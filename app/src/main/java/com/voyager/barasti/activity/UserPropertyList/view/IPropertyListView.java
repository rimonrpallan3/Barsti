package com.voyager.barasti.activity.UserPropertyList.view;

import com.voyager.barasti.activity.UserPropertyList.model.UserPropertyDetails;

import io.reactivex.disposables.Disposable;

/**
 * Created by User on 06-Mar-19.
 */

public interface IPropertyListView {
    void setProperties(UserPropertyDetails userPropertyDetails);
    void unSubscribeCalls(Disposable dMainListObservable);
}
