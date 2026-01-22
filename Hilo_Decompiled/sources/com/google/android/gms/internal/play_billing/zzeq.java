package com.google.android.gms.internal.play_billing;

import com.google.protobuf.e0;
import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzeq {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzff zzc;
    private static final zzff zzd;

    static {
        Class<e0> cls;
        Class<?> cls2;
        zzff zzffVar = null;
        try {
            cls = e0.class;
            int i10 = e0.f١٠٩٧٤a;
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.n2");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzffVar = (zzff) cls2.getConstructor(null).newInstance(null);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzffVar;
        zzd = new zzfh();
    }

    public static void zzA(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfxVar.zzy(i10, list, z10);
        }
    }

    public static void zzB(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfxVar.zzA(i10, list, z10);
        }
    }

    public static void zzC(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfxVar.zzC(i10, list, z10);
        }
    }

    public static void zzD(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfxVar.zzE(i10, list, z10);
        }
    }

    public static void zzE(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfxVar.zzJ(i10, list, z10);
        }
    }

    public static void zzF(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfxVar.zzL(i10, list, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzG(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzct) {
            zzct zzctVar = (zzct) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzby.zzx(zzctVar.zze(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzby.zzx(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzby.zzw(i10 << 3) + 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(List list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzby.zzw(i10 << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzct) {
            zzct zzctVar = (zzct) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzby.zzx(zzctVar.zze(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzby.zzx(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdr) {
            zzdr zzdrVar = (zzdr) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzby.zzx(zzdrVar.zze(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzby.zzx(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i10, Object obj, zzeo zzeoVar) {
        int i11 = i10 << 3;
        if (obj instanceof zzdi) {
            int zzw = zzby.zzw(i11);
            int zza2 = ((zzdi) obj).zza();
            return zzw + zzby.zzw(zza2) + zza2;
        }
        return zzby.zzw(i11) + zzby.zzu((zzec) obj, zzeoVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzct) {
            zzct zzctVar = (zzct) list;
            i10 = 0;
            while (i11 < size) {
                int zze = zzctVar.zze(i11);
                i10 += zzby.zzw((zze >> 31) ^ (zze + zze));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                int intValue = ((Integer) list.get(i11)).intValue();
                i10 += zzby.zzw((intValue >> 31) ^ (intValue + intValue));
                i11++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdr) {
            zzdr zzdrVar = (zzdr) list;
            i10 = 0;
            while (i11 < size) {
                long zze = zzdrVar.zze(i11);
                i10 += zzby.zzx((zze >> 63) ^ (zze + zze));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                long longValue = ((Long) list.get(i11)).longValue();
                i10 += zzby.zzx((longValue >> 63) ^ (longValue + longValue));
                i11++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzct) {
            zzct zzctVar = (zzct) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzby.zzw(zzctVar.zze(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzby.zzw(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdr) {
            zzdr zzdrVar = (zzdr) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzby.zzx(zzdrVar.zze(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzby.zzx(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static zzff zzm() {
        return zzc;
    }

    public static zzff zzn() {
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzo(Object obj, int i10, int i11, Object obj2, zzff zzffVar) {
        if (obj2 == null) {
            obj2 = zzffVar.zzc(obj);
        }
        zzffVar.zzf(obj2, i10, i11);
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzp(zzce zzceVar, Object obj, Object obj2) {
        zzci zzb2 = zzceVar.zzb(obj2);
        if (!zzb2.zza.isEmpty()) {
            zzceVar.zzc(obj).zzh(zzb2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzq(zzff zzffVar, Object obj, Object obj2) {
        zzffVar.zzh(obj, zzffVar.zze(zzffVar.zzd(obj), zzffVar.zzd(obj2)));
    }

    public static void zzr(Class cls) {
        Class cls2;
        if (!zzcs.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzs(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfxVar.zzc(i10, list, z10);
        }
    }

    public static void zzt(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfxVar.zzg(i10, list, z10);
        }
    }

    public static void zzu(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfxVar.zzj(i10, list, z10);
        }
    }

    public static void zzv(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfxVar.zzl(i10, list, z10);
        }
    }

    public static void zzw(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfxVar.zzn(i10, list, z10);
        }
    }

    public static void zzx(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfxVar.zzp(i10, list, z10);
        }
    }

    public static void zzy(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfxVar.zzs(i10, list, z10);
        }
    }

    public static void zzz(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfxVar.zzu(i10, list, z10);
        }
    }
}
