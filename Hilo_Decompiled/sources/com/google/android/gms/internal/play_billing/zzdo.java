package com.google.android.gms.internal.play_billing;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzdo extends zzdq {
    private zzdo() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzdq
    public final void zza(Object obj, long j10) {
        ((zzcz) zzfp.zzf(obj, j10)).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzdq
    public final void zzb(Object obj, Object obj2, long j10) {
        zzcz zzczVar = (zzcz) zzfp.zzf(obj, j10);
        zzcz zzczVar2 = (zzcz) zzfp.zzf(obj2, j10);
        int size = zzczVar.size();
        int size2 = zzczVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzczVar.zzc()) {
                zzczVar = zzczVar.zzd(size2 + size);
            }
            zzczVar.addAll(zzczVar2);
        }
        if (size > 0) {
            zzczVar2 = zzczVar;
        }
        zzfp.zzs(obj, j10, zzczVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdo(zzdn zzdnVar) {
        super(null);
    }
}
