package com.blackcat.example.ui.thread;

import android.os.Bundle;
import android.view.View;

import com.blackcat.example.R;
import com.blackcat.example.base.BaseActivity;
import com.blackcat.example.databinding.ActivityThreadThreeBinding;
import com.blackcat.example.utils.PerfectClickListener;

public class ThreadThreeActivity extends BaseActivity<ActivityThreadThreeBinding> {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_three);
        showContentView();
        initTitle();
    }


    private void initTitle() {
        getTitleBar().setTitleText("子线程UI操作");
        getTitleBar().setB_leftOnClick(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                finish();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                bindingView.btnUi.setText("Thread");
//            }
//        }).start();

    }

}
