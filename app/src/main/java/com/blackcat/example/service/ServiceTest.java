package com.blackcat.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.blackcat.example.utils.DebugUtil;

/**
 * Created by blackcat on 2018/10/31.15.41
 */

public class ServiceTest extends Service {
    /**
     * 构造方法
     */
    public ServiceTest() {
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
        return null;
    }
}
