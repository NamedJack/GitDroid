package com.zx.gitdroid.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zx.gitdroid.R;
import com.zx.gitdroid.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LeadActivity extends BaseActivity {

    @Bind(R.id.btn_login)
    TextView btnLogin;
    @Bind(R.id.btn_use)
    TextView btnUse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_login, R.id.btn_use})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                startActivity(LoginActivity.class);
                break;
            case R.id.btn_use:
                startActivity(MenuActivity.class);
                break;
        }
    }
}
