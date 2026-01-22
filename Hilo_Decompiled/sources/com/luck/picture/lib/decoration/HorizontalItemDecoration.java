package com.luck.picture.lib.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class HorizontalItemDecoration extends RecyclerView.ItemDecoration {
    private final int spacing;
    private final int spanCount;

    public HorizontalItemDecoration(int i10, int i11) {
        this.spanCount = i10;
        this.spacing = i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i10 = this.spanCount;
        int i11 = childAdapterPosition % i10;
        if (childAdapterPosition == 0) {
            int i12 = this.spacing;
            rect.left = i12 - ((i11 * i12) / i10);
        } else {
            rect.left = (this.spacing * i11) / i10;
        }
        int i13 = this.spacing;
        rect.right = i13 - (((i11 + 1) * i13) / i10);
        if (childAdapterPosition < i10) {
            rect.top = i13;
        }
        rect.bottom = i13;
    }
}
