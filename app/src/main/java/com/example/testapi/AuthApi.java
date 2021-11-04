package com.example.testapi;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface AuthApi {

    @POST("sign_in")
    Call<User> signAnswer(@Body User user );

    @POST("sign_in")
    Call<User> signAnswer1(@Query("password") String password);

    @GET("ping")
    Call<Post> getResult();
    }

