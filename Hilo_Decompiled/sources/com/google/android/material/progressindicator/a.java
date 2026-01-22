package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.google.android.material.R;
import com.google.android.material.internal.h0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public int f٩٥٩٢a;

    /* renamed from: b, reason: collision with root package name */
    public int f٩٥٩٣b;

    /* renamed from: c, reason: collision with root package name */
    public float f٩٥٩٤c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f٩٥٩٥d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f٩٥٩٦e = new int[0];

    /* renamed from: f, reason: collision with root package name */
    public int f٩٥٩٧f;

    /* renamed from: g, reason: collision with root package name */
    public int f٩٥٩٨g;

    /* renamed from: h, reason: collision with root package name */
    public int f٩٥٩٩h;

    /* renamed from: i, reason: collision with root package name */
    public int f٩٦٠٠i;

    /* renamed from: j, reason: collision with root package name */
    public int f٩٦٠١j;

    /* renamed from: k, reason: collision with root package name */
    public int f٩٦٠٢k;

    /* renamed from: l, reason: collision with root package name */
    public int f٩٦٠٣l;

    /* renamed from: m, reason: collision with root package name */
    public int f٩٦٠٤m;

    /* renamed from: n, reason: collision with root package name */
    public float f٩٦٠٥n;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, AttributeSet attributeSet, int i10, int i11) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_track_thickness);
        TypedArray i12 = h0.i(context, attributeSet, R.styleable.BaseProgressIndicator, i10, i11, new int[0]);
        this.f٩٥٩٢a = c8.c.d(context, i12, R.styleable.BaseProgressIndicator_trackThickness, dimensionPixelSize);
        TypedValue peekValue = i12.peekValue(R.styleable.BaseProgressIndicator_trackCornerRadius);
        if (peekValue != null) {
            int i13 = peekValue.type;
            if (i13 == 5) {
                this.f٩٥٩٣b = Math.min(TypedValue.complexToDimensionPixelSize(peekValue.data, i12.getResources().getDisplayMetrics()), this.f٩٥٩٢a / 2);
                this.f٩٥٩٥d = false;
            } else if (i13 == 6) {
                this.f٩٥٩٤c = Math.min(peekValue.getFraction(1.0f, 1.0f), 0.5f);
                this.f٩٥٩٥d = true;
            }
        }
        this.f٩٥٩٨g = i12.getInt(R.styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.f٩٥٩٩h = i12.getInt(R.styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        this.f٩٦٠٠i = i12.getDimensionPixelSize(R.styleable.BaseProgressIndicator_indicatorTrackGapSize, 0);
        int abs = Math.abs(i12.getDimensionPixelSize(R.styleable.BaseProgressIndicator_wavelength, 0));
        this.f٩٦٠١j = Math.abs(i12.getDimensionPixelSize(R.styleable.BaseProgressIndicator_wavelengthDeterminate, abs));
        this.f٩٦٠٢k = Math.abs(i12.getDimensionPixelSize(R.styleable.BaseProgressIndicator_wavelengthIndeterminate, abs));
        this.f٩٦٠٣l = Math.abs(i12.getDimensionPixelSize(R.styleable.BaseProgressIndicator_waveAmplitude, 0));
        this.f٩٦٠٤m = i12.getDimensionPixelSize(R.styleable.BaseProgressIndicator_waveSpeed, 0);
        this.f٩٦٠٥n = i12.getFloat(R.styleable.BaseProgressIndicator_indeterminateAnimatorDurationScale, 1.0f);
        e(context, i12);
        f(context, i12);
        i12.recycle();
    }

    private void e(Context context, TypedArray typedArray) {
        int i10 = R.styleable.BaseProgressIndicator_indicatorColor;
        if (!typedArray.hasValue(i10)) {
            this.f٩٥٩٦e = new int[]{v7.a.b(context, androidx.appcompat.R.attr.colorPrimary, -1)};
            return;
        }
        if (typedArray.peekValue(i10).type != 1) {
            this.f٩٥٩٦e = new int[]{typedArray.getColor(i10, -1)};
            return;
        }
        int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(i10, -1));
        this.f٩٥٩٦e = intArray;
        if (intArray.length != 0) {
        } else {
            throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
        }
    }

    private void f(Context context, TypedArray typedArray) {
        int i10 = R.styleable.BaseProgressIndicator_trackColor;
        if (typedArray.hasValue(i10)) {
            this.f٩٥٩٧f = typedArray.getColor(i10, -1);
            return;
        }
        this.f٩٥٩٧f = this.f٩٥٩٦e[0];
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.disabledAlpha});
        float f10 = obtainStyledAttributes.getFloat(0, 0.2f);
        obtainStyledAttributes.recycle();
        this.f٩٥٩٧f = v7.a.a(this.f٩٥٩٧f, (int) (f10 * 255.0f));
    }

    public int a() {
        if (this.f٩٥٩٥d) {
            return (int) (this.f٩٥٩٢a * this.f٩٥٩٤c);
        }
        return this.f٩٥٩٣b;
    }

    public boolean b(boolean z10) {
        if (this.f٩٦٠٣l > 0 && ((!z10 && this.f٩٦٠٢k > 0) || (z10 && this.f٩٦٠١j > 0))) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f٩٥٩٩h != 0) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f٩٥٩٨g != 0) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f٩٥٩٥d && this.f٩٥٩٤c == 0.5f) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (this.f٩٦٠٠i >= 0) {
        } else {
            throw new IllegalArgumentException("indicatorTrackGapSize must be >= 0.");
        }
    }
}
