package com.voyager.barasti.activity.UserPropertyList.adapter;

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
import com.voyager.barasti.activity.UserPropertyList.model.ListingsBean;
import com.voyager.barasti.activity.UserPropertyList.model.UserPropertyDetails;
import com.voyager.barasti.activity.UserPropertyList.presenter.IPropertyListPresenter;
import com.voyager.barasti.activity.propertyProfilepage.PropertyProfilePage;
import com.voyager.barasti.fragment.explore.adapter.BodyListAdapter;
import com.voyager.barasti.fragment.explore.model.exploreList.HouseList;
import com.voyager.barasti.fragment.explore.presenter.IExplorePresenter;

import java.util.List;

/**
 * Created by User on 06-Mar-19.
 */

public class UserPropertyAdapter extends RecyclerView.Adapter<UserPropertyAdapter.ViewHolder> {

    public List<ListingsBean> listingsBeans;
    //private CustomFilter mFilter;
    Activity activity;
    int userID;
    IPropertyListPresenter iPropertyListPresenter;
    UserPropertyAdapter userPropertyAdapter;

    public UserPropertyAdapter(List<ListingsBean> listingsBeans, Activity activity, int userID, IPropertyListPresenter iPropertyListPresenter) {
        this.listingsBeans = listingsBeans;
        this.activity = activity;
        this.userID = userID;
        this.iPropertyListPresenter = iPropertyListPresenter;
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
        userPropertyAdapter = this;
        System.out.println("MapPlaceSearch has ben ListMapApiDirectionSourceAdapter  onBindViewHolder");
        final ListingsBean listingsBean = listingsBeans.get(position);
        //holder.ivHome.setImageResource(bodyItems.getImgHome());
        Picasso.with(activity)
                .load(listingsBean.getCover_photo())
                .placeholder(R.drawable.placeholder_image)
                .into(holder.ivHome);
        holder.tvHeading.setText(listingsBean.getName());
        holder.tvHomeAmt.setText(""+listingsBean.getPrice()+" BD per Night");
        holder.tvFavValue.setText(""+listingsBean.getOverall_rating());
        holder.llHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, PropertyProfilePage.class);
                intent.putExtra("propertyId", listingsBean.getId());
                intent.putExtra("priceValue", listingsBean.getPrice());
                intent.putExtra("reviewRate", listingsBean.getReviews_count());
                intent.putExtra("userID", userID);
                activity.startActivity(intent);
            }
        });


    }

    public  void getRefreshList(List<ListingsBean> listingsBeans){
        this.listingsBeans.clear();
        this.listingsBeans = listingsBeans;
        notifyDataSetChanged();
        System.out.println("UserPropertyAdapter getRefreshList : ");

    }


    @Override
    public int getItemCount() {
        if (listingsBeans != null && listingsBeans.size() > 0) {
            return listingsBeans.size();
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

