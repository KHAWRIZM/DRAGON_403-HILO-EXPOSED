package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzbb extends zzav {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzbb() {
        this.zza.add(zzbk.AND);
        this.zza.add(zzbk.NOT);
        this.zza.add(zzbk.OR);
    }

    @Override // com.google.android.gms.internal.measurement.zzav
    public final zzao zza(String str, zzg zzgVar, List list) {
        zzbk zzbkVar = zzbk.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 1) {
            if (ordinal != 47) {
                if (ordinal != 50) {
                    return super.zzb(str);
                }
                zzh.zza(zzbk.OR.name(), 2, list);
                zzao zza = zzgVar.zza((zzao) list.get(0));
                if (!zza.zze().booleanValue()) {
                    return zzgVar.zza((zzao) list.get(1));
                }
                return zza;
            }
            zzh.zza(zzbk.NOT.name(), 1, list);
            return new zzaf(Boolean.valueOf(!zzgVar.zza((zzao) list.get(0)).zze().booleanValue()));
        }
        zzh.zza(zzbk.AND.name(), 2, list);
        zzao zza2 = zzgVar.zza((zzao) list.get(0));
        if (zza2.zze().booleanValue()) {
            return zzgVar.zza((zzao) list.get(1));
        }
        return zza2;
    }
}
