package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzjn;
import com.google.common.collect.s;
import com.google.common.collect.u;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzc {
    public static final /* synthetic */ int zza = 0;
    private static final u zzb = u.t("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", FirebaseAnalytics.Event.CAMPAIGN_DETAILS, "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire");
    private static final s zzc = s.t("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");
    private static final s zzd = s.s("auto", "app", "am");
    private static final s zze = s.r("_r", "_dbg");
    private static final s zzf = new s.a().e(zzjn.zza).e(zzjn.zzb).f();
    private static final s zzg = s.r("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");

    public static boolean zza(String str) {
        if (!zzd.contains(str)) {
            return true;
        }
        return false;
    }

    public static boolean zzb(String str, Bundle bundle) {
        if (zzc.contains(str)) {
            return false;
        }
        if (bundle != null) {
            s sVar = zze;
            int size = sVar.size();
            int i10 = 0;
            while (i10 < size) {
                boolean containsKey = bundle.containsKey((String) sVar.get(i10));
                i10++;
                if (containsKey) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static boolean zzc(String str) {
        if (!zzb.contains(str)) {
            return true;
        }
        return false;
    }

    public static boolean zzd(String str, String str2) {
        if (!"_ce1".equals(str2) && !"_ce2".equals(str2)) {
            if (Constants.ScionAnalytics.USER_PROPERTY_FIREBASE_LAST_NOTIFICATION.equals(str2)) {
                if (str.equals("fcm") || str.equals("fiam")) {
                    return true;
                }
                return false;
            }
            if (zzf.contains(str2)) {
                return false;
            }
            s sVar = zzg;
            int size = sVar.size();
            int i10 = 0;
            while (i10 < size) {
                boolean matches = str2.matches((String) sVar.get(i10));
                i10++;
                if (matches) {
                    return false;
                }
            }
            return true;
        }
        if (str.equals("fcm") || str.equals(FirebaseABTesting.OriginService.REMOTE_CONFIG)) {
            return true;
        }
        return false;
    }

    public static boolean zze(String str, String str2, Bundle bundle) {
        char c10;
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!zza(str) || bundle == null) {
            return false;
        }
        s sVar = zze;
        int size = sVar.size();
        int i10 = 0;
        while (i10 < size) {
            boolean containsKey = bundle.containsKey((String) sVar.get(i10));
            i10++;
            if (containsKey) {
                return false;
            }
        }
        int hashCode = str.hashCode();
        if (hashCode != 101200) {
            if (hashCode != 101230) {
                if (hashCode == 3142703 && str.equals("fiam")) {
                    c10 = 2;
                }
                c10 = 65535;
            } else {
                if (str.equals("fdl")) {
                    c10 = 1;
                }
                c10 = 65535;
            }
        } else {
            if (str.equals("fcm")) {
                c10 = 0;
            }
            c10 = 65535;
        }
        if (c10 != 0) {
            if (c10 != 1) {
                if (c10 != 2) {
                    return false;
                }
                bundle.putString("_cis", "fiam_integration");
                return true;
            }
            bundle.putString("_cis", "fdl_integration");
            return true;
        }
        bundle.putString("_cis", "fcm_integration");
        return true;
    }
}
