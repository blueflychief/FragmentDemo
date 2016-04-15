package com.example.administrator.fragmentdemo.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.fragmentdemo.R;
import com.example.administrator.fragmentdemo.base.BaseActivity;

public class ExceptionActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exception);
        final Button button = (Button) findViewById(R.id.btnException);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    throw new RuntimeException("This will crash the app");
                }
            });
        }

    }

    @Override
    protected void setContentView(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void findViews() {

    }
}
