package com.example.administrator.fragmentdemo.main;

import android.support.v4.app.Fragment;

import com.example.administrator.fragmentdemo.R;
import com.example.administrator.fragmentdemo.fragmentnavigator.FragmentNavigatorAdapter;
import com.example.administrator.fragmentdemo.utils.StringUtil;



public class FragmentAdapter implements FragmentNavigatorAdapter {

    private static final String TABS[] = StringUtil.getStringFromAssert(R.array.main_tabs_string);

    @Override
    public Fragment onCreateFragment(int position) {
        if (position == 1) {
            return ContactsFragment.newInstance(position);
        }

        return MainFragment.newInstance(TABS[position]);
    }

    @Override
    public String getTag(int position) {
        if (position == 1) {
            return ContactsFragment.TAG;
        }
        return MainFragment.TAG + TABS[position];
    }

    @Override
    public int getCount() {
        return TABS.length;
    }
}
