package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzbb {
    final String zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final zzbe zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbb(zzib zzibVar, String str, String str2, String str3, long j10, long j11, Bundle bundle) {
        zzbe zzbeVar;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = true == TextUtils.isEmpty(str) ? null : str;
        this.zzd = j10;
        this.zze = j11;
        if (j11 != 0 && j11 > j10) {
            zzibVar.zzaV().zze().zzb("Event created with reverse previous/current timestamps. appId", zzgt.zzl(str2));
        }
        if (bundle != null && !bundle.isEmpty()) {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzibVar.zzaV().zzb().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object zzE = zzibVar.zzk().zzE(next, bundle2.get(next));
                    if (zzE == null) {
                        zzibVar.zzaV().zze().zzb("Param value can't be null", zzibVar.zzl().zzb(next));
                        it.remove();
                    } else {
                        zzibVar.zzk().zzM(bundle2, next, zzE);
                    }
                }
            }
            zzbeVar = new zzbe(bundle2);
        } else {
            zzbeVar = new zzbe(new Bundle());
        }
        this.zzf = zzbeVar;
    }

    public final String toString() {
        String obj = this.zzf.toString();
        String str = this.zza;
        int length = String.valueOf(str).length();
        String str2 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 22 + String.valueOf(str2).length() + 10 + obj.length() + 1);
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(obj);
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbb zza(zzib zzibVar, long j10) {
        return new zzbb(zzibVar, this.zzc, this.zza, this.zzb, this.zzd, j10, this.zzf);
    }

    private zzbb(zzib zzibVar, String str, String str2, String str3, long j10, long j11, zzbe zzbeVar) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzbeVar);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = true == TextUtils.isEmpty(str) ? null : str;
        this.zzd = j10;
        this.zze = j11;
        if (j11 != 0 && j11 > j10) {
            zzibVar.zzaV().zze().zzc("Event created with reverse previous/current timestamps. appId, name", zzgt.zzl(str2), zzgt.zzl(str3));
        }
        this.zzf = zzbeVar;
    }
}
