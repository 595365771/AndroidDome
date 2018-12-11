package com.blackcat.example.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.blackcat.example.utils.DebugUtil;

/**
 * Created by blackcat on 2018/11/1.15.20
 */

public class IntentServiceTest extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public IntentServiceTest(String name) {
        super(name);
    }

    /**
     * 调用父类有参构造函数。这里我们手动给服务起个名字为：IntentServiceTest
     */
    public IntentServiceTest() {
        super("IntentServiceTest");
    }

    //该方法在会在一个单独的线程中执行，来完成工作任务。任务结束后，该Service自动停止
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        for (int i = 0; i < 3; i++) {
            DebugUtil.error("IntentServiceTest的线程是：" + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        DebugUtil.error("onDestroy");
    }
}
