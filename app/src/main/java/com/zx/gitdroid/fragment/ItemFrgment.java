package com.zx.gitdroid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.zx.gitdroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by keepRun on 2016/7/27.
 */
public class ItemFrgment extends Fragment {
    @Bind(R.id.item_list)
    ListView itemList;
    @Bind(R.id.emptyView)
    TextView emptyView;
    @Bind(R.id.errorView)
    TextView errorView;

    String[] data = {"qeeqwe","wer","rwerw","rwer"};
    private ArrayAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_fragment, container, false);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        adapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,data);
        itemList.setAdapter(adapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
