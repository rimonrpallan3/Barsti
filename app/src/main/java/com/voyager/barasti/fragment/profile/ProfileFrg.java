package com.voyager.barasti.fragment.profile;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.voyager.barasti.R;
import com.voyager.barasti.activity.login.model.UserDetails;
import com.voyager.barasti.fragment.explore.model.exploreList.MainList;
import com.voyager.barasti.fragment.profile.adapter.RecyclerViewProfileServiceListAdapter;
import com.voyager.barasti.fragment.profile.model.PServiceList;
import com.voyager.barasti.fragment.profile.presenter.IProfileFrgPresenter;
import com.voyager.barasti.fragment.profile.presenter.ProfileFrgPresenter;
import com.voyager.barasti.fragment.profile.view.IProfileFragView;

import java.util.ArrayList;
import java.util.List;

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

        iProfileFrgPresenter = new ProfileFrgPresenter(this, activity);
        if (bundle != null) {
            try {
                userDetails = bundle.getParcelable("UserDetails");
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
        }

        setProfileServiceList(rootView);

        return rootView;
    }


    public void setProfileServiceList(View rootView){
        rvProfileListItems = rootView.findViewById(R.id.rvProfileListItems);
        recyclerViewProfileServiceListAdapter = new RecyclerViewProfileServiceListAdapter(pServiceLists, activity);
        rvProfileListItems.setLayoutFrozen(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvProfileListItems.setLayoutManager(mLayoutManager);
        rvProfileListItems.setItemAnimator(new DefaultItemAnimator());
        rvProfileListItems.setAdapter(recyclerViewProfileServiceListAdapter);
        populateProfileListService();
    }


    private void populateProfileListService(){
        PServiceList firstValue = new PServiceList("Notification","");
        PServiceList SecondValue = new PServiceList("Travel for work?","");
        PServiceList ThirdValue = new PServiceList("Credits and coupons","");
        PServiceList FourthValue = new PServiceList("invite friends","");
        PServiceList FifthValue = new PServiceList("Refer a host","");
        PServiceList SixthValue = new PServiceList("Payment","");
        PServiceList SeventhValue = new PServiceList("Learn About Hosting","Earn upto 20BD per month");
        PServiceList EightValue = new PServiceList("List your space","");
        PServiceList ninethValue = new PServiceList("Host an experience","");
        PServiceList TenthValue = new PServiceList("Settings","");
        PServiceList eleventhValue = new PServiceList("Get Help","");
        PServiceList TwelveValue = new PServiceList("Give us Feedback","");
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