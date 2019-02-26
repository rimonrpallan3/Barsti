package com.voyager.barasti.activity.propertyProfilepage.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
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

import java.util.List;

/**
 * Created by User on 22-Nov-18.
 */

public class RvHomeRoomImgAdapter extends RecyclerView.Adapter<RvHomeRoomImgAdapter.ServiceViewHolder>{

    Activity activity;
    List<String> photos;
    RvPopUpImgAdapter rvPopUpImgAdapter;

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
        holder.llRoomImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profileImgViewerPopup(activity, "", position);
            }
        });

    }

    public void profileImgViewerPopup(Activity activity, String unitName, int currentPos){
        Dialog dialogs = new Dialog(activity, R.style.HomeImageAnimation);
        dialogs.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogs.setContentView(R.layout.content_home_img_viewer_popup);

        ImageView ivHome = (ImageView) dialogs.findViewById(R.id.ivHome);
        RecyclerView rvImageViewer = dialogs.findViewById(R.id.rvImageViewer);
        TextView tvImgName;
        LinearLayoutManager horizontalView;
        tvImgName = (TextView) dialogs.findViewById(R.id.tvImgName);
        rvPopUpImgAdapter = new RvPopUpImgAdapter(photos, activity,currentPos);
        horizontalView = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, true);
        rvImageViewer.setLayoutManager(horizontalView);
        rvImageViewer.setItemAnimator(new DefaultItemAnimator());
        rvImageViewer.setAdapter(rvPopUpImgAdapter);
        rvImageViewer.smoothScrollToPosition(currentPos);
        tvImgName.setText(unitName);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialogs.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        dialogs.show();
        dialogs.getWindow().setAttributes(lp);
    }


    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder {
        ImageView ivRoomImages;
        LinearLayout llRoomImg;
        public ServiceViewHolder(View view) {
            super(view);
            ivRoomImages=view.findViewById(R.id.ivRoomImages);
            llRoomImg=view.findViewById(R.id.llRoomImg);
        }
    }
}