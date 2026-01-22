package com.google.android.gms.internal.measurement;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zznb implements zznj {
    private final zznj[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznb(zznj... zznjVarArr) {
        this.zza = zznjVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zznj
    public final boolean zzb(Class cls) {
        for (int i10 = 0; i10 < 2; i10++) {
            if (this.zza[i10].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zznj
    public final zzni zzc(Class cls) {
        for (int i10 = 0; i10 < 2; i10++) {
            zznj zznjVar = this.zza[i10];
            if (zznjVar.zzb(cls)) {
                return zznjVar.zzc(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }
}
