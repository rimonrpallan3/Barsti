package com.voyager.barasti.activity.landingpage.view;

import com.voyager.barasti.fragment.explore.model.exploreList.MainList;

import io.reactivex.disposables.Disposable;

/**
 * Created by User on 8/29/2017.
 */

public interface ILandingView {

    //----- Methods to be set for the Map Fragment side  -----------
    void hideVisibilityLandingItems(int visibility, String value);

    void unSubscribeCalls(Disposable dMainListObservable);


}
