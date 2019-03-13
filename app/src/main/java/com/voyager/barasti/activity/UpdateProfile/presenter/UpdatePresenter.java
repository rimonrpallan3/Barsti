package com.voyager.barasti.activity.UpdateProfile.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.voyager.barasti.activity.UpdateProfile.view.IUpdateView;
import com.voyager.barasti.activity.login.model.IUserDetials;
import com.voyager.barasti.activity.login.model.UserDetails;
import com.voyager.barasti.webservices.ApiClient;
import com.voyager.barasti.webservices.WebServices;

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
 * Created by User on 22-Feb-19.
 */

public class UpdatePresenter implements IUpdatePresenter{

    Activity activity;
    IUpdateView iUpdateView;
    String fName;
    String lName;
    String email;
    String phNo;
    String dob;
    IUserDetials user;
    UserDetails userDetails;
    int userId;

    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;


    public UpdatePresenter(Activity activity, IUpdateView iUpdateView,SharedPreferences sharedPrefs,SharedPreferences.Editor editor) {
        this.activity = activity;
        this.iUpdateView = iUpdateView;
        this.sharedPrefs = sharedPrefs;
        this.editor = editor;
    }

    @Override
    public void updateProfile(String fName,String lName, String phNo, String email, String dob,int userId) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phNo = phNo;
        this.userId = userId;
        this.dob =dob;
        user = new UserDetails();
        Boolean isLoginSuccess = true;
        final int code = user.validateUpdateUserDetails(fName,lName);
        if (code != 0) {
            isLoginSuccess = false;
        } else {
            updateUserDataValidateResponse();
        }
        Boolean result = isLoginSuccess;
        iUpdateView.onUpdateValidate(result, code);
    }


    public void updateUserDataValidateResponse(){
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Observable<UserDetails> getUpdateDetailObservable = webServices.updateProfile(fName,lName,userId);
        getUpdateDetailObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(setUpdateProfile());

    }

    private Observer<UserDetails> setUpdateProfile() {
        return new Observer<UserDetails>() {

            @Override
            public void onSubscribe(Disposable d) {
                iUpdateView.unSubscribeCalls(d);
                Log.d("RegisterPresenter", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(UserDetails value) {
                UserDetails userDetails= value; userDetails.setFirst_name(fName);
                userDetails.setLast_name(lName);
                userDetails.setEmail(email);
                userDetails.setPhone_num(phNo);
                userDetails.setDate_of_birth(dob);
                System.out.println("------- updateUserDataValidateResponse  FirstName : " + fName +
                        " lName : " + lName +
                        " email Address : " + email +
                        " phno : " + phNo +" dob : " + dob );
                final int code =user.validateRegisterResponseError(userDetails.getStatus());
                System.out.println("-----sendRegisteredDataAndValidateResponse  data code :"+code);
                Boolean isLoginSuccess =true;
                if (code != 0) {
                    isLoginSuccess = false;
                    Toast.makeText((Context) iUpdateView, userDetails.getStatus(), Toast.LENGTH_SHORT).show();
                    System.out.println("----- sendRegisteredDataAndValidateResponse isError: "+userDetails.getError());
                    System.out.println("-----sendRegisteredDataAndValidateResponse  data unSuccess ");
                } else {
                    Toast.makeText((Context) iUpdateView, "Register Successful", Toast.LENGTH_SHORT).show();
                    addUserGsonInSharedPrefrences(userDetails);
                    System.out.println("--------- sendRegisteredDataAndValidateResponse isError: "+userDetails.getError() +" Error message: "+userDetails.getStatus());
                    System.out.println("----- sendRegisteredDataAndValidateResponse data Successful ");
                }
                Boolean result = isLoginSuccess;
                System.out.println("----- sendRegisteredDataAndValidateResponse second Data Please see, code = " + code + ", result: " + result);
                iUpdateView.onUpdateResponse(result, code);
            }

            @Override
            public void onError(Throwable e) {
                Boolean isLoginSuccess =false;
                Boolean result = isLoginSuccess;
                int code = -77;
                iUpdateView.onUpdateResponse(result, code);

                Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Log.d("RegisterPresenter", " onComplete");
            }
        };
    }


    private void addUserGsonInSharedPrefrences(UserDetails userDetails){
        Gson gson = new Gson();
        String jsonString = gson.toJson(userDetails);
        //UserModel user1 = gson.fromJson(jsonString,UserModel.class);
        if(jsonString!=null) {
            editor.putString("UserDetails", jsonString);
            editor.commit();
            System.out.println("-----------sendRegisteredDataAndValidateResponse  UserDetails"+jsonString);

        }

    }
}
