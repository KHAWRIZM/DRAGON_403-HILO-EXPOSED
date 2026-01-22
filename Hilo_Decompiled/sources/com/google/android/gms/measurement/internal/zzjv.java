package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.util.SparseArray;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzjv implements m8.a {
    final /* synthetic */ zzog zza;
    final /* synthetic */ zzli zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjv(zzli zzliVar, zzog zzogVar) {
        this.zza = zzogVar;
        Objects.requireNonNull(zzliVar);
        this.zzb = zzliVar;
    }

    private final void zza() {
        zzib zzibVar = this.zzb.zzu;
        SparseArray zzf = zzibVar.zzd().zzf();
        zzog zzogVar = this.zza;
        zzf.put(zzogVar.zzc, Long.valueOf(zzogVar.zzb));
        zzhg zzd = zzibVar.zzd();
        int[] iArr = new int[zzf.size()];
        long[] jArr = new long[zzf.size()];
        for (int i10 = 0; i10 < zzf.size(); i10++) {
            iArr[i10] = zzf.keyAt(i10);
            jArr[i10] = ((Long) zzf.valueAt(i10)).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        zzd.zzi.zzb(bundle);
    }

    @Override // m8.a
    public final void onFailure(Throwable th) {
        int i10;
        zzli zzliVar = this.zzb;
        zzliVar.zzg();
        zzliVar.zzal(false);
        zzib zzibVar = zzliVar.zzu;
        if (zzibVar.zzc().zzp(null, zzfx.zzaT)) {
            i10 = zzliVar.zzap(th);
        } else {
            i10 = 2;
        }
        int i11 = i10 - 1;
        if (i11 != 0) {
            if (i11 != 1) {
                zzibVar.zzaV().zzb().zzc("registerTriggerAsync failed. Dropping URI. App ID, Throwable", zzgt.zzl(zzliVar.zzu.zzv().zzj()), th);
                zza();
                zzliVar.zzan(1);
                zzliVar.zzz();
                return;
            }
            zzliVar.zzy().add(this.zza);
            if (zzliVar.zzam() > ((Integer) zzfx.zzaw.zzb(null)).intValue()) {
                zzliVar.zzan(1);
                zzibVar.zzaV().zze().zzc("registerTriggerAsync failed. May try later. App ID, throwable", zzgt.zzl(zzliVar.zzu.zzv().zzj()), zzgt.zzl(th.toString()));
                return;
            } else {
                zzibVar.zzaV().zze().zzd("registerTriggerAsync failed. App ID, delay in seconds, throwable", zzgt.zzl(zzliVar.zzu.zzv().zzj()), zzgt.zzl(String.valueOf(zzliVar.zzam())), zzgt.zzl(th.toString()));
                zzliVar.zzah(zzliVar.zzam());
                int zzam = zzliVar.zzam();
                zzliVar.zzan(zzam + zzam);
                return;
            }
        }
        zzibVar.zzaV().zze().zzc("registerTriggerAsync failed with retriable error. Will try later. App ID, throwable", zzgt.zzl(zzliVar.zzu.zzv().zzj()), zzgt.zzl(th.toString()));
        zzliVar.zzan(1);
        zzliVar.zzy().add(this.zza);
    }

    @Override // m8.a
    public final void onSuccess(Object obj) {
        zzli zzliVar = this.zzb;
        zzliVar.zzg();
        zza();
        zzliVar.zzal(false);
        zzliVar.zzan(1);
        zzliVar.zzu.zzaV().zzj().zzb("Successfully registered trigger URI", this.zza.zza);
        zzliVar.zzz();
    }
}
