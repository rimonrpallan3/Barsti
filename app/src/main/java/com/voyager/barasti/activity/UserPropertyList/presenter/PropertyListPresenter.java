package com.voyager.barasti.activity.UserPropertyList.presenter;

import android.app.Activity;
import android.widget.Toast;

import com.voyager.barasti.activity.UserPropertyList.model.UserPropertyDetails;
import com.voyager.barasti.activity.UserPropertyList.view.IPropertyListView;
import com.voyager.barasti.fragment.explore.model.exploreList.MainList;
import com.voyager.barasti.webservices.ApiClient;
import com.voyager.barasti.webservices.WebServices;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by User on 06-Mar-19.
 */

public class PropertyListPresenter implements IPropertyListPresenter{

    IPropertyListView iPropertyListView;
    Activity activity;

    public PropertyListPresenter(IPropertyListView iPropertyListView, Activity activity) {
        this.iPropertyListView = iPropertyListView;
        this.activity = activity;
    }

    public void getUserProperties(int userId){
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Call<UserPropertyDetails> calls = webServices.getPropertiesDetail(userId);
        calls.enqueue(new Callback<UserPropertyDetails>() {
            @Override
            public void onResponse(Call<UserPropertyDetails> call, Response<UserPropertyDetails> response) {
                UserPropertyDetails userPropertyDetails= response.body();
                iPropertyListView.setProperties(userPropertyDetails);
            }

            @Override
            public void onFailure(Call<UserPropertyDetails> call, Throwable t) {
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
