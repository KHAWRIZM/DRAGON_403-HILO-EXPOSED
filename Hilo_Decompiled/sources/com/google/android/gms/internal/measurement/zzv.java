package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzv extends zzai {
    private final zzz zza;

    public zzv(zzz zzzVar) {
        super("internal.registerCallback");
        this.zza = zzzVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzao zza(zzg zzgVar, List list) {
        int i10;
        zzh.zza(this.zzd, 3, list);
        String zzc = zzgVar.zza((zzao) list.get(0)).zzc();
        zzao zza = zzgVar.zza((zzao) list.get(1));
        if (zza instanceof zzan) {
            zzao zza2 = zzgVar.zza((zzao) list.get(2));
            if (zza2 instanceof zzal) {
                zzal zzalVar = (zzal) zza2;
                if (zzalVar.zzj("type")) {
                    String zzc2 = zzalVar.zzk("type").zzc();
                    if (zzalVar.zzj("priority")) {
                        i10 = zzh.zzg(zzalVar.zzk("priority").zzd().doubleValue());
                    } else {
                        i10 = 1000;
                    }
                    this.zza.zza(zzc, i10, (zzan) zza, zzc2);
                    return zzao.zzf;
                }
                throw new IllegalArgumentException("Undefined rule type");
            }
            throw new IllegalArgumentException("Invalid callback params");
        }
        throw new IllegalArgumentException("Invalid callback type");
    }
}
