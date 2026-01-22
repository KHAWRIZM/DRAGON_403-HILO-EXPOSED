package ce;

import java.util.concurrent.Callable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class j extends a implements Callable {
    private static final long serialVersionUID = 1811839108042568751L;

    public j(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void call() {
        this.f٦٠٢٤b = Thread.currentThread();
        try {
            try {
                this.f٦٠٢٣a.run();
                return null;
            } finally {
                lazySet(a.f٦٠٢١c);
                this.f٦٠٢٤b = null;
            }
        } catch (Throwable th) {
            ie.a.s(th);
            throw th;
        }
    }
}
