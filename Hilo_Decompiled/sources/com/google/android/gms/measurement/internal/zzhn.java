package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzhn implements com.google.android.gms.internal.measurement.zzo {
    final /* synthetic */ String zza;
    final /* synthetic */ zzhs zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhn(zzhs zzhsVar, String str) {
        this.zza = str;
        Objects.requireNonNull(zzhsVar);
        this.zzb = zzhsVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzo
    public final String zza(String str) {
        Map map = (Map) this.zzb.zzD().get(this.zza);
        if (map != null && map.containsKey(str)) {
            return (String) map.get(str);
        }
        return null;
    }
}
