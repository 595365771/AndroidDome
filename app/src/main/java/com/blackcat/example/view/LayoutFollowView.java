package com.blackcat.example.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.blackcat.example.utils.DebugUtil;


/**
 * Created by blackcat on 2019/3/21.15.30
 */
public class LayoutFollowView extends LinearLayout {


    public LayoutFollowView(Context context) {
        super(context);
    }

    public LayoutFollowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LayoutFollowView(Context context, AttributeSet attrs, int defStyleAttr) {
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
                //让控件在指定区域内滑动，这里主要是防止滑出屏幕，具体参数可以自己调整
                if(getLeft()+offsetX>60&&getTop()+offsetY>60&&getRight()+offsetX<1020&&getBottom()+offsetY<1860){
                    //调用layout方法重置位置
                    layout(getLeft()+offsetX,getTop()+offsetY,getRight()+offsetX,getBottom()+offsetY);
                }

                break;
        }
         return super.onTouchEvent(event);
    }
}
