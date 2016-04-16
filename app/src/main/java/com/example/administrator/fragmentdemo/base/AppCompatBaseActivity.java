package com.example.administrator.fragmentdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.WindowCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.administrator.fragmentdemo.R;

/**
 * Created by Administrator on 4/14/2016.
 */
public abstract class AppCompatBaseActivity extends AppCompatActivity implements IContentView {

    private Toolbar mToolbar;
    private ScrollView sv_content;
    private LayoutInflater mInflater = null;
    private LinearLayout mLlRootView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }
        supportRequestWindowFeature(WindowCompat.FEATURE_ACTION_MODE_OVERLAY);  //防止在WebView中长按复制出现标题栏显示错误
        setContentView(R.layout.activity_base);
        sv_content = (ScrollView) findViewById(R.id.sv_content);
        mLlRootView = (LinearLayout) findViewById(R.id.ll_root);
        setBaseContentView(savedInstanceState);
        initTitle();
        findViews(mLlRootView);
        initData();
    }

    protected void setBaseContentView(Bundle savedInstanceState) {
        mInflater = this.getLayoutInflater();
        View view = setContentView(savedInstanceState, mInflater);
        if (view != null) {
            sv_content.addView(view);
        }
    }


    protected void initTitle() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setVisibility(View.VISIBLE);
// toolbar.setLogo(R.drawable.ic_launcher);
        mToolbar.setTitle("Rocko");// 标题的文字需在setSupportActionBar之前，不然会无效
// toolbar.setSubtitle("副标题");
        setSupportActionBar(mToolbar);
/* 这些通过ActionBar来设置也是一样的，注意要在setSupportActionBar(toolbar);之后，不然就报错了 */
// getSupportActionBar().setTitle("标题");
// getSupportActionBar().setSubtitle("副标题");
// getSupportActionBar().setLogo(R.drawable.ic_launcher);
    }

    protected abstract void findViews(View root);

    protected abstract void initData();


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}
