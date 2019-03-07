package com.voyager.barasti.activity.splashscreen.presenter;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;
import com.voyager.barasti.activity.login.model.UserDetails;
import com.voyager.barasti.activity.splashscreen.view.ISplashView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by User on 8/28/2017.
 */

public class SplashPresenter implements IConnectionStatus{

    Context context;
    ISplashView splashView;
    Activity activity;
    String emailAddress="";

    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;

    private int SPLASH_DISPLAY_LENGTH = 2;

    public SplashPresenter(Context context, ISplashView splashView, Activity activity, SharedPreferences sharedPrefs, SharedPreferences.Editor editor) {
        this.activity = activity;
        this.context = context;
        this.splashView = splashView;
        this.sharedPrefs = sharedPrefs;
        this.editor = editor;
        emailAddress = getUserGsonInSharedPrefrences();
    }

    public String getUserGsonInSharedPrefrences(){
        String emailAddress ="";
        Gson gson = new Gson();
        String json = sharedPrefs.getString("UserDetails", null);
        if(json!=null){
            UserDetails userDetail = gson.fromJson(json, UserDetails.class);
            if(userDetail.getEmail()!=null) {
                emailAddress = userDetail.getEmail();
            }else {
                emailAddress = "";
            }
            System.out.println("--------- SplashPresenter getUserGsonInSharedPrefrences"+json);
        }
        return emailAddress;
    }



    @Override
    public void load() {
        getObservable().delay(SPLASH_DISPLAY_LENGTH, TimeUnit.SECONDS)
                // Run on a background thread
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver());
    }

    private Observable<String> getObservable() {
        return Observable.just(getUserGsonInSharedPrefrences());
    }

    private Observer<String> getObserver() {
        return new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d("SplashPresenter", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(String value) {
                if (value != null && value.length() > 0) {
                    splashView.moveToLanding();
                } else {
                    splashView.moveToSignUpLogin();
                }
                Log.d("SplashPresenter", " onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("SplashPresenter", " onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d("SplashPresenter", " onComplete");
            }
        };
    }

}
