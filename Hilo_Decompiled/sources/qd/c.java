package qd;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public enum c implements nd.c {
    DISPOSED;

    public static boolean a(AtomicReference atomicReference) {
        nd.c cVar;
        nd.c cVar2 = (nd.c) atomicReference.get();
        c cVar3 = DISPOSED;
        if (cVar2 != cVar3 && (cVar = (nd.c) atomicReference.getAndSet(cVar3)) != cVar3) {
            if (cVar != null) {
                cVar.dispose();
                return true;
            }
            return true;
        }
        return false;
    }

    public static boolean c(nd.c cVar) {
        if (cVar == DISPOSED) {
            return true;
        }
        return false;
    }

    public static boolean d(AtomicReference atomicReference, nd.c cVar) {
        nd.c cVar2;
        do {
            cVar2 = (nd.c) atomicReference.get();
            if (cVar2 == DISPOSED) {
                if (cVar != null) {
                    cVar.dispose();
                    return false;
                }
                return false;
            }
        } while (!androidx.lifecycle.a.a(atomicReference, cVar2, cVar));
        return true;
    }

    public static void e() {
        ie.a.s(new od.e("Disposable already set!"));
    }

    public static boolean f(AtomicReference atomicReference, nd.c cVar) {
        nd.c cVar2;
        do {
            cVar2 = (nd.c) atomicReference.get();
            if (cVar2 == DISPOSED) {
                if (cVar != null) {
                    cVar.dispose();
                    return false;
                }
                return false;
            }
        } while (!androidx.lifecycle.a.a(atomicReference, cVar2, cVar));
        if (cVar2 != null) {
            cVar2.dispose();
            return true;
        }
        return true;
    }

    public static boolean g(AtomicReference atomicReference, nd.c cVar) {
        Objects.requireNonNull(cVar, "d is null");
        if (!androidx.lifecycle.a.a(atomicReference, null, cVar)) {
            cVar.dispose();
            if (atomicReference.get() != DISPOSED) {
                e();
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean h(AtomicReference atomicReference, nd.c cVar) {
        if (!androidx.lifecycle.a.a(atomicReference, null, cVar)) {
            if (atomicReference.get() == DISPOSED) {
                cVar.dispose();
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean i(nd.c cVar, nd.c cVar2) {
        if (cVar2 == null) {
            ie.a.s(new NullPointerException("next is null"));
            return false;
        }
        if (cVar != null) {
            cVar2.dispose();
            e();
            return false;
        }
        return true;
    }

    @Override // nd.c
    public boolean isDisposed() {
        return true;
    }

    @Override // nd.c
    public void dispose() {
    }
}
