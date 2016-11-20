package com.example.demo.myapplication;

import com.example.demo.myapplication.Components.Interface.UserService;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by demo on 11/5/2016.
 */

public class MainController {

    private MainActivity mMainActivity;

    public MainController(MainActivity mainActivity){
        mMainActivity = mainActivity;
    }
    public void login(String username, String password, String password2){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://158.182.6.135/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserService userService = retrofit.create(UserService.class);
        userService.register(username,password).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                JsonObject jsonObject = response.body();
                String result = jsonObject.toString();
                mMainActivity.onResultReceived(result);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                String message = t.toString();
                mMainActivity.onErrorReceived(message);
            }
        });
    }
}
