package com.example.christian.androiddrinkshop.Database.Local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.christian.androiddrinkshop.Database.ModelDB.Cart;
import com.example.christian.androiddrinkshop.Database.ModelDB.Favorite;

@Database(entities = {Cart.class, Favorite.class}, version = 1)
public abstract class AppRoomDatabase extends RoomDatabase {

    public abstract CartDAO cartDAO();
    public abstract FavoriteDAO favoriteDAO();
    private static AppRoomDatabase instance;

    public static AppRoomDatabase getInstance(Context context)
    {
        if (instance == null)
            instance = Room.databaseBuilder(context, AppRoomDatabase.class, "DrinkShopDB")
                    .allowMainThreadQueries()
                    .build();
        return instance;
    }
}
