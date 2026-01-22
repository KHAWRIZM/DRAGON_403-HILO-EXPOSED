package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class g implements Callable {
    private static final g a = new g();

    private g() {
    }

    public static Callable a() {
        return a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String[] strArr;
        strArr = Build.SUPPORTED_ABIS;
        return strArr;
    }
}
