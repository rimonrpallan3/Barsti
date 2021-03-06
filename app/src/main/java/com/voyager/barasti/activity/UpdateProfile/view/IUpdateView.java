package com.voyager.barasti.activity.UpdateProfile.view;

import io.reactivex.disposables.Disposable;

/**
 * Created by User on 22-Feb-19.
 */

public interface IUpdateView {

    //void onRegister(Boolean result, int code);
   // void onRegistered(Boolean result, int code);
    void onUpdateValidate(Boolean result, int code);
    void onUpdateResponse(Boolean result, int code);
    void unSubscribeCalls(Disposable dMainListObservable);
}
