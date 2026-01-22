package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.a;
import c8.c;
import com.google.android.material.R;
import com.google.android.material.internal.h0;
import f8.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class MaterialDivider extends View {

    /* renamed from: f, reason: collision with root package name */
    private static final int f٩٠٠٠f = R.style.Widget_MaterialComponents_MaterialDivider;

    /* renamed from: a, reason: collision with root package name */
    private final i f٩٠٠١a;

    /* renamed from: b, reason: collision with root package name */
    private int f٩٠٠٢b;

    /* renamed from: c, reason: collision with root package name */
    private int f٩٠٠٣c;

    /* renamed from: d, reason: collision with root package name */
    private int f٩٠٠٤d;

    /* renamed from: e, reason: collision with root package name */
    private int f٩٠٠٥e;

    public MaterialDivider(Context context) {
        this(context, null);
    }

    public int getDividerColor() {
        return this.f٩٠٠٣c;
    }

    public int getDividerInsetEnd() {
        return this.f٩٠٠٥e;
    }

    public int getDividerInsetStart() {
        return this.f٩٠٠٤d;
    }

    public int getDividerThickness() {
        return this.f٩٠٠٢b;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i10;
        int width;
        int i11;
        super.onDraw(canvas);
        boolean z10 = true;
        if (getLayoutDirection() != 1) {
            z10 = false;
        }
        if (z10) {
            i10 = this.f٩٠٠٥e;
        } else {
            i10 = this.f٩٠٠٤d;
        }
        if (z10) {
            width = getWidth();
            i11 = this.f٩٠٠٤d;
        } else {
            width = getWidth();
            i11 = this.f٩٠٠٥e;
        }
        this.f٩٠٠١a.setBounds(i10, 0, width - i11, getBottom() - getTop());
        this.f٩٠٠١a.draw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i12 = this.f٩٠٠٢b;
            if (i12 > 0 && measuredHeight != i12) {
                measuredHeight = i12;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(int i10) {
        if (this.f٩٠٠٣c != i10) {
            this.f٩٠٠٣c = i10;
            this.f٩٠٠١a.h0(ColorStateList.valueOf(i10));
            invalidate();
        }
    }

    public void setDividerColorResource(int i10) {
        setDividerColor(a.getColor(getContext(), i10));
    }

    public void setDividerInsetEnd(int i10) {
        this.f٩٠٠٥e = i10;
    }

    public void setDividerInsetEndResource(int i10) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i10));
    }

    public void setDividerInsetStart(int i10) {
        this.f٩٠٠٤d = i10;
    }

    public void setDividerInsetStartResource(int i10) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i10));
    }

    public void setDividerThickness(int i10) {
        if (this.f٩٠٠٢b != i10) {
            this.f٩٠٠٢b = i10;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(int i10) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i10));
    }

    public MaterialDivider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialDividerStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialDivider(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, r4), attributeSet, i10);
        int i11 = f٩٠٠٠f;
        Context context2 = getContext();
        this.f٩٠٠١a = new i();
        TypedArray i12 = h0.i(context2, attributeSet, R.styleable.MaterialDivider, i10, i11, new int[0]);
        this.f٩٠٠٢b = i12.getDimensionPixelSize(R.styleable.MaterialDivider_dividerThickness, getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.f٩٠٠٤d = i12.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetStart, 0);
        this.f٩٠٠٥e = i12.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetEnd, 0);
        setDividerColor(c.a(context2, i12, R.styleable.MaterialDivider_dividerColor).getDefaultColor());
        i12.recycle();
    }
}
