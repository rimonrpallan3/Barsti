package com.voyager.barasti.activity.calenderactivity.pesenter;

import android.app.Activity;

import com.voyager.barasti.activity.calenderactivity.view.ICalenderView;

/**
 * Created by User on 14-Feb-19.
 */

public class CalenderPresenter implements ICalenderPresenter {

    Activity activity;
    ICalenderView iCalenderView;

    public CalenderPresenter(Activity activity, ICalenderView iCalenderView) {
        this.activity = activity;
        this.iCalenderView = iCalenderView;
    }

    @Override
    public void saveBookingDetails(String startDate, String EndDate, int userID, int propertyID) {

    }
}
