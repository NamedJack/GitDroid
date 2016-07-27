package com.zx.gitdroid.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.zx.gitdroid.R;

/**
 * Created by keepRun on 2016/7/26.
 */
public class LeadPager0 extends FrameLayout {

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.content_page0, this, true);
    }

    public LeadPager0(Context context) {
        this(context, null);
    }

    public LeadPager0(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LeadPager0(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
}
