package com.voyager.barasti.activity.profilepage;

import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.MapView;
import com.voyager.barasti.R;
import com.voyager.barasti.activity.profilepage.adapter.ProfilePageAdapter;
import com.voyager.barasti.activity.profilepage.model.HomeDetails;
import com.voyager.barasti.activity.profilepage.presenter.IProfiePresenter;
import com.voyager.barasti.activity.profilepage.presenter.ProfilePresenter;
import com.voyager.barasti.activity.profilepage.view.IProfileView;
import com.voyager.barasti.fragment.explore.model.exploreList.HouseList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 09-Jan-19.
 */

public class ProfilePage extends AppCompatActivity implements IProfileView {

    RecyclerView rvProfilePage;
    IProfiePresenter iProfiePresenter;
    HouseList bodyItems;
    ProfilePageAdapter profilePageAdapter;
    List<HomeDetails> homeDetailsList = new ArrayList<>();
    HomeDetails homeDetails;
    MapView mvHouseDetail;
    TextView tvHomeAmt;
    TextView tvFavValue;
    int currentId=0;
    int priceValue=0;
    int reviewRate=0;


    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        rvProfilePage = (RecyclerView) findViewById(R.id.rvProfilePage);
        tvHomeAmt =findViewById(R.id.tvHomeAmt);
        tvFavValue =findViewById(R.id.tvFavValue);

        iProfiePresenter = new ProfilePresenter(this,this);
        Intent intent = getIntent();

        currentId = intent.getIntExtra("currentId",currentId);
        priceValue = intent.getIntExtra("priceValue",priceValue);
        reviewRate = intent.getIntExtra("reviewRate",reviewRate);

        if(currentId!=0){
            iProfiePresenter.getHomeData(currentId);
            tvHomeAmt.setText(priceValue+" / Night");
            tvFavValue.setText(""+reviewRate);
        }else {
            Toast.makeText(getApplication(), "Home Data Is not Present.",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void setHomeDetail(HomeDetails homeDetails) {
        this.homeDetails = homeDetails;
        homeDetailsList.add(homeDetails);
        profilePageAdapter = new ProfilePageAdapter(homeDetailsList,this,iProfiePresenter);
        rvProfilePage.setLayoutFrozen(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvProfilePage.setLayoutManager(mLayoutManager);
        rvProfilePage.setItemAnimator(new DefaultItemAnimator());
        rvProfilePage.setAdapter(profilePageAdapter);
    }

    @Override
    public void setMapViewP(MapView mvHouseDetail) {
        this.mvHouseDetail =mvHouseDetail;
    }




}