package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.nestedScroll.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIContinuousNestedTopRecyclerView extends RecyclerView implements c {

    /* renamed from: a, reason: collision with root package name */
    private b.a f١٢٨١٧a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f١٢٨١٨b;

    public QMUIContinuousNestedTopRecyclerView(Context context) {
        this(context, null);
        init();
    }

    private void init() {
        setVerticalScrollBarEnabled(false);
    }

    @Override // com.qmuiteam.qmui.nestedScroll.c
    public int a(int i10) {
        if (i10 == Integer.MIN_VALUE) {
            scrollToPosition(0);
            return Integer.MIN_VALUE;
        }
        boolean z10 = true;
        if (i10 == Integer.MAX_VALUE) {
            RecyclerView.Adapter adapter = getAdapter();
            if (adapter != null) {
                scrollToPosition(adapter.getItemCount() - 1);
            }
            return Integer.MAX_VALUE;
        }
        if (!hasNestedScrollingParent(0)) {
            startNestedScroll(2, 0);
            int[] iArr = this.f١٢٨١٨b;
            iArr[0] = 0;
            iArr[1] = 0;
            dispatchNestedPreScroll(0, i10, iArr, null, 0);
            i10 -= this.f١٢٨١٨b[1];
        } else {
            z10 = false;
        }
        scrollBy(0, i10);
        if (z10) {
            stopNestedScroll(0);
        }
        return 0;
    }

    @Override // com.qmuiteam.qmui.nestedScroll.b
    public void c(b.a aVar) {
        this.f١٢٨١٧a = aVar;
    }

    @Override // com.qmuiteam.qmui.nestedScroll.c
    public int getCurrentScroll() {
        return computeVerticalScrollOffset();
    }

    @Override // com.qmuiteam.qmui.nestedScroll.c
    public int getScrollOffsetRange() {
        return Math.max(0, computeVerticalScrollRange() - getHeight());
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrolled(int i10, int i11) {
        super.onScrolled(i10, i11);
        b.a aVar = this.f١٢٨١٧a;
        if (aVar != null) {
            aVar.a(getCurrentScroll(), getScrollOffsetRange());
        }
    }

    public QMUIContinuousNestedTopRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init();
    }

    public QMUIContinuousNestedTopRecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٢٨١٨b = new int[2];
        init();
    }
}
