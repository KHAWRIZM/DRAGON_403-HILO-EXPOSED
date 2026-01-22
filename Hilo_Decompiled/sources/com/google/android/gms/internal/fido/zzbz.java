package com.google.android.gms.internal.fido;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzbz extends zzbu {
    private final zzcc zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbz(zzcc zzccVar, int i10) {
        super(zzccVar.size(), i10);
        this.zza = zzccVar;
    }

    @Override // com.google.android.gms.internal.fido.zzbu
    protected final Object zza(int i10) {
        return this.zza.get(i10);
    }
}
