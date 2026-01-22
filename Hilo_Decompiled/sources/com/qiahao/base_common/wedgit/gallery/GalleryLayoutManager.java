package com.qiahao.base_common.wedgit.gallery;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class GalleryLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {

    /* renamed from: a, reason: collision with root package name */
    private int f١٢٦٣٥a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٢٦٣٦b;

    /* renamed from: c, reason: collision with root package name */
    private int f١٢٦٣٧c;

    /* renamed from: d, reason: collision with root package name */
    int f١٢٦٣٨d;

    /* renamed from: e, reason: collision with root package name */
    View f١٢٦٣٩e;

    /* renamed from: f, reason: collision with root package name */
    private d f١٢٦٤٠f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٢٦٤١g;

    /* renamed from: h, reason: collision with root package name */
    private OrientationHelper f١٢٦٤٢h;

    /* renamed from: i, reason: collision with root package name */
    private OrientationHelper f١٢٦٤٣i;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private class a extends LinearSmoothScroller {
        public a(Context context) {
            super(context);
        }

        public int a(View view) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager != null && layoutManager.canScrollHorizontally()) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                int decoratedLeft = layoutManager.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                int decoratedRight = layoutManager.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                return ((int) (((layoutManager.getWidth() - layoutManager.getPaddingRight()) - layoutManager.getPaddingLeft()) / 2.0f)) - (decoratedLeft + ((int) ((decoratedRight - decoratedLeft) / 2.0f)));
            }
            return 0;
        }

        public int b(View view) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager != null && layoutManager.canScrollVertically()) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                int decoratedTop = layoutManager.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                int decoratedBottom = layoutManager.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                return ((int) (((layoutManager.getHeight() - layoutManager.getPaddingBottom()) - layoutManager.getPaddingTop()) / 2.0f)) - (decoratedTop + ((int) ((decoratedBottom - decoratedTop) / 2.0f)));
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            int a10 = a(view);
            int b10 = b(view);
            int calculateTimeForDeceleration = calculateTimeForDeceleration((int) Math.sqrt((a10 * a10) + (b10 * b10)));
            if (calculateTimeForDeceleration > 0) {
                action.update(-a10, -b10, calculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class b extends RecyclerView.LayoutParams {
        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(int i10, int i11) {
            super(i10, i11);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface c {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        SparseArray f١٢٦٤٥a = new SparseArray();

        /* renamed from: b, reason: collision with root package name */
        int f١٢٦٤٦b = 0;

        public d() {
        }
    }

    private int calculateScrollDirectionForPosition(int i10) {
        if (getChildCount() == 0 || i10 < this.f١٢٦٣٥a) {
            return -1;
        }
        return 1;
    }

    private void e(RecyclerView.Recycler recycler, int i10, int i11, int i12) {
        Rect rect = new Rect();
        int o10 = o();
        while (i10 < getItemCount() && i11 < i12) {
            View viewForPosition = recycler.getViewForPosition(i10);
            addView(viewForPosition);
            measureChildWithMargins(viewForPosition, 0, 0);
            int paddingLeft = (int) (getPaddingLeft() + ((o10 - r2) / 2.0f));
            rect.set(paddingLeft, i11, getDecoratedMeasuredWidth(viewForPosition) + paddingLeft, getDecoratedMeasuredHeight(viewForPosition) + i11);
            layoutDecorated(viewForPosition, rect.left, rect.top, rect.right, rect.bottom);
            i11 = rect.bottom;
            this.f١٢٦٣٦b = i10;
            if (q().f١٢٦٤٥a.get(i10) == null) {
                q().f١٢٦٤٥a.put(i10, rect);
            } else {
                ((Rect) q().f١٢٦٤٥a.get(i10)).set(rect);
            }
            i10++;
        }
    }

    private void f(RecyclerView.Recycler recycler, RecyclerView.State state, int i10) {
        if (getItemCount() == 0) {
            return;
        }
        if (this.f١٢٦٤١g == 0) {
            j(recycler, state, i10);
        } else {
            k(recycler, state, i10);
        }
    }

    private void g(RecyclerView.Recycler recycler, int i10, int i11, int i12) {
        Rect rect = new Rect();
        int r10 = r();
        while (i10 >= 0 && i11 > i12) {
            View viewForPosition = recycler.getViewForPosition(i10);
            addView(viewForPosition, 0);
            measureChildWithMargins(viewForPosition, 0, 0);
            int paddingTop = (int) (getPaddingTop() + ((r10 - r4) / 2.0f));
            rect.set(i11 - getDecoratedMeasuredWidth(viewForPosition), paddingTop, i11, getDecoratedMeasuredHeight(viewForPosition) + paddingTop);
            layoutDecorated(viewForPosition, rect.left, rect.top, rect.right, rect.bottom);
            i11 = rect.left;
            this.f١٢٦٣٥a = i10;
            if (q().f١٢٦٤٥a.get(i10) == null) {
                q().f١٢٦٤٥a.put(i10, rect);
            } else {
                ((Rect) q().f١٢٦٤٥a.get(i10)).set(rect);
            }
            i10--;
        }
    }

    private void h(RecyclerView.Recycler recycler, int i10, int i11, int i12) {
        Rect rect = new Rect();
        int r10 = r();
        while (i10 < getItemCount() && i11 < i12) {
            View viewForPosition = recycler.getViewForPosition(i10);
            addView(viewForPosition);
            measureChildWithMargins(viewForPosition, 0, 0);
            int paddingTop = (int) (getPaddingTop() + ((r10 - r3) / 2.0f));
            rect.set(i11, paddingTop, getDecoratedMeasuredWidth(viewForPosition) + i11, getDecoratedMeasuredHeight(viewForPosition) + paddingTop);
            layoutDecorated(viewForPosition, rect.left, rect.top, rect.right, rect.bottom);
            i11 = rect.right;
            this.f١٢٦٣٦b = i10;
            if (q().f١٢٦٤٥a.get(i10) == null) {
                q().f١٢٦٤٥a.put(i10, rect);
            } else {
                ((Rect) q().f١٢٦٤٥a.get(i10)).set(rect);
            }
            i10++;
        }
    }

    private void i(RecyclerView.Recycler recycler, int i10, int i11, int i12) {
        Rect rect = new Rect();
        int o10 = o();
        while (i10 >= 0 && i11 > i12) {
            View viewForPosition = recycler.getViewForPosition(i10);
            addView(viewForPosition, 0);
            measureChildWithMargins(viewForPosition, 0, 0);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
            int paddingLeft = (int) (getPaddingLeft() + ((o10 - decoratedMeasuredWidth) / 2.0f));
            rect.set(paddingLeft, i11 - getDecoratedMeasuredHeight(viewForPosition), decoratedMeasuredWidth + paddingLeft, i11);
            layoutDecorated(viewForPosition, rect.left, rect.top, rect.right, rect.bottom);
            i11 = rect.top;
            this.f١٢٦٣٥a = i10;
            if (q().f١٢٦٤٥a.get(i10) == null) {
                q().f١٢٦٤٥a.put(i10, rect);
            } else {
                ((Rect) q().f١٢٦٤٥a.get(i10)).set(rect);
            }
            i10--;
        }
    }

    private void j(RecyclerView.Recycler recycler, RecyclerView.State state, int i10) {
        int i11;
        int i12;
        int i13;
        int startAfterPadding = p().getStartAfterPadding();
        int endAfterPadding = p().getEndAfterPadding();
        if (getChildCount() > 0) {
            if (i10 >= 0) {
                int i14 = 0;
                for (int i15 = 0; i15 < getChildCount(); i15++) {
                    View childAt = getChildAt(i15 + i14);
                    if (getDecoratedRight(childAt) - i10 >= startAfterPadding) {
                        break;
                    }
                    removeAndRecycleView(childAt, recycler);
                    this.f١٢٦٣٥a++;
                    i14--;
                }
            } else {
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt2 = getChildAt(childCount);
                    if (getDecoratedLeft(childAt2) - i10 > endAfterPadding) {
                        removeAndRecycleView(childAt2, recycler);
                        this.f١٢٦٣٦b--;
                    }
                }
            }
        }
        int i16 = this.f١٢٦٣٥a;
        int r10 = r();
        int i17 = -1;
        if (i10 >= 0) {
            if (getChildCount() != 0) {
                View childAt3 = getChildAt(getChildCount() - 1);
                int position = getPosition(childAt3) + 1;
                i13 = getDecoratedRight(childAt3);
                i12 = position;
            } else {
                i12 = i16;
                i13 = -1;
            }
            for (int i18 = i12; i18 < getItemCount() && i13 < endAfterPadding + i10; i18++) {
                Rect rect = (Rect) q().f١٢٦٤٥a.get(i18);
                View viewForPosition = recycler.getViewForPosition(i18);
                addView(viewForPosition);
                if (rect == null) {
                    rect = new Rect();
                    q().f١٢٦٤٥a.put(i18, rect);
                }
                Rect rect2 = rect;
                measureChildWithMargins(viewForPosition, 0, 0);
                int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
                int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
                int paddingTop = (int) (getPaddingTop() + ((r10 - decoratedMeasuredHeight) / 2.0f));
                if (i13 == -1 && i12 == 0) {
                    int paddingLeft = (int) (getPaddingLeft() + ((o() - decoratedMeasuredWidth) / 2.0f));
                    rect2.set(paddingLeft, paddingTop, decoratedMeasuredWidth + paddingLeft, decoratedMeasuredHeight + paddingTop);
                } else {
                    rect2.set(i13, paddingTop, decoratedMeasuredWidth + i13, decoratedMeasuredHeight + paddingTop);
                }
                layoutDecorated(viewForPosition, rect2.left, rect2.top, rect2.right, rect2.bottom);
                i13 = rect2.right;
                this.f١٢٦٣٦b = i18;
            }
            return;
        }
        if (getChildCount() > 0) {
            View childAt4 = getChildAt(0);
            int position2 = getPosition(childAt4) - 1;
            i17 = getDecoratedLeft(childAt4);
            i11 = position2;
        } else {
            i11 = i16;
        }
        while (i11 >= 0 && i17 > startAfterPadding + i10) {
            Rect rect3 = (Rect) q().f١٢٦٤٥a.get(i11);
            View viewForPosition2 = recycler.getViewForPosition(i11);
            addView(viewForPosition2, 0);
            if (rect3 == null) {
                rect3 = new Rect();
                q().f١٢٦٤٥a.put(i11, rect3);
            }
            Rect rect4 = rect3;
            measureChildWithMargins(viewForPosition2, 0, 0);
            int paddingTop2 = (int) (getPaddingTop() + ((r10 - r2) / 2.0f));
            rect4.set(i17 - getDecoratedMeasuredWidth(viewForPosition2), paddingTop2, i17, getDecoratedMeasuredHeight(viewForPosition2) + paddingTop2);
            layoutDecorated(viewForPosition2, rect4.left, rect4.top, rect4.right, rect4.bottom);
            i17 = rect4.left;
            this.f١٢٦٣٥a = i11;
            i11--;
        }
    }

    private void k(RecyclerView.Recycler recycler, RecyclerView.State state, int i10) {
        int i11;
        int i12;
        int i13;
        int startAfterPadding = p().getStartAfterPadding();
        int endAfterPadding = p().getEndAfterPadding();
        if (getChildCount() > 0) {
            if (i10 >= 0) {
                int i14 = 0;
                for (int i15 = 0; i15 < getChildCount(); i15++) {
                    View childAt = getChildAt(i15 + i14);
                    if (getDecoratedBottom(childAt) - i10 >= startAfterPadding) {
                        break;
                    }
                    removeAndRecycleView(childAt, recycler);
                    this.f١٢٦٣٥a++;
                    i14--;
                }
            } else {
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt2 = getChildAt(childCount);
                    if (getDecoratedTop(childAt2) - i10 <= endAfterPadding) {
                        break;
                    }
                    removeAndRecycleView(childAt2, recycler);
                    this.f١٢٦٣٦b--;
                }
            }
        }
        int i16 = this.f١٢٦٣٥a;
        int o10 = o();
        int i17 = -1;
        if (i10 >= 0) {
            if (getChildCount() != 0) {
                View childAt3 = getChildAt(getChildCount() - 1);
                int position = getPosition(childAt3) + 1;
                i13 = getDecoratedBottom(childAt3);
                i12 = position;
            } else {
                i12 = i16;
                i13 = -1;
            }
            for (int i18 = i12; i18 < getItemCount() && i13 < endAfterPadding + i10; i18++) {
                Rect rect = (Rect) q().f١٢٦٤٥a.get(i18);
                View viewForPosition = recycler.getViewForPosition(i18);
                addView(viewForPosition);
                if (rect == null) {
                    rect = new Rect();
                    q().f١٢٦٤٥a.put(i18, rect);
                }
                Rect rect2 = rect;
                measureChildWithMargins(viewForPosition, 0, 0);
                int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
                int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
                int paddingLeft = (int) (getPaddingLeft() + ((o10 - decoratedMeasuredWidth) / 2.0f));
                if (i13 == -1 && i12 == 0) {
                    int paddingTop = (int) (getPaddingTop() + ((r() - decoratedMeasuredHeight) / 2.0f));
                    rect2.set(paddingLeft, paddingTop, decoratedMeasuredWidth + paddingLeft, decoratedMeasuredHeight + paddingTop);
                } else {
                    rect2.set(paddingLeft, i13, decoratedMeasuredWidth + paddingLeft, decoratedMeasuredHeight + i13);
                }
                layoutDecorated(viewForPosition, rect2.left, rect2.top, rect2.right, rect2.bottom);
                i13 = rect2.bottom;
                this.f١٢٦٣٦b = i18;
            }
            return;
        }
        if (getChildCount() > 0) {
            View childAt4 = getChildAt(0);
            int position2 = getPosition(childAt4) - 1;
            i17 = getDecoratedTop(childAt4);
            i11 = position2;
        } else {
            i11 = i16;
        }
        while (i11 >= 0 && i17 > startAfterPadding + i10) {
            Rect rect3 = (Rect) q().f١٢٦٤٥a.get(i11);
            View viewForPosition2 = recycler.getViewForPosition(i11);
            addView(viewForPosition2, 0);
            if (rect3 == null) {
                rect3 = new Rect();
                q().f١٢٦٤٥a.put(i11, rect3);
            }
            Rect rect4 = rect3;
            measureChildWithMargins(viewForPosition2, 0, 0);
            int decoratedMeasuredWidth2 = getDecoratedMeasuredWidth(viewForPosition2);
            int paddingLeft2 = (int) (getPaddingLeft() + ((o10 - decoratedMeasuredWidth2) / 2.0f));
            rect4.set(paddingLeft2, i17 - getDecoratedMeasuredHeight(viewForPosition2), decoratedMeasuredWidth2 + paddingLeft2, i17);
            layoutDecorated(viewForPosition2, rect4.left, rect4.top, rect4.right, rect4.bottom);
            i17 = rect4.top;
            this.f١٢٦٣٥a = i11;
            i11--;
        }
    }

    private void l(RecyclerView.Recycler recycler, RecyclerView.State state, int i10) {
        if (this.f١٢٦٤١g == 0) {
            m(recycler, state);
        } else {
            n(recycler, state);
        }
        throw null;
    }

    private void m(RecyclerView.Recycler recycler, RecyclerView.State state) {
        detachAndScrapAttachedViews(recycler);
        int startAfterPadding = p().getStartAfterPadding();
        int endAfterPadding = p().getEndAfterPadding();
        int i10 = this.f١٢٦٣٧c;
        Rect rect = new Rect();
        int r10 = r();
        View viewForPosition = recycler.getViewForPosition(this.f١٢٦٣٧c);
        addView(viewForPosition, 0);
        measureChildWithMargins(viewForPosition, 0, 0);
        int paddingTop = (int) (getPaddingTop() + ((r10 - r6) / 2.0f));
        int paddingLeft = (int) (getPaddingLeft() + ((o() - r5) / 2.0f));
        rect.set(paddingLeft, paddingTop, getDecoratedMeasuredWidth(viewForPosition) + paddingLeft, getDecoratedMeasuredHeight(viewForPosition) + paddingTop);
        layoutDecorated(viewForPosition, rect.left, rect.top, rect.right, rect.bottom);
        if (q().f١٢٦٤٥a.get(i10) == null) {
            q().f١٢٦٤٥a.put(i10, rect);
        } else {
            ((Rect) q().f١٢٦٤٥a.get(i10)).set(rect);
        }
        this.f١٢٦٣٦b = i10;
        this.f١٢٦٣٥a = i10;
        int decoratedLeft = getDecoratedLeft(viewForPosition);
        int decoratedRight = getDecoratedRight(viewForPosition);
        g(recycler, this.f١٢٦٣٧c - 1, decoratedLeft, startAfterPadding);
        h(recycler, this.f١٢٦٣٧c + 1, decoratedRight, endAfterPadding);
    }

    private void n(RecyclerView.Recycler recycler, RecyclerView.State state) {
        detachAndScrapAttachedViews(recycler);
        int startAfterPadding = p().getStartAfterPadding();
        int endAfterPadding = p().getEndAfterPadding();
        int i10 = this.f١٢٦٣٧c;
        Rect rect = new Rect();
        int o10 = o();
        View viewForPosition = recycler.getViewForPosition(this.f١٢٦٣٧c);
        addView(viewForPosition, 0);
        measureChildWithMargins(viewForPosition, 0, 0);
        int paddingLeft = (int) (getPaddingLeft() + ((o10 - r5) / 2.0f));
        int paddingTop = (int) (getPaddingTop() + ((r() - r6) / 2.0f));
        rect.set(paddingLeft, paddingTop, getDecoratedMeasuredWidth(viewForPosition) + paddingLeft, getDecoratedMeasuredHeight(viewForPosition) + paddingTop);
        layoutDecorated(viewForPosition, rect.left, rect.top, rect.right, rect.bottom);
        if (q().f١٢٦٤٥a.get(i10) == null) {
            q().f١٢٦٤٥a.put(i10, rect);
        } else {
            ((Rect) q().f١٢٦٤٥a.get(i10)).set(rect);
        }
        this.f١٢٦٣٦b = i10;
        this.f١٢٦٣٥a = i10;
        int decoratedTop = getDecoratedTop(viewForPosition);
        int decoratedBottom = getDecoratedBottom(viewForPosition);
        i(recycler, this.f١٢٦٣٧c - 1, decoratedTop, startAfterPadding);
        e(recycler, this.f١٢٦٣٧c + 1, decoratedBottom, endAfterPadding);
    }

    private int o() {
        return (getWidth() - getPaddingRight()) - getPaddingLeft();
    }

    private int r() {
        return (getHeight() - getPaddingBottom()) - getPaddingTop();
    }

    private void s() {
        d dVar = this.f١٢٦٤٠f;
        if (dVar != null) {
            dVar.f١٢٦٤٥a.clear();
        }
        int i10 = this.f١٢٦٣٨d;
        if (i10 != -1) {
            this.f١٢٦٣٧c = i10;
        }
        int min = Math.min(Math.max(0, this.f١٢٦٣٧c), getItemCount() - 1);
        this.f١٢٦٣٧c = min;
        this.f١٢٦٣٥a = min;
        this.f١٢٦٣٦b = min;
        this.f١٢٦٣٨d = -1;
        View view = this.f١٢٦٣٩e;
        if (view != null) {
            view.setSelected(false);
            this.f١٢٦٣٩e = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.f١٢٦٤١g == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.f١٢٦٤١g == 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i10) {
        int calculateScrollDirectionForPosition = calculateScrollDirectionForPosition(i10);
        PointF pointF = new PointF();
        if (calculateScrollDirectionForPosition == 0) {
            return null;
        }
        if (this.f١٢٦٤١g == 0) {
            pointF.x = calculateScrollDirectionForPosition;
            pointF.y = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            pointF.x = DownloadProgress.UNKNOWN_PROGRESS;
            pointF.y = calculateScrollDirectionForPosition;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.f١٢٦٤١g == 1) {
            return new b(-1, -2);
        }
        return new b(-2, -1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        super.onItemsRemoved(recyclerView, i10, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getItemCount() == 0) {
            s();
            detachAndScrapAttachedViews(recycler);
            return;
        }
        if (state.isPreLayout()) {
            return;
        }
        if (state.getItemCount() != 0 && !state.didStructureChange()) {
            return;
        }
        if (getChildCount() == 0 || state.didStructureChange()) {
            s();
        }
        this.f١٢٦٣٧c = Math.min(Math.max(0, this.f١٢٦٣٧c), getItemCount() - 1);
        detachAndScrapAttachedViews(recycler);
        l(recycler, state, 0);
    }

    public OrientationHelper p() {
        if (this.f١٢٦٤١g == 0) {
            if (this.f١٢٦٤٢h == null) {
                this.f١٢٦٤٢h = OrientationHelper.createHorizontalHelper(this);
            }
            return this.f١٢٦٤٢h;
        }
        if (this.f١٢٦٤٣i == null) {
            this.f١٢٦٤٣i = OrientationHelper.createVerticalHelper(this);
        }
        return this.f١٢٦٤٣i;
    }

    public d q() {
        if (this.f١٢٦٤٠f == null) {
            this.f١٢٦٤٠f = new d();
        }
        return this.f١٢٦٤٠f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int min;
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        int i11 = -i10;
        int endAfterPadding = ((p().getEndAfterPadding() - p().getStartAfterPadding()) / 2) + p().getStartAfterPadding();
        if (i10 > 0) {
            if (getPosition(getChildAt(getChildCount() - 1)) == getItemCount() - 1) {
                View childAt = getChildAt(getChildCount() - 1);
                min = Math.max(0, Math.min(i10, (((childAt.getRight() - childAt.getLeft()) / 2) + childAt.getLeft()) - endAfterPadding));
                i11 = -min;
            }
            int i12 = -i11;
            q().f١٢٦٤٦b = i12;
            f(recycler, state, i12);
            offsetChildrenHorizontal(i11);
            return i12;
        }
        if (this.f١٢٦٣٥a == 0) {
            View childAt2 = getChildAt(0);
            min = Math.min(0, Math.max(i10, (((childAt2.getRight() - childAt2.getLeft()) / 2) + childAt2.getLeft()) - endAfterPadding));
            i11 = -min;
        }
        int i122 = -i11;
        q().f١٢٦٤٦b = i122;
        f(recycler, state, i122);
        offsetChildrenHorizontal(i11);
        return i122;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int min;
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        int i11 = -i10;
        int endAfterPadding = ((p().getEndAfterPadding() - p().getStartAfterPadding()) / 2) + p().getStartAfterPadding();
        if (i10 > 0) {
            if (getPosition(getChildAt(getChildCount() - 1)) == getItemCount() - 1) {
                View childAt = getChildAt(getChildCount() - 1);
                min = Math.max(0, Math.min(i10, (((getDecoratedBottom(childAt) - getDecoratedTop(childAt)) / 2) + getDecoratedTop(childAt)) - endAfterPadding));
                i11 = -min;
            }
            int i12 = -i11;
            q().f١٢٦٤٦b = i12;
            f(recycler, state, i12);
            offsetChildrenVertical(i11);
            return i12;
        }
        if (this.f١٢٦٣٥a == 0) {
            View childAt2 = getChildAt(0);
            min = Math.min(0, Math.max(i10, (((getDecoratedBottom(childAt2) - getDecoratedTop(childAt2)) / 2) + getDecoratedTop(childAt2)) - endAfterPadding));
            i11 = -min;
        }
        int i122 = -i11;
        q().f١٢٦٤٦b = i122;
        f(recycler, state, i122);
        offsetChildrenVertical(i11);
        return i122;
    }

    public void setOnItemSelectedListener(c cVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i10) {
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i10);
        startSmoothScroll(aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }
}
