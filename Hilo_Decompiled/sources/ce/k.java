package ce;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class k extends AtomicReferenceArray implements Runnable, Callable, nd.c {

    /* renamed from: b, reason: collision with root package name */
    static final Object f٦٠٧١b = new Object();

    /* renamed from: c, reason: collision with root package name */
    static final Object f٦٠٧٢c = new Object();

    /* renamed from: d, reason: collision with root package name */
    static final Object f٦٠٧٣d = new Object();

    /* renamed from: e, reason: collision with root package name */
    static final Object f٦٠٧٤e = new Object();
    private static final long serialVersionUID = -6120223772001106981L;

    /* renamed from: a, reason: collision with root package name */
    final Runnable f٦٠٧٥a;

    public k(Runnable runnable, nd.d dVar) {
        super(3);
        this.f٦٠٧٥a = runnable;
        lazySet(0, dVar);
    }

    public void a(Future future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == f٦٠٧٤e) {
                return;
            }
            if (obj == f٦٠٧٢c) {
                future.cancel(false);
                return;
            } else if (obj == f٦٠٧٣d) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // nd.c
    public void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        boolean z10;
        while (true) {
            Object obj5 = get(1);
            if (obj5 == f٦٠٧٤e || obj5 == (obj3 = f٦٠٧٢c) || obj5 == (obj4 = f٦٠٧٣d)) {
                break;
            }
            if (get(2) != Thread.currentThread()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                obj3 = obj4;
            }
            if (compareAndSet(1, obj5, obj3)) {
                if (obj5 != null) {
                    ((Future) obj5).cancel(z10);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == f٦٠٧٤e || obj == (obj2 = f٦٠٧١b) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((nd.d) obj).c(this);
    }

    @Override // nd.c
    public boolean isDisposed() {
        Object obj = get(0);
        if (obj != f٦٠٧١b && obj != f٦٠٧٤e) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        lazySet(2, Thread.currentThread());
        try {
            this.f٦٠٧٥a.run();
            lazySet(2, null);
            Object obj3 = get(0);
            if (obj3 != f٦٠٧١b && compareAndSet(0, obj3, f٦٠٧٤e) && obj3 != null) {
                ((nd.d) obj3).c(this);
            }
            do {
                obj2 = get(1);
                if (obj2 == f٦٠٧٢c || obj2 == f٦٠٧٣d) {
                    return;
                }
            } while (!compareAndSet(1, obj2, f٦٠٧٤e));
        } catch (Throwable th) {
            try {
                ie.a.s(th);
                throw th;
            } catch (Throwable th2) {
                lazySet(2, null);
                Object obj4 = get(0);
                if (obj4 != f٦٠٧١b && compareAndSet(0, obj4, f٦٠٧٤e) && obj4 != null) {
                    ((nd.d) obj4).c(this);
                }
                do {
                    obj = get(1);
                    if (obj == f٦٠٧٢c || obj == f٦٠٧٣d) {
                        break;
                    }
                } while (!compareAndSet(1, obj, f٦٠٧٤e));
                throw th2;
            }
        }
    }
}
