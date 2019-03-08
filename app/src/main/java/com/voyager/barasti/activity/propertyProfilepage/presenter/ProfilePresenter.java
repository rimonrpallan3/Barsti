package com.voyager.barasti.activity.propertyProfilepage.presenter;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.MapView;
import com.google.gson.Gson;
import com.voyager.barasti.activity.propertyProfilepage.model.HomeDetails;
import com.voyager.barasti.activity.propertyProfilepage.view.IProfileView;
import com.voyager.barasti.fragment.explore.model.exploreList.LikeUnLike;
import com.voyager.barasti.webservices.ApiClient;
import com.voyager.barasti.webservices.WebServices;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
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
        Observable<HomeDetails> homeDetailObservable = webServices.doGetHomeDetails(houseId,userId);
        homeDetailObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getHomeDetail());
    }

    private Observer<HomeDetails> getHomeDetail() {
        return new Observer<HomeDetails>() {

            @Override
            public void onSubscribe(Disposable d) {
                iProfileView.unSubscribeCalls(d);
                Log.d("LocationPresenter", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(HomeDetails value) {
                HomeDetails homeDetails= value;
                iProfileView.setHomeDetail(homeDetails);
                String json = new Gson().toJson(homeDetails);
                System.out.println("LocationPresenter getHomeData json : " + json);
                Log.d("LocationPresenter", " onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("LocationPresenter", " onError : " + e.getMessage());
                Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Log.d("LocationPresenter", " onComplete");
            }
        };
    }



    private Observer<LikeUnLike> getLikedRsp() {
        return new Observer<LikeUnLike>() {

            @Override
            public void onSubscribe(Disposable d) {
                iProfileView.unSubscribeCalls(d);
                Log.d("LocationPresenter", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(LikeUnLike value) {
                LikeUnLike likeUnLike= value;
                if(likeUnLike.getError()!=null&&likeUnLike.getError().equals(true)){
                    Toast.makeText(activity, likeUnLike.getError_status(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(activity, "Liked", Toast.LENGTH_SHORT).show();
                }
                Log.d("LocationPresenter", " onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("LocationPresenter", " onError : " + e.getMessage());
                Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Log.d("LocationPresenter", " onComplete");
            }
        };
    }

    private Observer<LikeUnLike> getUnLikedRsp() {
        return new Observer<LikeUnLike>() {

            @Override
            public void onSubscribe(Disposable d) {
                iProfileView.unSubscribeCalls(d);
                Log.d("LocationPresenter", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(LikeUnLike value) {
                LikeUnLike likeUnLike= value;
                if(likeUnLike.getError()!=null&&likeUnLike.getError().equals(true)){
                    Toast.makeText(activity, likeUnLike.getError_status(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(activity, "UnLiked", Toast.LENGTH_SHORT).show();
                }

                Log.d("LocationPresenter", " onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("LocationPresenter", " onError : " + e.getMessage());
                Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Log.d("LocationPresenter", " onComplete");
            }
        };
    }

    @Override
    public void btnLiked(Integer userID, Integer propertyId) {
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Observable<LikeUnLike> likedObservable = webServices.propertyLike(userID,propertyId);
        likedObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getLikedRsp());
    }

    @Override
    public void btnUnliked(Integer userID, Integer propertyId) {
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Observable<LikeUnLike> likedObservable = webServices.propertyUnlike(userID,propertyId);
        likedObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getUnLikedRsp());
    }



    @Override
    public void setMapView(MapView mvHouseDetail) {
        this.mvHouseDetail = mvHouseDetail;
        iProfileView.setMapViewP(mvHouseDetail);
    }

}
