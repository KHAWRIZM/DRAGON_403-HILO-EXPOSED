package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.content.res.e;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import k2.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class m0 extends k0 {

    /* renamed from: g, reason: collision with root package name */
    protected final Class f٢٨٥٧g;

    /* renamed from: h, reason: collision with root package name */
    protected final Constructor f٢٨٥٨h;

    /* renamed from: i, reason: collision with root package name */
    protected final Method f٢٨٥٩i;

    /* renamed from: j, reason: collision with root package name */
    protected final Method f٢٨٦٠j;

    /* renamed from: k, reason: collision with root package name */
    protected final Method f٢٨٦١k;

    /* renamed from: l, reason: collision with root package name */
    protected final Method f٢٨٦٢l;

    /* renamed from: m, reason: collision with root package name */
    protected final Method f٢٨٦٣m;

    public m0() {
        Class cls;
        Constructor constructor;
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        try {
            cls = w();
            constructor = x(cls);
            method = t(cls);
            method2 = u(cls);
            method3 = y(cls);
            method4 = s(cls);
            method5 = v(cls);
        } catch (ClassNotFoundException | NoSuchMethodException e10) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e10.getClass().getName(), e10);
            cls = null;
            constructor = null;
            method = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f٢٨٥٧g = cls;
        this.f٢٨٥٨h = constructor;
        this.f٢٨٥٩i = method;
        this.f٢٨٦٠j = method2;
        this.f٢٨٦١k = method3;
        this.f٢٨٦٢l = method4;
        this.f٢٨٦٣m = method5;
    }

    private Object m() {
        try {
            return this.f٢٨٥٨h.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private void n(Object obj) {
        try {
            this.f٢٨٦٢l.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean o(Context context, Object obj, String str, int i10, int i11, int i12, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f٢٨٥٩i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean p(Object obj, ByteBuffer byteBuffer, int i10, int i11, int i12) {
        try {
            return ((Boolean) this.f٢٨٦٠j.invoke(obj, byteBuffer, Integer.valueOf(i10), null, Integer.valueOf(i11), Integer.valueOf(i12))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean q(Object obj) {
        try {
            return ((Boolean) this.f٢٨٦١k.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean r() {
        if (this.f٢٨٥٩i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (this.f٢٨٥٩i != null) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.graphics.k0, androidx.core.graphics.p0
    public Typeface a(Context context, e.c cVar, Resources resources, int i10) {
        if (!r()) {
            return super.a(context, cVar, resources, i10);
        }
        Object m10 = m();
        if (m10 == null) {
            return null;
        }
        for (e.d dVar : cVar.a()) {
            if (!o(context, m10, dVar.a(), dVar.c(), dVar.e(), dVar.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(dVar.d()))) {
                n(m10);
                return null;
            }
        }
        if (!q(m10)) {
            return null;
        }
        return j(m10);
    }

    @Override // androidx.core.graphics.k0, androidx.core.graphics.p0
    public Typeface b(Context context, CancellationSignal cancellationSignal, l.b[] bVarArr, int i10) {
        Typeface j10;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!r()) {
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
                    Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(h10.e()).setItalic(h10.f()).build();
                    openFileDescriptor.close();
                    return build;
                } finally {
                }
            } catch (IOException unused) {
                return null;
            }
        }
        Map h11 = q0.h(context, bVarArr, cancellationSignal);
        Object m10 = m();
        if (m10 == null) {
            return null;
        }
        boolean z10 = false;
        for (l.b bVar : bVarArr) {
            ByteBuffer byteBuffer = (ByteBuffer) h11.get(bVar.d());
            if (byteBuffer != null) {
                if (!p(m10, byteBuffer, bVar.c(), bVar.e(), bVar.f() ? 1 : 0)) {
                    n(m10);
                    return null;
                }
                z10 = true;
            }
        }
        if (!z10) {
            n(m10);
            return null;
        }
        if (!q(m10) || (j10 = j(m10)) == null) {
            return null;
        }
        return Typeface.create(j10, i10);
    }

    @Override // androidx.core.graphics.p0
    public /* bridge */ /* synthetic */ Typeface c(Context context, CancellationSignal cancellationSignal, List list, int i10) {
        return super.c(context, cancellationSignal, list, i10);
    }

    @Override // androidx.core.graphics.p0
    public Typeface e(Context context, Resources resources, int i10, String str, int i11) {
        if (!r()) {
            return super.e(context, resources, i10, str, i11);
        }
        Object m10 = m();
        if (m10 == null) {
            return null;
        }
        if (!o(context, m10, str, 0, -1, -1, null)) {
            n(m10);
            return null;
        }
        if (!q(m10)) {
            return null;
        }
        return j(m10);
    }

    protected Typeface j(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) this.f٢٨٥٧g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f٢٨٦٣m.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    protected Method s(Class cls) {
        return cls.getMethod("abortCreation", null);
    }

    protected Method t(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    protected Method u(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    protected Method v(Class cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance((Class<?>) cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    protected Class w() {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Constructor x(Class cls) {
        return cls.getConstructor(null);
    }

    protected Method y(Class cls) {
        return cls.getMethod("freeze", null);
    }
}
