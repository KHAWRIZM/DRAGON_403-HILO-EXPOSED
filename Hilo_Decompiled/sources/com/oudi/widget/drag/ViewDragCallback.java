package com.oudi.widget.drag;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import s2.c;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0010J7\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b \u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010!¨\u0006\""}, d2 = {"Lcom/oudi/widget/drag/ViewDragCallback;", "Ls2/c$c;", "Landroid/view/ViewGroup;", "parent", "<init>", "(Landroid/view/ViewGroup;)V", "Landroid/view/View;", "child", "", "pointerId", "", "tryCaptureView", "(Landroid/view/View;I)Z", ViewHierarchyConstants.DIMENSION_TOP_KEY, "dy", "clampViewPositionVertical", "(Landroid/view/View;II)I", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "dx", "clampViewPositionHorizontal", "changedView", "", "onViewPositionChanged", "(Landroid/view/View;IIII)V", FirebaseAnalytics.Param.INDEX, "getOrderedChildIndex", "(I)I", "getViewHorizontalDragRange", "(Landroid/view/View;)I", "getViewVerticalDragRange", "isBoundaryLimit", "(Landroid/view/View;)Z", "isRecordDrag", "Landroid/view/ViewGroup;", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class ViewDragCallback extends c.AbstractC٠٢٢٦c {

    @NotNull
    private final ViewGroup parent;

    public ViewDragCallback(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.parent = parent;
    }

    @Override // s2.c.AbstractC٠٢٢٦c
    public int clampViewPositionHorizontal(@NotNull View child, int left, int dx) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (isBoundaryLimit(child)) {
            return RangesKt.coerceAtMost((this.parent.getWidth() - child.getWidth()) - this.parent.getPaddingEnd(), RangesKt.coerceAtLeast(this.parent.getPaddingStart(), left));
        }
        return left;
    }

    @Override // s2.c.AbstractC٠٢٢٦c
    public int clampViewPositionVertical(@NotNull View child, int top, int dy) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (isBoundaryLimit(child)) {
            return RangesKt.coerceAtMost((this.parent.getHeight() - child.getHeight()) - this.parent.getPaddingBottom(), RangesKt.coerceAtLeast(this.parent.getPaddingTop(), top));
        }
        return top;
    }

    @Override // s2.c.AbstractC٠٢٢٦c
    public int getOrderedChildIndex(int index) {
        return index;
    }

    @Override // s2.c.AbstractC٠٢٢٦c
    public int getViewHorizontalDragRange(@NotNull View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return this.parent.getMeasuredWidth() - child.getMeasuredWidth();
    }

    @Override // s2.c.AbstractC٠٢٢٦c
    public int getViewVerticalDragRange(@NotNull View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return this.parent.getMeasuredWidth() - child.getMeasuredHeight();
    }

    public boolean isBoundaryLimit(@NotNull View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return true;
    }

    public boolean isRecordDrag(@NotNull View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return true;
    }

    @Override // s2.c.AbstractC٠٢٢٦c
    public void onViewPositionChanged(@NotNull View changedView, int left, int top, int dx, int dy) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
    }

    @Override // s2.c.AbstractC٠٢٢٦c
    public boolean tryCaptureView(@NotNull View child, int pointerId) {
        Intrinsics.checkNotNullParameter(child, "child");
        return true;
    }
}
