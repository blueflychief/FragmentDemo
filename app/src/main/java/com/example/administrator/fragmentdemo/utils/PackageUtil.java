package com.example.administrator.fragmentdemo.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.example.administrator.fragmentdemo.base.BaseApplication;

/**
 * Created by Administrator on 4/15/2016.
 */
public class PackageUtil {
    // 取得版本号
    public static String getVersionName() {
        try {
            PackageInfo manager = getPackageManager();
            return manager.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "Unknown Version";
        }
    }

    // 获取build号
    public static int getVersionCode() {
        try {
            PackageInfo manager = getPackageManager();
            return manager.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }

    // 获取包名
    public static String getPackageName() {
        try {
            PackageInfo manager = getPackageManager();
            return manager.packageName;
        } catch (PackageManager.NameNotFoundException e) {
            return "Unknown PackageName";
        }
    }

    private static PackageInfo getPackageManager() throws PackageManager.NameNotFoundException {
        Context context = BaseApplication.getInstance().getApplicationContext();
        return context.getPackageManager().getPackageInfo(
                context.getPackageName(), 0);
    }
}
