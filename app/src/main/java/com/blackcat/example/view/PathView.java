package com.blackcat.example.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import com.blackcat.example.R;

/**
 * Created by blackcat on 2019/3/25.10.06
 * 绘制自定义图形，心形
 */
public class PathView extends android.support.v7.widget.AppCompatImageView {
    //创建一个画笔Paint开启防锯齿
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public PathView(Context context) {
        super(context);
    }

    public PathView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔的颜色
        paint.setColor(getResources().getColor(R.color.colorBlue));
        //设置空心圆
        paint.setStyle(Paint.Style.STROKE);
        //设置画笔宽度
        paint.setStrokeWidth(4);
        Path path = new Path();
        //添加一个扇形
        path.addArc(200, 200, 400, 400, -225, 225);
        //从上个扇形结束的位置再画一个扇形
        path.arcTo(400, 200, 600, 400, -180, 225, false);
        //从第二个扇形结束的位置在画一根线，X和Y是线结束的位置 path.lineTo绝对位置
        path.lineTo(400, 542);
        //从上一根线结束的位置再画一根线，X和Y是线结束的位置，也是第一个扇形的起始位置
        //path.rLineTo(228, 372);

        //path.rLineTo相对位置（相对于上一个图形结束的点的位置）
        path.rLineTo(-172, -170);
        canvas.drawPath(path, paint);

    }
}
