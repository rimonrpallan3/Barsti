package com.voyager.barasti.landingpage;


import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


import com.google.gson.Gson;
import com.mikepenz.iconics.context.IconicsLayoutInflater;
import com.mikepenz.iconics.context.IconicsLayoutInflater2;
import com.voyager.barasti.R;
import com.voyager.barasti.common.Helper;
import com.voyager.barasti.landingpage.adapter.LandingListAdapter;
import com.voyager.barasti.landingpage.helper.BackHandledFragment;
import com.voyager.barasti.landingpage.model.drawerHeader.HeaderItem;
import com.voyager.barasti.landingpage.model.drawerList.LandingItems;
import com.voyager.barasti.landingpage.view.ILandingView;
import com.voyager.barasti.splashscreen.model.UserDetails;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




/**
 * Created by User on 8/30/2017.
 */

public class LandingPage extends AppCompatActivity implements View.OnClickListener,LandingListAdapter.ClickListener,
        ILandingView,
        BackHandledFragment.BackHandlerInterface{

    Activity activity;
    public Toolbar toolbar;


    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;

    UserDetails userDetails;

    ImageButton choseTripBackPress;

    Bundle bundle;
    RecyclerView rvLandingList;
    LandingListAdapter landingListAdapter;

    private BackHandledFragment selectedFragment;
    String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Grape", "Kiwi", "Mango", "Pear"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Do something for lollipop and above versions
            LayoutInflaterCompat.setFactory2(getLayoutInflater(), new IconicsLayoutInflater2(getDelegate()));
        } else {
            LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));
            // do something for phones running an SDK before lollipop
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);
        activity = this;

        sharedPrefs = getSharedPreferences(Helper.UserDetails,
                Context.MODE_PRIVATE);
        editor = sharedPrefs.edit();

        rvLandingList = findViewById(R.id.rvLandingList);



        Intent intent = getIntent();
        bundle = new Bundle();
        String hiddenBtn = intent.getStringExtra("btnHiddenBtn");
        userDetails = (UserDetails) intent.getParcelableExtra("UserDetails");
     /*   if (userDetails != null) {
            System.out.println("LandingPage -- UserDetails- name : " + userDetails.getFName());
            System.out.println("LandingPage -- UserDetails- Id : " + userDetails.getUserID());
            System.out.println("LandingPage -- UserDetails- fcm : " + userDetails.getFcm());
        } else if (hiddenBtn != null) {
            // do nothing //
        } else {
            getUserSDetails();
        }
*/
        landingListAdapter = new LandingListAdapter(getData(), this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvLandingList.setLayoutManager(mLayoutManager);
        rvLandingList.setItemAnimator(new DefaultItemAnimator());
        rvLandingList.setAdapter(landingListAdapter);
        landingListAdapter.setClickListener(this);

        //toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.black));
        //Creating the instance of ArrayAdapter containing list of fruit names
       /* ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, fruits);
        //Getting the instance of AutoCompleteTextView
        AutoCompleteTextView actvSearchList = findViewById(R.id.actvSearchList);
        actvSearchList.setThreshold(1);//will start working from first character
        actvSearchList.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        actvSearchList.setTextColor(Color.RED);*/


    }

  /*  public void passVal(IMapFragmentView iMapFragmentView) {
        this.iMapFragmentView = iMapFragmentView;

    }
*/
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        System.out.println("onNewIntent Landing -------------");

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:


        }

        return super.onOptionsItemSelected(item);
    }



    List<LandingItems> landingListItems = Arrays.asList();

    public List<LandingItems> getData() {

        landingListItems = new ArrayList<LandingItems>();
        landingListItems.clear();

        HeaderItem headerItem = new HeaderItem();
        headerItem.setImgHeader(R.drawable.barasti_home_banner);
        headerItem.setBtnContent("Explore Homes");
       // headerItem.setEnabled(true);
        landingListItems.add(headerItem);

        LandingItems yourTripItem = new LandingItems();
        yourTripItem.setName(getResources().getString(R.string.drawer_your_trips));
        yourTripItem.setIconDraw(MaterialDrawableBuilder.IconValue.INFORMATION);
        yourTripItem.setID(1);
        yourTripItem.setEnabled(true);
        landingListItems.add(yourTripItem);

        LandingItems paymentItem = new LandingItems();
        paymentItem.setName(getResources().getString(R.string.drawer_payment));
        paymentItem.setIconDraw(MaterialDrawableBuilder.IconValue.CASH);
        paymentItem.setID(2);
        paymentItem.setEnabled(true);
        landingListItems.add(paymentItem);

        LandingItems hlpItem = new LandingItems();
        //savesItem.setName(getResources().getString(R.string.Favoris)+" ("+bookmaeks_count+")");
        hlpItem.setName(getResources().getString(R.string.drawer_help));
        hlpItem.setIconDraw(MaterialDrawableBuilder.IconValue.HELP);
        hlpItem.setID(3);
        landingListItems.add(hlpItem);

        LandingItems termAndCondItem = new LandingItems();
        //savesItem.setName(getResources().getString(R.string.Favoris)+" ("+bookmaeks_count+")");
        termAndCondItem.setName(getResources().getString(R.string.terms_and_cond));
        termAndCondItem.setIconDraw(MaterialDrawableBuilder.IconValue.FILE_DOCUMENT);
        termAndCondItem.setID(4);
        landingListItems.add(termAndCondItem);

        LandingItems settingItem = new LandingItems();
        //savesItem.setName(getResources().getString(R.string.Favoris)+" ("+bookmaeks_count+")");
        settingItem.setName(getResources().getString(R.string.action_settings));
        settingItem.setIconDraw(MaterialDrawableBuilder.IconValue.SETTINGS);
        settingItem.setID(5);
        landingListItems.add(settingItem);

        return landingListItems;
    }



    /**
     * this method redirects the user to the app page in play store
     */
    private void launchMarket() {
        Uri uri = Uri.parse("market://details?id=" + getPackageName());
        Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            startActivity(myAppLinkToMarket);
        } catch (ActivityNotFoundException e) {
           // Toast.makeText(this, getString(R.string.play_store_warning), Toast.LENGTH_LONG).show();
        }
    }

    private void getUserSDetails() {
        Gson gson = new Gson();
        String json = sharedPrefs.getString("UserDetails", null);
        if (json != null) {
            System.out.println("-----------LandingPage uploadProfileName UserDetails" + json);
            userDetails = gson.fromJson(json, UserDetails.class);
            //emailAddress = userDetails.getEmail();
        }

    }




    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            // case R.id.driverSwitch:

        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.landingContainer);
        //fragment.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case Helper.GET_DRIVER:
                if (resultCode == Activity.RESULT_OK) {
                    System.out.println("LandingPage onActivityResult GET_DRIVER : ");
                }
                break;
            case Helper.LOG_OUT:
                if (resultCode == Activity.RESULT_OK) {
                    System.out.println("LandingPage onActivityResult GET_DRIVER : ");
                    //Intent intent = new Intent(LandingPage.this, LoginSignUpPage.class);
                    //intent.putExtra("logout","logout");
                   // startActivity(intent);
                   // finish();
                }
                break;
            case Helper.PROFILE_IMAGE_SET:
                userDetails = getUserGsonInSharedPrefrences();
                getData();
                //drawerListAdapter.notifyDataSetChanged();
                System.out.println("LandingPage -- onActivityResult PROFILE_IMAGE_SET -  : " );
                break;

            default:
                break;
        }
    }

    public UserDetails getUserGsonInSharedPrefrences(){
        Gson gson = new Gson();
        String json = sharedPrefs.getString("UserDetails", null);
        if(json!=null){
            UserDetails userDetails = gson.fromJson(json, UserDetails.class);
            System.out.println("--------- SplashPresenter getUserGsonInSharedPrefrences"+json);
        }
        return userDetails;

    }



    @Override
    public void hideVisibilityLandingItems(int visibility, String value) {
        if (value.equals("toolbar")) {
            toolbar.setVisibility(visibility);
        } else if (value.equals("backImg")) {
            choseTripBackPress.setVisibility(visibility);
        }
    }

    @Override
    public void setSelectedFragment(BackHandledFragment backHandledFragment) {
        this.selectedFragment = selectedFragment;
    }

    @Override
    public void itemClicked(View view, int position) {

    }

    /*@Override
    public void itemClicked(View view, int position) {
        System.out.println(" ------------ LandingPage itemClicked position : "+position);
        MapFragmentView mf = (MapFragmentView) getSupportFragmentManager().findFragmentByTag(MapFragmentView.TAG);
        LandingItems landingListItems = drawerListAdapter.getData().get(position);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (landingListItems instanceof LandingItems) {
            switch (landingListItems.getID()) {
                case Menu.YOUR_TRIPS:

                    if (mDrawerLayout != null)
                        mDrawerLayout.closeDrawers();
                    Intent intent = new Intent(LandingPage.this, TripHistory.class);
                    intent.putExtra("UserDetails", userDetails);
                    startActivity(intent);

                    break;
                case Menu.PAYMENT:

                    if (mDrawerLayout != null)
                        mDrawerLayout.closeDrawers();
                    intent = new Intent(LandingPage.this, PaymentActivity.class);
                    intent.putExtra("UserDetails", userDetails);
                    startActivity(intent);

                    break;
                case Menu.HELP:

                    if (mDrawerLayout != null)
                        mDrawerLayout.closeDrawers();
                    intent = new Intent(LandingPage.this, HelpActivity.class);
                    intent.putExtra("UserDetails", userDetails);
                    startActivity(intent);
                    *//*
                    getSupportActionBar().setTitle(getResources().getString(R.string.help));
                    HelpFragment helpFragment = new HelpFragment();
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.landingContainer, helpFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();*//*

                    break;
                case Menu.TERMS_AND_CONDITIONS:

                    if (mDrawerLayout != null)
                        mDrawerLayout.closeDrawers();
                    intent = new Intent(LandingPage.this, TermsAndConduction.class);
                    intent.putExtra("UserDetails", userDetails);
                    startActivity(intent);

                    break;
                case Menu.SETTINGS:

                    if (mDrawerLayout != null)
                        mDrawerLayout.closeDrawers();
                    Intent intent2 = new Intent(LandingPage.this, Settings.class);
                    intent2.putExtra("UserDetails", userDetails);
                    startActivityForResult(intent2,Helper.LOG_OUT);

                    break;


            }
        }

    }*/

    private static class Menu {
        public static final int YOUR_TRIPS = 1;
        public static final int PAYMENT = 2;
        public static final int HELP = 3;
        public static final int TERMS_AND_CONDITIONS = 4;
        public static final int SETTINGS = 5;
    }

}
