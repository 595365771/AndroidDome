package com.blackcat.example.app;

import android.app.Application;


/**
sssss
 * Created by BlackCat on 2017/5/24.
 */

public class BlackApplication extends Application {
    private static BlackApplication canteetApplication;

    public static BlackApplication getInstance() {
        if (canteetApplication == null) {
            synchronized (BlackApplication.class) {
                if (canteetApplication == null) {
                    canteetApplication = new BlackApplication();
                }
            }
        }
        return canteetApplication;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        canteetApplication = this;
    }
}
