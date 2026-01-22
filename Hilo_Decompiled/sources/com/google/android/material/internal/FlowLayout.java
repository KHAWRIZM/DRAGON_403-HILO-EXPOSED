package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private int f٩١٨٠a;

    /* renamed from: b, reason: collision with root package name */
    private int f٩١٨١b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f٩١٨٢c;

    /* renamed from: d, reason: collision with root package name */
    private int f٩١٨٣d;

    public FlowLayout(Context context) {
        this(context, null);
    }

    private static int a(int i10, int i11, int i12) {
        if (i11 != Integer.MIN_VALUE) {
            if (i11 != 1073741824) {
                return i12;
            }
            return i10;
        }
        return Math.min(i12, i10);
    }

    private void d(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, 0, 0);
        this.f٩١٨٠a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
        this.f٩١٨١b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_horizontalItemSpacing, 0);
        obtainStyledAttributes.recycle();
    }

    public int b(View view) {
        Object tag = view.getTag(R.id.row_index_key);
        if (!(tag instanceof Integer)) {
            return -1;
        }
        return ((Integer) tag).intValue();
    }

    public boolean c() {
        return this.f٩١٨٢c;
    }

    protected int getItemSpacing() {
        return this.f٩١٨١b;
    }

    protected int getLineSpacing() {
        return this.f٩١٨٠a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getRowCount() {
        return this.f٩١٨٣d;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean z11;
        int paddingLeft;
        int paddingRight;
        int i14;
        int i15;
        if (getChildCount() == 0) {
            this.f٩١٨٣d = 0;
            return;
        }
        this.f٩١٨٣d = 1;
        if (getLayoutDirection() == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            paddingLeft = getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (z11) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int i16 = paddingLeft;
        int i17 = paddingTop;
        for (int i18 = 0; i18 < getChildCount(); i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R.id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i15 = marginLayoutParams.getMarginStart();
                    i14 = marginLayoutParams.getMarginEnd();
                } else {
                    i14 = 0;
                    i15 = 0;
                }
                int measuredWidth = i16 + i15 + childAt.getMeasuredWidth();
                int i19 = i12 - i10;
                int i20 = i19 - paddingRight;
                if (!this.f٩١٨٢c && measuredWidth > i20) {
                    measuredWidth = paddingLeft + i15 + childAt.getMeasuredWidth();
                    i17 = paddingTop + this.f٩١٨٠a;
                    this.f٩١٨٣d++;
                    i16 = paddingLeft;
                }
                childAt.setTag(R.id.row_index_key, Integer.valueOf(this.f٩١٨٣d - 1));
                int measuredHeight = childAt.getMeasuredHeight() + i17;
                if (z11) {
                    childAt.layout(i19 - measuredWidth, i17, (i19 - i16) - i15, measuredHeight);
                } else {
                    childAt.layout(i16 + i15, i17, measuredWidth, measuredHeight);
                }
                i16 += i15 + i14 + childAt.getMeasuredWidth() + this.f٩١٨١b;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int size = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i11);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            i12 = Integer.MAX_VALUE;
        } else {
            i12 = size;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i12 - getPaddingRight();
        int i16 = paddingTop;
        int i17 = 0;
        for (int i18 = 0; i18 < getChildCount(); i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i10, i11);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i13 = marginLayoutParams.leftMargin;
                    i14 = marginLayoutParams.rightMargin;
                } else {
                    i13 = 0;
                    i14 = 0;
                }
                int i19 = paddingLeft;
                if (paddingLeft + i13 + childAt.getMeasuredWidth() > paddingRight && !c()) {
                    i15 = getPaddingLeft();
                    i16 = this.f٩١٨٠a + paddingTop;
                } else {
                    i15 = i19;
                }
                int measuredWidth = i15 + i13 + childAt.getMeasuredWidth();
                int measuredHeight = i16 + childAt.getMeasuredHeight();
                if (measuredWidth > i17) {
                    i17 = measuredWidth;
                }
                paddingLeft = i15 + i13 + i14 + childAt.getMeasuredWidth() + this.f٩١٨١b;
                if (i18 == getChildCount() - 1) {
                    i17 += i14;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(a(size, mode, i17 + getPaddingRight()), a(size2, mode2, paddingTop + getPaddingBottom()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setItemSpacing(int i10) {
        this.f٩١٨١b = i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLineSpacing(int i10) {
        this.f٩١٨٠a = i10;
    }

    public void setSingleLine(boolean z10) {
        this.f٩١٨٢c = z10;
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٩١٨٢c = false;
        d(context, attributeSet);
    }
}
