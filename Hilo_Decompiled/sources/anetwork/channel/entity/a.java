package anetwork.channel.entity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final ExecutorService[] f٥٢٠٥a = new ExecutorService[2];

    /* renamed from: b, reason: collision with root package name */
    private static AtomicInteger f٥٢٠٦b = new AtomicInteger(0);

    static {
        for (int i10 = 0; i10 < 2; i10++) {
            f٥٢٠٥a[i10] = Executors.newSingleThreadExecutor(new b());
        }
    }

    public static void a(int i10, Runnable runnable) {
        f٥٢٠٥a[Math.abs(i10 % 2)].submit(runnable);
    }
}
