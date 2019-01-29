package com.voyager.barasti.fragment.profile.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.voyager.barasti.R;
import com.voyager.barasti.fragment.profile.model.PServiceList;

import java.util.List;

/**
 * Created by User on 22-Nov-18.
 */

public class RecyclerViewProfileServiceListAdapter extends RecyclerView.Adapter<RecyclerViewProfileServiceListAdapter.ServiceViewHolder>{
    private List<PServiceList> pServiceLists;
    Activity activity;

    public RecyclerViewProfileServiceListAdapter(List<PServiceList> pServiceLists, Activity activity){
        this.pServiceLists = pServiceLists;
        this.activity = activity;
    }

    @Override
    public ServiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View groceryProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_profile_service_list, parent, false);
        ServiceViewHolder gvh = new ServiceViewHolder(groceryProductView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(ServiceViewHolder holder, final int position) {
        //Picasso.with(context).load(pServiceLists.get(position).getImageView()).memoryPolicy(MemoryPolicy.NO_CACHE).into(holder.ivHzList);

        holder.tvHeading.setText(pServiceLists.get(position).getHeading());
        if(pServiceLists.get(position).getSubHeading().length()>1) {
            holder.tvSubHeading.setText(pServiceLists.get(position).getSubHeading());
        }else {
            holder.tvSubHeading.setVisibility(View.GONE);
        }
        holder.llProfileContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,pServiceLists.get(position).getHeading()+" Is Clicked",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return pServiceLists.size();
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder {
        TextView tvHeading;
        TextView tvSubHeading;
        LinearLayout llProfileContent;
        public ServiceViewHolder(View view) {
            super(view);
            tvHeading=view.findViewById(R.id.tvHeading);
            tvSubHeading=view.findViewById(R.id.tvSubHeading);
            llProfileContent=view.findViewById(R.id.llProfileContent);
        }
    }
}