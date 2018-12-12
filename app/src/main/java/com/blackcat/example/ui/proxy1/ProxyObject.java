package com.blackcat.example.ui.proxy1;

/**
 * Created by blackcat on 2018/12/11.20.56
 */
public class ProxyObject extends AbstractObject {
    //对目标类的引用
    private RealObject realObject;

    @Override
    protected void operation() {
        System.out.println("do something before real operation...");
        if (realObject == null) {
            realObject = new RealObject();
        }
        realObject.operation();
        System.out.println("do something before real operation...");
    }
}
