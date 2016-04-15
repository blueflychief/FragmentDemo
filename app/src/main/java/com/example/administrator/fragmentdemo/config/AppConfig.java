package com.example.administrator.fragmentdemo.config;

import com.example.administrator.fragmentdemo.BuildConfig;

/**
 * Created by Administrator on 4/15/2016.
 */
public class AppConfig {
    /**
     * 开发时用APP_DEVELOPING
     * 开发完成改成APP_DEVELOPED
     */
    public static final boolean APP_DEVELOPING = BuildConfig.BASE_DEVELOPING;
    public static final boolean APP_DEVELOPED = BuildConfig.BASE_DEVELOPED;

    //QQ登录平台ID
    public static final String QQ_OPEN_PLATFORM_ID = "";
    public static final String WX_APP_ID = "";
    public static final String MCH_ID = "";
    public static final String WX_AUTH_STATE = "";
    public static final String WX_AUTH_SCOPE = "";

    /*
     * log tag
     */
    public static final String APP_LOG_TAG = "[BaseApp]";


    /*
     * Internal test url
     */
    public static final String APP_ROOT_URL = BuildConfig.API_HOST;

}
