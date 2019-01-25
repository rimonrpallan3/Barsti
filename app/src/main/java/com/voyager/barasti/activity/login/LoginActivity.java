package com.voyager.barasti.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.voyager.barasti.R;
import com.voyager.barasti.activity.login.presenter.ILoginPresenter;
import com.voyager.barasti.activity.login.presenter.LoginPresenter;
import com.voyager.barasti.activity.login.view.ILoginView;

/**
 * Created by User on 23-Jan-19.
 */

public class LoginActivity extends AppCompatActivity implements ILoginView{


    LinearLayout btnSignInGoogle;
    private GoogleSignInClient mGoogleSignInClient;
    private static final String TAG = "SignInPage";
    ILoginPresenter iLoginPresenter;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final int RC_SIGN_IN = 9001;
    FrameLayout loadingLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSignInGoogle = (LinearLayout) findViewById(R.id.btnSignInGoogle);
        loadingLayout = (FrameLayout) findViewById(R.id.loadingLayout);
        // [START config_signin]
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        // [END config_signin]

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        iLoginPresenter = new LoginPresenter(this, this,mGoogleSignInClient,mAuth);
        mAuth = FirebaseAuth.getInstance();
    }

    public void setLoader(int visibility){
        loadingLayout.setVisibility(visibility);
    }


    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUserFireBase = mAuth.getCurrentUser();
        /*if (mAuthListener != null) {
            mAuth.addAuthStateListener(mAuthListener);
        }*/
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                iLoginPresenter.firebaseAuthWithGoogle(account);
                System.out.println("-----------GoogleSignInAccount onActivityResult");
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                btnSignInGoogle.setEnabled(true);
                Log.w(TAG, "Google sign in failed", e);
                System.out.println("-----------GoogleSignInAccount onActivityResult error : " +e.getMessage());
                // ...
            }
        }
    }

}