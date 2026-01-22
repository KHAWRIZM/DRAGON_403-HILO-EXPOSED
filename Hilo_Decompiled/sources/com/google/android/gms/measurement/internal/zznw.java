package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zznw implements Runnable {
    final long zza;
    final long zzb;
    final /* synthetic */ zznx zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznw(zznx zznxVar, long j10, long j11) {
        Objects.requireNonNull(zznxVar);
        this.zzc = zznxVar;
        this.zza = j10;
        this.zzb = j11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzu.zzaW().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznv
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                long zzl;
                zznw zznwVar = zznw.this;
                zzob zzobVar = zznwVar.zzc.zza;
                zzobVar.zzg();
                zzib zzibVar = zzobVar.zzu;
                zzibVar.zzaV().zzj().zza("Application going to the background");
                zzibVar.zzd().zzn.zzb(true);
                zzobVar.zzh(true);
                if (!zzibVar.zzc().zzv()) {
                    long j10 = zznwVar.zzb;
                    zznz zznzVar = zzobVar.zzb;
                    zznzVar.zzd(false, false, j10);
                    zznzVar.zzb(j10);
                }
                zzibVar.zzaV().zzi().zzb("Application backgrounded at: timestamp_millis", Long.valueOf(zznwVar.zza));
                zzib zzibVar2 = zzobVar.zzu;
                zzli zzj = zzibVar2.zzj();
                zzj.zzg();
                zzib zzibVar3 = zzj.zzu;
                zzj.zzb();
                zznk zzt = zzibVar3.zzt();
                zzt.zzg();
                zzt.zzb();
                if (!zzt.zzK() || zzt.zzu.zzk().zzah() >= 242600) {
                    zzibVar3.zzt().zzF();
                }
                if (zzibVar.zzc().zzp(null, zzfx.zzaN)) {
                    if (zzibVar.zzk().zzaa(zzibVar.zzaY().getPackageName(), zzibVar.zzc().zzz())) {
                        zzl = 1000;
                    } else {
                        zzl = zzibVar.zzc().zzl(zzibVar.zzaY().getPackageName(), zzfx.zzD);
                    }
                    zzibVar.zzaV().zzk().zzb("[sgtm] Scheduling batch upload with minimum latency in millis", Long.valueOf(zzl));
                    zzibVar2.zzx().zzh(zzl);
                }
            }
        });
    }
}
