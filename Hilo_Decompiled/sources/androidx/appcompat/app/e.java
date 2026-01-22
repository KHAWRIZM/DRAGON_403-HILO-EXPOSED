package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.e;
import androidx.appcompat.view.b;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.z0;
import androidx.collection.ArraySet;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executor;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    static c f٧٤٦a = new c(new d());

    /* renamed from: b, reason: collision with root package name */
    private static int f٧٤٧b = -100;

    /* renamed from: c, reason: collision with root package name */
    private static androidx.core.os.f f٧٤٨c = null;

    /* renamed from: d, reason: collision with root package name */
    private static androidx.core.os.f f٧٤٩d = null;

    /* renamed from: e, reason: collision with root package name */
    private static Boolean f٧٥٠e = null;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f٧٥١f = false;

    /* renamed from: g, reason: collision with root package name */
    private static final ArraySet f٧٥٢g = new ArraySet();

    /* renamed from: h, reason: collision with root package name */
    private static final Object f٧٥٣h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private static final Object f٧٥٤i = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b {
        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c implements Executor {

        /* renamed from: a, reason: collision with root package name */
        private final Object f٧٥٥a = new Object();

        /* renamed from: b, reason: collision with root package name */
        final Queue f٧٥٦b = new ArrayDeque();

        /* renamed from: c, reason: collision with root package name */
        final Executor f٧٥٧c;

        /* renamed from: d, reason: collision with root package name */
        Runnable f٧٥٨d;

        c(Executor executor) {
            this.f٧٥٧c = executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Runnable runnable) {
            try {
                runnable.run();
            } finally {
                e();
            }
        }

        protected void e() {
            synchronized (this.f٧٥٥a) {
                try {
                    Runnable runnable = (Runnable) this.f٧٥٦b.poll();
                    this.f٧٥٨d = runnable;
                    if (runnable != null) {
                        this.f٧٥٧c.execute(runnable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable runnable) {
            synchronized (this.f٧٥٥a) {
                try {
                    this.f٧٥٦b.add(new Runnable() { // from class: androidx.appcompat.app.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            e.c.this.d(runnable);
                        }
                    });
                    if (this.f٧٥٨d == null) {
                        e();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class d implements Executor {
        d() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void F(e eVar) {
        synchronized (f٧٥٣h) {
            G(eVar);
        }
    }

    private static void G(e eVar) {
        synchronized (f٧٥٣h) {
            try {
                Iterator it = f٧٥٢g.iterator();
                while (it.hasNext()) {
                    e eVar2 = (e) ((WeakReference) it.next()).get();
                    if (eVar2 == eVar || eVar2 == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void I(boolean z10) {
        z0.c(z10);
    }

    static void R(Context context) {
        if (Build.VERSION.SDK_INT >= 33) {
            ComponentName componentName = new ComponentName(context, "androidx.appcompat.app.AppLocalesMetadataHolderService");
            if (context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                if (k().f()) {
                    String b10 = androidx.core.app.e.b(context);
                    Object systemService = context.getSystemService("locale");
                    if (systemService != null) {
                        b.b(systemService, a.a(b10));
                    }
                }
                context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void S(final Context context) {
        if (!v(context)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            if (!f٧٥١f) {
                f٧٤٦a.execute(new Runnable() { // from class: androidx.appcompat.app.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.w(context);
                    }
                });
                return;
            }
            return;
        }
        synchronized (f٧٥٤i) {
            try {
                androidx.core.os.f fVar = f٧٤٨c;
                if (fVar == null) {
                    if (f٧٤٩d == null) {
                        f٧٤٩d = androidx.core.os.f.c(androidx.core.app.e.b(context));
                    }
                    if (f٧٤٩d.f()) {
                    } else {
                        f٧٤٨c = f٧٤٩d;
                    }
                } else if (!fVar.equals(f٧٤٩d)) {
                    androidx.core.os.f fVar2 = f٧٤٨c;
                    f٧٤٩d = fVar2;
                    androidx.core.app.e.a(context, fVar2.h());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(e eVar) {
        synchronized (f٧٥٣h) {
            G(eVar);
            f٧٥٢g.add(new WeakReference(eVar));
        }
    }

    public static e h(Activity activity, androidx.appcompat.app.c cVar) {
        return new AppCompatDelegateImpl(activity, cVar);
    }

    public static e i(Dialog dialog, androidx.appcompat.app.c cVar) {
        return new AppCompatDelegateImpl(dialog, cVar);
    }

    public static androidx.core.os.f k() {
        if (Build.VERSION.SDK_INT >= 33) {
            Object p10 = p();
            if (p10 != null) {
                return androidx.core.os.f.j(b.a(p10));
            }
        } else {
            androidx.core.os.f fVar = f٧٤٨c;
            if (fVar != null) {
                return fVar;
            }
        }
        return androidx.core.os.f.e();
    }

    public static int m() {
        return f٧٤٧b;
    }

    static Object p() {
        Context l10;
        Iterator it = f٧٥٢g.iterator();
        while (it.hasNext()) {
            e eVar = (e) ((WeakReference) it.next()).get();
            if (eVar != null && (l10 = eVar.l()) != null) {
                return l10.getSystemService("locale");
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static androidx.core.os.f r() {
        return f٧٤٨c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean v(Context context) {
        if (f٧٥٠e == null) {
            try {
                Bundle bundle = AppLocalesMetadataHolderService.a(context).metaData;
                if (bundle != null) {
                    f٧٥٠e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f٧٥٠e = Boolean.FALSE;
            }
        }
        return f٧٥٠e.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(Context context) {
        R(context);
        f٧٥١f = true;
    }

    public abstract void A(Bundle bundle);

    public abstract void B();

    public abstract void C(Bundle bundle);

    public abstract void D();

    public abstract void E();

    public abstract boolean H(int i10);

    public abstract void J(int i10);

    public abstract void K(View view);

    public abstract void L(View view, ViewGroup.LayoutParams layoutParams);

    public void M(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public abstract void N(Toolbar toolbar);

    public abstract void O(int i10);

    public abstract void P(CharSequence charSequence);

    public abstract androidx.appcompat.view.b Q(b.a aVar);

    public abstract void e(View view, ViewGroup.LayoutParams layoutParams);

    public void f(Context context) {
    }

    public Context g(Context context) {
        f(context);
        return context;
    }

    public abstract View j(int i10);

    public abstract Context l();

    public abstract androidx.appcompat.app.b n();

    public abstract int o();

    public abstract MenuInflater q();

    public abstract androidx.appcompat.app.a s();

    public abstract void t();

    public abstract void u();

    public abstract void x(Configuration configuration);

    public abstract void y(Bundle bundle);

    public abstract void z();
}
