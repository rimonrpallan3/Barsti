package com.voyager.barasti.fragment.explore.adapter;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.like.LikeButton;
import com.like.OnLikeListener;
import com.squareup.picasso.Picasso;
import com.voyager.barasti.R;
import com.voyager.barasti.activity.propertyProfilepage.PropertyProfilePage;
import com.voyager.barasti.fragment.explore.model.exploreList.HouseList;
import com.voyager.barasti.fragment.explore.presenter.IExplorePresenter;


import java.util.List;

/*
*
 * Created by rimon on 08-02-2018.
*/


// create a custom RecycleViewAdapter class

public class BodyListAdapter extends RecyclerView.Adapter<BodyListAdapter.ViewHolder> {

    public List<HouseList> houseLists;
    //private CustomFilter mFilter;
    Activity activity;
    int userID;
    IExplorePresenter iExplorePresenter;
    BodyListAdapter bodyListAdapter;

    public BodyListAdapter(List<HouseList> houseLists, Activity activity,int userID,IExplorePresenter iExplorePresenter) {
        this.houseLists = houseLists;
        this.activity = activity;
        this.userID = userID;
        this.iExplorePresenter = iExplorePresenter;
        //mFilter = new CustomFilter(this, items);
        // System.out.println("MapPlaceSearch has ben ListMapApiDirectionSourceAdapter ");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_body_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        bodyListAdapter = this;
        System.out.println("MapPlaceSearch has ben ListMapApiDirectionSourceAdapter  onBindViewHolder");
        final HouseList bodyItems = houseLists.get(position);
        //holder.ivHome.setImageResource(bodyItems.getImgHome());
        Picasso.with(activity)
                .load(bodyItems.getCover_photo())
                .placeholder(R.drawable.placeholder_image)
                .into(holder.ivHome);
        holder.tvHeading.setText(bodyItems.getName());
        holder.tvHomeAmt.setText(""+bodyItems.getPrice()+" BD per Night");
        holder.tvFavValue.setText(""+bodyItems.getOverall_rating());
        holder.llHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, PropertyProfilePage.class);
                intent.putExtra("propertyId", bodyItems.getId());
                intent.putExtra("priceValue", bodyItems.getPrice());
                intent.putExtra("reviewRate", bodyItems.getReviews_count());
                intent.putExtra("guestMoreAccNo", bodyItems.getGuest_after());
                intent.putExtra("guestAccNo", bodyItems.getGuest_fee());
                intent.putExtra("guestLimit", bodyItems.getGuest_fee());
                intent.putExtra("userID", userID);
                activity.startActivity(intent);
            }
        });
        if(bodyItems.getLike_status()!=0){
            holder.lbHomeFav.setLiked(true);
        }else {
            holder.lbHomeFav.setLiked(false);
        }
        holder.lbHomeFav.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                likeButton.setLiked(true);
                iExplorePresenter.btnLiked(userID,bodyItems.getId());
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                likeButton.setLiked(false);
                iExplorePresenter.btnUnliked(userID,bodyItems.getId());
            }
        });

    }

    public  void getRefreshList(List<HouseList> houseLists){
        this.houseLists.clear();
        this.houseLists = houseLists;
        notifyDataSetChanged();
        System.out.println("BodyListAdapter getRefreshList : ");

    }
    public void addItem(HouseList item){

        int index = (houseLists.size());
        houseLists.add(item);
        notifyDataSetChanged();
        //notifyItemInserted(index);
    }

    @Override
    public int getItemCount() {
        if (houseLists != null && houseLists.size() > 0) {
            return houseLists.size();
        } else {
            return 0;
        }
    }

  /*  @Override
    public Filter getFilter() {
        return mFilter;
    }*/

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout llHome;
        TextView tvFavValue;
        TextView tvHomeAmt;
        TextView tvHeading;
        ImageView ivHome;
        ImageView ivFav1;
        ImageView ivFav2;
        ImageView ivFav3;
        ImageView ivFav4;
        ImageView ivFav5;
        LikeButton lbHomeFav;

        public ViewHolder(View view) {
            super(view);
            llHome = view.findViewById(R.id.llHome);
            ivHome = view.findViewById(R.id.ivHome);
            ivFav1 = view.findViewById(R.id.ivFav1);
            ivFav2 = view.findViewById(R.id.ivFav2);
            ivFav3 = view.findViewById(R.id.ivFav3);
            ivFav4 = view.findViewById(R.id.ivFav4);
            ivFav5 = view.findViewById(R.id.ivFav5);
            tvHomeAmt = view.findViewById(R.id.tvHomeAmt);
            tvHeading = view.findViewById(R.id.tvHeading);
            tvFavValue = view.findViewById(R.id.tvFavValue);
            lbHomeFav = view.findViewById(R.id.lbHomeFav);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + "'";
        }
    }

}
