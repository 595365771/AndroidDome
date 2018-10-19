package com.blackcat.example.ui.thread;

import com.blackcat.example.utils.DebugUtil;

import java.util.concurrent.Callable;

/**
 * Created by blackcat on 2018/10/19.15.10
 * 使用Callable和Future创建线程
 */

public class MyCallable implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        int sum=0;
        for (int i = 0; i < 50; i++) {
            DebugUtil.error(Thread.currentThread().getName()+"----------"+i);
            sum+=i;
        }

        return sum;
    }
}
