package com.voyager.barasti.activity.typelist;

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
import com.voyager.barasti.activity.typelist.adapter.TypedListAdapter;
import com.voyager.barasti.activity.typelist.model.TypedDetail;
import com.voyager.barasti.activity.typelist.presenter.ITypeListPresenter;
import com.voyager.barasti.activity.typelist.presenter.TypeListPresenter;
import com.voyager.barasti.activity.typelist.view.ITypeView;
import com.voyager.barasti.fragment.explore.model.ExploreType.TypeList;

/**
 * Created by User on 11-Jan-19.
 */

public class TypeListActivity extends AppCompatActivity implements ITypeView{

    RecyclerView rvTypeList;
    ITypeListPresenter iTypeListPresenter;
    TypedListAdapter typedListAdapter;
    TypeList typeList;
    TextView tvTBHeading;
    int userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_list);
        rvTypeList = findViewById(R.id.rvTypeList);
        tvTBHeading = findViewById(R.id.tvTBHeading);
        iTypeListPresenter = new TypeListPresenter(this, this);
        Intent intent = getIntent();
        typeList = intent.getParcelableExtra("TypeListActivity");
        userID = intent.getIntExtra("userID",userID);
        if(typeList!=null){
            iTypeListPresenter.getTypedAptData(typeList);
            tvTBHeading.setText(typeList.getName());
        }else {
            Toast.makeText(getApplication(), "Home Data Is not Present.",Toast.LENGTH_LONG).show();
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
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void setTypedAdapterList(TypedDetail typedAdapterList) {
        typedListAdapter = new TypedListAdapter(typedAdapterList.getProperties(), this,iTypeListPresenter,userID);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getParent());
        rvTypeList.setLayoutManager(mLayoutManager);
        rvTypeList.setItemAnimator(new DefaultItemAnimator());
        rvTypeList.setLayoutManager(new GridLayoutManager(getParent(), 2));
        rvTypeList.setAdapter(typedListAdapter);
        rvTypeList.setLayoutFrozen(true);
    }
}