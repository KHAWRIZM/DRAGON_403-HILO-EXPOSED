package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzlj extends zzll {
    private final byte[] zzc;
    private final int zzd;
    private int zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlj(byte[] bArr, int i10, int i11) {
        super(null);
        int length = bArr.length;
        if (((length - i11) | i11) >= 0) {
            this.zzc = bArr;
            this.zze = 0;
            this.zzd = i11;
            return;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i11)));
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zza(int i10, int i11) throws IOException {
        zzr((i10 << 3) | i11);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzb(int i10, int i11) throws IOException {
        zzr(i10 << 3);
        zzq(i11);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzc(int i10, int i11) throws IOException {
        zzr(i10 << 3);
        zzr(i11);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzd(int i10, int i11) throws IOException {
        zzr((i10 << 3) | 5);
        zzs(i11);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zze(int i10, long j10) throws IOException {
        zzr(i10 << 3);
        zzt(j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzf(int i10, long j10) throws IOException {
        zzr((i10 << 3) | 1);
        zzu(j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzg(int i10, boolean z10) throws IOException {
        zzr(i10 << 3);
        zzp(z10 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzh(int i10, String str) throws IOException {
        zzr((i10 << 3) | 2);
        zzx(str);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzi(int i10, zzlg zzlgVar) throws IOException {
        zzr((i10 << 3) | 2);
        zzj(zzlgVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzj(zzlg zzlgVar) throws IOException {
        zzr(zzlgVar.zzc());
        zzlgVar.zzf(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzk(byte[] bArr, int i10, int i11) throws IOException {
        zzr(i11);
        zzv(bArr, 0, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzl(int i10, zznl zznlVar, zznw zznwVar) throws IOException {
        zzr((i10 << 3) | 2);
        zzr(((zzkr) zznlVar).zzcd(zznwVar));
        zznwVar.zzf(zznlVar, this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzm(int i10, zznl zznlVar) throws IOException {
        zzr(11);
        zzc(2, i10);
        zzr(26);
        zzo(zznlVar);
        zzr(12);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzn(int i10, zzlg zzlgVar) throws IOException {
        zzr(11);
        zzc(2, i10);
        zzi(3, zzlgVar);
        zzr(12);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzo(zznl zznlVar) throws IOException {
        zzr(zznlVar.zzcn());
        zznlVar.zzcB(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzp(byte b10) throws IOException {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i10 = this.zze;
        try {
            int i11 = i10 + 1;
            try {
                this.zzc[i10] = b10;
                this.zze = i11;
            } catch (IndexOutOfBoundsException e10) {
                indexOutOfBoundsException = e10;
                i10 = i11;
                throw new zzlk(i10, this.zzd, 1, indexOutOfBoundsException);
            }
        } catch (IndexOutOfBoundsException e11) {
            indexOutOfBoundsException = e11;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzq(int i10) throws IOException {
        if (i10 >= 0) {
            zzr(i10);
        } else {
            zzt(i10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzr(int i10) throws IOException {
        int i11;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i12 = this.zze;
        while ((i10 & (-128)) != 0) {
            try {
                i11 = i12 + 1;
                try {
                    this.zzc[i12] = (byte) (i10 | 128);
                    i10 >>>= 7;
                    i12 = i11;
                } catch (IndexOutOfBoundsException e10) {
                    indexOutOfBoundsException = e10;
                    i12 = i11;
                    throw new zzlk(i12, this.zzd, 1, indexOutOfBoundsException);
                }
            } catch (IndexOutOfBoundsException e11) {
                indexOutOfBoundsException = e11;
                throw new zzlk(i12, this.zzd, 1, indexOutOfBoundsException);
            }
        }
        i11 = i12 + 1;
        this.zzc[i12] = (byte) i10;
        this.zze = i11;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzs(int i10) throws IOException {
        int i11 = this.zze;
        try {
            byte[] bArr = this.zzc;
            bArr[i11] = (byte) i10;
            bArr[i11 + 1] = (byte) (i10 >> 8);
            bArr[i11 + 2] = (byte) (i10 >> 16);
            bArr[i11 + 3] = (byte) (i10 >> 24);
            this.zze = i11 + 4;
        } catch (IndexOutOfBoundsException e10) {
            throw new zzlk(i11, this.zzd, 4, e10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzt(long j10) throws IOException {
        boolean z10;
        int i10;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i11;
        z10 = zzll.zzd;
        int i12 = this.zze;
        if (z10 && this.zzd - i12 >= 10) {
            while ((j10 & (-128)) != 0) {
                zzoo.zzp(this.zzc, i12, (byte) (((int) j10) | 128));
                j10 >>>= 7;
                i12++;
            }
            i10 = i12 + 1;
            zzoo.zzp(this.zzc, i12, (byte) j10);
        } else {
            while ((j10 & (-128)) != 0) {
                try {
                    i11 = i12 + 1;
                } catch (IndexOutOfBoundsException e10) {
                    indexOutOfBoundsException = e10;
                }
                try {
                    this.zzc[i12] = (byte) (((int) j10) | 128);
                    j10 >>>= 7;
                    i12 = i11;
                } catch (IndexOutOfBoundsException e11) {
                    indexOutOfBoundsException = e11;
                    i12 = i11;
                    throw new zzlk(i12, this.zzd, 1, indexOutOfBoundsException);
                }
            }
            i10 = i12 + 1;
            try {
                this.zzc[i12] = (byte) j10;
            } catch (IndexOutOfBoundsException e12) {
                indexOutOfBoundsException = e12;
                i12 = i10;
                throw new zzlk(i12, this.zzd, 1, indexOutOfBoundsException);
            }
        }
        this.zze = i10;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzu(long j10) throws IOException {
        int i10 = this.zze;
        try {
            byte[] bArr = this.zzc;
            bArr[i10] = (byte) j10;
            bArr[i10 + 1] = (byte) (j10 >> 8);
            bArr[i10 + 2] = (byte) (j10 >> 16);
            bArr[i10 + 3] = (byte) (j10 >> 24);
            bArr[i10 + 4] = (byte) (j10 >> 32);
            bArr[i10 + 5] = (byte) (j10 >> 40);
            bArr[i10 + 6] = (byte) (j10 >> 48);
            bArr[i10 + 7] = (byte) (j10 >> 56);
            this.zze = i10 + 8;
        } catch (IndexOutOfBoundsException e10) {
            throw new zzlk(i10, this.zzd, 8, e10);
        }
    }

    public final void zzv(byte[] bArr, int i10, int i11) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zzc, this.zze, i11);
            this.zze += i11;
        } catch (IndexOutOfBoundsException e10) {
            throw new zzlk(this.zze, this.zzd, i11, e10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzw(byte[] bArr, int i10, int i11) throws IOException {
        zzv(bArr, 0, i11);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzx(String str) throws IOException {
        int i10 = this.zze;
        try {
            int zzz = zzll.zzz(str.length() * 3);
            int zzz2 = zzll.zzz(str.length());
            if (zzz2 == zzz) {
                int i11 = i10 + zzz2;
                this.zze = i11;
                int zzc = zzor.zzc(str, this.zzc, i11, this.zzd - i11);
                this.zze = i10;
                zzr((zzc - i10) - zzz2);
                this.zze = zzc;
                return;
            }
            zzr(zzor.zzb(str));
            byte[] bArr = this.zzc;
            int i12 = this.zze;
            this.zze = zzor.zzc(str, bArr, i12, this.zzd - i12);
        } catch (zzoq e10) {
            this.zze = i10;
            zzF(str, e10);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzlk(e11);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final int zzy() {
        return this.zzd - this.zze;
    }
}
