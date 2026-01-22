package com.google.android.gms.measurement.internal;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
enum zzam {
    UNSET('0'),
    REMOTE_DEFAULT('1'),
    REMOTE_DELEGATION('2'),
    MANIFEST('3'),
    INITIALIZATION('4'),
    API('5'),
    CHILD_ACCOUNT('6'),
    TCF('7'),
    REMOTE_ENFORCED_DEFAULT('8'),
    FAILSAFE('9');

    private final char zzk;

    zzam(char c10) {
        this.zzk = c10;
    }

    public static zzam zza(char c10) {
        for (zzam zzamVar : values()) {
            if (zzamVar.zzk == c10) {
                return zzamVar;
            }
        }
        return UNSET;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ char zzb() {
        return this.zzk;
    }
}
