package com.voyager.barasti.activity.PriceDetailPage;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.voyager.barasti.R;
import com.voyager.barasti.activity.PriceDetailPage.model.PriceDetails;
import com.voyager.barasti.activity.PriceDetailPage.presenter.IPricePresenter;
import com.voyager.barasti.activity.PriceDetailPage.presenter.PricePresenter;
import com.voyager.barasti.activity.PriceDetailPage.view.IPriceView;
import com.voyager.barasti.activity.gestCountPage.adapter.GuestListAdapter;
import com.voyager.barasti.activity.gestCountPage.model.GuestCount;
import com.voyager.barasti.activity.propertyProfilepage.model.HomeDetails;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by User on 25-Feb-19.
 */

public class PriceDetailActivity extends AppCompatActivity  implements IPriceView{

    private Activity activity;
    SharedPreferences filter_prefs;
    GuestListAdapter guestListAdapter;
    private List<GuestCount> guestCounts = new ArrayList<>();
    private RecyclerView rvCountList;

    int propertyId = 0;
    int userID = 0;
    int totalGuestCount = 0;
    public String currentStartDate = "";
    public String currentEndDate = "";
    HomeDetails homeDetails;
    Integer guestCount = 0;
    TextView tvTotalNightsAmt;
    TextView tvTotalNightsHd;
    TextView tvServiceFee;
    TextView tvHostFee;
    TextView tvTotalAmt;
    TextView tvHeading;
    TextView tvHomeAmt;
    TextView tvFavValue;
    TextView tvSecurityFee;
    TextView tvCleaningFee;
    ImageView ivHome;
    ImageView ivGuest;
    TextView tvGuestCount;
    ImageView ivCheckOut;
    TextView tvCheckOutDate;
    ImageView ivCheckIn;
    TextView tvCheckInDate;
    IPricePresenter iPricePresenter;

    String checkIn ="";
    String checkOut = "";
    PriceDetails priceDetails;
    Disposable dMainListObservable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_detail);
        Intent intent = getIntent();
        currentStartDate = intent.getStringExtra("currentStartDate");
        currentEndDate = intent.getStringExtra("currentEndDate");
        propertyId = intent.getIntExtra("propertyId", propertyId);
        userID = intent.getIntExtra("userID", userID);
        guestCount = intent.getIntExtra("guestCount", guestCount);
        homeDetails = intent.getParcelableExtra("homeDetails");
        checkIn = intent.getStringExtra("checkIn");
        checkOut = intent.getStringExtra("checkOut");
        tvHeading = findViewById(R.id.tvHeading);
        tvHomeAmt = findViewById(R.id.tvHomeAmt);
        tvFavValue = findViewById(R.id.tvFavValue);
        ivGuest = findViewById(R.id.ivGuest);
        tvGuestCount = findViewById(R.id.tvGuestCount);
        ivCheckOut = findViewById(R.id.ivCheckOut);
        tvCheckOutDate = findViewById(R.id.tvCheckOutDate);
        ivCheckIn = findViewById(R.id.ivCheckIn);
        tvCheckInDate = findViewById(R.id.tvCheckInDate);
        ivHome = findViewById(R.id.ivHome);
        tvSecurityFee = findViewById(R.id.tvSecurityFee);
        tvCleaningFee = findViewById(R.id.tvCleaningFee);
        tvTotalNightsAmt = findViewById(R.id.tvTotalNightsAmt);
        tvTotalNightsHd = findViewById(R.id.tvTotalNightsHd);
        tvServiceFee = findViewById(R.id.tvServiceFee);
        tvHostFee = findViewById(R.id.tvHostFee);
        tvTotalAmt = findViewById(R.id.tvTotalAmt);
        Picasso.with(this)
                .load(homeDetails.getCover_photo())
                .placeholder(R.drawable.placeholder_image)
                .into(ivHome);
        tvHeading.setText(homeDetails.getName());
        tvHomeAmt.setText(""+homeDetails.getPrice()+" BD per Night");
        tvFavValue.setText(""+homeDetails.getOverall_rating());
        tvCheckOutDate.setText(checkOut);
        tvCheckInDate.setText(checkIn);
        tvGuestCount.setText(guestCount+" Guest");
        iPricePresenter = new PricePresenter(this,
                this,
                propertyId,
                currentStartDate,
                currentEndDate,
                guestCount,
                userID);
    }



    public  void ivBackbtn(View v){
        finish();
    }

    @Override
    public void setPriceDetails(PriceDetails priceDetails) {
        this.priceDetails = priceDetails;
        tvTotalNightsAmt.setText(priceDetails.getTotal_night_price() +" BD");
        tvTotalNightsHd.setText(priceDetails.getTotal_nights() +"Nights price");
        tvServiceFee.setText(priceDetails.getService_fee() +" BD");
        tvHostFee.setText(priceDetails.getHost_fee() +" BD");
        tvSecurityFee.setText(priceDetails.getSecurity_fee()+" BD");
        tvCleaningFee.setText(priceDetails.getCleaning_fee()+" BD");
        tvTotalAmt.setText(priceDetails.getTotal() +" BD");

    }

    @Override
    public void unSubscribeCalls(Disposable dMainListObservable) {
        this.dMainListObservable = dMainListObservable;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(dMainListObservable!=null){
            dMainListObservable.dispose();
        }
    }
}
