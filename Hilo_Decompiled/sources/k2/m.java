package k2;

import android.os.Handler;
import android.os.Process;
import androidx.core.util.Consumer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class m {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private String f١٥٤٧٣a;

        /* renamed from: b, reason: collision with root package name */
        private int f١٥٤٧٤b;

        /* renamed from: k2.m$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        private static class C٠١٧٨a extends Thread {

            /* renamed from: a, reason: collision with root package name */
            private final int f١٥٤٧٥a;

            C٠١٧٨a(Runnable runnable, String str, int i10) {
                super(runnable, str);
                this.f١٥٤٧٥a = i10;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f١٥٤٧٥a);
                super.run();
            }
        }

        a(String str, int i10) {
            this.f١٥٤٧٣a = str;
            this.f١٥٤٧٤b = i10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C٠١٧٨a(runnable, this.f١٥٤٧٣a, this.f١٥٤٧٤b);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class b implements Executor {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f١٥٤٧٦a;

        b(Handler handler) {
            this.f١٥٤٧٦a = (Handler) androidx.core.util.h.g(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f١٥٤٧٦a.post((Runnable) androidx.core.util.h.g(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f١٥٤٧٦a + " is shutting down");
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Callable f١٥٤٧٧a;

        /* renamed from: b, reason: collision with root package name */
        private Consumer f١٥٤٧٨b;

        /* renamed from: c, reason: collision with root package name */
        private Handler f١٥٤٧٩c;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Consumer f١٥٤٨٠a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Object f١٥٤٨١b;

            a(Consumer consumer, Object obj) {
                this.f١٥٤٨٠a = consumer;
                this.f١٥٤٨١b = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f١٥٤٨٠a.accept(this.f١٥٤٨١b);
            }
        }

        c(Handler handler, Callable callable, Consumer consumer) {
            this.f١٥٤٧٧a = callable;
            this.f١٥٤٧٨b = consumer;
            this.f١٥٤٧٩c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            try {
                obj = this.f١٥٤٧٧a.call();
            } catch (Exception unused) {
                obj = null;
            }
            this.f١٥٤٧٩c.post(new a(this.f١٥٤٧٨b, obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThreadPoolExecutor a(String str, int i10, int i11) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i11, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i10));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor b(Handler handler) {
        return new b(handler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Executor executor, Callable callable, Consumer consumer) {
        executor.execute(new c(k2.b.a(), callable, consumer));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object d(ExecutorService executorService, Callable callable, int i10) {
        try {
            return executorService.submit(callable).get(i10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            throw e10;
        } catch (ExecutionException e11) {
            throw new RuntimeException(e11);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
