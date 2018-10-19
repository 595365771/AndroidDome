package com.blackcat.example.ui.touchevent;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;

import com.blackcat.example.MainAdapter;
import com.blackcat.example.MainModelView;
import com.blackcat.example.R;
import com.blackcat.example.base.BaseActivity;
import com.blackcat.example.base.baseadapter.setting.DividerListItemDecoration;
import com.blackcat.example.databinding.ActivityMainBinding;
import com.blackcat.example.databinding.ActivityTouchEventBinding;
import com.blackcat.example.utils.CommonUtils;
import com.blackcat.example.utils.DebugUtil;
import com.blackcat.example.utils.DensityUtil;
import com.blackcat.example.utils.PerfectClickListener;

public class TouchEventActivity extends BaseActivity<ActivityTouchEventBinding> {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);
        showContentView();
        initTitle();
        initListener();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                DebugUtil.error("dispatchTouchEventActivity: ======ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                DebugUtil.error("dispatchTouchEventActivity: ======ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                DebugUtil.error("dispatchTouchEventActivity: ======ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                DebugUtil.error("dispatchTouchEventActivity: ======ACTION_CANCEL");
                break;
            default:
                DebugUtil.error("dispatchTouchEventActivity: ======DEFAULT");
                break;

        }
        return super.dispatchTouchEvent(ev);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                DebugUtil.error("onTouchEventActivity: ======ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                DebugUtil.error("onTouchEventActivity: ======ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                DebugUtil.error("onTouchEventActivity: ======ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                DebugUtil.error("onTouchEventActivity: ======ACTION_CANCEL");
                break;
            default:
                DebugUtil.error("onTouchEventActivity: ======DEFAULT");
                break;

        }
        return super.onTouchEvent(event);
    }

    private void initTitle() {
        getTitleBar().setTitleText("TouchEvent");
        getTitleBar().setB_leftOnClick(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                finish();
            }
        });
    }

    private void initListener() {
        bindingView.tevTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DebugUtil.error("onClickV:====");
            }
        });
        bindingView.tevTest.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                DebugUtil.error("onTouchV:====");
                return bindingView.swOntouch.isChecked();
            }
        });
        bindingView.tevgVg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                DebugUtil.error("onTouchVG:====");
                return false;
            }
        });
        bindingView.tevgVg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DebugUtil.error("onClickVG:====");
            }
        });
        bindingView.tevVg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                DebugUtil.error("onTouchVGView:====");
                return false;
            }
        });
        bindingView.tevVg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DebugUtil.error("onClickVGView:====");
            }
        });
    }

}
