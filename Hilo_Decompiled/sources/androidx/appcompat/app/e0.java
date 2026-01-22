package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.app.a;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.d1;
import androidx.core.view.l1;
import androidx.core.view.m1;
import androidx.core.view.n1;
import androidx.core.view.o1;
import com.amazonaws.services.s3.internal.Constants;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class e0 extends androidx.appcompat.app.a implements ActionBarOverlayLayout.d {
    private static final Interpolator E = new AccelerateInterpolator();
    private static final Interpolator F = new DecelerateInterpolator();
    boolean A;

    /* renamed from: a, reason: collision with root package name */
    Context f٧٦٠a;

    /* renamed from: b, reason: collision with root package name */
    private Context f٧٦١b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f٧٦٢c;

    /* renamed from: d, reason: collision with root package name */
    ActionBarOverlayLayout f٧٦٣d;

    /* renamed from: e, reason: collision with root package name */
    ActionBarContainer f٧٦٤e;

    /* renamed from: f, reason: collision with root package name */
    androidx.appcompat.widget.x f٧٦٥f;

    /* renamed from: g, reason: collision with root package name */
    ActionBarContextView f٧٦٦g;

    /* renamed from: h, reason: collision with root package name */
    View f٧٦٧h;

    /* renamed from: i, reason: collision with root package name */
    ScrollingTabContainerView f٧٦٨i;

    /* renamed from: l, reason: collision with root package name */
    private boolean f٧٧١l;

    /* renamed from: m, reason: collision with root package name */
    d f٧٧٢m;

    /* renamed from: n, reason: collision with root package name */
    androidx.appcompat.view.b f٧٧٣n;

    /* renamed from: o, reason: collision with root package name */
    b.a f٧٧٤o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f٧٧٥p;

    /* renamed from: r, reason: collision with root package name */
    private boolean f٧٧٧r;

    /* renamed from: u, reason: collision with root package name */
    boolean f٧٨٠u;

    /* renamed from: v, reason: collision with root package name */
    boolean f٧٨١v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f٧٨٢w;

    /* renamed from: y, reason: collision with root package name */
    androidx.appcompat.view.h f٧٨٤y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f٧٨٥z;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList f٧٦٩j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    private int f٧٧٠k = -1;

    /* renamed from: q, reason: collision with root package name */
    private ArrayList f٧٧٦q = new ArrayList();

    /* renamed from: s, reason: collision with root package name */
    private int f٧٧٨s = 0;

    /* renamed from: t, reason: collision with root package name */
    boolean f٧٧٩t = true;

    /* renamed from: x, reason: collision with root package name */
    private boolean f٧٨٣x = true;

    /* renamed from: B, reason: collision with root package name */
    final m1 f٧٥٩B = new a();
    final m1 C = new b();
    final o1 D = new c();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a extends n1 {
        a() {
        }

        @Override // androidx.core.view.m1
        public void onAnimationEnd(View view) {
            View view2;
            e0 e0Var = e0.this;
            if (e0Var.f٧٧٩t && (view2 = e0Var.f٧٦٧h) != null) {
                view2.setTranslationY(DownloadProgress.UNKNOWN_PROGRESS);
                e0.this.f٧٦٤e.setTranslationY(DownloadProgress.UNKNOWN_PROGRESS);
            }
            e0.this.f٧٦٤e.setVisibility(8);
            e0.this.f٧٦٤e.setTransitioning(false);
            e0 e0Var2 = e0.this;
            e0Var2.f٧٨٤y = null;
            e0Var2.z();
            ActionBarOverlayLayout actionBarOverlayLayout = e0.this.f٧٦٣d;
            if (actionBarOverlayLayout != null) {
                d1.n0(actionBarOverlayLayout);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b extends n1 {
        b() {
        }

        @Override // androidx.core.view.m1
        public void onAnimationEnd(View view) {
            e0 e0Var = e0.this;
            e0Var.f٧٨٤y = null;
            e0Var.f٧٦٤e.requestLayout();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class c implements o1 {
        c() {
        }

        @Override // androidx.core.view.o1
        public void a(View view) {
            ((View) e0.this.f٧٦٤e.getParent()).invalidate();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class d extends androidx.appcompat.view.b implements g.a {

        /* renamed from: c, reason: collision with root package name */
        private final Context f٧٨٩c;

        /* renamed from: d, reason: collision with root package name */
        private final androidx.appcompat.view.menu.g f٧٩٠d;

        /* renamed from: e, reason: collision with root package name */
        private b.a f٧٩١e;

        /* renamed from: f, reason: collision with root package name */
        private WeakReference f٧٩٢f;

        public d(Context context, b.a aVar) {
            this.f٧٨٩c = context;
            this.f٧٩١e = aVar;
            androidx.appcompat.view.menu.g X = new androidx.appcompat.view.menu.g(context).X(1);
            this.f٧٩٠d = X;
            X.W(this);
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            b.a aVar = this.f٧٩١e;
            if (aVar != null) {
                return aVar.c(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
            if (this.f٧٩١e == null) {
                return;
            }
            k();
            e0.this.f٧٦٦g.l();
        }

        @Override // androidx.appcompat.view.b
        public void c() {
            e0 e0Var = e0.this;
            if (e0Var.f٧٧٢m != this) {
                return;
            }
            if (!e0.y(e0Var.f٧٨٠u, e0Var.f٧٨١v, false)) {
                e0 e0Var2 = e0.this;
                e0Var2.f٧٧٣n = this;
                e0Var2.f٧٧٤o = this.f٧٩١e;
            } else {
                this.f٧٩١e.a(this);
            }
            this.f٧٩١e = null;
            e0.this.x(false);
            e0.this.f٧٦٦g.g();
            e0 e0Var3 = e0.this;
            e0Var3.f٧٦٣d.setHideOnContentScrollEnabled(e0Var3.A);
            e0.this.f٧٧٢m = null;
        }

        @Override // androidx.appcompat.view.b
        public View d() {
            WeakReference weakReference = this.f٧٩٢f;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.b
        public Menu e() {
            return this.f٧٩٠d;
        }

        @Override // androidx.appcompat.view.b
        public MenuInflater f() {
            return new androidx.appcompat.view.g(this.f٧٨٩c);
        }

        @Override // androidx.appcompat.view.b
        public CharSequence g() {
            return e0.this.f٧٦٦g.getSubtitle();
        }

        @Override // androidx.appcompat.view.b
        public CharSequence i() {
            return e0.this.f٧٦٦g.getTitle();
        }

        @Override // androidx.appcompat.view.b
        public void k() {
            if (e0.this.f٧٧٢m != this) {
                return;
            }
            this.f٧٩٠d.i0();
            try {
                this.f٧٩١e.d(this, this.f٧٩٠d);
            } finally {
                this.f٧٩٠d.h0();
            }
        }

        @Override // androidx.appcompat.view.b
        public boolean l() {
            return e0.this.f٧٦٦g.j();
        }

        @Override // androidx.appcompat.view.b
        public void m(View view) {
            e0.this.f٧٦٦g.setCustomView(view);
            this.f٧٩٢f = new WeakReference(view);
        }

        @Override // androidx.appcompat.view.b
        public void n(int i10) {
            o(e0.this.f٧٦٠a.getResources().getString(i10));
        }

        @Override // androidx.appcompat.view.b
        public void o(CharSequence charSequence) {
            e0.this.f٧٦٦g.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void q(int i10) {
            r(e0.this.f٧٦٠a.getResources().getString(i10));
        }

        @Override // androidx.appcompat.view.b
        public void r(CharSequence charSequence) {
            e0.this.f٧٦٦g.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void s(boolean z10) {
            super.s(z10);
            e0.this.f٧٦٦g.setTitleOptional(z10);
        }

        public boolean t() {
            this.f٧٩٠d.i0();
            try {
                return this.f٧٩١e.b(this, this.f٧٩٠d);
            } finally {
                this.f٧٩٠d.h0();
            }
        }
    }

    public e0(Activity activity, boolean z10) {
        this.f٧٦٢c = activity;
        View decorView = activity.getWindow().getDecorView();
        F(decorView);
        if (z10) {
            return;
        }
        this.f٧٦٧h = decorView.findViewById(R.id.content);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private androidx.appcompat.widget.x C(View view) {
        String str;
        if (view instanceof androidx.appcompat.widget.x) {
            return (androidx.appcompat.widget.x) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        if (view != 0) {
            str = view.getClass().getSimpleName();
        } else {
            str = Constants.NULL_VERSION_ID;
        }
        sb.append(str);
        throw new IllegalStateException(sb.toString());
    }

    private void E() {
        if (this.f٧٨٢w) {
            this.f٧٨٢w = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f٧٦٣d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            N(false);
        }
    }

    private void F(View view) {
        boolean z10;
        boolean z11;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(androidx.appcompat.R.id.decor_content_parent);
        this.f٧٦٣d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f٧٦٥f = C(view.findViewById(androidx.appcompat.R.id.action_bar));
        this.f٧٦٦g = (ActionBarContextView) view.findViewById(androidx.appcompat.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(androidx.appcompat.R.id.action_bar_container);
        this.f٧٦٤e = actionBarContainer;
        androidx.appcompat.widget.x xVar = this.f٧٦٥f;
        if (xVar != null && this.f٧٦٦g != null && actionBarContainer != null) {
            this.f٧٦٠a = xVar.getContext();
            if ((this.f٧٦٥f.v() & 4) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.f٧٧١l = true;
            }
            androidx.appcompat.view.a b10 = androidx.appcompat.view.a.b(this.f٧٦٠a);
            if (!b10.a() && !z10) {
                z11 = false;
            } else {
                z11 = true;
            }
            K(z11);
            I(b10.g());
            TypedArray obtainStyledAttributes = this.f٧٦٠a.obtainStyledAttributes(null, androidx.appcompat.R.styleable.ActionBar, androidx.appcompat.R.attr.actionBarStyle, 0);
            if (obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.ActionBar_hideOnContentScroll, false)) {
                J(true);
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.ActionBar_elevation, 0);
            if (dimensionPixelSize != 0) {
                H(dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
    }

    private void I(boolean z10) {
        boolean z11;
        boolean z12;
        this.f٧٧٧r = z10;
        if (!z10) {
            this.f٧٦٥f.r(null);
            this.f٧٦٤e.setTabContainer(this.f٧٦٨i);
        } else {
            this.f٧٦٤e.setTabContainer(null);
            this.f٧٦٥f.r(this.f٧٦٨i);
        }
        boolean z13 = true;
        if (D() == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        ScrollingTabContainerView scrollingTabContainerView = this.f٧٦٨i;
        if (scrollingTabContainerView != null) {
            if (z11) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f٧٦٣d;
                if (actionBarOverlayLayout != null) {
                    d1.n0(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        androidx.appcompat.widget.x xVar = this.f٧٦٥f;
        if (!this.f٧٧٧r && z11) {
            z12 = true;
        } else {
            z12 = false;
        }
        xVar.p(z12);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f٧٦٣d;
        if (this.f٧٧٧r || !z11) {
            z13 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z13);
    }

    private boolean L() {
        return this.f٧٦٤e.isLaidOut();
    }

    private void M() {
        if (!this.f٧٨٢w) {
            this.f٧٨٢w = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f٧٦٣d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            N(false);
        }
    }

    private void N(boolean z10) {
        if (y(this.f٧٨٠u, this.f٧٨١v, this.f٧٨٢w)) {
            if (!this.f٧٨٣x) {
                this.f٧٨٣x = true;
                B(z10);
                return;
            }
            return;
        }
        if (this.f٧٨٣x) {
            this.f٧٨٣x = false;
            A(z10);
        }
    }

    static boolean y(boolean z10, boolean z11, boolean z12) {
        if (z12) {
            return true;
        }
        return (z10 || z11) ? false : true;
    }

    public void A(boolean z10) {
        View view;
        androidx.appcompat.view.h hVar = this.f٧٨٤y;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f٧٧٨s == 0 && (this.f٧٨٥z || z10)) {
            this.f٧٦٤e.setAlpha(1.0f);
            this.f٧٦٤e.setTransitioning(true);
            androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
            float f10 = -this.f٧٦٤e.getHeight();
            if (z10) {
                this.f٧٦٤e.getLocationInWindow(new int[]{0, 0});
                f10 -= r5[1];
            }
            l1 n10 = d1.e(this.f٧٦٤e).n(f10);
            n10.k(this.D);
            hVar2.c(n10);
            if (this.f٧٧٩t && (view = this.f٧٦٧h) != null) {
                hVar2.c(d1.e(view).n(f10));
            }
            hVar2.f(E);
            hVar2.e(250L);
            hVar2.g(this.f٧٥٩B);
            this.f٧٨٤y = hVar2;
            hVar2.h();
            return;
        }
        this.f٧٥٩B.onAnimationEnd(null);
    }

    public void B(boolean z10) {
        View view;
        View view2;
        androidx.appcompat.view.h hVar = this.f٧٨٤y;
        if (hVar != null) {
            hVar.a();
        }
        this.f٧٦٤e.setVisibility(0);
        if (this.f٧٧٨s == 0 && (this.f٧٨٥z || z10)) {
            this.f٧٦٤e.setTranslationY(DownloadProgress.UNKNOWN_PROGRESS);
            float f10 = -this.f٧٦٤e.getHeight();
            if (z10) {
                this.f٧٦٤e.getLocationInWindow(new int[]{0, 0});
                f10 -= r5[1];
            }
            this.f٧٦٤e.setTranslationY(f10);
            androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
            l1 n10 = d1.e(this.f٧٦٤e).n(DownloadProgress.UNKNOWN_PROGRESS);
            n10.k(this.D);
            hVar2.c(n10);
            if (this.f٧٧٩t && (view2 = this.f٧٦٧h) != null) {
                view2.setTranslationY(f10);
                hVar2.c(d1.e(this.f٧٦٧h).n(DownloadProgress.UNKNOWN_PROGRESS));
            }
            hVar2.f(F);
            hVar2.e(250L);
            hVar2.g(this.C);
            this.f٧٨٤y = hVar2;
            hVar2.h();
        } else {
            this.f٧٦٤e.setAlpha(1.0f);
            this.f٧٦٤e.setTranslationY(DownloadProgress.UNKNOWN_PROGRESS);
            if (this.f٧٧٩t && (view = this.f٧٦٧h) != null) {
                view.setTranslationY(DownloadProgress.UNKNOWN_PROGRESS);
            }
            this.C.onAnimationEnd(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f٧٦٣d;
        if (actionBarOverlayLayout != null) {
            d1.n0(actionBarOverlayLayout);
        }
    }

    public int D() {
        return this.f٧٦٥f.k();
    }

    public void G(int i10, int i11) {
        int v10 = this.f٧٦٥f.v();
        if ((i11 & 4) != 0) {
            this.f٧٧١l = true;
        }
        this.f٧٦٥f.i((i10 & i11) | ((~i11) & v10));
    }

    public void H(float f10) {
        d1.x0(this.f٧٦٤e, f10);
    }

    public void J(boolean z10) {
        if (z10 && !this.f٧٦٣d.r()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.A = z10;
        this.f٧٦٣d.setHideOnContentScrollEnabled(z10);
    }

    public void K(boolean z10) {
        this.f٧٦٥f.n(z10);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.f٧٨١v) {
            this.f٧٨١v = false;
            N(true);
        }
    }

    @Override // androidx.appcompat.app.a
    public void addOnMenuVisibilityListener(a.b bVar) {
        this.f٧٧٦q.add(bVar);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b(int i10) {
        this.f٧٧٨s = i10;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d(boolean z10) {
        this.f٧٧٩t = z10;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e() {
        if (!this.f٧٨١v) {
            this.f٧٨١v = true;
            N(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f() {
        androidx.appcompat.view.h hVar = this.f٧٨٤y;
        if (hVar != null) {
            hVar.a();
            this.f٧٨٤y = null;
        }
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        androidx.appcompat.widget.x xVar = this.f٧٦٥f;
        if (xVar != null && xVar.h()) {
            this.f٧٦٥f.collapseActionView();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z10) {
        if (z10 == this.f٧٧٥p) {
            return;
        }
        this.f٧٧٥p = z10;
        if (this.f٧٧٦q.size() <= 0) {
            return;
        }
        a0.a(this.f٧٧٦q.get(0));
        throw null;
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.f٧٦٥f.v();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        if (this.f٧٦١b == null) {
            TypedValue typedValue = new TypedValue();
            this.f٧٦٠a.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                this.f٧٦١b = new ContextThemeWrapper(this.f٧٦٠a, i10);
            } else {
                this.f٧٦١b = this.f٧٦٠a;
            }
        }
        return this.f٧٦١b;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        I(androidx.appcompat.view.a.b(this.f٧٦٠a).g());
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i10, KeyEvent keyEvent) {
        Menu e10;
        int i11;
        d dVar = this.f٧٧٢m;
        if (dVar == null || (e10 = dVar.e()) == null) {
            return false;
        }
        if (keyEvent != null) {
            i11 = keyEvent.getDeviceId();
        } else {
            i11 = -1;
        }
        boolean z10 = true;
        if (KeyCharacterMap.load(i11).getKeyboardType() == 1) {
            z10 = false;
        }
        e10.setQwertyMode(z10);
        return e10.performShortcut(i10, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z10) {
        if (!this.f٧٧١l) {
            s(z10);
        }
    }

    @Override // androidx.appcompat.app.a
    public void removeOnMenuVisibilityListener(a.b bVar) {
        this.f٧٧٦q.remove(bVar);
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z10) {
        int i10;
        if (z10) {
            i10 = 4;
        } else {
            i10 = 0;
        }
        G(i10, 4);
    }

    @Override // androidx.appcompat.app.a
    public void t(boolean z10) {
        int i10;
        if (z10) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        G(i10, 8);
    }

    @Override // androidx.appcompat.app.a
    public void u(boolean z10) {
        androidx.appcompat.view.h hVar;
        this.f٧٨٥z = z10;
        if (!z10 && (hVar = this.f٧٨٤y) != null) {
            hVar.a();
        }
    }

    @Override // androidx.appcompat.app.a
    public void v(CharSequence charSequence) {
        this.f٧٦٥f.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public androidx.appcompat.view.b w(b.a aVar) {
        d dVar = this.f٧٧٢m;
        if (dVar != null) {
            dVar.c();
        }
        this.f٧٦٣d.setHideOnContentScrollEnabled(false);
        this.f٧٦٦g.k();
        d dVar2 = new d(this.f٧٦٦g.getContext(), aVar);
        if (dVar2.t()) {
            this.f٧٧٢m = dVar2;
            dVar2.k();
            this.f٧٦٦g.h(dVar2);
            x(true);
            return dVar2;
        }
        return null;
    }

    public void x(boolean z10) {
        l1 l10;
        l1 f10;
        if (z10) {
            M();
        } else {
            E();
        }
        if (L()) {
            if (z10) {
                f10 = this.f٧٦٥f.l(4, 100L);
                l10 = this.f٧٦٦g.f(0, 200L);
            } else {
                l10 = this.f٧٦٥f.l(0, 200L);
                f10 = this.f٧٦٦g.f(8, 100L);
            }
            androidx.appcompat.view.h hVar = new androidx.appcompat.view.h();
            hVar.d(f10, l10);
            hVar.h();
            return;
        }
        if (z10) {
            this.f٧٦٥f.u(4);
            this.f٧٦٦g.setVisibility(0);
        } else {
            this.f٧٦٥f.u(0);
            this.f٧٦٦g.setVisibility(8);
        }
    }

    void z() {
        b.a aVar = this.f٧٧٤o;
        if (aVar != null) {
            aVar.a(this.f٧٧٣n);
            this.f٧٧٣n = null;
            this.f٧٧٤o = null;
        }
    }

    public e0(Dialog dialog) {
        F(dialog.getWindow().getDecorView());
    }
}
