package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.d1;
import androidx.core.view.g1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class x0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: k, reason: collision with root package name */
    private static x0 f١٦٩٠k;

    /* renamed from: l, reason: collision with root package name */
    private static x0 f١٦٩١l;

    /* renamed from: a, reason: collision with root package name */
    private final View f١٦٩٢a;

    /* renamed from: b, reason: collision with root package name */
    private final CharSequence f١٦٩٣b;

    /* renamed from: c, reason: collision with root package name */
    private final int f١٦٩٤c;

    /* renamed from: d, reason: collision with root package name */
    private final Runnable f١٦٩٥d = new Runnable() { // from class: androidx.appcompat.widget.v0
        @Override // java.lang.Runnable
        public final void run() {
            x0.this.e();
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f١٦٩٦e = new Runnable() { // from class: androidx.appcompat.widget.w0
        @Override // java.lang.Runnable
        public final void run() {
            x0.this.d();
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private int f١٦٩٧f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٦٩٨g;

    /* renamed from: h, reason: collision with root package name */
    private y0 f١٦٩٩h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f١٧٠٠i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f١٧٠١j;

    private x0(View view, CharSequence charSequence) {
        this.f١٦٩٢a = view;
        this.f١٦٩٣b = charSequence;
        this.f١٦٩٤c = g1.g(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void b() {
        this.f١٦٩٢a.removeCallbacks(this.f١٦٩٥d);
    }

    private void c() {
        this.f١٧٠١j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        i(false);
    }

    private void f() {
        this.f١٦٩٢a.postDelayed(this.f١٦٩٥d, ViewConfiguration.getLongPressTimeout());
    }

    private static void g(x0 x0Var) {
        x0 x0Var2 = f١٦٩٠k;
        if (x0Var2 != null) {
            x0Var2.b();
        }
        f١٦٩٠k = x0Var;
        if (x0Var != null) {
            x0Var.f();
        }
    }

    public static void h(View view, CharSequence charSequence) {
        x0 x0Var = f١٦٩٠k;
        if (x0Var != null && x0Var.f١٦٩٢a == view) {
            g(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            x0 x0Var2 = f١٦٩١l;
            if (x0Var2 != null && x0Var2.f١٦٩٢a == view) {
                x0Var2.d();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new x0(view, charSequence);
    }

    private boolean j(MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        if (!this.f١٧٠١j && Math.abs(x10 - this.f١٦٩٧f) <= this.f١٦٩٤c && Math.abs(y10 - this.f١٦٩٨g) <= this.f١٦٩٤c) {
            return false;
        }
        this.f١٦٩٧f = x10;
        this.f١٦٩٨g = y10;
        this.f١٧٠١j = false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (f١٦٩١l == this) {
            f١٦٩١l = null;
            y0 y0Var = this.f١٦٩٩h;
            if (y0Var != null) {
                y0Var.c();
                this.f١٦٩٩h = null;
                c();
                this.f١٦٩٢a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f١٦٩٠k == this) {
            g(null);
        }
        this.f١٦٩٢a.removeCallbacks(this.f١٦٩٦e);
    }

    void i(boolean z10) {
        long longPressTimeout;
        long j10;
        long j11;
        if (!this.f١٦٩٢a.isAttachedToWindow()) {
            return;
        }
        g(null);
        x0 x0Var = f١٦٩١l;
        if (x0Var != null) {
            x0Var.d();
        }
        f١٦٩١l = this;
        this.f١٧٠٠i = z10;
        y0 y0Var = new y0(this.f١٦٩٢a.getContext());
        this.f١٦٩٩h = y0Var;
        y0Var.e(this.f١٦٩٢a, this.f١٦٩٧f, this.f١٦٩٨g, this.f١٧٠٠i, this.f١٦٩٣b);
        this.f١٦٩٢a.addOnAttachStateChangeListener(this);
        if (this.f١٧٠٠i) {
            j11 = 2500;
        } else {
            if ((d1.P(this.f١٦٩٢a) & 1) == 1) {
                longPressTimeout = ViewConfiguration.getLongPressTimeout();
                j10 = 3000;
            } else {
                longPressTimeout = ViewConfiguration.getLongPressTimeout();
                j10 = 15000;
            }
            j11 = j10 - longPressTimeout;
        }
        this.f١٦٩٢a.removeCallbacks(this.f١٦٩٦e);
        this.f١٦٩٢a.postDelayed(this.f١٦٩٦e, j11);
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f١٦٩٩h != null && this.f١٧٠٠i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f١٦٩٢a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.f١٦٩٢a.isEnabled() && this.f١٦٩٩h == null && j(motionEvent)) {
            g(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f١٦٩٧f = view.getWidth() / 2;
        this.f١٦٩٨g = view.getHeight() / 2;
        i(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        d();
    }
}
