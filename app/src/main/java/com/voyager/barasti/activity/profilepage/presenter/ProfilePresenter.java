package com.voyager.barasti.activity.profilepage.presenter;

import android.app.Activity;
import android.widget.Toast;

import com.google.android.gms.maps.MapView;
import com.google.gson.Gson;
import com.voyager.barasti.activity.profilepage.model.HomeDetails;
import com.voyager.barasti.activity.profilepage.view.IProfileView;
import com.voyager.barasti.fragment.explore.model.exploreList.HouseList;
import com.voyager.barasti.fragment.explore.model.exploreList.LikeUnLike;
import com.voyager.barasti.webservices.ApiClient;
import com.voyager.barasti.webservices.WebServices;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by User on 09-Jan-19.
 */

public class ProfilePresenter implements IProfiePresenter{

    IProfileView iProfileView;
    Activity activity;
    HomeDetails homeDetails;
    MapView mvHouseDetail;

    public ProfilePresenter(IProfileView iProfileView, Activity activity) {
        this.iProfileView = iProfileView;
        this.activity = activity;
    }


    @Override
    public void getHomeData(int houseId,int userId) {
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Call<HomeDetails> calls = webServices.doGetHomeDetails(houseId,userId);
        calls.enqueue(new Callback<HomeDetails>() {
            @Override
            public void onResponse(Call<HomeDetails> call, Response<HomeDetails> response) {
                homeDetails = response.body();
                iProfileView.setHomeDetail(homeDetails);
                String json = new Gson().toJson(homeDetails);
                System.out.println("ProfilePresenter getHomeData json : " + json);

            }

            @Override
            public void onFailure(Call<HomeDetails> call, Throwable t) {
                if (t instanceof IOException) {
                    Toast.makeText(activity, "this is an actual network failure :( inform the user and possibly retry", Toast.LENGTH_SHORT).show();
                    // logging probably not necessary
                }
                else {
                    Toast.makeText(activity, "conversion issue! big problems :(", Toast.LENGTH_SHORT).show();
                    // todo log to some central bug tracking service
                }
                t.printStackTrace();
                System.out.println(" there is an  error here  in api : "+t.getMessage()+"/n");

                //Toast.makeText((Context) iRegisterView, "ErrorMessage"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
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
    public void setMapView(MapView mvHouseDetail) {
        this.mvHouseDetail = mvHouseDetail;
        iProfileView.setMapViewP(mvHouseDetail);
    }

}
