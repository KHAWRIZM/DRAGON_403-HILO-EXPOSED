package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzjz implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzli zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjz(zzli zzliVar, long j10) {
        this.zza = j10;
        Objects.requireNonNull(zzliVar);
        this.zzb = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzib zzibVar = this.zzb.zzu;
        zzhd zzhdVar = zzibVar.zzd().zzf;
        long j10 = this.zza;
        zzhdVar.zzb(j10);
        zzibVar.zzaV().zzj().zzb("Session timeout duration set", Long.valueOf(j10));
    }
}
