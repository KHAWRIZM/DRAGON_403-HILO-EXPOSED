package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzlx implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzma zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlx(zzma zzmaVar, long j10) {
        this.zza = j10;
        Objects.requireNonNull(zzmaVar);
        this.zzb = zzmaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzma zzmaVar = this.zzb;
        zzmaVar.zzu.zzw().zzc(this.zza);
        zzmaVar.zza = null;
    }
}
