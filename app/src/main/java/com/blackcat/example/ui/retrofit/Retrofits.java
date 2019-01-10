package com.blackcat.example.ui.retrofit;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by blackcat on 2018/12/11.17.51
 */
public class Retrofits {
    public void MyRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://xxx.xxx.com/")//设置网络请求的Url
                .addConverterFactory(GsonConverterFactory.create())//设置数据解析器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//支持RxJava平台
                .build();

        MyInterface myInterface = retrofit.create(MyInterface.class);
        Call call = myInterface.getCall();

        try {
            //同步请求
            Response response= call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //异步请求
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                System.out.println("请求失败");
            }
        });
    }
}
