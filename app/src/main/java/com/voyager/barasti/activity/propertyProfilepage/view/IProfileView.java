package com.voyager.barasti.activity.propertyProfilepage.view;

import com.google.android.gms.maps.MapView;
import com.voyager.barasti.activity.propertyProfilepage.model.HomeDetails;

import io.reactivex.disposables.Disposable;

/**
 * Created by User on 09-Jan-19.
 */

public interface IProfileView {

    void setHomeDetail(HomeDetails homeDetail);
    void setMapViewP(MapView mvHouseDetail);
    void unSubscribeCalls(Disposable dMainListObservable);
}
