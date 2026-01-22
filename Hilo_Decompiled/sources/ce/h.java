package ce;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class h extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;

    /* renamed from: a, reason: collision with root package name */
    final String f٦٠٦٨a;

    /* renamed from: b, reason: collision with root package name */
    final int f٦٠٦٩b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f٦٠٧٠c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends Thread implements g {
        a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public h(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread;
        String str = this.f٦٠٦٨a + '-' + incrementAndGet();
        if (this.f٦٠٧٠c) {
            thread = new a(runnable, str);
        } else {
            thread = new Thread(runnable, str);
        }
        thread.setPriority(this.f٦٠٦٩b);
        thread.setDaemon(true);
        return thread;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.f٦٠٦٨a + "]";
    }

    public h(String str, int i10) {
        this(str, i10, false);
    }

    public h(String str, int i10, boolean z10) {
        this.f٦٠٦٨a = str;
        this.f٦٠٦٩b = i10;
        this.f٦٠٧٠c = z10;
    }
}
