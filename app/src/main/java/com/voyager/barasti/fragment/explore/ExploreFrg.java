package com.voyager.barasti.fragment.explore;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.voyager.barasti.R;
import com.voyager.barasti.fragment.explore.adapter.ExploreListAdapter;
import com.voyager.barasti.fragment.explore.model.ExploreFooter.FooterItems;
import com.voyager.barasti.fragment.explore.model.ExploreFooter.LocList;
import com.voyager.barasti.fragment.explore.model.ExploreHeader.HeaderItem;
import com.voyager.barasti.fragment.explore.model.exploreList.BodyItems;
import com.voyager.barasti.fragment.explore.model.exploreList.ExploreItems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by User on 18-Dec-18.
 */

public class ExploreFrg extends Fragment implements ExploreListAdapter.ClickListener {

    private Activity activity;

    RecyclerView rvExploreList;
    ExploreListAdapter exploreListAdapter;

    public static final int HEADER_TYPE=0;
    public static final int BODY_TYPE=1;
    public static final int FOOTER_TYPE=2;


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

        rvExploreList = rootView.findViewById(R.id.rvExplore);
        exploreListAdapter = new ExploreListAdapter(getData(), getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvExploreList.setLayoutManager(mLayoutManager);
        rvExploreList.setItemAnimator(new DefaultItemAnimator());
        rvExploreList.setAdapter(exploreListAdapter);
        rvExploreList.setLayoutFrozen(true);
        //exploreListAdapter.setClickListener(this);

        return rootView;
    }

    List<ExploreItems> landingListItems = Arrays.asList();

    public List<ExploreItems> getData() {

        landingListItems = new ArrayList<ExploreItems>();
        landingListItems.clear();

        HeaderItem headerItem = new HeaderItem();
        headerItem.setImgHeader(R.drawable.barasti_home_banner);
        headerItem.setBtnContent("Explore Homes >");
        // headerItem.setEnabled(true);
        landingListItems.add(headerItem);

        FooterItems footerItems = new FooterItems();
        footerItems.setHeadingTitile("Location");
        footerItems.setID(1);
        footerItems.setLocLists(getLocs());
        landingListItems.add(footerItems);

        ExploreItems yourTripItem = new ExploreItems();
        yourTripItem.setMainHeading("Top Rated Homes");
        yourTripItem.setBodyItemsList(getDatas());
        yourTripItem.setID(1);
        yourTripItem.setEnabled(true);
        landingListItems.add(yourTripItem);






        return landingListItems;
    }

    List<BodyItems> bodyItemsList = Arrays.asList();

    public List<BodyItems> getDatas() {

        bodyItemsList = new ArrayList<BodyItems>();
        bodyItemsList.clear();

        BodyItems homeBodyItems = new BodyItems();
        homeBodyItems.setImgHome(R.drawable.placeholder_image);
        homeBodyItems.setHeading("George home");
        homeBodyItems.setAmtHome("100BD per Night");
        homeBodyItems.setFavRate("192");
        homeBodyItems.setFavRatio("3.5");
        homeBodyItems.setId(1);
        homeBodyItems.setEnabled(true);
        bodyItemsList.add(homeBodyItems);


        BodyItems homeBodyItems2 = new BodyItems();
        homeBodyItems2.setImgHome(R.drawable.placeholder_image);
        homeBodyItems2.setHeading("George home");
        homeBodyItems2.setAmtHome("100BD per Night");
        homeBodyItems2.setFavRate("192");
        homeBodyItems2.setFavRatio("3.5");
        homeBodyItems2.setId(2);
        homeBodyItems2.setEnabled(true);
        bodyItemsList.add(homeBodyItems2);

        BodyItems homeBodyItems3 = new BodyItems();
        homeBodyItems3.setImgHome(R.drawable.placeholder_image);
        homeBodyItems3.setHeading("George home");
        homeBodyItems3.setAmtHome("100BD per Night");
        homeBodyItems3.setFavRate("192");
        homeBodyItems3.setFavRatio("3.5");
        homeBodyItems3.setId(3);
        homeBodyItems3.setEnabled(true);
        bodyItemsList.add(homeBodyItems3);

        BodyItems homeBodyItems4 = new BodyItems();
        homeBodyItems4.setImgHome(R.drawable.placeholder_image);
        homeBodyItems4.setHeading("George home");
        homeBodyItems4.setAmtHome("100BD per Night");
        homeBodyItems4.setFavRate("192");
        homeBodyItems4.setFavRatio("3.5");
        homeBodyItems4.setId(4);
        homeBodyItems4.setEnabled(true);
        bodyItemsList.add(homeBodyItems4);

        return bodyItemsList;
    }

    List<LocList> locLists = Arrays.asList();

    public List<LocList> getLocs() {

        locLists = new ArrayList<LocList>();
        locLists.clear();

        LocList locList1 = new LocList();
        locList1.setIdImg(R.drawable.placeholder_image);
        locList1.setImgHeading("India");
        locList1.setId(1);
        locList1.setEnabled(true);
        locLists.add(locList1);


        LocList locList2 = new LocList();
        locList2.setIdImg(R.drawable.placeholder_image);
        locList2.setImgHeading("Kerala");
        locList2.setId(2);
        locList2.setEnabled(true);
        locLists.add(locList2);

        LocList locList3 = new LocList();
        locList3.setIdImg(R.drawable.placeholder_image);
        locList2.setImgHeading("Kumbalangi");
        locList3.setId(3);
        locList3.setEnabled(true);
        locLists.add(locList3);

        return locLists;
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

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

    }

    @Override
    public void itemClicked(View view, int position) {

    }

}