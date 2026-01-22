package com.google.android.gms.internal.fido;

import kotlin.UByte;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class zzft {
    private static final char[] zza = "0123456789abcdef".toCharArray();
    public static final /* synthetic */ int zzb = 0;

    public final boolean equals(Object obj) {
        if (obj instanceof zzft) {
            zzft zzftVar = (zzft) obj;
            if (zzb() == zzftVar.zzb() && zzc(zzftVar)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (zzb() >= 32) {
            return zza();
        }
        byte[] zze = zze();
        int i10 = zze[0] & UByte.MAX_VALUE;
        for (int i11 = 1; i11 < zze.length; i11++) {
            i10 |= (zze[i11] & UByte.MAX_VALUE) << (i11 * 8);
        }
        return i10;
    }

    public final String toString() {
        byte[] zze = zze();
        int length = zze.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (byte b10 : zze) {
            char[] cArr = zza;
            sb.append(cArr[(b10 >> 4) & 15]);
            sb.append(cArr[b10 & 15]);
        }
        return sb.toString();
    }

    public abstract int zza();

    public abstract int zzb();

    abstract boolean zzc(zzft zzftVar);

    public abstract byte[] zzd();

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] zze() {
        throw null;
    }
}
