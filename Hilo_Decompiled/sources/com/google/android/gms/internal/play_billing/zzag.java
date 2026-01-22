package com.google.android.gms.internal.play_billing;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzag extends zzac {
    private final zzai zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzag(zzai zzaiVar, int i10) {
        super(zzaiVar.size(), i10);
        this.zza = zzaiVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzac
    protected final Object zza(int i10) {
        return this.zza.get(i10);
    }
}
