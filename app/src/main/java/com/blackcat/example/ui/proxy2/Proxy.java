package com.blackcat.example.ui.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by blackcat on 2018/12/12.17.19
 */
public class Proxy  implements InvocationHandler {
    private Object target;//要代理的真是对象
    public Proxy(Subject target){
        this.target =target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy:"+proxy.getClass().getName());
        System.out.println("before...");
        method.invoke(target,args);
        System.out.println("after...");
        return null;
    }
}
