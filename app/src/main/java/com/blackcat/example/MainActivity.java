package com.blackcat.example;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.blackcat.example.base.BaseActivity;
import com.blackcat.example.base.baseadapter.OnItemClickListener;
import com.blackcat.example.base.baseadapter.setting.DividerListItemDecoration;
import com.blackcat.example.databinding.ActivityMainBinding;
import com.blackcat.example.ui.thread.ThreadOneActivity;
import com.blackcat.example.ui.touchevent.TouchEventActivity;
import com.blackcat.example.utils.CommonUtils;
import com.blackcat.example.utils.DensityUtil;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private MainModelView viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showContentView();
        initView();
        initAdapter();
    }

    private void initView() {
        getTitleBar().setTitleText("BlackCat");
        getTitleBar().setB_leftHide(true);
    }

    private void initAdapter() {
        viewModel = new MainModelView();
        MainAdapter mainAdapter = new MainAdapter();
        mainAdapter.setData(viewModel.mainBeans);
        bindingView.rvMain.setLayoutManager(new LinearLayoutManager(this));
        bindingView.rvMain.addItemDecoration(new DividerListItemDecoration(this, LinearLayoutManager.HORIZONTAL, DensityUtil.dip2px(0), CommonUtils.getColor(R.color.colorWhite)));
        bindingView.rvMain.setAdapter(mainAdapter);
        mainAdapter.setOnItemClickListener(new OnItemClickListener<MainBean>() {
            @Override
            public void onClick(MainBean mainBean, int position) {
                switch (position){
                    case 0:
                        turnToNextActivity(TouchEventActivity.class);
                        break;
                    case 1:
                        turnToNextActivity(ThreadOneActivity.class);
                        break;
                }

            }
        });
    }
}
