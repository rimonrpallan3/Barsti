package com.voyager.barasti.activity.PriceDetailPage.presenter;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.voyager.barasti.activity.PriceDetailPage.model.PriceDetails;
import com.voyager.barasti.activity.PriceDetailPage.view.IPriceView;
import com.voyager.barasti.webservices.ApiClient;
import com.voyager.barasti.webservices.WebServices;

import java.io.IOException;

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
 * Created by User on 26-Feb-19.
 */

public class PricePresenter implements IPricePresenter {

    IPriceView iPriceView;
    Activity activity;
    int propertyId = 0;
    int userID = 0;

    public String currentStartDate = "";
    public String currentEndDate = "";
    Integer guestCount = 0;


    public PricePresenter(IPriceView iPriceView, Activity activity, int propertyId,String currentStartDate,String currentEndDate,Integer guestCount ,int userID) {
        this.iPriceView = iPriceView;
        this.activity = activity;
        this.propertyId = propertyId;
        this.currentStartDate = currentStartDate;
        this.currentEndDate = currentEndDate;
        this.guestCount = guestCount;
        this.userID = userID;
        getBookingDetails();

    }

    public void getBookingDetails(){
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Observable<PriceDetails> priceDetailsObservable = webServices.getPriceDetails(propertyId,guestCount,currentStartDate,currentEndDate,userID);
        priceDetailsObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getPriceDetail());
    }

    private Observer<PriceDetails> getPriceDetail() {
        return new Observer<PriceDetails>() {

            @Override
            public void onSubscribe(Disposable d) {
                iPriceView.unSubscribeCalls(d);
                Log.d("LocationPresenter", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(PriceDetails value) {
                PriceDetails priceDetails= value;
                iPriceView.setPriceDetails(priceDetails);
                String json = new Gson().toJson(priceDetails);
                System.out.println("LocationPresenter getHomeData json : " + json);
                Log.d("LocationPresenter", " onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("LocationPresenter", " onError : " + e.getMessage());
                Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Log.d("LocationPresenter", " onComplete");
            }
        };
    }


}
