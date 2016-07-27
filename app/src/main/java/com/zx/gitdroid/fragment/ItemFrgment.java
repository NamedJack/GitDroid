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
import com.zx.gitdroid.utils.ItemFragmentPersenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.header.StoreHouseHeader;

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
    @Bind(R.id.cfl_pull)
    PtrClassicFrameLayout cflPull;

//    String[] data = {"qeeqwe", "wer", "rwerw", "rwer"};

    private ArrayAdapter<String> adapter;
    private ItemFragmentPersenter persenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_fragment, container, false);
        ButterKnife.bind(this, view);
        initData();
        initPullRefrash();
        return view;
    }

    private void initPullRefrash() {
        //传入当前对象，记录下拉刷新的时间，太近的话，将不会触发刷新效果
        cflPull.setLastUpdateTimeRelateObject(this);
        //设置两次下拉刷新的时间间隔
        cflPull.setDurationToCloseHeader(1000);
        //设置下拉刷新
        cflPull.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                persenter.onRefrash();
            }
        });
        //下拉头部文件的样式
        StoreHouseHeader header =new StoreHouseHeader(getContext());
        header.initWithString("I LIKE"+"JAVA");
        header.setPadding(0,60,0,60);
        cflPull.setHeaderView(header);
        cflPull.addPtrUIHandler(header);
        cflPull.setBackgroundResource(R.color.colorRefresh);
    }

    private void initData() {
        adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,
                new ArrayList<String>());
        itemList.setAdapter(adapter);
        persenter = new ItemFragmentPersenter(this);
    }
    //结束头部
    public void stopRefresh(){
        cflPull.refreshComplete();
    }
    //错误的显示
    public void showError(){
        cflPull.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
    }
    //没有数据的显示
    public void showEmpty(){
        cflPull.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
    }
    //加载数据，更新
    public void refreshData(List<String> list){
        adapter.clear();
        adapter.addAll(list);
        adapter.notifyDataSetChanged();
    }
    //显示更新后的数据
    public void showContent(){
        cflPull.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
