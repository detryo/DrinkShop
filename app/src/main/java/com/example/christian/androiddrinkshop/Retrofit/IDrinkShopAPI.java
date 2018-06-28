package com.example.christian.androiddrinkshop.Retrofit;

import com.example.christian.androiddrinkshop.Model.Banner;
import com.example.christian.androiddrinkshop.Model.Category;
import com.example.christian.androiddrinkshop.Model.CheckUserResponse;
import com.example.christian.androiddrinkshop.Model.User;

import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IDrinkShopAPI {

    @FormUrlEncoded
    @POST("checkuser.php")
    Call<CheckUserResponse> checkUserExist(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("register.php")
    Call<User> registerNameUser(@Field("phone") String phone,
                                @Field("name") String name,
                                @Field("address") String address,
                                @Field("birthdate") String birthdate);

    @FormUrlEncoded
    @POST("getuser.php")
    Call<User> getUserInformation(@Field("phone") String phone);

    @GET("getbanner.php")
    io.reactivex.Observable<List<Banner>> getBanners();

    @GET("getmenu.php")
    io.reactivex.Observable<List<Category>> getMenu();
}
