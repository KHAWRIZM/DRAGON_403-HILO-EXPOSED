package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zznc implements zznx {
    private static final zznj zzb = new zzna();
    private final zznj zza;

    public zznc() {
        zzlz zza = zzlz.zza();
        int i10 = zznt.zza;
        zznb zznbVar = new zznb(zza, zzb);
        byte[] bArr = zzmo.zzb;
        this.zza = zznbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zznx
    public final zznw zza(Class cls) {
        zzlr zzlrVar;
        int i10 = zzny.zza;
        if (!zzme.class.isAssignableFrom(cls)) {
            int i11 = zznt.zza;
        }
        zzni zzc = this.zza.zzc(cls);
        if (!zzc.zza()) {
            int i12 = zznt.zza;
            zznq zza = zznr.zza();
            zzmx zza2 = zzmy.zza();
            zzoh zzA = zzny.zzA();
            if (zzc.zzc() - 1 != 1) {
                zzlrVar = zzlt.zza();
            } else {
                zzlrVar = null;
            }
            return zzno.zzl(cls, zzc, zza, zza2, zzA, zzlrVar, zznh.zza());
        }
        int i13 = zznt.zza;
        return zznp.zzg(zzny.zzA(), zzlt.zza(), zzc.zzb());
    }
}
