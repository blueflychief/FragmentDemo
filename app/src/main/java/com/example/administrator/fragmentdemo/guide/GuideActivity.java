package com.example.administrator.fragmentdemo.guide;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.fragmentdemo.R;
import com.example.administrator.fragmentdemo.base.BaseActivity;
import com.example.administrator.fragmentdemo.main.MainActivity;
import com.example.administrator.fragmentdemo.utils.SPUtil;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends BaseActivity {
    private ViewPager viewpager;
    private TextView bt_experience;
    private TextView tv_jump;
    private List<ImageView> mImageList;
    private ImageView iv_dot;
    private int[] mImagesId = new int[]{
            R.mipmap.guide_loading_1,
            R.mipmap.guide_loading_2,
            R.mipmap.guide_loading_3,
            R.mipmap.guide_loading_4,
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    @Override
    protected void setContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_guide);
    }

    @Override
    protected void findViews() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        iv_dot = (ImageView) findViewById(R.id.iv_dot);
        tv_jump = (TextView) findViewById(R.id.tv_jump);
        bt_experience = (TextView) findViewById(R.id.bt_experience);
    }

    @Override
    protected void initData() {
        ImageView imageView1 = new ImageView(getApplicationContext());
        imageView1.setBackgroundResource(R.mipmap.guide1);

        ImageView imageView2 = new ImageView(getApplicationContext());
        imageView2.setBackgroundResource(R.mipmap.guide2);

        ImageView imageView3 = new ImageView(getApplicationContext());
        imageView3.setBackgroundResource(R.mipmap.guide3);

        ImageView imageView4 = new ImageView(getApplicationContext());
        imageView4.setBackgroundResource(R.mipmap.guide4);

        mImageList = new ArrayList<ImageView>();
        mImageList.add(imageView1);
        mImageList.add(imageView2);
        mImageList.add(imageView3);
        mImageList.add(imageView4);

        viewpager.setAdapter(new MyAdatper());
        viewpager.setOnPageChangeListener(listener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SPUtil.setParam(this, "is_skip_guide", true);
    }

    ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int arg0) {
            iv_dot.setImageResource(mImagesId[arg0]);
            if (arg0 == mImageList.size() - 1) {
                bt_experience.setVisibility(View.VISIBLE);
                tv_jump.setVisibility(View.GONE);
                bt_experience.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(GuideActivity.this, MainActivity.class));
                        finish();
                    }
                });
            } else {
                bt_experience.setVisibility(View.INVISIBLE);
            }
            if (arg0 == 0 || arg0 == 1 || arg0 == 2) {
                tv_jump.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    class MyAdatper extends PagerAdapter {
        @Override
        public int getCount() {
            return mImageList.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mImageList.get(position));
            return mImageList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
