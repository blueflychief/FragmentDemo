package com.example.administrator.fragmentdemo.utils;

import com.example.administrator.fragmentdemo.base.BaseApplication;

/**
 * Created by Administrator on 4/15/2016.
 */
public class FileUtil {
    //app文件存储路径
    public static final String APP_FILE_PATH = BaseApplication.getInstance().getFilesDir().toString();
    //app缓存路径
    public static final String APP_CACHE_PATH = BaseApplication.getInstance().getCacheDir().toString();
}
