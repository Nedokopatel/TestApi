package com.example.testapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Post {


    @SerializedName("result")
    @Expose
    private String result;


    public String getResult() {
        return result;
    }
    public void setResult(String result){this.result = result;}

}

