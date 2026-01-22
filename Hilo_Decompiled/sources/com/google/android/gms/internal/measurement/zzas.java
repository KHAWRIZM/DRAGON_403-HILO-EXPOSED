package com.google.android.gms.internal.measurement;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzas implements Iterable, zzao {
    private final String zza;

    public zzas(String str) {
        if (str != null) {
            this.zza = str;
            return;
        }
        throw new IllegalArgumentException("StringValue cannot be null.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzas)) {
            return false;
        }
        return this.zza.equals(((zzas) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzar(this);
    }

    public final String toString() {
        String str = this.zza;
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("\"");
        sb.append(str);
        sb.append("\"");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        return this.zza;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:44:0x0179. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x050b  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x056c  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x05c0  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0608  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0643  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x032f  */
    @Override // com.google.android.gms.internal.measurement.zzao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzao zzcA(String str, zzg zzgVar, List list) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        char c10;
        String str7;
        zzas zzasVar;
        zzao zzasVar2;
        zzao zzaoVar;
        int i10;
        int i11;
        double min;
        double min2;
        int i12;
        int i13;
        int i14;
        zzg zzgVar2;
        int i15;
        int length;
        if ("charAt".equals(str) || "concat".equals(str) || "hasOwnProperty".equals(str) || "indexOf".equals(str) || "lastIndexOf".equals(str) || "match".equals(str) || "replace".equals(str) || FirebaseAnalytics.Event.SEARCH.equals(str) || "slice".equals(str) || "split".equals(str) || "substring".equals(str) || "toLowerCase".equals(str) || "toLocaleLowerCase".equals(str) || "toString".equals(str) || "toUpperCase".equals(str)) {
            str2 = "toLocaleUpperCase";
        } else {
            str2 = "toLocaleUpperCase";
            if (!str2.equals(str)) {
                str3 = "hasOwnProperty";
                str4 = "trim";
                if (!str4.equals(str)) {
                    throw new IllegalArgumentException(String.format("%s is not a String function", str));
                }
                switch (str.hashCode()) {
                    case -1789698943:
                        str5 = "charAt";
                        str6 = str3;
                        if (str.equals(str6)) {
                            c10 = 2;
                            break;
                        }
                        c10 = 65535;
                        break;
                    case -1776922004:
                        str5 = "charAt";
                        if (str.equals("toString")) {
                            c10 = 14;
                            str6 = str3;
                            break;
                        }
                        str6 = str3;
                        c10 = 65535;
                        break;
                    case -1464939364:
                        str5 = "charAt";
                        if (str.equals("toLocaleLowerCase")) {
                            c10 = '\f';
                            str6 = str3;
                            break;
                        }
                        str6 = str3;
                        c10 = 65535;
                        break;
                    case -1361633751:
                        str5 = "charAt";
                        if (str.equals(str5)) {
                            str6 = str3;
                            c10 = 0;
                            break;
                        }
                        str6 = str3;
                        c10 = 65535;
                        break;
                    case -1354795244:
                        if (str.equals("concat")) {
                            str5 = "charAt";
                            str6 = str3;
                            c10 = 1;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c10 = 65535;
                        break;
                    case -1137582698:
                        if (str.equals("toLowerCase")) {
                            c10 = '\r';
                            str5 = "charAt";
                            str6 = str3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c10 = 65535;
                        break;
                    case -906336856:
                        if (str.equals(FirebaseAnalytics.Event.SEARCH)) {
                            c10 = 7;
                            str5 = "charAt";
                            str6 = str3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c10 = 65535;
                        break;
                    case -726908483:
                        if (str.equals(str2)) {
                            c10 = 11;
                            str5 = "charAt";
                            str6 = str3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c10 = 65535;
                        break;
                    case -467511597:
                        if (str.equals("lastIndexOf")) {
                            c10 = 4;
                            str5 = "charAt";
                            str6 = str3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c10 = 65535;
                        break;
                    case -399551817:
                        if (str.equals("toUpperCase")) {
                            c10 = 15;
                            str5 = "charAt";
                            str6 = str3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c10 = 65535;
                        break;
                    case 3568674:
                        if (str.equals(str4)) {
                            c10 = 16;
                            str5 = "charAt";
                            str6 = str3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c10 = 65535;
                        break;
                    case 103668165:
                        if (str.equals("match")) {
                            c10 = 5;
                            str5 = "charAt";
                            str6 = str3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c10 = 65535;
                        break;
                    case 109526418:
                        if (str.equals("slice")) {
                            c10 = '\b';
                            str5 = "charAt";
                            str6 = str3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c10 = 65535;
                        break;
                    case 109648666:
                        if (str.equals("split")) {
                            c10 = '\t';
                            str5 = "charAt";
                            str6 = str3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c10 = 65535;
                        break;
                    case 530542161:
                        if (str.equals("substring")) {
                            c10 = '\n';
                            str5 = "charAt";
                            str6 = str3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c10 = 65535;
                        break;
                    case 1094496948:
                        if (str.equals("replace")) {
                            c10 = 6;
                            str5 = "charAt";
                            str6 = str3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c10 = 65535;
                        break;
                    case 1943291465:
                        if (str.equals("indexOf")) {
                            str5 = "charAt";
                            str6 = str3;
                            c10 = 3;
                            break;
                        }
                        str5 = "charAt";
                        str6 = str3;
                        c10 = 65535;
                        break;
                    default:
                        str5 = "charAt";
                        str6 = str3;
                        c10 = 65535;
                        break;
                }
                str7 = "undefined";
                double d10 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                switch (c10) {
                    case 0:
                        zzh.zzc(str5, 1, list);
                        int zzi = !list.isEmpty() ? (int) zzh.zzi(zzgVar.zza((zzao) list.get(0)).zzd().doubleValue()) : 0;
                        String str8 = this.zza;
                        if (zzi >= 0 && zzi < str8.length()) {
                            return new zzas(String.valueOf(str8.charAt(zzi)));
                        }
                        return zzao.zzm;
                    case 1:
                        zzasVar = this;
                        if (!list.isEmpty()) {
                            StringBuilder sb = new StringBuilder(zzasVar.zza);
                            for (int i16 = 0; i16 < list.size(); i16++) {
                                sb.append(zzgVar.zza((zzao) list.get(i16)).zzc());
                            }
                            zzasVar2 = new zzas(sb.toString());
                            return zzasVar2;
                        }
                        return zzasVar;
                    case 2:
                        zzasVar = this;
                        zzh.zza(str6, 1, list);
                        String str9 = zzasVar.zza;
                        zzao zza = zzgVar.zza((zzao) list.get(0));
                        if ("length".equals(zza.zzc())) {
                            zzaoVar = zzao.zzk;
                        } else {
                            double doubleValue = zza.zzd().doubleValue();
                            zzaoVar = (doubleValue != Math.floor(doubleValue) || (i10 = (int) doubleValue) < 0 || i10 >= str9.length()) ? zzao.zzl : zzao.zzk;
                        }
                        return zzaoVar;
                    case 3:
                        zzasVar = this;
                        zzh.zzc("indexOf", 2, list);
                        String str10 = zzasVar.zza;
                        String zzc = list.size() > 0 ? zzgVar.zza((zzao) list.get(0)).zzc() : "undefined";
                        if (list.size() >= 2) {
                            d10 = zzgVar.zza((zzao) list.get(1)).zzd().doubleValue();
                        }
                        zzasVar2 = new zzah(Double.valueOf(str10.indexOf(zzc, (int) zzh.zzi(d10))));
                        return zzasVar2;
                    case 4:
                        zzasVar = this;
                        zzh.zzc("lastIndexOf", 2, list);
                        String str11 = zzasVar.zza;
                        String zzc2 = list.size() > 0 ? zzgVar.zza((zzao) list.get(0)).zzc() : "undefined";
                        zzasVar2 = new zzah(Double.valueOf(str11.lastIndexOf(zzc2, (int) (Double.isNaN(list.size() < 2 ? Double.NaN : zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()) ? Double.POSITIVE_INFINITY : zzh.zzi(r0)))));
                        return zzasVar2;
                    case 5:
                        zzasVar = this;
                        zzh.zzc("match", 1, list);
                        Matcher matcher = Pattern.compile(list.size() <= 0 ? "" : zzgVar.zza((zzao) list.get(0)).zzc()).matcher(zzasVar.zza);
                        if (matcher.find()) {
                            zzasVar2 = new zzae(Arrays.asList(new zzas(matcher.group())));
                            return zzasVar2;
                        }
                        zzaoVar = zzao.zzg;
                        return zzaoVar;
                    case 6:
                        zzasVar = this;
                        zzh.zzc("replace", 2, list);
                        zzao zzaoVar2 = zzao.zzf;
                        if (!list.isEmpty()) {
                            str7 = zzgVar.zza((zzao) list.get(0)).zzc();
                            if (list.size() > 1) {
                                zzaoVar2 = zzgVar.zza((zzao) list.get(1));
                            }
                        }
                        String str12 = str7;
                        String str13 = zzasVar.zza;
                        int indexOf = str13.indexOf(str12);
                        if (indexOf >= 0) {
                            if (zzaoVar2 instanceof zzai) {
                                i11 = 0;
                                zzaoVar2 = ((zzai) zzaoVar2).zza(zzgVar, Arrays.asList(new zzas(str12), new zzah(Double.valueOf(indexOf)), zzasVar));
                            } else {
                                i11 = 0;
                            }
                            String substring = str13.substring(i11, indexOf);
                            String zzc3 = zzaoVar2.zzc();
                            String substring2 = str13.substring(indexOf + str12.length());
                            StringBuilder sb2 = new StringBuilder(String.valueOf(substring).length() + String.valueOf(zzc3).length() + String.valueOf(substring2).length());
                            sb2.append(substring);
                            sb2.append(zzc3);
                            sb2.append(substring2);
                            zzasVar2 = new zzas(sb2.toString());
                            return zzasVar2;
                        }
                        return zzasVar;
                    case 7:
                        zzasVar = this;
                        zzh.zzc(FirebaseAnalytics.Event.SEARCH, 1, list);
                        if (Pattern.compile(list.isEmpty() ? "undefined" : zzgVar.zza((zzao) list.get(0)).zzc()).matcher(zzasVar.zza).find()) {
                            zzasVar2 = new zzah(Double.valueOf(r0.start()));
                            return zzasVar2;
                        }
                        zzaoVar = new zzah(Double.valueOf(-1.0d));
                        return zzaoVar;
                    case '\b':
                        zzasVar = this;
                        zzh.zzc("slice", 2, list);
                        String str14 = zzasVar.zza;
                        double zzi2 = zzh.zzi(!list.isEmpty() ? zzgVar.zza((zzao) list.get(0)).zzd().doubleValue() : 0.0d);
                        if (zzi2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            min = Math.max(str14.length() + zzi2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        } else {
                            min = Math.min(zzi2, str14.length());
                        }
                        double zzi3 = zzh.zzi(list.size() > 1 ? zzgVar.zza((zzao) list.get(1)).zzd().doubleValue() : str14.length());
                        if (zzi3 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            min2 = Math.max(str14.length() + zzi3, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        } else {
                            min2 = Math.min(zzi3, str14.length());
                        }
                        int i17 = (int) min;
                        zzasVar2 = new zzas(str14.substring(i17, Math.max(0, ((int) min2) - i17) + i17));
                        return zzasVar2;
                    case '\t':
                        zzasVar = this;
                        zzh.zzc("split", 2, list);
                        String str15 = zzasVar.zza;
                        if (str15.length() == 0) {
                            zzaoVar = new zzae(Arrays.asList(zzasVar));
                        } else {
                            ArrayList arrayList = new ArrayList();
                            if (list.isEmpty()) {
                                arrayList.add(zzasVar);
                            } else {
                                String zzc4 = zzgVar.zza((zzao) list.get(0)).zzc();
                                long zzh = list.size() > 1 ? zzh.zzh(zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()) : 2147483647L;
                                if (zzh == 0) {
                                    zzaoVar = new zzae();
                                } else {
                                    String[] split = str15.split(Pattern.quote(zzc4), ((int) zzh) + 1);
                                    int length2 = split.length;
                                    if (!zzc4.isEmpty() || length2 <= 0) {
                                        i12 = -1;
                                        i13 = length2;
                                        i14 = 0;
                                    } else {
                                        boolean isEmpty = split[0].isEmpty();
                                        i12 = -1;
                                        i13 = length2 - 1;
                                        i14 = isEmpty;
                                        if (!split[i13].isEmpty()) {
                                            i13 = length2;
                                            i14 = isEmpty;
                                        }
                                    }
                                    if (length2 > zzh) {
                                        i13 += i12;
                                    }
                                    while (i14 < i13) {
                                        arrayList.add(new zzas(split[i14]));
                                        i14++;
                                    }
                                }
                            }
                            zzaoVar = new zzae(arrayList);
                        }
                        return zzaoVar;
                    case '\n':
                        zzasVar = this;
                        zzh.zzc("substring", 2, list);
                        String str16 = zzasVar.zza;
                        if (list.isEmpty()) {
                            zzgVar2 = zzgVar;
                            i15 = 0;
                        } else {
                            zzgVar2 = zzgVar;
                            i15 = (int) zzh.zzi(zzgVar2.zza((zzao) list.get(0)).zzd().doubleValue());
                        }
                        if (list.size() > 1) {
                            length = (int) zzh.zzi(zzgVar2.zza((zzao) list.get(1)).zzd().doubleValue());
                        } else {
                            length = str16.length();
                        }
                        int min3 = Math.min(Math.max(i15, 0), str16.length());
                        int min4 = Math.min(Math.max(length, 0), str16.length());
                        zzasVar2 = new zzas(str16.substring(Math.min(min3, min4), Math.max(min3, min4)));
                        return zzasVar2;
                    case 11:
                        zzasVar = this;
                        zzh.zza(str2, 0, list);
                        zzasVar2 = new zzas(zzasVar.zza.toUpperCase());
                        return zzasVar2;
                    case '\f':
                        zzasVar = this;
                        zzh.zza("toLocaleLowerCase", 0, list);
                        zzasVar2 = new zzas(zzasVar.zza.toLowerCase());
                        return zzasVar2;
                    case '\r':
                        zzasVar = this;
                        zzh.zza("toLowerCase", 0, list);
                        zzasVar2 = new zzas(zzasVar.zza.toLowerCase(Locale.ENGLISH));
                        return zzasVar2;
                    case 14:
                        zzasVar = this;
                        zzh.zza("toString", 0, list);
                        return zzasVar;
                    case 15:
                        zzasVar = this;
                        zzh.zza("toUpperCase", 0, list);
                        zzasVar2 = new zzas(zzasVar.zza.toUpperCase(Locale.ENGLISH));
                        return zzasVar2;
                    case 16:
                        zzh.zza("toUpperCase", 0, list);
                        zzasVar = this;
                        zzasVar2 = new zzas(zzasVar.zza.trim());
                        return zzasVar2;
                    default:
                        throw new IllegalArgumentException("Command not supported");
                }
            }
        }
        str3 = "hasOwnProperty";
        str4 = "trim";
        switch (str.hashCode()) {
            case -1789698943:
                break;
            case -1776922004:
                break;
            case -1464939364:
                break;
            case -1361633751:
                break;
            case -1354795244:
                break;
            case -1137582698:
                break;
            case -906336856:
                break;
            case -726908483:
                break;
            case -467511597:
                break;
            case -399551817:
                break;
            case 3568674:
                break;
            case 103668165:
                break;
            case 109526418:
                break;
            case 109648666:
                break;
            case 530542161:
                break;
            case 1094496948:
                break;
            case 1943291465:
                break;
        }
        str7 = "undefined";
        double d102 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        switch (c10) {
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        String str = this.zza;
        if (!str.isEmpty()) {
            try {
                return Double.valueOf(str);
            } catch (NumberFormatException unused) {
                return Double.valueOf(Double.NaN);
            }
        }
        return Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return new zzaq(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao zzt() {
        return new zzas(this.zza);
    }
}
