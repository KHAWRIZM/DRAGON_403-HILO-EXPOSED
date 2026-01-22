package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzne {
    private final zznd zza;

    private zzne(zzos zzosVar, Object obj, zzos zzosVar2, Object obj2) {
        this.zza = new zznd(zzosVar, "", zzosVar2, "");
    }

    public static zzne zza(zzos zzosVar, Object obj, zzos zzosVar2, Object obj2) {
        return new zzne(zzosVar, "", zzosVar2, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(zzll zzllVar, zznd zzndVar, Object obj, Object obj2) throws IOException {
        zzlv.zzf(zzllVar, zzndVar.zza, 1, obj);
        zzlv.zzf(zzllVar, zzndVar.zzc, 2, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(zznd zzndVar, Object obj, Object obj2) {
        return zzlv.zzh(zzndVar.zza, 1, obj) + zzlv.zzh(zzndVar.zzc, 2, obj2);
    }

    public final int zzd(int i10, Object obj, Object obj2) {
        zznd zzndVar = this.zza;
        int zzz = zzll.zzz(i10 << 3);
        int zzc = zzc(zzndVar, obj, obj2);
        return zzz + zzll.zzz(zzc) + zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zznd zze() {
        return this.zza;
    }
}
