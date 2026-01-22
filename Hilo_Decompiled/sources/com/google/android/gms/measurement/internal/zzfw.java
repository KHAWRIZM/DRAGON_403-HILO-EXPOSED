package com.google.android.gms.measurement.internal;

import androidx.annotation.GuardedBy;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzfw {
    private static final Object zze = new Object();
    private final String zza;
    private final zzbn zzb;
    private final Object zzc;
    private final Object zzd = new Object();

    @GuardedBy("overrideLock")
    private volatile Object zzf = null;

    @GuardedBy("cachingLock")
    private volatile Object zzg = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfw(String str, Object obj, Object obj2, zzbn zzbnVar, byte[] bArr) {
        this.zza = str;
        this.zzc = obj;
        this.zzb = zzbnVar;
    }

    public final String zza() {
        return this.zza;
    }

    public final Object zzb(Object obj) {
        Object obj2;
        synchronized (this.zzd) {
        }
        if (obj != null) {
            return obj;
        }
        if (zzfr.zza == null) {
            return this.zzc;
        }
        synchronized (zze) {
            try {
                if (zzae.zza()) {
                    if (this.zzg == null) {
                        obj2 = this.zzc;
                    } else {
                        obj2 = this.zzg;
                    }
                    return obj2;
                }
                try {
                    for (zzfw zzfwVar : zzfx.zzb()) {
                        if (!zzae.zza()) {
                            Object obj3 = null;
                            try {
                                zzbn zzbnVar = zzfwVar.zzb;
                                if (zzbnVar != null) {
                                    obj3 = zzbnVar.zza();
                                }
                            } catch (IllegalStateException unused) {
                            }
                            synchronized (zze) {
                                zzfwVar.zzg = obj3;
                            }
                        } else {
                            throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                        }
                    }
                } catch (SecurityException unused2) {
                }
                zzbn zzbnVar2 = this.zzb;
                if (zzbnVar2 != null) {
                    try {
                        return zzbnVar2.zza();
                    } catch (IllegalStateException | SecurityException unused3) {
                    }
                }
                return this.zzc;
            } finally {
            }
        }
    }
}
