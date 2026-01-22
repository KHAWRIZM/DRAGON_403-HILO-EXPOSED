package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class zzje extends zzjd {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzje(zzib zzibVar) {
        super(zzibVar);
        this.zzu.zzF();
    }

    protected abstract boolean zza();

    protected void zzba() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzv() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzw() {
        if (zzv()) {
        } else {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzx() {
        if (!this.zza) {
            if (!zza()) {
                this.zzu.zzG();
                this.zza = true;
                return;
            }
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public final void zzy() {
        if (!this.zza) {
            zzba();
            this.zzu.zzG();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
