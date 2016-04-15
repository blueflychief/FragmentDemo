package com.example.administrator.fragmentdemo.splash;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.WindowManager;

import com.example.administrator.fragmentdemo.R;
import com.example.administrator.fragmentdemo.base.BaseActivity;
import com.example.administrator.fragmentdemo.guide.GuideActivity;
import com.example.administrator.fragmentdemo.main.MainActivity;
import com.example.administrator.fragmentdemo.utils.SPUtil;

public class SplashActivity extends BaseActivity {
    private long mStart = 0;
    private final int DELAY_TIME = 3 * 1000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        mStart = System.currentTimeMillis();
    }

    @Override
    protected void setContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void findViews() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goToNextActivity();
            }
        }, DELAY_TIME);
    }

    private void goToNextActivity() {
        if (!(Boolean) SPUtil.getParam(SplashActivity.this, "is_skip_guide", false)) {
            startActivity(new Intent(SplashActivity.this, GuideActivity.class));
        } else {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        }
        finish();
    }
}
