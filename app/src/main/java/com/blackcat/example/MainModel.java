package com.blackcat.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by blackcat on 2018/10/12.15.48
 * Model 进行数据获取和存储
 */

public class MainModel {
    private String[] titles = {"Android触摸事件分发机制"
            , "多线程编程(一)"
            ,"多线程编程(二)"
            ,"Android子线程进行UI操作"
            ,"AndroidService"};
    private String[] describes = {"触摸事件分发机制一直以来都是Android中比较重要的一大块，自定义view，各种复杂的自定义手势交互都与触摸事件分发机制关系密切，想要做好这些，就要对触摸事件了解透彻，并且需要不断的去实践来加深印象，否则在自己去实现的时候就会茫然不知所措，所以说掌握它是必须的。"
            , "了解线程和进程的区别、线程的多种创建方式、生命周期"
            ,"线程控制和线程同步、线程通信"
            ,"Android子线程到底能不能进行UI操作，为什么不推荐在子线程进行UI操作。"
            ,"Service是Android中实现程序后台运行的解决方案，非常适合用于去执行哪些不需要和用户交互而且还要求长期运行的任务。不能运行在一个独立的进程当中，而是依赖与创建服务时所在的应用程序进程。只能在后台运行，并且可以和其他组件进行交互。"};
    private String[] times = {"2018.10.12", "2018.10.19","2018.10.27","2018.10.27","2018.10.31"};

    public List<MainBean> getMainList() {
        List<MainBean> list = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            list.add(new MainBean(titles[i], describes[i], times[i]));
        }
        return list;
    }
}
