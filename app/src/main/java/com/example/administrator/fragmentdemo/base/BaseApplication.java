package com.example.administrator.fragmentdemo.base;

import android.app.Application;

import com.example.administrator.fragmentdemo.BuildConfig;
import com.example.administrator.fragmentdemo.utils.crash.CrashHandler;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;

/**
 * Created by Administrator on 4/14/2016.
 */
public class BaseApplication extends Application {
    private static BaseApplication sINSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        sINSTANCE = this;
        NoHttp.init(this);
        if (!BuildConfig.DEBUG) {
            initEmailReporter();
        }
        Logger.setDebug(BuildConfig.DEBUG);//nohttp调试模式
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
