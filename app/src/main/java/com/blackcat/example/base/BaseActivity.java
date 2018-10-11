package com.blackcat.example.base;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


import com.blackcat.example.R;
import com.blackcat.example.databinding.ActivityBaseBinding;
import com.blackcat.example.utils.PerfectClickListener;
import com.blackcat.example.view.TitleBar;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/**
 * Created by BlackCat on 2018/10/10.
 */
public class BaseActivity<SV extends ViewDataBinding> extends AppCompatActivity {

    // 布局view
    protected SV bindingView;
    private TitleBar titleBar;
    private LinearLayout llProgressBar;
    private View refresh;
    private LinearLayout llEmpty;
    private ActivityBaseBinding mBaseBinding;
    private AnimationDrawable mAnimationDrawable;
    private CompositeDisposable mCompositeDisposable;
    protected <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        mBaseBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_base, null, false);
        bindingView = DataBindingUtil.inflate(getLayoutInflater(), layoutResID, null, false);
        // content
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        bindingView.getRoot().setLayoutParams(params);
        RelativeLayout mContainer = (RelativeLayout) mBaseBinding.getRoot().findViewById(R.id.container);
        mContainer.addView(bindingView.getRoot());
        getWindow().setContentView(mBaseBinding.getRoot());
        titleBar = getView(R.id.titleBar);
        llProgressBar = getView(R.id.ll_progress_bar);
        refresh = getView(R.id.ll_error_refresh);
        llEmpty = getView(R.id.ll_empty);
        ImageView img = getView(R.id.img_progress);
        // 加载动画
        mAnimationDrawable = (AnimationDrawable) img.getDrawable();
        // 默认进入页面就开启动画
        if (!mAnimationDrawable.isRunning()) {
            mAnimationDrawable.start();
        }
        // 点击加载失败布局
        llEmpty.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                showLoading();
                onRefresh();
            }
        });
        // 点击加载失败布局
        refresh.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                showLoading();
                onRefresh();
            }
        });
        bindingView.getRoot().setVisibility(View.GONE);
    }




    protected void showLoading() {
        if (llProgressBar.getVisibility() != View.VISIBLE) {
            llProgressBar.setVisibility(View.VISIBLE);
        }
        // 开始动画
        if (!mAnimationDrawable.isRunning()) {
            mAnimationDrawable.start();
        }
        if (bindingView.getRoot().getVisibility() != View.GONE) {
            bindingView.getRoot().setVisibility(View.GONE);
        }
        if (llEmpty.getVisibility() != View.GONE) {
            llEmpty.setVisibility(View.GONE);
        }
        if (refresh.getVisibility() != View.GONE) {
            refresh.setVisibility(View.GONE);
        }
    }

    public void showContentView() {
        if (llProgressBar.getVisibility() != View.GONE) {
            llProgressBar.setVisibility(View.GONE);
        }
        // 停止动画
        if (mAnimationDrawable.isRunning()) {
            mAnimationDrawable.stop();
        }
        if (refresh.getVisibility() != View.GONE) {
            refresh.setVisibility(View.GONE);
        }
        if (llEmpty.getVisibility() != View.GONE) {
            llEmpty.setVisibility(View.GONE);
        }
        if (bindingView.getRoot().getVisibility() != View.VISIBLE) {
            bindingView.getRoot().setVisibility(View.VISIBLE);
        }
    }

    protected void showEmpty() {
        if (llProgressBar.getVisibility() != View.GONE) {
            llProgressBar.setVisibility(View.GONE);
        }
        // 停止动画
        if (mAnimationDrawable.isRunning()) {
            mAnimationDrawable.stop();
        }
        if (llEmpty.getVisibility() != View.VISIBLE) {
            llEmpty.setVisibility(View.VISIBLE);
        }
        if (refresh.getVisibility() != View.GONE) {
            refresh.setVisibility(View.GONE);
        }
        if (bindingView.getRoot().getVisibility() != View.GONE) {
            bindingView.getRoot().setVisibility(View.GONE);
        }
    }

    public void showError() {
        if (llProgressBar.getVisibility() != View.GONE) {
            llProgressBar.setVisibility(View.GONE);
        }
        // 停止动画
        if (mAnimationDrawable.isRunning()) {
            mAnimationDrawable.stop();
        }
        if (refresh.getVisibility() != View.VISIBLE) {
            refresh.setVisibility(View.VISIBLE);
        }
        if (llEmpty.getVisibility() != View.GONE) {
            llEmpty.setVisibility(View.GONE);
        }
        if (bindingView.getRoot().getVisibility() != View.GONE) {
            bindingView.getRoot().setVisibility(View.GONE);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();

    }

    /**
     * 失败后点击刷新
     */
    protected void onRefresh() {

    }

    /**
     * 返回titleBar
     * @return titleBar
     */
    public TitleBar getTitleBar() {
        return titleBar;
    }
    public void addSubscription(Disposable s) {
        if (this.mCompositeDisposable == null) {
            this.mCompositeDisposable = new CompositeDisposable();
        }
        this.mCompositeDisposable.add(s);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.mCompositeDisposable != null) {
            this.mCompositeDisposable.dispose();
        }
    }

    public void removeSubscription() {
        if (this.mCompositeDisposable != null) {
            this.mCompositeDisposable.dispose();
        }
    }

    /**
     * 跳转到下一个Activity 销毁自己
     */
    protected void turnToActivity(Class<?> dest) {
        Intent intent = new Intent(this, dest);
        startActivity(intent);
        finish();
    }


    /**
     * 带参跳转到下一个Activity 销毁自己
     */
    protected void turnToActivity(Class<?> dest, Bundle bundle) {
        Intent intent = new Intent(this, dest);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    /**
     * 跳转到下一个Activity 把自己压入栈内
     */
    protected void turnToNextActivity(Class<?> dest) {
        Intent intent = new Intent(this, dest);
        startActivity(intent);
    }

    /**
     * 带参跳转到下一个Activity 把自己压入栈内
     */
    protected void turnToActivityForResult(Class<?> dest) {
        Intent intent = new Intent(this, dest);
        startActivityForResult(intent, 0);
    }

    /**
     * 跳转到下一个Activity 把自己压入栈内
     */
    protected void turnToActivityForResult(Class<?> dest, int resultCode) {
        Intent intent = new Intent(this, dest);
        startActivityForResult(intent, resultCode);
    }

    /**
     * 跳转到下一个Activity 把自己压入栈内 传递传参数
     */
    protected void turnToNextActivity(Class<?> dest, Bundle bundle) {
        Intent intent = new Intent(this, dest);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * 带参跳转到下一个Activity 把自己压入栈内
     */
    protected void turnToActivityForResult(Class<?> dest, Bundle bundle) {
        Intent intent = new Intent(this, dest);
        intent.putExtras(bundle);
        startActivityForResult(intent, 0);
    }

    /**
     * 带参跳转到下一个Activity 把自己压入栈内
     */
    protected void turnToActivityForResult(Class<?> dest, Bundle bundle, int requestCode) {
        Intent intent = new Intent(this, dest);
        intent.putExtras(bundle);
        startActivityForResult(intent, requestCode);
    }


}
