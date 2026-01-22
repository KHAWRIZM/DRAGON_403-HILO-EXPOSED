package com.qmuiteam.qmui.widget.tab;

import android.graphics.Typeface;
import android.view.View;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    boolean f١٣٣٦٨a;

    /* renamed from: b, reason: collision with root package name */
    int f١٣٣٦٩b;

    /* renamed from: c, reason: collision with root package name */
    int f١٣٣٧٠c;

    /* renamed from: d, reason: collision with root package name */
    int f١٣٣٧١d;

    /* renamed from: e, reason: collision with root package name */
    Typeface f١٣٣٧٢e;

    /* renamed from: f, reason: collision with root package name */
    Typeface f١٣٣٧٣f;

    /* renamed from: g, reason: collision with root package name */
    float f١٣٣٧٤g;

    /* renamed from: h, reason: collision with root package name */
    int f١٣٣٧٥h;

    /* renamed from: i, reason: collision with root package name */
    int f١٣٣٧٦i;

    /* renamed from: j, reason: collision with root package name */
    int f١٣٣٧٧j;

    /* renamed from: k, reason: collision with root package name */
    int f١٣٣٧٨k;

    /* renamed from: p, reason: collision with root package name */
    boolean f١٣٣٨٣p;

    /* renamed from: q, reason: collision with root package name */
    boolean f١٣٣٨٤q;

    /* renamed from: r, reason: collision with root package name */
    boolean f١٣٣٨٥r;

    /* renamed from: s, reason: collision with root package name */
    int f١٣٣٨٦s;

    /* renamed from: t, reason: collision with root package name */
    int f١٣٣٨٧t;

    /* renamed from: y, reason: collision with root package name */
    private CharSequence f١٣٣٩٢y;

    /* renamed from: l, reason: collision with root package name */
    int f١٣٣٧٩l = -1;

    /* renamed from: m, reason: collision with root package name */
    int f١٣٣٨٠m = -1;

    /* renamed from: n, reason: collision with root package name */
    float f١٣٣٨١n = 1.0f;

    /* renamed from: o, reason: collision with root package name */
    d f١٣٣٨٢o = null;

    /* renamed from: u, reason: collision with root package name */
    int f١٣٣٨٨u = 0;

    /* renamed from: v, reason: collision with root package name */
    int f١٣٣٨٩v = 0;

    /* renamed from: w, reason: collision with root package name */
    int f١٣٣٩٠w = 1;

    /* renamed from: x, reason: collision with root package name */
    int f١٣٣٩١x = 17;

    /* renamed from: z, reason: collision with root package name */
    int f١٣٣٩٣z = 2;
    int A = 0;

    /* renamed from: B, reason: collision with root package name */
    int f١٣٣٦٧B = 0;
    int C = 0;
    int D = 0;
    float E = DownloadProgress.UNKNOWN_PROGRESS;
    float F = DownloadProgress.UNKNOWN_PROGRESS;
    int G = 0;
    int H = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CharSequence charSequence) {
        this.f١٣٣٩٢y = charSequence;
    }

    public int a() {
        return this.f١٣٣٩٠w;
    }

    public int b() {
        return this.f١٣٣٦٩b;
    }

    public int c(View view) {
        int i10 = this.f١٣٣٧٧j;
        if (i10 == 0) {
            return this.f١٣٣٧٥h;
        }
        return dc.d.a(view, i10);
    }

    public int d() {
        d dVar;
        int i10 = this.f١٣٣٨٠m;
        if (i10 == -1 && (dVar = this.f١٣٣٨٢o) != null) {
            return dVar.getIntrinsicWidth();
        }
        return i10;
    }

    public int e() {
        d dVar;
        int i10 = this.f١٣٣٧٩l;
        if (i10 == -1 && (dVar = this.f١٣٣٨٢o) != null) {
            return dVar.getIntrinsicWidth();
        }
        return i10;
    }

    public int f(View view) {
        int i10 = this.f١٣٣٧٨k;
        if (i10 == 0) {
            return this.f١٣٣٧٦i;
        }
        return dc.d.a(view, i10);
    }

    public float g() {
        return this.f١٣٣٨١n;
    }

    public d h() {
        return this.f١٣٣٨٢o;
    }

    public CharSequence i() {
        return this.f١٣٣٩٢y;
    }

    public boolean j() {
        return this.f١٣٣٦٨a;
    }
}
