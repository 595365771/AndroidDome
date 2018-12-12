package com.blackcat.example.ui.proxy1;

/**
 * Created by blackcat on 2018/12/11.20.51
 */
public class RealObject extends  AbstractObject {
    @Override
    protected void operation() {
        System.out.print("do operation...");
    }
}
