package com.voyager.barasti.landingpage.presenter;

import android.app.Activity;

import com.voyager.barasti.landingpage.view.ILandingView;


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




}
