package f5;

import android.os.SystemClock;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    private static final double f١٤٠٦٨a = 1.0d / Math.pow(10.0d, 6.0d);

    public static double a(long j10) {
        return (b() - j10) * f١٤٠٦٨a;
    }

    public static long b() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
