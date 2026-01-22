package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.annotation.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzjx implements zzju {

    @GuardedBy("GservicesLoader.class")
    private static zzjx zza;
    private final Context zzb;
    private final ContentObserver zzc;

    @GuardedBy("GservicesLoader.class")
    private boolean zzd;

    private zzjx() {
        this.zzd = false;
        this.zzb = null;
        this.zzc = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjx zza(Context context) {
        zzjx zzjxVar;
        zzjx zzjxVar2;
        synchronized (zzjx.class) {
            try {
                if (zza == null) {
                    if (androidx.core.content.b.b(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                        zzjxVar2 = new zzjx(context);
                    } else {
                        zzjxVar2 = new zzjx();
                    }
                    zza = zzjxVar2;
                }
                zzjx zzjxVar3 = zza;
                if (zzjxVar3 != null && zzjxVar3.zzc != null && !zzjxVar3.zzd) {
                    try {
                        context.getContentResolver().registerContentObserver(zzjg.zza, true, zza.zzc);
                        ((zzjx) k8.h.i(zza)).zzd = true;
                    } catch (SecurityException e10) {
                        Log.e("GservicesLoader", "Unable to register Gservices content observer", e10);
                    }
                }
                zzjxVar = (zzjx) k8.h.i(zza);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzjxVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void zzc() {
        Context context;
        synchronized (zzjx.class) {
            try {
                zzjx zzjxVar = zza;
                if (zzjxVar != null && (context = zzjxVar.zzb) != null && zzjxVar.zzc != null && zzjxVar.zzd) {
                    context.getContentResolver().unregisterContentObserver(zza.zzc);
                }
                zza = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzju
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final String zze(final String str) {
        Context context = this.zzb;
        if (context != null && !zzjm.zzb(context)) {
            try {
                return (String) c.a(new zzjt() { // from class: com.google.android.gms.internal.measurement.zzjw
                    @Override // com.google.android.gms.internal.measurement.zzjt
                    public final /* synthetic */ Object zza() {
                        return zzjx.this.zzd(str);
                    }
                });
            } catch (IllegalStateException | NullPointerException | SecurityException e10) {
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(str), e10);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zzd(String str) {
        return zzjf.zza(((Context) k8.h.i(this.zzb)).getContentResolver(), str, null);
    }

    private zzjx(Context context) {
        this.zzd = false;
        this.zzb = context;
        this.zzc = new zzjv(this, null);
    }
}
