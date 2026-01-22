package com.google.android.gms.internal.fido;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzfj {
    private static final String[] zza = {"com.google.common.flogger.util.StackWalkerStackGetter", "com.google.common.flogger.util.JavaLangAccessStackGetter"};
    private static final zzfn zzb;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.fido.zzfn] */
    static {
        zzfo zzfoVar;
        int i10 = 0;
        while (true) {
            if (i10 < 2) {
                zzfoVar = null;
                try {
                    zzfoVar = (zzfn) Class.forName(zza[i10]).asSubclass(zzfn.class).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable unused) {
                }
                if (zzfoVar != null) {
                    break;
                } else {
                    i10++;
                }
            } else {
                zzfoVar = new zzfo();
                break;
            }
        }
        zzb = zzfoVar;
    }

    @NullableDecl
    public static StackTraceElement zza(Class cls, int i10) {
        zzfk.zza(cls, "target");
        return zzb.zza(cls, 2);
    }
}
