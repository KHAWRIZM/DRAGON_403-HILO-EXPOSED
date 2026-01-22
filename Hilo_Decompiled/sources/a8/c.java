package a8;

import android.os.Build;
import android.view.View;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.BackEventCompat;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final d f٤٢٩a;

    /* renamed from: b, reason: collision with root package name */
    private final a8.b f٤٣٠b;

    /* renamed from: c, reason: collision with root package name */
    private final View f٤٣١c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b implements d {

        /* renamed from: a, reason: collision with root package name */
        private OnBackInvokedCallback f٤٣٢a;

        private b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0005, code lost:
        
            r2 = r2.findOnBackInvokedDispatcher();
         */
        @Override // a8.c.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view) {
            OnBackInvokedDispatcher findOnBackInvokedDispatcher;
            if (this.f٤٣٢a != null && findOnBackInvokedDispatcher != null) {
                findOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.f٤٣٢a);
                this.f٤٣٢a = null;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0005, code lost:
        
            r3 = r3.findOnBackInvokedDispatcher();
         */
        @Override // a8.c.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(a8.b bVar, View view, boolean z10) {
            OnBackInvokedDispatcher findOnBackInvokedDispatcher;
            int i10;
            if (this.f٤٣٢a != null || findOnBackInvokedDispatcher == null) {
                return;
            }
            OnBackInvokedCallback c10 = c(bVar);
            this.f٤٣٢a = c10;
            if (z10) {
                i10 = 1000000;
            } else {
                i10 = 0;
            }
            findOnBackInvokedDispatcher.registerOnBackInvokedCallback(i10, c10);
        }

        OnBackInvokedCallback c(final a8.b bVar) {
            Objects.requireNonNull(bVar);
            return new OnBackInvokedCallback() { // from class: a8.e
                public final void onBackInvoked() {
                    b.this.f();
                }
            };
        }

        boolean d() {
            if (this.f٤٣٢a != null) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a8.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class C٠٠٠٣c extends b {

        /* renamed from: a8.c$c$a */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a implements OnBackAnimationCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ a8.b f٤٣٣a;

            a(a8.b bVar) {
                this.f٤٣٣a = bVar;
            }

            public void onBackCancelled() {
                if (!C٠٠٠٣c.this.d()) {
                    return;
                }
                this.f٤٣٣a.a();
            }

            public void onBackInvoked() {
                this.f٤٣٣a.f();
            }

            public void onBackProgressed(BackEvent backEvent) {
                if (!C٠٠٠٣c.this.d()) {
                    return;
                }
                this.f٤٣٣a.e(new BackEventCompat(backEvent));
            }

            public void onBackStarted(BackEvent backEvent) {
                if (!C٠٠٠٣c.this.d()) {
                    return;
                }
                this.f٤٣٣a.d(new BackEventCompat(backEvent));
            }
        }

        private C٠٠٠٣c() {
            super();
        }

        @Override // a8.c.b
        OnBackInvokedCallback c(a8.b bVar) {
            return new a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface d {
        void a(View view);

        void b(a8.b bVar, View view, boolean z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(View view) {
        this((a8.b) view, view);
    }

    private static d a() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 34) {
            return new C٠٠٠٣c();
        }
        if (i10 < 33) {
            return null;
        }
        return new b();
    }

    private void d(boolean z10) {
        d dVar = this.f٤٢٩a;
        if (dVar != null) {
            dVar.b(this.f٤٣٠b, this.f٤٣١c, z10);
        }
    }

    public boolean b() {
        if (this.f٤٢٩a != null) {
            return true;
        }
        return false;
    }

    public void c() {
        d(false);
    }

    public void e() {
        d(true);
    }

    public void f() {
        d dVar = this.f٤٢٩a;
        if (dVar != null) {
            dVar.a(this.f٤٣١c);
        }
    }

    public c(a8.b bVar, View view) {
        this.f٤٢٩a = a();
        this.f٤٣٠b = bVar;
        this.f٤٣١c = view;
    }
}
