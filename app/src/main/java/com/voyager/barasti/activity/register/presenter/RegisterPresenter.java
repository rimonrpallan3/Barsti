package com.voyager.barasti.activity.register.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.voyager.barasti.activity.login.model.IUserDetials;
import com.voyager.barasti.activity.login.model.UserDetails;
import com.voyager.barasti.activity.register.model.DOBDetails;
import com.voyager.barasti.activity.register.view.IRegisterView;
import com.voyager.barasti.fragment.fav.model.FavDetail;
import com.voyager.barasti.webservices.ApiClient;
import com.voyager.barasti.webservices.WebServices;

import java.util.ArrayList;

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
 * Created by User on 19-Feb-19.
 */

public class RegisterPresenter implements  IRegisterPresenter{

    Activity activity;
    IRegisterView iRegisterView;
    IUserDetials user;
    UserDetails userDetails;
    String FirstName;
    String LastName;
    String Password;
    String RetypePassword;
    String email;
    String phno;
    String dob;
    String Imei;
    String loginType;

    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;

    public RegisterPresenter(Activity activity, IRegisterView iRegisterView,SharedPreferences sharedPrefs,SharedPreferences.Editor editor) {
        this.activity = activity;
        this.iRegisterView = iRegisterView;
        this.sharedPrefs = sharedPrefs;
        this.editor = editor;
        loginType = "normal";
    }

    private void initUser(){
        user = new UserDetails(FirstName,Password,RetypePassword,email,phno,dob,loginType);
    }

    @Override
    public void doRegister(String FirstName,String LastName, String Password, String RetypePassword, String email, String phno, String dob) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Password = Password;
        this.RetypePassword = RetypePassword;
        this.email = email;
        this.phno = phno;
        this.dob =dob;
        System.out.println("-------------------RegisterPresenter doRegister FirstName : "+FirstName+" LastName : "+LastName+" Password : "+Password+" RetypePassword : "+RetypePassword+" email : "+email+" phno : "+phno+" Dob :"+dob);

        initUser();
        Boolean isLoginSuccess = true;
        final int code = user.validateUserDetails(FirstName,LastName,Password,RetypePassword,email,phno,dob);
        if (code != 0) {
            isLoginSuccess = false;
        } else {
            sendRegisteredDataAndValidateResponse();
        }
        Boolean result = isLoginSuccess;
        iRegisterView.onRegister(result, code);
    }

    @Override
    public void onRegisteredSucuess() {
        System.out.println("------------------- onRegisteredSucuess");
        iRegisterView.sendPParcelableObj(userDetails);
    }


    public void sendRegisteredDataAndValidateResponse(){
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Observable<UserDetails> getRegisterUserObservable = webServices.registerUser(FirstName,LastName,Password,email,phno,dob,loginType);
        getRegisterUserObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getRegisterDetail());

        System.out.println("-------------------RegisterPresenter sendRegisteredDataAndValidateResponse FirstName : "+FirstName+" Password : "+Password+" RetypePassword : "+RetypePassword+" email : "+email+" phno : "+phno+" dob : "+dob);
    }

    private Observer<UserDetails> getRegisterDetail() {
        return new Observer<UserDetails>() {

            @Override
            public void onSubscribe(Disposable d) {
                iRegisterView.unSubscribeCalls(d);
                Log.d("RegisterPresenter", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(UserDetails value) {
                UserDetails userDetails= value;userDetails.setFirst_name(FirstName);
                userDetails.setLast_name(LastName);
                userDetails.setPassword(Password);
                userDetails.setEmail(email);
                userDetails.setPhone_num(phno);
                userDetails.setDate_of_birth(dob);
                userDetails.setLoginType(loginType);
                System.out.println("------- sendRegisteredDataAndValidateResponse  FirstName : " + FirstName +
                        " Password : " + Password +
                        " email Address : " + email +
                        " phno : " + phno +" dob : " + dob );
                final int code =user.validateRegisterResponseError(userDetails.getStatus());
                System.out.println("-----sendRegisteredDataAndValidateResponse  data code :"+code);
                Boolean isLoginSuccess =true;
                if (code != 0) {
                    isLoginSuccess = false;
                    Toast.makeText((Context) iRegisterView, userDetails.getStatus(), Toast.LENGTH_SHORT).show();
                    System.out.println("----- sendRegisteredDataAndValidateResponse isError: "+userDetails.getError());
                    System.out.println("-----sendRegisteredDataAndValidateResponse  data unSuccess ");
                } else {
                    Toast.makeText((Context) iRegisterView, "Register Successful", Toast.LENGTH_SHORT).show();
                    addUserGsonInSharedPrefrences(userDetails);
                    System.out.println("--------- sendRegisteredDataAndValidateResponse isError: "+userDetails.getError() +" Error message: "+userDetails.getStatus());
                    System.out.println("----- sendRegisteredDataAndValidateResponse data Successful ");
                }
                Boolean result = isLoginSuccess;
                System.out.println("----- sendRegisteredDataAndValidateResponse second Data Please see, code = " + code + ", result: " + result);
                iRegisterView.onRegistered(result, code);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("RegisterPresenter", " onError : " + e.getMessage());
                Boolean isLoginSuccess =false;
                Boolean result = isLoginSuccess;
                int code = -77;
                iRegisterView.onRegistered(result, code);

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
