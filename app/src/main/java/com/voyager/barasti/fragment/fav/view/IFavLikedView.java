package com.voyager.barasti.fragment.fav.view;

import com.voyager.barasti.fragment.fav.model.FavDetail;

import java.util.ArrayList;

/**
 * Created by User on 11-Jan-19.
 */

public interface IFavLikedView {
    void setFavAdapterList(ArrayList<FavDetail> typedAdapterList);
    void setDefaultImg();
}
