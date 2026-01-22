package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzoa {
    final /* synthetic */ zzob zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzoa(zzob zzobVar) {
        Objects.requireNonNull(zzobVar);
        this.zza = zzobVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        zzob zzobVar = this.zza;
        zzobVar.zzg();
        zzib zzibVar = zzobVar.zzu;
        if (zzibVar.zzd().zzp(zzibVar.zzaZ().currentTimeMillis())) {
            zzibVar.zzd().zzg.zzb(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                zzibVar.zzaV().zzk().zza("Detected application was in foreground");
                zzc(zzibVar.zzaZ().currentTimeMillis(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(long j10, boolean z10) {
        zzob zzobVar = this.zza;
        zzobVar.zzg();
        zzobVar.zzj();
        zzib zzibVar = zzobVar.zzu;
        if (zzibVar.zzd().zzp(j10)) {
            zzibVar.zzd().zzg.zzb(true);
            zzobVar.zzu.zzv().zzi();
        }
        zzibVar.zzd().zzk.zzb(j10);
        if (zzibVar.zzd().zzg.zza()) {
            zzc(j10, z10);
        }
    }

    @VisibleForTesting
    final void zzc(long j10, boolean z10) {
        zzob zzobVar = this.zza;
        zzobVar.zzg();
        if (zzobVar.zzu.zzB()) {
            zzib zzibVar = zzobVar.zzu;
            zzibVar.zzd().zzk.zzb(j10);
            zzibVar.zzaV().zzk().zzb("Session started, time", Long.valueOf(zzibVar.zzaZ().elapsedRealtime()));
            long j11 = j10 / 1000;
            zzib zzibVar2 = zzobVar.zzu;
            zzibVar2.zzj().zzN("auto", "_sid", Long.valueOf(j11), j10);
            zzibVar.zzd().zzl.zzb(j11);
            zzibVar.zzd().zzg.zzb(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j11);
            zzibVar2.zzj().zzG("auto", "_s", j10, bundle);
            String zza = zzibVar.zzd().zzq.zza();
            if (!TextUtils.isEmpty(zza)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", zza);
                zzibVar2.zzj().zzG("auto", "_ssr", j10, bundle2);
            }
        }
    }
}
