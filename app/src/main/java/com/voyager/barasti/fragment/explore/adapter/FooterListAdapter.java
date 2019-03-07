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

import com.squareup.picasso.Picasso;
import com.voyager.barasti.R;
import com.voyager.barasti.activity.locationListPropety.LocationListPropety;
import com.voyager.barasti.activity.propertyProfilepage.PropertyProfilePage;
import com.voyager.barasti.fragment.explore.model.ExploreFooter.LocItems;
import com.voyager.barasti.fragment.explore.model.ExploreFooter.LocList;

import java.util.List;

/*
*
 * Created by rimon on 08-02-2018.
*/


// create a custom RecycleViewAdapter class

public class FooterListAdapter extends RecyclerView.Adapter<FooterListAdapter.ViewHolder> {

    public List<LocItems> locItemsList;
    //private CustomFilter mFilter;
    Activity activity;
    int userId=0;

    public FooterListAdapter(List<LocItems> locItemsList, Activity activity,int userId) {
        this.locItemsList = locItemsList;
        this.activity = activity;
        this.userId = userId;
        //mFilter = new CustomFilter(this, items);
        // System.out.println("MapPlaceSearch has ben ListMapApiDirectionSourceAdapter ");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_footer_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        System.out.println("FooterListAdapter has ben   onBindViewHolder");
        final LocItems locList = locItemsList.get(position);
        //holder.ivFooterHome.setImageResource(locList.getIdImg());
        Picasso.with(activity)
                .load(locList.getImage_url())
                .placeholder(R.drawable.placeholder_image)
                .into(holder.ivFooterHome);
        holder.tvFooterSubHeading.setText(locList.getName());
        holder.llLocView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, LocationListPropety.class);
                intent.putExtra("LocName", locList.getName());
                intent.putExtra("userID", userId);
                activity.startActivityForResult(intent,1);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (locItemsList != null && locItemsList.size() > 0) {
            return locItemsList.size();
        } else {
            return 0;
        }
    }

  /*  @Override
    public Filter getFilter() {
        return mFilter;
    }*/

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvFooterSubHeading;
        ImageView ivFooterHome;
        LinearLayout llLocView;

        public ViewHolder(View view) {
            super(view);
            ivFooterHome = view.findViewById(R.id.ivFooterHome);
            tvFooterSubHeading = view.findViewById(R.id.tvFooterSubHeading);
            llLocView = view.findViewById(R.id.llLocView);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + "'";
        }
    }

}
