package com.example.testapi;

public class User {
    private String password;
    private String token;
    private String message;
    private String code;
    private String session_id;

    public User(String password){
        this.password = password;
        this.session_id = session_id;
    }
    /*public User(String session_id){
        this.session_id = session_id;
    }*/
    public String getPassword(){
        return password;
    }
    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }


}
