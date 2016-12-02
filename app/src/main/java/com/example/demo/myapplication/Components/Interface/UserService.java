package com.example.demo.myapplication.Components.Interface;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * ----------------------------- NEED TO FILL login() and getCourseList() !!!!! -----------------------------
 * ----------------------------- NEED TO FILL login() and getCourseList() !!!!! -----------------------------
 * ----------------------------- NEED TO FILL login() and getCourseList() !!!!! -----------------------------
 */

public interface UserService
{
    Call<JsonObject> login();

    @FormUrlEncoded
    @POST("me/")
    Call<JsonObject> register(
            @Field("username") String username,
            @Field("userpassword") String userpassword);


    Call<JsonObject> getCourseList();

}
