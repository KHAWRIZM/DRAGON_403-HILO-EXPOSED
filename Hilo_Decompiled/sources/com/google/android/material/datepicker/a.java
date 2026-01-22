package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import com.google.android.material.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final Rect f٨٨٦٠a;

    /* renamed from: b, reason: collision with root package name */
    private final ColorStateList f٨٨٦١b;

    /* renamed from: c, reason: collision with root package name */
    private final ColorStateList f٨٨٦٢c;

    /* renamed from: d, reason: collision with root package name */
    private final ColorStateList f٨٨٦٣d;

    /* renamed from: e, reason: collision with root package name */
    private final int f٨٨٦٤e;

    /* renamed from: f, reason: collision with root package name */
    private final f8.o f٨٨٦٥f;

    private a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i10, f8.o oVar, Rect rect) {
        androidx.core.util.h.d(rect.left);
        androidx.core.util.h.d(rect.top);
        androidx.core.util.h.d(rect.right);
        androidx.core.util.h.d(rect.bottom);
        this.f٨٨٦٠a = rect;
        this.f٨٨٦١b = colorStateList2;
        this.f٨٨٦٢c = colorStateList;
        this.f٨٨٦٣d = colorStateList3;
        this.f٨٨٦٤e = i10;
        this.f٨٨٦٥f = oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(Context context, int i10) {
        boolean z10;
        if (i10 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        androidx.core.util.h.b(z10, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i10, R.styleable.MaterialCalendarItem);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList a10 = c8.c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList a11 = c8.c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList a12 = c8.c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        f8.o m10 = f8.o.b(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).m();
        obtainStyledAttributes.recycle();
        return new a(a10, a11, a12, dimensionPixelSize, m10, rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f٨٨٦٠a.bottom;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f٨٨٦٠a.top;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(TextView textView) {
        e(textView, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(TextView textView, ColorStateList colorStateList, ColorStateList colorStateList2) {
        f8.i iVar = new f8.i();
        f8.i iVar2 = new f8.i();
        iVar.setShapeAppearanceModel(this.f٨٨٦٥f);
        iVar2.setShapeAppearanceModel(this.f٨٨٦٥f);
        if (colorStateList == null) {
            colorStateList = this.f٨٨٦٢c;
        }
        iVar.h0(colorStateList);
        iVar.s0(this.f٨٨٦٤e, this.f٨٨٦٣d);
        if (colorStateList2 == null) {
            colorStateList2 = this.f٨٨٦١b;
        }
        textView.setTextColor(colorStateList2);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f٨٨٦١b.withAlpha(30), iVar, iVar2);
        Rect rect = this.f٨٨٦٠a;
        textView.setBackground(new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
