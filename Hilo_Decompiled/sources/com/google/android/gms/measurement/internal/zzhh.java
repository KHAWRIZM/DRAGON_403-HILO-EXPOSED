package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzhh implements Runnable {
    final /* synthetic */ com.google.android.gms.internal.measurement.zzbq zza;
    final /* synthetic */ ServiceConnection zzb;
    final /* synthetic */ zzhi zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhh(zzhi zzhiVar, com.google.android.gms.internal.measurement.zzbq zzbqVar, ServiceConnection serviceConnection) {
        this.zza = zzbqVar;
        this.zzb = serviceConnection;
        Objects.requireNonNull(zzhiVar);
        this.zzc = zzhiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        zzhi zzhiVar = this.zzc;
        zzhj zzhjVar = zzhiVar.zza;
        zzib zzibVar = zzhjVar.zza;
        zzibVar.zzaW().zzg();
        Bundle bundle2 = new Bundle();
        String zza = zzhiVar.zza();
        bundle2.putString("package_name", zza);
        try {
            bundle = this.zza.zze(bundle2);
        } catch (Exception e10) {
            zzhjVar.zza.zzaV().zzb().zzb("Exception occurred while retrieving the Install Referrer", e10.getMessage());
        }
        if (bundle == null) {
            zzibVar.zzaV().zzb().zza("Install Referrer Service returned a null response");
            bundle = null;
        }
        zzib zzibVar2 = zzhjVar.zza;
        zzibVar2.zzaW().zzg();
        zzib.zzL();
        if (bundle != null) {
            long j10 = bundle.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j10 == 0) {
                zzibVar2.zzaV().zze().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundle.getString("install_referrer");
                if (string != null && !string.isEmpty()) {
                    zzibVar2.zzaV().zzk().zzb("InstallReferrer API result", string);
                    Bundle zzi = zzibVar2.zzk().zzi(Uri.parse("?".concat(string)));
                    if (zzi == null) {
                        zzibVar2.zzaV().zzb().zza("No campaign params defined in Install Referrer result");
                    } else {
                        List asList = Arrays.asList(((String) zzfx.zzbh.zzb(null)).split(","));
                        Iterator<String> it = zzi.keySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (asList.contains(it.next())) {
                                long j11 = bundle.getLong("referrer_click_timestamp_server_seconds", 0L) * 1000;
                                if (j11 > 0) {
                                    zzi.putLong("click_timestamp", j11);
                                }
                            }
                        }
                        if (j10 == zzibVar2.zzd().zzd.zza()) {
                            zzibVar2.zzaV().zzk().zza("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (zzibVar2.zzB()) {
                            zzibVar2.zzd().zzd.zzb(j10);
                            zzibVar2.zzaV().zzk().zzb("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            zzi.putString("_cis", "referrer API v2");
                            zzibVar2.zzj().zzI("auto", "_cmp", zzi, zza);
                        }
                    }
                } else {
                    zzibVar2.zzaV().zzb().zza("No referrer defined in Install Referrer response");
                }
            }
        }
        ConnectionTracker.getInstance().unbindService(zzibVar2.zzaY(), this.zzb);
    }
}
