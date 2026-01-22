package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class zzlg implements Iterable, Serializable {
    public static final zzlg zzb = new zzlf(zzmo.zzb);
    private int zza = 0;

    static {
        int i10 = zzku.zza;
    }

    public static zzlg zzh(byte[] bArr, int i10, int i11) {
        zzj(i10, i10 + i11, bArr.length);
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return new zzlf(bArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i10, int i11, int i12) {
        int i13 = i11 - i10;
        if ((i10 | i11 | i13 | (i12 - i11)) < 0) {
            if (i10 >= 0) {
                if (i11 < i10) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 44 + String.valueOf(i11).length());
                    sb.append("Beginning index larger than ending index: ");
                    sb.append(i10);
                    sb.append(", ");
                    sb.append(i11);
                    throw new IndexOutOfBoundsException(sb.toString());
                }
                StringBuilder sb2 = new StringBuilder(String.valueOf(i11).length() + 15 + String.valueOf(i12).length());
                sb2.append("End index: ");
                sb2.append(i11);
                sb2.append(" >= ");
                sb2.append(i12);
                throw new IndexOutOfBoundsException(sb2.toString());
            }
            StringBuilder sb3 = new StringBuilder(String.valueOf(i10).length() + 21);
            sb3.append("Beginning index: ");
            sb3.append(i10);
            sb3.append(" < 0");
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        return i13;
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i10 = this.zza;
        if (i10 == 0) {
            int zzc = zzc();
            i10 = zzg(zzc, 0, zzc);
            if (i10 == 0) {
                i10 = 1;
            }
            this.zza = i10;
        }
        return i10;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzkz(this);
    }

    public final String toString() {
        String concat;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        Integer valueOf = Integer.valueOf(zzc());
        if (zzc() <= 50) {
            concat = zzof.zza(this);
        } else {
            concat = zzof.zza(zze(0, 47)).concat("...");
        }
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", hexString, valueOf, concat);
    }

    public abstract byte zza(int i10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte zzb(int i10);

    public abstract int zzc();

    public abstract zzlg zze(int i10, int i11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzf(zzky zzkyVar) throws IOException;

    protected abstract int zzg(int i10, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzi() {
        return this.zza;
    }
}
