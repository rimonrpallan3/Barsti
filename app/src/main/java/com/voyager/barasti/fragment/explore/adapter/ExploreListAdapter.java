package com.voyager.barasti.fragment.explore.adapter;


import android.app.Activity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.voyager.barasti.R;
import com.voyager.barasti.fragment.explore.model.ExploreFooter.LocList;
import com.voyager.barasti.fragment.explore.model.ExploreHeader.HeaderItem;
import com.voyager.barasti.fragment.explore.model.exploreList.BodyItems;
import com.voyager.barasti.fragment.explore.model.exploreList.ExploreItems;
import com.voyager.barasti.fragment.explore.model.ExploreFooter.FooterItems;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by User on 15-May-18.*/



public class ExploreListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<ExploreItems> exploreItems =new ArrayList<>();
    private Activity activity;
    private ClickListener clickListener;
    private LayoutInflater infalter;
    List<BodyItems> bodyItemsList;
    List<LocList> locLists;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_FOOTER = 2;
    private static final int TYPE_BODY = 1;
    BodyListAdapter bodyListAdapter;
    FooterListAdapter footerListAdapter;

    public ExploreListAdapter(List<ExploreItems> exploreItems, Activity activity) {
        this.exploreItems = exploreItems;
        this.infalter = LayoutInflater.from(activity);
        this.activity = activity;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        System.out.println(" ------------ ExploreListAdapter onCreateViewHolder viewType : "+viewType);
        if(viewType == 1){
            View rootView = infalter.inflate(R.layout.content_explore_list_body,parent,false);
            System.out.println(" ------------ ExploreListAdapter content_explore_list_body");
            return new BodyListViewHolder(rootView);
        }else if(viewType == 2){
            View rootView = infalter.inflate(R.layout.content_explore_list_footer,parent,false);
            System.out.println(" ------------ ExploreListAdapter content_explore_list_footer");
            return new FooterListViewHolder(rootView);
        }else{
            View rootView = infalter.inflate(R.layout.content_landing_header,parent,false);
            System.out.println(" ------------ ExploreListAdapter content_landing_header");
            return new mHeaderViewHolder(rootView);
        }
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holderViews, final int position) {
        if(holderViews instanceof BodyListViewHolder) {
            BodyListViewHolder holder = (BodyListViewHolder) holderViews;
            System.out.println(" ------------ ExploreListAdapter onBindViewHolder BodyListViewHolder position : "+position);

            holder.tvHeading.setText(exploreItems.get(position).getMainHeading());
            holder.btnExpandView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(activity,"Expand View Clicked",Toast.LENGTH_LONG).show();
                }
            });
            bodyItemsList = exploreItems.get(position).getBodyItemsList();
            bodyListAdapter = new BodyListAdapter(bodyItemsList, activity);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity.getApplicationContext());
            holder.rvBodyList.setLayoutManager(mLayoutManager);
            holder.rvBodyList.setItemAnimator(new DefaultItemAnimator());
            holder.rvBodyList.setLayoutManager(new GridLayoutManager(activity, 2));
            holder.rvBodyList.setAdapter(bodyListAdapter);
            holder.rvBodyList.setLayoutFrozen(true);
            //bodyListAdapter.setClickListener(this);
        } else if (holderViews instanceof mHeaderViewHolder){
            System.out.println(" ------------ mHeaderViewHolder onBindViewHolder HeaderItem position : "+position);
            final mHeaderViewHolder holder = (mHeaderViewHolder) holderViews;
            final HeaderItem dataItem = (HeaderItem) exploreItems.get(position);
            System.out.println("mHeaderViewHolder Btn name : "+dataItem.getBtnContent());
            System.out.println("mHeaderViewHolder Image Url/Id  : "+dataItem.getImageUrl());
            holder.ivBanner.setImageResource(dataItem.getImgHeader());
            holder.btnHome.setText(dataItem.getBtnContent());


        } else if (holderViews instanceof FooterListViewHolder){
            System.out.println(" ------------ FooterListViewHolder onBindViewHolder FooterItems position : "+position);
            final FooterListViewHolder holder = (FooterListViewHolder) holderViews;
            final FooterItems footerItems = (FooterItems) exploreItems.get(position);
            String json = new Gson().toJson(footerItems);
            System.out.println(" ------------ FooterListViewHolder onBindViewHolder FooterItems  : "+json);
            locLists = footerItems.getLocLists();
            holder.tvFooterHeading.setText(footerItems.getHeadingTitile());
            System.out.println(" ------------ FooterListViewHolder onBindViewHolder FooterItems Heading : "+footerItems.getHeadingTitile());
            footerListAdapter = new FooterListAdapter(locLists, activity);
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
            holder.rvFooterList.setLayoutManager(mLayoutManager);
            holder.rvFooterList.setItemAnimator(new DefaultItemAnimator());
            holder.rvFooterList.setAdapter(footerListAdapter);
            holder.rvFooterList.setNestedScrollingEnabled(true);
            //holder.rvFooterList.setLayoutFrozen(true);
        }

    }


    @Override
    public int getItemCount() {
        if (exploreItems != null && exploreItems.size() > 0) {
            return exploreItems.size();
        } else {
            return 0;
        }
    }

    @Override
    public int getItemViewType(int position) {
        System.out.println(" ------------ ExploreListAdapter getItemViewType position : "+position);
        if(position == 0 && exploreItems.get(position) instanceof HeaderItem){
            System.out.println(" ------------ ExploreListAdapter onBindViewHolder getItemViewType HeaderItem : "+position);
            return TYPE_HEADER;
        }else if(position == 2 && exploreItems.get(position) instanceof FooterItems){
            System.out.println(" ------------ ExploreListAdapter onBindViewHolder getItemViewType FooterItems : "+position);
            return TYPE_FOOTER;
        }
        return TYPE_BODY;
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

        /*** ViewHolder class which holds Initialisation to all views and buttons.*/



    public class BodyListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvHeading;
        RecyclerView rvBodyList;
        Button btnExpandView;
        View root;

        public BodyListViewHolder(View itemView) {
            super(itemView);
            root = itemView;
            itemView.setOnClickListener(this);
            rvBodyList =  itemView.findViewById(R.id.rvBodyList);
            tvHeading =  itemView.findViewById(R.id.tvHeading);
            btnExpandView =  itemView.findViewById(R.id.btnExpandView);
        }

        @Override
        public void onClick(View v) {

            if(clickListener!=null){
                clickListener.itemClicked(v,getPosition());
            }

            //delete(getPosition());

        }
    }
    public class FooterListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvFooterHeading;
        RecyclerView rvFooterList;
        View root;

        public FooterListViewHolder(View itemView) {
            super(itemView);
            root = itemView;
            itemView.setOnClickListener(this);
            rvFooterList =  itemView.findViewById(R.id.rvFooterList);
            tvFooterHeading =  itemView.findViewById(R.id.tvFooterHeading);
        }

        @Override
        public void onClick(View v) {

            if(clickListener!=null){
                clickListener.itemClicked(v,getPosition());
            }

            //delete(getPosition());

        }
    }

    public  class mHeaderViewHolder extends RecyclerView.ViewHolder{


        TextView userName;
        ImageView ivBanner;
        Button btnHome;

        public mHeaderViewHolder(View itemView) {
            super(itemView);
            ivBanner = itemView.findViewById(R.id.ivBanner);
            btnHome =  itemView.findViewById(R.id.btnHome);

        }
    }

    public void setClickListener(ClickListener clicklistener){

        this.clickListener = clicklistener;

    }


    public interface ClickListener{
        public void itemClicked(View view, int position);
    }

    public List<ExploreItems> getData(){

        return this.exploreItems;
    }

}
