package com.voyager.barasti.activity.PriceDetailPage.view;

import com.voyager.barasti.activity.PriceDetailPage.model.PriceDetails;

import io.reactivex.disposables.Disposable;

/**
 * Created by User on 26-Feb-19.
 */

public interface IPriceView {

    void setPriceDetails(PriceDetails priceDetails);
    void unSubscribeCalls(Disposable dMainListObservable);
}
