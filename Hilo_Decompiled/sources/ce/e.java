package ce;

import io.reactivex.rxjava3.core.h0;
import java.util.concurrent.ThreadFactory;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class e extends h0 {

    /* renamed from: b, reason: collision with root package name */
    private static final h f٦٠٦٤b = new h("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx3.newthread-priority", 5).intValue())));

    /* renamed from: a, reason: collision with root package name */
    final ThreadFactory f٦٠٦٥a;

    public e() {
        this(f٦٠٦٤b);
    }

    @Override // io.reactivex.rxjava3.core.h0
    public h0.c createWorker() {
        return new f(this.f٦٠٦٥a);
    }

    public e(ThreadFactory threadFactory) {
        this.f٦٠٦٥a = threadFactory;
    }
}
