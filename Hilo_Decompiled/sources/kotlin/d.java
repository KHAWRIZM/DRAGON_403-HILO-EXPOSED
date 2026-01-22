package kotlin;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract /* synthetic */ class d {
    public static /* synthetic */ long a(long j10, long j11) {
        if (j11 < 0) {
            if ((j10 ^ Long.MIN_VALUE) < (j11 ^ Long.MIN_VALUE)) {
                return 0L;
            }
            return 1L;
        }
        if (j10 >= 0) {
            return j10 / j11;
        }
        int i10 = 1;
        long j12 = ((j10 >>> 1) / j11) << 1;
        if (((j10 - (j12 * j11)) ^ Long.MIN_VALUE) < (j11 ^ Long.MIN_VALUE)) {
            i10 = 0;
        }
        return j12 + i10;
    }
}
