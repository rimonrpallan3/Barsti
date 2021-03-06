package com.voyager.barasti.activity.login.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.gson.Gson;
import com.voyager.barasti.R;
import com.voyager.barasti.activity.login.model.UserDetails;
import com.voyager.barasti.activity.login.view.ILoginView;

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
 * Created by User on 23-Jan-19.
 */

public class LoginPresenter implements ILoginPresenter{

    ILoginView iLoginView;
    Activity activity;
    GoogleSignInClient mGoogleSignInClient;
    FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
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
    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;
    String name;
    String passwd;
    String fireBaseToken="";
    String loginType  ="";
    String facebook = "";
    String google = "";
    String normal = "";



    public LoginPresenter(ILoginView iLoginView, Activity activity,
                          GoogleSignInClient mGoogleSignInClient,
                          FirebaseAuth mAuth,
                          SharedPreferences sharedPrefs,
                                  SharedPreferences.Editor editor,
                          String fireBaseToken) {
        this.iLoginView = iLoginView;
        this.activity = activity;
        this.mGoogleSignInClient = mGoogleSignInClient;
        this.mAuth = mAuth;
        this.sharedPrefs=sharedPrefs;
        this.editor=editor;
        this.fireBaseToken = fireBaseToken;
        facebook = activity.getResources().getString(R.string.login_facebook);
        google = activity.getResources().getString(R.string.login_google);
        normal = activity.getResources().getString(R.string.login_normal);
    }


