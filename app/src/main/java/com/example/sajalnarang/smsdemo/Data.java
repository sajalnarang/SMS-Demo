package com.example.sajalnarang.smsdemo;

/**
 * Created by sajalnarang on 21/1/17.
 */

public class Data {
    private static GsonModels.MenuResponse menuResponse;

    public Data(GsonModels.MenuResponse menuResponse) {
        this.menuResponse = menuResponse;
    }

    public static GsonModels.MenuResponse getMenuResponse() {
        return menuResponse;
    }

    public static void setMenuResponse(GsonModels.MenuResponse menuResponse) {
        Data.menuResponse = menuResponse;
    }
}
