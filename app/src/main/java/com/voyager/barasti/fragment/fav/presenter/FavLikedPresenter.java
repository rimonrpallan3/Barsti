package com.voyager.barasti.fragment.fav.presenter;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.voyager.barasti.activity.landingpage.view.ILandingView;
import com.voyager.barasti.fragment.explore.model.ExploreType.TypeList;
import com.voyager.barasti.fragment.explore.model.exploreList.LikeUnLike;
import com.voyager.barasti.fragment.fav.model.FavDetail;
import com.voyager.barasti.fragment.fav.view.IFavLikedView;
import com.voyager.barasti.webservices.ApiClient;
import com.voyager.barasti.webservices.WebServices;

import java.io.IOException;
import java.util.ArrayList;

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
    ILandingView iLandingView;


    public FavLikedPresenter(IFavLikedView iFavLikedView, Activity activity,ILandingView iLandingView) {
        this.iFavLikedView = iFavLikedView;
        this.activity = activity;
        this.iLandingView = iLandingView;
    }

    private Observer<LikeUnLike> getLikedRsp() {
        return new Observer<LikeUnLike>() {

            @Override
            public void onSubscribe(Disposable d) {
                iFavLikedView.unSubscribeCalls(d);
                Log.d("FavLikedPresenter", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(LikeUnLike value) {
                LikeUnLike likeUnLike= value;
                if(likeUnLike.getError()!=null&&likeUnLike.getError().equals(true)){
                    Toast.makeText(activity, likeUnLike.getError_status(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(activity, "Liked", Toast.LENGTH_SHORT).show();
                }
                Log.d("FavLikedPresenter", " onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("FavLikedPresenter", " onError : " + e.getMessage());
                Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Log.d("FavLikedPresenter", " onComplete");
            }
        };
    }

    private Observer<LikeUnLike> getUnLikedRsp() {
        return new Observer<LikeUnLike>() {

            @Override
            public void onSubscribe(Disposable d) {
                iFavLikedView.unSubscribeCalls(d);
                Log.d("FavLikedPresenter", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(LikeUnLike value) {
                LikeUnLike likeUnLike= value;
                if(likeUnLike.getError()!=null&&likeUnLike.getError().equals(true)){
                    Toast.makeText(activity, likeUnLike.getError_status(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(activity, "UnLiked", Toast.LENGTH_SHORT).show();
                }

                Log.d("FavLikedPresenter", " onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("FavLikedPresenter", " onError : " + e.getMessage());
                Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Log.d("FavLikedPresenter", " onComplete");
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
    public void setDefaultImg() {
        iFavLikedView.setDefaultImg();
    }


    @Override
    public void getFavLikedData(int userId) {
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Observable<ArrayList<FavDetail>> getFavDatailsObservable = webServices.getFavDetails(userId);
        getFavDatailsObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getFavDetail());


    }


    private Observer<ArrayList<FavDetail>> getFavDetail() {
        return new Observer<ArrayList<FavDetail>>() {

            @Override
            public void onSubscribe(Disposable d) {
                iFavLikedView.unSubscribeCalls(d);
                Log.d("FavLikedPresenter", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(ArrayList<FavDetail> value) {
                ArrayList<FavDetail> favDetails= value;
                String json = new Gson().toJson(favDetails);
                System.out.println("FavLikedPresenter getTypedAptData json : " + json);
                iFavLikedView.setFavAdapterList(favDetails);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("FavLikedPresenter", " onError : " + e.getMessage());
                Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Log.d("FavLikedPresenter", " onComplete");
            }
        };
    }
}
