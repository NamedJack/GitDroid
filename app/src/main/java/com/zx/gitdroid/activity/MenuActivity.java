package com.zx.gitdroid.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.zx.gitdroid.R;
import com.zx.gitdroid.fragment.HotFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.rl_layout)
    DrawerLayout rlLayout;
    private ActionBarDrawerToggle toggle;
    @Bind(R.id.menu_toolbar)
    Toolbar menuToolbar;
    @Bind(R.id.menu_frame)
    FrameLayout menuFrame;
    @Bind(R.id.menu_nv)
    NavigationView menuNv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        initData();
        loadFragment();
    }

    private void loadFragment() {
        HotFragment fragment = new HotFragment();
        replaceFragment(fragment);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.menu_frame,fragment);
        transaction.commit();
    }


    private void initData() {
        setSupportActionBar(menuToolbar);
        menuToolbar.setTitle("GITHUB");
        menuNv.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(this, rlLayout,menuToolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close );
        toggle.syncState();
        rlLayout.addDrawerListener(toggle);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.github_hot_repo:
                break;
            case R.id.github_hot_coder:
                break;
            case R.id.github_trend:
                break;
            case R.id.arsenal_my_repo:
                break;
            case R.id.arsenal_recommend:
                break;
            case R.id.tips_daily:
                break;
            case R.id.tips_share:
                break;
        }
        return true;
    }
}
