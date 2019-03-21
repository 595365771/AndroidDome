package com.blackcat.example.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

import com.blackcat.example.utils.DebugUtil;

/**
 * Created by blackcat on 2018/10/15.13.50
 */

public class VelocityTrackerView extends View {

    public VelocityTrackerView(Context context) {
        super(context);
    }

    public VelocityTrackerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public VelocityTrackerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //获得一个VelocityTracker对象
        VelocityTracker velocityTracker =VelocityTracker.obtain();
        //添加要计算的事件
        velocityTracker.addMovement(event);
        //设置时间，计算手指在1000ms内划过的像素
        velocityTracker.computeCurrentVelocity(1000);
        //获取水平方向移动速度
        int xVelocity = (int) velocityTracker.getXVelocity();
        //获取垂直方向移动速度
        int yVelocity = (int) velocityTracker.getYVelocity();
        //重置和回收内存
        velocityTracker.clear();
        velocityTracker.recycle();
        return super.onTouchEvent(event);
    }
}
