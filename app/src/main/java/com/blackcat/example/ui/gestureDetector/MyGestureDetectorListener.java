package com.blackcat.example.ui.gestureDetector;

import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by blackcat on 2019/3/20.20.11
 *
 * 触发顺序：
 * 点击一下非常快的（不滑动）Touchup：
 *     onDown->onSingleTapUp->onSingleTapConfirmed
 * 点击一下稍微慢点的（不滑动）Touchup：
 *     onDown->onShowPress->onSingleTapUp->onSingleTapConfirmed
 * 滑屏：手指触动屏幕后，稍微滑动后立即松开
 *     onDown-----》onScroll----》onScroll----》onScroll----》………----->onFling
 * 拖动:
 *     onDown------》onScroll----》onScroll------》onFiling
 * 可见，无论是滑屏，还是拖动，影响的只是中间OnScroll触发的数量多少而已，最终都会触发onFling事件！
 *
 */
public class MyGestureDetectorListener implements GestureDetector.OnGestureListener ,GestureDetector.OnDoubleTapListener {
    /**
     * 用户按下屏幕就会触发 由一个ACTION_DOWN触发
     * @param e
     * @return
     */
    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }
    /**
     * 单击事件 一次单独的轻击抬起操作,也就是轻击一下屏幕，立刻抬起来，ACTION_UP事件触发,
     * 如果除了Down以外还有其它操作,那就不再算是Single操作了,所以也就不会触发这个事件
     * @param e
     * @return
     */
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }
    /**
     * 用户按下屏幕而且在按下的时候没有松开或者是拖动 由一个ACTION_DOWN触发，和onDown不同强调的是没有松开和拖动
     * @param e
     */
    @Override
    public void onShowPress(MotionEvent e) {

    }
    /**
     * 长按触摸屏，超过一定时长，就会触发这个事件
     * @param e
     */
    @Override
    public void onLongPress(MotionEvent e) {

    }
    /**
     * 在屏幕上拖动事件。无论是用手拖动view，或者是以抛的动作滚动，都会多次触发,这个方法. 在ACTION_MOVE动作发生时就会触发
     *
     * @param e1
     * @param e2
     * @param distanceX
     * @param distanceY
     * @return
     */
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }


    /**
     * 滑屏，用户按下触摸屏、快速移动后松开，由1个MotionEvent ACTION_DOWN, 多个ACTION_MOVE, 1个ACTION_UP触发
     * @param e1 第1个ACTION_DOWN MotionEvent
     * @param e2 最后一个ACTION_MOVE MotionEvent
     * @param velocityX X轴上的移动速度，像素/秒
     * @param velocityY Y轴上的移动速度，像素/秒
     * @return
     */
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }


    //********************************* 下面是OnDoubleTapListener接口方法  *********************************

    /**
     * 严格的单击行为，和onSingleTapUp的区别在于在onSingleTapConfirmed后不可能在紧跟着另一个单击行为，
     * onSingleTapConfirmed不可能是两次双击事件中的一次单击
     * @param e
     * @return
     */
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    /**
     * 双击两次连续的单击 不可能和onSingleTapConfirmed同时存在
     * @param e
     * @return
     */
    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    /**
     * 表示发生了双击行为在双击期间 ACTION_DOWN，ACTION_MOVE，ACTION_UP都会触发此回调
     * @param e
     * @return
     */
    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }
}
