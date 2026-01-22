package com.google.android.gms.internal.play_billing;

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
public final class zzef<T> implements zzeo<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzfp.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzec zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzdq zzl;
    private final zzff zzm;
    private final zzce zzn;
    private final zzei zzo;
    private final zzdx zzp;

    private zzef(int[] iArr, Object[] objArr, int i10, int i11, zzec zzecVar, int i12, boolean z10, int[] iArr2, int i13, int i14, zzei zzeiVar, zzdq zzdqVar, zzff zzffVar, zzce zzceVar, zzdx zzdxVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i10;
        this.zzf = i11;
        boolean z11 = false;
        if (zzceVar != null && zzceVar.zzf(zzecVar)) {
            z11 = true;
        }
        this.zzh = z11;
        this.zzi = iArr2;
        this.zzj = i13;
        this.zzk = i14;
        this.zzo = zzeiVar;
        this.zzl = zzdqVar;
        this.zzm = zzffVar;
        this.zzn = zzceVar;
        this.zzg = zzecVar;
        this.zzp = zzdxVar;
    }

    private static void zzA(Object obj) {
        if (zzL(obj)) {
        } else {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzB(Object obj, Object obj2, int i10) {
        if (!zzI(obj2, i10)) {
            return;
        }
        int zzs = zzs(i10) & 1048575;
        Unsafe unsafe = zzb;
        long j10 = zzs;
        Object object = unsafe.getObject(obj2, j10);
        if (object != null) {
            zzeo zzv = zzv(i10);
            if (!zzI(obj, i10)) {
                if (!zzL(object)) {
                    unsafe.putObject(obj, j10, object);
                } else {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, j10, zze);
                }
                zzD(obj, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, j10);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, j10, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + this.zzc[i10] + " is present but null: " + obj2.toString());
    }

    private final void zzC(Object obj, Object obj2, int i10) {
        int i11 = this.zzc[i10];
        if (!zzM(obj2, i11, i10)) {
            return;
        }
        int zzs = zzs(i10) & 1048575;
        Unsafe unsafe = zzb;
        long j10 = zzs;
        Object object = unsafe.getObject(obj2, j10);
        if (object != null) {
            zzeo zzv = zzv(i10);
            if (!zzM(obj, i11, i10)) {
                if (!zzL(object)) {
                    unsafe.putObject(obj, j10, object);
                } else {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, j10, zze);
                }
                zzE(obj, i11, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, j10);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, j10, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + this.zzc[i10] + " is present but null: " + obj2.toString());
    }

    private final void zzD(Object obj, int i10) {
        int zzp = zzp(i10);
        long j10 = 1048575 & zzp;
        if (j10 == 1048575) {
            return;
        }
        zzfp.zzq(obj, j10, (1 << (zzp >>> 20)) | zzfp.zzc(obj, j10));
    }

    private final void zzE(Object obj, int i10, int i11) {
        zzfp.zzq(obj, zzp(i11) & 1048575, i10);
    }

    private final void zzF(Object obj, int i10, Object obj2) {
        zzb.putObject(obj, zzs(i10) & 1048575, obj2);
        zzD(obj, i10);
    }

    private final void zzG(Object obj, int i10, int i11, Object obj2) {
        zzb.putObject(obj, zzs(i11) & 1048575, obj2);
        zzE(obj, i10, i11);
    }

    private final boolean zzH(Object obj, Object obj2, int i10) {
        if (zzI(obj, i10) == zzI(obj2, i10)) {
            return true;
        }
        return false;
    }

    private final boolean zzI(Object obj, int i10) {
        int zzp = zzp(i10);
        long j10 = zzp & 1048575;
        if (j10 == 1048575) {
            int zzs = zzs(i10);
            long j11 = zzs & 1048575;
            switch (zzr(zzs)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzfp.zza(obj, j11)) == 0) {
                        return false;
                    }
                    return true;
                case 1:
                    if (Float.floatToRawIntBits(zzfp.zzb(obj, j11)) == 0) {
                        return false;
                    }
                    return true;
                case 2:
                    if (zzfp.zzd(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (zzfp.zzd(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (zzfp.zzc(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (zzfp.zzd(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (zzfp.zzc(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return zzfp.zzw(obj, j11);
                case 8:
                    Object zzf = zzfp.zzf(obj, j11);
                    if (zzf instanceof String) {
                        if (((String) zzf).isEmpty()) {
                            return false;
                        }
                        return true;
                    }
                    if (zzf instanceof zzbq) {
                        if (zzbq.zzb.equals(zzf)) {
                            return false;
                        }
                        return true;
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (zzfp.zzf(obj, j11) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    if (zzbq.zzb.equals(zzfp.zzf(obj, j11))) {
                        return false;
                    }
                    return true;
                case 11:
                    if (zzfp.zzc(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (zzfp.zzc(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (zzfp.zzc(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (zzfp.zzd(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (zzfp.zzc(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (zzfp.zzd(obj, j11) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (zzfp.zzf(obj, j11) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        }
        if ((zzfp.zzc(obj, j10) & (1 << (zzp >>> 20))) == 0) {
            return false;
        }
        return true;
    }

    private final boolean zzJ(Object obj, int i10, int i11, int i12, int i13) {
        if (i11 == 1048575) {
            return zzI(obj, i10);
        }
        if ((i12 & i13) != 0) {
            return true;
        }
        return false;
    }

    private static boolean zzK(Object obj, int i10, zzeo zzeoVar) {
        return zzeoVar.zzk(zzfp.zzf(obj, i10 & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzcs) {
            return ((zzcs) obj).zzw();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i10, int i11) {
        if (zzfp.zzc(obj, zzp(i11) & 1048575) == i10) {
            return true;
        }
        return false;
    }

    private static boolean zzN(Object obj, long j10) {
        return ((Boolean) zzfp.zzf(obj, j10)).booleanValue();
    }

    private static final void zzO(int i10, Object obj, zzfx zzfxVar) throws IOException {
        if (obj instanceof String) {
            zzfxVar.zzG(i10, (String) obj);
        } else {
            zzfxVar.zzd(i10, (zzbq) obj);
        }
    }

    static zzfg zzd(Object obj) {
        zzcs zzcsVar = (zzcs) obj;
        zzfg zzfgVar = zzcsVar.zzc;
        if (zzfgVar == zzfg.zzc()) {
            zzfg zzf = zzfg.zzf();
            zzcsVar.zzc = zzf;
            return zzf;
        }
        return zzfgVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x026a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzef zzl(Class cls, zzdz zzdzVar, zzei zzeiVar, zzdq zzdqVar, zzff zzffVar, zzce zzceVar, zzdx zzdxVar) {
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
        zzen zzenVar;
        int i28;
        String str;
        int i29;
        int i30;
        int i31;
        int i32;
        Field zzz;
        char charAt11;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        int i39;
        Object obj;
        Field zzz2;
        Object obj2;
        Field zzz3;
        int i40;
        char charAt12;
        int i41;
        char charAt13;
        int i42;
        char charAt14;
        int i43;
        char charAt15;
        if (zzdzVar instanceof zzen) {
            zzen zzenVar2 = (zzen) zzdzVar;
            String zzd = zzenVar2.zzd();
            int length = zzd.length();
            char c10 = 55296;
            if (zzd.charAt(0) >= 55296) {
                int i44 = 1;
                while (true) {
                    i10 = i44 + 1;
                    if (zzd.charAt(i44) < 55296) {
                        break;
                    }
                    i44 = i10;
                }
            } else {
                i10 = 1;
            }
            int i45 = i10 + 1;
            int charAt16 = zzd.charAt(i10);
            if (charAt16 >= 55296) {
                int i46 = charAt16 & 8191;
                int i47 = 13;
                while (true) {
                    i43 = i45 + 1;
                    charAt15 = zzd.charAt(i45);
                    if (charAt15 < 55296) {
                        break;
                    }
                    i46 |= (charAt15 & 8191) << i47;
                    i47 += 13;
                    i45 = i43;
                }
                charAt16 = i46 | (charAt15 << i47);
                i45 = i43;
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
                int i48 = i45 + 1;
                int charAt17 = zzd.charAt(i45);
                if (charAt17 >= 55296) {
                    int i49 = charAt17 & 8191;
                    int i50 = 13;
                    while (true) {
                        i23 = i48 + 1;
                        charAt10 = zzd.charAt(i48);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i49 |= (charAt10 & 8191) << i50;
                        i50 += 13;
                        i48 = i23;
                    }
                    charAt17 = i49 | (charAt10 << i50);
                    i48 = i23;
                }
                int i51 = i48 + 1;
                int charAt18 = zzd.charAt(i48);
                if (charAt18 >= 55296) {
                    int i52 = charAt18 & 8191;
                    int i53 = 13;
                    while (true) {
                        i22 = i51 + 1;
                        charAt9 = zzd.charAt(i51);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i52 |= (charAt9 & 8191) << i53;
                        i53 += 13;
                        i51 = i22;
                    }
                    charAt18 = i52 | (charAt9 << i53);
                    i51 = i22;
                }
                int i54 = i51 + 1;
                int charAt19 = zzd.charAt(i51);
                if (charAt19 >= 55296) {
                    int i55 = charAt19 & 8191;
                    int i56 = 13;
                    while (true) {
                        i21 = i54 + 1;
                        charAt8 = zzd.charAt(i54);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i55 |= (charAt8 & 8191) << i56;
                        i56 += 13;
                        i54 = i21;
                    }
                    charAt19 = i55 | (charAt8 << i56);
                    i54 = i21;
                }
                int i57 = i54 + 1;
                int charAt20 = zzd.charAt(i54);
                if (charAt20 >= 55296) {
                    int i58 = charAt20 & 8191;
                    int i59 = 13;
                    while (true) {
                        i20 = i57 + 1;
                        charAt7 = zzd.charAt(i57);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i58 |= (charAt7 & 8191) << i59;
                        i59 += 13;
                        i57 = i20;
                    }
                    charAt20 = i58 | (charAt7 << i59);
                    i57 = i20;
                }
                int i60 = i57 + 1;
                charAt = zzd.charAt(i57);
                if (charAt >= 55296) {
                    int i61 = charAt & 8191;
                    int i62 = 13;
                    while (true) {
                        i19 = i60 + 1;
                        charAt6 = zzd.charAt(i60);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i61 |= (charAt6 & 8191) << i62;
                        i62 += 13;
                        i60 = i19;
                    }
                    charAt = i61 | (charAt6 << i62);
                    i60 = i19;
                }
                int i63 = i60 + 1;
                charAt2 = zzd.charAt(i60);
                if (charAt2 >= 55296) {
                    int i64 = charAt2 & 8191;
                    int i65 = 13;
                    while (true) {
                        i18 = i63 + 1;
                        charAt5 = zzd.charAt(i63);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i64 |= (charAt5 & 8191) << i65;
                        i65 += 13;
                        i63 = i18;
                    }
                    charAt2 = i64 | (charAt5 << i65);
                    i63 = i18;
                }
                int i66 = i63 + 1;
                int charAt21 = zzd.charAt(i63);
                if (charAt21 >= 55296) {
                    int i67 = charAt21 & 8191;
                    int i68 = 13;
                    while (true) {
                        i17 = i66 + 1;
                        charAt4 = zzd.charAt(i66);
                        if (charAt4 < 55296) {
                            break;
                        }
                        i67 |= (charAt4 & 8191) << i68;
                        i68 += 13;
                        i66 = i17;
                    }
                    charAt21 = i67 | (charAt4 << i68);
                    i66 = i17;
                }
                int i69 = i66 + 1;
                int charAt22 = zzd.charAt(i66);
                if (charAt22 >= 55296) {
                    int i70 = charAt22 & 8191;
                    int i71 = 13;
                    while (true) {
                        i16 = i69 + 1;
                        charAt3 = zzd.charAt(i69);
                        if (charAt3 < 55296) {
                            break;
                        }
                        i70 |= (charAt3 & 8191) << i71;
                        i71 += 13;
                        i69 = i16;
                    }
                    charAt22 = i70 | (charAt3 << i71);
                    i69 = i16;
                }
                i11 = charAt17 + charAt17 + charAt18;
                iArr = new int[charAt22 + charAt2 + charAt21];
                i12 = charAt19;
                i13 = charAt22;
                i14 = charAt17;
                i15 = charAt20;
                i45 = i69;
            }
            Unsafe unsafe = zzb;
            Object[] zze = zzenVar2.zze();
            Class<?> cls2 = zzenVar2.zza().getClass();
            int i72 = i13 + charAt2;
            int i73 = charAt + charAt;
            int[] iArr2 = new int[charAt * 3];
            Object[] objArr = new Object[i73];
            int i74 = i13;
            int i75 = i72;
            int i76 = 0;
            int i77 = 0;
            while (i45 < length) {
                int i78 = i45 + 1;
                int charAt23 = zzd.charAt(i45);
                if (charAt23 >= c10) {
                    int i79 = charAt23 & 8191;
                    int i80 = i78;
                    int i81 = 13;
                    while (true) {
                        i42 = i80 + 1;
                        charAt14 = zzd.charAt(i80);
                        if (charAt14 < c10) {
                            break;
                        }
                        i79 |= (charAt14 & 8191) << i81;
                        i81 += 13;
                        i80 = i42;
                    }
                    charAt23 = i79 | (charAt14 << i81);
                    i24 = i42;
                } else {
                    i24 = i78;
                }
                int i82 = i24 + 1;
                int charAt24 = zzd.charAt(i24);
                if (charAt24 >= c10) {
                    int i83 = charAt24 & 8191;
                    int i84 = i82;
                    int i85 = 13;
                    while (true) {
                        i41 = i84 + 1;
                        charAt13 = zzd.charAt(i84);
                        if (charAt13 < c10) {
                            break;
                        }
                        i83 |= (charAt13 & 8191) << i85;
                        i85 += 13;
                        i84 = i41;
                    }
                    charAt24 = i83 | (charAt13 << i85);
                    i25 = i41;
                } else {
                    i25 = i82;
                }
                if ((charAt24 & 1024) != 0) {
                    iArr[i76] = i77;
                    i76++;
                }
                int i86 = charAt24 & KotlinVersion.MAX_COMPONENT_VALUE;
                int i87 = charAt24 & 2048;
                int i88 = length;
                if (i86 >= 51) {
                    int i89 = i25 + 1;
                    int charAt25 = zzd.charAt(i25);
                    char c11 = 55296;
                    if (charAt25 >= 55296) {
                        int i90 = 13;
                        int i91 = charAt25 & 8191;
                        int i92 = i89;
                        while (true) {
                            i40 = i92 + 1;
                            charAt12 = zzd.charAt(i92);
                            if (charAt12 < c11) {
                                break;
                            }
                            i91 |= (charAt12 & 8191) << i90;
                            i90 += 13;
                            i92 = i40;
                            c11 = 55296;
                        }
                        charAt25 = i91 | (charAt12 << i90);
                        i38 = i40;
                    } else {
                        i38 = i89;
                    }
                    int i93 = i38;
                    int i94 = i86 - 51;
                    i27 = i15;
                    if (i94 != 9 && i94 != 17) {
                        if (i94 == 12) {
                            if (zzenVar2.zzc() != 1 && i87 == 0) {
                                i87 = 0;
                            } else {
                                i39 = i11 + 1;
                                int i95 = i77 / 3;
                                objArr[i95 + i95 + 1] = zze[i11];
                            }
                        }
                        int i96 = charAt25 + charAt25;
                        obj = zze[i96];
                        if (!(obj instanceof Field)) {
                            zzz2 = (Field) obj;
                        } else {
                            zzz2 = zzz(cls2, (String) obj);
                            zze[i96] = zzz2;
                        }
                        i26 = i12;
                        i32 = (int) unsafe.objectFieldOffset(zzz2);
                        int i97 = i96 + 1;
                        obj2 = zze[i97];
                        if (!(obj2 instanceof Field)) {
                            zzz3 = (Field) obj2;
                        } else {
                            zzz3 = zzz(cls2, (String) obj2);
                            zze[i97] = zzz3;
                        }
                        zzenVar = zzenVar2;
                        str = zzd;
                        i31 = i11;
                        i29 = i93;
                        i28 = (int) unsafe.objectFieldOffset(zzz3);
                        i30 = 0;
                    } else {
                        i39 = i11 + 1;
                        int i98 = i77 / 3;
                        objArr[i98 + i98 + 1] = zze[i11];
                    }
                    i11 = i39;
                    int i962 = charAt25 + charAt25;
                    obj = zze[i962];
                    if (!(obj instanceof Field)) {
                    }
                    i26 = i12;
                    i32 = (int) unsafe.objectFieldOffset(zzz2);
                    int i972 = i962 + 1;
                    obj2 = zze[i972];
                    if (!(obj2 instanceof Field)) {
                    }
                    zzenVar = zzenVar2;
                    str = zzd;
                    i31 = i11;
                    i29 = i93;
                    i28 = (int) unsafe.objectFieldOffset(zzz3);
                    i30 = 0;
                } else {
                    i26 = i12;
                    i27 = i15;
                    int i99 = i11 + 1;
                    Field zzz4 = zzz(cls2, (String) zze[i11]);
                    if (i86 == 9 || i86 == 17) {
                        zzenVar = zzenVar2;
                        int i100 = i77 / 3;
                        objArr[i100 + i100 + 1] = zzz4.getType();
                    } else {
                        if (i86 != 27) {
                            if (i86 == 49) {
                                i34 = i11 + 2;
                                zzenVar = zzenVar2;
                                i33 = 1;
                            } else if (i86 != 12 && i86 != 30 && i86 != 44) {
                                if (i86 == 50) {
                                    int i101 = i11 + 2;
                                    int i102 = i74 + 1;
                                    iArr[i74] = i77;
                                    int i103 = i77 / 3;
                                    int i104 = i103 + i103;
                                    objArr[i104] = zze[i99];
                                    if (i87 != 0) {
                                        i99 = i11 + 3;
                                        objArr[i104 + 1] = zze[i101];
                                        i74 = i102;
                                    } else {
                                        i99 = i101;
                                        i74 = i102;
                                        i87 = 0;
                                    }
                                }
                                zzenVar = zzenVar2;
                            } else {
                                zzenVar = zzenVar2;
                                if (zzenVar2.zzc() != 1 && i87 == 0) {
                                    i87 = 0;
                                } else {
                                    i34 = i11 + 2;
                                    int i105 = i77 / 3;
                                    objArr[i105 + i105 + 1] = zze[i99];
                                    i99 = i34;
                                }
                            }
                        } else {
                            zzenVar = zzenVar2;
                            i33 = 1;
                            i34 = i11 + 2;
                        }
                        int i106 = i77 / 3;
                        objArr[i106 + i106 + i33] = zze[i99];
                        i99 = i34;
                    }
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(zzz4);
                    i28 = 1048575;
                    if ((charAt24 & 4096) != 0 && i86 <= 17) {
                        int i107 = i25 + 1;
                        int charAt26 = zzd.charAt(i25);
                        if (charAt26 >= 55296) {
                            int i108 = charAt26 & 8191;
                            int i109 = 13;
                            while (true) {
                                i29 = i107 + 1;
                                charAt11 = zzd.charAt(i107);
                                if (charAt11 < 55296) {
                                    break;
                                }
                                i108 |= (charAt11 & 8191) << i109;
                                i109 += 13;
                                i107 = i29;
                            }
                            charAt26 = i108 | (charAt11 << i109);
                        } else {
                            i29 = i107;
                        }
                        int i110 = i14 + i14 + (charAt26 / 32);
                        Object obj3 = zze[i110];
                        str = zzd;
                        if (obj3 instanceof Field) {
                            zzz = (Field) obj3;
                        } else {
                            zzz = zzz(cls2, (String) obj3);
                            zze[i110] = zzz;
                        }
                        i30 = charAt26 % 32;
                        i28 = (int) unsafe.objectFieldOffset(zzz);
                    } else {
                        str = zzd;
                        i29 = i25;
                        i30 = 0;
                    }
                    if (i86 >= 18 && i86 <= 49) {
                        iArr[i75] = objectFieldOffset;
                        i75++;
                    }
                    i31 = i99;
                    i32 = objectFieldOffset;
                }
                int i111 = i77 + 1;
                iArr2[i77] = charAt23;
                int i112 = i77 + 2;
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
                if (i87 != 0) {
                    i37 = Integer.MIN_VALUE;
                } else {
                    i37 = 0;
                }
                iArr2[i111] = i32 | i36 | i35 | i37 | (i86 << 20);
                i77 += 3;
                iArr2[i112] = (i30 << 20) | i28;
                i11 = i31;
                i45 = i29;
                length = i88;
                zzenVar2 = zzenVar;
                zzd = str;
                i15 = i27;
                i12 = i26;
                c10 = 55296;
            }
            zzen zzenVar3 = zzenVar2;
            return new zzef(iArr2, objArr, i12, i15, zzenVar3.zza(), zzenVar3.zzc(), false, iArr, i13, i72, zzeiVar, zzdqVar, zzffVar, zzceVar, zzdxVar);
        }
        throw null;
    }

    private static double zzm(Object obj, long j10) {
        return ((Double) zzfp.zzf(obj, j10)).doubleValue();
    }

    private static float zzn(Object obj, long j10) {
        return ((Float) zzfp.zzf(obj, j10)).floatValue();
    }

    private static int zzo(Object obj, long j10) {
        return ((Integer) zzfp.zzf(obj, j10)).intValue();
    }

    private final int zzp(int i10) {
        return this.zzc[i10 + 2];
    }

    private final int zzq(int i10, int i11) {
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

    private static int zzr(int i10) {
        return (i10 >>> 20) & KotlinVersion.MAX_COMPONENT_VALUE;
    }

    private final int zzs(int i10) {
        return this.zzc[i10 + 1];
    }

    private static long zzt(Object obj, long j10) {
        return ((Long) zzfp.zzf(obj, j10)).longValue();
    }

    private final zzcw zzu(int i10) {
        int i11 = i10 / 3;
        return (zzcw) this.zzd[i11 + i11 + 1];
    }

    private final zzeo zzv(int i10) {
        Object[] objArr = this.zzd;
        int i11 = i10 / 3;
        int i12 = i11 + i11;
        zzeo zzeoVar = (zzeo) objArr[i12];
        if (zzeoVar != null) {
            return zzeoVar;
        }
        zzeo zzb2 = zzel.zza().zzb((Class) objArr[i12 + 1]);
        this.zzd[i12] = zzb2;
        return zzb2;
    }

    private final Object zzw(int i10) {
        int i11 = i10 / 3;
        return this.zzd[i11 + i11];
    }

    private final Object zzx(Object obj, int i10) {
        zzeo zzv = zzv(i10);
        int zzs = zzs(i10) & 1048575;
        if (!zzI(obj, i10)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzy(Object obj, int i10, int i11) {
        zzeo zzv = zzv(i11);
        if (!zzM(obj, i10, i11)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i11) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    private static Field zzz(Class cls, String str) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0058. Please report as an issue. */
    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final int zza(Object obj) {
        int i10;
        int i11;
        int i12;
        int zzw;
        int zzw2;
        int zzw3;
        int zzx;
        int zzw4;
        int zzw5;
        int zzd;
        int zzw6;
        int zzh;
        int zzg;
        int size;
        int zzw7;
        int zzw8;
        int zzw9;
        int zze;
        int zzw10;
        int zzw11;
        int i13;
        Unsafe unsafe = zzb;
        boolean z10 = false;
        int i14 = 1048575;
        int i15 = 1048575;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i17 < this.zzc.length) {
            int zzs = zzs(i17);
            int zzr = zzr(zzs);
            int[] iArr = this.zzc;
            int i19 = iArr[i17];
            int i20 = iArr[i17 + 2];
            int i21 = i20 & i14;
            if (zzr <= 17) {
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
            int i22 = zzs & i14;
            if (zzr >= zzcj.zzJ.zza()) {
                zzcj.zzW.zza();
            }
            long j10 = i22;
            switch (zzr) {
                case 0:
                    if (zzJ(obj, i17, i10, i11, i12)) {
                        zzw = zzby.zzw(i19 << 3);
                        zzh = zzw + 8;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 1:
                    if (zzJ(obj, i17, i10, i11, i12)) {
                        zzw2 = zzby.zzw(i19 << 3);
                        zzh = zzw2 + 4;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 2:
                    if (zzJ(obj, i17, i10, i11, i12)) {
                        long j11 = unsafe.getLong(obj, j10);
                        zzw3 = zzby.zzw(i19 << 3);
                        zzx = zzby.zzx(j11);
                        zzh = zzw3 + zzx;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 3:
                    if (zzJ(obj, i17, i10, i11, i12)) {
                        long j12 = unsafe.getLong(obj, j10);
                        zzw3 = zzby.zzw(i19 << 3);
                        zzx = zzby.zzx(j12);
                        zzh = zzw3 + zzx;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 4:
                    if (zzJ(obj, i17, i10, i11, i12)) {
                        long j13 = unsafe.getInt(obj, j10);
                        zzw3 = zzby.zzw(i19 << 3);
                        zzx = zzby.zzx(j13);
                        zzh = zzw3 + zzx;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 5:
                    if (zzJ(obj, i17, i10, i11, i12)) {
                        zzw = zzby.zzw(i19 << 3);
                        zzh = zzw + 8;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 6:
                    if (zzJ(obj, i17, i10, i11, i12)) {
                        zzw2 = zzby.zzw(i19 << 3);
                        zzh = zzw2 + 4;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 7:
                    if (zzJ(obj, i17, i10, i11, i12)) {
                        zzw4 = zzby.zzw(i19 << 3);
                        zzh = zzw4 + 1;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 8:
                    if (zzJ(obj, i17, i10, i11, i12)) {
                        int i23 = i19 << 3;
                        Object object = unsafe.getObject(obj, j10);
                        if (object instanceof zzbq) {
                            zzw5 = zzby.zzw(i23);
                            zzd = ((zzbq) object).zzd();
                            zzw6 = zzby.zzw(zzd);
                            zzh = zzw5 + zzw6 + zzd;
                            i18 += zzh;
                            i17 += 3;
                            i15 = i10;
                            i16 = i11;
                            z10 = false;
                            i14 = 1048575;
                        } else {
                            zzw3 = zzby.zzw(i23);
                            zzx = zzby.zzv((String) object);
                            zzh = zzw3 + zzx;
                            i18 += zzh;
                            i17 += 3;
                            i15 = i10;
                            i16 = i11;
                            z10 = false;
                            i14 = 1048575;
                        }
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 9:
                    if (zzJ(obj, i17, i10, i11, i12)) {
                        zzh = zzeq.zzh(i19, unsafe.getObject(obj, j10), zzv(i17));
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 10:
                    if (zzJ(obj, i17, i10, i11, i12)) {
                        zzbq zzbqVar = (zzbq) unsafe.getObject(obj, j10);
                        zzw5 = zzby.zzw(i19 << 3);
                        zzd = zzbqVar.zzd();
                        zzw6 = zzby.zzw(zzd);
                        zzh = zzw5 + zzw6 + zzd;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 11:
                    if (zzJ(obj, i17, i10, i11, i12)) {
                        int i24 = unsafe.getInt(obj, j10);
                        zzw3 = zzby.zzw(i19 << 3);
                        zzx = zzby.zzw(i24);
                        zzh = zzw3 + zzx;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 12:
                    if (zzJ(obj, i17, i10, i11, i12)) {
                        long j14 = unsafe.getInt(obj, j10);
                        zzw3 = zzby.zzw(i19 << 3);
                        zzx = zzby.zzx(j14);
                        zzh = zzw3 + zzx;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 13:
                    if (zzJ(obj, i17, i10, i11, i12)) {
                        zzw2 = zzby.zzw(i19 << 3);
                        zzh = zzw2 + 4;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 14:
                    if (zzJ(obj, i17, i10, i11, i12)) {
                        zzw = zzby.zzw(i19 << 3);
                        zzh = zzw + 8;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 15:
                    if (zzJ(obj, i17, i10, i11, i12)) {
                        int i25 = unsafe.getInt(obj, j10);
                        zzw3 = zzby.zzw(i19 << 3);
                        zzx = zzby.zzw((i25 >> 31) ^ (i25 + i25));
                        zzh = zzw3 + zzx;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 16:
                    if (zzJ(obj, i17, i10, i11, i12)) {
                        long j15 = unsafe.getLong(obj, j10);
                        zzw3 = zzby.zzw(i19 << 3);
                        zzx = zzby.zzx((j15 >> 63) ^ (j15 + j15));
                        zzh = zzw3 + zzx;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 17:
                    if (zzJ(obj, i17, i10, i11, i12)) {
                        zzh = zzby.zzt(i19, (zzec) unsafe.getObject(obj, j10), zzv(i17));
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 18:
                    zzh = zzeq.zzd(i19, (List) unsafe.getObject(obj, j10), z10);
                    i18 += zzh;
                    i17 += 3;
                    i15 = i10;
                    i16 = i11;
                    z10 = false;
                    i14 = 1048575;
                case 19:
                    zzh = zzeq.zzb(i19, (List) unsafe.getObject(obj, j10), z10);
                    i18 += zzh;
                    i17 += 3;
                    i15 = i10;
                    i16 = i11;
                    z10 = false;
                    i14 = 1048575;
                case 20:
                    List list = (List) unsafe.getObject(obj, j10);
                    int i26 = zzeq.zza;
                    if (list.size() != 0) {
                        zzg = zzeq.zzg(list) + (list.size() * zzby.zzw(i19 << 3));
                        i18 += zzg;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                    zzg = 0;
                    i18 += zzg;
                    i17 += 3;
                    i15 = i10;
                    i16 = i11;
                    z10 = false;
                    i14 = 1048575;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j10);
                    int i27 = zzeq.zza;
                    size = list2.size();
                    if (size != 0) {
                        zzw3 = zzeq.zzl(list2);
                        zzw7 = zzby.zzw(i19 << 3);
                        zzx = size * zzw7;
                        zzh = zzw3 + zzx;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                    zzh = 0;
                    i18 += zzh;
                    i17 += 3;
                    i15 = i10;
                    i16 = i11;
                    z10 = false;
                    i14 = 1048575;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j10);
                    int i28 = zzeq.zza;
                    size = list3.size();
                    if (size != 0) {
                        zzw3 = zzeq.zzf(list3);
                        zzw7 = zzby.zzw(i19 << 3);
                        zzx = size * zzw7;
                        zzh = zzw3 + zzx;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                    zzh = 0;
                    i18 += zzh;
                    i17 += 3;
                    i15 = i10;
                    i16 = i11;
                    z10 = false;
                    i14 = 1048575;
                case 23:
                    zzh = zzeq.zzd(i19, (List) unsafe.getObject(obj, j10), z10);
                    i18 += zzh;
                    i17 += 3;
                    i15 = i10;
                    i16 = i11;
                    z10 = false;
                    i14 = 1048575;
                case 24:
                    zzh = zzeq.zzb(i19, (List) unsafe.getObject(obj, j10), z10);
                    i18 += zzh;
                    i17 += 3;
                    i15 = i10;
                    i16 = i11;
                    z10 = false;
                    i14 = 1048575;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j10);
                    int i29 = zzeq.zza;
                    int size2 = list4.size();
                    if (size2 != 0) {
                        zzh = size2 * (zzby.zzw(i19 << 3) + 1);
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                    zzh = 0;
                    i18 += zzh;
                    i17 += 3;
                    i15 = i10;
                    i16 = i11;
                    z10 = false;
                    i14 = 1048575;
                case 26:
                    List list5 = (List) unsafe.getObject(obj, j10);
                    int i30 = zzeq.zza;
                    int size3 = list5.size();
                    if (size3 != 0) {
                        zzg = zzby.zzw(i19 << 3) * size3;
                        if (list5 instanceof zzdk) {
                            zzdk zzdkVar = (zzdk) list5;
                            for (int i31 = 0; i31 < size3; i31++) {
                                Object zzf = zzdkVar.zzf(i31);
                                if (zzf instanceof zzbq) {
                                    int zzd2 = ((zzbq) zzf).zzd();
                                    zzg += zzby.zzw(zzd2) + zzd2;
                                } else {
                                    zzg += zzby.zzv((String) zzf);
                                }
                            }
                        } else {
                            for (int i32 = 0; i32 < size3; i32++) {
                                Object obj2 = list5.get(i32);
                                if (obj2 instanceof zzbq) {
                                    int zzd3 = ((zzbq) obj2).zzd();
                                    zzg += zzby.zzw(zzd3) + zzd3;
                                } else {
                                    zzg += zzby.zzv((String) obj2);
                                }
                            }
                        }
                        i18 += zzg;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                    zzg = 0;
                    i18 += zzg;
                    i17 += 3;
                    i15 = i10;
                    i16 = i11;
                    z10 = false;
                    i14 = 1048575;
                case 27:
                    List list6 = (List) unsafe.getObject(obj, j10);
                    zzeo zzv = zzv(i17);
                    int i33 = zzeq.zza;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        zzw8 = 0;
                    } else {
                        zzw8 = zzby.zzw(i19 << 3) * size4;
                        for (int i34 = 0; i34 < size4; i34++) {
                            Object obj3 = list6.get(i34);
                            if (obj3 instanceof zzdi) {
                                int zza2 = ((zzdi) obj3).zza();
                                zzw8 += zzby.zzw(zza2) + zza2;
                            } else {
                                zzw8 += zzby.zzu((zzec) obj3, zzv);
                            }
                        }
                    }
                    i18 += zzw8;
                    i17 += 3;
                    i15 = i10;
                    i16 = i11;
                    z10 = false;
                    i14 = 1048575;
                case 28:
                    List list7 = (List) unsafe.getObject(obj, j10);
                    int i35 = zzeq.zza;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        zzw9 = 0;
                    } else {
                        zzw9 = size5 * zzby.zzw(i19 << 3);
                        for (int i36 = 0; i36 < list7.size(); i36++) {
                            int zzd4 = ((zzbq) list7.get(i36)).zzd();
                            zzw9 += zzby.zzw(zzd4) + zzd4;
                        }
                    }
                    i18 += zzw9;
                    i17 += 3;
                    i15 = i10;
                    i16 = i11;
                    z10 = false;
                    i14 = 1048575;
                case 29:
                    List list8 = (List) unsafe.getObject(obj, j10);
                    int i37 = zzeq.zza;
                    size = list8.size();
                    if (size != 0) {
                        zzw3 = zzeq.zzk(list8);
                        zzw7 = zzby.zzw(i19 << 3);
                        zzx = size * zzw7;
                        zzh = zzw3 + zzx;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                    zzh = 0;
                    i18 += zzh;
                    i17 += 3;
                    i15 = i10;
                    i16 = i11;
                    z10 = false;
                    i14 = 1048575;
                case 30:
                    List list9 = (List) unsafe.getObject(obj, j10);
                    int i38 = zzeq.zza;
                    size = list9.size();
                    if (size != 0) {
                        zzw3 = zzeq.zza(list9);
                        zzw7 = zzby.zzw(i19 << 3);
                        zzx = size * zzw7;
                        zzh = zzw3 + zzx;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                    zzh = 0;
                    i18 += zzh;
                    i17 += 3;
                    i15 = i10;
                    i16 = i11;
                    z10 = false;
                    i14 = 1048575;
                case 31:
                    zzh = zzeq.zzb(i19, (List) unsafe.getObject(obj, j10), z10);
                    i18 += zzh;
                    i17 += 3;
                    i15 = i10;
                    i16 = i11;
                    z10 = false;
                    i14 = 1048575;
                case 32:
                    zzh = zzeq.zzd(i19, (List) unsafe.getObject(obj, j10), z10);
                    i18 += zzh;
                    i17 += 3;
                    i15 = i10;
                    i16 = i11;
                    z10 = false;
                    i14 = 1048575;
                case 33:
                    List list10 = (List) unsafe.getObject(obj, j10);
                    int i39 = zzeq.zza;
                    size = list10.size();
                    if (size != 0) {
                        zzw3 = zzeq.zzi(list10);
                        zzw7 = zzby.zzw(i19 << 3);
                        zzx = size * zzw7;
                        zzh = zzw3 + zzx;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                    zzh = 0;
                    i18 += zzh;
                    i17 += 3;
                    i15 = i10;
                    i16 = i11;
                    z10 = false;
                    i14 = 1048575;
                case 34:
                    List list11 = (List) unsafe.getObject(obj, j10);
                    int i40 = zzeq.zza;
                    size = list11.size();
                    if (size != 0) {
                        zzw3 = zzeq.zzj(list11);
                        zzw7 = zzby.zzw(i19 << 3);
                        zzx = size * zzw7;
                        zzh = zzw3 + zzx;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                    zzh = 0;
                    i18 += zzh;
                    i17 += 3;
                    i15 = i10;
                    i16 = i11;
                    z10 = false;
                    i14 = 1048575;
                case 35:
                    zze = zzeq.zze((List) unsafe.getObject(obj, j10));
                    if (zze > 0) {
                        zzw10 = zzby.zzw(i19 << 3);
                        zzw11 = zzby.zzw(zze);
                        zzw9 = zzw10 + zzw11 + zze;
                        i18 += zzw9;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 36:
                    zze = zzeq.zzc((List) unsafe.getObject(obj, j10));
                    if (zze > 0) {
                        zzw10 = zzby.zzw(i19 << 3);
                        zzw11 = zzby.zzw(zze);
                        zzw9 = zzw10 + zzw11 + zze;
                        i18 += zzw9;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 37:
                    zze = zzeq.zzg((List) unsafe.getObject(obj, j10));
                    if (zze > 0) {
                        zzw10 = zzby.zzw(i19 << 3);
                        zzw11 = zzby.zzw(zze);
                        zzw9 = zzw10 + zzw11 + zze;
                        i18 += zzw9;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 38:
                    zze = zzeq.zzl((List) unsafe.getObject(obj, j10));
                    if (zze > 0) {
                        zzw10 = zzby.zzw(i19 << 3);
                        zzw11 = zzby.zzw(zze);
                        zzw9 = zzw10 + zzw11 + zze;
                        i18 += zzw9;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 39:
                    zze = zzeq.zzf((List) unsafe.getObject(obj, j10));
                    if (zze > 0) {
                        zzw10 = zzby.zzw(i19 << 3);
                        zzw11 = zzby.zzw(zze);
                        zzw9 = zzw10 + zzw11 + zze;
                        i18 += zzw9;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 40:
                    zze = zzeq.zze((List) unsafe.getObject(obj, j10));
                    if (zze > 0) {
                        zzw10 = zzby.zzw(i19 << 3);
                        zzw11 = zzby.zzw(zze);
                        zzw9 = zzw10 + zzw11 + zze;
                        i18 += zzw9;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 41:
                    zze = zzeq.zzc((List) unsafe.getObject(obj, j10));
                    if (zze > 0) {
                        zzw10 = zzby.zzw(i19 << 3);
                        zzw11 = zzby.zzw(zze);
                        zzw9 = zzw10 + zzw11 + zze;
                        i18 += zzw9;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 42:
                    List list12 = (List) unsafe.getObject(obj, j10);
                    int i41 = zzeq.zza;
                    zze = list12.size();
                    if (zze > 0) {
                        zzw10 = zzby.zzw(i19 << 3);
                        zzw11 = zzby.zzw(zze);
                        zzw9 = zzw10 + zzw11 + zze;
                        i18 += zzw9;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 43:
                    zze = zzeq.zzk((List) unsafe.getObject(obj, j10));
                    if (zze > 0) {
                        zzw10 = zzby.zzw(i19 << 3);
                        zzw11 = zzby.zzw(zze);
                        zzw9 = zzw10 + zzw11 + zze;
                        i18 += zzw9;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 44:
                    zze = zzeq.zza((List) unsafe.getObject(obj, j10));
                    if (zze > 0) {
                        zzw10 = zzby.zzw(i19 << 3);
                        zzw11 = zzby.zzw(zze);
                        zzw9 = zzw10 + zzw11 + zze;
                        i18 += zzw9;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 45:
                    zze = zzeq.zzc((List) unsafe.getObject(obj, j10));
                    if (zze > 0) {
                        zzw10 = zzby.zzw(i19 << 3);
                        zzw11 = zzby.zzw(zze);
                        zzw9 = zzw10 + zzw11 + zze;
                        i18 += zzw9;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 46:
                    zze = zzeq.zze((List) unsafe.getObject(obj, j10));
                    if (zze > 0) {
                        zzw10 = zzby.zzw(i19 << 3);
                        zzw11 = zzby.zzw(zze);
                        zzw9 = zzw10 + zzw11 + zze;
                        i18 += zzw9;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 47:
                    zze = zzeq.zzi((List) unsafe.getObject(obj, j10));
                    if (zze > 0) {
                        zzw10 = zzby.zzw(i19 << 3);
                        zzw11 = zzby.zzw(zze);
                        zzw9 = zzw10 + zzw11 + zze;
                        i18 += zzw9;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 48:
                    zze = zzeq.zzj((List) unsafe.getObject(obj, j10));
                    if (zze > 0) {
                        zzw10 = zzby.zzw(i19 << 3);
                        zzw11 = zzby.zzw(zze);
                        zzw9 = zzw10 + zzw11 + zze;
                        i18 += zzw9;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 49:
                    List list13 = (List) unsafe.getObject(obj, j10);
                    zzeo zzv2 = zzv(i17);
                    int i42 = zzeq.zza;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        i13 = 0;
                    } else {
                        i13 = 0;
                        for (int i43 = 0; i43 < size6; i43++) {
                            i13 += zzby.zzt(i19, (zzec) list13.get(i43), zzv2);
                        }
                    }
                    i18 += i13;
                    i17 += 3;
                    i15 = i10;
                    i16 = i11;
                    z10 = false;
                    i14 = 1048575;
                case 50:
                    zzdw zzdwVar = (zzdw) unsafe.getObject(obj, j10);
                    if (zzdwVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzdwVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i17 += 3;
                    i15 = i10;
                    i16 = i11;
                    z10 = false;
                    i14 = 1048575;
                case 51:
                    if (zzM(obj, i19, i17)) {
                        zzw = zzby.zzw(i19 << 3);
                        zzh = zzw + 8;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 52:
                    if (zzM(obj, i19, i17)) {
                        zzw2 = zzby.zzw(i19 << 3);
                        zzh = zzw2 + 4;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 53:
                    if (zzM(obj, i19, i17)) {
                        long zzt = zzt(obj, j10);
                        zzw3 = zzby.zzw(i19 << 3);
                        zzx = zzby.zzx(zzt);
                        zzh = zzw3 + zzx;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 54:
                    if (zzM(obj, i19, i17)) {
                        long zzt2 = zzt(obj, j10);
                        zzw3 = zzby.zzw(i19 << 3);
                        zzx = zzby.zzx(zzt2);
                        zzh = zzw3 + zzx;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 55:
                    if (zzM(obj, i19, i17)) {
                        long zzo = zzo(obj, j10);
                        zzw3 = zzby.zzw(i19 << 3);
                        zzx = zzby.zzx(zzo);
                        zzh = zzw3 + zzx;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 56:
                    if (zzM(obj, i19, i17)) {
                        zzw = zzby.zzw(i19 << 3);
                        zzh = zzw + 8;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 57:
                    if (zzM(obj, i19, i17)) {
                        zzw2 = zzby.zzw(i19 << 3);
                        zzh = zzw2 + 4;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 58:
                    if (zzM(obj, i19, i17)) {
                        zzw4 = zzby.zzw(i19 << 3);
                        zzh = zzw4 + 1;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 59:
                    if (zzM(obj, i19, i17)) {
                        int i44 = i19 << 3;
                        Object object2 = unsafe.getObject(obj, j10);
                        if (object2 instanceof zzbq) {
                            zzw5 = zzby.zzw(i44);
                            zzd = ((zzbq) object2).zzd();
                            zzw6 = zzby.zzw(zzd);
                            zzh = zzw5 + zzw6 + zzd;
                            i18 += zzh;
                            i17 += 3;
                            i15 = i10;
                            i16 = i11;
                            z10 = false;
                            i14 = 1048575;
                        } else {
                            zzw3 = zzby.zzw(i44);
                            zzx = zzby.zzv((String) object2);
                            zzh = zzw3 + zzx;
                            i18 += zzh;
                            i17 += 3;
                            i15 = i10;
                            i16 = i11;
                            z10 = false;
                            i14 = 1048575;
                        }
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 60:
                    if (zzM(obj, i19, i17)) {
                        zzh = zzeq.zzh(i19, unsafe.getObject(obj, j10), zzv(i17));
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 61:
                    if (zzM(obj, i19, i17)) {
                        zzbq zzbqVar2 = (zzbq) unsafe.getObject(obj, j10);
                        zzw5 = zzby.zzw(i19 << 3);
                        zzd = zzbqVar2.zzd();
                        zzw6 = zzby.zzw(zzd);
                        zzh = zzw5 + zzw6 + zzd;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 62:
                    if (zzM(obj, i19, i17)) {
                        int zzo2 = zzo(obj, j10);
                        zzw3 = zzby.zzw(i19 << 3);
                        zzx = zzby.zzw(zzo2);
                        zzh = zzw3 + zzx;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 63:
                    if (zzM(obj, i19, i17)) {
                        long zzo3 = zzo(obj, j10);
                        zzw3 = zzby.zzw(i19 << 3);
                        zzx = zzby.zzx(zzo3);
                        zzh = zzw3 + zzx;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 64:
                    if (zzM(obj, i19, i17)) {
                        zzw2 = zzby.zzw(i19 << 3);
                        zzh = zzw2 + 4;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 65:
                    if (zzM(obj, i19, i17)) {
                        zzw = zzby.zzw(i19 << 3);
                        zzh = zzw + 8;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 66:
                    if (zzM(obj, i19, i17)) {
                        int zzo4 = zzo(obj, j10);
                        zzw3 = zzby.zzw(i19 << 3);
                        zzx = zzby.zzw((zzo4 >> 31) ^ (zzo4 + zzo4));
                        zzh = zzw3 + zzx;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 67:
                    if (zzM(obj, i19, i17)) {
                        long zzt3 = zzt(obj, j10);
                        zzw3 = zzby.zzw(i19 << 3);
                        zzx = zzby.zzx((zzt3 >> 63) ^ (zzt3 + zzt3));
                        zzh = zzw3 + zzx;
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                case 68:
                    if (zzM(obj, i19, i17)) {
                        zzh = zzby.zzt(i19, (zzec) unsafe.getObject(obj, j10), zzv(i17));
                        i18 += zzh;
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    } else {
                        i17 += 3;
                        i15 = i10;
                        i16 = i11;
                        z10 = false;
                        i14 = 1048575;
                    }
                default:
                    i17 += 3;
                    i15 = i10;
                    i16 = i11;
                    z10 = false;
                    i14 = 1048575;
            }
        }
        zzff zzffVar = this.zzm;
        int zza3 = i18 + zzffVar.zza(zzffVar.zzd(obj));
        if (!this.zzh) {
            return zza3;
        }
        zzci zzb2 = this.zzn.zzb(obj);
        int i45 = 0;
        for (int i46 = 0; i46 < zzb2.zza.zzb(); i46++) {
            Map.Entry zzg2 = zzb2.zza.zzg(i46);
            i45 += zzci.zzb((zzch) zzg2.getKey(), zzg2.getValue());
        }
        for (Map.Entry entry2 : zzb2.zza.zzc()) {
            i45 += zzci.zzb((zzch) entry2.getKey(), entry2.getValue());
        }
        return zza3 + i45;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001c. Please report as an issue. */
    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final int zzb(Object obj) {
        int i10;
        long doubleToLongBits;
        int i11;
        int floatToIntBits;
        int i12;
        int i13 = 0;
        for (int i14 = 0; i14 < this.zzc.length; i14 += 3) {
            int zzs = zzs(i14);
            int[] iArr = this.zzc;
            int i15 = 1048575 & zzs;
            int zzr = zzr(zzs);
            int i16 = iArr[i14];
            long j10 = i15;
            int i17 = 37;
            switch (zzr) {
                case 0:
                    i10 = i13 * 53;
                    doubleToLongBits = Double.doubleToLongBits(zzfp.zza(obj, j10));
                    byte[] bArr = zzda.zzd;
                    i13 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 1:
                    i11 = i13 * 53;
                    floatToIntBits = Float.floatToIntBits(zzfp.zzb(obj, j10));
                    i13 = i11 + floatToIntBits;
                    break;
                case 2:
                    i10 = i13 * 53;
                    doubleToLongBits = zzfp.zzd(obj, j10);
                    byte[] bArr2 = zzda.zzd;
                    i13 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 3:
                    i10 = i13 * 53;
                    doubleToLongBits = zzfp.zzd(obj, j10);
                    byte[] bArr3 = zzda.zzd;
                    i13 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 4:
                    i11 = i13 * 53;
                    floatToIntBits = zzfp.zzc(obj, j10);
                    i13 = i11 + floatToIntBits;
                    break;
                case 5:
                    i10 = i13 * 53;
                    doubleToLongBits = zzfp.zzd(obj, j10);
                    byte[] bArr4 = zzda.zzd;
                    i13 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 6:
                    i11 = i13 * 53;
                    floatToIntBits = zzfp.zzc(obj, j10);
                    i13 = i11 + floatToIntBits;
                    break;
                case 7:
                    i11 = i13 * 53;
                    floatToIntBits = zzda.zza(zzfp.zzw(obj, j10));
                    i13 = i11 + floatToIntBits;
                    break;
                case 8:
                    i11 = i13 * 53;
                    floatToIntBits = ((String) zzfp.zzf(obj, j10)).hashCode();
                    i13 = i11 + floatToIntBits;
                    break;
                case 9:
                    i12 = i13 * 53;
                    Object zzf = zzfp.zzf(obj, j10);
                    if (zzf != null) {
                        i17 = zzf.hashCode();
                    }
                    i13 = i12 + i17;
                    break;
                case 10:
                    i11 = i13 * 53;
                    floatToIntBits = zzfp.zzf(obj, j10).hashCode();
                    i13 = i11 + floatToIntBits;
                    break;
                case 11:
                    i11 = i13 * 53;
                    floatToIntBits = zzfp.zzc(obj, j10);
                    i13 = i11 + floatToIntBits;
                    break;
                case 12:
                    i11 = i13 * 53;
                    floatToIntBits = zzfp.zzc(obj, j10);
                    i13 = i11 + floatToIntBits;
                    break;
                case 13:
                    i11 = i13 * 53;
                    floatToIntBits = zzfp.zzc(obj, j10);
                    i13 = i11 + floatToIntBits;
                    break;
                case 14:
                    i10 = i13 * 53;
                    doubleToLongBits = zzfp.zzd(obj, j10);
                    byte[] bArr5 = zzda.zzd;
                    i13 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 15:
                    i11 = i13 * 53;
                    floatToIntBits = zzfp.zzc(obj, j10);
                    i13 = i11 + floatToIntBits;
                    break;
                case 16:
                    i10 = i13 * 53;
                    doubleToLongBits = zzfp.zzd(obj, j10);
                    byte[] bArr6 = zzda.zzd;
                    i13 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 17:
                    i12 = i13 * 53;
                    Object zzf2 = zzfp.zzf(obj, j10);
                    if (zzf2 != null) {
                        i17 = zzf2.hashCode();
                    }
                    i13 = i12 + i17;
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
                    i11 = i13 * 53;
                    floatToIntBits = zzfp.zzf(obj, j10).hashCode();
                    i13 = i11 + floatToIntBits;
                    break;
                case 50:
                    i11 = i13 * 53;
                    floatToIntBits = zzfp.zzf(obj, j10).hashCode();
                    i13 = i11 + floatToIntBits;
                    break;
                case 51:
                    if (zzM(obj, i16, i14)) {
                        i10 = i13 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzm(obj, j10));
                        byte[] bArr7 = zzda.zzd;
                        i13 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = Float.floatToIntBits(zzn(obj, j10));
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzM(obj, i16, i14)) {
                        i10 = i13 * 53;
                        doubleToLongBits = zzt(obj, j10);
                        byte[] bArr8 = zzda.zzd;
                        i13 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzM(obj, i16, i14)) {
                        i10 = i13 * 53;
                        doubleToLongBits = zzt(obj, j10);
                        byte[] bArr9 = zzda.zzd;
                        i13 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzo(obj, j10);
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzM(obj, i16, i14)) {
                        i10 = i13 * 53;
                        doubleToLongBits = zzt(obj, j10);
                        byte[] bArr10 = zzda.zzd;
                        i13 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzo(obj, j10);
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzda.zza(zzN(obj, j10));
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = ((String) zzfp.zzf(obj, j10)).hashCode();
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzfp.zzf(obj, j10).hashCode();
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzfp.zzf(obj, j10).hashCode();
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzo(obj, j10);
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzo(obj, j10);
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzo(obj, j10);
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzM(obj, i16, i14)) {
                        i10 = i13 * 53;
                        doubleToLongBits = zzt(obj, j10);
                        byte[] bArr11 = zzda.zzd;
                        i13 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzo(obj, j10);
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzM(obj, i16, i14)) {
                        i10 = i13 * 53;
                        doubleToLongBits = zzt(obj, j10);
                        byte[] bArr12 = zzda.zzd;
                        i13 = i10 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzfp.zzf(obj, j10).hashCode();
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i13 * 53) + this.zzm.zzd(obj).hashCode();
        if (this.zzh) {
            return (hashCode * 53) + this.zzn.zzb(obj).zza.hashCode();
        }
        return hashCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0e70, code lost:
    
        if (r0 == r11) goto L٥٦٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0e72, code lost:
    
        r36.putInt(r7, r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0e78, code lost:
    
        r0 = r13.zzj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0e7c, code lost:
    
        if (r0 >= r13.zzk) goto L٦٥٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0e7e, code lost:
    
        r1 = r13.zzi;
        r3 = r13.zzc;
        r1 = r1[r0];
        r3 = r3[r1];
        r3 = com.google.android.gms.internal.play_billing.zzfp.zzf(r7, r13.zzs(r1) & r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0e90, code lost:
    
        if (r3 != null) goto L٥٦٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0e9b, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0e98, code lost:
    
        if (r13.zzu(r1) != null) goto L٦٥٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0e9d, code lost:
    
        r3 = (com.google.android.gms.internal.play_billing.zzdw) r3;
        r0 = (com.google.android.gms.internal.play_billing.zzdv) r13.zzw(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0ea5, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0ea6, code lost:
    
        if (r9 != 0) goto L٥٨٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0ea8, code lost:
    
        if (r8 != r14) goto L٥٧٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0eaf, code lost:
    
        throw com.google.android.gms.internal.play_billing.zzdc.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0eb4, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0eb0, code lost:
    
        if (r8 > r14) goto L٥٨٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0eb2, code lost:
    
        if (r2 != r9) goto L٥٨٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0eb9, code lost:
    
        throw com.google.android.gms.internal.play_billing.zzdc.zze();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x0535. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:445:0x0b7b. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:543:0x00bc. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0af8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:449:0x0de9  */
    /* JADX WARN: Removed duplicated region for block: B:450:0x0dfd  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0b10 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:604:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:704:0x0055 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzc(Object obj, byte[] bArr, int i10, int i11, int i12, zzbc zzbcVar) throws IOException {
        zzef<T> zzefVar;
        int i13;
        Unsafe unsafe;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int zzq;
        zzbc zzbcVar2;
        byte[] bArr2;
        int i20;
        int i21;
        int i22;
        int zzg;
        zzcd zzcdVar;
        int i23;
        int i24;
        int i25;
        int i26;
        Unsafe unsafe2;
        int i27;
        int i28;
        zzbc zzbcVar3;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        zzbc zzbcVar4;
        zzef<T> zzefVar2;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        int i39;
        int i40;
        int i41;
        zzbc zzbcVar5;
        int zzh;
        zzbc zzbcVar6;
        int i42;
        zzef<T> zzefVar3;
        int i43;
        int i44;
        int i45;
        int i46;
        int i47;
        int zzf;
        int zzh2;
        zzcz zzczVar;
        int i48;
        int i49;
        byte[] bArr3;
        int i50;
        int zzj;
        int i51;
        int i52;
        int i53;
        zzef<T> zzefVar4 = this;
        Object obj2 = obj;
        byte[] bArr4 = bArr;
        int i54 = i11;
        int i55 = i12;
        zzbc zzbcVar7 = zzbcVar;
        int i56 = 3;
        zzA(obj);
        Unsafe unsafe3 = zzb;
        int i57 = 0;
        int i58 = -1;
        int i59 = i10;
        int i60 = -1;
        int i61 = 0;
        int i62 = 1048575;
        int i63 = 0;
        int i64 = 0;
        while (true) {
            if (i59 < i54) {
                int i65 = i59 + 1;
                int i66 = bArr4[i59];
                if (i66 < 0) {
                    i65 = zzbd.zzi(i66, bArr4, i65, zzbcVar7);
                    i66 = zzbcVar7.zza;
                }
                int i67 = (i66 == true ? 1 : 0) >>> 3;
                if (i67 > i60) {
                    zzq = (i67 < zzefVar4.zze || i67 > zzefVar4.zzf) ? -1 : zzefVar4.zzq(i67, i61 / i56);
                } else if (i67 < zzefVar4.zze || i67 > zzefVar4.zzf) {
                    i19 = -1;
                    if (i19 != i58) {
                        zzefVar = zzefVar4;
                        zzbcVar2 = zzbcVar7;
                        i13 = i55;
                        unsafe = unsafe3;
                        bArr2 = bArr4;
                        i20 = i62;
                        i61 = 0;
                        i21 = i65;
                        i15 = i54;
                        i22 = i67;
                    } else {
                        boolean z10 = (i66 == true ? 1 : 0) & 7;
                        int[] iArr = zzefVar4.zzc;
                        int i68 = iArr[i19 + 1];
                        int zzr = zzr(i68);
                        long j10 = i68 & 1048575;
                        int i69 = i66 == true ? 1 : 0;
                        if (zzr > 17) {
                            int i70 = i67;
                            int i71 = i62;
                            int i72 = i19;
                            zzbc zzbcVar8 = zzbcVar7;
                            Unsafe unsafe4 = unsafe3;
                            if (zzr != 27) {
                                i20 = i71;
                                i35 = i69;
                                if (zzr > 49) {
                                    unsafe = unsafe4;
                                    i34 = i72;
                                    i22 = i70;
                                    zzefVar2 = zzefVar4;
                                    i33 = i65;
                                    bArr2 = bArr;
                                    if (zzr != 50) {
                                        obj2 = obj;
                                        Unsafe unsafe5 = zzb;
                                        long j11 = iArr[i34 + 2] & 1048575;
                                        switch (zzr) {
                                            case 51:
                                                zzbcVar2 = zzbcVar;
                                                i36 = i35;
                                                i37 = i33;
                                                i38 = i34;
                                                i15 = i11;
                                                zzefVar = zzefVar2;
                                                if (z10 == 1) {
                                                    i39 = i37 + 8;
                                                    unsafe5.putObject(obj2, j10, Double.valueOf(Double.longBitsToDouble(zzbd.zzn(bArr2, i37))));
                                                    unsafe5.putInt(obj2, j11, i22);
                                                    i59 = i39;
                                                    if (i59 != i37) {
                                                        i13 = i12;
                                                        i21 = i59;
                                                        i61 = i38;
                                                        i66 = i36;
                                                        break;
                                                    } else {
                                                        i55 = i12;
                                                        zzbcVar7 = zzbcVar2;
                                                        i54 = i15;
                                                        i60 = i22;
                                                        i62 = i20;
                                                        i61 = i38;
                                                        i64 = i36;
                                                        unsafe3 = unsafe;
                                                        i56 = 3;
                                                        i58 = -1;
                                                        bArr4 = bArr2;
                                                        zzefVar4 = zzefVar;
                                                        break;
                                                    }
                                                }
                                                i59 = i37;
                                                if (i59 != i37) {
                                                }
                                            case 52:
                                                zzbcVar2 = zzbcVar;
                                                i36 = i35;
                                                i37 = i33;
                                                i38 = i34;
                                                i15 = i11;
                                                zzefVar = zzefVar2;
                                                if (z10 == 5) {
                                                    i39 = i37 + 4;
                                                    unsafe5.putObject(obj2, j10, Float.valueOf(Float.intBitsToFloat(zzbd.zzb(bArr2, i37))));
                                                    unsafe5.putInt(obj2, j11, i22);
                                                    i59 = i39;
                                                    if (i59 != i37) {
                                                    }
                                                }
                                                i59 = i37;
                                                if (i59 != i37) {
                                                }
                                                break;
                                            case 53:
                                            case 54:
                                                zzbcVar2 = zzbcVar;
                                                i36 = i35;
                                                i37 = i33;
                                                i38 = i34;
                                                i15 = i11;
                                                zzefVar = zzefVar2;
                                                if (z10 == 0) {
                                                    i39 = zzbd.zzk(bArr2, i37, zzbcVar2);
                                                    unsafe5.putObject(obj2, j10, Long.valueOf(zzbcVar2.zzb));
                                                    unsafe5.putInt(obj2, j11, i22);
                                                    i59 = i39;
                                                    if (i59 != i37) {
                                                    }
                                                }
                                                i59 = i37;
                                                if (i59 != i37) {
                                                }
                                                break;
                                            case 55:
                                            case 62:
                                                zzbcVar2 = zzbcVar;
                                                i36 = i35;
                                                i37 = i33;
                                                i38 = i34;
                                                i15 = i11;
                                                zzefVar = zzefVar2;
                                                if (z10 == 0) {
                                                    i39 = zzbd.zzh(bArr2, i37, zzbcVar2);
                                                    unsafe5.putObject(obj2, j10, Integer.valueOf(zzbcVar2.zza));
                                                    unsafe5.putInt(obj2, j11, i22);
                                                    i59 = i39;
                                                    if (i59 != i37) {
                                                    }
                                                }
                                                i59 = i37;
                                                if (i59 != i37) {
                                                }
                                                break;
                                            case 56:
                                            case 65:
                                                zzbcVar2 = zzbcVar;
                                                i36 = i35;
                                                i37 = i33;
                                                i38 = i34;
                                                i15 = i11;
                                                zzefVar = zzefVar2;
                                                if (z10 == 1) {
                                                    i39 = i37 + 8;
                                                    unsafe5.putObject(obj2, j10, Long.valueOf(zzbd.zzn(bArr2, i37)));
                                                    unsafe5.putInt(obj2, j11, i22);
                                                    i59 = i39;
                                                    if (i59 != i37) {
                                                    }
                                                }
                                                i59 = i37;
                                                if (i59 != i37) {
                                                }
                                                break;
                                            case 57:
                                            case 64:
                                                zzbcVar2 = zzbcVar;
                                                i36 = i35;
                                                i37 = i33;
                                                i38 = i34;
                                                i15 = i11;
                                                zzefVar = zzefVar2;
                                                if (z10 == 5) {
                                                    i39 = i37 + 4;
                                                    unsafe5.putObject(obj2, j10, Integer.valueOf(zzbd.zzb(bArr2, i37)));
                                                    unsafe5.putInt(obj2, j11, i22);
                                                    i59 = i39;
                                                    if (i59 != i37) {
                                                    }
                                                }
                                                i59 = i37;
                                                if (i59 != i37) {
                                                }
                                                break;
                                            case 58:
                                                zzbcVar2 = zzbcVar;
                                                i36 = i35;
                                                i37 = i33;
                                                i38 = i34;
                                                i15 = i11;
                                                zzefVar = zzefVar2;
                                                if (z10 == 0) {
                                                    i39 = zzbd.zzk(bArr2, i37, zzbcVar2);
                                                    unsafe5.putObject(obj2, j10, Boolean.valueOf(zzbcVar2.zzb != 0));
                                                    unsafe5.putInt(obj2, j11, i22);
                                                    i59 = i39;
                                                    if (i59 != i37) {
                                                    }
                                                }
                                                i59 = i37;
                                                if (i59 != i37) {
                                                }
                                                break;
                                            case 59:
                                                zzbcVar2 = zzbcVar;
                                                i36 = i35;
                                                i37 = i33;
                                                i38 = i34;
                                                i15 = i11;
                                                zzefVar = zzefVar2;
                                                if (z10 == 2) {
                                                    int zzh3 = zzbd.zzh(bArr2, i37, zzbcVar2);
                                                    int i73 = zzbcVar2.zza;
                                                    if (i73 == 0) {
                                                        unsafe5.putObject(obj2, j10, "");
                                                    } else {
                                                        int i74 = zzh3 + i73;
                                                        if ((i68 & 536870912) != 0 && !zzfu.zze(bArr2, zzh3, i74)) {
                                                            throw zzdc.zzc();
                                                        }
                                                        unsafe5.putObject(obj2, j10, new String(bArr2, zzh3, i73, zzda.zzb));
                                                        zzh3 = i74;
                                                    }
                                                    unsafe5.putInt(obj2, j11, i22);
                                                    i59 = zzh3;
                                                    if (i59 != i37) {
                                                    }
                                                }
                                                i59 = i37;
                                                if (i59 != i37) {
                                                }
                                                break;
                                            case 60:
                                                if (z10 == 2) {
                                                    Object zzy = zzefVar2.zzy(obj2, i22, i34);
                                                    i36 = i35;
                                                    i37 = i33;
                                                    zzefVar = zzefVar2;
                                                    int zzm = zzbd.zzm(zzy, zzefVar2.zzv(i34), bArr, i33, i11, zzbcVar);
                                                    zzefVar.zzG(obj2, i22, i34, zzy);
                                                    zzbcVar2 = zzbcVar;
                                                    i59 = zzm;
                                                    i15 = i11;
                                                    i38 = i34;
                                                    if (i59 != i37) {
                                                    }
                                                } else {
                                                    zzefVar = zzefVar2;
                                                    i36 = i35;
                                                    i37 = i33;
                                                    i15 = i11;
                                                    zzbcVar2 = zzbcVar;
                                                    i38 = i34;
                                                    i59 = i37;
                                                    if (i59 != i37) {
                                                    }
                                                }
                                                break;
                                            case 61:
                                                i40 = i33;
                                                i41 = i34;
                                                zzbcVar5 = zzbcVar;
                                                if (z10 == 2) {
                                                    int zza2 = zzbd.zza(bArr2, i40, zzbcVar5);
                                                    unsafe5.putObject(obj2, j10, zzbcVar5.zzc);
                                                    unsafe5.putInt(obj2, j11, i22);
                                                    i15 = i11;
                                                    zzefVar = zzefVar2;
                                                    i59 = zza2;
                                                    i36 = i35;
                                                    i38 = i41;
                                                    i37 = i40;
                                                    zzbcVar2 = zzbcVar5;
                                                    if (i59 != i37) {
                                                    }
                                                }
                                                i15 = i11;
                                                zzefVar = zzefVar2;
                                                i36 = i35;
                                                i38 = i41;
                                                i37 = i40;
                                                zzbcVar2 = zzbcVar5;
                                                i59 = i37;
                                                if (i59 != i37) {
                                                }
                                                break;
                                            case 63:
                                                i40 = i33;
                                                i41 = i34;
                                                zzbcVar5 = zzbcVar;
                                                if (z10 == 0) {
                                                    zzh = zzbd.zzh(bArr2, i40, zzbcVar5);
                                                    int i75 = zzbcVar5.zza;
                                                    zzcw zzu = zzefVar2.zzu(i41);
                                                    if (zzu != null && !zzu.zza(i75)) {
                                                        zzd(obj).zzj(i35, Long.valueOf(i75));
                                                    } else {
                                                        unsafe5.putObject(obj2, j10, Integer.valueOf(i75));
                                                        unsafe5.putInt(obj2, j11, i22);
                                                    }
                                                    i15 = i11;
                                                    i59 = zzh;
                                                    zzefVar = zzefVar2;
                                                    i36 = i35;
                                                    i38 = i41;
                                                    i37 = i40;
                                                    zzbcVar2 = zzbcVar5;
                                                    if (i59 != i37) {
                                                    }
                                                }
                                                i15 = i11;
                                                zzefVar = zzefVar2;
                                                i36 = i35;
                                                i38 = i41;
                                                i37 = i40;
                                                zzbcVar2 = zzbcVar5;
                                                i59 = i37;
                                                if (i59 != i37) {
                                                }
                                                break;
                                            case 66:
                                                i40 = i33;
                                                i41 = i34;
                                                zzbcVar5 = zzbcVar;
                                                if (z10 == 0) {
                                                    zzh = zzbd.zzh(bArr2, i40, zzbcVar5);
                                                    unsafe5.putObject(obj2, j10, Integer.valueOf(zzbu.zzb(zzbcVar5.zza)));
                                                    unsafe5.putInt(obj2, j11, i22);
                                                    i15 = i11;
                                                    i59 = zzh;
                                                    zzefVar = zzefVar2;
                                                    i36 = i35;
                                                    i38 = i41;
                                                    i37 = i40;
                                                    zzbcVar2 = zzbcVar5;
                                                    if (i59 != i37) {
                                                    }
                                                }
                                                i15 = i11;
                                                zzefVar = zzefVar2;
                                                i36 = i35;
                                                i38 = i41;
                                                i37 = i40;
                                                zzbcVar2 = zzbcVar5;
                                                i59 = i37;
                                                if (i59 != i37) {
                                                }
                                                break;
                                            case 67:
                                                i40 = i33;
                                                i41 = i34;
                                                if (z10 == 0) {
                                                    zzbcVar5 = zzbcVar;
                                                    zzh = zzbd.zzk(bArr2, i40, zzbcVar5);
                                                    unsafe5.putObject(obj2, j10, Long.valueOf(zzbu.zzc(zzbcVar5.zzb)));
                                                    unsafe5.putInt(obj2, j11, i22);
                                                    i15 = i11;
                                                    i59 = zzh;
                                                    zzefVar = zzefVar2;
                                                    i36 = i35;
                                                    i38 = i41;
                                                    i37 = i40;
                                                    zzbcVar2 = zzbcVar5;
                                                    if (i59 != i37) {
                                                    }
                                                } else {
                                                    i15 = i11;
                                                    zzefVar = zzefVar2;
                                                    i36 = i35;
                                                    i38 = i41;
                                                    i37 = i40;
                                                    zzbcVar2 = zzbcVar;
                                                    i59 = i37;
                                                    if (i59 != i37) {
                                                    }
                                                }
                                                break;
                                            case 68:
                                                if (z10 == 3) {
                                                    Object zzy2 = zzefVar2.zzy(obj2, i22, i34);
                                                    i59 = zzbd.zzl(zzy2, zzefVar2.zzv(i34), bArr, i33, i11, (i35 & (-8)) | 4, zzbcVar);
                                                    zzefVar2.zzG(obj2, i22, i34, zzy2);
                                                    i15 = i11;
                                                    i38 = i34;
                                                    zzefVar = zzefVar2;
                                                    i37 = i33;
                                                    i36 = i35;
                                                    zzbcVar2 = zzbcVar;
                                                    if (i59 != i37) {
                                                    }
                                                }
                                                break;
                                            default:
                                                zzbcVar2 = zzbcVar;
                                                i36 = i35;
                                                i37 = i33;
                                                i38 = i34;
                                                i15 = i11;
                                                zzefVar = zzefVar2;
                                                i59 = i37;
                                                if (i59 != i37) {
                                                }
                                                break;
                                        }
                                    } else {
                                        if (z10 == 2) {
                                            Unsafe unsafe6 = zzb;
                                            Object zzw = zzefVar2.zzw(i34);
                                            Object object = unsafe6.getObject(obj, j10);
                                            if (!((zzdw) object).zze()) {
                                                zzdw zzb2 = zzdw.zza().zzb();
                                                zzdx.zza(zzb2, object);
                                                unsafe6.putObject(obj, j10, zzb2);
                                            }
                                            throw null;
                                        }
                                        zzbcVar4 = zzbcVar8;
                                        obj2 = obj;
                                        i13 = i12;
                                        zzbcVar2 = zzbcVar4;
                                        i66 = i35;
                                        i61 = i34;
                                        i15 = i11;
                                        int i76 = i33;
                                        zzefVar = zzefVar2;
                                        i21 = i76;
                                    }
                                } else {
                                    long j12 = i68;
                                    Unsafe unsafe7 = zzb;
                                    zzcz zzczVar2 = (zzcz) unsafe7.getObject(obj2, j10);
                                    if (!zzczVar2.zzc()) {
                                        int size = zzczVar2.size();
                                        zzcz zzd = zzczVar2.zzd(size == 0 ? 10 : size + size);
                                        unsafe7.putObject(obj2, j10, zzd);
                                        zzczVar2 = zzd;
                                    }
                                    switch (zzr) {
                                        case 18:
                                        case 35:
                                            unsafe = unsafe4;
                                            zzbcVar6 = zzbcVar8;
                                            i42 = i72;
                                            i22 = i70;
                                            zzefVar3 = zzefVar4;
                                            i43 = i65;
                                            bArr2 = bArr;
                                            int i77 = i11;
                                            if (z10 == 2) {
                                                zzca zzcaVar = (zzca) zzczVar2;
                                                i44 = zzbd.zzh(bArr2, i43, zzbcVar6);
                                                int i78 = zzbcVar6.zza + i44;
                                                while (i44 < i78) {
                                                    zzcaVar.zzf(Double.longBitsToDouble(zzbd.zzn(bArr2, i44)));
                                                    i44 += 8;
                                                }
                                                if (i44 != i78) {
                                                    throw zzdc.zzg();
                                                }
                                            } else {
                                                if (z10 == 1) {
                                                    int i79 = i43 + 8;
                                                    zzca zzcaVar2 = (zzca) zzczVar2;
                                                    zzcaVar2.zzf(Double.longBitsToDouble(zzbd.zzn(bArr2, i43)));
                                                    while (i79 < i77) {
                                                        int zzh4 = zzbd.zzh(bArr2, i79, zzbcVar6);
                                                        if (i35 == zzbcVar6.zza) {
                                                            zzcaVar2.zzf(Double.longBitsToDouble(zzbd.zzn(bArr2, zzh4)));
                                                            i79 = zzh4 + 8;
                                                            i77 = i11;
                                                        } else {
                                                            i44 = i79;
                                                        }
                                                    }
                                                    i44 = i79;
                                                }
                                                i44 = i43;
                                            }
                                            if (i44 == i43) {
                                                i13 = i12;
                                                zzefVar = zzefVar3;
                                                zzbcVar2 = zzbcVar6;
                                                i66 = i35;
                                                i61 = i42;
                                                obj2 = obj;
                                                i15 = i11;
                                                i21 = i44;
                                                break;
                                            } else {
                                                i54 = i11;
                                                i55 = i12;
                                                i59 = i44;
                                                i64 = i35;
                                                i61 = i42;
                                                i60 = i22;
                                                i62 = i20;
                                                unsafe3 = unsafe;
                                                i56 = 3;
                                                i58 = -1;
                                                i57 = 0;
                                                bArr4 = bArr2;
                                                zzefVar4 = zzefVar3;
                                                zzbcVar7 = zzbcVar6;
                                                obj2 = obj;
                                            }
                                        case 19:
                                        case 36:
                                            unsafe = unsafe4;
                                            zzbcVar6 = zzbcVar8;
                                            i42 = i72;
                                            i22 = i70;
                                            zzefVar3 = zzefVar4;
                                            i43 = i65;
                                            bArr2 = bArr;
                                            if (z10 == 2) {
                                                zzck zzckVar = (zzck) zzczVar2;
                                                i44 = zzbd.zzh(bArr2, i43, zzbcVar6);
                                                int i80 = zzbcVar6.zza + i44;
                                                while (i44 < i80) {
                                                    zzckVar.zzf(Float.intBitsToFloat(zzbd.zzb(bArr2, i44)));
                                                    i44 += 4;
                                                }
                                                if (i44 != i80) {
                                                    throw zzdc.zzg();
                                                }
                                            } else {
                                                if (z10 == 5) {
                                                    i44 = i43 + 4;
                                                    zzck zzckVar2 = (zzck) zzczVar2;
                                                    zzckVar2.zzf(Float.intBitsToFloat(zzbd.zzb(bArr2, i43)));
                                                    while (i44 < i11) {
                                                        int zzh5 = zzbd.zzh(bArr2, i44, zzbcVar6);
                                                        if (i35 == zzbcVar6.zza) {
                                                            zzckVar2.zzf(Float.intBitsToFloat(zzbd.zzb(bArr2, zzh5)));
                                                            i44 = zzh5 + 4;
                                                        }
                                                    }
                                                }
                                                i44 = i43;
                                            }
                                            if (i44 == i43) {
                                            }
                                            break;
                                        case 20:
                                        case 21:
                                        case 37:
                                        case 38:
                                            unsafe = unsafe4;
                                            zzbcVar6 = zzbcVar8;
                                            i42 = i72;
                                            i22 = i70;
                                            zzefVar3 = zzefVar4;
                                            i43 = i65;
                                            bArr2 = bArr;
                                            if (z10 == 2) {
                                                zzdr zzdrVar = (zzdr) zzczVar2;
                                                i44 = zzbd.zzh(bArr2, i43, zzbcVar6);
                                                int i81 = zzbcVar6.zza + i44;
                                                while (i44 < i81) {
                                                    i44 = zzbd.zzk(bArr2, i44, zzbcVar6);
                                                    zzdrVar.zzf(zzbcVar6.zzb);
                                                }
                                                if (i44 != i81) {
                                                    throw zzdc.zzg();
                                                }
                                            } else {
                                                if (z10 == 0) {
                                                    zzdr zzdrVar2 = (zzdr) zzczVar2;
                                                    i44 = zzbd.zzk(bArr2, i43, zzbcVar6);
                                                    zzdrVar2.zzf(zzbcVar6.zzb);
                                                    while (i44 < i11) {
                                                        int zzh6 = zzbd.zzh(bArr2, i44, zzbcVar6);
                                                        if (i35 == zzbcVar6.zza) {
                                                            i44 = zzbd.zzk(bArr2, zzh6, zzbcVar6);
                                                            zzdrVar2.zzf(zzbcVar6.zzb);
                                                        }
                                                    }
                                                }
                                                i44 = i43;
                                            }
                                            if (i44 == i43) {
                                            }
                                            break;
                                        case 22:
                                        case 29:
                                        case 39:
                                        case 43:
                                            bArr2 = bArr;
                                            unsafe = unsafe4;
                                            i45 = i35;
                                            zzbcVar6 = zzbcVar8;
                                            i46 = i70;
                                            i43 = i65;
                                            i47 = i72;
                                            if (z10 == 2) {
                                                zzf = zzbd.zzf(bArr2, i43, zzczVar2, zzbcVar6);
                                                i22 = i46;
                                                i42 = i47;
                                                i35 = i45;
                                                i44 = zzf;
                                                zzefVar3 = this;
                                                if (i44 == i43) {
                                                }
                                            } else if (z10 == 0) {
                                                i22 = i46;
                                                i42 = i47;
                                                i35 = i45;
                                                i44 = zzbd.zzj(i45, bArr, i43, i11, zzczVar2, zzbcVar);
                                                zzefVar3 = this;
                                                if (i44 == i43) {
                                                }
                                            } else {
                                                i22 = i46;
                                                i42 = i47;
                                                i35 = i45;
                                                zzefVar3 = this;
                                                i44 = i43;
                                                if (i44 == i43) {
                                                }
                                            }
                                            break;
                                        case 23:
                                        case 32:
                                        case 40:
                                        case 46:
                                            bArr2 = bArr;
                                            unsafe = unsafe4;
                                            i45 = i35;
                                            zzbcVar6 = zzbcVar8;
                                            i46 = i70;
                                            i43 = i65;
                                            i47 = i72;
                                            if (z10 == 2) {
                                                zzdr zzdrVar3 = (zzdr) zzczVar2;
                                                zzh2 = zzbd.zzh(bArr2, i43, zzbcVar6);
                                                int i82 = zzbcVar6.zza + zzh2;
                                                while (zzh2 < i82) {
                                                    zzdrVar3.zzf(zzbd.zzn(bArr2, zzh2));
                                                    zzh2 += 8;
                                                }
                                                if (zzh2 != i82) {
                                                    throw zzdc.zzg();
                                                }
                                                i22 = i46;
                                                i42 = i47;
                                                i35 = i45;
                                                i44 = zzh2;
                                                zzefVar3 = this;
                                                if (i44 == i43) {
                                                }
                                            } else {
                                                if (z10 == 1) {
                                                    zzf = i43 + 8;
                                                    zzdr zzdrVar4 = (zzdr) zzczVar2;
                                                    zzdrVar4.zzf(zzbd.zzn(bArr2, i43));
                                                    while (zzf < i11) {
                                                        int zzh7 = zzbd.zzh(bArr2, zzf, zzbcVar6);
                                                        if (i45 == zzbcVar6.zza) {
                                                            zzdrVar4.zzf(zzbd.zzn(bArr2, zzh7));
                                                            zzf = zzh7 + 8;
                                                        } else {
                                                            i22 = i46;
                                                            i42 = i47;
                                                            i35 = i45;
                                                            i44 = zzf;
                                                            zzefVar3 = this;
                                                            if (i44 == i43) {
                                                            }
                                                        }
                                                    }
                                                    i22 = i46;
                                                    i42 = i47;
                                                    i35 = i45;
                                                    i44 = zzf;
                                                    zzefVar3 = this;
                                                    if (i44 == i43) {
                                                    }
                                                }
                                                i22 = i46;
                                                i42 = i47;
                                                i35 = i45;
                                                zzefVar3 = this;
                                                i44 = i43;
                                                if (i44 == i43) {
                                                }
                                            }
                                            break;
                                        case 24:
                                        case 31:
                                        case 41:
                                        case 45:
                                            bArr2 = bArr;
                                            unsafe = unsafe4;
                                            i45 = i35;
                                            zzbcVar6 = zzbcVar8;
                                            i46 = i70;
                                            i43 = i65;
                                            i47 = i72;
                                            if (z10 == 2) {
                                                zzct zzctVar = (zzct) zzczVar2;
                                                zzh2 = zzbd.zzh(bArr2, i43, zzbcVar6);
                                                int i83 = zzbcVar6.zza + zzh2;
                                                while (zzh2 < i83) {
                                                    zzctVar.zzg(zzbd.zzb(bArr2, zzh2));
                                                    zzh2 += 4;
                                                }
                                                if (zzh2 != i83) {
                                                    throw zzdc.zzg();
                                                }
                                            } else {
                                                if (z10 == 5) {
                                                    zzh2 = i43 + 4;
                                                    zzct zzctVar2 = (zzct) zzczVar2;
                                                    zzctVar2.zzg(zzbd.zzb(bArr2, i43));
                                                    while (zzh2 < i11) {
                                                        int zzh8 = zzbd.zzh(bArr2, zzh2, zzbcVar6);
                                                        if (i45 == zzbcVar6.zza) {
                                                            zzctVar2.zzg(zzbd.zzb(bArr2, zzh8));
                                                            zzh2 = zzh8 + 4;
                                                        }
                                                    }
                                                }
                                                i22 = i46;
                                                i42 = i47;
                                                i35 = i45;
                                                zzefVar3 = this;
                                                i44 = i43;
                                                if (i44 == i43) {
                                                }
                                            }
                                            i22 = i46;
                                            i42 = i47;
                                            i35 = i45;
                                            i44 = zzh2;
                                            zzefVar3 = this;
                                            if (i44 == i43) {
                                            }
                                            break;
                                        case 25:
                                        case 42:
                                            bArr2 = bArr;
                                            unsafe = unsafe4;
                                            i45 = i35;
                                            zzbcVar6 = zzbcVar8;
                                            i46 = i70;
                                            i43 = i65;
                                            i47 = i72;
                                            if (z10 == 2) {
                                                zzbe zzbeVar = (zzbe) zzczVar2;
                                                zzh2 = zzbd.zzh(bArr2, i43, zzbcVar6);
                                                int i84 = zzbcVar6.zza + zzh2;
                                                while (zzh2 < i84) {
                                                    zzh2 = zzbd.zzk(bArr2, zzh2, zzbcVar6);
                                                    zzbeVar.zze(zzbcVar6.zzb != 0);
                                                }
                                                if (zzh2 != i84) {
                                                    throw zzdc.zzg();
                                                }
                                            } else {
                                                if (z10 == 0) {
                                                    zzbe zzbeVar2 = (zzbe) zzczVar2;
                                                    zzh2 = zzbd.zzk(bArr2, i43, zzbcVar6);
                                                    zzbeVar2.zze(zzbcVar6.zzb != 0);
                                                    while (zzh2 < i11) {
                                                        int zzh9 = zzbd.zzh(bArr2, zzh2, zzbcVar6);
                                                        if (i45 == zzbcVar6.zza) {
                                                            zzh2 = zzbd.zzk(bArr2, zzh9, zzbcVar6);
                                                            zzbeVar2.zze(zzbcVar6.zzb != 0);
                                                        }
                                                    }
                                                }
                                                i22 = i46;
                                                i42 = i47;
                                                i35 = i45;
                                                zzefVar3 = this;
                                                i44 = i43;
                                                if (i44 == i43) {
                                                }
                                            }
                                            i22 = i46;
                                            i42 = i47;
                                            i35 = i45;
                                            i44 = zzh2;
                                            zzefVar3 = this;
                                            if (i44 == i43) {
                                            }
                                            break;
                                        case 26:
                                            bArr2 = bArr;
                                            unsafe = unsafe4;
                                            i45 = i35;
                                            zzcz zzczVar3 = zzczVar2;
                                            zzbcVar6 = zzbcVar8;
                                            i46 = i70;
                                            i43 = i65;
                                            i47 = i72;
                                            if (z10 == 2) {
                                                if ((536870912 & j12) == 0) {
                                                    zzf = zzbd.zzh(bArr2, i43, zzbcVar6);
                                                    int i85 = zzbcVar6.zza;
                                                    if (i85 < 0) {
                                                        throw zzdc.zzd();
                                                    }
                                                    if (i85 == 0) {
                                                        zzczVar = zzczVar3;
                                                        zzczVar.add("");
                                                    } else {
                                                        zzczVar = zzczVar3;
                                                        zzczVar.add(new String(bArr2, zzf, i85, zzda.zzb));
                                                        zzf += i85;
                                                    }
                                                    while (zzf < i11) {
                                                        int zzh10 = zzbd.zzh(bArr2, zzf, zzbcVar6);
                                                        if (i45 == zzbcVar6.zza) {
                                                            zzf = zzbd.zzh(bArr2, zzh10, zzbcVar6);
                                                            int i86 = zzbcVar6.zza;
                                                            if (i86 < 0) {
                                                                throw zzdc.zzd();
                                                            }
                                                            if (i86 == 0) {
                                                                zzczVar.add("");
                                                            } else {
                                                                zzczVar.add(new String(bArr2, zzf, i86, zzda.zzb));
                                                                zzf += i86;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    zzf = zzbd.zzh(bArr2, i43, zzbcVar6);
                                                    int i87 = zzbcVar6.zza;
                                                    if (i87 < 0) {
                                                        throw zzdc.zzd();
                                                    }
                                                    if (i87 == 0) {
                                                        zzczVar3.add("");
                                                    } else {
                                                        int i88 = zzf + i87;
                                                        if (zzfu.zze(bArr2, zzf, i88)) {
                                                            zzczVar3.add(new String(bArr2, zzf, i87, zzda.zzb));
                                                            zzf = i88;
                                                        } else {
                                                            throw zzdc.zzc();
                                                        }
                                                    }
                                                    while (zzf < i11) {
                                                        int zzh11 = zzbd.zzh(bArr2, zzf, zzbcVar6);
                                                        if (i45 == zzbcVar6.zza) {
                                                            zzf = zzbd.zzh(bArr2, zzh11, zzbcVar6);
                                                            int i89 = zzbcVar6.zza;
                                                            if (i89 < 0) {
                                                                throw zzdc.zzd();
                                                            }
                                                            if (i89 == 0) {
                                                                zzczVar3.add("");
                                                            } else {
                                                                int i90 = zzf + i89;
                                                                if (zzfu.zze(bArr2, zzf, i90)) {
                                                                    zzczVar3.add(new String(bArr2, zzf, i89, zzda.zzb));
                                                                    zzf = i90;
                                                                } else {
                                                                    throw zzdc.zzc();
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                i22 = i46;
                                                i42 = i47;
                                                i35 = i45;
                                                i44 = zzf;
                                                zzefVar3 = this;
                                                if (i44 == i43) {
                                                }
                                            }
                                            i22 = i46;
                                            i42 = i47;
                                            i35 = i45;
                                            zzefVar3 = this;
                                            i44 = i43;
                                            if (i44 == i43) {
                                            }
                                            break;
                                        case 27:
                                            i48 = i65;
                                            unsafe = unsafe4;
                                            i42 = i72;
                                            i49 = i70;
                                            if (z10 == 2) {
                                                bArr2 = bArr;
                                                zzbcVar6 = zzbcVar8;
                                                int zze = zzbd.zze(zzv(i42), i35, bArr, i48, i11, zzczVar2, zzbcVar);
                                                i42 = i42;
                                                i35 = i35;
                                                i43 = i48;
                                                zzefVar3 = this;
                                                i22 = i49;
                                                i44 = zze;
                                                if (i44 == i43) {
                                                }
                                            } else {
                                                bArr2 = bArr;
                                                zzbcVar6 = zzbcVar8;
                                                zzefVar3 = this;
                                                i43 = i48;
                                                i22 = i49;
                                                i44 = i43;
                                                if (i44 == i43) {
                                                }
                                            }
                                            break;
                                        case 28:
                                            i48 = i65;
                                            unsafe = unsafe4;
                                            i42 = i72;
                                            i49 = i70;
                                            if (z10 == 2) {
                                                int zzh12 = zzbd.zzh(bArr, i48, zzbcVar8);
                                                int i91 = zzbcVar8.zza;
                                                if (i91 >= 0) {
                                                    if (i91 > bArr.length - zzh12) {
                                                        throw zzdc.zzg();
                                                    }
                                                    if (i91 == 0) {
                                                        zzczVar2.add(zzbq.zzb);
                                                    } else {
                                                        zzczVar2.add(zzbq.zzl(bArr, zzh12, i91));
                                                        zzh12 += i91;
                                                    }
                                                    while (zzh12 < i11) {
                                                        int zzh13 = zzbd.zzh(bArr, zzh12, zzbcVar8);
                                                        if (i35 == zzbcVar8.zza) {
                                                            zzh12 = zzbd.zzh(bArr, zzh13, zzbcVar8);
                                                            int i92 = zzbcVar8.zza;
                                                            if (i92 >= 0) {
                                                                if (i92 > bArr.length - zzh12) {
                                                                    throw zzdc.zzg();
                                                                }
                                                                if (i92 == 0) {
                                                                    zzczVar2.add(zzbq.zzb);
                                                                } else {
                                                                    zzczVar2.add(zzbq.zzl(bArr, zzh12, i92));
                                                                    zzh12 += i92;
                                                                }
                                                            } else {
                                                                throw zzdc.zzd();
                                                            }
                                                        } else {
                                                            zzefVar3 = this;
                                                            bArr2 = bArr;
                                                            zzbcVar6 = zzbcVar8;
                                                            i43 = i48;
                                                            i22 = i49;
                                                            i44 = zzh12;
                                                            if (i44 == i43) {
                                                            }
                                                        }
                                                    }
                                                    zzefVar3 = this;
                                                    bArr2 = bArr;
                                                    zzbcVar6 = zzbcVar8;
                                                    i43 = i48;
                                                    i22 = i49;
                                                    i44 = zzh12;
                                                    if (i44 == i43) {
                                                    }
                                                } else {
                                                    throw zzdc.zzd();
                                                }
                                            } else {
                                                zzefVar3 = this;
                                                bArr2 = bArr;
                                                zzbcVar6 = zzbcVar8;
                                                i43 = i48;
                                                i22 = i49;
                                                i44 = i43;
                                                if (i44 == i43) {
                                                }
                                            }
                                            break;
                                        case 30:
                                        case 44:
                                            bArr3 = bArr;
                                            i50 = i65;
                                            unsafe = unsafe4;
                                            i42 = i72;
                                            if (z10 == 2) {
                                                zzj = zzbd.zzf(bArr3, i50, zzczVar2, zzbcVar8);
                                            } else if (z10 == 0) {
                                                zzj = zzbd.zzj(i35, bArr, i50, i11, zzczVar2, zzbcVar);
                                            } else {
                                                zzefVar3 = this;
                                                bArr2 = bArr3;
                                                zzbcVar6 = zzbcVar8;
                                                i43 = i50;
                                                i22 = i70;
                                                i44 = i43;
                                                if (i44 == i43) {
                                                }
                                            }
                                            zzcw zzu2 = zzefVar4.zzu(i42);
                                            zzff zzffVar = zzefVar4.zzm;
                                            int i93 = zzeq.zza;
                                            if (zzu2 == null) {
                                                i51 = zzj;
                                                i52 = i70;
                                            } else if (zzczVar2 instanceof RandomAccess) {
                                                int size2 = zzczVar2.size();
                                                Object obj3 = null;
                                                int i94 = 0;
                                                int i95 = 0;
                                                while (i94 < size2) {
                                                    int i96 = zzj;
                                                    Integer num = (Integer) zzczVar2.get(i94);
                                                    int intValue = num.intValue();
                                                    if (zzu2.zza(intValue)) {
                                                        if (i94 != i95) {
                                                            zzczVar2.set(i95, num);
                                                        }
                                                        i95++;
                                                        i53 = i70;
                                                    } else {
                                                        i53 = i70;
                                                        obj3 = zzeq.zzo(obj2, i53, intValue, obj3, zzffVar);
                                                    }
                                                    i94++;
                                                    i70 = i53;
                                                    zzj = i96;
                                                }
                                                i51 = zzj;
                                                i52 = i70;
                                                if (i95 != size2) {
                                                    zzczVar2.subList(i95, size2).clear();
                                                }
                                            } else {
                                                i51 = zzj;
                                                i52 = i70;
                                                Iterator it = zzczVar2.iterator();
                                                Object obj4 = null;
                                                while (it.hasNext()) {
                                                    int intValue2 = ((Integer) it.next()).intValue();
                                                    if (!zzu2.zza(intValue2)) {
                                                        obj4 = zzeq.zzo(obj2, i52, intValue2, obj4, zzffVar);
                                                        it.remove();
                                                    }
                                                }
                                            }
                                            zzefVar3 = this;
                                            bArr2 = bArr3;
                                            zzbcVar6 = zzbcVar8;
                                            i43 = i50;
                                            i22 = i52;
                                            i44 = i51;
                                            if (i44 == i43) {
                                            }
                                            break;
                                        case 33:
                                        case 47:
                                            bArr3 = bArr;
                                            i50 = i65;
                                            unsafe = unsafe4;
                                            i42 = i72;
                                            if (z10 == 2) {
                                                zzct zzctVar3 = (zzct) zzczVar2;
                                                i44 = zzbd.zzh(bArr3, i50, zzbcVar8);
                                                int i97 = zzbcVar8.zza + i44;
                                                while (i44 < i97) {
                                                    i44 = zzbd.zzh(bArr3, i44, zzbcVar8);
                                                    zzctVar3.zzg(zzbu.zzb(zzbcVar8.zza));
                                                }
                                                if (i44 != i97) {
                                                    throw zzdc.zzg();
                                                }
                                            } else {
                                                if (z10 == 0) {
                                                    zzct zzctVar4 = (zzct) zzczVar2;
                                                    i44 = zzbd.zzh(bArr3, i50, zzbcVar8);
                                                    zzctVar4.zzg(zzbu.zzb(zzbcVar8.zza));
                                                    while (i44 < i11) {
                                                        int zzh14 = zzbd.zzh(bArr3, i44, zzbcVar8);
                                                        if (i35 == zzbcVar8.zza) {
                                                            i44 = zzbd.zzh(bArr3, zzh14, zzbcVar8);
                                                            zzctVar4.zzg(zzbu.zzb(zzbcVar8.zza));
                                                        }
                                                    }
                                                }
                                                zzefVar3 = zzefVar4;
                                                bArr2 = bArr3;
                                                zzbcVar6 = zzbcVar8;
                                                i43 = i50;
                                                i22 = i70;
                                                i44 = i43;
                                                if (i44 == i43) {
                                                }
                                            }
                                            zzefVar3 = zzefVar4;
                                            bArr2 = bArr3;
                                            zzbcVar6 = zzbcVar8;
                                            i43 = i50;
                                            i22 = i70;
                                            if (i44 == i43) {
                                            }
                                            break;
                                        case 34:
                                        case 48:
                                            bArr3 = bArr;
                                            i50 = i65;
                                            unsafe = unsafe4;
                                            i42 = i72;
                                            if (z10 == 2) {
                                                zzdr zzdrVar5 = (zzdr) zzczVar2;
                                                i44 = zzbd.zzh(bArr3, i50, zzbcVar8);
                                                int i98 = zzbcVar8.zza + i44;
                                                while (i44 < i98) {
                                                    i44 = zzbd.zzk(bArr3, i44, zzbcVar8);
                                                    zzdrVar5.zzf(zzbu.zzc(zzbcVar8.zzb));
                                                }
                                                if (i44 != i98) {
                                                    throw zzdc.zzg();
                                                }
                                            } else {
                                                if (z10 == 0) {
                                                    zzdr zzdrVar6 = (zzdr) zzczVar2;
                                                    i44 = zzbd.zzk(bArr3, i50, zzbcVar8);
                                                    zzdrVar6.zzf(zzbu.zzc(zzbcVar8.zzb));
                                                    while (i44 < i11) {
                                                        int zzh15 = zzbd.zzh(bArr3, i44, zzbcVar8);
                                                        if (i35 == zzbcVar8.zza) {
                                                            i44 = zzbd.zzk(bArr3, zzh15, zzbcVar8);
                                                            zzdrVar6.zzf(zzbu.zzc(zzbcVar8.zzb));
                                                        }
                                                    }
                                                }
                                                zzefVar3 = zzefVar4;
                                                bArr2 = bArr3;
                                                zzbcVar6 = zzbcVar8;
                                                i43 = i50;
                                                i22 = i70;
                                                i44 = i43;
                                                if (i44 == i43) {
                                                }
                                            }
                                            zzefVar3 = zzefVar4;
                                            bArr2 = bArr3;
                                            zzbcVar6 = zzbcVar8;
                                            i43 = i50;
                                            i22 = i70;
                                            if (i44 == i43) {
                                            }
                                            break;
                                        default:
                                            if (z10 == 3) {
                                                int i99 = (i35 & (-8)) | 4;
                                                int i100 = i72;
                                                zzeo zzv = zzefVar4.zzv(i100);
                                                i50 = i65;
                                                unsafe = unsafe4;
                                                i44 = zzbd.zzc(zzv, bArr, i50, i11, i99, zzbcVar);
                                                zzczVar2.add(zzbcVar8.zzc);
                                                int i101 = i11;
                                                while (true) {
                                                    if (i44 < i101) {
                                                        int i102 = i100;
                                                        bArr3 = bArr;
                                                        int zzh16 = zzbd.zzh(bArr3, i44, zzbcVar8);
                                                        if (i35 == zzbcVar8.zza) {
                                                            i44 = zzbd.zzc(zzv, bArr, zzh16, i11, i99, zzbcVar);
                                                            zzczVar2.add(zzbcVar8.zzc);
                                                            i101 = i101;
                                                            i100 = i102;
                                                            zzv = zzv;
                                                        } else {
                                                            i42 = i102;
                                                        }
                                                    } else {
                                                        i42 = i100;
                                                        bArr3 = bArr;
                                                    }
                                                }
                                                zzefVar3 = zzefVar4;
                                                bArr2 = bArr3;
                                                zzbcVar6 = zzbcVar8;
                                                i43 = i50;
                                                i22 = i70;
                                                if (i44 == i43) {
                                                }
                                            } else {
                                                unsafe = unsafe4;
                                                zzefVar3 = zzefVar4;
                                                zzbcVar6 = zzbcVar8;
                                                i42 = i72;
                                                i22 = i70;
                                                bArr2 = bArr;
                                                i43 = i65;
                                                i44 = i43;
                                                if (i44 == i43) {
                                                }
                                            }
                                            break;
                                    }
                                }
                            } else if (z10 == 2) {
                                zzcz zzczVar4 = (zzcz) unsafe4.getObject(obj2, j10);
                                if (!zzczVar4.zzc()) {
                                    int size3 = zzczVar4.size();
                                    zzczVar4 = zzczVar4.zzd(size3 == 0 ? 10 : size3 + size3);
                                    unsafe4.putObject(obj2, j10, zzczVar4);
                                }
                                i59 = zzbd.zze(zzefVar4.zzv(i72), i69, bArr, i65, i11, zzczVar4, zzbcVar);
                                i54 = i11;
                                i55 = i12;
                                i64 = i69;
                                unsafe3 = unsafe4;
                                zzbcVar7 = zzbcVar8;
                                i61 = i72;
                                i62 = i71;
                                i60 = i70;
                                i56 = 3;
                                i58 = -1;
                                i57 = 0;
                                bArr4 = bArr;
                            } else {
                                i20 = i71;
                                i33 = i65;
                                unsafe = unsafe4;
                                zzbcVar4 = zzbcVar8;
                                i22 = i70;
                                zzefVar2 = zzefVar4;
                                bArr2 = bArr;
                                i34 = i72;
                                i35 = i69;
                                i13 = i12;
                                zzbcVar2 = zzbcVar4;
                                i66 = i35;
                                i61 = i34;
                                i15 = i11;
                                int i762 = i33;
                                zzefVar = zzefVar2;
                                i21 = i762;
                            }
                        } else {
                            int i103 = iArr[i19 + 2];
                            int i104 = 1 << (i103 >>> 20);
                            int i105 = 1048575;
                            int i106 = i103 & 1048575;
                            int i107 = i62;
                            int i108 = i65;
                            if (i106 != i107) {
                                if (i107 != 1048575) {
                                    unsafe3.putInt(obj2, i107, i63);
                                    i105 = 1048575;
                                }
                                i23 = i106 == i105 ? 0 : unsafe3.getInt(obj2, i106);
                                i24 = i106;
                            } else {
                                i23 = i63;
                                i24 = i107;
                            }
                            switch (zzr) {
                                case 0:
                                    i25 = i67;
                                    unsafe2 = unsafe3;
                                    i27 = i108;
                                    i28 = i69;
                                    i26 = i19;
                                    zzbcVar3 = zzbcVar7;
                                    if (z10 == 1) {
                                        i23 |= i104;
                                        zzfp.zzo(obj2, j10, Double.longBitsToDouble(zzbd.zzn(bArr4, i27)));
                                        i59 = i27 + 8;
                                        i54 = i11;
                                        i55 = i12;
                                        zzbcVar7 = zzbcVar3;
                                        i61 = i26;
                                        i64 = i28;
                                        i62 = i24;
                                        i60 = i25;
                                        i56 = 3;
                                        i58 = -1;
                                        i63 = i23;
                                        unsafe3 = unsafe2;
                                        break;
                                    }
                                    i13 = i12;
                                    i21 = i27;
                                    zzbcVar2 = zzbcVar3;
                                    i61 = i26;
                                    unsafe = unsafe2;
                                    i66 = i28;
                                    i20 = i24;
                                    i15 = i11;
                                    zzefVar = zzefVar4;
                                    i63 = i23;
                                    bArr2 = bArr4;
                                    i22 = i25;
                                    break;
                                case 1:
                                    i25 = i67;
                                    unsafe2 = unsafe3;
                                    i27 = i108;
                                    i28 = i69;
                                    i26 = i19;
                                    zzbcVar3 = zzbcVar7;
                                    if (z10 == 5) {
                                        i29 = i27 + 4;
                                        i23 |= i104;
                                        zzfp.zzp(obj2, j10, Float.intBitsToFloat(zzbd.zzb(bArr4, i27)));
                                        i54 = i11;
                                        i55 = i12;
                                        i59 = i29;
                                        zzbcVar7 = zzbcVar3;
                                        i61 = i26;
                                        i64 = i28;
                                        i62 = i24;
                                        i60 = i25;
                                        i56 = 3;
                                        i58 = -1;
                                        i63 = i23;
                                        unsafe3 = unsafe2;
                                        break;
                                    }
                                    i13 = i12;
                                    i21 = i27;
                                    zzbcVar2 = zzbcVar3;
                                    i61 = i26;
                                    unsafe = unsafe2;
                                    i66 = i28;
                                    i20 = i24;
                                    i15 = i11;
                                    zzefVar = zzefVar4;
                                    i63 = i23;
                                    bArr2 = bArr4;
                                    i22 = i25;
                                    break;
                                case 2:
                                case 3:
                                    i25 = i67;
                                    unsafe2 = unsafe3;
                                    i27 = i108;
                                    i28 = i69;
                                    i26 = i19;
                                    zzbcVar3 = zzbcVar7;
                                    if (z10 == 0) {
                                        i30 = i23 | i104;
                                        int zzk = zzbd.zzk(bArr4, i27, zzbcVar3);
                                        unsafe2.putLong(obj, j10, zzbcVar3.zzb);
                                        i54 = i11;
                                        i55 = i12;
                                        zzbcVar7 = zzbcVar3;
                                        i61 = i26;
                                        i59 = zzk;
                                        i64 = i28;
                                        i62 = i24;
                                        i56 = 3;
                                        i58 = -1;
                                        i63 = i30;
                                        unsafe3 = unsafe2;
                                        i60 = i25;
                                        break;
                                    }
                                    i13 = i12;
                                    i21 = i27;
                                    zzbcVar2 = zzbcVar3;
                                    i61 = i26;
                                    unsafe = unsafe2;
                                    i66 = i28;
                                    i20 = i24;
                                    i15 = i11;
                                    zzefVar = zzefVar4;
                                    i63 = i23;
                                    bArr2 = bArr4;
                                    i22 = i25;
                                    break;
                                case 4:
                                case 11:
                                    i25 = i67;
                                    unsafe2 = unsafe3;
                                    i27 = i108;
                                    i28 = i69;
                                    i26 = i19;
                                    zzbcVar3 = zzbcVar7;
                                    if (z10 == 0) {
                                        i23 |= i104;
                                        i29 = zzbd.zzh(bArr4, i27, zzbcVar3);
                                        unsafe2.putInt(obj2, j10, zzbcVar3.zza);
                                        i54 = i11;
                                        i55 = i12;
                                        i59 = i29;
                                        zzbcVar7 = zzbcVar3;
                                        i61 = i26;
                                        i64 = i28;
                                        i62 = i24;
                                        i60 = i25;
                                        i56 = 3;
                                        i58 = -1;
                                        i63 = i23;
                                        unsafe3 = unsafe2;
                                        break;
                                    }
                                    i13 = i12;
                                    i21 = i27;
                                    zzbcVar2 = zzbcVar3;
                                    i61 = i26;
                                    unsafe = unsafe2;
                                    i66 = i28;
                                    i20 = i24;
                                    i15 = i11;
                                    zzefVar = zzefVar4;
                                    i63 = i23;
                                    bArr2 = bArr4;
                                    i22 = i25;
                                    break;
                                case 5:
                                case 14:
                                    i25 = i67;
                                    unsafe2 = unsafe3;
                                    i27 = i108;
                                    i28 = i69;
                                    i26 = i19;
                                    zzbcVar3 = zzbcVar7;
                                    if (z10 == 1) {
                                        unsafe2.putLong(obj, j10, zzbd.zzn(bArr4, i27));
                                        i54 = i11;
                                        i55 = i12;
                                        i59 = i27 + 8;
                                        zzbcVar7 = zzbcVar3;
                                        i61 = i26;
                                        i64 = i28;
                                        i62 = i24;
                                        i60 = i25;
                                        i56 = 3;
                                        i63 = i104 | i23;
                                        unsafe3 = unsafe2;
                                        i58 = -1;
                                        break;
                                    }
                                    i13 = i12;
                                    i21 = i27;
                                    zzbcVar2 = zzbcVar3;
                                    i61 = i26;
                                    unsafe = unsafe2;
                                    i66 = i28;
                                    i20 = i24;
                                    i15 = i11;
                                    zzefVar = zzefVar4;
                                    i63 = i23;
                                    bArr2 = bArr4;
                                    i22 = i25;
                                    break;
                                case 6:
                                case 13:
                                    i25 = i67;
                                    unsafe2 = unsafe3;
                                    i27 = i108;
                                    i28 = i69;
                                    i26 = i19;
                                    zzbcVar3 = zzbcVar7;
                                    if (z10 == 5) {
                                        i29 = i27 + 4;
                                        i23 |= i104;
                                        unsafe2.putInt(obj2, j10, zzbd.zzb(bArr4, i27));
                                        i54 = i11;
                                        i55 = i12;
                                        i59 = i29;
                                        zzbcVar7 = zzbcVar3;
                                        i61 = i26;
                                        i64 = i28;
                                        i62 = i24;
                                        i60 = i25;
                                        i56 = 3;
                                        i58 = -1;
                                        i63 = i23;
                                        unsafe3 = unsafe2;
                                        break;
                                    }
                                    i13 = i12;
                                    i21 = i27;
                                    zzbcVar2 = zzbcVar3;
                                    i61 = i26;
                                    unsafe = unsafe2;
                                    i66 = i28;
                                    i20 = i24;
                                    i15 = i11;
                                    zzefVar = zzefVar4;
                                    i63 = i23;
                                    bArr2 = bArr4;
                                    i22 = i25;
                                    break;
                                case 7:
                                    i25 = i67;
                                    unsafe2 = unsafe3;
                                    i27 = i108;
                                    i28 = i69;
                                    i26 = i19;
                                    zzbcVar3 = zzbcVar7;
                                    if (z10 == 0) {
                                        i23 |= i104;
                                        i29 = zzbd.zzk(bArr4, i27, zzbcVar3);
                                        zzfp.zzm(obj2, j10, zzbcVar3.zzb != 0);
                                        i54 = i11;
                                        i55 = i12;
                                        i59 = i29;
                                        zzbcVar7 = zzbcVar3;
                                        i61 = i26;
                                        i64 = i28;
                                        i62 = i24;
                                        i60 = i25;
                                        i56 = 3;
                                        i58 = -1;
                                        i63 = i23;
                                        unsafe3 = unsafe2;
                                        break;
                                    }
                                    i13 = i12;
                                    i21 = i27;
                                    zzbcVar2 = zzbcVar3;
                                    i61 = i26;
                                    unsafe = unsafe2;
                                    i66 = i28;
                                    i20 = i24;
                                    i15 = i11;
                                    zzefVar = zzefVar4;
                                    i63 = i23;
                                    bArr2 = bArr4;
                                    i22 = i25;
                                    break;
                                case 8:
                                    i25 = i67;
                                    unsafe2 = unsafe3;
                                    i27 = i108;
                                    i28 = i69;
                                    i26 = i19;
                                    zzbcVar3 = zzbcVar7;
                                    if (z10 == 2) {
                                        if ((i68 & 536870912) != 0) {
                                            i29 = zzbd.zzh(bArr4, i27, zzbcVar3);
                                            int i109 = zzbcVar3.zza;
                                            if (i109 < 0) {
                                                throw zzdc.zzd();
                                            }
                                            int i110 = i23 | i104;
                                            if (i109 == 0) {
                                                zzbcVar3.zzc = "";
                                                i31 = i110;
                                            } else {
                                                int i111 = zzfu.zza;
                                                int length = bArr4.length;
                                                if ((((length - i29) - i109) | i29 | i109) >= 0) {
                                                    int i112 = i29 + i109;
                                                    char[] cArr = new char[i109];
                                                    int i113 = 0;
                                                    while (i29 < i112) {
                                                        byte b10 = bArr4[i29];
                                                        if (zzfq.zzd(b10)) {
                                                            i29++;
                                                            cArr[i113] = (char) b10;
                                                            i113++;
                                                        } else {
                                                            while (true) {
                                                                while (i29 < i112) {
                                                                    int i114 = i29 + 1;
                                                                    byte b11 = bArr4[i29];
                                                                    if (zzfq.zzd(b11)) {
                                                                        cArr[i113] = (char) b11;
                                                                        i113++;
                                                                        i29 = i114;
                                                                        while (i29 < i112) {
                                                                            byte b12 = bArr4[i29];
                                                                            if (zzfq.zzd(b12)) {
                                                                                i29++;
                                                                                cArr[i113] = (char) b12;
                                                                                i113++;
                                                                            }
                                                                        }
                                                                    } else {
                                                                        int i115 = i110;
                                                                        if (b11 < -32) {
                                                                            if (i114 < i112) {
                                                                                i29 += 2;
                                                                                zzfq.zzc(b11, bArr4[i114], cArr, i113);
                                                                                i113++;
                                                                                i110 = i115;
                                                                            } else {
                                                                                throw zzdc.zzc();
                                                                            }
                                                                        } else if (b11 < -16) {
                                                                            if (i114 < i112 - 1) {
                                                                                int i116 = i29 + 2;
                                                                                i29 += 3;
                                                                                zzfq.zzb(b11, bArr4[i114], bArr4[i116], cArr, i113);
                                                                                i110 = i115;
                                                                                i113++;
                                                                            } else {
                                                                                throw zzdc.zzc();
                                                                            }
                                                                        } else if (i114 < i112 - 2) {
                                                                            byte b13 = bArr4[i114];
                                                                            int i117 = i29 + 3;
                                                                            byte b14 = bArr4[i29 + 2];
                                                                            i29 += 4;
                                                                            zzfq.zza(b11, b13, b14, bArr4[i117], cArr, i113);
                                                                            i113 += 2;
                                                                            i110 = i115;
                                                                        } else {
                                                                            throw zzdc.zzc();
                                                                        }
                                                                    }
                                                                }
                                                                i31 = i110;
                                                                zzbcVar3.zzc = new String(cArr, 0, i113);
                                                                i29 = i112;
                                                            }
                                                        }
                                                    }
                                                    while (true) {
                                                        while (i29 < i112) {
                                                        }
                                                        i31 = i110;
                                                        zzbcVar3.zzc = new String(cArr, 0, i113);
                                                        i29 = i112;
                                                    }
                                                } else {
                                                    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i29), Integer.valueOf(i109)));
                                                }
                                            }
                                            i23 = i31;
                                        } else {
                                            i29 = zzbd.zzh(bArr4, i27, zzbcVar3);
                                            int i118 = zzbcVar3.zza;
                                            if (i118 < 0) {
                                                throw zzdc.zzd();
                                            }
                                            i23 |= i104;
                                            if (i118 == 0) {
                                                zzbcVar3.zzc = "";
                                            } else {
                                                zzbcVar3.zzc = new String(bArr4, i29, i118, zzda.zzb);
                                                i29 += i118;
                                            }
                                        }
                                        unsafe2.putObject(obj2, j10, zzbcVar3.zzc);
                                        i54 = i11;
                                        i55 = i12;
                                        i59 = i29;
                                        zzbcVar7 = zzbcVar3;
                                        i61 = i26;
                                        i64 = i28;
                                        i62 = i24;
                                        i60 = i25;
                                        i56 = 3;
                                        i58 = -1;
                                        i63 = i23;
                                        unsafe3 = unsafe2;
                                        break;
                                    }
                                    i13 = i12;
                                    i21 = i27;
                                    zzbcVar2 = zzbcVar3;
                                    i61 = i26;
                                    unsafe = unsafe2;
                                    i66 = i28;
                                    i20 = i24;
                                    i15 = i11;
                                    zzefVar = zzefVar4;
                                    i63 = i23;
                                    bArr2 = bArr4;
                                    i22 = i25;
                                    break;
                                case 9:
                                    i25 = i67;
                                    unsafe2 = unsafe3;
                                    i32 = i108;
                                    i28 = i69;
                                    i26 = i19;
                                    zzbcVar3 = zzbcVar7;
                                    if (z10 == 2) {
                                        i30 = i23 | i104;
                                        Object zzx = zzefVar4.zzx(obj2, i26);
                                        i54 = i11;
                                        int zzm2 = zzbd.zzm(zzx, zzefVar4.zzv(i26), bArr, i32, i54, zzbcVar);
                                        zzefVar4.zzF(obj2, i26, zzx);
                                        i55 = i12;
                                        i59 = zzm2;
                                        zzbcVar7 = zzbcVar3;
                                        i61 = i26;
                                        i64 = i28;
                                        i62 = i24;
                                        i56 = 3;
                                        i58 = -1;
                                        i63 = i30;
                                        unsafe3 = unsafe2;
                                        i60 = i25;
                                        break;
                                    }
                                    i27 = i32;
                                    i13 = i12;
                                    i21 = i27;
                                    zzbcVar2 = zzbcVar3;
                                    i61 = i26;
                                    unsafe = unsafe2;
                                    i66 = i28;
                                    i20 = i24;
                                    i15 = i11;
                                    zzefVar = zzefVar4;
                                    i63 = i23;
                                    bArr2 = bArr4;
                                    i22 = i25;
                                    break;
                                case 10:
                                    i25 = i67;
                                    unsafe2 = unsafe3;
                                    i32 = i108;
                                    i28 = i69;
                                    i26 = i19;
                                    zzbcVar3 = zzbcVar7;
                                    if (z10 == 2) {
                                        i23 |= i104;
                                        i29 = zzbd.zza(bArr4, i32, zzbcVar3);
                                        unsafe2.putObject(obj2, j10, zzbcVar3.zzc);
                                        i54 = i11;
                                        i55 = i12;
                                        i59 = i29;
                                        zzbcVar7 = zzbcVar3;
                                        i61 = i26;
                                        i64 = i28;
                                        i62 = i24;
                                        i60 = i25;
                                        i56 = 3;
                                        i58 = -1;
                                        i63 = i23;
                                        unsafe3 = unsafe2;
                                        break;
                                    }
                                    i27 = i32;
                                    i13 = i12;
                                    i21 = i27;
                                    zzbcVar2 = zzbcVar3;
                                    i61 = i26;
                                    unsafe = unsafe2;
                                    i66 = i28;
                                    i20 = i24;
                                    i15 = i11;
                                    zzefVar = zzefVar4;
                                    i63 = i23;
                                    bArr2 = bArr4;
                                    i22 = i25;
                                    break;
                                case 12:
                                    i25 = i67;
                                    unsafe2 = unsafe3;
                                    i32 = i108;
                                    i28 = i69;
                                    i26 = i19;
                                    zzbcVar3 = zzbcVar7;
                                    if (z10 == 0) {
                                        i29 = zzbd.zzh(bArr4, i32, zzbcVar3);
                                        int i119 = zzbcVar3.zza;
                                        zzcw zzu3 = zzefVar4.zzu(i26);
                                        if ((i68 & Integer.MIN_VALUE) != 0 && zzu3 != null && !zzu3.zza(i119)) {
                                            zzd(obj).zzj(i28, Long.valueOf(i119));
                                        } else {
                                            i23 |= i104;
                                            unsafe2.putInt(obj2, j10, i119);
                                        }
                                        i54 = i11;
                                        i55 = i12;
                                        i59 = i29;
                                        zzbcVar7 = zzbcVar3;
                                        i61 = i26;
                                        i64 = i28;
                                        i62 = i24;
                                        i60 = i25;
                                        i56 = 3;
                                        i58 = -1;
                                        i63 = i23;
                                        unsafe3 = unsafe2;
                                        break;
                                    }
                                    i27 = i32;
                                    i13 = i12;
                                    i21 = i27;
                                    zzbcVar2 = zzbcVar3;
                                    i61 = i26;
                                    unsafe = unsafe2;
                                    i66 = i28;
                                    i20 = i24;
                                    i15 = i11;
                                    zzefVar = zzefVar4;
                                    i63 = i23;
                                    bArr2 = bArr4;
                                    i22 = i25;
                                    break;
                                case 15:
                                    i25 = i67;
                                    Unsafe unsafe8 = unsafe3;
                                    i32 = i108;
                                    i28 = i69;
                                    i26 = i19;
                                    zzbcVar3 = zzbcVar7;
                                    if (z10 != 0) {
                                        unsafe2 = unsafe8;
                                        i27 = i32;
                                        i13 = i12;
                                        i21 = i27;
                                        zzbcVar2 = zzbcVar3;
                                        i61 = i26;
                                        unsafe = unsafe2;
                                        i66 = i28;
                                        i20 = i24;
                                        i15 = i11;
                                        zzefVar = zzefVar4;
                                        i63 = i23;
                                        bArr2 = bArr4;
                                        i22 = i25;
                                        break;
                                    } else {
                                        i23 |= i104;
                                        i29 = zzbd.zzh(bArr4, i32, zzbcVar3);
                                        unsafe2 = unsafe8;
                                        unsafe2.putInt(obj2, j10, zzbu.zzb(zzbcVar3.zza));
                                        i54 = i11;
                                        i55 = i12;
                                        i59 = i29;
                                        zzbcVar7 = zzbcVar3;
                                        i61 = i26;
                                        i64 = i28;
                                        i62 = i24;
                                        i60 = i25;
                                        i56 = 3;
                                        i58 = -1;
                                        i63 = i23;
                                        unsafe3 = unsafe2;
                                        break;
                                    }
                                case 16:
                                    i25 = i67;
                                    Unsafe unsafe9 = unsafe3;
                                    i28 = i69;
                                    i26 = i19;
                                    if (z10 != 0) {
                                        zzbcVar3 = zzbcVar7;
                                        i27 = i108;
                                        unsafe2 = unsafe9;
                                        i13 = i12;
                                        i21 = i27;
                                        zzbcVar2 = zzbcVar3;
                                        i61 = i26;
                                        unsafe = unsafe2;
                                        i66 = i28;
                                        i20 = i24;
                                        i15 = i11;
                                        zzefVar = zzefVar4;
                                        i63 = i23;
                                        bArr2 = bArr4;
                                        i22 = i25;
                                        break;
                                    } else {
                                        int i120 = i23 | i104;
                                        int zzk2 = zzbd.zzk(bArr4, i108, zzbcVar7);
                                        unsafe9.putLong(obj, j10, zzbu.zzc(zzbcVar7.zzb));
                                        i54 = i11;
                                        i55 = i12;
                                        i59 = zzk2;
                                        zzbcVar7 = zzbcVar7;
                                        i61 = i26;
                                        i64 = i28;
                                        i62 = i24;
                                        unsafe3 = unsafe9;
                                        i60 = i25;
                                        i56 = 3;
                                        i58 = -1;
                                        i57 = 0;
                                        i63 = i120;
                                    }
                                default:
                                    i56 = 3;
                                    if (z10 != 3) {
                                        i25 = i67;
                                        i26 = i19;
                                        unsafe2 = unsafe3;
                                        i27 = i108;
                                        i28 = i69;
                                        zzbcVar3 = zzbcVar7;
                                        i13 = i12;
                                        i21 = i27;
                                        zzbcVar2 = zzbcVar3;
                                        i61 = i26;
                                        unsafe = unsafe2;
                                        i66 = i28;
                                        i20 = i24;
                                        i15 = i11;
                                        zzefVar = zzefVar4;
                                        i63 = i23;
                                        bArr2 = bArr4;
                                        i22 = i25;
                                        break;
                                    } else {
                                        int i121 = i23 | i104;
                                        Object zzx2 = zzefVar4.zzx(obj2, i19);
                                        int i122 = i19;
                                        i59 = zzbd.zzl(zzx2, zzefVar4.zzv(i19), bArr, i108, i11, (i67 << 3) | 4, zzbcVar);
                                        zzefVar4.zzF(obj2, i122, zzx2);
                                        i64 = i69;
                                        i61 = i122;
                                        i62 = i24;
                                        unsafe3 = unsafe3;
                                        i60 = i67;
                                        i58 = -1;
                                        i57 = 0;
                                        i54 = i11;
                                        i55 = i12;
                                        i63 = i121;
                                    }
                            }
                        }
                        i57 = 0;
                    }
                    if (i66 == i13 || i13 == 0) {
                        if (!zzefVar.zzh && (zzcdVar = zzbcVar2.zzd) != zzcd.zza) {
                            if (zzcdVar.zzb(zzefVar.zzg, i22) == null) {
                                zzg = zzbd.zzg(i66, bArr, i21, i11, zzd(obj), zzbcVar);
                            } else {
                                throw null;
                            }
                        } else {
                            zzg = zzbd.zzg(i66, bArr, i21, i11, zzd(obj), zzbcVar);
                        }
                        zzbcVar7 = zzbcVar;
                        i64 = i66;
                        i55 = i13;
                        i54 = i15;
                        i60 = i22;
                        i62 = i20;
                        unsafe3 = unsafe;
                        i56 = 3;
                        i58 = -1;
                        bArr4 = bArr2;
                        i59 = zzg;
                        zzefVar4 = zzefVar;
                        i57 = 0;
                    } else {
                        i17 = i66;
                        i16 = i63;
                        i18 = i20;
                        i14 = 1048575;
                        i59 = i21;
                    }
                } else {
                    zzq = zzefVar4.zzq(i67, i57);
                }
                i19 = zzq;
                if (i19 != i58) {
                }
                if (i66 == i13) {
                }
                if (!zzefVar.zzh) {
                }
                zzg = zzbd.zzg(i66, bArr, i21, i11, zzd(obj), zzbcVar);
                zzbcVar7 = zzbcVar;
                i64 = i66;
                i55 = i13;
                i54 = i15;
                i60 = i22;
                i62 = i20;
                unsafe3 = unsafe;
                i56 = 3;
                i58 = -1;
                bArr4 = bArr2;
                i59 = zzg;
                zzefVar4 = zzefVar;
                i57 = 0;
            } else {
                zzefVar = zzefVar4;
                i13 = i55;
                unsafe = unsafe3;
                i14 = 1048575;
                i15 = i54;
                i16 = i63;
                i17 = i64;
                i18 = i62;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final Object zze() {
        return ((zzcs) this.zzg).zzl();
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzcs) {
                zzcs zzcsVar = (zzcs) obj;
                zzcsVar.zzu(Integer.MAX_VALUE);
                zzcsVar.zza = 0;
                zzcsVar.zzs();
            }
            int[] iArr = this.zzc;
            for (int i10 = 0; i10 < iArr.length; i10 += 3) {
                int zzs = zzs(i10);
                int i11 = 1048575 & zzs;
                int zzr = zzr(zzs);
                long j10 = i11;
                if (zzr != 9) {
                    if (zzr != 60 && zzr != 68) {
                        switch (zzr) {
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
                                this.zzl.zza(obj, j10);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j10);
                                if (object != null) {
                                    ((zzdw) object).zzc();
                                    unsafe.putObject(obj, j10, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzM(obj, this.zzc[i10], i10)) {
                        zzv(i10).zzf(zzb.getObject(obj, j10));
                    }
                }
                if (zzI(obj, i10)) {
                    zzv(i10).zzf(zzb.getObject(obj, j10));
                }
            }
            this.zzm.zzg(obj);
            if (this.zzh) {
                this.zzn.zzd(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        for (int i10 = 0; i10 < this.zzc.length; i10 += 3) {
            int zzs = zzs(i10);
            int i11 = 1048575 & zzs;
            int[] iArr = this.zzc;
            int zzr = zzr(zzs);
            int i12 = iArr[i10];
            long j10 = i11;
            switch (zzr) {
                case 0:
                    if (zzI(obj2, i10)) {
                        zzfp.zzo(obj, j10, zzfp.zza(obj2, j10));
                        zzD(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzI(obj2, i10)) {
                        zzfp.zzp(obj, j10, zzfp.zzb(obj2, j10));
                        zzD(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzI(obj2, i10)) {
                        zzfp.zzr(obj, j10, zzfp.zzd(obj2, j10));
                        zzD(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzI(obj2, i10)) {
                        zzfp.zzr(obj, j10, zzfp.zzd(obj2, j10));
                        zzD(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzI(obj2, i10)) {
                        zzfp.zzq(obj, j10, zzfp.zzc(obj2, j10));
                        zzD(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzI(obj2, i10)) {
                        zzfp.zzr(obj, j10, zzfp.zzd(obj2, j10));
                        zzD(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzI(obj2, i10)) {
                        zzfp.zzq(obj, j10, zzfp.zzc(obj2, j10));
                        zzD(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzI(obj2, i10)) {
                        zzfp.zzm(obj, j10, zzfp.zzw(obj2, j10));
                        zzD(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzI(obj2, i10)) {
                        zzfp.zzs(obj, j10, zzfp.zzf(obj2, j10));
                        zzD(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzB(obj, obj2, i10);
                    break;
                case 10:
                    if (zzI(obj2, i10)) {
                        zzfp.zzs(obj, j10, zzfp.zzf(obj2, j10));
                        zzD(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzI(obj2, i10)) {
                        zzfp.zzq(obj, j10, zzfp.zzc(obj2, j10));
                        zzD(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzI(obj2, i10)) {
                        zzfp.zzq(obj, j10, zzfp.zzc(obj2, j10));
                        zzD(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzI(obj2, i10)) {
                        zzfp.zzq(obj, j10, zzfp.zzc(obj2, j10));
                        zzD(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzI(obj2, i10)) {
                        zzfp.zzr(obj, j10, zzfp.zzd(obj2, j10));
                        zzD(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzI(obj2, i10)) {
                        zzfp.zzq(obj, j10, zzfp.zzc(obj2, j10));
                        zzD(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzI(obj2, i10)) {
                        zzfp.zzr(obj, j10, zzfp.zzd(obj2, j10));
                        zzD(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzB(obj, obj2, i10);
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
                    this.zzl.zzb(obj, obj2, j10);
                    break;
                case 50:
                    int i13 = zzeq.zza;
                    zzfp.zzs(obj, j10, zzdx.zza(zzfp.zzf(obj, j10), zzfp.zzf(obj2, j10)));
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
                    if (zzM(obj2, i12, i10)) {
                        zzfp.zzs(obj, j10, zzfp.zzf(obj2, j10));
                        zzE(obj, i12, i10);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzC(obj, obj2, i10);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzM(obj2, i12, i10)) {
                        zzfp.zzs(obj, j10, zzfp.zzf(obj2, j10));
                        zzE(obj, i12, i10);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzC(obj, obj2, i10);
                    break;
            }
        }
        zzeq.zzq(this.zzm, obj, obj2);
        if (this.zzh) {
            zzeq.zzp(this.zzn, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final void zzh(Object obj, byte[] bArr, int i10, int i11, zzbc zzbcVar) throws IOException {
        zzc(obj, bArr, i10, i11, 0, zzbcVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0096. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:254:0x073b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0035  */
    @Override // com.google.android.gms.internal.play_billing.zzeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzi(Object obj, zzfx zzfxVar) throws IOException {
        Map.Entry entry;
        Iterator it;
        int[] iArr;
        int i10;
        int i11;
        int i12;
        Map.Entry entry2;
        int i13;
        int i14;
        Iterator it2;
        int[] iArr2;
        Map.Entry entry3;
        int i15;
        if (this.zzh) {
            zzci zzb2 = this.zzn.zzb(obj);
            if (!zzb2.zza.isEmpty()) {
                Iterator zzf = zzb2.zzf();
                entry = (Map.Entry) zzf.next();
                it = zzf;
                iArr = this.zzc;
                Unsafe unsafe = zzb;
                int i16 = 1048575;
                int i17 = 1048575;
                int i18 = 0;
                i10 = 0;
                while (i10 < iArr.length) {
                    int zzs = zzs(i10);
                    int[] iArr3 = this.zzc;
                    int zzr = zzr(zzs);
                    int i19 = iArr3[i10];
                    if (zzr <= 17) {
                        int i20 = iArr3[i10 + 2];
                        int i21 = i20 & i16;
                        if (i21 != i17) {
                            if (i21 == i16) {
                                i11 = zzr;
                                i18 = 0;
                            } else {
                                i11 = zzr;
                                i18 = unsafe.getInt(obj, i21);
                            }
                            i17 = i21;
                        } else {
                            i11 = zzr;
                        }
                        i12 = i17;
                        entry2 = entry;
                        i13 = i18;
                        i14 = 1 << (i20 >>> 20);
                    } else {
                        i11 = zzr;
                        i12 = i17;
                        entry2 = entry;
                        i13 = i18;
                        i14 = 0;
                    }
                    while (entry2 != null && this.zzn.zza(entry2) <= i19) {
                        this.zzn.zze(zzfxVar, entry2);
                        if (it.hasNext()) {
                            entry2 = (Map.Entry) it.next();
                        } else {
                            entry2 = null;
                        }
                    }
                    long j10 = zzs & 1048575;
                    switch (i11) {
                        case 0:
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            if (zzJ(obj, i15, i12, i13, i14)) {
                                zzfxVar.zzf(i19, zzfp.zza(obj, j10));
                            }
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 1:
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            if (zzJ(obj, i15, i12, i13, i14)) {
                                zzfxVar.zzo(i19, zzfp.zzb(obj, j10));
                            }
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 2:
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            if (zzJ(obj, i15, i12, i13, i14)) {
                                zzfxVar.zzt(i19, unsafe.getLong(obj, j10));
                            }
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 3:
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            if (zzJ(obj, i15, i12, i13, i14)) {
                                zzfxVar.zzK(i19, unsafe.getLong(obj, j10));
                            }
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 4:
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            if (zzJ(obj, i15, i12, i13, i14)) {
                                zzfxVar.zzr(i19, unsafe.getInt(obj, j10));
                            }
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 5:
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            if (zzJ(obj, i15, i12, i13, i14)) {
                                zzfxVar.zzm(i19, unsafe.getLong(obj, j10));
                            }
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 6:
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            if (zzJ(obj, i15, i12, i13, i14)) {
                                zzfxVar.zzk(i19, unsafe.getInt(obj, j10));
                            }
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 7:
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            if (zzJ(obj, i15, i12, i13, i14)) {
                                zzfxVar.zzb(i19, zzfp.zzw(obj, j10));
                            }
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 8:
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            if (zzJ(obj, i15, i12, i13, i14)) {
                                zzO(i19, unsafe.getObject(obj, j10), zzfxVar);
                            }
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 9:
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            if (zzJ(obj, i15, i12, i13, i14)) {
                                zzfxVar.zzv(i19, unsafe.getObject(obj, j10), zzv(i15));
                            }
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 10:
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            if (zzJ(obj, i15, i12, i13, i14)) {
                                zzfxVar.zzd(i19, (zzbq) unsafe.getObject(obj, j10));
                            }
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 11:
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            if (zzJ(obj, i15, i12, i13, i14)) {
                                zzfxVar.zzI(i19, unsafe.getInt(obj, j10));
                            }
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 12:
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            if (zzJ(obj, i15, i12, i13, i14)) {
                                zzfxVar.zzi(i19, unsafe.getInt(obj, j10));
                            }
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 13:
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            if (zzJ(obj, i15, i12, i13, i14)) {
                                zzfxVar.zzx(i19, unsafe.getInt(obj, j10));
                            }
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 14:
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            if (zzJ(obj, i15, i12, i13, i14)) {
                                zzfxVar.zzz(i19, unsafe.getLong(obj, j10));
                            }
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 15:
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            if (zzJ(obj, i15, i12, i13, i14)) {
                                zzfxVar.zzB(i19, unsafe.getInt(obj, j10));
                            }
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 16:
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            if (zzJ(obj, i15, i12, i13, i14)) {
                                zzfxVar.zzD(i19, unsafe.getLong(obj, j10));
                            }
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 17:
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            if (zzJ(obj, i10, i12, i13, i14)) {
                                zzfxVar.zzq(i19, unsafe.getObject(obj, j10), zzv(i15));
                            }
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 18:
                            zzeq.zzt(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, false);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 19:
                            zzeq.zzx(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, false);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 20:
                            zzeq.zzz(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, false);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 21:
                            zzeq.zzF(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, false);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 22:
                            zzeq.zzy(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, false);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 23:
                            zzeq.zzw(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, false);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 24:
                            zzeq.zzv(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, false);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 25:
                            zzeq.zzs(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, false);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 26:
                            int i22 = this.zzc[i10];
                            List list = (List) unsafe.getObject(obj, j10);
                            int i23 = zzeq.zza;
                            if (list != null && !list.isEmpty()) {
                                zzfxVar.zzH(i22, list);
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                            break;
                        case 27:
                            int i24 = this.zzc[i10];
                            List list2 = (List) unsafe.getObject(obj, j10);
                            zzeo zzv = zzv(i10);
                            int i25 = zzeq.zza;
                            if (list2 != null && !list2.isEmpty()) {
                                for (int i26 = 0; i26 < list2.size(); i26++) {
                                    ((zzbz) zzfxVar).zzv(i24, list2.get(i26), zzv);
                                }
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                            break;
                        case 28:
                            int i27 = this.zzc[i10];
                            List list3 = (List) unsafe.getObject(obj, j10);
                            int i28 = zzeq.zza;
                            if (list3 != null && !list3.isEmpty()) {
                                zzfxVar.zze(i27, list3);
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                            break;
                        case 29:
                            zzeq.zzE(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, false);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 30:
                            zzeq.zzu(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, false);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 31:
                            zzeq.zzA(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, false);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 32:
                            zzeq.zzB(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, false);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 33:
                            zzeq.zzC(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, false);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 34:
                            zzeq.zzD(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, false);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 35:
                            zzeq.zzt(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, true);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 36:
                            zzeq.zzx(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, true);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 37:
                            zzeq.zzz(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, true);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 38:
                            zzeq.zzF(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, true);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 39:
                            zzeq.zzy(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, true);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 40:
                            zzeq.zzw(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, true);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 41:
                            zzeq.zzv(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, true);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 42:
                            zzeq.zzs(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, true);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 43:
                            zzeq.zzE(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, true);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 44:
                            zzeq.zzu(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, true);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 45:
                            zzeq.zzA(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, true);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 46:
                            zzeq.zzB(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, true);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 47:
                            zzeq.zzC(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, true);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 48:
                            zzeq.zzD(this.zzc[i10], (List) unsafe.getObject(obj, j10), zzfxVar, true);
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 49:
                            int i29 = this.zzc[i10];
                            List list4 = (List) unsafe.getObject(obj, j10);
                            zzeo zzv2 = zzv(i10);
                            int i30 = zzeq.zza;
                            if (list4 != null && !list4.isEmpty()) {
                                for (int i31 = 0; i31 < list4.size(); i31++) {
                                    ((zzbz) zzfxVar).zzq(i29, list4.get(i31), zzv2);
                                }
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                            break;
                        case 50:
                            if (unsafe.getObject(obj, j10) != null) {
                                throw null;
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 51:
                            if (zzM(obj, i19, i10)) {
                                zzfxVar.zzf(i19, zzm(obj, j10));
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 52:
                            if (zzM(obj, i19, i10)) {
                                zzfxVar.zzo(i19, zzn(obj, j10));
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 53:
                            if (zzM(obj, i19, i10)) {
                                zzfxVar.zzt(i19, zzt(obj, j10));
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 54:
                            if (zzM(obj, i19, i10)) {
                                zzfxVar.zzK(i19, zzt(obj, j10));
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 55:
                            if (zzM(obj, i19, i10)) {
                                zzfxVar.zzr(i19, zzo(obj, j10));
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 56:
                            if (zzM(obj, i19, i10)) {
                                zzfxVar.zzm(i19, zzt(obj, j10));
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 57:
                            if (zzM(obj, i19, i10)) {
                                zzfxVar.zzk(i19, zzo(obj, j10));
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 58:
                            if (zzM(obj, i19, i10)) {
                                zzfxVar.zzb(i19, zzN(obj, j10));
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 59:
                            if (zzM(obj, i19, i10)) {
                                zzO(i19, unsafe.getObject(obj, j10), zzfxVar);
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 60:
                            if (zzM(obj, i19, i10)) {
                                zzfxVar.zzv(i19, unsafe.getObject(obj, j10), zzv(i10));
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 61:
                            if (zzM(obj, i19, i10)) {
                                zzfxVar.zzd(i19, (zzbq) unsafe.getObject(obj, j10));
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 62:
                            if (zzM(obj, i19, i10)) {
                                zzfxVar.zzI(i19, zzo(obj, j10));
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 63:
                            if (zzM(obj, i19, i10)) {
                                zzfxVar.zzi(i19, zzo(obj, j10));
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 64:
                            if (zzM(obj, i19, i10)) {
                                zzfxVar.zzx(i19, zzo(obj, j10));
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 65:
                            if (zzM(obj, i19, i10)) {
                                zzfxVar.zzz(i19, zzt(obj, j10));
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 66:
                            if (zzM(obj, i19, i10)) {
                                zzfxVar.zzB(i19, zzo(obj, j10));
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 67:
                            if (zzM(obj, i19, i10)) {
                                zzfxVar.zzD(i19, zzt(obj, j10));
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        case 68:
                            if (zzM(obj, i19, i10)) {
                                zzfxVar.zzq(i19, unsafe.getObject(obj, j10), zzv(i10));
                            }
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                        default:
                            it2 = it;
                            iArr2 = iArr;
                            entry3 = entry2;
                            i15 = i10;
                            i10 = i15 + 3;
                            i17 = i12;
                            i18 = i13;
                            it = it2;
                            iArr = iArr2;
                            entry = entry3;
                            i16 = 1048575;
                    }
                }
                Iterator it3 = it;
                while (entry != null) {
                    this.zzn.zze(zzfxVar, entry);
                    if (it3.hasNext()) {
                        entry = (Map.Entry) it3.next();
                    } else {
                        entry = null;
                    }
                }
                zzff zzffVar = this.zzm;
                zzffVar.zzj(zzffVar.zzd(obj), zzfxVar);
            }
        }
        entry = null;
        it = null;
        iArr = this.zzc;
        Unsafe unsafe2 = zzb;
        int i162 = 1048575;
        int i172 = 1048575;
        int i182 = 0;
        i10 = 0;
        while (i10 < iArr.length) {
        }
        Iterator it32 = it;
        while (entry != null) {
        }
        zzff zzffVar2 = this.zzm;
        zzffVar2.zzj(zzffVar2.zzd(obj), zzfxVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01c4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01c0 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.zzeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzj(Object obj, Object obj2) {
        boolean zzG;
        for (int i10 = 0; i10 < this.zzc.length; i10 += 3) {
            int zzs = zzs(i10);
            long j10 = zzs & 1048575;
            switch (zzr(zzs)) {
                case 0:
                    if (zzH(obj, obj2, i10) && Double.doubleToLongBits(zzfp.zza(obj, j10)) == Double.doubleToLongBits(zzfp.zza(obj2, j10))) {
                    }
                    return false;
                case 1:
                    if (zzH(obj, obj2, i10) && Float.floatToIntBits(zzfp.zzb(obj, j10)) == Float.floatToIntBits(zzfp.zzb(obj2, j10))) {
                    }
                    return false;
                case 2:
                    if (zzH(obj, obj2, i10) && zzfp.zzd(obj, j10) == zzfp.zzd(obj2, j10)) {
                    }
                    return false;
                case 3:
                    if (zzH(obj, obj2, i10) && zzfp.zzd(obj, j10) == zzfp.zzd(obj2, j10)) {
                    }
                    return false;
                case 4:
                    if (zzH(obj, obj2, i10) && zzfp.zzc(obj, j10) == zzfp.zzc(obj2, j10)) {
                    }
                    return false;
                case 5:
                    if (zzH(obj, obj2, i10) && zzfp.zzd(obj, j10) == zzfp.zzd(obj2, j10)) {
                    }
                    return false;
                case 6:
                    if (zzH(obj, obj2, i10) && zzfp.zzc(obj, j10) == zzfp.zzc(obj2, j10)) {
                    }
                    return false;
                case 7:
                    if (zzH(obj, obj2, i10) && zzfp.zzw(obj, j10) == zzfp.zzw(obj2, j10)) {
                    }
                    return false;
                case 8:
                    if (zzH(obj, obj2, i10) && zzeq.zzG(zzfp.zzf(obj, j10), zzfp.zzf(obj2, j10))) {
                    }
                    return false;
                case 9:
                    if (zzH(obj, obj2, i10) && zzeq.zzG(zzfp.zzf(obj, j10), zzfp.zzf(obj2, j10))) {
                    }
                    return false;
                case 10:
                    if (zzH(obj, obj2, i10) && zzeq.zzG(zzfp.zzf(obj, j10), zzfp.zzf(obj2, j10))) {
                    }
                    return false;
                case 11:
                    if (zzH(obj, obj2, i10) && zzfp.zzc(obj, j10) == zzfp.zzc(obj2, j10)) {
                    }
                    return false;
                case 12:
                    if (zzH(obj, obj2, i10) && zzfp.zzc(obj, j10) == zzfp.zzc(obj2, j10)) {
                    }
                    return false;
                case 13:
                    if (zzH(obj, obj2, i10) && zzfp.zzc(obj, j10) == zzfp.zzc(obj2, j10)) {
                    }
                    return false;
                case 14:
                    if (zzH(obj, obj2, i10) && zzfp.zzd(obj, j10) == zzfp.zzd(obj2, j10)) {
                    }
                    return false;
                case 15:
                    if (zzH(obj, obj2, i10) && zzfp.zzc(obj, j10) == zzfp.zzc(obj2, j10)) {
                    }
                    return false;
                case 16:
                    if (zzH(obj, obj2, i10) && zzfp.zzd(obj, j10) == zzfp.zzd(obj2, j10)) {
                    }
                    return false;
                case 17:
                    if (zzH(obj, obj2, i10) && zzeq.zzG(zzfp.zzf(obj, j10), zzfp.zzf(obj2, j10))) {
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
                    zzG = zzeq.zzG(zzfp.zzf(obj, j10), zzfp.zzf(obj2, j10));
                    if (zzG) {
                        return false;
                    }
                case 50:
                    zzG = zzeq.zzG(zzfp.zzf(obj, j10), zzfp.zzf(obj2, j10));
                    if (zzG) {
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
                    long zzp = zzp(i10) & 1048575;
                    if (zzfp.zzc(obj, zzp) == zzfp.zzc(obj2, zzp) && zzeq.zzG(zzfp.zzf(obj, j10), zzfp.zzf(obj2, j10))) {
                    }
                    return false;
                default:
            }
        }
        if (!this.zzm.zzd(obj).equals(this.zzm.zzd(obj2))) {
            return false;
        }
        if (this.zzh) {
            return this.zzn.zzb(obj).equals(this.zzn.zzb(obj2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
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
            int zzs = zzs(i15);
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
            if ((268435456 & zzs) != 0 && !zzJ(obj, i15, i10, i11, i19)) {
                return false;
            }
            int zzr = zzr(zzs);
            if (zzr != 9 && zzr != 17) {
                if (zzr != 27) {
                    if (zzr != 60 && zzr != 68) {
                        if (zzr != 49) {
                            if (zzr == 50 && !((zzdw) zzfp.zzf(obj, zzs & 1048575)).isEmpty()) {
                                throw null;
                            }
                        }
                    } else if (zzM(obj, i16, i15) && !zzK(obj, zzs, zzv(i15))) {
                        return false;
                    }
                }
                List list = (List) zzfp.zzf(obj, zzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzeo zzv = zzv(i15);
                    for (int i20 = 0; i20 < list.size(); i20++) {
                        if (!zzv.zzk(list.get(i20))) {
                            return false;
                        }
                    }
                }
            } else if (zzJ(obj, i15, i10, i11, i19) && !zzK(obj, zzs, zzv(i15))) {
                return false;
            }
            i14++;
            i12 = i10;
            i13 = i11;
        }
        if (this.zzh && !this.zzn.zzb(obj).zzj()) {
            return false;
        }
        return true;
    }
}
