package com.blackcat.example.ui.thread;

import com.blackcat.example.utils.DebugUtil;

/**
 * Created by blackcat on 2018/10/19.14.37
 * 实现Runnable接口创建一个线程
 */

public class MyRunnable implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            DebugUtil.error(Thread.currentThread().getName()+"----------"+i);
        }
    }
}
