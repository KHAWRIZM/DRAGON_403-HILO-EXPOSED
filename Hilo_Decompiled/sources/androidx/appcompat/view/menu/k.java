package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.l;
import androidx.core.view.t;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final Context f١٠٧٥a;

    /* renamed from: b, reason: collision with root package name */
    private final g f١٠٧٦b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f١٠٧٧c;

    /* renamed from: d, reason: collision with root package name */
    private final int f١٠٧٨d;

    /* renamed from: e, reason: collision with root package name */
    private final int f١٠٧٩e;

    /* renamed from: f, reason: collision with root package name */
    private View f١٠٨٠f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٠٨١g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f١٠٨٢h;

    /* renamed from: i, reason: collision with root package name */
    private l.a f١٠٨٣i;

    /* renamed from: j, reason: collision with root package name */
    private j f١٠٨٤j;

    /* renamed from: k, reason: collision with root package name */
    private PopupWindow.OnDismissListener f١٠٨٥k;

    /* renamed from: l, reason: collision with root package name */
    private final PopupWindow.OnDismissListener f١٠٨٦l;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            k.this.e();
        }
    }

    public k(Context context, g gVar, View view, boolean z10, int i10) {
        this(context, gVar, view, z10, i10, 0);
    }

    private j a() {
        j pVar;
        Display defaultDisplay = ((WindowManager) this.f١٠٧٥a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        if (Math.min(point.x, point.y) >= this.f١٠٧٥a.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
            pVar = new d(this.f١٠٧٥a, this.f١٠٨٠f, this.f١٠٧٨d, this.f١٠٧٩e, this.f١٠٧٧c);
        } else {
            pVar = new p(this.f١٠٧٥a, this.f١٠٧٦b, this.f١٠٨٠f, this.f١٠٧٨d, this.f١٠٧٩e, this.f١٠٧٧c);
        }
        pVar.f(this.f١٠٧٦b);
        pVar.setOnDismissListener(this.f١٠٨٦l);
        pVar.p(this.f١٠٨٠f);
        pVar.c(this.f١٠٨٣i);
        pVar.r(this.f١٠٨٢h);
        pVar.s(this.f١٠٨١g);
        return pVar;
    }

    private void k(int i10, int i11, boolean z10, boolean z11) {
        j c10 = c();
        c10.u(z11);
        if (z10) {
            if ((t.b(this.f١٠٨١g, this.f١٠٨٠f.getLayoutDirection()) & 7) == 5) {
                i10 -= this.f١٠٨٠f.getWidth();
            }
            c10.t(i10);
            c10.v(i11);
            int i12 = (int) ((this.f١٠٧٥a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            c10.q(new Rect(i10 - i12, i11 - i12, i10 + i12, i11 + i12));
        }
        c10.show();
    }

    public void b() {
        if (d()) {
            this.f١٠٨٤j.dismiss();
        }
    }

    public j c() {
        if (this.f١٠٨٤j == null) {
            this.f١٠٨٤j = a();
        }
        return this.f١٠٨٤j;
    }

    public boolean d() {
        j jVar = this.f١٠٨٤j;
        if (jVar != null && jVar.isShowing()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.f١٠٨٤j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f١٠٨٥k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f١٠٨٠f = view;
    }

    public void g(boolean z10) {
        this.f١٠٨٢h = z10;
        j jVar = this.f١٠٨٤j;
        if (jVar != null) {
            jVar.r(z10);
        }
    }

    public void h(int i10) {
        this.f١٠٨١g = i10;
    }

    public void i(l.a aVar) {
        this.f١٠٨٣i = aVar;
        j jVar = this.f١٠٨٤j;
        if (jVar != null) {
            jVar.c(aVar);
        }
    }

    public void j() {
        if (l()) {
        } else {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean l() {
        if (d()) {
            return true;
        }
        if (this.f١٠٨٠f == null) {
            return false;
        }
        k(0, 0, false, false);
        return true;
    }

    public boolean m(int i10, int i11) {
        if (d()) {
            return true;
        }
        if (this.f١٠٨٠f == null) {
            return false;
        }
        k(i10, i11, true, true);
        return true;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f١٠٨٥k = onDismissListener;
    }

    public k(Context context, g gVar, View view, boolean z10, int i10, int i11) {
        this.f١٠٨١g = 8388611;
        this.f١٠٨٦l = new a();
        this.f١٠٧٥a = context;
        this.f١٠٧٦b = gVar;
        this.f١٠٨٠f = view;
        this.f١٠٧٧c = z10;
        this.f١٠٧٨d = i10;
        this.f١٠٧٩e = i11;
    }
}
