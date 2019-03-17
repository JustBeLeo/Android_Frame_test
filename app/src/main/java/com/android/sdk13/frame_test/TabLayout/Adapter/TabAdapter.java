package com.android.sdk13.frame_test.TabLayout.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.sdk13.frame_test.TabLayout.Fragment.TabFragment;

import java.util.ArrayList;

public class TabAdapter extends FragmentPagerAdapter {
    ArrayList<TabFragment> fragments;

    public TabAdapter(FragmentManager fm,ArrayList<TabFragment> fragments) {
        super( fm );
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get( i );
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get( position ).getTitle();
    }
}
