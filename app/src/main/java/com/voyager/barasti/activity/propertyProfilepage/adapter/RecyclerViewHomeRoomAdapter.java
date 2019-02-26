package com.voyager.barasti.activity.propertyProfilepage.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.voyager.barasti.R;
import com.voyager.barasti.activity.propertyProfilepage.model.HomeDetails;
import com.voyager.barasti.activity.propertyProfilepage.model.HomeRooms;

import java.util.List;

/**
 * Created by User on 22-Nov-18.
 */

public class RecyclerViewHomeRoomAdapter extends RecyclerView.Adapter<RecyclerViewHomeRoomAdapter.ServiceViewHolder>{
    private List<HomeRooms> homeRooms;
    Activity activity;
    HomeDetails homeDetails;

    public RecyclerViewHomeRoomAdapter(List<HomeRooms> homeRooms, Activity activity,HomeDetails homeDetails){
        this.homeRooms = homeRooms;
        this.homeDetails = homeDetails;
        this.activity = activity;
    }

    @Override
    public ServiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View groceryProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_home_room, parent, false);
        ServiceViewHolder gvh = new ServiceViewHolder(groceryProductView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(ServiceViewHolder holder, final int position) {
        //Picasso.with(context).load(pServiceLists.get(position).getImageView()).memoryPolicy(MemoryPolicy.NO_CACHE).into(holder.ivHzList);

        holder.tvRoomName.setText(homeRooms.get(position).getRoomName());
        if(homeRooms.get(position).getRoomName().equals("Bedrooms")) {
            holder.tvRoomCnt.setText(""+homeDetails.getBedrooms());
        }else if (homeRooms.get(position).getRoomName().equals("Beds")){
            holder.tvRoomCnt.setText(""+homeDetails.getBeds());
        }else if (homeRooms.get(position).getRoomName().equals("Bathrooms")){
            holder.tvRoomCnt.setText(""+homeDetails.getBathrooms());
        }else if (homeRooms.get(position).getRoomName().equals("Accommodates")){
            holder.tvRoomCnt.setText(""+homeDetails.getAccommodates());
        }
        holder.ivRoom.setImageResource(homeRooms.get(position).getImageId());


    }

    @Override
    public int getItemCount() {
        return homeRooms.size();
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder {
        TextView tvRoomCnt;
        TextView tvRoomName;
        ImageView ivRoom;
        public ServiceViewHolder(View view) {
            super(view);
            tvRoomCnt=view.findViewById(R.id.tvRoomCnt);
            tvRoomName=view.findViewById(R.id.tvRoomName);
            ivRoom=view.findViewById(R.id.ivRoom);
        }
    }
}