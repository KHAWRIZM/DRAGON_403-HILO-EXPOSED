package androidx.core.view;

import android.R;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.q0;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class q0 {

    /* renamed from: a, reason: collision with root package name */
    private final c f٣٠٠٩a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class a extends c {

        /* renamed from: a, reason: collision with root package name */
        private final View f٣٠١٠a;

        a(View view) {
            this.f٣٠١٠a = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(View view) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
        }

        @Override // androidx.core.view.q0.c
        void a() {
            View view = this.f٣٠١٠a;
            if (view != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f٣٠١٠a.getWindowToken(), 0);
            }
        }

        @Override // androidx.core.view.q0.c
        void b() {
            final View view = this.f٣٠١٠a;
            if (view == null) {
                return;
            }
            if (!view.isInEditMode() && !view.onCheckIsTextEditor()) {
                view = view.getRootView().findFocus();
            } else {
                view.requestFocus();
            }
            if (view == null) {
                view = this.f٣٠١٠a.getRootView().findViewById(R.id.content);
            }
            if (view != null && view.hasWindowFocus()) {
                view.post(new Runnable() { // from class: androidx.core.view.p0
                    @Override // java.lang.Runnable
                    public final void run() {
                        q0.a.d(view);
                    }
                });
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class c {
        c() {
        }

        abstract void a();

        abstract void b();
    }

    public q0(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f٣٠٠٩a = new b(view);
        } else {
            this.f٣٠٠٩a = new a(view);
        }
    }

    public void a() {
        this.f٣٠٠٩a.a();
    }

    public void b() {
        this.f٣٠٠٩a.b();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class b extends a {

        /* renamed from: b, reason: collision with root package name */
        private View f٣٠١١b;

        /* renamed from: c, reason: collision with root package name */
        private WindowInsetsController f٣٠١٢c;

        b(View view) {
            super(view);
            this.f٣٠١١b = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void f(AtomicBoolean atomicBoolean, WindowInsetsController windowInsetsController, int i10) {
            boolean z10;
            if ((i10 & 8) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            atomicBoolean.set(z10);
        }

        @Override // androidx.core.view.q0.a, androidx.core.view.q0.c
        void a() {
            int ime;
            View view;
            WindowInsetsController windowInsetsController = this.f٣٠١٢c;
            if (windowInsetsController == null) {
                View view2 = this.f٣٠١١b;
                windowInsetsController = view2 != null ? view2.getWindowInsetsController() : null;
            }
            if (windowInsetsController != null) {
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListener = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: androidx.core.view.x0
                    @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
                    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController2, int i10) {
                        q0.b.f(atomicBoolean, windowInsetsController2, i10);
                    }
                };
                windowInsetsController.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
                if (!atomicBoolean.get() && (view = this.f٣٠١١b) != null) {
                    ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f٣٠١١b.getWindowToken(), 0);
                }
                windowInsetsController.removeOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
                ime = WindowInsets.Type.ime();
                windowInsetsController.hide(ime);
                return;
            }
            super.a();
        }

        @Override // androidx.core.view.q0.a, androidx.core.view.q0.c
        void b() {
            int ime;
            View view = this.f٣٠١١b;
            if (view != null && Build.VERSION.SDK_INT < 33) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).isActive();
            }
            WindowInsetsController windowInsetsController = this.f٣٠١٢c;
            if (windowInsetsController == null) {
                View view2 = this.f٣٠١١b;
                if (view2 != null) {
                    windowInsetsController = view2.getWindowInsetsController();
                } else {
                    windowInsetsController = null;
                }
            }
            if (windowInsetsController != null) {
                ime = WindowInsets.Type.ime();
                windowInsetsController.show(ime);
            }
            super.b();
        }

        b(WindowInsetsController windowInsetsController) {
            super(null);
            this.f٣٠١٢c = windowInsetsController;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q0(WindowInsetsController windowInsetsController) {
        this.f٣٠٠٩a = new b(windowInsetsController);
    }
}
