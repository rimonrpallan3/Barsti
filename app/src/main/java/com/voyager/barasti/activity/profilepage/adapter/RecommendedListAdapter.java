package com.voyager.barasti.activity.profilepage.adapter;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.like.LikeButton;
import com.like.OnLikeListener;
import com.squareup.picasso.Picasso;
import com.voyager.barasti.R;
import com.voyager.barasti.activity.profilepage.model.RecommendBean;
import com.voyager.barasti.activity.profilepage.presenter.IProfiePresenter;


import java.util.List;

/*
*
 * Created by rimon on 08-02-2018.
*/


// create a custom RecycleViewAdapter class

public class RecommendedListAdapter extends RecyclerView.Adapter<RecommendedListAdapter.ViewHolder> {

    public List<RecommendBean> recommendBeanList;
    IProfiePresenter iProfiePresenter;
    //private CustomFilter mFilter;
    Activity activity;
    int userID;

    public RecommendedListAdapter(List<RecommendBean> recommendBeanList, Activity activity,int userID,IProfiePresenter iProfiePresenter) {
        this.recommendBeanList = recommendBeanList;
        this.activity = activity;
        this.userID = userID;
        this.iProfiePresenter = iProfiePresenter;
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
        final RecommendBean recommendBean = recommendBeanList.get(position);
        //holder.ivHome.setImageResource(recommendBean.getImgHome());
        Picasso.with(activity)
                .load(recommendBean.getCover_photo())
                .placeholder(R.drawable.placeholder_image)
                .into(holder.ivHome);
        holder.tvHeading.setText(recommendBean.getName());
        holder.tvHomeAmt.setText(""+recommendBean.getPrice()+" BD per Night");
        holder.tvFavValue.setText(""+recommendBean.getOverall_rating());
        if(recommendBean.getLike_status()==0){
            holder.lbHomeFav.setLiked(false);
        }else {
            holder.lbHomeFav.setLiked(true);
        }
        holder.lbHomeFav.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                likeButton.setLiked(true);
                iProfiePresenter.btnLiked(userID,recommendBean.getId());
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                likeButton.setLiked(false);
                iProfiePresenter.btnUnliked(userID,recommendBean.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (recommendBeanList != null && recommendBeanList.size() > 0) {
            return recommendBeanList.size();
        } else {
            return 0;
        }
    }

  /*  @Override
    public Filter getFilter() {
        return mFilter;
    }*/

    public class ViewHolder extends RecyclerView.ViewHolder {

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
