package com.example.testapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiService {
    private static ApiService mInstance;
    private static AuthApi service;
    static final String BASE_URL = "http://i.vedacom.ru:20080/nordcity_front_office_test_8/hs/rest.waiter/";
    private static Retrofit mRetrofit;
    private String username = "waiter";
    private String password = "waiter";

    private ApiService(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(new HttpInterceptor(username,password)).addInterceptor(interceptor);

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
        service = mRetrofit.create(AuthApi.class);
    }

    public static ApiService getInstance(){
        if(mInstance == null){
            mInstance = new ApiService();
        }
        return mInstance;
    }
    public AuthApi getJSONApi() {
        return mRetrofit.create(AuthApi.class);
    }

    public void loginUser(User user, Callback<User> callback) {
        Call<User> userCall = service.signAnswer(user);
        userCall.enqueue(callback);
    }
}
