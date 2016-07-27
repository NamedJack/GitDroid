package com.zx.gitdroid.fragment;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.zx.gitdroid.R;
import com.zx.gitdroid.adapter.LeadAdapter;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by keepRun on 2016/7/26.
 */
public class LeadFragment extends Fragment {

    @Bind(R.id.vp_viewpager)
    ViewPager vpViewpager;
    @Bind(R.id.ci_indicator)
    CircleIndicator ciIndicator;
    @Bind(R.id.iv_phone_back)
    ImageView ivPhoneBack;
    @Bind(R.id.iv_phone_font)
    ImageView ivPhoneFont;
    @Bind(R.id.layout_phone)
    FrameLayout layoutPhone;
    @Bind(R.id.fl_content)
    FrameLayout flContent;
    @BindColor(R.color.colorGreen)
    int colorGreen;
    @BindColor(R.color.colorRed)
    int colorRed;
    @BindColor(R.color.colorYellow)
    int colorYellow;



    private LeadAdapter adapter;
    private int width;
    private int hight;


    //创建视图
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lead_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new LeadAdapter(getContext());
        vpViewpager.setAdapter(adapter);
        ciIndicator.setViewPager(vpViewpager);


        vpViewpager.addOnPageChangeListener(pageColorChange);
        vpViewpager.addOnPageChangeListener(pageViewChange);

        WindowManager manager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
             width = manager.getDefaultDisplay().getWidth();
             hight = manager.getDefaultDisplay().getHeight();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private ViewPager.OnPageChangeListener pageColorChange = new ViewPager.OnPageChangeListener() {
        ArgbEvaluator evaluator = new ArgbEvaluator();
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if(position == 0){
                int color = (int) evaluator.evaluate(positionOffset,colorGreen,colorRed);
                flContent.setBackgroundColor(color);
                return;
            }
            if(position == 1){
                int color = (int) evaluator.evaluate(positionOffset,colorRed,colorYellow);
                flContent.setBackgroundColor(color);
            }

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
//    private String TAG = "TAG";
    private ViewPager.OnPageChangeListener pageViewChange = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if(position == 0){
                ivPhoneFont.setAlpha(positionOffset);
                float scale = 0.3f+positionOffset*0.5f;
                layoutPhone.setScaleX(scale);
                layoutPhone.setScaleY(scale);
                int scroll = (int) (-(positionOffset-1)*100);
                layoutPhone.setScrollX(scroll);
                return;
            }
            if(position == 1){
                layoutPhone.setTranslationX(-positionOffsetPixels);
            }
        }

        @Override
        public void onPageSelected(int position) {
            if(position == 2){
                LeadPager2 pager2 = (LeadPager2) adapter.getView(position);
                pager2.showAnimation();
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
