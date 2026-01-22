package fe;

import io.reactivex.rxjava3.core.g0;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class k {
    public static void a(g0 g0Var, AtomicInteger atomicInteger, c cVar) {
        if (atomicInteger.getAndIncrement() == 0) {
            cVar.f(g0Var);
        }
    }

    public static void b(kf.b bVar, AtomicInteger atomicInteger, c cVar) {
        if (atomicInteger.getAndIncrement() == 0) {
            cVar.g(bVar);
        }
    }

    public static void c(g0 g0Var, Throwable th, AtomicInteger atomicInteger, c cVar) {
        if (cVar.c(th) && atomicInteger.getAndIncrement() == 0) {
            cVar.f(g0Var);
        }
    }

    public static void d(kf.b bVar, Throwable th, AtomicInteger atomicInteger, c cVar) {
        if (cVar.c(th) && atomicInteger.getAndIncrement() == 0) {
            cVar.g(bVar);
        }
    }

    public static void e(g0 g0Var, Object obj, AtomicInteger atomicInteger, c cVar) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            g0Var.onNext(obj);
            if (atomicInteger.decrementAndGet() != 0) {
                cVar.f(g0Var);
            }
        }
    }

    public static boolean f(kf.b bVar, Object obj, AtomicInteger atomicInteger, c cVar) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            bVar.onNext(obj);
            if (atomicInteger.decrementAndGet() == 0) {
                return true;
            }
            cVar.g(bVar);
        }
        return false;
    }
}
