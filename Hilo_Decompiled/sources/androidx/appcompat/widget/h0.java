package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.resources.R;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import com.alibaba.sdk.android.push.notification.CustomNotificationBuilder;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class h0 {

    /* renamed from: i, reason: collision with root package name */
    private static h0 f١٥٥٢i;

    /* renamed from: a, reason: collision with root package name */
    private WeakHashMap f١٥٥٤a;

    /* renamed from: b, reason: collision with root package name */
    private SimpleArrayMap f١٥٥٥b;

    /* renamed from: c, reason: collision with root package name */
    private SparseArrayCompat f١٥٥٦c;

    /* renamed from: d, reason: collision with root package name */
    private final WeakHashMap f١٥٥٧d = new WeakHashMap(0);

    /* renamed from: e, reason: collision with root package name */
    private TypedValue f١٥٥٨e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f١٥٥٩f;

    /* renamed from: g, reason: collision with root package name */
    private f f١٥٦٠g;

    /* renamed from: h, reason: collision with root package name */
    private static final PorterDuff.Mode f١٥٥١h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j, reason: collision with root package name */
    private static final c f١٥٥٣j = new c(6);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a implements e {
        a() {
        }

        @Override // androidx.appcompat.widget.h0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return s1.a.l(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e10) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e10);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b implements e {
        b() {
        }

        @Override // androidx.appcompat.widget.h0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.e.b(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e10) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e10);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c extends LruCache {
        public c(int i10) {
            super(i10);
        }

        private static int a(int i10, PorterDuff.Mode mode) {
            return ((i10 + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter b(int i10, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(a(i10, mode)));
        }

        PorterDuffColorFilter c(int i10, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(a(i10, mode)), porterDuffColorFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d implements e {
        d() {
        }

        @Override // androidx.appcompat.widget.h0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(null).newInstance(null);
                    t1.a.c(drawable, context.getResources(), xmlPullParser, attributeSet, theme);
                    return drawable;
                } catch (Exception e10) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e10);
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface e {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface f {
        Drawable a(h0 h0Var, Context context, int i10);

        ColorStateList b(Context context, int i10);

        boolean c(Context context, int i10, Drawable drawable);

        PorterDuff.Mode d(int i10);

        boolean e(Context context, int i10, Drawable drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class g implements e {
        g() {
        }

        @Override // androidx.appcompat.widget.h0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.j.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e10) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e10);
                return null;
            }
        }
    }

    private void a(String str, e eVar) {
        if (this.f١٥٥٥b == null) {
            this.f١٥٥٥b = new SimpleArrayMap();
        }
        this.f١٥٥٥b.put(str, eVar);
    }

    private synchronized boolean b(Context context, long j10, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                LongSparseArray longSparseArray = (LongSparseArray) this.f١٥٥٧d.get(context);
                if (longSparseArray == null) {
                    longSparseArray = new LongSparseArray();
                    this.f١٥٥٧d.put(context, longSparseArray);
                }
                longSparseArray.put(j10, new WeakReference(constantState));
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void c(Context context, int i10, ColorStateList colorStateList) {
        if (this.f١٥٥٤a == null) {
            this.f١٥٥٤a = new WeakHashMap();
        }
        SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) this.f١٥٥٤a.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new SparseArrayCompat();
            this.f١٥٥٤a.put(context, sparseArrayCompat);
        }
        sparseArrayCompat.append(i10, colorStateList);
    }

    private void d(Context context) {
        if (this.f١٥٥٩f) {
            return;
        }
        this.f١٥٥٩f = true;
        Drawable j10 = j(context, R.drawable.abc_vector_test);
        if (j10 != null && q(j10)) {
            return;
        }
        this.f١٥٥٩f = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
    }

    private static long e(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private Drawable f(Context context, int i10) {
        Drawable a10;
        if (this.f١٥٥٨e == null) {
            this.f١٥٥٨e = new TypedValue();
        }
        TypedValue typedValue = this.f١٥٥٨e;
        context.getResources().getValue(i10, typedValue, true);
        long e10 = e(typedValue);
        Drawable i11 = i(context, e10);
        if (i11 != null) {
            return i11;
        }
        f fVar = this.f١٥٦٠g;
        if (fVar == null) {
            a10 = null;
        } else {
            a10 = fVar.a(this, context, i10);
        }
        if (a10 != null) {
            a10.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, e10, a10);
        }
        return a10;
    }

    private static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList != null && mode != null) {
            return l(colorStateList.getColorForState(iArr, 0), mode);
        }
        return null;
    }

    public static synchronized h0 h() {
        h0 h0Var;
        synchronized (h0.class) {
            try {
                if (f١٥٥٢i == null) {
                    h0 h0Var2 = new h0();
                    f١٥٥٢i = h0Var2;
                    p(h0Var2);
                }
                h0Var = f١٥٥٢i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return h0Var;
    }

    private synchronized Drawable i(Context context, long j10) {
        LongSparseArray longSparseArray = (LongSparseArray) this.f١٥٥٧d.get(context);
        if (longSparseArray == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) longSparseArray.get(j10);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            longSparseArray.remove(j10);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter l(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter b10;
        synchronized (h0.class) {
            c cVar = f١٥٥٣j;
            b10 = cVar.b(i10, mode);
            if (b10 == null) {
                b10 = new PorterDuffColorFilter(i10, mode);
                cVar.c(i10, mode, b10);
            }
        }
        return b10;
    }

    private ColorStateList n(Context context, int i10) {
        SparseArrayCompat sparseArrayCompat;
        WeakHashMap weakHashMap = this.f١٥٥٤a;
        if (weakHashMap == null || (sparseArrayCompat = (SparseArrayCompat) weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) sparseArrayCompat.get(i10);
    }

    private static void p(h0 h0Var) {
        if (Build.VERSION.SDK_INT < 24) {
            h0Var.a("vector", new g());
            h0Var.a("animated-vector", new b());
            h0Var.a("animated-selector", new a());
            h0Var.a(CustomNotificationBuilder.NOTIFICATION_ICON_RES_TYPE, new d());
        }
    }

    private static boolean q(Drawable drawable) {
        if (!(drawable instanceof androidx.vectordrawable.graphics.drawable.j) && !"android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            return false;
        }
        return true;
    }

    private Drawable r(Context context, int i10) {
        int next;
        SimpleArrayMap simpleArrayMap = this.f١٥٥٥b;
        if (simpleArrayMap == null || simpleArrayMap.isEmpty()) {
            return null;
        }
        SparseArrayCompat sparseArrayCompat = this.f١٥٥٦c;
        if (sparseArrayCompat != null) {
            String str = (String) sparseArrayCompat.get(i10);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.f١٥٥٥b.get(str) == null)) {
                return null;
            }
        } else {
            this.f١٥٥٦c = new SparseArrayCompat();
        }
        if (this.f١٥٥٨e == null) {
            this.f١٥٥٨e = new TypedValue();
        }
        TypedValue typedValue = this.f١٥٥٨e;
        Resources resources = context.getResources();
        resources.getValue(i10, typedValue, true);
        long e10 = e(typedValue);
        Drawable i11 = i(context, e10);
        if (i11 != null) {
            return i11;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i10);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next == 2) {
                    String name = xml.getName();
                    this.f١٥٥٦c.append(i10, name);
                    e eVar = (e) this.f١٥٥٥b.get(name);
                    if (eVar != null) {
                        i11 = eVar.a(context, xml, asAttributeSet, context.getTheme());
                    }
                    if (i11 != null) {
                        i11.setChangingConfigurations(typedValue.changingConfigurations);
                        b(context, e10, i11);
                    }
                } else {
                    throw new XmlPullParserException("No start tag found");
                }
            } catch (Exception e11) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e11);
            }
        }
        if (i11 == null) {
            this.f١٥٥٦c.append(i10, "appcompat_skip_skip");
        }
        return i11;
    }

    private Drawable v(Context context, int i10, boolean z10, Drawable drawable) {
        ColorStateList m10 = m(context, i10);
        if (m10 != null) {
            Drawable r10 = h2.b.r(drawable.mutate());
            h2.b.o(r10, m10);
            PorterDuff.Mode o10 = o(i10);
            if (o10 != null) {
                h2.b.p(r10, o10);
                return r10;
            }
            return r10;
        }
        f fVar = this.f١٥٦٠g;
        if ((fVar == null || !fVar.e(context, i10, drawable)) && !x(context, i10, drawable) && z10) {
            return null;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void w(Drawable drawable, n0 n0Var, int[] iArr) {
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        int[] state = drawable.getState();
        if (drawable.mutate() == drawable) {
            if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
                drawable.setState(new int[0]);
                drawable.setState(state);
            }
            boolean z10 = n0Var.f١٦٢٢d;
            if (!z10 && !n0Var.f١٦٢١c) {
                drawable.clearColorFilter();
            } else {
                if (z10) {
                    colorStateList = n0Var.f١٦١٩a;
                } else {
                    colorStateList = null;
                }
                if (n0Var.f١٦٢١c) {
                    mode = n0Var.f١٦٢٠b;
                } else {
                    mode = f١٥٥١h;
                }
                drawable.setColorFilter(g(colorStateList, mode, iArr));
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
    }

    public synchronized Drawable j(Context context, int i10) {
        return k(context, i10, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable k(Context context, int i10, boolean z10) {
        Drawable r10;
        try {
            d(context);
            r10 = r(context, i10);
            if (r10 == null) {
                r10 = f(context, i10);
            }
            if (r10 == null) {
                r10 = androidx.core.content.a.getDrawable(context, i10);
            }
            if (r10 != null) {
                r10 = v(context, i10, z10, r10);
            }
            if (r10 != null) {
                c0.b(r10);
            }
        } catch (Throwable th) {
            throw th;
        }
        return r10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList m(Context context, int i10) {
        ColorStateList n10;
        n10 = n(context, i10);
        if (n10 == null) {
            f fVar = this.f١٥٦٠g;
            if (fVar == null) {
                n10 = null;
            } else {
                n10 = fVar.b(context, i10);
            }
            if (n10 != null) {
                c(context, i10, n10);
            }
        }
        return n10;
    }

    PorterDuff.Mode o(int i10) {
        f fVar = this.f١٥٦٠g;
        if (fVar == null) {
            return null;
        }
        return fVar.d(i10);
    }

    public synchronized void s(Context context) {
        LongSparseArray longSparseArray = (LongSparseArray) this.f١٥٥٧d.get(context);
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable t(Context context, z0 z0Var, int i10) {
        try {
            Drawable r10 = r(context, i10);
            if (r10 == null) {
                r10 = z0Var.a(i10);
            }
            if (r10 != null) {
                return v(context, i10, false, r10);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void u(f fVar) {
        this.f١٥٦٠g = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x(Context context, int i10, Drawable drawable) {
        f fVar = this.f١٥٦٠g;
        if (fVar != null && fVar.c(context, i10, drawable)) {
            return true;
        }
        return false;
    }
}
