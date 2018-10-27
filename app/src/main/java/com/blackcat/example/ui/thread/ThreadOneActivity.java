package com.blackcat.example.ui.thread;

import android.os.Bundle;
import android.view.View;

import com.blackcat.example.R;
import com.blackcat.example.base.BaseActivity;
import com.blackcat.example.databinding.ActivityThreadOneBinding;
import com.blackcat.example.ui.thread.chlid.MyCallable;
import com.blackcat.example.ui.thread.chlid.MyRunnable;
import com.blackcat.example.ui.thread.chlid.MyThread;
import com.blackcat.example.utils.DebugUtil;
import com.blackcat.example.utils.PerfectClickListener;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadOneActivity extends BaseActivity<ActivityThreadOneBinding> {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_one);
        showContentView();
        initTitle();
        initListener();
    }


    private void initTitle() {
        getTitleBar().setTitleText("Thread(一)");
        getTitleBar().setB_leftOnClick(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                finish();
            }
        });
    }

    private void initListener() {
        bindingView.btnMythread.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                CreateThread();
            }
        });
        bindingView.btnMyrunnable.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                CreateRunnable();
            }
        });
        bindingView.btnMycallable.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                CreateCallable();
            }
        });
    }

    /**
     * 执行MyThread线程
     */
    private void CreateThread() {
        new MyThread().start();
    }

    /**
     * 执行MyRunnable线程
     */
    private void CreateRunnable() {
        new Thread(new MyRunnable()).start();
    }

    /**
     * 执行MyCallable线程
     */
    private void CreateCallable() {
        MyCallable myCallable = new MyCallable();

        //1.执行Callable方式，需要FutureTask实现类的支持，用于接收运算结果
        FutureTask<Integer> futureTask = new FutureTask<Integer>(myCallable);
        new Thread(futureTask).start();
        //2.接收线程运算后的结果
        try {
            DebugUtil.error(futureTask.get() + "");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
