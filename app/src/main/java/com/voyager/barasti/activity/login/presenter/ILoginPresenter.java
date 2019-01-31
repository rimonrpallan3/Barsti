package com.voyager.barasti.activity.login.presenter;

import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by User on 23-Jan-19.
 */

public interface ILoginPresenter {
    void firebaseAuthWithGoogle(GoogleSignInAccount acct);
    void firebaseAuthWithFB(LoginResult loginResult);
    void updateUI(FirebaseUser user);
    void doLogin(String emailPhno, String passwd,String fireBaseToken);
    void setProgressBarVisiblity(int visiblity);
}
