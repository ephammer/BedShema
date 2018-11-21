package com.thinkhodl.bedshema;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;


import com.thinkhodl.bedshema.fragments.BedShemaFragment;
import com.thinkhodl.bedshema.fragments.BirkathHalevanahFragment;
import com.thinkhodl.bedshema.fragments.BirkothHashrarFragment;
import com.thinkhodl.bedshema.fragments.TphilathBhFragment;
import com.thinkhodl.bedshema.fragments.TravelPrayerFragment;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;

    // Action Bar
    private Toolbar myToolbar;
    // Action Bar Title
    private TextView mToolbarTitle;
    private SharedPreferences mSharedPref;
    private int mThemeMode;

    private ActionBarDrawerToggle drawerToggle;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Context context = this;
        mSharedPref = context.getSharedPreferences(
                getString(R.string.preference_file_key),
                Context.MODE_PRIVATE);

        mThemeMode = mSharedPref.getInt(getString(R.string.saved_theme_mode),
                AppCompatDelegate.MODE_NIGHT_AUTO);

        AppCompatDelegate.setDefaultNightMode( mThemeMode);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Set the toolbar
        myToolbar = findViewById(R.id.toolbar);
        myToolbar.setTitle("");
        setSupportActionBar(myToolbar);


        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        setActionBarItems();


        // Set the title for the Action Bar
        mToolbarTitle = findViewById(R.id.toolbar_title);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        drawerToggle = setupDrawerToggle();

        // Tie DrawerLayout events to the ActionBarToggle
        mDrawerLayout.addDrawerListener(drawerToggle);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Set default position navigation drawer
        if (savedInstanceState == null) {
            MenuItem item =  navigationView.getMenu().getItem(0);
            onNavigationItemSelected(item);
        }

    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, mDrawerLayout, myToolbar, R.string.drawer_open,  R.string.drawer_close);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    /*
     * Change the Status Bar to black and removes notification icons
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setActionBarItems() {
        Window window = getWindow();
        window.setStatusBarColor(getColor(R.color.colorSecondaryLight));
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
    }

    // Menu icon clicked opens Navigation Drawer
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Handle navigation view item clicks here.
        switch (menuItem.getItemId()) {
            case R.id.nav_shema:

                // Insert the fragment by replacing any existing fragment
                fragmentManager.beginTransaction().replace(R.id.prayer_fragment_container,
                        new BedShemaFragment()).commit();

                /*
                mAdapter = new PrayerAdapter(PrayerLists.getmShemaPrayer(), this);
                mRecyclerView.setAdapter(mAdapter);
                // change title
                mToolbarTitle.setText(getString(R.string.shema_english));
                */

                // set item as selected to persist highlight
                menuItem.setChecked(true);
                // close drawer when item is tapped
                mDrawerLayout.closeDrawers();
                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here


                return true;

            case R.id.nav_birkoth_hashrar:

                // Insert the fragment by replacing any existing fragment
                fragmentManager.beginTransaction().replace(R.id.prayer_fragment_container,
                        new BirkothHashrarFragment()).commit();

                /*
                mAdapter = new PrayerAdapter(PrayerLists.getmBirkathHasharar(), this);
                mRecyclerView.setAdapter(mAdapter);
                // change title
                mToolbarTitle.setText(getString(R.string.preparatory_prayers_title));
                */

                // set item as selected to persist highlight
                menuItem.setChecked(true);
                // close drawer when item is tapped
                mDrawerLayout.closeDrawers();

                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here


                return true;

            case R.id.nav_tphilath_bh:

                // Insert the fragment by replacing any existing fragment
                fragmentManager.beginTransaction().replace(R.id.prayer_fragment_container,
                        new TphilathBhFragment()).commit();

                /*
                mAdapter = new PrayerAdapter(PrayerLists.getmTphilathBH(), this);
                mRecyclerView.setAdapter(mAdapter);
                // change title
                mToolbarTitle.setText("Tphilath Beith Hamidrash");
                */


                // set item as selected to persist highlight
                menuItem.setChecked(true);
                // close drawer when item is tapped
                mDrawerLayout.closeDrawers();

                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here


                return true;

            case R.id.nav_travel_prayer:
                // Insert the fragment by replacing any existing fragment
                fragmentManager.beginTransaction().replace(R.id.prayer_fragment_container,
                        new TravelPrayerFragment()).commit();

                /*
                mAdapter = new PrayerAdapter(PrayerLists.getmTphilathHaerech(), this);
                mRecyclerView.setAdapter(mAdapter);
                // change title
                mToolbarTitle.setText(getString(R.string.travel_prayer_title));

                */
                // set item as selected to persist highlight
                menuItem.setChecked(true);
                // close drawer when item is tapped
                mDrawerLayout.closeDrawers();

                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here

                return true;

            case R.id.nav_bitkath_halevoneh:

                // Insert the fragment by replacing any existing fragment
                fragmentManager.beginTransaction().replace(R.id.prayer_fragment_container,
                        new BirkathHalevanahFragment()).commit();

                /*
                mAdapter = new PrayerAdapter(PrayerLists.getmBirkathHalevanah(), this);
                mRecyclerView.setAdapter(mAdapter);

                // change title
                mToolbarTitle.setText(getString(R.string.birkath_halevoneh_title));
                */

                // set item as selected to persist highlight
                menuItem.setChecked(true);
                // close drawer when item is tapped
                mDrawerLayout.closeDrawers();

                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here

                return true;

            case R.id.nav_settings:
                startActivityForResult(new Intent(this, SettingsActivity.class),1);
                return true;


            case R.id.nav_contact:
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("message/rfc822");
                intent.setData(Uri.parse("mailto:contact@thinkhodl.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback BedShema app");
                startActivity(Intent.createChooser(intent, "Contact"));
                return true;

            case R.id.nav_share:
                Intent shareLinkIntent = new Intent(Intent.ACTION_SEND);
                shareLinkIntent.setType("text/plain");
                shareLinkIntent.putExtra(Intent.EXTRA_SUBJECT,
                        "Take a look at this amazing app");
                shareLinkIntent.putExtra(Intent.EXTRA_TEXT,
                        "Take a look at this amazing app!\n\n" +
                                "https://play.google.com/store/apps/details?id=com.thinkhodl.bedshema");
                startActivity(Intent.createChooser(shareLinkIntent, "Share the App"));
                return true;

        }

        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onResume() {
        super.onResume();
        setActionBarItems();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    private void loadUsersPreference() {

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == RESULT_CANCELED) {
                recreate();
            }
        }
    }
}
