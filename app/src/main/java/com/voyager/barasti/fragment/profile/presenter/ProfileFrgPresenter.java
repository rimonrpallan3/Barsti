package com.voyager.barasti.fragment.profile.presenter;

import android.app.Activity;

import com.voyager.barasti.fragment.profile.view.IProfileFragView;

/**
 * Created by User on 29-Jan-19.
 */

public class ProfileFrgPresenter implements IProfileFrgPresenter{

    IProfileFragView iProfileFragView;
    Activity activity;


    public ProfileFrgPresenter(IProfileFragView iProfileFragView, Activity activity) {
        this.iProfileFragView = iProfileFragView;
        this.activity = activity;
    }
}
