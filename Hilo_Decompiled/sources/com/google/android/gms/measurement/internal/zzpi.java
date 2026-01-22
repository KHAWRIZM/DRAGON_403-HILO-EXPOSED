package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzpi {
    private final long zza;
    private final com.google.android.gms.internal.measurement.zzib zzb;
    private final String zzc;
    private final Map zzd;
    private final zzlr zze;
    private final long zzf;
    private final long zzg;
    private final long zzh;
    private final int zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpi(long j10, com.google.android.gms.internal.measurement.zzib zzibVar, String str, Map map, zzlr zzlrVar, long j11, long j12, long j13, int i10, byte[] bArr) {
        this.zza = j10;
        this.zzb = zzibVar;
        this.zzc = str;
        this.zzd = map;
        this.zze = zzlrVar;
        this.zzf = j11;
        this.zzg = j12;
        this.zzh = j13;
        this.zzi = i10;
    }

    public final zzos zza() {
        return new zzos(this.zzc, this.zzd, this.zze, null);
    }

    public final zzol zzb() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.zzd.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        long j10 = this.zza;
        com.google.android.gms.internal.measurement.zzib zzibVar = this.zzb;
        String str = this.zzc;
        zzlr zzlrVar = this.zze;
        return new zzol(j10, zzibVar.zzcc(), str, bundle, zzlrVar.zza(), this.zzg, "");
    }

    public final long zzc() {
        return this.zza;
    }

    public final com.google.android.gms.internal.measurement.zzib zzd() {
        return this.zzb;
    }

    public final String zze() {
        return this.zzc;
    }

    public final zzlr zzf() {
        return this.zze;
    }

    public final long zzg() {
        return this.zzf;
    }

    public final long zzh() {
        return this.zzh;
    }

    public final int zzi() {
        return this.zzi;
    }
}
