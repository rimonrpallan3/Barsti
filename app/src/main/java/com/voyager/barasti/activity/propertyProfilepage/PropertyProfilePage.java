package com.voyager.barasti.activity.propertyProfilepage;

import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.MapView;
import com.voyager.barasti.R;
import com.voyager.barasti.activity.calenderactivity.CalenderActivity_v3;
import com.voyager.barasti.activity.landingpage.LandingPage;
import com.voyager.barasti.activity.propertyProfilepage.adapter.ProfilePageAdapter;
import com.voyager.barasti.activity.propertyProfilepage.model.HomeDetails;
import com.voyager.barasti.activity.propertyProfilepage.model.HomeRooms;
import com.voyager.barasti.activity.propertyProfilepage.presenter.IProfiePresenter;
import com.voyager.barasti.activity.propertyProfilepage.presenter.ProfilePresenter;
import com.voyager.barasti.activity.propertyProfilepage.view.IProfileView;
import com.voyager.barasti.fragment.explore.model.exploreList.HouseList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 09-Jan-19.
 */

public class PropertyProfilePage extends AppCompatActivity implements IProfileView {

    RecyclerView rvProfilePage;
    IProfiePresenter iProfiePresenter;
    HouseList bodyItems;
    ProfilePageAdapter profilePageAdapter;
    List<HomeDetails> homeDetailsList = new ArrayList<>();
    HomeDetails homeDetails;
    MapView mvHouseDetail;
    TextView tvHomeAmt;
    TextView tvFavValue;
    int propertyId=0;
    int priceValue=0;
    int reviewRate=0;
    int userID=0;
    int guestMoreAccNo=0;
    int guestAccNo=0;
    LinearLayout llContBtn;
    List<HomeRooms> homeRoomsList;
    int totalGuestCount = 0;

    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_profile_page);
        rvProfilePage = (RecyclerView) findViewById(R.id.rvProfilePage);
        tvHomeAmt =findViewById(R.id.tvHomeAmt);
        tvFavValue =findViewById(R.id.tvFavValue);
        llContBtn =findViewById(R.id.llContBtn);

        iProfiePresenter = new ProfilePresenter(this,this);
        Intent intent = getIntent();

        propertyId = intent.getIntExtra("propertyId",propertyId);
        priceValue = intent.getIntExtra("priceValue",priceValue);
        reviewRate = intent.getIntExtra("reviewRate",reviewRate);
        userID = intent.getIntExtra("userID",userID);
        guestMoreAccNo = intent.getIntExtra("guestMoreAccNo",guestMoreAccNo);
        guestAccNo = intent.getIntExtra("guestAccNo",guestAccNo);

        if(propertyId!=0){
            iProfiePresenter.getHomeData(propertyId,userID);
            tvHomeAmt.setText(priceValue+" BD / Night");
            tvFavValue.setText(""+reviewRate);
        }else {
            Toast.makeText(getApplication(), "Home Data Is not Present.",Toast.LENGTH_LONG).show();
        }

        llContBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalGuestCount = homeDetails.getAccommodates();
                Intent intent = new Intent(getApplicationContext(), CalenderActivity_v3.class);
                intent.putExtra("propertyId", propertyId);
                intent.putExtra("userID", userID);
                intent.putExtra("totalGuestCount", totalGuestCount);
                intent.putExtra("homeDetails", homeDetails);
                System.out.println("PropertyProfilePage totalGuestCount : "+totalGuestCount);
                startActivity(intent);
            }
        });

    }

    public void getHouseRomeDetials(){
        homeRoomsList = new ArrayList<>();
        HomeRooms Bedrooms =new HomeRooms(R.drawable.bedroom_icon,"Bedrooms");
        HomeRooms Beds = new HomeRooms(R.drawable.beds_icon,"Beds");
        HomeRooms Bathrooms =new HomeRooms(R.drawable.bathroom_icon,"Bathrooms");
        HomeRooms Accommodates =new HomeRooms(R.drawable.accommodates_icon,"Accommodates");
        homeRoomsList.add(Bedrooms);
        homeRoomsList.add(Beds);
        homeRoomsList.add(Bathrooms);
        homeRoomsList.add(Accommodates);
    }

    @Override
    public void setHomeDetail(HomeDetails homeDetails) {
        this.homeDetails = homeDetails;
        homeDetailsList.add(homeDetails);
        getHouseRomeDetials();
        profilePageAdapter = new ProfilePageAdapter(homeDetailsList,this,iProfiePresenter,homeRoomsList,userID);
        rvProfilePage.setLayoutFrozen(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvProfilePage.setLayoutManager(mLayoutManager);
        rvProfilePage.setItemAnimator(new DefaultItemAnimator());
        rvProfilePage.setAdapter(profilePageAdapter);
        totalGuestCount = homeDetails.getAccommodates();
    }

    @Override
    public void setMapViewP(MapView mvHouseDetail) {
        this.mvHouseDetail =mvHouseDetail;
    }


    public void ivHomeClick(View v){
        Intent intent = new Intent(getApplicationContext(), LandingPage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        /*Intent intent = getIntent();
        intent.putExtra("orderConfirm","true");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();*/
    }


}