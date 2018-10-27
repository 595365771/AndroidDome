package com.blackcat.example.ui.thread.chlid;

import com.blackcat.example.utils.DebugUtil;

/**
 * Created by blackcat on 2018/10/19.14.37
 * 继承Thread创建一个线程
 */

public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 50; i++) {
            DebugUtil.error(this.getName()+"----------"+i);
        }

    }
}
