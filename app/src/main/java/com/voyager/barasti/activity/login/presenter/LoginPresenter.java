package com.voyager.barasti.activity.login.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.voyager.barasti.R;
import com.voyager.barasti.activity.login.model.UserDetails;
import com.voyager.barasti.activity.login.view.ILoginView;

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

    public LoginPresenter(ILoginView iLoginView, Activity activity,GoogleSignInClient mGoogleSignInClient,FirebaseAuth mAuth) {
        this.iLoginView = iLoginView;
        this.activity = activity;
        this.mGoogleSignInClient = mGoogleSignInClient;
        this.mAuth = mAuth;
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
            userDetails = new UserDetails(state, userId, userEmailAdress, userName, userImageUrl, userMob);


        } else {
            System.out.println("Something went wrong SignInPresenter updateUI");
        }
    }



}
