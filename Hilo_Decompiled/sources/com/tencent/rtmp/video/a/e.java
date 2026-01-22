package com.tencent.rtmp.video.a;

import com.tencent.rtmp.video.a.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class e implements Runnable {
    private final a.C٠٠٤٨a a;

    private e(a.C٠٠٤٨a r1) {
        this.a = r1;
    }

    public static Runnable a(a.C٠٠٤٨a r1) {
        return new e(r1);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.C٠٠٤٨a r0 = this.a;
        a.this.a.execute(r0.b);
    }
}
