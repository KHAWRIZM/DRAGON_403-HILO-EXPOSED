package anetwork.channel.entity;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class b implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        AtomicInteger atomicInteger;
        atomicInteger = a.f٥٢٠٦b;
        return new Thread(runnable, String.format("RepeaterThread:%d", Integer.valueOf(atomicInteger.getAndIncrement())));
    }
}
