package com.google.android.gms.internal.fido;

import java.math.RoundingMode;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzgh {
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
    
        if (((r0 & 1) & r3) != 0) goto L٢٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        if (r1 > 0) goto L٢٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
    
        if (r5 > 0) goto L٢٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
    
        if (r5 < 0) goto L٢٧;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x001c. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int zza(int i10, int i11, RoundingMode roundingMode) {
        roundingMode.getClass();
        if (i11 != 0) {
            int i12 = i10 / i11;
            int i13 = i10 - (i11 * i12);
            if (i13 != 0) {
                int i14 = 1;
                int i15 = ((i10 ^ i11) >> 31) | 1;
                switch (zzgg.zza[roundingMode.ordinal()]) {
                    case 1:
                        zzgi.zza(false);
                    case 2:
                        return i12;
                    case 3:
                        break;
                    case 4:
                        return i12 + i15;
                    case 5:
                        break;
                    case 6:
                    case 7:
                    case 8:
                        int abs = Math.abs(i13);
                        int abs2 = abs - (Math.abs(i11) - abs);
                        if (abs2 == 0) {
                            if (roundingMode != RoundingMode.HALF_UP) {
                                if (roundingMode != RoundingMode.HALF_EVEN) {
                                    i14 = 0;
                                }
                                break;
                            }
                            return i12 + i15;
                        }
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            return i12;
        }
        throw new ArithmeticException("/ by zero");
    }

    public static int zzb(int i10, RoundingMode roundingMode) {
        boolean z10;
        if (i10 > 0) {
            switch (zzgg.zza[roundingMode.ordinal()]) {
                case 1:
                    if (((i10 - 1) & i10) == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    zzgi.zza(z10);
                    break;
                case 2:
                case 3:
                    break;
                case 4:
                case 5:
                    return 32 - Integer.numberOfLeadingZeros(i10 - 1);
                case 6:
                case 7:
                case 8:
                    int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i10);
                    return (31 - numberOfLeadingZeros) + ((((-1257966797) >>> numberOfLeadingZeros) - i10) >>> 31);
                default:
                    throw new AssertionError();
            }
            return 31 - Integer.numberOfLeadingZeros(i10);
        }
        throw new IllegalArgumentException("x (0) must be > 0");
    }
}
