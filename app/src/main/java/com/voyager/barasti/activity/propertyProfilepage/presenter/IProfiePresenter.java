package com.voyager.barasti.activity.propertyProfilepage.presenter;

import com.google.android.gms.maps.MapView;

/**
 * Created by User on 09-Jan-19.
 */

public interface IProfiePresenter {

    public void getHomeData(int houseId,int userId);
    public void setMapView(MapView mvHouseDetail);

    void btnLiked(Integer userID,Integer propertyId);
    void btnUnliked(Integer userID,Integer propertyId);
}
