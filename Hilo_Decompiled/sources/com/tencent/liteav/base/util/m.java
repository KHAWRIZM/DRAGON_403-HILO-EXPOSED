package com.tencent.liteav.base.util;

import java.util.concurrent.ThreadFactory;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class m implements ThreadFactory {
    private final String a;

    private m(String str) {
        this.a = str;
    }

    public static ThreadFactory a(String str) {
        return new m(str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.a);
    }
}
