package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.facebook.internal.security.CertificateUtil;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzaz {
    public static final zzaz zza = new zzaz((Boolean) null, 100, (Boolean) null, (String) null);
    private final int zzb;
    private final String zzc;
    private final Boolean zzd;
    private final String zze;
    private final EnumMap zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaz(Boolean bool, int i10, Boolean bool2, String str) {
        EnumMap enumMap = new EnumMap(zzjj.class);
        this.zzf = enumMap;
        enumMap.put((EnumMap) zzjj.AD_USER_DATA, (zzjj) zzjk.zzh(bool));
        this.zzb = i10;
        this.zzc = zzl();
        this.zzd = bool2;
        this.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzaz zza(zzjh zzjhVar, int i10) {
        EnumMap enumMap = new EnumMap(zzjj.class);
        enumMap.put((EnumMap) zzjj.AD_USER_DATA, (zzjj) zzjhVar);
        return new zzaz(enumMap, -10, (Boolean) null, (String) null);
    }

    public static zzaz zzg(String str) {
        if (str != null && str.length() > 0) {
            String[] split = str.split(CertificateUtil.DELIMITER);
            int parseInt = Integer.parseInt(split[0]);
            EnumMap enumMap = new EnumMap(zzjj.class);
            zzjj[] zza2 = zzji.DMA.zza();
            int length = zza2.length;
            int i10 = 1;
            int i11 = 0;
            while (i11 < length) {
                enumMap.put((EnumMap) zza2[i11], (zzjj) zzjk.zzj(split[i10].charAt(0)));
                i11++;
                i10++;
            }
            return new zzaz(enumMap, parseInt, (Boolean) null, (String) null);
        }
        return zza;
    }

    public static zzaz zzh(Bundle bundle, int i10) {
        Boolean bool = null;
        if (bundle == null) {
            return new zzaz((Boolean) null, i10, (Boolean) null, (String) null);
        }
        EnumMap enumMap = new EnumMap(zzjj.class);
        for (zzjj zzjjVar : zzji.DMA.zza()) {
            enumMap.put((EnumMap) zzjjVar, (zzjj) zzjk.zzg(bundle.getString(zzjjVar.zze)));
        }
        if (bundle.containsKey("is_dma_region")) {
            bool = Boolean.valueOf(bundle.getString("is_dma_region"));
        }
        return new zzaz(enumMap, i10, bool, bundle.getString("cps_display_str"));
    }

    public static Boolean zzi(Bundle bundle) {
        zzjh zzg;
        if (bundle != null && (zzg = zzjk.zzg(bundle.getString("ad_personalization"))) != null) {
            int ordinal = zzg.ordinal();
            if (ordinal != 2) {
                if (ordinal == 3) {
                    return Boolean.TRUE;
                }
                return null;
            }
            return Boolean.FALSE;
        }
        return null;
    }

    private final String zzl() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzb);
        for (zzjj zzjjVar : zzji.DMA.zza()) {
            sb.append(CertificateUtil.DELIMITER);
            sb.append(zzjk.zzm((zzjh) this.zzf.get(zzjjVar)));
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzaz) {
            zzaz zzazVar = (zzaz) obj;
            if (this.zzc.equalsIgnoreCase(zzazVar.zzc) && Objects.equals(this.zzd, zzazVar.zzd)) {
                return Objects.equals(this.zze, zzazVar.zze);
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i10;
        int hashCode;
        Boolean bool = this.zzd;
        if (bool == null) {
            i10 = 3;
        } else if (true != bool.booleanValue()) {
            i10 = 13;
        } else {
            i10 = 7;
        }
        String str = this.zze;
        if (str == null) {
            hashCode = 17;
        } else {
            hashCode = str.hashCode();
        }
        return this.zzc.hashCode() + (i10 * 29) + (hashCode * 137);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zzjk.zzd(this.zzb));
        for (zzjj zzjjVar : zzji.DMA.zza()) {
            sb.append(",");
            sb.append(zzjjVar.zze);
            sb.append("=");
            zzjh zzjhVar = (zzjh) this.zzf.get(zzjjVar);
            if (zzjhVar == null) {
                sb.append("uninitialized");
            } else {
                int ordinal = zzjhVar.ordinal();
                if (ordinal != 0) {
                    if (ordinal != 1) {
                        if (ordinal != 2) {
                            if (ordinal == 3) {
                                sb.append("granted");
                            }
                        } else {
                            sb.append("denied");
                        }
                    } else {
                        sb.append("eu_consent_policy");
                    }
                } else {
                    sb.append("uninitialized");
                }
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            sb.append(",isDmaRegion=");
            sb.append(bool);
        }
        String str = this.zze;
        if (str != null) {
            sb.append(",cpsDisplayStr=");
            sb.append(str);
        }
        return sb.toString();
    }

    public final int zzb() {
        return this.zzb;
    }

    public final zzjh zzc() {
        zzjh zzjhVar = (zzjh) this.zzf.get(zzjj.AD_USER_DATA);
        if (zzjhVar == null) {
            return zzjh.UNINITIALIZED;
        }
        return zzjhVar;
    }

    public final boolean zzd() {
        Iterator it = this.zzf.values().iterator();
        while (it.hasNext()) {
            if (((zzjh) it.next()) != zzjh.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final String zze() {
        return this.zzc;
    }

    public final Bundle zzf() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.zzf.entrySet()) {
            String zzi = zzjk.zzi((zzjh) entry.getValue());
            if (zzi != null) {
                bundle.putString(((zzjj) entry.getKey()).zze, zzi);
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            bundle.putString("is_dma_region", bool.toString());
        }
        String str = this.zze;
        if (str != null) {
            bundle.putString("cps_display_str", str);
        }
        return bundle;
    }

    public final Boolean zzj() {
        return this.zzd;
    }

    public final String zzk() {
        return this.zze;
    }

    private zzaz(EnumMap enumMap, int i10, Boolean bool, String str) {
        EnumMap enumMap2 = new EnumMap(zzjj.class);
        this.zzf = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzb = i10;
        this.zzc = zzl();
        this.zzd = bool;
        this.zze = str;
    }
}
