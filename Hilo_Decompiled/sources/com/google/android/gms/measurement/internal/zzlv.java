package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzlv implements Runnable {
    final /* synthetic */ zzlt zza;
    final /* synthetic */ zzlt zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzma zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlv(zzma zzmaVar, zzlt zzltVar, zzlt zzltVar2, long j10, boolean z10) {
        this.zza = zzltVar;
        this.zzb = zzltVar2;
        this.zzc = j10;
        this.zzd = z10;
        Objects.requireNonNull(zzmaVar);
        this.zze = zzmaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zzu(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
