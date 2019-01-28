package com.voyager.barasti.activity.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.iid.FirebaseInstanceId;
import com.voyager.barasti.R;
import com.voyager.barasti.activity.login.model.UserDetails;
import com.voyager.barasti.activity.login.presenter.ILoginPresenter;
import com.voyager.barasti.activity.login.presenter.LoginPresenter;
import com.voyager.barasti.activity.login.view.ILoginView;
import com.voyager.barasti.activity.register.RegisterActivity;
import com.voyager.barasti.common.Helper;
import com.voyager.barasti.common.NetworkDetector;

/**
 * Created by User on 23-Jan-19.
 */

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, ILoginView{


    Button btnSignInGoogle;
    Button btnSignInFB;
    Button btnSignIn;
    AppCompatEditText etEmail;
    AppCompatEditText etCPass;
    private GoogleSignInClient mGoogleSignInClient;
    private static final String TAG = "SignInPage";
    ILoginPresenter iLoginPresenter;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final int RC_SIGN_IN = 9001;
    FrameLayout loadingLayout;

    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;
    String fireBaseToken="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSignInGoogle =  findViewById(R.id.btnSignInGoogle);
        btnSignInFB =  findViewById(R.id.btnSignInFB);
        btnSignIn =  findViewById(R.id.btnSignIn);
        etEmail =  findViewById(R.id.etEmail);
        etCPass =  findViewById(R.id.etCPass);
        fireBaseToken = FirebaseInstanceId.getInstance().getToken();
        sharedPrefs = getSharedPreferences(Helper.UserDetails,
                Context.MODE_PRIVATE);
        editor = sharedPrefs.edit();
        loadingLayout = (FrameLayout) findViewById(R.id.loadingLayout);
        // [START config_signin]
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        // [END config_signin]
        mAuth = FirebaseAuth.getInstance();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        iLoginPresenter = new LoginPresenter(this, this,mGoogleSignInClient,mAuth,sharedPrefs,editor);
        mAuth = FirebaseAuth.getInstance();
    }

    public void setLoader(int visibility){
        loadingLayout.setVisibility(visibility);
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        loadingLayout.setVisibility(visibility);
    }

    @Override
    public void onLoginResult(Boolean result, int code) {

    }

    @Override
    public void onLoginResponse(Boolean result, int code) {

    }

    @Override
    public void sendPParcelableObj(UserDetails userDetails) {

    }

    public void btnSignIn(View v){
        Helper.hideKeyboard(this);
        if(NetworkDetector.haveNetworkConnection(this)){
            //Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.snack_error_network_available), Snackbar.LENGTH_SHORT).show();
            iLoginPresenter.setProgressBarVisiblity(View.VISIBLE);
            btnSignIn.setEnabled(false);
            iLoginPresenter.doLogin(etEmail.getText().toString(), etCPass.getText().toString(),fireBaseToken);
        }else {
            Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.snack_error_network), Snackbar.LENGTH_LONG).show();

        }
    }

    public void registerTxtClick(View v){
        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intent);
    }

    public void btnSignInGoogle(View v){
        if(NetworkDetector.haveNetworkConnection(this)){
            Snackbar.make(findViewById(android.R.id.content),"Google Sign In btn", Snackbar.LENGTH_SHORT).show();
            btnSignInGoogle.setEnabled(false);
            signIn();
        }else {
            Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.snack_error_network), Snackbar.LENGTH_LONG).show();

        }
    }

    public void btnSignInFB(View v){
        Snackbar.make(findViewById(android.R.id.content),"Facebook Sign In btn", Snackbar.LENGTH_SHORT).show();
    }



    /**
     * This method starts the google sign in process.
     * It opens the dialog box for choosing google account.
     */
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
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

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}