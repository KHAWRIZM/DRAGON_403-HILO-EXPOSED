package u;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e implements Application.ActivityLifecycleCallbacks {

    /* renamed from: e, reason: collision with root package name */
    public static final String f١٨٢١٧e = "SudGIP ".concat(e.class.getSimpleName());

    /* renamed from: a, reason: collision with root package name */
    public int f١٨٢١٨a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f١٨٢١٩b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public boolean f١٨٢٢٠c;

    /* renamed from: d, reason: collision with root package name */
    public Activity f١٨٢٢١d;

    public final void a(Application application) {
        if (this.f١٨٢٢٠c) {
            return;
        }
        this.f١٨٢٢٠c = true;
        Activity b10 = d.b();
        if (b10 != null) {
            this.f١٨٢٢١d = b10;
        }
        application.registerActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        SudLogger.d(f١٨٢١٧e, "onActivityCreated:" + activity);
        LogUtils.file("SudActivityManager", "onActivityCreated:" + activity);
        this.f١٨٢٢١d = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        SudLogger.d(f١٨٢١٧e, "onActivityDestroyed:" + activity);
        LogUtils.file("SudActivityManager", "onActivityDestroyed:" + activity);
        if (this.f١٨٢٢١d == activity) {
            this.f١٨٢٢١d = null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        SudLogger.d(f١٨٢١٧e, "onActivityPaused:" + activity);
        LogUtils.file("SudActivityManager", "onActivityPaused:" + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        SudLogger.d(f١٨٢١٧e, "onActivityResumed:" + activity);
        LogUtils.file("SudActivityManager", "onActivityResumed:" + activity);
        this.f١٨٢٢١d = activity;
        if (this.f١٨٢١٨a != 3) {
            this.f١٨٢١٨a = 3;
            Iterator it = this.f١٨٢١٩b.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        SudLogger.d(f١٨٢١٧e, "onActivitySaveInstanceState:" + activity);
        LogUtils.file("SudActivityManager", "onActivitySaveInstanceState:" + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        SudLogger.d(f١٨٢١٧e, "onActivityStarted:" + activity);
        LogUtils.file("SudActivityManager", "onActivityStarted:" + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        SudLogger.d(f١٨٢١٧e, "onActivityStopped:" + activity);
        LogUtils.file("SudActivityManager", "onActivityStopped:" + activity);
        Activity activity2 = this.f١٨٢٢١d;
        if (activity2 != null && activity2 == activity && this.f١٨٢١٨a != 2) {
            this.f١٨٢١٨a = 2;
            Iterator it = this.f١٨٢١٩b.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
        }
    }
}
