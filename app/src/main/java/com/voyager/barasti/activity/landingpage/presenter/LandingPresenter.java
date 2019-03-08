package com.voyager.barasti.activity.landingpage.presenter;

import android.app.Activity;
import android.util.Log;
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

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
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
    public void getDetails(int userId) {
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Observable<MainList> mainListObservable = webServices.doGetDetails1(userId);
        mainListObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getMainList());
    }

    private Observer<MainList> getMainList() {
        return new Observer<MainList>() {

            @Override
            public void onSubscribe(Disposable d) {
                iLandingView.unSubscribeCalls(d);
                Log.d("LandingPresenter", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(MainList value) {
                iLandingView.setMainList(value);
                Log.d("LandingPresenter", " onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("LandingPresenter", " onError : " + e.getMessage());
                Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Log.d("LandingPresenter", " onComplete");
            }
        };
    }

}
