package com.example.christian.androiddrinkshop.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.christian.androiddrinkshop.Interface.IItemClickListener;
import com.example.christian.androiddrinkshop.R;

public class DrinkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView img_product;
    TextView txt_drink_name, txt_price;

    IItemClickListener iItemClickListener;

    public void setiItemClickListener(IItemClickListener iItemClickListener) {
        this.iItemClickListener = iItemClickListener;
    }

    public DrinkViewHolder(View itemView) {
        super(itemView);

        img_product = (ImageView)itemView.findViewById(R.id.image_product);
        txt_drink_name = (TextView) itemView.findViewById(R.id.txt_drink_name);
        txt_price = (TextView) itemView.findViewById(R.id.txt_price);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        iItemClickListener.onClick(v);

    }
}
