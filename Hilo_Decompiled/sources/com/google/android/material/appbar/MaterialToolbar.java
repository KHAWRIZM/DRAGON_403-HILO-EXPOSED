package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.R;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.i0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class MaterialToolbar extends Toolbar {

    /* renamed from: f, reason: collision with root package name */
    private static final int f٨٢٠٢f = R.style.Widget_MaterialComponents_Toolbar;

    /* renamed from: g, reason: collision with root package name */
    private static final ImageView.ScaleType[] f٨٢٠٣g = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: a, reason: collision with root package name */
    private Integer f٨٢٠٤a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f٨٢٠٥b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f٨٢٠٦c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView.ScaleType f٨٢٠٧d;

    /* renamed from: e, reason: collision with root package name */
    private Boolean f٨٢٠٨e;

    public MaterialToolbar(Context context) {
        this(context, null);
    }

    private Drawable A(Drawable drawable) {
        if (drawable != null && this.f٨٢٠٤a != null) {
            Drawable r10 = h2.b.r(drawable.mutate());
            r10.setTint(this.f٨٢٠٤a.intValue());
            return r10;
        }
        return drawable;
    }

    private void B() {
        ImageView c10 = i0.c(this);
        if (c10 != null) {
            Boolean bool = this.f٨٢٠٨e;
            if (bool != null) {
                c10.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f٨٢٠٧d;
            if (scaleType != null) {
                c10.setScaleType(scaleType);
            }
        }
    }

    private Pair w(TextView textView, TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i10 = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i10 && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i10 && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    private void x(Context context) {
        ColorStateList g10;
        Drawable background = getBackground();
        if (background == null) {
            g10 = ColorStateList.valueOf(0);
        } else {
            g10 = com.google.android.material.drawable.g.g(background);
        }
        if (g10 != null) {
            f8.i iVar = new f8.i();
            iVar.h0(g10);
            iVar.V(context);
            iVar.g0(getElevation());
            setBackground(iVar);
        }
    }

    private void y(View view, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i10 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i11 = measuredWidth2 + i10;
        int max = Math.max(Math.max(((Integer) pair.first).intValue() - i10, 0), Math.max(i11 - ((Integer) pair.second).intValue(), 0));
        if (max > 0) {
            i10 += max;
            i11 -= max;
            view.measure(View.MeasureSpec.makeMeasureSpec(i11 - i10, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i10, view.getTop(), i11, view.getBottom());
    }

    private void z() {
        if (!this.f٨٢٠٥b && !this.f٨٢٠٦c) {
            return;
        }
        TextView g10 = i0.g(this);
        TextView e10 = i0.e(this);
        if (g10 == null && e10 == null) {
            return;
        }
        Pair w10 = w(g10, e10);
        if (this.f٨٢٠٥b && g10 != null) {
            y(g10, w10);
        }
        if (this.f٨٢٠٦c && e10 != null) {
            y(e10, w10);
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f٨٢٠٧d;
    }

    public Integer getNavigationIconTint() {
        return this.f٨٢٠٤a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f8.j.e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        z();
        B();
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        f8.j.d(this, f10);
    }

    public void setLogoAdjustViewBounds(boolean z10) {
        Boolean bool = this.f٨٢٠٨e;
        if (bool == null || bool.booleanValue() != z10) {
            this.f٨٢٠٨e = Boolean.valueOf(z10);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.f٨٢٠٧d != scaleType) {
            this.f٨٢٠٧d = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(A(drawable));
    }

    public void setNavigationIconTint(int i10) {
        this.f٨٢٠٤a = Integer.valueOf(i10);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z10) {
        if (this.f٨٢٠٦c != z10) {
            this.f٨٢٠٦c = z10;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z10) {
        if (this.f٨٢٠٥b != z10) {
            this.f٨٢٠٥b = z10;
            requestLayout();
        }
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.toolbarStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialToolbar(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, r4), attributeSet, i10);
        int i11 = f٨٢٠٢f;
        Context context2 = getContext();
        TypedArray i12 = h0.i(context2, attributeSet, R.styleable.MaterialToolbar, i10, i11, new int[0]);
        int i13 = R.styleable.MaterialToolbar_navigationIconTint;
        if (i12.hasValue(i13)) {
            setNavigationIconTint(i12.getColor(i13, -1));
        }
        this.f٨٢٠٥b = i12.getBoolean(R.styleable.MaterialToolbar_titleCentered, false);
        this.f٨٢٠٦c = i12.getBoolean(R.styleable.MaterialToolbar_subtitleCentered, false);
        int i14 = i12.getInt(R.styleable.MaterialToolbar_logoScaleType, -1);
        if (i14 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f٨٢٠٣g;
            if (i14 < scaleTypeArr.length) {
                this.f٨٢٠٧d = scaleTypeArr[i14];
            }
        }
        int i15 = R.styleable.MaterialToolbar_logoAdjustViewBounds;
        if (i12.hasValue(i15)) {
            this.f٨٢٠٨e = Boolean.valueOf(i12.getBoolean(i15, false));
        }
        i12.recycle();
        x(context2);
    }
}
