package com.tencent.liteav.base.util;

import android.os.MessageQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* synthetic */ class d implements Runnable {
    private final CustomHandler a;
    private final MessageQueue.IdleHandler b;

    private d(CustomHandler customHandler, MessageQueue.IdleHandler idleHandler) {
        this.a = customHandler;
        this.b = idleHandler;
    }

    public static Runnable a(CustomHandler customHandler, MessageQueue.IdleHandler idleHandler) {
        return new d(customHandler, idleHandler);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CustomHandler.lambda$quitLooper$3(this.a, this.b);
    }
}
