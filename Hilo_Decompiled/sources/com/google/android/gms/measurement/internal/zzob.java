package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzob extends zzg {
    protected final zzoa zza;
    protected final zznz zzb;
    protected final zznx zzc;
    private Handler zzd;
    private boolean zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzob(zzib zzibVar) {
        super(zzibVar);
        this.zze = true;
        this.zza = new zzoa(this);
        this.zzb = new zznz(this);
        this.zzc = new zznx(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzn, reason: merged with bridge method [inline-methods] */
    public final void zzj() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new com.google.android.gms.internal.measurement.zzcn(Looper.getMainLooper());
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzh(boolean z10) {
        zzg();
        this.zze = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzi() {
        zzg();
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(long j10) {
        zzg();
        zzj();
        zzib zzibVar = this.zzu;
        zzibVar.zzaV().zzk().zzb("Activity resumed, time", Long.valueOf(j10));
        if (zzibVar.zzc().zzp(null, zzfx.zzaU)) {
            if (zzibVar.zzc().zzv() || this.zze) {
                this.zzb.zza(j10);
            }
        } else if (zzibVar.zzc().zzv() || zzibVar.zzd().zzn.zza()) {
            this.zzb.zza(j10);
        }
        this.zzc.zza();
        zzoa zzoaVar = this.zza;
        zzob zzobVar = zzoaVar.zza;
        zzobVar.zzg();
        if (!zzobVar.zzu.zzB()) {
            return;
        }
        zzoaVar.zzb(zzobVar.zzu.zzaZ().currentTimeMillis(), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(long j10) {
        zzg();
        zzj();
        zzib zzibVar = this.zzu;
        zzibVar.zzaV().zzk().zzb("Activity paused, time", Long.valueOf(j10));
        this.zzc.zzb(j10);
        if (zzibVar.zzc().zzv()) {
            this.zzb.zzb(j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Handler zzm() {
        return this.zzd;
    }
}
