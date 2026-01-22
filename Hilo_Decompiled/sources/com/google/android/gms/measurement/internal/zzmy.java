package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzmy implements Runnable {
    final /* synthetic */ ComponentName zza;
    final /* synthetic */ zzne zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmy(zzne zzneVar, ComponentName componentName) {
        this.zza = componentName;
        Objects.requireNonNull(zzneVar);
        this.zzb = zzneVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzW(this.zza);
    }
}
