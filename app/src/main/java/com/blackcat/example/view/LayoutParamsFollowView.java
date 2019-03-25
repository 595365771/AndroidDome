package com.blackcat.example.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.blackcat.example.utils.DebugUtil;

/**
 * Created by blackcat on 2019/3/21.15.30
 */
public class LayoutParamsFollowView extends android.support.v7.widget.AppCompatTextView {


    public LayoutParamsFollowView(Context context) {
        super(context);
    }

    public LayoutParamsFollowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LayoutParamsFollowView(Context context, AttributeSet attrs, int defStyleAttr) {
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

                if(getLeft()+offsetX>60&&getRight()+offsetX<1020&&getTop()+offsetY>60&&getBottom()+offsetY<1860){
//                  如果父布局是  RelativeLayout使用这种方式获取LayoutParams对象
//                  RelativeLayout.LayoutParams layoutParams= (RelativeLayout.LayoutParams) getLayoutParams();

//                  我们的父布局是LinearLayout布局所以使用LinearLayout.LayoutParams
//                  LinearLayout.LayoutParams  layoutParams =  (LinearLayout.LayoutParams)  getLayoutParams();

//                  使用ViewGroup的MarginLayoutParams对象也能实现这个效果
                    ViewGroup.MarginLayoutParams  layoutParams =  (ViewGroup.MarginLayoutParams)  getLayoutParams();
                    layoutParams.leftMargin =  getLeft()  +  offsetX;
                    layoutParams.topMargin =  getTop()+  offsetY;
                    setLayoutParams(layoutParams);
                }

                break;
        }
        return super.onTouchEvent(event);
    }
}
