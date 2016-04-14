package com.example.administrator.fragmentdemo.main;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.administrator.fragmentdemo.R;

public class NavigatorTabView extends ScrollView {
    private int mOrientation = 0;
    private String[] mTabs = null;
    private NavigatorTabClickListener mNavigatorTabClickListener;
    private LinearLayoutCompat linearLayoutCompat;

    public interface NavigatorTabClickListener {
        void onNavigatorTabClick(int position, View view);
    }

    public NavigatorTabView(Context context) {
        this(context, null);
    }

    public NavigatorTabView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NavigatorTabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MainTab);
        mOrientation = a.getInt(R.styleable.MainTab_tab_orientation, 0);
        a.recycle();
        mTabs = context.getResources().getStringArray(R.array.main_tabs_string);
        initViews(context);
    }

    private void initViews(Context context) {
        linearLayoutCompat = new LinearLayoutCompat(context);
        ViewGroup.LayoutParams param = new ViewGroup.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        addView(linearLayoutCompat, param);
        linearLayoutCompat.setOrientation(mOrientation);
        for (int i = 0; i < mTabs.length; i++) {
            View view = View.inflate(context, R.layout.item_main_tab_view, null);
            view.setTag(i);
            LayoutParams param1 = new LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT, 1);

            ((TextView) view.findViewById(R.id.tv_tab)).setText(mTabs[i]);
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mNavigatorTabClickListener.onNavigatorTabClick((Integer) v.getTag(), v);
                }
            });
            linearLayoutCompat.addView(view, param1);
        }
    }

    public void select(int position) {
        for (int i = 0, n = linearLayoutCompat.getChildCount(); i < n; i++) {
            View child = linearLayoutCompat.getChildAt(i);
            if (i == position) {
                selectChild(child, true);
            } else {
                selectChild(child, false);
            }
        }
    }

    private void selectChild(View child, boolean select) {
        if (child instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) child;
            group.setSelected(select);
            for (int i = 0; i < group.getChildCount(); i++) {
                selectChild(group.getChildAt(i), select);
            }
        } else {
            child.setSelected(select);
            if (child instanceof ImageView) {
                ImageView iv = (ImageView) child;
                Drawable drawable = iv.getDrawable().mutate();
                if (select) {
                    iv.setBackgroundColor(getResources().getColor(R.color.main_tab_selected));
                    drawable.setColorFilter(getResources().getColor(R.color.colorTabSelected), PorterDuff.Mode.SRC_ATOP);
                } else {
                    iv.setBackgroundColor(getResources().getColor(R.color.main_tab_unselected));
                    drawable.setColorFilter(getResources().getColor(R.color.colorTabNormal), PorterDuff.Mode.SRC_ATOP);
                }
            }
            if (child instanceof TextView) {
                TextView tv = (TextView) child;
                if (select) {
                    tv.setBackgroundColor(getResources().getColor(R.color.main_tab_selected));
                } else {
                    tv.setBackgroundColor(getResources().getColor(R.color.main_tab_unselected));
                }
            }
        }
    }

    public void setNavigatorTabClickListener(NavigatorTabClickListener listener) {
        this.mNavigatorTabClickListener = listener;
    }
}
