package com.voyager.barasti.fragment.explore.presenter;

import android.app.Activity;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.voyager.barasti.R;
import com.voyager.barasti.fragment.explore.model.ExploreFooter.FooterItems;
import com.voyager.barasti.fragment.explore.model.ExploreHeader.Banner;
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

import java.io.IOException;
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
    ArrayList<TypeList> typeLists;
    LocItems locItems;
    Gson gson;
    Activity activity;
    ArrayList<Banner> bannerArrayList;
    private static final Integer[] IMAGES= {R.drawable.placeholder_image,R.drawable.placeholder_image,R.drawable.placeholder_image,R.drawable.placeholder_image};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();

    public ExplorePresenter(IExploreView iExploreView,Activity activity) {
        this.iExploreView = iExploreView;
        this.activity = activity;
        gson = new Gson();
    }

    ArrayList<ExploreItems> landingListItems = new ArrayList<>();


    @Override
    public void getHomeListPresenter() {
        for(int i=0;i<IMAGES.length;i++) {
            ImagesArray.add(IMAGES[i]);
        }
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Call<ArrayList<Banner>> calls = webServices.doGetbannerlist();
        calls.enqueue(new Callback<ArrayList<Banner>>() {
            @Override
            public void onResponse(Call<ArrayList<Banner>> call, Response<ArrayList<Banner>> response) {
                bannerArrayList = response.body();
                landingListItems = new ArrayList<ExploreItems>();
                landingListItems.clear();
                HeaderItem headerItem = new HeaderItem();
                headerItem.setImgHeader(R.drawable.barasti_home_banner);
                headerItem.setBtnContent("Explore Homes >");
                headerItem.setBanners(bannerArrayList);
                headerItem.setViewType(0);
                landingListItems.add(headerItem);

                Call<NewList> call1 = webServices.doGetHouseList();
                call1.enqueue(new Callback<NewList>() {
                    @Override
                    public void onResponse(Call<NewList> call, Response<NewList> response) {
                        newList = response.body();

                        String json = new Gson().toJson(newList);
                        System.out.println("ExplorePresenter getHomeListPresenter json : " + json);

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
                                if (t instanceof IOException) {
                                    Toast.makeText(activity, "this is an actual network failure :( inform the user and possibly retry", Toast.LENGTH_SHORT).show();
                                    // logging probably not necessary
                                }
                                else {
                                    Toast.makeText(activity, "conversion issue! big problems :(", Toast.LENGTH_SHORT).show();
                                    // todo log to some central bug tracking service
                                }
                                t.printStackTrace();
                                //Toast.makeText((Context) iRegisterView, "ErrorMessage"+t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });


                    }

                    @Override
                    public void onFailure(Call<NewList> call, Throwable t) {
                        if (t instanceof IOException) {
                            Toast.makeText(activity, "this is an actual network failure :( inform the user and possibly retry", Toast.LENGTH_SHORT).show();
                            // logging probably not necessary
                        }
                        else {
                            Toast.makeText(activity, "conversion issue! big problems :(", Toast.LENGTH_SHORT).show();
                            // todo log to some central bug tracking service
                        }
                        t.printStackTrace();
                        //Toast.makeText((Context) iRegisterView, "ErrorMessage"+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onFailure(Call<ArrayList<Banner>> call, Throwable t) {
                if (t instanceof IOException) {
                    Toast.makeText(activity, "this is an actual network failure :( inform the user and possibly retry", Toast.LENGTH_SHORT).show();
                    // logging probably not necessary
                }
                else {
                    Toast.makeText(activity, "conversion issue! big problems :(", Toast.LENGTH_SHORT).show();
                    // todo log to some central bug tracking service
                }
                t.printStackTrace();
                //Toast.makeText((Context) iRegisterView, "ErrorMessage"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });







    }


}
