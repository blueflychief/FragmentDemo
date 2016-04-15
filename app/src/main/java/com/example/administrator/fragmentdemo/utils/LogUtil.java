package com.example.administrator.fragmentdemo.utils;

import android.util.Log;

import com.example.administrator.fragmentdemo.BuildConfig;
import com.example.administrator.fragmentdemo.config.AppConfig;

/**
 * Created by Administrator on 4/15/2016.
 */
public class LogUtil {
    public static void v(String msg){
        if(BuildConfig.BASE_LOG){
            Log.v(AppConfig.APP_LOG_TAG, msg);
        }
    }

    public static void d(String msg){
        if(BuildConfig.BASE_LOG){
            Log.d(AppConfig.APP_LOG_TAG, msg);
        }
    }

    public static void i(String msg){
        if(BuildConfig.BASE_LOG){
            Log.i(AppConfig.APP_LOG_TAG, msg);
        }
    }
    public static void w(String msg){
        if(BuildConfig.BASE_LOG){
            Log.w(AppConfig.APP_LOG_TAG, msg);
        }
    }
    public static void e(String msg){
        if(BuildConfig.BASE_LOG){
            Log.e(AppConfig.APP_LOG_TAG, msg);
        }
    }

    public static void w(Throwable tr) {
        if (BuildConfig.BASE_LOG) {
            Log.w(AppConfig.APP_LOG_TAG, Log.getStackTraceString(tr));
        }
    }

    public static void e(Throwable tr) {
        if (BuildConfig.BASE_LOG)
            Log.e(AppConfig.APP_LOG_TAG,  Log.getStackTraceString(tr));
    }

    public static void i(Throwable tr) {
        if (BuildConfig.BASE_LOG) {
            Log.i(AppConfig.APP_LOG_TAG, Log.getStackTraceString(tr));
        }
    }

}