package com.voyager.barasti.activity.profilepage.adapter;

import android.app.Activity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.voyager.barasti.R;
import com.voyager.barasti.activity.profilepage.model.Amenities;

import java.util.List;

/**
 * Created by User on 22-Nov-18.
 */

public class RvHomeAmenitiesAdapter extends RecyclerView.Adapter<RvHomeAmenitiesAdapter.ServiceViewHolder>{

    Activity activity;
    List<Amenities> amenitiesList;

    public RvHomeAmenitiesAdapter(List<Amenities> amenitiesList, Activity activity){
        this.amenitiesList = amenitiesList;
        this.activity = activity;
    }

    @Override
    public ServiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View groceryProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_home_amenities, parent, false);
        ServiceViewHolder gvh = new ServiceViewHolder(groceryProductView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(ServiceViewHolder holder, final int position) {
        //Picasso.with(context).load(pServiceLists.get(position).getImageView()).memoryPolicy(MemoryPolicy.NO_CACHE).into(holder.ivHzList);
        Amenities amenities = amenitiesList.get(position);
        holder.tvAmenities.setText(amenities.getTitle());


    }

    @Override
    public int getItemCount() {
        return amenitiesList.size();
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView tvAmenities;
        public ServiceViewHolder(View view) {
            super(view);
            tvAmenities=view.findViewById(R.id.tvAmenities);
        }
    }
}