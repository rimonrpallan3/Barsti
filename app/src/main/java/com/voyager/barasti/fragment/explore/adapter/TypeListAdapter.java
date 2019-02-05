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

import com.voyager.barasti.R;
import com.voyager.barasti.activity.profilepage.ProfilePage;
import com.voyager.barasti.activity.typelist.TypeListActivity;
import com.voyager.barasti.activity.typelist.adapter.TypedListAdapter;
import com.voyager.barasti.fragment.explore.model.ExploreType.TypeList;

import java.util.List;

/*
*
 * Created by rimon on 08-02-2018.
*/


// create a custom RecycleViewAdapter class

public class TypeListAdapter extends RecyclerView.Adapter<TypeListAdapter.ViewHolder> {

    public List<TypeList> typeLists;
    //private CustomFilter mFilter;
    Activity activity;

    public TypeListAdapter(List<TypeList> typeLists, Activity activity) {
        this.typeLists = typeLists;
        this.activity = activity;
        //mFilter = new CustomFilter(this, items);
        // System.out.println("MapPlaceSearch has ben ListMapApiDirectionSourceAdapter ");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_type_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        System.out.println("FooterListAdapter has ben   onBindViewHolder");
        final TypeList typeList = typeLists.get(position);
        if(typeList.getName().equals("Apartment")){
            typeList.setImgId(R.drawable.apartment_1);
        }else  if(typeList.getName().equals("Villa")){
            typeList.setImgId(R.drawable.penthouse_1);
        }else  if(typeList.getName().equals("Penthouse")){
            typeList.setImgId(R.drawable.villa_1);
        }
        holder.ivTypeHome.setImageResource(typeList.getImgId());
        /*Picasso.with(activity)
                .load("")
                .placeholder(R.drawable.placeholder_image)
                .into(holder.ivTypeHome);*/
        holder.tvTypeSubHeading.setText(typeList.getName());
        holder.llTypedHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity, TypeListActivity.class);
                intent.putExtra("TypeListActivity", typeList);
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (typeLists != null && typeLists.size() > 0) {
            return typeLists.size();
        } else {
            return 0;
        }
    }

  /*  @Override
    public Filter getFilter() {
        return mFilter;
    }*/

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTypeSubHeading;
        ImageView ivTypeHome;
        LinearLayout llTypedHome;

        public ViewHolder(View view) {
            super(view);
            ivTypeHome = view.findViewById(R.id.ivTypeHome);
            tvTypeSubHeading = view.findViewById(R.id.tvTypeSubHeading);
            llTypedHome = view.findViewById(R.id.llTypedHome);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + "'";
        }
    }

}
