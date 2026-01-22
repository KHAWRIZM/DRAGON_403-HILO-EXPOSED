package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzbh extends zzav {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzbh() {
        this.zza.add(zzbk.ADD);
        this.zza.add(zzbk.DIVIDE);
        this.zza.add(zzbk.MODULUS);
        this.zza.add(zzbk.MULTIPLY);
        this.zza.add(zzbk.NEGATE);
        this.zza.add(zzbk.POST_DECREMENT);
        this.zza.add(zzbk.POST_INCREMENT);
        this.zza.add(zzbk.PRE_DECREMENT);
        this.zza.add(zzbk.PRE_INCREMENT);
        this.zza.add(zzbk.SUBTRACT);
    }

    @Override // com.google.android.gms.internal.measurement.zzav
    public final zzao zza(String str, zzg zzgVar, List list) {
        zzbk zzbkVar = zzbk.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 0) {
            if (ordinal != 21) {
                if (ordinal != 59) {
                    if (ordinal != 52 && ordinal != 53) {
                        if (ordinal != 55 && ordinal != 56) {
                            switch (ordinal) {
                                case 44:
                                    zzh.zza(zzbk.MODULUS.name(), 2, list);
                                    return new zzah(Double.valueOf(zzgVar.zza((zzao) list.get(0)).zzd().doubleValue() % zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()));
                                case 45:
                                    zzh.zza(zzbk.MULTIPLY.name(), 2, list);
                                    return new zzah(Double.valueOf(zzgVar.zza((zzao) list.get(0)).zzd().doubleValue() * zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()));
                                case 46:
                                    zzh.zza(zzbk.NEGATE.name(), 1, list);
                                    return new zzah(Double.valueOf(-zzgVar.zza((zzao) list.get(0)).zzd().doubleValue()));
                                default:
                                    return super.zzb(str);
                            }
                        }
                        zzh.zza(str, 1, list);
                        return zzgVar.zza((zzao) list.get(0));
                    }
                    zzh.zza(str, 2, list);
                    zzao zza = zzgVar.zza((zzao) list.get(0));
                    zzgVar.zza((zzao) list.get(1));
                    return zza;
                }
                zzh.zza(zzbk.SUBTRACT.name(), 2, list);
                return new zzah(Double.valueOf(zzgVar.zza((zzao) list.get(0)).zzd().doubleValue() + new zzah(Double.valueOf(-zzgVar.zza((zzao) list.get(1)).zzd().doubleValue())).zzd().doubleValue()));
            }
            zzh.zza(zzbk.DIVIDE.name(), 2, list);
            return new zzah(Double.valueOf(zzgVar.zza((zzao) list.get(0)).zzd().doubleValue() / zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()));
        }
        zzh.zza(zzbk.ADD.name(), 2, list);
        zzao zza2 = zzgVar.zza((zzao) list.get(0));
        zzao zza3 = zzgVar.zza((zzao) list.get(1));
        if (!(zza2 instanceof zzak) && !(zza2 instanceof zzas) && !(zza3 instanceof zzak) && !(zza3 instanceof zzas)) {
            return new zzah(Double.valueOf(zza2.zzd().doubleValue() + zza3.zzd().doubleValue()));
        }
        return new zzas(String.valueOf(zza2.zzc()).concat(String.valueOf(zza3.zzc())));
    }
}
