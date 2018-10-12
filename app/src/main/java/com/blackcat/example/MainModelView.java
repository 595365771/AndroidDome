package com.blackcat.example;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by blackcat on 2018/10/12.16.15
 * 通过数据来控制业务逻辑，完成View和Model 的交互
 */

public class MainModelView {
    private MainModel model;
    public final List<MainBean> mainBeans = new ArrayList<>();
    public MainModelView(){
        model=new MainModel();
        mainBeans.addAll(model.getMainList());
    }

}
