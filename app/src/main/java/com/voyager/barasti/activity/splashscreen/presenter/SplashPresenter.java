package com.voyager.barasti.activity.splashscreen.presenter;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.voyager.barasti.activity.login.model.UserDetails;
import com.voyager.barasti.activity.splashscreen.view.ISplashView;


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

    private int SPLASH_DISPLAY_LENGTH = 1000;

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
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //splashView.moveToLanding();
                if(emailAddress!=null&&emailAddress.length()>0){
                    splashView.moveToLanding();
                }else{
                    splashView.moveToSignUpLogin();
                }
                /*if(Helper.isLocationEnabled(context)) {

                    if(emailAddress.length()>0){

                    }else{
                        splashView.moveToSignUpLogin();
                    }
                }else {
                    Helper.toEnabledLocation(context,activity);
                }*/
            }
        },SPLASH_DISPLAY_LENGTH);
    }
}
