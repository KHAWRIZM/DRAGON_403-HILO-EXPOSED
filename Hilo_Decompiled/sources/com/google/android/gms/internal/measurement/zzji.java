package com.google.android.gms.internal.measurement;

import androidx.annotation.GuardedBy;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzji {

    @GuardedBy("GservicesDelegateSupplier.class")
    private static zzjh zza;

    public static synchronized void zza(zzjh zzjhVar) {
        synchronized (zzji.class) {
            if (zza == null) {
                zza = zzjhVar;
            } else {
                throw new IllegalStateException("init() already called");
            }
        }
    }

    public static synchronized zzjh zzb() {
        zzjh zzjhVar;
        synchronized (zzji.class) {
            try {
                if (zza == null) {
                    zza(new zzjl());
                }
                zzjhVar = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzjhVar;
    }
}
