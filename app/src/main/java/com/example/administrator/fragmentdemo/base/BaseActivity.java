package com.example.administrator.fragmentdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.WindowCompat;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 4/14/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }
        supportRequestWindowFeature(WindowCompat.FEATURE_ACTION_MODE_OVERLAY);  //防止在WebView中长按复制出现标题栏显示错误
        setContentView(savedInstanceState);
        initTitle();
        findViews();
        initData();
    }

    protected abstract void setContentView(Bundle savedInstanceState);

    protected void initTitle() {
    }

    protected abstract void initData();


    protected abstract void findViews();


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}
