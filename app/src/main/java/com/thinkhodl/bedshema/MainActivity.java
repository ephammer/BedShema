package com.thinkhodl.bedshema;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.thinkhodl.bedshema.backend.Prayer;
import com.thinkhodl.bedshema.backend.PrayerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter<PrayerAdapter.ViewHolder> mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<Prayer> mShemaPrayer;
    private ArrayList<Prayer> mBirkathHasharar;
    private ArrayList<Prayer> mTphilathBH;
    private ArrayList<Prayer> mTphilathHaerech;
    private ArrayList<Prayer> mBirathHalevanah;

    private DrawerLayout mDrawerLayout;

    // Action Bar
    private Toolbar myToolbar;
    // Action Bar Title
    private TextView mToolbarTitle;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Bed shema
        mShemaPrayer = new ArrayList<>();

        mShemaPrayer.add(new Prayer(R.string.bed_shema_first_benediction, Prayer.TYPE_MAIN_PRAYER));
        mShemaPrayer.add(new Prayer(R.string.bed_shema_shema_intro, Prayer.TYPE_SUBTITLE));
        mShemaPrayer.add(new Prayer(R.string.bed_shema_shema, Prayer.TYPE_TITLE));
        mShemaPrayer.add(new Prayer(R.string.bed_shema_shema_baruch_shem_kevod, Prayer.TYPE_SUBTITLE));
        mShemaPrayer.add(new Prayer(R.string.bed_shema_shema_firstparagraph));
        mShemaPrayer.add(new Prayer(R.string.bed_shema_tehilim_01));
        mShemaPrayer.add(new Prayer(R.string.bed_shema_tehilim_02));
        mShemaPrayer.add(new Prayer(R.string.bed_shema_tehilim_03));
        mShemaPrayer.add(new Prayer(R.string.bed_shema_tehilim_04));
        mShemaPrayer.add(new Prayer(R.string.bed_shema_tehilim_05));
        mShemaPrayer.add(new Prayer(R.string.bed_shema_tehilim_06));
        mShemaPrayer.add(new Prayer(R.string.bed_shema_tehilim_07));
        mShemaPrayer.add(new Prayer(R.string.bed_shema_three_times, Prayer.TYPE_CAPTION));
        mShemaPrayer.add(new Prayer(R.string.bed_shema_tehilim_08));
        mShemaPrayer.add(new Prayer(R.string.bed_shema_tehilim_09));
        mShemaPrayer.add(new Prayer(R.string.bed_shema_tehilim_10));
        mShemaPrayer.add(new Prayer(R.string.bed_shema_tehilim_11));
        mShemaPrayer.add(new Prayer(R.string.bed_shema_tehilim_12));
        mShemaPrayer.add(new Prayer(R.string.bed_shema_tehilim_13));

        // Preparatory Prayers
        mBirkathHasharar = new ArrayList<>();
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_ma_tovu));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_adon_olam));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_netliath));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_asher_yosar));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_elokhai_neshama));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_birkoth_hashachar));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_yehy_rason_1));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_yehy_rason_2));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_yehy_rason_3));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_yehy_rason_4));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_yehy_rason_5));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_yehy_rason_6));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_yehy_rason_7, Prayer.TYPE_TITLE));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_yehy_rason_8));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_yehy_rason_9));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_birkath_hatorah));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_parashath_hatamid));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_parashath_haketoreth_1));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_parashath_haketoreth_2));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_parashath_haketoreth_3));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_korbanoth_rosh_hodesh_title, Prayer.TYPE_CAPTION));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_korbanoth_rosh_hodesh));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_dinei_zvachim_1));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_dinei_zvachim_2));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_dinei_zvachim_3));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_dinei_zvachim_4));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_dinei_zvachim_5));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_dinei_zvachim_6));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_dinei_zvachim_7));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_dinei_zvachim_8));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_divrei_ribbi_yshmael));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_last_yehyeh_chason));

        // Tphilath BH
        mTphilathBH = new ArrayList<>();
        mTphilathBH.add(new Prayer(R.string.tphilath_bh_before_english_intro, Prayer.TYPE_CAPTION));
        mTphilathBH.add(new Prayer(R.string.tphilath_bh_before));
        mTphilathBH.add(new Prayer(R.string.tphilath_bh_after_english_intro, Prayer.TYPE_CAPTION));
        mTphilathBH.add(new Prayer(R.string.tphilath_bh_after));

        // Tphilath Haderech
        mTphilathHaerech = new ArrayList<>();
        mTphilathHaerech.add(new Prayer(R.string.travel_prayer));

        // Birkath Halevanah
        mBirathHalevanah = new ArrayList<>();
        mBirathHalevanah.add(new Prayer(R.string.birkath_halevanah_beroche));
        mBirathHalevanah.add(new Prayer(R.string.bed_shema_three_times, Prayer.TYPE_CAPTION));
        mBirathHalevanah.add(new Prayer(R.string.birkath_halevanah_yotser));
        mBirathHalevanah.add(new Prayer(R.string.bed_shema_three_times, Prayer.TYPE_CAPTION));
        mBirathHalevanah.add(new Prayer(R.string.birkath_halevanah_roked));
        mBirathHalevanah.add(new Prayer(R.string.bed_shema_three_times, Prayer.TYPE_CAPTION));
        mBirathHalevanah.add(new Prayer(R.string.birkath_halevanah_tipol));
        mBirathHalevanah.add(new Prayer(R.string.birkath_halevanah_david));
        mBirathHalevanah.add(new Prayer(R.string.bed_shema_three_times, Prayer.TYPE_CAPTION));
        mBirathHalevanah.add(new Prayer(R.string.birkath_halevanah_shalom));
        mBirathHalevanah.add(new Prayer(R.string.bed_shema_three_times, Prayer.TYPE_CAPTION));
        mBirathHalevanah.add(new Prayer(R.string.birkath_halevanah_siman_tov));

        mRecyclerView = findViewById(R.id.recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new PrayerAdapter(mShemaPrayer,this);
        mRecyclerView.setAdapter(mAdapter);

        // Set default position naviagation drawer
        onNavigationItemSelected(navigationView.getMenu().getItem(0));


    }


    /*
     * Change the Status Bar to black and removes notification icons
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setActionBarItems() {
        Window window = getWindow();
        window.setStatusBarColor(getColor(R.color.colorPrimaryDark));
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
        // Handle navigation view item clicks here.
        switch (menuItem.getItemId()) {
            case R.id.nav_shema:
                mAdapter = new PrayerAdapter(mShemaPrayer,this);
                mRecyclerView.setAdapter(mAdapter);
                // set item as selected to persist highlight
                menuItem.setChecked(true);
                // close drawer when item is tapped
                mDrawerLayout.closeDrawers();
                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here

                // change title
                mToolbarTitle.setText(getString(R.string.shema_english));
                return true;

            case R.id.nav_birkoth_hashrar:
                mAdapter = new PrayerAdapter(mBirkathHasharar,this);
                mRecyclerView.setAdapter(mAdapter);
                // set item as selected to persist highlight
                menuItem.setChecked(true);
                // close drawer when item is tapped
                mDrawerLayout.closeDrawers();

                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here

                // change title
                mToolbarTitle.setText(getString(R.string.preparatory_prayers_title));
                return true;

            case R.id.nav_tphilath_bh:
                mAdapter = new PrayerAdapter(mTphilathBH,this);
                mRecyclerView.setAdapter(mAdapter);
                // set item as selected to persist highlight
                menuItem.setChecked(true);
                // close drawer when item is tapped
                mDrawerLayout.closeDrawers();

                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here

                // change title
                mToolbarTitle.setText("Tphilath Beith Hamidrash");
                return true;

            case R.id.nav_travel_prayer:
                mAdapter = new PrayerAdapter(mTphilathHaerech,this);
                mRecyclerView.setAdapter(mAdapter);
                // set item as selected to persist highlight
                menuItem.setChecked(true);
                // close drawer when item is tapped
                mDrawerLayout.closeDrawers();

                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here

                // change title
                mToolbarTitle.setText(getString(R.string.travel_prayer_title));
                return true;

            case R.id.nav_bitkath_halevoneh:
                mAdapter = new PrayerAdapter(mBirathHalevanah,this);
                mRecyclerView.setAdapter(mAdapter);
                // set item as selected to persist highlight
                menuItem.setChecked(true);
                // close drawer when item is tapped
                mDrawerLayout.closeDrawers();

                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here

                // change title
                mToolbarTitle.setText(getString(R.string.bitkath_halevoneh_title));
                return true;

            case R.id.nav_settings:
                startActivity(new Intent(this,SettingsActivity.class));
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
                shareLinkIntent.putExtra(Intent.EXTRA_SUBJECT, "Take a look at this amazing app");
                shareLinkIntent.putExtra(Intent.EXTRA_TEXT, "Take a look at this amazing app!\n\nhttps://play.google.com/store/apps/details?id=com.thinkhodl.bedshema");
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

    private void loadUsersPreference()
    {

    }
}
