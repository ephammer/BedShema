package com.thinkhodl.bedshema.backend;

import android.location.Location;

import net.sourceforge.zmanim.ComplexZmanimCalendar;
import net.sourceforge.zmanim.util.GeoLocation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Utils {

    public static ComplexZmanimCalendar getComplexZmanimCalendar(Location location) {
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        String locationName = "";
        double elevation = 0; //optional elevation
        TimeZone timeZone = TimeZone.getDefault();
        GeoLocation geoLocation = new GeoLocation(locationName, latitude, longitude, elevation, timeZone);

        return new ComplexZmanimCalendar(geoLocation);
    }

    public static Date getDawnTime(ComplexZmanimCalendar complexZmanimCalendar) {
        return complexZmanimCalendar.getAlos16Point1Degrees();
    }

    public static Date getEarliestTalisTefillinTime(ComplexZmanimCalendar complexZmanimCalendar) {
        return complexZmanimCalendar.getMisheyakir11Point5Degrees();
    }

    public static Date getSunriseTime(ComplexZmanimCalendar complexZmanimCalendar) {
        return complexZmanimCalendar.getSunrise();
    }

    public static Date getLatestShemaMATime(ComplexZmanimCalendar complexZmanimCalendar) {
        return complexZmanimCalendar.getSofZmanShmaMGA16Point1Degrees();
    }

    public static Date getLatestShemaGraTime(ComplexZmanimCalendar complexZmanimCalendar) {
        return complexZmanimCalendar.getSofZmanShmaGRA();
    }

    public static Date getLatestShachrisGraTime(ComplexZmanimCalendar complexZmanimCalendar) {
        return complexZmanimCalendar.getSofZmanTfilaGRA();
    }

    public static Date getMiddayTime(ComplexZmanimCalendar complexZmanimCalendar) {
        return complexZmanimCalendar.getChatzos();
    }

    public static Date getEarliestMinchaTime(ComplexZmanimCalendar complexZmanimCalendar) {
        return complexZmanimCalendar.getMinchaGedola();
    }

    public static Date getPlagHaMinchaTime(ComplexZmanimCalendar complexZmanimCalendar) {
        return complexZmanimCalendar.getPlagHamincha();
    }

    public static Date getSunsetTime(ComplexZmanimCalendar complexZmanimCalendar) {
        return complexZmanimCalendar.getSunset();
    }

    public static Date getNightfallThreeStarsTime(ComplexZmanimCalendar complexZmanimCalendar) {
        return complexZmanimCalendar.getTzais();
    }

    public static Date getNightfallSeventyTwoMinutesTime(ComplexZmanimCalendar complexZmanimCalendar) {
        return complexZmanimCalendar.getTzais72();
    }

    public static String formatTime(Date date) {
        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm");
        return sdfDate.format(date);
    }
}
