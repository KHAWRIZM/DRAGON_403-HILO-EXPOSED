package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class BottomNavigationMenuView extends NavigationBarMenuView {

    /* renamed from: b0, reason: collision with root package name */
    private final int f٨٤٠٦b0;

    /* renamed from: c0, reason: collision with root package name */
    private final int f٨٤٠٧c0;

    /* renamed from: d0, reason: collision with root package name */
    private final int f٨٤٠٨d0;

    /* renamed from: e0, reason: collision with root package name */
    private final int f٨٤٠٩e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f٨٤١٠f0;

    /* renamed from: g0, reason: collision with root package name */
    private final List f٨٤١١g0;

    public BottomNavigationMenuView(Context context) {
        super(context);
        this.f٨٤١١g0 = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.f٨٤٠٦b0 = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.f٨٤٠٧c0 = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.f٨٤٠٨d0 = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.f٨٤٠٩e0 = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    protected NavigationBarItemView h(Context context) {
        return new BottomNavigationItemView(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                if (getLayoutDirection() == 1) {
                    int i18 = i14 - i16;
                    childAt.layout(i18 - childAt.getMeasuredWidth(), 0, i18, i15);
                } else {
                    childAt.layout(i16, 0, childAt.getMeasuredWidth() + i16, i15);
                }
                i16 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int size = View.MeasureSpec.getSize(i10);
        int currentVisibleContentItemCount = getCurrentVisibleContentItemCount();
        int childCount = getChildCount();
        this.f٨٤١١g0.clear();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i11), Integer.MIN_VALUE);
        int i17 = 1;
        int i18 = 0;
        if (getItemIconGravity() == 0) {
            if (j(getLabelVisibilityMode(), currentVisibleContentItemCount) && s()) {
                View childAt = getChildAt(getSelectedItemPosition());
                int i19 = this.f٨٤٠٩e0;
                if (childAt.getVisibility() != 8) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f٨٤٠٨d0, Integer.MIN_VALUE), makeMeasureSpec);
                    i19 = Math.max(i19, childAt.getMeasuredWidth());
                }
                if (childAt.getVisibility() != 8) {
                    i15 = 1;
                } else {
                    i15 = 0;
                }
                int i20 = currentVisibleContentItemCount - i15;
                int min = Math.min(size - (this.f٨٤٠٧c0 * i20), Math.min(i19, this.f٨٤٠٨d0));
                int i21 = size - min;
                if (i20 != 0) {
                    i17 = i20;
                }
                int min2 = Math.min(i21 / i17, this.f٨٤٠٦b0);
                int i22 = i21 - (i20 * min2);
                for (int i23 = 0; i23 < childCount; i23++) {
                    if (getChildAt(i23).getVisibility() != 8) {
                        if (i23 == getSelectedItemPosition()) {
                            i16 = min;
                        } else {
                            i16 = min2;
                        }
                        if (i22 > 0) {
                            i16++;
                            i22--;
                        }
                    } else {
                        i16 = 0;
                    }
                    this.f٨٤١١g0.add(Integer.valueOf(i16));
                }
            } else {
                if (currentVisibleContentItemCount != 0) {
                    i17 = currentVisibleContentItemCount;
                }
                int min3 = Math.min(size / i17, this.f٨٤٠٨d0);
                int i24 = size - (currentVisibleContentItemCount * min3);
                for (int i25 = 0; i25 < childCount; i25++) {
                    if (getChildAt(i25).getVisibility() != 8) {
                        if (i24 > 0) {
                            i14 = min3 + 1;
                            i24--;
                        } else {
                            i14 = min3;
                        }
                    } else {
                        i14 = 0;
                    }
                    this.f٨٤١١g0.add(Integer.valueOf(i14));
                }
            }
            i12 = 0;
            i13 = 0;
            while (i18 < childCount) {
                View childAt2 = getChildAt(i18);
                if (childAt2.getVisibility() != 8) {
                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(((Integer) this.f٨٤١١g0.get(i18)).intValue(), 1073741824), makeMeasureSpec);
                    childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                    i12 += childAt2.getMeasuredWidth();
                    i13 = Math.max(i13, childAt2.getMeasuredHeight());
                }
                i18++;
            }
        } else {
            if (currentVisibleContentItemCount == 0) {
                currentVisibleContentItemCount = 1;
            }
            float f10 = size;
            float min4 = Math.min((currentVisibleContentItemCount + 3) / 10.0f, 0.9f) * f10;
            float f11 = currentVisibleContentItemCount;
            int round = Math.round(min4 / f11);
            int round2 = Math.round(f10 / f11);
            int i26 = 0;
            int i27 = 0;
            while (i18 < childCount) {
                View childAt3 = getChildAt(i18);
                if (childAt3.getVisibility() != 8) {
                    childAt3.measure(View.MeasureSpec.makeMeasureSpec(round2, Integer.MIN_VALUE), makeMeasureSpec);
                    if (childAt3.getMeasuredWidth() < round) {
                        childAt3.measure(View.MeasureSpec.makeMeasureSpec(round, 1073741824), makeMeasureSpec);
                    }
                    i26 += childAt3.getMeasuredWidth();
                    i27 = Math.max(i27, childAt3.getMeasuredHeight());
                }
                i18++;
            }
            i12 = i26;
            i13 = i27;
        }
        setMeasuredDimension(i12, Math.max(i13, getSuggestedMinimumHeight()));
    }

    public boolean s() {
        return this.f٨٤١٠f0;
    }

    public void setItemHorizontalTranslationEnabled(boolean z10) {
        this.f٨٤١٠f0 = z10;
    }
}
