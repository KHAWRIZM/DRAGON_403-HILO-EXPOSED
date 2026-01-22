package com.airbnb.lottie;

import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    private final Object f٦٢٧٣a;

    /* renamed from: b, reason: collision with root package name */
    private final Throwable f٦٢٧٤b;

    public o0(Object obj) {
        this.f٦٢٧٣a = obj;
        this.f٦٢٧٤b = null;
    }

    public Throwable a() {
        return this.f٦٢٧٤b;
    }

    public Object b() {
        return this.f٦٢٧٣a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        if (b() != null && b().equals(o0Var.b())) {
            return true;
        }
        if (a() == null || o0Var.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public o0(Throwable th) {
        this.f٦٢٧٤b = th;
        this.f٦٢٧٣a = null;
    }
}
