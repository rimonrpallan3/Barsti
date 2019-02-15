package com.voyager.barasti.activity.typelist.presenter;

import com.voyager.barasti.activity.typelist.TypeListActivity;
import com.voyager.barasti.fragment.explore.model.ExploreType.TypeList;

/**
 * Created by User on 11-Jan-19.
 */

public interface ITypeListPresenter {
    public void getTypedAptData(TypeList typeList);

    void btnLiked(Integer userID,Integer propertyId);
    void btnUnliked(Integer userID,Integer propertyId);
}
