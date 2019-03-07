package com.voyager.barasti.fragment.fav.presenter;

import android.app.Activity;
import android.widget.Toast;

import com.google.gson.Gson;
import com.voyager.barasti.fragment.explore.model.ExploreType.TypeList;
import com.voyager.barasti.fragment.explore.model.exploreList.LikeUnLike;
import com.voyager.barasti.fragment.fav.model.FavDetail;
import com.voyager.barasti.fragment.fav.view.IFavLikedView;
import com.voyager.barasti.webservices.ApiClient;
import com.voyager.barasti.webservices.WebServices;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by User on 11-Jan-19.
 */

public class FavLikedPresenter implements IFavLikedPresenter {

    IFavLikedView iFavLikedView;
    Activity activity;
    ArrayList<FavDetail> favDetails;
    int limit = 4;
    int locLimit = 4;
    int offset = 0;
    int locOffset = 0;
    int propertyId   = 0;


    public FavLikedPresenter(IFavLikedView iFavLikedView, Activity activity) {
        this.iFavLikedView = iFavLikedView;
        this.activity = activity;
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
    public void setDefaultImg() {

    }


    @Override
    public void getFavLikedData(int userId) {
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Call<ArrayList<FavDetail>> calls = webServices.getFavDetails(userId);
        calls.enqueue(new Callback<ArrayList<FavDetail>>() {
            @Override
            public void onResponse(Call<ArrayList<FavDetail>> call, Response<ArrayList<FavDetail>> response) {
                favDetails = response.body();
                String json = new Gson().toJson(favDetails);
                System.out.println("FavLikedPresenter getTypedAptData json : " + json);
                iFavLikedView.setFavAdapterList(favDetails);
            }

            @Override
            public void onFailure(Call<ArrayList<FavDetail>> call, Throwable t) {
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
