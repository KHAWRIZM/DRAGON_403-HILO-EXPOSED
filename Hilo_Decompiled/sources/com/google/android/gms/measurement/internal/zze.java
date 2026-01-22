package com.google.android.gms.measurement.internal;

import android.text.TextUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zze {
    private final zzjh zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(zzjh zzjhVar) {
        this.zza = zzjhVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zze zzc(String str) {
        zzjh zzjhVar;
        if (!TextUtils.isEmpty(str) && str.length() <= 1) {
            zzjhVar = zzjk.zzj(str.charAt(0));
        } else {
            zzjhVar = zzjh.UNINITIALIZED;
        }
        return new zze(zzjhVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzjh zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzb() {
        return String.valueOf(zzjk.zzm(this.zza));
    }
}
