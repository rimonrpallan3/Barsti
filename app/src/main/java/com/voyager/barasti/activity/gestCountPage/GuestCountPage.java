package com.voyager.barasti.activity.gestCountPage;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.voyager.barasti.R;
import com.voyager.barasti.activity.PriceDetailPage.PriceDetailActivity;
import com.voyager.barasti.activity.gestCountPage.adapter.GuestListAdapter;
import com.voyager.barasti.activity.gestCountPage.model.GuestCount;
import com.voyager.barasti.activity.gestCountPage.presenter.GuestPresenter;
import com.voyager.barasti.activity.gestCountPage.presenter.IGuestPresenter;
import com.voyager.barasti.activity.gestCountPage.view.IGuestView;
import com.voyager.barasti.activity.propertyProfilepage.model.HomeDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 25-Feb-19.
 */

public class GuestCountPage extends AppCompatActivity implements IGuestView {

    private Activity activity;
    SharedPreferences filter_prefs;
    GuestListAdapter guestListAdapter;
    private List<GuestCount> guestCounts = new ArrayList<>();
    private RecyclerView rvCountList;

    int propertyId=0;
    int userID=0;
    int totalGuestCount=0;
    public String currentStartDate="";
    public String currentEndDate = "";
    IGuestPresenter iGuestPresenter;
    Integer guestCount =0;
    HomeDetails homeDetails;

    String checkIn ="";
    String checkOut = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_count);
        Intent intent = getIntent();
        currentStartDate = intent.getStringExtra("currentStartDate");
        currentEndDate = intent.getStringExtra("currentEndDate");
        checkIn = intent.getStringExtra("checkIn");
        checkOut = intent.getStringExtra("checkOut");
        propertyId = intent.getIntExtra("propertyId",propertyId);
        userID = intent.getIntExtra("userID",userID);
        totalGuestCount = intent.getIntExtra("totalGuestCount",totalGuestCount);
        homeDetails = intent.getParcelableExtra("homeDetails");
        iGuestPresenter = new GuestPresenter(this,this);
        menVerticalList();
    }

    public void btnContinue(View v){
        if(guestCount>0) {
            Intent intent = new Intent(this, PriceDetailActivity.class);
            intent.putExtra("currentStartDate", currentStartDate);
            intent.putExtra("currentEndDate", currentEndDate);
            intent.putExtra("propertyId", propertyId);
            intent.putExtra("userID", userID);
            intent.putExtra("guestCount", guestCount);
            intent.putExtra("homeDetails", homeDetails);
            intent.putExtra("checkIn", checkIn);
            intent.putExtra("checkOut", checkOut);
            startActivity(intent);
        }else {
            Toast.makeText(this,"Geust count cant be zero",Toast.LENGTH_LONG).show();
        }
    }

    public  void ivBackbtn(View v){
        finish();
    }

    private void menVerticalList() {
        rvCountList = findViewById(R.id.rvCountList);
        // add a divider after each item for more clarity
        //rvHorizontalView.addItemDecoration(new DividerItemDecoration(activity, LinearLayoutManager.HORIZONTAL));
        guestListAdapter = new GuestListAdapter(guestCounts,activity,totalGuestCount,iGuestPresenter);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        rvCountList.setLayoutManager(horizontalLayoutManager);
        rvCountList.setAdapter(guestListAdapter);
        populateOrderList();

    }

    private void populateOrderList() {
        GuestCount firstOrder = new GuestCount(R.drawable.profile_icon,
                "Guest No : ", "Newfree3", "2 BD");
        guestCounts.add(firstOrder);
        guestListAdapter.notifyDataSetChanged();
    }


    @Override
    public void getGuestCount(Integer guestCount) {
        this.guestCount = guestCount;
    }
}