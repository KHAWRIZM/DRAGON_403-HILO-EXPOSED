package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d2 {

    /* renamed from: b, reason: collision with root package name */
    public static final d2 f٢٩٣٥b;

    /* renamed from: a, reason: collision with root package name */
    private final l f٢٩٣٦a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static Field f٢٩٣٧a;

        /* renamed from: b, reason: collision with root package name */
        private static Field f٢٩٣٨b;

        /* renamed from: c, reason: collision with root package name */
        private static Field f٢٩٣٩c;

        /* renamed from: d, reason: collision with root package name */
        private static boolean f٢٩٤٠d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f٢٩٣٧a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f٢٩٣٨b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f٢٩٣٩c = declaredField3;
                declaredField3.setAccessible(true);
                f٢٩٤٠d = true;
            } catch (ReflectiveOperationException e10) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e10.getMessage(), e10);
            }
        }

        public static d2 a(View view) {
            if (f٢٩٤٠d && view.isAttachedToWindow()) {
                try {
                    Object obj = f٢٩٣٧a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f٢٩٣٨b.get(obj);
                        Rect rect2 = (Rect) f٢٩٣٩c.get(obj);
                        if (rect != null && rect2 != null) {
                            d2 a10 = new b().c(androidx.core.graphics.b0.c(rect)).d(androidx.core.graphics.b0.c(rect2)).a();
                            a10.u(a10);
                            a10.d(view.getRootView());
                            return a10;
                        }
                    }
                } catch (IllegalAccessException e10) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e10.getMessage(), e10);
                }
            }
            return null;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class e extends d {
        e() {
        }

        @Override // androidx.core.view.d2.f
        void c(int i10, androidx.core.graphics.b0 b0Var) {
            this.f٢٩٤٨c.setInsets(n.a(i10), b0Var.f());
        }

        e(d2 d2Var) {
            super(d2Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private final d2 f٢٩٤٩a;

        /* renamed from: b, reason: collision with root package name */
        androidx.core.graphics.b0[] f٢٩٥٠b;

        f() {
            this(new d2((d2) null));
        }

        protected final void a() {
            androidx.core.graphics.b0[] b0VarArr = this.f٢٩٥٠b;
            if (b0VarArr != null) {
                androidx.core.graphics.b0 b0Var = b0VarArr[m.c(1)];
                androidx.core.graphics.b0 b0Var2 = this.f٢٩٥٠b[m.c(2)];
                if (b0Var2 == null) {
                    b0Var2 = this.f٢٩٤٩a.f(2);
                }
                if (b0Var == null) {
                    b0Var = this.f٢٩٤٩a.f(1);
                }
                g(androidx.core.graphics.b0.a(b0Var, b0Var2));
                androidx.core.graphics.b0 b0Var3 = this.f٢٩٥٠b[m.c(16)];
                if (b0Var3 != null) {
                    f(b0Var3);
                }
                androidx.core.graphics.b0 b0Var4 = this.f٢٩٥٠b[m.c(32)];
                if (b0Var4 != null) {
                    d(b0Var4);
                }
                androidx.core.graphics.b0 b0Var5 = this.f٢٩٥٠b[m.c(64)];
                if (b0Var5 != null) {
                    h(b0Var5);
                }
            }
        }

        abstract d2 b();

        void c(int i10, androidx.core.graphics.b0 b0Var) {
            if (this.f٢٩٥٠b == null) {
                this.f٢٩٥٠b = new androidx.core.graphics.b0[9];
            }
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    this.f٢٩٥٠b[m.c(i11)] = b0Var;
                }
            }
        }

        void d(androidx.core.graphics.b0 b0Var) {
        }

        abstract void e(androidx.core.graphics.b0 b0Var);

        void f(androidx.core.graphics.b0 b0Var) {
        }

        abstract void g(androidx.core.graphics.b0 b0Var);

        void h(androidx.core.graphics.b0 b0Var) {
        }

        f(d2 d2Var) {
            this.f٢٩٤٩a = d2Var;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class i extends h {
        i(d2 d2Var, WindowInsets windowInsets) {
            super(d2Var, windowInsets);
        }

        @Override // androidx.core.view.d2.l
        d2 a() {
            WindowInsets consumeDisplayCutout;
            consumeDisplayCutout = this.f٢٩٥٦c.consumeDisplayCutout();
            return d2.x(consumeDisplayCutout);
        }

        @Override // androidx.core.view.d2.g, androidx.core.view.d2.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            if (Objects.equals(this.f٢٩٥٦c, iVar.f٢٩٥٦c) && Objects.equals(this.f٢٩٦٠g, iVar.f٢٩٦٠g)) {
                return true;
            }
            return false;
        }

        @Override // androidx.core.view.d2.l
        r f() {
            DisplayCutout displayCutout;
            displayCutout = this.f٢٩٥٦c.getDisplayCutout();
            return r.e(displayCutout);
        }

        @Override // androidx.core.view.d2.l
        public int hashCode() {
            return this.f٢٩٥٦c.hashCode();
        }

        i(d2 d2Var, i iVar) {
            super(d2Var, iVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class k extends j {

        /* renamed from: q, reason: collision with root package name */
        static final d2 f٢٩٦٥q;

        static {
            WindowInsets windowInsets;
            windowInsets = WindowInsets.CONSUMED;
            f٢٩٦٥q = d2.x(windowInsets);
        }

        k(d2 d2Var, WindowInsets windowInsets) {
            super(d2Var, windowInsets);
        }

        @Override // androidx.core.view.d2.g, androidx.core.view.d2.l
        final void d(View view) {
        }

        @Override // androidx.core.view.d2.g, androidx.core.view.d2.l
        public androidx.core.graphics.b0 g(int i10) {
            Insets insets;
            insets = this.f٢٩٥٦c.getInsets(n.a(i10));
            return androidx.core.graphics.b0.e(insets);
        }

        @Override // androidx.core.view.d2.g, androidx.core.view.d2.l
        public androidx.core.graphics.b0 h(int i10) {
            Insets insetsIgnoringVisibility;
            insetsIgnoringVisibility = this.f٢٩٥٦c.getInsetsIgnoringVisibility(n.a(i10));
            return androidx.core.graphics.b0.e(insetsIgnoringVisibility);
        }

        k(d2 d2Var, k kVar) {
            super(d2Var, kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class l {

        /* renamed from: b, reason: collision with root package name */
        static final d2 f٢٩٦٦b = new b().a().a().b().c();

        /* renamed from: a, reason: collision with root package name */
        final d2 f٢٩٦٧a;

        l(d2 d2Var) {
            this.f٢٩٦٧a = d2Var;
        }

        d2 a() {
            return this.f٢٩٦٧a;
        }

        d2 b() {
            return this.f٢٩٦٧a;
        }

        d2 c() {
            return this.f٢٩٦٧a;
        }

        void d(View view) {
        }

        void e(d2 d2Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            if (p() == lVar.p() && o() == lVar.o() && androidx.core.util.f.a(l(), lVar.l()) && androidx.core.util.f.a(j(), lVar.j()) && androidx.core.util.f.a(f(), lVar.f())) {
                return true;
            }
            return false;
        }

        r f() {
            return null;
        }

        androidx.core.graphics.b0 g(int i10) {
            return androidx.core.graphics.b0.f٢٧٩٢e;
        }

        androidx.core.graphics.b0 h(int i10) {
            if ((i10 & 8) == 0) {
                return androidx.core.graphics.b0.f٢٧٩٢e;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        public int hashCode() {
            return androidx.core.util.f.b(Boolean.valueOf(p()), Boolean.valueOf(o()), l(), j(), f());
        }

        androidx.core.graphics.b0 i() {
            return l();
        }

        androidx.core.graphics.b0 j() {
            return androidx.core.graphics.b0.f٢٧٩٢e;
        }

        androidx.core.graphics.b0 k() {
            return l();
        }

        androidx.core.graphics.b0 l() {
            return androidx.core.graphics.b0.f٢٧٩٢e;
        }

        androidx.core.graphics.b0 m() {
            return l();
        }

        d2 n(int i10, int i11, int i12, int i13) {
            return f٢٩٦٦b;
        }

        boolean o() {
            return false;
        }

        boolean p() {
            return false;
        }

        public void q(androidx.core.graphics.b0[] b0VarArr) {
        }

        void r(androidx.core.graphics.b0 b0Var) {
        }

        void s(d2 d2Var) {
        }

        public void t(androidx.core.graphics.b0 b0Var) {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class m {
        public static int a() {
            return 128;
        }

        public static int b() {
            return 8;
        }

        static int c(int i10) {
            if (i10 != 1) {
                if (i10 == 2) {
                    return 1;
                }
                if (i10 == 4) {
                    return 2;
                }
                if (i10 != 8) {
                    if (i10 == 16) {
                        return 4;
                    }
                    if (i10 != 32) {
                        if (i10 != 64) {
                            if (i10 != 128) {
                                if (i10 == 256) {
                                    return 8;
                                }
                                throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i10);
                            }
                            return 7;
                        }
                        return 6;
                    }
                    return 5;
                }
                return 3;
            }
            return 0;
        }

        public static int d() {
            return 32;
        }

        public static int e() {
            return 2;
        }

        public static int f() {
            return 1;
        }

        public static int g() {
            return 7;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static final class n {
        static int a(int i10) {
            int statusBars;
            int i11 = 0;
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i10 & i12) != 0) {
                    if (i12 == 1) {
                        statusBars = WindowInsets.Type.statusBars();
                    } else if (i12 == 2) {
                        statusBars = WindowInsets.Type.navigationBars();
                    } else if (i12 == 4) {
                        statusBars = WindowInsets.Type.captionBar();
                    } else if (i12 == 8) {
                        statusBars = WindowInsets.Type.ime();
                    } else if (i12 == 16) {
                        statusBars = WindowInsets.Type.systemGestures();
                    } else if (i12 == 32) {
                        statusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i12 == 64) {
                        statusBars = WindowInsets.Type.tappableElement();
                    } else if (i12 == 128) {
                        statusBars = WindowInsets.Type.displayCutout();
                    }
                    i11 |= statusBars;
                }
            }
            return i11;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f٢٩٣٥b = k.f٢٩٦٥q;
        } else {
            f٢٩٣٥b = l.f٢٩٦٦b;
        }
    }

    private d2(WindowInsets windowInsets) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            this.f٢٩٣٦a = new k(this, windowInsets);
            return;
        }
        if (i10 >= 29) {
            this.f٢٩٣٦a = new j(this, windowInsets);
        } else if (i10 >= 28) {
            this.f٢٩٣٦a = new i(this, windowInsets);
        } else {
            this.f٢٩٣٦a = new h(this, windowInsets);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static androidx.core.graphics.b0 p(androidx.core.graphics.b0 b0Var, int i10, int i11, int i12, int i13) {
        int max = Math.max(0, b0Var.f٢٧٩٣a - i10);
        int max2 = Math.max(0, b0Var.f٢٧٩٤b - i11);
        int max3 = Math.max(0, b0Var.f٢٧٩٥c - i12);
        int max4 = Math.max(0, b0Var.f٢٧٩٦d - i13);
        if (max == i10 && max2 == i11 && max3 == i12 && max4 == i13) {
            return b0Var;
        }
        return androidx.core.graphics.b0.b(max, max2, max3, max4);
    }

    public static d2 x(WindowInsets windowInsets) {
        return y(windowInsets, null);
    }

    public static d2 y(WindowInsets windowInsets, View view) {
        d2 d2Var = new d2((WindowInsets) androidx.core.util.h.g(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            d2Var.u(d1.K(view));
            d2Var.d(view.getRootView());
        }
        return d2Var;
    }

    public d2 a() {
        return this.f٢٩٣٦a.a();
    }

    public d2 b() {
        return this.f٢٩٣٦a.b();
    }

    public d2 c() {
        return this.f٢٩٣٦a.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(View view) {
        this.f٢٩٣٦a.d(view);
    }

    public r e() {
        return this.f٢٩٣٦a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d2)) {
            return false;
        }
        return androidx.core.util.f.a(this.f٢٩٣٦a, ((d2) obj).f٢٩٣٦a);
    }

    public androidx.core.graphics.b0 f(int i10) {
        return this.f٢٩٣٦a.g(i10);
    }

    public androidx.core.graphics.b0 g(int i10) {
        return this.f٢٩٣٦a.h(i10);
    }

    public androidx.core.graphics.b0 h() {
        return this.f٢٩٣٦a.j();
    }

    public int hashCode() {
        l lVar = this.f٢٩٣٦a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    public androidx.core.graphics.b0 i() {
        return this.f٢٩٣٦a.k();
    }

    public int j() {
        return this.f٢٩٣٦a.l().f٢٧٩٦d;
    }

    public int k() {
        return this.f٢٩٣٦a.l().f٢٧٩٣a;
    }

    public int l() {
        return this.f٢٩٣٦a.l().f٢٧٩٥c;
    }

    public int m() {
        return this.f٢٩٣٦a.l().f٢٧٩٤b;
    }

    public boolean n() {
        return !this.f٢٩٣٦a.l().equals(androidx.core.graphics.b0.f٢٧٩٢e);
    }

    public d2 o(int i10, int i11, int i12, int i13) {
        return this.f٢٩٣٦a.n(i10, i11, i12, i13);
    }

    public boolean q() {
        return this.f٢٩٣٦a.o();
    }

    public d2 r(int i10, int i11, int i12, int i13) {
        return new b(this).d(androidx.core.graphics.b0.b(i10, i11, i12, i13)).a();
    }

    void s(androidx.core.graphics.b0[] b0VarArr) {
        this.f٢٩٣٦a.q(b0VarArr);
    }

    void t(androidx.core.graphics.b0 b0Var) {
        this.f٢٩٣٦a.r(b0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(d2 d2Var) {
        this.f٢٩٣٦a.s(d2Var);
    }

    void v(androidx.core.graphics.b0 b0Var) {
        this.f٢٩٣٦a.t(b0Var);
    }

    public WindowInsets w() {
        l lVar = this.f٢٩٣٦a;
        if (lVar instanceof g) {
            return ((g) lVar).f٢٩٥٦c;
        }
        return null;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class c extends f {

        /* renamed from: e, reason: collision with root package name */
        private static Field f٢٩٤٢e;

        /* renamed from: f, reason: collision with root package name */
        private static boolean f٢٩٤٣f;

        /* renamed from: g, reason: collision with root package name */
        private static Constructor f٢٩٤٤g;

        /* renamed from: h, reason: collision with root package name */
        private static boolean f٢٩٤٥h;

        /* renamed from: c, reason: collision with root package name */
        private WindowInsets f٢٩٤٦c;

        /* renamed from: d, reason: collision with root package name */
        private androidx.core.graphics.b0 f٢٩٤٧d;

        c() {
            this.f٢٩٤٦c = i();
        }

        private static WindowInsets i() {
            if (!f٢٩٤٣f) {
                try {
                    f٢٩٤٢e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e10) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e10);
                }
                f٢٩٤٣f = true;
            }
            Field field = f٢٩٤٢e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e11) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e11);
                }
            }
            if (!f٢٩٤٥h) {
                try {
                    f٢٩٤٤g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e12) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e12);
                }
                f٢٩٤٥h = true;
            }
            Constructor constructor = f٢٩٤٤g;
            if (constructor != null) {
                try {
                    return (WindowInsets) constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e13) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e13);
                }
            }
            return null;
        }

        @Override // androidx.core.view.d2.f
        d2 b() {
            a();
            d2 x10 = d2.x(this.f٢٩٤٦c);
            x10.s(this.f٢٩٥٠b);
            x10.v(this.f٢٩٤٧d);
            return x10;
        }

        @Override // androidx.core.view.d2.f
        void e(androidx.core.graphics.b0 b0Var) {
            this.f٢٩٤٧d = b0Var;
        }

        @Override // androidx.core.view.d2.f
        void g(androidx.core.graphics.b0 b0Var) {
            WindowInsets windowInsets = this.f٢٩٤٦c;
            if (windowInsets != null) {
                this.f٢٩٤٦c = windowInsets.replaceSystemWindowInsets(b0Var.f٢٧٩٣a, b0Var.f٢٧٩٤b, b0Var.f٢٧٩٥c, b0Var.f٢٧٩٦d);
            }
        }

        c(d2 d2Var) {
            super(d2Var);
            this.f٢٩٤٦c = d2Var.w();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class d extends f {

        /* renamed from: c, reason: collision with root package name */
        final WindowInsets.Builder f٢٩٤٨c;

        d() {
            this.f٢٩٤٨c = l2.a();
        }

        @Override // androidx.core.view.d2.f
        d2 b() {
            WindowInsets build;
            a();
            build = this.f٢٩٤٨c.build();
            d2 x10 = d2.x(build);
            x10.s(this.f٢٩٥٠b);
            return x10;
        }

        @Override // androidx.core.view.d2.f
        void d(androidx.core.graphics.b0 b0Var) {
            this.f٢٩٤٨c.setMandatorySystemGestureInsets(b0Var.f());
        }

        @Override // androidx.core.view.d2.f
        void e(androidx.core.graphics.b0 b0Var) {
            this.f٢٩٤٨c.setStableInsets(b0Var.f());
        }

        @Override // androidx.core.view.d2.f
        void f(androidx.core.graphics.b0 b0Var) {
            this.f٢٩٤٨c.setSystemGestureInsets(b0Var.f());
        }

        @Override // androidx.core.view.d2.f
        void g(androidx.core.graphics.b0 b0Var) {
            this.f٢٩٤٨c.setSystemWindowInsets(b0Var.f());
        }

        @Override // androidx.core.view.d2.f
        void h(androidx.core.graphics.b0 b0Var) {
            this.f٢٩٤٨c.setTappableElementInsets(b0Var.f());
        }

        d(d2 d2Var) {
            super(d2Var);
            WindowInsets.Builder a10;
            WindowInsets w10 = d2Var.w();
            if (w10 != null) {
                a10 = k2.a(w10);
            } else {
                a10 = l2.a();
            }
            this.f٢٩٤٨c = a10;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class h extends g {

        /* renamed from: m, reason: collision with root package name */
        private androidx.core.graphics.b0 f٢٩٦١m;

        h(d2 d2Var, WindowInsets windowInsets) {
            super(d2Var, windowInsets);
            this.f٢٩٦١m = null;
        }

        @Override // androidx.core.view.d2.l
        d2 b() {
            return d2.x(this.f٢٩٥٦c.consumeStableInsets());
        }

        @Override // androidx.core.view.d2.l
        d2 c() {
            return d2.x(this.f٢٩٥٦c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.d2.l
        final androidx.core.graphics.b0 j() {
            if (this.f٢٩٦١m == null) {
                this.f٢٩٦١m = androidx.core.graphics.b0.b(this.f٢٩٥٦c.getStableInsetLeft(), this.f٢٩٥٦c.getStableInsetTop(), this.f٢٩٥٦c.getStableInsetRight(), this.f٢٩٥٦c.getStableInsetBottom());
            }
            return this.f٢٩٦١m;
        }

        @Override // androidx.core.view.d2.l
        boolean o() {
            return this.f٢٩٥٦c.isConsumed();
        }

        @Override // androidx.core.view.d2.l
        public void t(androidx.core.graphics.b0 b0Var) {
            this.f٢٩٦١m = b0Var;
        }

        h(d2 d2Var, h hVar) {
            super(d2Var, hVar);
            this.f٢٩٦١m = null;
            this.f٢٩٦١m = hVar.f٢٩٦١m;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class g extends l {

        /* renamed from: h, reason: collision with root package name */
        private static boolean f٢٩٥١h;

        /* renamed from: i, reason: collision with root package name */
        private static Method f٢٩٥٢i;

        /* renamed from: j, reason: collision with root package name */
        private static Class f٢٩٥٣j;

        /* renamed from: k, reason: collision with root package name */
        private static Field f٢٩٥٤k;

        /* renamed from: l, reason: collision with root package name */
        private static Field f٢٩٥٥l;

        /* renamed from: c, reason: collision with root package name */
        final WindowInsets f٢٩٥٦c;

        /* renamed from: d, reason: collision with root package name */
        private androidx.core.graphics.b0[] f٢٩٥٧d;

        /* renamed from: e, reason: collision with root package name */
        private androidx.core.graphics.b0 f٢٩٥٨e;

        /* renamed from: f, reason: collision with root package name */
        private d2 f٢٩٥٩f;

        /* renamed from: g, reason: collision with root package name */
        androidx.core.graphics.b0 f٢٩٦٠g;

        g(d2 d2Var, WindowInsets windowInsets) {
            super(d2Var);
            this.f٢٩٥٨e = null;
            this.f٢٩٥٦c = windowInsets;
        }

        @SuppressLint({"WrongConstant"})
        private androidx.core.graphics.b0 u(int i10, boolean z10) {
            androidx.core.graphics.b0 b0Var = androidx.core.graphics.b0.f٢٧٩٢e;
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    b0Var = androidx.core.graphics.b0.a(b0Var, v(i11, z10));
                }
            }
            return b0Var;
        }

        private androidx.core.graphics.b0 w() {
            d2 d2Var = this.f٢٩٥٩f;
            if (d2Var != null) {
                return d2Var.h();
            }
            return androidx.core.graphics.b0.f٢٧٩٢e;
        }

        private androidx.core.graphics.b0 x(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!f٢٩٥١h) {
                    y();
                }
                Method method = f٢٩٥٢i;
                if (method != null && f٢٩٥٣j != null && f٢٩٥٤k != null) {
                    try {
                        Object invoke = method.invoke(view, null);
                        if (invoke == null) {
                            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) f٢٩٥٤k.get(f٢٩٥٥l.get(invoke));
                        if (rect == null) {
                            return null;
                        }
                        return androidx.core.graphics.b0.c(rect);
                    } catch (ReflectiveOperationException e10) {
                        Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @SuppressLint({"PrivateApi"})
        private static void y() {
            try {
                f٢٩٥٢i = View.class.getDeclaredMethod("getViewRootImpl", null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f٢٩٥٣j = cls;
                f٢٩٥٤k = cls.getDeclaredField("mVisibleInsets");
                f٢٩٥٥l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f٢٩٥٤k.setAccessible(true);
                f٢٩٥٥l.setAccessible(true);
            } catch (ReflectiveOperationException e10) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
            }
            f٢٩٥١h = true;
        }

        @Override // androidx.core.view.d2.l
        void d(View view) {
            androidx.core.graphics.b0 x10 = x(view);
            if (x10 == null) {
                x10 = androidx.core.graphics.b0.f٢٧٩٢e;
            }
            r(x10);
        }

        @Override // androidx.core.view.d2.l
        void e(d2 d2Var) {
            d2Var.u(this.f٢٩٥٩f);
            d2Var.t(this.f٢٩٦٠g);
        }

        @Override // androidx.core.view.d2.l
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.f٢٩٦٠g, ((g) obj).f٢٩٦٠g);
        }

        @Override // androidx.core.view.d2.l
        public androidx.core.graphics.b0 g(int i10) {
            return u(i10, false);
        }

        @Override // androidx.core.view.d2.l
        public androidx.core.graphics.b0 h(int i10) {
            return u(i10, true);
        }

        @Override // androidx.core.view.d2.l
        final androidx.core.graphics.b0 l() {
            if (this.f٢٩٥٨e == null) {
                this.f٢٩٥٨e = androidx.core.graphics.b0.b(this.f٢٩٥٦c.getSystemWindowInsetLeft(), this.f٢٩٥٦c.getSystemWindowInsetTop(), this.f٢٩٥٦c.getSystemWindowInsetRight(), this.f٢٩٥٦c.getSystemWindowInsetBottom());
            }
            return this.f٢٩٥٨e;
        }

        @Override // androidx.core.view.d2.l
        d2 n(int i10, int i11, int i12, int i13) {
            b bVar = new b(d2.x(this.f٢٩٥٦c));
            bVar.d(d2.p(l(), i10, i11, i12, i13));
            bVar.c(d2.p(j(), i10, i11, i12, i13));
            return bVar.a();
        }

        @Override // androidx.core.view.d2.l
        boolean p() {
            return this.f٢٩٥٦c.isRound();
        }

        @Override // androidx.core.view.d2.l
        public void q(androidx.core.graphics.b0[] b0VarArr) {
            this.f٢٩٥٧d = b0VarArr;
        }

        @Override // androidx.core.view.d2.l
        void r(androidx.core.graphics.b0 b0Var) {
            this.f٢٩٦٠g = b0Var;
        }

        @Override // androidx.core.view.d2.l
        void s(d2 d2Var) {
            this.f٢٩٥٩f = d2Var;
        }

        protected androidx.core.graphics.b0 v(int i10, boolean z10) {
            int i11;
            r f10;
            if (i10 != 1) {
                androidx.core.graphics.b0 b0Var = null;
                if (i10 != 2) {
                    if (i10 != 8) {
                        if (i10 != 16) {
                            if (i10 != 32) {
                                if (i10 != 64) {
                                    if (i10 != 128) {
                                        return androidx.core.graphics.b0.f٢٧٩٢e;
                                    }
                                    d2 d2Var = this.f٢٩٥٩f;
                                    if (d2Var != null) {
                                        f10 = d2Var.e();
                                    } else {
                                        f10 = f();
                                    }
                                    if (f10 != null) {
                                        return androidx.core.graphics.b0.b(f10.b(), f10.d(), f10.c(), f10.a());
                                    }
                                    return androidx.core.graphics.b0.f٢٧٩٢e;
                                }
                                return m();
                            }
                            return i();
                        }
                        return k();
                    }
                    androidx.core.graphics.b0[] b0VarArr = this.f٢٩٥٧d;
                    if (b0VarArr != null) {
                        b0Var = b0VarArr[m.c(8)];
                    }
                    if (b0Var != null) {
                        return b0Var;
                    }
                    androidx.core.graphics.b0 l10 = l();
                    androidx.core.graphics.b0 w10 = w();
                    int i12 = l10.f٢٧٩٦d;
                    if (i12 > w10.f٢٧٩٦d) {
                        return androidx.core.graphics.b0.b(0, 0, 0, i12);
                    }
                    androidx.core.graphics.b0 b0Var2 = this.f٢٩٦٠g;
                    if (b0Var2 != null && !b0Var2.equals(androidx.core.graphics.b0.f٢٧٩٢e) && (i11 = this.f٢٩٦٠g.f٢٧٩٦d) > w10.f٢٧٩٦d) {
                        return androidx.core.graphics.b0.b(0, 0, 0, i11);
                    }
                    return androidx.core.graphics.b0.f٢٧٩٢e;
                }
                if (z10) {
                    androidx.core.graphics.b0 w11 = w();
                    androidx.core.graphics.b0 j10 = j();
                    return androidx.core.graphics.b0.b(Math.max(w11.f٢٧٩٣a, j10.f٢٧٩٣a), 0, Math.max(w11.f٢٧٩٥c, j10.f٢٧٩٥c), Math.max(w11.f٢٧٩٦d, j10.f٢٧٩٦d));
                }
                androidx.core.graphics.b0 l11 = l();
                d2 d2Var2 = this.f٢٩٥٩f;
                if (d2Var2 != null) {
                    b0Var = d2Var2.h();
                }
                int i13 = l11.f٢٧٩٦d;
                if (b0Var != null) {
                    i13 = Math.min(i13, b0Var.f٢٧٩٦d);
                }
                return androidx.core.graphics.b0.b(l11.f٢٧٩٣a, 0, l11.f٢٧٩٥c, i13);
            }
            if (z10) {
                return androidx.core.graphics.b0.b(0, Math.max(w().f٢٧٩٤b, l().f٢٧٩٤b), 0, 0);
            }
            return androidx.core.graphics.b0.b(0, l().f٢٧٩٤b, 0, 0);
        }

        g(d2 d2Var, g gVar) {
            this(d2Var, new WindowInsets(gVar.f٢٩٥٦c));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class j extends i {

        /* renamed from: n, reason: collision with root package name */
        private androidx.core.graphics.b0 f٢٩٦٢n;

        /* renamed from: o, reason: collision with root package name */
        private androidx.core.graphics.b0 f٢٩٦٣o;

        /* renamed from: p, reason: collision with root package name */
        private androidx.core.graphics.b0 f٢٩٦٤p;

        j(d2 d2Var, WindowInsets windowInsets) {
            super(d2Var, windowInsets);
            this.f٢٩٦٢n = null;
            this.f٢٩٦٣o = null;
            this.f٢٩٦٤p = null;
        }

        @Override // androidx.core.view.d2.l
        androidx.core.graphics.b0 i() {
            Insets mandatorySystemGestureInsets;
            if (this.f٢٩٦٣o == null) {
                mandatorySystemGestureInsets = this.f٢٩٥٦c.getMandatorySystemGestureInsets();
                this.f٢٩٦٣o = androidx.core.graphics.b0.e(mandatorySystemGestureInsets);
            }
            return this.f٢٩٦٣o;
        }

        @Override // androidx.core.view.d2.l
        androidx.core.graphics.b0 k() {
            Insets systemGestureInsets;
            if (this.f٢٩٦٢n == null) {
                systemGestureInsets = this.f٢٩٥٦c.getSystemGestureInsets();
                this.f٢٩٦٢n = androidx.core.graphics.b0.e(systemGestureInsets);
            }
            return this.f٢٩٦٢n;
        }

        @Override // androidx.core.view.d2.l
        androidx.core.graphics.b0 m() {
            Insets tappableElementInsets;
            if (this.f٢٩٦٤p == null) {
                tappableElementInsets = this.f٢٩٥٦c.getTappableElementInsets();
                this.f٢٩٦٤p = androidx.core.graphics.b0.e(tappableElementInsets);
            }
            return this.f٢٩٦٤p;
        }

        @Override // androidx.core.view.d2.g, androidx.core.view.d2.l
        d2 n(int i10, int i11, int i12, int i13) {
            WindowInsets inset;
            inset = this.f٢٩٥٦c.inset(i10, i11, i12, i13);
            return d2.x(inset);
        }

        @Override // androidx.core.view.d2.h, androidx.core.view.d2.l
        public void t(androidx.core.graphics.b0 b0Var) {
        }

        j(d2 d2Var, j jVar) {
            super(d2Var, jVar);
            this.f٢٩٦٢n = null;
            this.f٢٩٦٣o = null;
            this.f٢٩٦٤p = null;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final f f٢٩٤١a;

        public b() {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                this.f٢٩٤١a = new e();
            } else if (i10 >= 29) {
                this.f٢٩٤١a = new d();
            } else {
                this.f٢٩٤١a = new c();
            }
        }

        public d2 a() {
            return this.f٢٩٤١a.b();
        }

        public b b(int i10, androidx.core.graphics.b0 b0Var) {
            this.f٢٩٤١a.c(i10, b0Var);
            return this;
        }

        public b c(androidx.core.graphics.b0 b0Var) {
            this.f٢٩٤١a.e(b0Var);
            return this;
        }

        public b d(androidx.core.graphics.b0 b0Var) {
            this.f٢٩٤١a.g(b0Var);
            return this;
        }

        public b(d2 d2Var) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                this.f٢٩٤١a = new e(d2Var);
            } else if (i10 >= 29) {
                this.f٢٩٤١a = new d(d2Var);
            } else {
                this.f٢٩٤١a = new c(d2Var);
            }
        }
    }

    public d2(d2 d2Var) {
        if (d2Var != null) {
            l lVar = d2Var.f٢٩٣٦a;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30 && (lVar instanceof k)) {
                this.f٢٩٣٦a = new k(this, (k) lVar);
            } else if (i10 >= 29 && (lVar instanceof j)) {
                this.f٢٩٣٦a = new j(this, (j) lVar);
            } else if (i10 >= 28 && (lVar instanceof i)) {
                this.f٢٩٣٦a = new i(this, (i) lVar);
            } else if (lVar instanceof h) {
                this.f٢٩٣٦a = new h(this, (h) lVar);
            } else if (lVar instanceof g) {
                this.f٢٩٣٦a = new g(this, (g) lVar);
            } else {
                this.f٢٩٣٦a = new l(this);
            }
            lVar.e(this);
            return;
        }
        this.f٢٩٣٦a = new l(this);
    }
}
