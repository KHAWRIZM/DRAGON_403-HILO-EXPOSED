package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.google.common.collect.s;
import com.google.common.collect.t;
import com.google.common.collect.u;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzoe {
    static final s zza = s.u(JsonDocumentFields.VERSION, "GoogleConsent", "VendorConsent", "VendorLegitimateInterest", "gdprApplies", "EnableAdvertiserConsentMode", "PolicyVersion", "PurposeConsents", "PurposeOneTreatment", "Purpose1", "Purpose3", "Purpose4", "Purpose7", "CmpSdkID", "PublisherCC", "PublisherRestrictions1", "PublisherRestrictions3", "PublisherRestrictions4", "PublisherRestrictions7", "AuthorizePurpose1", "AuthorizePurpose3", "AuthorizePurpose4", "AuthorizePurpose7", "PurposeDiagnostics");
    public static final /* synthetic */ int zzb = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "");
        } catch (ClassCastException unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, -1);
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ea  */
    @VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static final boolean zzc(com.google.android.gms.internal.measurement.zzko zzkoVar, t tVar, t tVar2, u uVar, char[] cArr, int i10, int i11, int i12, int i13, int i14, String str, String str2, String str3, boolean z10, boolean z11, boolean z12) {
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        t tVar3;
        int i21;
        zzod zzodVar;
        int ordinal;
        char c10;
        int zze = zze(zzkoVar, tVar, tVar2, uVar, cArr, i10, i11, i12, i13, i14, str, str2, str3, z10, z11, z12);
        if (zze > 0) {
            i16 = i12;
            if (i16 == 1) {
                i15 = i11;
                if (i15 == 1) {
                    i18 = 1;
                    i17 = 1;
                    if (zzi(zzkoVar, tVar, tVar2, uVar, cArr, i10, i18, i17, i13, i14, str, str2, str3, z10, z11, z12) != com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_NOT_ALLOWED) {
                        c10 = '3';
                    } else {
                        if (zzkoVar == com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
                            i19 = i14;
                            i20 = 1;
                            if (i19 == 1) {
                                if (uVar.contains(str)) {
                                    if (zze > 0 && cArr[zze] != '2') {
                                        cArr[zze] = '1';
                                    }
                                    return true;
                                }
                                tVar3 = tVar;
                                i21 = 1;
                                if (tVar3.containsKey(zzkoVar) && (zzodVar = (zzod) tVar3.get(zzkoVar)) != null) {
                                    ordinal = zzodVar.ordinal();
                                    if (ordinal == 0) {
                                        if (ordinal != i20) {
                                            if (ordinal == 2) {
                                                if (zzi(zzkoVar, tVar, tVar2, uVar, cArr, i10, i18, i17, i13, i21, str, str2, str3, z10, z11, z12) == com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                                                    return zzh(zzkoVar, tVar, tVar2, uVar, cArr, i10, i18, i17, i13, i21, str, str2, str3, z10, z11, z12);
                                                }
                                                return zzg(zzkoVar, tVar, tVar2, uVar, cArr, i10, i18, i17, i13, i21, str, str2, str3, z10, z11, z12);
                                            }
                                            if (ordinal == 3) {
                                                if (zzi(zzkoVar, tVar, tVar2, uVar, cArr, i10, i18, i17, i13, i21, str, str2, str3, z10, z11, z12) == com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                                                    return zzg(zzkoVar, tVar, tVar2, uVar, cArr, i10, i18, i17, i13, i21, str, str2, str3, z10, z11, z12);
                                                }
                                                return zzh(zzkoVar, tVar, tVar2, uVar, cArr, i10, i18, i17, i13, i21, str, str2, str3, z10, z11, z12);
                                            }
                                        } else if (zzi(zzkoVar, tVar, tVar2, uVar, cArr, i10, i18, i17, i13, i21, str, str2, str3, z10, z11, z12) != com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                                            return zzh(zzkoVar, tVar, tVar2, uVar, cArr, i10, i18, i17, i13, i21, str, str2, str3, z10, z11, z12);
                                        }
                                    } else if (zzi(zzkoVar, tVar, tVar2, uVar, cArr, i10, i18, i17, i13, i21, str, str2, str3, z10, z11, z12) != com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                                        return zzg(zzkoVar, tVar, tVar2, uVar, cArr, i10, i18, i17, i13, i21, str, str2, str3, z10, z11, z12);
                                    }
                                    c10 = '8';
                                }
                                c10 = '0';
                            }
                        } else {
                            i19 = i14;
                            i20 = 1;
                        }
                        tVar3 = tVar;
                        i21 = i19;
                        if (tVar3.containsKey(zzkoVar)) {
                            ordinal = zzodVar.ordinal();
                            if (ordinal == 0) {
                            }
                            c10 = '8';
                        }
                        c10 = '0';
                    }
                    if (zze <= 0 && cArr[zze] != '2') {
                        cArr[zze] = c10;
                        return false;
                    }
                }
                i16 = 1;
            } else {
                i15 = i11;
            }
            cArr[zze] = '2';
        } else {
            i15 = i11;
            i16 = i12;
        }
        i17 = i16;
        i18 = i15;
        if (zzi(zzkoVar, tVar, tVar2, uVar, cArr, i10, i18, i17, i13, i14, str, str2, str3, z10, z11, z12) != com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_NOT_ALLOWED) {
        }
        return zze <= 0 ? false : false;
    }

    public static final Map zzd(t tVar, t tVar2, u uVar, char[] cArr, int i10, int i11, int i12, int i13, int i14, String str, String str2, String str3, boolean z10, boolean z11, boolean z12) {
        int zza2;
        int zza3;
        int zza4;
        int zza5;
        if (((Boolean) zzfx.zzba.zzb(null)).booleanValue() && !z12) {
            return t.j();
        }
        com.google.android.gms.internal.measurement.zzko zzkoVar = com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
        com.google.android.gms.internal.measurement.zzkp zzkpVar = (com.google.android.gms.internal.measurement.zzkp) tVar2.get(zzkoVar);
        com.google.android.gms.internal.measurement.zzko zzkoVar2 = com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE;
        com.google.android.gms.internal.measurement.zzkp zzkpVar2 = (com.google.android.gms.internal.measurement.zzkp) tVar2.get(zzkoVar2);
        com.google.android.gms.internal.measurement.zzko zzkoVar3 = com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS;
        com.google.android.gms.internal.measurement.zzkp zzkpVar3 = (com.google.android.gms.internal.measurement.zzkp) tVar2.get(zzkoVar3);
        com.google.android.gms.internal.measurement.zzko zzkoVar4 = com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE;
        com.google.android.gms.internal.measurement.zzkp zzkpVar4 = (com.google.android.gms.internal.measurement.zzkp) tVar2.get(zzkoVar4);
        t.a f10 = t.c().f(JsonDocumentFields.VERSION, "2").f("VendorConsent", true != z10 ? "0" : "1").f("VendorLegitimateInterest", true != z11 ? "0" : "1").f("gdprApplies", i12 != 1 ? "0" : "1").f("EnableAdvertiserConsentMode", i11 != 1 ? "0" : "1").f("PolicyVersion", String.valueOf(i13)).f("CmpSdkID", String.valueOf(i10)).f("PurposeOneTreatment", i14 != 1 ? "0" : "1").f("PublisherCC", str);
        if (zzkpVar != null) {
            zza2 = zzkpVar.zza();
        } else {
            zza2 = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_UNDEFINED.zza();
        }
        t.a f11 = f10.f("PublisherRestrictions1", String.valueOf(zza2));
        if (zzkpVar2 != null) {
            zza3 = zzkpVar2.zza();
        } else {
            zza3 = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_UNDEFINED.zza();
        }
        t.a f12 = f11.f("PublisherRestrictions3", String.valueOf(zza3));
        if (zzkpVar3 != null) {
            zza4 = zzkpVar3.zza();
        } else {
            zza4 = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_UNDEFINED.zza();
        }
        t.a f13 = f12.f("PublisherRestrictions4", String.valueOf(zza4));
        if (zzkpVar4 != null) {
            zza5 = zzkpVar4.zza();
        } else {
            zza5 = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_UNDEFINED.zza();
        }
        return f13.f("PublisherRestrictions7", String.valueOf(zza5)).i(t.k("Purpose1", zzf(zzkoVar, tVar, tVar2, uVar, cArr, i10, i11, i12, i13, i14, str, str2, str3, z10, z11, z12), "Purpose3", zzf(zzkoVar2, tVar, tVar2, uVar, cArr, i10, i11, i12, i13, i14, str, str2, str3, z10, z11, z12), "Purpose4", zzf(zzkoVar3, tVar, tVar2, uVar, cArr, i10, i11, i12, i13, i14, str, str2, str3, z10, z11, z12), "Purpose7", zzf(zzkoVar4, tVar, tVar2, uVar, cArr, i10, i11, i12, i13, i14, str, str2, str3, z10, z11, z12))).i(t.l("AuthorizePurpose1", true != zzc(zzkoVar, tVar, tVar2, uVar, cArr, i10, i11, i12, i13, i14, str, str2, str3, z10, z11, z12) ? "0" : "1", "AuthorizePurpose3", true != zzc(zzkoVar2, tVar, tVar2, uVar, cArr, i10, i11, i12, i13, i14, str, str2, str3, z10, z11, z12) ? "0" : "1", "AuthorizePurpose4", true != zzc(zzkoVar3, tVar, tVar2, uVar, cArr, i10, i11, i12, i13, i14, str, str2, str3, z10, z11, z12) ? "0" : "1", "AuthorizePurpose7", true == zzc(zzkoVar4, tVar, tVar2, uVar, cArr, i10, i11, i12, i13, i14, str, str2, str3, z10, z11, z12) ? "1" : "0", "PurposeDiagnostics", new String(cArr))).c();
    }

    private static final int zze(com.google.android.gms.internal.measurement.zzko zzkoVar, t tVar, t tVar2, u uVar, char[] cArr, int i10, int i11, int i12, int i13, int i14, String str, String str2, String str3, boolean z10, boolean z11, boolean z12) {
        if (zzkoVar == com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
            return 1;
        }
        if (zzkoVar == com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE) {
            return 2;
        }
        if (zzkoVar == com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS) {
            return 3;
        }
        return zzkoVar == com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE ? 4 : -1;
    }

    private static final String zzf(com.google.android.gms.internal.measurement.zzko zzkoVar, t tVar, t tVar2, u uVar, char[] cArr, int i10, int i11, int i12, int i13, int i14, String str, String str2, String str3, boolean z10, boolean z11, boolean z12) {
        String str4;
        String str5 = "0";
        if (TextUtils.isEmpty(str2) || str2.length() < zzkoVar.zza()) {
            str4 = "0";
        } else {
            str4 = String.valueOf(str2.charAt(zzkoVar.zza() - 1));
        }
        if (!TextUtils.isEmpty(str3) && str3.length() >= zzkoVar.zza()) {
            str5 = String.valueOf(str3.charAt(zzkoVar.zza() - 1));
        }
        return String.valueOf(str4).concat(String.valueOf(str5));
    }

    private static final boolean zzg(com.google.android.gms.internal.measurement.zzko zzkoVar, t tVar, t tVar2, u uVar, char[] cArr, int i10, int i11, int i12, int i13, int i14, String str, String str2, String str3, boolean z10, boolean z11, boolean z12) {
        char c10;
        int zze = zze(zzkoVar, tVar, tVar2, uVar, cArr, i10, i11, i12, i13, i14, str, str2, str3, z10, z11, z12);
        boolean z13 = false;
        if (!z10) {
            c10 = '4';
        } else if (str2.length() < zzkoVar.zza()) {
            c10 = '0';
        } else {
            char charAt = str2.charAt(zzkoVar.zza() - 1);
            char c11 = '1';
            if (charAt == '1') {
                z13 = true;
            }
            if (zze > 0 && cArr[zze] != '2') {
                if (charAt != '1') {
                    c11 = '6';
                }
                cArr[zze] = c11;
            }
            return z13;
        }
        if (zze > 0 && cArr[zze] != '2') {
            cArr[zze] = c10;
        }
        return false;
    }

    private static final boolean zzh(com.google.android.gms.internal.measurement.zzko zzkoVar, t tVar, t tVar2, u uVar, char[] cArr, int i10, int i11, int i12, int i13, int i14, String str, String str2, String str3, boolean z10, boolean z11, boolean z12) {
        char c10;
        int zze = zze(zzkoVar, tVar, tVar2, uVar, cArr, i10, i11, i12, i13, i14, str, str2, str3, z10, z11, z12);
        boolean z13 = false;
        if (!z11) {
            c10 = '5';
        } else if (str3.length() < zzkoVar.zza()) {
            c10 = '0';
        } else {
            char charAt = str3.charAt(zzkoVar.zza() - 1);
            char c11 = '1';
            if (charAt == '1') {
                z13 = true;
            }
            if (zze > 0 && cArr[zze] != '2') {
                if (charAt != '1') {
                    c11 = '7';
                }
                cArr[zze] = c11;
            }
            return z13;
        }
        if (zze > 0 && cArr[zze] != '2') {
            cArr[zze] = c10;
        }
        return false;
    }

    private static final com.google.android.gms.internal.measurement.zzkp zzi(com.google.android.gms.internal.measurement.zzko zzkoVar, t tVar, t tVar2, u uVar, char[] cArr, int i10, int i11, int i12, int i13, int i14, String str, String str2, String str3, boolean z10, boolean z11, boolean z12) {
        return (com.google.android.gms.internal.measurement.zzkp) tVar2.getOrDefault(zzkoVar, com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_UNDEFINED);
    }
}
