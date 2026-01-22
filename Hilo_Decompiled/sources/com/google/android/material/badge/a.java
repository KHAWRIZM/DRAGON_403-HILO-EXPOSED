package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import c8.c;
import c8.e;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.e0;
import com.google.android.material.internal.h0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.i;
import f8.o;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a extends Drawable implements e0.b {

    /* renamed from: n, reason: collision with root package name */
    private static final int f٨٢٧٩n = R.style.Widget_MaterialComponents_Badge;

    /* renamed from: o, reason: collision with root package name */
    private static final int f٨٢٨٠o = R.attr.badgeStyle;

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference f٨٢٨١a;

    /* renamed from: b, reason: collision with root package name */
    private final i f٨٢٨٢b;

    /* renamed from: c, reason: collision with root package name */
    private final e0 f٨٢٨٣c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f٨٢٨٤d;

    /* renamed from: e, reason: collision with root package name */
    private final BadgeState f٨٢٨٥e;

    /* renamed from: f, reason: collision with root package name */
    private float f٨٢٨٦f;

    /* renamed from: g, reason: collision with root package name */
    private float f٨٢٨٧g;

    /* renamed from: h, reason: collision with root package name */
    private int f٨٢٨٨h;

    /* renamed from: i, reason: collision with root package name */
    private float f٨٢٨٩i;

    /* renamed from: j, reason: collision with root package name */
    private float f٨٢٩٠j;

    /* renamed from: k, reason: collision with root package name */
    private float f٨٢٩١k;

    /* renamed from: l, reason: collision with root package name */
    private WeakReference f٨٢٩٢l;

    /* renamed from: m, reason: collision with root package name */
    private WeakReference f٨٢٩٣m;

    private a(Context context, int i10, int i11, int i12, BadgeState.State state) {
        int i13;
        int h10;
        this.f٨٢٨١a = new WeakReference(context);
        h0.c(context);
        this.f٨٢٨٤d = new Rect();
        e0 e0Var = new e0(this);
        this.f٨٢٨٣c = e0Var;
        e0Var.g().setTextAlign(Paint.Align.CENTER);
        BadgeState badgeState = new BadgeState(context, i10, i11, i12, state);
        this.f٨٢٨٥e = badgeState;
        if (B()) {
            i13 = badgeState.m();
        } else {
            i13 = badgeState.i();
        }
        if (B()) {
            h10 = badgeState.l();
        } else {
            h10 = badgeState.h();
        }
        this.f٨٢٨٢b = new i(o.b(context, i13, h10).m());
        N();
    }

    private int A() {
        int C = this.f٨٢٨٥e.C();
        if (B()) {
            C = this.f٨٢٨٥e.B();
            Context context = (Context) this.f٨٢٨١a.get();
            if (context != null) {
                C = p7.a.c(C, C - this.f٨٢٨٥e.t(), p7.a.b(DownloadProgress.UNKNOWN_PROGRESS, 1.0f, 0.3f, 1.0f, c.f(context) - 1.0f));
            }
        }
        if (this.f٨٢٨٥e.f٨٢٥٠k == 0) {
            C -= Math.round(this.f٨٢٩١k);
        }
        return C + this.f٨٢٨٥e.c();
    }

    private boolean B() {
        if (!D() && !C()) {
            return false;
        }
        return true;
    }

    private void E() {
        this.f٨٢٨٣c.g().setAlpha(getAlpha());
        invalidateSelf();
    }

    private void F() {
        ColorStateList valueOf = ColorStateList.valueOf(this.f٨٢٨٥e.e());
        if (this.f٨٢٨٢b.D() != valueOf) {
            this.f٨٢٨٢b.h0(valueOf);
            invalidateSelf();
        }
    }

    private void G() {
        this.f٨٢٨٣c.l(true);
        I();
        R();
        invalidateSelf();
    }

    private void H() {
        FrameLayout frameLayout;
        WeakReference weakReference = this.f٨٢٩٢l;
        if (weakReference != null && weakReference.get() != null) {
            View view = (View) this.f٨٢٩٢l.get();
            WeakReference weakReference2 = this.f٨٢٩٣m;
            if (weakReference2 != null) {
                frameLayout = (FrameLayout) weakReference2.get();
            } else {
                frameLayout = null;
            }
            Q(view, frameLayout);
        }
    }

    private void I() {
        int i10;
        int h10;
        Context context = (Context) this.f٨٢٨١a.get();
        if (context == null) {
            return;
        }
        i iVar = this.f٨٢٨٢b;
        if (B()) {
            i10 = this.f٨٢٨٥e.m();
        } else {
            i10 = this.f٨٢٨٥e.i();
        }
        if (B()) {
            h10 = this.f٨٢٨٥e.l();
        } else {
            h10 = this.f٨٢٨٥e.h();
        }
        iVar.setShapeAppearanceModel(o.b(context, i10, h10).m());
        invalidateSelf();
    }

    private void J() {
        e eVar;
        Context context = (Context) this.f٨٢٨١a.get();
        if (context == null || this.f٨٢٨٣c.e() == (eVar = new e(context, this.f٨٢٨٥e.A()))) {
            return;
        }
        this.f٨٢٨٣c.k(eVar, context);
        K();
        R();
        invalidateSelf();
    }

    private void K() {
        this.f٨٢٨٣c.g().setColor(this.f٨٢٨٥e.j());
        invalidateSelf();
    }

    private void L() {
        S();
        this.f٨٢٨٣c.l(true);
        R();
        invalidateSelf();
    }

    private void M() {
        setVisible(this.f٨٢٨٥e.G(), false);
    }

    private void N() {
        I();
        J();
        L();
        G();
        E();
        F();
        K();
        H();
        R();
        M();
    }

    private static void P(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    private void R() {
        View view;
        Context context = (Context) this.f٨٢٨١a.get();
        WeakReference weakReference = this.f٨٢٩٢l;
        ViewGroup viewGroup = null;
        if (weakReference != null) {
            view = (View) weakReference.get();
        } else {
            view = null;
        }
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.f٨٢٨٤d);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference weakReference2 = this.f٨٢٩٣m;
            if (weakReference2 != null) {
                viewGroup = (ViewGroup) weakReference2.get();
            }
            if (viewGroup != null) {
                viewGroup.offsetDescendantRectToMyCoords(view, rect2);
            }
            d(rect2, view);
            b.g(this.f٨٢٨٤d, this.f٨٢٨٦f, this.f٨٢٨٧g, this.f٨٢٩٠j, this.f٨٢٩١k);
            float f10 = this.f٨٢٨٩i;
            if (f10 != -1.0f) {
                this.f٨٢٨٢b.d0(f10);
            }
            if (!rect.equals(this.f٨٢٨٤d)) {
                this.f٨٢٨٢b.setBounds(this.f٨٢٨٤d);
            }
        }
    }

    private void S() {
        if (o() != -2) {
            this.f٨٢٨٨h = ((int) Math.pow(10.0d, o() - 1.0d)) - 1;
        } else {
            this.f٨٢٨٨h = p();
        }
    }

    private void b(View view) {
        ViewParent k10 = k();
        if (k10 == null) {
            k10 = view.getParent();
        }
        if ((k10 instanceof View) && (k10.getParent() instanceof View)) {
            c(view, (View) k10.getParent());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewParent] */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.view.ViewParent] */
    /* JADX WARN: Type inference failed for: r0v9 */
    private void c(View view, View view2) {
        float f10;
        float f11;
        View view3;
        boolean z10;
        FrameLayout k10 = k();
        if (k10 == null) {
            float y10 = view.getY();
            f11 = view.getX();
            view3 = view.getParent();
            f10 = y10;
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
            f11 = DownloadProgress.UNKNOWN_PROGRESS;
            view3 = k10;
        }
        while (true) {
            z10 = view3 instanceof View;
            if (!z10 || view3 == view2) {
                break;
            }
            ViewParent parent = view3.getParent();
            if (!(parent instanceof ViewGroup) || ((ViewGroup) parent).getClipChildren()) {
                break;
            }
            View view4 = view3;
            f10 += view4.getY();
            f11 += view4.getX();
            view3 = view3.getParent();
        }
        if (!z10) {
            return;
        }
        float y11 = y(f10);
        float n10 = n(f11);
        View view5 = view3;
        float i10 = i(view5.getHeight(), f10);
        float t10 = t(view5.getWidth(), f11);
        if (y11 < DownloadProgress.UNKNOWN_PROGRESS) {
            this.f٨٢٨٧g += Math.abs(y11);
        }
        if (n10 < DownloadProgress.UNKNOWN_PROGRESS) {
            this.f٨٢٨٦f += Math.abs(n10);
        }
        if (i10 > DownloadProgress.UNKNOWN_PROGRESS) {
            this.f٨٢٨٧g -= Math.abs(i10);
        }
        if (t10 > DownloadProgress.UNKNOWN_PROGRESS) {
            this.f٨٢٨٦f -= Math.abs(t10);
        }
    }

    private void d(Rect rect, View view) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        if (B()) {
            f10 = this.f٨٢٨٥e.f٨٢٤٣d;
        } else {
            f10 = this.f٨٢٨٥e.f٨٢٤٢c;
        }
        this.f٨٢٨٩i = f10;
        if (f10 != -1.0f) {
            this.f٨٢٩٠j = f10;
            this.f٨٢٩١k = f10;
        } else {
            if (B()) {
                f11 = this.f٨٢٨٥e.f٨٢٤٦g;
            } else {
                f11 = this.f٨٢٨٥e.f٨٢٤٤e;
            }
            this.f٨٢٩٠j = Math.round(f11 / 2.0f);
            if (B()) {
                f12 = this.f٨٢٨٥e.f٨٢٤٧h;
            } else {
                f12 = this.f٨٢٨٥e.f٨٢٤٥f;
            }
            this.f٨٢٩١k = Math.round(f12 / 2.0f);
        }
        if (B()) {
            String h10 = h();
            this.f٨٢٩٠j = Math.max(this.f٨٢٩٠j, (this.f٨٢٨٣c.h(h10) / 2.0f) + this.f٨٢٨٥e.g());
            float max = Math.max(this.f٨٢٩١k, (this.f٨٢٨٣c.f(h10) / 2.0f) + this.f٨٢٨٥e.k());
            this.f٨٢٩١k = max;
            this.f٨٢٩٠j = Math.max(this.f٨٢٩٠j, max);
        }
        int A = A();
        int f15 = this.f٨٢٨٥e.f();
        if (f15 != 8388691 && f15 != 8388693) {
            this.f٨٢٨٧g = rect.top + A;
        } else {
            this.f٨٢٨٧g = rect.bottom - A;
        }
        int z10 = z();
        int f16 = this.f٨٢٨٥e.f();
        if (f16 != 8388659 && f16 != 8388691) {
            if (this.f٨٢٨٥e.f٨٢٥١l == 0) {
                if (view.getLayoutDirection() == 0) {
                    f14 = (rect.right + this.f٨٢٩٠j) - z10;
                } else {
                    f14 = (rect.left - this.f٨٢٩٠j) + z10;
                }
            } else if (view.getLayoutDirection() == 0) {
                f14 = (rect.right - this.f٨٢٩٠j) + ((this.f٨٢٩١k * 2.0f) - z10);
            } else {
                f14 = (rect.left + this.f٨٢٩٠j) - ((this.f٨٢٩١k * 2.0f) - z10);
            }
            this.f٨٢٨٦f = f14;
        } else {
            if (this.f٨٢٨٥e.f٨٢٥١l == 0) {
                if (view.getLayoutDirection() == 0) {
                    f13 = (rect.left + this.f٨٢٩٠j) - ((this.f٨٢٩١k * 2.0f) - z10);
                } else {
                    f13 = (rect.right - this.f٨٢٩٠j) + ((this.f٨٢٩١k * 2.0f) - z10);
                }
            } else if (view.getLayoutDirection() == 0) {
                f13 = (rect.left - this.f٨٢٩٠j) + z10;
            } else {
                f13 = (rect.right + this.f٨٢٩٠j) - z10;
            }
            this.f٨٢٨٦f = f13;
        }
        if (this.f٨٢٨٥e.F()) {
            b(view);
        } else {
            c(view, null);
        }
    }

    public static a e(Context context) {
        return new a(context, 0, f٨٢٨٠o, f٨٢٧٩n, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a f(Context context, BadgeState.State state) {
        return new a(context, 0, f٨٢٨٠o, f٨٢٧٩n, state);
    }

    private void g(Canvas canvas) {
        int round;
        String h10 = h();
        if (h10 != null) {
            Rect rect = new Rect();
            this.f٨٢٨٣c.g().getTextBounds(h10, 0, h10.length(), rect);
            float exactCenterY = this.f٨٢٨٧g - rect.exactCenterY();
            float f10 = this.f٨٢٨٦f;
            if (rect.bottom <= 0) {
                round = (int) exactCenterY;
            } else {
                round = Math.round(exactCenterY);
            }
            canvas.drawText(h10, f10, round, this.f٨٢٨٣c.g());
        }
    }

    private String h() {
        if (D()) {
            return w();
        }
        if (C()) {
            return r();
        }
        return null;
    }

    private float i(float f10, float f11) {
        return ((this.f٨٢٨٧g + this.f٨٢٩١k) - f10) + f11;
    }

    private CharSequence l() {
        return this.f٨٢٨٥e.p();
    }

    private float n(float f10) {
        return (this.f٨٢٨٦f - this.f٨٢٩٠j) + f10;
    }

    private String r() {
        if (this.f٨٢٨٨h != -2 && q() > this.f٨٢٨٨h) {
            Context context = (Context) this.f٨٢٨١a.get();
            if (context == null) {
                return "";
            }
            return String.format(this.f٨٢٨٥e.x(), context.getString(R.string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(this.f٨٢٨٨h), "+");
        }
        return NumberFormat.getInstance(this.f٨٢٨٥e.x()).format(q());
    }

    private String s() {
        Context context;
        if (this.f٨٢٨٥e.q() == 0 || (context = (Context) this.f٨٢٨١a.get()) == null) {
            return null;
        }
        if (this.f٨٢٨٨h != -2 && q() > this.f٨٢٨٨h) {
            return context.getString(this.f٨٢٨٥e.n(), Integer.valueOf(this.f٨٢٨٨h));
        }
        return context.getResources().getQuantityString(this.f٨٢٨٥e.q(), q(), Integer.valueOf(q()));
    }

    private float t(float f10, float f11) {
        return ((this.f٨٢٨٦f + this.f٨٢٩٠j) - f10) + f11;
    }

    private String w() {
        String v10 = v();
        int o10 = o();
        if (o10 == -2) {
            return v10;
        }
        if (v10 != null && v10.length() > o10) {
            Context context = (Context) this.f٨٢٨١a.get();
            if (context == null) {
                return "";
            }
            return String.format(context.getString(R.string.m3_exceed_max_badge_text_suffix), v10.substring(0, o10 - 1), "…");
        }
        return v10;
    }

    private CharSequence x() {
        CharSequence o10 = this.f٨٢٨٥e.o();
        if (o10 != null) {
            return o10;
        }
        return v();
    }

    private float y(float f10) {
        return (this.f٨٢٨٧g - this.f٨٢٩١k) + f10;
    }

    private int z() {
        int s10;
        int i10;
        if (B()) {
            s10 = this.f٨٢٨٥e.r();
        } else {
            s10 = this.f٨٢٨٥e.s();
        }
        if (this.f٨٢٨٥e.f٨٢٥٠k == 1) {
            if (B()) {
                i10 = this.f٨٢٨٥e.f٨٢٤٩j;
            } else {
                i10 = this.f٨٢٨٥e.f٨٢٤٨i;
            }
            s10 += i10;
        }
        return s10 + this.f٨٢٨٥e.b();
    }

    public boolean C() {
        if (!this.f٨٢٨٥e.E() && this.f٨٢٨٥e.D()) {
            return true;
        }
        return false;
    }

    public boolean D() {
        return this.f٨٢٨٥e.E();
    }

    public void O(int i10) {
        BadgeState badgeState = this.f٨٢٨٥e;
        if (badgeState.f٨٢٥١l != i10) {
            badgeState.f٨٢٥١l = i10;
            R();
        }
    }

    public void Q(View view, FrameLayout frameLayout) {
        this.f٨٢٩٢l = new WeakReference(view);
        this.f٨٢٩٣m = new WeakReference(frameLayout);
        P(view);
        R();
        invalidateSelf();
    }

    @Override // com.google.android.material.internal.e0.b
    public void a() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.f٨٢٨٢b.draw(canvas);
            if (B()) {
                g(canvas);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f٨٢٨٥e.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f٨٢٨٤d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f٨٢٨٤d.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    public CharSequence j() {
        if (!isVisible()) {
            return null;
        }
        if (D()) {
            return x();
        }
        if (C()) {
            return s();
        }
        return l();
    }

    public FrameLayout k() {
        WeakReference weakReference = this.f٨٢٩٣m;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    public int m() {
        return this.f٨٢٨٥e.s();
    }

    public int o() {
        return this.f٨٢٨٥e.u();
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.e0.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public int p() {
        return this.f٨٢٨٥e.v();
    }

    public int q() {
        if (this.f٨٢٨٥e.D()) {
            return this.f٨٢٨٥e.w();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f٨٢٨٥e.I(i10);
        E();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BadgeState.State u() {
        return this.f٨٢٨٥e.y();
    }

    public String v() {
        return this.f٨٢٨٥e.z();
    }
}
