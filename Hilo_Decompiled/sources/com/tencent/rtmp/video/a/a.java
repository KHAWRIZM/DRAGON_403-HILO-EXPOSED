package com.tencent.rtmp.video.a;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class a {
    final ThreadPoolExecutor a;
    final Handler b;
    final List<C٠٠٤٨a> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.rtmp.video.a.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class C٠٠٤٨a {
        final Runnable a;
        final Runnable b;
        final Runnable c = e.a(this);
        final long d;

        public C٠٠٤٨a(Runnable runnable, long j) {
            this.a = runnable;
            this.b = d.a(this, runnable);
            this.d = j;
        }
    }

    public a() {
        this((byte) 0);
    }

    public final void a(Runnable runnable) {
        this.a.execute(runnable);
    }

    public final void b(Runnable runnable) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.a.execute(c.a(runnable, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public final void c(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.a.remove(runnable);
        synchronized (this) {
            try {
                Iterator<C٠٠٤٨a> it = this.c.iterator();
                while (it.hasNext()) {
                    C٠٠٤٨a next = it.next();
                    if (next != null && runnable == next.a) {
                        a.this.b.removeCallbacks(next.c);
                        a.this.a.remove(next.b);
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private a(byte b) {
        this("SequenceTaskRunner_");
    }

    public final void a(Runnable runnable, long j) {
        C٠٠٤٨a r0 = new C٠٠٤٨a(runnable, j);
        synchronized (this) {
            this.c.add(r0);
        }
        a.this.b.postDelayed(r0.c, r0.d);
    }

    private a(String str) {
        this.a = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), b.a(str));
        this.b = new Handler(Looper.getMainLooper());
        this.c = new ArrayList();
    }
}
