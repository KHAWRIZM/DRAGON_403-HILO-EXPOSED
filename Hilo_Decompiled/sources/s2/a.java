package s2;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.d1;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import io.agora.rtc.Constants;
import java.util.ArrayList;
import java.util.List;
import m2.g0;
import m2.h0;
import m2.i0;
import s2.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a extends androidx.core.view.a {

    /* renamed from: k, reason: collision with root package name */
    private static final Rect f١٧٦٧٥k = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: l, reason: collision with root package name */
    private static final b.a f١٧٦٧٦l = new C٠٢٢٤a();

    /* renamed from: m, reason: collision with root package name */
    private static final b.InterfaceC٠٢٢٥b f١٧٦٧٧m = new b();

    /* renamed from: e, reason: collision with root package name */
    private final AccessibilityManager f١٧٦٨٢e;

    /* renamed from: f, reason: collision with root package name */
    private final View f١٧٦٨٣f;

    /* renamed from: g, reason: collision with root package name */
    private c f١٧٦٨٤g;

    /* renamed from: a, reason: collision with root package name */
    private final Rect f١٧٦٧٨a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    private final Rect f١٧٦٧٩b = new Rect();

    /* renamed from: c, reason: collision with root package name */
    private final Rect f١٧٦٨٠c = new Rect();

    /* renamed from: d, reason: collision with root package name */
    private final int[] f١٧٦٨١d = new int[2];

    /* renamed from: h, reason: collision with root package name */
    int f١٧٦٨٥h = Integer.MIN_VALUE;

    /* renamed from: i, reason: collision with root package name */
    int f١٧٦٨٦i = Integer.MIN_VALUE;

    /* renamed from: j, reason: collision with root package name */
    private int f١٧٦٨٧j = Integer.MIN_VALUE;

    /* renamed from: s2.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class C٠٢٢٤a implements b.a {
        C٠٢٢٤a() {
        }

        @Override // s2.b.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g0 g0Var, Rect rect) {
            g0Var.m(rect);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b implements b.InterfaceC٠٢٢٥b {
        b() {
        }

        @Override // s2.b.InterfaceC٠٢٢٥b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public g0 a(SparseArrayCompat sparseArrayCompat, int i10) {
            return (g0) sparseArrayCompat.valueAt(i10);
        }

        @Override // s2.b.InterfaceC٠٢٢٥b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int b(SparseArrayCompat sparseArrayCompat) {
            return sparseArrayCompat.size();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private class c extends h0 {
        c() {
        }

        @Override // m2.h0
        public g0 b(int i10) {
            return g0.c0(a.this.y(i10));
        }

        @Override // m2.h0
        public g0 d(int i10) {
            int i11;
            if (i10 == 2) {
                i11 = a.this.f١٧٦٨٥h;
            } else {
                i11 = a.this.f١٧٦٨٦i;
            }
            if (i11 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i11);
        }

        @Override // m2.h0
        public boolean f(int i10, int i11, Bundle bundle) {
            return a.this.G(i10, i11, bundle);
        }
    }

    public a(View view) {
        if (view != null) {
            this.f١٧٦٨٣f = view;
            this.f١٧٦٨٢e = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (d1.B(view) == 0) {
                d1.z0(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private boolean H(int i10, int i11, Bundle bundle) {
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 64) {
                    if (i11 != 128) {
                        return A(i10, i11, bundle);
                    }
                    return c(i10);
                }
                return J(i10);
            }
            return d(i10);
        }
        return K(i10);
    }

    private boolean I(int i10, Bundle bundle) {
        return d1.f0(this.f١٧٦٨٣f, i10, bundle);
    }

    private boolean J(int i10) {
        int i11;
        if (!this.f١٧٦٨٢e.isEnabled() || !this.f١٧٦٨٢e.isTouchExplorationEnabled() || (i11 = this.f١٧٦٨٥h) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            c(i11);
        }
        this.f١٧٦٨٥h = i10;
        this.f١٧٦٨٣f.invalidate();
        L(i10, 32768);
        return true;
    }

    private void M(int i10) {
        int i11 = this.f١٧٦٨٧j;
        if (i11 == i10) {
            return;
        }
        this.f١٧٦٨٧j = i10;
        L(i10, 128);
        L(i11, 256);
    }

    private boolean c(int i10) {
        if (this.f١٧٦٨٥h == i10) {
            this.f١٧٦٨٥h = Integer.MIN_VALUE;
            this.f١٧٦٨٣f.invalidate();
            L(i10, 65536);
            return true;
        }
        return false;
    }

    private boolean e() {
        int i10 = this.f١٧٦٨٦i;
        if (i10 != Integer.MIN_VALUE && A(i10, 16, null)) {
            return true;
        }
        return false;
    }

    private AccessibilityEvent f(int i10, int i11) {
        if (i10 != -1) {
            return g(i10, i11);
        }
        return h(i11);
    }

    private AccessibilityEvent g(int i10, int i11) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i11);
        g0 y10 = y(i10);
        obtain.getText().add(y10.C());
        obtain.setContentDescription(y10.t());
        obtain.setScrollable(y10.V());
        obtain.setPassword(y10.U());
        obtain.setEnabled(y10.O());
        obtain.setChecked(y10.L());
        C(i10, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(y10.q());
        i0.c(obtain, this.f١٧٦٨٣f, i10);
        obtain.setPackageName(this.f١٧٦٨٣f.getContext().getPackageName());
        return obtain;
    }

    private AccessibilityEvent h(int i10) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i10);
        this.f١٧٦٨٣f.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    private g0 i(int i10) {
        boolean z10;
        g0 a02 = g0.a0();
        a02.u0(true);
        a02.w0(true);
        a02.o0("android.view.View");
        Rect rect = f١٧٦٧٥k;
        a02.j0(rect);
        a02.k0(rect);
        a02.G0(this.f١٧٦٨٣f);
        E(i10, a02);
        if (a02.C() == null && a02.t() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        a02.m(this.f١٧٦٧٩b);
        if (!this.f١٧٦٧٩b.equals(rect)) {
            int k10 = a02.k();
            if ((k10 & 64) == 0) {
                if ((k10 & 128) == 0) {
                    a02.E0(this.f١٧٦٨٣f.getContext().getPackageName());
                    a02.P0(this.f١٧٦٨٣f, i10);
                    if (this.f١٧٦٨٥h == i10) {
                        a02.h0(true);
                        a02.a(128);
                    } else {
                        a02.h0(false);
                        a02.a(64);
                    }
                    if (this.f١٧٦٨٦i == i10) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        a02.a(2);
                    } else if (a02.P()) {
                        a02.a(1);
                    }
                    a02.x0(z10);
                    this.f١٧٦٨٣f.getLocationOnScreen(this.f١٧٦٨١d);
                    a02.n(this.f١٧٦٧٨a);
                    if (this.f١٧٦٧٨a.equals(rect)) {
                        a02.m(this.f١٧٦٧٨a);
                        if (a02.f١٥٩٢٣b != -1) {
                            g0 a03 = g0.a0();
                            for (int i11 = a02.f١٥٩٢٣b; i11 != -1; i11 = a03.f١٥٩٢٣b) {
                                a03.H0(this.f١٧٦٨٣f, -1);
                                a03.j0(f١٧٦٧٥k);
                                E(i11, a03);
                                a03.m(this.f١٧٦٧٩b);
                                Rect rect2 = this.f١٧٦٧٨a;
                                Rect rect3 = this.f١٧٦٧٩b;
                                rect2.offset(rect3.left, rect3.top);
                            }
                            a03.e0();
                        }
                        this.f١٧٦٧٨a.offset(this.f١٧٦٨١d[0] - this.f١٧٦٨٣f.getScrollX(), this.f١٧٦٨١d[1] - this.f١٧٦٨٣f.getScrollY());
                    }
                    if (this.f١٧٦٨٣f.getLocalVisibleRect(this.f١٧٦٨٠c)) {
                        this.f١٧٦٨٠c.offset(this.f١٧٦٨١d[0] - this.f١٧٦٨٣f.getScrollX(), this.f١٧٦٨١d[1] - this.f١٧٦٨٣f.getScrollY());
                        if (this.f١٧٦٧٨a.intersect(this.f١٧٦٨٠c)) {
                            a02.k0(this.f١٧٦٧٨a);
                            if (v(this.f١٧٦٧٨a)) {
                                a02.T0(true);
                            }
                        }
                    }
                    return a02;
                }
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }

    private g0 j() {
        g0 b02 = g0.b0(this.f١٧٦٨٣f);
        d1.d0(this.f١٧٦٨٣f, b02);
        ArrayList arrayList = new ArrayList();
        r(arrayList);
        if (b02.p() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            b02.d(this.f١٧٦٨٣f, ((Integer) arrayList.get(i10)).intValue());
        }
        return b02;
    }

    private SparseArrayCompat n() {
        ArrayList arrayList = new ArrayList();
        r(arrayList);
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            sparseArrayCompat.put(((Integer) arrayList.get(i10)).intValue(), i(((Integer) arrayList.get(i10)).intValue()));
        }
        return sparseArrayCompat;
    }

    private void o(int i10, Rect rect) {
        y(i10).m(rect);
    }

    private static Rect s(View view, int i10, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i10 != 17) {
            if (i10 != 33) {
                if (i10 != 66) {
                    if (i10 == 130) {
                        rect.set(0, -1, width, -1);
                    } else {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                } else {
                    rect.set(-1, 0, -1, height);
                }
            } else {
                rect.set(0, height, width, height);
            }
        } else {
            rect.set(width, 0, width, height);
        }
        return rect;
    }

    private boolean v(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f١٧٦٨٣f.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.f١٧٦٨٣f.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= DownloadProgress.UNKNOWN_PROGRESS || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent == null) {
            return false;
        }
        return true;
    }

    private static int w(int i10) {
        if (i10 != 19) {
            if (i10 != 21) {
                if (i10 != 22) {
                    return Constants.ERR_ENCRYPTED_STREAM_NOT_ALLOWED_PUBLISHED;
                }
                return 66;
            }
            return 17;
        }
        return 33;
    }

    private boolean x(int i10, Rect rect) {
        g0 g0Var;
        boolean z10;
        g0 g0Var2;
        SparseArrayCompat n10 = n();
        int i11 = this.f١٧٦٨٦i;
        int i12 = Integer.MIN_VALUE;
        if (i11 == Integer.MIN_VALUE) {
            g0Var = null;
        } else {
            g0Var = (g0) n10.get(i11);
        }
        g0 g0Var3 = g0Var;
        if (i10 != 1 && i10 != 2) {
            if (i10 != 17 && i10 != 33 && i10 != 66 && i10 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i13 = this.f١٧٦٨٦i;
            if (i13 != Integer.MIN_VALUE) {
                o(i13, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                s(this.f١٧٦٨٣f, i10, rect2);
            }
            g0Var2 = (g0) s2.b.c(n10, f١٧٦٧٧m, f١٧٦٧٦l, g0Var3, rect2, i10);
        } else {
            if (d1.D(this.f١٧٦٨٣f) == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            g0Var2 = (g0) s2.b.d(n10, f١٧٦٧٧m, f١٧٦٧٦l, g0Var3, i10, z10, false);
        }
        if (g0Var2 != null) {
            i12 = n10.keyAt(n10.indexOfValue(g0Var2));
        }
        return K(i12);
    }

    protected abstract boolean A(int i10, int i11, Bundle bundle);

    protected abstract void E(int i10, g0 g0Var);

    boolean G(int i10, int i11, Bundle bundle) {
        if (i10 != -1) {
            return H(i10, i11, bundle);
        }
        return I(i11, bundle);
    }

    public final boolean K(int i10) {
        int i11;
        if ((!this.f١٧٦٨٣f.isFocused() && !this.f١٧٦٨٣f.requestFocus()) || (i11 = this.f١٧٦٨٦i) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            d(i11);
        }
        if (i10 == Integer.MIN_VALUE) {
            return false;
        }
        this.f١٧٦٨٦i = i10;
        F(i10, true);
        L(i10, 8);
        return true;
    }

    public final boolean L(int i10, int i11) {
        ViewParent parent;
        if (i10 == Integer.MIN_VALUE || !this.f١٧٦٨٢e.isEnabled() || (parent = this.f١٧٦٨٣f.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f١٧٦٨٣f, f(i10, i11));
    }

    public final boolean d(int i10) {
        if (this.f١٧٦٨٦i != i10) {
            return false;
        }
        this.f١٧٦٨٦i = Integer.MIN_VALUE;
        F(i10, false);
        L(i10, 8);
        return true;
    }

    @Override // androidx.core.view.a
    public h0 getAccessibilityNodeProvider(View view) {
        if (this.f١٧٦٨٤g == null) {
            this.f١٧٦٨٤g = new c();
        }
        return this.f١٧٦٨٤g;
    }

    public final boolean k(MotionEvent motionEvent) {
        if (!this.f١٧٦٨٢e.isEnabled() || !this.f١٧٦٨٢e.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7 && action != 9) {
            if (action != 10 || this.f١٧٦٨٧j == Integer.MIN_VALUE) {
                return false;
            }
            M(Integer.MIN_VALUE);
            return true;
        }
        int q10 = q(motionEvent.getX(), motionEvent.getY());
        M(q10);
        if (q10 == Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    public final boolean l(KeyEvent keyEvent) {
        int i10 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int w10 = w(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z10 = false;
                        while (i10 < repeatCount && x(w10, null)) {
                            i10++;
                            z10 = true;
                        }
                        return z10;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            e();
            return true;
        }
        if (keyEvent.hasNoModifiers()) {
            return x(2, null);
        }
        if (!keyEvent.hasModifiers(1)) {
            return false;
        }
        return x(1, null);
    }

    public final int m() {
        return this.f١٧٦٨٥h;
    }

    @Override // androidx.core.view.a
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        B(accessibilityEvent);
    }

    @Override // androidx.core.view.a
    public void onInitializeAccessibilityNodeInfo(View view, g0 g0Var) {
        super.onInitializeAccessibilityNodeInfo(view, g0Var);
        D(g0Var);
    }

    public final int p() {
        return this.f١٧٦٨٦i;
    }

    protected abstract int q(float f10, float f11);

    protected abstract void r(List list);

    public final void t(int i10) {
        u(i10, 0);
    }

    public final void u(int i10, int i11) {
        ViewParent parent;
        if (i10 != Integer.MIN_VALUE && this.f١٧٦٨٢e.isEnabled() && (parent = this.f١٧٦٨٣f.getParent()) != null) {
            AccessibilityEvent f10 = f(i10, 2048);
            m2.b.b(f10, i11);
            parent.requestSendAccessibilityEvent(this.f١٧٦٨٣f, f10);
        }
    }

    g0 y(int i10) {
        if (i10 == -1) {
            return j();
        }
        return i(i10);
    }

    public final void z(boolean z10, int i10, Rect rect) {
        int i11 = this.f١٧٦٨٦i;
        if (i11 != Integer.MIN_VALUE) {
            d(i11);
        }
        if (z10) {
            x(i10, rect);
        }
    }

    protected void B(AccessibilityEvent accessibilityEvent) {
    }

    protected void D(g0 g0Var) {
    }

    protected void C(int i10, AccessibilityEvent accessibilityEvent) {
    }

    protected void F(int i10, boolean z10) {
    }
}
