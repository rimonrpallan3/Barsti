package com.voyager.barasti.fragment.explore.presenter;

import com.voyager.barasti.R;
import com.voyager.barasti.fragment.explore.model.ExploreFooter.FooterItems;
import com.voyager.barasti.fragment.explore.model.ExploreHeader.HeaderItem;
import com.voyager.barasti.fragment.explore.model.ExploreHeader.HeaderNewItem;
import com.voyager.barasti.fragment.explore.model.exploreList.ExploreItems;
import com.voyager.barasti.fragment.explore.model.exploreList.HouseList;
import com.voyager.barasti.fragment.explore.model.ExploreFooter.LocItems;
import com.voyager.barasti.fragment.explore.view.IExploreView;
import com.voyager.barasti.webservices.ApiClient;
import com.voyager.barasti.webservices.WebServices;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by User on 27-Dec-18.
 */

public class ExplorePresenter implements IExplorePresenter{

    IExploreView iExploreView;
    ArrayList<HouseList> houseLists;
    HouseList houseList;
    ArrayList<LocItems> locItemsArrayList;
    LocItems locItems;

    public ExplorePresenter(IExploreView iExploreView) {
        this.iExploreView = iExploreView;

    }
        ArrayList<ExploreItems> landingListItems = new ArrayList<>();




    @Override
    public void getHomeListPresenter() {
        landingListItems = new ArrayList<ExploreItems>();
        landingListItems.clear();
        HeaderItem headerItem = new HeaderItem();
        headerItem.setImgHeader(R.drawable.barasti_home_banner);
        headerItem.setBtnContent("Explore Homes >");
        headerItem.setViewType(0);
        landingListItems.add(headerItem);

        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Call<ArrayList<HouseList>> call = webServices.doGetHouseList();
        call.enqueue(new Callback<ArrayList<HouseList>>() {
            @Override
            public void onResponse(Call<ArrayList<HouseList>> call, Response<ArrayList<HouseList>> response) {
                houseLists  =  response.body();

                ExploreItems yourTripItem = new ExploreItems();
                yourTripItem.setMainHeading("Top Rated Homes");
                yourTripItem.setHouseList(houseLists);
                yourTripItem.setViewType(1);
                landingListItems.add(yourTripItem);

                Call<ArrayList<LocItems>> calls = webServices.doGetLocList();
                calls.enqueue(new Callback<ArrayList<LocItems>>() {
                    @Override
                    public void onResponse(Call<ArrayList<LocItems>> call, Response<ArrayList<LocItems>> response) {
                        locItemsArrayList  =  response.body();
                        FooterItems footerItems = new FooterItems();
                        footerItems.setHeadingTitile("Location");
                        footerItems.setLocItemsList(locItemsArrayList);
                        footerItems.setViewType(2);
                        landingListItems.add(footerItems);

                        iExploreView.setHomeList(landingListItems);
                    }

                    @Override
                    public void onFailure(Call<ArrayList<LocItems>> call, Throwable t) {

                        t.printStackTrace();
                        //Toast.makeText((Context) iRegisterView, "ErrorMessage"+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }

            @Override
            public void onFailure(Call<ArrayList<HouseList>> call, Throwable t) {

                t.printStackTrace();
                //Toast.makeText((Context) iRegisterView, "ErrorMessage"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }


}
