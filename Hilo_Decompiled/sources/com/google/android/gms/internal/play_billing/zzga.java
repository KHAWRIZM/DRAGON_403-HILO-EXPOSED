package com.google.android.gms.internal.play_billing;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzga extends zzcs implements zzed {
    private static final zzga zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;
    private zzgk zzh;

    static {
        zzga zzgaVar = new zzga();
        zzb = zzgaVar;
        zzcs.zzt(zzga.class, zzgaVar);
    }

    private zzga() {
    }

    public static zzga zzA(byte[] bArr, zzcd zzcdVar) throws zzdc {
        return (zzga) zzcs.zzm(zzb, bArr, zzcdVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzB(zzga zzgaVar, zzgk zzgkVar) {
        zzgkVar.getClass();
        zzgaVar.zzh = zzgkVar;
        zzgaVar.zzd |= 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzC(zzga zzgaVar, zzhb zzhbVar) {
        zzhbVar.getClass();
        zzgaVar.zzf = zzhbVar;
        zzgaVar.zze = 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzD(zzga zzgaVar, int i10) {
        zzgaVar.zzg = i10 - 1;
        zzgaVar.zzd |= 1;
    }

    public static zzfz zzy() {
        return (zzfz) zzb.zzg();
    }

    @Override // com.google.android.gms.internal.play_billing.zzcs
    protected final Object zzx(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 != 0) {
            if (i11 != 2) {
                if (i11 != 3) {
                    zzfy zzfyVar = null;
                    if (i11 != 4) {
                        if (i11 != 5) {
                            return null;
                        }
                        return zzb;
                    }
                    return new zzfz(zzfyVar);
                }
                return new zzga();
            }
            return zzcs.zzq(zzb, "\u0001\u0003\u0001\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0004<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzgb.zza, "zzh", zzhb.class});
        }
        return (byte) 1;
    }
}
