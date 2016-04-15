package com.example.administrator.fragmentdemo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 4/15/2016.
 */
public class DateUtil {
    public static String getCurrentTime() {
        return getCurrentTime("yyyy-MM-dd_HH:mm");
    }

    public static String getDateString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        return sdf.format(date);
    }

    public static String getDateString(long milliseconds, String format) {
        Date date = new Date(milliseconds);
        return getDateString(date, format);
    }

    public static String getCurrentTime(String format) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        String currentTime = sdf.format(date);
        return currentTime;
    }
}
