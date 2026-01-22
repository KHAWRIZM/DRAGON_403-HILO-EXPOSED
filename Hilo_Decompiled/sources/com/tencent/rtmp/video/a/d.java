package com.tencent.rtmp.video.a;

import com.tencent.rtmp.video.a.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class d implements Runnable {
    private final a.C٠٠٤٨a a;
    private final Runnable b;

    private d(a.C٠٠٤٨a r1, Runnable runnable) {
        this.a = r1;
        this.b = runnable;
    }

    public static Runnable a(a.C٠٠٤٨a r1, Runnable runnable) {
        return new d(r1, runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.C٠٠٤٨a r0 = this.a;
        this.b.run();
        synchronized (a.this) {
            a.this.c.remove(r0);
        }
    }
}
