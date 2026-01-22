package com.google.android.gms.internal.fido;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzah {
    private static final Object zza = new Object();
    private static volatile boolean zzb;
    private static volatile zzag zzc;
    private static volatile boolean zzd;
    private static volatile zzag zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza() {
        zzd = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb() {
        if (zze == null) {
            zze = new zzag(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzc() {
        if (zzc == null) {
            zzc = new zzag(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzd() {
        synchronized (zza) {
        }
        return false;
    }
}
