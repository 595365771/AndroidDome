package com.blackcat.example;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by blackcat on 2018/10/12.15.59
 */

public class MainBean extends BaseObservable {
    private String title;
    private String time;
    private String describe;

    public MainBean() {
    }

    public MainBean(String title, String describe, String time) {
        this.title = title;
        this.time = time;
        this.describe = describe;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }
    @Bindable
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
        notifyPropertyChanged(BR.time);
    }
    @Bindable
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
        notifyPropertyChanged(BR.describe);
    }


}
