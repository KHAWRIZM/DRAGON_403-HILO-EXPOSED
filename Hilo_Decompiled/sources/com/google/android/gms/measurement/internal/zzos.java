package com.google.android.gms.measurement.internal;

import java.util.Collections;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzos {
    private final String zza;
    private final Map zzb;
    private final zzlr zzc;
    private final com.google.android.gms.internal.measurement.zzis zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzos(String str, Map map, zzlr zzlrVar, com.google.android.gms.internal.measurement.zzis zzisVar) {
        this.zza = str;
        this.zzb = map;
        this.zzc = zzlrVar;
        this.zzd = zzisVar;
    }

    public final String zza() {
        return this.zza;
    }

    public final Map zzb() {
        Map map = this.zzb;
        if (map == null) {
            return Collections.emptyMap();
        }
        return map;
    }

    public final zzlr zzc() {
        return this.zzc;
    }

    public final com.google.android.gms.internal.measurement.zzis zzd() {
        return this.zzd;
    }
}
