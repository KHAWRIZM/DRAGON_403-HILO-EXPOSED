package qd;

import io.reactivex.rxjava3.core.g0;
import io.reactivex.rxjava3.core.k0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public enum d implements sd.e {
    INSTANCE,
    NEVER;

    public static void c(io.reactivex.rxjava3.core.d dVar) {
        dVar.onSubscribe(INSTANCE);
        dVar.onComplete();
    }

    public static void d(g0 g0Var) {
        g0Var.onSubscribe(INSTANCE);
        g0Var.onComplete();
    }

    public static void e(Throwable th, io.reactivex.rxjava3.core.d dVar) {
        dVar.onSubscribe(INSTANCE);
        dVar.onError(th);
    }

    public static void f(Throwable th, g0 g0Var) {
        g0Var.onSubscribe(INSTANCE);
        g0Var.onError(th);
    }

    public static void g(Throwable th, k0 k0Var) {
        k0Var.onSubscribe(INSTANCE);
        k0Var.onError(th);
    }

    @Override // sd.f
    public int a(int i10) {
        return i10 & 2;
    }

    @Override // nd.c
    public boolean isDisposed() {
        if (this == INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // sd.j
    public boolean isEmpty() {
        return true;
    }

    @Override // sd.j
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // sd.j
    public Object poll() {
        return null;
    }

    @Override // sd.j
    public void clear() {
    }

    @Override // nd.c
    public void dispose() {
    }
}
