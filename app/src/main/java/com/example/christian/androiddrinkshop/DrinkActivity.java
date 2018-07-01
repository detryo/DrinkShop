package com.example.christian.androiddrinkshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.christian.androiddrinkshop.Adapter.DrinkAdapter;
import com.example.christian.androiddrinkshop.Model.Drink;
import com.example.christian.androiddrinkshop.Retrofit.IDrinkShopAPI;
import com.example.christian.androiddrinkshop.Util.Common;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DrinkActivity extends AppCompatActivity {

    IDrinkShopAPI mService;

    RecyclerView lst_drink;
    TextView txt_banner_name;

    // Rxjava
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        mService = Common.getAPI();

        lst_drink = (RecyclerView) findViewById(R.id.recycler_drink);
        lst_drink.setLayoutManager(new GridLayoutManager(this, 2));
        lst_drink.setHasFixedSize(true);

        txt_banner_name = (TextView) findViewById(R.id.txt_menu_name);
        txt_banner_name.setText(Common.currentCategory.Name);

        loadDrinkList(Common.currentCategory.ID);
    }

    private void loadDrinkList(String menuId) {

        compositeDisposable.add(mService.getDrinik(menuId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Drink>>() {
                    @Override
                    public void accept(List<Drink> drinks) throws Exception {

                        displayDrinkList(drinks);
                    }
                }));
    }

    private void displayDrinkList(List<Drink> drinks) {

        DrinkAdapter adapter = new DrinkAdapter(this, drinks);
        lst_drink.setAdapter(adapter);
    }
}
