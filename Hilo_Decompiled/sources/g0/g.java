package g0;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public static final long f١٤٣٧٠c = TimeUnit.MILLISECONDS.toNanos(100);

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f١٤٣٧١a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f١٤٣٧٢b;

    public g() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        this.f١٤٣٧١a = hashMap;
        this.f١٤٣٧٢b = hashMap2;
    }

    public final void a(String str) {
        AtomicInteger atomicInteger;
        Thread thread;
        synchronized (this.f١٤٣٧١a) {
            atomicInteger = (AtomicInteger) this.f١٤٣٧١a.get(str);
        }
        if (atomicInteger != null && atomicInteger.decrementAndGet() == 0) {
            synchronized (this.f١٤٣٧٢b) {
                try {
                    thread = (Thread) this.f١٤٣٧٢b.get(str);
                    if (thread != null) {
                        this.f١٤٣٧٢b.remove(str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (thread != null) {
                atomicInteger.toString();
                LockSupport.unpark(thread);
            }
            synchronized (this.f١٤٣٧١a) {
                this.f١٤٣٧١a.remove(str);
            }
        }
    }

    public final void b(String str) {
        AtomicInteger atomicInteger;
        synchronized (this.f١٤٣٧١a) {
            atomicInteger = (AtomicInteger) this.f١٤٣٧١a.get(str);
        }
        if (atomicInteger != null && atomicInteger.get() > 0) {
            synchronized (this.f١٤٣٧٢b) {
                this.f١٤٣٧٢b.put(str, Thread.currentThread());
            }
            while (atomicInteger.get() > 0) {
                LockSupport.park(Long.valueOf(f١٤٣٧٠c));
            }
        }
    }

    public final void c(String str) {
        AtomicInteger atomicInteger;
        synchronized (this.f١٤٣٧١a) {
            atomicInteger = (AtomicInteger) this.f١٤٣٧١a.get(str);
        }
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
            synchronized (this.f١٤٣٧١a) {
                this.f١٤٣٧١a.put(str, atomicInteger);
            }
        }
        atomicInteger.incrementAndGet();
    }
}
