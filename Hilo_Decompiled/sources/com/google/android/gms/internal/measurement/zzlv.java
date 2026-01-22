package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzlv {
    private static final zzlv zzd = new zzlv(true);
    final zzod zza = new zznz();
    private boolean zzb;
    private boolean zzc;

    private zzlv() {
    }

    public static zzlv zza() {
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzf(zzll zzllVar, zzos zzosVar, int i10, Object obj) throws IOException {
        if (zzosVar != zzos.zzj) {
            zzllVar.zza(i10, zzosVar.zzb());
            zzot zzotVar = zzot.INT;
            switch (zzosVar.ordinal()) {
                case 0:
                    zzllVar.zzu(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                    return;
                case 1:
                    zzllVar.zzs(Float.floatToRawIntBits(((Float) obj).floatValue()));
                    return;
                case 2:
                    zzllVar.zzt(((Long) obj).longValue());
                    return;
                case 3:
                    zzllVar.zzt(((Long) obj).longValue());
                    return;
                case 4:
                    zzllVar.zzq(((Integer) obj).intValue());
                    return;
                case 5:
                    zzllVar.zzu(((Long) obj).longValue());
                    return;
                case 6:
                    zzllVar.zzs(((Integer) obj).intValue());
                    return;
                case 7:
                    zzllVar.zzp(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                    return;
                case 8:
                    if (obj instanceof zzlg) {
                        zzllVar.zzj((zzlg) obj);
                        return;
                    } else {
                        zzllVar.zzx((String) obj);
                        return;
                    }
                case 9:
                    ((zznl) obj).zzcB(zzllVar);
                    return;
                case 10:
                    zzllVar.zzo((zznl) obj);
                    return;
                case 11:
                    if (obj instanceof zzlg) {
                        zzllVar.zzj((zzlg) obj);
                        return;
                    } else {
                        byte[] bArr = (byte[]) obj;
                        zzllVar.zzk(bArr, 0, bArr.length);
                        return;
                    }
                case 12:
                    zzllVar.zzr(((Integer) obj).intValue());
                    return;
                case 13:
                    if (obj instanceof zzmi) {
                        zzllVar.zzq(((zzmi) obj).zza());
                        return;
                    } else {
                        zzllVar.zzq(((Integer) obj).intValue());
                        return;
                    }
                case 14:
                    zzllVar.zzs(((Integer) obj).intValue());
                    return;
                case 15:
                    zzllVar.zzu(((Long) obj).longValue());
                    return;
                case 16:
                    int intValue = ((Integer) obj).intValue();
                    zzllVar.zzr((intValue >> 31) ^ (intValue + intValue));
                    return;
                case 17:
                    long longValue = ((Long) obj).longValue();
                    zzllVar.zzt((longValue >> 63) ^ (longValue + longValue));
                    return;
                default:
                    return;
            }
        }
        zznl zznlVar = (zznl) obj;
        zzmo.zzd(zznlVar);
        zzllVar.zza(i10, 3);
        zznlVar.zzcB(zzllVar);
        zzllVar.zza(i10, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(zzos zzosVar, int i10, Object obj) {
        int zzz = zzll.zzz(i10 << 3);
        if (zzosVar == zzos.zzj) {
            zzmo.zzd((zznl) obj);
            zzz += zzz;
        }
        return zzz + zzi(zzosVar, obj);
    }

    static int zzi(zzos zzosVar, Object obj) {
        int zzc;
        int zzz;
        zzos zzosVar2 = zzos.zza;
        zzot zzotVar = zzot.INT;
        switch (zzosVar.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                int i10 = zzll.zzb;
                return 8;
            case 1:
                ((Float) obj).floatValue();
                int i11 = zzll.zzb;
                return 4;
            case 2:
                return zzll.zzA(((Long) obj).longValue());
            case 3:
                return zzll.zzA(((Long) obj).longValue());
            case 4:
                return zzll.zzA(((Integer) obj).intValue());
            case 5:
                ((Long) obj).longValue();
                int i12 = zzll.zzb;
                return 8;
            case 6:
                ((Integer) obj).intValue();
                int i13 = zzll.zzb;
                return 4;
            case 7:
                ((Boolean) obj).booleanValue();
                int i14 = zzll.zzb;
                return 1;
            case 8:
                if (obj instanceof zzlg) {
                    int i15 = zzll.zzb;
                    zzc = ((zzlg) obj).zzc();
                    zzz = zzll.zzz(zzc);
                    break;
                } else {
                    return zzll.zzB((String) obj);
                }
            case 9:
                return ((zznl) obj).zzcn();
            case 10:
                if (obj instanceof zzmu) {
                    int i16 = zzll.zzb;
                    zzc = ((zzmu) obj).zzb();
                    zzz = zzll.zzz(zzc);
                    break;
                } else {
                    return zzll.zzC((zznl) obj);
                }
            case 11:
                if (obj instanceof zzlg) {
                    int i17 = zzll.zzb;
                    zzc = ((zzlg) obj).zzc();
                    zzz = zzll.zzz(zzc);
                    break;
                } else {
                    int i18 = zzll.zzb;
                    zzc = ((byte[]) obj).length;
                    zzz = zzll.zzz(zzc);
                    break;
                }
            case 12:
                return zzll.zzz(((Integer) obj).intValue());
            case 13:
                if (obj instanceof zzmi) {
                    return zzll.zzA(((zzmi) obj).zza());
                }
                return zzll.zzA(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                int i19 = zzll.zzb;
                return 4;
            case 15:
                ((Long) obj).longValue();
                int i20 = zzll.zzb;
                return 8;
            case 16:
                int intValue = ((Integer) obj).intValue();
                return zzll.zzz((intValue >> 31) ^ (intValue + intValue));
            case 17:
                long longValue = ((Long) obj).longValue();
                return zzll.zzA((longValue >> 63) ^ (longValue + longValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return zzz + zzc;
    }

    public static int zzj(zzlu zzluVar, Object obj) {
        zzos zzb = zzluVar.zzb();
        int zza = zzluVar.zza();
        if (zzluVar.zzd()) {
            List list = (List) obj;
            int size = list.size();
            int i10 = 0;
            if (zzluVar.zze()) {
                if (list.isEmpty()) {
                    return 0;
                }
                int i11 = 0;
                while (i10 < size) {
                    i11 += zzi(zzb, list.get(i10));
                    i10++;
                }
                return zzll.zzz(zza << 3) + i11 + zzll.zzz(i11);
            }
            int i12 = 0;
            while (i10 < size) {
                i12 += zzh(zzb, zza, list.get(i10));
                i10++;
            }
            return i12;
        }
        return zzh(zzb, zza, obj);
    }

    private static boolean zzk(Map.Entry entry) {
        zzlu zzluVar = (zzlu) entry.getKey();
        if (zzluVar.zzc() == zzot.MESSAGE) {
            if (zzluVar.zzd()) {
                List list = (List) entry.getValue();
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (!zzl(list.get(i10))) {
                        return false;
                    }
                }
                return true;
            }
            return zzl(entry.getValue());
        }
        return true;
    }

    private static boolean zzl(Object obj) {
        if (obj instanceof zznm) {
            return ((zznm) obj).zzcD();
        }
        if (obj instanceof zzmu) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzm(Map.Entry entry) {
        int i10;
        int zzz;
        int zzz2;
        zzlu zzluVar = (zzlu) entry.getKey();
        Object value = entry.getValue();
        if (zzluVar.zzc() == zzot.MESSAGE && !zzluVar.zzd() && !zzluVar.zze()) {
            if (value instanceof zzmu) {
                int zza = ((zzlu) entry.getKey()).zza();
                int zzz3 = zzll.zzz(8);
                i10 = zzz3 + zzz3;
                zzz = zzll.zzz(16) + zzll.zzz(zza);
                int zzz4 = zzll.zzz(24);
                int zzb = ((zzmu) value).zzb();
                zzz2 = zzz4 + zzll.zzz(zzb) + zzb;
            } else {
                int zza2 = ((zzlu) entry.getKey()).zza();
                int zzz5 = zzll.zzz(8);
                i10 = zzz5 + zzz5;
                zzz = zzll.zzz(16) + zzll.zzz(zza2);
                zzz2 = zzll.zzz(24) + zzll.zzC((zznl) value);
            }
            return i10 + zzz + zzz2;
        }
        return zzj(zzluVar, value);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void zzn(zzlu zzluVar, Object obj) {
        boolean z10;
        zzluVar.zzb();
        byte[] bArr = zzmo.zzb;
        obj.getClass();
        zzos zzosVar = zzos.zza;
        zzot zzotVar = zzot.INT;
        switch (r0.zza()) {
            case INT:
                z10 = obj instanceof Integer;
                if (z10) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzluVar.zza()), zzluVar.zzb().zza(), obj.getClass().getName()));
            case LONG:
                z10 = obj instanceof Long;
                if (z10) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzluVar.zza()), zzluVar.zzb().zza(), obj.getClass().getName()));
            case FLOAT:
                z10 = obj instanceof Float;
                if (z10) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzluVar.zza()), zzluVar.zzb().zza(), obj.getClass().getName()));
            case DOUBLE:
                z10 = obj instanceof Double;
                if (z10) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzluVar.zza()), zzluVar.zzb().zza(), obj.getClass().getName()));
            case BOOLEAN:
                z10 = obj instanceof Boolean;
                if (z10) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzluVar.zza()), zzluVar.zzb().zza(), obj.getClass().getName()));
            case STRING:
                z10 = obj instanceof String;
                if (z10) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzluVar.zza()), zzluVar.zzb().zza(), obj.getClass().getName()));
            case BYTE_STRING:
                if ((obj instanceof zzlg) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzluVar.zza()), zzluVar.zzb().zza(), obj.getClass().getName()));
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzmi)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzluVar.zza()), zzluVar.zzb().zza(), obj.getClass().getName()));
            case MESSAGE:
                if ((obj instanceof zznl) || (obj instanceof zzmu)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzluVar.zza()), zzluVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzluVar.zza()), zzluVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzlv zzlvVar = new zzlv();
        zzod zzodVar = this.zza;
        int zzc = zzodVar.zzc();
        for (int i10 = 0; i10 < zzc; i10++) {
            Map.Entry zzd2 = zzodVar.zzd(i10);
            zzlvVar.zzd((zzlu) ((zzoa) zzd2).zza(), zzd2.getValue());
        }
        for (Map.Entry entry : zzodVar.zze()) {
            zzlvVar.zzd((zzlu) entry.getKey(), entry.getValue());
        }
        zzlvVar.zzc = this.zzc;
        return zzlvVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlv)) {
            return false;
        }
        return this.zza.equals(((zzlv) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        zzod zzodVar = this.zza;
        int zzc = zzodVar.zzc();
        for (int i10 = 0; i10 < zzc; i10++) {
            Object value = zzodVar.zzd(i10).getValue();
            if (value instanceof zzme) {
                ((zzme) value).zzcj();
            }
        }
        Iterator it = zzodVar.zze().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzme) {
                ((zzme) value2).zzcj();
            }
        }
        zzodVar.zza();
        this.zzb = true;
    }

    public final Iterator zzc() {
        zzod zzodVar = this.zza;
        if (zzodVar.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzc) {
            return new zzmt(zzodVar.entrySet().iterator());
        }
        return zzodVar.entrySet().iterator();
    }

    public final void zzd(zzlu zzluVar, Object obj) {
        if (zzluVar.zzd()) {
            if (obj instanceof List) {
                List list = (List) obj;
                int size = list.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i10 = 0; i10 < size; i10++) {
                    Object obj2 = list.get(i10);
                    zzn(zzluVar, obj2);
                    arrayList.add(obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            zzn(zzluVar, obj);
        }
        if (obj instanceof zzmu) {
            this.zzc = true;
        }
        this.zza.put(zzluVar, obj);
    }

    public final boolean zze() {
        zzod zzodVar = this.zza;
        int zzc = zzodVar.zzc();
        for (int i10 = 0; i10 < zzc; i10++) {
            if (!zzk(zzodVar.zzd(i10))) {
                return false;
            }
        }
        Iterator it = zzodVar.zze().iterator();
        while (it.hasNext()) {
            if (!zzk((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int zzg() {
        zzod zzodVar = this.zza;
        int zzc = zzodVar.zzc();
        int i10 = 0;
        for (int i11 = 0; i11 < zzc; i11++) {
            i10 += zzm(zzodVar.zzd(i11));
        }
        Iterator it = zzodVar.zze().iterator();
        while (it.hasNext()) {
            i10 += zzm((Map.Entry) it.next());
        }
        return i10;
    }

    private zzlv(boolean z10) {
        zzb();
        zzb();
    }
}
