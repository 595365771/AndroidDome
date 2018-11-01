package com.blackcat.example.ui.service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blackcat.example.R;
import com.blackcat.example.base.BaseActivity;
import com.blackcat.example.databinding.ActivityServiceOneBinding;
import com.blackcat.example.databinding.ActivityThreadOneBinding;
import com.blackcat.example.service.ServiceTest;
import com.blackcat.example.ui.thread.chlid.MyCallable;
import com.blackcat.example.ui.thread.chlid.MyRunnable;
import com.blackcat.example.ui.thread.chlid.MyThread;
import com.blackcat.example.utils.DebugUtil;
import com.blackcat.example.utils.PerfectClickListener;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ServiceOneActivity extends BaseActivity<ActivityServiceOneBinding> {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_one);
        showContentView();
        initTitle();
        initListener();
    }


    private void initTitle() {
        getTitleBar().setTitleText("Service(一)");
        getTitleBar().setB_leftOnClick(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                finish();
            }
        });
    }

    private void initListener() {
        bindingView.button1StartService.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                Intent intent =new Intent(ServiceOneActivity.this, ServiceTest.class);
                startService(intent);
            }
        });
        bindingView.button2StopService.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                Intent intent =new Intent(ServiceOneActivity.this, ServiceTest.class);
                stopService(intent);
            }
        });

    }


}
