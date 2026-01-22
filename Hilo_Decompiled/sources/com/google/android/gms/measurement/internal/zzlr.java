package com.google.android.gms.measurement.internal;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public enum zzlr {
    GOOGLE_ANALYTICS(0),
    GOOGLE_SIGNAL(1),
    SGTM(2),
    SGTM_CLIENT(3),
    GOOGLE_SIGNAL_PENDING(4),
    UNKNOWN(99);

    private final int zzg;

    zzlr(int i10) {
        this.zzg = i10;
    }

    public static zzlr zzb(int i10) {
        for (zzlr zzlrVar : values()) {
            if (zzlrVar.zzg == i10) {
                return zzlrVar;
            }
        }
        return UNKNOWN;
    }

    public final int zza() {
        return this.zzg;
    }
}
