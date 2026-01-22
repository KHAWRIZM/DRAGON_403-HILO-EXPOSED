package com.google.android.material.radiobutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.c;
import com.google.android.material.R;
import com.google.android.material.internal.h0;
import v7.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class MaterialRadioButton extends AppCompatRadioButton {

    /* renamed from: g, reason: collision with root package name */
    private static final int f٩٧٤٤g = R.style.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* renamed from: h, reason: collision with root package name */
    private static final int[][] f٩٧٤٥h = {new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: e, reason: collision with root package name */
    private ColorStateList f٩٧٤٦e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f٩٧٤٧f;

    public MaterialRadioButton(Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f٩٧٤٦e == null) {
            int d10 = a.d(this, androidx.appcompat.R.attr.colorControlActivated);
            int d11 = a.d(this, R.attr.colorOnSurface);
            int d12 = a.d(this, R.attr.colorSurface);
            int[][] iArr = f٩٧٤٥h;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = a.k(d12, d10, 1.0f);
            iArr2[1] = a.k(d12, d11, 0.54f);
            iArr2[2] = a.k(d12, d11, 0.38f);
            iArr2[3] = a.k(d12, d11, 0.38f);
            this.f٩٧٤٦e = new ColorStateList(iArr, iArr2);
        }
        return this.f٩٧٤٦e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f٩٧٤٧f && c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f٩٧٤٧f = z10;
        if (z10) {
            c.d(this, getMaterialThemeColorsTintList());
        } else {
            c.d(this, null);
        }
    }

    public MaterialRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.radioButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialRadioButton(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, r4), attributeSet, i10);
        int i11 = f٩٧٤٤g;
        Context context2 = getContext();
        TypedArray i12 = h0.i(context2, attributeSet, R.styleable.MaterialRadioButton, i10, i11, new int[0]);
        int i13 = R.styleable.MaterialRadioButton_buttonTint;
        if (i12.hasValue(i13)) {
            c.d(this, c8.c.a(context2, i12, i13));
        }
        this.f٩٧٤٧f = i12.getBoolean(R.styleable.MaterialRadioButton_useMaterialThemeColors, false);
        i12.recycle();
    }
}
