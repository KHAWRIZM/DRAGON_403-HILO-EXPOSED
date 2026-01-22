package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzmn implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzbe zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ zznk zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmn(zznk zznkVar, boolean z10, zzr zzrVar, boolean z11, zzbe zzbeVar, Bundle bundle) {
        this.zza = zzrVar;
        this.zzb = z11;
        this.zzc = zzbeVar;
        this.zzd = bundle;
        Objects.requireNonNull(zznkVar);
        this.zze = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznk zznkVar = this.zze;
        zzga zzZ = zznkVar.zzZ();
        if (zzZ == null) {
            zznkVar.zzu.zzaV().zzb().zza("Failed to send default event parameters to service");
            return;
        }
        zzbe zzbeVar = null;
        if (zznkVar.zzu.zzc().zzp(null, zzfx.zzbc)) {
            zzr zzrVar = this.zza;
            Preconditions.checkNotNull(zzrVar);
            zznk zznkVar2 = this.zze;
            if (!this.zzb) {
                zzbeVar = this.zzc;
            }
            zznkVar2.zzm(zzZ, zzbeVar, zzrVar);
            return;
        }
        try {
            zzr zzrVar2 = this.zza;
            Preconditions.checkNotNull(zzrVar2);
            zzZ.zzu(this.zzd, zzrVar2);
            zznkVar.zzV();
        } catch (RemoteException e10) {
            this.zze.zzu.zzaV().zzb().zzb("Failed to send default event parameters to service", e10);
        }
    }
}
