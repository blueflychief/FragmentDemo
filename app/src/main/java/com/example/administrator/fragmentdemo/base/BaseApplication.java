package com.example.administrator.fragmentdemo.base;

import android.app.Application;

import com.example.administrator.fragmentdemo.crash.CrashHandler;

/**
 * Created by Administrator on 4/14/2016.
 */
public class BaseApplication extends Application {
    private static BaseApplication sINSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        sINSTANCE = this;
        initEmailReporter();
    }

    /**
     * 使用EMAIL发送日志
     */
    private void initEmailReporter() {
        CrashHandler.getInstance()
                .setReciverInfo(this, "blueflychief@163.com", "qq690797866@163.com", "MNBvcxz3.14", "smtp.163.com", 465);
    }


    public static BaseApplication getInstance() {
        return sINSTANCE;
    }
}
