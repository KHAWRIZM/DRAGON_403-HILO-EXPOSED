package com.google.android.gms.internal.auth;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzfo implements zzfv {
    private final zzfv[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfo(zzfv... zzfvVarArr) {
        this.zza = zzfvVarArr;
    }

    @Override // com.google.android.gms.internal.auth.zzfv
    public final zzfu zzb(Class cls) {
        zzfv[] zzfvVarArr = this.zza;
        for (int i10 = 0; i10 < 2; i10++) {
            zzfv zzfvVar = zzfvVarArr[i10];
            if (zzfvVar.zzc(cls)) {
                return zzfvVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.auth.zzfv
    public final boolean zzc(Class cls) {
        zzfv[] zzfvVarArr = this.zza;
        for (int i10 = 0; i10 < 2; i10++) {
            if (zzfvVarArr[i10].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
