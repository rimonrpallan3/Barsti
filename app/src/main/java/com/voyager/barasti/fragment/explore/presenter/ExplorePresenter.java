package com.voyager.barasti.fragment.explore.presenter;

import android.app.Activity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.voyager.barasti.R;
import com.voyager.barasti.fragment.explore.model.ExploreFooter.FooterItems;
import com.voyager.barasti.fragment.explore.model.ExploreHeader.HeaderItem;
import com.voyager.barasti.fragment.explore.model.ExploreHeader.HeaderNewItem;
import com.voyager.barasti.fragment.explore.model.ExploreType.TypeBody;
import com.voyager.barasti.fragment.explore.model.ExploreType.TypeList;
import com.voyager.barasti.fragment.explore.model.exploreList.ExploreItems;
import com.voyager.barasti.fragment.explore.model.exploreList.HouseList;
import com.voyager.barasti.fragment.explore.model.ExploreFooter.LocItems;
import com.voyager.barasti.fragment.explore.model.exploreList.NewList;
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

public class ExplorePresenter implements IExplorePresenter {

    IExploreView iExploreView;
    ArrayList<HouseList> houseLists;
    NewList newList;
    HouseList houseList;
    ArrayList<LocItems> locItemsArrayList;
    LocItems locItems;
    Gson gson;

    public ExplorePresenter(IExploreView iExploreView) {
        this.iExploreView = iExploreView;
        gson = new Gson();
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
        Call<NewList> call = webServices.doGetHouseList();
        call.enqueue(new Callback<NewList>() {
            @Override
            public void onResponse(Call<NewList> call, Response<NewList> response) {
                newList = response.body();

                String json = new Gson().toJson(newList);

                System.out.println("ExplorePresenter getHomeListPresenter json : " + json);

                for(int i=0; i<newList.getTypeLists().size();i++){
                    TypeList typeList = newList.getTypeLists().get(i);
                    if(typeList.getName()==""){
                        typeList.setImgId(R.drawable.apartment);
                    }else  if(typeList.getName()==""){
                        typeList.setImgId(R.drawable.penthouse);
                    }else  if(typeList.getName()==""){
                        typeList.setImgId(R.drawable.villa);
                    }
                    newList.getTypeLists().add(typeList);

                }


                TypeBody typeItems = new TypeBody();
                typeItems.setHeadingTitile("Type List");
                typeItems.setTypeLists(newList.getTypeLists());
                typeItems.setViewType(1);
                landingListItems.add(typeItems);

                ExploreItems yourTripItem = new ExploreItems();
                yourTripItem.setMainHeading("Top Rated Homes");
                yourTripItem.setNewList(newList);
                yourTripItem.setHouseList(newList.getHouseLists());
                yourTripItem.setViewType(2);
                landingListItems.add(yourTripItem);

                Call<ArrayList<LocItems>> calls = webServices.doGetLocList();
                calls.enqueue(new Callback<ArrayList<LocItems>>() {
                    @Override
                    public void onResponse(Call<ArrayList<LocItems>> call, Response<ArrayList<LocItems>> response) {
                        locItemsArrayList = response.body();
                        FooterItems footerItems = new FooterItems();
                        footerItems.setHeadingTitile("Location");
                        footerItems.setLocItemsList(locItemsArrayList);
                        footerItems.setViewType(3);
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
            public void onFailure(Call<NewList> call, Throwable t) {

                t.printStackTrace();
                //Toast.makeText((Context) iRegisterView, "ErrorMessage"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }


}
