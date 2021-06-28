package com.example.appgfprod.Data.remote;

import com.example.appgfprod.BuildConfig;
import com.example.appgfprod.io.PersonaServiceIO;
import com.example.appgfprod.io.RetrofitClient;
import com.example.appgfprod.io.SmsServiceIO;
import com.example.appgfprod.io.UsuarioServiceIO;

public class RemoteUtils {

    private RemoteUtils(){}

    public static SmsServiceIO getSmsService(){
        return RetrofitClient.getClient(BuildConfig.BASE_URL).create(SmsServiceIO.class);
    }

    public static PersonaServiceIO getPersonaServiceIo(){
        return RetrofitClient.getClient(BuildConfig.BASE_URL).create(PersonaServiceIO.class);
    }

    public static UsuarioServiceIO getUsuarioServiceIo(){
        return RetrofitClient.getClient(BuildConfig.BASE_URL).create(UsuarioServiceIO.class);
    }

}
