package com.worldline.comm.webservice;


import com.worldline.comm.Utils.Constant;
import com.worldline.comm.webservice.apis.Login;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    private Api() {

    }

    private static Retrofit getRetrofit() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.Url.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    public static Login userManagement() {
        return getRetrofit().create(Login.class);
    }

}
