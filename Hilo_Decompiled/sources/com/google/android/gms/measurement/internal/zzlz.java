package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzlz implements Runnable {
    final /* synthetic */ zzma zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlz(zzma zzmaVar) {
        Objects.requireNonNull(zzmaVar);
        this.zza = zzmaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzx(null);
    }
}
