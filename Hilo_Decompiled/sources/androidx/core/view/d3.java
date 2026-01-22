package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.d3;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d3 {

    /* renamed from: a, reason: collision with root package name */
    private final g f٢٩٦٨a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class a extends g {

        /* renamed from: a, reason: collision with root package name */
        protected final Window f٢٩٦٩a;

        /* renamed from: b, reason: collision with root package name */
        private final q0 f٢٩٧٠b;

        a(Window window, q0 q0Var) {
            this.f٢٩٦٩a = window;
            this.f٢٩٧٠b = q0Var;
        }

        private void g(int i10) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 8) {
                        this.f٢٩٧٠b.a();
                        return;
                    }
                    return;
                }
                h(2);
                return;
            }
            h(4);
        }

        private void j(int i10) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 8) {
                        this.f٢٩٧٠b.b();
                        return;
                    }
                    return;
                }
                k(2);
                return;
            }
            k(4);
            l(1024);
        }

        @Override // androidx.core.view.d3.g
        void a(int i10) {
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    g(i11);
                }
            }
        }

        @Override // androidx.core.view.d3.g
        void addOnControllableInsetsChangedListener(h hVar) {
        }

        @Override // androidx.core.view.d3.g
        void e(int i10) {
            this.f٢٩٦٩a.getDecorView().setTag(356039078, Integer.valueOf(i10));
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        k(2048);
                        h(4096);
                        return;
                    }
                    return;
                }
                k(4096);
                h(2048);
                return;
            }
            k(6144);
        }

        @Override // androidx.core.view.d3.g
        void f(int i10) {
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    j(i11);
                }
            }
        }

        protected void h(int i10) {
            View decorView = this.f٢٩٦٩a.getDecorView();
            decorView.setSystemUiVisibility(i10 | decorView.getSystemUiVisibility());
        }

        protected void i(int i10) {
            this.f٢٩٦٩a.addFlags(i10);
        }

        protected void k(int i10) {
            View decorView = this.f٢٩٦٩a.getDecorView();
            decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
        }

        protected void l(int i10) {
            this.f٢٩٦٩a.clearFlags(i10);
        }

        @Override // androidx.core.view.d3.g
        void removeOnControllableInsetsChangedListener(h hVar) {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class b extends a {
        b(Window window, q0 q0Var) {
            super(window, q0Var);
        }

        @Override // androidx.core.view.d3.g
        public boolean b() {
            if ((this.f٢٩٦٩a.getDecorView().getSystemUiVisibility() & 8192) != 0) {
                return true;
            }
            return false;
        }

        @Override // androidx.core.view.d3.g
        public void d(boolean z10) {
            if (z10) {
                l(67108864);
                i(Integer.MIN_VALUE);
                h(8192);
                return;
            }
            k(8192);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class c extends b {
        c(Window window, q0 q0Var) {
            super(window, q0Var);
        }

        @Override // androidx.core.view.d3.g
        public void c(boolean z10) {
            if (z10) {
                l(134217728);
                i(Integer.MIN_VALUE);
                h(16);
                return;
            }
            k(16);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class e extends d {
        e(Window window, d3 d3Var, q0 q0Var) {
            super(window, d3Var, q0Var);
        }

        @Override // androidx.core.view.d3.d, androidx.core.view.d3.g
        void e(int i10) {
            this.f٢٩٧٢b.setSystemBarsBehavior(i10);
        }

        e(WindowInsetsController windowInsetsController, d3 d3Var, q0 q0Var) {
            super(windowInsetsController, d3Var, q0Var);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class f extends e {
        f(Window window, d3 d3Var, q0 q0Var) {
            super(window, d3Var, q0Var);
        }

        @Override // androidx.core.view.d3.d, androidx.core.view.d3.g
        public boolean b() {
            int systemBarsAppearance;
            systemBarsAppearance = this.f٢٩٧٢b.getSystemBarsAppearance();
            if ((systemBarsAppearance & 8) != 0) {
                return true;
            }
            return false;
        }

        f(WindowInsetsController windowInsetsController, d3 d3Var, q0 q0Var) {
            super(windowInsetsController, d3Var, q0Var);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class g {
        g() {
        }

        abstract void a(int i10);

        void addOnControllableInsetsChangedListener(h hVar) {
        }

        public boolean b() {
            return false;
        }

        public void c(boolean z10) {
        }

        public void d(boolean z10) {
        }

        abstract void e(int i10);

        abstract void f(int i10);

        void removeOnControllableInsetsChangedListener(h hVar) {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface h {
        void a(d3 d3Var, int i10);
    }

    private d3(WindowInsetsController windowInsetsController) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.f٢٩٦٨a = new f(windowInsetsController, this, new q0(windowInsetsController));
        } else {
            this.f٢٩٦٨a = new d(windowInsetsController, this, new q0(windowInsetsController));
        }
    }

    public static d3 g(WindowInsetsController windowInsetsController) {
        return new d3(windowInsetsController);
    }

    public void a(int i10) {
        this.f٢٩٦٨a.a(i10);
    }

    public void addOnControllableInsetsChangedListener(h hVar) {
        this.f٢٩٦٨a.addOnControllableInsetsChangedListener(hVar);
    }

    public boolean b() {
        return this.f٢٩٦٨a.b();
    }

    public void c(boolean z10) {
        this.f٢٩٦٨a.c(z10);
    }

    public void d(boolean z10) {
        this.f٢٩٦٨a.d(z10);
    }

    public void e(int i10) {
        this.f٢٩٦٨a.e(i10);
    }

    public void f(int i10) {
        this.f٢٩٦٨a.f(i10);
    }

    public void removeOnControllableInsetsChangedListener(h hVar) {
        this.f٢٩٦٨a.removeOnControllableInsetsChangedListener(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d extends g {

        /* renamed from: a, reason: collision with root package name */
        final d3 f٢٩٧١a;

        /* renamed from: b, reason: collision with root package name */
        final WindowInsetsController f٢٩٧٢b;

        /* renamed from: c, reason: collision with root package name */
        final q0 f٢٩٧٣c;

        /* renamed from: d, reason: collision with root package name */
        private final SimpleArrayMap f٢٩٧٤d;

        /* renamed from: e, reason: collision with root package name */
        protected Window f٢٩٧٥e;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        d(Window window, d3 d3Var, q0 q0Var) {
            this(r0, d3Var, q0Var);
            WindowInsetsController insetsController;
            insetsController = window.getInsetsController();
            this.f٢٩٧٥e = window;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(h hVar, WindowInsetsController windowInsetsController, int i10) {
            if (this.f٢٩٧٢b == windowInsetsController) {
                hVar.a(this.f٢٩٧١a, i10);
            }
        }

        @Override // androidx.core.view.d3.g
        void a(int i10) {
            if ((i10 & 8) != 0) {
                this.f٢٩٧٣c.a();
            }
            this.f٢٩٧٢b.hide(i10 & (-9));
        }

        @Override // androidx.core.view.d3.g
        void addOnControllableInsetsChangedListener(final h hVar) {
            if (this.f٢٩٧٤d.containsKey(hVar)) {
                return;
            }
            WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListener = new WindowInsetsController.OnControllableInsetsChangedListener(hVar) { // from class: androidx.core.view.j3
                @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
                public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i10) {
                    d3.d.this.h(null, windowInsetsController, i10);
                }
            };
            this.f٢٩٧٤d.put(hVar, onControllableInsetsChangedListener);
            this.f٢٩٧٢b.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
        }

        @Override // androidx.core.view.d3.g
        public boolean b() {
            int systemBarsAppearance;
            this.f٢٩٧٢b.setSystemBarsAppearance(0, 0);
            systemBarsAppearance = this.f٢٩٧٢b.getSystemBarsAppearance();
            if ((systemBarsAppearance & 8) == 0) {
                return false;
            }
            return true;
        }

        @Override // androidx.core.view.d3.g
        public void c(boolean z10) {
            if (z10) {
                if (this.f٢٩٧٥e != null) {
                    i(16);
                }
                this.f٢٩٧٢b.setSystemBarsAppearance(16, 16);
            } else {
                if (this.f٢٩٧٥e != null) {
                    j(16);
                }
                this.f٢٩٧٢b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // androidx.core.view.d3.g
        public void d(boolean z10) {
            if (z10) {
                if (this.f٢٩٧٥e != null) {
                    i(8192);
                }
                this.f٢٩٧٢b.setSystemBarsAppearance(8, 8);
            } else {
                if (this.f٢٩٧٥e != null) {
                    j(8192);
                }
                this.f٢٩٧٢b.setSystemBarsAppearance(0, 8);
            }
        }

        @Override // androidx.core.view.d3.g
        void e(int i10) {
            Window window = this.f٢٩٧٥e;
            if (window == null) {
                this.f٢٩٧٢b.setSystemBarsBehavior(i10);
                return;
            }
            window.getDecorView().setTag(356039078, Integer.valueOf(i10));
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        j(2048);
                        i(4096);
                        return;
                    }
                    return;
                }
                j(4096);
                i(2048);
                return;
            }
            j(6144);
        }

        @Override // androidx.core.view.d3.g
        void f(int i10) {
            if ((i10 & 8) != 0) {
                this.f٢٩٧٣c.b();
            }
            this.f٢٩٧٢b.show(i10 & (-9));
        }

        protected void i(int i10) {
            View decorView = this.f٢٩٧٥e.getDecorView();
            decorView.setSystemUiVisibility(i10 | decorView.getSystemUiVisibility());
        }

        protected void j(int i10) {
            View decorView = this.f٢٩٧٥e.getDecorView();
            decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
        }

        @Override // androidx.core.view.d3.g
        void removeOnControllableInsetsChangedListener(h hVar) {
            WindowInsetsController.OnControllableInsetsChangedListener a10 = i3.a(this.f٢٩٧٤d.remove(hVar));
            if (a10 != null) {
                this.f٢٩٧٢b.removeOnControllableInsetsChangedListener(a10);
            }
        }

        d(WindowInsetsController windowInsetsController, d3 d3Var, q0 q0Var) {
            this.f٢٩٧٤d = new SimpleArrayMap();
            this.f٢٩٧٢b = windowInsetsController;
            this.f٢٩٧١a = d3Var;
            this.f٢٩٧٣c = q0Var;
        }
    }

    public d3(Window window, View view) {
        q0 q0Var = new q0(view);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 35) {
            this.f٢٩٦٨a = new f(window, this, q0Var);
            return;
        }
        if (i10 >= 30) {
            this.f٢٩٦٨a = new d(window, this, q0Var);
            return;
        }
        if (i10 >= 26) {
            this.f٢٩٦٨a = new c(window, q0Var);
        } else if (i10 >= 23) {
            this.f٢٩٦٨a = new b(window, q0Var);
        } else {
            this.f٢٩٦٨a = new a(window, q0Var);
        }
    }
}
