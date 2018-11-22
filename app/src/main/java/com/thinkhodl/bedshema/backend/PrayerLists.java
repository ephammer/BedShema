package com.thinkhodl.bedshema.backend;

import com.thinkhodl.bedshema.R;

import java.util.ArrayList;

public class PrayerLists {

    private static ArrayList<Prayer> mShemaPrayer;
    private static ArrayList<Prayer> mBirkathHasharar;
    private static ArrayList<Prayer> mTphilathBH;
    private static ArrayList<Prayer> mTphilathHaerech;
    private static ArrayList<Prayer> mBirathHalevanah;

    public static ArrayList<Prayer> getmShemaPrayer() {

        mShemaPrayer = new ArrayList<>();

        mShemaPrayer.add(new Prayer(R.string.bed_shema_first_benediction,
                Prayer.TYPE_MAIN_PRAYER));
        mShemaPrayer.add(new Prayer(R.string.bed_shema_shema_intro,
                Prayer.TYPE_SUBTITLE));
        mShemaPrayer.add(new Prayer(R.string.bed_shema_shema,
                Prayer.TYPE_TITLE));
        mShemaPrayer.add(new Prayer(R.string.bed_shema_shema_baruch_shem_kevod,
                Prayer.TYPE_SUBTITLE));
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

        return mShemaPrayer;
    }

    public static ArrayList<Prayer> getmBirkathHasharar() {

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
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_yehy_rason_7,
                Prayer.TYPE_TITLE));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_yehy_rason_8));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_yehy_rason_9));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_birkath_hatorah));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_parashath_hatamid));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_parashath_haketoreth_1));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_parashath_haketoreth_2));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_parashath_haketoreth_3));
        mBirkathHasharar.add(new Prayer(R.string.preparatory_prayers_korbanoth_rosh_hodesh_title,
                Prayer.TYPE_CAPTION));
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

        return mBirkathHasharar;
    }

    public static ArrayList<Prayer> getmTphilathBH() {

        // Tphilath BH
        mTphilathBH = new ArrayList<>();
        mTphilathBH.add(new Prayer(R.string.tphilath_bh_before_english_intro,
                Prayer.TYPE_CAPTION));
        mTphilathBH.add(new Prayer(R.string.tphilath_bh_before));
        mTphilathBH.add(new Prayer(R.string.tphilath_bh_after_english_intro,
                Prayer.TYPE_CAPTION));
        mTphilathBH.add(new Prayer(R.string.tphilath_bh_after));

        return mTphilathBH;
    }

    public static ArrayList<Prayer> getmTphilathHaerech() {

        // Tphilath Haderech
        mTphilathHaerech = new ArrayList<>();
        mTphilathHaerech.add(new Prayer(R.string.travel_prayer));

        return mTphilathHaerech;
    }

    public static ArrayList<Prayer> getmBirkathHalevanah() {

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

        return mBirathHalevanah;
    }







}
