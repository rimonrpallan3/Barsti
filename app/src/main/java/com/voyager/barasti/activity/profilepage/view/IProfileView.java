package com.voyager.barasti.activity.profilepage.view;

import com.google.android.gms.maps.MapView;
import com.voyager.barasti.activity.profilepage.model.HomeDetails;

/**
 * Created by User on 09-Jan-19.
 */

public interface IProfileView {

    void setHomeDetail(HomeDetails homeDetail);
    void setMapViewP(MapView mvHouseDetail);
}
