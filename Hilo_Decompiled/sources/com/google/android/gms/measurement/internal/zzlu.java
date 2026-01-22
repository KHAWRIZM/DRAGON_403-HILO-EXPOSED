package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzlu implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzlt zzb;
    final /* synthetic */ zzlt zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzma zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlu(zzma zzmaVar, Bundle bundle, zzlt zzltVar, zzlt zzltVar2, long j10) {
        this.zza = bundle;
        this.zzb = zzltVar;
        this.zzc = zzltVar2;
        this.zzd = j10;
        Objects.requireNonNull(zzmaVar);
        this.zze = zzmaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zzt(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
