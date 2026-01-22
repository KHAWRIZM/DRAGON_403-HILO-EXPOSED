package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import kotlin.KotlinVersion;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzno<T> implements zznw<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzoo.zzq();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zznl zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzoh zzl;
    private final zzlr zzm;

    private zzno(int[] iArr, Object[] objArr, int i10, int i11, zznl zznlVar, boolean z10, int[] iArr2, int i12, int i13, zznq zznqVar, zzmx zzmxVar, zzoh zzohVar, zzlr zzlrVar, zzng zzngVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i10;
        this.zzf = i11;
        boolean z11 = false;
        if (zzlrVar != null && (zznlVar instanceof zzmb)) {
            z11 = true;
        }
        this.zzh = z11;
        this.zzi = iArr2;
        this.zzj = i12;
        this.zzk = i13;
        this.zzl = zzohVar;
        this.zzm = zzlrVar;
        this.zzg = zznlVar;
    }

    private static boolean zzA(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzme) {
            return ((zzme) obj).zzcf();
        }
        return true;
    }

    private static void zzB(Object obj) {
        if (zzA(obj)) {
        } else {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private static double zzC(Object obj, long j10) {
        return ((Double) zzoo.zzn(obj, j10)).doubleValue();
    }

    private static float zzD(Object obj, long j10) {
        return ((Float) zzoo.zzn(obj, j10)).floatValue();
    }

    private static int zzE(Object obj, long j10) {
        return ((Integer) zzoo.zzn(obj, j10)).intValue();
    }

    private static long zzF(Object obj, long j10) {
        return ((Long) zzoo.zzn(obj, j10)).longValue();
    }

    private static boolean zzG(Object obj, long j10) {
        return ((Boolean) zzoo.zzn(obj, j10)).booleanValue();
    }

    private final boolean zzH(Object obj, Object obj2, int i10) {
        if (zzJ(obj, i10) == zzJ(obj2, i10)) {
            return true;
        }
        return false;
    }

    private final boolean zzI(Object obj, int i10, int i11, int i12, int i13) {
        if (i11 == 1048575) {
            return zzJ(obj, i10);
        }
        if ((i12 & i13) != 0) {
            return true;
        }
        return false;
    }

    private final boolean zzJ(Object obj, int i10) {
        int zzy = zzy(i10);
        long j10 = zzy & 1048575;
        if (j10 == 1048575) {
            int zzx = zzx(i10);
            long j11 = zzx & 1048575;
            switch (zzz(zzx)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzoo.zzl(obj, j11)) == 0) {
                        return false;
                    }
                    return true;
                case 1:
                    if (Float.floatToRawIntBits(zzoo.zzj(obj, j11)) == 0) {
                        return false;
                    }
                    return true;
                case 2:
                    if (zzoo.zzf(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (zzoo.zzf(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (zzoo.zzd(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (zzoo.zzf(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (zzoo.zzd(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return zzoo.zzh(obj, j11);
                case 8:
                    Object zzn = zzoo.zzn(obj, j11);
                    if (zzn instanceof String) {
                        if (((String) zzn).isEmpty()) {
                            return false;
                        }
                        return true;
                    }
                    if (zzn instanceof zzlg) {
                        if (zzlg.zzb.equals(zzn)) {
                            return false;
                        }
                        return true;
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (zzoo.zzn(obj, j11) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    if (zzlg.zzb.equals(zzoo.zzn(obj, j11))) {
                        return false;
                    }
                    return true;
                case 11:
                    if (zzoo.zzd(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (zzoo.zzd(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (zzoo.zzd(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (zzoo.zzf(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (zzoo.zzd(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (zzoo.zzf(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (zzoo.zzn(obj, j11) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        }
        if ((zzoo.zzd(obj, j10) & (1 << (zzy >>> 20))) == 0) {
            return false;
        }
        return true;
    }

    private final void zzK(Object obj, int i10) {
        int zzy = zzy(i10);
        long j10 = 1048575 & zzy;
        if (j10 == 1048575) {
            return;
        }
        zzoo.zze(obj, j10, (1 << (zzy >>> 20)) | zzoo.zzd(obj, j10));
    }

    private final boolean zzL(Object obj, int i10, int i11) {
        if (zzoo.zzd(obj, zzy(i11) & 1048575) == i10) {
            return true;
        }
        return false;
    }

    private final void zzM(Object obj, int i10, int i11) {
        zzoo.zze(obj, zzy(i11) & 1048575, i10);
    }

    private final int zzN(int i10, int i11) {
        int[] iArr = this.zzc;
        int length = (iArr.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int i14 = iArr[i13];
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

    private static final int zzO(byte[] bArr, int i10, int i11, zzos zzosVar, Class cls, zzkv zzkvVar) throws IOException {
        int i12;
        boolean z10;
        zzos zzosVar2 = zzos.zza;
        switch (zzosVar.ordinal()) {
            case 0:
                i12 = i10 + 8;
                zzkvVar.zzc = Double.valueOf(Double.longBitsToDouble(zzkw.zze(bArr, i10)));
                break;
            case 1:
                i12 = i10 + 4;
                zzkvVar.zzc = Float.valueOf(Float.intBitsToFloat(zzkw.zzd(bArr, i10)));
                break;
            case 2:
            case 3:
                int zzc = zzkw.zzc(bArr, i10, zzkvVar);
                zzkvVar.zzc = Long.valueOf(zzkvVar.zzb);
                return zzc;
            case 4:
            case 12:
            case 13:
                int zza2 = zzkw.zza(bArr, i10, zzkvVar);
                zzkvVar.zzc = Integer.valueOf(zzkvVar.zza);
                return zza2;
            case 5:
            case 15:
                i12 = i10 + 8;
                zzkvVar.zzc = Long.valueOf(zzkw.zze(bArr, i10));
                break;
            case 6:
            case 14:
                i12 = i10 + 4;
                zzkvVar.zzc = Integer.valueOf(zzkw.zzd(bArr, i10));
                break;
            case 7:
                int zzc2 = zzkw.zzc(bArr, i10, zzkvVar);
                if (zzkvVar.zzb != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                zzkvVar.zzc = Boolean.valueOf(z10);
                return zzc2;
            case 8:
                return zzkw.zzf(bArr, i10, zzkvVar);
            case 9:
            default:
                throw new RuntimeException("unsupported field type.");
            case 10:
                return zzkw.zzh(zznt.zza().zzb(cls), bArr, i10, i11, zzkvVar);
            case 11:
                return zzkw.zzg(bArr, i10, zzkvVar);
            case 16:
                int zza3 = zzkw.zza(bArr, i10, zzkvVar);
                zzkvVar.zzc = Integer.valueOf(zzli.zzb(zzkvVar.zza));
                return zza3;
            case 17:
                int zzc3 = zzkw.zzc(bArr, i10, zzkvVar);
                zzkvVar.zzc = Long.valueOf(zzli.zzc(zzkvVar.zzb));
                return zzc3;
        }
        return i12;
    }

    private static final void zzP(int i10, Object obj, zzou zzouVar) throws IOException {
        if (obj instanceof String) {
            zzouVar.zzm(i10, (String) obj);
        } else {
            zzouVar.zzn(i10, (zzlg) obj);
        }
    }

    static zzoi zzg(Object obj) {
        zzme zzmeVar = (zzme) obj;
        zzoi zzoiVar = zzmeVar.zzc;
        if (zzoiVar == zzoi.zza()) {
            zzoi zzb2 = zzoi.zzb();
            zzmeVar.zzc = zzb2;
            return zzb2;
        }
        return zzoiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0268  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzno zzl(Class cls, zzni zzniVar, zznq zznqVar, zzmx zzmxVar, zzoh zzohVar, zzlr zzlrVar, zzng zzngVar) {
        int i10;
        int charAt;
        int charAt2;
        int i11;
        int i12;
        int i13;
        int[] iArr;
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
        zznv zznvVar;
        String str;
        int objectFieldOffset;
        int i28;
        Class<?> cls2;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        Field zzm;
        int i35;
        char charAt11;
        int i36;
        int i37;
        int i38;
        int i39;
        int i40;
        int i41;
        int i42;
        Object obj;
        Field zzm2;
        Object obj2;
        Field zzm3;
        int i43;
        char charAt12;
        int i44;
        char charAt13;
        int i45;
        char charAt14;
        int i46;
        char charAt15;
        if (zzniVar instanceof zznv) {
            zznv zznvVar2 = (zznv) zzniVar;
            String zzd = zznvVar2.zzd();
            int length = zzd.length();
            char c10 = 55296;
            if (zzd.charAt(0) >= 55296) {
                int i47 = 1;
                while (true) {
                    i10 = i47 + 1;
                    if (zzd.charAt(i47) < 55296) {
                        break;
                    }
                    i47 = i10;
                }
            } else {
                i10 = 1;
            }
            int i48 = i10 + 1;
            int charAt16 = zzd.charAt(i10);
            if (charAt16 >= 55296) {
                int i49 = charAt16 & 8191;
                int i50 = 13;
                while (true) {
                    i46 = i48 + 1;
                    charAt15 = zzd.charAt(i48);
                    if (charAt15 < 55296) {
                        break;
                    }
                    i49 |= (charAt15 & 8191) << i50;
                    i50 += 13;
                    i48 = i46;
                }
                charAt16 = i49 | (charAt15 << i50);
                i48 = i46;
            }
            if (charAt16 == 0) {
                iArr = zza;
                i15 = 0;
                i13 = 0;
                charAt = 0;
                charAt2 = 0;
                i11 = 0;
                i14 = 0;
                i12 = 0;
            } else {
                int i51 = i48 + 1;
                int charAt17 = zzd.charAt(i48);
                if (charAt17 >= 55296) {
                    int i52 = charAt17 & 8191;
                    int i53 = 13;
                    while (true) {
                        i23 = i51 + 1;
                        charAt10 = zzd.charAt(i51);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i52 |= (charAt10 & 8191) << i53;
                        i53 += 13;
                        i51 = i23;
                    }
                    charAt17 = i52 | (charAt10 << i53);
                    i51 = i23;
                }
                int i54 = i51 + 1;
                int charAt18 = zzd.charAt(i51);
                if (charAt18 >= 55296) {
                    int i55 = charAt18 & 8191;
                    int i56 = 13;
                    while (true) {
                        i22 = i54 + 1;
                        charAt9 = zzd.charAt(i54);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i55 |= (charAt9 & 8191) << i56;
                        i56 += 13;
                        i54 = i22;
                    }
                    charAt18 = i55 | (charAt9 << i56);
                    i54 = i22;
                }
                int i57 = i54 + 1;
                int charAt19 = zzd.charAt(i54);
                if (charAt19 >= 55296) {
                    int i58 = charAt19 & 8191;
                    int i59 = 13;
                    while (true) {
                        i21 = i57 + 1;
                        charAt8 = zzd.charAt(i57);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i58 |= (charAt8 & 8191) << i59;
                        i59 += 13;
                        i57 = i21;
                    }
                    charAt19 = i58 | (charAt8 << i59);
                    i57 = i21;
                }
                int i60 = i57 + 1;
                int charAt20 = zzd.charAt(i57);
                if (charAt20 >= 55296) {
                    int i61 = charAt20 & 8191;
                    int i62 = 13;
                    while (true) {
                        i20 = i60 + 1;
                        charAt7 = zzd.charAt(i60);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i61 |= (charAt7 & 8191) << i62;
                        i62 += 13;
                        i60 = i20;
                    }
                    charAt20 = i61 | (charAt7 << i62);
                    i60 = i20;
                }
                int i63 = i60 + 1;
                charAt = zzd.charAt(i60);
                if (charAt >= 55296) {
                    int i64 = charAt & 8191;
                    int i65 = 13;
                    while (true) {
                        i19 = i63 + 1;
                        charAt6 = zzd.charAt(i63);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i64 |= (charAt6 & 8191) << i65;
                        i65 += 13;
                        i63 = i19;
                    }
                    charAt = i64 | (charAt6 << i65);
                    i63 = i19;
                }
                int i66 = i63 + 1;
                charAt2 = zzd.charAt(i63);
                if (charAt2 >= 55296) {
                    int i67 = charAt2 & 8191;
                    int i68 = 13;
                    while (true) {
                        i18 = i66 + 1;
                        charAt5 = zzd.charAt(i66);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i67 |= (charAt5 & 8191) << i68;
                        i68 += 13;
                        i66 = i18;
                    }
                    charAt2 = i67 | (charAt5 << i68);
                    i66 = i18;
                }
                int i69 = i66 + 1;
                int charAt21 = zzd.charAt(i66);
                if (charAt21 >= 55296) {
                    int i70 = charAt21 & 8191;
                    int i71 = 13;
                    while (true) {
                        i17 = i69 + 1;
                        charAt4 = zzd.charAt(i69);
                        if (charAt4 < 55296) {
                            break;
                        }
                        i70 |= (charAt4 & 8191) << i71;
                        i71 += 13;
                        i69 = i17;
                    }
                    charAt21 = i70 | (charAt4 << i71);
                    i69 = i17;
                }
                int i72 = i69 + 1;
                int charAt22 = zzd.charAt(i69);
                if (charAt22 >= 55296) {
                    int i73 = charAt22 & 8191;
                    int i74 = 13;
                    while (true) {
                        i16 = i72 + 1;
                        charAt3 = zzd.charAt(i72);
                        if (charAt3 < 55296) {
                            break;
                        }
                        i73 |= (charAt3 & 8191) << i74;
                        i74 += 13;
                        i72 = i16;
                    }
                    charAt22 = i73 | (charAt3 << i74);
                    i72 = i16;
                }
                int i75 = charAt17 + charAt17 + charAt18;
                int[] iArr2 = new int[charAt22 + charAt2 + charAt21];
                i11 = charAt19;
                i12 = charAt22;
                i13 = i75;
                iArr = iArr2;
                i14 = charAt20;
                i15 = charAt17;
                i48 = i72;
            }
            Unsafe unsafe = zzb;
            Object[] zze = zznvVar2.zze();
            Class<?> cls3 = zznvVar2.zzb().getClass();
            int i76 = i12 + charAt2;
            int i77 = charAt + charAt;
            int[] iArr3 = new int[charAt * 3];
            Object[] objArr = new Object[i77];
            int i78 = i12;
            int i79 = i76;
            int i80 = 0;
            int i81 = 0;
            while (i48 < length) {
                int i82 = i48 + 1;
                int charAt23 = zzd.charAt(i48);
                if (charAt23 >= c10) {
                    int i83 = charAt23 & 8191;
                    int i84 = i82;
                    int i85 = 13;
                    while (true) {
                        i45 = i84 + 1;
                        charAt14 = zzd.charAt(i84);
                        if (charAt14 < c10) {
                            break;
                        }
                        i83 |= (charAt14 & 8191) << i85;
                        i85 += 13;
                        i84 = i45;
                    }
                    charAt23 = i83 | (charAt14 << i85);
                    i24 = i45;
                } else {
                    i24 = i82;
                }
                int i86 = i24 + 1;
                int charAt24 = zzd.charAt(i24);
                if (charAt24 >= c10) {
                    int i87 = charAt24 & 8191;
                    int i88 = i86;
                    int i89 = 13;
                    while (true) {
                        i44 = i88 + 1;
                        charAt13 = zzd.charAt(i88);
                        if (charAt13 < c10) {
                            break;
                        }
                        i87 |= (charAt13 & 8191) << i89;
                        i89 += 13;
                        i88 = i44;
                    }
                    charAt24 = i87 | (charAt13 << i89);
                    i25 = i44;
                } else {
                    i25 = i86;
                }
                if ((charAt24 & 1024) != 0) {
                    iArr[i80] = i81;
                    i80++;
                }
                int i90 = charAt24 & KotlinVersion.MAX_COMPONENT_VALUE;
                int i91 = length;
                int i92 = charAt24 & 2048;
                int i93 = i14;
                if (i90 >= 51) {
                    int i94 = i25 + 1;
                    int charAt25 = zzd.charAt(i25);
                    if (charAt25 >= 55296) {
                        int i95 = charAt25 & 8191;
                        int i96 = i94;
                        int i97 = 13;
                        while (true) {
                            i43 = i96 + 1;
                            charAt12 = zzd.charAt(i96);
                            i26 = i11;
                            if (charAt12 < 55296) {
                                break;
                            }
                            i95 |= (charAt12 & 8191) << i97;
                            i97 += 13;
                            i96 = i43;
                            i11 = i26;
                        }
                        charAt25 = i95 | (charAt12 << i97);
                        i41 = i43;
                    } else {
                        i26 = i11;
                        i41 = i94;
                    }
                    int i98 = i90 - 51;
                    int i99 = i41;
                    if (i98 != 9 && i98 != 17) {
                        if (i98 == 12) {
                            if (zznvVar2.zzc() != 1 && i92 == 0) {
                                i92 = 0;
                            } else {
                                i42 = i13 + 1;
                                int i100 = i81 / 3;
                                objArr[i100 + i100 + 1] = zze[i13];
                            }
                        }
                        int i101 = charAt25 + charAt25;
                        obj = zze[i101];
                        if (!(obj instanceof Field)) {
                            zzm2 = (Field) obj;
                        } else {
                            zzm2 = zzm(cls3, (String) obj);
                            zze[i101] = zzm2;
                        }
                        int objectFieldOffset2 = (int) unsafe.objectFieldOffset(zzm2);
                        int i102 = i101 + 1;
                        obj2 = zze[i102];
                        int i103 = i92;
                        if (!(obj2 instanceof Field)) {
                            zzm3 = (Field) obj2;
                        } else {
                            zzm3 = zzm(cls3, (String) obj2);
                            zze[i102] = zzm3;
                        }
                        i31 = (int) unsafe.objectFieldOffset(zzm3);
                        objectFieldOffset = objectFieldOffset2;
                        i33 = i103;
                        zznvVar = zznvVar2;
                        cls2 = cls3;
                        i32 = i99;
                        i27 = charAt23;
                        str = zzd;
                        i30 = 0;
                    } else {
                        i42 = i13 + 1;
                        int i104 = i81 / 3;
                        objArr[i104 + i104 + 1] = zze[i13];
                    }
                    i13 = i42;
                    int i1012 = charAt25 + charAt25;
                    obj = zze[i1012];
                    if (!(obj instanceof Field)) {
                    }
                    int objectFieldOffset22 = (int) unsafe.objectFieldOffset(zzm2);
                    int i1022 = i1012 + 1;
                    obj2 = zze[i1022];
                    int i1032 = i92;
                    if (!(obj2 instanceof Field)) {
                    }
                    i31 = (int) unsafe.objectFieldOffset(zzm3);
                    objectFieldOffset = objectFieldOffset22;
                    i33 = i1032;
                    zznvVar = zznvVar2;
                    cls2 = cls3;
                    i32 = i99;
                    i27 = charAt23;
                    str = zzd;
                    i30 = 0;
                } else {
                    i26 = i11;
                    int i105 = i13 + 1;
                    Field zzm4 = zzm(cls3, (String) zze[i13]);
                    i27 = charAt23;
                    if (i90 == 9 || i90 == 17) {
                        zznvVar = zznvVar2;
                        int i106 = i81 / 3;
                        objArr[i106 + i106 + 1] = zzm4.getType();
                    } else {
                        if (i90 != 27) {
                            if (i90 == 49) {
                                i37 = i13 + 2;
                                zznvVar = zznvVar2;
                                i36 = 1;
                            } else {
                                if (i90 != 12 && i90 != 30 && i90 != 44) {
                                    if (i90 == 50) {
                                        int i107 = i13 + 2;
                                        int i108 = i78 + 1;
                                        iArr[i78] = i81;
                                        int i109 = i81 / 3;
                                        int i110 = i109 + i109;
                                        objArr[i110] = zze[i105];
                                        if (i92 != 0) {
                                            i105 = i13 + 3;
                                            objArr[i110 + 1] = zze[i107];
                                            str = zzd;
                                            i78 = i108;
                                            zznvVar = zznvVar2;
                                        } else {
                                            i105 = i107;
                                            i78 = i108;
                                            i92 = 0;
                                            zznvVar = zznvVar2;
                                        }
                                    } else {
                                        zznvVar = zznvVar2;
                                    }
                                } else {
                                    zznvVar = zznvVar2;
                                    if (zznvVar2.zzc() != 1 && i92 == 0) {
                                        str = zzd;
                                        i92 = 0;
                                    } else {
                                        i37 = i13 + 2;
                                        int i111 = i81 / 3;
                                        objArr[i111 + i111 + 1] = zze[i105];
                                        str = zzd;
                                        i105 = i37;
                                    }
                                }
                                objectFieldOffset = (int) unsafe.objectFieldOffset(zzm4);
                                if ((charAt24 & 4096) == 0 && i90 <= 17) {
                                    int i112 = i25 + 1;
                                    int charAt26 = str.charAt(i25);
                                    if (charAt26 >= 55296) {
                                        int i113 = charAt26 & 8191;
                                        int i114 = 13;
                                        while (true) {
                                            i35 = i112 + 1;
                                            charAt11 = str.charAt(i112);
                                            if (charAt11 < 55296) {
                                                break;
                                            }
                                            i113 |= (charAt11 & 8191) << i114;
                                            i114 += 13;
                                            i112 = i35;
                                        }
                                        charAt26 = i113 | (charAt11 << i114);
                                        i34 = i35;
                                    } else {
                                        i34 = i112;
                                    }
                                    int i115 = i15 + i15 + (charAt26 / 32);
                                    Object obj3 = zze[i115];
                                    i28 = i92;
                                    if (obj3 instanceof Field) {
                                        zzm = (Field) obj3;
                                    } else {
                                        zzm = zzm(cls3, (String) obj3);
                                        zze[i115] = zzm;
                                    }
                                    cls2 = cls3;
                                    i30 = charAt26 % 32;
                                    i29 = i34;
                                    i31 = (int) unsafe.objectFieldOffset(zzm);
                                } else {
                                    i28 = i92;
                                    cls2 = cls3;
                                    i29 = i25;
                                    i30 = 0;
                                    i31 = 1048575;
                                }
                                if (i90 < 18 && i90 <= 49) {
                                    iArr[i79] = objectFieldOffset;
                                    i79++;
                                    i13 = i105;
                                    i32 = i29;
                                } else {
                                    i32 = i29;
                                    i13 = i105;
                                }
                                i33 = i28;
                            }
                        } else {
                            zznvVar = zznvVar2;
                            i36 = 1;
                            i37 = i13 + 2;
                        }
                        int i116 = i81 / 3;
                        objArr[i116 + i116 + i36] = zze[i105];
                        str = zzd;
                        i105 = i37;
                        objectFieldOffset = (int) unsafe.objectFieldOffset(zzm4);
                        if ((charAt24 & 4096) == 0) {
                        }
                        i28 = i92;
                        cls2 = cls3;
                        i29 = i25;
                        i30 = 0;
                        i31 = 1048575;
                        if (i90 < 18) {
                        }
                        i32 = i29;
                        i13 = i105;
                        i33 = i28;
                    }
                    str = zzd;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zzm4);
                    if ((charAt24 & 4096) == 0) {
                    }
                    i28 = i92;
                    cls2 = cls3;
                    i29 = i25;
                    i30 = 0;
                    i31 = 1048575;
                    if (i90 < 18) {
                    }
                    i32 = i29;
                    i13 = i105;
                    i33 = i28;
                }
                int i117 = i81 + 1;
                iArr3[i81] = i27;
                int i118 = i81 + 2;
                Class<?> cls4 = cls2;
                if ((charAt24 & 512) != 0) {
                    i38 = 536870912;
                } else {
                    i38 = 0;
                }
                if ((charAt24 & 256) != 0) {
                    i39 = 268435456;
                } else {
                    i39 = 0;
                }
                if (i33 != 0) {
                    i40 = Integer.MIN_VALUE;
                } else {
                    i40 = 0;
                }
                iArr3[i117] = i38 | i39 | i40 | (i90 << 20) | objectFieldOffset;
                i81 += 3;
                iArr3[i118] = (i30 << 20) | i31;
                zzd = str;
                length = i91;
                i14 = i93;
                zznvVar2 = zznvVar;
                i11 = i26;
                c10 = 55296;
                i48 = i32;
                cls3 = cls4;
            }
            return new zzno(iArr3, objArr, i11, i14, zznvVar2.zzb(), false, iArr, i12, i76, zznqVar, zzmxVar, zzohVar, zzlrVar, zzngVar);
        }
        throw null;
    }

    private static Field zzm(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e10) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + name.length() + 29 + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString(), e10);
        }
    }

    private final void zzn(Object obj, Object obj2, int i10) {
        if (!zzJ(obj2, i10)) {
            return;
        }
        int zzx = zzx(i10) & 1048575;
        Unsafe unsafe = zzb;
        long j10 = zzx;
        Object object = unsafe.getObject(obj2, j10);
        if (object != null) {
            zznw zzp = zzp(i10);
            if (!zzJ(obj, i10)) {
                if (!zzA(object)) {
                    unsafe.putObject(obj, j10, object);
                } else {
                    Object zza2 = zzp.zza();
                    zzp.zzd(zza2, object);
                    unsafe.putObject(obj, j10, zza2);
                }
                zzK(obj, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, j10);
            if (!zzA(object2)) {
                Object zza3 = zzp.zza();
                zzp.zzd(zza3, object2);
                unsafe.putObject(obj, j10, zza3);
                object2 = zza3;
            }
            zzp.zzd(object2, object);
            return;
        }
        int i11 = this.zzc[i10];
        String obj3 = obj2.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(i11).length() + 38 + obj3.length());
        sb.append("Source subfield ");
        sb.append(i11);
        sb.append(" is present but null: ");
        sb.append(obj3);
        throw new IllegalStateException(sb.toString());
    }

    private final void zzo(Object obj, Object obj2, int i10) {
        int[] iArr = this.zzc;
        int i11 = iArr[i10];
        if (!zzL(obj2, i11, i10)) {
            return;
        }
        int zzx = zzx(i10) & 1048575;
        Unsafe unsafe = zzb;
        long j10 = zzx;
        Object object = unsafe.getObject(obj2, j10);
        if (object != null) {
            zznw zzp = zzp(i10);
            if (!zzL(obj, i11, i10)) {
                if (!zzA(object)) {
                    unsafe.putObject(obj, j10, object);
                } else {
                    Object zza2 = zzp.zza();
                    zzp.zzd(zza2, object);
                    unsafe.putObject(obj, j10, zza2);
                }
                zzM(obj, i11, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, j10);
            if (!zzA(object2)) {
                Object zza3 = zzp.zza();
                zzp.zzd(zza3, object2);
                unsafe.putObject(obj, j10, zza3);
                object2 = zza3;
            }
            zzp.zzd(object2, object);
            return;
        }
        int i12 = iArr[i10];
        String obj3 = obj2.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(i12).length() + 38 + obj3.length());
        sb.append("Source subfield ");
        sb.append(i12);
        sb.append(" is present but null: ");
        sb.append(obj3);
        throw new IllegalStateException(sb.toString());
    }

    private final zznw zzp(int i10) {
        Object[] objArr = this.zzd;
        int i11 = i10 / 3;
        int i12 = i11 + i11;
        zznw zznwVar = (zznw) objArr[i12];
        if (zznwVar != null) {
            return zznwVar;
        }
        zznw zzb2 = zznt.zza().zzb((Class) objArr[i12 + 1]);
        objArr[i12] = zzb2;
        return zzb2;
    }

    private final Object zzq(int i10) {
        int i11 = i10 / 3;
        return this.zzd[i11 + i11];
    }

    private final zzmj zzr(int i10) {
        int i11 = i10 / 3;
        return (zzmj) this.zzd[i11 + i11 + 1];
    }

    private final Object zzs(Object obj, int i10) {
        zznw zzp = zzp(i10);
        int zzx = zzx(i10) & 1048575;
        if (!zzJ(obj, i10)) {
            return zzp.zza();
        }
        Object object = zzb.getObject(obj, zzx);
        if (zzA(object)) {
            return object;
        }
        Object zza2 = zzp.zza();
        if (object != null) {
            zzp.zzd(zza2, object);
        }
        return zza2;
    }

    private final void zzt(Object obj, int i10, Object obj2) {
        zzb.putObject(obj, zzx(i10) & 1048575, obj2);
        zzK(obj, i10);
    }

    private final Object zzu(Object obj, int i10, int i11) {
        zznw zzp = zzp(i11);
        if (!zzL(obj, i10, i11)) {
            return zzp.zza();
        }
        Object object = zzb.getObject(obj, zzx(i11) & 1048575);
        if (zzA(object)) {
            return object;
        }
        Object zza2 = zzp.zza();
        if (object != null) {
            zzp.zzd(zza2, object);
        }
        return zza2;
    }

    private final void zzv(Object obj, int i10, int i11, Object obj2) {
        zzb.putObject(obj, zzx(i11) & 1048575, obj2);
        zzM(obj, i10, i11);
    }

    private static boolean zzw(Object obj, int i10, zznw zznwVar) {
        return zznwVar.zzk(zzoo.zzn(obj, i10 & 1048575));
    }

    private final int zzx(int i10) {
        return this.zzc[i10 + 1];
    }

    private final int zzy(int i10) {
        return this.zzc[i10 + 2];
    }

    private static int zzz(int i10) {
        return (i10 >>> 20) & KotlinVersion.MAX_COMPONENT_VALUE;
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final Object zza() {
        return ((zzme) this.zzg).zzch();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01c4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01c0 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zznw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzb(Object obj, Object obj2) {
        boolean zzB;
        for (int i10 = 0; i10 < this.zzc.length; i10 += 3) {
            int zzx = zzx(i10);
            long j10 = zzx & 1048575;
            switch (zzz(zzx)) {
                case 0:
                    if (zzH(obj, obj2, i10) && Double.doubleToLongBits(zzoo.zzl(obj, j10)) == Double.doubleToLongBits(zzoo.zzl(obj2, j10))) {
                    }
                    return false;
                case 1:
                    if (zzH(obj, obj2, i10) && Float.floatToIntBits(zzoo.zzj(obj, j10)) == Float.floatToIntBits(zzoo.zzj(obj2, j10))) {
                    }
                    return false;
                case 2:
                    if (zzH(obj, obj2, i10) && zzoo.zzf(obj, j10) == zzoo.zzf(obj2, j10)) {
                    }
                    return false;
                case 3:
                    if (zzH(obj, obj2, i10) && zzoo.zzf(obj, j10) == zzoo.zzf(obj2, j10)) {
                    }
                    return false;
                case 4:
                    if (zzH(obj, obj2, i10) && zzoo.zzd(obj, j10) == zzoo.zzd(obj2, j10)) {
                    }
                    return false;
                case 5:
                    if (zzH(obj, obj2, i10) && zzoo.zzf(obj, j10) == zzoo.zzf(obj2, j10)) {
                    }
                    return false;
                case 6:
                    if (zzH(obj, obj2, i10) && zzoo.zzd(obj, j10) == zzoo.zzd(obj2, j10)) {
                    }
                    return false;
                case 7:
                    if (zzH(obj, obj2, i10) && zzoo.zzh(obj, j10) == zzoo.zzh(obj2, j10)) {
                    }
                    return false;
                case 8:
                    if (zzH(obj, obj2, i10) && zzny.zzB(zzoo.zzn(obj, j10), zzoo.zzn(obj2, j10))) {
                    }
                    return false;
                case 9:
                    if (zzH(obj, obj2, i10) && zzny.zzB(zzoo.zzn(obj, j10), zzoo.zzn(obj2, j10))) {
                    }
                    return false;
                case 10:
                    if (zzH(obj, obj2, i10) && zzny.zzB(zzoo.zzn(obj, j10), zzoo.zzn(obj2, j10))) {
                    }
                    return false;
                case 11:
                    if (zzH(obj, obj2, i10) && zzoo.zzd(obj, j10) == zzoo.zzd(obj2, j10)) {
                    }
                    return false;
                case 12:
                    if (zzH(obj, obj2, i10) && zzoo.zzd(obj, j10) == zzoo.zzd(obj2, j10)) {
                    }
                    return false;
                case 13:
                    if (zzH(obj, obj2, i10) && zzoo.zzd(obj, j10) == zzoo.zzd(obj2, j10)) {
                    }
                    return false;
                case 14:
                    if (zzH(obj, obj2, i10) && zzoo.zzf(obj, j10) == zzoo.zzf(obj2, j10)) {
                    }
                    return false;
                case 15:
                    if (zzH(obj, obj2, i10) && zzoo.zzd(obj, j10) == zzoo.zzd(obj2, j10)) {
                    }
                    return false;
                case 16:
                    if (zzH(obj, obj2, i10) && zzoo.zzf(obj, j10) == zzoo.zzf(obj2, j10)) {
                    }
                    return false;
                case 17:
                    if (zzH(obj, obj2, i10) && zzny.zzB(zzoo.zzn(obj, j10), zzoo.zzn(obj2, j10))) {
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
                    zzB = zzny.zzB(zzoo.zzn(obj, j10), zzoo.zzn(obj2, j10));
                    if (zzB) {
                        return false;
                    }
                case 50:
                    zzB = zzny.zzB(zzoo.zzn(obj, j10), zzoo.zzn(obj2, j10));
                    if (zzB) {
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
                    long zzy = zzy(i10) & 1048575;
                    if (zzoo.zzd(obj, zzy) == zzoo.zzd(obj2, zzy) && zzny.zzB(zzoo.zzn(obj, j10), zzoo.zzn(obj2, j10))) {
                    }
                    return false;
                default:
            }
        }
        if (!((zzme) obj).zzc.equals(((zzme) obj2).zzc)) {
            return false;
        }
        if (this.zzh) {
            return ((zzmb) obj).zzb.equals(((zzmb) obj2).zzb);
        }
        return true;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001a. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zznw
    public final int zzc(Object obj) {
        int i10;
        long doubleToLongBits;
        int i11;
        int floatToIntBits;
        int i12;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i13 < iArr.length) {
                int zzx = zzx(i13);
                int i15 = 1048575 & zzx;
                int zzz = zzz(zzx);
                int i16 = iArr[i13];
                long j10 = i15;
                int i17 = 37;
                switch (zzz) {
                    case 0:
                        i10 = i14 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzoo.zzl(obj, j10));
                        byte[] bArr = zzmo.zzb;
                        i14 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    case 1:
                        i11 = i14 * 53;
                        floatToIntBits = Float.floatToIntBits(zzoo.zzj(obj, j10));
                        i14 = i11 + floatToIntBits;
                        break;
                    case 2:
                        i10 = i14 * 53;
                        doubleToLongBits = zzoo.zzf(obj, j10);
                        byte[] bArr2 = zzmo.zzb;
                        i14 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    case 3:
                        i10 = i14 * 53;
                        doubleToLongBits = zzoo.zzf(obj, j10);
                        byte[] bArr3 = zzmo.zzb;
                        i14 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    case 4:
                        i11 = i14 * 53;
                        floatToIntBits = zzoo.zzd(obj, j10);
                        i14 = i11 + floatToIntBits;
                        break;
                    case 5:
                        i10 = i14 * 53;
                        doubleToLongBits = zzoo.zzf(obj, j10);
                        byte[] bArr4 = zzmo.zzb;
                        i14 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    case 6:
                        i11 = i14 * 53;
                        floatToIntBits = zzoo.zzd(obj, j10);
                        i14 = i11 + floatToIntBits;
                        break;
                    case 7:
                        i11 = i14 * 53;
                        floatToIntBits = zzmo.zzb(zzoo.zzh(obj, j10));
                        i14 = i11 + floatToIntBits;
                        break;
                    case 8:
                        i11 = i14 * 53;
                        floatToIntBits = ((String) zzoo.zzn(obj, j10)).hashCode();
                        i14 = i11 + floatToIntBits;
                        break;
                    case 9:
                        i12 = i14 * 53;
                        Object zzn = zzoo.zzn(obj, j10);
                        if (zzn != null) {
                            i17 = zzn.hashCode();
                        }
                        i14 = i12 + i17;
                        break;
                    case 10:
                        i11 = i14 * 53;
                        floatToIntBits = zzoo.zzn(obj, j10).hashCode();
                        i14 = i11 + floatToIntBits;
                        break;
                    case 11:
                        i11 = i14 * 53;
                        floatToIntBits = zzoo.zzd(obj, j10);
                        i14 = i11 + floatToIntBits;
                        break;
                    case 12:
                        i11 = i14 * 53;
                        floatToIntBits = zzoo.zzd(obj, j10);
                        i14 = i11 + floatToIntBits;
                        break;
                    case 13:
                        i11 = i14 * 53;
                        floatToIntBits = zzoo.zzd(obj, j10);
                        i14 = i11 + floatToIntBits;
                        break;
                    case 14:
                        i10 = i14 * 53;
                        doubleToLongBits = zzoo.zzf(obj, j10);
                        byte[] bArr5 = zzmo.zzb;
                        i14 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    case 15:
                        i11 = i14 * 53;
                        floatToIntBits = zzoo.zzd(obj, j10);
                        i14 = i11 + floatToIntBits;
                        break;
                    case 16:
                        i10 = i14 * 53;
                        doubleToLongBits = zzoo.zzf(obj, j10);
                        byte[] bArr6 = zzmo.zzb;
                        i14 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    case 17:
                        i12 = i14 * 53;
                        Object zzn2 = zzoo.zzn(obj, j10);
                        if (zzn2 != null) {
                            i17 = zzn2.hashCode();
                        }
                        i14 = i12 + i17;
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
                        i11 = i14 * 53;
                        floatToIntBits = zzoo.zzn(obj, j10).hashCode();
                        i14 = i11 + floatToIntBits;
                        break;
                    case 50:
                        i11 = i14 * 53;
                        floatToIntBits = zzoo.zzn(obj, j10).hashCode();
                        i14 = i11 + floatToIntBits;
                        break;
                    case 51:
                        if (!zzL(obj, i16, i13)) {
                            break;
                        } else {
                            i10 = i14 * 53;
                            doubleToLongBits = Double.doubleToLongBits(zzC(obj, j10));
                            byte[] bArr7 = zzmo.zzb;
                            i14 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                            break;
                        }
                    case 52:
                        if (!zzL(obj, i16, i13)) {
                            break;
                        } else {
                            i11 = i14 * 53;
                            floatToIntBits = Float.floatToIntBits(zzD(obj, j10));
                            i14 = i11 + floatToIntBits;
                            break;
                        }
                    case 53:
                        if (!zzL(obj, i16, i13)) {
                            break;
                        } else {
                            i10 = i14 * 53;
                            doubleToLongBits = zzF(obj, j10);
                            byte[] bArr8 = zzmo.zzb;
                            i14 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                            break;
                        }
                    case 54:
                        if (!zzL(obj, i16, i13)) {
                            break;
                        } else {
                            i10 = i14 * 53;
                            doubleToLongBits = zzF(obj, j10);
                            byte[] bArr9 = zzmo.zzb;
                            i14 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                            break;
                        }
                    case 55:
                        if (!zzL(obj, i16, i13)) {
                            break;
                        } else {
                            i11 = i14 * 53;
                            floatToIntBits = zzE(obj, j10);
                            i14 = i11 + floatToIntBits;
                            break;
                        }
                    case 56:
                        if (!zzL(obj, i16, i13)) {
                            break;
                        } else {
                            i10 = i14 * 53;
                            doubleToLongBits = zzF(obj, j10);
                            byte[] bArr10 = zzmo.zzb;
                            i14 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                            break;
                        }
                    case 57:
                        if (!zzL(obj, i16, i13)) {
                            break;
                        } else {
                            i11 = i14 * 53;
                            floatToIntBits = zzE(obj, j10);
                            i14 = i11 + floatToIntBits;
                            break;
                        }
                    case 58:
                        if (!zzL(obj, i16, i13)) {
                            break;
                        } else {
                            i11 = i14 * 53;
                            floatToIntBits = zzmo.zzb(zzG(obj, j10));
                            i14 = i11 + floatToIntBits;
                            break;
                        }
                    case 59:
                        if (!zzL(obj, i16, i13)) {
                            break;
                        } else {
                            i11 = i14 * 53;
                            floatToIntBits = ((String) zzoo.zzn(obj, j10)).hashCode();
                            i14 = i11 + floatToIntBits;
                            break;
                        }
                    case 60:
                        if (!zzL(obj, i16, i13)) {
                            break;
                        } else {
                            i11 = i14 * 53;
                            floatToIntBits = zzoo.zzn(obj, j10).hashCode();
                            i14 = i11 + floatToIntBits;
                            break;
                        }
                    case 61:
                        if (!zzL(obj, i16, i13)) {
                            break;
                        } else {
                            i11 = i14 * 53;
                            floatToIntBits = zzoo.zzn(obj, j10).hashCode();
                            i14 = i11 + floatToIntBits;
                            break;
                        }
                    case 62:
                        if (!zzL(obj, i16, i13)) {
                            break;
                        } else {
                            i11 = i14 * 53;
                            floatToIntBits = zzE(obj, j10);
                            i14 = i11 + floatToIntBits;
                            break;
                        }
                    case 63:
                        if (!zzL(obj, i16, i13)) {
                            break;
                        } else {
                            i11 = i14 * 53;
                            floatToIntBits = zzE(obj, j10);
                            i14 = i11 + floatToIntBits;
                            break;
                        }
                    case 64:
                        if (!zzL(obj, i16, i13)) {
                            break;
                        } else {
                            i11 = i14 * 53;
                            floatToIntBits = zzE(obj, j10);
                            i14 = i11 + floatToIntBits;
                            break;
                        }
                    case 65:
                        if (!zzL(obj, i16, i13)) {
                            break;
                        } else {
                            i10 = i14 * 53;
                            doubleToLongBits = zzF(obj, j10);
                            byte[] bArr11 = zzmo.zzb;
                            i14 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                            break;
                        }
                    case 66:
                        if (!zzL(obj, i16, i13)) {
                            break;
                        } else {
                            i11 = i14 * 53;
                            floatToIntBits = zzE(obj, j10);
                            i14 = i11 + floatToIntBits;
                            break;
                        }
                    case 67:
                        if (!zzL(obj, i16, i13)) {
                            break;
                        } else {
                            i10 = i14 * 53;
                            doubleToLongBits = zzF(obj, j10);
                            byte[] bArr12 = zzmo.zzb;
                            i14 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                            break;
                        }
                    case 68:
                        if (!zzL(obj, i16, i13)) {
                            break;
                        } else {
                            i11 = i14 * 53;
                            floatToIntBits = zzoo.zzn(obj, j10).hashCode();
                            i14 = i11 + floatToIntBits;
                            break;
                        }
                }
                i13 += 3;
            } else {
                int hashCode = (i14 * 53) + ((zzme) obj).zzc.hashCode();
                if (this.zzh) {
                    return (hashCode * 53) + ((zzmb) obj).zzb.zza.hashCode();
                }
                return hashCode;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final void zzd(Object obj, Object obj2) {
        zzB(obj);
        obj2.getClass();
        int i10 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i10 < iArr.length) {
                int zzx = zzx(i10);
                int i11 = 1048575 & zzx;
                int zzz = zzz(zzx);
                int i12 = iArr[i10];
                long j10 = i11;
                switch (zzz) {
                    case 0:
                        if (!zzJ(obj2, i10)) {
                            break;
                        } else {
                            zzoo.zzm(obj, j10, zzoo.zzl(obj2, j10));
                            zzK(obj, i10);
                            break;
                        }
                    case 1:
                        if (!zzJ(obj2, i10)) {
                            break;
                        } else {
                            zzoo.zzk(obj, j10, zzoo.zzj(obj2, j10));
                            zzK(obj, i10);
                            break;
                        }
                    case 2:
                        if (!zzJ(obj2, i10)) {
                            break;
                        } else {
                            zzoo.zzg(obj, j10, zzoo.zzf(obj2, j10));
                            zzK(obj, i10);
                            break;
                        }
                    case 3:
                        if (!zzJ(obj2, i10)) {
                            break;
                        } else {
                            zzoo.zzg(obj, j10, zzoo.zzf(obj2, j10));
                            zzK(obj, i10);
                            break;
                        }
                    case 4:
                        if (!zzJ(obj2, i10)) {
                            break;
                        } else {
                            zzoo.zze(obj, j10, zzoo.zzd(obj2, j10));
                            zzK(obj, i10);
                            break;
                        }
                    case 5:
                        if (!zzJ(obj2, i10)) {
                            break;
                        } else {
                            zzoo.zzg(obj, j10, zzoo.zzf(obj2, j10));
                            zzK(obj, i10);
                            break;
                        }
                    case 6:
                        if (!zzJ(obj2, i10)) {
                            break;
                        } else {
                            zzoo.zze(obj, j10, zzoo.zzd(obj2, j10));
                            zzK(obj, i10);
                            break;
                        }
                    case 7:
                        if (!zzJ(obj2, i10)) {
                            break;
                        } else {
                            zzoo.zzi(obj, j10, zzoo.zzh(obj2, j10));
                            zzK(obj, i10);
                            break;
                        }
                    case 8:
                        if (!zzJ(obj2, i10)) {
                            break;
                        } else {
                            zzoo.zzo(obj, j10, zzoo.zzn(obj2, j10));
                            zzK(obj, i10);
                            break;
                        }
                    case 9:
                        zzn(obj, obj2, i10);
                        break;
                    case 10:
                        if (!zzJ(obj2, i10)) {
                            break;
                        } else {
                            zzoo.zzo(obj, j10, zzoo.zzn(obj2, j10));
                            zzK(obj, i10);
                            break;
                        }
                    case 11:
                        if (!zzJ(obj2, i10)) {
                            break;
                        } else {
                            zzoo.zze(obj, j10, zzoo.zzd(obj2, j10));
                            zzK(obj, i10);
                            break;
                        }
                    case 12:
                        if (!zzJ(obj2, i10)) {
                            break;
                        } else {
                            zzoo.zze(obj, j10, zzoo.zzd(obj2, j10));
                            zzK(obj, i10);
                            break;
                        }
                    case 13:
                        if (!zzJ(obj2, i10)) {
                            break;
                        } else {
                            zzoo.zze(obj, j10, zzoo.zzd(obj2, j10));
                            zzK(obj, i10);
                            break;
                        }
                    case 14:
                        if (!zzJ(obj2, i10)) {
                            break;
                        } else {
                            zzoo.zzg(obj, j10, zzoo.zzf(obj2, j10));
                            zzK(obj, i10);
                            break;
                        }
                    case 15:
                        if (!zzJ(obj2, i10)) {
                            break;
                        } else {
                            zzoo.zze(obj, j10, zzoo.zzd(obj2, j10));
                            zzK(obj, i10);
                            break;
                        }
                    case 16:
                        if (!zzJ(obj2, i10)) {
                            break;
                        } else {
                            zzoo.zzg(obj, j10, zzoo.zzf(obj2, j10));
                            zzK(obj, i10);
                            break;
                        }
                    case 17:
                        zzn(obj, obj2, i10);
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
                        zzmn zzmnVar = (zzmn) zzoo.zzn(obj, j10);
                        zzmn zzmnVar2 = (zzmn) zzoo.zzn(obj2, j10);
                        int size = zzmnVar.size();
                        int size2 = zzmnVar2.size();
                        if (size > 0 && size2 > 0) {
                            if (!zzmnVar.zza()) {
                                zzmnVar = zzmnVar.zzg(size2 + size);
                            }
                            zzmnVar.addAll(zzmnVar2);
                        }
                        if (size > 0) {
                            zzmnVar2 = zzmnVar;
                        }
                        zzoo.zzo(obj, j10, zzmnVar2);
                        break;
                    case 50:
                        int i13 = zzny.zza;
                        zzoo.zzo(obj, j10, zzng.zza(zzoo.zzn(obj, j10), zzoo.zzn(obj2, j10)));
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
                        if (!zzL(obj2, i12, i10)) {
                            break;
                        } else {
                            zzoo.zzo(obj, j10, zzoo.zzn(obj2, j10));
                            zzM(obj, i12, i10);
                            break;
                        }
                    case 60:
                        zzo(obj, obj2, i10);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zzL(obj2, i12, i10)) {
                            break;
                        } else {
                            zzoo.zzo(obj, j10, zzoo.zzn(obj2, j10));
                            zzM(obj, i12, i10);
                            break;
                        }
                    case 68:
                        zzo(obj, obj2, i10);
                        break;
                }
                i10 += 3;
            } else {
                zzny.zzD(this.zzl, obj, obj2);
                if (this.zzh) {
                    zzny.zzC(this.zzm, obj, obj2);
                    return;
                }
                return;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0056. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zznw
    public final int zze(Object obj) {
        int i10;
        int i11;
        int i12;
        int zzz;
        int zzz2;
        int zzz3;
        int zzA;
        int zzz4;
        int zzz5;
        int zzc;
        int zzz6;
        int zzz7;
        int zzo;
        int size;
        int zzz8;
        int zzz9;
        int zzz10;
        int zzx;
        int zzz11;
        int zzz12;
        int i13;
        Unsafe unsafe = zzb;
        boolean z10 = false;
        int i14 = 1048575;
        int i15 = 1048575;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i17 < iArr.length) {
                int zzx2 = zzx(i17);
                int zzz13 = zzz(zzx2);
                int i19 = iArr[i17];
                int i20 = iArr[i17 + 2];
                int i21 = i20 & i14;
                if (zzz13 <= 17) {
                    if (i21 != i15) {
                        i16 = i21 == i14 ? 0 : unsafe.getInt(obj, i21);
                        i15 = i21;
                    }
                    i10 = i15;
                    i11 = i16;
                    i12 = 1 << (i20 >>> 20);
                } else {
                    i10 = i15;
                    i11 = i16;
                    i12 = 0;
                }
                int i22 = zzx2 & i14;
                if (zzz13 >= zzlw.zzJ.zza()) {
                    zzlw.zzW.zza();
                }
                long j10 = i22;
                switch (zzz13) {
                    case 0:
                        if (zzI(obj, i17, i10, i11, i12)) {
                            zzz = zzll.zzz(i19 << 3);
                            zzz7 = zzz + 8;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zzI(obj, i17, i10, i11, i12)) {
                            zzz2 = zzll.zzz(i19 << 3);
                            zzz7 = zzz2 + 4;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zzI(obj, i17, i10, i11, i12)) {
                            long j11 = unsafe.getLong(obj, j10);
                            zzz3 = zzll.zzz(i19 << 3);
                            zzA = zzll.zzA(j11);
                            zzz7 = zzz3 + zzA;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zzI(obj, i17, i10, i11, i12)) {
                            long j12 = unsafe.getLong(obj, j10);
                            zzz3 = zzll.zzz(i19 << 3);
                            zzA = zzll.zzA(j12);
                            zzz7 = zzz3 + zzA;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zzI(obj, i17, i10, i11, i12)) {
                            long j13 = unsafe.getInt(obj, j10);
                            zzz3 = zzll.zzz(i19 << 3);
                            zzA = zzll.zzA(j13);
                            zzz7 = zzz3 + zzA;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zzI(obj, i17, i10, i11, i12)) {
                            zzz = zzll.zzz(i19 << 3);
                            zzz7 = zzz + 8;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zzI(obj, i17, i10, i11, i12)) {
                            zzz2 = zzll.zzz(i19 << 3);
                            zzz7 = zzz2 + 4;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zzI(obj, i17, i10, i11, i12)) {
                            zzz4 = zzll.zzz(i19 << 3);
                            zzz7 = zzz4 + 1;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (!zzI(obj, i17, i10, i11, i12)) {
                            break;
                        } else {
                            int i23 = i19 << 3;
                            Object object = unsafe.getObject(obj, j10);
                            if (object instanceof zzlg) {
                                zzz5 = zzll.zzz(i23);
                                zzc = ((zzlg) object).zzc();
                                zzz6 = zzll.zzz(zzc);
                                zzz7 = zzz5 + zzz6 + zzc;
                                i18 += zzz7;
                                break;
                            } else {
                                zzz3 = zzll.zzz(i23);
                                zzA = zzll.zzB((String) object);
                                zzz7 = zzz3 + zzA;
                                i18 += zzz7;
                            }
                        }
                    case 9:
                        if (zzI(obj, i17, i10, i11, i12)) {
                            zzz7 = zzny.zzz(i19, unsafe.getObject(obj, j10), zzp(i17));
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zzI(obj, i17, i10, i11, i12)) {
                            zzlg zzlgVar = (zzlg) unsafe.getObject(obj, j10);
                            zzz5 = zzll.zzz(i19 << 3);
                            zzc = zzlgVar.zzc();
                            zzz6 = zzll.zzz(zzc);
                            zzz7 = zzz5 + zzz6 + zzc;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zzI(obj, i17, i10, i11, i12)) {
                            int i24 = unsafe.getInt(obj, j10);
                            zzz3 = zzll.zzz(i19 << 3);
                            zzA = zzll.zzz(i24);
                            zzz7 = zzz3 + zzA;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zzI(obj, i17, i10, i11, i12)) {
                            long j14 = unsafe.getInt(obj, j10);
                            zzz3 = zzll.zzz(i19 << 3);
                            zzA = zzll.zzA(j14);
                            zzz7 = zzz3 + zzA;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zzI(obj, i17, i10, i11, i12)) {
                            zzz2 = zzll.zzz(i19 << 3);
                            zzz7 = zzz2 + 4;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zzI(obj, i17, i10, i11, i12)) {
                            zzz = zzll.zzz(i19 << 3);
                            zzz7 = zzz + 8;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zzI(obj, i17, i10, i11, i12)) {
                            int i25 = unsafe.getInt(obj, j10);
                            zzz3 = zzll.zzz(i19 << 3);
                            zzA = zzll.zzz((i25 >> 31) ^ (i25 + i25));
                            zzz7 = zzz3 + zzA;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zzI(obj, i17, i10, i11, i12)) {
                            long j15 = unsafe.getLong(obj, j10);
                            zzz3 = zzll.zzz(i19 << 3);
                            zzA = zzll.zzA((j15 >> 63) ^ (j15 + j15));
                            zzz7 = zzz3 + zzA;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zzI(obj, i17, i10, i11, i12)) {
                            zzz7 = zzll.zzG(i19, (zznl) unsafe.getObject(obj, j10), zzp(i17));
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzz7 = zzny.zzy(i19, (List) unsafe.getObject(obj, j10), z10);
                        i18 += zzz7;
                        break;
                    case 19:
                        zzz7 = zzny.zzw(i19, (List) unsafe.getObject(obj, j10), z10);
                        i18 += zzz7;
                        break;
                    case 20:
                        List list = (List) unsafe.getObject(obj, j10);
                        int i26 = zzny.zza;
                        if (list.size() != 0) {
                            zzo = zzny.zzo(list) + (list.size() * zzll.zzz(i19 << 3));
                            i18 += zzo;
                            break;
                        }
                        zzo = 0;
                        i18 += zzo;
                    case 21:
                        List list2 = (List) unsafe.getObject(obj, j10);
                        int i27 = zzny.zza;
                        size = list2.size();
                        if (size != 0) {
                            zzz3 = zzny.zzp(list2);
                            zzz8 = zzll.zzz(i19 << 3);
                            zzA = size * zzz8;
                            zzz7 = zzz3 + zzA;
                            i18 += zzz7;
                            break;
                        }
                        zzz7 = 0;
                        i18 += zzz7;
                    case 22:
                        List list3 = (List) unsafe.getObject(obj, j10);
                        int i28 = zzny.zza;
                        size = list3.size();
                        if (size != 0) {
                            zzz3 = zzny.zzs(list3);
                            zzz8 = zzll.zzz(i19 << 3);
                            zzA = size * zzz8;
                            zzz7 = zzz3 + zzA;
                            i18 += zzz7;
                            break;
                        }
                        zzz7 = 0;
                        i18 += zzz7;
                    case 23:
                        zzz7 = zzny.zzy(i19, (List) unsafe.getObject(obj, j10), z10);
                        i18 += zzz7;
                        break;
                    case 24:
                        zzz7 = zzny.zzw(i19, (List) unsafe.getObject(obj, j10), z10);
                        i18 += zzz7;
                        break;
                    case 25:
                        List list4 = (List) unsafe.getObject(obj, j10);
                        int i29 = zzny.zza;
                        int size2 = list4.size();
                        if (size2 != 0) {
                            zzz7 = size2 * (zzll.zzz(i19 << 3) + 1);
                            i18 += zzz7;
                            break;
                        }
                        zzz7 = 0;
                        i18 += zzz7;
                    case 26:
                        List list5 = (List) unsafe.getObject(obj, j10);
                        int i30 = zzny.zza;
                        int size3 = list5.size();
                        if (size3 != 0) {
                            zzo = zzll.zzz(i19 << 3) * size3;
                            if (list5 instanceof zzmw) {
                                zzmw zzmwVar = (zzmw) list5;
                                for (int i31 = 0; i31 < size3; i31++) {
                                    Object zzc2 = zzmwVar.zzc();
                                    if (zzc2 instanceof zzlg) {
                                        int zzc3 = ((zzlg) zzc2).zzc();
                                        zzo += zzll.zzz(zzc3) + zzc3;
                                    } else {
                                        zzo += zzll.zzB((String) zzc2);
                                    }
                                }
                            } else {
                                for (int i32 = 0; i32 < size3; i32++) {
                                    Object obj2 = list5.get(i32);
                                    if (obj2 instanceof zzlg) {
                                        int zzc4 = ((zzlg) obj2).zzc();
                                        zzo += zzll.zzz(zzc4) + zzc4;
                                    } else {
                                        zzo += zzll.zzB((String) obj2);
                                    }
                                }
                            }
                            i18 += zzo;
                            break;
                        }
                        zzo = 0;
                        i18 += zzo;
                    case 27:
                        List list6 = (List) unsafe.getObject(obj, j10);
                        zznw zzp = zzp(i17);
                        int i33 = zzny.zza;
                        int size4 = list6.size();
                        if (size4 == 0) {
                            zzz9 = 0;
                        } else {
                            zzz9 = zzll.zzz(i19 << 3) * size4;
                            for (int i34 = 0; i34 < size4; i34++) {
                                Object obj3 = list6.get(i34);
                                if (obj3 instanceof zzmv) {
                                    int zzb2 = ((zzmv) obj3).zzb();
                                    zzz9 += zzll.zzz(zzb2) + zzb2;
                                } else {
                                    zzz9 += zzll.zzD((zznl) obj3, zzp);
                                }
                            }
                        }
                        i18 += zzz9;
                        break;
                    case 28:
                        List list7 = (List) unsafe.getObject(obj, j10);
                        int i35 = zzny.zza;
                        int size5 = list7.size();
                        if (size5 == 0) {
                            zzz10 = 0;
                        } else {
                            zzz10 = size5 * zzll.zzz(i19 << 3);
                            for (int i36 = 0; i36 < list7.size(); i36++) {
                                int zzc5 = ((zzlg) list7.get(i36)).zzc();
                                zzz10 += zzll.zzz(zzc5) + zzc5;
                            }
                        }
                        i18 += zzz10;
                        break;
                    case 29:
                        List list8 = (List) unsafe.getObject(obj, j10);
                        int i37 = zzny.zza;
                        size = list8.size();
                        if (size != 0) {
                            zzz3 = zzny.zzt(list8);
                            zzz8 = zzll.zzz(i19 << 3);
                            zzA = size * zzz8;
                            zzz7 = zzz3 + zzA;
                            i18 += zzz7;
                            break;
                        }
                        zzz7 = 0;
                        i18 += zzz7;
                    case 30:
                        List list9 = (List) unsafe.getObject(obj, j10);
                        int i38 = zzny.zza;
                        size = list9.size();
                        if (size != 0) {
                            zzz3 = zzny.zzr(list9);
                            zzz8 = zzll.zzz(i19 << 3);
                            zzA = size * zzz8;
                            zzz7 = zzz3 + zzA;
                            i18 += zzz7;
                            break;
                        }
                        zzz7 = 0;
                        i18 += zzz7;
                    case 31:
                        zzz7 = zzny.zzw(i19, (List) unsafe.getObject(obj, j10), z10);
                        i18 += zzz7;
                        break;
                    case 32:
                        zzz7 = zzny.zzy(i19, (List) unsafe.getObject(obj, j10), z10);
                        i18 += zzz7;
                        break;
                    case 33:
                        List list10 = (List) unsafe.getObject(obj, j10);
                        int i39 = zzny.zza;
                        size = list10.size();
                        if (size != 0) {
                            zzz3 = zzny.zzu(list10);
                            zzz8 = zzll.zzz(i19 << 3);
                            zzA = size * zzz8;
                            zzz7 = zzz3 + zzA;
                            i18 += zzz7;
                            break;
                        }
                        zzz7 = 0;
                        i18 += zzz7;
                    case 34:
                        List list11 = (List) unsafe.getObject(obj, j10);
                        int i40 = zzny.zza;
                        size = list11.size();
                        if (size != 0) {
                            zzz3 = zzny.zzq(list11);
                            zzz8 = zzll.zzz(i19 << 3);
                            zzA = size * zzz8;
                            zzz7 = zzz3 + zzA;
                            i18 += zzz7;
                            break;
                        }
                        zzz7 = 0;
                        i18 += zzz7;
                    case 35:
                        zzx = zzny.zzx((List) unsafe.getObject(obj, j10));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i19 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i18 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        zzx = zzny.zzv((List) unsafe.getObject(obj, j10));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i19 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i18 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        zzx = zzny.zzo((List) unsafe.getObject(obj, j10));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i19 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i18 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        zzx = zzny.zzp((List) unsafe.getObject(obj, j10));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i19 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i18 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        zzx = zzny.zzs((List) unsafe.getObject(obj, j10));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i19 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i18 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        zzx = zzny.zzx((List) unsafe.getObject(obj, j10));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i19 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i18 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        zzx = zzny.zzv((List) unsafe.getObject(obj, j10));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i19 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i18 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        List list12 = (List) unsafe.getObject(obj, j10);
                        int i41 = zzny.zza;
                        zzx = list12.size();
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i19 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i18 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        zzx = zzny.zzt((List) unsafe.getObject(obj, j10));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i19 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i18 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        zzx = zzny.zzr((List) unsafe.getObject(obj, j10));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i19 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i18 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        zzx = zzny.zzv((List) unsafe.getObject(obj, j10));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i19 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i18 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        zzx = zzny.zzx((List) unsafe.getObject(obj, j10));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i19 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i18 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        zzx = zzny.zzu((List) unsafe.getObject(obj, j10));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i19 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i18 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        zzx = zzny.zzq((List) unsafe.getObject(obj, j10));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i19 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i18 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        List list13 = (List) unsafe.getObject(obj, j10);
                        zznw zzp2 = zzp(i17);
                        int i42 = zzny.zza;
                        int size6 = list13.size();
                        if (size6 == 0) {
                            i13 = 0;
                        } else {
                            i13 = 0;
                            for (int i43 = 0; i43 < size6; i43++) {
                                i13 += zzll.zzG(i19, (zznl) list13.get(i43), zzp2);
                            }
                        }
                        i18 += i13;
                        break;
                    case 50:
                        zznf zznfVar = (zznf) unsafe.getObject(obj, j10);
                        zzne zzneVar = (zzne) zzq(i17);
                        if (!zznfVar.isEmpty()) {
                            zzo = 0;
                            for (Map.Entry entry : zznfVar.entrySet()) {
                                zzo += zzneVar.zzd(i19, entry.getKey(), entry.getValue());
                            }
                            i18 += zzo;
                            break;
                        }
                        zzo = 0;
                        i18 += zzo;
                    case 51:
                        if (zzL(obj, i19, i17)) {
                            zzz = zzll.zzz(i19 << 3);
                            zzz7 = zzz + 8;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zzL(obj, i19, i17)) {
                            zzz2 = zzll.zzz(i19 << 3);
                            zzz7 = zzz2 + 4;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zzL(obj, i19, i17)) {
                            long zzF = zzF(obj, j10);
                            zzz3 = zzll.zzz(i19 << 3);
                            zzA = zzll.zzA(zzF);
                            zzz7 = zzz3 + zzA;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zzL(obj, i19, i17)) {
                            long zzF2 = zzF(obj, j10);
                            zzz3 = zzll.zzz(i19 << 3);
                            zzA = zzll.zzA(zzF2);
                            zzz7 = zzz3 + zzA;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zzL(obj, i19, i17)) {
                            long zzE = zzE(obj, j10);
                            zzz3 = zzll.zzz(i19 << 3);
                            zzA = zzll.zzA(zzE);
                            zzz7 = zzz3 + zzA;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zzL(obj, i19, i17)) {
                            zzz = zzll.zzz(i19 << 3);
                            zzz7 = zzz + 8;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zzL(obj, i19, i17)) {
                            zzz2 = zzll.zzz(i19 << 3);
                            zzz7 = zzz2 + 4;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zzL(obj, i19, i17)) {
                            zzz4 = zzll.zzz(i19 << 3);
                            zzz7 = zzz4 + 1;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (!zzL(obj, i19, i17)) {
                            break;
                        } else {
                            int i44 = i19 << 3;
                            Object object2 = unsafe.getObject(obj, j10);
                            if (object2 instanceof zzlg) {
                                zzz5 = zzll.zzz(i44);
                                zzc = ((zzlg) object2).zzc();
                                zzz6 = zzll.zzz(zzc);
                                zzz7 = zzz5 + zzz6 + zzc;
                                i18 += zzz7;
                                break;
                            } else {
                                zzz3 = zzll.zzz(i44);
                                zzA = zzll.zzB((String) object2);
                                zzz7 = zzz3 + zzA;
                                i18 += zzz7;
                            }
                        }
                    case 60:
                        if (zzL(obj, i19, i17)) {
                            zzz7 = zzny.zzz(i19, unsafe.getObject(obj, j10), zzp(i17));
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zzL(obj, i19, i17)) {
                            zzlg zzlgVar2 = (zzlg) unsafe.getObject(obj, j10);
                            zzz5 = zzll.zzz(i19 << 3);
                            zzc = zzlgVar2.zzc();
                            zzz6 = zzll.zzz(zzc);
                            zzz7 = zzz5 + zzz6 + zzc;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zzL(obj, i19, i17)) {
                            int zzE2 = zzE(obj, j10);
                            zzz3 = zzll.zzz(i19 << 3);
                            zzA = zzll.zzz(zzE2);
                            zzz7 = zzz3 + zzA;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zzL(obj, i19, i17)) {
                            long zzE3 = zzE(obj, j10);
                            zzz3 = zzll.zzz(i19 << 3);
                            zzA = zzll.zzA(zzE3);
                            zzz7 = zzz3 + zzA;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zzL(obj, i19, i17)) {
                            zzz2 = zzll.zzz(i19 << 3);
                            zzz7 = zzz2 + 4;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zzL(obj, i19, i17)) {
                            zzz = zzll.zzz(i19 << 3);
                            zzz7 = zzz + 8;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zzL(obj, i19, i17)) {
                            int zzE4 = zzE(obj, j10);
                            zzz3 = zzll.zzz(i19 << 3);
                            zzA = zzll.zzz((zzE4 >> 31) ^ (zzE4 + zzE4));
                            zzz7 = zzz3 + zzA;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zzL(obj, i19, i17)) {
                            long zzF3 = zzF(obj, j10);
                            zzz3 = zzll.zzz(i19 << 3);
                            zzA = zzll.zzA((zzF3 >> 63) ^ (zzF3 + zzF3));
                            zzz7 = zzz3 + zzA;
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zzL(obj, i19, i17)) {
                            zzz7 = zzll.zzG(i19, (zznl) unsafe.getObject(obj, j10), zzp(i17));
                            i18 += zzz7;
                            break;
                        } else {
                            break;
                        }
                }
                i17 += 3;
                i15 = i10;
                i16 = i11;
                z10 = false;
                i14 = 1048575;
            } else {
                int zzi = i18 + ((zzme) obj).zzc.zzi();
                if (!this.zzh) {
                    return zzi;
                }
                zzod zzodVar = ((zzmb) obj).zzb.zza;
                int zzc6 = zzodVar.zzc();
                int i45 = 0;
                for (int i46 = 0; i46 < zzc6; i46++) {
                    Map.Entry zzd = zzodVar.zzd(i46);
                    i45 += zzlv.zzj((zzlu) ((zzoa) zzd).zza(), zzd.getValue());
                }
                for (Map.Entry entry2 : zzodVar.zze()) {
                    i45 += zzlv.zzj((zzlu) entry2.getKey(), entry2.getValue());
                }
                return zzi + i45;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x0067. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:234:0x05e8  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0034  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r9v20 */
    @Override // com.google.android.gms.internal.measurement.zznw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzf(Object obj, zzou zzouVar) throws IOException {
        Map.Entry entry;
        int[] iArr;
        int i10;
        Map.Entry entry2;
        int i11;
        int i12;
        int i13;
        int i14;
        Map.Entry entry3;
        int[] iArr2;
        ?? r92 = 1;
        if (this.zzh) {
            zzlv zzlvVar = ((zzmb) obj).zzb;
            if (!zzlvVar.zza.isEmpty()) {
                entry = (Map.Entry) zzlvVar.zzc().next();
                iArr = this.zzc;
                Unsafe unsafe = zzb;
                int i15 = 1048575;
                int i16 = 1048575;
                int i17 = 0;
                i10 = 0;
                while (i10 < iArr.length) {
                    int zzx = zzx(i10);
                    int zzz = zzz(zzx);
                    int i18 = iArr[i10];
                    if (zzz <= 17) {
                        int i19 = iArr[i10 + 2];
                        int i20 = i19 & i15;
                        if (i20 != i16) {
                            if (i20 == i15) {
                                i17 = 0;
                            } else {
                                i17 = unsafe.getInt(obj, i20);
                            }
                            i16 = i20;
                        }
                        i12 = i17;
                        i13 = r92 << (i19 >>> 20);
                        i11 = i16;
                    } else {
                        i11 = i16;
                        i12 = i17;
                        i13 = 0;
                    }
                    if (entry == null) {
                        long j10 = zzx & i15;
                        switch (zzz) {
                            case 0:
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                if (zzI(obj, i14, i11, i12, i13)) {
                                    zzouVar.zzf(i18, zzoo.zzl(obj, j10));
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                if (zzI(obj, i14, i11, i12, i13)) {
                                    zzouVar.zze(i18, zzoo.zzj(obj, j10));
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                if (zzI(obj, i14, i11, i12, i13)) {
                                    zzouVar.zzc(i18, unsafe.getLong(obj, j10));
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                if (zzI(obj, i14, i11, i12, i13)) {
                                    zzouVar.zzh(i18, unsafe.getLong(obj, j10));
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                if (zzI(obj, i14, i11, i12, i13)) {
                                    zzouVar.zzi(i18, unsafe.getInt(obj, j10));
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                if (zzI(obj, i14, i11, i12, i13)) {
                                    zzouVar.zzj(i18, unsafe.getLong(obj, j10));
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                if (zzI(obj, i14, i11, i12, i13)) {
                                    zzouVar.zzk(i18, unsafe.getInt(obj, j10));
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                if (zzI(obj, i14, i11, i12, i13)) {
                                    zzouVar.zzl(i18, zzoo.zzh(obj, j10));
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                if (zzI(obj, i14, i11, i12, i13)) {
                                    zzP(i18, unsafe.getObject(obj, j10), zzouVar);
                                    break;
                                } else {
                                    break;
                                }
                            case 9:
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                if (zzI(obj, i14, i11, i12, i13)) {
                                    zzouVar.zzr(i18, unsafe.getObject(obj, j10), zzp(i14));
                                    break;
                                } else {
                                    break;
                                }
                            case 10:
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                if (zzI(obj, i14, i11, i12, i13)) {
                                    zzouVar.zzn(i18, (zzlg) unsafe.getObject(obj, j10));
                                    break;
                                } else {
                                    break;
                                }
                            case 11:
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                if (zzI(obj, i14, i11, i12, i13)) {
                                    zzouVar.zzo(i18, unsafe.getInt(obj, j10));
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                if (zzI(obj, i14, i11, i12, i13)) {
                                    zzouVar.zzg(i18, unsafe.getInt(obj, j10));
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                if (zzI(obj, i14, i11, i12, i13)) {
                                    zzouVar.zzb(i18, unsafe.getInt(obj, j10));
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                if (zzI(obj, i14, i11, i12, i13)) {
                                    zzouVar.zzd(i18, unsafe.getLong(obj, j10));
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                if (zzI(obj, i14, i11, i12, i13)) {
                                    zzouVar.zzp(i18, unsafe.getInt(obj, j10));
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                if (zzI(obj, i14, i11, i12, i13)) {
                                    zzouVar.zzq(i18, unsafe.getLong(obj, j10));
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                i14 = i10;
                                if (zzI(obj, i10, i11, i12, i13)) {
                                    zzouVar.zzs(i18, unsafe.getObject(obj, j10), zzp(i14));
                                }
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 18:
                                zzny.zza(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, false);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 19:
                                zzny.zzb(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, false);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 20:
                                zzny.zzc(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, false);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 21:
                                zzny.zzd(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, false);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 22:
                                zzny.zzh(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, false);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 23:
                                zzny.zzf(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, false);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 24:
                                zzny.zzk(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, false);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 25:
                                zzny.zzn(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, false);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 26:
                                int i21 = iArr[i10];
                                List list = (List) unsafe.getObject(obj, j10);
                                int i22 = zzny.zza;
                                if (list != null && !list.isEmpty()) {
                                    zzouVar.zzF(i21, list);
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 27:
                                int i23 = iArr[i10];
                                List list2 = (List) unsafe.getObject(obj, j10);
                                zznw zzp = zzp(i10);
                                int i24 = zzny.zza;
                                if (list2 != null && !list2.isEmpty()) {
                                    for (int i25 = 0; i25 < list2.size(); i25 += r92) {
                                        ((zzlm) zzouVar).zzr(i23, list2.get(i25), zzp);
                                    }
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 28:
                                int i26 = iArr[i10];
                                List list3 = (List) unsafe.getObject(obj, j10);
                                int i27 = zzny.zza;
                                if (list3 != null && !list3.isEmpty()) {
                                    zzouVar.zzG(i26, list3);
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 29:
                                zzny.zzi(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, false);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 30:
                                zzny.zzm(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, false);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 31:
                                zzny.zzl(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, false);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 32:
                                zzny.zzg(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, false);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 33:
                                zzny.zzj(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, false);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 34:
                                zzny.zze(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, false);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 35:
                                zzny.zza(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, r92);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 36:
                                zzny.zzb(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, r92);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 37:
                                zzny.zzc(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, r92);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 38:
                                zzny.zzd(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, r92);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 39:
                                zzny.zzh(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, r92);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 40:
                                zzny.zzf(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, r92);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 41:
                                zzny.zzk(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, r92);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 42:
                                zzny.zzn(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, r92);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 43:
                                zzny.zzi(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, r92);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 44:
                                zzny.zzm(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, r92);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 45:
                                zzny.zzl(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, r92);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 46:
                                zzny.zzg(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, r92);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 47:
                                zzny.zzj(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, r92);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 48:
                                zzny.zze(iArr[i10], (List) unsafe.getObject(obj, j10), zzouVar, r92);
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 49:
                                int i28 = iArr[i10];
                                List list4 = (List) unsafe.getObject(obj, j10);
                                zznw zzp2 = zzp(i10);
                                int i29 = zzny.zza;
                                if (list4 != null && !list4.isEmpty()) {
                                    for (int i30 = 0; i30 < list4.size(); i30 += r92) {
                                        ((zzlm) zzouVar).zzs(i28, list4.get(i30), zzp2);
                                    }
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 50:
                                Object object = unsafe.getObject(obj, j10);
                                if (object != null) {
                                    zzouVar.zzM(i18, ((zzne) zzq(i10)).zze(), (zznf) object);
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 51:
                                if (zzL(obj, i18, i10)) {
                                    zzouVar.zzf(i18, zzC(obj, j10));
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 52:
                                if (zzL(obj, i18, i10)) {
                                    zzouVar.zze(i18, zzD(obj, j10));
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 53:
                                if (zzL(obj, i18, i10)) {
                                    zzouVar.zzc(i18, zzF(obj, j10));
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 54:
                                if (zzL(obj, i18, i10)) {
                                    zzouVar.zzh(i18, zzF(obj, j10));
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 55:
                                if (zzL(obj, i18, i10)) {
                                    zzouVar.zzi(i18, zzE(obj, j10));
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 56:
                                if (zzL(obj, i18, i10)) {
                                    zzouVar.zzj(i18, zzF(obj, j10));
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 57:
                                if (zzL(obj, i18, i10)) {
                                    zzouVar.zzk(i18, zzE(obj, j10));
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 58:
                                if (zzL(obj, i18, i10)) {
                                    zzouVar.zzl(i18, zzG(obj, j10));
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 59:
                                if (zzL(obj, i18, i10)) {
                                    zzP(i18, unsafe.getObject(obj, j10), zzouVar);
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 60:
                                if (zzL(obj, i18, i10)) {
                                    zzouVar.zzr(i18, unsafe.getObject(obj, j10), zzp(i10));
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 61:
                                if (zzL(obj, i18, i10)) {
                                    zzouVar.zzn(i18, (zzlg) unsafe.getObject(obj, j10));
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 62:
                                if (zzL(obj, i18, i10)) {
                                    zzouVar.zzo(i18, zzE(obj, j10));
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 63:
                                if (zzL(obj, i18, i10)) {
                                    zzouVar.zzg(i18, zzE(obj, j10));
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 64:
                                if (zzL(obj, i18, i10)) {
                                    zzouVar.zzb(i18, zzE(obj, j10));
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 65:
                                if (zzL(obj, i18, i10)) {
                                    zzouVar.zzd(i18, zzF(obj, j10));
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 66:
                                if (zzL(obj, i18, i10)) {
                                    zzouVar.zzp(i18, zzE(obj, j10));
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 67:
                                if (zzL(obj, i18, i10)) {
                                    zzouVar.zzq(i18, zzF(obj, j10));
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            case 68:
                                if (zzL(obj, i18, i10)) {
                                    zzouVar.zzs(i18, unsafe.getObject(obj, j10), zzp(i10));
                                }
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                            default:
                                i14 = i10;
                                entry3 = entry;
                                iArr2 = iArr;
                                break;
                        }
                        i10 = i14 + 3;
                        i16 = i11;
                        i17 = i12;
                        entry = entry3;
                        iArr = iArr2;
                        r92 = 1;
                        i15 = 1048575;
                    } else {
                        throw null;
                    }
                }
                entry2 = entry;
                if (entry2 != null) {
                    ((zzme) obj).zzc.zzg(zzouVar);
                    return;
                } else {
                    throw null;
                }
            }
        }
        entry = null;
        iArr = this.zzc;
        Unsafe unsafe2 = zzb;
        int i152 = 1048575;
        int i162 = 1048575;
        int i172 = 0;
        i10 = 0;
        while (i10 < iArr.length) {
        }
        entry2 = entry;
        if (entry2 != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0d80, code lost:
    
        if (r3 == r5) goto L٥٦٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0d82, code lost:
    
        r13.putInt(r8, r3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0d86, code lost:
    
        r3 = r1.zzj;
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0d8c, code lost:
    
        if (r3 >= r1.zzk) goto L٦٧٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0d8e, code lost:
    
        r5 = r1.zzi;
        r6 = r1.zzl;
        r7 = r1.zzc;
        r5 = r5[r3];
        r7 = r7[r5];
        r9 = com.google.android.gms.internal.measurement.zzoo.zzn(r8, r1.zzx(r5) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0da5, code lost:
    
        if (r9 == null) goto L٦٧٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0da7, code lost:
    
        r12 = r1.zzr(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0dab, code lost:
    
        if (r12 == null) goto L٦٧٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0dad, code lost:
    
        r5 = ((com.google.android.gms.internal.measurement.zzne) r1.zzq(r5)).zze();
        r9 = ((com.google.android.gms.internal.measurement.zznf) r9).entrySet().iterator();
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0dc5, code lost:
    
        if (r9.hasNext() == false) goto L٦٧٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0dc7, code lost:
    
        r13 = (java.util.Map.Entry) r9.next();
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0ddb, code lost:
    
        if (r12.zza(((java.lang.Integer) r13.getValue()).intValue()) != false) goto L٦٧٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0ddd, code lost:
    
        if (r4 != null) goto L٥٧٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0ddf, code lost:
    
        r4 = r6.zza(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0de3, code lost:
    
        r14 = com.google.android.gms.internal.measurement.zzne.zzc(r5, r13.getKey(), r13.getValue());
        r15 = com.google.android.gms.internal.measurement.zzlg.zzb;
        r15 = new byte[r14];
        r16 = com.google.android.gms.internal.measurement.zzll.zzb;
        r10 = new com.google.android.gms.internal.measurement.zzlj(r15, 0, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0dfb, code lost:
    
        com.google.android.gms.internal.measurement.zzne.zzb(r10, r5, r13.getKey(), r13.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0e06, code lost:
    
        r4.zzk((r7 << 3) | 2, com.google.android.gms.internal.measurement.zzld.zza(r10, r15));
        r9.remove();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0e1d, code lost:
    
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:642:0x0aac, code lost:
    
        throw new com.google.android.gms.internal.measurement.zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0e20, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0e26, code lost:
    
        throw new java.lang.RuntimeException(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0e27, code lost:
    
        r3 = r3 + 1;
        r1 = r33;
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0e33, code lost:
    
        if (r4 == null) goto L٥٨٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0e35, code lost:
    
        ((com.google.android.gms.internal.measurement.zzme) r8).zzc = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0e3a, code lost:
    
        if (r0 != 0) goto L٥٩٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0e3e, code lost:
    
        if (r2 != r37) goto L٥٩١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0e48, code lost:
    
        throw new com.google.android.gms.internal.measurement.zzmq(r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0e51, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0e49, code lost:
    
        r3 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0e4d, code lost:
    
        if (r2 > r37) goto L٥٩٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0e4f, code lost:
    
        if (r11 != r0) goto L٥٩٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0e57, code lost:
    
        throw new com.google.android.gms.internal.measurement.zzmq(r3);
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:219:0x0369. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x00c3. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:648:0x0ac8. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0959 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x096a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:652:0x0cf3  */
    /* JADX WARN: Removed duplicated region for block: B:653:0x0d0a  */
    /* JADX WARN: Removed duplicated region for block: B:722:0x005c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0d28  */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v38, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzh(Object obj, byte[] bArr, int i10, int i11, int i12, zzkv zzkvVar) throws IOException {
        String str;
        Unsafe unsafe;
        Object obj2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int zzN;
        int i19;
        Unsafe unsafe2;
        zzkv zzkvVar2;
        byte[] bArr2;
        int i20;
        Unsafe unsafe3;
        int i21;
        int i22;
        int i23;
        int i24;
        int zzc;
        Unsafe unsafe4;
        Unsafe unsafe5;
        String str2;
        Unsafe unsafe6;
        Object obj3;
        int i25;
        zznf zznfVar;
        Object obj4;
        long j10;
        int i26;
        int i27;
        Unsafe unsafe7;
        int i28;
        int i29;
        int i30;
        int i31;
        Object obj5;
        int zzl;
        int i32;
        int i33;
        int i34;
        Unsafe unsafe8;
        int i35;
        int zzc2;
        zzno<T> zznoVar = this;
        Object obj6 = obj;
        byte[] bArr3 = bArr;
        int i36 = i11;
        int i37 = i12;
        zzkv zzkvVar3 = zzkvVar;
        int i38 = 3;
        zzB(obj);
        Unsafe unsafe9 = zzb;
        int i39 = 0;
        int i40 = -1;
        int i41 = i10;
        int i42 = -1;
        int i43 = 0;
        int i44 = 1048575;
        int i45 = 0;
        int i46 = 0;
        while (true) {
            if (i41 < i36) {
                int i47 = i41 + 1;
                int i48 = bArr3[i41];
                if (i48 < 0) {
                    i47 = zzkw.zzb(i48, bArr3, i47, zzkvVar3);
                    i48 = zzkvVar3.zza;
                }
                int i49 = i48 >>> 3;
                if (i49 > i42) {
                    zzN = (i49 < zznoVar.zze || i49 > zznoVar.zzf) ? -1 : zznoVar.zzN(i49, i43 / i38);
                } else if (i49 < zznoVar.zze || i49 > zznoVar.zzf) {
                    i18 = -1;
                    if (i18 != i40) {
                        i19 = i47;
                        unsafe2 = unsafe9;
                        zzkvVar2 = zzkvVar3;
                        str = "Failed to parse the message.";
                        obj2 = obj6;
                        bArr2 = bArr3;
                        i13 = i37;
                        i20 = 0;
                        i16 = i48;
                    } else {
                        int i50 = i48 & 7;
                        int[] iArr = zznoVar.zzc;
                        int i51 = iArr[i18 + 1];
                        int zzz = zzz(i51);
                        int i52 = i48;
                        long j11 = i51 & 1048575;
                        str = "Failed to parse the message.";
                        if (zzz <= 17) {
                            int i53 = iArr[i18 + 2];
                            int i54 = 1 << (i53 >>> 20);
                            int i55 = i53 & 1048575;
                            int i56 = i44;
                            if (i55 != i56) {
                                if (i56 != 1048575) {
                                    unsafe9.putInt(obj6, i56, i45);
                                }
                                i45 = i55 == 1048575 ? 0 : unsafe9.getInt(obj6, i55);
                                i44 = i55;
                            } else {
                                i44 = i56;
                            }
                            switch (zzz) {
                                case 0:
                                    i34 = i52;
                                    unsafe8 = unsafe9;
                                    i35 = i18;
                                    if (i50 != 1) {
                                        i19 = i47;
                                        unsafe2 = unsafe8;
                                        zzkvVar2 = zzkvVar3;
                                        i16 = i34;
                                        bArr2 = bArr3;
                                        i20 = i35;
                                        obj2 = obj6;
                                        i13 = i12;
                                        break;
                                    } else {
                                        i41 = i47 + 8;
                                        i45 |= i54;
                                        zzoo.zzm(obj6, j11, Double.longBitsToDouble(zzkw.zze(bArr3, i47)));
                                        i36 = i11;
                                        i43 = i35;
                                        unsafe9 = unsafe8;
                                        i46 = i34;
                                        i42 = i49;
                                        i40 = -1;
                                        i39 = 0;
                                        i38 = 3;
                                        i37 = i12;
                                        break;
                                    }
                                case 1:
                                    i34 = i52;
                                    unsafe8 = unsafe9;
                                    i35 = i18;
                                    if (i50 != 5) {
                                        i19 = i47;
                                        unsafe2 = unsafe8;
                                        zzkvVar2 = zzkvVar3;
                                        i16 = i34;
                                        bArr2 = bArr3;
                                        i20 = i35;
                                        obj2 = obj6;
                                        i13 = i12;
                                        break;
                                    } else {
                                        i41 = i47 + 4;
                                        i45 |= i54;
                                        zzoo.zzk(obj6, j11, Float.intBitsToFloat(zzkw.zzd(bArr3, i47)));
                                        i36 = i11;
                                        i43 = i35;
                                        unsafe9 = unsafe8;
                                        i46 = i34;
                                        i42 = i49;
                                        i40 = -1;
                                        i39 = 0;
                                        i38 = 3;
                                        i37 = i12;
                                        break;
                                    }
                                case 2:
                                case 3:
                                    i34 = i52;
                                    unsafe8 = unsafe9;
                                    i35 = i18;
                                    if (i50 != 0) {
                                        i19 = i47;
                                        unsafe2 = unsafe8;
                                        zzkvVar2 = zzkvVar3;
                                        i16 = i34;
                                        bArr2 = bArr3;
                                        i20 = i35;
                                        obj2 = obj6;
                                        i13 = i12;
                                        break;
                                    } else {
                                        i45 |= i54;
                                        zzc2 = zzkw.zzc(bArr3, i47, zzkvVar3);
                                        unsafe8.putLong(obj, j11, zzkvVar3.zzb);
                                        i43 = i35;
                                        i41 = zzc2;
                                        unsafe9 = unsafe8;
                                        i46 = i34;
                                        i42 = i49;
                                        i40 = -1;
                                        i39 = 0;
                                        i38 = 3;
                                        i36 = i11;
                                        i37 = i12;
                                        break;
                                    }
                                case 4:
                                case 11:
                                    i34 = i52;
                                    unsafe8 = unsafe9;
                                    i35 = i18;
                                    if (i50 != 0) {
                                        i19 = i47;
                                        unsafe2 = unsafe8;
                                        zzkvVar2 = zzkvVar3;
                                        i16 = i34;
                                        bArr2 = bArr3;
                                        i20 = i35;
                                        obj2 = obj6;
                                        i13 = i12;
                                        break;
                                    } else {
                                        i45 |= i54;
                                        i41 = zzkw.zza(bArr3, i47, zzkvVar3);
                                        unsafe8.putInt(obj6, j11, zzkvVar3.zza);
                                        i36 = i11;
                                        i43 = i35;
                                        unsafe9 = unsafe8;
                                        i46 = i34;
                                        i42 = i49;
                                        i40 = -1;
                                        i39 = 0;
                                        i38 = 3;
                                        i37 = i12;
                                        break;
                                    }
                                case 5:
                                case 14:
                                    i34 = i52;
                                    unsafe8 = unsafe9;
                                    i35 = i18;
                                    if (i50 != 1) {
                                        i19 = i47;
                                        unsafe2 = unsafe8;
                                        zzkvVar2 = zzkvVar3;
                                        i16 = i34;
                                        bArr2 = bArr3;
                                        i20 = i35;
                                        obj2 = obj6;
                                        i13 = i12;
                                        break;
                                    } else {
                                        zzc2 = i47 + 8;
                                        i45 |= i54;
                                        unsafe8.putLong(obj, j11, zzkw.zze(bArr3, i47));
                                        i43 = i35;
                                        i41 = zzc2;
                                        unsafe9 = unsafe8;
                                        i46 = i34;
                                        i42 = i49;
                                        i40 = -1;
                                        i39 = 0;
                                        i38 = 3;
                                        i36 = i11;
                                        i37 = i12;
                                        break;
                                    }
                                case 6:
                                case 13:
                                    i34 = i52;
                                    unsafe8 = unsafe9;
                                    i35 = i18;
                                    if (i50 != 5) {
                                        i19 = i47;
                                        unsafe2 = unsafe8;
                                        zzkvVar2 = zzkvVar3;
                                        i16 = i34;
                                        bArr2 = bArr3;
                                        i20 = i35;
                                        obj2 = obj6;
                                        i13 = i12;
                                        break;
                                    } else {
                                        i41 = i47 + 4;
                                        i45 |= i54;
                                        unsafe8.putInt(obj6, j11, zzkw.zzd(bArr3, i47));
                                        i36 = i11;
                                        i43 = i35;
                                        unsafe9 = unsafe8;
                                        i46 = i34;
                                        i42 = i49;
                                        i40 = -1;
                                        i39 = 0;
                                        i38 = 3;
                                        i37 = i12;
                                        break;
                                    }
                                case 7:
                                    i34 = i52;
                                    unsafe8 = unsafe9;
                                    i35 = i18;
                                    if (i50 != 0) {
                                        i19 = i47;
                                        unsafe2 = unsafe8;
                                        zzkvVar2 = zzkvVar3;
                                        i16 = i34;
                                        bArr2 = bArr3;
                                        i20 = i35;
                                        obj2 = obj6;
                                        i13 = i12;
                                        break;
                                    } else {
                                        i45 |= i54;
                                        i41 = zzkw.zzc(bArr3, i47, zzkvVar3);
                                        zzoo.zzi(obj6, j11, zzkvVar3.zzb != 0);
                                        i36 = i11;
                                        i43 = i35;
                                        unsafe9 = unsafe8;
                                        i46 = i34;
                                        i42 = i49;
                                        i40 = -1;
                                        i39 = 0;
                                        i38 = 3;
                                        i37 = i12;
                                        break;
                                    }
                                case 8:
                                    i34 = i52;
                                    unsafe8 = unsafe9;
                                    i35 = i18;
                                    if (i50 != 2) {
                                        i19 = i47;
                                        unsafe2 = unsafe8;
                                        zzkvVar2 = zzkvVar3;
                                        i16 = i34;
                                        bArr2 = bArr3;
                                        i20 = i35;
                                        obj2 = obj6;
                                        i13 = i12;
                                        break;
                                    } else {
                                        if ((i51 & 536870912) != 0) {
                                            i45 |= i54;
                                            i41 = zzkw.zzf(bArr3, i47, zzkvVar3);
                                        } else {
                                            i41 = zzkw.zza(bArr3, i47, zzkvVar3);
                                            int i57 = zzkvVar3.zza;
                                            if (i57 < 0) {
                                                throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            int i58 = i45 | i54;
                                            if (i57 == 0) {
                                                zzkvVar3.zzc = "";
                                            } else {
                                                zzkvVar3.zzc = new String(bArr3, i41, i57, zzmo.zza);
                                                i41 += i57;
                                            }
                                            i45 = i58;
                                        }
                                        unsafe8.putObject(obj6, j11, zzkvVar3.zzc);
                                        i36 = i11;
                                        i43 = i35;
                                        unsafe9 = unsafe8;
                                        i46 = i34;
                                        i42 = i49;
                                        i40 = -1;
                                        i39 = 0;
                                        i38 = 3;
                                        i37 = i12;
                                        break;
                                    }
                                case 9:
                                    i34 = i52;
                                    unsafe8 = unsafe9;
                                    i35 = i18;
                                    if (i50 != 2) {
                                        i19 = i47;
                                        unsafe2 = unsafe8;
                                        zzkvVar2 = zzkvVar3;
                                        i16 = i34;
                                        bArr2 = bArr3;
                                        i20 = i35;
                                        obj2 = obj6;
                                        i13 = i12;
                                        break;
                                    } else {
                                        i45 |= i54;
                                        Object zzs = zznoVar.zzs(obj6, i35);
                                        i41 = zzkw.zzj(zzs, zznoVar.zzp(i35), bArr, i47, i11, zzkvVar);
                                        zznoVar.zzt(obj6, i35, zzs);
                                        i36 = i11;
                                        i43 = i35;
                                        unsafe9 = unsafe8;
                                        i46 = i34;
                                        i42 = i49;
                                        i40 = -1;
                                        i39 = 0;
                                        i38 = 3;
                                        i37 = i12;
                                        break;
                                    }
                                case 10:
                                    i34 = i52;
                                    unsafe8 = unsafe9;
                                    i35 = i18;
                                    if (i50 != 2) {
                                        i19 = i47;
                                        unsafe2 = unsafe8;
                                        zzkvVar2 = zzkvVar3;
                                        i16 = i34;
                                        bArr2 = bArr3;
                                        i20 = i35;
                                        obj2 = obj6;
                                        i13 = i12;
                                        break;
                                    } else {
                                        i45 |= i54;
                                        int zzg = zzkw.zzg(bArr3, i47, zzkvVar3);
                                        unsafe8.putObject(obj6, j11, zzkvVar3.zzc);
                                        i36 = i11;
                                        i41 = zzg;
                                        i43 = i35;
                                        unsafe9 = unsafe8;
                                        i46 = i34;
                                        i42 = i49;
                                        i40 = -1;
                                        i39 = 0;
                                        i38 = 3;
                                        i37 = i12;
                                        break;
                                    }
                                case 12:
                                    i34 = i52;
                                    unsafe8 = unsafe9;
                                    i35 = i18;
                                    if (i50 != 0) {
                                        i19 = i47;
                                        unsafe2 = unsafe8;
                                        zzkvVar2 = zzkvVar3;
                                        i16 = i34;
                                        bArr2 = bArr3;
                                        i20 = i35;
                                        obj2 = obj6;
                                        i13 = i12;
                                        break;
                                    } else {
                                        i41 = zzkw.zza(bArr3, i47, zzkvVar3);
                                        int i59 = zzkvVar3.zza;
                                        zzmj zzr = zznoVar.zzr(i35);
                                        if ((i51 & Integer.MIN_VALUE) != 0 && zzr != null && !zzr.zza(i59)) {
                                            zzg(obj).zzk(i34, Long.valueOf(i59));
                                        } else {
                                            i45 |= i54;
                                            unsafe8.putInt(obj6, j11, i59);
                                        }
                                        i36 = i11;
                                        i43 = i35;
                                        unsafe9 = unsafe8;
                                        i46 = i34;
                                        i42 = i49;
                                        i40 = -1;
                                        i39 = 0;
                                        i38 = 3;
                                        i37 = i12;
                                        break;
                                    }
                                case 15:
                                    i34 = i52;
                                    unsafe8 = unsafe9;
                                    i35 = i18;
                                    if (i50 != 0) {
                                        i19 = i47;
                                        unsafe2 = unsafe8;
                                        zzkvVar2 = zzkvVar3;
                                        i16 = i34;
                                        bArr2 = bArr3;
                                        i20 = i35;
                                        obj2 = obj6;
                                        i13 = i12;
                                        break;
                                    } else {
                                        i45 |= i54;
                                        i41 = zzkw.zza(bArr3, i47, zzkvVar3);
                                        unsafe8.putInt(obj6, j11, zzli.zzb(zzkvVar3.zza));
                                        i36 = i11;
                                        i43 = i35;
                                        unsafe9 = unsafe8;
                                        i46 = i34;
                                        i42 = i49;
                                        i40 = -1;
                                        i39 = 0;
                                        i38 = 3;
                                        i37 = i12;
                                        break;
                                    }
                                case 16:
                                    i34 = i52;
                                    unsafe8 = unsafe9;
                                    i35 = i18;
                                    if (i50 != 0) {
                                        i19 = i47;
                                        unsafe2 = unsafe8;
                                        zzkvVar2 = zzkvVar3;
                                        i16 = i34;
                                        bArr2 = bArr3;
                                        i20 = i35;
                                        obj2 = obj6;
                                        i13 = i12;
                                        break;
                                    } else {
                                        i45 |= i54;
                                        zzc2 = zzkw.zzc(bArr3, i47, zzkvVar3);
                                        unsafe8.putLong(obj, j11, zzli.zzc(zzkvVar3.zzb));
                                        i43 = i35;
                                        i41 = zzc2;
                                        unsafe9 = unsafe8;
                                        i46 = i34;
                                        i42 = i49;
                                        i40 = -1;
                                        i39 = 0;
                                        i38 = 3;
                                        i36 = i11;
                                        i37 = i12;
                                        break;
                                    }
                                default:
                                    if (i50 != 3) {
                                        i34 = i52;
                                        unsafe8 = unsafe9;
                                        i35 = i18;
                                        i19 = i47;
                                        unsafe2 = unsafe8;
                                        zzkvVar2 = zzkvVar3;
                                        i16 = i34;
                                        bArr2 = bArr3;
                                        i20 = i35;
                                        obj2 = obj6;
                                        i13 = i12;
                                        break;
                                    } else {
                                        i45 |= i54;
                                        Object zzs2 = zznoVar.zzs(obj6, i18);
                                        i34 = i52;
                                        int i60 = i18;
                                        i41 = zzkw.zzk(zzs2, zznoVar.zzp(i18), bArr, i47, i11, (i49 << 3) | 4, zzkvVar);
                                        zznoVar.zzt(obj6, i60, zzs2);
                                        i36 = i11;
                                        unsafe9 = unsafe9;
                                        i43 = i60;
                                        i46 = i34;
                                        i42 = i49;
                                        i40 = -1;
                                        i39 = 0;
                                        i38 = 3;
                                        i37 = i12;
                                        break;
                                    }
                            }
                        } else {
                            Unsafe unsafe10 = unsafe9;
                            int i61 = i45;
                            int i62 = i18;
                            if (zzz != 27) {
                                i21 = i52;
                                if (zzz > 49) {
                                    i22 = i47;
                                    zzkvVar2 = zzkvVar3;
                                    bArr2 = bArr;
                                    i20 = i62;
                                    i23 = i49;
                                    if (zzz != 50) {
                                        long j12 = iArr[i20 + 2] & 1048575;
                                        switch (zzz) {
                                            case 51:
                                                i16 = i21;
                                                i24 = i20;
                                                i49 = i23;
                                                unsafe2 = unsafe10;
                                                obj2 = obj;
                                                if (i50 == 1) {
                                                    i41 = i22 + 8;
                                                    unsafe2.putObject(obj2, j11, Double.valueOf(Double.longBitsToDouble(zzkw.zze(bArr2, i22))));
                                                    unsafe2.putInt(obj2, j12, i49);
                                                    if (i41 == i22) {
                                                        i13 = i12;
                                                        i19 = i41;
                                                        i20 = i24;
                                                        i45 = i61;
                                                        break;
                                                    } else {
                                                        zznoVar = this;
                                                        obj6 = obj2;
                                                        i46 = i16;
                                                        bArr3 = bArr2;
                                                        i42 = i49;
                                                        i43 = i24;
                                                        i39 = 0;
                                                        i38 = 3;
                                                        i45 = i61;
                                                        i37 = i12;
                                                        unsafe9 = unsafe2;
                                                        zzkvVar3 = zzkvVar2;
                                                        i40 = -1;
                                                        i36 = i11;
                                                        break;
                                                    }
                                                }
                                                i41 = i22;
                                                if (i41 == i22) {
                                                }
                                            case 52:
                                                i16 = i21;
                                                i24 = i20;
                                                i49 = i23;
                                                unsafe2 = unsafe10;
                                                obj2 = obj;
                                                if (i50 == 5) {
                                                    i41 = i22 + 4;
                                                    unsafe2.putObject(obj2, j11, Float.valueOf(Float.intBitsToFloat(zzkw.zzd(bArr2, i22))));
                                                    unsafe2.putInt(obj2, j12, i49);
                                                    if (i41 == i22) {
                                                    }
                                                }
                                                i41 = i22;
                                                if (i41 == i22) {
                                                }
                                                break;
                                            case 53:
                                            case 54:
                                                i16 = i21;
                                                i24 = i20;
                                                i49 = i23;
                                                unsafe2 = unsafe10;
                                                obj2 = obj;
                                                if (i50 == 0) {
                                                    zzc = zzkw.zzc(bArr2, i22, zzkvVar2);
                                                    unsafe2.putObject(obj2, j11, Long.valueOf(zzkvVar2.zzb));
                                                    unsafe2.putInt(obj2, j12, i49);
                                                    i41 = zzc;
                                                    if (i41 == i22) {
                                                    }
                                                }
                                                i41 = i22;
                                                if (i41 == i22) {
                                                }
                                                break;
                                            case 55:
                                            case 62:
                                                i16 = i21;
                                                i24 = i20;
                                                i49 = i23;
                                                unsafe2 = unsafe10;
                                                obj2 = obj;
                                                if (i50 == 0) {
                                                    i41 = zzkw.zza(bArr2, i22, zzkvVar2);
                                                    unsafe2.putObject(obj2, j11, Integer.valueOf(zzkvVar2.zza));
                                                    unsafe2.putInt(obj2, j12, i49);
                                                    if (i41 == i22) {
                                                    }
                                                }
                                                i41 = i22;
                                                if (i41 == i22) {
                                                }
                                                break;
                                            case 56:
                                            case 65:
                                                i16 = i21;
                                                i24 = i20;
                                                i49 = i23;
                                                unsafe2 = unsafe10;
                                                obj2 = obj;
                                                if (i50 == 1) {
                                                    i41 = i22 + 8;
                                                    unsafe2.putObject(obj2, j11, Long.valueOf(zzkw.zze(bArr2, i22)));
                                                    unsafe2.putInt(obj2, j12, i49);
                                                    if (i41 == i22) {
                                                    }
                                                }
                                                i41 = i22;
                                                if (i41 == i22) {
                                                }
                                                break;
                                            case 57:
                                            case 64:
                                                i16 = i21;
                                                i24 = i20;
                                                i49 = i23;
                                                unsafe2 = unsafe10;
                                                obj2 = obj;
                                                if (i50 == 5) {
                                                    i41 = i22 + 4;
                                                    unsafe2.putObject(obj2, j11, Integer.valueOf(zzkw.zzd(bArr2, i22)));
                                                    unsafe2.putInt(obj2, j12, i49);
                                                    if (i41 == i22) {
                                                    }
                                                }
                                                i41 = i22;
                                                if (i41 == i22) {
                                                }
                                                break;
                                            case 58:
                                                i16 = i21;
                                                i24 = i20;
                                                i49 = i23;
                                                unsafe2 = unsafe10;
                                                obj2 = obj;
                                                if (i50 == 0) {
                                                    zzc = zzkw.zzc(bArr2, i22, zzkvVar2);
                                                    unsafe2.putObject(obj2, j11, Boolean.valueOf(zzkvVar2.zzb != 0));
                                                    unsafe2.putInt(obj2, j12, i49);
                                                    i41 = zzc;
                                                    if (i41 == i22) {
                                                    }
                                                }
                                                i41 = i22;
                                                if (i41 == i22) {
                                                }
                                                break;
                                            case 59:
                                                i16 = i21;
                                                i24 = i20;
                                                i49 = i23;
                                                unsafe2 = unsafe10;
                                                obj2 = obj;
                                                if (i50 == 2) {
                                                    int zza2 = zzkw.zza(bArr2, i22, zzkvVar2);
                                                    int i63 = zzkvVar2.zza;
                                                    if (i63 == 0) {
                                                        unsafe2.putObject(obj2, j11, "");
                                                    } else {
                                                        int i64 = zza2 + i63;
                                                        if ((i51 & 536870912) != 0 && !zzor.zza(bArr2, zza2, i64)) {
                                                            throw new zzmq("Protocol message had invalid UTF-8.");
                                                        }
                                                        unsafe2.putObject(obj2, j11, new String(bArr2, zza2, i63, zzmo.zza));
                                                        zza2 = i64;
                                                    }
                                                    unsafe2.putInt(obj2, j12, i49);
                                                    i41 = zza2;
                                                    if (i41 == i22) {
                                                    }
                                                }
                                                i41 = i22;
                                                if (i41 == i22) {
                                                }
                                                break;
                                            case 60:
                                                i16 = i21;
                                                i49 = i23;
                                                unsafe4 = unsafe10;
                                                obj2 = obj;
                                                if (i50 == 2) {
                                                    Object zzu = zzu(obj2, i49, i20);
                                                    i41 = zzkw.zzj(zzu, zzp(i20), bArr, i22, i11, zzkvVar);
                                                    zzv(obj2, i49, i20, zzu);
                                                    unsafe2 = unsafe4;
                                                    i24 = i20;
                                                    if (i41 == i22) {
                                                    }
                                                }
                                                unsafe2 = unsafe4;
                                                i24 = i20;
                                                i41 = i22;
                                                if (i41 == i22) {
                                                }
                                                break;
                                            case 61:
                                                i16 = i21;
                                                i49 = i23;
                                                unsafe4 = unsafe10;
                                                obj2 = obj;
                                                if (i50 == 2) {
                                                    int zzg2 = zzkw.zzg(bArr2, i22, zzkvVar2);
                                                    unsafe4.putObject(obj2, j11, zzkvVar2.zzc);
                                                    unsafe4.putInt(obj2, j12, i49);
                                                    i41 = zzg2;
                                                    unsafe2 = unsafe4;
                                                    i24 = i20;
                                                    if (i41 == i22) {
                                                    }
                                                }
                                                unsafe2 = unsafe4;
                                                i24 = i20;
                                                i41 = i22;
                                                if (i41 == i22) {
                                                }
                                                break;
                                            case 63:
                                                i16 = i21;
                                                i49 = i23;
                                                unsafe4 = unsafe10;
                                                obj2 = obj;
                                                if (i50 == 0) {
                                                    i41 = zzkw.zza(bArr2, i22, zzkvVar2);
                                                    int i65 = zzkvVar2.zza;
                                                    zzmj zzr2 = zzr(i20);
                                                    if (zzr2 != null && !zzr2.zza(i65)) {
                                                        zzg(obj).zzk(i16, Long.valueOf(i65));
                                                    } else {
                                                        unsafe4.putObject(obj2, j11, Integer.valueOf(i65));
                                                        unsafe4.putInt(obj2, j12, i49);
                                                    }
                                                    unsafe2 = unsafe4;
                                                    i24 = i20;
                                                    if (i41 == i22) {
                                                    }
                                                }
                                                unsafe2 = unsafe4;
                                                i24 = i20;
                                                i41 = i22;
                                                if (i41 == i22) {
                                                }
                                                break;
                                            case 66:
                                                i16 = i21;
                                                i49 = i23;
                                                unsafe4 = unsafe10;
                                                obj2 = obj;
                                                if (i50 == 0) {
                                                    i41 = zzkw.zza(bArr2, i22, zzkvVar2);
                                                    unsafe4.putObject(obj2, j11, Integer.valueOf(zzli.zzb(zzkvVar2.zza)));
                                                    unsafe4.putInt(obj2, j12, i49);
                                                    unsafe2 = unsafe4;
                                                    i24 = i20;
                                                    if (i41 == i22) {
                                                    }
                                                }
                                                unsafe2 = unsafe4;
                                                i24 = i20;
                                                i41 = i22;
                                                if (i41 == i22) {
                                                }
                                                break;
                                            case 67:
                                                i16 = i21;
                                                i49 = i23;
                                                obj2 = obj;
                                                if (i50 == 0) {
                                                    i41 = zzkw.zzc(bArr2, i22, zzkvVar2);
                                                    unsafe4 = unsafe10;
                                                    unsafe4.putObject(obj2, j11, Long.valueOf(zzli.zzc(zzkvVar2.zzb)));
                                                    unsafe4.putInt(obj2, j12, i49);
                                                    unsafe2 = unsafe4;
                                                    i24 = i20;
                                                    if (i41 == i22) {
                                                    }
                                                }
                                                i24 = i20;
                                                unsafe2 = unsafe10;
                                                i41 = i22;
                                                if (i41 == i22) {
                                                }
                                                break;
                                            case 68:
                                                if (i50 == 3) {
                                                    Object zzu2 = zzu(obj, i23, i20);
                                                    i16 = i21;
                                                    i41 = zzkw.zzk(zzu2, zzp(i20), bArr, i22, i11, (i21 & (-8)) | 4, zzkvVar);
                                                    zzv(obj, i23, i20, zzu2);
                                                    obj2 = obj;
                                                    i49 = i23;
                                                    i24 = i20;
                                                    unsafe2 = unsafe10;
                                                    if (i41 == i22) {
                                                    }
                                                } else {
                                                    i16 = i21;
                                                    obj2 = obj;
                                                    i49 = i23;
                                                    i24 = i20;
                                                    unsafe2 = unsafe10;
                                                    i41 = i22;
                                                    if (i41 == i22) {
                                                    }
                                                }
                                                break;
                                            default:
                                                i16 = i21;
                                                i24 = i20;
                                                i49 = i23;
                                                unsafe2 = unsafe10;
                                                obj2 = obj;
                                                i41 = i22;
                                                if (i41 == i22) {
                                                }
                                                break;
                                        }
                                    } else if (i50 == 2) {
                                        Object zzq = zznoVar.zzq(i20);
                                        Unsafe unsafe11 = unsafe10;
                                        Object object = unsafe11.getObject(obj6, j11);
                                        if (!((zznf) object).zze()) {
                                            zznf zzc3 = zznf.zza().zzc();
                                            zzng.zza(zzc3, object);
                                            unsafe11.putObject(obj6, j11, zzc3);
                                            object = zzc3;
                                        }
                                        zznd zze = ((zzne) zzq).zze();
                                        zznf zznfVar2 = (zznf) object;
                                        int zza3 = zzkw.zza(bArr2, i22, zzkvVar2);
                                        int i66 = zzkvVar2.zza;
                                        if (i66 >= 0 && i66 <= i11 - zza3) {
                                            int i67 = zza3 + i66;
                                            Object obj7 = zze.zzb;
                                            Object obj8 = zze.zzd;
                                            Object obj9 = obj7;
                                            Object obj10 = obj8;
                                            while (zza3 < i67) {
                                                Object obj11 = obj10;
                                                Object obj12 = obj9;
                                                int i68 = zza3 + 1;
                                                byte b10 = bArr2[zza3];
                                                if (b10 < 0) {
                                                    i68 = zzkw.zzb(b10, bArr2, i68, zzkvVar2);
                                                    b10 = zzkvVar2.zza;
                                                }
                                                int i69 = b10 >>> 3;
                                                int i70 = i67;
                                                int i71 = b10 & 7;
                                                zznf zznfVar3 = zznfVar2;
                                                if (i69 == 1) {
                                                    unsafe6 = unsafe11;
                                                    obj3 = obj12;
                                                    i25 = i70;
                                                    zznfVar = zznfVar3;
                                                    obj4 = obj8;
                                                    zzos zzosVar = zze.zza;
                                                    if (i71 == zzosVar.zzb()) {
                                                        zza3 = zzO(bArr, i68, i11, zzosVar, null, zzkvVar);
                                                        obj9 = zzkvVar2.zzc;
                                                        zznfVar2 = zznfVar;
                                                        i67 = i25;
                                                        obj10 = obj11;
                                                        obj8 = obj4;
                                                        unsafe11 = unsafe6;
                                                    }
                                                } else if (i69 == 2) {
                                                    zzos zzosVar2 = zze.zzc;
                                                    if (i71 == zzosVar2.zzb()) {
                                                        unsafe6 = unsafe11;
                                                        obj3 = obj12;
                                                        obj4 = obj8;
                                                        i25 = i70;
                                                        zznfVar = zznfVar3;
                                                        zza3 = zzO(bArr, i68, i11, zzosVar2, obj8.getClass(), zzkvVar);
                                                        obj10 = zzkvVar2.zzc;
                                                        zznfVar2 = zznfVar;
                                                        i67 = i25;
                                                        obj9 = obj3;
                                                        obj8 = obj4;
                                                        unsafe11 = unsafe6;
                                                    } else {
                                                        unsafe6 = unsafe11;
                                                        obj3 = obj12;
                                                        i25 = i70;
                                                        zznfVar = zznfVar3;
                                                        obj4 = obj8;
                                                    }
                                                } else {
                                                    unsafe6 = unsafe11;
                                                    obj10 = obj11;
                                                    obj3 = obj12;
                                                    i25 = i70;
                                                    zznfVar = zznfVar3;
                                                    obj4 = obj8;
                                                    zza3 = zzkw.zzp(b10, bArr2, i68, i11, zzkvVar2);
                                                    zznfVar2 = zznfVar;
                                                    i67 = i25;
                                                    obj9 = obj3;
                                                    obj8 = obj4;
                                                    unsafe11 = unsafe6;
                                                }
                                                obj10 = obj11;
                                                zza3 = zzkw.zzp(b10, bArr2, i68, i11, zzkvVar2);
                                                zznfVar2 = zznfVar;
                                                i67 = i25;
                                                obj9 = obj3;
                                                obj8 = obj4;
                                                unsafe11 = unsafe6;
                                            }
                                            int i72 = i67;
                                            zznf zznfVar4 = zznfVar2;
                                            unsafe5 = unsafe11;
                                            Object obj13 = obj9;
                                            if (zza3 == i72) {
                                                zznfVar4.put(obj13, obj10);
                                                if (i72 != i22) {
                                                    obj6 = obj;
                                                    i45 = i61;
                                                    i41 = i72;
                                                    i46 = i21;
                                                    i43 = i20;
                                                    bArr3 = bArr2;
                                                    i42 = i23;
                                                    unsafe9 = unsafe5;
                                                    i40 = -1;
                                                    i39 = 0;
                                                    i38 = 3;
                                                    zznoVar = this;
                                                    zzkvVar3 = zzkvVar2;
                                                    i36 = i11;
                                                } else {
                                                    i45 = i61;
                                                    i13 = i12;
                                                    i19 = i72;
                                                    i16 = i21;
                                                    i49 = i23;
                                                    unsafe2 = unsafe5;
                                                    obj2 = obj;
                                                }
                                            } else {
                                                throw new zzmq(str);
                                            }
                                        }
                                    } else {
                                        unsafe5 = unsafe10;
                                        str2 = str;
                                    }
                                } else {
                                    long j13 = i51;
                                    zzmn zzmnVar = (zzmn) unsafe10.getObject(obj6, j11);
                                    if (zzmnVar.zza()) {
                                        j10 = j13;
                                    } else {
                                        int size = zzmnVar.size();
                                        j10 = j13;
                                        zzmnVar = zzmnVar.zzg(size + size);
                                        unsafe10.putObject(obj6, j11, zzmnVar);
                                    }
                                    zzmn zzmnVar2 = zzmnVar;
                                    switch (zzz) {
                                        case 18:
                                        case 35:
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            i26 = i47;
                                            i27 = i62;
                                            unsafe7 = unsafe10;
                                            i28 = i49;
                                            i29 = i11;
                                            if (i50 == 2) {
                                                int i73 = zzkw.zza;
                                                zzln zzlnVar = (zzln) zzmnVar2;
                                                i41 = zzkw.zza(bArr2, i26, zzkvVar2);
                                                int i74 = zzkvVar2.zza;
                                                int i75 = i41 + i74;
                                                if (i75 <= bArr2.length) {
                                                    zzlnVar.zzh(zzlnVar.size() + (i74 / 8));
                                                    while (i41 < i75) {
                                                        zzlnVar.zzf(Double.longBitsToDouble(zzkw.zze(bArr2, i41)));
                                                        i41 += 8;
                                                    }
                                                    if (i41 != i75) {
                                                        throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    i45 = i61;
                                                    if (i41 == i26) {
                                                        i19 = i41;
                                                        i16 = i21;
                                                        i20 = i27;
                                                        i49 = i28;
                                                        unsafe2 = unsafe7;
                                                        obj2 = obj6;
                                                        i13 = i12;
                                                        break;
                                                    } else {
                                                        bArr3 = bArr2;
                                                        i43 = i27;
                                                        i42 = i28;
                                                        i40 = -1;
                                                        i39 = 0;
                                                        i38 = 3;
                                                        i46 = i21;
                                                        zzkvVar3 = zzkvVar2;
                                                        i36 = i29;
                                                        unsafe9 = unsafe7;
                                                        break;
                                                    }
                                                } else {
                                                    throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (i50 == 1) {
                                                    i30 = i26 + 8;
                                                    int i76 = zzkw.zza;
                                                    zzln zzlnVar2 = (zzln) zzmnVar2;
                                                    zzlnVar2.zzf(Double.longBitsToDouble(zzkw.zze(bArr2, i26)));
                                                    while (i30 < i29) {
                                                        int zza4 = zzkw.zza(bArr2, i30, zzkvVar2);
                                                        if (i21 == zzkvVar2.zza) {
                                                            zzlnVar2.zzf(Double.longBitsToDouble(zzkw.zze(bArr2, zza4)));
                                                            i30 = zza4 + 8;
                                                        } else {
                                                            i41 = i30;
                                                            i45 = i61;
                                                            if (i41 == i26) {
                                                            }
                                                        }
                                                    }
                                                    i41 = i30;
                                                    i45 = i61;
                                                    if (i41 == i26) {
                                                    }
                                                }
                                                i41 = i26;
                                                i45 = i61;
                                                if (i41 == i26) {
                                                }
                                            }
                                        case 19:
                                        case 36:
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            i26 = i47;
                                            i27 = i62;
                                            unsafe7 = unsafe10;
                                            i28 = i49;
                                            i29 = i11;
                                            if (i50 == 2) {
                                                int i77 = zzkw.zza;
                                                zzlx zzlxVar = (zzlx) zzmnVar2;
                                                i41 = zzkw.zza(bArr2, i26, zzkvVar2);
                                                int i78 = zzkvVar2.zza;
                                                int i79 = i41 + i78;
                                                if (i79 <= bArr2.length) {
                                                    zzlxVar.zzh(zzlxVar.size() + (i78 / 4));
                                                    while (i41 < i79) {
                                                        zzlxVar.zzf(Float.intBitsToFloat(zzkw.zzd(bArr2, i41)));
                                                        i41 += 4;
                                                    }
                                                    if (i41 != i79) {
                                                        throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    i45 = i61;
                                                    if (i41 == i26) {
                                                    }
                                                } else {
                                                    throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (i50 == 5) {
                                                    i30 = i26 + 4;
                                                    int i80 = zzkw.zza;
                                                    zzlx zzlxVar2 = (zzlx) zzmnVar2;
                                                    zzlxVar2.zzf(Float.intBitsToFloat(zzkw.zzd(bArr2, i26)));
                                                    while (i30 < i29) {
                                                        int zza5 = zzkw.zza(bArr2, i30, zzkvVar2);
                                                        if (i21 == zzkvVar2.zza) {
                                                            zzlxVar2.zzf(Float.intBitsToFloat(zzkw.zzd(bArr2, zza5)));
                                                            i30 = zza5 + 4;
                                                        } else {
                                                            i41 = i30;
                                                            i45 = i61;
                                                            if (i41 == i26) {
                                                            }
                                                        }
                                                    }
                                                    i41 = i30;
                                                    i45 = i61;
                                                    if (i41 == i26) {
                                                    }
                                                }
                                                i41 = i26;
                                                i45 = i61;
                                                if (i41 == i26) {
                                                }
                                            }
                                            break;
                                        case 20:
                                        case 21:
                                        case 37:
                                        case 38:
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            i26 = i47;
                                            i27 = i62;
                                            unsafe7 = unsafe10;
                                            i28 = i49;
                                            i29 = i11;
                                            if (i50 == 2) {
                                                int i81 = zzkw.zza;
                                                zzmz zzmzVar = (zzmz) zzmnVar2;
                                                i41 = zzkw.zza(bArr2, i26, zzkvVar2);
                                                int i82 = zzkvVar2.zza + i41;
                                                while (i41 < i82) {
                                                    i41 = zzkw.zzc(bArr2, i41, zzkvVar2);
                                                    zzmzVar.zzf(zzkvVar2.zzb);
                                                }
                                                if (i41 != i82) {
                                                    throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (i50 == 0) {
                                                    int i83 = zzkw.zza;
                                                    zzmz zzmzVar2 = (zzmz) zzmnVar2;
                                                    i41 = zzkw.zzc(bArr2, i26, zzkvVar2);
                                                    zzmzVar2.zzf(zzkvVar2.zzb);
                                                    while (i41 < i29) {
                                                        int zza6 = zzkw.zza(bArr2, i41, zzkvVar2);
                                                        if (i21 == zzkvVar2.zza) {
                                                            i41 = zzkw.zzc(bArr2, zza6, zzkvVar2);
                                                            zzmzVar2.zzf(zzkvVar2.zzb);
                                                        }
                                                    }
                                                }
                                                i41 = i26;
                                            }
                                            i45 = i61;
                                            if (i41 == i26) {
                                            }
                                            break;
                                        case 22:
                                        case 29:
                                        case 39:
                                        case 43:
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            i26 = i47;
                                            i27 = i62;
                                            unsafe7 = unsafe10;
                                            i28 = i49;
                                            i29 = i11;
                                            if (i50 == 2) {
                                                i41 = zzkw.zzm(bArr2, i26, zzmnVar2, zzkvVar2);
                                            } else {
                                                if (i50 == 0) {
                                                    i41 = zzkw.zzl(i21, bArr, i26, i11, zzmnVar2, zzkvVar);
                                                }
                                                i41 = i26;
                                            }
                                            i45 = i61;
                                            if (i41 == i26) {
                                            }
                                            break;
                                        case 23:
                                        case 32:
                                        case 40:
                                        case 46:
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            i26 = i47;
                                            int i84 = i62;
                                            unsafe7 = unsafe10;
                                            i29 = i11;
                                            if (i50 == 2) {
                                                int i85 = zzkw.zza;
                                                zzmz zzmzVar3 = (zzmz) zzmnVar2;
                                                i41 = zzkw.zza(bArr2, i26, zzkvVar2);
                                                int i86 = zzkvVar2.zza;
                                                int i87 = i41 + i86;
                                                if (i87 <= bArr2.length) {
                                                    zzmzVar3.zzh(zzmzVar3.size() + (i86 / 8));
                                                    while (i41 < i87) {
                                                        zzmzVar3.zzf(zzkw.zze(bArr2, i41));
                                                        i41 += 8;
                                                        i84 = i84;
                                                        i49 = i49;
                                                    }
                                                    i27 = i84;
                                                    i28 = i49;
                                                    if (i41 != i87) {
                                                        throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    i45 = i61;
                                                    if (i41 == i26) {
                                                    }
                                                } else {
                                                    throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                i27 = i84;
                                                i28 = i49;
                                                if (i50 == 1) {
                                                    i30 = i26 + 8;
                                                    int i88 = zzkw.zza;
                                                    zzmz zzmzVar4 = (zzmz) zzmnVar2;
                                                    zzmzVar4.zzf(zzkw.zze(bArr2, i26));
                                                    while (i30 < i29) {
                                                        int zza7 = zzkw.zza(bArr2, i30, zzkvVar2);
                                                        if (i21 == zzkvVar2.zza) {
                                                            zzmzVar4.zzf(zzkw.zze(bArr2, zza7));
                                                            i30 = zza7 + 8;
                                                        } else {
                                                            i41 = i30;
                                                            i45 = i61;
                                                            if (i41 == i26) {
                                                            }
                                                        }
                                                    }
                                                    i41 = i30;
                                                    i45 = i61;
                                                    if (i41 == i26) {
                                                    }
                                                }
                                                i41 = i26;
                                                i45 = i61;
                                                if (i41 == i26) {
                                                }
                                            }
                                            break;
                                        case 24:
                                        case 31:
                                        case 41:
                                        case 45:
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            i26 = i47;
                                            i31 = i62;
                                            unsafe7 = unsafe10;
                                            i29 = i11;
                                            if (i50 == 2) {
                                                int i89 = zzkw.zza;
                                                zzmf zzmfVar = (zzmf) zzmnVar2;
                                                i41 = zzkw.zza(bArr2, i26, zzkvVar2);
                                                int i90 = zzkvVar2.zza;
                                                int i91 = i41 + i90;
                                                if (i91 <= bArr2.length) {
                                                    zzmfVar.zzi(zzmfVar.size() + (i90 / 4));
                                                    while (i41 < i91) {
                                                        zzmfVar.zzh(zzkw.zzd(bArr2, i41));
                                                        i41 += 4;
                                                    }
                                                    if (i41 != i91) {
                                                        throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                } else {
                                                    throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (i50 == 5) {
                                                    int i92 = i26 + 4;
                                                    int i93 = zzkw.zza;
                                                    zzmf zzmfVar2 = (zzmf) zzmnVar2;
                                                    zzmfVar2.zzh(zzkw.zzd(bArr2, i26));
                                                    while (i92 < i29) {
                                                        int zza8 = zzkw.zza(bArr2, i92, zzkvVar2);
                                                        if (i21 == zzkvVar2.zza) {
                                                            zzmfVar2.zzh(zzkw.zzd(bArr2, zza8));
                                                            i92 = zza8 + 4;
                                                        } else {
                                                            i41 = i92;
                                                        }
                                                    }
                                                    i41 = i92;
                                                }
                                                i27 = i31;
                                                i28 = i49;
                                                i41 = i26;
                                                i45 = i61;
                                                if (i41 == i26) {
                                                }
                                            }
                                            i27 = i31;
                                            i28 = i49;
                                            i45 = i61;
                                            if (i41 == i26) {
                                            }
                                            break;
                                        case 25:
                                        case 42:
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            i26 = i47;
                                            i31 = i62;
                                            unsafe7 = unsafe10;
                                            i29 = i11;
                                            if (i50 == 2) {
                                                int i94 = zzkw.zza;
                                                zzkx zzkxVar = (zzkx) zzmnVar2;
                                                i41 = zzkw.zza(bArr2, i26, zzkvVar2);
                                                int i95 = zzkvVar2.zza + i41;
                                                while (i41 < i95) {
                                                    i41 = zzkw.zzc(bArr2, i41, zzkvVar2);
                                                    zzkxVar.zzf(zzkvVar2.zzb != 0);
                                                }
                                                if (i41 != i95) {
                                                    throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (i50 == 0) {
                                                    int i96 = zzkw.zza;
                                                    zzkx zzkxVar2 = (zzkx) zzmnVar2;
                                                    i41 = zzkw.zzc(bArr2, i26, zzkvVar2);
                                                    zzkxVar2.zzf(zzkvVar2.zzb != 0);
                                                    while (i41 < i29) {
                                                        int zza9 = zzkw.zza(bArr2, i41, zzkvVar2);
                                                        if (i21 == zzkvVar2.zza) {
                                                            i41 = zzkw.zzc(bArr2, zza9, zzkvVar2);
                                                            zzkxVar2.zzf(zzkvVar2.zzb != 0);
                                                        }
                                                    }
                                                }
                                                i27 = i31;
                                                i28 = i49;
                                                i41 = i26;
                                                i45 = i61;
                                                if (i41 == i26) {
                                                }
                                            }
                                            i27 = i31;
                                            i28 = i49;
                                            i45 = i61;
                                            if (i41 == i26) {
                                            }
                                            break;
                                        case 26:
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            i26 = i47;
                                            i31 = i62;
                                            unsafe7 = unsafe10;
                                            long j14 = j10;
                                            i29 = i11;
                                            if (i50 == 2) {
                                                if ((536870912 & j14) == 0) {
                                                    i41 = zzkw.zza(bArr2, i26, zzkvVar2);
                                                    int i97 = zzkvVar2.zza;
                                                    if (i97 < 0) {
                                                        throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i97 == 0) {
                                                        obj5 = "";
                                                        zzmnVar2.add(obj5);
                                                    } else {
                                                        obj5 = "";
                                                        zzmnVar2.add(new String(bArr2, i41, i97, zzmo.zza));
                                                        i41 += i97;
                                                    }
                                                    while (i41 < i29) {
                                                        int zza10 = zzkw.zza(bArr2, i41, zzkvVar2);
                                                        if (i21 == zzkvVar2.zza) {
                                                            i41 = zzkw.zza(bArr2, zza10, zzkvVar2);
                                                            int i98 = zzkvVar2.zza;
                                                            if (i98 < 0) {
                                                                throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                            if (i98 == 0) {
                                                                zzmnVar2.add(obj5);
                                                            } else {
                                                                zzmnVar2.add(new String(bArr2, i41, i98, zzmo.zza));
                                                                i41 += i98;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    i41 = zzkw.zza(bArr2, i26, zzkvVar2);
                                                    int i99 = zzkvVar2.zza;
                                                    if (i99 < 0) {
                                                        throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i99 == 0) {
                                                        zzmnVar2.add("");
                                                    } else {
                                                        int i100 = i41 + i99;
                                                        if (zzor.zza(bArr2, i41, i100)) {
                                                            zzmnVar2.add(new String(bArr2, i41, i99, zzmo.zza));
                                                            i41 = i100;
                                                        } else {
                                                            throw new zzmq("Protocol message had invalid UTF-8.");
                                                        }
                                                    }
                                                    while (i41 < i29) {
                                                        int zza11 = zzkw.zza(bArr2, i41, zzkvVar2);
                                                        if (i21 == zzkvVar2.zza) {
                                                            i41 = zzkw.zza(bArr2, zza11, zzkvVar2);
                                                            int i101 = zzkvVar2.zza;
                                                            if (i101 < 0) {
                                                                throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                            if (i101 == 0) {
                                                                zzmnVar2.add("");
                                                            } else {
                                                                int i102 = i41 + i101;
                                                                if (zzor.zza(bArr2, i41, i102)) {
                                                                    zzmnVar2.add(new String(bArr2, i41, i101, zzmo.zza));
                                                                    i41 = i102;
                                                                } else {
                                                                    throw new zzmq("Protocol message had invalid UTF-8.");
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                i27 = i31;
                                                i28 = i49;
                                                i45 = i61;
                                                if (i41 == i26) {
                                                }
                                            }
                                            i27 = i31;
                                            i28 = i49;
                                            i41 = i26;
                                            i45 = i61;
                                            if (i41 == i26) {
                                            }
                                            break;
                                        case 27:
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            i26 = i47;
                                            i27 = i62;
                                            unsafe7 = unsafe10;
                                            i29 = i11;
                                            if (i50 == 2) {
                                                zznoVar = this;
                                                i41 = zzkw.zzn(zznoVar.zzp(i27), i21, bArr, i26, i11, zzmnVar2, zzkvVar);
                                                i21 = i21;
                                                i28 = i49;
                                                i45 = i61;
                                                if (i41 == i26) {
                                                }
                                            }
                                            zznoVar = this;
                                            i28 = i49;
                                            i41 = i26;
                                            i45 = i61;
                                            if (i41 == i26) {
                                            }
                                            break;
                                        case 28:
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            i26 = i47;
                                            i27 = i62;
                                            unsafe7 = unsafe10;
                                            i29 = i11;
                                            if (i50 == 2) {
                                                int zza12 = zzkw.zza(bArr2, i26, zzkvVar2);
                                                int i103 = zzkvVar2.zza;
                                                if (i103 >= 0) {
                                                    if (i103 > bArr2.length - zza12) {
                                                        throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    if (i103 == 0) {
                                                        zzmnVar2.add(zzlg.zzb);
                                                    } else {
                                                        zzmnVar2.add(zzlg.zzh(bArr2, zza12, i103));
                                                        zza12 += i103;
                                                    }
                                                    while (zza12 < i29) {
                                                        int zza13 = zzkw.zza(bArr2, zza12, zzkvVar2);
                                                        if (i21 == zzkvVar2.zza) {
                                                            zza12 = zzkw.zza(bArr2, zza13, zzkvVar2);
                                                            int i104 = zzkvVar2.zza;
                                                            if (i104 >= 0) {
                                                                if (i104 > bArr2.length - zza12) {
                                                                    throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                                }
                                                                if (i104 == 0) {
                                                                    zzmnVar2.add(zzlg.zzb);
                                                                } else {
                                                                    zzmnVar2.add(zzlg.zzh(bArr2, zza12, i104));
                                                                    zza12 += i104;
                                                                }
                                                            } else {
                                                                throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                        } else {
                                                            i41 = zza12;
                                                            i28 = i49;
                                                            zznoVar = this;
                                                            i45 = i61;
                                                            if (i41 == i26) {
                                                            }
                                                        }
                                                    }
                                                    i41 = zza12;
                                                    i28 = i49;
                                                    zznoVar = this;
                                                    i45 = i61;
                                                    if (i41 == i26) {
                                                    }
                                                } else {
                                                    throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                            }
                                            zznoVar = this;
                                            i28 = i49;
                                            i41 = i26;
                                            i45 = i61;
                                            if (i41 == i26) {
                                            }
                                            break;
                                        case 30:
                                        case 44:
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            i26 = i47;
                                            i31 = i62;
                                            unsafe7 = unsafe10;
                                            i29 = i11;
                                            if (i50 == 2) {
                                                zzl = zzkw.zzm(bArr2, i26, zzmnVar2, zzkvVar2);
                                            } else if (i50 == 0) {
                                                zzl = zzkw.zzl(i21, bArr, i26, i11, zzmnVar2, zzkvVar);
                                            } else {
                                                zznoVar = this;
                                                i27 = i31;
                                                i28 = i49;
                                                i41 = i26;
                                                i45 = i61;
                                                if (i41 == i26) {
                                                }
                                            }
                                            zzmj zzr3 = zznoVar.zzr(i31);
                                            zzoh zzohVar = zznoVar.zzl;
                                            int i105 = zzny.zza;
                                            if (zzr3 == null) {
                                                i32 = zzl;
                                                i27 = i31;
                                            } else if (zzmnVar2 instanceof RandomAccess) {
                                                int size2 = zzmnVar2.size();
                                                i32 = zzl;
                                                Object obj14 = null;
                                                int i106 = 0;
                                                int i107 = 0;
                                                while (i107 < size2) {
                                                    Integer num = (Integer) zzmnVar2.get(i107);
                                                    int i108 = i31;
                                                    int intValue = num.intValue();
                                                    if (zzr3.zza(intValue)) {
                                                        if (i107 != i106) {
                                                            zzmnVar2.set(i106, num);
                                                        }
                                                        i33 = 1;
                                                        i106++;
                                                    } else {
                                                        i33 = 1;
                                                        obj14 = zzny.zzE(obj6, i49, intValue, obj14, zzohVar);
                                                    }
                                                    i107 += i33;
                                                    i31 = i108;
                                                }
                                                i27 = i31;
                                                if (i106 != size2) {
                                                    zzmnVar2.subList(i106, size2).clear();
                                                }
                                            } else {
                                                i32 = zzl;
                                                i27 = i31;
                                                Iterator it = zzmnVar2.iterator();
                                                Object obj15 = null;
                                                while (it.hasNext()) {
                                                    int intValue2 = ((Integer) it.next()).intValue();
                                                    if (!zzr3.zza(intValue2)) {
                                                        obj15 = zzny.zzE(obj6, i49, intValue2, obj15, zzohVar);
                                                        it.remove();
                                                    }
                                                }
                                            }
                                            zznoVar = this;
                                            i28 = i49;
                                            i41 = i32;
                                            i45 = i61;
                                            if (i41 == i26) {
                                            }
                                            break;
                                        case 33:
                                        case 47:
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            i26 = i47;
                                            i31 = i62;
                                            unsafe7 = unsafe10;
                                            i29 = i11;
                                            if (i50 == 2) {
                                                int i109 = zzkw.zza;
                                                zzmf zzmfVar3 = (zzmf) zzmnVar2;
                                                i41 = zzkw.zza(bArr2, i26, zzkvVar2);
                                                int i110 = zzkvVar2.zza + i41;
                                                while (i41 < i110) {
                                                    i41 = zzkw.zza(bArr2, i41, zzkvVar2);
                                                    zzmfVar3.zzh(zzli.zzb(zzkvVar2.zza));
                                                }
                                                if (i41 != i110) {
                                                    throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (i50 == 0) {
                                                    int i111 = zzkw.zza;
                                                    zzmf zzmfVar4 = (zzmf) zzmnVar2;
                                                    i41 = zzkw.zza(bArr2, i26, zzkvVar2);
                                                    zzmfVar4.zzh(zzli.zzb(zzkvVar2.zza));
                                                    while (i41 < i29) {
                                                        int zza14 = zzkw.zza(bArr2, i41, zzkvVar2);
                                                        if (i21 == zzkvVar2.zza) {
                                                            i41 = zzkw.zza(bArr2, zza14, zzkvVar2);
                                                            zzmfVar4.zzh(zzli.zzb(zzkvVar2.zza));
                                                        }
                                                    }
                                                }
                                                i27 = i31;
                                                i28 = i49;
                                                i41 = i26;
                                                i45 = i61;
                                                if (i41 == i26) {
                                                }
                                            }
                                            i27 = i31;
                                            i28 = i49;
                                            i45 = i61;
                                            if (i41 == i26) {
                                            }
                                            break;
                                        case 34:
                                        case 48:
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            i26 = i47;
                                            i31 = i62;
                                            unsafe7 = unsafe10;
                                            i29 = i11;
                                            if (i50 == 2) {
                                                int i112 = zzkw.zza;
                                                zzmz zzmzVar5 = (zzmz) zzmnVar2;
                                                i41 = zzkw.zza(bArr2, i26, zzkvVar2);
                                                int i113 = zzkvVar2.zza + i41;
                                                while (i41 < i113) {
                                                    i41 = zzkw.zzc(bArr2, i41, zzkvVar2);
                                                    zzmzVar5.zzf(zzli.zzc(zzkvVar2.zzb));
                                                }
                                                if (i41 != i113) {
                                                    throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (i50 == 0) {
                                                    int i114 = zzkw.zza;
                                                    zzmz zzmzVar6 = (zzmz) zzmnVar2;
                                                    i41 = zzkw.zzc(bArr2, i26, zzkvVar2);
                                                    zzmzVar6.zzf(zzli.zzc(zzkvVar2.zzb));
                                                    while (i41 < i29) {
                                                        int zza15 = zzkw.zza(bArr2, i41, zzkvVar2);
                                                        if (i21 == zzkvVar2.zza) {
                                                            i41 = zzkw.zzc(bArr2, zza15, zzkvVar2);
                                                            zzmzVar6.zzf(zzli.zzc(zzkvVar2.zzb));
                                                        }
                                                    }
                                                }
                                                i27 = i31;
                                                i28 = i49;
                                                i41 = i26;
                                                i45 = i61;
                                                if (i41 == i26) {
                                                }
                                            }
                                            i27 = i31;
                                            i28 = i49;
                                            i45 = i61;
                                            if (i41 == i26) {
                                            }
                                            break;
                                        default:
                                            if (i50 == 3) {
                                                int i115 = (i21 & (-8)) | 4;
                                                zznw zzp = zznoVar.zzp(i62);
                                                i26 = i47;
                                                i31 = i62;
                                                zzkv zzkvVar4 = zzkvVar;
                                                i41 = zzkw.zzi(zzp, bArr, i47, i11, i115, zzkvVar4);
                                                zzmnVar2.add(zzkvVar4.zzc);
                                                int i116 = i11;
                                                while (true) {
                                                    if (i41 < i116) {
                                                        int zza16 = zzkw.zza(bArr, i41, zzkvVar4);
                                                        if (i21 == zzkvVar4.zza) {
                                                            Unsafe unsafe12 = unsafe10;
                                                            int i117 = i116;
                                                            int i118 = i115;
                                                            int i119 = i115;
                                                            zzkv zzkvVar5 = zzkvVar4;
                                                            i41 = zzkw.zzi(zzp, bArr, zza16, i11, i118, zzkvVar);
                                                            zzmnVar2.add(zzkvVar5.zzc);
                                                            zzkvVar4 = zzkvVar5;
                                                            i116 = i117;
                                                            zzp = zzp;
                                                            i115 = i119;
                                                            unsafe10 = unsafe12;
                                                        } else {
                                                            bArr2 = bArr;
                                                        }
                                                    } else {
                                                        bArr2 = bArr;
                                                    }
                                                }
                                                zzkvVar2 = zzkvVar4;
                                                unsafe7 = unsafe10;
                                                i29 = i116;
                                                i27 = i31;
                                                i28 = i49;
                                                i45 = i61;
                                                if (i41 == i26) {
                                                }
                                            } else {
                                                bArr2 = bArr;
                                                zzkvVar2 = zzkvVar;
                                                i26 = i47;
                                                unsafe7 = unsafe10;
                                                i29 = i11;
                                                i27 = i62;
                                                i28 = i49;
                                                i41 = i26;
                                                i45 = i61;
                                                if (i41 == i26) {
                                                }
                                            }
                                            break;
                                    }
                                }
                                i37 = i12;
                            } else if (i50 == 2) {
                                zzmn zzmnVar3 = (zzmn) unsafe10.getObject(obj6, j11);
                                if (!zzmnVar3.zza()) {
                                    int size3 = zzmnVar3.size();
                                    zzmnVar3 = zzmnVar3.zzg(size3 == 0 ? 10 : size3 + size3);
                                    unsafe10.putObject(obj6, j11, zzmnVar3);
                                }
                                i41 = zzkw.zzn(zznoVar.zzp(i62), i52, bArr, i47, i11, zzmnVar3, zzkvVar);
                                i45 = i61;
                                i43 = i62;
                                i46 = i52;
                                unsafe9 = unsafe10;
                                i42 = i49;
                                i40 = -1;
                                i39 = 0;
                                i38 = 3;
                                bArr3 = bArr;
                                i36 = i11;
                                i37 = i12;
                            } else {
                                i22 = i47;
                                i20 = i62;
                                unsafe5 = unsafe10;
                                zzkvVar2 = zzkvVar3;
                                i23 = i49;
                                str2 = str;
                                bArr2 = bArr;
                                i21 = i52;
                            }
                            i45 = i61;
                            i13 = i12;
                            str = str2;
                            i16 = i21;
                            i19 = i22;
                            i49 = i23;
                            unsafe2 = unsafe5;
                            obj2 = obj;
                        }
                    }
                    if (i16 == i13 || i13 == 0) {
                        zznoVar = this;
                        if (zznoVar.zzh) {
                            zzlq zzlqVar = zzkvVar2.zzd;
                            int i120 = zzlq.zzb;
                            int i121 = zznt.zza;
                            if (zzlqVar != zzlq.zza) {
                                zznl zznlVar = zznoVar.zzg;
                                int i122 = zzkw.zza;
                                if (zzlqVar.zzb(zznlVar, i49) == null) {
                                    unsafe3 = unsafe2;
                                    i41 = zzkw.zzo(i16, bArr, i19, i11, zzg(obj), zzkvVar);
                                    i43 = i20;
                                    i46 = i16;
                                    bArr3 = bArr2;
                                    i42 = i49;
                                    i40 = -1;
                                    i39 = 0;
                                    i38 = 3;
                                    i37 = i13;
                                    obj6 = obj2;
                                    zzkvVar3 = zzkvVar2;
                                    unsafe9 = unsafe3;
                                    i36 = i11;
                                } else {
                                    throw null;
                                }
                            }
                        }
                        unsafe3 = unsafe2;
                        i41 = zzkw.zzo(i16, bArr, i19, i11, zzg(obj), zzkvVar);
                        i43 = i20;
                        i46 = i16;
                        bArr3 = bArr2;
                        i42 = i49;
                        i40 = -1;
                        i39 = 0;
                        i38 = 3;
                        i37 = i13;
                        obj6 = obj2;
                        zzkvVar3 = zzkvVar2;
                        unsafe9 = unsafe3;
                        i36 = i11;
                    } else {
                        i17 = 1048575;
                        zznoVar = this;
                        i41 = i19;
                        unsafe = unsafe2;
                        i15 = i44;
                        i14 = i45;
                    }
                } else {
                    zzN = zznoVar.zzN(i49, i39);
                }
                i18 = zzN;
                if (i18 != i40) {
                }
                if (i16 == i13) {
                }
                zznoVar = this;
                if (zznoVar.zzh) {
                }
                unsafe3 = unsafe2;
                i41 = zzkw.zzo(i16, bArr, i19, i11, zzg(obj), zzkvVar);
                i43 = i20;
                i46 = i16;
                bArr3 = bArr2;
                i42 = i49;
                i40 = -1;
                i39 = 0;
                i38 = 3;
                i37 = i13;
                obj6 = obj2;
                zzkvVar3 = zzkvVar2;
                unsafe9 = unsafe3;
                i36 = i11;
            } else {
                str = "Failed to parse the message.";
                unsafe = unsafe9;
                obj2 = obj6;
                i13 = i37;
                i14 = i45;
                i15 = i44;
                i16 = i46;
                i17 = 1048575;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final void zzi(Object obj, byte[] bArr, int i10, int i11, zzkv zzkvVar) throws IOException {
        zzh(obj, bArr, i10, i11, 0, zzkvVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final void zzj(Object obj) {
        if (zzA(obj)) {
            if (obj instanceof zzme) {
                zzme zzmeVar = (zzme) obj;
                zzmeVar.zzcm(Integer.MAX_VALUE);
                zzmeVar.zza = 0;
                zzmeVar.zzcg();
            }
            int[] iArr = this.zzc;
            for (int i10 = 0; i10 < iArr.length; i10 += 3) {
                int zzx = zzx(i10);
                int i11 = 1048575 & zzx;
                int zzz = zzz(zzx);
                long j10 = i11;
                if (zzz != 9) {
                    if (zzz != 60 && zzz != 68) {
                        switch (zzz) {
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
                                ((zzmn) zzoo.zzn(obj, j10)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j10);
                                if (object != null) {
                                    ((zznf) object).zzd();
                                    unsafe.putObject(obj, j10, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzL(obj, iArr[i10], i10)) {
                        zzp(i10).zzj(zzb.getObject(obj, j10));
                    }
                }
                if (zzJ(obj, i10)) {
                    zzp(i10).zzj(zzb.getObject(obj, j10));
                }
            }
            this.zzl.zzb(obj);
            if (this.zzh) {
                this.zzm.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final boolean zzk(Object obj) {
        int i10;
        int i11;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        while (i14 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i15 = iArr[i14];
            int i16 = iArr2[i15];
            int zzx = zzx(i15);
            int i17 = iArr2[i15 + 2];
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
            if ((268435456 & zzx) != 0 && !zzI(obj, i15, i10, i11, i19)) {
                return false;
            }
            int zzz = zzz(zzx);
            if (zzz != 9 && zzz != 17) {
                if (zzz != 27) {
                    if (zzz != 60 && zzz != 68) {
                        if (zzz != 49) {
                            if (zzz != 50) {
                                continue;
                            } else {
                                zznf zznfVar = (zznf) zzoo.zzn(obj, zzx & 1048575);
                                if (!zznfVar.isEmpty() && ((zzne) zzq(i15)).zze().zzc.zza() == zzot.MESSAGE) {
                                    zznw zznwVar = null;
                                    for (Object obj2 : zznfVar.values()) {
                                        if (zznwVar == null) {
                                            zznwVar = zznt.zza().zzb(obj2.getClass());
                                        }
                                        if (!zznwVar.zzk(obj2)) {
                                            return false;
                                        }
                                    }
                                }
                            }
                        }
                    } else if (zzL(obj, i16, i15) && !zzw(obj, zzx, zzp(i15))) {
                        return false;
                    }
                }
                List list = (List) zzoo.zzn(obj, zzx & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zznw zzp = zzp(i15);
                    for (int i20 = 0; i20 < list.size(); i20++) {
                        if (!zzp.zzk(list.get(i20))) {
                            return false;
                        }
                    }
                }
            } else if (zzI(obj, i15, i10, i11, i19) && !zzw(obj, zzx, zzp(i15))) {
                return false;
            }
            i14++;
            i12 = i10;
            i13 = i11;
        }
        if (this.zzh && !((zzmb) obj).zzb.zze()) {
            return false;
        }
        return true;
    }
}
