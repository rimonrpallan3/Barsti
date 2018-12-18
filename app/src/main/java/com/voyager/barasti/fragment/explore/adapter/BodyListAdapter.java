package com.voyager.barasti.fragment.explore.adapter;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.voyager.barasti.R;
import com.voyager.barasti.fragment.explore.model.exploreList.BodyItems;


import java.util.List;

/*
*
 * Created by rimon on 08-02-2018.
*/


// create a custom RecycleViewAdapter class

public class BodyListAdapter extends RecyclerView.Adapter<BodyListAdapter.ViewHolder> {

    public List<BodyItems> bodyItemsList;
    //private CustomFilter mFilter;
    Activity activity;

    public BodyListAdapter(List<BodyItems> bodyItemsList, Activity activity) {
        this.bodyItemsList = bodyItemsList;
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
        final BodyItems bodyItems = bodyItemsList.get(position);
        holder.ivHome.setImageResource(bodyItems.getImgHome());
        holder.tvHeading.setText(bodyItems.getHeading());
        holder.tvHomeAmt.setText(bodyItems.getAmtHome());
        holder.tvFavValue.setText(bodyItems.getFavRate());

    }

    @Override
    public int getItemCount() {
        return bodyItemsList.size();
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
        }

        @Override
        public String toString() {
            return super.toString() + " '" + "'";
        }
    }

}
