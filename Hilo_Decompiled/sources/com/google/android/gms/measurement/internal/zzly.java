package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzly implements Runnable {
    final /* synthetic */ zzlt zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzma zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzly(zzma zzmaVar, zzlt zzltVar, long j10) {
        this.zza = zzltVar;
        this.zzb = j10;
        Objects.requireNonNull(zzmaVar);
        this.zzc = zzmaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzma zzmaVar = this.zzc;
        zzmaVar.zzv(this.zza, false, this.zzb);
        zzmaVar.zza = null;
        zzmaVar.zzu.zzt().zzG(null);
    }
}
