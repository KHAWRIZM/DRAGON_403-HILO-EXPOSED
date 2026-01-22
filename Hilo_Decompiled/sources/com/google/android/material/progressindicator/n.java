package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.google.android.material.R;
import com.google.android.material.internal.h0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class n extends a {

    /* renamed from: o, reason: collision with root package name */
    public int f٩٧٣٥o;

    /* renamed from: p, reason: collision with root package name */
    public int f٩٧٣٦p;

    /* renamed from: q, reason: collision with root package name */
    boolean f٩٧٣٧q;

    /* renamed from: r, reason: collision with root package name */
    public int f٩٧٣٨r;

    /* renamed from: s, reason: collision with root package name */
    public Integer f٩٧٣٩s;

    /* renamed from: t, reason: collision with root package name */
    public int f٩٧٤٠t;

    /* renamed from: u, reason: collision with root package name */
    public float f٩٧٤١u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f٩٧٤٢v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f٩٧٤٣w;

    public n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    @Override // com.google.android.material.progressindicator.a
    public boolean g() {
        if (super.g() && i() == a()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.a
    public void h() {
        super.h();
        if (this.f٩٧٣٨r >= 0) {
            if (this.f٩٧٣٥o == 0) {
                if ((a() <= 0 && (!this.f٩٧٤٣w || i() <= 0)) || this.f٩٦٠٠i != 0) {
                    if (this.f٩٥٩٦e.length < 3) {
                        throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
                    }
                    return;
                }
                throw new IllegalArgumentException("Rounded corners without gap are not supported in contiguous indeterminate animation.");
            }
            return;
        }
        throw new IllegalArgumentException("Stop indicator size must be >= 0.");
    }

    public int i() {
        if (!this.f٩٧٤٣w) {
            return a();
        }
        if (this.f٩٧٤٢v) {
            return (int) (this.f٩٥٩٢a * this.f٩٧٤١u);
        }
        return this.f٩٧٤٠t;
    }

    public n(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, LinearProgressIndicator.f٩٥٩١q);
    }

    public n(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray i12 = h0.i(context, attributeSet, R.styleable.LinearProgressIndicator, R.attr.linearProgressIndicatorStyle, LinearProgressIndicator.f٩٥٩١q, new int[0]);
        this.f٩٧٣٥o = i12.getInt(R.styleable.LinearProgressIndicator_indeterminateAnimationType, 1);
        this.f٩٧٣٦p = i12.getInt(R.styleable.LinearProgressIndicator_indicatorDirectionLinear, 0);
        this.f٩٧٣٨r = Math.min(i12.getDimensionPixelSize(R.styleable.LinearProgressIndicator_trackStopIndicatorSize, 0), this.f٩٥٩٢a);
        int i13 = R.styleable.LinearProgressIndicator_trackStopIndicatorPadding;
        if (i12.hasValue(i13)) {
            this.f٩٧٣٩s = Integer.valueOf(i12.getDimensionPixelSize(i13, 0));
        }
        TypedValue peekValue = i12.peekValue(R.styleable.LinearProgressIndicator_trackInnerCornerRadius);
        if (peekValue != null) {
            int i14 = peekValue.type;
            if (i14 == 5) {
                this.f٩٧٤٠t = Math.min(TypedValue.complexToDimensionPixelSize(peekValue.data, i12.getResources().getDisplayMetrics()), this.f٩٥٩٢a / 2);
                this.f٩٧٤٢v = false;
                this.f٩٧٤٣w = true;
            } else if (i14 == 6) {
                this.f٩٧٤١u = Math.min(peekValue.getFraction(1.0f, 1.0f), 0.5f);
                this.f٩٧٤٢v = true;
                this.f٩٧٤٣w = true;
            }
        }
        i12.recycle();
        h();
        this.f٩٧٣٧q = this.f٩٧٣٦p == 1;
    }
}
