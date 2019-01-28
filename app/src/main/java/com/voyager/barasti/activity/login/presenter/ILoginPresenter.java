package com.voyager.barasti.activity.login.presenter;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by User on 23-Jan-19.
 */

public interface ILoginPresenter {
    void firebaseAuthWithGoogle(GoogleSignInAccount acct);
    void updateUI(FirebaseUser user);
    void doLogin(String emailPhno, String passwd,String fireBaseToken);
    void setProgressBarVisiblity(int visiblity);
}
