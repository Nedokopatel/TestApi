package com.example.testapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.security.auth.login.LoginException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView.setText("проверка");
        Encoder enc = new Encoder();

        String password_waiter = "/";
        String session_id = "052d5f75-c230-47cc-a09a-1aea2eebb54a";
        try {
            password_waiter = Encoder.Encryption("8713");
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(password_waiter);
        User body = new User(password_waiter);

        /*ApiService.getInstance()
                .getJSONApi()
                .signAnswer1(password_waiter)
                .enqueue(new Callback <User>() {
                    @Override
                    public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {

                        User responseUser = response.body();
                        if (response.isSuccessful() && responseUser != null) {
                            textView.append(responseUser.getMessage());
                        } else {
                            textView.append("Error"+ String.valueOf(response.message())+String.valueOf(response.code()));
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call <User> call, @NonNull Throwable t) {

                        textView.append("Error occurred while getting request!"+t);
                        t.printStackTrace();
                    }
                });*/
        /*ApiService.getInstance()
                .getJSONApi()
                .getResult()
                .enqueue(new Callback <Post>() {
                    @Override
                    public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {

                        Post post = response.body();
                        textView.setText(post.getResult());

                    }

                    @Override
                    public void onFailure(@NonNull Call <Post> call, @NonNull Throwable t) {

                        textView.append("Error occurred while getting request!"+t);
                        t.printStackTrace();
                    }
                });*/

        User user = new User(password_waiter);
        MainApplication.apiManager.loginUser(user, new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                User responseUser = response.body();
                if (response.isSuccessful() && responseUser != null) {
                        textView.setText(response.body().getToken());
                } else {
                    textView.setText("Error is:"+response.code());

                }
            }

            @Override
            public void onFailure(@NonNull Call<User> call, Throwable t) {
                textView.setText("Error is:"+t);
            }
        });



    }
}