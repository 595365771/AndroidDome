package com.blackcat.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by blackcat on 2018/10/12.15.48
 * Model 进行数据获取和存储
 */

public class MainModel {
    private String[] titles = {"Android触摸事件分发机制"};
    private String[] describes = {"触摸事件分发机制一直以来都是Android中比较重要的一大块，自定义view，各种复杂的自定义手势交互都与触摸事件分发机制关系密切，想要做好这些，就要对触摸事件了解透彻，并且需要不断的去实践来加深印象，否则在自己去实现的时候就会茫然不知所措，所以说掌握它是必须的。"};
    private String[] times = {"2018.10.12"};

    public List<MainBean> getMainList() {
        List<MainBean> list = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            list.add(new MainBean(titles[i], describes[i], times[i]));
        }
        return list;
    }
}
