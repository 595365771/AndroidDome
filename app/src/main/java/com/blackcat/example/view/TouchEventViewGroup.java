package com.blackcat.example.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.blackcat.example.utils.DebugUtil;

/**
 * Created by blackcat on 2018/10/15.13.50
 */

public class TouchEventViewGroup extends LinearLayout {
    public TouchEventViewGroup(Context context) {
        super(context);
    }

    public TouchEventViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchEventViewGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                DebugUtil.error("onInterceptTouchEventVG: ======ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                DebugUtil.error("onInterceptTouchEventVG: ======ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                DebugUtil.error("onInterceptTouchEventVG: ======ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                DebugUtil.error("onInterceptTouchEventVG: ======ACTION_CANCEL");
                break;
            default:
                DebugUtil.error("onInterceptTouchEventVG: ======DEFAULT");
                break;

        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                DebugUtil.error("dispatchTouchEventVG: ======ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                DebugUtil.error("dispatchTouchEventVG: ======ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                DebugUtil.error("dispatchTouchEventVG: ======ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                DebugUtil.error("dispatchTouchEventVG: ======ACTION_CANCEL");
                break;
            default:
                DebugUtil.error("dispatchTouchEventVG: ======DEFAULT");
                break;

        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                DebugUtil.error("onTouchEventVG: ======ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                DebugUtil.error("onTouchEventVG: ======ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                DebugUtil.error("onTouchEventVG: ======ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                DebugUtil.error("onTouchEventVG: ======ACTION_CANCEL");
                break;
            default:
                DebugUtil.error("onTouchEventVG: ======DEFAULT");
                break;

        }
        return super.onTouchEvent(event);
    }
}
