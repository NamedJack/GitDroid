package com.zx.gitdroid.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by keepRun on 2016/7/25.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public void startActivity(Class<?> pClass,Bundle bundle){
        Intent intent = new Intent(this,pClass);
        if(bundle != null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
    public void startActivity(Class<?> pClass){
        startActivity(pClass,null);
    }
    public void startActivity(String action,Bundle bundle){
        Intent intent = new Intent(action);
        if(bundle != null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
}
