package com.voyager.barasti.landingpage.adapter;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.voyager.barasti.R;
import com.voyager.barasti.landingpage.model.drawerList.BodyItems;
import java.util.List;

/*
*
 * Created by rimon on 08-02-2018.
*/


// create a custom RecycleViewAdapter class

public class BodyListAdapter extends RecyclerView.Adapter<BodyListAdapter.ViewHolder>  {

    public List<BodyItems> bodyItemsList;
    //private CustomFilter mFilter;
    Activity activity;

    public BodyListAdapter(List<BodyItems> bodyItemsList,Activity activity) {
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

         TextView mainText;
        TextView secondaryText;
        LinearLayout linearView;

        public ViewHolder(View view) {
            super(view);/*
            mainText = (TextView) view.findViewById(R.id.mainText);
            secondaryText = (TextView) view.findViewById(R.id.secondaryText);
            linearView = (LinearLayout) view.findViewById(R.id.linearView);*/
        }

        @Override
        public String toString() {
            return super.toString() + " '"  + "'";
        }
    }

}
