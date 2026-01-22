package ee;

import fe.d;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import od.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public enum c implements kf.c {
    CANCELLED;

    public static boolean a(AtomicReference atomicReference) {
        kf.c cVar;
        kf.c cVar2 = (kf.c) atomicReference.get();
        c cVar3 = CANCELLED;
        if (cVar2 != cVar3 && (cVar = (kf.c) atomicReference.getAndSet(cVar3)) != cVar3) {
            if (cVar != null) {
                cVar.cancel();
                return true;
            }
            return true;
        }
        return false;
    }

    public static void c(AtomicReference atomicReference, AtomicLong atomicLong, long j10) {
        kf.c cVar = (kf.c) atomicReference.get();
        if (cVar != null) {
            cVar.request(j10);
            return;
        }
        if (g(j10)) {
            d.a(atomicLong, j10);
            kf.c cVar2 = (kf.c) atomicReference.get();
            if (cVar2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    cVar2.request(andSet);
                }
            }
        }
    }

    public static boolean d(AtomicReference atomicReference, AtomicLong atomicLong, kf.c cVar) {
        if (f(atomicReference, cVar)) {
            long andSet = atomicLong.getAndSet(0L);
            if (andSet != 0) {
                cVar.request(andSet);
                return true;
            }
            return true;
        }
        return false;
    }

    public static void e() {
        ie.a.s(new e("Subscription already set!"));
    }

    public static boolean f(AtomicReference atomicReference, kf.c cVar) {
        Objects.requireNonNull(cVar, "s is null");
        if (!androidx.lifecycle.a.a(atomicReference, null, cVar)) {
            cVar.cancel();
            if (atomicReference.get() != CANCELLED) {
                e();
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean g(long j10) {
        if (j10 <= 0) {
            ie.a.s(new IllegalArgumentException("n > 0 required but it was " + j10));
            return false;
        }
        return true;
    }

    public static boolean h(kf.c cVar, kf.c cVar2) {
        if (cVar2 == null) {
            ie.a.s(new NullPointerException("next is null"));
            return false;
        }
        if (cVar != null) {
            cVar2.cancel();
            e();
            return false;
        }
        return true;
    }

    public void cancel() {
    }

    public void request(long j10) {
    }
}
