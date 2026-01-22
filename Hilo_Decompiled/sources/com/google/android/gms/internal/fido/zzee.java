package com.google.android.gms.internal.fido;

import java.lang.reflect.InvocationTargetException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzee {
    private static final zzeg zza;

    static {
        String[] strArr;
        strArr = zzeg.zzd;
        zza = zzb(strArr);
    }

    public static /* bridge */ /* synthetic */ zzeg zza() {
        return zza;
    }

    private static zzeg zzb(String[] strArr) {
        zzeg zzegVar;
        try {
            zzegVar = zzeh.zza();
        } catch (NoClassDefFoundError unused) {
            zzegVar = null;
        }
        if (zzegVar != null) {
            return zzegVar;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            try {
                return (zzeg) Class.forName(str).getConstructor(null).newInstance(null);
            } catch (Throwable th) {
                th = th;
                if (th instanceof InvocationTargetException) {
                    th = th.getCause();
                }
                sb.append('\n');
                sb.append(str);
                sb.append(": ");
                sb.append(th);
            }
        }
        throw new IllegalStateException(sb.insert(0, "No logging platforms found:").toString());
    }
}
