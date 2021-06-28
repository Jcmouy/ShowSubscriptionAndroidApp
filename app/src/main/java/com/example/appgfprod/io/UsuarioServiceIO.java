package com.example.appgfprod.io;

import com.example.appgfprod.dto.Io.UsuarioServiceDto;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsuarioServiceIO {

    @POST("api/users")
    Call<JsonObject> createUser(@Body UsuarioServiceDto userDTO);

    @POST("api/authenticate")
    Call<JsonObject> authenticateUser(@Body LoginData loginVM);


}
