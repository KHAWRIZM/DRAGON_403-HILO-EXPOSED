package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zznx {
    final /* synthetic */ zzob zza;
    private zznw zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznx(zzob zzobVar) {
        Objects.requireNonNull(zzobVar);
        this.zza = zzobVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        zzob zzobVar = this.zza;
        zzobVar.zzg();
        zznw zznwVar = this.zzb;
        if (zznwVar != null) {
            zzobVar.zzm().removeCallbacks(zznwVar);
        }
        zzib zzibVar = zzobVar.zzu;
        zzibVar.zzd().zzn.zzb(false);
        zzobVar.zzh(false);
        if (zzibVar.zzc().zzp(null, zzfx.zzaT)) {
            zzib zzibVar2 = zzobVar.zzu;
            if (zzibVar2.zzj().zzx()) {
                zzibVar.zzaV().zzk().zza("Retrying trigger URI registration in foreground");
                zzibVar2.zzj().zzz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(long j10) {
        zzob zzobVar = this.zza;
        this.zzb = new zznw(this, zzobVar.zzu.zzaZ().currentTimeMillis(), j10);
        zzobVar.zzm().postDelayed(this.zzb, 2000L);
    }
}
