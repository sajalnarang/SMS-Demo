package com.example.sajalnarang.smsdemo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sajalnarang on 21/1/17.
 */

public interface RetrofitInterface {
    @GET("/~hostel5/api/app/mess.php")
    Call<GsonModels.MenuResponse> getMenu();

    @GET("/~hostel5/api/app/phoneDB.php")
    Call<GsonModels.PhoneResponse> getNumbers();
}
