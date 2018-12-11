package com.blackcat.example.ui.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by blackcat on 2018/12/11.17.38
 */
public interface MyInterface {
    @GET(".../...")
    Call<List<MyResponse>> getCall();
}
