package com.example.christian.androiddrinkshop.Util;

import com.example.christian.androiddrinkshop.Model.User;
import com.example.christian.androiddrinkshop.Retrofit.IDrinkShopAPI;
import com.example.christian.androiddrinkshop.Retrofit.RetrofitClient;

public class Common {

    // In Emulator , localhost = 10.0.2.2
    private static final String BASE_URL = "http://10.0.2.2/drinkshop/";

    public static User currentUser = null;

    public static IDrinkShopAPI getAPI()
    {
        return RetrofitClient.getClient(BASE_URL).create(IDrinkShopAPI.class);
    }
}
