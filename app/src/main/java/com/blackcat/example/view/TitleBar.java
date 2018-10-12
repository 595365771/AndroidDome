package com.blackcat.example.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blackcat.example.R;
import com.blackcat.example.utils.DensityUtil;

/**
 * Created by blackcat on 2018/10/11.10.32
 */

public class TitleBar extends RelativeLayout {
    // 这里使用0x282828相当于0x00282828
    private final int B_LEFT_TEXT_COLOR_DEFAULT = 0xFF484759;
    private final int B_RIGHT_TEXT_COLOR_DEFAULT = 0xFF484759;
    private final int ETV_TITLE_TEXT_COLOR_DEFAULT = 0xFF484759;
    private Button b_left;
    private Button b_right;
    private TextView tv_title;

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_title_bar, this, true);
        b_left = (Button) view.findViewById(R.id.b_left);
        b_right = (Button) view.findViewById(R.id.b_right);
        tv_title = (TextView) view.findViewById(R.id.etv_title);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
        if (attributes != null) {
            //rightButton的隐藏显示
            boolean rightButtonVisible = attributes.getBoolean(R.styleable.TitleBar_right_button_visible, true);
            if (rightButtonVisible) {
                b_right.setVisibility(View.VISIBLE);
            } else {
                b_right.setVisibility(View.INVISIBLE);
            }
            //rightButton显示的文字
            String rightButtonText = attributes.getString(R.styleable.TitleBar_right_button_text);
            if (!TextUtils.isEmpty(rightButtonText)) {
                b_right.setText(rightButtonText);
            }
            //rightButton的TextColor 设置
            int rightButtonTextColor = attributes.getColor(R.styleable.TitleBar_right_button_text_color, B_RIGHT_TEXT_COLOR_DEFAULT);
            b_right.setTextColor(rightButtonTextColor);
            //rightButton 的 rightDrawable 设置
            int rightButtonDrawable = attributes.getResourceId(R.styleable.TitleBar_right_button_drawable, -1);
            if (rightButtonDrawable != -1) {
                Drawable drawable = getResources().getDrawable(rightButtonDrawable);
                drawable.setBounds(0, 0, DensityUtil.dip2px(9), DensityUtil.dip2px(16));
                b_right.setCompoundDrawables(null, null, drawable, null);
            }
            //leftButton的隐藏显示
            boolean leftButtonVisible = attributes.getBoolean(R.styleable.TitleBar_left_button_visible, true);
            if (leftButtonVisible) {
                b_left.setVisibility(View.VISIBLE);
            } else {
                b_left.setVisibility(View.INVISIBLE);
            }
            //leftButton显示和隐藏
            String leftButtonText = attributes.getString(R.styleable.TitleBar_left_button_text);
            if (!TextUtils.isEmpty(leftButtonText)) {
                b_left.setText(leftButtonText);
            }
            //leftButton的leftDrawable
            int leftButtonDrawable = attributes.getResourceId(R.styleable.TitleBar_left_button_drawable, -1);
            if (leftButtonDrawable != -1) {
                Drawable drawable = getResources().getDrawable(leftButtonDrawable);
                drawable.setBounds(0, 0, DensityUtil.dip2px(9), DensityUtil.dip2px(16));
                b_left.setCompoundDrawables(drawable, null, null, null);
            }
            //leftButton的textColor
            int leftButtonTextColor = attributes.getColor(R.styleable.TitleBar_left_button_text_color, B_LEFT_TEXT_COLOR_DEFAULT);
            b_left.setTextColor(leftButtonTextColor);
            //etv_title 的背景设置
            int titleBackGround = attributes.getResourceId(R.styleable.TitleBar_title_text_background, -1);
            if (titleBackGround != -1) {
                tv_title.setBackgroundResource(titleBackGround);
            }
            //etv_title 的文字设置
            String titleText = attributes.getString(R.styleable.TitleBar_title_text);
            if (!TextUtils.isEmpty(titleText)) {
                tv_title.setText(titleText);
            }
            //etv_title 的TextColor设置
            int titleTextColor = attributes.getColor(R.styleable.TitleBar_title_text_color, ETV_TITLE_TEXT_COLOR_DEFAULT);
            tv_title.setTextColor(titleTextColor);

            if (attributes != null) {
                attributes.recycle();
            }
        }
    }

    /**
     * @return the b_left
     */
    public Button getB_left() {
        return b_left;
    }

    /**
     * @param b_left the b_left to set
     */
    public void setB_left(Button b_left) {
        this.b_left = b_left;
    }

    /**
     *
     * @param onClick
     */
    public void setB_leftOnClick(OnClickListener onClick){
        this.b_left.setOnClickListener(onClick);
    }
    /**
     * @return the b_right
     */
    public Button getB_right() {
        return b_right;
    }

    /**
     * @param b_right the b_right to set
     */
    public void setB_right(Button b_right) {
        this.b_right = b_right;
    }
    /**
     * @param b_rightText
     *            the b_rightText to set
     */
    /**
     *
     * @param onClick
     */
    public void setB_rightOnClick(OnClickListener onClick){
        this.b_right.setOnClickListener(onClick);
    }

    /**
     * @return the etv_title
     */
    public TextView getTv_title() {
        return tv_title;
    }

    public void setTitleText(CharSequence text) {
        tv_title.setText(text);
    }

    public void setB_leftHide(boolean bol) {
        if (bol) {
            b_left.setVisibility(View.GONE);
        } else {
            b_left.setVisibility(View.VISIBLE);

        }

    }

}
