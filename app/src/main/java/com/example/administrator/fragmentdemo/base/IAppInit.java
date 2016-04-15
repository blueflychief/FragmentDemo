package com.example.administrator.fragmentdemo.base;

import android.os.Bundle;

/**
 * Created by Administrator on 4/15/2016.
 */
public interface IAppInit {
    void setContentView(Bundle savedInstanceState);

    void initTitle();

    void findViews();

    void initData();
}
