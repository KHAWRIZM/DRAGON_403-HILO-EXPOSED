package com.google.android.gms.internal.play_billing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzcd {
    static final zzcd zza = new zzcd(true);
    private static volatile boolean zzb;
    private static volatile zzcd zzc;
    private final Map zzd;

    zzcd() {
        this.zzd = new HashMap();
    }

    public static zzcd zza() {
        zzcd zzcdVar = zzc;
        if (zzcdVar != null) {
            return zzcdVar;
        }
        synchronized (zzcd.class) {
            try {
                zzcd zzcdVar2 = zzc;
                if (zzcdVar2 != null) {
                    return zzcdVar2;
                }
                zzcd zzb2 = zzcl.zzb(zzcd.class);
                zzc = zzb2;
                return zzb2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzcq zzb(zzec zzecVar, int i10) {
        return (zzcq) this.zzd.get(new zzcc(zzecVar, i10));
    }

    zzcd(boolean z10) {
        this.zzd = Collections.emptyMap();
    }
}
