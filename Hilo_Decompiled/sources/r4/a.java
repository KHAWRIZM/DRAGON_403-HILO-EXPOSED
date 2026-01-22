package r4;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class a implements ExecutorService {

    /* renamed from: b, reason: collision with root package name */
    private static final long f١٧٣٤٠b = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: c, reason: collision with root package name */
    private static volatile int f١٧٣٤١c;

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f١٧٣٤٢a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f١٧٣٤٣a;

        /* renamed from: b, reason: collision with root package name */
        private int f١٧٣٤٤b;

        /* renamed from: c, reason: collision with root package name */
        private int f١٧٣٤٥c;

        /* renamed from: d, reason: collision with root package name */
        private ThreadFactory f١٧٣٤٦d = new c();

        /* renamed from: e, reason: collision with root package name */
        private e f١٧٣٤٧e = e.f١٧٣٦١d;

        /* renamed from: f, reason: collision with root package name */
        private String f١٧٣٤٨f;

        /* renamed from: g, reason: collision with root package name */
        private long f١٧٣٤٩g;

        b(boolean z10) {
            this.f١٧٣٤٣a = z10;
        }

        public a a() {
            if (!TextUtils.isEmpty(this.f١٧٣٤٨f)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f١٧٣٤٤b, this.f١٧٣٤٥c, this.f١٧٣٤٩g, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new d(this.f١٧٣٤٦d, this.f١٧٣٤٨f, this.f١٧٣٤٧e, this.f١٧٣٤٣a));
                if (this.f١٧٣٤٩g != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new a(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f١٧٣٤٨f);
        }

        public b b(String str) {
            this.f١٧٣٤٨f = str;
            return this;
        }

        public b c(int i10) {
            this.f١٧٣٤٤b = i10;
            this.f١٧٣٤٥c = i10;
            return this;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class c implements ThreadFactory {

        /* renamed from: r4.a$c$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class C٠٢١٦a extends Thread {
            C٠٢١٦a(Runnable runnable) {
                super(runnable);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                super.run();
            }
        }

        private c() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C٠٢١٦a(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class d implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final ThreadFactory f١٧٣٥١a;

        /* renamed from: b, reason: collision with root package name */
        private final String f١٧٣٥٢b;

        /* renamed from: c, reason: collision with root package name */
        final e f١٧٣٥٣c;

        /* renamed from: d, reason: collision with root package name */
        final boolean f١٧٣٥٤d;

        /* renamed from: e, reason: collision with root package name */
        private final AtomicInteger f١٧٣٥٥e = new AtomicInteger();

        /* renamed from: r4.a$d$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class RunnableC٠٢١٧a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Runnable f١٧٣٥٦a;

            RunnableC٠٢١٧a(Runnable runnable) {
                this.f١٧٣٥٦a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f١٧٣٥٤d) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    this.f١٧٣٥٦a.run();
                } catch (Throwable th) {
                    d.this.f١٧٣٥٣c.a(th);
                }
            }
        }

        d(ThreadFactory threadFactory, String str, e eVar, boolean z10) {
            this.f١٧٣٥١a = threadFactory;
            this.f١٧٣٥٢b = str;
            this.f١٧٣٥٣c = eVar;
            this.f١٧٣٥٤d = z10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = this.f١٧٣٥١a.newThread(new RunnableC٠٢١٧a(runnable));
            newThread.setName("glide-" + this.f١٧٣٥٢b + "-thread-" + this.f١٧٣٥٥e.getAndIncrement());
            return newThread;
        }
    }

    a(ExecutorService executorService) {
        this.f١٧٣٤٢a = executorService;
    }

    static int b() {
        if (d() >= 4) {
            return 2;
        }
        return 1;
    }

    public static int d() {
        if (f١٧٣٤١c == 0) {
            f١٧٣٤١c = Math.min(4, r4.b.a());
        }
        return f١٧٣٤١c;
    }

    public static b e() {
        return new b(true).c(b()).b("animation");
    }

    public static a f() {
        return e().a();
    }

    public static b g() {
        return new b(true).c(1).b("disk-cache");
    }

    public static a h() {
        return g().a();
    }

    public static b i() {
        return new b(false).c(d()).b("source");
    }

    public static a j() {
        return i().a();
    }

    public static a k() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f١٧٣٤٠b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new d(new c(), "source-unlimited", e.f١٧٣٦١d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j10, TimeUnit timeUnit) {
        return this.f١٧٣٤٢a.awaitTermination(j10, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f١٧٣٤٢a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection) {
        return this.f١٧٣٤٢a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection) {
        return this.f١٧٣٤٢a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f١٧٣٤٢a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f١٧٣٤٢a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f١٧٣٤٢a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List shutdownNow() {
        return this.f١٧٣٤٢a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable) {
        return this.f١٧٣٤٢a.submit(runnable);
    }

    public String toString() {
        return this.f١٧٣٤٢a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection, long j10, TimeUnit timeUnit) {
        return this.f١٧٣٤٢a.invokeAll(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection, long j10, TimeUnit timeUnit) {
        return this.f١٧٣٤٢a.invokeAny(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable, Object obj) {
        return this.f١٧٣٤٢a.submit(runnable, obj);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Callable callable) {
        return this.f١٧٣٤٢a.submit(callable);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface e {

        /* renamed from: a, reason: collision with root package name */
        public static final e f١٧٣٥٨a = new C٠٢١٨a();

        /* renamed from: b, reason: collision with root package name */
        public static final e f١٧٣٥٩b;

        /* renamed from: c, reason: collision with root package name */
        public static final e f١٧٣٦٠c;

        /* renamed from: d, reason: collision with root package name */
        public static final e f١٧٣٦١d;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class b implements e {
            b() {
            }

            @Override // r4.a.e
            public void a(Throwable th) {
                if (th != null && Log.isLoggable("GlideExecutor", 6)) {
                    Log.e("GlideExecutor", "Request threw uncaught throwable", th);
                }
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class c implements e {
            c() {
            }

            @Override // r4.a.e
            public void a(Throwable th) {
                if (th == null) {
                } else {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        }

        static {
            b bVar = new b();
            f١٧٣٥٩b = bVar;
            f١٧٣٦٠c = new c();
            f١٧٣٦١d = bVar;
        }

        void a(Throwable th);

        /* renamed from: r4.a$e$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class C٠٢١٨a implements e {
            C٠٢١٨a() {
            }

            @Override // r4.a.e
            public void a(Throwable th) {
            }
        }
    }
}
