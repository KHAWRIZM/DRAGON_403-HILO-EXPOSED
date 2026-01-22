package qd;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class b extends AtomicReference implements nd.c {
    private static final long serialVersionUID = 5718521705281392066L;

    public b(pd.f fVar) {
        super(fVar);
    }

    @Override // nd.c
    public void dispose() {
        pd.f fVar;
        if (get() != null && (fVar = (pd.f) getAndSet(null)) != null) {
            try {
                fVar.cancel();
            } catch (Throwable th) {
                od.b.b(th);
                ie.a.s(th);
            }
        }
    }

    @Override // nd.c
    public boolean isDisposed() {
        if (get() == null) {
            return true;
        }
        return false;
    }
}
