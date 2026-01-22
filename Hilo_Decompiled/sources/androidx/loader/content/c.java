package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class c {

    /* renamed from: f, reason: collision with root package name */
    private static final ThreadFactory f٣٨٤٥f;

    /* renamed from: g, reason: collision with root package name */
    private static final BlockingQueue f٣٨٤٦g;

    /* renamed from: h, reason: collision with root package name */
    public static final Executor f٣٨٤٧h;

    /* renamed from: i, reason: collision with root package name */
    private static f f٣٨٤٨i;

    /* renamed from: j, reason: collision with root package name */
    private static volatile Executor f٣٨٤٩j;

    /* renamed from: a, reason: collision with root package name */
    private final h f٣٨٥٠a;

    /* renamed from: b, reason: collision with root package name */
    private final FutureTask f٣٨٥١b;

    /* renamed from: c, reason: collision with root package name */
    private volatile g f٣٨٥٢c = g.PENDING;

    /* renamed from: d, reason: collision with root package name */
    final AtomicBoolean f٣٨٥٣d = new AtomicBoolean();

    /* renamed from: e, reason: collision with root package name */
    final AtomicBoolean f٣٨٥٤e = new AtomicBoolean();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f٣٨٥٥a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f٣٨٥٥a.getAndIncrement());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b extends h {
        b() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            c.this.f٣٨٥٤e.set(true);
            Object obj = null;
            try {
                Process.setThreadPriority(10);
                obj = c.this.b(this.f٣٨٦٥a);
                Binder.flushPendingCommands();
                return obj;
            } finally {
            }
        }
    }

    /* renamed from: androidx.loader.content.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class C٠٠٤٧c extends FutureTask {
        C٠٠٤٧c(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                c.this.l(get());
            } catch (InterruptedException e10) {
                Log.w("AsyncTask", e10);
            } catch (CancellationException unused) {
                c.this.l(null);
            } catch (ExecutionException e11) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e11.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f٣٨٥٨a;

        static {
            int[] iArr = new int[g.values().length];
            f٣٨٥٨a = iArr;
            try {
                iArr[g.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f٣٨٥٨a[g.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        final c f٣٨٥٩a;

        /* renamed from: b, reason: collision with root package name */
        final Object[] f٣٨٦٠b;

        e(c cVar, Object... objArr) {
            this.f٣٨٥٩a = cVar;
            this.f٣٨٦٠b = objArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class f extends Handler {
        f() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar = (e) message.obj;
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 == 2) {
                    eVar.f٣٨٥٩a.j(eVar.f٣٨٦٠b);
                    return;
                }
                return;
            }
            eVar.f٣٨٥٩a.d(eVar.f٣٨٦٠b[0]);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum g {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static abstract class h implements Callable {

        /* renamed from: a, reason: collision with root package name */
        Object[] f٣٨٦٥a;

        h() {
        }
    }

    static {
        a aVar = new a();
        f٣٨٤٥f = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        f٣٨٤٦g = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        f٣٨٤٧h = threadPoolExecutor;
        f٣٨٤٩j = threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c() {
        b bVar = new b();
        this.f٣٨٥٠a = bVar;
        this.f٣٨٥١b = new C٠٠٤٧c(bVar);
    }

    private static Handler e() {
        f fVar;
        synchronized (c.class) {
            try {
                if (f٣٨٤٨i == null) {
                    f٣٨٤٨i = new f();
                }
                fVar = f٣٨٤٨i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    public final boolean a(boolean z10) {
        this.f٣٨٥٣d.set(true);
        return this.f٣٨٥١b.cancel(z10);
    }

    protected abstract Object b(Object... objArr);

    public final c c(Executor executor, Object... objArr) {
        if (this.f٣٨٥٢c != g.PENDING) {
            int i10 = d.f٣٨٥٨a[this.f٣٨٥٢c.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("We should never reach this state");
                }
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        this.f٣٨٥٢c = g.RUNNING;
        i();
        this.f٣٨٥٠a.f٣٨٦٥a = objArr;
        executor.execute(this.f٣٨٥١b);
        return this;
    }

    void d(Object obj) {
        if (f()) {
            g(obj);
        } else {
            h(obj);
        }
        this.f٣٨٥٢c = g.FINISHED;
    }

    public final boolean f() {
        return this.f٣٨٥٣d.get();
    }

    protected abstract void g(Object obj);

    protected abstract void h(Object obj);

    protected void i() {
    }

    protected void j(Object... objArr) {
    }

    Object k(Object obj) {
        e().obtainMessage(1, new e(this, obj)).sendToTarget();
        return obj;
    }

    void l(Object obj) {
        if (!this.f٣٨٥٤e.get()) {
            k(obj);
        }
    }
}
