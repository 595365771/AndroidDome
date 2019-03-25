package com.blackcat.example.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.blackcat.example.R;

/**
 * Created by blackcat on 2019/3/25.10.06
 * 绘制椭圆
 */
public class OvalView extends android.support.v7.widget.AppCompatImageView {
   //创建一个画笔Paint开启防锯齿 也可以用paint.setAntiAlias(true)开启防锯齿
   Paint paint =new Paint(Paint.ANTI_ALIAS_FLAG);

    public OvalView(Context context) {
        super(context);
    }

    public OvalView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OvalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔的颜色
        paint.setColor(getResources().getColor(R.color.colorBlue));
        //设置空心
        paint.setStyle(Paint.Style.STROKE);
        //设置画笔宽度
        paint.setStrokeWidth(4);
        /**
         * 进行绘制
         * left、top、right、bottom 椭圆四个顶边的位置
         * paint 画笔
         */
        canvas.drawOval(0, getHeight()/3, getWidth(), getHeight()*2/3, paint);

    }
}
