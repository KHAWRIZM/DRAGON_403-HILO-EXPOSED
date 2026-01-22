package tech.sud.runtime.core;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import tech.sud.runtime.component.c.b;
import tech.sud.runtime.core.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class a extends FrameLayout {
    private final i a;
    private final c b;
    private final tech.sud.runtime.component.e.d c;
    private final tech.sud.runtime.component.e.b d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private int k;
    private final tech.sud.runtime.component.i.b l;
    private final g m;
    private tech.sud.runtime.component.c.h n;
    private tech.sud.runtime.component.a.a o;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Context context, int i, g gVar, boolean z, int i2, String str, tech.sud.runtime.component.d.a aVar, Integer num) {
        super(context);
        e eVar;
        this.e = false;
        this.f = false;
        this.g = true;
        this.h = false;
        this.i = -1;
        this.j = 0;
        this.k = 0;
        this.n = new tech.sud.runtime.component.c.h();
        this.m = gVar;
        this.f = (i & 16) != 0;
        int i3 = i & 2;
        this.g = i3 != 0;
        this.h = (i & 64) != 0;
        this.e = (i & 128) != 0;
        i iVar = new i(gVar, context, new i.a() { // from class: tech.sud.runtime.core.a.1
            @Override // tech.sud.runtime.core.i.a
            public void a() {
                a aVar2 = a.this;
                aVar2.a(aVar2.getContext());
            }
        });
        this.a = iVar;
        this.l = new tech.sud.runtime.component.i.b(iVar, gVar);
        if (i3 != 0) {
            f fVar = new f(gVar, context);
            fVar.setOpaque((i & 1) == 0);
            fVar.setExternalInterface(aVar);
            this.b = fVar;
            eVar = fVar;
        } else {
            e eVar2 = new e(gVar, context, (i & 1) != 0);
            this.b = eVar2;
            eVar = eVar2;
        }
        iVar.a(eVar);
        tech.sud.runtime.component.e.d dVar = new tech.sud.runtime.component.e.d(context, gVar);
        this.c = dVar;
        iVar.addView(dVar);
        iVar.a(dVar);
        this.b.a().a(dVar);
        this.o = new tech.sud.runtime.component.a.a(context, iVar, i2, str, z);
        this.n.a(context, gVar);
        j();
        iVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(iVar);
        this.d = new tech.sud.runtime.component.e.b(iVar, gVar, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        int i;
        int i2;
        Context context = getContext();
        a(context);
        int i3 = Build.VERSION.SDK_INT;
        b.a a = tech.sud.runtime.component.c.b.a();
        boolean z = this.h;
        if (z && i3 >= 28 && a == b.a.huawei && !tech.sud.runtime.component.c.g.d(context)) {
            z = false;
        }
        if (!z && this.i < 0) {
            if (i3 != 26 && i3 != 27) {
                if (i3 >= 28 && tech.sud.runtime.component.c.g.b(context)) {
                    tech.sud.runtime.component.c.g.n(context);
                }
            } else if (a == b.a.oppo) {
                if (tech.sud.runtime.component.c.g.f(context)) {
                    this.i = tech.sud.runtime.component.c.g.m(context);
                }
            } else if (a == b.a.vivo) {
                if (tech.sud.runtime.component.c.g.g(context)) {
                    this.i = tech.sud.runtime.component.c.g.m(context);
                }
            } else if (a == b.a.smartisan && tech.sud.runtime.component.c.g.h(context)) {
                this.i = tech.sud.runtime.component.c.g.b();
            }
        }
        if (this.i > 0 && this.k > 0) {
            tech.sud.runtime.component.c.h hVar = this.n;
            hVar.a(context, this.m);
            if (tech.sud.runtime.component.c.h.b(context)) {
                if (this.k == hVar.b) {
                    i2 = this.i;
                    i = 0;
                    setPadding(i, i2, 0, 0);
                }
            } else if (this.j == hVar.b && !tech.sud.runtime.component.c.b.b()) {
                i = this.i;
                i2 = 0;
                setPadding(i, i2, 0, 0);
            }
            i = 0;
            i2 = 0;
            setPadding(i, i2, 0, 0);
        }
        if (z) {
            if (i3 != 26 && i3 != 27) {
                if (i3 >= 28) {
                    tech.sud.runtime.component.c.g.o(context);
                }
            } else if (a == b.a.xiaomi) {
                if (tech.sud.runtime.component.c.g.a() && tech.sud.runtime.component.c.g.e(context)) {
                    tech.sud.runtime.component.c.g.p(context);
                }
            } else if (a == b.a.huawei && tech.sud.runtime.component.c.g.c(context) && tech.sud.runtime.component.c.g.d(context)) {
                tech.sud.runtime.component.c.g.q(context);
            }
            if (a == b.a.smartisan && !tech.sud.runtime.component.c.h.b(context)) {
                this.m.a(false, 0, 0);
                return;
            } else if (tech.sud.runtime.component.c.g.a(context)) {
                int[] i4 = tech.sud.runtime.component.c.g.i(context);
                this.m.a(true, i4[0], i4[1]);
                return;
            } else {
                this.m.a(false, 0, 0);
                return;
            }
        }
        this.m.a(false, 0, 0);
    }

    public tech.sud.runtime.component.e.d b() {
        return this.c;
    }

    public i c() {
        return this.a;
    }

    public tech.sud.runtime.component.e.b d() {
        return this.d;
    }

    public c e() {
        return this.b;
    }

    public void f() {
        a(getContext());
        this.b.onResume();
    }

    public void g() {
        this.b.onPause();
    }

    public void h() {
        this.b.a().a();
        this.l.a();
        this.a.a();
        tech.sud.runtime.component.a.a aVar = this.o;
        if (aVar != null) {
            aVar.a();
            this.o = null;
        }
        this.c.a();
        this.d.a();
    }

    public tech.sud.runtime.component.a.a i() {
        return this.o;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (i == this.j && i2 == this.k) {
            return;
        }
        this.j = i;
        this.k = i2;
        post(new Runnable() { // from class: tech.sud.runtime.core.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.j();
            }
        });
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            a(getContext());
        }
    }

    public tech.sud.runtime.component.i.b a() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        a(context, false);
    }

    private void a(Context context, boolean z) {
        if (this.e) {
            return;
        }
        View decorView = tech.sud.runtime.component.h.c.a(context).getWindow().getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        boolean z2 = this.g;
        int i = z2 ? 1028 : 0;
        if (this.f) {
            i = z2 ? i | 4866 : i | 4098;
        }
        if (systemUiVisibility == i) {
            return;
        }
        decorView.setSystemUiVisibility(i);
    }
}
