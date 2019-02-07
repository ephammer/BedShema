package com.thinkhodl.bedshema.fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.thinkhodl.bedshema.R;
import com.thinkhodl.bedshema.backend.Utils;

import net.sourceforge.zmanim.ComplexZmanimCalendar;

import java.util.Objects;

import javax.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZmanimFragment extends Fragment {

    private static final int MY_PERMISSIONS_REQUEST_COARSE_LOCATION = 230;

    @Nullable
    @BindView(R.id.zmanim_linear_layout)
    LinearLayout mZmanimLinearLayout;

    @Nullable
    @BindView(R.id.textView_location_rationale)
    TextView mLocationRationaleTextView;

    @Nullable
    @BindView(R.id.textView_dawn_time)
    TextView mDawnTextView;

    @Nullable
    @BindView(R.id.textView_earliest_talis_tefillin_time)
    TextView mEarliestTalisTefillinTextView;

    @Nullable
    @BindView(R.id.textView_sunrise_time)
    TextView mSunriseTextView;

    @Nullable
    @BindView(R.id.textView_latest_shema_magen_avraham_time)
    TextView mLatestShemaMATextView;

    @Nullable
    @BindView(R.id.textView_latest_shema_gra_baal_hatanya_time)
    TextView mLatestShemaGraTextView;

    @Nullable
    @BindView(R.id.textView_latest_shachris_gra_baal_hatanya_time)
    TextView mLatestShachrisGraTextView;

    @Nullable
    @BindView(R.id.textView_midday_time)
    TextView mMiddayTextView;

    @Nullable
    @BindView(R.id.textView_earliest_mincha_time)
    TextView mEarliestMinchaTextView;

    @Nullable
    @BindView(R.id.textView_plag_hamincha_time)
    TextView mPlagHaMinchaTextView;

    @Nullable
    @BindView(R.id.textView_sunset_time)
    TextView mSunsetTextView;

    @Nullable
    @BindView(R.id.textView_nightfall_three_stars_time)
    TextView mNightfallThreeStarsTextView;

    @Nullable
    @BindView(R.id.textView_nightfall_seventy_two_minutes_time)
    TextView mNightfallSeventyTwoMinutesTextView;

    @Nullable
    @BindView(R.id.earthplussateliteImageView)
    ImageView mEarthPlusSateliteImageView;

    @Nullable
    @BindView(R.id.location_permission_button)
    Button mLocationPermissionButton;

    @Nullable
    @BindView(R.id.missing_permission_location_layout)
    LinearLayout mMissingPermissionLocationLayout;

    public ZmanimFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View rootView = inflater.inflate(R.layout.fragment_zmanim, container, false);

        ButterKnife.bind(this, rootView);

        Toolbar mToolbar = Objects.requireNonNull(getActivity()).findViewById(R.id.toolbar);
        TextView mToolbarTitle = mToolbar.findViewById(R.id.toolbar_title);

        if (mToolbarTitle != null)
            mToolbarTitle.setText(getString(R.string.zmanim_title));

        methodRequiresPermission();

        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_COARSE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    getUserLocation(getContext());
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    showError();
                }
            }
            break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);

                // other 'case' lines to check for other
                // permissions this app might request.
        }
    }

    private void methodRequiresPermission() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_COARSE_LOCATION)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                showError();
            } else {
                // No explanation needed; request the permission
                showError();

                // MY_PERMISSIONS_REQUEST_COARSE_LOCATION is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
            getUserLocation(getContext());
        }
    }


    private void showError() {
        mMissingPermissionLocationLayout.setVisibility(View.VISIBLE);
        mZmanimLinearLayout.setVisibility(View.GONE);
        mLocationPermissionButton.setVisibility(View.VISIBLE);
        mLocationRationaleTextView.setText(R.string.location_rationale);


        Animation rotation = AnimationUtils.loadAnimation(getContext(), R.anim.rotation);
        mEarthPlusSateliteImageView.startAnimation(rotation);

        mLocationPermissionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermissions(
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        MY_PERMISSIONS_REQUEST_COARSE_LOCATION);
            }
        });
    }

    private void showGPSError() {
        mMissingPermissionLocationLayout.setVisibility(View.VISIBLE);
        mZmanimLinearLayout.setVisibility(View.GONE);

        Animation rotation = AnimationUtils.loadAnimation(getContext(), R.anim.rotation);
        mEarthPlusSateliteImageView.startAnimation(rotation);

        mLocationPermissionButton.setVisibility(View.GONE);
        mLocationRationaleTextView.setText(R.string.location_error_acquisition);

    }
    private void showZmanim(Location location) {
        ComplexZmanimCalendar complexZmanimCalendar = Utils.getComplexZmanimCalendar(location);

        mDawnTextView.setText(Utils.formatTime(Utils.getDawnTime(complexZmanimCalendar)));
        mEarliestTalisTefillinTextView.setText(Utils.formatTime(Utils.getEarliestTalisTefillinTime(complexZmanimCalendar)));
        mSunriseTextView.setText(Utils.formatTime(Utils.getSunriseTime(complexZmanimCalendar)));
        mLatestShemaMATextView.setText(Utils.formatTime(Utils.getLatestShemaMATime(complexZmanimCalendar)));
        mLatestShemaGraTextView.setText(Utils.formatTime(Utils.getLatestShemaGraTime(complexZmanimCalendar)));
        mLatestShachrisGraTextView.setText(Utils.formatTime(Utils.getLatestShachrisGraTime(complexZmanimCalendar)));
        mMiddayTextView.setText(Utils.formatTime(Utils.getMiddayTime(complexZmanimCalendar)));
        mEarliestMinchaTextView.setText(Utils.formatTime(Utils.getEarliestMinchaTime(complexZmanimCalendar)));
        mPlagHaMinchaTextView.setText(Utils.formatTime(Utils.getPlagHaMinchaTime(complexZmanimCalendar)));
        mSunsetTextView.setText(Utils.formatTime(Utils.getSunsetTime(complexZmanimCalendar)));
        mNightfallThreeStarsTextView.setText(Utils.formatTime(Utils.getNightfallThreeStarsTime(complexZmanimCalendar)));
        mNightfallSeventyTwoMinutesTextView.setText(Utils.formatTime(Utils.getNightfallSeventyTwoMinutesTime(complexZmanimCalendar)));


        mMissingPermissionLocationLayout.setVisibility(View.GONE);
        mZmanimLinearLayout.setVisibility(View.VISIBLE);


    }

    @SuppressLint("MissingPermission")
    public void getUserLocation(final Context context) {
        FusedLocationProviderClient mFusedLocationClient;
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(context);
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(getActivity(), location -> {
                    // Got last known location. In some rare situations this can be null.
                    if (location != null) {
                        showZmanim(location);
                    } else {
                        showGPSError();
                    }

                });
    }

}
