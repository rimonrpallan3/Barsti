package com.voyager.barasti.activity.profilepage.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.voyager.barasti.R;
import com.voyager.barasti.activity.profilepage.model.HomeDetails;
import com.voyager.barasti.activity.profilepage.model.HomeRooms;

import java.util.List;

/**
 * Created by User on 22-Nov-18.
 */

public class RvHomeRoomImgAdapter extends RecyclerView.Adapter<RvHomeRoomImgAdapter.ServiceViewHolder>{

    Activity activity;
    List<String> photos;

    public RvHomeRoomImgAdapter(List<String> photos, Activity activity){
        this.photos = photos;
        this.activity = activity;
    }

    @Override
    public ServiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View groceryProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_home_room_img, parent, false);
        ServiceViewHolder gvh = new ServiceViewHolder(groceryProductView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(ServiceViewHolder holder, final int position) {
        //Picasso.with(context).load(pServiceLists.get(position).getImageView()).memoryPolicy(MemoryPolicy.NO_CACHE).into(holder.ivHzList);

        Picasso.with(activity)
                .load(photos.get(position))
                .placeholder(R.drawable.placeholder_image)
                .into(holder.ivRoomImages);


    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder {
        ImageView ivRoomImages;
        public ServiceViewHolder(View view) {
            super(view);
            ivRoomImages=view.findViewById(R.id.ivRoomImages);
        }
    }
}