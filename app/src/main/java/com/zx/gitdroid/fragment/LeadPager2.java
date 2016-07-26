package com.zx.gitdroid.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.zx.gitdroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by keepRun on 2016/7/26.
 */
public class LeadPager2 extends FrameLayout {
    @Bind(R.id.iv_page2_image1)
    ImageView ivPage2Image1;
    @Bind(R.id.iv_page2_image2)
    ImageView ivPage2Image2;
    @Bind(R.id.iv_page2_image3)
    ImageView ivPage2Image3;

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.content_page2, this, true);
        ButterKnife.bind(this);
        ivPage2Image1.setVisibility(GONE);
        ivPage2Image2.setVisibility(GONE);
        ivPage2Image3.setVisibility(GONE);
    }

    public LeadPager2(Context context) {
        this(context, null);
    }

    public LeadPager2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LeadPager2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public void showAnimation(){
        if(ivPage2Image1.getVisibility() != VISIBLE){
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    ivPage2Image1.setVisibility(VISIBLE);
                    YoYo.with(Techniques.BounceInDown).duration(500).playOn(ivPage2Image1);
                }
            },50);

        }
        if(ivPage2Image2.getVisibility() != VISIBLE){
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    ivPage2Image2.setVisibility(VISIBLE);
                    YoYo.with(Techniques.BounceInDown).duration(500).playOn(ivPage2Image2);
                }
            },600);

        }
        if(ivPage2Image3.getVisibility() != VISIBLE){
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    ivPage2Image3.setVisibility(VISIBLE);
                    YoYo.with(Techniques.BounceInDown).duration(500).playOn(ivPage2Image3);
                }
            },1200);

        }
    }
}
