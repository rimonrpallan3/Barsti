package com.voyager.barasti.activity.locationListPropety.presenter;

/**
 * Created by User on 04-Mar-19.
 */

public interface ILocationPresenter {
    void getLoclist(String locName,int userID);
    void btnLiked(Integer userID,Integer propertyId);
    void btnUnliked(Integer userID,Integer propertyId);
}
