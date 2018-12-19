package com.blackcat.example.ui.proxy3;

import java.lang.reflect.Proxy;

/**
 * Created by blackcat on 2018/12/19.23.37
 */
public class MyProxyFactory {
    /**
     * 为指定的target生成动态代理对象
     * @param target
     * @return
     */
    public static Object getProxy(Object target) throws Exception{
        //创建一个MyInvocationHandler对象
        MyInvocationHandler handler = new MyInvocationHandler();
        //为MyInvocationHandler设置target对象
        handler.setTarget(target);
        //创建并返回一个动态代理
        return Proxy.newProxyInstance(target.getClass().getClassLoader()
                ,target.getClass().getInterfaces(),handler);
    }
}
