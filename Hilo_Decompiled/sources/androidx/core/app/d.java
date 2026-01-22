package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    protected static final Class f٢٦٢٤a;

    /* renamed from: b, reason: collision with root package name */
    protected static final Field f٢٦٢٥b;

    /* renamed from: c, reason: collision with root package name */
    protected static final Field f٢٦٢٦c;

    /* renamed from: d, reason: collision with root package name */
    protected static final Method f٢٦٢٧d;

    /* renamed from: e, reason: collision with root package name */
    protected static final Method f٢٦٢٨e;

    /* renamed from: f, reason: collision with root package name */
    protected static final Method f٢٦٢٩f;

    /* renamed from: g, reason: collision with root package name */
    private static final Handler f٢٦٣٠g = new Handler(Looper.getMainLooper());

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ C٠٠٢١d f٢٦٣١a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f٢٦٣٢b;

        a(C٠٠٢١d r12, Object obj) {
            this.f٢٦٣١a = r12;
            this.f٢٦٣٢b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f٢٦٣١a.f٢٦٣٧a = this.f٢٦٣٢b;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Application f٢٦٣٣a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ C٠٠٢١d f٢٦٣٤b;

        b(Application application, C٠٠٢١d r22) {
            this.f٢٦٣٣a = application;
            this.f٢٦٣٤b = r22;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f٢٦٣٣a.unregisterActivityLifecycleCallbacks(this.f٢٦٣٤b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f٢٦٣٥a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f٢٦٣٦b;

        c(Object obj, Object obj2) {
            this.f٢٦٣٥a = obj;
            this.f٢٦٣٦b = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = d.f٢٦٢٧d;
                if (method != null) {
                    method.invoke(this.f٢٦٣٥a, this.f٢٦٣٦b, Boolean.FALSE, "AppCompat recreation");
                } else {
                    d.f٢٦٢٨e.invoke(this.f٢٦٣٥a, this.f٢٦٣٦b, Boolean.FALSE);
                }
            } catch (RuntimeException e10) {
                if (e10.getClass() == RuntimeException.class && e10.getMessage() != null && e10.getMessage().startsWith("Unable to stop")) {
                    throw e10;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    /* renamed from: androidx.core.app.d$d, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static final class C٠٠٢١d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a, reason: collision with root package name */
        Object f٢٦٣٧a;

        /* renamed from: b, reason: collision with root package name */
        private Activity f٢٦٣٨b;

        /* renamed from: c, reason: collision with root package name */
        private final int f٢٦٣٩c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f٢٦٤٠d = false;

        /* renamed from: e, reason: collision with root package name */
        private boolean f٢٦٤١e = false;

        /* renamed from: f, reason: collision with root package name */
        private boolean f٢٦٤٢f = false;

        C٠٠٢١d(Activity activity) {
            this.f٢٦٣٨b = activity;
            this.f٢٦٣٩c = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f٢٦٣٨b == activity) {
                this.f٢٦٣٨b = null;
                this.f٢٦٤١e = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (this.f٢٦٤١e && !this.f٢٦٤٢f && !this.f٢٦٤٠d && d.h(this.f٢٦٣٧a, this.f٢٦٣٩c, activity)) {
                this.f٢٦٤٢f = true;
                this.f٢٦٣٧a = null;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f٢٦٣٨b == activity) {
                this.f٢٦٤٠d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class a10 = a();
        f٢٦٢٤a = a10;
        f٢٦٢٥b = b();
        f٢٦٢٦c = f();
        f٢٦٢٧d = d(a10);
        f٢٦٢٨e = c(a10);
        f٢٦٢٩f = e(a10);
    }

    private static Class a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 != 26 && i10 != 27) {
            return false;
        }
        return true;
    }

    protected static boolean h(Object obj, int i10, Activity activity) {
        try {
            Object obj2 = f٢٦٢٦c.get(activity);
            if (obj2 == obj && activity.hashCode() == i10) {
                f٢٦٣٠g.postAtFrontOfQueue(new c(f٢٦٢٥b.get(activity), obj2));
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && f٢٦٢٩f == null) {
            return false;
        }
        if (f٢٦٢٨e == null && f٢٦٢٧d == null) {
            return false;
        }
        try {
            Object obj2 = f٢٦٢٦c.get(activity);
            if (obj2 == null || (obj = f٢٦٢٥b.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            C٠٠٢١d r62 = new C٠٠٢١d(activity);
            application.registerActivityLifecycleCallbacks(r62);
            Handler handler = f٢٦٣٠g;
            handler.post(new a(r62, obj2));
            try {
                if (g()) {
                    Method method = f٢٦٢٩f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new b(application, r62));
                return true;
            } catch (Throwable th) {
                f٢٦٣٠g.post(new b(application, r62));
                throw th;
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
