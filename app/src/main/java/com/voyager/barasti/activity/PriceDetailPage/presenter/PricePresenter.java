package com.voyager.barasti.activity.PriceDetailPage.presenter;

import android.app.Activity;
import android.widget.Toast;

import com.google.gson.Gson;
import com.voyager.barasti.activity.PriceDetailPage.model.PriceDetails;
import com.voyager.barasti.activity.PriceDetailPage.view.IPriceView;
import com.voyager.barasti.activity.propertyProfilepage.model.HomeDetails;
import com.voyager.barasti.webservices.ApiClient;
import com.voyager.barasti.webservices.WebServices;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by User on 26-Feb-19.
 */

public class PricePresenter implements  IPreicePresenter{

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
        Call<PriceDetails> calls = webServices.getPriceDetails(propertyId,guestCount,currentStartDate,currentEndDate,userID);
        calls.enqueue(new Callback<PriceDetails>() {
            @Override
            public void onResponse(Call<PriceDetails> call, Response<PriceDetails> response) {
                PriceDetails priceDetails = response.body();
                iPriceView.setPriceDetails(priceDetails);
                String json = new Gson().toJson(priceDetails);
                // System.out.println("PricePresenter getBookingDetails json : " + json);

            }

            @Override
            public void onFailure(Call<PriceDetails> call, Throwable t) {
                if (t instanceof IOException) {
                    Toast.makeText(activity, "this is an actual network failure :( inform the user and possibly retry", Toast.LENGTH_SHORT).show();
                    // logging probably not necessary
                }
                else {
                    //Toast.makeText(activity, "conversion issue! big problems :(", Toast.LENGTH_SHORT).show();
                    // todo log to some central bug tracking service
                }
                t.printStackTrace();
                System.out.println(" there is an  error here  in api : "+t.getMessage()+"/n");

                //Toast.makeText((Context) iRegisterView, "ErrorMessage"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
