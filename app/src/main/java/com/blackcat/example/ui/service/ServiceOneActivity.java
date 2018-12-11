package com.blackcat.example.ui.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import com.blackcat.example.R;
import com.blackcat.example.base.BaseActivity;
import com.blackcat.example.databinding.ActivityServiceOneBinding;
import com.blackcat.example.databinding.ActivityThreadOneBinding;
import com.blackcat.example.service.BindServiceTest;
import com.blackcat.example.service.IntentServiceTest;
import com.blackcat.example.service.ServiceTest;
import com.blackcat.example.ui.thread.chlid.MyCallable;
import com.blackcat.example.ui.thread.chlid.MyRunnable;
import com.blackcat.example.ui.thread.chlid.MyThread;
import com.blackcat.example.utils.DebugUtil;
import com.blackcat.example.utils.PerfectClickListener;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ServiceOneActivity extends BaseActivity<ActivityServiceOneBinding> {
    private BindServiceTest.BinderTest binderTest;
    boolean mBound = false; //一开始，并没有和Service绑定.这个参数是用来显示绑定状态
    //匿名内部类：服务连接对象
    private ServiceConnection connection = new ServiceConnection() {
        //和服务绑定成功后，服务会回调该方法
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binderTest = (BindServiceTest.BinderTest) service;
            //在Activity中调用Service里面的方法
            binderTest.startDownload();
            binderTest.getProgress();
            mBound = true; //true说明是绑定状态

        }

        //当服务异常终止时会调用。注意，解除绑定服务时不会调用
        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound = false; //服务异常终止时，状态为未绑定
        }
    };

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
                Intent intent = new Intent(ServiceOneActivity.this, ServiceTest.class);
                startService(intent);
            }
        });
        bindingView.button2StopService.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                Intent intent = new Intent(ServiceOneActivity.this, ServiceTest.class);
                stopService(intent);
            }
        });
        bindingView.button3StopIntentservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DebugUtil.error("主线程的ID是" + Thread.currentThread().getId());
                Intent intentService = new Intent(ServiceOneActivity.this, IntentServiceTest.class);
                startService(intentService);
            }
        });
        bindingView.button4BindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bindIntent = new Intent(ServiceOneActivity.this, BindServiceTest.class);
                /**
                 * 这里传入BIND_AUTO_CREATE表示在Activity和Service建立关联后会自动创建Service（即使之前没有创建Service也没有关系）
                 * ，这会使得MyService中的onCreate()方法得到执行，但onStartCommand()方法不会执行。
                 */
                bindService(bindIntent, connection, BIND_AUTO_CREATE);
            }
        });
        bindingView.button5UnbindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //如果和Service是绑定的状态，就解除绑定。
                if (mBound) {
                    unbindService(connection);
                    mBound = false;
                }
            }
        });

    }


}
