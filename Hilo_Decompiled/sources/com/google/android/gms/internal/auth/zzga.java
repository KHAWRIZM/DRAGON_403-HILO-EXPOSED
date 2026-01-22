package com.google.android.gms.internal.auth;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.KotlinVersion;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzga<T> implements zzgi<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhj.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfx zzg;
    private final int[] zzh;
    private final int zzi;
    private final int zzj;
    private final zzfl zzk;
    private final zzgz zzl;
    private final zzem zzm;
    private final zzgc zzn;
    private final zzfs zzo;

    private zzga(int[] iArr, Object[] objArr, int i10, int i11, zzfx zzfxVar, int i12, boolean z10, int[] iArr2, int i13, int i14, zzgc zzgcVar, zzfl zzflVar, zzgz zzgzVar, zzem zzemVar, zzfs zzfsVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i10;
        this.zzf = i11;
        this.zzh = iArr2;
        this.zzi = i13;
        this.zzj = i14;
        this.zzn = zzgcVar;
        this.zzk = zzflVar;
        this.zzl = zzgzVar;
        this.zzm = zzemVar;
        this.zzg = zzfxVar;
        this.zzo = zzfsVar;
    }

    private final void zzA(Object obj, int i10, int i11) {
        zzhj.zzn(obj, zzl(i11) & 1048575, i10);
    }

    private final void zzB(Object obj, int i10, Object obj2) {
        zzb.putObject(obj, zzo(i10) & 1048575, obj2);
        zzz(obj, i10);
    }

    private final void zzC(Object obj, int i10, int i11, Object obj2) {
        zzb.putObject(obj, zzo(i11) & 1048575, obj2);
        zzA(obj, i10, i11);
    }

    private final boolean zzD(Object obj, Object obj2, int i10) {
        if (zzE(obj, i10) == zzE(obj2, i10)) {
            return true;
        }
        return false;
    }

    private final boolean zzE(Object obj, int i10) {
        int zzl = zzl(i10);
        long j10 = zzl & 1048575;
        if (j10 == 1048575) {
            int zzo = zzo(i10);
            long j11 = zzo & 1048575;
            switch (zzn(zzo)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzhj.zza(obj, j11)) == 0) {
                        return false;
                    }
                    return true;
                case 1:
                    if (Float.floatToRawIntBits(zzhj.zzb(obj, j11)) == 0) {
                        return false;
                    }
                    return true;
                case 2:
                    if (zzhj.zzd(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (zzhj.zzd(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (zzhj.zzc(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (zzhj.zzd(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (zzhj.zzc(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return zzhj.zzt(obj, j11);
                case 8:
                    Object zzf = zzhj.zzf(obj, j11);
                    if (zzf instanceof String) {
                        if (((String) zzf).isEmpty()) {
                            return false;
                        }
                        return true;
                    }
                    if (zzf instanceof zzef) {
                        if (zzef.zzb.equals(zzf)) {
                            return false;
                        }
                        return true;
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (zzhj.zzf(obj, j11) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    if (zzef.zzb.equals(zzhj.zzf(obj, j11))) {
                        return false;
                    }
                    return true;
                case 11:
                    if (zzhj.zzc(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (zzhj.zzc(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (zzhj.zzc(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (zzhj.zzd(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (zzhj.zzc(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (zzhj.zzd(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (zzhj.zzf(obj, j11) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        }
        if ((zzhj.zzc(obj, j10) & (1 << (zzl >>> 20))) == 0) {
            return false;
        }
        return true;
    }

    private final boolean zzF(Object obj, int i10, int i11, int i12, int i13) {
        if (i11 == 1048575) {
            return zzE(obj, i10);
        }
        if ((i12 & i13) != 0) {
            return true;
        }
        return false;
    }

    private static boolean zzG(Object obj, int i10, zzgi zzgiVar) {
        return zzgiVar.zzi(zzhj.zzf(obj, i10 & 1048575));
    }

    private static boolean zzH(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzev) {
            return ((zzev) obj).zzm();
        }
        return true;
    }

    private final boolean zzI(Object obj, int i10, int i11) {
        if (zzhj.zzc(obj, zzl(i11) & 1048575) == i10) {
            return true;
        }
        return false;
    }

    static zzha zzc(Object obj) {
        zzev zzevVar = (zzev) obj;
        zzha zzhaVar = zzevVar.zzc;
        if (zzhaVar == zzha.zza()) {
            zzha zzd = zzha.zzd();
            zzevVar.zzc = zzd;
            return zzd;
        }
        return zzhaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:65:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0255  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzga zzj(Class cls, zzfu zzfuVar, zzgc zzgcVar, zzfl zzflVar, zzgz zzgzVar, zzem zzemVar, zzfs zzfsVar) {
        int i10;
        int charAt;
        int charAt2;
        int i11;
        int[] iArr;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        char charAt3;
        int i17;
        char charAt4;
        int i18;
        char charAt5;
        int i19;
        char charAt6;
        int i20;
        char charAt7;
        int i21;
        char charAt8;
        int i22;
        char charAt9;
        int i23;
        char charAt10;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        String str;
        int i30;
        int i31;
        int i32;
        int i33;
        Field zzv;
        char charAt11;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        Object obj;
        Field zzv2;
        Object obj2;
        Field zzv3;
        int i39;
        char charAt12;
        int i40;
        char charAt13;
        int i41;
        char charAt14;
        int i42;
        char charAt15;
        if (zzfuVar instanceof zzgh) {
            zzgh zzghVar = (zzgh) zzfuVar;
            String zzd = zzghVar.zzd();
            int length = zzd.length();
            char c10 = 55296;
            if (zzd.charAt(0) >= 55296) {
                int i43 = 1;
                while (true) {
                    i10 = i43 + 1;
                    if (zzd.charAt(i43) < 55296) {
                        break;
                    }
                    i43 = i10;
                }
            } else {
                i10 = 1;
            }
            int i44 = i10 + 1;
            int charAt16 = zzd.charAt(i10);
            if (charAt16 >= 55296) {
                int i45 = charAt16 & 8191;
                int i46 = 13;
                while (true) {
                    i42 = i44 + 1;
                    charAt15 = zzd.charAt(i44);
                    if (charAt15 < 55296) {
                        break;
                    }
                    i45 |= (charAt15 & 8191) << i46;
                    i46 += 13;
                    i44 = i42;
                }
                charAt16 = i45 | (charAt15 << i46);
                i44 = i42;
            }
            if (charAt16 == 0) {
                iArr = zza;
                i14 = 0;
                charAt = 0;
                charAt2 = 0;
                i12 = 0;
                i15 = 0;
                i11 = 0;
                i13 = 0;
            } else {
                int i47 = i44 + 1;
                int charAt17 = zzd.charAt(i44);
                if (charAt17 >= 55296) {
                    int i48 = charAt17 & 8191;
                    int i49 = 13;
                    while (true) {
                        i23 = i47 + 1;
                        charAt10 = zzd.charAt(i47);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i48 |= (charAt10 & 8191) << i49;
                        i49 += 13;
                        i47 = i23;
                    }
                    charAt17 = i48 | (charAt10 << i49);
                    i47 = i23;
                }
                int i50 = i47 + 1;
                int charAt18 = zzd.charAt(i47);
                if (charAt18 >= 55296) {
                    int i51 = charAt18 & 8191;
                    int i52 = 13;
                    while (true) {
                        i22 = i50 + 1;
                        charAt9 = zzd.charAt(i50);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i51 |= (charAt9 & 8191) << i52;
                        i52 += 13;
                        i50 = i22;
                    }
                    charAt18 = i51 | (charAt9 << i52);
                    i50 = i22;
                }
                int i53 = i50 + 1;
                int charAt19 = zzd.charAt(i50);
                if (charAt19 >= 55296) {
                    int i54 = charAt19 & 8191;
                    int i55 = 13;
                    while (true) {
                        i21 = i53 + 1;
                        charAt8 = zzd.charAt(i53);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i54 |= (charAt8 & 8191) << i55;
                        i55 += 13;
                        i53 = i21;
                    }
                    charAt19 = i54 | (charAt8 << i55);
                    i53 = i21;
                }
                int i56 = i53 + 1;
                int charAt20 = zzd.charAt(i53);
                if (charAt20 >= 55296) {
                    int i57 = charAt20 & 8191;
                    int i58 = 13;
                    while (true) {
                        i20 = i56 + 1;
                        charAt7 = zzd.charAt(i56);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i57 |= (charAt7 & 8191) << i58;
                        i58 += 13;
                        i56 = i20;
                    }
                    charAt20 = i57 | (charAt7 << i58);
                    i56 = i20;
                }
                int i59 = i56 + 1;
                charAt = zzd.charAt(i56);
                if (charAt >= 55296) {
                    int i60 = charAt & 8191;
                    int i61 = 13;
                    while (true) {
                        i19 = i59 + 1;
                        charAt6 = zzd.charAt(i59);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i60 |= (charAt6 & 8191) << i61;
                        i61 += 13;
                        i59 = i19;
                    }
                    charAt = i60 | (charAt6 << i61);
                    i59 = i19;
                }
                int i62 = i59 + 1;
                charAt2 = zzd.charAt(i59);
                if (charAt2 >= 55296) {
                    int i63 = charAt2 & 8191;
                    int i64 = 13;
                    while (true) {
                        i18 = i62 + 1;
                        charAt5 = zzd.charAt(i62);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i63 |= (charAt5 & 8191) << i64;
                        i64 += 13;
                        i62 = i18;
                    }
                    charAt2 = i63 | (charAt5 << i64);
                    i62 = i18;
                }
                int i65 = i62 + 1;
                int charAt21 = zzd.charAt(i62);
                if (charAt21 >= 55296) {
                    int i66 = charAt21 & 8191;
                    int i67 = 13;
                    while (true) {
                        i17 = i65 + 1;
                        charAt4 = zzd.charAt(i65);
                        if (charAt4 < 55296) {
                            break;
                        }
                        i66 |= (charAt4 & 8191) << i67;
                        i67 += 13;
                        i65 = i17;
                    }
                    charAt21 = i66 | (charAt4 << i67);
                    i65 = i17;
                }
                int i68 = i65 + 1;
                int charAt22 = zzd.charAt(i65);
                if (charAt22 >= 55296) {
                    int i69 = charAt22 & 8191;
                    int i70 = 13;
                    while (true) {
                        i16 = i68 + 1;
                        charAt3 = zzd.charAt(i68);
                        if (charAt3 < 55296) {
                            break;
                        }
                        i69 |= (charAt3 & 8191) << i70;
                        i70 += 13;
                        i68 = i16;
                    }
                    charAt22 = i69 | (charAt3 << i70);
                    i68 = i16;
                }
                i11 = charAt17 + charAt17 + charAt18;
                iArr = new int[charAt22 + charAt2 + charAt21];
                i12 = charAt19;
                i13 = charAt22;
                i14 = charAt17;
                i15 = charAt20;
                i44 = i68;
            }
            Unsafe unsafe = zzb;
            Object[] zze = zzghVar.zze();
            Class<?> cls2 = zzghVar.zza().getClass();
            int i71 = i13 + charAt2;
            int i72 = charAt + charAt;
            int[] iArr2 = new int[charAt * 3];
            Object[] objArr = new Object[i72];
            int i73 = i13;
            int i74 = i71;
            int i75 = 0;
            int i76 = 0;
            while (i44 < length) {
                int i77 = i44 + 1;
                int charAt23 = zzd.charAt(i44);
                if (charAt23 >= c10) {
                    int i78 = charAt23 & 8191;
                    int i79 = i77;
                    int i80 = 13;
                    while (true) {
                        i41 = i79 + 1;
                        charAt14 = zzd.charAt(i79);
                        if (charAt14 < c10) {
                            break;
                        }
                        i78 |= (charAt14 & 8191) << i80;
                        i80 += 13;
                        i79 = i41;
                    }
                    charAt23 = i78 | (charAt14 << i80);
                    i24 = i41;
                } else {
                    i24 = i77;
                }
                int i81 = i24 + 1;
                int charAt24 = zzd.charAt(i24);
                if (charAt24 >= c10) {
                    int i82 = charAt24 & 8191;
                    int i83 = i81;
                    int i84 = 13;
                    while (true) {
                        i40 = i83 + 1;
                        charAt13 = zzd.charAt(i83);
                        if (charAt13 < c10) {
                            break;
                        }
                        i82 |= (charAt13 & 8191) << i84;
                        i84 += 13;
                        i83 = i40;
                    }
                    charAt24 = i82 | (charAt13 << i84);
                    i25 = i40;
                } else {
                    i25 = i81;
                }
                if ((charAt24 & 1024) != 0) {
                    iArr[i75] = i76;
                    i75++;
                }
                int i85 = charAt24 & KotlinVersion.MAX_COMPONENT_VALUE;
                if (i85 >= 51) {
                    int i86 = i25 + 1;
                    int charAt25 = zzd.charAt(i25);
                    i26 = length;
                    char c11 = 55296;
                    if (charAt25 >= 55296) {
                        int i87 = charAt25 & 8191;
                        int i88 = 13;
                        while (true) {
                            i39 = i86 + 1;
                            charAt12 = zzd.charAt(i86);
                            if (charAt12 < c11) {
                                break;
                            }
                            i87 |= (charAt12 & 8191) << i88;
                            i88 += 13;
                            i86 = i39;
                            c11 = 55296;
                        }
                        charAt25 = i87 | (charAt12 << i88);
                        i86 = i39;
                    }
                    int i89 = i85 - 51;
                    int i90 = i86;
                    if (i89 != 9 && i89 != 17) {
                        if (i89 == 12 && (zzghVar.zzc() == 1 || (charAt24 & 2048) != 0)) {
                            int i91 = i76 / 3;
                            i38 = i11 + 1;
                            objArr[i91 + i91 + 1] = zze[i11];
                        }
                        int i92 = charAt25 + charAt25;
                        obj = zze[i92];
                        if (!(obj instanceof Field)) {
                            zzv2 = (Field) obj;
                        } else {
                            zzv2 = zzv(cls2, (String) obj);
                            zze[i92] = zzv2;
                        }
                        int i93 = i12;
                        i27 = i15;
                        i33 = (int) unsafe.objectFieldOffset(zzv2);
                        int i94 = i92 + 1;
                        obj2 = zze[i94];
                        if (!(obj2 instanceof Field)) {
                            zzv3 = (Field) obj2;
                        } else {
                            zzv3 = zzv(cls2, (String) obj2);
                            zze[i94] = zzv3;
                        }
                        int objectFieldOffset = (int) unsafe.objectFieldOffset(zzv3);
                        str = zzd;
                        i28 = i93;
                        i30 = i11;
                        i31 = i90;
                        i29 = objectFieldOffset;
                        i32 = 0;
                    } else {
                        int i95 = i76 / 3;
                        i38 = i11 + 1;
                        objArr[i95 + i95 + 1] = zze[i11];
                    }
                    i11 = i38;
                    int i922 = charAt25 + charAt25;
                    obj = zze[i922];
                    if (!(obj instanceof Field)) {
                    }
                    int i932 = i12;
                    i27 = i15;
                    i33 = (int) unsafe.objectFieldOffset(zzv2);
                    int i942 = i922 + 1;
                    obj2 = zze[i942];
                    if (!(obj2 instanceof Field)) {
                    }
                    int objectFieldOffset2 = (int) unsafe.objectFieldOffset(zzv3);
                    str = zzd;
                    i28 = i932;
                    i30 = i11;
                    i31 = i90;
                    i29 = objectFieldOffset2;
                    i32 = 0;
                } else {
                    i26 = length;
                    int i96 = i12;
                    i27 = i15;
                    int i97 = i11 + 1;
                    Field zzv4 = zzv(cls2, (String) zze[i11]);
                    if (i85 == 9 || i85 == 17) {
                        i28 = i96;
                        int i98 = i76 / 3;
                        objArr[i98 + i98 + 1] = zzv4.getType();
                    } else {
                        if (i85 == 27 || i85 == 49) {
                            i28 = i96;
                            int i99 = i76 / 3;
                            i34 = i11 + 2;
                            objArr[i99 + i99 + 1] = zze[i97];
                        } else if (i85 != 12 && i85 != 30 && i85 != 44) {
                            if (i85 == 50) {
                                int i100 = i73 + 1;
                                iArr[i73] = i76;
                                int i101 = i76 / 3;
                                int i102 = i11 + 2;
                                int i103 = i101 + i101;
                                objArr[i103] = zze[i97];
                                if ((charAt24 & 2048) != 0) {
                                    i97 = i11 + 3;
                                    objArr[i103 + 1] = zze[i102];
                                    i28 = i96;
                                    i73 = i100;
                                } else {
                                    i73 = i100;
                                    i97 = i102;
                                }
                            }
                            i28 = i96;
                        } else {
                            i28 = i96;
                            if (zzghVar.zzc() == 1 || (charAt24 & 2048) != 0) {
                                int i104 = i76 / 3;
                                i34 = i11 + 2;
                                objArr[i104 + i104 + 1] = zze[i97];
                            }
                        }
                        i97 = i34;
                    }
                    int objectFieldOffset3 = (int) unsafe.objectFieldOffset(zzv4);
                    i29 = 1048575;
                    if ((charAt24 & 4096) != 0 && i85 <= 17) {
                        int i105 = i25 + 1;
                        int charAt26 = zzd.charAt(i25);
                        if (charAt26 >= 55296) {
                            int i106 = charAt26 & 8191;
                            int i107 = 13;
                            while (true) {
                                i31 = i105 + 1;
                                charAt11 = zzd.charAt(i105);
                                if (charAt11 < 55296) {
                                    break;
                                }
                                i106 |= (charAt11 & 8191) << i107;
                                i107 += 13;
                                i105 = i31;
                            }
                            charAt26 = i106 | (charAt11 << i107);
                        } else {
                            i31 = i105;
                        }
                        int i108 = i14 + i14 + (charAt26 / 32);
                        Object obj3 = zze[i108];
                        str = zzd;
                        if (obj3 instanceof Field) {
                            zzv = (Field) obj3;
                        } else {
                            zzv = zzv(cls2, (String) obj3);
                            zze[i108] = zzv;
                        }
                        i30 = i97;
                        i32 = charAt26 % 32;
                        i29 = (int) unsafe.objectFieldOffset(zzv);
                    } else {
                        str = zzd;
                        i30 = i97;
                        i31 = i25;
                        i32 = 0;
                    }
                    if (i85 >= 18 && i85 <= 49) {
                        iArr[i74] = objectFieldOffset3;
                        i74++;
                    }
                    i33 = objectFieldOffset3;
                }
                int i109 = i76 + 1;
                iArr2[i76] = charAt23;
                int i110 = i76 + 2;
                if ((charAt24 & 512) != 0) {
                    i35 = 536870912;
                } else {
                    i35 = 0;
                }
                if ((charAt24 & 256) != 0) {
                    i36 = 268435456;
                } else {
                    i36 = 0;
                }
                if ((charAt24 & 2048) != 0) {
                    i37 = Integer.MIN_VALUE;
                } else {
                    i37 = 0;
                }
                iArr2[i109] = i33 | i37 | i35 | i36 | (i85 << 20);
                i76 += 3;
                iArr2[i110] = (i32 << 20) | i29;
                i11 = i30;
                i44 = i31;
                length = i26;
                i12 = i28;
                zzd = str;
                i15 = i27;
                c10 = 55296;
            }
            return new zzga(iArr2, objArr, i12, i15, zzghVar.zza(), zzghVar.zzc(), false, iArr, i13, i71, zzgcVar, zzflVar, zzgzVar, zzemVar, zzfsVar);
        }
        throw null;
    }

    private static int zzk(Object obj, long j10) {
        return ((Integer) zzhj.zzf(obj, j10)).intValue();
    }

    private final int zzl(int i10) {
        return this.zzc[i10 + 2];
    }

    private final int zzm(int i10, int i11) {
        int length = (this.zzc.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int i14 = this.zzc[i13];
            if (i10 == i14) {
                return i13;
            }
            if (i10 < i14) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    private static int zzn(int i10) {
        return (i10 >>> 20) & KotlinVersion.MAX_COMPONENT_VALUE;
    }

    private final int zzo(int i10) {
        return this.zzc[i10 + 1];
    }

    private static long zzp(Object obj, long j10) {
        return ((Long) zzhj.zzf(obj, j10)).longValue();
    }

    private final zzey zzq(int i10) {
        int i11 = i10 / 3;
        return (zzey) this.zzd[i11 + i11 + 1];
    }

    private final zzgi zzr(int i10) {
        int i11 = i10 / 3;
        int i12 = i11 + i11;
        zzgi zzgiVar = (zzgi) this.zzd[i12];
        if (zzgiVar != null) {
            return zzgiVar;
        }
        zzgi zzb2 = zzgf.zza().zzb((Class) this.zzd[i12 + 1]);
        this.zzd[i12] = zzb2;
        return zzb2;
    }

    private final Object zzs(int i10) {
        int i11 = i10 / 3;
        return this.zzd[i11 + i11];
    }

    private final Object zzt(Object obj, int i10) {
        zzgi zzr = zzr(i10);
        int zzo = zzo(i10) & 1048575;
        if (!zzE(obj, i10)) {
            return zzr.zzd();
        }
        Object object = zzb.getObject(obj, zzo);
        if (zzH(object)) {
            return object;
        }
        Object zzd = zzr.zzd();
        if (object != null) {
            zzr.zzf(zzd, object);
        }
        return zzd;
    }

    private final Object zzu(Object obj, int i10, int i11) {
        zzgi zzr = zzr(i11);
        if (!zzI(obj, i10, i11)) {
            return zzr.zzd();
        }
        Object object = zzb.getObject(obj, zzo(i11) & 1048575);
        if (zzH(object)) {
            return object;
        }
        Object zzd = zzr.zzd();
        if (object != null) {
            zzr.zzf(zzd, object);
        }
        return zzd;
    }

    private static Field zzv(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zzw(Object obj) {
        if (zzH(obj)) {
        } else {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzx(Object obj, Object obj2, int i10) {
        if (!zzE(obj2, i10)) {
            return;
        }
        int zzo = zzo(i10) & 1048575;
        Unsafe unsafe = zzb;
        long j10 = zzo;
        Object object = unsafe.getObject(obj2, j10);
        if (object != null) {
            zzgi zzr = zzr(i10);
            if (!zzE(obj, i10)) {
                if (!zzH(object)) {
                    unsafe.putObject(obj, j10, object);
                } else {
                    Object zzd = zzr.zzd();
                    zzr.zzf(zzd, object);
                    unsafe.putObject(obj, j10, zzd);
                }
                zzz(obj, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, j10);
            if (!zzH(object2)) {
                Object zzd2 = zzr.zzd();
                zzr.zzf(zzd2, object2);
                unsafe.putObject(obj, j10, zzd2);
                object2 = zzd2;
            }
            zzr.zzf(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + this.zzc[i10] + " is present but null: " + obj2.toString());
    }

    private final void zzy(Object obj, Object obj2, int i10) {
        int i11 = this.zzc[i10];
        if (!zzI(obj2, i11, i10)) {
            return;
        }
        int zzo = zzo(i10) & 1048575;
        Unsafe unsafe = zzb;
        long j10 = zzo;
        Object object = unsafe.getObject(obj2, j10);
        if (object != null) {
            zzgi zzr = zzr(i10);
            if (!zzI(obj, i11, i10)) {
                if (!zzH(object)) {
                    unsafe.putObject(obj, j10, object);
                } else {
                    Object zzd = zzr.zzd();
                    zzr.zzf(zzd, object);
                    unsafe.putObject(obj, j10, zzd);
                }
                zzA(obj, i11, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, j10);
            if (!zzH(object2)) {
                Object zzd2 = zzr.zzd();
                zzr.zzf(zzd2, object2);
                unsafe.putObject(obj, j10, zzd2);
                object2 = zzd2;
            }
            zzr.zzf(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + this.zzc[i10] + " is present but null: " + obj2.toString());
    }

    private final void zzz(Object obj, int i10) {
        int zzl = zzl(i10);
        long j10 = 1048575 & zzl;
        if (j10 == 1048575) {
            return;
        }
        zzhj.zzn(obj, j10, (1 << (zzl >>> 20)) | zzhj.zzc(obj, j10));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001c. Please report as an issue. */
    @Override // com.google.android.gms.internal.auth.zzgi
    public final int zza(Object obj) {
        int i10;
        long doubleToLongBits;
        int i11;
        int floatToIntBits;
        int length = this.zzc.length;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13 += 3) {
            int zzo = zzo(i13);
            int i14 = this.zzc[i13];
            long j10 = 1048575 & zzo;
            int i15 = 37;
            switch (zzn(zzo)) {
                case 0:
                    i10 = i12 * 53;
                    doubleToLongBits = Double.doubleToLongBits(zzhj.zza(obj, j10));
                    byte[] bArr = zzfa.zzd;
                    i12 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 1:
                    i11 = i12 * 53;
                    floatToIntBits = Float.floatToIntBits(zzhj.zzb(obj, j10));
                    i12 = i11 + floatToIntBits;
                    break;
                case 2:
                    i10 = i12 * 53;
                    doubleToLongBits = zzhj.zzd(obj, j10);
                    byte[] bArr2 = zzfa.zzd;
                    i12 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 3:
                    i10 = i12 * 53;
                    doubleToLongBits = zzhj.zzd(obj, j10);
                    byte[] bArr3 = zzfa.zzd;
                    i12 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 4:
                    i11 = i12 * 53;
                    floatToIntBits = zzhj.zzc(obj, j10);
                    i12 = i11 + floatToIntBits;
                    break;
                case 5:
                    i10 = i12 * 53;
                    doubleToLongBits = zzhj.zzd(obj, j10);
                    byte[] bArr4 = zzfa.zzd;
                    i12 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 6:
                    i11 = i12 * 53;
                    floatToIntBits = zzhj.zzc(obj, j10);
                    i12 = i11 + floatToIntBits;
                    break;
                case 7:
                    i11 = i12 * 53;
                    floatToIntBits = zzfa.zza(zzhj.zzt(obj, j10));
                    i12 = i11 + floatToIntBits;
                    break;
                case 8:
                    i11 = i12 * 53;
                    floatToIntBits = ((String) zzhj.zzf(obj, j10)).hashCode();
                    i12 = i11 + floatToIntBits;
                    break;
                case 9:
                    Object zzf = zzhj.zzf(obj, j10);
                    if (zzf != null) {
                        i15 = zzf.hashCode();
                    }
                    i12 = (i12 * 53) + i15;
                    break;
                case 10:
                    i11 = i12 * 53;
                    floatToIntBits = zzhj.zzf(obj, j10).hashCode();
                    i12 = i11 + floatToIntBits;
                    break;
                case 11:
                    i11 = i12 * 53;
                    floatToIntBits = zzhj.zzc(obj, j10);
                    i12 = i11 + floatToIntBits;
                    break;
                case 12:
                    i11 = i12 * 53;
                    floatToIntBits = zzhj.zzc(obj, j10);
                    i12 = i11 + floatToIntBits;
                    break;
                case 13:
                    i11 = i12 * 53;
                    floatToIntBits = zzhj.zzc(obj, j10);
                    i12 = i11 + floatToIntBits;
                    break;
                case 14:
                    i10 = i12 * 53;
                    doubleToLongBits = zzhj.zzd(obj, j10);
                    byte[] bArr5 = zzfa.zzd;
                    i12 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 15:
                    i11 = i12 * 53;
                    floatToIntBits = zzhj.zzc(obj, j10);
                    i12 = i11 + floatToIntBits;
                    break;
                case 16:
                    i10 = i12 * 53;
                    doubleToLongBits = zzhj.zzd(obj, j10);
                    byte[] bArr6 = zzfa.zzd;
                    i12 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 17:
                    Object zzf2 = zzhj.zzf(obj, j10);
                    if (zzf2 != null) {
                        i15 = zzf2.hashCode();
                    }
                    i12 = (i12 * 53) + i15;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i11 = i12 * 53;
                    floatToIntBits = zzhj.zzf(obj, j10).hashCode();
                    i12 = i11 + floatToIntBits;
                    break;
                case 50:
                    i11 = i12 * 53;
                    floatToIntBits = zzhj.zzf(obj, j10).hashCode();
                    i12 = i11 + floatToIntBits;
                    break;
                case 51:
                    if (zzI(obj, i14, i13)) {
                        i10 = i12 * 53;
                        doubleToLongBits = Double.doubleToLongBits(((Double) zzhj.zzf(obj, j10)).doubleValue());
                        byte[] bArr7 = zzfa.zzd;
                        i12 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzI(obj, i14, i13)) {
                        i11 = i12 * 53;
                        floatToIntBits = Float.floatToIntBits(((Float) zzhj.zzf(obj, j10)).floatValue());
                        i12 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzI(obj, i14, i13)) {
                        i10 = i12 * 53;
                        doubleToLongBits = zzp(obj, j10);
                        byte[] bArr8 = zzfa.zzd;
                        i12 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzI(obj, i14, i13)) {
                        i10 = i12 * 53;
                        doubleToLongBits = zzp(obj, j10);
                        byte[] bArr9 = zzfa.zzd;
                        i12 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzI(obj, i14, i13)) {
                        i11 = i12 * 53;
                        floatToIntBits = zzk(obj, j10);
                        i12 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzI(obj, i14, i13)) {
                        i10 = i12 * 53;
                        doubleToLongBits = zzp(obj, j10);
                        byte[] bArr10 = zzfa.zzd;
                        i12 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzI(obj, i14, i13)) {
                        i11 = i12 * 53;
                        floatToIntBits = zzk(obj, j10);
                        i12 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzI(obj, i14, i13)) {
                        i11 = i12 * 53;
                        floatToIntBits = zzfa.zza(((Boolean) zzhj.zzf(obj, j10)).booleanValue());
                        i12 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzI(obj, i14, i13)) {
                        i11 = i12 * 53;
                        floatToIntBits = ((String) zzhj.zzf(obj, j10)).hashCode();
                        i12 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzI(obj, i14, i13)) {
                        i11 = i12 * 53;
                        floatToIntBits = zzhj.zzf(obj, j10).hashCode();
                        i12 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzI(obj, i14, i13)) {
                        i11 = i12 * 53;
                        floatToIntBits = zzhj.zzf(obj, j10).hashCode();
                        i12 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzI(obj, i14, i13)) {
                        i11 = i12 * 53;
                        floatToIntBits = zzk(obj, j10);
                        i12 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzI(obj, i14, i13)) {
                        i11 = i12 * 53;
                        floatToIntBits = zzk(obj, j10);
                        i12 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzI(obj, i14, i13)) {
                        i11 = i12 * 53;
                        floatToIntBits = zzk(obj, j10);
                        i12 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzI(obj, i14, i13)) {
                        i10 = i12 * 53;
                        doubleToLongBits = zzp(obj, j10);
                        byte[] bArr11 = zzfa.zzd;
                        i12 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzI(obj, i14, i13)) {
                        i11 = i12 * 53;
                        floatToIntBits = zzk(obj, j10);
                        i12 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzI(obj, i14, i13)) {
                        i10 = i12 * 53;
                        doubleToLongBits = zzp(obj, j10);
                        byte[] bArr12 = zzfa.zzd;
                        i12 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzI(obj, i14, i13)) {
                        i11 = i12 * 53;
                        floatToIntBits = zzhj.zzf(obj, j10).hashCode();
                        i12 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return (i12 * 53) + this.zzl.zzb(obj).hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0ee1, code lost:
    
        if (r1 == r4) goto L٥٦٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0ee3, code lost:
    
        r43.putInt(r12, r1, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0ee9, code lost:
    
        r1 = r0.zzi;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0eed, code lost:
    
        if (r1 >= r0.zzj) goto L٦٨٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0eef, code lost:
    
        r3 = r0.zzh[r1];
        r4 = r0.zzc[r3];
        r4 = com.google.android.gms.internal.auth.zzhj.zzf(r12, r0.zzo(r3) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0f04, code lost:
    
        if (r4 != null) goto L٥٧١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0f0b, code lost:
    
        if (r0.zzq(r3) != null) goto L٦٨٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0f0f, code lost:
    
        r4 = (com.google.android.gms.internal.auth.zzfr) r4;
        r1 = (com.google.android.gms.internal.auth.zzfq) r0.zzs(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0f17, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0f0d, code lost:
    
        r1 = r1 + r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0f18, code lost:
    
        if (r9 != 0) goto L٥٨١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0f1a, code lost:
    
        if (r8 != r10) goto L٥٧٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0f21, code lost:
    
        throw com.google.android.gms.internal.auth.zzfb.zzd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0f26, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0f22, code lost:
    
        if (r8 > r10) goto L٥٨٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0f24, code lost:
    
        if (r11 != r9) goto L٥٨٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0f2b, code lost:
    
        throw com.google.android.gms.internal.auth.zzfb.zzd();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:163:0x051f. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x0bb5. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:546:0x00c2. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0b2d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0b45 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0e79 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0e91 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:586:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:734:0x0055 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzb(Object obj, byte[] bArr, int i10, int i11, int i12, zzdt zzdtVar) throws IOException {
        int i13;
        int i14;
        Object obj2;
        Unsafe unsafe;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int zzm;
        int i21;
        int i22;
        int i23;
        int i24;
        Object obj3;
        zzdt zzdtVar2;
        int i25;
        int i26;
        zzdt zzdtVar3;
        int i27;
        int i28;
        int i29;
        Unsafe unsafe2;
        int i30;
        Unsafe unsafe3;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        zzdt zzdtVar4;
        int i38;
        Object obj4;
        int i39;
        int i40;
        byte[] bArr2;
        int i41;
        int i42;
        int i43;
        int i44;
        zzga<T> zzgaVar;
        byte[] bArr3;
        int i45;
        zzga<T> zzgaVar2;
        int i46;
        int zzf;
        byte[] bArr4;
        int i47;
        int i48;
        byte[] bArr5;
        int i49;
        int i50;
        int i51;
        int zzj;
        int i52;
        int i53;
        int i54;
        int zzh;
        int i55;
        int i56;
        Object obj5;
        zzdt zzdtVar5;
        int i57;
        zzga<T> zzgaVar3 = this;
        Object obj6 = obj;
        byte[] bArr6 = bArr;
        int i58 = i11;
        int i59 = i12;
        zzdt zzdtVar6 = zzdtVar;
        int i60 = 3;
        zzw(obj);
        Unsafe unsafe4 = zzb;
        int i61 = 0;
        int i62 = -1;
        int i63 = i10;
        int i64 = -1;
        int i65 = 0;
        int i66 = 1048575;
        int i67 = 0;
        int i68 = 0;
        while (true) {
            if (i63 < i58) {
                int i69 = i63 + 1;
                int i70 = bArr6[i63];
                if (i70 < 0) {
                    i69 = zzdu.zzi(i70, bArr6, i69, zzdtVar6);
                    i70 = zzdtVar6.zza;
                }
                int i71 = i70 >>> 3;
                if (i71 > i64) {
                    zzm = (i71 < zzgaVar3.zze || i71 > zzgaVar3.zzf) ? -1 : zzgaVar3.zzm(i71, i65 / i60);
                } else if (i71 < zzgaVar3.zze || i71 > zzgaVar3.zzf) {
                    i20 = -1;
                    if (i20 == i62) {
                        int i72 = i70 & 7;
                        int[] iArr = zzgaVar3.zzc;
                        int i73 = iArr[i20 + 1];
                        int zzn = zzn(i73);
                        long j10 = i73 & 1048575;
                        int i74 = i70;
                        if (zzn > 17) {
                            zzdt zzdtVar7 = zzdtVar6;
                            int i75 = i20;
                            Unsafe unsafe5 = unsafe4;
                            int i76 = i66;
                            if (zzn != 27) {
                                int i77 = i69;
                                Unsafe unsafe6 = unsafe5;
                                if (zzn > 49) {
                                    i22 = i76;
                                    unsafe = unsafe6;
                                    byte[] bArr7 = bArr;
                                    i38 = i74;
                                    i36 = i77;
                                    i37 = i71;
                                    i35 = i11;
                                    zzga<T> zzgaVar4 = zzgaVar3;
                                    if (zzn != 50) {
                                        Unsafe unsafe7 = zzb;
                                        long j11 = iArr[i75 + 2] & 1048575;
                                        switch (zzn) {
                                            case 51:
                                                obj3 = obj;
                                                i56 = i75;
                                                i21 = i37;
                                                zzdtVar2 = zzdtVar;
                                                i13 = i11;
                                                i17 = i38;
                                                if (i72 == 1) {
                                                    unsafe7.putObject(obj3, j10, Double.valueOf(Double.longBitsToDouble(zzdu.zzn(bArr7, i36))));
                                                    i24 = i36 + 8;
                                                    unsafe7.putInt(obj3, j11, i21);
                                                    if (i24 == i36) {
                                                        i14 = i12;
                                                        i23 = i56;
                                                        break;
                                                    } else {
                                                        unsafe4 = unsafe;
                                                        i59 = i12;
                                                        i64 = i21;
                                                        bArr6 = bArr7;
                                                        i63 = i24;
                                                        zzdtVar6 = zzdtVar2;
                                                        i58 = i13;
                                                        i68 = i17;
                                                        i65 = i56;
                                                        i66 = i22;
                                                        i60 = 3;
                                                        i62 = -1;
                                                        i61 = 0;
                                                        zzgaVar3 = this;
                                                        obj6 = obj3;
                                                    }
                                                }
                                                i24 = i36;
                                                if (i24 == i36) {
                                                }
                                            case 52:
                                                obj3 = obj;
                                                i56 = i75;
                                                i21 = i37;
                                                zzdtVar2 = zzdtVar;
                                                i13 = i11;
                                                i17 = i38;
                                                if (i72 == 5) {
                                                    unsafe7.putObject(obj3, j10, Float.valueOf(Float.intBitsToFloat(zzdu.zzb(bArr7, i36))));
                                                    i24 = i36 + 4;
                                                    unsafe7.putInt(obj3, j11, i21);
                                                    if (i24 == i36) {
                                                    }
                                                }
                                                i24 = i36;
                                                if (i24 == i36) {
                                                }
                                                break;
                                            case 53:
                                            case 54:
                                                obj3 = obj;
                                                i56 = i75;
                                                i21 = i37;
                                                zzdtVar2 = zzdtVar;
                                                i13 = i11;
                                                i17 = i38;
                                                if (i72 == 0) {
                                                    i24 = zzdu.zzk(bArr7, i36, zzdtVar2);
                                                    unsafe7.putObject(obj3, j10, Long.valueOf(zzdtVar2.zzb));
                                                    unsafe7.putInt(obj3, j11, i21);
                                                    if (i24 == i36) {
                                                    }
                                                }
                                                i24 = i36;
                                                if (i24 == i36) {
                                                }
                                                break;
                                            case 55:
                                            case 62:
                                                obj3 = obj;
                                                i56 = i75;
                                                i21 = i37;
                                                zzdtVar2 = zzdtVar;
                                                i13 = i11;
                                                i17 = i38;
                                                if (i72 == 0) {
                                                    i24 = zzdu.zzh(bArr7, i36, zzdtVar2);
                                                    unsafe7.putObject(obj3, j10, Integer.valueOf(zzdtVar2.zza));
                                                    unsafe7.putInt(obj3, j11, i21);
                                                    if (i24 == i36) {
                                                    }
                                                }
                                                i24 = i36;
                                                if (i24 == i36) {
                                                }
                                                break;
                                            case 56:
                                            case 65:
                                                obj3 = obj;
                                                i56 = i75;
                                                i21 = i37;
                                                zzdtVar2 = zzdtVar;
                                                i13 = i11;
                                                i17 = i38;
                                                if (i72 == 1) {
                                                    unsafe7.putObject(obj3, j10, Long.valueOf(zzdu.zzn(bArr7, i36)));
                                                    i24 = i36 + 8;
                                                    unsafe7.putInt(obj3, j11, i21);
                                                    if (i24 == i36) {
                                                    }
                                                }
                                                i24 = i36;
                                                if (i24 == i36) {
                                                }
                                                break;
                                            case 57:
                                            case 64:
                                                obj3 = obj;
                                                i56 = i75;
                                                i21 = i37;
                                                zzdtVar2 = zzdtVar;
                                                i13 = i11;
                                                i17 = i38;
                                                if (i72 == 5) {
                                                    unsafe7.putObject(obj3, j10, Integer.valueOf(zzdu.zzb(bArr7, i36)));
                                                    i24 = i36 + 4;
                                                    unsafe7.putInt(obj3, j11, i21);
                                                    if (i24 == i36) {
                                                    }
                                                }
                                                i24 = i36;
                                                if (i24 == i36) {
                                                }
                                                break;
                                            case 58:
                                                obj3 = obj;
                                                i56 = i75;
                                                i21 = i37;
                                                zzdtVar2 = zzdtVar;
                                                i13 = i11;
                                                i17 = i38;
                                                if (i72 == 0) {
                                                    i24 = zzdu.zzk(bArr7, i36, zzdtVar2);
                                                    unsafe7.putObject(obj3, j10, Boolean.valueOf(zzdtVar2.zzb != 0));
                                                    unsafe7.putInt(obj3, j11, i21);
                                                    if (i24 == i36) {
                                                    }
                                                }
                                                i24 = i36;
                                                if (i24 == i36) {
                                                }
                                                break;
                                            case 59:
                                                obj3 = obj;
                                                i56 = i75;
                                                i21 = i37;
                                                zzdtVar2 = zzdtVar;
                                                i13 = i11;
                                                i17 = i38;
                                                if (i72 == 2) {
                                                    int zzh2 = zzdu.zzh(bArr7, i36, zzdtVar2);
                                                    int i78 = zzdtVar2.zza;
                                                    if (i78 == 0) {
                                                        unsafe7.putObject(obj3, j10, "");
                                                    } else {
                                                        if ((i73 & 536870912) != 0 && !zzhn.zzc(bArr7, zzh2, zzh2 + i78)) {
                                                            throw zzfb.zzb();
                                                        }
                                                        unsafe7.putObject(obj3, j10, new String(bArr7, zzh2, i78, zzfa.zzb));
                                                        zzh2 += i78;
                                                    }
                                                    unsafe7.putInt(obj3, j11, i21);
                                                    i24 = zzh2;
                                                    if (i24 == i36) {
                                                    }
                                                }
                                                i24 = i36;
                                                if (i24 == i36) {
                                                }
                                                break;
                                            case 60:
                                                obj5 = obj;
                                                i13 = i11;
                                                zzdtVar5 = zzdtVar;
                                                i17 = i38;
                                                i21 = i37;
                                                if (i72 == 2) {
                                                    Object zzu = zzgaVar4.zzu(obj5, i21, i75);
                                                    int zzm2 = zzdu.zzm(zzu, zzgaVar4.zzr(i75), bArr, i36, i11, zzdtVar);
                                                    zzgaVar4.zzC(obj5, i21, i75, zzu);
                                                    i24 = zzm2;
                                                    i56 = i75;
                                                    bArr7 = bArr7;
                                                    obj3 = obj5;
                                                    zzdtVar2 = zzdtVar5;
                                                    if (i24 == i36) {
                                                    }
                                                } else {
                                                    obj3 = obj5;
                                                    i56 = i75;
                                                    zzdtVar2 = zzdtVar5;
                                                    i24 = i36;
                                                    if (i24 == i36) {
                                                    }
                                                }
                                                break;
                                            case 61:
                                                obj5 = obj;
                                                zzdtVar5 = zzdtVar;
                                                i21 = i37;
                                                i13 = i11;
                                                i17 = i38;
                                                if (i72 == 2) {
                                                    int zza2 = zzdu.zza(bArr7, i36, zzdtVar5);
                                                    unsafe7.putObject(obj5, j10, zzdtVar5.zzc);
                                                    unsafe7.putInt(obj5, j11, i21);
                                                    obj3 = obj5;
                                                    i56 = i75;
                                                    i24 = zza2;
                                                    zzdtVar2 = zzdtVar5;
                                                    if (i24 == i36) {
                                                    }
                                                }
                                                obj3 = obj5;
                                                i56 = i75;
                                                zzdtVar2 = zzdtVar5;
                                                i24 = i36;
                                                if (i24 == i36) {
                                                }
                                                break;
                                            case 63:
                                                obj5 = obj;
                                                zzdtVar5 = zzdtVar;
                                                i21 = i37;
                                                i13 = i11;
                                                if (i72 == 0) {
                                                    int zzh3 = zzdu.zzh(bArr7, i36, zzdtVar5);
                                                    int i79 = zzdtVar5.zza;
                                                    zzey zzq = zzgaVar4.zzq(i75);
                                                    if (zzq != null && !zzq.zza()) {
                                                        zzc(obj).zzh(i38, Long.valueOf(i79));
                                                        i17 = i38;
                                                    } else {
                                                        i17 = i38;
                                                        unsafe7.putObject(obj5, j10, Integer.valueOf(i79));
                                                        unsafe7.putInt(obj5, j11, i21);
                                                    }
                                                    obj3 = obj5;
                                                    i56 = i75;
                                                    i24 = zzh3;
                                                    zzdtVar2 = zzdtVar5;
                                                    if (i24 == i36) {
                                                    }
                                                } else {
                                                    i17 = i38;
                                                    obj3 = obj5;
                                                    i56 = i75;
                                                    zzdtVar2 = zzdtVar5;
                                                    i24 = i36;
                                                    if (i24 == i36) {
                                                    }
                                                }
                                                break;
                                            case 66:
                                                i57 = i38;
                                                i21 = i37;
                                                i13 = i11;
                                                if (i72 == 0) {
                                                    int zzh4 = zzdu.zzh(bArr7, i36, zzdtVar);
                                                    unsafe7.putObject(obj, j10, Integer.valueOf(zzej.zzb(zzdtVar.zza)));
                                                    unsafe7.putInt(obj, j11, i21);
                                                    obj3 = obj;
                                                    i56 = i75;
                                                    i24 = zzh4;
                                                    zzdtVar2 = zzdtVar;
                                                    i17 = i57;
                                                    if (i24 == i36) {
                                                    }
                                                } else {
                                                    obj3 = obj;
                                                    i56 = i75;
                                                    zzdtVar2 = zzdtVar;
                                                    i17 = i57;
                                                    i24 = i36;
                                                    if (i24 == i36) {
                                                    }
                                                }
                                                break;
                                            case 67:
                                                i57 = i38;
                                                i21 = i37;
                                                i13 = i11;
                                                if (i72 == 0) {
                                                    int zzk = zzdu.zzk(bArr7, i36, zzdtVar);
                                                    unsafe7.putObject(obj, j10, Long.valueOf(zzej.zzc(zzdtVar.zzb)));
                                                    unsafe7.putInt(obj, j11, i21);
                                                    obj3 = obj;
                                                    i56 = i75;
                                                    zzdtVar2 = zzdtVar;
                                                    i24 = zzk;
                                                    i17 = i57;
                                                    if (i24 == i36) {
                                                    }
                                                } else {
                                                    obj3 = obj;
                                                    i56 = i75;
                                                    i17 = i57;
                                                    zzdtVar2 = zzdtVar;
                                                    i24 = i36;
                                                    if (i24 == i36) {
                                                    }
                                                }
                                                break;
                                            case 68:
                                                if (i72 == 3) {
                                                    Object zzu2 = zzgaVar4.zzu(obj, i37, i75);
                                                    i21 = i37;
                                                    int zzl = zzdu.zzl(zzu2, zzgaVar4.zzr(i75), bArr, i36, i11, (i38 & (-8)) | 4, zzdtVar);
                                                    zzgaVar4.zzC(obj, i21, i75, zzu2);
                                                    obj3 = obj;
                                                    i13 = i11;
                                                    i56 = i75;
                                                    i24 = zzl;
                                                    i17 = i38;
                                                    zzdtVar2 = zzdtVar;
                                                    if (i24 == i36) {
                                                    }
                                                } else {
                                                    i21 = i37;
                                                    obj3 = obj;
                                                    i13 = i11;
                                                    i56 = i75;
                                                    i17 = i38;
                                                    zzdtVar2 = zzdtVar;
                                                    i24 = i36;
                                                    if (i24 == i36) {
                                                    }
                                                }
                                                break;
                                            default:
                                                obj3 = obj;
                                                i13 = i11;
                                                i56 = i75;
                                                i17 = i38;
                                                i21 = i37;
                                                zzdtVar2 = zzdtVar;
                                                i24 = i36;
                                                if (i24 == i36) {
                                                }
                                                break;
                                        }
                                    } else {
                                        if (i72 == 2) {
                                            Unsafe unsafe8 = zzb;
                                            Object zzs = zzgaVar4.zzs(i75);
                                            Object object = unsafe8.getObject(obj, j10);
                                            if (!((zzfr) object).zze()) {
                                                zzfr zzb2 = zzfr.zza().zzb();
                                                zzfs.zza(zzb2, object);
                                                unsafe8.putObject(obj, j10, zzb2);
                                            }
                                            throw null;
                                        }
                                        obj4 = obj;
                                        zzdtVar4 = zzdtVar7;
                                        i39 = i75;
                                        i14 = i12;
                                        i23 = i39;
                                        i13 = i35;
                                        obj3 = obj4;
                                        i17 = i38;
                                        i21 = i37;
                                        zzdtVar2 = zzdtVar4;
                                        i24 = i36;
                                    }
                                } else {
                                    int i80 = i71;
                                    long j12 = i73;
                                    Unsafe unsafe9 = zzb;
                                    zzez zzezVar = (zzez) unsafe9.getObject(obj6, j10);
                                    if (zzezVar.zzc()) {
                                        i40 = i77;
                                    } else {
                                        int size = zzezVar.size();
                                        if (size == 0) {
                                            i40 = i77;
                                            i55 = 10;
                                        } else {
                                            i40 = i77;
                                            i55 = size + size;
                                        }
                                        zzezVar = zzezVar.zzd(i55);
                                        unsafe9.putObject(obj6, j10, zzezVar);
                                    }
                                    zzez zzezVar2 = zzezVar;
                                    switch (zzn) {
                                        case 18:
                                        case 35:
                                            bArr2 = bArr;
                                            i41 = i11;
                                            zzdtVar2 = zzdtVar7;
                                            i23 = i75;
                                            i42 = i80;
                                            i22 = i76;
                                            i43 = i40;
                                            unsafe = unsafe6;
                                            i44 = i74;
                                            zzgaVar = zzgaVar3;
                                            if (i72 == 2) {
                                                zzek zzekVar = (zzek) zzezVar2;
                                                i24 = zzdu.zzh(bArr2, i43, zzdtVar2);
                                                int i81 = zzdtVar2.zza + i24;
                                                while (i24 < i81) {
                                                    zzekVar.zze(Double.longBitsToDouble(zzdu.zzn(bArr2, i24)));
                                                    i24 += 8;
                                                }
                                                if (i24 != i81) {
                                                    throw zzfb.zzf();
                                                }
                                            } else {
                                                if (i72 == 1) {
                                                    zzek zzekVar2 = (zzek) zzezVar2;
                                                    zzekVar2.zze(Double.longBitsToDouble(zzdu.zzn(bArr2, i43)));
                                                    i24 = i43 + 8;
                                                    while (i24 < i41) {
                                                        int zzh5 = zzdu.zzh(bArr2, i24, zzdtVar2);
                                                        if (i44 == zzdtVar2.zza) {
                                                            zzekVar2.zze(Double.longBitsToDouble(zzdu.zzn(bArr2, zzh5)));
                                                            i24 = zzh5 + 8;
                                                        }
                                                    }
                                                }
                                                i24 = i43;
                                            }
                                            if (i24 == i43) {
                                                obj3 = obj;
                                                i14 = i12;
                                                i13 = i41;
                                                i17 = i44;
                                                i21 = i42;
                                                break;
                                            } else {
                                                unsafe4 = unsafe;
                                                i59 = i12;
                                                bArr6 = bArr2;
                                                zzgaVar3 = zzgaVar;
                                                i58 = i41;
                                                i68 = i44;
                                                i64 = i42;
                                                i66 = i22;
                                                i65 = i23;
                                                i60 = 3;
                                                i62 = -1;
                                                i61 = 0;
                                                i63 = i24;
                                                zzdtVar6 = zzdtVar2;
                                                obj6 = obj;
                                            }
                                        case 19:
                                        case 36:
                                            bArr2 = bArr;
                                            i41 = i11;
                                            zzdtVar2 = zzdtVar7;
                                            i23 = i75;
                                            i42 = i80;
                                            i22 = i76;
                                            i43 = i40;
                                            unsafe = unsafe6;
                                            i44 = i74;
                                            zzgaVar = zzgaVar3;
                                            if (i72 == 2) {
                                                zzer zzerVar = (zzer) zzezVar2;
                                                i24 = zzdu.zzh(bArr2, i43, zzdtVar2);
                                                int i82 = zzdtVar2.zza + i24;
                                                while (i24 < i82) {
                                                    zzerVar.zze(Float.intBitsToFloat(zzdu.zzb(bArr2, i24)));
                                                    i24 += 4;
                                                }
                                                if (i24 != i82) {
                                                    throw zzfb.zzf();
                                                }
                                            } else {
                                                if (i72 == 5) {
                                                    zzer zzerVar2 = (zzer) zzezVar2;
                                                    zzerVar2.zze(Float.intBitsToFloat(zzdu.zzb(bArr2, i43)));
                                                    i24 = i43 + 4;
                                                    while (i24 < i41) {
                                                        int zzh6 = zzdu.zzh(bArr2, i24, zzdtVar2);
                                                        if (i44 == zzdtVar2.zza) {
                                                            zzerVar2.zze(Float.intBitsToFloat(zzdu.zzb(bArr2, zzh6)));
                                                            i24 = zzh6 + 4;
                                                        }
                                                    }
                                                }
                                                i24 = i43;
                                            }
                                            if (i24 == i43) {
                                            }
                                            break;
                                        case 20:
                                        case 21:
                                        case 37:
                                        case 38:
                                            bArr2 = bArr;
                                            i41 = i11;
                                            zzdtVar2 = zzdtVar7;
                                            i23 = i75;
                                            i42 = i80;
                                            i22 = i76;
                                            i43 = i40;
                                            unsafe = unsafe6;
                                            i44 = i74;
                                            zzgaVar = zzgaVar3;
                                            if (i72 == 2) {
                                                zzfm zzfmVar = (zzfm) zzezVar2;
                                                i24 = zzdu.zzh(bArr2, i43, zzdtVar2);
                                                int i83 = zzdtVar2.zza + i24;
                                                while (i24 < i83) {
                                                    i24 = zzdu.zzk(bArr2, i24, zzdtVar2);
                                                    zzfmVar.zze(zzdtVar2.zzb);
                                                }
                                                if (i24 != i83) {
                                                    throw zzfb.zzf();
                                                }
                                            } else {
                                                if (i72 == 0) {
                                                    zzfm zzfmVar2 = (zzfm) zzezVar2;
                                                    i24 = zzdu.zzk(bArr2, i43, zzdtVar2);
                                                    zzfmVar2.zze(zzdtVar2.zzb);
                                                    while (i24 < i41) {
                                                        int zzh7 = zzdu.zzh(bArr2, i24, zzdtVar2);
                                                        if (i44 == zzdtVar2.zza) {
                                                            i24 = zzdu.zzk(bArr2, zzh7, zzdtVar2);
                                                            zzfmVar2.zze(zzdtVar2.zzb);
                                                        }
                                                    }
                                                }
                                                i24 = i43;
                                            }
                                            if (i24 == i43) {
                                            }
                                            break;
                                        case 22:
                                        case 29:
                                        case 39:
                                        case 43:
                                            bArr3 = bArr;
                                            i45 = i11;
                                            zzgaVar2 = zzgaVar3;
                                            i46 = i74;
                                            zzdtVar2 = zzdtVar7;
                                            i23 = i75;
                                            i42 = i80;
                                            i22 = i76;
                                            i43 = i40;
                                            unsafe = unsafe6;
                                            if (i72 == 2) {
                                                zzf = zzdu.zzf(bArr3, i43, zzezVar2, zzdtVar2);
                                                i44 = i46;
                                                bArr2 = bArr3;
                                                zzgaVar = zzgaVar2;
                                                i24 = zzf;
                                                i41 = i45;
                                                if (i24 == i43) {
                                                }
                                            } else if (i72 == 0) {
                                                i44 = i46;
                                                i41 = i45;
                                                i24 = zzdu.zzj(i46, bArr, i43, i11, zzezVar2, zzdtVar);
                                                bArr2 = bArr3;
                                                zzgaVar = zzgaVar2;
                                                if (i24 == i43) {
                                                }
                                            } else {
                                                i44 = i46;
                                                i41 = i45;
                                                bArr2 = bArr3;
                                                zzgaVar = zzgaVar2;
                                                i24 = i43;
                                                if (i24 == i43) {
                                                }
                                            }
                                            break;
                                        case 23:
                                        case 32:
                                        case 40:
                                        case 46:
                                            bArr3 = bArr;
                                            i45 = i11;
                                            zzgaVar2 = zzgaVar3;
                                            i46 = i74;
                                            zzdtVar2 = zzdtVar7;
                                            i23 = i75;
                                            i42 = i80;
                                            i22 = i76;
                                            i43 = i40;
                                            unsafe = unsafe6;
                                            if (i72 == 2) {
                                                zzfm zzfmVar3 = (zzfm) zzezVar2;
                                                i24 = zzdu.zzh(bArr3, i43, zzdtVar2);
                                                int i84 = zzdtVar2.zza + i24;
                                                while (i24 < i84) {
                                                    zzfmVar3.zze(zzdu.zzn(bArr3, i24));
                                                    i24 += 8;
                                                }
                                                if (i24 != i84) {
                                                    throw zzfb.zzf();
                                                }
                                                i44 = i46;
                                                i41 = i45;
                                                bArr2 = bArr3;
                                                zzgaVar = zzgaVar2;
                                                if (i24 == i43) {
                                                }
                                            } else {
                                                if (i72 == 1) {
                                                    zzfm zzfmVar4 = (zzfm) zzezVar2;
                                                    zzfmVar4.zze(zzdu.zzn(bArr3, i43));
                                                    zzf = i43 + 8;
                                                    while (zzf < i45) {
                                                        int zzh8 = zzdu.zzh(bArr3, zzf, zzdtVar2);
                                                        if (i46 == zzdtVar2.zza) {
                                                            zzfmVar4.zze(zzdu.zzn(bArr3, zzh8));
                                                            zzf = zzh8 + 8;
                                                        } else {
                                                            i44 = i46;
                                                            bArr2 = bArr3;
                                                            zzgaVar = zzgaVar2;
                                                            i24 = zzf;
                                                            i41 = i45;
                                                            if (i24 == i43) {
                                                            }
                                                        }
                                                    }
                                                    i44 = i46;
                                                    bArr2 = bArr3;
                                                    zzgaVar = zzgaVar2;
                                                    i24 = zzf;
                                                    i41 = i45;
                                                    if (i24 == i43) {
                                                    }
                                                }
                                                i44 = i46;
                                                i41 = i45;
                                                bArr2 = bArr3;
                                                zzgaVar = zzgaVar2;
                                                i24 = i43;
                                                if (i24 == i43) {
                                                }
                                            }
                                            break;
                                        case 24:
                                        case 31:
                                        case 41:
                                        case 45:
                                            bArr3 = bArr;
                                            i45 = i11;
                                            zzgaVar2 = zzgaVar3;
                                            i46 = i74;
                                            zzdtVar2 = zzdtVar7;
                                            i23 = i75;
                                            i42 = i80;
                                            i22 = i76;
                                            i43 = i40;
                                            unsafe = unsafe6;
                                            if (i72 == 2) {
                                                zzew zzewVar = (zzew) zzezVar2;
                                                i24 = zzdu.zzh(bArr3, i43, zzdtVar2);
                                                int i85 = zzdtVar2.zza + i24;
                                                while (i24 < i85) {
                                                    zzewVar.zze(zzdu.zzb(bArr3, i24));
                                                    i24 += 4;
                                                }
                                                if (i24 != i85) {
                                                    throw zzfb.zzf();
                                                }
                                            } else {
                                                if (i72 == 5) {
                                                    zzew zzewVar2 = (zzew) zzezVar2;
                                                    zzewVar2.zze(zzdu.zzb(bArr3, i43));
                                                    i24 = i43 + 4;
                                                    while (i24 < i45) {
                                                        int zzh9 = zzdu.zzh(bArr3, i24, zzdtVar2);
                                                        if (i46 == zzdtVar2.zza) {
                                                            zzewVar2.zze(zzdu.zzb(bArr3, zzh9));
                                                            i24 = zzh9 + 4;
                                                        }
                                                    }
                                                }
                                                i44 = i46;
                                                i41 = i45;
                                                bArr2 = bArr3;
                                                zzgaVar = zzgaVar2;
                                                i24 = i43;
                                                if (i24 == i43) {
                                                }
                                            }
                                            i44 = i46;
                                            i41 = i45;
                                            bArr2 = bArr3;
                                            zzgaVar = zzgaVar2;
                                            if (i24 == i43) {
                                            }
                                            break;
                                        case 25:
                                        case 42:
                                            bArr3 = bArr;
                                            i45 = i11;
                                            zzgaVar2 = zzgaVar3;
                                            i46 = i74;
                                            zzdtVar2 = zzdtVar7;
                                            i23 = i75;
                                            i42 = i80;
                                            i22 = i76;
                                            i43 = i40;
                                            unsafe = unsafe6;
                                            if (i72 == 2) {
                                                zzdv zzdvVar = (zzdv) zzezVar2;
                                                i24 = zzdu.zzh(bArr3, i43, zzdtVar2);
                                                int i86 = zzdtVar2.zza + i24;
                                                while (i24 < i86) {
                                                    i24 = zzdu.zzk(bArr3, i24, zzdtVar2);
                                                    zzdvVar.zze(zzdtVar2.zzb != 0);
                                                }
                                                if (i24 != i86) {
                                                    throw zzfb.zzf();
                                                }
                                            } else {
                                                if (i72 == 0) {
                                                    zzdv zzdvVar2 = (zzdv) zzezVar2;
                                                    i24 = zzdu.zzk(bArr3, i43, zzdtVar2);
                                                    zzdvVar2.zze(zzdtVar2.zzb != 0);
                                                    while (i24 < i45) {
                                                        int zzh10 = zzdu.zzh(bArr3, i24, zzdtVar2);
                                                        if (i46 == zzdtVar2.zza) {
                                                            i24 = zzdu.zzk(bArr3, zzh10, zzdtVar2);
                                                            zzdvVar2.zze(zzdtVar2.zzb != 0);
                                                        }
                                                    }
                                                }
                                                i44 = i46;
                                                i41 = i45;
                                                bArr2 = bArr3;
                                                zzgaVar = zzgaVar2;
                                                i24 = i43;
                                                if (i24 == i43) {
                                                }
                                            }
                                            i44 = i46;
                                            i41 = i45;
                                            bArr2 = bArr3;
                                            zzgaVar = zzgaVar2;
                                            if (i24 == i43) {
                                            }
                                            break;
                                        case 26:
                                            bArr3 = bArr;
                                            i45 = i11;
                                            zzgaVar2 = zzgaVar3;
                                            i46 = i74;
                                            zzdtVar2 = zzdtVar7;
                                            i23 = i75;
                                            i42 = i80;
                                            i22 = i76;
                                            i43 = i40;
                                            unsafe = unsafe6;
                                            if (i72 == 2) {
                                                if ((536870912 & j12) == 0) {
                                                    zzf = zzdu.zzh(bArr3, i43, zzdtVar2);
                                                    int i87 = zzdtVar2.zza;
                                                    if (i87 < 0) {
                                                        throw zzfb.zzc();
                                                    }
                                                    if (i87 == 0) {
                                                        zzezVar2.add("");
                                                    } else {
                                                        zzezVar2.add(new String(bArr3, zzf, i87, zzfa.zzb));
                                                        zzf += i87;
                                                    }
                                                    while (zzf < i45) {
                                                        int zzh11 = zzdu.zzh(bArr3, zzf, zzdtVar2);
                                                        if (i46 == zzdtVar2.zza) {
                                                            zzf = zzdu.zzh(bArr3, zzh11, zzdtVar2);
                                                            int i88 = zzdtVar2.zza;
                                                            if (i88 < 0) {
                                                                throw zzfb.zzc();
                                                            }
                                                            if (i88 == 0) {
                                                                zzezVar2.add("");
                                                            } else {
                                                                zzezVar2.add(new String(bArr3, zzf, i88, zzfa.zzb));
                                                                zzf += i88;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    zzf = zzdu.zzh(bArr3, i43, zzdtVar2);
                                                    int i89 = zzdtVar2.zza;
                                                    if (i89 < 0) {
                                                        throw zzfb.zzc();
                                                    }
                                                    if (i89 == 0) {
                                                        zzezVar2.add("");
                                                    } else {
                                                        int i90 = zzf + i89;
                                                        if (zzhn.zzc(bArr3, zzf, i90)) {
                                                            zzezVar2.add(new String(bArr3, zzf, i89, zzfa.zzb));
                                                            zzf = i90;
                                                        } else {
                                                            throw zzfb.zzb();
                                                        }
                                                    }
                                                    while (zzf < i45) {
                                                        int zzh12 = zzdu.zzh(bArr3, zzf, zzdtVar2);
                                                        if (i46 == zzdtVar2.zza) {
                                                            zzf = zzdu.zzh(bArr3, zzh12, zzdtVar2);
                                                            int i91 = zzdtVar2.zza;
                                                            if (i91 < 0) {
                                                                throw zzfb.zzc();
                                                            }
                                                            if (i91 == 0) {
                                                                zzezVar2.add("");
                                                            } else {
                                                                int i92 = zzf + i91;
                                                                if (zzhn.zzc(bArr3, zzf, i92)) {
                                                                    zzezVar2.add(new String(bArr3, zzf, i91, zzfa.zzb));
                                                                    zzf = i92;
                                                                } else {
                                                                    throw zzfb.zzb();
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                i44 = i46;
                                                bArr2 = bArr3;
                                                zzgaVar = zzgaVar2;
                                                i24 = zzf;
                                                i41 = i45;
                                                if (i24 == i43) {
                                                }
                                            }
                                            i44 = i46;
                                            i41 = i45;
                                            bArr2 = bArr3;
                                            zzgaVar = zzgaVar2;
                                            i24 = i43;
                                            if (i24 == i43) {
                                            }
                                            break;
                                        case 27:
                                            bArr4 = bArr;
                                            i47 = i11;
                                            i48 = i74;
                                            i22 = i76;
                                            i43 = i40;
                                            unsafe = unsafe6;
                                            if (i72 == 2) {
                                                zzgaVar2 = this;
                                                bArr3 = bArr4;
                                                i45 = i47;
                                                zzdtVar2 = zzdtVar7;
                                                i23 = i75;
                                                zzf = zzdu.zze(zzgaVar2.zzr(i75), i48, bArr, i43, i11, zzezVar2, zzdtVar);
                                                i44 = i48;
                                                i42 = i80;
                                                bArr2 = bArr3;
                                                zzgaVar = zzgaVar2;
                                                i24 = zzf;
                                                i41 = i45;
                                                if (i24 == i43) {
                                                }
                                            } else {
                                                i23 = i75;
                                                zzdtVar2 = zzdtVar7;
                                                zzgaVar = this;
                                                i42 = i80;
                                                bArr2 = bArr4;
                                                i41 = i47;
                                                i44 = i48;
                                                i24 = i43;
                                                if (i24 == i43) {
                                                }
                                            }
                                            break;
                                        case 28:
                                            bArr4 = bArr;
                                            i47 = i11;
                                            i48 = i74;
                                            i22 = i76;
                                            i43 = i40;
                                            unsafe = unsafe6;
                                            if (i72 == 2) {
                                                int zzh13 = zzdu.zzh(bArr4, i43, zzdtVar7);
                                                int i93 = zzdtVar7.zza;
                                                if (i93 >= 0) {
                                                    if (i93 > bArr4.length - zzh13) {
                                                        throw zzfb.zzf();
                                                    }
                                                    if (i93 == 0) {
                                                        zzezVar2.add(zzef.zzb);
                                                    } else {
                                                        zzezVar2.add(zzef.zzk(bArr4, zzh13, i93));
                                                        zzh13 += i93;
                                                    }
                                                    while (zzh13 < i47) {
                                                        int zzh14 = zzdu.zzh(bArr4, zzh13, zzdtVar7);
                                                        if (i48 == zzdtVar7.zza) {
                                                            zzh13 = zzdu.zzh(bArr4, zzh14, zzdtVar7);
                                                            int i94 = zzdtVar7.zza;
                                                            if (i94 >= 0) {
                                                                if (i94 > bArr4.length - zzh13) {
                                                                    throw zzfb.zzf();
                                                                }
                                                                if (i94 == 0) {
                                                                    zzezVar2.add(zzef.zzb);
                                                                } else {
                                                                    zzezVar2.add(zzef.zzk(bArr4, zzh13, i94));
                                                                    zzh13 += i94;
                                                                }
                                                            } else {
                                                                throw zzfb.zzc();
                                                            }
                                                        } else {
                                                            zzgaVar = this;
                                                            i24 = zzh13;
                                                            i23 = i75;
                                                            zzdtVar2 = zzdtVar7;
                                                            i42 = i80;
                                                            bArr2 = bArr4;
                                                            i41 = i47;
                                                            i44 = i48;
                                                            if (i24 == i43) {
                                                            }
                                                        }
                                                    }
                                                    zzgaVar = this;
                                                    i24 = zzh13;
                                                    i23 = i75;
                                                    zzdtVar2 = zzdtVar7;
                                                    i42 = i80;
                                                    bArr2 = bArr4;
                                                    i41 = i47;
                                                    i44 = i48;
                                                    if (i24 == i43) {
                                                    }
                                                } else {
                                                    throw zzfb.zzc();
                                                }
                                            } else {
                                                zzgaVar = this;
                                                i23 = i75;
                                                zzdtVar2 = zzdtVar7;
                                                i42 = i80;
                                                bArr2 = bArr4;
                                                i41 = i47;
                                                i44 = i48;
                                                i24 = i43;
                                                if (i24 == i43) {
                                                }
                                            }
                                            break;
                                        case 30:
                                        case 44:
                                            bArr5 = bArr;
                                            i49 = i11;
                                            i50 = i74;
                                            i22 = i76;
                                            i43 = i40;
                                            unsafe = unsafe6;
                                            i51 = i75;
                                            if (i72 == 2) {
                                                zzj = zzdu.zzf(bArr5, i43, zzezVar2, zzdtVar7);
                                            } else if (i72 == 0) {
                                                zzj = zzdu.zzj(i50, bArr, i43, i11, zzezVar2, zzdtVar);
                                            } else {
                                                zzgaVar = this;
                                                bArr2 = bArr5;
                                                i41 = i49;
                                                i23 = i51;
                                                zzdtVar2 = zzdtVar7;
                                                i42 = i80;
                                                i44 = i50;
                                                i24 = i43;
                                                if (i24 == i43) {
                                                }
                                            }
                                            zzey zzq2 = zzgaVar3.zzq(i51);
                                            zzgz zzgzVar = zzgaVar3.zzl;
                                            int i95 = zzgk.zza;
                                            if (zzq2 == null) {
                                                i52 = zzj;
                                                i53 = i80;
                                            } else if (zzezVar2 instanceof RandomAccess) {
                                                int size2 = zzezVar2.size();
                                                Object obj7 = null;
                                                int i96 = 0;
                                                int i97 = 0;
                                                while (i96 < size2) {
                                                    int i98 = zzj;
                                                    Integer num = (Integer) zzezVar2.get(i96);
                                                    int intValue = num.intValue();
                                                    if (zzq2.zza()) {
                                                        if (i96 != i97) {
                                                            zzezVar2.set(i97, num);
                                                        }
                                                        i97++;
                                                        i54 = i80;
                                                    } else {
                                                        i54 = i80;
                                                        obj7 = zzgk.zzc(obj6, i54, intValue, obj7, zzgzVar);
                                                    }
                                                    i96++;
                                                    i80 = i54;
                                                    zzj = i98;
                                                }
                                                i52 = zzj;
                                                i53 = i80;
                                                if (i97 != size2) {
                                                    zzezVar2.subList(i97, size2).clear();
                                                }
                                            } else {
                                                i52 = zzj;
                                                i53 = i80;
                                                Iterator it = zzezVar2.iterator();
                                                Object obj8 = null;
                                                while (it.hasNext()) {
                                                    int intValue2 = ((Integer) it.next()).intValue();
                                                    if (!zzq2.zza()) {
                                                        obj8 = zzgk.zzc(obj6, i53, intValue2, obj8, zzgzVar);
                                                        it.remove();
                                                    }
                                                }
                                            }
                                            zzgaVar = this;
                                            zzdtVar2 = zzdtVar7;
                                            i24 = i52;
                                            i42 = i53;
                                            bArr2 = bArr5;
                                            i41 = i49;
                                            i23 = i51;
                                            i44 = i50;
                                            if (i24 == i43) {
                                            }
                                            break;
                                        case 33:
                                        case 47:
                                            bArr5 = bArr;
                                            i49 = i11;
                                            i50 = i74;
                                            i22 = i76;
                                            i43 = i40;
                                            unsafe = unsafe6;
                                            i51 = i75;
                                            if (i72 == 2) {
                                                zzew zzewVar3 = (zzew) zzezVar2;
                                                zzh = zzdu.zzh(bArr5, i43, zzdtVar7);
                                                int i99 = zzdtVar7.zza + zzh;
                                                while (zzh < i99) {
                                                    zzh = zzdu.zzh(bArr5, zzh, zzdtVar7);
                                                    zzewVar3.zze(zzej.zzb(zzdtVar7.zza));
                                                }
                                                if (zzh != i99) {
                                                    throw zzfb.zzf();
                                                }
                                            } else {
                                                if (i72 == 0) {
                                                    zzew zzewVar4 = (zzew) zzezVar2;
                                                    zzh = zzdu.zzh(bArr5, i43, zzdtVar7);
                                                    zzewVar4.zze(zzej.zzb(zzdtVar7.zza));
                                                    while (zzh < i49) {
                                                        int zzh15 = zzdu.zzh(bArr5, zzh, zzdtVar7);
                                                        if (i50 == zzdtVar7.zza) {
                                                            zzh = zzdu.zzh(bArr5, zzh15, zzdtVar7);
                                                            zzewVar4.zze(zzej.zzb(zzdtVar7.zza));
                                                        }
                                                    }
                                                }
                                                zzgaVar = zzgaVar3;
                                                bArr2 = bArr5;
                                                i41 = i49;
                                                i23 = i51;
                                                zzdtVar2 = zzdtVar7;
                                                i42 = i80;
                                                i44 = i50;
                                                i24 = i43;
                                                if (i24 == i43) {
                                                }
                                            }
                                            zzgaVar = zzgaVar3;
                                            i24 = zzh;
                                            bArr2 = bArr5;
                                            i41 = i49;
                                            i23 = i51;
                                            zzdtVar2 = zzdtVar7;
                                            i42 = i80;
                                            i44 = i50;
                                            if (i24 == i43) {
                                            }
                                            break;
                                        case 34:
                                        case 48:
                                            bArr5 = bArr;
                                            i49 = i11;
                                            i50 = i74;
                                            i22 = i76;
                                            i43 = i40;
                                            unsafe = unsafe6;
                                            i51 = i75;
                                            if (i72 == 2) {
                                                zzfm zzfmVar5 = (zzfm) zzezVar2;
                                                zzh = zzdu.zzh(bArr5, i43, zzdtVar7);
                                                int i100 = zzdtVar7.zza + zzh;
                                                while (zzh < i100) {
                                                    zzh = zzdu.zzk(bArr5, zzh, zzdtVar7);
                                                    zzfmVar5.zze(zzej.zzc(zzdtVar7.zzb));
                                                }
                                                if (zzh != i100) {
                                                    throw zzfb.zzf();
                                                }
                                            } else {
                                                if (i72 == 0) {
                                                    zzfm zzfmVar6 = (zzfm) zzezVar2;
                                                    zzh = zzdu.zzk(bArr5, i43, zzdtVar7);
                                                    zzfmVar6.zze(zzej.zzc(zzdtVar7.zzb));
                                                    while (zzh < i49) {
                                                        int zzh16 = zzdu.zzh(bArr5, zzh, zzdtVar7);
                                                        if (i50 == zzdtVar7.zza) {
                                                            zzh = zzdu.zzk(bArr5, zzh16, zzdtVar7);
                                                            zzfmVar6.zze(zzej.zzc(zzdtVar7.zzb));
                                                        }
                                                    }
                                                }
                                                zzgaVar = zzgaVar3;
                                                bArr2 = bArr5;
                                                i41 = i49;
                                                i23 = i51;
                                                zzdtVar2 = zzdtVar7;
                                                i42 = i80;
                                                i44 = i50;
                                                i24 = i43;
                                                if (i24 == i43) {
                                                }
                                            }
                                            zzgaVar = zzgaVar3;
                                            i24 = zzh;
                                            bArr2 = bArr5;
                                            i41 = i49;
                                            i23 = i51;
                                            zzdtVar2 = zzdtVar7;
                                            i42 = i80;
                                            i44 = i50;
                                            if (i24 == i43) {
                                            }
                                            break;
                                        default:
                                            if (i72 == 3) {
                                                zzgi zzr = zzgaVar3.zzr(i75);
                                                int i101 = (i74 & (-8)) | 4;
                                                i22 = i76;
                                                int i102 = i40;
                                                i50 = i74;
                                                int i103 = i75;
                                                i43 = i102;
                                                zzh = zzdu.zzc(zzr, bArr, i102, i11, i101, zzdtVar);
                                                zzezVar2.add(zzdtVar7.zzc);
                                                int i104 = i11;
                                                while (true) {
                                                    if (zzh < i104) {
                                                        int i105 = i103;
                                                        int zzh17 = zzdu.zzh(bArr, zzh, zzdtVar7);
                                                        if (i50 == zzdtVar7.zza) {
                                                            zzh = zzdu.zzc(zzr, bArr, zzh17, i11, i101, zzdtVar);
                                                            zzezVar2.add(zzdtVar7.zzc);
                                                            i104 = i104;
                                                            i103 = i105;
                                                            i101 = i101;
                                                            unsafe6 = unsafe6;
                                                        } else {
                                                            bArr5 = bArr;
                                                            i49 = i104;
                                                            unsafe = unsafe6;
                                                            i51 = i105;
                                                        }
                                                    } else {
                                                        bArr5 = bArr;
                                                        i49 = i104;
                                                        unsafe = unsafe6;
                                                        i51 = i103;
                                                    }
                                                }
                                                zzgaVar = zzgaVar3;
                                                i24 = zzh;
                                                bArr2 = bArr5;
                                                i41 = i49;
                                                i23 = i51;
                                                zzdtVar2 = zzdtVar7;
                                                i42 = i80;
                                                i44 = i50;
                                                if (i24 == i43) {
                                                }
                                            } else {
                                                i22 = i76;
                                                i43 = i40;
                                                unsafe = unsafe6;
                                                bArr2 = bArr;
                                                i41 = i11;
                                                i23 = i75;
                                                zzdtVar2 = zzdtVar7;
                                                i42 = i80;
                                                i44 = i74;
                                                zzgaVar = zzgaVar3;
                                                i24 = i43;
                                                if (i24 == i43) {
                                                }
                                            }
                                            break;
                                    }
                                }
                            } else if (i72 == 2) {
                                zzez zzezVar3 = (zzez) unsafe5.getObject(obj6, j10);
                                if (!zzezVar3.zzc()) {
                                    int size3 = zzezVar3.size();
                                    zzezVar3 = zzezVar3.zzd(size3 == 0 ? 10 : size3 + size3);
                                    unsafe5.putObject(obj6, j10, zzezVar3);
                                }
                                i63 = zzdu.zze(zzgaVar3.zzr(i75), i74, bArr, i69, i11, zzezVar3, zzdtVar);
                                i59 = i12;
                                i66 = i76;
                                i68 = i74;
                                i64 = i71;
                                unsafe4 = unsafe5;
                                zzdtVar6 = zzdtVar7;
                                i65 = i75;
                                i60 = 3;
                                i62 = -1;
                                i61 = 0;
                                bArr6 = bArr;
                                i58 = i11;
                            } else {
                                i35 = i11;
                                i22 = i76;
                                i36 = i69;
                                unsafe = unsafe5;
                                i37 = i71;
                                zzdtVar4 = zzdtVar7;
                                i38 = i74;
                                obj4 = obj6;
                                i39 = i75;
                                i14 = i12;
                                i23 = i39;
                                i13 = i35;
                                obj3 = obj4;
                                i17 = i38;
                                i21 = i37;
                                zzdtVar2 = zzdtVar4;
                                i24 = i36;
                            }
                        } else {
                            int i106 = iArr[i20 + 2];
                            int i107 = 1 << (i106 >>> 20);
                            int i108 = 1048575;
                            int i109 = i106 & 1048575;
                            int i110 = i66;
                            if (i109 != i110) {
                                if (i110 != 1048575) {
                                    unsafe4.putInt(obj6, i110, i67);
                                    i108 = 1048575;
                                }
                                i25 = i109 == i108 ? 0 : unsafe4.getInt(obj6, i109);
                                i26 = i109;
                            } else {
                                i25 = i67;
                                i26 = i110;
                            }
                            switch (zzn) {
                                case 0:
                                    zzdtVar3 = zzdtVar6;
                                    i27 = i71;
                                    i28 = i74;
                                    i29 = i20;
                                    unsafe2 = unsafe4;
                                    if (i72 != 1) {
                                        i14 = i12;
                                        i24 = i69;
                                        obj3 = obj6;
                                        unsafe = unsafe2;
                                        i23 = i29;
                                        zzdtVar2 = zzdtVar3;
                                        i17 = i28;
                                        i22 = i26;
                                        i21 = i27;
                                        i67 = i25;
                                        i13 = i11;
                                        break;
                                    } else {
                                        zzhj.zzl(obj6, j10, Double.longBitsToDouble(zzdu.zzn(bArr6, i69)));
                                        i58 = i11;
                                        i59 = i12;
                                        i63 = i69 + 8;
                                        unsafe4 = unsafe2;
                                        i65 = i29;
                                        i68 = i28;
                                        i66 = i26;
                                        i64 = i27;
                                        i60 = 3;
                                        i61 = 0;
                                        i67 = i25 | i107;
                                        zzdtVar6 = zzdtVar3;
                                        i62 = -1;
                                    }
                                case 1:
                                    zzdtVar3 = zzdtVar6;
                                    i27 = i71;
                                    i28 = i74;
                                    i29 = i20;
                                    unsafe2 = unsafe4;
                                    if (i72 != 5) {
                                        i14 = i12;
                                        i24 = i69;
                                        obj3 = obj6;
                                        unsafe = unsafe2;
                                        i23 = i29;
                                        zzdtVar2 = zzdtVar3;
                                        i17 = i28;
                                        i22 = i26;
                                        i21 = i27;
                                        i67 = i25;
                                        i13 = i11;
                                        break;
                                    } else {
                                        zzhj.zzm(obj6, j10, Float.intBitsToFloat(zzdu.zzb(bArr6, i69)));
                                        i31 = i69 + 4;
                                        i33 = i25 | i107;
                                        i58 = i11;
                                        i59 = i12;
                                        i63 = i31;
                                        unsafe4 = unsafe2;
                                        i65 = i29;
                                        zzdtVar6 = zzdtVar3;
                                        i68 = i28;
                                        i66 = i26;
                                        i64 = i27;
                                        i60 = 3;
                                        i62 = -1;
                                        i61 = 0;
                                        i67 = i33;
                                    }
                                case 2:
                                case 3:
                                    zzdtVar3 = zzdtVar6;
                                    i27 = i71;
                                    i28 = i74;
                                    i29 = i20;
                                    unsafe2 = unsafe4;
                                    if (i72 != 0) {
                                        i14 = i12;
                                        i24 = i69;
                                        obj3 = obj6;
                                        unsafe = unsafe2;
                                        i23 = i29;
                                        zzdtVar2 = zzdtVar3;
                                        i17 = i28;
                                        i22 = i26;
                                        i21 = i27;
                                        i67 = i25;
                                        i13 = i11;
                                        break;
                                    } else {
                                        int zzk2 = zzdu.zzk(bArr6, i69, zzdtVar3);
                                        unsafe2.putLong(obj, j10, zzdtVar3.zzb);
                                        i30 = i25 | i107;
                                        i58 = i11;
                                        i59 = i12;
                                        i63 = zzk2;
                                        unsafe4 = unsafe2;
                                        i65 = i29;
                                        zzdtVar6 = zzdtVar3;
                                        i68 = i28;
                                        i66 = i26;
                                        i64 = i27;
                                        i60 = 3;
                                        i62 = -1;
                                        i61 = 0;
                                        i67 = i30;
                                    }
                                case 4:
                                case 11:
                                    zzdtVar3 = zzdtVar6;
                                    i27 = i71;
                                    i28 = i74;
                                    i29 = i20;
                                    unsafe2 = unsafe4;
                                    if (i72 != 0) {
                                        i14 = i12;
                                        i24 = i69;
                                        obj3 = obj6;
                                        unsafe = unsafe2;
                                        i23 = i29;
                                        zzdtVar2 = zzdtVar3;
                                        i17 = i28;
                                        i22 = i26;
                                        i21 = i27;
                                        i67 = i25;
                                        i13 = i11;
                                        break;
                                    } else {
                                        i31 = zzdu.zzh(bArr6, i69, zzdtVar3);
                                        unsafe2.putInt(obj6, j10, zzdtVar3.zza);
                                        i33 = i25 | i107;
                                        i58 = i11;
                                        i59 = i12;
                                        i63 = i31;
                                        unsafe4 = unsafe2;
                                        i65 = i29;
                                        zzdtVar6 = zzdtVar3;
                                        i68 = i28;
                                        i66 = i26;
                                        i64 = i27;
                                        i60 = 3;
                                        i62 = -1;
                                        i61 = 0;
                                        i67 = i33;
                                    }
                                case 5:
                                case 14:
                                    int i111 = i69;
                                    zzdtVar3 = zzdtVar6;
                                    i27 = i71;
                                    i28 = i74;
                                    i29 = i20;
                                    unsafe2 = unsafe4;
                                    if (i72 != 1) {
                                        i69 = i111;
                                        i14 = i12;
                                        i24 = i69;
                                        obj3 = obj6;
                                        unsafe = unsafe2;
                                        i23 = i29;
                                        zzdtVar2 = zzdtVar3;
                                        i17 = i28;
                                        i22 = i26;
                                        i21 = i27;
                                        i67 = i25;
                                        i13 = i11;
                                        break;
                                    } else {
                                        unsafe2.putLong(obj, j10, zzdu.zzn(bArr6, i111));
                                        i31 = i111 + 8;
                                        i33 = i25 | i107;
                                        i58 = i11;
                                        i59 = i12;
                                        i63 = i31;
                                        unsafe4 = unsafe2;
                                        i65 = i29;
                                        zzdtVar6 = zzdtVar3;
                                        i68 = i28;
                                        i66 = i26;
                                        i64 = i27;
                                        i60 = 3;
                                        i62 = -1;
                                        i61 = 0;
                                        i67 = i33;
                                    }
                                case 6:
                                case 13:
                                    i32 = i69;
                                    zzdtVar3 = zzdtVar6;
                                    i27 = i71;
                                    i28 = i74;
                                    i29 = i20;
                                    unsafe2 = unsafe4;
                                    if (i72 != 5) {
                                        i69 = i32;
                                        i14 = i12;
                                        i24 = i69;
                                        obj3 = obj6;
                                        unsafe = unsafe2;
                                        i23 = i29;
                                        zzdtVar2 = zzdtVar3;
                                        i17 = i28;
                                        i22 = i26;
                                        i21 = i27;
                                        i67 = i25;
                                        i13 = i11;
                                        break;
                                    } else {
                                        unsafe2.putInt(obj6, j10, zzdu.zzb(bArr6, i32));
                                        i31 = i32 + 4;
                                        i33 = i25 | i107;
                                        i58 = i11;
                                        i59 = i12;
                                        i63 = i31;
                                        unsafe4 = unsafe2;
                                        i65 = i29;
                                        zzdtVar6 = zzdtVar3;
                                        i68 = i28;
                                        i66 = i26;
                                        i64 = i27;
                                        i60 = 3;
                                        i62 = -1;
                                        i61 = 0;
                                        i67 = i33;
                                    }
                                case 7:
                                    i32 = i69;
                                    zzdtVar3 = zzdtVar6;
                                    i27 = i71;
                                    i28 = i74;
                                    i29 = i20;
                                    unsafe2 = unsafe4;
                                    if (i72 != 0) {
                                        i69 = i32;
                                        i14 = i12;
                                        i24 = i69;
                                        obj3 = obj6;
                                        unsafe = unsafe2;
                                        i23 = i29;
                                        zzdtVar2 = zzdtVar3;
                                        i17 = i28;
                                        i22 = i26;
                                        i21 = i27;
                                        i67 = i25;
                                        i13 = i11;
                                        break;
                                    } else {
                                        i31 = zzdu.zzk(bArr6, i32, zzdtVar3);
                                        zzhj.zzk(obj6, j10, zzdtVar3.zzb != 0);
                                        i33 = i25 | i107;
                                        i58 = i11;
                                        i59 = i12;
                                        i63 = i31;
                                        unsafe4 = unsafe2;
                                        i65 = i29;
                                        zzdtVar6 = zzdtVar3;
                                        i68 = i28;
                                        i66 = i26;
                                        i64 = i27;
                                        i60 = 3;
                                        i62 = -1;
                                        i61 = 0;
                                        i67 = i33;
                                    }
                                case 8:
                                    i32 = i69;
                                    zzdtVar3 = zzdtVar6;
                                    i27 = i71;
                                    i28 = i74;
                                    i29 = i20;
                                    unsafe2 = unsafe4;
                                    if (i72 != 2) {
                                        i69 = i32;
                                        i14 = i12;
                                        i24 = i69;
                                        obj3 = obj6;
                                        unsafe = unsafe2;
                                        i23 = i29;
                                        zzdtVar2 = zzdtVar3;
                                        i17 = i28;
                                        i22 = i26;
                                        i21 = i27;
                                        i67 = i25;
                                        i13 = i11;
                                        break;
                                    } else {
                                        if ((i73 & 536870912) != 0) {
                                            i31 = zzdu.zzh(bArr6, i32, zzdtVar3);
                                            int i112 = zzdtVar3.zza;
                                            if (i112 < 0) {
                                                throw zzfb.zzc();
                                            }
                                            if (i112 == 0) {
                                                zzdtVar3.zzc = "";
                                            } else {
                                                int i113 = zzhn.zza;
                                                int length = bArr6.length;
                                                if ((((length - i31) - i112) | i31 | i112) >= 0) {
                                                    int i114 = i31 + i112;
                                                    char[] cArr = new char[i112];
                                                    int i115 = 0;
                                                    while (i31 < i114) {
                                                        byte b10 = bArr6[i31];
                                                        if (zzhk.zzd(b10)) {
                                                            i31++;
                                                            cArr[i115] = (char) b10;
                                                            i115++;
                                                        } else {
                                                            int i116 = 1;
                                                            while (i31 < i114) {
                                                                int i117 = i31 + 1;
                                                                byte b11 = bArr6[i31];
                                                                if (zzhk.zzd(b11)) {
                                                                    cArr[i115] = (char) b11;
                                                                    i115++;
                                                                    i31 = i117;
                                                                    while (i31 < i114) {
                                                                        byte b12 = bArr6[i31];
                                                                        if (zzhk.zzd(b12)) {
                                                                            i31 += i116;
                                                                            cArr[i115] = (char) b12;
                                                                            i115++;
                                                                            i116 = 1;
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (b11 < -32) {
                                                                        if (i117 < i114) {
                                                                            i31 += 2;
                                                                            i34 = i115 + 1;
                                                                            zzhk.zzc(b11, bArr6[i117], cArr, i115);
                                                                        } else {
                                                                            throw zzfb.zzb();
                                                                        }
                                                                    } else if (b11 < -16) {
                                                                        if (i117 < i114 - 1) {
                                                                            int i118 = i31 + 2;
                                                                            i31 += 3;
                                                                            i34 = i115 + 1;
                                                                            zzhk.zzb(b11, bArr6[i117], bArr6[i118], cArr, i115);
                                                                        } else {
                                                                            throw zzfb.zzb();
                                                                        }
                                                                    } else if (i117 < i114 - 2) {
                                                                        byte b13 = bArr6[i117];
                                                                        int i119 = i31 + 3;
                                                                        byte b14 = bArr6[i31 + 2];
                                                                        i31 += 4;
                                                                        zzhk.zza(b11, b13, b14, bArr6[i119], cArr, i115);
                                                                        i115 += 2;
                                                                    } else {
                                                                        throw zzfb.zzb();
                                                                    }
                                                                    i115 = i34;
                                                                }
                                                                i116 = 1;
                                                            }
                                                            zzdtVar3.zzc = new String(cArr, 0, i115);
                                                            i31 = i114;
                                                        }
                                                    }
                                                    int i1162 = 1;
                                                    while (i31 < i114) {
                                                    }
                                                    zzdtVar3.zzc = new String(cArr, 0, i115);
                                                    i31 = i114;
                                                } else {
                                                    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i31), Integer.valueOf(i112)));
                                                }
                                            }
                                        } else {
                                            i31 = zzdu.zzh(bArr6, i32, zzdtVar3);
                                            int i120 = zzdtVar3.zza;
                                            if (i120 < 0) {
                                                throw zzfb.zzc();
                                            }
                                            if (i120 == 0) {
                                                zzdtVar3.zzc = "";
                                            } else {
                                                zzdtVar3.zzc = new String(bArr6, i31, i120, zzfa.zzb);
                                                i31 += i120;
                                            }
                                        }
                                        unsafe2.putObject(obj6, j10, zzdtVar3.zzc);
                                        i33 = i25 | i107;
                                        i58 = i11;
                                        i59 = i12;
                                        i63 = i31;
                                        unsafe4 = unsafe2;
                                        i65 = i29;
                                        zzdtVar6 = zzdtVar3;
                                        i68 = i28;
                                        i66 = i26;
                                        i64 = i27;
                                        i60 = 3;
                                        i62 = -1;
                                        i61 = 0;
                                        i67 = i33;
                                    }
                                    break;
                                case 9:
                                    zzdtVar3 = zzdtVar6;
                                    i27 = i71;
                                    i28 = i74;
                                    i29 = i20;
                                    unsafe2 = unsafe4;
                                    if (i72 != 2) {
                                        i14 = i12;
                                        i24 = i69;
                                        obj3 = obj6;
                                        unsafe = unsafe2;
                                        i23 = i29;
                                        zzdtVar2 = zzdtVar3;
                                        i17 = i28;
                                        i22 = i26;
                                        i21 = i27;
                                        i67 = i25;
                                        i13 = i11;
                                        break;
                                    } else {
                                        Object zzt = zzgaVar3.zzt(obj6, i29);
                                        i58 = i11;
                                        i31 = zzdu.zzm(zzt, zzgaVar3.zzr(i29), bArr, i69, i58, zzdtVar);
                                        zzgaVar3.zzB(obj6, i29, zzt);
                                        i33 = i25 | i107;
                                        i59 = i12;
                                        i63 = i31;
                                        unsafe4 = unsafe2;
                                        i65 = i29;
                                        zzdtVar6 = zzdtVar3;
                                        i68 = i28;
                                        i66 = i26;
                                        i64 = i27;
                                        i60 = 3;
                                        i62 = -1;
                                        i61 = 0;
                                        i67 = i33;
                                    }
                                case 10:
                                    zzdtVar3 = zzdtVar6;
                                    i27 = i71;
                                    i28 = i74;
                                    i29 = i20;
                                    unsafe2 = unsafe4;
                                    if (i72 != 2) {
                                        i14 = i12;
                                        i24 = i69;
                                        obj3 = obj6;
                                        unsafe = unsafe2;
                                        i23 = i29;
                                        zzdtVar2 = zzdtVar3;
                                        i17 = i28;
                                        i22 = i26;
                                        i21 = i27;
                                        i67 = i25;
                                        i13 = i11;
                                        break;
                                    } else {
                                        i63 = zzdu.zza(bArr6, i69, zzdtVar3);
                                        unsafe2.putObject(obj6, j10, zzdtVar3.zzc);
                                        i33 = i25 | i107;
                                        i58 = i11;
                                        i59 = i12;
                                        unsafe4 = unsafe2;
                                        i65 = i29;
                                        zzdtVar6 = zzdtVar3;
                                        i68 = i28;
                                        i66 = i26;
                                        i64 = i27;
                                        i60 = 3;
                                        i62 = -1;
                                        i61 = 0;
                                        i67 = i33;
                                    }
                                case 12:
                                    zzdtVar3 = zzdtVar6;
                                    i27 = i71;
                                    i28 = i74;
                                    i29 = i20;
                                    unsafe2 = unsafe4;
                                    if (i72 != 0) {
                                        i14 = i12;
                                        i24 = i69;
                                        obj3 = obj6;
                                        unsafe = unsafe2;
                                        i23 = i29;
                                        zzdtVar2 = zzdtVar3;
                                        i17 = i28;
                                        i22 = i26;
                                        i21 = i27;
                                        i67 = i25;
                                        i13 = i11;
                                        break;
                                    } else {
                                        i63 = zzdu.zzh(bArr6, i69, zzdtVar3);
                                        int i121 = zzdtVar3.zza;
                                        zzey zzq3 = zzgaVar3.zzq(i29);
                                        if ((i73 & Integer.MIN_VALUE) != 0 && zzq3 != null && !zzq3.zza()) {
                                            zzc(obj).zzh(i28, Long.valueOf(i121));
                                            i58 = i11;
                                            i59 = i12;
                                            unsafe4 = unsafe2;
                                            i65 = i29;
                                            zzdtVar6 = zzdtVar3;
                                            i68 = i28;
                                            i66 = i26;
                                            i64 = i27;
                                            i67 = i25;
                                            i60 = 3;
                                            i62 = -1;
                                            i61 = 0;
                                        } else {
                                            unsafe2.putInt(obj6, j10, i121);
                                            i30 = i25 | i107;
                                            i58 = i11;
                                            i59 = i12;
                                            unsafe4 = unsafe2;
                                            i65 = i29;
                                            zzdtVar6 = zzdtVar3;
                                            i68 = i28;
                                            i66 = i26;
                                            i64 = i27;
                                            i60 = 3;
                                            i62 = -1;
                                            i61 = 0;
                                            i67 = i30;
                                        }
                                    }
                                    break;
                                case 15:
                                    zzdtVar3 = zzdtVar6;
                                    i27 = i71;
                                    unsafe3 = unsafe4;
                                    i28 = i74;
                                    i29 = i20;
                                    if (i72 != 0) {
                                        unsafe2 = unsafe3;
                                        i14 = i12;
                                        i24 = i69;
                                        obj3 = obj6;
                                        unsafe = unsafe2;
                                        i23 = i29;
                                        zzdtVar2 = zzdtVar3;
                                        i17 = i28;
                                        i22 = i26;
                                        i21 = i27;
                                        i67 = i25;
                                        i13 = i11;
                                        break;
                                    } else {
                                        i63 = zzdu.zzh(bArr6, i69, zzdtVar3);
                                        unsafe2 = unsafe3;
                                        unsafe2.putInt(obj6, j10, zzej.zzb(zzdtVar3.zza));
                                        i30 = i25 | i107;
                                        i58 = i11;
                                        i59 = i12;
                                        unsafe4 = unsafe2;
                                        i65 = i29;
                                        zzdtVar6 = zzdtVar3;
                                        i68 = i28;
                                        i66 = i26;
                                        i64 = i27;
                                        i60 = 3;
                                        i62 = -1;
                                        i61 = 0;
                                        i67 = i30;
                                    }
                                case 16:
                                    unsafe3 = unsafe4;
                                    i28 = i74;
                                    i29 = i20;
                                    if (i72 != 0) {
                                        zzdtVar3 = zzdtVar6;
                                        i27 = i71;
                                        unsafe2 = unsafe3;
                                        i14 = i12;
                                        i24 = i69;
                                        obj3 = obj6;
                                        unsafe = unsafe2;
                                        i23 = i29;
                                        zzdtVar2 = zzdtVar3;
                                        i17 = i28;
                                        i22 = i26;
                                        i21 = i27;
                                        i67 = i25;
                                        i13 = i11;
                                        break;
                                    } else {
                                        i63 = zzdu.zzk(bArr6, i69, zzdtVar6);
                                        i27 = i71;
                                        unsafe3.putLong(obj, j10, zzej.zzc(zzdtVar6.zzb));
                                        i30 = i25 | i107;
                                        i58 = i11;
                                        i59 = i12;
                                        i65 = i29;
                                        zzdtVar6 = zzdtVar6;
                                        i68 = i28;
                                        i66 = i26;
                                        unsafe4 = unsafe3;
                                        i64 = i27;
                                        i60 = 3;
                                        i62 = -1;
                                        i61 = 0;
                                        i67 = i30;
                                    }
                                default:
                                    i60 = 3;
                                    if (i72 != 3) {
                                        zzdtVar3 = zzdtVar6;
                                        i27 = i71;
                                        i28 = i74;
                                        i29 = i20;
                                        unsafe2 = unsafe4;
                                        i14 = i12;
                                        i24 = i69;
                                        obj3 = obj6;
                                        unsafe = unsafe2;
                                        i23 = i29;
                                        zzdtVar2 = zzdtVar3;
                                        i17 = i28;
                                        i22 = i26;
                                        i21 = i27;
                                        i67 = i25;
                                        i13 = i11;
                                        break;
                                    } else {
                                        Object zzt2 = zzgaVar3.zzt(obj6, i20);
                                        int i122 = i20;
                                        i63 = zzdu.zzl(zzt2, zzgaVar3.zzr(i20), bArr, i69, i11, (i71 << 3) | 4, zzdtVar);
                                        zzgaVar3.zzB(obj6, i122, zzt2);
                                        i30 = i25 | i107;
                                        i64 = i71;
                                        i68 = i74;
                                        i65 = i122;
                                        i66 = i26;
                                        unsafe4 = unsafe4;
                                        i62 = -1;
                                        i61 = 0;
                                        i58 = i11;
                                        i59 = i12;
                                        i67 = i30;
                                    }
                            }
                        }
                    } else {
                        i13 = i58;
                        i14 = i59;
                        i21 = i71;
                        unsafe = unsafe4;
                        i22 = i66;
                        i23 = 0;
                        i17 = i70;
                        zzdt zzdtVar8 = zzdtVar6;
                        i24 = i69;
                        obj3 = obj6;
                        zzdtVar2 = zzdtVar8;
                    }
                    if (i17 == i14 || i14 == 0) {
                        bArr6 = bArr;
                        unsafe4 = unsafe;
                        i63 = zzdu.zzg(i17, bArr, i24, i11, zzc(obj), zzdtVar);
                        zzdtVar6 = zzdtVar2;
                        i59 = i14;
                        i58 = i13;
                        i68 = i17;
                        obj6 = obj3;
                        i66 = i22;
                        i65 = i23;
                        i60 = 3;
                        i62 = -1;
                        i61 = 0;
                        i64 = i21;
                        zzgaVar3 = this;
                    } else {
                        i19 = 1048575;
                        zzgaVar3 = this;
                        obj2 = obj3;
                        i63 = i24;
                        i16 = i67;
                        i18 = i22;
                        i15 = 1;
                    }
                } else {
                    zzm = zzgaVar3.zzm(i71, i61);
                }
                i20 = zzm;
                if (i20 == i62) {
                }
                if (i17 == i14) {
                }
                bArr6 = bArr;
                unsafe4 = unsafe;
                i63 = zzdu.zzg(i17, bArr, i24, i11, zzc(obj), zzdtVar);
                zzdtVar6 = zzdtVar2;
                i59 = i14;
                i58 = i13;
                i68 = i17;
                obj6 = obj3;
                i66 = i22;
                i65 = i23;
                i60 = 3;
                i62 = -1;
                i61 = 0;
                i64 = i21;
                zzgaVar3 = this;
            } else {
                i13 = i58;
                i14 = i59;
                obj2 = obj6;
                unsafe = unsafe4;
                i15 = 1;
                i16 = i67;
                i17 = i68;
                i18 = i66;
                i19 = 1048575;
            }
        }
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final Object zzd() {
        return ((zzev) this.zzg).zzc();
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zze(Object obj) {
        if (!zzH(obj)) {
            return;
        }
        if (obj instanceof zzev) {
            zzev zzevVar = (zzev) obj;
            zzevVar.zzl(Integer.MAX_VALUE);
            zzevVar.zza = 0;
            zzevVar.zzj();
        }
        int length = this.zzc.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            int zzo = zzo(i10);
            int i11 = 1048575 & zzo;
            int zzn = zzn(zzo);
            long j10 = i11;
            if (zzn != 9) {
                if (zzn != 60 && zzn != 68) {
                    switch (zzn) {
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            this.zzk.zza(obj, j10);
                            break;
                        case 50:
                            Unsafe unsafe = zzb;
                            Object object = unsafe.getObject(obj, j10);
                            if (object != null) {
                                ((zzfr) object).zzc();
                                unsafe.putObject(obj, j10, object);
                                break;
                            } else {
                                break;
                            }
                    }
                } else if (zzI(obj, this.zzc[i10], i10)) {
                    zzr(i10).zze(zzb.getObject(obj, j10));
                }
            }
            if (zzE(obj, i10)) {
                zzr(i10).zze(zzb.getObject(obj, j10));
            }
        }
        this.zzl.zze(obj);
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zzf(Object obj, Object obj2) {
        zzw(obj);
        obj2.getClass();
        for (int i10 = 0; i10 < this.zzc.length; i10 += 3) {
            int zzo = zzo(i10);
            int i11 = this.zzc[i10];
            long j10 = 1048575 & zzo;
            switch (zzn(zzo)) {
                case 0:
                    if (zzE(obj2, i10)) {
                        zzhj.zzl(obj, j10, zzhj.zza(obj2, j10));
                        zzz(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzE(obj2, i10)) {
                        zzhj.zzm(obj, j10, zzhj.zzb(obj2, j10));
                        zzz(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzE(obj2, i10)) {
                        zzhj.zzo(obj, j10, zzhj.zzd(obj2, j10));
                        zzz(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzE(obj2, i10)) {
                        zzhj.zzo(obj, j10, zzhj.zzd(obj2, j10));
                        zzz(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzE(obj2, i10)) {
                        zzhj.zzn(obj, j10, zzhj.zzc(obj2, j10));
                        zzz(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzE(obj2, i10)) {
                        zzhj.zzo(obj, j10, zzhj.zzd(obj2, j10));
                        zzz(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzE(obj2, i10)) {
                        zzhj.zzn(obj, j10, zzhj.zzc(obj2, j10));
                        zzz(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzE(obj2, i10)) {
                        zzhj.zzk(obj, j10, zzhj.zzt(obj2, j10));
                        zzz(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzE(obj2, i10)) {
                        zzhj.zzp(obj, j10, zzhj.zzf(obj2, j10));
                        zzz(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzx(obj, obj2, i10);
                    break;
                case 10:
                    if (zzE(obj2, i10)) {
                        zzhj.zzp(obj, j10, zzhj.zzf(obj2, j10));
                        zzz(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzE(obj2, i10)) {
                        zzhj.zzn(obj, j10, zzhj.zzc(obj2, j10));
                        zzz(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzE(obj2, i10)) {
                        zzhj.zzn(obj, j10, zzhj.zzc(obj2, j10));
                        zzz(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzE(obj2, i10)) {
                        zzhj.zzn(obj, j10, zzhj.zzc(obj2, j10));
                        zzz(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzE(obj2, i10)) {
                        zzhj.zzo(obj, j10, zzhj.zzd(obj2, j10));
                        zzz(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzE(obj2, i10)) {
                        zzhj.zzn(obj, j10, zzhj.zzc(obj2, j10));
                        zzz(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzE(obj2, i10)) {
                        zzhj.zzo(obj, j10, zzhj.zzd(obj2, j10));
                        zzz(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzx(obj, obj2, i10);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzk.zzb(obj, obj2, j10);
                    break;
                case 50:
                    int i12 = zzgk.zza;
                    zzhj.zzp(obj, j10, zzfs.zza(zzhj.zzf(obj, j10), zzhj.zzf(obj2, j10)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzI(obj2, i11, i10)) {
                        zzhj.zzp(obj, j10, zzhj.zzf(obj2, j10));
                        zzA(obj, i11, i10);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzy(obj, obj2, i10);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzI(obj2, i11, i10)) {
                        zzhj.zzp(obj, j10, zzhj.zzf(obj2, j10));
                        zzA(obj, i11, i10);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzy(obj, obj2, i10);
                    break;
            }
        }
        zzgk.zzd(this.zzl, obj, obj2);
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zzg(Object obj, byte[] bArr, int i10, int i11, zzdt zzdtVar) throws IOException {
        zzb(obj, bArr, i10, i11, 0, zzdtVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01c4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01c0 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.auth.zzgi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzh(Object obj, Object obj2) {
        boolean zzf;
        int length = this.zzc.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            int zzo = zzo(i10);
            long j10 = zzo & 1048575;
            switch (zzn(zzo)) {
                case 0:
                    if (zzD(obj, obj2, i10) && Double.doubleToLongBits(zzhj.zza(obj, j10)) == Double.doubleToLongBits(zzhj.zza(obj2, j10))) {
                    }
                    return false;
                case 1:
                    if (zzD(obj, obj2, i10) && Float.floatToIntBits(zzhj.zzb(obj, j10)) == Float.floatToIntBits(zzhj.zzb(obj2, j10))) {
                    }
                    return false;
                case 2:
                    if (zzD(obj, obj2, i10) && zzhj.zzd(obj, j10) == zzhj.zzd(obj2, j10)) {
                    }
                    return false;
                case 3:
                    if (zzD(obj, obj2, i10) && zzhj.zzd(obj, j10) == zzhj.zzd(obj2, j10)) {
                    }
                    return false;
                case 4:
                    if (zzD(obj, obj2, i10) && zzhj.zzc(obj, j10) == zzhj.zzc(obj2, j10)) {
                    }
                    return false;
                case 5:
                    if (zzD(obj, obj2, i10) && zzhj.zzd(obj, j10) == zzhj.zzd(obj2, j10)) {
                    }
                    return false;
                case 6:
                    if (zzD(obj, obj2, i10) && zzhj.zzc(obj, j10) == zzhj.zzc(obj2, j10)) {
                    }
                    return false;
                case 7:
                    if (zzD(obj, obj2, i10) && zzhj.zzt(obj, j10) == zzhj.zzt(obj2, j10)) {
                    }
                    return false;
                case 8:
                    if (zzD(obj, obj2, i10) && zzgk.zzf(zzhj.zzf(obj, j10), zzhj.zzf(obj2, j10))) {
                    }
                    return false;
                case 9:
                    if (zzD(obj, obj2, i10) && zzgk.zzf(zzhj.zzf(obj, j10), zzhj.zzf(obj2, j10))) {
                    }
                    return false;
                case 10:
                    if (zzD(obj, obj2, i10) && zzgk.zzf(zzhj.zzf(obj, j10), zzhj.zzf(obj2, j10))) {
                    }
                    return false;
                case 11:
                    if (zzD(obj, obj2, i10) && zzhj.zzc(obj, j10) == zzhj.zzc(obj2, j10)) {
                    }
                    return false;
                case 12:
                    if (zzD(obj, obj2, i10) && zzhj.zzc(obj, j10) == zzhj.zzc(obj2, j10)) {
                    }
                    return false;
                case 13:
                    if (zzD(obj, obj2, i10) && zzhj.zzc(obj, j10) == zzhj.zzc(obj2, j10)) {
                    }
                    return false;
                case 14:
                    if (zzD(obj, obj2, i10) && zzhj.zzd(obj, j10) == zzhj.zzd(obj2, j10)) {
                    }
                    return false;
                case 15:
                    if (zzD(obj, obj2, i10) && zzhj.zzc(obj, j10) == zzhj.zzc(obj2, j10)) {
                    }
                    return false;
                case 16:
                    if (zzD(obj, obj2, i10) && zzhj.zzd(obj, j10) == zzhj.zzd(obj2, j10)) {
                    }
                    return false;
                case 17:
                    if (zzD(obj, obj2, i10) && zzgk.zzf(zzhj.zzf(obj, j10), zzhj.zzf(obj2, j10))) {
                    }
                    return false;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zzf = zzgk.zzf(zzhj.zzf(obj, j10), zzhj.zzf(obj2, j10));
                    if (zzf) {
                        return false;
                    }
                case 50:
                    zzf = zzgk.zzf(zzhj.zzf(obj, j10), zzhj.zzf(obj2, j10));
                    if (zzf) {
                    }
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzl = zzl(i10) & 1048575;
                    if (zzhj.zzc(obj, zzl) == zzhj.zzc(obj2, zzl) && zzgk.zzf(zzhj.zzf(obj, j10), zzhj.zzf(obj2, j10))) {
                    }
                    return false;
                default:
            }
        }
        if (!this.zzl.zzb(obj).equals(this.zzl.zzb(obj2))) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final boolean zzi(Object obj) {
        int i10;
        int i11;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        while (i14 < this.zzi) {
            int i15 = this.zzh[i14];
            int i16 = this.zzc[i15];
            int zzo = zzo(i15);
            int i17 = this.zzc[i15 + 2];
            int i18 = i17 & 1048575;
            int i19 = 1 << (i17 >>> 20);
            if (i18 != i12) {
                if (i18 != 1048575) {
                    i13 = zzb.getInt(obj, i18);
                }
                i11 = i13;
                i10 = i18;
            } else {
                i10 = i12;
                i11 = i13;
            }
            if ((268435456 & zzo) != 0 && !zzF(obj, i15, i10, i11, i19)) {
                return false;
            }
            int zzn = zzn(zzo);
            if (zzn != 9 && zzn != 17) {
                if (zzn != 27) {
                    if (zzn != 60 && zzn != 68) {
                        if (zzn != 49) {
                            if (zzn == 50 && !((zzfr) zzhj.zzf(obj, zzo & 1048575)).isEmpty()) {
                                throw null;
                            }
                        }
                    } else if (zzI(obj, i16, i15) && !zzG(obj, zzo, zzr(i15))) {
                        return false;
                    }
                }
                List list = (List) zzhj.zzf(obj, zzo & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgi zzr = zzr(i15);
                    for (int i20 = 0; i20 < list.size(); i20++) {
                        if (!zzr.zzi(list.get(i20))) {
                            return false;
                        }
                    }
                }
            } else if (zzF(obj, i15, i10, i11, i19) && !zzG(obj, zzo, zzr(i15))) {
                return false;
            }
            i14++;
            i12 = i10;
            i13 = i11;
        }
        return true;
    }
}
