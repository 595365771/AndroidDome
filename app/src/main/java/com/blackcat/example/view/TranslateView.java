package com.blackcat.example.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.blackcat.example.utils.DebugUtil;

/**
 * Created by blackcat on 2019/3/21.15.30
 */
public class TranslateView extends android.support.v7.widget.AppCompatTextView {


    public TranslateView(Context context) {
        super(context);
    }

    public TranslateView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TranslateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        DebugUtil.debug("----");
        return super.onTouchEvent(event);
    }
}
