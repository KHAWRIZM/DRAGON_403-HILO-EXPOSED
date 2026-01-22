package qd;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class f extends AtomicReference implements nd.c {
    private static final long serialVersionUID = -754898800686245608L;

    public f() {
    }

    public boolean a(nd.c cVar) {
        return c.d(this, cVar);
    }

    public boolean b(nd.c cVar) {
        return c.f(this, cVar);
    }

    @Override // nd.c
    public void dispose() {
        c.a(this);
    }

    @Override // nd.c
    public boolean isDisposed() {
        return c.c((nd.c) get());
    }

    public f(nd.c cVar) {
        lazySet(cVar);
    }
}
