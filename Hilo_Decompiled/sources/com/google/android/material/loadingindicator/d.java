package com.google.android.material.loadingindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.internal.h0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    boolean f٩٣٩٧a;

    /* renamed from: b, reason: collision with root package name */
    int f٩٣٩٨b;

    /* renamed from: c, reason: collision with root package name */
    int f٩٣٩٩c;

    /* renamed from: d, reason: collision with root package name */
    int f٩٤٠٠d;

    /* renamed from: e, reason: collision with root package name */
    int[] f٩٤٠١e;

    /* renamed from: f, reason: collision with root package name */
    int f٩٤٠٢f;

    public d(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, LoadingIndicator.f٩٣٦٧c);
    }

    private void a(Context context, TypedArray typedArray) {
        int i10 = R.styleable.LoadingIndicator_indicatorColor;
        if (!typedArray.hasValue(i10)) {
            this.f٩٤٠١e = new int[]{v7.a.b(context, androidx.appcompat.R.attr.colorPrimary, -1)};
            return;
        }
        if (typedArray.peekValue(i10).type != 1) {
            this.f٩٤٠١e = new int[]{typedArray.getColor(i10, -1)};
            return;
        }
        int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(i10, -1));
        this.f٩٤٠١e = intArray;
        if (intArray.length != 0) {
        } else {
            throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
        }
    }

    public d(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f٩٣٩٧a = false;
        this.f٩٤٠١e = new int[0];
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.m3_loading_indicator_shape_size);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.m3_loading_indicator_container_size);
        TypedArray i12 = h0.i(context, attributeSet, R.styleable.LoadingIndicator, i10, i11, new int[0]);
        this.f٩٣٩٨b = i12.getDimensionPixelSize(R.styleable.LoadingIndicator_indicatorSize, dimensionPixelSize);
        this.f٩٣٩٩c = i12.getDimensionPixelSize(R.styleable.LoadingIndicator_containerWidth, dimensionPixelSize2);
        this.f٩٤٠٠d = i12.getDimensionPixelSize(R.styleable.LoadingIndicator_containerHeight, dimensionPixelSize2);
        a(context, i12);
        this.f٩٤٠٢f = i12.getColor(R.styleable.LoadingIndicator_containerColor, 0);
        i12.recycle();
    }
}
