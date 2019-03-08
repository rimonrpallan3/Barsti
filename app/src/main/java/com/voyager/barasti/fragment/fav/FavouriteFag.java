package com.voyager.barasti.fragment.fav;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.voyager.barasti.R;
import com.voyager.barasti.activity.login.model.UserDetails;
import com.voyager.barasti.activity.typelist.adapter.TypedListAdapter;
import com.voyager.barasti.activity.typelist.presenter.ITypeListPresenter;
import com.voyager.barasti.activity.typelist.presenter.TypeListPresenter;
import com.voyager.barasti.fragment.explore.adapter.ExploreListAdapter;
import com.voyager.barasti.fragment.fav.adapter.FavLikedAdapter;
import com.voyager.barasti.fragment.fav.model.FavDetail;
import com.voyager.barasti.fragment.fav.presenter.FavLikedPresenter;
import com.voyager.barasti.fragment.fav.presenter.IFavLikedPresenter;
import com.voyager.barasti.fragment.fav.view.IFavLikedView;

import java.util.ArrayList;

import io.reactivex.disposables.Disposable;

/**
 * Created by User on 11-Dec-18.
 */

public class FavouriteFag extends Fragment implements IFavLikedView{


    private Activity activity;
    RecyclerView rvFavList;
    IFavLikedPresenter iFavLikedPresenter;
    FavLikedAdapter favLikedAdapter;
    Bundle bundle;
    UserDetails userDetails;
    LinearLayout llImgNo;
    Disposable dMainListObservable;

    public FavouriteFag() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView;
        rootView   = inflater.inflate(R.layout.fragment_favourite, container, false);
        activity = getActivity();
        bundle = this.getArguments();
        rvFavList = rootView.findViewById(R.id.rvFavList);
        llImgNo = rootView.findViewById(R.id.llImgNo);
        iFavLikedPresenter = new FavLikedPresenter(this, activity);
        if (bundle != null) {
            try {
                userDetails = bundle.getParcelable("UserDetails");
                System.out.println("user Id : "+ userDetails.getId());
                iFavLikedPresenter.getFavLikedData(userDetails.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Bundle Is null ");
        }
        return rootView;
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
        if(dMainListObservable!=null)
        dMainListObservable.dispose();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

    }

    @Override
    public void setFavAdapterList(ArrayList<FavDetail> favAdapterList) {
        if(favAdapterList.size()>0) {
            favLikedAdapter = new FavLikedAdapter(favAdapterList, getActivity(), iFavLikedPresenter, userDetails.getId());
            rvFavList.setLayoutFrozen(true);
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            rvFavList.setLayoutManager(mLayoutManager);
            rvFavList.setItemAnimator(new DefaultItemAnimator());
            rvFavList.setAdapter(favLikedAdapter);
        }else {
            llImgNo.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setDefaultImg() {
        llImgNo.setVisibility(View.VISIBLE);
    }

    @Override
    public void unSubscribeCalls(Disposable dMainListObservable) {
        this.dMainListObservable = dMainListObservable;
    }
}