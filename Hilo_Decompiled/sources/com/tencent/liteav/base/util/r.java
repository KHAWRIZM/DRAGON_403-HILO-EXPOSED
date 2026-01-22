package com.tencent.liteav.base.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class r extends Handler {
    private int a;
    private boolean b;
    private final a c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface a {
        void onTimeout();
    }

    public r(Looper looper, a aVar) {
        super(looper);
        this.b = false;
        this.c = aVar;
    }

    public final synchronized void a(int i) {
        a();
        this.a = i;
        this.b = true;
        sendEmptyMessageDelayed(0, 0L);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        synchronized (this) {
            try {
                if (!this.b) {
                    return;
                }
                removeMessages(0);
                sendEmptyMessageDelayed(0, this.a);
                a aVar = this.c;
                if (aVar != null) {
                    aVar.onTimeout();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void a() {
        while (hasMessages(0)) {
            try {
                removeMessages(0);
            } catch (Throwable th) {
                throw th;
            }
        }
        this.b = false;
    }
}
