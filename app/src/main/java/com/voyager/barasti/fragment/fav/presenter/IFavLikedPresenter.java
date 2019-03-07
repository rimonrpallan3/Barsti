package com.voyager.barasti.fragment.fav.presenter;

import com.voyager.barasti.fragment.explore.model.ExploreType.TypeList;
import com.voyager.barasti.fragment.fav.model.FavDetail;

/**
 * Created by User on 11-Jan-19.
 */

public interface IFavLikedPresenter {
    void getFavLikedData(int userId);
    void btnLiked(Integer userID, Integer propertyId);
    void btnUnliked(Integer userID, Integer propertyId);
    void setDefaultImg();
}
