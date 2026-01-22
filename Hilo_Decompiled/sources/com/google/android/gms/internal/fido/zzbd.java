package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzbd {
    private final String zza = ",\n  ";

    private zzbd(String str) {
    }

    public static zzbd zza(String str) {
        return new zzbd(",\n  ");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence zzd(Object obj) {
        Objects.requireNonNull(obj);
        if (obj instanceof CharSequence) {
            return (CharSequence) obj;
        }
        return obj.toString();
    }

    public final StringBuilder zzc(StringBuilder sb, Iterator it) {
        try {
            if (it.hasNext()) {
                sb.append(zzd(it.next()));
                while (it.hasNext()) {
                    sb.append((CharSequence) this.zza);
                    sb.append(zzd(it.next()));
                }
            }
            return sb;
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }
}
