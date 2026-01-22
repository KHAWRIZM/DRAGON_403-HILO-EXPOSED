package nd;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
abstract class e extends AtomicReference implements c {
    private static final long serialVersionUID = 6537757548749041217L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Object obj) {
        super(obj);
        Objects.requireNonNull(obj, "value is null");
    }

    protected abstract void a(Object obj);

    @Override // nd.c
    public final void dispose() {
        Object andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            a(andSet);
        }
    }

    @Override // nd.c
    public final boolean isDisposed() {
        if (get() == null) {
            return true;
        }
        return false;
    }
}
