package com.google.android.gms.internal.auth;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzfj extends zzfl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfj(zzfi zzfiVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.auth.zzfl
    public final void zza(Object obj, long j10) {
        ((zzez) zzhj.zzf(obj, j10)).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.auth.zzfl
    public final void zzb(Object obj, Object obj2, long j10) {
        zzez zzezVar = (zzez) zzhj.zzf(obj, j10);
        zzez zzezVar2 = (zzez) zzhj.zzf(obj2, j10);
        int size = zzezVar.size();
        int size2 = zzezVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzezVar.zzc()) {
                zzezVar = zzezVar.zzd(size2 + size);
            }
            zzezVar.addAll(zzezVar2);
        }
        if (size > 0) {
            zzezVar2 = zzezVar;
        }
        zzhj.zzp(obj, j10, zzezVar2);
    }

    private zzfj() {
        super(null);
    }
}
