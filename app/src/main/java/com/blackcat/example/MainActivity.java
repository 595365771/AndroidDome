package com.blackcat.example;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.blackcat.example.base.BaseActivity;
import com.blackcat.example.base.baseadapter.setting.DividerListItemDecoration;
import com.blackcat.example.databinding.ActivityMainBinding;
import com.blackcat.example.utils.CommonUtils;
import com.blackcat.example.utils.DensityUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showContentView();
        initView();
    }

    private void initView() {
        getTitleBar().setTitleText("BlackCat");
        getTitleBar().setB_leftHide(true);
        List<String> list = new ArrayList<>();
        while (list.size()<15){
            list.add("-----hello-----");
        }
        MainAdapter mainAdapter = new MainAdapter();
        mainAdapter.setData(list);
        bindingView.rvMain.setLayoutManager(new LinearLayoutManager(this));
        bindingView.rvMain.addItemDecoration(new DividerListItemDecoration(this,LinearLayoutManager.HORIZONTAL, DensityUtil.dip2px(0), CommonUtils.getColor(R.color.colorWhite)));
        bindingView.rvMain.setAdapter(mainAdapter);

    }
}
