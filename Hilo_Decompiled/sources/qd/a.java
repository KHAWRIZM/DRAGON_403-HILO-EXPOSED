package qd;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class a extends AtomicReferenceArray implements nd.c {
    private static final long serialVersionUID = 2746389416410565408L;

    public a(int i10) {
        super(i10);
    }

    public boolean a(int i10, nd.c cVar) {
        nd.c cVar2;
        do {
            cVar2 = (nd.c) get(i10);
            if (cVar2 == c.DISPOSED) {
                cVar.dispose();
                return false;
            }
        } while (!compareAndSet(i10, cVar2, cVar));
        if (cVar2 != null) {
            cVar2.dispose();
            return true;
        }
        return true;
    }

    @Override // nd.c
    public void dispose() {
        nd.c cVar;
        if (get(0) != c.DISPOSED) {
            int length = length();
            for (int i10 = 0; i10 < length; i10++) {
                nd.c cVar2 = (nd.c) get(i10);
                c cVar3 = c.DISPOSED;
                if (cVar2 != cVar3 && (cVar = (nd.c) getAndSet(i10, cVar3)) != cVar3 && cVar != null) {
                    cVar.dispose();
                }
            }
        }
    }

    @Override // nd.c
    public boolean isDisposed() {
        if (get(0) != c.DISPOSED) {
            return false;
        }
        return true;
    }
}
