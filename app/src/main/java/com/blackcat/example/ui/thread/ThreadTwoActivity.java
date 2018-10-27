package com.blackcat.example.ui.thread;

import android.os.Bundle;
import android.view.View;

import com.blackcat.example.R;
import com.blackcat.example.base.BaseActivity;
import com.blackcat.example.databinding.ActivityThreadTwoBinding;
import com.blackcat.example.ui.thread.chlid.MyRunnable;
import com.blackcat.example.utils.DebugUtil;
import com.blackcat.example.utils.PerfectClickListener;

public class ThreadTwoActivity extends BaseActivity<ActivityThreadTwoBinding> {
    private Thread threadOne,threadTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_two);
        showContentView();
        initTitle();
        initListener();
    }


    private void initTitle() {
        getTitleBar().setTitleText("Thread(二)");
        getTitleBar().setB_leftOnClick(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                finish();
            }
        });
    }

    private void initListener() {
        //Dome 创建了threadOne和threadTwo两个子线程在主线程中执行，并在两个子线程启动后在主线程打印了一行log，正常情况下主线程打印的log会先打印，然后两个子线程并发执行。但我们调用了threaOne的join方法，执行顺序就会变成threaOne线程先执行完后其他线程才获得执行机会。
        bindingView.btnJoin.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                // 尝试join()方法
                threadOne=new Thread(new MyRunnable(),"threadOne");
                threadOne.start();
                try {
                    threadOne.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadTwo=new Thread(new MyRunnable(),"threadTwo");
                threadTwo.start();
                DebugUtil.error(Thread.currentThread().getName()+"----------ThreadTwoActivity");
            }
        });


    }


}
