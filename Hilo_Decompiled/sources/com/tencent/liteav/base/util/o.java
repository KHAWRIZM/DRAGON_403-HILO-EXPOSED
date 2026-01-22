package com.tencent.liteav.base.util;

import com.tencent.liteav.base.util.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* synthetic */ class o implements Runnable {
    private final l.a a;

    private o(l.a aVar) {
        this.a = aVar;
    }

    public static Runnable a(l.a aVar) {
        return new o(aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        l.a aVar = this.a;
        l.this.a.execute(aVar.a);
    }
}
