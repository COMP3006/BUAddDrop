package com.example.demo.myapplication.Components.Interface;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by demo on 11/5/2016.
 */

public interface UserService {
    @FormUrlEncoded
    @POST("me/")
    Call<JsonObject> register(
            @Field("username") String username,
            @Field("userpassword") String userpassword);
}
