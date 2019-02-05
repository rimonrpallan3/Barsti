package com.voyager.barasti.activity.profilepage.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.voyager.barasti.R;
import com.voyager.barasti.common.FileUtils;

import java.util.List;

/**
 * Created by User on 22-Nov-18.
 */

public class RvPopUpImgAdapter extends RecyclerView.Adapter<RvPopUpImgAdapter.ServiceViewHolder>{

    Activity activity;
    List<String> photos;
    int currentPos;
    Boolean setCurrentPos = true;

    public RvPopUpImgAdapter(List<String> photos, Activity activity,int currentPos){
        this.photos = photos;
        this.activity = activity;
        this.currentPos = currentPos;
    }

    @Override
    public ServiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View groceryProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_home_room_img_viewr, parent, false);
        ServiceViewHolder gvh = new ServiceViewHolder(groceryProductView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(ServiceViewHolder holder, int position) {
        //Picasso.with(context).load(pServiceLists.get(position).getImageView()).memoryPolicy(MemoryPolicy.NO_CACHE).into(holder.ivHzList);

       /* System.out.println("position : "+position);
        System.out.println("Current Pos : "+position);
        if(setCurrentPos) {
            position = currentPos;
            setCurrentPos = false;
        }*/


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
        ImageView zivRoomImages;
        LinearLayout llRoomImg;
        public ServiceViewHolder(View view) {
            super(view);
            ivRoomImages=view.findViewById(R.id.ivRoomImages);
            zivRoomImages=view.findViewById(R.id.zivRoomImages);
            llRoomImg=view.findViewById(R.id.llRoomImg);
        }
    }
}