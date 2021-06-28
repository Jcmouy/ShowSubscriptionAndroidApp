package com.example.appgfprod.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.appgfprod.Data.remote.RemoteUtils;
import com.example.appgfprod.helper.PrefManager;
import com.example.appgfprod.view.activity.MainActivity;
import com.example.appgfprod.io.SmsServiceIO;
import com.google.gson.JsonObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HttpService extends IntentService {

    private static String TAG = HttpService.class.getSimpleName();
    private SmsServiceIO mSmsServiceIO;

    public HttpService() {
        super(HttpService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        mSmsServiceIO = RemoteUtils.getSmsService();

        if (intent != null) {
            String otp = intent.getStringExtra("otp");
            verifyOtp(otp);
        }
    }

    /**
     * Posting the OTP to server and activating the user
     *
     * @param otp otp received in the SMS
     */
    private void verifyOtp(final String otp) {

        mSmsServiceIO.verify_opt(otp).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                if(response.isSuccessful()) {
                    Log.d("HttpService", "verifyOtp Successful");

                    JsonObject json = new JsonObject();
                    json = response.body();

                    String id = json.get("Id").getAsString();
                    String username = json.get("Username").getAsString();
                    String name = json.get("Nombre").getAsString();
                    String email = json.get("Email").getAsString();
                    String mobile = json.get("Mobile").getAsString();

                    Log.d("HttpService", "values"+ username + name + email + mobile);

                    PrefManager pref = new PrefManager(getApplicationContext());
                    pref.createLogin(id, name, username, email, mobile);

                    Intent intent = new Intent(HttpService.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                    Toast.makeText(getApplicationContext(), "OPT Verify", Toast.LENGTH_LONG).show();


                }else if(response.errorBody() != null){
                    try {
                        String errorBody = response.errorBody().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    int statusCode  = response.code();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
}
