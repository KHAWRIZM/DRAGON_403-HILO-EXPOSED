package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzjx implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzli zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjx(zzli zzliVar, boolean z10) {
        this.zza = z10;
        Objects.requireNonNull(zzliVar);
        this.zzb = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzli zzliVar = this.zzb;
        zzib zzibVar = zzliVar.zzu;
        boolean zzB = zzibVar.zzB();
        boolean zzA = zzibVar.zzA();
        boolean z10 = this.zza;
        zzibVar.zzz(z10);
        if (zzA == z10) {
            zzibVar.zzaV().zzk().zzb("Default data collection state already set to", Boolean.valueOf(z10));
        }
        if (zzibVar.zzB() == zzB || zzibVar.zzB() != zzibVar.zzA()) {
            zzibVar.zzaV().zzh().zzc("Default data collection is different than actual status", Boolean.valueOf(z10), Boolean.valueOf(zzB));
        }
        zzliVar.zzak();
    }
}
