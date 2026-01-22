package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.nestedScroll.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIContinuousNestedBottomRecyclerView extends RecyclerView implements com.qmuiteam.qmui.nestedScroll.a {

    /* renamed from: a, reason: collision with root package name */
    private b.a f١٢٧٧٧a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f١٢٧٧٨b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            if (QMUIContinuousNestedBottomRecyclerView.this.f١٢٧٧٧a != null) {
                if (i10 == 0) {
                    QMUIContinuousNestedBottomRecyclerView.this.f١٢٧٧٧a.b(recyclerView, 0);
                } else if (i10 == 2) {
                    QMUIContinuousNestedBottomRecyclerView.this.f١٢٧٧٧a.b(recyclerView, 2);
                } else if (i10 == 1) {
                    QMUIContinuousNestedBottomRecyclerView.this.f١٢٧٧٧a.b(recyclerView, 1);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            if (QMUIContinuousNestedBottomRecyclerView.this.f١٢٧٧٧a != null) {
                QMUIContinuousNestedBottomRecyclerView.this.f١٢٧٧٧a.a(recyclerView.computeVerticalScrollOffset(), Math.max(0, recyclerView.computeVerticalScrollRange() - recyclerView.getHeight()));
            }
        }
    }

    public QMUIContinuousNestedBottomRecyclerView(Context context) {
        super(context);
        this.f١٢٧٧٨b = new int[2];
        init();
    }

    private void init() {
        setVerticalScrollBarEnabled(false);
        addOnScrollListener(new a());
    }

    @Override // com.qmuiteam.qmui.nestedScroll.a
    public void a(int i10) {
        if (i10 == Integer.MIN_VALUE) {
            scrollToPosition(0);
            return;
        }
        boolean z10 = true;
        if (i10 == Integer.MAX_VALUE) {
            RecyclerView.Adapter adapter = getAdapter();
            if (adapter != null) {
                scrollToPosition(adapter.getItemCount() - 1);
                return;
            }
            return;
        }
        if (!hasNestedScrollingParent(0)) {
            startNestedScroll(2, 0);
            int[] iArr = this.f١٢٧٧٨b;
            iArr[0] = 0;
            iArr[1] = 0;
            dispatchNestedPreScroll(0, i10, iArr, null, 0);
            i10 -= this.f١٢٧٧٨b[1];
        } else {
            z10 = false;
        }
        scrollBy(0, i10);
        if (z10) {
            stopNestedScroll(0);
        }
    }

    @Override // com.qmuiteam.qmui.nestedScroll.a
    public int getContentHeight() {
        if (getAdapter() == null || getLayoutManager() == null) {
            return 0;
        }
        int computeVerticalScrollRange = computeVerticalScrollRange();
        if (computeVerticalScrollRange > getHeight()) {
            return -1;
        }
        return computeVerticalScrollRange;
    }

    @Override // com.qmuiteam.qmui.nestedScroll.a
    public int getCurrentScroll() {
        return computeVerticalScrollOffset();
    }

    @Override // com.qmuiteam.qmui.nestedScroll.a
    public int getScrollOffsetRange() {
        return Math.max(0, computeVerticalScrollRange() - getHeight());
    }

    public QMUIContinuousNestedBottomRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٢٧٧٨b = new int[2];
        init();
    }

    public QMUIContinuousNestedBottomRecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٢٧٧٨b = new int[2];
        init();
    }
}
