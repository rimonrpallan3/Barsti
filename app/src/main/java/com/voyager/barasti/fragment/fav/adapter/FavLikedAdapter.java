package com.voyager.barasti.fragment.fav.adapter;


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
import com.voyager.barasti.activity.landingpage.view.ILandingView;
import com.voyager.barasti.activity.propertyProfilepage.PropertyProfilePage;
import com.voyager.barasti.fragment.fav.model.FavDetail;
import com.voyager.barasti.fragment.fav.presenter.IFavLikedPresenter;

import java.util.List;

/*
*
 * Created by rimon on 08-02-2018.
*/


// create a custom RecycleViewAdapter class

public class FavLikedAdapter extends RecyclerView.Adapter<FavLikedAdapter.ViewHolder> {

    public List<FavDetail> favDetails;
    //private CustomFilter mFilter;
    Activity activity;
    IFavLikedPresenter iFavLikedPresenter;
    FavLikedAdapter favLikedAdapter;
    ILandingView iLandingView;
    int userID;

    public FavLikedAdapter(List<FavDetail> favDetails, Activity activity, IFavLikedPresenter iFavLikedPresenter, int userID,ILandingView iLandingView) {
        this.favDetails = favDetails;
        this.activity = activity;
        this.iFavLikedPresenter = iFavLikedPresenter;
        this.userID = userID;
        this.iLandingView = iLandingView;
        //mFilter = new CustomFilter(this, items);
        // System.out.println("MapPlaceSearch has ben ListMapApiDirectionSourceAdapter ");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_body_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position) {
        System.out.println("MapPlaceSearch has ben ListMapApiDirectionSourceAdapter  onBindViewHolder");
        final FavDetail favDetail = favDetails.get(position);
        favLikedAdapter =this;
        //holder.ivHome.setImageResource(propertiesBean.getImgHome());
        Picasso.with(activity)
                .load(favDetail.getCover_photo())
                .placeholder(R.drawable.placeholder_image)
                .into(holder.ivHome);
        holder.tvHeading.setText(favDetail.getName());
        holder.tvHomeAmt.setText(""+favDetail.getPrice()+" BD per Night");
        holder.tvFavValue.setText(""+favDetail.getOverall_rating());
        holder.llHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, PropertyProfilePage.class);
                intent.putExtra("userID", userID);
                intent.putExtra("propertyId", favDetail.getId());
                intent.putExtra("priceValue", favDetail.getPrice());
                intent.putExtra("reviewRate", favDetail.getReviews_count());
                activity.startActivity(intent);
            }
        });

            holder.lbHomeFav.setLiked(true);


        holder.lbHomeFav.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                /*likeButton.setLiked(true);
                iFavLikedPresenter.btnLiked(userID,favDetail.getId());
                System.out.println("lbHomeFav iFavLikedPresenter liked");*/
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                likeButton.setLiked(false);
                iFavLikedPresenter.btnUnliked(userID,favDetail.getId());
                favDetails.remove(position);
                favLikedAdapter.notifyDataSetChanged();
                System.out.println("lbHomeFav iFavLikedPresenter unLiked");
                System.out.println("favDetails size : "+favDetails.size());
                if(favDetails.size()<1){
                    System.out.println("favDetails size : "+favDetails.size());
                    iFavLikedPresenter.setDefaultImg();
                }
            }
        });



    }

    @Override
    public int getItemCount() {
        if (favDetails != null && favDetails.size() > 0) {
            return favDetails.size();
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
