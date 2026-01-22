package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzkw implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ Uri zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzkx zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkw(zzkx zzkxVar, boolean z10, Uri uri, String str, String str2) {
        this.zza = z10;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
        Objects.requireNonNull(zzkxVar);
        this.zze = zzkxVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e8 A[Catch: RuntimeException -> 0x00cb, TRY_LEAVE, TryCatch #2 {RuntimeException -> 0x00cb, blocks: (B:19:0x00be, B:20:0x00d6, B:21:0x00e1, B:26:0x00e8, B:30:0x0108, B:32:0x0121, B:34:0x0113, B:35:0x0125, B:37:0x012b, B:39:0x0131, B:41:0x0137, B:43:0x013d, B:45:0x0145, B:47:0x014d, B:49:0x0153, B:52:0x0158), top: B:18:0x00be }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        zzkx zzkxVar;
        zzkx zzkxVar2;
        Bundle zzi;
        Bundle zzi2;
        zzkx zzkxVar3 = this.zze;
        zzli zzliVar = zzkxVar3.zza;
        zzliVar.zzg();
        String str = this.zzd;
        Uri uri = this.zzb;
        try {
            zzib zzibVar = zzliVar.zzu;
            zzpo zzk = zzibVar.zzk();
            if (!TextUtils.isEmpty(str)) {
                if (!str.contains("gclid")) {
                    try {
                        if (!str.contains("gbraid") && !str.contains("utm_campaign") && !str.contains("utm_source") && !str.contains("utm_medium") && !str.contains("utm_id") && !str.contains("dclid") && !str.contains("srsltid") && !str.contains("sfmc_id")) {
                            zzk.zzu.zzaV().zzj().zza("Activity created with data 'referrer' without required params");
                        }
                    } catch (RuntimeException e10) {
                        e = e10;
                        zzkxVar2 = zzkxVar3;
                        zzkxVar2.zza.zzu.zzaV().zzb().zzb("Throwable caught in handleReferrerForOnActivityCreated", e);
                        return;
                    }
                }
                zzi = zzk.zzi(Uri.parse("https://google.com/search?".concat(str)));
                if (zzi != null) {
                    zzi.putString("_cis", "referrer");
                }
                String str2 = this.zzc;
                if (!this.zza && (zzi2 = zzibVar.zzk().zzi(uri)) != null) {
                    zzi2.putString("_cis", "intent");
                    if (!zzi2.containsKey("gclid") && zzi != null && zzi.containsKey("gclid")) {
                        zzkxVar = zzkxVar3;
                        try {
                            zzi2.putString("_cer", String.format("gclid=%s", zzi.getString("gclid")));
                        } catch (RuntimeException e11) {
                            e = e11;
                            zzkxVar2 = zzkxVar;
                            zzkxVar2.zza.zzu.zzaV().zzb().zzb("Throwable caught in handleReferrerForOnActivityCreated", e);
                            return;
                        }
                    }
                    zzliVar.zzF(str2, "_cmp", zzi2);
                    zzliVar.zzb.zzb(str2, zzi2);
                }
                if (TextUtils.isEmpty(str)) {
                    zzibVar.zzaV().zzj().zzb("Activity created with referrer", str);
                    if (zzibVar.zzc().zzp(null, zzfx.zzaG)) {
                        if (zzi != null) {
                            zzliVar.zzF(str2, "_cmp", zzi);
                            zzliVar.zzb.zzb(str2, zzi);
                        } else {
                            zzibVar.zzaV().zzj().zzb("Referrer does not contain valid parameters", str);
                        }
                        zzliVar.zzK("auto", "_ldl", null, true);
                        return;
                    }
                    if (str.contains("gclid") && (str.contains("utm_campaign") || str.contains("utm_source") || str.contains("utm_medium") || str.contains(DynamicLink.GoogleAnalyticsParameters.KEY_UTM_TERM) || str.contains(DynamicLink.GoogleAnalyticsParameters.KEY_UTM_CONTENT))) {
                        if (!TextUtils.isEmpty(str)) {
                            zzliVar.zzK("auto", "_ldl", str, true);
                            return;
                        }
                        return;
                    }
                    zzibVar.zzaV().zzj().zza("Activity created with data 'referrer' without required params");
                    return;
                }
                return;
            }
            zzi = null;
            String str22 = this.zzc;
            if (!this.zza) {
            }
            if (TextUtils.isEmpty(str)) {
            }
        } catch (RuntimeException e12) {
            e = e12;
            zzkxVar = zzkxVar3;
        }
    }
}
