package com.blackcat.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.blackcat.example.utils.DebugUtil;

/**
 * Created by blackcat on 2018/10/31.15.41
 */

public class BindServiceTest extends Service {
    private BinderTest binderTest = new BinderTest();


    /**
     * 构造方法
     */
    public BindServiceTest() {

        super();
    }

    /**
     * 创建服务时调用
     */
    @Override
    public void onCreate() {
        super.onCreate();
        DebugUtil.error("onCreate");
    }

    /**
     * 服务执行的操作
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        DebugUtil.error("onStartCommand");
        new Thread(new Runnable() {
            public void run() {
                //处理具体的逻辑
                stopSelf();  //服务执行完毕后自动停止
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);

    }

    /**
     * 销毁服务时调用
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        DebugUtil.error("onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        DebugUtil.error("onBind");
        return binderTest; //这里返回新建的BinderTest类
    }

    /**
     * BinderTest类，继承Binder：让里面的方法执行下载任务，并获取下载进度
     */
    public class BinderTest extends Binder {

        public void startDownload() {
            DebugUtil.error("startDownload() executed");
            // 执行具体的下载任务
        }

        public int getProgress() {
            DebugUtil.error("getProgress() executed");
            return 0;
        }

    }
}
