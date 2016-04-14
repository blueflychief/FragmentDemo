package com.example.administrator.fragmentdemo.base;

import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.WindowCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * Created by Administrator on 4/14/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        supportRequestWindowFeature(WindowCompat.FEATURE_ACTION_MODE_OVERLAY);  //防止在WebView中长按复制出现标题栏显示错误
        setContentView();
        initTitle();
//        findViews();
        initData();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    protected abstract void setContentView();

    protected abstract void initTitle();

//    protected <T extends View> void findViews(int id){
//        return findViewById(id);
//    };

    protected abstract void initData();

}
