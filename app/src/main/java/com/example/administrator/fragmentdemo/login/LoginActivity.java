package com.example.administrator.fragmentdemo.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.administrator.fragmentdemo.R;
import com.example.administrator.fragmentdemo.base.AppCompatBaseActivity;

public class LoginActivity extends AppCompatBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View setContentView(Bundle savedInstanceState, LayoutInflater inflater) {
        return inflater.inflate(R.layout.activity_login, null);
    }

    @Override
    protected void findViews(View root) {

    }

    @Override
    protected void initData() {

    }

}
