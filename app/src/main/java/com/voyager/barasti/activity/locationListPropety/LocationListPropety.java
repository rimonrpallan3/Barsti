package com.voyager.barasti.activity.locationListPropety;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.voyager.barasti.R;
import com.voyager.barasti.activity.locationListPropety.adapter.LocListAdapter;
import com.voyager.barasti.activity.locationListPropety.model.LocDetails;
import com.voyager.barasti.activity.locationListPropety.presenter.ILocationPresenter;
import com.voyager.barasti.activity.locationListPropety.presenter.LocationPresenter;
import com.voyager.barasti.activity.locationListPropety.view.ILocationView;
import com.voyager.barasti.fragment.explore.model.ExploreType.TypeList;

import java.util.ArrayList;

import io.reactivex.disposables.Disposable;

/**
 * Created by User on 04-Mar-19.
 */

public class LocationListPropety extends AppCompatActivity implements ILocationView{

    RecyclerView rvLocList;
    LocListAdapter locListAdapter;
    TextView tvTBHeading;
    ILocationPresenter iLocationPresenter;
    int userID;
    String locName = "";
    Disposable dMainListObservable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loc_list);
        rvLocList = findViewById(R.id.rvLocList);
        tvTBHeading = findViewById(R.id.tvTBHeading);
        iLocationPresenter = new LocationPresenter(this, this);
        Intent intent = getIntent();
        locName = intent.getStringExtra("LocName");
        userID = intent.getIntExtra("userID",userID);
        if(locName!=null){
            iLocationPresenter.getLoclist(locName,userID);
            tvTBHeading.setText(locName+" list");
        }else {
            Toast.makeText(getApplication(), getResources().getString( R.string.loc_data_null ),Toast.LENGTH_LONG).show();
        }

        /*typedListAdapter = new TypedListAdapter(homeDetailsList1.getRecommend(), getParent());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getParent());
        rvTypeList.setLayoutManager(mLayoutManager);
        rvTypeList.setItemAnimator(new DefaultItemAnimator());
        rvTypeList.setLayoutManager(new GridLayoutManager(getParent(), 2));
        rvTypeList.setAdapter(typedListAdapter);
        rvTypeList.setLayoutFrozen(true);*/

    }

    public void ivBackbtn(View v){
        Intent intent = new Intent();
        intent.putExtra("UpdateHome", "true");
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void setLocListAdapterList(ArrayList<LocDetails> locDetails) {
        locListAdapter = new LocListAdapter(locDetails, this,iLocationPresenter,userID);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getParent());
        rvLocList.setLayoutManager(mLayoutManager);
        rvLocList.setItemAnimator(new DefaultItemAnimator());
        rvLocList.setLayoutManager(new GridLayoutManager(getParent(), 2));
        rvLocList.setAdapter(locListAdapter);
        rvLocList.setLayoutFrozen(true);
    }

    @Override
    public void unSubscribeCalls(Disposable dMainListObservable) {
        this.dMainListObservable= dMainListObservable;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(dMainListObservable!=null)
            dMainListObservable.dispose();
    }
}