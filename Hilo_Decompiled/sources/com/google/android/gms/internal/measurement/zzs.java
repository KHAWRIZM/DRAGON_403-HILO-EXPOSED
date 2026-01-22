package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzs extends zzai {
    final boolean zza;
    final boolean zzb;
    final /* synthetic */ zzt zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzs(zzt zztVar, boolean z10, boolean z11) {
        super("log");
        Objects.requireNonNull(zztVar);
        this.zzc = zztVar;
        this.zza = z10;
        this.zzb = z11;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzao zza(zzg zzgVar, List list) {
        int i10;
        zzh.zzb("log", 1, list);
        if (list.size() == 1) {
            zzt zztVar = this.zzc;
            String zzc = zzgVar.zza((zzao) list.get(0)).zzc();
            boolean z10 = this.zza;
            boolean z11 = this.zzb;
            zztVar.zzb().zza(3, zzc, Collections.emptyList(), z10, z11);
            return zzao.zzf;
        }
        int zzg = zzh.zzg(zzgVar.zza((zzao) list.get(0)).zzd().doubleValue());
        if (zzg != 2) {
            if (zzg != 3) {
                if (zzg != 5) {
                    if (zzg != 6) {
                        i10 = 3;
                    } else {
                        i10 = 2;
                    }
                } else {
                    i10 = 5;
                }
            } else {
                i10 = 1;
            }
        } else {
            i10 = 4;
        }
        String zzc2 = zzgVar.zza((zzao) list.get(1)).zzc();
        if (list.size() == 2) {
            zzt zztVar2 = this.zzc;
            boolean z12 = this.zza;
            boolean z13 = this.zzb;
            zztVar2.zzb().zza(i10, zzc2, Collections.emptyList(), z12, z13);
            return zzao.zzf;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 2; i11 < Math.min(list.size(), 5); i11++) {
            arrayList.add(zzgVar.zza((zzao) list.get(i11)).zzc());
        }
        zzt zztVar3 = this.zzc;
        zztVar3.zzb().zza(i10, zzc2, arrayList, this.zza, this.zzb);
        return zzao.zzf;
    }
}
