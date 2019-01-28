package com.voyager.barasti.activity.login.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.gson.Gson;
import com.voyager.barasti.R;
import com.voyager.barasti.activity.login.model.UserDetails;
import com.voyager.barasti.activity.login.view.ILoginView;
import com.voyager.barasti.webservices.ApiClient;
import com.voyager.barasti.webservices.WebServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by User on 23-Jan-19.
 */

public class LoginPresenter implements ILoginPresenter{

    ILoginView iLoginView;
    Activity activity;
    GoogleSignInClient mGoogleSignInClient;
    FirebaseAuth mAuth;
    private static final String TAG = "LoginPresenter";
    Boolean state = false;
    String userId = "";
    String userName = "";
    String userEmailAdress = "";
    String userImageUrl = "";
    String app_version = "";
    String userMob = "";
    String adminRegNo = "";
    String adminQrgType = "";
    UserDetails userDetails;
    String fireBaseToken;

    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;
    String name;
    String passwd;

    public LoginPresenter(ILoginView iLoginView, Activity activity,
                          GoogleSignInClient mGoogleSignInClient,
                          FirebaseAuth mAuth,
                          SharedPreferences sharedPrefs,
                                  SharedPreferences.Editor editor) {
        this.iLoginView = iLoginView;
        this.activity = activity;
        this.mGoogleSignInClient = mGoogleSignInClient;
        this.mAuth = mAuth;
        this.sharedPrefs=sharedPrefs;
        this.editor=editor;
    }

    /**
     * Once the Google Sign in is successful,
     * Firebase authentication is done using Google's Sign In credentials.
     * And finally the users details are stored on the Firebase Authentication console.
     *
     * @param acct Google's Sign in account.
     */
    // [START auth_with_google]
    @Override
    public void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
        // [START_EXCLUDE silent]
        iLoginView.setLoader(View.VISIBLE);
        // [END_EXCLUDE]
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Snackbar.make(activity.findViewById(android.R.id.content), activity.getResources().getString(R.string.snack_error_acct), Snackbar.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                        // [START_EXCLUDE]
                        iLoginView.setLoader(View.GONE);
                        // [END_EXCLUDE]
                    }
                });
    }

    @Override
    public void doLogin(String name, String passwd,String fireBaseToken) {
        this.name = name;
        this.passwd = passwd;
        this.fireBaseToken = fireBaseToken;
        System.out.println("-------doLogin  email : " + name +
                " Password : " + passwd);
        initUser();
        Boolean isLoginSuccess = true;
        final int code = userDetails.checkUserValidity(name,passwd);
        if (code!=0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
        iLoginView.onLoginResult(result, code);
        validateLoginDataBaseApi();
    }

    @Override
    public void setProgressBarVisiblity(int visiblity) {
        iLoginView.onSetProgressBarVisibility(visiblity);
    }


    public void validateLoginDataBaseApi(){
        System.out.println("-------validateLoginDataBaseApi ");
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        WebServices webServices = retrofit.create(WebServices.class);
        Call<UserDetails> call = webServices.loginUser(name,passwd,fireBaseToken);
        call.enqueue(new Callback<UserDetails>() {
            @Override
            public void onResponse(Call<UserDetails> call, Response<UserDetails> response) {
                userDetails  = (UserDetails) response.body();

                System.out.println("-------validateLoginDataBaseApi  email : " + name +
                        " Password : " + passwd +
                        " LName : " + userDetails.getFirst_name()+
                        " phno : " + userDetails.getEmail() +
                        " city : " + userDetails.getEmail() +
                        "userID: " + userDetails.getId()+
                        "imageUrl"+ userDetails.getProfile_src());
                Gson gson = new Gson();
                String jsonString = gson.toJson(userDetails);

                System.out.println(" ----------- getFilters OfferListMap "+jsonString);
                if(jsonString!=null) {
                    System.out.println("-----------getFilters OfferList"+jsonString);
                }

                final int code =userDetails.validateLoginResponseError(userDetails.getLogin_status());
                System.out.println("--------- validateLoginDataBaseApi code: "+code);
                Boolean isLoginSuccess =true;
                if (code != 0) {
                    isLoginSuccess = false;
                    System.out.println("--------- validateLoginDataBaseApi isError: "+userDetails.getLogin_status() +" Error message: "+userDetails.getLogin_status());
                    Toast.makeText((Context) iLoginView, userDetails.getLogin_status(), Toast.LENGTH_SHORT).show();
                    System.out.println("-----validateLoginDataBaseApi  data unSuccess ");
                } else {
                    userDetails.setPswd(passwd);
                    //userDetails.setFcm(fireBaseToken);
                    System.out.println("----- validateLoginDataBaseApi isError: "+userDetails.getLogin_status() +" userID: "+userDetails.getId());
                    Toast.makeText((Context) iLoginView, "Login Successful", Toast.LENGTH_SHORT).show();
                    addUserGsonInSharedPrefrences(userDetails);
                    System.out.println("----- validateLoginDataBaseApi data Successful ");
                }
                Boolean result = isLoginSuccess;
                System.out.println("----- sendRegisteredDataAndValidateResponse second Data Please see, code = " + code + ", result: " + result);
                iLoginView.onLoginResponse(result, code);
            }

            @Override
            public void onFailure(Call<UserDetails> call, Throwable t) {
                Boolean isLoginSuccess = false;
                Boolean result = isLoginSuccess;
                int code = -77;
                iLoginView.onLoginResult(result, code);
                t.printStackTrace();
                //Toast.makeText((Context) iRegisterView, "ErrorMessage"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }



    private void initUser(){
        userDetails = new UserDetails(name,passwd);
    }

    // [END auth_with_google]
    @Override
    public void updateUI(final FirebaseUser user) {
        System.out.println("SignInPresenter user : " + user);
        if (user != null) {
            state = true;
            userId = user.getUid();
            userName = user.getDisplayName();
            userEmailAdress = user.getEmail();
            userImageUrl = String.valueOf(user.getPhotoUrl());
            userMob = user.getPhoneNumber();
            //userDetails = new UserDetails(state, userId, userEmailAdress, userName, userImageUrl, userMob);

            String json = new Gson().toJson(userDetails);
            System.out.println("SignInPresenter userDetails json : " + json);

        } else {
            System.out.println("Something went wrong SignInPresenter updateUI");
        }
    }

    private void addUserGsonInSharedPrefrences(UserDetails UserDetails ){
        Gson gson = new Gson();
        String jsonString = gson.toJson(UserDetails);
        //UserDetails user1 = gson.fromJson(jsonString,UserDetails.class);
        if(jsonString!=null) {
            editor.putString("UserDetails", jsonString);
            editor.commit();
            System.out.println("-----------validateLoginDataBaseApi UserDetails"+jsonString);
        }

    }



}
