package com.example.christian.androiddrinkshop.Database.DataSource;

import com.example.christian.androiddrinkshop.Database.ModelDB.Favorite;

import java.util.List;

import io.reactivex.Flowable;

public interface IFavoriteDataSource {

    Flowable<List<Favorite>> getFavItem();
    int isFavorite(int itemId);
    void insertFav(Favorite...favorites);
    void  delete (Favorite favorite);
}
