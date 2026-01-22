package com.tencent.liteav.base.b;

import android.os.SystemClock;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class a {
    private long a = 0;
    private final long b;

    public a(long j) {
        this.b = j;
    }

    public final boolean a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.a;
        if (j != 0 && elapsedRealtime - j <= this.b) {
            return false;
        }
        this.a = SystemClock.elapsedRealtime();
        return true;
    }
}
