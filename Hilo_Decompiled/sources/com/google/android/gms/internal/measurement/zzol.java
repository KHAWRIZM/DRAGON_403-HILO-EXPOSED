package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzol extends zzon {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzol(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final void zza(Object obj, long j10, byte b10) {
        if (zzoo.zzb) {
            zzoo.zzD(obj, j10, b10);
        } else {
            zzoo.zzE(obj, j10, b10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final boolean zzb(Object obj, long j10) {
        if (zzoo.zzb) {
            return zzoo.zzu(obj, j10);
        }
        return zzoo.zzv(obj, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final void zzc(Object obj, long j10, boolean z10) {
        if (zzoo.zzb) {
            zzoo.zzD(obj, j10, r3 ? (byte) 1 : (byte) 0);
        } else {
            zzoo.zzE(obj, j10, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final float zzd(Object obj, long j10) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j10));
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final void zze(Object obj, long j10, float f10) {
        this.zza.putInt(obj, j10, Float.floatToIntBits(f10));
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final double zzf(Object obj, long j10) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j10));
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final void zzg(Object obj, long j10, double d10) {
        this.zza.putLong(obj, j10, Double.doubleToLongBits(d10));
    }
}
