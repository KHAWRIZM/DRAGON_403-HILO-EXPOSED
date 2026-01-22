package ce;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class a extends AtomicReference implements nd.c {

    /* renamed from: c, reason: collision with root package name */
    protected static final FutureTask f٦٠٢١c;

    /* renamed from: d, reason: collision with root package name */
    protected static final FutureTask f٦٠٢٢d;
    private static final long serialVersionUID = 1811839108042568751L;

    /* renamed from: a, reason: collision with root package name */
    protected final Runnable f٦٠٢٣a;

    /* renamed from: b, reason: collision with root package name */
    protected Thread f٦٠٢٤b;

    static {
        Runnable runnable = rd.a.f١٧٥٠١b;
        f٦٠٢١c = new FutureTask(runnable, null);
        f٦٠٢٢d = new FutureTask(runnable, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Runnable runnable) {
        this.f٦٠٢٣a = runnable;
    }

    public final void a(Future future) {
        Future future2;
        boolean z10;
        do {
            future2 = (Future) get();
            if (future2 != f٦٠٢١c) {
                if (future2 == f٦٠٢٢d) {
                    if (this.f٦٠٢٤b != Thread.currentThread()) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    future.cancel(z10);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    @Override // nd.c
    public final void dispose() {
        FutureTask futureTask;
        boolean z10;
        Future future = (Future) get();
        if (future != f٦٠٢١c && future != (futureTask = f٦٠٢٢d) && compareAndSet(future, futureTask) && future != null) {
            if (this.f٦٠٢٤b != Thread.currentThread()) {
                z10 = true;
            } else {
                z10 = false;
            }
            future.cancel(z10);
        }
    }

    @Override // nd.c
    public final boolean isDisposed() {
        Future future = (Future) get();
        if (future != f٦٠٢١c && future != f٦٠٢٢d) {
            return false;
        }
        return true;
    }
}
