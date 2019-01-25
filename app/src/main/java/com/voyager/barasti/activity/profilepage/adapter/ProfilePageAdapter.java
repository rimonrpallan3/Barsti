package com.voyager.barasti.activity.profilepage.adapter;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.voyager.barasti.R;
import com.voyager.barasti.activity.profilepage.model.HomeDetails;
import com.voyager.barasti.activity.profilepage.presenter.IProfiePresenter;
import com.voyager.barasti.fragment.mapFg.MapFrg;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by User on 09-Jan-19.
 */

public class ProfilePageAdapter extends RecyclerView.Adapter<ProfilePageAdapter.ViewHolder>{

    List<HomeDetails> homeDetailsList = new ArrayList<>();
    private Activity activity;
    private ClickListener clickListener;
    private LayoutInflater infalter;
    private static final int TYPE_BODY = 0;
    LinearLayoutManager HorizontalView;
    String json;
    RecommendedListAdapter recommendedListAdapter;

    private GoogleMap mMap;

    double lat = 26.2285;
    double log = 50.5860;

    private int currentPage = 0;
    private int NUM_PAGES = 0;
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    IProfiePresenter iProfiePresenter;

    MapFrg mapFragmentView;
    Bundle bundle;


    public ProfilePageAdapter(List<HomeDetails> homeDetailsList, Activity activity,IProfiePresenter iProfiePresenter) {
        this.homeDetailsList = homeDetailsList;
        this.iProfiePresenter = iProfiePresenter;
        this.infalter = LayoutInflater.from(activity);
        this.activity = activity;
        bundle = new Bundle();
        /*String json = new Gson().toJson(homeDetailsList);
        System.out.println(" ------------ ExploreListAdapter Con onBindViewHolder ExploreItems  : "+json);*/

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_home_list_body, parent, false);
        return new ViewHolder(view);
    }


    private void init(View rootView) {

    }


    @Override
    public void onBindViewHolder(final ViewHolder holderViews, final int position) {
        HomeDetails homeDetailsList1 = homeDetailsList.get(position);
        if (homeDetailsList1 != null) {
            ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) holderViews.llHomeProfile.getLayoutParams();
            if (homeDetailsList.size() == (position + 1)) {
                mlp.setMargins(0, 0, 0, (int) activity.getResources().getDimension(R.dimen._80));
            } else {
                mlp.setMargins(0, 0, 0, 0);
            }
            System.out.println(" ------------ ExploreListAdapter onBindViewHolder BodyListViewHolder position : " + position);
            holderViews.tvDescription.setText(homeDetailsList1.getSummary());
            Picasso.with(activity)
                    .load(homeDetailsList1.getCover_photo())
                    .placeholder(R.drawable.placeholder_image)
                    .into(holderViews.ivHomeImg);
            holderViews.tvLocAddress.setText(homeDetailsList1.getAddress_line_1());
            recommendedListAdapter = new RecommendedListAdapter(homeDetailsList1.getRecommend(), activity);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity.getApplicationContext());
            holderViews.rvHomeRecommended.setLayoutManager(mLayoutManager);
            holderViews.rvHomeRecommended.setItemAnimator(new DefaultItemAnimator());
            holderViews.rvHomeRecommended.setLayoutManager(new GridLayoutManager(activity, 2));
            holderViews.rvHomeRecommended.setAdapter(recommendedListAdapter);
            holderViews.rvHomeRecommended.setLayoutFrozen(true);

            lat = Double.parseDouble(homeDetailsList1.getLatitude());
            log = Double.parseDouble(homeDetailsList1.getLongitude());
            bundle.putString("address",homeDetailsList1.getAddress_line_1());
            bundle.putDouble("lat", lat);
            bundle.putDouble("log", log);
            mapFragmentView = new MapFrg();
            FragmentTransaction fragmentTransaction = ((FragmentActivity)activity).getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.flAdapterContainer, mapFragmentView);
            mapFragmentView.setArguments(bundle);
            //fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();


            //holderViews.mvHouseDetail.getMapAsync(this);
            //iProfiePresenter.setMapView(holderViews.mvHouseDetail);

        }
    }



    @Override
    public int getItemCount() {
        if (homeDetailsList != null && homeDetailsList.size() > 0) {
            return homeDetailsList.size();
        } else {
            return 0;
        }
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    /*** ViewHolder class which holds Initialisation to all views and buttons.*/
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        LinearLayout llHomeProfile;
        FrameLayout flAdapterContainer;
        ImageView ivHomeImg;
        TextView tvDescription;
        TextView tvLocAddress;
        RecyclerView rvHomeRecommended;
        View root;

        public ViewHolder(View itemView) {
            super(itemView);
            root = itemView;
            itemView.setOnClickListener(this);
            rvHomeRecommended = itemView.findViewById(R.id.rvHomeRecommended);
            flAdapterContainer = itemView.findViewById(R.id.flAdapterContainer);
            llHomeProfile = itemView.findViewById(R.id.llHomeProfile);
            ivHomeImg = itemView.findViewById(R.id.ivHomeImg);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvLocAddress = itemView.findViewById(R.id.tvLocAddress);

        }

        @Override
        public void onClick(View v) {

            if (clickListener != null) {
                clickListener.itemClicked(v, getPosition());
            }

            //delete(getPosition());

        }
    }


    public void setClickListener(ClickListener clicklistener) {

        this.clickListener = clicklistener;

    }


    public interface ClickListener {
        public void itemClicked(View view, int position);
    }


}