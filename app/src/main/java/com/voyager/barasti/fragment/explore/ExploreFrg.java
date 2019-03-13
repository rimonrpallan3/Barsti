package com.voyager.barasti.fragment.explore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.voyager.barasti.R;
import com.voyager.barasti.activity.landingpage.view.ILandingView;
import com.voyager.barasti.activity.login.model.UserDetails;
import com.voyager.barasti.fragment.explore.adapter.ExploreListAdapter;
import com.voyager.barasti.fragment.explore.model.ExploreFooter.FooterItems;
import com.voyager.barasti.fragment.explore.model.ExploreFooter.LocList;
import com.voyager.barasti.fragment.explore.model.ExploreHeader.HeaderItem;
import com.voyager.barasti.fragment.explore.model.exploreList.BodyItems;
import com.voyager.barasti.fragment.explore.model.exploreList.ExploreItems;
import com.voyager.barasti.fragment.explore.model.exploreList.HouseList;
import com.voyager.barasti.fragment.explore.model.exploreList.MainList;
import com.voyager.barasti.fragment.explore.presenter.ExplorePresenter;
import com.voyager.barasti.fragment.explore.presenter.IExplorePresenter;
import com.voyager.barasti.fragment.explore.view.IExploreView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

import static android.app.Activity.RESULT_OK;

/**
 * Created by User on 18-Dec-18.
 */

public class ExploreFrg extends Fragment implements ExploreListAdapter.ClickListener, IExploreView {

    private Activity activity;

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_FOOTER = 3;
    private static final int TYPE_TYPE = 1;
    private static final int TYPE_BODY = 2;

    RecyclerView rvExploreList;
    ExploreListAdapter exploreListAdapter;

    IExplorePresenter explorePresenter;
    Bundle bundle;
    MainList mainList;
    UserDetails userDetails;
    Disposable dMainListObservable;
    Boolean updateExpUi= false;
    ILandingView iLandingView;

