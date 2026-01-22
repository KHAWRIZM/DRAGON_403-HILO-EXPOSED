package com.alibaba.sdk.android.tbrest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static ScheduledExecutorService f٦٨١٠a = null;

    /* renamed from: a, reason: collision with other field name */
    public static final AtomicInteger f١٧a = new AtomicInteger();

    /* renamed from: g, reason: collision with root package name */
    public static int f٦٨١١g = 1;

    /* renamed from: a, reason: collision with other field name */
    public Integer f١٨a = 2;

    /* renamed from: com.alibaba.sdk.android.tbrest.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class ThreadFactoryC٠٠٨٥a implements ThreadFactory {
        private final int priority;

        public ThreadFactoryC٠٠٨٥a(int i10) {
            this.priority = i10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "RestSend:" + a.f١٧a.getAndIncrement());
            thread.setPriority(this.priority);
            return thread;
        }
    }

    public synchronized void a(Runnable runnable) {
        try {
            if (f٦٨١٠a == null) {
                f٦٨١٠a = Executors.newScheduledThreadPool(this.f١٨a.intValue(), new ThreadFactoryC٠٠٨٥a(f٦٨١١g));
            }
            f٦٨١٠a.submit(runnable);
        } finally {
        }
    }
}
