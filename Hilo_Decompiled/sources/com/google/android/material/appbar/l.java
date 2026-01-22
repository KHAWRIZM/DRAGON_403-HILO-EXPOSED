package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.d1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private final View f٨٢٣٢a;

    /* renamed from: b, reason: collision with root package name */
    private int f٨٢٣٣b;

    /* renamed from: c, reason: collision with root package name */
    private int f٨٢٣٤c;

    /* renamed from: d, reason: collision with root package name */
    private int f٨٢٣٥d;

    /* renamed from: e, reason: collision with root package name */
    private int f٨٢٣٦e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f٨٢٣٧f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f٨٢٣٨g = true;

    public l(View view) {
        this.f٨٢٣٢a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        View view = this.f٨٢٣٢a;
        d1.b0(view, this.f٨٢٣٥d - (view.getTop() - this.f٨٢٣٣b));
        View view2 = this.f٨٢٣٢a;
        d1.a0(view2, this.f٨٢٣٦e - (view2.getLeft() - this.f٨٢٣٤c));
    }

    public int b() {
        return this.f٨٢٣٣b;
    }

    public int c() {
        return this.f٨٢٣٥d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.f٨٢٣٣b = this.f٨٢٣٢a.getTop();
        this.f٨٢٣٤c = this.f٨٢٣٢a.getLeft();
    }

    public boolean e(int i10) {
        if (this.f٨٢٣٨g && this.f٨٢٣٦e != i10) {
            this.f٨٢٣٦e = i10;
            a();
            return true;
        }
        return false;
    }

    public boolean f(int i10) {
        if (this.f٨٢٣٧f && this.f٨٢٣٥d != i10) {
            this.f٨٢٣٥d = i10;
            a();
            return true;
        }
        return false;
    }
}
