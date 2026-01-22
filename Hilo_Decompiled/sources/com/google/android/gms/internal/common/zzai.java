package com.google.android.gms.internal.common;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzai extends zzad {
    private final zzak zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzai(zzak zzakVar, int i10) {
        super(zzakVar.size(), i10);
        this.zza = zzakVar;
    }

    @Override // com.google.android.gms.internal.common.zzad
    protected final Object zza(int i10) {
        return this.zza.get(i10);
    }
}
