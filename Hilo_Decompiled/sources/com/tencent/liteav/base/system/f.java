package com.tencent.liteav.base.system;

import java.util.concurrent.Callable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class f implements Callable {
    private static final f a = new f();

    private f() {
    }

    public static Callable a() {
        return a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String a2;
        a2 = p.a(LiteavSystemInfo.sAppPackageName.a());
        return a2;
    }
}
