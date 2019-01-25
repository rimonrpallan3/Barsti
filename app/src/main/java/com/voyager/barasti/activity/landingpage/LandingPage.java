package com.voyager.barasti.activity.landingpage;


import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mikepenz.iconics.context.IconicsLayoutInflater;
import com.mikepenz.iconics.context.IconicsLayoutInflater2;
import com.voyager.barasti.R;
import com.voyager.barasti.activity.splashscreen.model.UserDetail;
import com.voyager.barasti.common.Helper;
import com.voyager.barasti.activity.landingpage.helper.BackHandledFragment;
import com.voyager.barasti.activity.landingpage.view.ILandingView;
import com.voyager.barasti.fragment.explore.ExploreFrg;
import com.voyager.barasti.fragment.fav.FavouriteFag;
import com.voyager.barasti.fragment.inbox.InboxFrg;
import com.voyager.barasti.fragment.profile.ProfileFrg;



/**
 * Created by User on 8/30/2017.
 */

public class LandingPage extends AppCompatActivity implements View.OnClickListener,
        ILandingView,
        BackHandledFragment.BackHandlerInterface  {

    Activity activity;
    public Toolbar toolbar;


    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;

    UserDetail userDetail;

    ImageButton choseTripBackPress;

    Bundle bundle;

    private BackHandledFragment selectedFragment;
    String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Grape", "Kiwi", "Mango", "Pear"};
    public String currentTabFrg;


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


        Intent intent = getIntent();
        bundle = new Bundle();
        String hiddenBtn = intent.getStringExtra("btnHiddenBtn");
        userDetail = (UserDetail) intent.getParcelableExtra("UserDetail");
     /*   if (userDetail != null) {
            System.out.println("LandingPage -- UserDetail- name : " + userDetail.getFName());
            System.out.println("LandingPage -- UserDetail- Id : " + userDetail.getUserID());
            System.out.println("LandingPage -- UserDetail- fcm : " + userDetail.getFcm());
        } else if (hiddenBtn != null) {
            // do nothing //
        } else {
            getUserSDetails();
        }
*/

        ExploreFrg exploreFrg = new ExploreFrg();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, exploreFrg);
        exploreFrg.setArguments(bundle);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        currentTabFrg="explore";

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


    public void clickExplore(View v) {/*
        ivPointer1.setVisibility(View.VISIBLE);
        ivPointer2.setVisibility(View.GONE);
        ivPointer3.setVisibility(View.GONE);*/
        if(currentTabFrg!="explore") {
            Toast.makeText(getApplicationContext(), "Explore Selected", Toast.LENGTH_SHORT).show();
            ExploreFrg exploreFrg = new ExploreFrg();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, exploreFrg);
            exploreFrg.setArguments(bundle);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            currentTabFrg = "explore";
        }else {
            Toast.makeText(getApplicationContext(),"Your in Explore Frg",Toast.LENGTH_LONG).show();
        }
    }

    public void clickFav(View v) {/*
        ivPointer1.setVisibility(View.GONE);
        ivPointer2.setVisibility(View.VISIBLE);
        ivPointer3.setVisibility(View.GONE);*/
        if(currentTabFrg!="fav") {
            Toast.makeText(getApplicationContext(), "Fav Selected", Toast.LENGTH_SHORT).show();
            FavouriteFag favouriteFag = new FavouriteFag();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, favouriteFag);
            favouriteFag.setArguments(bundle);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            currentTabFrg = "fav";
        }else {
            Toast.makeText(getApplicationContext(),"Your in Fav Frg",Toast.LENGTH_LONG).show();
        }
    }

    public void clickInbox(View v) {/*
        ivPointer1.setVisibility(View.GONE);
        ivPointer2.setVisibility(View.GONE);
        ivPointer3.setVisibility(View.VISIBLE);*/
        if(currentTabFrg!="inbox") {
            Toast.makeText(getApplicationContext(), "Inbox Selected", Toast.LENGTH_SHORT).show();
            InboxFrg inboxFrg = new InboxFrg();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, inboxFrg);
            inboxFrg.setArguments(bundle);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            currentTabFrg = "inbox";
        }else {
            Toast.makeText(getApplicationContext(),"Your in Inbox Frg",Toast.LENGTH_LONG).show();
        }
    }

    public void clickProfile(View v) {/*
        ivPointer1.setVisibility(View.GONE);
        ivPointer2.setVisibility(View.GONE);
        ivPointer3.setVisibility(View.VISIBLE);*/
        if(currentTabFrg != "profile") {
            Toast.makeText(getApplicationContext(), "Profile Selected", Toast.LENGTH_SHORT).show();
            ProfileFrg profileFrg = new ProfileFrg();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, profileFrg);
            profileFrg.setArguments(bundle);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            currentTabFrg = "profile";
        }else {
            Toast.makeText(getApplicationContext(),"Your in Profile Frg",Toast.LENGTH_LONG).show();
        }
    }



    @Override
    public void onBackPressed () {
        super.onBackPressed();
        finish();
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
        String json = sharedPrefs.getString("UserDetail", null);
        if (json != null) {
            System.out.println("-----------LandingPage uploadProfileName UserDetail" + json);
            userDetail = gson.fromJson(json, UserDetail.class);
            //emailAddress = userDetail.getEmail();
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
                userDetail = getUserGsonInSharedPrefrences();
                //drawerListAdapter.notifyDataSetChanged();
                System.out.println("LandingPage -- onActivityResult PROFILE_IMAGE_SET -  : ");
                break;

            default:
                break;
        }
    }

    public UserDetail getUserGsonInSharedPrefrences() {
        Gson gson = new Gson();
        String json = sharedPrefs.getString("UserDetail", null);
        if (json != null) {
            UserDetail userDetail = gson.fromJson(json, UserDetail.class);
            System.out.println("--------- SplashPresenter getUserGsonInSharedPrefrences" + json);
        }
        return userDetail;

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


    /*@Override
    public void itemClicked(View view, int position) {
        System.out.println(" ------------ LandingPage itemClicked position : "+position);
        MapFragmentView mf = (MapFragmentView) getSupportFragmentManager().findFragmentByTag(MapFragmentView.TAG);
        ExploreItems landingListItems = drawerListAdapter.getData().get(position);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (landingListItems instanceof ExploreItems) {
            switch (landingListItems.getID()) {
                case Menu.YOUR_TRIPS:

                    if (mDrawerLayout != null)
                        mDrawerLayout.closeDrawers();
                    Intent intent = new Intent(LandingPage.this, TripHistory.class);
                    intent.putExtra("UserDetail", userDetail);
                    startActivity(intent);

                    break;
                case Menu.PAYMENT:

                    if (mDrawerLayout != null)
                        mDrawerLayout.closeDrawers();
                    intent = new Intent(LandingPage.this, PaymentActivity.class);
                    intent.putExtra("UserDetail", userDetail);
                    startActivity(intent);

                    break;
                case Menu.HELP:

                    if (mDrawerLayout != null)
                        mDrawerLayout.closeDrawers();
                    intent = new Intent(LandingPage.this, HelpActivity.class);
                    intent.putExtra("UserDetail", userDetail);
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
                    intent.putExtra("UserDetail", userDetail);
                    startActivity(intent);

                    break;
                case Menu.SETTINGS:

                    if (mDrawerLayout != null)
                        mDrawerLayout.closeDrawers();
                    Intent intent2 = new Intent(LandingPage.this, Settings.class);
                    intent2.putExtra("UserDetail", userDetail);
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
