package com.oudi.utils;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0005R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/oudi/utils/ServiceTime;", "", "<init>", "()V", "serviceTimeDiff", "", "Ljava/lang/Long;", "time", "getTime", "()J", "refreshServiceTime", "", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ServiceTime {
    public static final ServiceTime INSTANCE = new ServiceTime();
    private static Long serviceTimeDiff;

    private ServiceTime() {
    }

    public final long getTime() {
        if (serviceTimeDiff == null) {
            return System.currentTimeMillis();
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Long l10 = serviceTimeDiff;
        Intrinsics.checkNotNull(l10);
        return elapsedRealtime + l10.longValue();
    }

    public final void refreshServiceTime(long time) {
        serviceTimeDiff = Long.valueOf(time - SystemClock.elapsedRealtime());
    }
}
