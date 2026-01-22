package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.common.zzak;
import java.util.HashMap;

@ShowFirstParty
@KeepForSdk
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class GmsSignatureVerifier {
    private static final zzaa zza;
    private static final zzaa zzb;
    private static final HashMap zzc;

    static {
        zzy zzyVar = new zzy();
        zzyVar.zzd("com.google.android.gms");
        zzyVar.zza(204200000L);
        zzl zzlVar = zzn.zzd;
        zzyVar.zzc(zzak.zzn(zzlVar.zzf(), zzn.zzb.zzf()));
        zzl zzlVar2 = zzn.zzc;
        zzyVar.zzb(zzak.zzn(zzlVar2.zzf(), zzn.zza.zzf()));
        zza = zzyVar.zze();
        zzy zzyVar2 = new zzy();
        zzyVar2.zzd("com.android.vending");
        zzyVar2.zza(82240000L);
        zzyVar2.zzc(zzak.zzm(zzlVar.zzf()));
        zzyVar2.zzb(zzak.zzm(zzlVar2.zzf()));
        zzb = zzyVar2.zze();
        zzc = new HashMap();
    }
}
