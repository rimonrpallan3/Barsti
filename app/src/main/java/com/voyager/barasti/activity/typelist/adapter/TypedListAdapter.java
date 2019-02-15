package com.voyager.barasti.activity.typelist.adapter;


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
import com.voyager.barasti.activity.profilepage.ProfilePage;
import com.voyager.barasti.activity.typelist.model.PropertiesBean;
import com.voyager.barasti.activity.typelist.presenter.ITypeListPresenter;

import java.util.List;

/*
*
 * Created by rimon on 08-02-2018.
*/


// create a custom RecycleViewAdapter class

public class TypedListAdapter extends RecyclerView.Adapter<TypedListAdapter.ViewHolder> {

    public List<PropertiesBean> propertiesBeans;
    //private CustomFilter mFilter;
    Activity activity;
    ITypeListPresenter iTypeListPresenter;
    int userID;

    public TypedListAdapter(List<PropertiesBean> propertiesBeans, Activity activity,ITypeListPresenter iTypeListPresenter,int userID) {
        this.propertiesBeans = propertiesBeans;
        this.activity = activity;
        this.iTypeListPresenter = iTypeListPresenter;
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
        final PropertiesBean propertiesBean = propertiesBeans.get(position);
        //holder.ivHome.setImageResource(propertiesBean.getImgHome());
        Picasso.with(activity)
                .load(propertiesBean.getCover_photo())
                .placeholder(R.drawable.placeholder_image)
                .into(holder.ivHome);
        holder.tvHeading.setText(propertiesBean.getName());
        holder.tvHomeAmt.setText(""+propertiesBean.getPrice()+" BD per Night");
        holder.tvFavValue.setText(""+propertiesBean.getOverall_rating());
        holder.llHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ProfilePage.class);
                intent.putExtra("currentId", propertiesBean.getId());
                intent.putExtra("priceValue", propertiesBean.getPrice());
                intent.putExtra("reviewRate", propertiesBean.getReviews_count());
                activity.startActivity(intent);
            }
        });
        if(propertiesBean.getLike_status()==0){
            holder.lbHomeFav.setLiked(false);
        }else {
            holder.lbHomeFav.setLiked(true);
        }

        holder.lbHomeFav.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                likeButton.setLiked(true);
                iTypeListPresenter.btnLiked(userID,propertiesBean.getId());
                System.out.println("lbHomeFav iTypeListPresenter liked");
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                likeButton.setLiked(false);
                iTypeListPresenter.btnUnliked(userID,propertiesBean.getId());
                System.out.println("lbHomeFav iTypeListPresenter unLiked");
            }
        });



    }

    @Override
    public int getItemCount() {
        if (propertiesBeans != null && propertiesBeans.size() > 0) {
            return propertiesBeans.size();
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
