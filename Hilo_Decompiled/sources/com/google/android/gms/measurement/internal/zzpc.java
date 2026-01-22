package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzpc {
    final String zza;
    long zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpc(zzpf zzpfVar, String str, byte[] bArr) {
        this(zzpfVar, str);
    }

    private zzpc(zzpf zzpfVar, String str) {
        Objects.requireNonNull(zzpfVar);
        this.zza = str;
        this.zzb = zzpfVar.zzaZ().elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpc(zzpf zzpfVar, byte[] bArr) {
        this(zzpfVar, zzpfVar.zzt().zzaw());
    }
}
