package com.voyager.barasti.activity.UpdateProfile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.voyager.barasti.R;
import com.voyager.barasti.activity.UpdateProfile.presenter.IUpdatePresenter;
import com.voyager.barasti.activity.UpdateProfile.presenter.UpdatePresenter;
import com.voyager.barasti.activity.UpdateProfile.view.IUpdateView;
import com.voyager.barasti.activity.login.model.UserDetails;
import com.voyager.barasti.common.Helper;
import com.voyager.barasti.common.NetworkDetector;

/**
 * Created by User on 22-Feb-19.
 */

public class UpdateProfile extends AppCompatActivity implements IUpdateView{

    AppCompatEditText etFirstName;
    AppCompatEditText etLastName;
    AppCompatEditText etPhno;
    AppCompatEditText etEmail;
    AppCompatEditText etDOB;
    Button btnUpdate;
    IUpdatePresenter iUpdatePresenter;
    int userId = 0;
    String fName= "";
    String lName = "";

    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;
    UserDetails userDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etPhno = findViewById(R.id.etPhno);
        etEmail = findViewById(R.id.etEmail);
        etDOB = findViewById(R.id.etDOB);
        btnUpdate = findViewById(R.id.btnUpdate);

        Intent intent = getIntent();
        String hiddenBtn = intent.getStringExtra("btnHiddenBtn");
        userDetails = (UserDetails) intent.getParcelableExtra("UserDetails");
        if (userDetails != null) {
            if(userDetails.getLoginType().equals("google")||userDetails.getLoginType().equals("facebook")) {
                String str = userDetails.getUserName();
                String[] splited = str.split("\\s+");
                String lastName= "";
                for(int i=0;i<splited.length;i++){
                    fName = splited[0];
                    if(i>0) {
                        lastName = splited[i];
                        lName = lName + lastName;
                    }
                }
                etFirstName.setText(fName);
                etLastName.setText(lName);
                etPhno.setText(userDetails.getPhone_num());
                etPhno.setClickable(false);
                etPhno.setEnabled(false);
                etEmail.setText(userDetails.getEmail());
                etEmail.setClickable(false);
                etEmail.setEnabled(false);
                etDOB.setText(userDetails.getDate_of_birth());
            }else if(userDetails.getLoginType().equals("normal")){
                etFirstName.setText(userDetails.getFirst_name());
                etLastName.setText(userDetails.getLast_name());
                etPhno.setText(userDetails.getPhone_num());
                etPhno.setClickable(false);
                etPhno.setEnabled(false);
                etEmail.setText(userDetails.getEmail());
                etEmail.setClickable(false);
                etEmail.setEnabled(false);
                etDOB.setText(userDetails.getDate_of_birth());
            }
            System.out.println("LandingPage -- UserDetail- name : " + userDetails.getFirst_name());
            System.out.println("LandingPage -- UserDetail- Id : " + userDetails.getId());
            System.out.println("LandingPage -- UserDetail- fcm : " + userDetails.getFcm());
        }

        sharedPrefs = getSharedPreferences(Helper.UserDetails,
                Context.MODE_PRIVATE);
        editor = sharedPrefs.edit();
        iUpdatePresenter = new UpdatePresenter(this,this,sharedPrefs,editor);




    }


    public  void btnUpdate(View v){
        Helper.hideKeyboard(this);
        if(NetworkDetector.haveNetworkConnection(this)){
            //Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.snack_error_network_available), Snackbar.LENGTH_SHORT).show();
            btnUpdate.setEnabled(false);
            iUpdatePresenter.updateProfile(etFirstName.getText().toString(),
                    etLastName.getText().toString(),
                    etPhno.getText().toString(),
                    etEmail.getText().toString(),
                    etDOB.getText().toString(),
                    userDetails.getId());
        }else {
            Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.snack_error_network), Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpdateValidate(Boolean result, int code) {
        etFirstName.setEnabled(true);
        etLastName.setEnabled(true);
        etPhno.setEnabled(true);
        etEmail.setEnabled(true);
        etDOB.setEnabled(true);
        btnUpdate.setEnabled(true);
        if (result) {
        } else {
            btnUpdate.setEnabled(true);
            switch (code) {
                case -1:
                    Toast.makeText(this, "Please fill all the fields, code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                case -2:
                    Toast.makeText(this, "Please fill a valid First Name, code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                case -3:
                    Toast.makeText(this, "Please fill a valid Last Name, code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                case -4:
                    Toast.makeText(this, "Please fill a valid email Address, code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                case -5:
                    Toast.makeText(this, "Please fill a valid Phone No, code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                case -6:
                    Toast.makeText(this, "Please fill a valid Dob , code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(this, "Please try Again Later, code = " + code, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onUpdateResponse(Boolean result, int code) {
        System.out.println("-----onRegistered second Please see, code = " + code + ", result: " + result);
        if (result) {
            System.out.println("------- inside onRegistered first Please see, code = " + code + ", result: " + result);
            //Toast.makeText(this, "-----onRegistered second Please see, code = " + code + ", result: " + result, Toast.LENGTH_SHORT).show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //re-enable the button
                    btnUpdate.setEnabled(true);
                    Toast.makeText(getApplicationContext(), "Profile Updated", Toast.LENGTH_SHORT).show();

                }
            }, 4000);
        } else {
            btnUpdate.setEnabled(true);
            etFirstName.setEnabled(true);
            etLastName.setEnabled(true);
            etPhno.setEnabled(true);
            etEmail.setEnabled(true);
            etDOB.setEnabled(true);
            btnUpdate.setEnabled(true);
            switch (code) {
                case -9:
                    Toast.makeText(this, "Please Correct the Required fields, code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                case -77:
                    Toast.makeText(this, "SomeThing went Wrong on our end Please try after some time , code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(this, "Please try Again Later, code = " + code, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
