package com.voyager.barasti.fragment.explore.adapter;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.voyager.barasti.R;
import com.voyager.barasti.fragment.explore.model.ExploreFooter.LocList;
import com.voyager.barasti.fragment.explore.model.exploreList.BodyItems;

import java.util.List;

/*
*
 * Created by rimon on 08-02-2018.
*/


// create a custom RecycleViewAdapter class

public class FooterListAdapter extends RecyclerView.Adapter<FooterListAdapter.ViewHolder> {

    public List<LocList> locLists;
    //private CustomFilter mFilter;
    Activity activity;

    public FooterListAdapter(List<LocList> bodyItemsList, Activity activity) {
        this.locLists = bodyItemsList;
        this.activity = activity;
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
        final LocList locList = locLists.get(position);
        holder.ivFooterHome.setImageResource(locList.getIdImg());
        holder.tvFooterSubHeading.setText(locList.getImgHeading());

    }

    @Override
    public int getItemCount() {
        if (locLists != null && locLists.size() > 0) {
            return locLists.size();
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

        public ViewHolder(View view) {
            super(view);
            ivFooterHome = view.findViewById(R.id.ivFooterHome);
            tvFooterSubHeading = view.findViewById(R.id.tvFooterSubHeading);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + "'";
        }
    }

}
