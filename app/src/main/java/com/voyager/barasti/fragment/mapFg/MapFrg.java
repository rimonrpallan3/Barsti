package com.voyager.barasti.fragment.mapFg;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.directions.route.Route;
import com.directions.route.RouteException;
import com.directions.route.RoutingListener;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.voyager.barasti.R;
import com.voyager.barasti.fragment.mapFg.helper.MapStateManager;

import java.util.ArrayList;

/**
 * Created by User on 11-Dec-18.
 */

public class MapFrg extends Fragment implements
        RoutingListener,
        GoogleMap.OnMarkerClickListener,
        OnMapReadyCallback, LocationListener,
        View.OnClickListener {

    private Activity activity;
    Bundle mapViewBundle = null;
    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";

    MapView mvProfile;
    private GoogleMap googleMap;
    View rootView;

    private static final String TAG = MapFrg.class.getSimpleName();
    private static final int REQUEST_PERMISSIONS_REQUEST_CODE = 34;

    Bundle bundle;


    double lat = 26.2285;
    double log = 50.5860;
    String address = "";


    public MapFrg() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        rootView = inflater.inflate(R.layout.fragment_map, container, false);
        activity = getActivity();
        bundle = this.getArguments();
        mvProfile = rootView.findViewById(R.id.mvProfile);

        // Needs to call MapsInitializer before doing any CameraUpdateFactory calls
        MapsInitializer.initialize(this.getActivity());


        mvProfile.onCreate(savedInstanceState);
        mvProfile.getMapAsync(this);


        return rootView;
    }


    @Override
    public void onStart() {
        super.onStart();
        mvProfile.onStart();
        if (!checkPermissions()) {
            requestPermissions();
        } else {
        }
    }

    /**
     * Return the current state of the permissions needed.
     */
    private boolean checkPermissions() {
        int permissionState = ActivityCompat.checkSelfPermission(activity,
                android.Manifest.permission.ACCESS_FINE_LOCATION);
        return permissionState == PackageManager.PERMISSION_GRANTED;
    }


    /**
     * Shows a {@link Snackbar}.
     *
     * @param mainTextStringId The id for the string resource for the Snackbar text.
     * @param actionStringId   The text of the action item.
     * @param listener         The listener associated with the Snackbar action.
     */
    private void showSnackbar(final int mainTextStringId, final int actionStringId,
                              View.OnClickListener listener) {
        Snackbar.make(rootView.findViewById(android.R.id.content),
                getString(mainTextStringId),
                Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(actionStringId), listener).show();
    }


    private void requestPermissions() {
        boolean shouldProvideRationale =
                ActivityCompat.shouldShowRequestPermissionRationale(activity,
                        android.Manifest.permission.ACCESS_FINE_LOCATION);

        // Provide an additional rationale to the user. This would happen if the user denied the
        // request previously, but didn't check the "Don't ask again" checkbox.
        if (shouldProvideRationale) {
            Log.i(TAG, "Displaying permission rationale to provide additional context.");

            showSnackbar(R.string.permission_rationale, android.R.string.ok,
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // Request permission
                            ActivityCompat.requestPermissions(activity,
                                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                                    REQUEST_PERMISSIONS_REQUEST_CODE);
                        }
                    });

        } else {
            Log.i(TAG, "Requesting permission");
            // Request permission. It's possible this can be auto answered if device policy
            // sets the permission in a given state or the user denied the permission
            // previously and checked "Never ask again".
            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_PERMISSIONS_REQUEST_CODE);
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        mvProfile.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mvProfile.onPause();
        /*MapStateManager mgr = new MapStateManager(getActivity());
        mgr.saveMapState(googleMap);
        Toast.makeText(getContext(), "Map State has been save?", Toast.LENGTH_SHORT).show();*/
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            mvProfile.onDestroy();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mvProfile.onLowMemory();
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onRoutingFailure(RouteException e) {

    }

    @Override
    public void onRoutingStart() {

    }

    @Override
    public void onRoutingSuccess(ArrayList<Route> arrayList, int i) {

    }

    @Override
    public void onRoutingCancelled() {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        if (bundle != null) {
            try {
                address = bundle.getString("address");
                lat = bundle.getDouble("lat");
                log = bundle.getDouble("log");
                googleMap.getUiSettings().setZoomControlsEnabled(true);
                googleMap.addMarker(new MarkerOptions().position(new LatLng(lat, log)).title(address));
                CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(lat, log));
                CameraUpdate zoom = CameraUpdateFactory.zoomTo(10);
                googleMap.moveCamera(center);
                googleMap.animateCamera(zoom);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("MapFrg -- bundle- lat : " + lat);
        }

    }
}