    @Override
    public void onLoginSucuess() {
        iLoginView.sendPParcelableObj(userDetails);
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
                            updateUI(user,google);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Snackbar.make(activity.findViewById(android.R.id.content), activity.getResources().getString(R.string.snack_error_acct), Snackbar.LENGTH_SHORT).show();
                            updateUI(null,google);
                        }
                        // [START_EXCLUDE]
                        iLoginView.setLoader(View.GONE);
                        // [END_EXCLUDE]
                    }
                });
    }

    public void firebaseFacebookAuthWithAnonymous(final AccessToken token) {
        final AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.getCurrentUser().linkWithCredential(credential)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        System.out.println("Login Anonymous Linking Facebook: "+task.isSuccessful());
                        Log.d(TAG, "linkWithCredential:onComplete:" + task.isSuccessful());

                        if (!task.isSuccessful()) {
                            System.out.println("Login initate login with Facebook");
                            handleFacebookAccessToken(token);
                        }

                    }
                });
    }


    @Override
    public void firebaseAuthWithFB(final LoginResult loginResult) {
        Log.d(TAG, "handleFacebookAccessToken:" + loginResult.getAccessToken());
        final AccessToken token =loginResult.getAccessToken();
        System.out.println("firebaseAuthWithFB : handleFacebookAccessToken success token : "+loginResult.getAccessToken());
        /*final AuthCredential credential = FacebookAuthProvider.getCredential(loginResult.getAccessToken().getToken());
        mAuth.getCurrentUser().linkWithCredential(credential)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        System.out.println("Login Anonymous Linking Facebook: "+task.isSuccessful());
                        Log.d(TAG, "linkWithCredential:onComplete:" + task.isSuccessful());

                        if (!task.isSuccessful()) {
                            System.out.println("Login initate login with Facebook");
                            handleFacebookAccessToken(token);
                        }

                    }
                });*/

        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            System.out.println("firebaseAuthWithFB : success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user,facebook);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(activity, activity.getResources().getString(R.string.login_facebook_auth_fail),
                                    Toast.LENGTH_SHORT).show();
                            System.out.println("Authentication : success");
                            updateUI(null,facebook);
                        }

                        // ...
                    }
                });


    }


    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);
        final AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        System.out.println("Login : login with Facebook "+task.isSuccessful());
                        if (!task.isSuccessful()) {

                            Snackbar.make(activity.findViewById(android.R.id.content),
                                    activity.getResources().getString(R.string.sign_snack_error_message),
                                    Snackbar.LENGTH_INDEFINITE)
                                    .setAction(activity.getResources().getString(R.string.sign_snack_ok_button), new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            //loginButton.setVisibility(View.GONE);
                                        }
                                    }).show();

                        }

                    }
                });
    }

    @Override
    public void doLogin(String name, String passwd,String fireBaseToken) {
        this.name = name;
        this.passwd = passwd;
        this.fireBaseToken = fireBaseToken;
        UserDetails userDetails = new UserDetails();
        userDetails.setLoginType(normal);
        userDetails.setFcm(fireBaseToken);
        System.out.println("------- doLogin  email : "+ name +
                " Password : " + passwd);
        initUser();
        Boolean isLoginSuccess = true;
        final int code = userDetails.checkUserValidity(name,passwd);
        if (code!=0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
        iLoginView.onLoginResult(result, code);
        validateLoginDataBaseApi(userDetails);
    }

    @Override
    public void setProgressBarVisiblity(int visiblity) {
        iLoginView.onSetProgressBarVisibility(visiblity);
    }


    public void validateLoginDataBaseApi(final UserDetails userDetails){
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Observable<UserDetails> getLoginObservable;
        if(userDetails.getLoginType().equals(google)) {
            getLoginObservable = webServices.loginGoogleUser(userDetails.getEmail(), userDetails.getLoginType(), userDetails.getProfile_image(),userDetails.getUsermob(),userDetails.getUserName(),userDetails.getGoogleId(),userDetails.getFcm());
            loginType = userDetails.getLoginType() ;
        }else if(userDetails.getLoginType().equals(normal)){
            getLoginObservable = webServices.loginNormalUser(name, passwd, userDetails.getLoginType(),userDetails.getFcm());
            loginType = userDetails.getLoginType() ;
        }else if(userDetails.getLoginType().equals(facebook)){
            getLoginObservable = webServices.loginFBUser(userDetails.getEmail(), userDetails.getLoginType(), userDetails.getProfile_image(),userDetails.getUsermob(),userDetails.getUserName(),userDetails.getFcm());
            loginType = userDetails.getLoginType() ;
        }else {
            getLoginObservable = webServices.loginNormalUser(name, passwd, userDetails.getLoginType(),userDetails.getFcm());
            loginType = userDetails.getLoginType() ;
        }
        getLoginObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getLoginDetails());
        System.out.println(" ------- validateLoginDataBaseApi ");




    }


    private Observer<UserDetails> getLoginDetails() {
        return new Observer<UserDetails>() {

            @Override
            public void onSubscribe(Disposable d) {
                iLoginView.unSubscribeCalls(d);
                Log.d("LoginPresenter", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(UserDetails value) {
                UserDetails userDetails= value;
                userDetails.setLoginType(loginType);
                    /*System.out.println("-------validateLoginDataBaseApi  email : " + name +
                            " Password : " + passwd +
                            " LName : " + userDetails.getFirst_name()+
                            " phno : " + userDetails.getEmail() +
                            " city : " + userDetails.getEmail() +
                            "userID: " + userDetails.getId()+
                            "imageUrl"+ userDetails.getProfile_src());*/
                Gson gson = new Gson();
                String jsonString = gson.toJson(userDetails);

                System.out.println(" ----------- LoginPresenter validateLoginDataBaseApi "+jsonString);
                if(jsonString!=null) {
                    System.out.println("-----------getFilters OfferList"+jsonString);
                }
                    /*if(userDetails.getError_status()==null){
                        userDetails.setError_status("");
                    }*/

                final int code = userDetails.validateLoginResponseError(userDetails.getError_status());
                System.out.println("--------- validateLoginDataBaseApi code: "+code);
                Boolean isLoginSuccess = true;
                if (code != 0) {
                    isLoginSuccess = false;
                    //System.out.println("--------- validateLoginDataBaseApi isError: "+userDetails.getLogin_status() +" Error message: "+userDetails.getLogin_status());
                    Toast.makeText((Context) iLoginView, userDetails.getLogin_status(), Toast.LENGTH_SHORT).show();
                    //System.out.println("-----validateLoginDataBaseApi  data unSuccess ");
                } else {
                    userDetails.setPswd(passwd);
                    //userDetails.setFcm(fireBaseToken);
                    //System.out.println("----- validateLoginDataBaseApi isError: "+userDetails.getLogin_status() +" userID: "+userDetails.getId());
                    Toast.makeText((Context) iLoginView, activity.getResources().getString(R.string.login_api_normal_response_success), Toast.LENGTH_SHORT).show();
                    addUserGsonInSharedPrefrences(userDetails);
                    //System.out.println("----- validateLoginDataBaseApi data Successful ");
                }
                Boolean result = isLoginSuccess;
                //System.out.println("----- sendRegisteredDataAndValidateResponse second Data Please see, code = " + code + ", result: " + result);
                iLoginView.onLoginResponse(result, code);
            }

            @Override
            public void onError(Throwable e) {
                Boolean isLoginSuccess = false;
                Boolean result = isLoginSuccess;
                int code = -77;
                iLoginView.onLoginResult(result, code);
                Log.d("LoginPresenter", " onError : " + e.getMessage());
                Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Log.d("LoginPresenter", " onComplete");
            }
        };
    }



    private void initUser(){
        userDetails = new UserDetails(name,passwd);
    }

    // [END auth_with_google]
    @Override
    public void updateUI( final FirebaseUser user, String userType ) {
        System.out.println("SignInPresenter user : " + user);
        if (user != null) {
            state = true;
            userId = user.getUid();
            userName = user.getDisplayName();
            userEmailAdress = user.getEmail();
            userImageUrl = String.valueOf(user.getPhotoUrl());
            userMob = user.getPhoneNumber();
            if(userType.equals("facebook")){
                userDetails = new UserDetails(userId,userEmailAdress, userImageUrl, userName, userMob);
            }else {
                userDetails = new UserDetails(userId, userEmailAdress, userImageUrl, userName, userMob, state);
            }
            userDetails.setLoginType(userType);
            userDetails.setFcm(fireBaseToken);
            validateLoginDataBaseApi(userDetails);
            String json = new Gson().toJson(userDetails);
            System.out.println("SignInPresenter userDetails json : " + json);

        } else {
            System.out.println("Something went wrong SignInPresenter updateUI");
        }
    }

    private void addUserGsonInSharedPrefrences(UserDetails UserDetails){
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
