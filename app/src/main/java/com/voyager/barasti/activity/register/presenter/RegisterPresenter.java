package com.voyager.barasti.activity.register.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.Gson;
import com.voyager.barasti.activity.login.model.IUserDetials;
import com.voyager.barasti.activity.login.model.UserDetails;
import com.voyager.barasti.activity.register.model.DOBDetails;
import com.voyager.barasti.activity.register.view.IRegisterView;
import com.voyager.barasti.webservices.ApiClient;
import com.voyager.barasti.webservices.WebServices;

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

    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;

    public RegisterPresenter(Activity activity, IRegisterView iRegisterView,SharedPreferences sharedPrefs,SharedPreferences.Editor editor) {
        this.activity = activity;
        this.iRegisterView = iRegisterView;
        this.sharedPrefs = sharedPrefs;
        this.editor = editor;
    }

    private void initUser(){
        user = new UserDetails(FirstName,Password,RetypePassword,email,phno,dob);
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
        System.out.println("-------------------RegisterPresenter sendRegisteredDataAndValidateResponse FirstName : "+FirstName+" Password : "+Password+" RetypePassword : "+RetypePassword+" email : "+email+" phno : "+phno+" dob : "+dob);
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        WebServices webServices = retrofit.create(WebServices.class);
        Call<UserDetails> call = webServices.registerUser(FirstName,LastName,Password,email,phno,dob);
        call.enqueue(new Callback<UserDetails>() {
            @Override
            public void onResponse(Call<UserDetails> call, Response<UserDetails> response) {
                userDetails  = (UserDetails) response.body();
                userDetails.setFirst_name(FirstName);
                userDetails.setLast_name(LastName);
                userDetails.setPassword(Password);
                userDetails.setEmail(email);
                userDetails.setPhone_num(phno);
                userDetails.setDate_of_birth(dob);
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
            public void onFailure(Call<UserDetails> call, Throwable t) {
                Boolean isLoginSuccess =false;
                Boolean result = isLoginSuccess;
                int code = -77;
                iRegisterView.onRegistered(result, code);
                t.printStackTrace();
                //Toast.makeText((Context) iRegisterView, "ErrorMessage"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


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
