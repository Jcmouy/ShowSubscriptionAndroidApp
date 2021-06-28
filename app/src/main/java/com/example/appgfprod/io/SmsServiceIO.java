package com.example.appgfprod.io;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SmsServiceIO {
    /*@Headers("Content-Type: application/json")*/
    @FormUrlEncoded
    @POST("students/send_sms")
    Call<JsonObject> sent_sms(@Field("Username") String userName,
                              @Field("Nombre") String name,
                              @Field("Email") String email,
                              @Field("Mobile") String mobile);

    @FormUrlEncoded
    @POST("students/verify_otp")
    Call<JsonObject> verify_opt(@Field("Otp") String otp);


}
