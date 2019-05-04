package com.work.rxworld.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {

    private static Retrofit mInstance;


    public static Retrofit getInstance(){

        if (mInstance == null){
            mInstance = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                   .build();
        }

        return mInstance;
    }

    private NetworkClient(){}
}
