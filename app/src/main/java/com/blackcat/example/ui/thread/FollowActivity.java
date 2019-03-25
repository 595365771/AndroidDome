package com.blackcat.example.ui.thread;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

import com.blackcat.example.R;
import com.blackcat.example.utils.DebugUtil;


public class FollowActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);

    }
    public void lFVClick(View view){
        Toast.makeText(this,"lFVClick",Toast.LENGTH_SHORT).show();
    }

    public void oFVClick(View view){
        Toast.makeText(this,"oFVClick",Toast.LENGTH_SHORT).show();
    }
    public void lPFVClick(View view){
        Toast.makeText(this,"lPFVClick",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void tVClick(View view){
        Toast.makeText(this,"tVClick",Toast.LENGTH_SHORT).show();
        view.startAnimation(AnimationUtils.loadAnimation(FollowActivity.this, R.anim.translate));
    }
    public void tVOClick(View view){
        Toast.makeText(this,"tVClick",Toast.LENGTH_SHORT).show();
        ObjectAnimator.ofFloat(view,"translationX",0,300).setDuration(1000).start();
    }
    public void sFOClick(View view){
        Toast.makeText(this,"sFOClick",Toast.LENGTH_SHORT).show();
    }

    private int lastX;
    private int lastY;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //手指当前的位置
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:
                //计算移动偏移量（手指当前的位置减去按下的位置）
                int offsetX = x - lastX;
                int offsetY = y - lastY;
//                this.getWindow().getDecorView().scrollTo(-x, -y);
                this.getWindow().getDecorView().scrollBy(-offsetX, -offsetY);
                break;
        }
        //手指最后松开的位置
        lastX = x;
        lastY = y;
        return super.onTouchEvent(event);
    }


}
