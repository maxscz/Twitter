package com.example.cesarsantacruz.tw.Interface;

import android.support.v7.widget.RecyclerView;

public interface RefreshItemTouchHelperListener {
    void onSwipe (RecyclerView.ViewHolder viewHolder, int intDirection, int intPosition);

    void onItemMove(int intFromPosition, int intToPosition);
}
