package com.voyager.barasti.activity.register.presenter;

import com.voyager.barasti.activity.register.model.DOBDetails;

/**
 * Created by User on 19-Feb-19.
 */

public interface IRegisterPresenter {
    void doRegister(String FirstName, String LastName, String Password,String RetypePassword, String email,String phno,String dob);
    void onRegisteredSucuess();
}
