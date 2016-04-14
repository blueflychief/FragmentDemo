package com.example.administrator.fragmentdemo.utils;

import com.example.administrator.fragmentdemo.base.BaseApplication;

/**
 * Created by Administrator on 4/14/2016.
 */
public class StringUtil {
    public static String[] getStringFromAssert(int id) {
        return BaseApplication.getInstance().getResources().getStringArray(id);
    }
}
