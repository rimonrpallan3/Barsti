package com.voyager.barasti.activity.login.view;

import com.voyager.barasti.activity.login.model.UserDetails;

import io.reactivex.disposables.Disposable;

/**
 * Created by User on 23-Jan-19.
 */

public interface ILoginView {
    void setLoader(int visibility);
    void onSetProgressBarVisibility(int visibility);
    void onLoginResult(Boolean result, int code);
    void onLoginResponse(Boolean result, int code);
    void sendPParcelableObj(UserDetails userDetails);
    void unSubscribeCalls(Disposable dMainListObservable);
}
