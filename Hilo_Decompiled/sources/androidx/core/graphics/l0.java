package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.e;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import k2.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class l0 extends p0 {

    /* renamed from: b, reason: collision with root package name */
    private static final Class f٢٨٥٣b;

    /* renamed from: c, reason: collision with root package name */
    private static final Constructor f٢٨٥٤c;

    /* renamed from: d, reason: collision with root package name */
    private static final Method f٢٨٥٥d;

    /* renamed from: e, reason: collision with root package name */
    private static final Method f٢٨٥٦e;

    static {
        Method method;
        Class<?> cls;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e10) {
            Log.e("TypefaceCompatApi24Impl", e10.getClass().getName(), e10);
            method = null;
            cls = null;
            method2 = null;
        }
        f٢٨٥٤c = constructor;
        f٢٨٥٣b = cls;
        f٢٨٥٥d = method2;
        f٢٨٥٦e = method;
    }

    private static boolean i(Object obj, ByteBuffer byteBuffer, int i10, int i11, boolean z10) {
        try {
            return ((Boolean) f٢٨٥٥d.invoke(obj, byteBuffer, Integer.valueOf(i10), null, Integer.valueOf(i11), Boolean.valueOf(z10))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface j(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) f٢٨٥٣b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f٢٨٥٦e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean k() {
        Method method = f٢٨٥٥d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        if (method != null) {
            return true;
        }
        return false;
    }

    private static Object l() {
        try {
            return f٢٨٥٤c.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.p0
    public Typeface a(Context context, e.c cVar, Resources resources, int i10) {
        Object l10 = l();
        if (l10 == null) {
            return null;
        }
        for (e.d dVar : cVar.a()) {
            ByteBuffer b10 = q0.b(context, resources, dVar.b());
            if (b10 == null || !i(l10, b10, dVar.c(), dVar.e(), dVar.f())) {
                return null;
            }
        }
        return j(l10);
    }

    @Override // androidx.core.graphics.p0
    public Typeface b(Context context, CancellationSignal cancellationSignal, l.b[] bVarArr, int i10) {
        Object l10 = l();
        if (l10 == null) {
            return null;
        }
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        for (l.b bVar : bVarArr) {
            Uri d10 = bVar.d();
            ByteBuffer byteBuffer = (ByteBuffer) simpleArrayMap.get(d10);
            if (byteBuffer == null) {
                byteBuffer = q0.f(context, cancellationSignal, d10);
                simpleArrayMap.put(d10, byteBuffer);
            }
            if (byteBuffer == null || !i(l10, byteBuffer, bVar.c(), bVar.e(), bVar.f())) {
                return null;
            }
        }
        Typeface j10 = j(l10);
        if (j10 == null) {
            return null;
        }
        return Typeface.create(j10, i10);
    }
}
