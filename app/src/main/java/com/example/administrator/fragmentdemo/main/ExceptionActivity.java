package com.example.administrator.fragmentdemo.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.administrator.fragmentdemo.R;
import com.example.administrator.fragmentdemo.base.AppCompatBaseActivity;

public class ExceptionActivity extends AppCompatBaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    protected void findViews(View root) {
//        final Button button = (Button) root.findViewById(R.id.btnException);
//        if (button != null) {
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    throw new RuntimeException("This will crash the app");
//                }
//            });
//        }
    }

    @Override
    protected void initData() {

    }

    @Override
    public View setContentView(Bundle savedInstanceState, LayoutInflater inflater) {
        return inflater.inflate(R.layout.activity_exception,null);
    }
}