    public ExploreFrg() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_explore, container, false);
        activity = getActivity();
        bundle = this.getArguments();
        rvExploreList = rootView.findViewById(R.id.rvExplore);
        explorePresenter = new ExplorePresenter(this, getActivity(), iLandingView);
        if (bundle != null) {
            try {
                userDetails = bundle.getParcelable("UserDetails");
                System.out.println("ExploreFrg onCreateView updateExpUi : "+updateExpUi);
                explorePresenter.getDetails(userDetails.getId());
                System.out.println("user Id : " + userDetails.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Bundle Is null ");
        }


        //explorePresenter.getHomeListPresenter();


        //exploreListAdapter.setClickListener(this);

        return rootView;
    }

    ArrayList<ExploreItems> landingListItems = new ArrayList<>();

    public ArrayList<ExploreItems> getData() {

        landingListItems = new ArrayList<ExploreItems>();
        landingListItems.clear();

        HeaderItem headerItem = new HeaderItem();
        headerItem.setImgHeader(R.drawable.barasti_home_banner);
        headerItem.setBtnContent("Explore Homes >");
        headerItem.setViewType(0);
        landingListItems.add(headerItem);


        ExploreItems yourTripItem = new ExploreItems();
        yourTripItem.setMainHeading("Top Rated Homes");
        yourTripItem.setBodyItemsList(getDatas());
        yourTripItem.setViewType(1);
        landingListItems.add(yourTripItem);

        FooterItems footerItems = new FooterItems();
        footerItems.setHeadingTitile("Location");
        footerItems.setLocLists(getLocs());
        footerItems.setViewType(2);
        landingListItems.add(footerItems);

        return landingListItems;
    }

    ArrayList<BodyItems> bodyItemsList = new ArrayList<>();

    public ArrayList<BodyItems> getDatas() {

        bodyItemsList = new ArrayList<BodyItems>();
        bodyItemsList.clear();

        BodyItems homeBodyItems = new BodyItems();
        homeBodyItems.setImgHome(R.drawable.placeholder_image);
        homeBodyItems.setHeading("George home");
        homeBodyItems.setAmtHome("100BD per Night");
        homeBodyItems.setFavRate("192");
        homeBodyItems.setFavRatio("3.5");
        bodyItemsList.add(homeBodyItems);


        BodyItems homeBodyItems2 = new BodyItems();
        homeBodyItems2.setImgHome(R.drawable.placeholder_image);
        homeBodyItems2.setHeading("George home");
        homeBodyItems2.setAmtHome("100BD per Night");
        homeBodyItems2.setFavRate("192");
        homeBodyItems2.setFavRatio("3.5");
        bodyItemsList.add(homeBodyItems2);

        BodyItems homeBodyItems3 = new BodyItems();
        homeBodyItems3.setImgHome(R.drawable.placeholder_image);
        homeBodyItems3.setHeading("George home");
        homeBodyItems3.setAmtHome("100BD per Night");
        homeBodyItems3.setFavRate("192");
        homeBodyItems3.setFavRatio("3.5");
        bodyItemsList.add(homeBodyItems3);

        BodyItems homeBodyItems4 = new BodyItems();
        homeBodyItems4.setImgHome(R.drawable.placeholder_image);
        homeBodyItems4.setHeading("George home");
        homeBodyItems4.setAmtHome("100BD per Night");
        homeBodyItems4.setFavRate("192");
        homeBodyItems4.setFavRatio("3.5");
        bodyItemsList.add(homeBodyItems4);

        return bodyItemsList;
    }

    ArrayList<LocList> locLists = new ArrayList<>();

    public ArrayList<LocList> getLocs() {

        locLists = new ArrayList<LocList>();
        locLists.clear();

        LocList locList1 = new LocList();
        locList1.setIdImg(R.drawable.prefered_location);
        locList1.setImgHeading("India");
        locLists.add(locList1);


        LocList locList2 = new LocList();
        locList2.setIdImg(R.drawable.prefered_location);
        locList2.setImgHeading("Kerala");
        locLists.add(locList2);

        LocList locList3 = new LocList();
        locList3.setIdImg(R.drawable.prefered_location);
        locList3.setImgHeading("Kumbalangi");
        locLists.add(locList3);

        return locLists;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String UpdateHome = data.getStringExtra("UpdateHome");
                if (UpdateHome != null) {
                    explorePresenter.getMainRefreshList(userDetails.getId());
                }
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            iLandingView = (ILandingView) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        /*landing_search_filter_language_recycleView.setOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView,
                                             int newState) {
                // TODO Auto-generated method stub
                if (newState < 1) {

                } else {

                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                // TODO Auto-generated method stub
                if (dy > 0) {

                } else {

                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });
*/
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (dMainListObservable != null)
            dMainListObservable.dispose();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

    }

    @Override
    public void itemClicked(View view, int position) {

    }


    @Override
    public void setHomeList(ArrayList<ExploreItems> exploreItems) {
        exploreListAdapter = new ExploreListAdapter(exploreItems, getActivity(), explorePresenter, userDetails.getId());
        rvExploreList.setLayoutFrozen(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvExploreList.setLayoutManager(mLayoutManager);
        rvExploreList.setItemAnimator(new DefaultItemAnimator());
        rvExploreList.setAdapter(exploreListAdapter);
    }

    @Override
    public void setRefreshHomeList(ArrayList<ExploreItems> exploreItems) {
        exploreListAdapter = new ExploreListAdapter(exploreItems, getActivity(), explorePresenter, userDetails.getId());
        rvExploreList.setLayoutFrozen(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvExploreList.setLayoutManager(mLayoutManager);
        rvExploreList.setItemAnimator(new DefaultItemAnimator());
        rvExploreList.setAdapter(exploreListAdapter);
    }


    @Override
    public void updatePropertyList(List<HouseList> houseListArrayList) {
        for (int i = 0; i < houseListArrayList.size(); i++) {
            HouseList houseList = houseListArrayList.get(i);
            exploreListAdapter.addHouse(houseList);
        }
    }

    public void updateApiCall() {

    }

    @Override
    public void unSubscribeCalls(Disposable dMainListObservable) {
        this.dMainListObservable = dMainListObservable;
    }
}