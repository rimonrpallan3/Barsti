package com.voyager.barasti.fragment.explore.presenter;

import com.voyager.barasti.fragment.explore.model.exploreList.MainList;

/**
 * Created by User on 27-Dec-18.
 */

public interface IExplorePresenter {


    void setMainList(MainList mainList);
    void updatePropertyList(int totalCount);
    void btnLiked(Integer userID,Integer propertyId);
    void btnUnliked(Integer userID,Integer propertyId);
}
