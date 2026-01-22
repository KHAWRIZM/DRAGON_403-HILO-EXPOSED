package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzoi {
    private static final zzoi zza = new zzoi(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzoi(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.zze = -1;
        this.zzb = i10;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z10;
    }

    public static zzoi zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzoi zzb() {
        return new zzoi(0, new int[8], new Object[8], true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzoi zzc(zzoi zzoiVar, zzoi zzoiVar2) {
        int i10 = zzoiVar.zzb + zzoiVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzoiVar.zzc, i10);
        System.arraycopy(zzoiVar2.zzc, 0, copyOf, zzoiVar.zzb, zzoiVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzoiVar.zzd, i10);
        System.arraycopy(zzoiVar2.zzd, 0, copyOf2, zzoiVar.zzb, zzoiVar2.zzb);
        return new zzoi(i10, copyOf, copyOf2, true);
    }

    private final void zzm(int i10) {
        int[] iArr = this.zzc;
        if (i10 > iArr.length) {
            int i11 = this.zzb;
            int i12 = i11 + (i11 / 2);
            if (i12 >= i10) {
                i10 = i12;
            }
            if (i10 < 8) {
                i10 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i10);
            this.zzd = Arrays.copyOf(this.zzd, i10);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzoi)) {
            return false;
        }
        zzoi zzoiVar = (zzoi) obj;
        int i10 = this.zzb;
        if (i10 == zzoiVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzoiVar.zzc;
            int i11 = 0;
            while (true) {
                if (i11 < i10) {
                    if (iArr[i11] != iArr2[i11]) {
                        break;
                    }
                    i11++;
                } else {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzoiVar.zzd;
                    int i12 = this.zzb;
                    for (int i13 = 0; i13 < i12; i13++) {
                        if (objArr[i13].equals(objArr2[i13])) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10 = this.zzb;
        int i11 = i10 + 527;
        int[] iArr = this.zzc;
        int i12 = 17;
        int i13 = 17;
        for (int i14 = 0; i14 < i10; i14++) {
            i13 = (i13 * 31) + iArr[i14];
        }
        int i15 = ((i11 * 31) + i13) * 31;
        Object[] objArr = this.zzd;
        int i16 = this.zzb;
        for (int i17 = 0; i17 < i16; i17++) {
            i12 = (i12 * 31) + objArr[i17].hashCode();
        }
        return i15 + i12;
    }

    public final void zzd() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    final void zze() {
        if (this.zzf) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzf(zzou zzouVar) throws IOException {
        for (int i10 = 0; i10 < this.zzb; i10++) {
            zzouVar.zzv(this.zzc[i10] >>> 3, this.zzd[i10]);
        }
    }

    public final void zzg(zzou zzouVar) throws IOException {
        if (this.zzb != 0) {
            for (int i10 = 0; i10 < this.zzb; i10++) {
                int i11 = this.zzc[i10];
                Object obj = this.zzd[i10];
                int i12 = i11 & 7;
                int i13 = i11 >>> 3;
                if (i12 != 0) {
                    if (i12 != 1) {
                        if (i12 != 2) {
                            if (i12 != 3) {
                                if (i12 == 5) {
                                    zzouVar.zzk(i13, ((Integer) obj).intValue());
                                } else {
                                    throw new RuntimeException(new zzmp("Protocol message tag had invalid wire type."));
                                }
                            } else {
                                zzouVar.zzt(i13);
                                ((zzoi) obj).zzg(zzouVar);
                                zzouVar.zzu(i13);
                            }
                        } else {
                            zzouVar.zzn(i13, (zzlg) obj);
                        }
                    } else {
                        zzouVar.zzj(i13, ((Long) obj).longValue());
                    }
                } else {
                    zzouVar.zzc(i13, ((Long) obj).longValue());
                }
            }
        }
    }

    public final int zzh() {
        int i10 = this.zze;
        if (i10 == -1) {
            int i11 = 0;
            for (int i12 = 0; i12 < this.zzb; i12++) {
                int i13 = this.zzc[i12] >>> 3;
                zzlg zzlgVar = (zzlg) this.zzd[i12];
                int zzz = zzll.zzz(8);
                int zzz2 = zzll.zzz(16) + zzll.zzz(i13);
                int zzz3 = zzll.zzz(24);
                int zzc = zzlgVar.zzc();
                i11 += zzz + zzz + zzz2 + zzz3 + zzll.zzz(zzc) + zzc;
            }
            this.zze = i11;
            return i11;
        }
        return i10;
    }

    public final int zzi() {
        int zzz;
        int zzA;
        int i10;
        int i11 = this.zze;
        if (i11 == -1) {
            int i12 = 0;
            for (int i13 = 0; i13 < this.zzb; i13++) {
                int i14 = this.zzc[i13];
                int i15 = i14 >>> 3;
                int i16 = i14 & 7;
                if (i16 != 0) {
                    if (i16 != 1) {
                        if (i16 != 2) {
                            if (i16 != 3) {
                                if (i16 == 5) {
                                    ((Integer) this.zzd[i13]).intValue();
                                    i10 = zzll.zzz(i15 << 3) + 4;
                                } else {
                                    throw new IllegalStateException(new zzmp("Protocol message tag had invalid wire type."));
                                }
                            } else {
                                int zzz2 = zzll.zzz(i15 << 3);
                                zzz = zzz2 + zzz2;
                                zzA = ((zzoi) this.zzd[i13]).zzi();
                            }
                        } else {
                            int i17 = i15 << 3;
                            zzlg zzlgVar = (zzlg) this.zzd[i13];
                            int zzz3 = zzll.zzz(i17);
                            int zzc = zzlgVar.zzc();
                            i10 = zzz3 + zzll.zzz(zzc) + zzc;
                        }
                    } else {
                        ((Long) this.zzd[i13]).longValue();
                        i10 = zzll.zzz(i15 << 3) + 8;
                    }
                    i12 += i10;
                } else {
                    int i18 = i15 << 3;
                    long longValue = ((Long) this.zzd[i13]).longValue();
                    zzz = zzll.zzz(i18);
                    zzA = zzll.zzA(longValue);
                }
                i10 = zzz + zzA;
                i12 += i10;
            }
            this.zze = i12;
            return i12;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(StringBuilder sb, int i10) {
        for (int i11 = 0; i11 < this.zzb; i11++) {
            zznn.zzb(sb, i10, String.valueOf(this.zzc[i11] >>> 3), this.zzd[i11]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzk(int i10, Object obj) {
        zze();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i11 = this.zzb;
        iArr[i11] = i10;
        this.zzd[i11] = obj;
        this.zzb = i11 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzoi zzl(zzoi zzoiVar) {
        if (zzoiVar.equals(zza)) {
            return this;
        }
        zze();
        int i10 = this.zzb + zzoiVar.zzb;
        zzm(i10);
        System.arraycopy(zzoiVar.zzc, 0, this.zzc, this.zzb, zzoiVar.zzb);
        System.arraycopy(zzoiVar.zzd, 0, this.zzd, this.zzb, zzoiVar.zzb);
        this.zzb = i10;
        return this;
    }

    private zzoi() {
        this(0, new int[8], new Object[8], true);
    }
}
