package com.example.login_apitask2.API;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("member-login.php")
    Call<String> Login(@Field("mobile") String mobile, @Field("password") String pass );




}
