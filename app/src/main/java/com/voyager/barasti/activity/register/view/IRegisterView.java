package com.voyager.barasti.activity.register.view;

import com.voyager.barasti.activity.login.model.UserDetails;

/**
 * Created by User on 19-Feb-19.
 */

public interface IRegisterView {
    void onRegister(Boolean result, int code);
    void onRegistered(Boolean result, int code);
    void sendPParcelableObj(UserDetails userDetails);
}
