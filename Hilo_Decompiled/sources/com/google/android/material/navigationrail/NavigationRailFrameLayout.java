package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class NavigationRailFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    int f٩٥٤٢a;

    /* renamed from: b, reason: collision with root package name */
    boolean f٩٥٤٣b;

    public NavigationRailFrameLayout(Context context) {
        super(context);
        this.f٩٥٤٢a = 0;
        this.f٩٥٤٣b = false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        int childCount = getChildCount();
        int i14 = this.f٩٥٤٢a;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int max = Math.max(i14, childAt.getTop()) + layoutParams.topMargin;
            childAt.layout(childAt.getLeft(), max, childAt.getRight(), childAt.getMeasuredHeight() + max);
            i14 = max + childAt.getMeasuredHeight() + layoutParams.bottomMargin;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int childCount = getChildCount();
        int i12 = 0;
        View childAt = getChildAt(0);
        int size = View.MeasureSpec.getSize(i11);
        if (childCount > 1) {
            View childAt2 = getChildAt(0);
            measureChild(childAt2, i10, i11);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt2.getLayoutParams();
            i12 = layoutParams.topMargin + childAt2.getMeasuredHeight() + layoutParams.bottomMargin;
            int i13 = (size - i12) - this.f٩٥٤٢a;
            childAt = getChildAt(1);
            if (!this.f٩٥٤٣b) {
                i11 = View.MeasureSpec.makeMeasureSpec(i13, Integer.MIN_VALUE);
            }
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        measureChild(childAt, i10, i11);
        setMeasuredDimension(getMeasuredWidth(), Math.max(size, this.f٩٥٤٢a + i12 + childAt.getMeasuredHeight() + layoutParams2.bottomMargin + layoutParams2.topMargin));
    }

    public void setPaddingTop(int i10) {
        this.f٩٥٤٢a = i10;
    }

    public void setScrollingEnabled(boolean z10) {
        this.f٩٥٤٣b = z10;
    }
}
