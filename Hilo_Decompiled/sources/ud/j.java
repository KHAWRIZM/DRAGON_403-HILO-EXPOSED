package ud;

import io.reactivex.rxjava3.core.g0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class j extends b {
    private static final long serialVersionUID = -5502432239815349361L;

    /* renamed from: a, reason: collision with root package name */
    protected final g0 f١٨٢٩٩a;

    /* renamed from: b, reason: collision with root package name */
    protected Object f١٨٣٠٠b;

    public j(g0 g0Var) {
        this.f١٨٢٩٩a = g0Var;
    }

    @Override // sd.f
    public final int a(int i10) {
        if ((i10 & 2) != 0) {
            lazySet(8);
            return 2;
        }
        return 0;
    }

    public final void b() {
        if ((get() & 54) != 0) {
            return;
        }
        lazySet(2);
        this.f١٨٢٩٩a.onComplete();
    }

    public final void c(Object obj) {
        int i10 = get();
        if ((i10 & 54) != 0) {
            return;
        }
        g0 g0Var = this.f١٨٢٩٩a;
        if (i10 == 8) {
            this.f١٨٣٠٠b = obj;
            lazySet(16);
            g0Var.onNext(null);
        } else {
            lazySet(2);
            g0Var.onNext(obj);
        }
        if (get() != 4) {
            g0Var.onComplete();
        }
    }

    @Override // sd.j
    public final void clear() {
        lazySet(32);
        this.f١٨٣٠٠b = null;
    }

    public final void d(Throwable th) {
        if ((get() & 54) != 0) {
            ie.a.s(th);
        } else {
            lazySet(2);
            this.f١٨٢٩٩a.onError(th);
        }
    }

    public void dispose() {
        set(4);
        this.f١٨٣٠٠b = null;
    }

    @Override // nd.c
    public final boolean isDisposed() {
        if (get() == 4) {
            return true;
        }
        return false;
    }

    @Override // sd.j
    public final boolean isEmpty() {
        if (get() != 16) {
            return true;
        }
        return false;
    }

    @Override // sd.j
    public final Object poll() {
        if (get() != 16) {
            return null;
        }
        Object obj = this.f١٨٣٠٠b;
        this.f١٨٣٠٠b = null;
        lazySet(32);
        return obj;
    }
}
