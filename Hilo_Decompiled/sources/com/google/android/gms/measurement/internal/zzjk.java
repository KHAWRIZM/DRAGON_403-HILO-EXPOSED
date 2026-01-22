package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzjk {
    public static final zzjk zza = new zzjk(null, null, 100);
    private final EnumMap zzb;
    private final int zzc;

    public zzjk(Boolean bool, Boolean bool2, int i10) {
        EnumMap enumMap = new EnumMap(zzjj.class);
        this.zzb = enumMap;
        enumMap.put((EnumMap) zzjj.AD_STORAGE, (zzjj) zzh(null));
        enumMap.put((EnumMap) zzjj.ANALYTICS_STORAGE, (zzjj) zzh(null));
        this.zzc = i10;
    }

    public static zzjk zza(zzjh zzjhVar, zzjh zzjhVar2, int i10) {
        EnumMap enumMap = new EnumMap(zzjj.class);
        enumMap.put((EnumMap) zzjj.AD_STORAGE, (zzjj) zzjhVar);
        enumMap.put((EnumMap) zzjj.ANALYTICS_STORAGE, (zzjj) zzjhVar2);
        return new zzjk(enumMap, -10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzd(int i10) {
        return i10 != -30 ? i10 != -20 ? i10 != -10 ? i10 != 0 ? i10 != 30 ? i10 != 90 ? i10 != 100 ? "OTHER" : "UNKNOWN" : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API" : "TCF";
    }

    public static zzjk zze(Bundle bundle, int i10) {
        if (bundle == null) {
            return new zzjk(null, null, i10);
        }
        EnumMap enumMap = new EnumMap(zzjj.class);
        for (zzjj zzjjVar : zzji.STORAGE.zzb()) {
            enumMap.put((EnumMap) zzjjVar, (zzjj) zzg(bundle.getString(zzjjVar.zze)));
        }
        return new zzjk(enumMap, i10);
    }

    public static zzjk zzf(String str, int i10) {
        String str2;
        EnumMap enumMap = new EnumMap(zzjj.class);
        zzjj[] zza2 = zzji.STORAGE.zza();
        for (int i11 = 0; i11 < zza2.length; i11++) {
            if (str == null) {
                str2 = "";
            } else {
                str2 = str;
            }
            zzjj zzjjVar = zza2[i11];
            int i12 = i11 + 2;
            if (i12 < str2.length()) {
                enumMap.put((EnumMap) zzjjVar, (zzjj) zzj(str2.charAt(i12)));
            } else {
                enumMap.put((EnumMap) zzjjVar, (zzjj) zzjh.UNINITIALIZED);
            }
        }
        return new zzjk(enumMap, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjh zzg(String str) {
        if (str == null) {
            return zzjh.UNINITIALIZED;
        }
        if (str.equals("granted")) {
            return zzjh.GRANTED;
        }
        if (str.equals("denied")) {
            return zzjh.DENIED;
        }
        return zzjh.UNINITIALIZED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjh zzh(Boolean bool) {
        if (bool == null) {
            return zzjh.UNINITIALIZED;
        }
        if (bool.booleanValue()) {
            return zzjh.GRANTED;
        }
        return zzjh.DENIED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzi(zzjh zzjhVar) {
        int ordinal = zzjhVar.ordinal();
        if (ordinal != 2) {
            if (ordinal != 3) {
                return null;
            }
            return "granted";
        }
        return "denied";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjh zzj(char c10) {
        if (c10 != '+') {
            if (c10 != '0') {
                if (c10 != '1') {
                    return zzjh.UNINITIALIZED;
                }
                return zzjh.GRANTED;
            }
            return zzjh.DENIED;
        }
        return zzjh.POLICY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static char zzm(zzjh zzjhVar) {
        if (zzjhVar != null) {
            int ordinal = zzjhVar.ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        return '1';
                    }
                    return '-';
                }
                return '0';
            }
            return '+';
        }
        return '-';
    }

    public static boolean zzu(int i10, int i11) {
        int i12 = -30;
        if (i10 == -20) {
            if (i11 == -30) {
                return true;
            }
            i10 = -20;
        }
        if (i10 != -30) {
            i12 = i10;
        } else if (i11 == -20) {
            return true;
        }
        return i12 == i11 || i10 < i11;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzjk)) {
            return false;
        }
        zzjk zzjkVar = (zzjk) obj;
        for (zzjj zzjjVar : zzji.STORAGE.zzb()) {
            if (this.zzb.get(zzjjVar) != zzjkVar.zzb.get(zzjjVar)) {
                return false;
            }
        }
        if (this.zzc != zzjkVar.zzc) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Iterator it = this.zzb.values().iterator();
        int i10 = this.zzc * 17;
        while (it.hasNext()) {
            i10 = (i10 * 31) + ((zzjh) it.next()).hashCode();
        }
        return i10;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zzd(this.zzc));
        for (zzjj zzjjVar : zzji.STORAGE.zzb()) {
            sb.append(",");
            sb.append(zzjjVar.zze);
            sb.append("=");
            zzjh zzjhVar = (zzjh) this.zzb.get(zzjjVar);
            if (zzjhVar == null) {
                zzjhVar = zzjh.UNINITIALIZED;
            }
            sb.append(zzjhVar);
        }
        return sb.toString();
    }

    public final int zzb() {
        return this.zzc;
    }

    public final boolean zzc() {
        Iterator it = this.zzb.values().iterator();
        while (it.hasNext()) {
            if (((zzjh) it.next()) != zzjh.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final String zzk() {
        int ordinal;
        StringBuilder sb = new StringBuilder("G1");
        for (zzjj zzjjVar : zzji.STORAGE.zza()) {
            zzjh zzjhVar = (zzjh) this.zzb.get(zzjjVar);
            char c10 = '-';
            if (zzjhVar != null && (ordinal = zzjhVar.ordinal()) != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal != 3) {
                        }
                    } else {
                        c10 = '0';
                    }
                }
                c10 = '1';
            }
            sb.append(c10);
        }
        return sb.toString();
    }

    public final String zzl() {
        StringBuilder sb = new StringBuilder("G1");
        for (zzjj zzjjVar : zzji.STORAGE.zza()) {
            sb.append(zzm((zzjh) this.zzb.get(zzjjVar)));
        }
        return sb.toString();
    }

    public final Bundle zzn() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.zzb.entrySet()) {
            String zzi = zzi((zzjh) entry.getValue());
            if (zzi != null) {
                bundle.putString(((zzjj) entry.getKey()).zze, zzi);
            }
        }
        return bundle;
    }

    public final boolean zzo(zzjj zzjjVar) {
        if (((zzjh) this.zzb.get(zzjjVar)) == zzjh.DENIED) {
            return false;
        }
        return true;
    }

    public final zzjh zzp() {
        zzjh zzjhVar = (zzjh) this.zzb.get(zzjj.AD_STORAGE);
        if (zzjhVar == null) {
            return zzjh.UNINITIALIZED;
        }
        return zzjhVar;
    }

    public final zzjh zzq() {
        zzjh zzjhVar = (zzjh) this.zzb.get(zzjj.ANALYTICS_STORAGE);
        if (zzjhVar == null) {
            return zzjh.UNINITIALIZED;
        }
        return zzjhVar;
    }

    public final boolean zzr(zzjk zzjkVar) {
        EnumMap enumMap = this.zzb;
        for (zzjj zzjjVar : (zzjj[]) enumMap.keySet().toArray(new zzjj[0])) {
            zzjh zzjhVar = (zzjh) enumMap.get(zzjjVar);
            zzjh zzjhVar2 = (zzjh) zzjkVar.zzb.get(zzjjVar);
            zzjh zzjhVar3 = zzjh.DENIED;
            if (zzjhVar == zzjhVar3 && zzjhVar2 != zzjhVar3) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzjk zzs(zzjk zzjkVar) {
        EnumMap enumMap = new EnumMap(zzjj.class);
        for (zzjj zzjjVar : zzji.STORAGE.zzb()) {
            zzjh zzjhVar = (zzjh) this.zzb.get(zzjjVar);
            zzjh zzjhVar2 = (zzjh) zzjkVar.zzb.get(zzjjVar);
            if (zzjhVar != null) {
                if (zzjhVar2 != null) {
                    zzjh zzjhVar3 = zzjh.UNINITIALIZED;
                    if (zzjhVar != zzjhVar3) {
                        if (zzjhVar2 != zzjhVar3) {
                            zzjh zzjhVar4 = zzjh.POLICY;
                            if (zzjhVar != zzjhVar4) {
                                if (zzjhVar2 != zzjhVar4) {
                                    zzjh zzjhVar5 = zzjh.DENIED;
                                    zzjhVar = (zzjhVar == zzjhVar5 || zzjhVar2 == zzjhVar5) ? zzjhVar5 : zzjh.GRANTED;
                                }
                            }
                        }
                    }
                }
                if (zzjhVar == null) {
                    enumMap.put((EnumMap) zzjjVar, (zzjj) zzjhVar);
                }
            }
            zzjhVar = zzjhVar2;
            if (zzjhVar == null) {
            }
        }
        return new zzjk(enumMap, 100);
    }

    public final zzjk zzt(zzjk zzjkVar) {
        EnumMap enumMap = new EnumMap(zzjj.class);
        for (zzjj zzjjVar : zzji.STORAGE.zzb()) {
            zzjh zzjhVar = (zzjh) this.zzb.get(zzjjVar);
            if (zzjhVar == zzjh.UNINITIALIZED) {
                zzjhVar = (zzjh) zzjkVar.zzb.get(zzjjVar);
            }
            if (zzjhVar != null) {
                enumMap.put((EnumMap) zzjjVar, (zzjj) zzjhVar);
            }
        }
        return new zzjk(enumMap, this.zzc);
    }

    private zzjk(EnumMap enumMap, int i10) {
        EnumMap enumMap2 = new EnumMap(zzjj.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzc = i10;
    }
}
