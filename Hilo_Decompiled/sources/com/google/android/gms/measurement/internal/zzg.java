package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class zzg extends zzf {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(zzib zzibVar) {
        super(zzibVar);
        this.zzu.zzF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzb() {
        if (zza()) {
        } else {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzc() {
        if (!this.zza) {
            if (!zze()) {
                this.zzu.zzG();
                this.zza = true;
                return;
            }
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public final void zzd() {
        if (!this.zza) {
            zzf();
            this.zzu.zzG();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    protected abstract boolean zze();

    protected void zzf() {
    }
}
