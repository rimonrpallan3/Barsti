package com.voyager.barasti.fragment.explore.adapter;


import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessaging;
import com.like.LikeButton;
import com.like.OnLikeListener;
import com.squareup.picasso.Picasso;
import com.voyager.barasti.R;
import com.voyager.barasti.activity.landingpage.LandingPage;
import com.voyager.barasti.activity.profilepage.ProfilePage;
import com.voyager.barasti.fragment.explore.model.exploreList.HouseList;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*
 * Created by rimon on 08-02-2018.
*/


// create a custom RecycleViewAdapter class

public class BodyListAdapter extends RecyclerView.Adapter<BodyListAdapter.ViewHolder> {

    public List<HouseList> houseLists;
    //private CustomFilter mFilter;
    Activity activity;

    public BodyListAdapter(List<HouseList> houseLists, Activity activity) {
        this.houseLists = houseLists;
        this.activity = activity;
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
                Intent intent = new Intent(activity, ProfilePage.class);
                intent.putExtra("currentId", bodyItems.getId());
                intent.putExtra("priceValue", bodyItems.getPrice());
                intent.putExtra("reviewRate", bodyItems.getReviews_count());
                activity.startActivity(intent);
            }
        });
        holder.lbHomeFav.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                likeButton.setLiked(true);
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                likeButton.setLiked(false);

            }
        });

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
