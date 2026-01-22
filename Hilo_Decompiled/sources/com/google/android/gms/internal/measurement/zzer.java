package com.google.android.gms.internal.measurement;

import android.os.Bundle;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzer extends zzcz {
    private final com.google.android.gms.measurement.internal.zzjo zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzer(com.google.android.gms.measurement.internal.zzjo zzjoVar) {
        this.zza = zzjoVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzda
    public final void zze(String str, String str2, Bundle bundle, long j10) {
        this.zza.interceptEvent(str, str2, bundle, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzda
    public final int zzf() {
        return System.identityHashCode(this.zza);
    }
}
