package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.d1;
import androidx.core.view.l1;
import androidx.core.view.n1;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class t0 implements x {

    /* renamed from: a, reason: collision with root package name */
    Toolbar f١٦٦٦a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٦٦٧b;

    /* renamed from: c, reason: collision with root package name */
    private View f١٦٦٨c;

    /* renamed from: d, reason: collision with root package name */
    private View f١٦٦٩d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f١٦٧٠e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f١٦٧١f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f١٦٧٢g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f١٦٧٣h;

    /* renamed from: i, reason: collision with root package name */
    CharSequence f١٦٧٤i;

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f١٦٧٥j;

    /* renamed from: k, reason: collision with root package name */
    private CharSequence f١٦٧٦k;

    /* renamed from: l, reason: collision with root package name */
    Window.Callback f١٦٧٧l;

    /* renamed from: m, reason: collision with root package name */
    boolean f١٦٧٨m;

    /* renamed from: n, reason: collision with root package name */
    private ActionMenuPresenter f١٦٧٩n;

    /* renamed from: o, reason: collision with root package name */
    private int f١٦٨٠o;

    /* renamed from: p, reason: collision with root package name */
    private int f١٦٨١p;

    /* renamed from: q, reason: collision with root package name */
    private Drawable f١٦٨٢q;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final androidx.appcompat.view.menu.a f١٦٨٣a;

        a() {
            this.f١٦٨٣a = new androidx.appcompat.view.menu.a(t0.this.f١٦٦٦a.getContext(), 0, R.id.home, 0, 0, t0.this.f١٦٧٤i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t0 t0Var = t0.this;
            Window.Callback callback = t0Var.f١٦٧٧l;
            if (callback != null && t0Var.f١٦٧٨m) {
                callback.onMenuItemSelected(0, this.f١٦٨٣a);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b extends n1 {

        /* renamed from: a, reason: collision with root package name */
        private boolean f١٦٨٥a = false;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f١٦٨٦b;

        b(int i10) {
            this.f١٦٨٦b = i10;
        }

        @Override // androidx.core.view.n1, androidx.core.view.m1
        public void onAnimationCancel(View view) {
            this.f١٦٨٥a = true;
        }

        @Override // androidx.core.view.m1
        public void onAnimationEnd(View view) {
            if (!this.f١٦٨٥a) {
                t0.this.f١٦٦٦a.setVisibility(this.f١٦٨٦b);
            }
        }

        @Override // androidx.core.view.n1, androidx.core.view.m1
        public void onAnimationStart(View view) {
            t0.this.f١٦٦٦a.setVisibility(0);
        }
    }

    public t0(Toolbar toolbar, boolean z10) {
        this(toolbar, z10, androidx.appcompat.R.string.abc_action_bar_up_description, androidx.appcompat.R.drawable.abc_ic_ab_back_material);
    }

    private void G(CharSequence charSequence) {
        this.f١٦٧٤i = charSequence;
        if ((this.f١٦٦٧b & 8) != 0) {
            this.f١٦٦٦a.setTitle(charSequence);
            if (this.f١٦٧٣h) {
                d1.s0(this.f١٦٦٦a.getRootView(), charSequence);
            }
        }
    }

    private void H() {
        if ((this.f١٦٦٧b & 4) != 0) {
            if (TextUtils.isEmpty(this.f١٦٧٦k)) {
                this.f١٦٦٦a.setNavigationContentDescription(this.f١٦٨١p);
            } else {
                this.f١٦٦٦a.setNavigationContentDescription(this.f١٦٧٦k);
            }
        }
    }

    private void I() {
        if ((this.f١٦٦٧b & 4) != 0) {
            Toolbar toolbar = this.f١٦٦٦a;
            Drawable drawable = this.f١٦٧٢g;
            if (drawable == null) {
                drawable = this.f١٦٨٢q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f١٦٦٦a.setNavigationIcon((Drawable) null);
    }

    private void J() {
        Drawable drawable;
        int i10 = this.f١٦٦٧b;
        if ((i10 & 2) != 0) {
            if ((i10 & 1) != 0) {
                drawable = this.f١٦٧١f;
                if (drawable == null) {
                    drawable = this.f١٦٧٠e;
                }
            } else {
                drawable = this.f١٦٧٠e;
            }
        } else {
            drawable = null;
        }
        this.f١٦٦٦a.setLogo(drawable);
    }

    private int x() {
        if (this.f١٦٦٦a.getNavigationIcon() != null) {
            this.f١٦٨٢q = this.f١٦٦٦a.getNavigationIcon();
            return 15;
        }
        return 11;
    }

    public void A(Drawable drawable) {
        this.f١٦٧١f = drawable;
        J();
    }

    public void B(int i10) {
        String string;
        if (i10 == 0) {
            string = null;
        } else {
            string = getContext().getString(i10);
        }
        C(string);
    }

    public void C(CharSequence charSequence) {
        this.f١٦٧٦k = charSequence;
        H();
    }

    public void D(Drawable drawable) {
        this.f١٦٧٢g = drawable;
        I();
    }

    public void E(CharSequence charSequence) {
        this.f١٦٧٥j = charSequence;
        if ((this.f١٦٦٧b & 8) != 0) {
            this.f١٦٦٦a.setSubtitle(charSequence);
        }
    }

    public void F(CharSequence charSequence) {
        this.f١٦٧٣h = true;
        G(charSequence);
    }

    @Override // androidx.appcompat.widget.x
    public boolean a() {
        return this.f١٦٦٦a.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.x
    public boolean b() {
        return this.f١٦٦٦a.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.x
    public boolean c() {
        return this.f١٦٦٦a.showOverflowMenu();
    }

    @Override // androidx.appcompat.widget.x
    public void collapseActionView() {
        this.f١٦٦٦a.collapseActionView();
    }

    @Override // androidx.appcompat.widget.x
    public void d(Menu menu, l.a aVar) {
        if (this.f١٦٧٩n == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f١٦٦٦a.getContext());
            this.f١٦٧٩n = actionMenuPresenter;
            actionMenuPresenter.s(androidx.appcompat.R.id.action_menu_presenter);
        }
        this.f١٦٧٩n.c(aVar);
        this.f١٦٦٦a.setMenu((androidx.appcompat.view.menu.g) menu, this.f١٦٧٩n);
    }

    @Override // androidx.appcompat.widget.x
    public boolean e() {
        return this.f١٦٦٦a.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.x
    public void f() {
        this.f١٦٧٨m = true;
    }

    @Override // androidx.appcompat.widget.x
    public boolean g() {
        return this.f١٦٦٦a.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.x
    public Context getContext() {
        return this.f١٦٦٦a.getContext();
    }

    @Override // androidx.appcompat.widget.x
    public CharSequence getTitle() {
        return this.f١٦٦٦a.getTitle();
    }

    @Override // androidx.appcompat.widget.x
    public boolean h() {
        return this.f١٦٦٦a.hasExpandedActionView();
    }

    @Override // androidx.appcompat.widget.x
    public void i(int i10) {
        View view;
        int i11 = this.f١٦٦٧b ^ i10;
        this.f١٦٦٧b = i10;
        if (i11 != 0) {
            if ((i11 & 4) != 0) {
                if ((i10 & 4) != 0) {
                    H();
                }
                I();
            }
            if ((i11 & 3) != 0) {
                J();
            }
            if ((i11 & 8) != 0) {
                if ((i10 & 8) != 0) {
                    this.f١٦٦٦a.setTitle(this.f١٦٧٤i);
                    this.f١٦٦٦a.setSubtitle(this.f١٦٧٥j);
                } else {
                    this.f١٦٦٦a.setTitle((CharSequence) null);
                    this.f١٦٦٦a.setSubtitle((CharSequence) null);
                }
            }
            if ((i11 & 16) != 0 && (view = this.f١٦٦٩d) != null) {
                if ((i10 & 16) != 0) {
                    this.f١٦٦٦a.addView(view);
                } else {
                    this.f١٦٦٦a.removeView(view);
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.x
    public Menu j() {
        return this.f١٦٦٦a.getMenu();
    }

    @Override // androidx.appcompat.widget.x
    public int k() {
        return this.f١٦٨٠o;
    }

    @Override // androidx.appcompat.widget.x
    public l1 l(int i10, long j10) {
        float f10;
        l1 e10 = d1.e(this.f١٦٦٦a);
        if (i10 == 0) {
            f10 = 1.0f;
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        return e10.b(f10).f(j10).h(new b(i10));
    }

    @Override // androidx.appcompat.widget.x
    public ViewGroup m() {
        return this.f١٦٦٦a;
    }

    @Override // androidx.appcompat.widget.x
    public void n(boolean z10) {
    }

    @Override // androidx.appcompat.widget.x
    public void o() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.x
    public void p(boolean z10) {
        this.f١٦٦٦a.setCollapsible(z10);
    }

    @Override // androidx.appcompat.widget.x
    public void q() {
        this.f١٦٦٦a.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.x
    public void r(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f١٦٦٨c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f١٦٦٦a;
            if (parent == toolbar) {
                toolbar.removeView(this.f١٦٦٨c);
            }
        }
        this.f١٦٦٨c = scrollingTabContainerView;
        if (scrollingTabContainerView != null && this.f١٦٨٠o == 2) {
            this.f١٦٦٦a.addView(scrollingTabContainerView, 0);
            Toolbar.g gVar = (Toolbar.g) this.f١٦٦٨c.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) gVar).width = -2;
            ((ViewGroup.MarginLayoutParams) gVar).height = -2;
            gVar.f٧١٩a = 8388691;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    @Override // androidx.appcompat.widget.x
    public void s(int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = r1.a.b(getContext(), i10);
        } else {
            drawable = null;
        }
        A(drawable);
    }

    @Override // androidx.appcompat.widget.x
    public void setIcon(int i10) {
        setIcon(i10 != 0 ? r1.a.b(getContext(), i10) : null);
    }

    @Override // androidx.appcompat.widget.x
    public void setWindowCallback(Window.Callback callback) {
        this.f١٦٧٧l = callback;
    }

    @Override // androidx.appcompat.widget.x
    public void setWindowTitle(CharSequence charSequence) {
        if (!this.f١٦٧٣h) {
            G(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.x
    public void t(l.a aVar, g.a aVar2) {
        this.f١٦٦٦a.setMenuCallbacks(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.x
    public void u(int i10) {
        this.f١٦٦٦a.setVisibility(i10);
    }

    @Override // androidx.appcompat.widget.x
    public int v() {
        return this.f١٦٦٧b;
    }

    @Override // androidx.appcompat.widget.x
    public void w() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void y(View view) {
        View view2 = this.f١٦٦٩d;
        if (view2 != null && (this.f١٦٦٧b & 16) != 0) {
            this.f١٦٦٦a.removeView(view2);
        }
        this.f١٦٦٩d = view;
        if (view != null && (this.f١٦٦٧b & 16) != 0) {
            this.f١٦٦٦a.addView(view);
        }
    }

    public void z(int i10) {
        if (i10 == this.f١٦٨١p) {
            return;
        }
        this.f١٦٨١p = i10;
        if (TextUtils.isEmpty(this.f١٦٦٦a.getNavigationContentDescription())) {
            B(this.f١٦٨١p);
        }
    }

    public t0(Toolbar toolbar, boolean z10, int i10, int i11) {
        Drawable drawable;
        this.f١٦٨٠o = 0;
        this.f١٦٨١p = 0;
        this.f١٦٦٦a = toolbar;
        this.f١٦٧٤i = toolbar.getTitle();
        this.f١٦٧٥j = toolbar.getSubtitle();
        this.f١٦٧٣h = this.f١٦٧٤i != null;
        this.f١٦٧٢g = toolbar.getNavigationIcon();
        p0 v10 = p0.v(toolbar.getContext(), null, androidx.appcompat.R.styleable.ActionBar, androidx.appcompat.R.attr.actionBarStyle, 0);
        this.f١٦٨٢q = v10.g(androidx.appcompat.R.styleable.ActionBar_homeAsUpIndicator);
        if (z10) {
            CharSequence p10 = v10.p(androidx.appcompat.R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(p10)) {
                F(p10);
            }
            CharSequence p11 = v10.p(androidx.appcompat.R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(p11)) {
                E(p11);
            }
            Drawable g10 = v10.g(androidx.appcompat.R.styleable.ActionBar_logo);
            if (g10 != null) {
                A(g10);
            }
            Drawable g11 = v10.g(androidx.appcompat.R.styleable.ActionBar_icon);
            if (g11 != null) {
                setIcon(g11);
            }
            if (this.f١٦٧٢g == null && (drawable = this.f١٦٨٢q) != null) {
                D(drawable);
            }
            i(v10.k(androidx.appcompat.R.styleable.ActionBar_displayOptions, 0));
            int n10 = v10.n(androidx.appcompat.R.styleable.ActionBar_customNavigationLayout, 0);
            if (n10 != 0) {
                y(LayoutInflater.from(this.f١٦٦٦a.getContext()).inflate(n10, (ViewGroup) this.f١٦٦٦a, false));
                i(this.f١٦٦٧b | 16);
            }
            int m10 = v10.m(androidx.appcompat.R.styleable.ActionBar_height, 0);
            if (m10 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f١٦٦٦a.getLayoutParams();
                layoutParams.height = m10;
                this.f١٦٦٦a.setLayoutParams(layoutParams);
            }
            int e10 = v10.e(androidx.appcompat.R.styleable.ActionBar_contentInsetStart, -1);
            int e11 = v10.e(androidx.appcompat.R.styleable.ActionBar_contentInsetEnd, -1);
            if (e10 >= 0 || e11 >= 0) {
                this.f١٦٦٦a.setContentInsetsRelative(Math.max(e10, 0), Math.max(e11, 0));
            }
            int n11 = v10.n(androidx.appcompat.R.styleable.ActionBar_titleTextStyle, 0);
            if (n11 != 0) {
                Toolbar toolbar2 = this.f١٦٦٦a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), n11);
            }
            int n12 = v10.n(androidx.appcompat.R.styleable.ActionBar_subtitleTextStyle, 0);
            if (n12 != 0) {
                Toolbar toolbar3 = this.f١٦٦٦a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), n12);
            }
            int n13 = v10.n(androidx.appcompat.R.styleable.ActionBar_popupTheme, 0);
            if (n13 != 0) {
                this.f١٦٦٦a.setPopupTheme(n13);
            }
        } else {
            this.f١٦٦٧b = x();
        }
        v10.x();
        z(i10);
        this.f١٦٧٦k = this.f١٦٦٦a.getNavigationContentDescription();
        this.f١٦٦٦a.setNavigationOnClickListener(new a());
    }

    @Override // androidx.appcompat.widget.x
    public void setIcon(Drawable drawable) {
        this.f١٦٧٠e = drawable;
        J();
    }
}
