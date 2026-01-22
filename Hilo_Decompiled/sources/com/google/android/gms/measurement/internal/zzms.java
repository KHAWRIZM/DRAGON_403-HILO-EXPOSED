package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzms implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzbg zzc;
    final /* synthetic */ zznk zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzms(zznk zznkVar, boolean z10, zzr zzrVar, boolean z11, zzbg zzbgVar, String str) {
        this.zza = zzrVar;
        this.zzb = z11;
        this.zzc = zzbgVar;
        Objects.requireNonNull(zznkVar);
        this.zzd = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbg zzbgVar;
        zznk zznkVar = this.zzd;
        zzga zzZ = zznkVar.zzZ();
        if (zzZ == null) {
            zznkVar.zzu.zzaV().zzb().zza("Discarding data. Failed to send event to service");
            return;
        }
        zzr zzrVar = this.zza;
        Preconditions.checkNotNull(zzrVar);
        if (this.zzb) {
            zzbgVar = null;
        } else {
            zzbgVar = this.zzc;
        }
        zznkVar.zzm(zzZ, zzbgVar, zzrVar);
        zznkVar.zzV();
    }
}
