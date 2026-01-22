package com.tencent.liteav.base.util;

import com.tencent.liteav.base.util.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* synthetic */ class n implements Runnable {
    private final l.a a;
    private final Runnable b;

    private n(l.a aVar, Runnable runnable) {
        this.a = aVar;
        this.b = runnable;
    }

    public static Runnable a(l.a aVar, Runnable runnable) {
        return new n(aVar, runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        l.a aVar = this.a;
        this.b.run();
        synchronized (l.this) {
            l.this.c.remove(aVar);
        }
    }
}
