package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.MenuPopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class p extends j implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, l, View.OnKeyListener {

    /* renamed from: v, reason: collision with root package name */
    private static final int f١٠٨٩v = R.layout.abc_popup_menu_item_layout;

    /* renamed from: b, reason: collision with root package name */
    private final Context f١٠٩٠b;

    /* renamed from: c, reason: collision with root package name */
    private final g f١٠٩١c;

    /* renamed from: d, reason: collision with root package name */
    private final f f١٠٩٢d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f١٠٩٣e;

    /* renamed from: f, reason: collision with root package name */
    private final int f١٠٩٤f;

    /* renamed from: g, reason: collision with root package name */
    private final int f١٠٩٥g;

    /* renamed from: h, reason: collision with root package name */
    private final int f١٠٩٦h;

    /* renamed from: i, reason: collision with root package name */
    final MenuPopupWindow f١٠٩٧i;

    /* renamed from: l, reason: collision with root package name */
    private PopupWindow.OnDismissListener f١١٠٠l;

    /* renamed from: m, reason: collision with root package name */
    private View f١١٠١m;

    /* renamed from: n, reason: collision with root package name */
    View f١١٠٢n;

    /* renamed from: o, reason: collision with root package name */
    private l.a f١١٠٣o;

    /* renamed from: p, reason: collision with root package name */
    ViewTreeObserver f١١٠٤p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f١١٠٥q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f١١٠٦r;

    /* renamed from: s, reason: collision with root package name */
    private int f١١٠٧s;

    /* renamed from: u, reason: collision with root package name */
    private boolean f١١٠٩u;

    /* renamed from: j, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f١٠٩٨j = new a();

    /* renamed from: k, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f١٠٩٩k = new b();

    /* renamed from: t, reason: collision with root package name */
    private int f١١٠٨t = 0;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (p.this.isShowing() && !p.this.f١٠٩٧i.z()) {
                View view = p.this.f١١٠٢n;
                if (view != null && view.isShown()) {
                    p.this.f١٠٩٧i.show();
                } else {
                    p.this.dismiss();
                }
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = p.this.f١١٠٤p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    p.this.f١١٠٤p = view.getViewTreeObserver();
                }
                p pVar = p.this;
                pVar.f١١٠٤p.removeGlobalOnLayoutListener(pVar.f١٠٩٨j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public p(Context context, g gVar, View view, int i10, int i11, boolean z10) {
        this.f١٠٩٠b = context;
        this.f١٠٩١c = gVar;
        this.f١٠٩٣e = z10;
        this.f١٠٩٢d = new f(gVar, LayoutInflater.from(context), z10, f١٠٨٩v);
        this.f١٠٩٥g = i10;
        this.f١٠٩٦h = i11;
        Resources resources = context.getResources();
        this.f١٠٩٤f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f١١٠١m = view;
        this.f١٠٩٧i = new MenuPopupWindow(context, null, i10, i11);
        gVar.c(this, context);
    }

    private boolean y() {
        View view;
        boolean z10;
        if (isShowing()) {
            return true;
        }
        if (this.f١١٠٥q || (view = this.f١١٠١m) == null) {
            return false;
        }
        this.f١١٠٢n = view;
        this.f١٠٩٧i.setOnDismissListener(this);
        this.f١٠٩٧i.setOnItemClickListener(this);
        this.f١٠٩٧i.H(true);
        View view2 = this.f١١٠٢n;
        if (this.f١١٠٤p == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f١١٠٤p = viewTreeObserver;
        if (z10) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f١٠٩٨j);
        }
        view2.addOnAttachStateChangeListener(this.f١٠٩٩k);
        this.f١٠٩٧i.B(view2);
        this.f١٠٩٧i.E(this.f١١٠٨t);
        if (!this.f١١٠٦r) {
            this.f١١٠٧s = j.o(this.f١٠٩٢d, null, this.f١٠٩٠b, this.f١٠٩٤f);
            this.f١١٠٦r = true;
        }
        this.f١٠٩٧i.D(this.f١١٠٧s);
        this.f١٠٩٧i.G(2);
        this.f١٠٩٧i.F(m());
        this.f١٠٩٧i.show();
        ListView n10 = this.f١٠٩٧i.n();
        n10.setOnKeyListener(this);
        if (this.f١١٠٩u && this.f١٠٩١c.z() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f١٠٩٠b).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) n10, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            if (textView != null) {
                textView.setText(this.f١٠٩١c.z());
            }
            frameLayout.setEnabled(false);
            n10.addHeaderView(frameLayout, null, false);
        }
        this.f١٠٩٧i.l(this.f١٠٩٢d);
        this.f١٠٩٧i.show();
        return true;
    }

    @Override // androidx.appcompat.view.menu.l
    public void a(g gVar, boolean z10) {
        if (gVar != this.f١٠٩١c) {
            return;
        }
        dismiss();
        l.a aVar = this.f١١٠٣o;
        if (aVar != null) {
            aVar.a(gVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public void c(l.a aVar) {
        this.f١١٠٣o = aVar;
    }

    @Override // androidx.appcompat.view.menu.l
    public void d(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.o
    public void dismiss() {
        if (isShowing()) {
            this.f١٠٩٧i.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean e(q qVar) {
        if (qVar.hasVisibleItems()) {
            k kVar = new k(this.f١٠٩٠b, qVar, this.f١١٠٢n, this.f١٠٩٣e, this.f١٠٩٥g, this.f١٠٩٦h);
            kVar.i(this.f١١٠٣o);
            kVar.g(j.w(qVar));
            kVar.setOnDismissListener(this.f١١٠٠l);
            this.f١١٠٠l = null;
            this.f١٠٩١c.e(false);
            int c10 = this.f١٠٩٧i.c();
            int k10 = this.f١٠٩٧i.k();
            if ((Gravity.getAbsoluteGravity(this.f١١٠٨t, this.f١١٠١m.getLayoutDirection()) & 7) == 5) {
                c10 += this.f١١٠١m.getWidth();
            }
            if (kVar.m(c10, k10)) {
                l.a aVar = this.f١١٠٣o;
                if (aVar != null) {
                    aVar.b(qVar);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void f(g gVar) {
    }

    @Override // androidx.appcompat.view.menu.l
    public Parcelable g() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.l
    public void h(boolean z10) {
        this.f١١٠٦r = false;
        f fVar = this.f١٠٩٢d;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.o
    public boolean isShowing() {
        if (!this.f١١٠٥q && this.f١٠٩٧i.isShowing()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.o
    public ListView n() {
        return this.f١٠٩٧i.n();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f١١٠٥q = true;
        this.f١٠٩١c.close();
        ViewTreeObserver viewTreeObserver = this.f١١٠٤p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f١١٠٤p = this.f١١٠٢n.getViewTreeObserver();
            }
            this.f١١٠٤p.removeGlobalOnLayoutListener(this.f١٠٩٨j);
            this.f١١٠٤p = null;
        }
        this.f١١٠٢n.removeOnAttachStateChangeListener(this.f١٠٩٩k);
        PopupWindow.OnDismissListener onDismissListener = this.f١١٠٠l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i10 == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void p(View view) {
        this.f١١٠١m = view;
    }

    @Override // androidx.appcompat.view.menu.j
    public void r(boolean z10) {
        this.f١٠٩٢d.d(z10);
    }

    @Override // androidx.appcompat.view.menu.j
    public void s(int i10) {
        this.f١١٠٨t = i10;
    }

    @Override // androidx.appcompat.view.menu.j
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f١١٠٠l = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.o
    public void show() {
        if (y()) {
        } else {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void t(int i10) {
        this.f١٠٩٧i.d(i10);
    }

    @Override // androidx.appcompat.view.menu.j
    public void u(boolean z10) {
        this.f١١٠٩u = z10;
    }

    @Override // androidx.appcompat.view.menu.j
    public void v(int i10) {
        this.f١٠٩٧i.h(i10);
    }
}
