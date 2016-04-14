package com.example.administrator.fragmentdemo.base;

import android.app.Application;

/**
 * Created by Administrator on 4/14/2016.
 */
public class BaseApplication extends Application {
    private static BaseApplication sINSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        sINSTANCE = this;
    }

    public static BaseApplication getInstance() {
        return sINSTANCE;
    }
}
