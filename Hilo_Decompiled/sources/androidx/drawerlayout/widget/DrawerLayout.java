package androidx.drawerlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.graphics.b0;
import androidx.core.view.d1;
import androidx.core.view.d2;
import androidx.core.view.t;
import androidx.customview.view.AbsSavedState;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinVersion;
import m2.g0;
import m2.j0;
import s2.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DrawerLayout extends ViewGroup {
    private static final int[] L = {R.attr.colorPrimaryDark};
    static final int[] M = {R.attr.layout_gravity};
    static final boolean N;
    private static final boolean O;
    private static boolean P;
    private CharSequence A;

    /* renamed from: B, reason: collision with root package name */
    private Object f٣٥٤١B;
    private boolean C;
    private Drawable D;
    private Drawable E;
    private Drawable F;
    private Drawable G;
    private final ArrayList H;
    private Rect I;
    private Matrix J;
    private final j0 K;

    /* renamed from: a, reason: collision with root package name */
    private final d f٣٥٤٢a;

    /* renamed from: b, reason: collision with root package name */
    private float f٣٥٤٣b;

    /* renamed from: c, reason: collision with root package name */
    private int f٣٥٤٤c;

    /* renamed from: d, reason: collision with root package name */
    private int f٣٥٤٥d;

    /* renamed from: e, reason: collision with root package name */
    private float f٣٥٤٦e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f٣٥٤٧f;

    /* renamed from: g, reason: collision with root package name */
    private final s2.c f٣٥٤٨g;

    /* renamed from: h, reason: collision with root package name */
    private final s2.c f٣٥٤٩h;

    /* renamed from: i, reason: collision with root package name */
    private final h f٣٥٥٠i;

    /* renamed from: j, reason: collision with root package name */
    private final h f٣٥٥١j;

    /* renamed from: k, reason: collision with root package name */
    private int f٣٥٥٢k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f٣٥٥٣l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f٣٥٥٤m;

    /* renamed from: n, reason: collision with root package name */
    private int f٣٥٥٥n;

    /* renamed from: o, reason: collision with root package name */
    private int f٣٥٥٦o;

    /* renamed from: p, reason: collision with root package name */
    private int f٣٥٥٧p;

    /* renamed from: q, reason: collision with root package name */
    private int f٣٥٥٨q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f٣٥٥٩r;

    /* renamed from: s, reason: collision with root package name */
    private e f٣٥٦٠s;

    /* renamed from: t, reason: collision with root package name */
    private List f٣٥٦١t;

    /* renamed from: u, reason: collision with root package name */
    private float f٣٥٦٢u;

    /* renamed from: v, reason: collision with root package name */
    private float f٣٥٦٣v;

    /* renamed from: w, reason: collision with root package name */
    private Drawable f٣٥٦٤w;

    /* renamed from: x, reason: collision with root package name */
    private Drawable f٣٥٦٥x;

    /* renamed from: y, reason: collision with root package name */
    private Drawable f٣٥٦٦y;

    /* renamed from: z, reason: collision with root package name */
    private CharSequence f٣٥٦٧z;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements j0 {
        a() {
        }

        @Override // m2.j0
        public boolean perform(View view, j0.a aVar) {
            if (DrawerLayout.this.A(view) && DrawerLayout.this.p(view) != 2) {
                DrawerLayout.this.d(view);
                return true;
            }
            return false;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b implements View.OnApplyWindowInsetsListener {
        b() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            boolean z10;
            DrawerLayout drawerLayout = (DrawerLayout) view;
            if (windowInsets.getSystemWindowInsetTop() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            drawerLayout.M(windowInsets, z10);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class c extends androidx.core.view.a {

        /* renamed from: a, reason: collision with root package name */
        private final Rect f٣٥٧٥a = new Rect();

        c() {
        }

        private void c(g0 g0Var, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (DrawerLayout.y(childAt)) {
                    g0Var.c(childAt);
                }
            }
        }

        private void d(g0 g0Var, g0 g0Var2) {
            Rect rect = this.f٣٥٧٥a;
            g0Var2.n(rect);
            g0Var.k0(rect);
            g0Var.T0(g0Var2.Z());
            g0Var.E0(g0Var2.z());
            g0Var.o0(g0Var2.q());
            g0Var.s0(g0Var2.t());
            g0Var.u0(g0Var2.O());
            g0Var.x0(g0Var2.Q());
            g0Var.h0(g0Var2.J());
            g0Var.M0(g0Var2.W());
            g0Var.a(g0Var2.k());
        }

        @Override // androidx.core.view.a
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() == 32) {
                List<CharSequence> text = accessibilityEvent.getText();
                View n10 = DrawerLayout.this.n();
                if (n10 != null) {
                    CharSequence q10 = DrawerLayout.this.q(DrawerLayout.this.r(n10));
                    if (q10 != null) {
                        text.add(q10);
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View view, g0 g0Var) {
            if (DrawerLayout.N) {
                super.onInitializeAccessibilityNodeInfo(view, g0Var);
            } else {
                g0 c02 = g0.c0(g0Var);
                super.onInitializeAccessibilityNodeInfo(view, c02);
                g0Var.O0(view);
                Object J = d1.J(view);
                if (J instanceof View) {
                    g0Var.G0((View) J);
                }
                d(g0Var, c02);
                c02.e0();
                c(g0Var, (ViewGroup) view);
            }
            g0Var.o0("androidx.drawerlayout.widget.DrawerLayout");
            g0Var.w0(false);
            g0Var.x0(false);
            g0Var.f0(g0.a.f١٥٩٢٦e);
            g0Var.f0(g0.a.f١٥٩٢٧f);
        }

        @Override // androidx.core.view.a
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!DrawerLayout.N && !DrawerLayout.y(view)) {
                return false;
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static final class d extends androidx.core.view.a {
        d() {
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View view, g0 g0Var) {
            super.onInitializeAccessibilityNodeInfo(view, g0Var);
            if (!DrawerLayout.y(view)) {
                g0Var.G0(null);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface e {
        void a(View view);

        void b(View view);

        void c(int i10);

        void d(View view, float f10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class g implements e {
        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void c(int i10) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void d(View view, float f10) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class h extends c.AbstractC٠٢٢٦c {

        /* renamed from: a, reason: collision with root package name */
        private final int f٣٥٨١a;

        /* renamed from: b, reason: collision with root package name */
        private s2.c f٣٥٨٢b;

        /* renamed from: c, reason: collision with root package name */
        private final Runnable f٣٥٨٣c = new a();

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.b();
            }
        }

        h(int i10) {
            this.f٣٥٨١a = i10;
        }

        private void a() {
            int i10 = 3;
            if (this.f٣٥٨١a == 3) {
                i10 = 5;
            }
            View l10 = DrawerLayout.this.l(i10);
            if (l10 != null) {
                DrawerLayout.this.d(l10);
            }
        }

        void b() {
            boolean z10;
            View l10;
            int width;
            int y10 = this.f٣٥٨٢b.y();
            int i10 = 0;
            if (this.f٣٥٨١a == 3) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                l10 = DrawerLayout.this.l(3);
                if (l10 != null) {
                    i10 = -l10.getWidth();
                }
                width = i10 + y10;
            } else {
                l10 = DrawerLayout.this.l(5);
                width = DrawerLayout.this.getWidth() - y10;
            }
            if (l10 != null) {
                if (((z10 && l10.getLeft() < width) || (!z10 && l10.getLeft() > width)) && DrawerLayout.this.p(l10) == 0) {
                    f fVar = (f) l10.getLayoutParams();
                    this.f٣٥٨٢b.R(l10, width, l10.getTop());
                    fVar.f٣٥٧٩c = true;
                    DrawerLayout.this.invalidate();
                    a();
                    DrawerLayout.this.b();
                }
            }
        }

        public void c() {
            DrawerLayout.this.removeCallbacks(this.f٣٥٨٣c);
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public int clampViewPositionHorizontal(View view, int i10, int i11) {
            if (DrawerLayout.this.c(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i10, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i10, width));
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public int clampViewPositionVertical(View view, int i10, int i11) {
            return view.getTop();
        }

        public void d(s2.c cVar) {
            this.f٣٥٨٢b = cVar;
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public int getViewHorizontalDragRange(View view) {
            if (DrawerLayout.this.B(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public void onEdgeDragStarted(int i10, int i11) {
            View l10;
            if ((i10 & 1) == 1) {
                l10 = DrawerLayout.this.l(3);
            } else {
                l10 = DrawerLayout.this.l(5);
            }
            if (l10 != null && DrawerLayout.this.p(l10) == 0) {
                this.f٣٥٨٢b.c(l10, i11);
            }
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public boolean onEdgeLock(int i10) {
            return false;
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public void onEdgeTouched(int i10, int i11) {
            DrawerLayout.this.postDelayed(this.f٣٥٨٣c, 160L);
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public void onViewCaptured(View view, int i10) {
            ((f) view.getLayoutParams()).f٣٥٧٩c = false;
            a();
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public void onViewDragStateChanged(int i10) {
            DrawerLayout.this.R(i10, this.f٣٥٨٢b.w());
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public void onViewPositionChanged(View view, int i10, int i11, int i12, int i13) {
            float width;
            int i14;
            int width2 = view.getWidth();
            if (DrawerLayout.this.c(view, 3)) {
                width = i10 + width2;
            } else {
                width = DrawerLayout.this.getWidth() - i10;
            }
            float f10 = width / width2;
            DrawerLayout.this.O(view, f10);
            if (f10 == DownloadProgress.UNKNOWN_PROGRESS) {
                i14 = 4;
            } else {
                i14 = 0;
            }
            view.setVisibility(i14);
            DrawerLayout.this.invalidate();
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public void onViewReleased(View view, float f10, float f11) {
            int i10;
            float s10 = DrawerLayout.this.s(view);
            int width = view.getWidth();
            if (DrawerLayout.this.c(view, 3)) {
                if (f10 <= DownloadProgress.UNKNOWN_PROGRESS && (f10 != DownloadProgress.UNKNOWN_PROGRESS || s10 <= 0.5f)) {
                    i10 = -width;
                } else {
                    i10 = 0;
                }
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f10 < DownloadProgress.UNKNOWN_PROGRESS || (f10 == DownloadProgress.UNKNOWN_PROGRESS && s10 > 0.5f)) {
                    width2 -= width;
                }
                i10 = width2;
            }
            this.f٣٥٨٢b.P(i10, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public boolean tryCaptureView(View view, int i10) {
            if (DrawerLayout.this.B(view) && DrawerLayout.this.c(view, this.f٣٥٨١a) && DrawerLayout.this.p(view) == 0) {
                return true;
            }
            return false;
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = true;
        N = true;
        O = true;
        if (i10 < 29) {
            z10 = false;
        }
        P = z10;
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    private boolean D(float f10, float f11, View view) {
        if (this.I == null) {
            this.I = new Rect();
        }
        view.getHitRect(this.I);
        return this.I.contains((int) f10, (int) f11);
    }

    private void E(Drawable drawable, int i10) {
        if (drawable != null && h2.b.h(drawable)) {
            h2.b.m(drawable, i10);
        }
    }

    private Drawable J() {
        int D = d1.D(this);
        if (D == 0) {
            Drawable drawable = this.D;
            if (drawable != null) {
                E(drawable, D);
                return this.D;
            }
        } else {
            Drawable drawable2 = this.E;
            if (drawable2 != null) {
                E(drawable2, D);
                return this.E;
            }
        }
        return this.F;
    }

    private Drawable K() {
        int D = d1.D(this);
        if (D == 0) {
            Drawable drawable = this.E;
            if (drawable != null) {
                E(drawable, D);
                return this.E;
            }
        } else {
            Drawable drawable2 = this.D;
            if (drawable2 != null) {
                E(drawable2, D);
                return this.D;
            }
        }
        return this.G;
    }

    private void L() {
        if (O) {
            return;
        }
        this.f٣٥٦٥x = J();
        this.f٣٥٦٦y = K();
    }

    private void P(View view) {
        g0.a aVar = g0.a.f١٥٩٤٦y;
        d1.k0(view, aVar.b());
        if (A(view) && p(view) != 2) {
            d1.m0(view, aVar, null, this.K);
        }
    }

    private void Q(View view, boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if ((!z10 && !B(childAt)) || (z10 && childAt == view)) {
                d1.z0(childAt, 1);
            } else {
                d1.z0(childAt, 4);
            }
        }
    }

    private boolean k(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent t10 = t(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(t10);
            t10.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    private MotionEvent t(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.J == null) {
                this.J = new Matrix();
            }
            matrix.invert(this.J);
            obtain.transform(this.J);
        }
        return obtain;
    }

    static String u(int i10) {
        if ((i10 & 3) == 3) {
            return "LEFT";
        }
        if ((i10 & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(i10);
    }

    private static boolean v(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    private boolean w() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (((f) getChildAt(i10).getLayoutParams()).f٣٥٧٩c) {
                return true;
            }
        }
        return false;
    }

    private boolean x() {
        if (n() != null) {
            return true;
        }
        return false;
    }

    static boolean y(View view) {
        if (d1.B(view) != 4 && d1.B(view) != 2) {
            return true;
        }
        return false;
    }

    public boolean A(View view) {
        if (B(view)) {
            if ((((f) view.getLayoutParams()).f٣٥٨٠d & 1) == 1) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    boolean B(View view) {
        int b10 = t.b(((f) view.getLayoutParams()).f٣٥٧٧a, d1.D(view));
        if ((b10 & 3) != 0 || (b10 & 5) != 0) {
            return true;
        }
        return false;
    }

    public boolean C(View view) {
        if (B(view)) {
            if (((f) view.getLayoutParams()).f٣٥٧٨b > DownloadProgress.UNKNOWN_PROGRESS) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    void F(View view, float f10) {
        float s10 = s(view);
        float width = view.getWidth();
        int i10 = ((int) (width * f10)) - ((int) (s10 * width));
        if (!c(view, 3)) {
            i10 = -i10;
        }
        view.offsetLeftAndRight(i10);
        O(view, f10);
    }

    public void G(View view) {
        H(view, true);
    }

    public void H(View view, boolean z10) {
        if (B(view)) {
            f fVar = (f) view.getLayoutParams();
            if (this.f٣٥٥٤m) {
                fVar.f٣٥٧٨b = 1.0f;
                fVar.f٣٥٨٠d = 1;
                Q(view, true);
                P(view);
            } else if (z10) {
                fVar.f٣٥٨٠d |= 2;
                if (c(view, 3)) {
                    this.f٣٥٤٨g.R(view, 0, view.getTop());
                } else {
                    this.f٣٥٤٩h.R(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                F(view, 1.0f);
                R(0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void I(e eVar) {
        List list;
        if (eVar == null || (list = this.f٣٥٦١t) == null) {
            return;
        }
        list.remove(eVar);
    }

    public void M(Object obj, boolean z10) {
        boolean z11;
        this.f٣٥٤١B = obj;
        this.C = z10;
        if (!z10 && getBackground() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        setWillNotDraw(z11);
        requestLayout();
    }

    public void N(int i10, int i11) {
        View l10;
        s2.c cVar;
        int b10 = t.b(i11, d1.D(this));
        if (i11 != 3) {
            if (i11 != 5) {
                if (i11 != 8388611) {
                    if (i11 == 8388613) {
                        this.f٣٥٥٨q = i10;
                    }
                } else {
                    this.f٣٥٥٧p = i10;
                }
            } else {
                this.f٣٥٥٦o = i10;
            }
        } else {
            this.f٣٥٥٥n = i10;
        }
        if (i10 != 0) {
            if (b10 == 3) {
                cVar = this.f٣٥٤٨g;
            } else {
                cVar = this.f٣٥٤٩h;
            }
            cVar.b();
        }
        if (i10 != 1) {
            if (i10 == 2 && (l10 = l(b10)) != null) {
                G(l10);
                return;
            }
            return;
        }
        View l11 = l(b10);
        if (l11 != null) {
            d(l11);
        }
    }

    void O(View view, float f10) {
        f fVar = (f) view.getLayoutParams();
        if (f10 == fVar.f٣٥٧٨b) {
            return;
        }
        fVar.f٣٥٧٨b = f10;
        j(view, f10);
    }

    void R(int i10, View view) {
        int i11;
        int B2 = this.f٣٥٤٨g.B();
        int B3 = this.f٣٥٤٩h.B();
        if (B2 != 1 && B3 != 1) {
            i11 = 2;
            if (B2 != 2 && B3 != 2) {
                i11 = 0;
            }
        } else {
            i11 = 1;
        }
        if (view != null && i10 == 0) {
            float f10 = ((f) view.getLayoutParams()).f٣٥٧٨b;
            if (f10 == DownloadProgress.UNKNOWN_PROGRESS) {
                h(view);
            } else if (f10 == 1.0f) {
                i(view);
            }
        }
        if (i11 != this.f٣٥٥٢k) {
            this.f٣٥٥٢k = i11;
            List list = this.f٣٥٦١t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((e) this.f٣٥٦١t.get(size)).c(i11);
                }
            }
        }
    }

    public void a(e eVar) {
        if (eVar == null) {
            return;
        }
        if (this.f٣٥٦١t == null) {
            this.f٣٥٦١t = new ArrayList();
        }
        this.f٣٥٦١t.add(eVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i10, int i11) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (B(childAt)) {
                if (A(childAt)) {
                    childAt.addFocusables(arrayList, i10, i11);
                    z10 = true;
                }
            } else {
                this.H.add(childAt);
            }
        }
        if (!z10) {
            int size = this.H.size();
            for (int i13 = 0; i13 < size; i13++) {
                View view = (View) this.H.get(i13);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i10, i11);
                }
            }
        }
        this.H.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        if (m() == null && !B(view)) {
            d1.z0(view, 1);
        } else {
            d1.z0(view, 4);
        }
        if (!N) {
            d1.q0(view, this.f٣٥٤٢a);
        }
    }

    void b() {
        if (!this.f٣٥٥٩r) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 0);
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                getChildAt(i10).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.f٣٥٥٩r = true;
        }
    }

    boolean c(View view, int i10) {
        if ((r(view) & i10) == i10) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof f) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        for (int i10 = 0; i10 < childCount; i10++) {
            f10 = Math.max(f10, ((f) getChildAt(i10).getLayoutParams()).f٣٥٧٨b);
        }
        this.f٣٥٤٦e = f10;
        boolean n10 = this.f٣٥٤٨g.n(true);
        boolean n11 = this.f٣٥٤٩h.n(true);
        if (n10 || n11) {
            d1.h0(this);
        }
    }

    public void d(View view) {
        e(view, true);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() != 10 && this.f٣٥٤٦e > DownloadProgress.UNKNOWN_PROGRESS) {
            int childCount = getChildCount();
            if (childCount != 0) {
                float x10 = motionEvent.getX();
                float y10 = motionEvent.getY();
                for (int i10 = childCount - 1; i10 >= 0; i10--) {
                    View childAt = getChildAt(i10);
                    if (D(x10, y10, childAt) && !z(childAt) && k(motionEvent, childAt)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j10) {
        int height = getHeight();
        boolean z10 = z(view);
        int width = getWidth();
        int save = canvas.save();
        int i10 = 0;
        if (z10) {
            int childCount = getChildCount();
            int i11 = 0;
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (childAt != view && childAt.getVisibility() == 0 && v(childAt) && B(childAt) && childAt.getHeight() >= height) {
                    if (c(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i11) {
                            i11 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i11, 0, width, getHeight());
            i10 = i11;
        }
        boolean drawChild = super.drawChild(canvas, view, j10);
        canvas.restoreToCount(save);
        float f10 = this.f٣٥٤٦e;
        if (f10 > DownloadProgress.UNKNOWN_PROGRESS && z10) {
            this.f٣٥٤٧f.setColor((this.f٣٥٤٥d & 16777215) | (((int) ((((-16777216) & r2) >>> 24) * f10)) << 24));
            canvas.drawRect(i10, DownloadProgress.UNKNOWN_PROGRESS, width, getHeight(), this.f٣٥٤٧f);
        } else if (this.f٣٥٦٥x != null && c(view, 3)) {
            int intrinsicWidth = this.f٣٥٦٥x.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(DownloadProgress.UNKNOWN_PROGRESS, Math.min(right2 / this.f٣٥٤٨g.y(), 1.0f));
            this.f٣٥٦٥x.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.f٣٥٦٥x.setAlpha((int) (max * 255.0f));
            this.f٣٥٦٥x.draw(canvas);
        } else if (this.f٣٥٦٦y != null && c(view, 5)) {
            int intrinsicWidth2 = this.f٣٥٦٦y.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(DownloadProgress.UNKNOWN_PROGRESS, Math.min((getWidth() - left2) / this.f٣٥٤٩h.y(), 1.0f));
            this.f٣٥٦٦y.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.f٣٥٦٦y.setAlpha((int) (max2 * 255.0f));
            this.f٣٥٦٦y.draw(canvas);
        }
        return drawChild;
    }

    public void e(View view, boolean z10) {
        if (B(view)) {
            f fVar = (f) view.getLayoutParams();
            if (this.f٣٥٥٤m) {
                fVar.f٣٥٧٨b = DownloadProgress.UNKNOWN_PROGRESS;
                fVar.f٣٥٨٠d = 0;
            } else if (z10) {
                fVar.f٣٥٨٠d |= 4;
                if (c(view, 3)) {
                    this.f٣٥٤٨g.R(view, -view.getWidth(), view.getTop());
                } else {
                    this.f٣٥٤٩h.R(view, getWidth(), view.getTop());
                }
            } else {
                F(view, DownloadProgress.UNKNOWN_PROGRESS);
                R(0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void f() {
        g(false);
    }

    void g(boolean z10) {
        boolean R;
        int childCount = getChildCount();
        boolean z11 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            f fVar = (f) childAt.getLayoutParams();
            if (B(childAt) && (!z10 || fVar.f٣٥٧٩c)) {
                int width = childAt.getWidth();
                if (c(childAt, 3)) {
                    R = this.f٣٥٤٨g.R(childAt, -width, childAt.getTop());
                } else {
                    R = this.f٣٥٤٩h.R(childAt, getWidth(), childAt.getTop());
                }
                z11 |= R;
                fVar.f٣٥٧٩c = false;
            }
        }
        this.f٣٥٥٠i.c();
        this.f٣٥٥١j.c();
        if (z11) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new f((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new f(layoutParams);
    }

    public float getDrawerElevation() {
        if (O) {
            return this.f٣٥٤٣b;
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f٣٥٦٤w;
    }

    void h(View view) {
        View rootView;
        f fVar = (f) view.getLayoutParams();
        if ((fVar.f٣٥٨٠d & 1) == 1) {
            fVar.f٣٥٨٠d = 0;
            List list = this.f٣٥٦١t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((e) this.f٣٥٦١t.get(size)).b(view);
                }
            }
            Q(view, false);
            P(view);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    void i(View view) {
        f fVar = (f) view.getLayoutParams();
        if ((fVar.f٣٥٨٠d & 1) == 0) {
            fVar.f٣٥٨٠d = 1;
            List list = this.f٣٥٦١t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((e) this.f٣٥٦١t.get(size)).a(view);
                }
            }
            Q(view, true);
            P(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    void j(View view, float f10) {
        List list = this.f٣٥٦١t;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((e) this.f٣٥٦١t.get(size)).d(view, f10);
            }
        }
    }

    View l(int i10) {
        int b10 = t.b(i10, d1.D(this)) & 7;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if ((r(childAt) & 7) == b10) {
                return childAt;
            }
        }
        return null;
    }

    View m() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if ((((f) childAt.getLayoutParams()).f٣٥٨٠d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    View n() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (B(childAt) && C(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public int o(int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        int D = d1.D(this);
        if (i10 != 3) {
            if (i10 != 5) {
                if (i10 != 8388611) {
                    if (i10 == 8388613) {
                        int i15 = this.f٣٥٥٨q;
                        if (i15 != 3) {
                            return i15;
                        }
                        if (D == 0) {
                            i14 = this.f٣٥٥٦o;
                        } else {
                            i14 = this.f٣٥٥٥n;
                        }
                        if (i14 != 3) {
                            return i14;
                        }
                        return 0;
                    }
                    return 0;
                }
                int i16 = this.f٣٥٥٧p;
                if (i16 != 3) {
                    return i16;
                }
                if (D == 0) {
                    i13 = this.f٣٥٥٥n;
                } else {
                    i13 = this.f٣٥٥٦o;
                }
                if (i13 != 3) {
                    return i13;
                }
                return 0;
            }
            int i17 = this.f٣٥٥٦o;
            if (i17 != 3) {
                return i17;
            }
            if (D == 0) {
                i12 = this.f٣٥٥٨q;
            } else {
                i12 = this.f٣٥٥٧p;
            }
            if (i12 != 3) {
                return i12;
            }
            return 0;
        }
        int i18 = this.f٣٥٥٥n;
        if (i18 != 3) {
            return i18;
        }
        if (D == 0) {
            i11 = this.f٣٥٥٧p;
        } else {
            i11 = this.f٣٥٥٨q;
        }
        if (i11 != 3) {
            return i11;
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f٣٥٥٤m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f٣٥٥٤m = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i10;
        super.onDraw(canvas);
        if (this.C && this.f٣٥٦٤w != null) {
            Object obj = this.f٣٥٤١B;
            if (obj != null) {
                i10 = ((WindowInsets) obj).getSystemWindowInsetTop();
            } else {
                i10 = 0;
            }
            if (i10 > 0) {
                this.f٣٥٦٤w.setBounds(0, 0, getWidth(), i10);
                this.f٣٥٦٤w.draw(canvas);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r0 != 3) goto L١٣;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        View u10;
        int actionMasked = motionEvent.getActionMasked();
        boolean Q = this.f٣٥٤٨g.Q(motionEvent) | this.f٣٥٤٩h.Q(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.f٣٥٤٨g.e(3)) {
                        this.f٣٥٥٠i.c();
                        this.f٣٥٥١j.c();
                    }
                }
                z10 = false;
            }
            g(true);
            this.f٣٥٥٩r = false;
            z10 = false;
        } else {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            this.f٣٥٦٢u = x10;
            this.f٣٥٦٣v = y10;
            if (this.f٣٥٤٦e > DownloadProgress.UNKNOWN_PROGRESS && (u10 = this.f٣٥٤٨g.u((int) x10, (int) y10)) != null && z(u10)) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f٣٥٥٩r = false;
        }
        if (Q || z10 || w() || this.f٣٥٥٩r) {
            return true;
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4 && x()) {
            keyEvent.startTracking();
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            View n10 = n();
            if (n10 != null && p(n10) == 0) {
                f();
            }
            if (n10 != null) {
                return true;
            }
            return false;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d3, code lost:
    
        r1 = getRootWindowInsets();
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        WindowInsets rootWindowInsets;
        float f10;
        int i14;
        boolean z11;
        int i15;
        this.f٣٥٥٣l = true;
        int i16 = i12 - i10;
        int childCount = getChildCount();
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (z(childAt)) {
                    int i18 = ((ViewGroup.MarginLayoutParams) fVar).leftMargin;
                    childAt.layout(i18, ((ViewGroup.MarginLayoutParams) fVar).topMargin, childAt.getMeasuredWidth() + i18, ((ViewGroup.MarginLayoutParams) fVar).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (c(childAt, 3)) {
                        float f11 = measuredWidth;
                        i14 = (-measuredWidth) + ((int) (fVar.f٣٥٧٨b * f11));
                        f10 = (measuredWidth + i14) / f11;
                    } else {
                        float f12 = measuredWidth;
                        f10 = (i16 - r11) / f12;
                        i14 = i16 - ((int) (fVar.f٣٥٧٨b * f12));
                    }
                    if (f10 != fVar.f٣٥٧٨b) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    int i19 = fVar.f٣٥٧٧a & 112;
                    if (i19 != 16) {
                        if (i19 != 80) {
                            int i20 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
                            childAt.layout(i14, i20, measuredWidth + i14, measuredHeight + i20);
                        } else {
                            int i21 = i13 - i11;
                            childAt.layout(i14, (i21 - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i14, i21 - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
                        }
                    } else {
                        int i22 = i13 - i11;
                        int i23 = (i22 - measuredHeight) / 2;
                        int i24 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
                        if (i23 < i24) {
                            i23 = i24;
                        } else {
                            int i25 = i23 + measuredHeight;
                            int i26 = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                            if (i25 > i22 - i26) {
                                i23 = (i22 - i26) - measuredHeight;
                            }
                        }
                        childAt.layout(i14, i23, measuredWidth + i14, measuredHeight + i23);
                    }
                    if (z11) {
                        O(childAt, f10);
                    }
                    if (fVar.f٣٥٧٨b > DownloadProgress.UNKNOWN_PROGRESS) {
                        i15 = 0;
                    } else {
                        i15 = 4;
                    }
                    if (childAt.getVisibility() != i15) {
                        childAt.setVisibility(i15);
                    }
                }
            }
        }
        if (P && rootWindowInsets != null) {
            b0 i27 = d2.x(rootWindowInsets).i();
            s2.c cVar = this.f٣٥٤٨g;
            cVar.M(Math.max(cVar.x(), i27.f٢٧٩٣a));
            s2.c cVar2 = this.f٣٥٤٩h;
            cVar2.M(Math.max(cVar2.x(), i27.f٢٧٩٥c));
        }
        this.f٣٥٥٣l = false;
        this.f٣٥٥٤m = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        boolean z10;
        boolean z11;
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (isInEditMode()) {
                if (mode == 0) {
                    size = 300;
                }
                if (mode2 == 0) {
                    size2 = 300;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        if (this.f٣٥٤١B != null && d1.A(this)) {
            z10 = true;
        } else {
            z10 = false;
        }
        int D = d1.D(this);
        int childCount = getChildCount();
        boolean z12 = false;
        boolean z13 = false;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (z10) {
                    int b10 = t.b(fVar.f٣٥٧٧a, D);
                    if (d1.A(childAt)) {
                        WindowInsets windowInsets = (WindowInsets) this.f٣٥٤١B;
                        if (b10 == 3) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
                        } else if (b10 == 5) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                        }
                        childAt.dispatchApplyWindowInsets(windowInsets);
                    } else {
                        WindowInsets windowInsets2 = (WindowInsets) this.f٣٥٤١B;
                        if (b10 == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), 0, windowInsets2.getSystemWindowInsetBottom());
                        } else if (b10 == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(0, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) fVar).topMargin = windowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin = windowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (z(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin, 1073741824));
                } else if (B(childAt)) {
                    if (O) {
                        float x10 = d1.x(childAt);
                        float f10 = this.f٣٥٤٣b;
                        if (x10 != f10) {
                            d1.x0(childAt, f10);
                        }
                    }
                    int r10 = r(childAt) & 7;
                    if (r10 == 3) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if ((z11 && z12) || (!z11 && z13)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + u(r10) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (z11) {
                        z12 = true;
                    } else {
                        z13 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i10, this.f٣٥٤٤c + ((ViewGroup.MarginLayoutParams) fVar).leftMargin + ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((ViewGroup.MarginLayoutParams) fVar).width), ViewGroup.getChildMeasureSpec(i11, ((ViewGroup.MarginLayoutParams) fVar).topMargin + ((ViewGroup.MarginLayoutParams) fVar).bottomMargin, ((ViewGroup.MarginLayoutParams) fVar).height));
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i12 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View l10;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i10 = savedState.f٣٥٦٨a;
        if (i10 != 0 && (l10 = l(i10)) != null) {
            G(l10);
        }
        int i11 = savedState.f٣٥٦٩b;
        if (i11 != 3) {
            N(i11, 3);
        }
        int i12 = savedState.f٣٥٧٠c;
        if (i12 != 3) {
            N(i12, 5);
        }
        int i13 = savedState.f٣٥٧١d;
        if (i13 != 3) {
            N(i13, 8388611);
        }
        int i14 = savedState.f٣٥٧٢e;
        if (i14 != 3) {
            N(i14, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        L();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        boolean z10;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            f fVar = (f) getChildAt(i10).getLayoutParams();
            int i11 = fVar.f٣٥٨٠d;
            boolean z11 = true;
            if (i11 == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (i11 != 2) {
                z11 = false;
            }
            if (z10 || z11) {
                savedState.f٣٥٦٨a = fVar.f٣٥٧٧a;
                break;
            }
        }
        savedState.f٣٥٦٩b = this.f٣٥٥٥n;
        savedState.f٣٥٧٠c = this.f٣٥٥٦o;
        savedState.f٣٥٧١d = this.f٣٥٥٧p;
        savedState.f٣٥٧٢e = this.f٣٥٥٨q;
        return savedState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        if (p(r7) != 2) goto L٢٠;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f٣٥٤٨g.G(motionEvent);
        this.f٣٥٤٩h.G(motionEvent);
        int action = motionEvent.getAction() & KotlinVersion.MAX_COMPONENT_VALUE;
        boolean z10 = false;
        if (action != 0) {
            if (action != 1) {
                if (action == 3) {
                    g(true);
                    this.f٣٥٥٩r = false;
                }
            } else {
                float x10 = motionEvent.getX();
                float y10 = motionEvent.getY();
                View u10 = this.f٣٥٤٨g.u((int) x10, (int) y10);
                if (u10 != null && z(u10)) {
                    float f10 = x10 - this.f٣٥٦٢u;
                    float f11 = y10 - this.f٣٥٦٣v;
                    int A = this.f٣٥٤٨g.A();
                    if ((f10 * f10) + (f11 * f11) < A * A) {
                        View m10 = m();
                        if (m10 != null) {
                        }
                    }
                }
                z10 = true;
                g(z10);
            }
        } else {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            this.f٣٥٦٢u = x11;
            this.f٣٥٦٣v = y11;
            this.f٣٥٥٩r = false;
        }
        return true;
    }

    public int p(View view) {
        if (B(view)) {
            return o(((f) view.getLayoutParams()).f٣٥٧٧a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public CharSequence q(int i10) {
        int b10 = t.b(i10, d1.D(this));
        if (b10 == 3) {
            return this.f٣٥٦٧z;
        }
        if (b10 == 5) {
            return this.A;
        }
        return null;
    }

    int r(View view) {
        return t.b(((f) view.getLayoutParams()).f٣٥٧٧a, d1.D(this));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (z10) {
            g(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.f٣٥٥٣l) {
            super.requestLayout();
        }
    }

    float s(View view) {
        return ((f) view.getLayoutParams()).f٣٥٧٨b;
    }

    public void setDrawerElevation(float f10) {
        this.f٣٥٤٣b = f10;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (B(childAt)) {
                d1.x0(childAt, this.f٣٥٤٣b);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(e eVar) {
        e eVar2 = this.f٣٥٦٠s;
        if (eVar2 != null) {
            I(eVar2);
        }
        if (eVar != null) {
            a(eVar);
        }
        this.f٣٥٦٠s = eVar;
    }

    public void setDrawerLockMode(int i10) {
        N(i10, 3);
        N(i10, 5);
    }

    public void setScrimColor(int i10) {
        this.f٣٥٤٥d = i10;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f٣٥٦٤w = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i10) {
        this.f٣٥٦٤w = new ColorDrawable(i10);
        invalidate();
    }

    boolean z(View view) {
        if (((f) view.getLayoutParams()).f٣٥٧٧a == 0) {
            return true;
        }
        return false;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.drawerlayout.R.attr.drawerLayoutStyle);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٣٥٤٢a = new d();
        this.f٣٥٤٥d = -1728053248;
        this.f٣٥٤٧f = new Paint();
        this.f٣٥٥٤m = true;
        this.f٣٥٥٥n = 3;
        this.f٣٥٥٦o = 3;
        this.f٣٥٥٧p = 3;
        this.f٣٥٥٨q = 3;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.K = new a();
        setDescendantFocusability(262144);
        float f10 = getResources().getDisplayMetrics().density;
        this.f٣٥٤٤c = (int) ((64.0f * f10) + 0.5f);
        float f11 = f10 * 400.0f;
        h hVar = new h(3);
        this.f٣٥٥٠i = hVar;
        h hVar2 = new h(5);
        this.f٣٥٥١j = hVar2;
        s2.c o10 = s2.c.o(this, 1.0f, hVar);
        this.f٣٥٤٨g = o10;
        o10.N(1);
        o10.O(f11);
        hVar.d(o10);
        s2.c o11 = s2.c.o(this, 1.0f, hVar2);
        this.f٣٥٤٩h = o11;
        o11.N(2);
        o11.O(f11);
        hVar2.d(o11);
        setFocusableInTouchMode(true);
        d1.z0(this, 1);
        d1.q0(this, new c());
        setMotionEventSplittingEnabled(false);
        if (d1.A(this)) {
            setOnApplyWindowInsetsListener(new b());
            setSystemUiVisibility(1280);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(L);
            try {
                this.f٣٥٦٤w = obtainStyledAttributes.getDrawable(0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, androidx.drawerlayout.R.styleable.DrawerLayout, i10, 0);
        try {
            int i11 = androidx.drawerlayout.R.styleable.DrawerLayout_elevation;
            if (obtainStyledAttributes2.hasValue(i11)) {
                this.f٣٥٤٣b = obtainStyledAttributes2.getDimension(i11, DownloadProgress.UNKNOWN_PROGRESS);
            } else {
                this.f٣٥٤٣b = getResources().getDimension(androidx.drawerlayout.R.dimen.def_drawer_elevation);
            }
            obtainStyledAttributes2.recycle();
            this.H = new ArrayList();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    public void setStatusBarBackground(int i10) {
        this.f٣٥٦٤w = i10 != 0 ? androidx.core.content.a.getDrawable(getContext(), i10) : null;
        invalidate();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class f extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f٣٥٧٧a;

        /* renamed from: b, reason: collision with root package name */
        float f٣٥٧٨b;

        /* renamed from: c, reason: collision with root package name */
        boolean f٣٥٧٩c;

        /* renamed from: d, reason: collision with root package name */
        int f٣٥٨٠d;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f٣٥٧٧a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.M);
            this.f٣٥٧٧a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public f(int i10, int i11) {
            super(i10, i11);
            this.f٣٥٧٧a = 0;
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f٣٥٧٧a = 0;
            this.f٣٥٧٧a = fVar.f٣٥٧٧a;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f٣٥٧٧a = 0;
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f٣٥٧٧a = 0;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        int f٣٥٦٨a;

        /* renamed from: b, reason: collision with root package name */
        int f٣٥٦٩b;

        /* renamed from: c, reason: collision with root package name */
        int f٣٥٧٠c;

        /* renamed from: d, reason: collision with root package name */
        int f٣٥٧١d;

        /* renamed from: e, reason: collision with root package name */
        int f٣٥٧٢e;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f٣٥٦٨a = 0;
            this.f٣٥٦٨a = parcel.readInt();
            this.f٣٥٦٩b = parcel.readInt();
            this.f٣٥٧٠c = parcel.readInt();
            this.f٣٥٧١d = parcel.readInt();
            this.f٣٥٧٢e = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f٣٥٦٨a);
            parcel.writeInt(this.f٣٥٦٩b);
            parcel.writeInt(this.f٣٥٧٠c);
            parcel.writeInt(this.f٣٥٧١d);
            parcel.writeInt(this.f٣٥٧٢e);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f٣٥٦٨a = 0;
        }
    }
}
