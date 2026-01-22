package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class zzlf extends zzle {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlf(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzlg) || zzc() != ((zzlg) obj).zzc()) {
            return false;
        }
        if (zzc() == 0) {
            return true;
        }
        if (obj instanceof zzlf) {
            zzlf zzlfVar = (zzlf) obj;
            int zzi = zzi();
            int zzi2 = zzlfVar.zzi();
            if (zzi != 0 && zzi2 != 0 && zzi != zzi2) {
                return false;
            }
            int zzc = zzc();
            if (zzc <= zzlfVar.zzc()) {
                if (zzc <= zzlfVar.zzc()) {
                    byte[] bArr = this.zza;
                    byte[] bArr2 = zzlfVar.zza;
                    zzlfVar.zzd();
                    int i10 = 0;
                    int i11 = 0;
                    while (i10 < zzc) {
                        if (bArr[i10] != bArr2[i11]) {
                            return false;
                        }
                        i10++;
                        i11++;
                    }
                    return true;
                }
                int zzc2 = zzlfVar.zzc();
                StringBuilder sb = new StringBuilder(String.valueOf(zzc).length() + 27 + String.valueOf(zzc2).length());
                sb.append("Ran off end of other: 0, ");
                sb.append(zzc);
                sb.append(", ");
                sb.append(zzc2);
                throw new IllegalArgumentException(sb.toString());
            }
            int zzc3 = zzc();
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzc).length() + 18 + String.valueOf(zzc3).length());
            sb2.append("Length too large: ");
            sb2.append(zzc);
            sb2.append(zzc3);
            throw new IllegalArgumentException(sb2.toString());
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public byte zza(int i10) {
        return this.zza[i10];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzlg
    public byte zzb(int i10) {
        return this.zza[i10];
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public int zzc() {
        return this.zza.length;
    }

    protected int zzd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final zzlg zze(int i10, int i11) {
        int zzj = zzlg.zzj(0, i11, zzc());
        if (zzj == 0) {
            return zzlg.zzb;
        }
        return new zzlb(this.zza, 0, zzj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzlg
    public final void zzf(zzky zzkyVar) throws IOException {
        ((zzlj) zzkyVar).zzv(this.zza, 0, zzc());
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    protected final int zzg(int i10, int i11, int i12) {
        return zzmo.zzc(i10, this.zza, 0, i12);
    }
}
