package com.google.android.gms.measurement.internal;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzpd {
    private final zzpf zza;
    private int zzb = 1;
    private long zzc = zzd();

    public zzpd(zzpf zzpfVar) {
        this.zza = zzpfVar;
    }

    private final long zzd() {
        zzpf zzpfVar = this.zza;
        Preconditions.checkNotNull(zzpfVar);
        long longValue = ((Long) zzfx.zzu.zzb(null)).longValue();
        long longValue2 = ((Long) zzfx.zzv.zzb(null)).longValue();
        for (int i10 = 1; i10 < this.zzb; i10++) {
            longValue += longValue;
            if (longValue >= longValue2) {
                break;
            }
        }
        return zzpfVar.zzaZ().currentTimeMillis() + Math.min(longValue, longValue2);
    }

    public final void zza() {
        this.zzb++;
        this.zzc = zzd();
    }

    public final boolean zzb() {
        if (this.zza.zzaZ().currentTimeMillis() >= this.zzc) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ long zzc() {
        return this.zzc;
    }
}
