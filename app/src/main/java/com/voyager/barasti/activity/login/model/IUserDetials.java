package com.voyager.barasti.activity.login.model;

/**
 * Created by rimon on 18-03-2018.
 */

public interface IUserDetials {
    int checkUserValidity(String name, String passwd);
    int validateLoginResponseError(String errorMsg);

}
