package com.voyager.barasti.activity.locationListPropety.adapter;

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
import com.voyager.barasti.activity.locationListPropety.model.LocDetails;
import com.voyager.barasti.activity.locationListPropety.presenter.ILocationPresenter;
import com.voyager.barasti.activity.propertyProfilepage.PropertyProfilePage;
import com.voyager.barasti.activity.typelist.adapter.TypedListAdapter;
import com.voyager.barasti.activity.typelist.model.PropertiesBean;
import com.voyager.barasti.activity.typelist.presenter.ITypeListPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 04-Mar-19.
 */

public class LocListAdapter extends RecyclerView.Adapter<LocListAdapter.ViewHolder> {

    public ArrayList<LocDetails> locDetails;
    //private CustomFilter mFilter;
    Activity activity;
    ILocationPresenter iLocationPresenter;
    int userID;

    public LocListAdapter(ArrayList<LocDetails> locDetails, Activity activity,ILocationPresenter iLocationPresenter,int userID) {
        this.locDetails = locDetails;
        this.activity = activity;
        this.iLocationPresenter = iLocationPresenter;
        this.userID = userID;
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
        System.out.println("MapPlaceSearch has ben ListMapApiDirectionSourceAdapter  onBindViewHolder");
        final LocDetails locDetail = locDetails.get(position);
        //holder.ivHome.setImageResource(propertiesBean.getImgHome());
        Picasso.with(activity)
                .load(locDetail.getCover_photo())
                .placeholder(R.drawable.placeholder_image)
                .into(holder.ivHome);
        holder.tvHeading.setText(locDetail.getProperty_name());
        holder.tvHomeAmt.setText(""+locDetail.getPrice()+" BD per Night");
        holder.tvFavValue.setText(""+locDetail.getOverall_rating());
        holder.llHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, PropertyProfilePage.class);
                intent.putExtra("userID", userID);
                intent.putExtra("propertyId", locDetail.getId());
                intent.putExtra("priceValue", locDetail.getPrice());
                intent.putExtra("reviewRate", locDetail.getReviews_count());
                activity.startActivity(intent);
            }
        });
        if(locDetail.getLike_status()==0){
            holder.lbHomeFav.setLiked(false);
        }else {
            holder.lbHomeFav.setLiked(true);
        }

        holder.lbHomeFav.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                likeButton.setLiked(true);
                iLocationPresenter.btnLiked(userID,locDetail.getId());
                System.out.println("lbHomeFav iTypeListPresenter liked");
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                likeButton.setLiked(false);
                iLocationPresenter.btnUnliked(userID,locDetail.getId());
                System.out.println("lbHomeFav iTypeListPresenter unLiked");
            }
        });



    }

    @Override
    public int getItemCount() {
        if (locDetails != null && locDetails.size() > 0) {
            return locDetails.size();
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
            ivHome = view.findViewById(R.id.ivHome);
            llHome = view.findViewById(R.id.llHome);
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
