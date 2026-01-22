package com.chad.library.adapter.base.listener;

import android.graphics.Canvas;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface OnItemSwipeListener {
    void clearView(RecyclerView.ViewHolder viewHolder, int i10);

    void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float f10, float f11, boolean z10);

    void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int i10);

    void onItemSwiped(RecyclerView.ViewHolder viewHolder, int i10);
}
