package com.google.android.gms.internal.measurement;

import android.net.Uri;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzkf {
    final Uri zza;
    final String zzb;
    final String zzc;
    final boolean zzd;
    final boolean zze;

    private zzkf(String str, Uri uri, String str2, String str3, boolean z10, boolean z11, boolean z12, boolean z13, k8.c cVar) {
        this.zza = uri;
        this.zzb = "";
        this.zzc = "";
        this.zzd = z10;
        this.zze = z12;
    }

    public final zzkf zza() {
        String str = this.zzb;
        if (str.isEmpty()) {
            return new zzkf(null, this.zza, str, this.zzc, true, false, this.zze, false, null);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final zzkf zzb() {
        return new zzkf(null, this.zza, this.zzb, this.zzc, this.zzd, false, true, false, null);
    }

    public final zzkl zzc(String str, long j10) {
        Long valueOf = Long.valueOf(j10);
        int i10 = zzkl.zzc;
        return new zzkb(this, str, valueOf, true);
    }

    public final zzkl zzd(String str, boolean z10) {
        Boolean valueOf = Boolean.valueOf(z10);
        int i10 = zzkl.zzc;
        return new zzkc(this, str, valueOf, true);
    }

    public final zzkl zze(String str, double d10) {
        Double valueOf = Double.valueOf(-3.0d);
        int i10 = zzkl.zzc;
        return new zzkd(this, "measurement.test.double_flag", valueOf, true);
    }

    public final zzkl zzf(String str, String str2) {
        int i10 = zzkl.zzc;
        return new zzke(this, str, str2, true);
    }

    public zzkf(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }
}
