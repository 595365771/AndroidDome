package com.blackcat.example.ui.proxy3;

import com.blackcat.example.ui.proxy3.ManUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by blackcat on 2018/12/19.23.29
 */
public class MyInvocationHandler implements InvocationHandler {
    //需要被代理的对象
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     * 执行动态代理对象的所有方法时，都会被替换成执行如下的invoke方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        ManUtil manUtil = new ManUtil();
        manUtil.method1();
        //以target作为主调来执行method方法
        Object result = method.invoke(target,args);
        manUtil.method2();
        return result;
    }
}
