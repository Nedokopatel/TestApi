package com.example.testapi;

import android.app.Application;

public class MainApplication extends Application {

    public static ApiService apiManager;

    @Override
    public void onCreate() {
        super.onCreate();
        apiManager = ApiService.getInstance();
    }
}
