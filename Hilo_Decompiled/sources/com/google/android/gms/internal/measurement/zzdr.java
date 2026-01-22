package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzdr extends zzeq {
    final /* synthetic */ Context zza;
    final /* synthetic */ Bundle zzb;
    final /* synthetic */ zzfb zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdr(zzfb zzfbVar, Context context, Bundle bundle) {
        super(zzfbVar, true);
        this.zza = context;
        this.zzb = bundle;
        Objects.requireNonNull(zzfbVar);
        this.zzc = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        boolean z10;
        boolean z11;
        try {
            Context context = this.zza;
            Preconditions.checkNotNull(context);
            String zza = com.google.android.gms.measurement.internal.zzht.zza(context);
            Preconditions.checkNotNull(context);
            Resources resources = context.getResources();
            if (TextUtils.isEmpty(zza)) {
                zza = com.google.android.gms.measurement.internal.zzht.zza(context);
            }
            Boolean zzc = com.google.android.gms.measurement.internal.zzht.zzc("google_analytics_force_disable_updates", resources, zza);
            zzfb zzfbVar = this.zzc;
            if (zzc == null || !zzc.booleanValue()) {
                z10 = true;
            } else {
                z10 = false;
            }
            zzfbVar.zzR(zzfbVar.zzc(context, z10));
            if (zzfbVar.zzQ() == null) {
                Log.w(zzfbVar.zzO(), "Failed to connect to measurement client.");
                return;
            }
            int localVersion = DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID);
            int remoteVersion = DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID);
            int max = Math.max(localVersion, remoteVersion);
            if (Boolean.TRUE.equals(zzc) || remoteVersion < localVersion) {
                z11 = true;
            } else {
                z11 = false;
            }
            ((zzcr) Preconditions.checkNotNull(zzfbVar.zzQ())).initialize(ObjectWrapper.wrap(context), new zzdd(130000L, max, z11, this.zzb, com.google.android.gms.measurement.internal.zzht.zza(context)), this.zzh);
        } catch (Exception e10) {
            this.zzc.zzN(e10, true, false);
        }
    }
}
