package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zznd implements Runnable {
    final /* synthetic */ ConnectionResult zza;
    final /* synthetic */ zzne zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznd(zzne zzneVar, ConnectionResult connectionResult) {
        this.zza = connectionResult;
        Objects.requireNonNull(zzneVar);
        this.zzb = zzneVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznk zznkVar = this.zzb.zza;
        zznkVar.zzaa(null);
        if (this.zza.getErrorCode() == 7777) {
            if (zznkVar.zzab() == null) {
                zznkVar.zzac(Executors.newScheduledThreadPool(1));
            }
            zznkVar.zzab().schedule(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznb
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    final zznk zznkVar2 = zznd.this.zzb.zza;
                    zznkVar2.zzu.zzaW().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznc
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zznk.this.zzI();
                        }
                    });
                }
            }, ((Long) zzfx.zzZ.zzb(null)).longValue(), TimeUnit.MILLISECONDS);
            return;
        }
        zznkVar.zzX();
    }
}
