package com.voyager.barasti.activity.locationListPropety.view;

import com.voyager.barasti.activity.locationListPropety.model.LocDetails;

import java.util.ArrayList;

import io.reactivex.disposables.Disposable;

/**
 * Created by User on 04-Mar-19.
 */

public interface ILocationView {
    void setLocListAdapterList(ArrayList<LocDetails> locDetails);
    void unSubscribeCalls(Disposable dMainListObservable);
}
