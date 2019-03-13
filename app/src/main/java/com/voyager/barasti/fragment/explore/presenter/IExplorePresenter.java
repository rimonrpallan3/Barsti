package com.voyager.barasti.fragment.explore.presenter;

import com.voyager.barasti.activity.landingpage.view.ILandingView;
import com.voyager.barasti.fragment.explore.model.exploreList.MainList;

/**
 * Created by User on 27-Dec-18.
 */

public interface IExplorePresenter {


    void getDetails(int userID);
    void getMainRefreshList(int userID);
    void updatePropertyList(int totalCount);
    void btnLiked(Integer userID,Integer propertyId);
    void btnUnliked(Integer userID,Integer propertyId);
}
