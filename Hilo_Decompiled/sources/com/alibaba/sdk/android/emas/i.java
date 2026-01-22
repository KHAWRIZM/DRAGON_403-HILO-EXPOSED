package com.alibaba.sdk.android.emas;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class i implements Application.ActivityLifecycleCallbacks {

    /* renamed from: c, reason: collision with root package name */
    private List<a> f٦٤١٥c;

    /* renamed from: e, reason: collision with root package name */
    private int f٦٤١٦e = 0;

    /* renamed from: c, reason: collision with other field name */
    private boolean f١٤c = false;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface a {
        void c();

        void d();
    }

    public void a(a aVar) {
        if (this.f٦٤١٥c == null) {
            this.f٦٤١٥c = new ArrayList();
        }
        this.f٦٤١٥c.add(aVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.f٦٤١٦e++;
        if (!this.f١٤c) {
            this.f١٤c = true;
            List<a> list = this.f٦٤١٥c;
            if (list != null) {
                Iterator<a> it = list.iterator();
                while (it.hasNext()) {
                    it.next().c();
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i10 = this.f٦٤١٦e - 1;
        this.f٦٤١٦e = i10;
        if (i10 == 0) {
            this.f١٤c = false;
            List<a> list = this.f٦٤١٥c;
            if (list != null) {
                Iterator<a> it = list.iterator();
                while (it.hasNext()) {
                    it.next().d();
                }
            }
        }
    }
}
