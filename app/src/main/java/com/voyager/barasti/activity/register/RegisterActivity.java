package com.voyager.barasti.activity.register;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.text.format.DateFormat;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.philliphsu.bottomsheetpickers.BottomSheetPickerDialog;
import com.philliphsu.bottomsheetpickers.date.DatePickerDialog;
import com.philliphsu.bottomsheetpickers.time.BottomSheetTimePickerDialog;
import com.voyager.barasti.R;
import com.voyager.barasti.activity.calenderactivity.model.TimeStamp;
import com.voyager.barasti.activity.landingpage.LandingPage;
import com.voyager.barasti.activity.login.model.UserDetails;
import com.voyager.barasti.activity.register.model.DOBDetails;
import com.voyager.barasti.activity.register.presenter.IRegisterPresenter;
import com.voyager.barasti.activity.register.presenter.RegisterPresenter;
import com.voyager.barasti.activity.register.view.IRegisterView;
import com.voyager.barasti.common.Helper;
import com.voyager.barasti.common.NetworkDetector;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import io.reactivex.disposables.Disposable;

import static com.voyager.barasti.common.Helper.REQUEST_REGISTERED;

/**
 * Created by User on 28-Jan-19.
 */

public class RegisterActivity extends AppCompatActivity  implements
        BottomSheetTimePickerDialog.OnTimeSetListener,
        DatePickerDialog.OnDateSetListener,
        IRegisterView {
    private static final String TAG = "RegisterActivity";
    private static final boolean USE_BUILDERS = false;

    IRegisterPresenter iRegisterPresenter;

    AppCompatTextView tvDatePick;
    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;
    AppCompatEditText etFName;
    AppCompatEditText etLName;
    AppCompatEditText etEmail;
    AppCompatEditText etNo;
    AppCompatEditText etCPass;
    AppCompatEditText etCnfPass;
    Button btnRegister;
    String dob;
    String currentDateBirth ="";
    DOBDetails dobDetails;
    Disposable dMainListObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //init
        sharedPrefs = getSharedPreferences(Helper.UserDetails,
                Context.MODE_PRIVATE);
        editor = sharedPrefs.edit();
        iRegisterPresenter = new RegisterPresenter(this,this,sharedPrefs,editor);
        tvDatePick = (AppCompatTextView) findViewById(R.id.tvDatePick);

        etFName = findViewById(R.id.etFName);
        etLName = findViewById(R.id.etLName);
        etEmail = findViewById(R.id.etEmail);
        etNo = findViewById(R.id.etNo);
        etCPass = findViewById(R.id.etCPass);
        etCnfPass = findViewById(R.id.etCnfPass);
        btnRegister = findViewById(R.id.btnRegister);

    }


    @Override
    public void onTimeSet(ViewGroup viewGroup, int hourOfDay, int minute) {
        Calendar cal = new java.util.GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
        cal.set(Calendar.MINUTE, minute);
        tvDatePick.setText("Time set: " + DateFormat.getTimeFormat(this).format(cal.getTime()));
    }

    @Override
    public void onDateSet(DatePickerDialog dialog, int year, int monthOfYear, int dayOfMonth) {
        Calendar cal = new java.util.GregorianCalendar();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, monthOfYear);
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        tvDatePick.setText("" + DateFormat.getDateFormat(this).format(cal.getTime()));
        dob = tvDatePick.getText().toString();
        dob = dob.replace("/", "-");
        dobDetails =datePrserFormater(dob);
        dob = dobDetails.getYear()+"-"+dobDetails.getMonth()+"-"+dobDetails.getDay();
        currentDateBirth = dob;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                //findViewById(R.id.fab).requestFocus();
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                //findViewById(R.id.radioGroup).requestFocus();
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    private DialogFragment createDialog(int checkedId) {
        if (USE_BUILDERS) {
            return createDialogWithBuilders(checkedId);
        } else {
            return createDialogWithSetters(checkedId);
        }
    }

    public void btnPickDate(View v){
        DialogFragment dialog = createDialog(v.getId());
        dialog.show(getSupportFragmentManager(), TAG);
    }

    public  void  btnRegister(View v){
        if(NetworkDetector.haveNetworkConnection(this)){
            //Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.snack_error_network_available), Snackbar.LENGTH_SHORT).show();
            btnRegister.setEnabled(false);
            iRegisterPresenter.doRegister(etFName.getText().toString(),
                    etLName.getText().toString(),
                    etCPass.getText().toString(),
                    etCnfPass.getText().toString(),
                    etEmail.getText().toString(),
                    etNo.getText().toString(),
                    currentDateBirth);
        }else {
            Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.snack_error_network), Snackbar.LENGTH_LONG).show();

        }
    }


    @Override
    public void unSubscribeCalls(Disposable dMainListObservable) {
        this.dMainListObservable = dMainListObservable;
    }


    private DialogFragment createDialogWithBuilders(int checkedId) {
        BottomSheetPickerDialog.Builder builder = null;
        boolean custom = false;
        boolean customDark = false;
        boolean themeDark = false;

        switch (checkedId) {
            case R.id.btnPickDate: {

                Calendar now = Calendar.getInstance();
                Calendar max = Calendar.getInstance();
                max.add(Calendar.YEAR, 10);
                max.set(2019,02,19);
                builder = new DatePickerDialog.Builder(
                        RegisterActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH));
                now.set(1980,02,19);
                DatePickerDialog.Builder dateDialogBuilder = (DatePickerDialog.Builder) builder;
                dateDialogBuilder.setMaxDate(max)
                        .setMinDate(now)
                        .setYearRange(1980, 2032);
                if (custom || customDark) {
                    dateDialogBuilder.setHeaderTextColorSelected(0xFFFF4081)
                            .setHeaderTextColorUnselected(0x4AFF4081)
                            .setDayOfWeekHeaderTextColorSelected(0xFFFF4081)
                            .setDayOfWeekHeaderTextColorUnselected(0x4AFF4081);
                }
                break;
            }
        }

        builder.setThemeDark(themeDark);
        if (custom || customDark) {
            builder.setAccentColor(0xFFFF4081)
                    .setBackgroundColor(custom? 0xFF90CAF9 : 0xFF2196F3)
                    .setHeaderColor(custom? 0xFF90CAF9 : 0xFF2196F3)
                    .setHeaderTextDark(custom);
        }
        return builder.build();
    }

    public  void ivBackbtn(View v){
        finish();
    }

    private DialogFragment createDialogWithSetters(int checkedId) {
        BottomSheetPickerDialog dialog = null;
        boolean custom = false;
        boolean customDark = false;
        boolean themeDark = false;

        switch (checkedId) {
            case R.id.btnPickDate: {
                Calendar now = Calendar.getInstance();
                dialog = DatePickerDialog.newInstance(
                        RegisterActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH));
                now.set(1980,02,19);
                DatePickerDialog dateDialog = (DatePickerDialog) dialog;
                dateDialog.setMinDate(now);
                Calendar max = Calendar.getInstance();
                max.add(Calendar.YEAR, 10);
                max.set(2019,02,19);
                dateDialog.setMaxDate(max);
                dateDialog.setYearRange(1960, 2032);
                if (custom || customDark) {
                    dateDialog.setHeaderTextColorSelected(0xFFFF4081);
                    dateDialog.setHeaderTextColorUnselected(0x4AFF4081);
                    dateDialog.setDayOfWeekHeaderTextColorSelected(0xFFFF4081);
                    dateDialog.setDayOfWeekHeaderTextColorUnselected(0x4AFF4081);
                }
                break;
            }
        }

        dialog.setThemeDark(themeDark);
        if (custom || customDark) {
            dialog.setAccentColor(0xFFFF4081);
            dialog.setBackgroundColor(custom? 0xFF90CAF9 : 0xFF2196F3);
            dialog.setHeaderColor(custom? 0xFF90CAF9 : 0xFF2196F3);
            dialog.setHeaderTextDark(custom);
        }

        return dialog;
    }

    @Override
    public void onRegister(Boolean result, int code) {
        etFName.setEnabled(true);
        etLName.setEnabled(true);
        etEmail.setEnabled(true);
        etNo.setEnabled(true);
        etCPass.setEnabled(true);
        etCnfPass.setEnabled(true);
        if (result) {
        } else {
            btnRegister.setEnabled(true);
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
                    Toast.makeText(this, "Please fill a valid Password, code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                case -5:
                    Toast.makeText(this, "Please type the Same Password, code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                case -6:
                    Toast.makeText(this, "Please fill a valid email Address, code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                case -7:
                    Toast.makeText(this, "Please fill a valid Phone No, code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                case -8:
                    Toast.makeText(this, "Please fill a valid Dob , code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(this, "Please try Again Later, code = " + code, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onRegistered(Boolean result, int code) {
        System.out.println("-----onRegistered second Please see, code = " + code + ", result: " + result);
        if (result) {
            System.out.println("------- inside onRegistered first Please see, code = " + code + ", result: " + result);
            //Toast.makeText(this, "-----onRegistered second Please see, code = " + code + ", result: " + result, Toast.LENGTH_SHORT).show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //re-enable the button
                   btnRegister.setEnabled(true);
                }
            }, 4000);
            iRegisterPresenter.onRegisteredSucuess();
        } else {
            btnRegister.setEnabled(true);
            etFName.setEnabled(true);
            etLName.setEnabled(true);
            etEmail.setEnabled(true);
            etNo.setEnabled(true);
            etCPass.setEnabled(true);
            etCnfPass.setEnabled(true);
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

    public DOBDetails datePrserFormater(String date){
        DOBDetails dobDetails = new DOBDetails();
        String[] splitStr = date.split("-");
        for(int i=0;i<splitStr.length;i++) {
            String currentDate = splitStr[i];
            if(i == 0) {
                String monthString =splitStr[i];
                dobDetails.setMonth(monthString);
            }else if(i == 1){
                String dayString =splitStr[i];
                dobDetails.setDay(dayString);
            }else if(i == 2){
                String yearString =splitStr[i];
                dobDetails.setYear(yearString);
            }
        }
        return dobDetails;

    }

    @Override
    public void sendPParcelableObj(UserDetails userDetails) {
        Intent intent = new Intent(this, LandingPage.class);
        intent.putExtra("UserDetails", userDetails);
        intent.putExtra("LoginDone", "done");
        intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        setResult(REQUEST_REGISTERED);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(dMainListObservable!=null){
            dMainListObservable.dispose();
        }
    }


}