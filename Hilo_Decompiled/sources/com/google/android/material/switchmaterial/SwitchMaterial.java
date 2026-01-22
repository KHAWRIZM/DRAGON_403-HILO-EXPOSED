package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.R;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.k0;
import x7.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SwitchMaterial extends SwitchCompat {

    /* renamed from: b0, reason: collision with root package name */
    private static final int f١٠٠١٦b0 = R.style.Widget_MaterialComponents_CompoundButton_Switch;

    /* renamed from: c0, reason: collision with root package name */
    private static final int[][] f١٠٠١٧c0 = {new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
    private final a U;
    private ColorStateList V;
    private ColorStateList W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f١٠٠١٨a0;

    public SwitchMaterial(Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.V == null) {
            int d10 = v7.a.d(this, R.attr.colorSurface);
            int d11 = v7.a.d(this, androidx.appcompat.R.attr.colorControlActivated);
            float dimension = getResources().getDimension(R.dimen.mtrl_switch_thumb_elevation);
            if (this.U.e()) {
                dimension += k0.k(this);
            }
            int c10 = this.U.c(d10, dimension);
            int[][] iArr = f١٠٠١٧c0;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = v7.a.k(d10, d11, 1.0f);
            iArr2[1] = c10;
            iArr2[2] = v7.a.k(d10, d11, 0.38f);
            iArr2[3] = c10;
            this.V = new ColorStateList(iArr, iArr2);
        }
        return this.V;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.W == null) {
            int[][] iArr = f١٠٠١٧c0;
            int[] iArr2 = new int[iArr.length];
            int d10 = v7.a.d(this, R.attr.colorSurface);
            int d11 = v7.a.d(this, androidx.appcompat.R.attr.colorControlActivated);
            int d12 = v7.a.d(this, R.attr.colorOnSurface);
            iArr2[0] = v7.a.k(d10, d11, 0.54f);
            iArr2[1] = v7.a.k(d10, d12, 0.32f);
            iArr2[2] = v7.a.k(d10, d11, 0.12f);
            iArr2[3] = v7.a.k(d10, d12, 0.12f);
            this.W = new ColorStateList(iArr, iArr2);
        }
        return this.W;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f١٠٠١٨a0 && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.f١٠٠١٨a0 && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f١٠٠١٨a0 = z10;
        if (z10) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }

    public SwitchMaterial(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.switchStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SwitchMaterial(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, r4), attributeSet, i10);
        int i11 = f١٠٠١٦b0;
        Context context2 = getContext();
        this.U = new a(context2);
        TypedArray i12 = h0.i(context2, attributeSet, R.styleable.SwitchMaterial, i10, i11, new int[0]);
        this.f١٠٠١٨a0 = i12.getBoolean(R.styleable.SwitchMaterial_useMaterialThemeColors, false);
        i12.recycle();
    }
}
