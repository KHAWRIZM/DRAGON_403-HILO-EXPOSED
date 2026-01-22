package com.qiahao.nextvideo.ui.foodie;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class t1 extends RecyclerView.ItemDecoration {
    private int a;
    private int b;
    private boolean c;

    public t1(int i, int i2, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = z;
    }

    private int a(RecyclerView recyclerView) {
        GridLayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return layoutManager.getSpanCount();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        }
        return -1;
    }

    private int b(View view, RecyclerView recyclerView) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            return view.getLayoutParams().getSpanIndex();
        }
        return childAdapterPosition;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int a = a(recyclerView);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int b = b(view, recyclerView) % a;
        if (this.c) {
            int i = this.b;
            rect.left = i - ((b * i) / a);
            rect.right = ((b + 1) * i) / a;
            if (childAdapterPosition < a) {
                rect.top = this.a;
            }
            rect.bottom = this.a;
            return;
        }
        int i2 = this.b;
        rect.left = (b * i2) / a;
        rect.right = i2 - (((b + 1) * i2) / a);
        if (childAdapterPosition >= a) {
            rect.top = this.a;
        }
    }
}
