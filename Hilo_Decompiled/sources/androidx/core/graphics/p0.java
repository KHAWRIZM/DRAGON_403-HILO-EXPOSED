package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.core.content.res.e;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import k2.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class p0 {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap f٢٨٦٤a = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a implements b {
        a() {
        }

        @Override // androidx.core.graphics.p0.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(l.b bVar) {
            return bVar.e();
        }

        @Override // androidx.core.graphics.p0.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(l.b bVar) {
            return bVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface b {
        boolean a(Object obj);

        int b(Object obj);
    }

    private static Object f(Object[] objArr, int i10, b bVar) {
        int i11;
        boolean z10;
        if ((i10 & 1) == 0) {
            i11 = 400;
        } else {
            i11 = 700;
        }
        if ((i10 & 2) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        return g(objArr, i11, z10, bVar);
    }

    private static Object g(Object[] objArr, int i10, boolean z10, b bVar) {
        int i11;
        Object obj = null;
        int i12 = Integer.MAX_VALUE;
        for (Object obj2 : objArr) {
            int abs = Math.abs(bVar.b(obj2) - i10) * 2;
            if (bVar.a(obj2) == z10) {
                i11 = 0;
            } else {
                i11 = 1;
            }
            int i13 = abs + i11;
            if (obj == null || i12 > i13) {
                obj = obj2;
                i12 = i13;
            }
        }
        return obj;
    }

    public abstract Typeface a(Context context, e.c cVar, Resources resources, int i10);

    public abstract Typeface b(Context context, CancellationSignal cancellationSignal, l.b[] bVarArr, int i10);

    public Typeface c(Context context, CancellationSignal cancellationSignal, List list, int i10) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Typeface d(Context context, InputStream inputStream) {
        File e10 = q0.e(context);
        if (e10 == null) {
            return null;
        }
        try {
            if (!q0.d(e10, inputStream)) {
                return null;
            }
            return Typeface.createFromFile(e10.getPath());
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e10.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i10, String str, int i11) {
        File e10 = q0.e(context);
        if (e10 == null) {
            return null;
        }
        try {
            if (!q0.c(e10, resources, i10)) {
                return null;
            }
            return Typeface.createFromFile(e10.getPath());
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e10.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public l.b h(l.b[] bVarArr, int i10) {
        return (l.b) f(bVarArr, i10, new a());
    }
}
