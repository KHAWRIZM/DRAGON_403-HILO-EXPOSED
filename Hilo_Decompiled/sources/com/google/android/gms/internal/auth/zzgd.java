package com.google.android.gms.internal.auth;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzgd {
    private static final zzgc zza;
    private static final zzgc zzb;

    static {
        zzgc zzgcVar = null;
        try {
            zzgcVar = (zzgc) Class.forName("com.google.protobuf.m1").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zza = zzgcVar;
        zzb = new zzgc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgc zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgc zzb() {
        return zzb;
    }
}
