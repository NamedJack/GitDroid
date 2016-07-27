package com.zx.gitdroid.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zx.gitdroid.fragment.ItemFrgment;

/**
 * Created by keepRun on 2016/7/27.
 */
public class HotFragmentAdapter extends FragmentPagerAdapter {
    public HotFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new ItemFrgment();
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "JAVA"+position;
    }
}
