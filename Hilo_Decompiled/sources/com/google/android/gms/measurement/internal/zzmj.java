package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzmj implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ zznk zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmj(zznk zznkVar, zzr zzrVar, boolean z10) {
        this.zza = zzrVar;
        Objects.requireNonNull(zznkVar);
        this.zzb = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznk zznkVar = this.zzb;
        zzga zzZ = zznkVar.zzZ();
        if (zzZ == null) {
            zznkVar.zzu.zzaV().zzb().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzr zzrVar = this.zza;
            Preconditions.checkNotNull(zzrVar);
            zzib zzibVar = zznkVar.zzu;
            zzal zzc = zzibVar.zzc();
            zzfw zzfwVar = zzfx.zzbc;
            if (zzc.zzp(null, zzfwVar)) {
                zznkVar.zzm(zzZ, null, zzrVar);
            }
            zzZ.zzg(zzrVar);
            zznkVar.zzu.zzm().zzo();
            zzibVar.zzc().zzp(null, zzfwVar);
            zznkVar.zzm(zzZ, null, zzrVar);
            zznkVar.zzV();
        } catch (RemoteException e10) {
            this.zzb.zzu.zzaV().zzb().zzb("Failed to send app launch to the service", e10);
        }
    }
}
