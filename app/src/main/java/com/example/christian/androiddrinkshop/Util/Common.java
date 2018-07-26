package com.example.christian.androiddrinkshop.Util;

import com.example.christian.androiddrinkshop.Database.DataSource.CartRepository;
import com.example.christian.androiddrinkshop.Database.Local.CartDatabase;
import com.example.christian.androiddrinkshop.Model.Category;
import com.example.christian.androiddrinkshop.Model.Drink;
import com.example.christian.androiddrinkshop.Model.User;
import com.example.christian.androiddrinkshop.Retrofit.IDrinkShopAPI;
import com.example.christian.androiddrinkshop.Retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

public class Common {

    // In Emulator , localhost = 10.0.2.2
    public static final String BASE_URL = "http://10.0.2.2/drinkshop/";

    public static final String TOPPING_MENU_ID = "7";

    public static User currentUser = null;
    public static Category currentCategory = null;
    public static List<Drink> toppingList = new ArrayList<>();

    public static double toppingPrice = 0.0;
    public static List<String> toppingAdd = new ArrayList<>();

    // Hld Field
    public static int sizeOfCup = -1; // -1 no chose (error), 0 : M,  : L
    public static int sugar = 1; //  -1 : no choose (error)
    public static int ice = -1;

    // Database
    public static CartDatabase cartDatabase;
    public static CartRepository cartRepository;

    public static IDrinkShopAPI getAPI()
    {
        return RetrofitClient.getClient(BASE_URL).create(IDrinkShopAPI.class);
    }
}
