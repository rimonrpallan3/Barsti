package com.voyager.barasti.activity.profilepage.presenter;

import com.google.android.gms.maps.MapView;
import com.voyager.barasti.fragment.explore.model.exploreList.HouseList;

/**
 * Created by User on 09-Jan-19.
 */

public interface IProfiePresenter {

    public void getHomeData(int houseId);
    public void setMapView(MapView mvHouseDetail);
}
