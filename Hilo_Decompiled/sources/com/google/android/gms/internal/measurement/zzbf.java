package com.google.android.gms.internal.measurement;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzbf implements zzbe {
    private final zzg zza;
    private final String zzb;

    public zzbf(zzg zzgVar, String str) {
        this.zza = zzgVar;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzbe
    public final zzg zza(zzao zzaoVar) {
        zzg zzgVar = this.zza;
        zzgVar.zzf(this.zzb, zzaoVar);
        return zzgVar;
    }
}
