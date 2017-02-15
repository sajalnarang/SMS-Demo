package com.example.sajalnarang.smsdemo;

/**
 * Created by sajalnarang on 21/1/17.
 */

public class Data {
    private static GsonModels.MenuResponse menuResponse;
    private static GsonModels.PhoneResponse phoneResponse;

    public Data() {
    }

    public static GsonModels.MenuResponse getMenuResponse() {
        return menuResponse;
    }

    public static void setMenuResponse(GsonModels.MenuResponse menuResponse) {
        Data.menuResponse = menuResponse;
    }

    public static GsonModels.PhoneResponse getPhoneResponse() {
        return phoneResponse;
    }

    public static void setPhoneResponse(GsonModels.PhoneResponse phoneResponse) {
        Data.phoneResponse = phoneResponse;
    }
}
