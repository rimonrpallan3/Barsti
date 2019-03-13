package com.voyager.barasti.fragment.explore.view;

import com.voyager.barasti.fragment.explore.model.exploreList.ExploreItems;
import com.voyager.barasti.fragment.explore.model.exploreList.HouseList;
import com.voyager.barasti.fragment.explore.model.ExploreFooter.LocItems;
import com.voyager.barasti.fragment.explore.model.exploreList.MainList;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by User on 27-Dec-18.
 */

public interface IExploreView {
    void setHomeList(ArrayList<ExploreItems> exploreItems);
    void setRefreshHomeList(ArrayList<ExploreItems> exploreItems);
    void updatePropertyList(List<HouseList> houseListArrayList);
    void unSubscribeCalls(Disposable dMainListObservable);
}
