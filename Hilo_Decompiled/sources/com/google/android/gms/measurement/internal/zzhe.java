package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzhe {
    final String zza;
    final /* synthetic */ zzhg zzb;
    private final String zzc;
    private final String zzd;
    private final long zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzhe(zzhg zzhgVar, String str, long j10, byte[] bArr) {
        boolean z10;
        Objects.requireNonNull(zzhgVar);
        this.zzb = zzhgVar;
        Preconditions.checkNotEmpty("health_monitor");
        if (j10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10);
        this.zza = "health_monitor:start";
        this.zzc = "health_monitor:count";
        this.zzd = "health_monitor:value";
        this.zze = j10;
    }

    private final void zzc() {
        zzhg zzhgVar = this.zzb;
        zzhgVar.zzg();
        long currentTimeMillis = zzhgVar.zzu.zzaZ().currentTimeMillis();
        SharedPreferences.Editor edit = zzhgVar.zzd().edit();
        edit.remove(this.zzc);
        edit.remove(this.zzd);
        edit.putLong(this.zza, currentTimeMillis);
        edit.apply();
    }

    private final long zzd() {
        return this.zzb.zzd().getLong(this.zza, 0L);
    }

    public final void zza(String str, long j10) {
        zzhg zzhgVar = this.zzb;
        zzhgVar.zzg();
        if (zzd() == 0) {
            zzc();
        }
        if (str == null) {
            str = "";
        }
        SharedPreferences zzd = zzhgVar.zzd();
        String str2 = this.zzc;
        long j11 = zzd.getLong(str2, 0L);
        if (j11 <= 0) {
            SharedPreferences.Editor edit = zzhgVar.zzd().edit();
            edit.putString(this.zzd, str);
            edit.putLong(str2, 1L);
            edit.apply();
            return;
        }
        long nextLong = zzhgVar.zzu.zzk().zzf().nextLong() & LongCompanionObject.MAX_VALUE;
        long j12 = j11 + 1;
        long j13 = LongCompanionObject.MAX_VALUE / j12;
        SharedPreferences.Editor edit2 = zzhgVar.zzd().edit();
        if (nextLong < j13) {
            edit2.putString(this.zzd, str);
        }
        edit2.putLong(str2, j12);
        edit2.apply();
    }

    public final Pair zzb() {
        long abs;
        zzhg zzhgVar = this.zzb;
        zzhgVar.zzg();
        zzhgVar.zzg();
        long zzd = zzd();
        if (zzd == 0) {
            zzc();
            abs = 0;
        } else {
            abs = Math.abs(zzd - zzhgVar.zzu.zzaZ().currentTimeMillis());
        }
        long j10 = this.zze;
        if (abs < j10) {
            return null;
        }
        if (abs > j10 + j10) {
            zzc();
            return null;
        }
        String string = zzhgVar.zzd().getString(this.zzd, null);
        long j11 = zzhgVar.zzd().getLong(this.zzc, 0L);
        zzc();
        if (string != null && j11 > 0) {
            return new Pair(string, Long.valueOf(j11));
        }
        return zzhg.zza;
    }
}
