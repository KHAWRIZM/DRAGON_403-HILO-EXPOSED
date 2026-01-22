package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzba {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0109. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32, types: [com.google.android.gms.internal.measurement.zzao] */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.google.android.gms.internal.measurement.zzae] */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.google.android.gms.internal.measurement.zzae] */
    /* JADX WARN: Type inference failed for: r23v0, types: [java.lang.String] */
    public static zzao zza(String str, zzae zzaeVar, zzg zzgVar, List list) {
        String str2;
        char c10;
        zzao zzaoVar;
        double d10;
        String str3;
        double d11;
        double d12;
        zzae zzaeVar2;
        double min;
        switch (str.hashCode()) {
            case -1776922004:
                str2 = "toString";
                if (str.equals(str2)) {
                    c10 = 18;
                    break;
                }
                c10 = 65535;
                break;
            case -1354795244:
                if (str.equals("concat")) {
                    str2 = "toString";
                    c10 = 0;
                    break;
                }
                str2 = "toString";
                c10 = 65535;
                break;
            case -1274492040:
                if (str.equals("filter")) {
                    str2 = "toString";
                    c10 = 2;
                    break;
                }
                str2 = "toString";
                c10 = 65535;
                break;
            case -934873754:
                if (str.equals("reduce")) {
                    c10 = '\n';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c10 = 65535;
                break;
            case -895859076:
                if (str.equals("splice")) {
                    c10 = 17;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c10 = 65535;
                break;
            case -678635926:
                if (str.equals("forEach")) {
                    str2 = "toString";
                    c10 = 3;
                    break;
                }
                str2 = "toString";
                c10 = 65535;
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    c10 = 6;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c10 = 65535;
                break;
            case -277637751:
                if (str.equals("unshift")) {
                    c10 = 19;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c10 = 65535;
                break;
            case 107868:
                if (str.equals("map")) {
                    c10 = 7;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c10 = 65535;
                break;
            case 111185:
                if (str.equals("pop")) {
                    c10 = '\b';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c10 = 65535;
                break;
            case 3267882:
                if (str.equals("join")) {
                    c10 = 5;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c10 = 65535;
                break;
            case 3452698:
                if (str.equals("push")) {
                    c10 = '\t';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c10 = 65535;
                break;
            case 3536116:
                if (str.equals("some")) {
                    c10 = 15;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c10 = 65535;
                break;
            case 3536286:
                if (str.equals("sort")) {
                    c10 = 16;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c10 = 65535;
                break;
            case 96891675:
                if (str.equals("every")) {
                    str2 = "toString";
                    c10 = 1;
                    break;
                }
                str2 = "toString";
                c10 = 65535;
                break;
            case 109407362:
                if (str.equals("shift")) {
                    c10 = '\r';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c10 = 65535;
                break;
            case 109526418:
                if (str.equals("slice")) {
                    c10 = 14;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c10 = 65535;
                break;
            case 965561430:
                if (str.equals("reduceRight")) {
                    c10 = 11;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c10 = 65535;
                break;
            case 1099846370:
                if (str.equals("reverse")) {
                    c10 = '\f';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c10 = 65535;
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    c10 = 4;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c10 = 65535;
                break;
            default:
                str2 = "toString";
                c10 = 65535;
                break;
        }
        zzai zzaiVar = null;
        switch (c10) {
            case 0:
                zzaoVar = (zzae) zzaeVar.zzt();
                if (!list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        zzao zza = zzgVar.zza((zzao) it.next());
                        if (!(zza instanceof zzag)) {
                            int zzh = zzaoVar.zzh();
                            if (zza instanceof zzae) {
                                zzae zzaeVar3 = (zzae) zza;
                                Iterator zzg = zzaeVar3.zzg();
                                while (zzg.hasNext()) {
                                    Integer num = (Integer) zzg.next();
                                    zzaoVar.zzn(num.intValue() + zzh, zzaeVar3.zzl(num.intValue()));
                                }
                            } else {
                                zzaoVar.zzn(zzh, zza);
                            }
                        } else {
                            throw new IllegalStateException("Failed evaluation of arguments");
                        }
                    }
                }
                return zzaoVar;
            case 1:
                zzh.zza("every", 1, list);
                zzao zza2 = zzgVar.zza((zzao) list.get(0));
                if (zza2 instanceof zzan) {
                    if (zzaeVar.zzh() == 0) {
                        return zzao.zzk;
                    }
                    if (zzc(zzaeVar, zzgVar, (zzan) zza2, Boolean.FALSE, Boolean.TRUE).zzh() != zzaeVar.zzh()) {
                        return zzao.zzl;
                    }
                    return zzao.zzk;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 2:
                zzh.zza("filter", 1, list);
                zzao zza3 = zzgVar.zza((zzao) list.get(0));
                if (zza3 instanceof zzan) {
                    if (zzaeVar.zzi() == 0) {
                        return new zzae();
                    }
                    zzae zzaeVar4 = (zzae) zzaeVar.zzt();
                    zzae zzc = zzc(zzaeVar, zzgVar, (zzan) zza3, null, Boolean.TRUE);
                    zzaoVar = new zzae();
                    Iterator zzg2 = zzc.zzg();
                    while (zzg2.hasNext()) {
                        zzaoVar.zzn(zzaoVar.zzh(), zzaeVar4.zzl(((Integer) zzg2.next()).intValue()));
                    }
                    return zzaoVar;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 3:
                zzh.zza("forEach", 1, list);
                zzao zza4 = zzgVar.zza((zzao) list.get(0));
                if (zza4 instanceof zzan) {
                    if (zzaeVar.zzi() == 0) {
                        return zzao.zzf;
                    }
                    zzc(zzaeVar, zzgVar, (zzan) zza4, null, null);
                    return zzao.zzf;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 4:
                zzh.zzc("indexOf", 2, list);
                zzao zzaoVar2 = zzao.zzf;
                if (!list.isEmpty()) {
                    zzaoVar2 = zzgVar.zza((zzao) list.get(0));
                }
                if (list.size() > 1) {
                    d10 = zzh.zzi(zzgVar.zza((zzao) list.get(1)).zzd().doubleValue());
                    if (d10 >= zzaeVar.zzh()) {
                        return new zzah(Double.valueOf(-1.0d));
                    }
                    if (d10 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        d10 += zzaeVar.zzh();
                    }
                } else {
                    d10 = 0.0d;
                }
                Iterator zzg3 = zzaeVar.zzg();
                while (zzg3.hasNext()) {
                    int intValue = ((Integer) zzg3.next()).intValue();
                    double d13 = intValue;
                    if (d13 >= d10 && zzh.zzf(zzaeVar.zzl(intValue), zzaoVar2)) {
                        return new zzah(Double.valueOf(d13));
                    }
                }
                return new zzah(Double.valueOf(-1.0d));
            case 5:
                zzh.zzc("join", 1, list);
                if (zzaeVar.zzh() == 0) {
                    return zzao.zzm;
                }
                if (list.isEmpty()) {
                    str3 = ",";
                } else {
                    zzao zza5 = zzgVar.zza((zzao) list.get(0));
                    if (!(zza5 instanceof zzam) && !(zza5 instanceof zzat)) {
                        str3 = zza5.zzc();
                    } else {
                        str3 = "";
                    }
                }
                return new zzas(zzaeVar.zzs(str3));
            case 6:
                zzh.zzc("lastIndexOf", 2, list);
                zzao zzaoVar3 = zzao.zzf;
                if (!list.isEmpty()) {
                    zzaoVar3 = zzgVar.zza((zzao) list.get(0));
                }
                int zzh2 = zzaeVar.zzh() - 1;
                if (list.size() > 1) {
                    zzao zza6 = zzgVar.zza((zzao) list.get(1));
                    d12 = Double.isNaN(zza6.zzd().doubleValue()) ? zzaeVar.zzh() - 1 : zzh.zzi(zza6.zzd().doubleValue());
                    d11 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    if (d12 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        d12 += zzaeVar.zzh();
                    }
                } else {
                    d11 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    d12 = zzh2;
                }
                if (d12 < d11) {
                    return new zzah(Double.valueOf(-1.0d));
                }
                for (int min2 = (int) Math.min(zzaeVar.zzh(), d12); min2 >= 0; min2--) {
                    if (zzaeVar.zzo(min2) && zzh.zzf(zzaeVar.zzl(min2), zzaoVar3)) {
                        return new zzah(Double.valueOf(min2));
                    }
                }
                return new zzah(Double.valueOf(-1.0d));
            case 7:
                zzh.zza("map", 1, list);
                zzao zza7 = zzgVar.zza((zzao) list.get(0));
                if (zza7 instanceof zzan) {
                    if (zzaeVar.zzh() == 0) {
                        return new zzae();
                    }
                    return zzc(zzaeVar, zzgVar, (zzan) zza7, null, null);
                }
                throw new IllegalArgumentException("Callback should be a method");
            case '\b':
                zzh.zza("pop", 0, list);
                int zzh3 = zzaeVar.zzh();
                if (zzh3 == 0) {
                    return zzao.zzf;
                }
                int i10 = zzh3 - 1;
                zzaoVar = zzaeVar.zzl(i10);
                zzaeVar.zzr(i10);
                return zzaoVar;
            case '\t':
                if (!list.isEmpty()) {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        zzaeVar.zzn(zzaeVar.zzh(), zzgVar.zza((zzao) it2.next()));
                    }
                }
                return new zzah(Double.valueOf(zzaeVar.zzh()));
            case '\n':
                return zzb(zzaeVar, zzgVar, list, true);
            case 11:
                return zzb(zzaeVar, zzgVar, list, false);
            case '\f':
                zzaeVar2 = zzaeVar;
                zzh.zza("reverse", 0, list);
                int zzh4 = zzaeVar.zzh();
                if (zzh4 != 0) {
                    for (int i11 = 0; i11 < zzh4 / 2; i11++) {
                        if (zzaeVar2.zzo(i11)) {
                            zzao zzl = zzaeVar2.zzl(i11);
                            zzaeVar2.zzn(i11, null);
                            int i12 = (zzh4 - 1) - i11;
                            if (zzaeVar2.zzo(i12)) {
                                zzaeVar2.zzn(i11, zzaeVar2.zzl(i12));
                            }
                            zzaeVar2.zzn(i12, zzl);
                        }
                    }
                }
                return zzaeVar2;
            case '\r':
                zzh.zza("shift", 0, list);
                if (zzaeVar.zzh() == 0) {
                    return zzao.zzf;
                }
                zzao zzl2 = zzaeVar.zzl(0);
                zzaeVar.zzr(0);
                return zzl2;
            case 14:
                zzh.zzc("slice", 2, list);
                if (list.isEmpty()) {
                    return zzaeVar.zzt();
                }
                double zzh5 = zzaeVar.zzh();
                double zzi = zzh.zzi(zzgVar.zza((zzao) list.get(0)).zzd().doubleValue());
                if (zzi < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    min = Math.max(zzi + zzh5, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                } else {
                    min = Math.min(zzi, zzh5);
                }
                if (list.size() == 2) {
                    double zzi2 = zzh.zzi(zzgVar.zza((zzao) list.get(1)).zzd().doubleValue());
                    if (zzi2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        zzh5 = Math.max(zzh5 + zzi2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                    } else {
                        zzh5 = Math.min(zzh5, zzi2);
                    }
                }
                zzae zzaeVar5 = new zzae();
                for (int i13 = (int) min; i13 < zzh5; i13++) {
                    zzaeVar5.zzn(zzaeVar5.zzh(), zzaeVar.zzl(i13));
                }
                return zzaeVar5;
            case 15:
                zzh.zza("some", 1, list);
                zzao zza8 = zzgVar.zza((zzao) list.get(0));
                if (zza8 instanceof zzai) {
                    if (zzaeVar.zzh() == 0) {
                        return zzao.zzl;
                    }
                    zzai zzaiVar2 = (zzai) zza8;
                    Iterator zzg4 = zzaeVar.zzg();
                    while (zzg4.hasNext()) {
                        int intValue2 = ((Integer) zzg4.next()).intValue();
                        if (zzaeVar.zzo(intValue2) && zzaiVar2.zza(zzgVar, Arrays.asList(zzaeVar.zzl(intValue2), new zzah(Double.valueOf(intValue2)), zzaeVar)).zze().booleanValue()) {
                            return zzao.zzk;
                        }
                    }
                    return zzao.zzl;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 16:
                zzaeVar2 = zzaeVar;
                zzh.zzc("sort", 1, list);
                if (zzaeVar.zzh() >= 2) {
                    List zzb = zzaeVar.zzb();
                    if (!list.isEmpty()) {
                        zzao zza9 = zzgVar.zza((zzao) list.get(0));
                        if (zza9 instanceof zzai) {
                            zzaiVar = (zzai) zza9;
                        } else {
                            throw new IllegalArgumentException("Comparator should be a method");
                        }
                    }
                    Collections.sort(zzb, new zzaz(zzaiVar, zzgVar));
                    zzaeVar.zzp();
                    Iterator it3 = zzb.iterator();
                    int i14 = 0;
                    while (it3.hasNext()) {
                        zzaeVar2.zzn(i14, (zzao) it3.next());
                        i14++;
                    }
                }
                return zzaeVar2;
            case 17:
                if (list.isEmpty()) {
                    return new zzae();
                }
                int zzi3 = (int) zzh.zzi(zzgVar.zza((zzao) list.get(0)).zzd().doubleValue());
                if (zzi3 < 0) {
                    zzi3 = Math.max(0, zzi3 + zzaeVar.zzh());
                } else if (zzi3 > zzaeVar.zzh()) {
                    zzi3 = zzaeVar.zzh();
                }
                int zzh6 = zzaeVar.zzh();
                zzae zzaeVar6 = new zzae();
                if (list.size() > 1) {
                    int max = Math.max(0, (int) zzh.zzi(zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()));
                    if (max > 0) {
                        for (int i15 = zzi3; i15 < Math.min(zzh6, zzi3 + max); i15++) {
                            zzaeVar6.zzn(zzaeVar6.zzh(), zzaeVar.zzl(zzi3));
                            zzaeVar.zzr(zzi3);
                        }
                    }
                    if (list.size() > 2) {
                        for (int i16 = 2; i16 < list.size(); i16++) {
                            zzao zza10 = zzgVar.zza((zzao) list.get(i16));
                            if (!(zza10 instanceof zzag)) {
                                zzaeVar.zzq((zzi3 + i16) - 2, zza10);
                            } else {
                                throw new IllegalArgumentException("Failed to parse elements to add");
                            }
                        }
                    }
                } else {
                    while (zzi3 < zzh6) {
                        zzaeVar6.zzn(zzaeVar6.zzh(), zzaeVar.zzl(zzi3));
                        zzaeVar.zzn(zzi3, null);
                        zzi3++;
                    }
                }
                return zzaeVar6;
            case 18:
                zzh.zza(str2, 0, list);
                return new zzas(zzaeVar.zzs(","));
            case 19:
                if (!list.isEmpty()) {
                    zzae zzaeVar7 = new zzae();
                    Iterator it4 = list.iterator();
                    while (it4.hasNext()) {
                        zzao zza11 = zzgVar.zza((zzao) it4.next());
                        if (!(zza11 instanceof zzag)) {
                            zzaeVar7.zzn(zzaeVar7.zzh(), zza11);
                        } else {
                            throw new IllegalStateException("Argument evaluation failed");
                        }
                    }
                    int zzh7 = zzaeVar7.zzh();
                    Iterator zzg5 = zzaeVar.zzg();
                    while (zzg5.hasNext()) {
                        Integer num2 = (Integer) zzg5.next();
                        zzaeVar7.zzn(num2.intValue() + zzh7, zzaeVar.zzl(num2.intValue()));
                    }
                    zzaeVar.zzp();
                    Iterator zzg6 = zzaeVar7.zzg();
                    while (zzg6.hasNext()) {
                        Integer num3 = (Integer) zzg6.next();
                        zzaeVar.zzn(num3.intValue(), zzaeVar7.zzl(num3.intValue()));
                    }
                }
                return new zzah(Double.valueOf(zzaeVar.zzh()));
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    private static zzao zzb(zzae zzaeVar, zzg zzgVar, List list, boolean z10) {
        zzao zzaoVar;
        int i10;
        int i11;
        int i12 = -1;
        zzh.zzb("reduce", 1, list);
        zzh.zzc("reduce", 2, list);
        zzao zza = zzgVar.zza((zzao) list.get(0));
        if (zza instanceof zzai) {
            if (list.size() == 2) {
                zzaoVar = zzgVar.zza((zzao) list.get(1));
                if (zzaoVar instanceof zzag) {
                    throw new IllegalArgumentException("Failed to parse initial value");
                }
            } else if (zzaeVar.zzh() != 0) {
                zzaoVar = null;
            } else {
                throw new IllegalStateException("Empty array with no initial value error");
            }
            zzai zzaiVar = (zzai) zza;
            int zzh = zzaeVar.zzh();
            if (z10) {
                i10 = 0;
            } else {
                i10 = zzh - 1;
            }
            if (z10) {
                i11 = zzh - 1;
            } else {
                i11 = 0;
            }
            if (true == z10) {
                i12 = 1;
            }
            if (zzaoVar == null) {
                zzaoVar = zzaeVar.zzl(i10);
                i10 += i12;
            }
            while ((i11 - i10) * i12 >= 0) {
                if (!zzaeVar.zzo(i10)) {
                    i10 += i12;
                } else {
                    zzaoVar = zzaiVar.zza(zzgVar, Arrays.asList(zzaoVar, zzaeVar.zzl(i10), new zzah(Double.valueOf(i10)), zzaeVar));
                    if (!(zzaoVar instanceof zzag)) {
                        i10 += i12;
                    } else {
                        throw new IllegalStateException("Reduce operation failed");
                    }
                }
            }
            return zzaoVar;
        }
        throw new IllegalArgumentException("Callback should be a method");
    }

    private static zzae zzc(zzae zzaeVar, zzg zzgVar, zzai zzaiVar, Boolean bool, Boolean bool2) {
        zzae zzaeVar2 = new zzae();
        Iterator zzg = zzaeVar.zzg();
        while (zzg.hasNext()) {
            int intValue = ((Integer) zzg.next()).intValue();
            if (zzaeVar.zzo(intValue)) {
                zzao zza = zzaiVar.zza(zzgVar, Arrays.asList(zzaeVar.zzl(intValue), new zzah(Double.valueOf(intValue)), zzaeVar));
                if (zza.zze().equals(bool)) {
                    break;
                }
                if (bool2 == null || zza.zze().equals(bool2)) {
                    zzaeVar2.zzn(intValue, zza);
                }
            }
        }
        return zzaeVar2;
    }
}
