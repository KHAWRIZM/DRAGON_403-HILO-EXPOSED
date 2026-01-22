package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class NavigationRailMenuView extends NavigationBarMenuView {

    /* renamed from: b0, reason: collision with root package name */
    private int f٩٥٤٤b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f٩٥٤٥c0;

    /* renamed from: d0, reason: collision with root package name */
    private final FrameLayout.LayoutParams f٩٥٤٦d0;

    public NavigationRailMenuView(Context context) {
        super(context);
        this.f٩٥٤٤b0 = -1;
        this.f٩٥٤٥c0 = 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.f٩٥٤٦d0 = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
        setItemActiveIndicatorResizeable(true);
    }

    private int s(int i10, int i11, int i12) {
        int max = i11 / Math.max(1, i12);
        int i13 = this.f٩٥٤٤b0;
        if (i13 == -1) {
            i13 = View.MeasureSpec.getSize(i10);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(i13, max), 0);
    }

    private int t(View view, int i10, int i11) {
        view.measure(i10, i11);
        if (view.getVisibility() != 8) {
            return view.getMeasuredHeight();
        }
        return 0;
    }

    private int u(int i10, int i11, int i12, View view) {
        int makeMeasureSpec;
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i11, 0);
        int childCount = getChildCount();
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (!(childAt instanceof NavigationBarItemView)) {
                int t10 = t(childAt, i10, makeMeasureSpec2);
                i11 -= t10;
                i13 += t10;
            }
        }
        int max = Math.max(i11, 0);
        if (view == null) {
            makeMeasureSpec = s(i10, max, i12);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        }
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt2 = getChildAt(i16);
            if (childAt2.getVisibility() == 0) {
                i15++;
            }
            if ((childAt2 instanceof NavigationBarItemView) && childAt2 != view) {
                i13 += t(childAt2, i10, makeMeasureSpec);
            }
        }
        return i13 + (Math.max(0, i15 - 1) * this.f٩٥٤٥c0);
    }

    private int v(int i10, int i11, int i12) {
        int i13;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            i13 = t(childAt, i10, s(i10, i11, i12));
            i11 -= i13;
            i12--;
        } else {
            i13 = 0;
        }
        return i13 + u(i10, i11, i12, childAt);
    }

    public int getItemMinimumHeight() {
        return this.f٩٥٤٤b0;
    }

    public int getItemSpacing() {
        return this.f٩٥٤٥c0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMenuGravity() {
        return this.f٩٥٤٦d0.gravity;
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    protected NavigationBarItemView h(Context context) {
        return new NavigationRailItemView(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int max;
        int childCount = getChildCount();
        int i14 = i12 - i10;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                i16 += childAt.getMeasuredHeight();
                i15++;
            }
        }
        if (i15 <= 1) {
            max = 0;
        } else {
            max = Math.max(0, Math.min((getMeasuredHeight() - i16) / (i15 - 1), this.f٩٥٤٥c0));
        }
        int i18 = 0;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt2 = getChildAt(i19);
            if (childAt2.getVisibility() != 8) {
                int measuredHeight = childAt2.getMeasuredHeight();
                childAt2.layout(0, i18, i14, measuredHeight + i18);
                i18 += measuredHeight + max;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int u10;
        int size = View.MeasureSpec.getSize(i11);
        int currentVisibleContentItemCount = getCurrentVisibleContentItemCount();
        if (currentVisibleContentItemCount > 1 && j(getLabelVisibilityMode(), currentVisibleContentItemCount)) {
            u10 = v(i10, size, currentVisibleContentItemCount);
        } else {
            u10 = u(i10, size, currentVisibleContentItemCount, null);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i10), View.resolveSizeAndState(u10, i11, 0));
    }

    public void setItemMinimumHeight(int i10) {
        if (this.f٩٥٤٤b0 != i10) {
            this.f٩٥٤٤b0 = i10;
            requestLayout();
        }
    }

    public void setItemSpacing(int i10) {
        if (this.f٩٥٤٥c0 != i10) {
            this.f٩٥٤٥c0 = i10;
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuGravity(int i10) {
        FrameLayout.LayoutParams layoutParams = this.f٩٥٤٦d0;
        if (layoutParams.gravity != i10) {
            layoutParams.gravity = i10;
            setLayoutParams(layoutParams);
        }
    }
}
