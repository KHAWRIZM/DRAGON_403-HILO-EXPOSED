package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzhm implements com.google.android.gms.internal.measurement.zzr {
    final /* synthetic */ zzhs zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhm(zzhs zzhsVar) {
        Objects.requireNonNull(zzhsVar);
        this.zza = zzhsVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void zza(int i10, String str, List list, boolean z10, boolean z11) {
        zzgr zzj;
        int i11 = i10 - 1;
        if (i11 != 0) {
            if (i11 != 1) {
                if (i11 != 3) {
                    if (i11 != 4) {
                        zzj = this.zza.zzu.zzaV().zzi();
                    } else if (z10) {
                        zzj = this.zza.zzu.zzaV().zzf();
                    } else if (!z11) {
                        zzj = this.zza.zzu.zzaV().zzh();
                    } else {
                        zzj = this.zza.zzu.zzaV().zze();
                    }
                } else {
                    zzj = this.zza.zzu.zzaV().zzk();
                }
            } else if (z10) {
                zzj = this.zza.zzu.zzaV().zzc();
            } else if (!z11) {
                zzj = this.zza.zzu.zzaV().zzd();
            } else {
                zzj = this.zza.zzu.zzaV().zzb();
            }
        } else {
            zzj = this.zza.zzu.zzaV().zzj();
        }
        int size = list.size();
        if (size != 1) {
            if (size != 2) {
                if (size != 3) {
                    zzj.zza(str);
                    return;
                } else {
                    zzj.zzd(str, list.get(0), list.get(1), list.get(2));
                    return;
                }
            }
            zzj.zzc(str, list.get(0), list.get(1));
            return;
        }
        zzj.zzb(str, list.get(0));
    }
}
