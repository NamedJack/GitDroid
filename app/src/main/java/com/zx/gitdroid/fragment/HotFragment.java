package com.zx.gitdroid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zx.gitdroid.R;
import com.zx.gitdroid.adapter.HotFragmentAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by keepRun on 2016/7/27.
 */
public class HotFragment extends Fragment {

    private HotFragmentAdapter adapter;
    @Bind(R.id.hot_tablayout)
    TabLayout hotTablayout;
    @Bind(R.id.hot_vp)
    ViewPager hotVp;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hot_fragment, container, false);
        ButterKnife.bind(this, view);
        setData();
        return view;
    }

    private void setData() {
        adapter = new HotFragmentAdapter(getFragmentManager());
        hotVp.setAdapter(adapter);
        hotTablayout.setupWithViewPager(hotVp);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
