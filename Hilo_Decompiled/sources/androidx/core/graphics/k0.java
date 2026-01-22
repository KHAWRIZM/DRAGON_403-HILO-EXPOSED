package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.content.res.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import k2.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class k0 extends p0 {

    /* renamed from: b, reason: collision with root package name */
    private static Class f٢٨٤٨b;

    /* renamed from: c, reason: collision with root package name */
    private static Constructor f٢٨٤٩c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f٢٨٥٠d;

    /* renamed from: e, reason: collision with root package name */
    private static Method f٢٨٥١e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f٢٨٥٢f;

    private static boolean i(Object obj, String str, int i10, boolean z10) {
        l();
        try {
            return ((Boolean) f٢٨٥٠d.invoke(obj, str, Integer.valueOf(i10), Boolean.valueOf(z10))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    private static Typeface j(Object obj) {
        l();
        try {
            Object newInstance = Array.newInstance((Class<?>) f٢٨٤٨b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f٢٨٥١e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    private File k(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static void l() {
        Method method;
        Class<?> cls;
        Method method2;
        if (f٢٨٥٢f) {
            return;
        }
        f٢٨٥٢f = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e10) {
            Log.e("TypefaceCompatApi21Impl", e10.getClass().getName(), e10);
            method = null;
            cls = null;
            method2 = null;
        }
        f٢٨٤٩c = constructor;
        f٢٨٤٨b = cls;
        f٢٨٥٠d = method2;
        f٢٨٥١e = method;
    }

    private static Object m() {
        l();
        try {
            return f٢٨٤٩c.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override // androidx.core.graphics.p0
    public Typeface a(Context context, e.c cVar, Resources resources, int i10) {
        Object m10 = m();
        for (e.d dVar : cVar.a()) {
            File e10 = q0.e(context);
            if (e10 == null) {
                return null;
            }
            try {
                if (!q0.c(e10, resources, dVar.b())) {
                    return null;
                }
                if (!i(m10, e10.getPath(), dVar.e(), dVar.f())) {
                    return null;
                }
                e10.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                e10.delete();
            }
        }
        return j(m10);
    }

    @Override // androidx.core.graphics.p0
    public Typeface b(Context context, CancellationSignal cancellationSignal, l.b[] bVarArr, int i10) {
        if (bVarArr.length < 1) {
            return null;
        }
        l.b h10 = h(bVarArr, i10);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(h10.d(), "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                File k10 = k(openFileDescriptor);
                if (k10 != null && k10.canRead()) {
                    Typeface createFromFile = Typeface.createFromFile(k10);
                    openFileDescriptor.close();
                    return createFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                try {
                    Typeface d10 = super.d(context, fileInputStream);
                    fileInputStream.close();
                    openFileDescriptor.close();
                    return d10;
                } finally {
                }
            } catch (Throwable th) {
                try {
                    openFileDescriptor.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
