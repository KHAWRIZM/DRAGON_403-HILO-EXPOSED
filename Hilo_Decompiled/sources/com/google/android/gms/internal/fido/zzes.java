package com.google.android.gms.internal.fido;

import java.util.Set;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzes extends zzei {
    private final zzdn zza;
    private final Level zzb;
    private final Set zzc;
    private final zzea zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzes(String str, @NullableDecl String str2, boolean z10, zzdn zzdnVar, boolean z11, boolean z12) {
        super(str2);
        Set set;
        zzea zzeaVar;
        Level level = Level.ALL;
        set = zzeu.zza;
        zzeaVar = zzeu.zzb;
        this.zza = zzdnVar;
        this.zzb = level;
        this.zzc = set;
        this.zzd = zzeaVar;
    }
}
