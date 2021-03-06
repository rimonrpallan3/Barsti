package com.voyager.barasti.activity.typelist.view;

import com.voyager.barasti.activity.typelist.model.TypedDetail;

import io.reactivex.disposables.Disposable;

/**
 * Created by User on 11-Jan-19.
 */

public interface ITypeView {
    void setTypedAdapterList(TypedDetail typedAdapterList);
    void unSubscribeCalls(Disposable dMainListObservable);
}
