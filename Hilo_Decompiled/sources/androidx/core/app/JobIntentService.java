package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import com.facebook.AuthenticationTokenClaims;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class JobIntentService extends Service {

    /* renamed from: h, reason: collision with root package name */
    static final Object f٢٥٨٥h = new Object();

    /* renamed from: i, reason: collision with root package name */
    static final HashMap f٢٥٨٦i = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    b f٢٥٨٧a;

    /* renamed from: b, reason: collision with root package name */
    h f٢٥٨٨b;

    /* renamed from: c, reason: collision with root package name */
    a f٢٥٨٩c;

    /* renamed from: d, reason: collision with root package name */
    boolean f٢٥٩٠d = false;

    /* renamed from: e, reason: collision with root package name */
    boolean f٢٥٩١e = false;

    /* renamed from: f, reason: collision with root package name */
    boolean f٢٥٩٢f = false;

    /* renamed from: g, reason: collision with root package name */
    final ArrayList f٢٥٩٣g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public final class a extends AsyncTask {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                e a10 = JobIntentService.this.a();
                if (a10 != null) {
                    JobIntentService.this.e(a10.getIntent());
                    a10.complete();
                } else {
                    return null;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Void r12) {
            JobIntentService.this.g();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
            JobIntentService.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface b {
        IBinder a();

        e b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class c extends h {

        /* renamed from: d, reason: collision with root package name */
        private final Context f٢٥٩٥d;

        /* renamed from: e, reason: collision with root package name */
        private final PowerManager.WakeLock f٢٥٩٦e;

        /* renamed from: f, reason: collision with root package name */
        private final PowerManager.WakeLock f٢٥٩٧f;

        /* renamed from: g, reason: collision with root package name */
        boolean f٢٥٩٨g;

        /* renamed from: h, reason: collision with root package name */
        boolean f٢٥٩٩h;

        c(Context context, ComponentName componentName) {
            super(componentName);
            this.f٢٥٩٥d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f٢٥٩٦e = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f٢٥٩٧f = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.h
        public void b() {
            synchronized (this) {
                try {
                    if (this.f٢٥٩٩h) {
                        if (this.f٢٥٩٨g) {
                            this.f٢٥٩٦e.acquire(60000L);
                        }
                        this.f٢٥٩٩h = false;
                        this.f٢٥٩٧f.release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void c() {
            synchronized (this) {
                try {
                    if (!this.f٢٥٩٩h) {
                        this.f٢٥٩٩h = true;
                        this.f٢٥٩٧f.acquire(AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED);
                        this.f٢٥٩٦e.release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void d() {
            synchronized (this) {
                this.f٢٥٩٨g = false;
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    final class d implements e {

        /* renamed from: a, reason: collision with root package name */
        final Intent f٢٦٠٠a;

        /* renamed from: b, reason: collision with root package name */
        final int f٢٦٠١b;

        d(Intent intent, int i10) {
            this.f٢٦٠٠a = intent;
            this.f٢٦٠١b = i10;
        }

        @Override // androidx.core.app.JobIntentService.e
        public void complete() {
            JobIntentService.this.stopSelf(this.f٢٦٠١b);
        }

        @Override // androidx.core.app.JobIntentService.e
        public Intent getIntent() {
            return this.f٢٦٠٠a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface e {
        void complete();

        Intent getIntent();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static final class f extends JobServiceEngine implements b {

        /* renamed from: a, reason: collision with root package name */
        final JobIntentService f٢٦٠٣a;

        /* renamed from: b, reason: collision with root package name */
        final Object f٢٦٠٤b;

        /* renamed from: c, reason: collision with root package name */
        JobParameters f٢٦٠٥c;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        final class a implements e {

            /* renamed from: a, reason: collision with root package name */
            final JobWorkItem f٢٦٠٦a;

            a(JobWorkItem jobWorkItem) {
                this.f٢٦٠٦a = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.e
            public void complete() {
                synchronized (f.this.f٢٦٠٤b) {
                    try {
                        JobParameters jobParameters = f.this.f٢٦٠٥c;
                        if (jobParameters != null) {
                            jobParameters.completeWork(this.f٢٦٠٦a);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.e
            public Intent getIntent() {
                Intent intent;
                intent = this.f٢٦٠٦a.getIntent();
                return intent;
            }
        }

        f(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f٢٦٠٤b = new Object();
            this.f٢٦٠٣a = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.b
        public IBinder a() {
            IBinder binder;
            binder = getBinder();
            return binder;
        }

        @Override // androidx.core.app.JobIntentService.b
        public e b() {
            JobWorkItem dequeueWork;
            Intent intent;
            synchronized (this.f٢٦٠٤b) {
                try {
                    JobParameters jobParameters = this.f٢٦٠٥c;
                    if (jobParameters != null) {
                        dequeueWork = jobParameters.dequeueWork();
                        if (dequeueWork != null) {
                            intent = dequeueWork.getIntent();
                            intent.setExtrasClassLoader(this.f٢٦٠٣a.getClassLoader());
                            return new a(dequeueWork);
                        }
                        return null;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public boolean onStartJob(JobParameters jobParameters) {
            this.f٢٦٠٥c = jobParameters;
            this.f٢٦٠٣a.c(false);
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            boolean b10 = this.f٢٦٠٣a.b();
            synchronized (this.f٢٦٠٤b) {
                this.f٢٦٠٥c = null;
            }
            return b10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class g extends h {

        /* renamed from: d, reason: collision with root package name */
        private final JobInfo f٢٦٠٨d;

        /* renamed from: e, reason: collision with root package name */
        private final JobScheduler f٢٦٠٩e;

        g(Context context, ComponentName componentName, int i10) {
            super(componentName);
            a(i10);
            this.f٢٦٠٨d = new JobInfo.Builder(i10, this.f٢٦١٠a).setOverrideDeadline(0L).build();
            this.f٢٦٠٩e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class h {

        /* renamed from: a, reason: collision with root package name */
        final ComponentName f٢٦١٠a;

        /* renamed from: b, reason: collision with root package name */
        boolean f٢٦١١b;

        /* renamed from: c, reason: collision with root package name */
        int f٢٦١٢c;

        h(ComponentName componentName) {
            this.f٢٦١٠a = componentName;
        }

        void a(int i10) {
            if (!this.f٢٦١١b) {
                this.f٢٦١١b = true;
                this.f٢٦١٢c = i10;
            } else {
                if (this.f٢٦١٢c == i10) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i10 + " is different than previous " + this.f٢٦١٢c);
            }
        }

        public void b() {
        }

        public void c() {
        }

        public void d() {
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f٢٥٩٣g = null;
        } else {
            this.f٢٥٩٣g = new ArrayList();
        }
    }

    static h d(Context context, ComponentName componentName, boolean z10, int i10) {
        h cVar;
        HashMap hashMap = f٢٥٨٦i;
        h hVar = (h) hashMap.get(componentName);
        if (hVar == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                if (z10) {
                    cVar = new g(context, componentName, i10);
                } else {
                    throw new IllegalArgumentException("Can't be here without a job id");
                }
            } else {
                cVar = new c(context, componentName);
            }
            hVar = cVar;
            hashMap.put(componentName, hVar);
        }
        return hVar;
    }

    e a() {
        b bVar = this.f٢٥٨٧a;
        if (bVar != null) {
            return bVar.b();
        }
        synchronized (this.f٢٥٩٣g) {
            try {
                if (this.f٢٥٩٣g.size() > 0) {
                    return (e) this.f٢٥٩٣g.remove(0);
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    boolean b() {
        a aVar = this.f٢٥٨٩c;
        if (aVar != null) {
            aVar.cancel(this.f٢٥٩٠d);
        }
        this.f٢٥٩١e = true;
        return f();
    }

    void c(boolean z10) {
        if (this.f٢٥٨٩c == null) {
            this.f٢٥٨٩c = new a();
            h hVar = this.f٢٥٨٨b;
            if (hVar != null && z10) {
                hVar.c();
            }
            this.f٢٥٨٩c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    protected abstract void e(Intent intent);

    public boolean f() {
        return true;
    }

    void g() {
        ArrayList arrayList = this.f٢٥٩٣g;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.f٢٥٨٩c = null;
                    ArrayList arrayList2 = this.f٢٥٩٣g;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        c(false);
                    } else if (!this.f٢٥٩٢f) {
                        this.f٢٥٨٨b.b();
                    }
                } finally {
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        b bVar = this.f٢٥٨٧a;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f٢٥٨٧a = new f(this);
            this.f٢٥٨٨b = null;
        } else {
            this.f٢٥٨٧a = null;
            this.f٢٥٨٨b = d(this, new ComponentName(this, getClass()), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList arrayList = this.f٢٥٩٣g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f٢٥٩٢f = true;
                this.f٢٥٨٨b.b();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (this.f٢٥٩٣g != null) {
            this.f٢٥٨٨b.d();
            synchronized (this.f٢٥٩٣g) {
                ArrayList arrayList = this.f٢٥٩٣g;
                if (intent == null) {
                    intent = new Intent();
                }
                arrayList.add(new d(intent, i11));
                c(true);
            }
            return 3;
        }
        return 2;
    }
}
