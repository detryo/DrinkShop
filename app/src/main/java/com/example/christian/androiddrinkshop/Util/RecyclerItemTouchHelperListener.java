package com.example.christian.androiddrinkshop.Util;

import android.support.v7.widget.RecyclerView;

public interface RecyclerItemTouchHelperListener {

    void onSwiped(RecyclerView.ViewHolder viewHolder, int detection, int position);
}
