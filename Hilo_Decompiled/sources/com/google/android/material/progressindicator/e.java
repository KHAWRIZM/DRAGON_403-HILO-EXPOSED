package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.internal.h0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class e extends a {

    /* renamed from: o, reason: collision with root package name */
    public int f٩٦٤٨o;

    /* renamed from: p, reason: collision with root package name */
    public int f٩٦٤٩p;

    /* renamed from: q, reason: collision with root package name */
    public int f٩٦٥٠q;

    /* renamed from: r, reason: collision with root package name */
    public int f٩٦٥١r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f٩٦٥٢s;

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.circularProgressIndicatorStyle);
    }

    public e(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, CircularProgressIndicator.f٩٥٩٠q);
    }

    public e(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_inset_medium);
        TypedArray i12 = h0.i(context, attributeSet, R.styleable.CircularProgressIndicator, i10, i11, new int[0]);
        this.f٩٦٤٨o = i12.getInt(R.styleable.CircularProgressIndicator_indeterminateAnimationTypeCircular, 0);
        this.f٩٦٤٩p = Math.max(c8.c.d(context, i12, R.styleable.CircularProgressIndicator_indicatorSize, dimensionPixelSize), this.f٩٥٩٢a * 2);
        this.f٩٦٥٠q = c8.c.d(context, i12, R.styleable.CircularProgressIndicator_indicatorInset, dimensionPixelSize2);
        this.f٩٦٥١r = i12.getInt(R.styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        this.f٩٦٥٢s = i12.getBoolean(R.styleable.CircularProgressIndicator_indeterminateTrackVisible, true);
        i12.recycle();
        h();
    }
}
