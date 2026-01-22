package com.google.android.gms.internal.fido;

import java.util.Collections;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzfi {
    private static final Comparator zza = new zzfa();
    private static final Comparator zzb = new zzfb();
    private static final zzfi zzc = new zzfi(new zzfg(Collections.emptyList()));
    private final zzfg zzd;

    private zzfi(zzfg zzfgVar) {
        this.zzd = zzfgVar;
    }

    public static zzfi zza() {
        return zzc;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if ((obj instanceof zzfi) && ((zzfi) obj).zzd.equals(this.zzd)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ~this.zzd.hashCode();
    }

    public final String toString() {
        return this.zzd.toString();
    }
}
