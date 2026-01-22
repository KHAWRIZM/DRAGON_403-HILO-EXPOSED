package kotlin;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract /* synthetic */ class c {
    public static /* synthetic */ long a(long j10, long j11) {
        if (j11 < 0) {
            if ((j10 ^ Long.MIN_VALUE) < (Long.MIN_VALUE ^ j11)) {
                return j10;
            }
            return j10 - j11;
        }
        if (j10 >= 0) {
            return j10 % j11;
        }
        long j12 = j10 - ((((j10 >>> 1) / j11) << 1) * j11);
        if ((j12 ^ Long.MIN_VALUE) < (Long.MIN_VALUE ^ j11)) {
            j11 = 0;
        }
        return j12 - j11;
    }
}
