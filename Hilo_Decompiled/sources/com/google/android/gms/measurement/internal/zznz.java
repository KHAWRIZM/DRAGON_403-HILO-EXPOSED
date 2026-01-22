package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zznz {

    @VisibleForTesting
    protected long zza;

    @VisibleForTesting
    protected long zzb;
    final /* synthetic */ zzob zzc;
    private final zzay zzd;

    public zznz(zzob zzobVar) {
        Objects.requireNonNull(zzobVar);
        this.zzc = zzobVar;
        this.zzd = new zzny(this, zzobVar.zzu);
        long elapsedRealtime = zzobVar.zzu.zzaZ().elapsedRealtime();
        this.zza = elapsedRealtime;
        this.zzb = elapsedRealtime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(long j10) {
        this.zzc.zzg();
        this.zzd.zzd();
        this.zza = j10;
        this.zzb = j10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(long j10) {
        this.zzd.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc() {
        this.zzd.zzd();
        long elapsedRealtime = this.zzc.zzu.zzaZ().elapsedRealtime();
        this.zza = elapsedRealtime;
        this.zzb = elapsedRealtime;
    }

    public final boolean zzd(boolean z10, boolean z11, long j10) {
        zzob zzobVar = this.zzc;
        zzobVar.zzg();
        zzobVar.zzb();
        if (zzobVar.zzu.zzB()) {
            zzib zzibVar = zzobVar.zzu;
            zzibVar.zzd().zzk.zzb(zzibVar.zzaZ().currentTimeMillis());
        }
        long j11 = j10 - this.zza;
        if (!z10 && j11 < 1000) {
            zzobVar.zzu.zzaV().zzk().zzb("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j11));
            return false;
        }
        if (!z11) {
            j11 = j10 - this.zzb;
            this.zzb = j10;
        }
        zzib zzibVar2 = zzobVar.zzu;
        zzibVar2.zzaV().zzk().zzb("Recording user engagement, ms", Long.valueOf(j11));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j11);
        boolean z12 = !zzibVar2.zzc().zzv();
        zzib zzibVar3 = zzobVar.zzu;
        zzpo.zzav(zzibVar3.zzs().zzh(z12), bundle, true);
        if (!z11) {
            zzibVar3.zzj().zzF("auto", "_e", bundle);
        }
        this.zza = j10;
        zzay zzayVar = this.zzd;
        zzayVar.zzd();
        zzayVar.zzb(((Long) zzfx.zzaq.zzb(null)).longValue());
        return true;
    }
}
