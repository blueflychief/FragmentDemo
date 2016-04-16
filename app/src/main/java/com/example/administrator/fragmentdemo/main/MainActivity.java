package com.example.administrator.fragmentdemo.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.administrator.fragmentdemo.R;
import com.example.administrator.fragmentdemo.base.BaseActivity;
import com.example.administrator.fragmentdemo.navigator.FragmentNavigator;
import com.example.administrator.fragmentdemo.utils.ToastUtils;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends BaseActivity implements NavigatorTabView.NavigatorTabClickListener {

    private static final int DEFAULT_POSITION = 0;

    private FragmentNavigator mNavigator;

    private NavigatorTabView bottomNavigatorView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_exception, menu);
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (null != mNavigator && null != outState) {
            mNavigator.onSaveInstanceState(outState);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_exception) {
            startActivity(new Intent(this, ExceptionActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNavigatorTabClick(int position, View view) {
        setCurrentTab(position);
    }

    private void setCurrentTab(int position) {
        mNavigator.showFragment(position);
        bottomNavigatorView.select(position);
    }

    @Override
    public void setContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        mNavigator = new FragmentNavigator(getSupportFragmentManager(), new FragmentAdapter(), R.id.container);
        mNavigator.setDefaultPosition(DEFAULT_POSITION);
        mNavigator.onCreate(savedInstanceState);
    }

    @Override
    public void findViews() {
        bottomNavigatorView = (NavigatorTabView) findViewById(R.id.bottomNavigatorView);
        if (bottomNavigatorView != null) {
            bottomNavigatorView.setNavigatorTabClickListener(this);
        }
        setCurrentTab(mNavigator.getCurrentPosition());
    }

    @Override
    public void initData() {

    }


    @Override
    public void onBackPressed() {
        exitBy2Click();
    }

    private static Boolean mIsExit = false;

    private void exitBy2Click() {
        Timer tExit = null;
        if (!mIsExit) {
            mIsExit = true;
            ToastUtils.showToast("再按一次退出程序");
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    mIsExit = false;
                }
            }, 2000);

        } else {
//            MobclickAgent.onKillProcess(MainActivity.this);
            finish();
            System.exit(0);
        }
    }
}
