package com.google.android.gms.measurement.internal;

import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.internal.measurement.zzpq;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzac extends zzab {
    final /* synthetic */ zzad zza;
    private final com.google.android.gms.internal.measurement.zzfn zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzac(zzad zzadVar, String str, int i10, com.google.android.gms.internal.measurement.zzfn zzfnVar) {
        super(str, i10);
        Objects.requireNonNull(zzadVar);
        this.zza = zzadVar;
        this.zzh = zzfnVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzab
    public final int zza() {
        return this.zzh.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzab
    public final boolean zzb() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzab
    public final boolean zzc() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzd(Long l10, Long l11, com.google.android.gms.internal.measurement.zziu zziuVar, boolean z10) {
        boolean z11;
        Object obj;
        zzpq.zza();
        zzib zzibVar = this.zza.zzu;
        boolean zzp = zzibVar.zzc().zzp(this.zzb, zzfx.zzaD);
        com.google.android.gms.internal.measurement.zzfn zzfnVar = this.zzh;
        boolean zze = zzfnVar.zze();
        boolean zzf = zzfnVar.zzf();
        boolean zzh = zzfnVar.zzh();
        if (zze || zzf || zzh) {
            z11 = true;
        } else {
            z11 = false;
        }
        Boolean bool = null;
        Integer num = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        if (z10 && !z11) {
            zzgr zzk = zzibVar.zzaV().zzk();
            Integer valueOf = Integer.valueOf(this.zzc);
            if (zzfnVar.zza()) {
                num = Integer.valueOf(zzfnVar.zzb());
            }
            zzk.zzc("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", valueOf, num);
            return true;
        }
        com.google.android.gms.internal.measurement.zzfh zzd = zzfnVar.zzd();
        boolean zzf2 = zzd.zzf();
        if (zziuVar.zzf()) {
            if (!zzd.zzc()) {
                zzibVar.zzaV().zze().zzb("No number filter for long property. property", zzibVar.zzl().zzc(zziuVar.zzc()));
            } else {
                bool = zzab.zze(zzab.zzg(zziuVar.zzg(), zzd.zzd()), zzf2);
            }
        } else if (zziuVar.zzj()) {
            if (!zzd.zzc()) {
                zzibVar.zzaV().zze().zzb("No number filter for double property. property", zzibVar.zzl().zzc(zziuVar.zzc()));
            } else {
                bool = zzab.zze(zzab.zzh(zziuVar.zzk(), zzd.zzd()), zzf2);
            }
        } else if (zziuVar.zzd()) {
            if (!zzd.zza()) {
                if (!zzd.zzc()) {
                    zzibVar.zzaV().zze().zzb("No string or number filter defined. property", zzibVar.zzl().zzc(zziuVar.zzc()));
                } else if (zzpj.zzm(zziuVar.zze())) {
                    bool = zzab.zze(zzab.zzi(zziuVar.zze(), zzd.zzd()), zzf2);
                } else {
                    zzibVar.zzaV().zze().zzc("Invalid user property value for Numeric number filter. property, value", zzibVar.zzl().zzc(zziuVar.zzc()), zziuVar.zze());
                }
            } else {
                bool = zzab.zze(zzab.zzf(zziuVar.zze(), zzd.zzb(), zzibVar.zzaV()), zzf2);
            }
        } else {
            zzibVar.zzaV().zze().zzb("User property has no value, property", zzibVar.zzl().zzc(zziuVar.zzc()));
        }
        zzgr zzk2 = zzibVar.zzaV().zzk();
        if (bool == null) {
            obj = Constants.NULL_VERSION_ID;
        } else {
            obj = bool;
        }
        zzk2.zzb("Property filter result", obj);
        if (bool == null) {
            return false;
        }
        this.zzd = Boolean.TRUE;
        if (zzh && !bool.booleanValue()) {
            return true;
        }
        if (!z10 || zzfnVar.zze()) {
            this.zze = bool;
        }
        if (bool.booleanValue() && z11 && zziuVar.zza()) {
            long zzb = zziuVar.zzb();
            if (l10 != null) {
                zzb = l10.longValue();
            }
            if (zzp && zzfnVar.zze() && !zzfnVar.zzf() && l11 != null) {
                zzb = l11.longValue();
            }
            if (zzfnVar.zzf()) {
                this.zzg = Long.valueOf(zzb);
            } else {
                this.zzf = Long.valueOf(zzb);
            }
        }
        return true;
    }
}
