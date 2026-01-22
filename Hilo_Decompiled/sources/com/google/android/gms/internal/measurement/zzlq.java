package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzlq {
    static final zzlq zza = new zzlq(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc;
    private static volatile zzlq zzd;
    private final Map zze;

    zzlq() {
        this.zze = new HashMap();
    }

    public static zzlq zza() {
        zzlq zzlqVar = zzd;
        if (zzlqVar != null) {
            return zzlqVar;
        }
        synchronized (zzlq.class) {
            try {
                zzlq zzlqVar2 = zzd;
                if (zzlqVar2 != null) {
                    return zzlqVar2;
                }
                int i10 = zznt.zza;
                zzlq zzb2 = zzly.zzb(zzlq.class);
                zzd = zzb2;
                return zzb2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzmd zzb(zznl zznlVar, int i10) {
        return (zzmd) this.zze.get(new zzlp(zznlVar, i10));
    }

    zzlq(boolean z10) {
        this.zze = Collections.emptyMap();
    }
}
