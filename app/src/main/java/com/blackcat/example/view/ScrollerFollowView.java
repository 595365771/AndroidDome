package com.blackcat.example.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Scroller;

import com.blackcat.example.utils.DebugUtil;

/**
 * Created by blackcat on 2019/3/22.15.03
 */
public class ScrollerFollowView extends android.support.v7.widget.AppCompatTextView {

    public ScrollerFollowView(Context context) {
        super(context);
    }

    public ScrollerFollowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollerFollowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Scroller mScroller = new Scroller(getContext());
    int lastX;
    int lastY;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        DebugUtil.debug("----");
        //手指当前的位置
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //手指按下的位置
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                smoothScrollTo(-offsetX, -offsetY);
                break;
        }

        return super.onTouchEvent(event);
    }

    /**
     *
     * @param offsetX X轴偏移量 正数向左负数向右
     * @param offsetY Y轴便宜量 正数向上负数向下
     */
    private void smoothScrollTo(int offsetX, int offsetY) {
        DebugUtil.debug("offsetX--"+offsetX);
        DebugUtil.debug("offsetY--"+offsetY);
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        mScroller.startScroll(scrollX, scrollY, offsetX, offsetY,500);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
        super.computeScroll();
    }
}
