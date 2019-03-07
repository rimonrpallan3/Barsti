package com.voyager.barasti.activity.locationListPropety.presenter;

import android.app.Activity;
import android.widget.Toast;

import com.google.gson.Gson;
import com.voyager.barasti.activity.locationListPropety.model.LocDetails;
import com.voyager.barasti.activity.locationListPropety.view.ILocationView;
import com.voyager.barasti.activity.typelist.model.TypedDetail;
import com.voyager.barasti.fragment.explore.model.exploreList.LikeUnLike;
import com.voyager.barasti.webservices.ApiClient;
import com.voyager.barasti.webservices.WebServices;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by User on 04-Mar-19.
 */

public class LocationPresenter implements ILocationPresenter{

    Activity activity;
    ILocationView iLocationView;


    public LocationPresenter(Activity activity, ILocationView iLocationView) {
        this.activity = activity;
        this.iLocationView = iLocationView;
    }

    @Override
    public void btnLiked(Integer userID, Integer propertyId) {
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Call<LikeUnLike> calls = webServices.propertyLike(userID,propertyId);
        calls.enqueue(new Callback<LikeUnLike>() {
            @Override
            public void onResponse(Call<LikeUnLike> call, Response<LikeUnLike> response) {
                LikeUnLike likeUnLike= response.body();
                if(likeUnLike.getError()!=null&&likeUnLike.getError().equals(true)){
                    Toast.makeText(activity, likeUnLike.getError_status(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(activity, "Liked", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LikeUnLike> call, Throwable t) {
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

    @Override
    public void btnUnliked(Integer userID, Integer propertyId) {
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Call<LikeUnLike> calls = webServices.propertyUnlike(userID,propertyId);
        calls.enqueue(new Callback<LikeUnLike>() {
            @Override
            public void onResponse(Call<LikeUnLike> call, Response<LikeUnLike> response) {
                LikeUnLike likeUnLike= response.body();
                if(likeUnLike.getError()!=null&&likeUnLike.getError().equals(true)){
                    Toast.makeText(activity, likeUnLike.getError_status(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(activity, "UnLiked", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LikeUnLike> call, Throwable t) {
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


    @Override
    public void getLoclist(String locName, int userID) {
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Call<ArrayList<LocDetails>> calls = webServices.getLocDetails(userID,locName);
        calls.enqueue(new Callback<ArrayList<LocDetails>>() {
            @Override
            public void onResponse(Call<ArrayList<LocDetails>> call, Response<ArrayList<LocDetails>> response) {
                ArrayList<LocDetails> locDetails = response.body();
                String json = new Gson().toJson(locDetails);
                System.out.println("LocListPresenter getLoclist json : " + json);
                iLocationView.setLocListAdapterList(locDetails);
            }

            @Override
            public void onFailure(Call<ArrayList<LocDetails>> call, Throwable t) {
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
