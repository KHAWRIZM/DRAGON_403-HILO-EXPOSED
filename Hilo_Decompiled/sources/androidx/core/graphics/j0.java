package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.collection.LruCache;
import androidx.core.content.res.e;
import androidx.core.content.res.h;
import java.util.List;
import k2.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class j0 {

    /* renamed from: a, reason: collision with root package name */
    private static final p0 f٢٨٤٥a;

    /* renamed from: b, reason: collision with root package name */
    private static final LruCache f٢٨٤٦b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a extends l.c {

        /* renamed from: a, reason: collision with root package name */
        private h.e f٢٨٤٧a;

        public a(h.e eVar) {
            this.f٢٨٤٧a = eVar;
        }

        @Override // k2.l.c
        public void a(int i10) {
            h.e eVar = this.f٢٨٤٧a;
            if (eVar != null) {
                eVar.f(i10);
            }
        }

        @Override // k2.l.c
        public void b(Typeface typeface) {
            h.e eVar = this.f٢٨٤٧a;
            if (eVar != null) {
                eVar.g(typeface);
            }
        }
    }

    static {
        h3.a.a("TypefaceCompat static init");
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            f٢٨٤٥a = new o0();
        } else if (i10 >= 28) {
            f٢٨٤٥a = new n0();
        } else if (i10 >= 26) {
            f٢٨٤٥a = new m0();
        } else if (i10 >= 24 && l0.k()) {
            f٢٨٤٥a = new l0();
        } else {
            f٢٨٤٥a = new k0();
        }
        f٢٨٤٦b = new LruCache(16);
        h3.a.b();
    }

    public static Typeface a(Context context, Typeface typeface, int i10) {
        if (context != null) {
            return Typeface.create(typeface, i10);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, l.b[] bVarArr, int i10) {
        h3.a.a("TypefaceCompat.createFromFontInfo");
        try {
            return f٢٨٤٥a.b(context, cancellationSignal, bVarArr, i10);
        } finally {
            h3.a.b();
        }
    }

    public static Typeface c(Context context, CancellationSignal cancellationSignal, List list, int i10) {
        h3.a.a("TypefaceCompat.createFromFontInfoWithFallback");
        try {
            return f٢٨٤٥a.c(context, cancellationSignal, list, i10);
        } finally {
            h3.a.b();
        }
    }

    public static Typeface d(Context context, e.b bVar, Resources resources, int i10, String str, int i11, int i12, h.e eVar, Handler handler, boolean z10) {
        Typeface a10;
        boolean z11;
        int i13;
        List a11;
        if (bVar instanceof e.C٠٠٢٤e) {
            e.C٠٠٢٤e r02 = (e.C٠٠٢٤e) bVar;
            Typeface h10 = h(r02.d());
            if (h10 != null) {
                if (eVar != null) {
                    eVar.d(h10, handler);
                }
                return h10;
            }
            if (!z10 ? eVar == null : r02.b() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z10) {
                i13 = r02.e();
            } else {
                i13 = -1;
            }
            Handler e10 = h.e.e(handler);
            a aVar = new a(eVar);
            if (r02.a() == null) {
                a11 = i0.a(new Object[]{r02.c()});
            } else {
                a11 = i0.a(new Object[]{r02.c(), r02.a()});
            }
            a10 = k2.l.c(context, a11, i12, z11, i13, e10, aVar);
        } else {
            a10 = f٢٨٤٥a.a(context, (e.c) bVar, resources, i12);
            if (eVar != null) {
                if (a10 != null) {
                    eVar.d(a10, handler);
                } else {
                    eVar.c(-3, handler);
                }
            }
        }
        if (a10 != null) {
            f٢٨٤٦b.put(f(resources, i10, str, i11, i12), a10);
        }
        return a10;
    }

    public static Typeface e(Context context, Resources resources, int i10, String str, int i11, int i12) {
        Typeface e10 = f٢٨٤٥a.e(context, resources, i10, str, i12);
        if (e10 != null) {
            f٢٨٤٦b.put(f(resources, i10, str, i11, i12), e10);
        }
        return e10;
    }

    private static String f(Resources resources, int i10, String str, int i11, int i12) {
        return resources.getResourcePackageName(i10) + '-' + str + '-' + i11 + '-' + i10 + '-' + i12;
    }

    public static Typeface g(Resources resources, int i10, String str, int i11, int i12) {
        return (Typeface) f٢٨٤٦b.get(f(resources, i10, str, i11, i12));
    }

    private static Typeface h(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }
}
