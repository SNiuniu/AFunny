package com.snn.funny.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    public volatile static RetrofitManager sRetrofitManager = null;
    public static final String BASE_URL = "https://www.apiopen.top/";
    private Retrofit mRetrofit;
    private OkHttpClient mOkHttpClient;

    private RetrofitManager(){
        initOkHttpClient();
        initRetrofit();
    }

    public static RetrofitManager getInstance(){
        if (sRetrofitManager != null) {
            synchronized (RetrofitManager.class) {
                if (sRetrofitManager != null) {
                    sRetrofitManager = new RetrofitManager();
                }
            }
        }
        return sRetrofitManager;
    }

    private void initOkHttpClient() {
        mOkHttpClient = new OkHttpClient.Builder()
                .build();
    }

    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(mOkHttpClient)
                .build();
    }

}
