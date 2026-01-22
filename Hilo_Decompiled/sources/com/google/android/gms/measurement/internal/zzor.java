package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class zzor extends zzok {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzor(zzpf zzpfVar) {
        super(zzpfVar);
        this.zzg.zzad();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzax() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzay() {
        if (zzax()) {
        } else {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzaz() {
        if (!this.zza) {
            zzbb();
            this.zzg.zzae();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    protected abstract boolean zzbb();
}
