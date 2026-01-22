package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.t0;
import androidx.core.view.d1;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class b0 extends androidx.appcompat.app.a {

    /* renamed from: a, reason: collision with root package name */
    final androidx.appcompat.widget.x f٧٢٠a;

    /* renamed from: b, reason: collision with root package name */
    final Window.Callback f٧٢١b;

    /* renamed from: c, reason: collision with root package name */
    final AppCompatDelegateImpl.g f٧٢٢c;

    /* renamed from: d, reason: collision with root package name */
    boolean f٧٢٣d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f٧٢٤e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f٧٢٥f;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList f٧٢٦g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final Runnable f٧٢٧h = new a();

    /* renamed from: i, reason: collision with root package name */
    private final Toolbar.h f٧٢٨i;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.y();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b implements Toolbar.h {
        b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.h
        public boolean onMenuItemClick(MenuItem menuItem) {
            return b0.this.f٧٢١b.onMenuItemSelected(0, menuItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public final class c implements l.a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f٧٣١a;

        c() {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z10) {
            if (this.f٧٣١a) {
                return;
            }
            this.f٧٣١a = true;
            b0.this.f٧٢٠a.q();
            b0.this.f٧٢١b.onPanelClosed(108, gVar);
            this.f٧٣١a = false;
        }

        @Override // androidx.appcompat.view.menu.l.a
        public boolean b(androidx.appcompat.view.menu.g gVar) {
            b0.this.f٧٢١b.onMenuOpened(108, gVar);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public final class d implements g.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
            if (b0.this.f٧٢٠a.e()) {
                b0.this.f٧٢١b.onPanelClosed(108, gVar);
            } else if (b0.this.f٧٢١b.onPreparePanel(0, null, gVar)) {
                b0.this.f٧٢١b.onMenuOpened(108, gVar);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private class e implements AppCompatDelegateImpl.g {
        e() {
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.g
        public boolean a(int i10) {
            if (i10 == 0) {
                b0 b0Var = b0.this;
                if (!b0Var.f٧٢٣d) {
                    b0Var.f٧٢٠a.f();
                    b0.this.f٧٢٣d = true;
                    return false;
                }
                return false;
            }
            return false;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.g
        public View onCreatePanelView(int i10) {
            if (i10 == 0) {
                return new View(b0.this.f٧٢٠a.getContext());
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.f٧٢٨i = bVar;
        androidx.core.util.h.g(toolbar);
        t0 t0Var = new t0(toolbar, false);
        this.f٧٢٠a = t0Var;
        this.f٧٢١b = (Window.Callback) androidx.core.util.h.g(callback);
        t0Var.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(bVar);
        t0Var.setWindowTitle(charSequence);
        this.f٧٢٢c = new e();
    }

    private Menu x() {
        if (!this.f٧٢٤e) {
            this.f٧٢٠a.t(new c(), new d());
            this.f٧٢٤e = true;
        }
        return this.f٧٢٠a.j();
    }

    @Override // androidx.appcompat.app.a
    public void addOnMenuVisibilityListener(a.b bVar) {
        this.f٧٢٦g.add(bVar);
    }

    @Override // androidx.appcompat.app.a
    public boolean g() {
        return this.f٧٢٠a.b();
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        if (this.f٧٢٠a.h()) {
            this.f٧٢٠a.collapseActionView();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z10) {
        if (z10 == this.f٧٢٥f) {
            return;
        }
        this.f٧٢٥f = z10;
        if (this.f٧٢٦g.size() <= 0) {
            return;
        }
        a0.a(this.f٧٢٦g.get(0));
        throw null;
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.f٧٢٠a.v();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        return this.f٧٢٠a.getContext();
    }

    @Override // androidx.appcompat.app.a
    public boolean l() {
        this.f٧٢٠a.m().removeCallbacks(this.f٧٢٧h);
        d1.i0(this.f٧٢٠a.m(), this.f٧٢٧h);
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        super.m(configuration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.app.a
    public void n() {
        this.f٧٢٠a.m().removeCallbacks(this.f٧٢٧h);
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i10, KeyEvent keyEvent) {
        int i11;
        Menu x10 = x();
        if (x10 == null) {
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
        x10.setQwertyMode(z10);
        return x10.performShortcut(i10, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            q();
        }
        return true;
    }

    @Override // androidx.appcompat.app.a
    public boolean q() {
        return this.f٧٢٠a.c();
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z10) {
    }

    @Override // androidx.appcompat.app.a
    public void removeOnMenuVisibilityListener(a.b bVar) {
        this.f٧٢٦g.remove(bVar);
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z10) {
        int i10;
        if (z10) {
            i10 = 4;
        } else {
            i10 = 0;
        }
        z(i10, 4);
    }

    @Override // androidx.appcompat.app.a
    public void t(boolean z10) {
        int i10;
        if (z10) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        z(i10, 8);
    }

    @Override // androidx.appcompat.app.a
    public void u(boolean z10) {
    }

    @Override // androidx.appcompat.app.a
    public void v(CharSequence charSequence) {
        this.f٧٢٠a.setWindowTitle(charSequence);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void y() {
        androidx.appcompat.view.menu.g gVar;
        Menu x10 = x();
        if (x10 instanceof androidx.appcompat.view.menu.g) {
            gVar = (androidx.appcompat.view.menu.g) x10;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            gVar.i0();
        }
        try {
            x10.clear();
            if (this.f٧٢١b.onCreatePanelMenu(0, x10)) {
                if (!this.f٧٢١b.onPreparePanel(0, null, x10)) {
                }
                if (gVar == null) {
                    gVar.h0();
                    return;
                }
                return;
            }
            x10.clear();
            if (gVar == null) {
            }
        } catch (Throwable th) {
            if (gVar != null) {
                gVar.h0();
            }
            throw th;
        }
    }

    public void z(int i10, int i11) {
        this.f٧٢٠a.i((i10 & i11) | ((~i11) & this.f٧٢٠a.v()));
    }
}
