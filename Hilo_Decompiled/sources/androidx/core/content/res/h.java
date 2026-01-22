package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.content.res.e;
import androidx.core.content.res.h;
import androidx.core.graphics.j0;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f٢٧٦٦a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    private static final WeakHashMap f٢٧٦٧b = new WeakHashMap(0);

    /* renamed from: c, reason: collision with root package name */
    private static final Object f٢٧٦٨c = new Object();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class a {
        static Drawable a(Resources resources, int i10, Resources.Theme theme) {
            return resources.getDrawable(i10, theme);
        }

        static Drawable b(Resources resources, int i10, int i11, Resources.Theme theme) {
            return resources.getDrawableForDensity(i10, i11, theme);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b {
        static int a(Resources resources, int i10, Resources.Theme theme) {
            return resources.getColor(i10, theme);
        }

        static ColorStateList b(Resources resources, int i10, Resources.Theme theme) {
            return resources.getColorStateList(i10, theme);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final ColorStateList f٢٧٦٩a;

        /* renamed from: b, reason: collision with root package name */
        final Configuration f٢٧٧٠b;

        /* renamed from: c, reason: collision with root package name */
        final int f٢٧٧١c;

        c(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            int hashCode;
            this.f٢٧٦٩a = colorStateList;
            this.f٢٧٧٠b = configuration;
            if (theme == null) {
                hashCode = 0;
            } else {
                hashCode = theme.hashCode();
            }
            this.f٢٧٧١c = hashCode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        final Resources f٢٧٧٢a;

        /* renamed from: b, reason: collision with root package name */
        final Resources.Theme f٢٧٧٣b;

        d(Resources resources, Resources.Theme theme) {
            this.f٢٧٧٢a = resources;
            this.f٢٧٧٣b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f٢٧٧٢a.equals(dVar.f٢٧٧٢a) && androidx.core.util.f.a(this.f٢٧٧٣b, dVar.f٢٧٧٣b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return androidx.core.util.f.b(this.f٢٧٧٢a, this.f٢٧٧٣b);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class e {
        public static Handler e(Handler handler) {
            if (handler == null) {
                return new Handler(Looper.getMainLooper());
            }
            return handler;
        }

        public final void c(final int i10, Handler handler) {
            e(handler).post(new Runnable() { // from class: androidx.core.content.res.j
                @Override // java.lang.Runnable
                public final void run() {
                    h.e.this.f(i10);
                }
            });
        }

        public final void d(final Typeface typeface, Handler handler) {
            e(handler).post(new Runnable() { // from class: androidx.core.content.res.i
                @Override // java.lang.Runnable
                public final void run() {
                    h.e.this.g(typeface);
                }
            });
        }

        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public abstract void f(int i10);

        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public abstract void g(Typeface typeface);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class f {

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        static class a {

            /* renamed from: a, reason: collision with root package name */
            private static final Object f٢٧٧٤a = new Object();

            /* renamed from: b, reason: collision with root package name */
            private static Method f٢٧٧٥b;

            /* renamed from: c, reason: collision with root package name */
            private static boolean f٢٧٧٦c;

            static void a(Resources.Theme theme) {
                synchronized (f٢٧٧٤a) {
                    if (!f٢٧٧٦c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", null);
                            f٢٧٧٥b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e10) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e10);
                        }
                        f٢٧٧٦c = true;
                    }
                    Method method = f٢٧٧٥b;
                    if (method != null) {
                        try {
                            method.invoke(theme, null);
                        } catch (IllegalAccessException | InvocationTargetException e11) {
                            Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e11);
                            f٢٧٧٥b = null;
                        }
                    }
                }
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        static class b {
            static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(Resources.Theme theme) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 29) {
                b.a(theme);
            } else if (i10 >= 23) {
                a.a(theme);
            }
        }
    }

    private static void a(d dVar, int i10, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f٢٧٦٨c) {
            try {
                WeakHashMap weakHashMap = f٢٧٦٧b;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(dVar);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(dVar, sparseArray);
                }
                sparseArray.append(i10, new c(colorStateList, dVar.f٢٧٧٢a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
    
        if (r2.f٢٧٧١c == r5.hashCode()) goto L٢٢;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ColorStateList b(d dVar, int i10) {
        c cVar;
        synchronized (f٢٧٦٨c) {
            try {
                SparseArray sparseArray = (SparseArray) f٢٧٦٧b.get(dVar);
                if (sparseArray != null && sparseArray.size() > 0 && (cVar = (c) sparseArray.get(i10)) != null) {
                    if (cVar.f٢٧٧٠b.equals(dVar.f٢٧٧٢a.getConfiguration())) {
                        Resources.Theme theme = dVar.f٢٧٧٣b;
                        if (theme == null) {
                            if (cVar.f٢٧٧١c != 0) {
                            }
                            return cVar.f٢٧٦٩a;
                        }
                        if (theme != null) {
                        }
                    }
                    sparseArray.remove(i10);
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Typeface c(Context context, int i10) {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i10, new TypedValue(), 0, null, null, false, true);
    }

    public static int d(Resources resources, int i10, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 23) {
            return b.a(resources, i10, theme);
        }
        return resources.getColor(i10);
    }

    public static ColorStateList e(Resources resources, int i10, Resources.Theme theme) {
        d dVar = new d(resources, theme);
        ColorStateList b10 = b(dVar, i10);
        if (b10 != null) {
            return b10;
        }
        ColorStateList l10 = l(resources, i10, theme);
        if (l10 != null) {
            a(dVar, i10, l10, theme);
            return l10;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return b.b(resources, i10, theme);
        }
        return resources.getColorStateList(i10);
    }

    public static Drawable f(Resources resources, int i10, Resources.Theme theme) {
        return a.a(resources, i10, theme);
    }

    public static Drawable g(Resources resources, int i10, int i11, Resources.Theme theme) {
        return a.b(resources, i10, i11, theme);
    }

    public static Typeface h(Context context, int i10) {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i10, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface i(Context context, int i10, TypedValue typedValue, int i11, e eVar) {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i10, typedValue, i11, eVar, null, true, false);
    }

    public static void j(Context context, int i10, e eVar, Handler handler) {
        androidx.core.util.h.g(eVar);
        if (context.isRestricted()) {
            eVar.c(-4, handler);
        } else {
            n(context, i10, new TypedValue(), 0, eVar, handler, false, false);
        }
    }

    private static TypedValue k() {
        ThreadLocal threadLocal = f٢٧٦٦a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    private static ColorStateList l(Resources resources, int i10, Resources.Theme theme) {
        if (m(resources, i10)) {
            return null;
        }
        try {
            return androidx.core.content.res.c.a(resources, resources.getXml(i10), theme);
        } catch (Exception e10) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e10);
            return null;
        }
    }

    private static boolean m(Resources resources, int i10) {
        TypedValue k10 = k();
        resources.getValue(i10, k10, true);
        int i11 = k10.type;
        if (i11 >= 28 && i11 <= 31) {
            return true;
        }
        return false;
    }

    private static Typeface n(Context context, int i10, TypedValue typedValue, int i11, e eVar, Handler handler, boolean z10, boolean z11) {
        Resources resources = context.getResources();
        resources.getValue(i10, typedValue, true);
        Typeface o10 = o(context, resources, typedValue, i10, i11, eVar, handler, z10, z11);
        if (o10 == null && eVar == null && !z11) {
            throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i10) + " could not be retrieved.");
        }
        return o10;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Typeface o(Context context, Resources resources, TypedValue typedValue, int i10, int i11, e eVar, Handler handler, boolean z10, boolean z11) {
        CharSequence charSequence = typedValue.string;
        if (charSequence != null) {
            String charSequence2 = charSequence.toString();
            int i12 = 0;
            if (!charSequence2.startsWith("res/")) {
                if (eVar != null) {
                    eVar.c(-3, handler);
                }
                return null;
            }
            Typeface g10 = j0.g(resources, i10, charSequence2, typedValue.assetCookie, i11);
            if (g10 != null) {
                if (eVar != null) {
                    eVar.d(g10, handler);
                }
                return g10;
            }
            if (z11) {
                return null;
            }
            try {
            } catch (IOException e10) {
                e = e10;
                i12 = -3;
            } catch (XmlPullParserException e11) {
                e = e11;
                i12 = -3;
            }
            try {
                if (charSequence2.toLowerCase().endsWith(".xml")) {
                    e.b b10 = androidx.core.content.res.e.b(resources.getXml(i10), resources);
                    if (b10 == null) {
                        Log.e("ResourcesCompat", "Failed to find font-family tag");
                        if (eVar != null) {
                            eVar.c(-3, handler);
                        }
                        return null;
                    }
                    return j0.d(context, b10, resources, i10, charSequence2, typedValue.assetCookie, i11, eVar, handler, z10);
                }
                Typeface e12 = j0.e(context, resources, i10, charSequence2, typedValue.assetCookie, i11);
                if (eVar != null) {
                    if (e12 != null) {
                        eVar.d(e12, handler);
                    } else {
                        eVar.c(-3, handler);
                    }
                }
                return e12;
            } catch (IOException e13) {
                e = e13;
                Log.e("ResourcesCompat", "Failed to read xml resource " + charSequence2, e);
                if (eVar == null) {
                    eVar.c(i12, handler);
                    return null;
                }
                return null;
            } catch (XmlPullParserException e14) {
                e = e14;
                Log.e("ResourcesCompat", "Failed to parse xml resource " + charSequence2, e);
                if (eVar == null) {
                }
            }
        } else {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i10) + "\" (" + Integer.toHexString(i10) + ") is not a Font: " + typedValue);
        }
    }
}
