package com.example.cesarsantacruz.tw.Utils;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.cesarsantacruz.tw.Activities.MainActivity;
import com.example.cesarsantacruz.tw.Adapters.RecyclerViewAdapter;
import com.example.cesarsantacruz.tw.Interface.RefreshItemTouchHelperListener;

import static android.support.v7.widget.helper.ItemTouchHelper.Callback.getDefaultUIUtil;

public class RefreshItemTouchHelper extends ItemTouchHelper.SimpleCallback {

    private RefreshItemTouchHelperListener listener;

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public RefreshItemTouchHelper(int dragDirs, int swipeDirs, RefreshItemTouchHelperListener listener) {
        super(dragDirs, swipeDirs);
        this.listener = listener;
    }


    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        listener.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int intDirection) {
        if (listener != null) {
            listener.onSwipe(viewHolder, intDirection, viewHolder.getAdapterPosition());
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        View fgView = ((RecyclerViewAdapter.ViewHolder)viewHolder).parentLayout;
        getDefaultUIUtil().clearView(fgView);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public int convertToAbsoluteDirection(int flags, int layoutDirection) {
        return super.convertToAbsoluteDirection(flags, layoutDirection);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (viewHolder != null) {
            View fgView = ((RecyclerViewAdapter.ViewHolder)viewHolder).parentLayout;
            getDefaultUIUtil().onSelected(fgView);
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                            float dX, float dY, int actionState, boolean isCurrentlyActive)
    {
        View fgView = ((RecyclerViewAdapter.ViewHolder)viewHolder).parentLayout;
        getDefaultUIUtil().onDraw(c, recyclerView, fgView, dX, dY, actionState, isCurrentlyActive);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public void onChildDrawOver(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                float dX, float dY, int actionState, boolean isCurrentlyActive)
    {
        View fgView = ((RecyclerViewAdapter.ViewHolder)viewHolder).parentLayout;
        getDefaultUIUtil().onDrawOver(c, recyclerView, fgView, dX, dY, actionState, isCurrentlyActive);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int intDragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int intSwipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(intDragFlags, intSwipeFlags);
    }

}

