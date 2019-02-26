package com.voyager.barasti.activity.gestCountPage.presenter;

import android.app.Activity;

import com.voyager.barasti.activity.gestCountPage.view.IGuestView;

/**
 * Created by User on 25-Feb-19.
 */

public class GuestPresenter implements  IGuestPresenter{

    Activity activity;
    IGuestView iGuestView;

    public GuestPresenter(Activity activity, IGuestView iGuestView) {
        this.activity = activity;
        this.iGuestView = iGuestView;
    }

    @Override
    public void setCurrentGuestCount(Integer count) {
        iGuestView.getGuestCount(count);
    }
}
