package com.blackcat.example.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

import com.blackcat.example.R;

/**
 * Created by blackcat on 2019/3/25.10.06
 * 绘制矩形
 */
public class RoundRectView extends android.support.v7.widget.AppCompatImageView {
   //创建一个画笔Paint开启防锯齿 也可以用paint.setAntiAlias(true)开启防锯齿
   Paint paint =new Paint(Paint.ANTI_ALIAS_FLAG);

    public RoundRectView(Context context) {
        super(context);
    }

    public RoundRectView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundRectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔的颜色
        paint.setColor(getResources().getColor(R.color.colorBlue));
        //设置空心圆
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        //设置画笔宽度
        paint.setStrokeWidth(4);
        /**
         * 进行绘制
         * left 矩形的左边到view左边的距离
         * top 矩形的上边到view上边的距离
         * right 矩形的右边到view左边的距离
         * bottom 矩形的下边到view上边的距离
         * rx 圆角的横向半径
         * ry 圆角的纵向半径
         * paint 画笔
         */
        RectF rectF =new RectF();
        rectF.left=10;
        rectF.top=10;
        rectF.right=getWidth()-10;
        rectF.bottom=getHeight()-10;
        canvas.drawRoundRect(rectF,10,10,paint);

    }
}
