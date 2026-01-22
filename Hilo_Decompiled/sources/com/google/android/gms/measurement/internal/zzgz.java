package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzgz implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzha zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgz(zzha zzhaVar, boolean z10) {
        this.zza = z10;
        Objects.requireNonNull(zzhaVar);
        this.zzb = zzhaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc().zzar(this.zza);
    }
}
