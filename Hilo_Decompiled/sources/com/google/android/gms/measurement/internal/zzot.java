package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzot extends zzok {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzot(zzpf zzpfVar) {
        super(zzpfVar);
    }

    private final String zzd(String str) {
        String zzc = this.zzg.zzh().zzc(str);
        if (!TextUtils.isEmpty(zzc)) {
            Uri parse = Uri.parse((String) zzfx.zzq.zzb(null));
            Uri.Builder buildUpon = parse.buildUpon();
            String authority = parse.getAuthority();
            StringBuilder sb = new StringBuilder(String.valueOf(zzc).length() + 1 + String.valueOf(authority).length());
            sb.append(zzc);
            sb.append(InstructionFileId.DOT);
            sb.append(authority);
            buildUpon.authority(sb.toString());
            return buildUpon.build().toString();
        }
        return (String) zzfx.zzq.zzb(null);
    }

    private static final boolean zzf(String str) {
        String str2 = (String) zzfx.zzs.zzb(null);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        for (String str3 : str2.split(",")) {
            if (str.equalsIgnoreCase(str3.trim())) {
                return true;
            }
        }
        return false;
    }

    public final zzos zza(String str) {
        zzh zzu;
        zzpf zzpfVar = this.zzg;
        zzh zzu2 = zzpfVar.zzj().zzu(str);
        zzos zzosVar = null;
        if (zzu2 != null && zzu2.zzai()) {
            com.google.android.gms.internal.measurement.zzil zzb = com.google.android.gms.internal.measurement.zzis.zzb();
            zzb.zzb(2);
            zzb.zza((com.google.android.gms.internal.measurement.zzin) Preconditions.checkNotNull(com.google.android.gms.internal.measurement.zzin.zzb(zzu2.zzaL())));
            String zzd = zzu2.zzd();
            com.google.android.gms.internal.measurement.zzgl zzb2 = zzpfVar.zzh().zzb(str);
            if (zzb2 != null && (zzu = zzpfVar.zzj().zzu(str)) != null && ((zzb2.zzp() && zzb2.zzq().zzc() == 100) || this.zzu.zzk().zzaa(str, zzu.zzay()) || (!TextUtils.isEmpty(zzd) && Math.abs(zzd.hashCode() % 100) < zzb2.zzq().zzc()))) {
                String zzc = zzu2.zzc();
                zzb.zzb(2);
                com.google.android.gms.internal.measurement.zzgl zzb3 = zzpfVar.zzh().zzb(zzu2.zzc());
                if (zzb3 != null && zzb3.zzp()) {
                    HashMap hashMap = new HashMap();
                    if (!TextUtils.isEmpty(zzu2.zzay())) {
                        hashMap.put("x-gtm-server-preview", zzu2.zzay());
                    }
                    String zzd2 = zzb3.zzq().zzd();
                    com.google.android.gms.internal.measurement.zzin zzb4 = com.google.android.gms.internal.measurement.zzin.zzb(zzu2.zzaL());
                    if (zzb4 != null && zzb4 != com.google.android.gms.internal.measurement.zzin.CLIENT_UPLOAD_ELIGIBLE) {
                        zzb.zza(zzb4);
                    } else if (zzf(zzu2.zzc())) {
                        zzb.zza(com.google.android.gms.internal.measurement.zzin.PINNED_TO_SERVICE_UPLOAD);
                    } else if (TextUtils.isEmpty(zzd2)) {
                        zzb.zza(com.google.android.gms.internal.measurement.zzin.MISSING_SGTM_SERVER_URL);
                    } else {
                        this.zzu.zzaV().zzk().zzb("[sgtm] Eligible for client side upload. appId", zzc);
                        zzb.zzb(3);
                        zzb.zza(com.google.android.gms.internal.measurement.zzin.CLIENT_UPLOAD_ELIGIBLE);
                        zzosVar = new zzos(zzd2, hashMap, zzlr.SGTM_CLIENT, (com.google.android.gms.internal.measurement.zzis) zzb.zzbc());
                    }
                    zzb3.zzq().zza();
                    zzb3.zzq().zzb();
                    zzib zzibVar = this.zzu;
                    zzibVar.zzaU();
                    if (!TextUtils.isEmpty(zzd2)) {
                        zzibVar.zzaV().zzk().zzb("[sgtm] Eligible for local service direct upload. appId", zzc);
                        zzb.zzb(5);
                        zzb.zzc(2);
                        zzosVar = new zzos(zzd2, hashMap, zzlr.SGTM, (com.google.android.gms.internal.measurement.zzis) zzb.zzbc());
                    } else {
                        zzb.zzc(6);
                        zzibVar.zzaV().zzk().zzb("[sgtm] Local service, missing sgtm_server_url", zzu2.zzc());
                    }
                } else {
                    this.zzu.zzaV().zzk().zzb("[sgtm] Missing sgtm_setting in remote config. appId", zzc);
                    zzb.zzc(4);
                }
                if (zzosVar != null) {
                    return zzosVar;
                }
                return new zzos(zzd(str), Collections.emptyMap(), zzlr.GOOGLE_ANALYTICS, (com.google.android.gms.internal.measurement.zzis) zzb.zzbc());
            }
            zzb.zzc(3);
            return new zzos(zzd(str), Collections.emptyMap(), zzlr.GOOGLE_ANALYTICS, (com.google.android.gms.internal.measurement.zzis) zzb.zzbc());
        }
        return new zzos(zzd(str), Collections.emptyMap(), zzlr.GOOGLE_ANALYTICS, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzc(String str, com.google.android.gms.internal.measurement.zzin zzinVar) {
        com.google.android.gms.internal.measurement.zzgl zzb;
        zzg();
        if (zzinVar != com.google.android.gms.internal.measurement.zzin.CLIENT_UPLOAD_ELIGIBLE || zzf(str) || (zzb = this.zzg.zzh().zzb(str)) == null || !zzb.zzp() || zzb.zzq().zzd().isEmpty()) {
            return false;
        }
        return true;
    }
}
