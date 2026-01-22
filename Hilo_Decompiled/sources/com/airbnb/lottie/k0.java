package com.airbnb.lottie;

import android.graphics.Bitmap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class k0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f٦٢٣٢a;

    /* renamed from: b, reason: collision with root package name */
    private final int f٦٢٣٣b;

    /* renamed from: c, reason: collision with root package name */
    private final String f٦٢٣٤c;

    /* renamed from: d, reason: collision with root package name */
    private final String f٦٢٣٥d;

    /* renamed from: e, reason: collision with root package name */
    private final String f٦٢٣٦e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f٦٢٣٧f;

    public k0(int i10, int i11, String str, String str2, String str3) {
        this.f٦٢٣٢a = i10;
        this.f٦٢٣٣b = i11;
        this.f٦٢٣٤c = str;
        this.f٦٢٣٥d = str2;
        this.f٦٢٣٦e = str3;
    }

    public k0 a(float f10) {
        k0 k0Var = new k0((int) (this.f٦٢٣٢a * f10), (int) (this.f٦٢٣٣b * f10), this.f٦٢٣٤c, this.f٦٢٣٥d, this.f٦٢٣٦e);
        Bitmap bitmap = this.f٦٢٣٧f;
        if (bitmap != null) {
            k0Var.g(Bitmap.createScaledBitmap(bitmap, k0Var.f٦٢٣٢a, k0Var.f٦٢٣٣b, true));
        }
        return k0Var;
    }

    public Bitmap b() {
        return this.f٦٢٣٧f;
    }

    public String c() {
        return this.f٦٢٣٥d;
    }

    public int d() {
        return this.f٦٢٣٣b;
    }

    public String e() {
        return this.f٦٢٣٤c;
    }

    public int f() {
        return this.f٦٢٣٢a;
    }

    public void g(Bitmap bitmap) {
        this.f٦٢٣٧f = bitmap;
    }
}
