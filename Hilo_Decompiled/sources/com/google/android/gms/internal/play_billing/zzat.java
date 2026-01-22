package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Objects;
import kotlin.UByte;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzat extends zzal {
    static final zzal zza = new zzat(null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient Object zzc;
    private final transient int zzd;

    private zzat(Object obj, Object[] objArr, int i10) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01b7  */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzat zzg(int i10, Object[] objArr, zzak zzakVar) {
        int i11;
        short[] sArr;
        char c10;
        char c11;
        boolean z10;
        int i12 = i10;
        Object[] objArr2 = objArr;
        if (i12 == 0) {
            return (zzat) zza;
        }
        Object obj = null;
        int i13 = 1;
        if (i12 == 1) {
            Object obj2 = objArr2[0];
            Objects.requireNonNull(obj2);
            Object obj3 = objArr2[1];
            Objects.requireNonNull(obj3);
            zzad.zza(obj2, obj3);
            return new zzat(null, objArr2, 1);
        }
        zzaa.zzb(i12, objArr2.length >> 1, FirebaseAnalytics.Param.INDEX);
        int max = Math.max(i12, 2);
        if (max < 751619276) {
            i11 = Integer.highestOneBit(max - 1);
            do {
                i11 += i11;
            } while (i11 * 0.7d < max);
        } else {
            i11 = 1073741824;
            if (max >= 1073741824) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i12 == 1) {
            Object obj4 = objArr2[0];
            Objects.requireNonNull(obj4);
            Object obj5 = objArr2[1];
            Objects.requireNonNull(obj5);
            zzad.zza(obj4, obj5);
            i12 = 1;
        } else {
            int i14 = i11 - 1;
            char c12 = 65535;
            if (i11 <= 128) {
                byte[] bArr = new byte[i11];
                Arrays.fill(bArr, (byte) -1);
                int i15 = 0;
                int i16 = 0;
                while (i15 < i12) {
                    int i17 = i16 + i16;
                    int i18 = i15 + i15;
                    Object obj6 = objArr2[i18];
                    Objects.requireNonNull(obj6);
                    Object obj7 = objArr2[i18 ^ i13];
                    Objects.requireNonNull(obj7);
                    zzad.zza(obj6, obj7);
                    int zza2 = zzae.zza(obj6.hashCode());
                    while (true) {
                        int i19 = zza2 & i14;
                        int i20 = bArr[i19] & UByte.MAX_VALUE;
                        if (i20 == 255) {
                            bArr[i19] = (byte) i17;
                            if (i16 < i15) {
                                objArr2[i17] = obj6;
                                objArr2[i17 ^ 1] = obj7;
                            }
                            i16++;
                        } else {
                            if (obj6.equals(objArr2[i20])) {
                                int i21 = i20 ^ 1;
                                Object obj8 = objArr2[i21];
                                Objects.requireNonNull(obj8);
                                zzaj zzajVar = new zzaj(obj6, obj7, obj8);
                                objArr2[i21] = obj7;
                                obj = zzajVar;
                                break;
                            }
                            zza2 = i19 + 1;
                        }
                    }
                    i15++;
                    i13 = 1;
                }
                if (i16 == i12) {
                    obj = bArr;
                } else {
                    sArr = new Object[]{bArr, Integer.valueOf(i16), obj};
                }
            } else if (i11 <= 32768) {
                sArr = new short[i11];
                Arrays.fill(sArr, (short) -1);
                int i22 = 0;
                for (int i23 = 0; i23 < i12; i23++) {
                    int i24 = i22 + i22;
                    int i25 = i23 + i23;
                    Object obj9 = objArr2[i25];
                    Objects.requireNonNull(obj9);
                    Object obj10 = objArr2[i25 ^ 1];
                    Objects.requireNonNull(obj10);
                    zzad.zza(obj9, obj10);
                    int zza3 = zzae.zza(obj9.hashCode());
                    while (true) {
                        int i26 = zza3 & i14;
                        char c13 = (char) sArr[i26];
                        if (c13 == 65535) {
                            sArr[i26] = (short) i24;
                            if (i22 < i23) {
                                objArr2[i24] = obj9;
                                objArr2[i24 ^ 1] = obj10;
                            }
                            i22++;
                        } else {
                            if (obj9.equals(objArr2[c13])) {
                                int i27 = c13 ^ 1;
                                Object obj11 = objArr2[i27];
                                Objects.requireNonNull(obj11);
                                zzaj zzajVar2 = new zzaj(obj9, obj10, obj11);
                                objArr2[i27] = obj10;
                                obj = zzajVar2;
                                break;
                            }
                            zza3 = i26 + 1;
                        }
                    }
                }
                if (i22 != i12) {
                    c11 = 2;
                    obj = new Object[]{sArr, Integer.valueOf(i22), obj};
                    c10 = 1;
                    z10 = obj instanceof Object[];
                    Object obj12 = obj;
                    if (z10) {
                        Object[] objArr3 = (Object[]) obj;
                        zzaj zzajVar3 = (zzaj) objArr3[c11];
                        if (zzakVar != null) {
                            zzakVar.zzc = zzajVar3;
                            Object obj13 = objArr3[0];
                            int intValue = ((Integer) objArr3[c10]).intValue();
                            objArr2 = Arrays.copyOf(objArr2, intValue + intValue);
                            obj12 = obj13;
                            i12 = intValue;
                        } else {
                            throw zzajVar3.zza();
                        }
                    }
                    return new zzat(obj12, objArr2, i12);
                }
            } else {
                int i28 = 1;
                sArr = new int[i11];
                Arrays.fill((int[]) sArr, -1);
                int i29 = 0;
                int i30 = 0;
                while (i29 < i12) {
                    int i31 = i30 + i30;
                    int i32 = i29 + i29;
                    Object obj14 = objArr2[i32];
                    Objects.requireNonNull(obj14);
                    Object obj15 = objArr2[i32 ^ i28];
                    Objects.requireNonNull(obj15);
                    zzad.zza(obj14, obj15);
                    int zza4 = zzae.zza(obj14.hashCode());
                    while (true) {
                        int i33 = zza4 & i14;
                        ?? r15 = sArr[i33];
                        if (r15 == c12) {
                            sArr[i33] = i31;
                            if (i30 < i29) {
                                objArr2[i31] = obj14;
                                objArr2[i31 ^ 1] = obj15;
                            }
                            i30++;
                        } else {
                            if (obj14.equals(objArr2[r15])) {
                                int i34 = r15 ^ 1;
                                Object obj16 = objArr2[i34];
                                Objects.requireNonNull(obj16);
                                zzaj zzajVar4 = new zzaj(obj14, obj15, obj16);
                                objArr2[i34] = obj15;
                                obj = zzajVar4;
                                break;
                            }
                            zza4 = i33 + 1;
                            c12 = 65535;
                        }
                    }
                    i29++;
                    i28 = 1;
                    c12 = 65535;
                }
                if (i30 != i12) {
                    c10 = 1;
                    c11 = 2;
                    obj = new Object[]{sArr, Integer.valueOf(i30), obj};
                    z10 = obj instanceof Object[];
                    Object obj122 = obj;
                    if (z10) {
                    }
                    return new zzat(obj122, objArr2, i12);
                }
            }
            obj = sArr;
        }
        c11 = 2;
        c10 = 1;
        z10 = obj instanceof Object[];
        Object obj1222 = obj;
        if (z10) {
        }
        return new zzat(obj1222, objArr2, i12);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x009f A[RETURN] */
    @Override // com.google.android.gms.internal.play_billing.zzal, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object get(Object obj) {
        Object obj2;
        if (obj != null) {
            int i10 = this.zzd;
            Object[] objArr = this.zzb;
            if (i10 == 1) {
                Object obj3 = objArr[0];
                Objects.requireNonNull(obj3);
                if (obj3.equals(obj)) {
                    obj2 = objArr[1];
                    Objects.requireNonNull(obj2);
                }
            } else {
                Object obj4 = this.zzc;
                if (obj4 != null) {
                    if (obj4 instanceof byte[]) {
                        byte[] bArr = (byte[]) obj4;
                        int length = bArr.length - 1;
                        int zza2 = zzae.zza(obj.hashCode());
                        while (true) {
                            int i11 = zza2 & length;
                            int i12 = bArr[i11] & UByte.MAX_VALUE;
                            if (i12 == 255) {
                                break;
                            }
                            if (obj.equals(objArr[i12])) {
                                obj2 = objArr[i12 ^ 1];
                                break;
                            }
                            zza2 = i11 + 1;
                        }
                    } else if (obj4 instanceof short[]) {
                        short[] sArr = (short[]) obj4;
                        int length2 = sArr.length - 1;
                        int zza3 = zzae.zza(obj.hashCode());
                        while (true) {
                            int i13 = zza3 & length2;
                            char c10 = (char) sArr[i13];
                            if (c10 == 65535) {
                                break;
                            }
                            if (obj.equals(objArr[c10])) {
                                obj2 = objArr[c10 ^ 1];
                                break;
                            }
                            zza3 = i13 + 1;
                        }
                    } else {
                        int[] iArr = (int[]) obj4;
                        int length3 = iArr.length - 1;
                        int zza4 = zzae.zza(obj.hashCode());
                        while (true) {
                            int i14 = zza4 & length3;
                            int i15 = iArr[i14];
                            if (i15 == -1) {
                                break;
                            }
                            if (obj.equals(objArr[i15])) {
                                obj2 = objArr[i15 ^ 1];
                                break;
                            }
                            zza4 = i14 + 1;
                        }
                    }
                }
            }
            if (obj2 != null) {
                return null;
            }
            return obj2;
        }
        obj2 = null;
        if (obj2 != null) {
        }
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzal
    final zzaf zza() {
        return new zzas(this.zzb, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzal
    final zzam zzd() {
        return new zzaq(this, this.zzb, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzal
    final zzam zze() {
        return new zzar(this, new zzas(this.zzb, 0, this.zzd));
    }
}
