package com.blackcat.example.ui.proxy2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blackcat.example.R;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;

public class Proxy2Activity extends AppCompatActivity {
private Button btn_proxy2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy2);
        initView();
        initListener();
    }

    private void initView() {
        btn_proxy2 = (Button) findViewById(R.id.btn_proxy2);
    }
    private void initListener() {
        btn_proxy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proxy2Test();
            }
        });
    }
//        //通过ava.lang.reflect.Proxy.newProxyInstance(...)方法，获取真实对象的代理对象。
//        Subject subject = (Subject) java.lang.reflect.Proxy
//                .newProxyInstance(man.getClass().getClassLoader(),
//                        man.getClass().getInterfaces(),p);
//        //通过代理对象调用真实对象相关接口中实现的方法。
//        subject.info();
//        subject.shopping();
//        //获得真实对象的代理对象所对应的Class对象的名称，用字符创表示
//        System.out.print(subject.getClass().getName());
    /**
     * 测试动态代理
     */
    private void proxy2Test(){
        Subject man = new Man();
        Proxy p =new Proxy(man);
        Class proxyClass = java.lang.reflect.Proxy.getProxyClass(man.getClass().getClassLoader()
                ,man.getClass().getInterfaces());
        try {
           Constructor ctor= proxyClass.getConstructor(InvocationHandler.class);
            Subject subject= (Subject) ctor.newInstance(new Object[]{p});
            subject.shopping();
            subject.info();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
