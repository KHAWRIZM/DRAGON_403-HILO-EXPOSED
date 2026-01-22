package com.oudi.widget.nine;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.oudi.utils.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\nJ\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J,\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0019R\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\u001c\u0010\u001f\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0019R\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010!\u001a\u00020\u0006J\u0006\u0010\"\u001a\u00020\u0006J\u0014\u0010#\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0019R\u00020\u001aH\u0014J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&H\u0002J\u001c\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u001a2\n\u0010\u0018\u001a\u00060\u0019R\u00020\u001aH\u0016J(\u0010)\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0014H\u0016J \u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006/"}, d2 = {"Lcom/oudi/widget/nine/NineGridLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Lcom/oudi/utils/log/ILog;", "<init>", "()V", "gridSpacing", "", "(I)V", "gridSpanCount", "maxItemSize", "(III)V", "itemWidth", "itemHeight", "recycleChildrenOnDetach", "", "getRecycleChildrenOnDetach", "()Z", "setRecycleChildrenOnDetach", "(Z)V", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "isAutoMeasureEnabled", "onMeasure", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "widthSpec", "heightSpec", "onLayoutChildren", "getSpanCount", "getItemCount2", "getRowCount", "fill", "measureGridChild", "child", "Landroid/view/View;", "onDetachedFromWindow", ViewHierarchyConstants.VIEW_KEY, "shouldMeasureChild", "lp", "isMeasurementUpToDate", "childSize", "spec", ViewHierarchyConstants.DIMENSION_KEY, "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class NineGridLayoutManager extends RecyclerView.LayoutManager implements ILog {
    private int gridSpacing;
    private int gridSpanCount;
    private int itemHeight;
    private int itemWidth;
    private int maxItemSize;
    private boolean recycleChildrenOnDetach;

    public NineGridLayoutManager() {
        this(0);
    }

    private final boolean isMeasurementUpToDate(int childSize, int spec, int dimension) {
        int mode = View.MeasureSpec.getMode(spec);
        int size = View.MeasureSpec.getSize(spec);
        if (dimension > 0 && childSize != dimension) {
            return false;
        }
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                return true;
            }
            if (mode != 1073741824 || size != childSize) {
                return false;
            }
            return true;
        }
        if (size < childSize) {
            return false;
        }
        return true;
    }

    private final void measureGridChild(View child) {
        Rect rect = new Rect();
        calculateItemDecorationsForChild(child, rect);
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
        int i10 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
        int i11 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
        int childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), i10, this.itemWidth, canScrollHorizontally());
        int childMeasureSpec2 = RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), i11, this.itemHeight, canScrollVertically());
        if (shouldMeasureChild(child, childMeasureSpec, childMeasureSpec2, layoutParams2)) {
            child.measure(childMeasureSpec, childMeasureSpec2);
        }
    }

    public void fill(@NotNull RecyclerView.Recycler recycler) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        int itemCount2 = getItemCount2();
        int spanCount = getSpanCount();
        int i10 = 0;
        if (spanCount == 1) {
            View viewForPosition = recycler.getViewForPosition(0);
            Intrinsics.checkNotNullExpressionValue(viewForPosition, "getViewForPosition(...)");
            addView(viewForPosition);
            measureChildWithMargins(viewForPosition, 0, 0);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
            int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
            layoutDecoratedWithMargins(viewForPosition, getPaddingLeft(), getPaddingTop(), getPaddingRight() + getPaddingLeft() + decoratedMeasuredWidth, getPaddingTop() + decoratedMeasuredHeight);
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        while (i10 < itemCount2) {
            View viewForPosition2 = recycler.getViewForPosition(i10);
            Intrinsics.checkNotNullExpressionValue(viewForPosition2, "getViewForPosition(...)");
            addView(viewForPosition2);
            measureGridChild(viewForPosition2);
            layoutDecoratedWithMargins(viewForPosition2, paddingLeft, paddingTop, paddingLeft + this.itemWidth, paddingTop + this.itemHeight);
            paddingLeft += this.itemWidth + this.gridSpacing;
            i10++;
            if (i10 % spanCount == 0) {
                paddingLeft = getPaddingLeft();
                paddingTop += this.itemHeight + this.gridSpacing;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @Nullable
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-1, -2);
    }

    public final int getItemCount2() {
        return RangesKt.coerceAtMost(super.getItemCount(), this.maxItemSize);
    }

    @Override // com.oudi.utils.log.ILog
    @NotNull
    public String getLogTag() {
        return ILog.DefaultImpls.getLogTag(this);
    }

    public final boolean getRecycleChildrenOnDetach() {
        return this.recycleChildrenOnDetach;
    }

    public final int getRowCount() {
        int i10;
        int spanCount = getSpanCount();
        int itemCount2 = getItemCount2();
        int i11 = itemCount2 / spanCount;
        if (itemCount2 % spanCount != 0) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        return i11 + i10;
    }

    public final int getSpanCount() {
        int itemCount = getItemCount();
        if (itemCount == 1) {
            return 1;
        }
        if (itemCount != 4) {
            return 3;
        }
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // com.oudi.utils.log.ILog
    public void logD(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logD(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logI(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logI(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logV(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logV(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logW(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logW(this, str, str2, z10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(@NotNull RecyclerView view, @NotNull RecyclerView.Recycler recycler) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        super.onDetachedFromWindow(view, recycler);
        if (this.recycleChildrenOnDetach) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(@NotNull RecyclerView.Recycler recycler, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        if (state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
        } else {
            if (state.isPreLayout()) {
                return;
            }
            detachAndScrapAttachedViews(recycler);
            fill(recycler);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onMeasure(@NotNull RecyclerView.Recycler recycler, @NotNull RecyclerView.State state, int widthSpec, int heightSpec) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onMeasure(recycler, state, widthSpec, heightSpec);
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int i10 = this.gridSpacing;
        int i11 = this.gridSpanCount;
        int i12 = (width - ((i11 - 1) * i10)) / i11;
        this.itemWidth = i12;
        this.itemHeight = i12;
    }

    public final void setRecycleChildrenOnDetach(boolean z10) {
        this.recycleChildrenOnDetach = z10;
    }

    public boolean shouldMeasureChild(@NotNull View child, int widthSpec, int heightSpec, @NotNull RecyclerView.LayoutParams lp) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(lp, "lp");
        if (!child.isLayoutRequested() && isMeasurementUpToDate(child.getWidth(), widthSpec, ((ViewGroup.MarginLayoutParams) lp).width) && isMeasurementUpToDate(child.getHeight(), heightSpec, ((ViewGroup.MarginLayoutParams) lp).height)) {
            return false;
        }
        return true;
    }

    public NineGridLayoutManager(int i10) {
        this(i10, 3, 9);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, th, str2, z10);
    }

    public NineGridLayoutManager(int i10, int i11, int i12) {
        this.gridSpacing = i10;
        this.gridSpanCount = i11;
        this.maxItemSize = i12;
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
        ILog.DefaultImpls.logE(this, th, str, z10);
    }
}
