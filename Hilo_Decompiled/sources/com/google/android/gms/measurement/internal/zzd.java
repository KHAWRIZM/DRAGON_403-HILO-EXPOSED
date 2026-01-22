package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzd extends zzf {
    private final Map zza;
    private final Map zzb;
    private long zzc;

    public zzd(zzib zzibVar) {
        super(zzibVar);
        this.zzb = new androidx.collection.a();
        this.zza = new androidx.collection.a();
    }

    private final void zzh(long j10, zzlt zzltVar) {
        if (zzltVar == null) {
            this.zzu.zzaV().zzk().zza("Not logging ad exposure. No active activity");
            return;
        }
        if (j10 < 1000) {
            this.zzu.zzaV().zzk().zzb("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j10));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j10);
        zzpo.zzav(zzltVar, bundle, true);
        this.zzu.zzj().zzF("am", "_xa", bundle);
    }

    private final void zzi(String str, long j10, zzlt zzltVar) {
        if (zzltVar == null) {
            this.zzu.zzaV().zzk().zza("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j10 < 1000) {
            this.zzu.zzaV().zzk().zzb("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j10));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j10);
        zzpo.zzav(zzltVar, bundle, true);
        this.zzu.zzj().zzF("am", "_xu", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public final void zzf(long j10) {
        Map map = this.zza;
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            map.put((String) it.next(), Long.valueOf(j10));
        }
        if (!map.isEmpty()) {
            this.zzc = j10;
        }
    }

    public final void zza(String str, long j10) {
        if (str != null && str.length() != 0) {
            this.zzu.zzaW().zzj(new zza(this, str, j10));
        } else {
            this.zzu.zzaV().zzb().zza("Ad unit id must be a non-empty string");
        }
    }

    public final void zzb(String str, long j10) {
        if (str != null && str.length() != 0) {
            this.zzu.zzaW().zzj(new zzb(this, str, j10));
        } else {
            this.zzu.zzaV().zzb().zza("Ad unit id must be a non-empty string");
        }
    }

    public final void zzc(long j10) {
        zzlt zzh = this.zzu.zzs().zzh(false);
        Map map = this.zza;
        for (String str : map.keySet()) {
            zzi(str, j10 - ((Long) map.get(str)).longValue(), zzh);
        }
        if (!map.isEmpty()) {
            zzh(j10 - this.zzc, zzh);
        }
        zzf(j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(String str, long j10) {
        zzg();
        Preconditions.checkNotEmpty(str);
        Map map = this.zzb;
        if (map.isEmpty()) {
            this.zzc = j10;
        }
        Integer num = (Integer) map.get(str);
        if (num != null) {
            map.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (map.size() >= 100) {
            this.zzu.zzaV().zze().zza("Too many ads visible");
        } else {
            map.put(str, 1);
            this.zza.put(str, Long.valueOf(j10));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zze(String str, long j10) {
        zzg();
        Preconditions.checkNotEmpty(str);
        Map map = this.zzb;
        Integer num = (Integer) map.get(str);
        if (num != null) {
            zzlt zzh = this.zzu.zzs().zzh(false);
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                map.remove(str);
                Map map2 = this.zza;
                Long l10 = (Long) map2.get(str);
                if (l10 == null) {
                    this.zzu.zzaV().zzb().zza("First ad unit exposure time was never set");
                } else {
                    long longValue = j10 - l10.longValue();
                    map2.remove(str);
                    zzi(str, longValue, zzh);
                }
                if (map.isEmpty()) {
                    long j11 = this.zzc;
                    if (j11 == 0) {
                        this.zzu.zzaV().zzb().zza("First ad exposure time was never set");
                        return;
                    } else {
                        zzh(j10 - j11, zzh);
                        this.zzc = 0L;
                        return;
                    }
                }
                return;
            }
            map.put(str, Integer.valueOf(intValue));
            return;
        }
        this.zzu.zzaV().zzb().zzb("Call to endAdUnitExposure for unknown ad unit id", str);
    }
}
