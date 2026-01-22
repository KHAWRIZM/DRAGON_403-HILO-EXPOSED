package s1;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;
import io.agora.rtc.Constants;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class b extends Drawable implements Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    private d f١٧٦١٨a;

    /* renamed from: b, reason: collision with root package name */
    private Rect f١٧٦١٩b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f١٧٦٢٠c;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f١٧٦٢١d;

    /* renamed from: f, reason: collision with root package name */
    private boolean f١٧٦٢٣f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f١٧٦٢٥h;

    /* renamed from: i, reason: collision with root package name */
    private Runnable f١٧٦٢٦i;

    /* renamed from: j, reason: collision with root package name */
    private long f١٧٦٢٧j;

    /* renamed from: k, reason: collision with root package name */
    private long f١٧٦٢٨k;

    /* renamed from: l, reason: collision with root package name */
    private c f١٧٦٢٩l;

    /* renamed from: e, reason: collision with root package name */
    private int f١٧٦٢٢e = KotlinVersion.MAX_COMPONENT_VALUE;

    /* renamed from: g, reason: collision with root package name */
    private int f١٧٦٢٤g = -1;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(true);
            b.this.invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s1.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class C٠٢٢٣b {
        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void b(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources c(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class d extends Drawable.ConstantState {
        int A;

        /* renamed from: B, reason: collision with root package name */
        int f١٧٦٣٢B;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;

        /* renamed from: a, reason: collision with root package name */
        final b f١٧٦٣٣a;

        /* renamed from: b, reason: collision with root package name */
        Resources f١٧٦٣٤b;

        /* renamed from: c, reason: collision with root package name */
        int f١٧٦٣٥c;

        /* renamed from: d, reason: collision with root package name */
        int f١٧٦٣٦d;

        /* renamed from: e, reason: collision with root package name */
        int f١٧٦٣٧e;

        /* renamed from: f, reason: collision with root package name */
        SparseArray f١٧٦٣٨f;

        /* renamed from: g, reason: collision with root package name */
        Drawable[] f١٧٦٣٩g;

        /* renamed from: h, reason: collision with root package name */
        int f١٧٦٤٠h;

        /* renamed from: i, reason: collision with root package name */
        boolean f١٧٦٤١i;

        /* renamed from: j, reason: collision with root package name */
        boolean f١٧٦٤٢j;

        /* renamed from: k, reason: collision with root package name */
        Rect f١٧٦٤٣k;

        /* renamed from: l, reason: collision with root package name */
        boolean f١٧٦٤٤l;

        /* renamed from: m, reason: collision with root package name */
        boolean f١٧٦٤٥m;

        /* renamed from: n, reason: collision with root package name */
        int f١٧٦٤٦n;

        /* renamed from: o, reason: collision with root package name */
        int f١٧٦٤٧o;

        /* renamed from: p, reason: collision with root package name */
        int f١٧٦٤٨p;

        /* renamed from: q, reason: collision with root package name */
        int f١٧٦٤٩q;

        /* renamed from: r, reason: collision with root package name */
        boolean f١٧٦٥٠r;

        /* renamed from: s, reason: collision with root package name */
        int f١٧٦٥١s;

        /* renamed from: t, reason: collision with root package name */
        boolean f١٧٦٥٢t;

        /* renamed from: u, reason: collision with root package name */
        boolean f١٧٦٥٣u;

        /* renamed from: v, reason: collision with root package name */
        boolean f١٧٦٥٤v;

        /* renamed from: w, reason: collision with root package name */
        boolean f١٧٦٥٥w;

        /* renamed from: x, reason: collision with root package name */
        boolean f١٧٦٥٦x;

        /* renamed from: y, reason: collision with root package name */
        boolean f١٧٦٥٧y;

        /* renamed from: z, reason: collision with root package name */
        int f١٧٦٥٨z;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(d dVar, b bVar, Resources resources) {
            Resources resources2;
            int i10;
            this.f١٧٦٤١i = false;
            this.f١٧٦٤٤l = false;
            this.f١٧٦٥٦x = true;
            this.A = 0;
            this.f١٧٦٣٢B = 0;
            this.f١٧٦٣٣a = bVar;
            if (resources != null) {
                resources2 = resources;
            } else if (dVar != null) {
                resources2 = dVar.f١٧٦٣٤b;
            } else {
                resources2 = null;
            }
            this.f١٧٦٣٤b = resources2;
            if (dVar != null) {
                i10 = dVar.f١٧٦٣٥c;
            } else {
                i10 = 0;
            }
            int f10 = b.f(resources, i10);
            this.f١٧٦٣٥c = f10;
            if (dVar != null) {
                this.f١٧٦٣٦d = dVar.f١٧٦٣٦d;
                this.f١٧٦٣٧e = dVar.f١٧٦٣٧e;
                this.f١٧٦٥٤v = true;
                this.f١٧٦٥٥w = true;
                this.f١٧٦٤١i = dVar.f١٧٦٤١i;
                this.f١٧٦٤٤l = dVar.f١٧٦٤٤l;
                this.f١٧٦٥٦x = dVar.f١٧٦٥٦x;
                this.f١٧٦٥٧y = dVar.f١٧٦٥٧y;
                this.f١٧٦٥٨z = dVar.f١٧٦٥٨z;
                this.A = dVar.A;
                this.f١٧٦٣٢B = dVar.f١٧٦٣٢B;
                this.C = dVar.C;
                this.D = dVar.D;
                this.E = dVar.E;
                this.F = dVar.F;
                this.G = dVar.G;
                this.H = dVar.H;
                this.I = dVar.I;
                if (dVar.f١٧٦٣٥c == f10) {
                    if (dVar.f١٧٦٤٢j) {
                        this.f١٧٦٤٣k = dVar.f١٧٦٤٣k != null ? new Rect(dVar.f١٧٦٤٣k) : null;
                        this.f١٧٦٤٢j = true;
                    }
                    if (dVar.f١٧٦٤٥m) {
                        this.f١٧٦٤٦n = dVar.f١٧٦٤٦n;
                        this.f١٧٦٤٧o = dVar.f١٧٦٤٧o;
                        this.f١٧٦٤٨p = dVar.f١٧٦٤٨p;
                        this.f١٧٦٤٩q = dVar.f١٧٦٤٩q;
                        this.f١٧٦٤٥m = true;
                    }
                }
                if (dVar.f١٧٦٥٠r) {
                    this.f١٧٦٥١s = dVar.f١٧٦٥١s;
                    this.f١٧٦٥٠r = true;
                }
                if (dVar.f١٧٦٥٢t) {
                    this.f١٧٦٥٣u = dVar.f١٧٦٥٣u;
                    this.f١٧٦٥٢t = true;
                }
                Drawable[] drawableArr = dVar.f١٧٦٣٩g;
                this.f١٧٦٣٩g = new Drawable[drawableArr.length];
                this.f١٧٦٤٠h = dVar.f١٧٦٤٠h;
                SparseArray sparseArray = dVar.f١٧٦٣٨f;
                if (sparseArray != null) {
                    this.f١٧٦٣٨f = sparseArray.clone();
                } else {
                    this.f١٧٦٣٨f = new SparseArray(this.f١٧٦٤٠h);
                }
                int i11 = this.f١٧٦٤٠h;
                for (int i12 = 0; i12 < i11; i12++) {
                    Drawable drawable = drawableArr[i12];
                    if (drawable != null) {
                        Drawable.ConstantState constantState = drawable.getConstantState();
                        if (constantState != null) {
                            this.f١٧٦٣٨f.put(i12, constantState);
                        } else {
                            this.f١٧٦٣٩g[i12] = drawableArr[i12];
                        }
                    }
                }
                return;
            }
            this.f١٧٦٣٩g = new Drawable[10];
            this.f١٧٦٤٠h = 0;
        }

        private void e() {
            SparseArray sparseArray = this.f١٧٦٣٨f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i10 = 0; i10 < size; i10++) {
                    this.f١٧٦٣٩g[this.f١٧٦٣٨f.keyAt(i10)] = s(((Drawable.ConstantState) this.f١٧٦٣٨f.valueAt(i10)).newDrawable(this.f١٧٦٣٤b));
                }
                this.f١٧٦٣٨f = null;
            }
        }

        private Drawable s(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                h2.b.m(drawable, this.f١٧٦٥٨z);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f١٧٦٣٣a);
            return mutate;
        }

        public final int a(Drawable drawable) {
            int i10 = this.f١٧٦٤٠h;
            if (i10 >= this.f١٧٦٣٩g.length) {
                o(i10, i10 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f١٧٦٣٣a);
            this.f١٧٦٣٩g[i10] = drawable;
            this.f١٧٦٤٠h++;
            this.f١٧٦٣٧e = drawable.getChangingConfigurations() | this.f١٧٦٣٧e;
            p();
            this.f١٧٦٤٣k = null;
            this.f١٧٦٤٢j = false;
            this.f١٧٦٤٥m = false;
            this.f١٧٦٥٤v = false;
            return i10;
        }

        final void b(Resources.Theme theme) {
            if (theme != null) {
                e();
                int i10 = this.f١٧٦٤٠h;
                Drawable[] drawableArr = this.f١٧٦٣٩g;
                for (int i11 = 0; i11 < i10; i11++) {
                    Drawable drawable = drawableArr[i11];
                    if (drawable != null && h2.b.b(drawable)) {
                        h2.b.a(drawableArr[i11], theme);
                        this.f١٧٦٣٧e |= drawableArr[i11].getChangingConfigurations();
                    }
                }
                y(C٠٢٢٣b.c(theme));
            }
        }

        public boolean c() {
            if (this.f١٧٦٥٤v) {
                return this.f١٧٦٥٥w;
            }
            e();
            this.f١٧٦٥٤v = true;
            int i10 = this.f١٧٦٤٠h;
            Drawable[] drawableArr = this.f١٧٦٣٩g;
            for (int i11 = 0; i11 < i10; i11++) {
                if (drawableArr[i11].getConstantState() == null) {
                    this.f١٧٦٥٥w = false;
                    return false;
                }
            }
            this.f١٧٦٥٥w = true;
            return true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i10 = this.f١٧٦٤٠h;
            Drawable[] drawableArr = this.f١٧٦٣٩g;
            for (int i11 = 0; i11 < i10; i11++) {
                Drawable drawable = drawableArr[i11];
                if (drawable != null) {
                    if (h2.b.b(drawable)) {
                        return true;
                    }
                } else {
                    Drawable.ConstantState constantState = (Drawable.ConstantState) this.f١٧٦٣٨f.get(i11);
                    if (constantState != null && C٠٢٢٣b.a(constantState)) {
                        return true;
                    }
                }
            }
            return false;
        }

        protected void d() {
            this.f١٧٦٤٥m = true;
            e();
            int i10 = this.f١٧٦٤٠h;
            Drawable[] drawableArr = this.f١٧٦٣٩g;
            this.f١٧٦٤٧o = -1;
            this.f١٧٦٤٦n = -1;
            this.f١٧٦٤٩q = 0;
            this.f١٧٦٤٨p = 0;
            for (int i11 = 0; i11 < i10; i11++) {
                Drawable drawable = drawableArr[i11];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f١٧٦٤٦n) {
                    this.f١٧٦٤٦n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f١٧٦٤٧o) {
                    this.f١٧٦٤٧o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f١٧٦٤٨p) {
                    this.f١٧٦٤٨p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f١٧٦٤٩q) {
                    this.f١٧٦٤٩q = minimumHeight;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int f() {
            return this.f١٧٦٣٩g.length;
        }

        public final Drawable g(int i10) {
            int indexOfKey;
            Drawable drawable = this.f١٧٦٣٩g[i10];
            if (drawable != null) {
                return drawable;
            }
            SparseArray sparseArray = this.f١٧٦٣٨f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i10)) < 0) {
                return null;
            }
            Drawable s10 = s(((Drawable.ConstantState) this.f١٧٦٣٨f.valueAt(indexOfKey)).newDrawable(this.f١٧٦٣٤b));
            this.f١٧٦٣٩g[i10] = s10;
            this.f١٧٦٣٨f.removeAt(indexOfKey);
            if (this.f١٧٦٣٨f.size() == 0) {
                this.f١٧٦٣٨f = null;
            }
            return s10;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f١٧٦٣٦d | this.f١٧٦٣٧e;
        }

        public final int h() {
            return this.f١٧٦٤٠h;
        }

        public final int i() {
            if (!this.f١٧٦٤٥m) {
                d();
            }
            return this.f١٧٦٤٧o;
        }

        public final int j() {
            if (!this.f١٧٦٤٥m) {
                d();
            }
            return this.f١٧٦٤٩q;
        }

        public final int k() {
            if (!this.f١٧٦٤٥m) {
                d();
            }
            return this.f١٧٦٤٨p;
        }

        public final Rect l() {
            Rect rect = null;
            if (this.f١٧٦٤١i) {
                return null;
            }
            Rect rect2 = this.f١٧٦٤٣k;
            if (rect2 == null && !this.f١٧٦٤٢j) {
                e();
                Rect rect3 = new Rect();
                int i10 = this.f١٧٦٤٠h;
                Drawable[] drawableArr = this.f١٧٦٣٩g;
                for (int i11 = 0; i11 < i10; i11++) {
                    if (drawableArr[i11].getPadding(rect3)) {
                        if (rect == null) {
                            rect = new Rect(0, 0, 0, 0);
                        }
                        int i12 = rect3.left;
                        if (i12 > rect.left) {
                            rect.left = i12;
                        }
                        int i13 = rect3.top;
                        if (i13 > rect.top) {
                            rect.top = i13;
                        }
                        int i14 = rect3.right;
                        if (i14 > rect.right) {
                            rect.right = i14;
                        }
                        int i15 = rect3.bottom;
                        if (i15 > rect.bottom) {
                            rect.bottom = i15;
                        }
                    }
                }
                this.f١٧٦٤٢j = true;
                this.f١٧٦٤٣k = rect;
                return rect;
            }
            return rect2;
        }

        public final int m() {
            if (!this.f١٧٦٤٥m) {
                d();
            }
            return this.f١٧٦٤٦n;
        }

        public final int n() {
            int i10;
            if (this.f١٧٦٥٠r) {
                return this.f١٧٦٥١s;
            }
            e();
            int i11 = this.f١٧٦٤٠h;
            Drawable[] drawableArr = this.f١٧٦٣٩g;
            if (i11 > 0) {
                i10 = drawableArr[0].getOpacity();
            } else {
                i10 = -2;
            }
            for (int i12 = 1; i12 < i11; i12++) {
                i10 = Drawable.resolveOpacity(i10, drawableArr[i12].getOpacity());
            }
            this.f١٧٦٥١s = i10;
            this.f١٧٦٥٠r = true;
            return i10;
        }

        public void o(int i10, int i11) {
            Drawable[] drawableArr = new Drawable[i11];
            Drawable[] drawableArr2 = this.f١٧٦٣٩g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i10);
            }
            this.f١٧٦٣٩g = drawableArr;
        }

        void p() {
            this.f١٧٦٥٠r = false;
            this.f١٧٦٥٢t = false;
        }

        public final boolean q() {
            return this.f١٧٦٤٤l;
        }

        abstract void r();

        public final void t(boolean z10) {
            this.f١٧٦٤٤l = z10;
        }

        public final void u(int i10) {
            this.A = i10;
        }

        public final void v(int i10) {
            this.f١٧٦٣٢B = i10;
        }

        final boolean w(int i10, int i11) {
            boolean z10;
            int i12 = this.f١٧٦٤٠h;
            Drawable[] drawableArr = this.f١٧٦٣٩g;
            boolean z11 = false;
            for (int i13 = 0; i13 < i12; i13++) {
                Drawable drawable = drawableArr[i13];
                if (drawable != null) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        z10 = h2.b.m(drawable, i10);
                    } else {
                        z10 = false;
                    }
                    if (i13 == i11) {
                        z11 = z10;
                    }
                }
            }
            this.f١٧٦٥٨z = i10;
            return z11;
        }

        public final void x(boolean z10) {
            this.f١٧٦٤١i = z10;
        }

        final void y(Resources resources) {
            if (resources != null) {
                this.f١٧٦٣٤b = resources;
                int f10 = b.f(resources, this.f١٧٦٣٥c);
                int i10 = this.f١٧٦٣٥c;
                this.f١٧٦٣٥c = f10;
                if (i10 != f10) {
                    this.f١٧٦٤٥m = false;
                    this.f١٧٦٤٢j = false;
                }
            }
        }
    }

    private void d(Drawable drawable) {
        if (this.f١٧٦٢٩l == null) {
            this.f١٧٦٢٩l = new c();
        }
        drawable.setCallback(this.f١٧٦٢٩l.b(drawable.getCallback()));
        try {
            if (this.f١٧٦١٨a.A <= 0 && this.f١٧٦٢٣f) {
                drawable.setAlpha(this.f١٧٦٢٢e);
            }
            d dVar = this.f١٧٦١٨a;
            if (dVar.E) {
                drawable.setColorFilter(dVar.D);
            } else {
                if (dVar.H) {
                    h2.b.o(drawable, dVar.F);
                }
                d dVar2 = this.f١٧٦١٨a;
                if (dVar2.I) {
                    h2.b.p(drawable, dVar2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f١٧٦١٨a.f١٧٦٥٦x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                h2.b.m(drawable, h2.b.f(this));
            }
            h2.b.j(drawable, this.f١٧٦١٨a.C);
            Rect rect = this.f١٧٦١٩b;
            if (rect != null) {
                h2.b.l(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
            drawable.setCallback(this.f١٧٦٢٩l.a());
        } catch (Throwable th) {
            drawable.setCallback(this.f١٧٦٢٩l.a());
            throw th;
        }
    }

    private boolean e() {
        if (isAutoMirrored() && h2.b.f(this) == 1) {
            return true;
        }
        return false;
    }

    static int f(Resources resources, int i10) {
        if (resources != null) {
            i10 = resources.getDisplayMetrics().densityDpi;
        }
        if (i10 == 0) {
            return Constants.ERR_ALREADY_IN_RECORDING;
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(boolean z10) {
        boolean z11;
        Drawable drawable;
        boolean z12 = true;
        this.f١٧٦٢٣f = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.f١٧٦٢٠c;
        if (drawable2 != null) {
            long j10 = this.f١٧٦٢٧j;
            if (j10 != 0) {
                if (j10 <= uptimeMillis) {
                    drawable2.setAlpha(this.f١٧٦٢٢e);
                    this.f١٧٦٢٧j = 0L;
                } else {
                    drawable2.setAlpha(((255 - (((int) ((j10 - uptimeMillis) * 255)) / this.f١٧٦١٨a.A)) * this.f١٧٦٢٢e) / KotlinVersion.MAX_COMPONENT_VALUE);
                    z11 = true;
                    drawable = this.f١٧٦٢١d;
                    if (drawable == null) {
                        long j11 = this.f١٧٦٢٨k;
                        if (j11 != 0) {
                            if (j11 <= uptimeMillis) {
                                drawable.setVisible(false, false);
                                this.f١٧٦٢١d = null;
                                this.f١٧٦٢٨k = 0L;
                            } else {
                                drawable.setAlpha(((((int) ((j11 - uptimeMillis) * 255)) / this.f١٧٦١٨a.f١٧٦٣٢B) * this.f١٧٦٢٢e) / KotlinVersion.MAX_COMPONENT_VALUE);
                                if (z10 && z12) {
                                    scheduleSelf(this.f١٧٦٢٦i, uptimeMillis + 16);
                                    return;
                                }
                                return;
                            }
                        }
                    } else {
                        this.f١٧٦٢٨k = 0L;
                    }
                    z12 = z11;
                    if (z10) {
                        return;
                    } else {
                        return;
                    }
                }
            }
        } else {
            this.f١٧٦٢٧j = 0L;
        }
        z11 = false;
        drawable = this.f١٧٦٢١d;
        if (drawable == null) {
        }
        z12 = z11;
        if (z10) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f١٧٦١٨a.b(theme);
    }

    abstract d b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f١٧٦٢٤g;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f١٧٦١٨a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f١٧٦٢٠c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f١٧٦٢١d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g(int i10) {
        Runnable runnable;
        if (i10 == this.f١٧٦٢٤g) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f١٧٦١٨a.f١٧٦٣٢B > 0) {
            Drawable drawable = this.f١٧٦٢١d;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.f١٧٦٢٠c;
            if (drawable2 != null) {
                this.f١٧٦٢١d = drawable2;
                this.f١٧٦٢٨k = this.f١٧٦١٨a.f١٧٦٣٢B + uptimeMillis;
            } else {
                this.f١٧٦٢١d = null;
                this.f١٧٦٢٨k = 0L;
            }
        } else {
            Drawable drawable3 = this.f١٧٦٢٠c;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i10 >= 0) {
            d dVar = this.f١٧٦١٨a;
            if (i10 < dVar.f١٧٦٤٠h) {
                Drawable g10 = dVar.g(i10);
                this.f١٧٦٢٠c = g10;
                this.f١٧٦٢٤g = i10;
                if (g10 != null) {
                    int i11 = this.f١٧٦١٨a.A;
                    if (i11 > 0) {
                        this.f١٧٦٢٧j = uptimeMillis + i11;
                    }
                    d(g10);
                }
                if (this.f١٧٦٢٧j == 0 || this.f١٧٦٢٨k != 0) {
                    runnable = this.f١٧٦٢٦i;
                    if (runnable != null) {
                        this.f١٧٦٢٦i = new a();
                    } else {
                        unscheduleSelf(runnable);
                    }
                    a(true);
                }
                invalidateSelf();
                return true;
            }
        }
        this.f١٧٦٢٠c = null;
        this.f١٧٦٢٤g = -1;
        if (this.f١٧٦٢٧j == 0) {
        }
        runnable = this.f١٧٦٢٦i;
        if (runnable != null) {
        }
        a(true);
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f١٧٦٢٢e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f١٧٦١٨a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f١٧٦١٨a.c()) {
            this.f١٧٦١٨a.f١٧٦٣٦d = getChangingConfigurations();
            return this.f١٧٦١٨a;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f١٧٦٢٠c;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f١٧٦١٩b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f١٧٦١٨a.q()) {
            return this.f١٧٦١٨a.i();
        }
        Drawable drawable = this.f١٧٦٢٠c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f١٧٦١٨a.q()) {
            return this.f١٧٦١٨a.m();
        }
        Drawable drawable = this.f١٧٦٢٠c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f١٧٦١٨a.q()) {
            return this.f١٧٦١٨a.j();
        }
        Drawable drawable = this.f١٧٦٢٠c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f١٧٦١٨a.q()) {
            return this.f١٧٦١٨a.k();
        }
        Drawable drawable = this.f١٧٦٢٠c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f١٧٦٢٠c;
        if (drawable != null && drawable.isVisible()) {
            return this.f١٧٦١٨a.n();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f١٧٦٢٠c;
        if (drawable != null) {
            C٠٢٢٣b.b(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect l10 = this.f١٧٦١٨a.l();
        if (l10 != null) {
            rect.set(l10);
            if ((l10.right | l10.left | l10.top | l10.bottom) != 0) {
                padding = true;
            } else {
                padding = false;
            }
        } else {
            Drawable drawable = this.f١٧٦٢٠c;
            if (drawable != null) {
                padding = drawable.getPadding(rect);
            } else {
                padding = super.getPadding(rect);
            }
        }
        if (e()) {
            int i10 = rect.left;
            rect.left = rect.right;
            rect.right = i10;
        }
        return padding;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(d dVar) {
        this.f١٧٦١٨a = dVar;
        int i10 = this.f١٧٦٢٤g;
        if (i10 >= 0) {
            Drawable g10 = dVar.g(i10);
            this.f١٧٦٢٠c = g10;
            if (g10 != null) {
                d(g10);
            }
        }
        this.f١٧٦٢١d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i(Resources resources) {
        this.f١٧٦١٨a.y(resources);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        d dVar = this.f١٧٦١٨a;
        if (dVar != null) {
            dVar.p();
        }
        if (drawable == this.f١٧٦٢٠c && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f١٧٦١٨a.C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z10;
        Drawable drawable = this.f١٧٦٢١d;
        boolean z11 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f١٧٦٢١d = null;
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable drawable2 = this.f١٧٦٢٠c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f١٧٦٢٣f) {
                this.f١٧٦٢٠c.setAlpha(this.f١٧٦٢٢e);
            }
        }
        if (this.f١٧٦٢٨k != 0) {
            this.f١٧٦٢٨k = 0L;
            z10 = true;
        }
        if (this.f١٧٦٢٧j != 0) {
            this.f١٧٦٢٧j = 0L;
        } else {
            z11 = z10;
        }
        if (z11) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f١٧٦٢٥h && super.mutate() == this) {
            d b10 = b();
            b10.r();
            h(b10);
            this.f١٧٦٢٥h = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f١٧٦٢١d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f١٧٦٢٠c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i10) {
        return this.f١٧٦١٨a.w(i10, c());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i10) {
        Drawable drawable = this.f١٧٦٢١d;
        if (drawable != null) {
            return drawable.setLevel(i10);
        }
        Drawable drawable2 = this.f١٧٦٢٠c;
        if (drawable2 != null) {
            return drawable2.setLevel(i10);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        if (drawable == this.f١٧٦٢٠c && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (!this.f١٧٦٢٣f || this.f١٧٦٢٢e != i10) {
            this.f١٧٦٢٣f = true;
            this.f١٧٦٢٢e = i10;
            Drawable drawable = this.f١٧٦٢٠c;
            if (drawable != null) {
                if (this.f١٧٦٢٧j == 0) {
                    drawable.setAlpha(i10);
                } else {
                    a(false);
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        d dVar = this.f١٧٦١٨a;
        if (dVar.C != z10) {
            dVar.C = z10;
            Drawable drawable = this.f١٧٦٢٠c;
            if (drawable != null) {
                h2.b.j(drawable, z10);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        d dVar = this.f١٧٦١٨a;
        dVar.E = true;
        if (dVar.D != colorFilter) {
            dVar.D = colorFilter;
            Drawable drawable = this.f١٧٦٢٠c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z10) {
        d dVar = this.f١٧٦١٨a;
        if (dVar.f١٧٦٥٦x != z10) {
            dVar.f١٧٦٥٦x = z10;
            Drawable drawable = this.f١٧٦٢٠c;
            if (drawable != null) {
                drawable.setDither(z10);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f10, float f11) {
        Drawable drawable = this.f١٧٦٢٠c;
        if (drawable != null) {
            h2.b.k(drawable, f10, f11);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i10, int i11, int i12, int i13) {
        Rect rect = this.f١٧٦١٩b;
        if (rect == null) {
            this.f١٧٦١٩b = new Rect(i10, i11, i12, i13);
        } else {
            rect.set(i10, i11, i12, i13);
        }
        Drawable drawable = this.f١٧٦٢٠c;
        if (drawable != null) {
            h2.b.l(drawable, i10, i11, i12, i13);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        d dVar = this.f١٧٦١٨a;
        dVar.H = true;
        if (dVar.F != colorStateList) {
            dVar.F = colorStateList;
            h2.b.o(this.f١٧٦٢٠c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        d dVar = this.f١٧٦١٨a;
        dVar.I = true;
        if (dVar.G != mode) {
            dVar.G = mode;
            h2.b.p(this.f١٧٦٢٠c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        Drawable drawable = this.f١٧٦٢١d;
        if (drawable != null) {
            drawable.setVisible(z10, z11);
        }
        Drawable drawable2 = this.f١٧٦٢٠c;
        if (drawable2 != null) {
            drawable2.setVisible(z10, z11);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.f١٧٦٢٠c && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c implements Drawable.Callback {

        /* renamed from: a, reason: collision with root package name */
        private Drawable.Callback f١٧٦٣١a;

        c() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f١٧٦٣١a;
            this.f١٧٦٣١a = null;
            return callback;
        }

        public c b(Drawable.Callback callback) {
            this.f١٧٦٣١a = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            Drawable.Callback callback = this.f١٧٦٣١a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j10);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f١٧٦٣١a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }
    }
}
