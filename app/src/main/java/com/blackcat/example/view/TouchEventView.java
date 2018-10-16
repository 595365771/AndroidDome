package com.blackcat.example.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.blackcat.example.utils.DebugUtil;

/**
 * Created by blackcat on 2018/10/15.13.50
 */

public class TouchEventView extends View {
    public TouchEventView(Context context) {
        super(context);
    }

    public TouchEventView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchEventView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                DebugUtil.error("dispatchTouchEventV: ======ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                DebugUtil.error("dispatchTouchEventV: ======ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                DebugUtil.error("dispatchTouchEventV: ======ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                DebugUtil.error("dispatchTouchEventV: ======ACTION_CANCEL");
                break;
            default:
                DebugUtil.error("dispatchTouchEventV: ======DEFAULT");
                break;

        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                DebugUtil.error("onTouchEventV: ======ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                DebugUtil.error("onTouchEventV: ======ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                DebugUtil.error("onTouchEventV: ======ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                DebugUtil.error("onTouchEventV: ======ACTION_CANCEL");
                break;
            default:
                DebugUtil.error("onTouchEventV: ======DEFAULT");
                break;

        }
        return super.onTouchEvent(event);
    }
}
