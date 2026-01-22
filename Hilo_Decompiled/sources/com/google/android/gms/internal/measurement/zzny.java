package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzny {
    public static final /* synthetic */ int zza = 0;
    private static final zzoh zzb;

    static {
        int i10 = zznt.zza;
        zzb = new zzoj();
    }

    public static zzoh zzA() {
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzB(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzC(zzlr zzlrVar, Object obj, Object obj2) {
        if (((zzmb) obj2).zzb.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzD(zzoh zzohVar, Object obj, Object obj2) {
        zzme zzmeVar = (zzme) obj;
        zzoi zzoiVar = zzmeVar.zzc;
        zzoi zzoiVar2 = ((zzme) obj2).zzc;
        if (!zzoi.zza().equals(zzoiVar2)) {
            if (zzoi.zza().equals(zzoiVar)) {
                zzoiVar = zzoi.zzc(zzoiVar, zzoiVar2);
            } else {
                zzoiVar.zzl(zzoiVar2);
            }
        }
        zzmeVar.zzc = zzoiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzE(Object obj, int i10, int i11, Object obj2, zzoh zzohVar) {
        if (obj2 == null) {
            obj2 = zzohVar.zza(obj);
        }
        ((zzoi) obj2).zzk(i10 << 3, Long.valueOf(i11));
        return obj2;
    }

    public static void zza(int i10, List list, zzou zzouVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzouVar.zzC(i10, list, z10);
        }
    }

    public static void zzb(int i10, List list, zzou zzouVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzouVar.zzB(i10, list, z10);
        }
    }

    public static void zzc(int i10, List list, zzou zzouVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzouVar.zzy(i10, list, z10);
        }
    }

    public static void zzd(int i10, List list, zzou zzouVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzouVar.zzz(i10, list, z10);
        }
    }

    public static void zze(int i10, List list, zzou zzouVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzouVar.zzL(i10, list, z10);
        }
    }

    public static void zzf(int i10, List list, zzou zzouVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzouVar.zzA(i10, list, z10);
        }
    }

    public static void zzg(int i10, List list, zzou zzouVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzouVar.zzJ(i10, list, z10);
        }
    }

    public static void zzh(int i10, List list, zzou zzouVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzouVar.zzw(i10, list, z10);
        }
    }

    public static void zzi(int i10, List list, zzou zzouVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzouVar.zzH(i10, list, z10);
        }
    }

    public static void zzj(int i10, List list, zzou zzouVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzouVar.zzK(i10, list, z10);
        }
    }

    public static void zzk(int i10, List list, zzou zzouVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzouVar.zzx(i10, list, z10);
        }
    }

    public static void zzl(int i10, List list, zzou zzouVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzouVar.zzI(i10, list, z10);
        }
    }

    public static void zzm(int i10, List list, zzou zzouVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzouVar.zzD(i10, list, z10);
        }
    }

    public static void zzn(int i10, List list, zzou zzouVar, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzouVar.zzE(i10, list, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzmz) {
            zzmz zzmzVar = (zzmz) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzll.zzA(zzmzVar.zzc(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzll.zzA(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzp(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzmz) {
            zzmz zzmzVar = (zzmz) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzll.zzA(zzmzVar.zzc(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzll.zzA(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzq(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzmz) {
            zzmz zzmzVar = (zzmz) list;
            i10 = 0;
            while (i11 < size) {
                long zzc = zzmzVar.zzc(i11);
                i10 += zzll.zzA((zzc >> 63) ^ (zzc + zzc));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                long longValue = ((Long) list.get(i11)).longValue();
                i10 += zzll.zzA((longValue >> 63) ^ (longValue + longValue));
                i11++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzr(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzmf) {
            zzmf zzmfVar = (zzmf) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzll.zzA(zzmfVar.zzf(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzll.zzA(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzs(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzmf) {
            zzmf zzmfVar = (zzmf) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzll.zzA(zzmfVar.zzf(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzll.zzA(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzt(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzmf) {
            zzmf zzmfVar = (zzmf) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzll.zzz(zzmfVar.zzf(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += zzll.zzz(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzu(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzmf) {
            zzmf zzmfVar = (zzmf) list;
            i10 = 0;
            while (i11 < size) {
                int zzf = zzmfVar.zzf(i11);
                i10 += zzll.zzz((zzf >> 31) ^ (zzf + zzf));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                int intValue = ((Integer) list.get(i11)).intValue();
                i10 += zzll.zzz((intValue >> 31) ^ (intValue + intValue));
                i11++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzv(List list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzw(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzll.zzz(i10 << 3) + 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzx(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzy(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzll.zzz(i10 << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzz(int i10, Object obj, zznw zznwVar) {
        int i11 = i10 << 3;
        if (obj instanceof zzmv) {
            int zzz = zzll.zzz(i11);
            int zzb2 = ((zzmv) obj).zzb();
            return zzz + zzll.zzz(zzb2) + zzb2;
        }
        return zzll.zzz(i11) + zzll.zzD((zznl) obj, zznwVar);
    }
}
