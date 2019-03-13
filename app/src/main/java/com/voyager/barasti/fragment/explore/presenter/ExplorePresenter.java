package com.voyager.barasti.fragment.explore.presenter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.voyager.barasti.R;
import com.voyager.barasti.activity.landingpage.view.ILandingView;
import com.voyager.barasti.fragment.explore.model.ExploreFooter.FooterItems;
import com.voyager.barasti.fragment.explore.model.ExploreHeader.Banner;
import com.voyager.barasti.fragment.explore.model.ExploreHeader.HeaderItem;
import com.voyager.barasti.fragment.explore.model.ExploreType.TypeBody;
import com.voyager.barasti.fragment.explore.model.ExploreType.TypeList;
import com.voyager.barasti.fragment.explore.model.exploreList.ExploreItems;
import com.voyager.barasti.fragment.explore.model.exploreList.HouseList;
import com.voyager.barasti.fragment.explore.model.ExploreFooter.LocItems;
import com.voyager.barasti.fragment.explore.model.exploreList.LikeUnLike;
import com.voyager.barasti.fragment.explore.model.exploreList.MainList;
import com.voyager.barasti.fragment.explore.view.IExploreView;
import com.voyager.barasti.webservices.ApiClient;
import com.voyager.barasti.webservices.WebServices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
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
    MainList mainList;
    HouseList houseList;
    List<LocItems> locItemsArrayList;
    ArrayList<HouseList> houseListArrayList;
    LocItems locItems;
    Gson gson;
    Activity activity;
    ArrayList<Banner> bannerArrayList;
    private static final Integer[] IMAGES= {R.drawable.placeholder_image,R.drawable.placeholder_image,R.drawable.placeholder_image,R.drawable.placeholder_image};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();

    int limit = 2;
    int locLimit = 2;
    int offset = 0;
    int locOffset = 0;
    int propertyId   = 0;
    Boolean updateExpUi = false;
    ILandingView iLandingView;

    public ExplorePresenter(IExploreView iExploreView,Activity activity,ILandingView iLandingView) {
        this.iExploreView = iExploreView;
        this.activity = activity;
        this.iLandingView = iLandingView;
        gson = new Gson();
    }
    ArrayList<ExploreItems> landingListItems = new ArrayList<>();

    public void getDetails(int userId) {
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Observable<MainList> mainListObservable = webServices.doGetDetails1(userId);
        mainListObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( getMainListOnStart());
    }

    private Observer<MainList> getMainListOnStart() {
        return new Observer<MainList>() {

            @Override
            public void onSubscribe(Disposable d) {
                iExploreView.unSubscribeCalls(d);
                Log.d("LandingPresenter", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(MainList value) {
                MainList mainList = value;

                HeaderItem headerItem = new HeaderItem();
                headerItem.setImgHeader(R.drawable.barasti_home_banner);
                headerItem.setBtnContent("Explore Homes >");
                headerItem.setBanners(mainList.getSliders());
                headerItem.setViewType(0);
                landingListItems.add(headerItem);
                String json2 = new Gson().toJson(mainList.getSliders());
                //System.out.println("ExplorePresenter getSliders() json2 : " + json2);

                TypeBody typeItems = new TypeBody();
                typeItems.setHeadingTitile("Property Types");
                typeItems.setTypeLists(mainList.getTypes());
                typeItems.setViewType(1);
                landingListItems.add(typeItems);


                String json3 = new Gson().toJson(mainList.getTypes());
                System.out.println("ExplorePresenter getTypes() json 3: " + json3);

                ExploreItems yourTripItem = new ExploreItems();
                yourTripItem.setMainHeading("Top Rated Homes");
                yourTripItem.setMainList(mainList);
                yourTripItem.setHouseList(mainList.getProperties());
                yourTripItem.setViewType(2);
                landingListItems.add(yourTripItem);


                String json4 = new Gson().toJson(mainList.getProperties());
                System.out.println("ExplorePresenter getProperties() json4 : " + json4);


                locItemsArrayList = mainList.getLocations();
                FooterItems footerItems = new FooterItems();
                footerItems.setHeadingTitile("Location");
                footerItems.setLocItemsList(locItemsArrayList);
                footerItems.setViewType(3);
                landingListItems.add(footerItems);
                iExploreView.setHomeList(landingListItems);

                Log.d("LandingPresenter", " onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("LandingPresenter", " onError : " + e.getMessage());
                Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Log.d("LandingPresenter", " onComplete");
            }
        };
    }




    @Override
    public void updatePropertyList(int totalCount) {
        if(totalCount<=locOffset){
            Toast.makeText(activity, "All are Up to Date", Toast.LENGTH_SHORT).show();

        }else {
            locOffset = locOffset+ 2;
            Retrofit retrofit = new ApiClient().getRetrofitClient();
            final WebServices webServices = retrofit.create(WebServices.class);
            Observable<MainList> mainListObservable = webServices.updateHouseList(locLimit,locOffset);
            mainListObservable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(getMainList2());
        }
    }

    private Observer<MainList> getMainList2() {
        return new Observer<MainList>() {

            @Override
            public void onSubscribe(Disposable d) {
                iExploreView.unSubscribeCalls(d);
                Log.d("ExplorePresenter", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(MainList value) {
                iExploreView.updatePropertyList(value.getProperties());
                Log.d("ExplorePresenter", " onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("ExplorePresenter", " onError : " + e.getMessage());
                Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Log.d("ExplorePresenter", " onComplete");
            }
        };
    }

    private Observer<LikeUnLike> getLikedRsp() {
        return new Observer<LikeUnLike>() {

            @Override
            public void onSubscribe(Disposable d) {
                iExploreView.unSubscribeCalls(d);
                Log.d("ExplorePresenter", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(LikeUnLike value) {
                LikeUnLike likeUnLike= value;
                if(likeUnLike.getError()!=null&&likeUnLike.getError().equals(true)){
                    Toast.makeText(activity, likeUnLike.getError_status(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(activity, "Liked", Toast.LENGTH_SHORT).show();
                }
                Log.d("ExplorePresenter", " onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("ExplorePresenter", " onError : " + e.getMessage());
                Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Log.d("ExplorePresenter", " onComplete");
            }
        };
    }

    private Observer<LikeUnLike> getUnLikedRsp() {
        return new Observer<LikeUnLike>() {

            @Override
            public void onSubscribe(Disposable d) {
                iExploreView.unSubscribeCalls(d);
                Log.d("ExplorePresenter", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(LikeUnLike value) {
                LikeUnLike likeUnLike= value;
                if(likeUnLike.getError()!=null&&likeUnLike.getError().equals(true)){
                    Toast.makeText(activity, likeUnLike.getError_status(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(activity, "UnLiked", Toast.LENGTH_SHORT).show();
                }

                Log.d("ExplorePresenter", " onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("ExplorePresenter", " onError : " + e.getMessage());
                Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Log.d("ExplorePresenter", " onComplete");
            }
        };
    }

    @Override
    public void btnLiked(Integer userID, Integer propertyId) {
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Observable<LikeUnLike> likedObservable = webServices.propertyLike(userID,propertyId);
        likedObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getLikedRsp());
    }

    @Override
    public void btnUnliked(Integer userID, Integer propertyId) {
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Observable<LikeUnLike> likedObservable = webServices.propertyUnlike(userID,propertyId);
        likedObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getUnLikedRsp());
    }

    private Observer<MainList> getMainList() {
        return new Observer<MainList>() {

            @Override
            public void onSubscribe(Disposable d) {
                iExploreView.unSubscribeCalls(d);
                Log.d("ExplorePresenter", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(MainList value) {
                Log.d("ExplorePresenter", " onNext : value : " + value);
                MainList mainList = value;
                landingListItems.clear();
                String json = new Gson().toJson(mainList);
                System.out.println("getMainRefreshList getMainRefreshList json : " + json);


                HeaderItem headerItem = new HeaderItem();
                headerItem.setImgHeader(R.drawable.barasti_home_banner);
                headerItem.setBtnContent("Explore Homes >");
                headerItem.setBanners(mainList.getSliders());
                headerItem.setViewType(0);
                landingListItems.add(headerItem);
                String json2 = new Gson().toJson(mainList.getSliders());
                //System.out.println("ExplorePresenter getSliders() json2 : " + json2);

                TypeBody typeItems = new TypeBody();
                typeItems.setHeadingTitile("Property Types");
                typeItems.setTypeLists(mainList.getTypes());
                typeItems.setViewType(1);
                landingListItems.add(typeItems);


                String json3 = new Gson().toJson(mainList.getTypes());
                System.out.println("getMainRefreshList getTypes() json 3: " + json3);

                ExploreItems yourTripItem = new ExploreItems();
                yourTripItem.setMainHeading("Top Rated Homes");
                yourTripItem.setMainList(mainList);
                yourTripItem.setHouseList(mainList.getProperties());
                yourTripItem.setViewType(2);
                landingListItems.add(yourTripItem);


                String json4 = new Gson().toJson(mainList.getProperties());
                System.out.println("getMainRefreshList getProperties() json4 : " + json4);


                locItemsArrayList = mainList.getLocations();
                FooterItems footerItems = new FooterItems();
                footerItems.setHeadingTitile("Location");
                footerItems.setLocItemsList(locItemsArrayList);
                footerItems.setViewType(3);
                landingListItems.add(footerItems);
                iExploreView.setRefreshHomeList(landingListItems);

                String json5 = new Gson().toJson(mainList.getLocations());
                System.out.println("getMainRefreshList getLocations() json5 : " + json5);

            }

            @Override
            public void onError(Throwable e) {
                Log.d("ExplorePresenter", " onError : " + e.getMessage());
                Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Log.d("ExplorePresenter", " onComplete");
            }
        };
    }

    @Override
    public void getMainRefreshList(int userId) {
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Observable<MainList> mainListObservable = webServices.doGetDetails1(userId);
        mainListObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getMainList());

    }


}
