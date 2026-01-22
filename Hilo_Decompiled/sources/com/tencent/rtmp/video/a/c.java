package com.tencent.rtmp.video.a;

import java.util.concurrent.CountDownLatch;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class c implements Runnable {
    private final Runnable a;
    private final CountDownLatch b;

    private c(Runnable runnable, CountDownLatch countDownLatch) {
        this.a = runnable;
        this.b = countDownLatch;
    }

    public static Runnable a(Runnable runnable, CountDownLatch countDownLatch) {
        return new c(runnable, countDownLatch);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable = this.a;
        CountDownLatch countDownLatch = this.b;
        runnable.run();
        countDownLatch.countDown();
    }
}
