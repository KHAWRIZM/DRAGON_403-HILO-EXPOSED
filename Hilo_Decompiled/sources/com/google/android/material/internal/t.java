package com.google.android.material.internal;

import android.animation.TimeInterpolator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class t implements TimeInterpolator {

    /* renamed from: a, reason: collision with root package name */
    private final TimeInterpolator f٩٣٦٦a;

    public t(TimeInterpolator timeInterpolator) {
        this.f٩٣٦٦a = timeInterpolator;
    }

    public static TimeInterpolator a(boolean z10, TimeInterpolator timeInterpolator) {
        if (z10) {
            return timeInterpolator;
        }
        return new t(timeInterpolator);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        return 1.0f - this.f٩٣٦٦a.getInterpolation(f10);
    }
}
