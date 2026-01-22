package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.appcompat.widget.g0;
import androidx.core.view.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d extends j implements l, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: B, reason: collision with root package name */
    private static final int f٩٦٢B = R.layout.abc_cascading_menu_item_layout;
    boolean A;

    /* renamed from: b, reason: collision with root package name */
    private final Context f٩٦٣b;

    /* renamed from: c, reason: collision with root package name */
    private final int f٩٦٤c;

    /* renamed from: d, reason: collision with root package name */
    private final int f٩٦٥d;

    /* renamed from: e, reason: collision with root package name */
    private final int f٩٦٦e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f٩٦٧f;

    /* renamed from: g, reason: collision with root package name */
    final Handler f٩٦٨g;

    /* renamed from: o, reason: collision with root package name */
    private View f٩٧٦o;

    /* renamed from: p, reason: collision with root package name */
    View f٩٧٧p;

    /* renamed from: r, reason: collision with root package name */
    private boolean f٩٧٩r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f٩٨٠s;

    /* renamed from: t, reason: collision with root package name */
    private int f٩٨١t;

    /* renamed from: u, reason: collision with root package name */
    private int f٩٨٢u;

    /* renamed from: w, reason: collision with root package name */
    private boolean f٩٨٤w;

    /* renamed from: x, reason: collision with root package name */
    private l.a f٩٨٥x;

    /* renamed from: y, reason: collision with root package name */
    ViewTreeObserver f٩٨٦y;

    /* renamed from: z, reason: collision with root package name */
    private PopupWindow.OnDismissListener f٩٨٧z;

    /* renamed from: h, reason: collision with root package name */
    private final List f٩٦٩h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    final List f٩٧٠i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f٩٧١j = new a();

    /* renamed from: k, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f٩٧٢k = new b();

    /* renamed from: l, reason: collision with root package name */
    private final g0 f٩٧٣l = new c();

    /* renamed from: m, reason: collision with root package name */
    private int f٩٧٤m = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f٩٧٥n = 0;

    /* renamed from: v, reason: collision with root package name */
    private boolean f٩٨٣v = false;

    /* renamed from: q, reason: collision with root package name */
    private int f٩٧٨q = C();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.isShowing() && d.this.f٩٧٠i.size() > 0 && !((C٠٠٠٨d) d.this.f٩٧٠i.get(0)).f٩٩٥a.z()) {
                View view = d.this.f٩٧٧p;
                if (view != null && view.isShown()) {
                    Iterator it = d.this.f٩٧٠i.iterator();
                    while (it.hasNext()) {
                        ((C٠٠٠٨d) it.next()).f٩٩٥a.show();
                    }
                    return;
                }
                d.this.dismiss();
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
            ViewTreeObserver viewTreeObserver = d.this.f٩٨٦y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    d.this.f٩٨٦y = view.getViewTreeObserver();
                }
                d dVar = d.this;
                dVar.f٩٨٦y.removeGlobalOnLayoutListener(dVar.f٩٧١j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class c implements g0 {

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ C٠٠٠٨d f٩٩١a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ MenuItem f٩٩٢b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ g f٩٩٣c;

            a(C٠٠٠٨d r22, MenuItem menuItem, g gVar) {
                this.f٩٩١a = r22;
                this.f٩٩٢b = menuItem;
                this.f٩٩٣c = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C٠٠٠٨d r02 = this.f٩٩١a;
                if (r02 != null) {
                    d.this.A = true;
                    r02.f٩٩٦b.e(false);
                    d.this.A = false;
                }
                if (this.f٩٩٢b.isEnabled() && this.f٩٩٢b.hasSubMenu()) {
                    this.f٩٩٣c.O(this.f٩٩٢b, 4);
                }
            }
        }

        c() {
        }

        @Override // androidx.appcompat.widget.g0
        public void a(g gVar, MenuItem menuItem) {
            C٠٠٠٨d r12 = null;
            d.this.f٩٦٨g.removeCallbacksAndMessages(null);
            int size = d.this.f٩٧٠i.size();
            int i10 = 0;
            while (true) {
                if (i10 < size) {
                    if (gVar == ((C٠٠٠٨d) d.this.f٩٧٠i.get(i10)).f٩٩٦b) {
                        break;
                    } else {
                        i10++;
                    }
                } else {
                    i10 = -1;
                    break;
                }
            }
            if (i10 == -1) {
                return;
            }
            int i11 = i10 + 1;
            if (i11 < d.this.f٩٧٠i.size()) {
                r12 = (C٠٠٠٨d) d.this.f٩٧٠i.get(i11);
            }
            d.this.f٩٦٨g.postAtTime(new a(r12, menuItem, gVar), gVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.g0
        public void m(g gVar, MenuItem menuItem) {
            d.this.f٩٦٨g.removeCallbacksAndMessages(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.appcompat.view.menu.d$d, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class C٠٠٠٨d {

        /* renamed from: a, reason: collision with root package name */
        public final MenuPopupWindow f٩٩٥a;

        /* renamed from: b, reason: collision with root package name */
        public final g f٩٩٦b;

        /* renamed from: c, reason: collision with root package name */
        public final int f٩٩٧c;

        public C٠٠٠٨d(MenuPopupWindow menuPopupWindow, g gVar, int i10) {
            this.f٩٩٥a = menuPopupWindow;
            this.f٩٩٦b = gVar;
            this.f٩٩٧c = i10;
        }

        public ListView a() {
            return this.f٩٩٥a.n();
        }
    }

    public d(Context context, View view, int i10, int i11, boolean z10) {
        this.f٩٦٣b = context;
        this.f٩٧٦o = view;
        this.f٩٦٥d = i10;
        this.f٩٦٦e = i11;
        this.f٩٦٧f = z10;
        Resources resources = context.getResources();
        this.f٩٦٤c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f٩٦٨g = new Handler();
    }

    private MenuItem A(g gVar, g gVar2) {
        int size = gVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = gVar.getItem(i10);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View B(C٠٠٠٨d r82, g gVar) {
        f fVar;
        int i10;
        int firstVisiblePosition;
        MenuItem A = A(r82.f٩٩٦b, gVar);
        if (A == null) {
            return null;
        }
        ListView a10 = r82.a();
        ListAdapter adapter = a10.getAdapter();
        int i11 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i10 = headerViewListAdapter.getHeadersCount();
            fVar = (f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (f) adapter;
            i10 = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i11 < count) {
                if (A == fVar.getItem(i11)) {
                    break;
                }
                i11++;
            } else {
                i11 = -1;
                break;
            }
        }
        if (i11 == -1 || (firstVisiblePosition = (i11 + i10) - a10.getFirstVisiblePosition()) < 0 || firstVisiblePosition >= a10.getChildCount()) {
            return null;
        }
        return a10.getChildAt(firstVisiblePosition);
    }

    private int C() {
        if (this.f٩٧٦o.getLayoutDirection() != 1) {
            return 1;
        }
        return 0;
    }

    private int D(int i10) {
        List list = this.f٩٧٠i;
        ListView a10 = ((C٠٠٠٨d) list.get(list.size() - 1)).a();
        int[] iArr = new int[2];
        a10.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f٩٧٧p.getWindowVisibleDisplayFrame(rect);
        if (this.f٩٧٨q == 1) {
            if (iArr[0] + a10.getWidth() + i10 <= rect.right) {
                return 1;
            }
            return 0;
        }
        if (iArr[0] - i10 < 0) {
            return 1;
        }
        return 0;
    }

    private void E(g gVar) {
        C٠٠٠٨d r12;
        View view;
        boolean z10;
        int i10;
        int i11;
        int i12;
        LayoutInflater from = LayoutInflater.from(this.f٩٦٣b);
        f fVar = new f(gVar, from, this.f٩٦٧f, f٩٦٢B);
        if (!isShowing() && this.f٩٨٣v) {
            fVar.d(true);
        } else if (isShowing()) {
            fVar.d(j.w(gVar));
        }
        int o10 = j.o(fVar, null, this.f٩٦٣b, this.f٩٦٤c);
        MenuPopupWindow y10 = y();
        y10.l(fVar);
        y10.D(o10);
        y10.E(this.f٩٧٥n);
        if (this.f٩٧٠i.size() > 0) {
            List list = this.f٩٧٠i;
            r12 = (C٠٠٠٨d) list.get(list.size() - 1);
            view = B(r12, gVar);
        } else {
            r12 = null;
            view = null;
        }
        if (view != null) {
            y10.Q(false);
            y10.N(null);
            int D = D(o10);
            if (D == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f٩٧٨q = D;
            if (Build.VERSION.SDK_INT >= 26) {
                y10.B(view);
                i11 = 0;
                i10 = 0;
            } else {
                int[] iArr = new int[2];
                this.f٩٧٦o.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f٩٧٥n & 7) == 5) {
                    iArr[0] = iArr[0] + this.f٩٧٦o.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i10 = iArr2[0] - iArr[0];
                i11 = iArr2[1] - iArr[1];
            }
            if ((this.f٩٧٥n & 5) == 5) {
                if (!z10) {
                    o10 = view.getWidth();
                    i12 = i10 - o10;
                }
                i12 = i10 + o10;
            } else {
                if (z10) {
                    o10 = view.getWidth();
                    i12 = i10 + o10;
                }
                i12 = i10 - o10;
            }
            y10.d(i12);
            y10.I(true);
            y10.h(i11);
        } else {
            if (this.f٩٧٩r) {
                y10.d(this.f٩٨١t);
            }
            if (this.f٩٨٠s) {
                y10.h(this.f٩٨٢u);
            }
            y10.F(m());
        }
        this.f٩٧٠i.add(new C٠٠٠٨d(y10, gVar, this.f٩٧٨q));
        y10.show();
        ListView n10 = y10.n();
        n10.setOnKeyListener(this);
        if (r12 == null && this.f٩٨٤w && gVar.z() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) n10, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(gVar.z());
            n10.addHeaderView(frameLayout, null, false);
            y10.show();
        }
    }

    private MenuPopupWindow y() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.f٩٦٣b, null, this.f٩٦٥d, this.f٩٦٦e);
        menuPopupWindow.P(this.f٩٧٣l);
        menuPopupWindow.setOnItemClickListener(this);
        menuPopupWindow.setOnDismissListener(this);
        menuPopupWindow.B(this.f٩٧٦o);
        menuPopupWindow.E(this.f٩٧٥n);
        menuPopupWindow.H(true);
        menuPopupWindow.G(2);
        return menuPopupWindow;
    }

    private int z(g gVar) {
        int size = this.f٩٧٠i.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (gVar == ((C٠٠٠٨d) this.f٩٧٠i.get(i10)).f٩٩٦b) {
                return i10;
            }
        }
        return -1;
    }

    @Override // androidx.appcompat.view.menu.l
    public void a(g gVar, boolean z10) {
        int z11 = z(gVar);
        if (z11 < 0) {
            return;
        }
        int i10 = z11 + 1;
        if (i10 < this.f٩٧٠i.size()) {
            ((C٠٠٠٨d) this.f٩٧٠i.get(i10)).f٩٩٦b.e(false);
        }
        C٠٠٠٨d r02 = (C٠٠٠٨d) this.f٩٧٠i.remove(z11);
        r02.f٩٩٦b.R(this);
        if (this.A) {
            r02.f٩٩٥a.O(null);
            r02.f٩٩٥a.C(0);
        }
        r02.f٩٩٥a.dismiss();
        int size = this.f٩٧٠i.size();
        if (size > 0) {
            this.f٩٧٨q = ((C٠٠٠٨d) this.f٩٧٠i.get(size - 1)).f٩٩٧c;
        } else {
            this.f٩٧٨q = C();
        }
        if (size == 0) {
            dismiss();
            l.a aVar = this.f٩٨٥x;
            if (aVar != null) {
                aVar.a(gVar, true);
            }
            ViewTreeObserver viewTreeObserver = this.f٩٨٦y;
            if (viewTreeObserver != null) {
                if (viewTreeObserver.isAlive()) {
                    this.f٩٨٦y.removeGlobalOnLayoutListener(this.f٩٧١j);
                }
                this.f٩٨٦y = null;
            }
            this.f٩٧٧p.removeOnAttachStateChangeListener(this.f٩٧٢k);
            this.f٩٨٧z.onDismiss();
            return;
        }
        if (z10) {
            ((C٠٠٠٨d) this.f٩٧٠i.get(0)).f٩٩٦b.e(false);
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public void c(l.a aVar) {
        this.f٩٨٥x = aVar;
    }

    @Override // androidx.appcompat.view.menu.l
    public void d(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.o
    public void dismiss() {
        int size = this.f٩٧٠i.size();
        if (size > 0) {
            C٠٠٠٨d[] r12 = (C٠٠٠٨d[]) this.f٩٧٠i.toArray(new C٠٠٠٨d[size]);
            for (int i10 = size - 1; i10 >= 0; i10--) {
                C٠٠٠٨d r22 = r12[i10];
                if (r22.f٩٩٥a.isShowing()) {
                    r22.f٩٩٥a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean e(q qVar) {
        for (C٠٠٠٨d r12 : this.f٩٧٠i) {
            if (qVar == r12.f٩٩٦b) {
                r12.a().requestFocus();
                return true;
            }
        }
        if (qVar.hasVisibleItems()) {
            f(qVar);
            l.a aVar = this.f٩٨٥x;
            if (aVar != null) {
                aVar.b(qVar);
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void f(g gVar) {
        gVar.c(this, this.f٩٦٣b);
        if (isShowing()) {
            E(gVar);
        } else {
            this.f٩٦٩h.add(gVar);
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public Parcelable g() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.l
    public void h(boolean z10) {
        Iterator it = this.f٩٧٠i.iterator();
        while (it.hasNext()) {
            j.x(((C٠٠٠٨d) it.next()).a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.o
    public boolean isShowing() {
        if (this.f٩٧٠i.size() <= 0 || !((C٠٠٠٨d) this.f٩٧٠i.get(0)).f٩٩٥a.isShowing()) {
            return false;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    protected boolean l() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.o
    public ListView n() {
        if (this.f٩٧٠i.isEmpty()) {
            return null;
        }
        return ((C٠٠٠٨d) this.f٩٧٠i.get(r0.size() - 1)).a();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        C٠٠٠٨d r32;
        int size = this.f٩٧٠i.size();
        int i10 = 0;
        while (true) {
            if (i10 < size) {
                r32 = (C٠٠٠٨d) this.f٩٧٠i.get(i10);
                if (!r32.f٩٩٥a.isShowing()) {
                    break;
                } else {
                    i10++;
                }
            } else {
                r32 = null;
                break;
            }
        }
        if (r32 != null) {
            r32.f٩٩٦b.e(false);
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
        if (this.f٩٧٦o != view) {
            this.f٩٧٦o = view;
            this.f٩٧٥n = t.b(this.f٩٧٤m, view.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void r(boolean z10) {
        this.f٩٨٣v = z10;
    }

    @Override // androidx.appcompat.view.menu.j
    public void s(int i10) {
        if (this.f٩٧٤m != i10) {
            this.f٩٧٤m = i10;
            this.f٩٧٥n = t.b(i10, this.f٩٧٦o.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f٩٨٧z = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.o
    public void show() {
        boolean z10;
        if (isShowing()) {
            return;
        }
        Iterator it = this.f٩٦٩h.iterator();
        while (it.hasNext()) {
            E((g) it.next());
        }
        this.f٩٦٩h.clear();
        View view = this.f٩٧٦o;
        this.f٩٧٧p = view;
        if (view != null) {
            if (this.f٩٨٦y == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f٩٨٦y = viewTreeObserver;
            if (z10) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f٩٧١j);
            }
            this.f٩٧٧p.addOnAttachStateChangeListener(this.f٩٧٢k);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void t(int i10) {
        this.f٩٧٩r = true;
        this.f٩٨١t = i10;
    }

    @Override // androidx.appcompat.view.menu.j
    public void u(boolean z10) {
        this.f٩٨٤w = z10;
    }

    @Override // androidx.appcompat.view.menu.j
    public void v(int i10) {
        this.f٩٨٠s = true;
        this.f٩٨٢u = i10;
    }
}
