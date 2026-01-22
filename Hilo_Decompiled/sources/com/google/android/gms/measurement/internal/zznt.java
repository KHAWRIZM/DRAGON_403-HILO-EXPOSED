package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zznt implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzob zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznt(zzob zzobVar, long j10) {
        this.zza = j10;
        Objects.requireNonNull(zzobVar);
        this.zzb = zzobVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzk(this.zza);
    }
}
