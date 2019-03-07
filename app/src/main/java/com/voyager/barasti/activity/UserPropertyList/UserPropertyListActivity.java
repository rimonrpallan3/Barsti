package com.voyager.barasti.activity.UserPropertyList;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.voyager.barasti.R;
import com.voyager.barasti.activity.UserPropertyList.adapter.UserPropertyAdapter;
import com.voyager.barasti.activity.UserPropertyList.model.UserPropertyDetails;
import com.voyager.barasti.activity.UserPropertyList.presenter.IPropertyListPresenter;
import com.voyager.barasti.activity.UserPropertyList.presenter.PropertyListPresenter;
import com.voyager.barasti.activity.UserPropertyList.view.IPropertyListView;
import com.voyager.barasti.activity.login.model.UserDetails;
import com.voyager.barasti.fragment.explore.adapter.BodyListAdapter;

/**
 * Created by User on 06-Mar-19.
 */

public class UserPropertyListActivity extends AppCompatActivity implements IPropertyListView{

    Button btnUpdate;
    int userId = 0;
    String fName= "";
    String lName = "";

    AppCompatTextView tvEmail;
    AppCompatTextView tvPhone;
    AppCompatTextView tvUserName;
    TextView tvAbtMe;

    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;
    UserDetails userDetails;
    IPropertyListPresenter iPropertyListPresenter;
    boolean dataSet = false;
    RecyclerView rvUserProperty;
    RecyclerView rvUserPropertyRating;
    UserPropertyAdapter userPropertyAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_property_list);

        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvUserName = findViewById(R.id.tvUserName);
        rvUserProperty = findViewById(R.id.rvUserProperties);
        rvUserPropertyRating = findViewById(R.id.rvUserPropertyRating);
        tvAbtMe = findViewById(R.id.tvAbtMe);

        Intent intent = getIntent();
        userDetails = intent.getParcelableExtra("UserDetails");
        iPropertyListPresenter = new PropertyListPresenter(this,this);
        if (userDetails != null) {
            System.out.println(" UserProperty List Activity - - UserDetail- name : " + userDetails.getFirst_name());
            System.out.println(" UserProperty List Activity - - UserDetail- Id : " + userDetails.getId());
            System.out.println(" UserProperty List Activity - - UserDetail- fcm : " + userDetails.getFcm());
            tvUserName.setText(userDetails.getFirst_name()+"");
            tvPhone.setText(userDetails.getPhone_num()+"");
            tvEmail.setText(userDetails.getEmail());
            iPropertyListPresenter.getUserProperties(userDetails.getId());
        }





    }

    public void ivBackbtn(View v){
        if(dataSet){
            setResult(RESULT_OK);
            finish();
        }
        finish();
    }

    @Override
    public void onBackPressed() {
        if(dataSet){
            setResult(RESULT_OK);
            finish();
        }
        finish();
    }



    @Override
    public void setProperties(UserPropertyDetails userPropertyDetails) {
        userPropertyAdapter = new UserPropertyAdapter(userPropertyDetails.getListings(), this,userDetails.getId(),iPropertyListPresenter );
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);;
        rvUserProperty.setLayoutManager(mLayoutManager);
        rvUserProperty.setItemAnimator(new DefaultItemAnimator());
        //rvUserProperty.setLayoutManager(new GridLayoutManager(this, 1));
        rvUserProperty.setAdapter(userPropertyAdapter);

        tvAbtMe.setText(userPropertyDetails.getUser().getAbout_me()+"");
    }
}
