package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.base.util.LiteavLog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class c implements Runnable {
    private final b a;

    private c(b bVar) {
        this.a = bVar;
    }

    public static Runnable a(b bVar) {
        return new c(bVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.a;
        if (bVar.e != null) {
            LiteavLog.w(bVar.a, "onRequestRestart");
            bVar.e.a();
        }
    }
}
