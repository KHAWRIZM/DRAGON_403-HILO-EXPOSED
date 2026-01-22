package ce;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class c implements Callable, nd.c {

    /* renamed from: f, reason: collision with root package name */
    static final FutureTask f٦٠٣٩f = new FutureTask(rd.a.f١٧٥٠١b, null);

    /* renamed from: a, reason: collision with root package name */
    final Runnable f٦٠٤٠a;

    /* renamed from: d, reason: collision with root package name */
    final ExecutorService f٦٠٤٣d;

    /* renamed from: e, reason: collision with root package name */
    Thread f٦٠٤٤e;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference f٦٠٤٢c = new AtomicReference();

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference f٦٠٤١b = new AtomicReference();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.f٦٠٤٠a = runnable;
        this.f٦٠٤٣d = executorService;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        this.f٦٠٤٤e = Thread.currentThread();
        try {
            this.f٦٠٤٠a.run();
            this.f٦٠٤٤e = null;
            c(this.f٦٠٤٣d.submit(this));
            return null;
        } catch (Throwable th) {
            this.f٦٠٤٤e = null;
            ie.a.s(th);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Future future) {
        Future future2;
        boolean z10;
        do {
            future2 = (Future) this.f٦٠٤٢c.get();
            if (future2 == f٦٠٣٩f) {
                if (this.f٦٠٤٤e != Thread.currentThread()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                future.cancel(z10);
                return;
            }
        } while (!androidx.lifecycle.a.a(this.f٦٠٤٢c, future2, future));
    }

    void c(Future future) {
        Future future2;
        boolean z10;
        do {
            future2 = (Future) this.f٦٠٤١b.get();
            if (future2 == f٦٠٣٩f) {
                if (this.f٦٠٤٤e != Thread.currentThread()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                future.cancel(z10);
                return;
            }
        } while (!androidx.lifecycle.a.a(this.f٦٠٤١b, future2, future));
    }

    @Override // nd.c
    public void dispose() {
        boolean z10;
        AtomicReference atomicReference = this.f٦٠٤٢c;
        FutureTask futureTask = f٦٠٣٩f;
        Future future = (Future) atomicReference.getAndSet(futureTask);
        boolean z11 = false;
        if (future != null && future != futureTask) {
            if (this.f٦٠٤٤e != Thread.currentThread()) {
                z10 = true;
            } else {
                z10 = false;
            }
            future.cancel(z10);
        }
        Future future2 = (Future) this.f٦٠٤١b.getAndSet(futureTask);
        if (future2 != null && future2 != futureTask) {
            if (this.f٦٠٤٤e != Thread.currentThread()) {
                z11 = true;
            }
            future2.cancel(z11);
        }
    }

    @Override // nd.c
    public boolean isDisposed() {
        if (this.f٦٠٤٢c.get() == f٦٠٣٩f) {
            return true;
        }
        return false;
    }
}
