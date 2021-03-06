package com.example.demo.myapplication;

import android.widget.Toast;

import com.example.demo.myapplication.Components.Interface.DBCommunicator;
import com.example.demo.myapplication.Components.Interface.UserService;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by demo on 11/5/2016.
 */

public class MainController
{
    private DBCommunicator dbc;

    public MainController(DBCommunicator db_communicator){
        dbc = db_communicator;
    }

    public void login(String username, String password)
    {
        dbc.onResultReceived("");
    }

    public void register(String username, String password)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://202.125.249.223/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserService userService = retrofit.create(UserService.class);
        userService.register(username,password).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                JsonObject jsonObject = response.body();
                String result = jsonObject.toString();
                dbc.onResultReceived(result);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                String message = t.toString();
                dbc.onErrorReceived(message);
            }
        });
    }

    public void getCourseList()
    {
        dbc.onResultReceived("");

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://158.182.6.135/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        UserService userService = retrofit.create(UserService.class);
//        userService.getCourseList().enqueue(new Callback<JsonObject>()
//        {
//            @Override
//            public void onResponse(Call<JsonObject> call, Response<JsonObject> response)
//            {
//                JsonObject jsonObject = response.body();
//                String result = jsonObject.toString();
//                dbc.onResultReceived(result);
//            }
//
//            @Override
//            public void onFailure(Call<JsonObject> call, Throwable t)
//            {
//                String message = t.toString();
//                dbc.onErrorReceived(message);
//            }
//        });
    }
}
