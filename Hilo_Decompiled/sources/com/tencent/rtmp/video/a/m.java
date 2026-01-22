package com.tencent.rtmp.video.a;

import com.tencent.rtmp.video.a.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class m implements Runnable {
    private final f a;

    private m(f fVar) {
        this.a = fVar;
    }

    public static Runnable a(f fVar) {
        return new m(fVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.AnonymousClass1.a(this.a);
    }
}
