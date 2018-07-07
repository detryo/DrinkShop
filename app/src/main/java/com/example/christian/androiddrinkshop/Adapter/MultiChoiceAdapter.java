package com.example.christian.androiddrinkshop.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import com.example.christian.androiddrinkshop.Model.Drink;
import com.example.christian.androiddrinkshop.R;
import com.example.christian.androiddrinkshop.Util.Common;

import java.util.List;

public class MultiChoiceAdapter extends RecyclerView.Adapter<MultiChoiceAdapter.MultiChoiseViewHolder> {

    Context context;
    List<Drink> optionList;

    // Constructor
    public MultiChoiceAdapter(Context context, List<Drink> optionList) {
        this.context = context;
        this.optionList = optionList;
    }

    @NonNull
    @Override
    public MultiChoiseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.multi_check_layout, null);
        return new MultiChoiseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MultiChoiseViewHolder holder, final int position) {
        holder.checkBox.setText(optionList.get(position).Name);
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    Common.toppingAdd.add(buttonView.getText().toString());
                    Common.toppingPrice+=Double.parseDouble(optionList.get(position).Price);
                }
                else
                {
                    Common.toppingAdd.remove(buttonView.getText().toString());
                    Common.toppingPrice-=Double.parseDouble(optionList.get(position).Price);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return optionList.size();
    }

    class MultiChoiseViewHolder extends RecyclerView.ViewHolder{

        CheckBox checkBox;

        public MultiChoiseViewHolder(View itemView) {
            super(itemView);

            checkBox = (CheckBox) itemView.findViewById(R.id.ckb_topping);
        }
    }
}
