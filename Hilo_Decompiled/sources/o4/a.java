package o4;

import android.os.Process;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import o4.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f١٦٥٣٨a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f١٦٥٣٩b;

    /* renamed from: c, reason: collision with root package name */
    final Map f١٦٥٤٠c;

    /* renamed from: d, reason: collision with root package name */
    private final ReferenceQueue f١٦٥٤١d;

    /* renamed from: e, reason: collision with root package name */
    private p.a f١٦٥٤٢e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f١٦٥٤٣f;

    /* renamed from: o4.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class ThreadFactoryC٠١٩٩a implements ThreadFactory {

        /* renamed from: o4.a$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class RunnableC٠٢٠٠a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Runnable f١٦٥٤٤a;

            RunnableC٠٢٠٠a(Runnable runnable) {
                this.f١٦٥٤٤a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.f١٦٥٤٤a.run();
            }
        }

        ThreadFactoryC٠١٩٩a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(new RunnableC٠٢٠٠a(runnable), "glide-active-resources");
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class c extends WeakReference {

        /* renamed from: a, reason: collision with root package name */
        final m4.f f١٦٥٤٧a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f١٦٥٤٨b;

        /* renamed from: c, reason: collision with root package name */
        v f١٦٥٤٩c;

        c(m4.f fVar, p pVar, ReferenceQueue referenceQueue, boolean z10) {
            super(pVar, referenceQueue);
            v vVar;
            this.f١٦٥٤٧a = (m4.f) f5.k.d(fVar);
            if (pVar.c() && z10) {
                vVar = (v) f5.k.d(pVar.b());
            } else {
                vVar = null;
            }
            this.f١٦٥٤٩c = vVar;
            this.f١٦٥٤٨b = pVar.c();
        }

        void a() {
            this.f١٦٥٤٩c = null;
            clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(boolean z10) {
        this(z10, Executors.newSingleThreadExecutor(new ThreadFactoryC٠١٩٩a()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(m4.f fVar, p pVar) {
        c cVar = (c) this.f١٦٥٤٠c.put(fVar, new c(fVar, pVar, this.f١٦٥٤١d, this.f١٦٥٣٨a));
        if (cVar != null) {
            cVar.a();
        }
    }

    void b() {
        while (!this.f١٦٥٤٣f) {
            try {
                c((c) this.f١٦٥٤١d.remove());
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    void c(c cVar) {
        v vVar;
        synchronized (this) {
            this.f١٦٥٤٠c.remove(cVar.f١٦٥٤٧a);
            if (cVar.f١٦٥٤٨b && (vVar = cVar.f١٦٥٤٩c) != null) {
                this.f١٦٥٤٢e.c(cVar.f١٦٥٤٧a, new p(vVar, true, false, cVar.f١٦٥٤٧a, this.f١٦٥٤٢e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d(m4.f fVar) {
        c cVar = (c) this.f١٦٥٤٠c.remove(fVar);
        if (cVar != null) {
            cVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public synchronized p e(m4.f fVar) {
        c cVar = (c) this.f١٦٥٤٠c.get(fVar);
        if (cVar == null) {
            return null;
        }
        p pVar = (p) cVar.get();
        if (pVar == null) {
            c(cVar);
        }
        return pVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(p.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f١٦٥٤٢e = aVar;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.f١٦٥٤٣f = true;
        Executor executor = this.f١٦٥٣٩b;
        if (executor instanceof ExecutorService) {
            f5.e.c((ExecutorService) executor);
        }
    }

    a(boolean z10, Executor executor) {
        this.f١٦٥٤٠c = new HashMap();
        this.f١٦٥٤١d = new ReferenceQueue();
        this.f١٦٥٣٨a = z10;
        this.f١٦٥٣٩b = executor;
        executor.execute(new b());
    }
}
