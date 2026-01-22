package com.google.android.gms.internal.fido;

import java.math.RoundingMode;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzgb {
    final int zza;
    final int zzb;
    final int zzc;
    final int zzd;
    private final String zze;
    private final char[] zzf;
    private final byte[] zzg;
    private final boolean zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzgb(String str, char[] cArr) {
        this(str, cArr, r1, false);
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        for (int i10 = 0; i10 < cArr.length; i10++) {
            char c10 = cArr[i10];
            boolean z10 = true;
            zzbm.zzd(c10 < 128, "Non-ASCII character: %s", c10);
            if (bArr[c10] != -1) {
                z10 = false;
            }
            zzbm.zzd(z10, "Duplicate character: %s", c10);
            bArr[c10] = (byte) i10;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzgb) {
            zzgb zzgbVar = (zzgb) obj;
            if (this.zzh == zzgbVar.zzh && Arrays.equals(this.zzf, zzgbVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10;
        boolean z10 = this.zzh;
        int hashCode = Arrays.hashCode(this.zzf);
        if (true != z10) {
            i10 = 1237;
        } else {
            i10 = 1231;
        }
        return hashCode + i10;
    }

    public final String toString() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final char zza(int i10) {
        return this.zzf[i10];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    public final zzgb zzb() {
        int i10;
        boolean z10;
        int i11 = 0;
        while (true) {
            char[] cArr = this.zzf;
            if (i11 < cArr.length) {
                if (zzba.zza(cArr[i11])) {
                    int i12 = 0;
                    while (true) {
                        if (i12 < cArr.length) {
                            char c10 = cArr[i12];
                            if (c10 >= 'A' && c10 <= 'Z') {
                                z10 = true;
                                break;
                            }
                            i12++;
                        } else {
                            z10 = false;
                            break;
                        }
                    }
                    zzbm.zzf(!z10, "Cannot call upperCase() on a mixed-case alphabet");
                    char[] cArr2 = new char[this.zzf.length];
                    int i13 = 0;
                    while (true) {
                        char[] cArr3 = this.zzf;
                        if (i13 >= cArr3.length) {
                            break;
                        }
                        char c11 = cArr3[i13];
                        if (zzba.zza(c11)) {
                            c11 ^= 32;
                        }
                        cArr2[i13] = (char) c11;
                        i13++;
                    }
                    zzgb zzgbVar = new zzgb(this.zze.concat(".upperCase()"), cArr2);
                    if (this.zzh && !zzgbVar.zzh) {
                        byte[] bArr = zzgbVar.zzg;
                        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                        for (i10 = 65; i10 <= 90; i10++) {
                            int i14 = i10 | 32;
                            byte[] bArr2 = zzgbVar.zzg;
                            byte b10 = bArr2[i10];
                            byte b11 = bArr2[i14];
                            if (b10 == -1) {
                                copyOf[i10] = b11;
                            } else {
                                char c12 = (char) i10;
                                char c13 = (char) i14;
                                if (b11 == -1) {
                                    copyOf[i14] = b10;
                                } else {
                                    throw new IllegalStateException(zzbo.zza("Can't ignoreCase() since '%s' and '%s' encode different values", Character.valueOf(c12), Character.valueOf(c13)));
                                }
                            }
                        }
                        return new zzgb(zzgbVar.zze.concat(".ignoreCase()"), zzgbVar.zzf, copyOf, true);
                    }
                    return zzgbVar;
                }
                i11++;
            } else {
                return this;
            }
        }
    }

    public final boolean zzc(char c10) {
        byte[] bArr = this.zzg;
        if (bArr.length > 61 && bArr[61] != -1) {
            return true;
        }
        return false;
    }

    private zzgb(String str, char[] cArr, byte[] bArr, boolean z10) {
        this.zze = str;
        cArr.getClass();
        this.zzf = cArr;
        try {
            int length = cArr.length;
            int zzb = zzgh.zzb(length, RoundingMode.UNNECESSARY);
            this.zzb = zzb;
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(zzb);
            int i10 = 1 << (3 - numberOfTrailingZeros);
            this.zzc = i10;
            this.zzd = zzb >> numberOfTrailingZeros;
            this.zza = length - 1;
            this.zzg = bArr;
            boolean[] zArr = new boolean[i10];
            for (int i11 = 0; i11 < this.zzd; i11++) {
                zArr[zzgh.zza(i11 * 8, this.zzb, RoundingMode.CEILING)] = true;
            }
            this.zzh = z10;
        } catch (ArithmeticException e10) {
            throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e10);
        }
    }
}
