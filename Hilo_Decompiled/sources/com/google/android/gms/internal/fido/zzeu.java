package com.google.android.gms.internal.fido;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzeu extends zzei {
    private static final Set zza;
    private static final zzea zzb;
    private static final zzer zzc;
    private final String zzd;
    private final zzdn zze;
    private final Level zzf;
    private final Set zzg;
    private final zzea zzh;

    static {
        Set unmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(zzdh.zza, zzdm.zza)));
        zza = unmodifiableSet;
        zzb = zzed.zza(unmodifiableSet).zzd();
        zzc = new zzer();
    }

    public /* synthetic */ zzeu(String str, String str2, boolean z10, zzdn zzdnVar, Level level, Set set, zzea zzeaVar, zzet zzetVar) {
        super(str2);
        if (str2.length() > 23) {
            int i10 = -1;
            for (int length = str2.length() - 1; length >= 0; length--) {
                char charAt = str2.charAt(length);
                if (charAt == '.' || charAt == '$') {
                    i10 = length;
                    break;
                }
            }
            str2 = str2.substring(i10 + 1);
        }
        String concat = "".concat(String.valueOf(str2));
        this.zzd = concat.substring(0, Math.min(concat.length(), 23));
        this.zze = zzdnVar;
        this.zzf = level;
        this.zzg = set;
        this.zzh = zzeaVar;
    }

    public static zzer zzc() {
        return zzc;
    }
}
