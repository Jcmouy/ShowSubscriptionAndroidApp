package com.example.appgfprod.io;

import com.example.appgfprod.dto.PersonaDto;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PersonaServiceIO {

    @POST("api/users")
    Call<JsonObject> createPersona(@Body PersonaDto personaDTO);


}
