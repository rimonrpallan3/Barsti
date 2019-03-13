package com.voyager.barasti.activity.UserPropertyList.presenter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.voyager.barasti.activity.UserPropertyList.model.UserPropertyDetails;
import com.voyager.barasti.activity.UserPropertyList.view.IPropertyListView;
import com.voyager.barasti.activity.login.model.UserDetails;
import com.voyager.barasti.fragment.explore.model.exploreList.MainList;
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
 * Created by User on 06-Mar-19.
 */

public class PropertyListPresenter implements IPropertyListPresenter{

    IPropertyListView iPropertyListView;
    Activity activity;

    public PropertyListPresenter(IPropertyListView iPropertyListView, Activity activity) {
        this.iPropertyListView = iPropertyListView;
        this.activity = activity;
    }

    public void getUserProperties(int userId){
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Observable<UserPropertyDetails> getPropertiesDetailObservable = webServices.getPropertiesDetail(userId);
        getPropertiesDetailObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getPropertiesDetail());
    }

    private Observer<UserPropertyDetails> getPropertiesDetail() {
        return new Observer<UserPropertyDetails>() {

            @Override
            public void onSubscribe(Disposable d) {
                iPropertyListView.unSubscribeCalls(d);
                Log.d("PropertyListPresenter", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(UserPropertyDetails value) {
                UserPropertyDetails userPropertyDetails= value;
                iPropertyListView.setProperties(userPropertyDetails);
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Log.d("PropertyListPresenter", " onComplete");
            }
        };
    }


}
