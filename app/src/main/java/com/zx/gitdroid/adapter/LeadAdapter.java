package com.zx.gitdroid.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.zx.gitdroid.fragment.LeadPager0;
import com.zx.gitdroid.fragment.LeadPager1;
import com.zx.gitdroid.fragment.LeadPager2;

/**
 * Created by keepRun on 2016/7/26.
 */
public class LeadAdapter extends PagerAdapter {

    private View[] views;


    public LeadAdapter(Context context) {
        views = new View[]{
                new LeadPager0(context),
                new LeadPager1(context),
                new LeadPager2(context)
        };
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views[position],0);
        return views[position];
    }

    @Override
    public int getCount() {
        return views.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public View getView(int position) {
        return views[position];
    }
}
