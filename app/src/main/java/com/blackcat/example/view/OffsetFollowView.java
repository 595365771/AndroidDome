package com.blackcat.example.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.blackcat.example.utils.DebugUtil;

/**
 * Created by blackcat on 2019/3/21.15.30
 */
public class OffsetFollowView extends android.support.v7.widget.AppCompatTextView {


    public OffsetFollowView(Context context) {
        super(context);
    }

    public OffsetFollowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OffsetFollowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int lastX;
    private int lastY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        DebugUtil.debug("----");
        //手指当前的位置
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //记录下手指按下的位置
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算移动偏移量（手指当前的位置减去按下的位置）
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                if(getLeft()+offsetX>60&&getRight()+offsetX<1020){
                    //对left和right 进行偏移
                    offsetLeftAndRight(offsetX);
                }
                if(getTop()+offsetY>60&&getBottom()+offsetY<1860){
                    //对top 和 bottom 进行偏移
                    offsetTopAndBottom(offsetY);
                }

                break;
        }
        return super.onTouchEvent(event);
    }
}
