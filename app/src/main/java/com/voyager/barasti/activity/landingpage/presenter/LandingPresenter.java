package com.voyager.barasti.activity.landingpage.presenter;

import android.app.Activity;
import android.widget.Toast;

import com.google.gson.Gson;
import com.voyager.barasti.R;
import com.voyager.barasti.activity.landingpage.view.ILandingView;
import com.voyager.barasti.fragment.explore.model.ExploreFooter.FooterItems;
import com.voyager.barasti.fragment.explore.model.ExploreFooter.LocItems;
import com.voyager.barasti.fragment.explore.model.ExploreHeader.Banner;
import com.voyager.barasti.fragment.explore.model.ExploreHeader.HeaderItem;
import com.voyager.barasti.fragment.explore.model.ExploreType.TypeBody;
import com.voyager.barasti.fragment.explore.model.exploreList.ExploreItems;
import com.voyager.barasti.fragment.explore.model.exploreList.MainList;
import com.voyager.barasti.webservices.ApiClient;
import com.voyager.barasti.webservices.WebServices;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * Created by User on 8/29/2017.
 */

public class LandingPresenter implements ILandingPresenter {

    Activity activity;
    String TAG;
    ILandingView iLandingView;



    public LandingPresenter(Activity activity, String TAG, ILandingView iLandingView) {
        this.activity = activity;
        this.TAG = TAG;
        this.iLandingView = iLandingView;
    }


    @Override
    public void getDetails() {
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Call<MainList> calls = webServices.doGetDetails();
        calls.enqueue(new Callback<MainList>() {
            @Override
            public void onResponse(Call<MainList> call, Response<MainList> response) {
                MainList mainList = response.body();
                iLandingView.setMainList(mainList);
            }

            @Override
            public void onFailure(Call<MainList> call, Throwable t) {
                if (t instanceof IOException) {
                    Toast.makeText(activity, "this is an actual network failure :( inform the user and possibly retry", Toast.LENGTH_SHORT).show();
                    // logging probably not necessary
                }
                else {
                    Toast.makeText(activity, "conversion issue! big problems :(", Toast.LENGTH_SHORT).show();
                    // todo log to some central bug tracking service
                }
                t.printStackTrace();
                //Toast.makeText((Context) iRegisterView, "ErrorMessage"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
