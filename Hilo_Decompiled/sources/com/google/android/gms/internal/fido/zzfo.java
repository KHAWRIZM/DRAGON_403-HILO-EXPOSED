package com.google.android.gms.internal.fido;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzfo implements zzfn {
    @Override // com.google.android.gms.internal.fido.zzfn
    public final StackTraceElement zza(Class cls, int i10) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String name = cls.getName();
        int i11 = 3;
        boolean z10 = false;
        while (true) {
            if (i11 < stackTrace.length) {
                if (stackTrace[i11].getClassName().equals(name)) {
                    z10 = true;
                } else {
                    if (z10) {
                        break;
                    }
                    z10 = false;
                }
                i11++;
            } else {
                i11 = -1;
                break;
            }
        }
        if (i11 != -1) {
            return stackTrace[i11];
        }
        return null;
    }
}
