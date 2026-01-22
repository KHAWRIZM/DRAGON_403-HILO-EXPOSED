package com.google.android.gms.internal.play_billing;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzdu implements zzep {
    private static final zzea zza = new zzds();
    private final zzea zzb;

    public zzdu() {
        zzea zzeaVar;
        zzcm zza2 = zzcm.zza();
        try {
            zzeaVar = (zzea) Class.forName("com.google.protobuf.l").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            zzeaVar = zza;
        }
        zzdt zzdtVar = new zzdt(zza2, zzeaVar);
        byte[] bArr = zzda.zzd;
        this.zzb = zzdtVar;
    }

    private static boolean zzb(zzdz zzdzVar) {
        if (zzdzVar.zzc() - 1 != 1) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final zzeo zza(Class cls) {
        zzeq.zzr(cls);
        zzdz zzb = this.zzb.zzb(cls);
        if (zzb.zzb()) {
            if (zzcs.class.isAssignableFrom(cls)) {
                return zzeg.zzc(zzeq.zzn(), zzcg.zzb(), zzb.zza());
            }
            return zzeg.zzc(zzeq.zzm(), zzcg.zza(), zzb.zza());
        }
        if (zzcs.class.isAssignableFrom(cls)) {
            if (zzb(zzb)) {
                return zzef.zzl(cls, zzb, zzej.zzb(), zzdq.zzd(), zzeq.zzn(), zzcg.zzb(), zzdy.zzb());
            }
            return zzef.zzl(cls, zzb, zzej.zzb(), zzdq.zzd(), zzeq.zzn(), null, zzdy.zzb());
        }
        if (zzb(zzb)) {
            return zzef.zzl(cls, zzb, zzej.zza(), zzdq.zzc(), zzeq.zzm(), zzcg.zza(), zzdy.zza());
        }
        return zzef.zzl(cls, zzb, zzej.zza(), zzdq.zzc(), zzeq.zzm(), null, zzdy.zza());
    }
}
