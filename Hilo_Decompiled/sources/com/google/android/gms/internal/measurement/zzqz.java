package com.google.android.gms.internal.measurement;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzqz implements zzqy {
    public static final zzkl zza;

    static {
        zzkf zzb = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zza = zzb.zzd("measurement.client.sessions.enable_fix_background_engagement", false);
        zzb.zzd("measurement.client.sessions.enable_pause_engagement_in_background", true);
        zzb.zzc("measurement.id.client.sessions.enable_fix_background_engagement", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzqy
    public final boolean zza() {
        return ((Boolean) zza.zzd()).booleanValue();
    }
}
