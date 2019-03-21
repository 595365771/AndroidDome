package com.blackcat.example.ui.GestureDetector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.blackcat.example.R;

public class GestureDetectorActivity extends AppCompatActivity {
    //定义手势检测器实例
    private GestureDetector detector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_detector);
        initView();
    }

    /**
     * 初始化GestureDetector对象
     */
    private void initView() {
        detector=new GestureDetector(this,new MyGestureDetectorListener());
    }

    /**
     * 使用detector.onTouchEvent(event)接管onTouchEvent的事件处理
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean consume = detector.onTouchEvent(event);
        return consume;
    }
}
