package com.voyager.barasti.fragment.profile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.voyager.barasti.R;
import com.voyager.barasti.activity.UpdateProfile.UpdateProfile;
import com.voyager.barasti.activity.landingpage.LandingPage;
import com.voyager.barasti.activity.login.model.UserDetails;
import com.voyager.barasti.common.Helper;
import com.voyager.barasti.fragment.explore.model.exploreList.MainList;
import com.voyager.barasti.fragment.profile.adapter.RecyclerViewProfileServiceListAdapter;
import com.voyager.barasti.fragment.profile.model.PServiceList;
import com.voyager.barasti.fragment.profile.presenter.IProfileFrgPresenter;
import com.voyager.barasti.fragment.profile.presenter.ProfileFrgPresenter;
import com.voyager.barasti.fragment.profile.view.IProfileFragView;

import java.util.ArrayList;
import java.util.List;

import static com.voyager.barasti.common.Helper.REQUEST_REGISTERED;

/**
 * Created by User on 11-Dec-18.
 */

public class ProfileFrg extends Fragment implements IProfileFragView{


    private Activity activity;
    IProfileFrgPresenter iProfileFrgPresenter;
    RecyclerView rvProfileListItems;
    List<PServiceList> pServiceLists;
    RecyclerViewProfileServiceListAdapter recyclerViewProfileServiceListAdapter;
    Bundle bundle;
    UserDetails userDetails;
    TextView tvUserName;
    TextView tvEditProfile;

    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;


    public ProfileFrg() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView;
        rootView   = inflater.inflate(R.layout.fragment_profile, container, false);
        activity = getActivity();
        bundle = this.getArguments();
        pServiceLists = new ArrayList<>();
        tvUserName = rootView.findViewById(R.id.tvUserName);
        tvEditProfile = rootView.findViewById(R.id.tvEditProfile);

        sharedPrefs = activity.getSharedPreferences(Helper.UserDetails,
                Context.MODE_PRIVATE);
        editor = sharedPrefs.edit();

        iProfileFrgPresenter = new ProfileFrgPresenter(this, activity);
        userDetails = getUserSDetails();
        if(userDetails.getUserName()!=null){
            tvUserName.setText(userDetails.getUserName());
        }else if(userDetails.getFirst_name()!=null){
            tvUserName.setText(userDetails.getFirst_name());
        }

      /*  if (bundle != null) {
            try {
                //userDetails = bundle.getParcelable("UserDetails");
                userDetails = getUserSDetails();
                if(userDetails.getUserName()!=null){
                tvUserName.setText(userDetails.getUserName());
                }else if(userDetails.getFirst_name()!=null){
                    tvUserName.setText(userDetails.getFirst_name());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Bundle Is null ");
        }*/
        tvEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UpdateProfile.class);
                intent.putExtra("UserDetails", userDetails);
                startActivityForResult(intent,123);
            }
        });

        setProfileServiceList(rootView);

        return rootView;
    }

    private UserDetails getUserSDetails() {
        Gson gson = new Gson();
        String json = sharedPrefs.getString("UserDetails", null);
        if (json != null) {
            System.out.println("-----------LandingPage uploadProfileName UserDetail" + json);
            userDetails = gson.fromJson(json, UserDetails.class);
            //emailAddress = userDetail.getEmail();
        }
        return userDetails;

    }


    public void setProfileServiceList(View rootView){
        rvProfileListItems = rootView.findViewById(R.id.rvProfileListItems);
        recyclerViewProfileServiceListAdapter = new RecyclerViewProfileServiceListAdapter(pServiceLists, activity,userDetails);
        rvProfileListItems.setLayoutFrozen(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvProfileListItems.setLayoutManager(mLayoutManager);
        rvProfileListItems.setItemAnimator(new DefaultItemAnimator());
        rvProfileListItems.setAdapter(recyclerViewProfileServiceListAdapter);
        populateProfileListService();
    }


    private void populateProfileListService(){
        PServiceList firstValue = new PServiceList(0,"User Property List","");
        PServiceList SecondValue = new PServiceList(1,"Travel for work?","");
        PServiceList ThirdValue = new PServiceList(2,"Credits and coupons","");
        PServiceList FourthValue = new PServiceList(3,"invite friends","");
        PServiceList FifthValue = new PServiceList(4,"Refer a host","");
        PServiceList SixthValue = new PServiceList(5,"Payment","");
        PServiceList SeventhValue = new PServiceList(6,"Learn About Hosting","Earn upto 20BD per month");
        PServiceList EightValue = new PServiceList(7,"List your space","");
        PServiceList ninethValue = new PServiceList(8,"Host an experience","");
        PServiceList TenthValue = new PServiceList(9,"Settings","");
        PServiceList eleventhValue = new PServiceList(10,"Get Help","");
        PServiceList TwelveValue = new PServiceList(11,"Give us Feedback","");
        pServiceLists.add(firstValue);
        pServiceLists.add(SecondValue);
        pServiceLists.add(ThirdValue);
        pServiceLists.add(FourthValue);
        pServiceLists.add(FifthValue);
        pServiceLists.add(SixthValue);
        pServiceLists.add(SeventhValue);
        pServiceLists.add(EightValue);
        pServiceLists.add(ninethValue);
        pServiceLists.add(TenthValue);
        pServiceLists.add(eleventhValue);
        pServiceLists.add(TwelveValue);
        recyclerViewProfileServiceListAdapter.notifyDataSetChanged();
    }

    public void tvEditProfileClick(View v){

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        /*landing_search_filter_language_recycleView.setOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView,
                                             int newState) {
                // TODO Auto-generated method stub
                if (newState < 1) {

                } else {

                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                // TODO Auto-generated method stub
                if (dy > 0) {

                } else {

                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });
*/
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        userDetails = getUserSDetails();
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
}