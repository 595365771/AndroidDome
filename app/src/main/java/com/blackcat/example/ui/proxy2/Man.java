package com.blackcat.example.ui.proxy2;

/**
 * Created by blackcat on 2018/12/12.17.12
 *
 */
public class Man implements Subject {
    @Override
    public void info() {
        System.out.println("BC"+"购物清单...");
    }

    @Override
    public void shopping() {
        System.out.println("BC"+"要去买东西...");
    }
}
