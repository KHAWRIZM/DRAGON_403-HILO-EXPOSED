package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.lang.reflect.Constructor;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class c0 {

    /* renamed from: o, reason: collision with root package name */
    static final int f٩٢٧١o;

    /* renamed from: p, reason: collision with root package name */
    private static boolean f٩٢٧٢p;

    /* renamed from: q, reason: collision with root package name */
    private static Constructor f٩٢٧٣q;

    /* renamed from: r, reason: collision with root package name */
    private static Object f٩٢٧٤r;

    /* renamed from: a, reason: collision with root package name */
    private CharSequence f٩٢٧٥a;

    /* renamed from: b, reason: collision with root package name */
    private final TextPaint f٩٢٧٦b;

    /* renamed from: c, reason: collision with root package name */
    private final int f٩٢٧٧c;

    /* renamed from: e, reason: collision with root package name */
    private int f٩٢٧٩e;

    /* renamed from: l, reason: collision with root package name */
    private boolean f٩٢٨٦l;

    /* renamed from: n, reason: collision with root package name */
    private d0 f٩٢٨٨n;

    /* renamed from: d, reason: collision with root package name */
    private int f٩٢٧٨d = 0;

    /* renamed from: f, reason: collision with root package name */
    private Layout.Alignment f٩٢٨٠f = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: g, reason: collision with root package name */
    private int f٩٢٨١g = Integer.MAX_VALUE;

    /* renamed from: h, reason: collision with root package name */
    private float f٩٢٨٢h = DownloadProgress.UNKNOWN_PROGRESS;

    /* renamed from: i, reason: collision with root package name */
    private float f٩٢٨٣i = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    private int f٩٢٨٤j = f٩٢٧١o;

    /* renamed from: k, reason: collision with root package name */
    private boolean f٩٢٨٥k = true;

    /* renamed from: m, reason: collision with root package name */
    private TextUtils.TruncateAt f٩٢٨٧m = null;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a extends Exception {
        a(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    static {
        int i10;
        if (Build.VERSION.SDK_INT >= 23) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        f٩٢٧١o = i10;
    }

    private c0(CharSequence charSequence, TextPaint textPaint, int i10) {
        this.f٩٢٧٥a = charSequence;
        this.f٩٢٧٦b = textPaint;
        this.f٩٢٧٧c = i10;
        this.f٩٢٧٩e = charSequence.length();
    }

    private void b() {
        boolean z10;
        TextDirectionHeuristic textDirectionHeuristic;
        if (f٩٢٧٢p) {
            return;
        }
        try {
            if (this.f٩٢٨٦l && Build.VERSION.SDK_INT >= 23) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                textDirectionHeuristic = TextDirectionHeuristics.RTL;
            } else {
                textDirectionHeuristic = TextDirectionHeuristics.LTR;
            }
            f٩٢٧٤r = textDirectionHeuristic;
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Constructor declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
            f٩٢٧٣q = declaredConstructor;
            declaredConstructor.setAccessible(true);
            f٩٢٧٢p = true;
        } catch (Exception e10) {
            throw new a(e10);
        }
    }

    public static c0 c(CharSequence charSequence, TextPaint textPaint, int i10) {
        return new c0(charSequence, textPaint, i10);
    }

    public StaticLayout a() {
        StaticLayout.Builder obtain;
        TextDirectionHeuristic textDirectionHeuristic;
        StaticLayout build;
        if (this.f٩٢٧٥a == null) {
            this.f٩٢٧٥a = "";
        }
        int max = Math.max(0, this.f٩٢٧٧c);
        CharSequence charSequence = this.f٩٢٧٥a;
        if (this.f٩٢٨١g == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f٩٢٧٦b, max, this.f٩٢٨٧m);
        }
        int min = Math.min(charSequence.length(), this.f٩٢٧٩e);
        this.f٩٢٧٩e = min;
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.f٩٢٨٦l && this.f٩٢٨١g == 1) {
                this.f٩٢٨٠f = Layout.Alignment.ALIGN_OPPOSITE;
            }
            obtain = StaticLayout.Builder.obtain(charSequence, this.f٩٢٧٨d, min, this.f٩٢٧٦b, max);
            obtain.setAlignment(this.f٩٢٨٠f);
            obtain.setIncludePad(this.f٩٢٨٥k);
            if (this.f٩٢٨٦l) {
                textDirectionHeuristic = TextDirectionHeuristics.RTL;
            } else {
                textDirectionHeuristic = TextDirectionHeuristics.LTR;
            }
            obtain.setTextDirection(textDirectionHeuristic);
            TextUtils.TruncateAt truncateAt = this.f٩٢٨٧m;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.f٩٢٨١g);
            float f10 = this.f٩٢٨٢h;
            if (f10 != DownloadProgress.UNKNOWN_PROGRESS || this.f٩٢٨٣i != 1.0f) {
                obtain.setLineSpacing(f10, this.f٩٢٨٣i);
            }
            if (this.f٩٢٨١g > 1) {
                obtain.setHyphenationFrequency(this.f٩٢٨٤j);
            }
            d0 d0Var = this.f٩٢٨٨n;
            if (d0Var != null) {
                d0Var.a(obtain);
            }
            build = obtain.build();
            return build;
        }
        b();
        try {
            return (StaticLayout) ((Constructor) androidx.core.util.h.g(f٩٢٧٣q)).newInstance(charSequence, Integer.valueOf(this.f٩٢٧٨d), Integer.valueOf(this.f٩٢٧٩e), this.f٩٢٧٦b, Integer.valueOf(max), this.f٩٢٨٠f, androidx.core.util.h.g(f٩٢٧٤r), Float.valueOf(1.0f), Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS), Boolean.valueOf(this.f٩٢٨٥k), null, Integer.valueOf(max), Integer.valueOf(this.f٩٢٨١g));
        } catch (Exception e10) {
            throw new a(e10);
        }
    }

    public c0 d(Layout.Alignment alignment) {
        this.f٩٢٨٠f = alignment;
        return this;
    }

    public c0 e(TextUtils.TruncateAt truncateAt) {
        this.f٩٢٨٧m = truncateAt;
        return this;
    }

    public c0 f(int i10) {
        this.f٩٢٨٤j = i10;
        return this;
    }

    public c0 g(boolean z10) {
        this.f٩٢٨٥k = z10;
        return this;
    }

    public c0 h(boolean z10) {
        this.f٩٢٨٦l = z10;
        return this;
    }

    public c0 i(float f10, float f11) {
        this.f٩٢٨٢h = f10;
        this.f٩٢٨٣i = f11;
        return this;
    }

    public c0 j(int i10) {
        this.f٩٢٨١g = i10;
        return this;
    }

    public c0 k(d0 d0Var) {
        this.f٩٢٨٨n = d0Var;
        return this;
    }
}
