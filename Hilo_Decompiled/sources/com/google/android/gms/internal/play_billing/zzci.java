package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzci {
    private static final zzci zzb = new zzci(true);
    final zzfb zza = new zzer(16);
    private boolean zzc;
    private boolean zzd;

    private zzci() {
    }

    static int zza(zzfv zzfvVar, int i10, Object obj) {
        zzby.zzw(i10 << 3);
        if (zzfv.zzj == null) {
            byte[] bArr = zzda.zzd;
            if (((zzec) obj) instanceof zzaz) {
                throw null;
            }
        }
        zzfw zzfwVar = zzfw.INT;
        throw null;
    }

    public static int zzb(zzch zzchVar, Object obj) {
        zzfv zzd = zzchVar.zzd();
        int zza = zzchVar.zza();
        if (zzchVar.zzg()) {
            List list = (List) obj;
            int i10 = 0;
            if (zzchVar.zzf()) {
                if (list.isEmpty()) {
                    return 0;
                }
                Iterator it = list.iterator();
                if (!it.hasNext()) {
                    return zzby.zzw(zza << 3) + zzby.zzw(0);
                }
                it.next();
                zzfv zzfvVar = zzfv.zza;
                zzfw zzfwVar = zzfw.INT;
                throw null;
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                i10 += zza(zzd, zza, it2.next());
            }
            return i10;
        }
        return zza(zzd, zza, obj);
    }

    public static zzci zzd() {
        return zzb;
    }

    private static Object zzk(Object obj) {
        if (obj instanceof zzeh) {
            return ((zzeh) obj).zzd();
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            return bArr2;
        }
        return obj;
    }

    private final void zzl(Map.Entry entry) {
        zzec zzf;
        zzch zzchVar = (zzch) entry.getKey();
        Object value = entry.getValue();
        boolean z10 = value instanceof zzdh;
        if (zzchVar.zzg()) {
            if (!z10) {
                Object zze = zze(zzchVar);
                if (zze == null) {
                    zze = new ArrayList();
                }
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    ((List) zze).add(zzk(it.next()));
                }
                this.zza.put(zzchVar, zze);
                return;
            }
            throw new IllegalStateException("Lazy fields can not be repeated");
        }
        if (zzchVar.zze() == zzfw.MESSAGE) {
            Object zze2 = zze(zzchVar);
            if (zze2 == null) {
                this.zza.put(zzchVar, zzk(value));
                if (z10) {
                    this.zzd = true;
                    return;
                }
                return;
            }
            if (!z10) {
                if (zze2 instanceof zzeh) {
                    zzf = zzchVar.zzc((zzeh) zze2, (zzeh) value);
                } else {
                    zzf = zzchVar.zzb(((zzec) zze2).zzF(), (zzec) value).zzf();
                }
                this.zza.put(zzchVar, zzf);
                return;
            }
            throw null;
        }
        if (!z10) {
            this.zza.put(zzchVar, zzk(value));
            return;
        }
        throw new IllegalStateException("Lazy fields must be message-valued");
    }

    private static boolean zzm(Map.Entry entry) {
        zzch zzchVar = (zzch) entry.getKey();
        if (zzchVar.zze() == zzfw.MESSAGE) {
            if (zzchVar.zzg()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!zzn(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            return zzn(entry.getValue());
        }
        return true;
    }

    private static boolean zzn(Object obj) {
        if (obj instanceof zzed) {
            return ((zzed) obj).zzk();
        }
        if (obj instanceof zzdh) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzo(Map.Entry entry) {
        int i10;
        int zzw;
        int zzw2;
        int zzf;
        int zzw3;
        zzch zzchVar = (zzch) entry.getKey();
        Object value = entry.getValue();
        if (zzchVar.zze() == zzfw.MESSAGE && !zzchVar.zzg() && !zzchVar.zzf()) {
            if (value instanceof zzdh) {
                int zza = ((zzch) entry.getKey()).zza();
                int zzw4 = zzby.zzw(8);
                i10 = zzw4 + zzw4;
                zzw = zzby.zzw(16) + zzby.zzw(zza);
                zzw2 = zzby.zzw(24);
                zzf = ((zzdh) value).zza();
                zzw3 = zzby.zzw(zzf);
            } else {
                int zza2 = ((zzch) entry.getKey()).zza();
                int zzw5 = zzby.zzw(8);
                i10 = zzw5 + zzw5;
                zzw = zzby.zzw(16) + zzby.zzw(zza2);
                zzw2 = zzby.zzw(24);
                zzf = ((zzec) value).zzf();
                zzw3 = zzby.zzw(zzf);
            }
            return i10 + zzw + zzw2 + zzw3 + zzf;
        }
        return zzb(zzchVar, value);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void zzp(zzch zzchVar, Object obj) {
        boolean z10;
        zzchVar.zzd();
        byte[] bArr = zzda.zzd;
        obj.getClass();
        zzfv zzfvVar = zzfv.zza;
        zzfw zzfwVar = zzfw.INT;
        switch (r0.zza()) {
            case INT:
                z10 = obj instanceof Integer;
                if (z10) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzchVar.zza()), zzchVar.zzd().zza(), obj.getClass().getName()));
            case LONG:
                z10 = obj instanceof Long;
                if (z10) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzchVar.zza()), zzchVar.zzd().zza(), obj.getClass().getName()));
            case FLOAT:
                z10 = obj instanceof Float;
                if (z10) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzchVar.zza()), zzchVar.zzd().zza(), obj.getClass().getName()));
            case DOUBLE:
                z10 = obj instanceof Double;
                if (z10) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzchVar.zza()), zzchVar.zzd().zza(), obj.getClass().getName()));
            case BOOLEAN:
                z10 = obj instanceof Boolean;
                if (z10) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzchVar.zza()), zzchVar.zzd().zza(), obj.getClass().getName()));
            case STRING:
                z10 = obj instanceof String;
                if (z10) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzchVar.zza()), zzchVar.zzd().zza(), obj.getClass().getName()));
            case BYTE_STRING:
                if ((obj instanceof zzbq) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzchVar.zza()), zzchVar.zzd().zza(), obj.getClass().getName()));
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzcu)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzchVar.zza()), zzchVar.zzd().zza(), obj.getClass().getName()));
            case MESSAGE:
                if ((obj instanceof zzec) || (obj instanceof zzdh)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzchVar.zza()), zzchVar.zzd().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzchVar.zza()), zzchVar.zzd().zza(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzci zzciVar = new zzci();
        for (int i10 = 0; i10 < this.zza.zzb(); i10++) {
            Map.Entry zzg = this.zza.zzg(i10);
            zzciVar.zzi((zzch) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzciVar.zzi((zzch) entry.getKey(), entry.getValue());
        }
        zzciVar.zzd = this.zzd;
        return zzciVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzci)) {
            return false;
        }
        return this.zza.equals(((zzci) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzc() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.zza.zzb(); i11++) {
            i10 += zzo(this.zza.zzg(i11));
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            i10 += zzo((Map.Entry) it.next());
        }
        return i10;
    }

    public final Object zze(zzch zzchVar) {
        Object obj = this.zza.get(zzchVar);
        if (!(obj instanceof zzdh)) {
            return obj;
        }
        throw null;
    }

    public final Iterator zzf() {
        if (this.zzd) {
            return new zzdg(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    public final void zzg() {
        if (!this.zzc) {
            for (int i10 = 0; i10 < this.zza.zzb(); i10++) {
                Map.Entry zzg = this.zza.zzg(i10);
                if (zzg.getValue() instanceof zzcs) {
                    ((zzcs) zzg.getValue()).zzr();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzh(zzci zzciVar) {
        for (int i10 = 0; i10 < zzciVar.zza.zzb(); i10++) {
            zzl(zzciVar.zza.zzg(i10));
        }
        Iterator it = zzciVar.zza.zzc().iterator();
        while (it.hasNext()) {
            zzl((Map.Entry) it.next());
        }
    }

    public final void zzi(zzch zzchVar, Object obj) {
        if (zzchVar.zzg()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    zzp(zzchVar, arrayList.get(i10));
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            zzp(zzchVar, obj);
        }
        if (obj instanceof zzdh) {
            this.zzd = true;
        }
        this.zza.put(zzchVar, obj);
    }

    public final boolean zzj() {
        for (int i10 = 0; i10 < this.zza.zzb(); i10++) {
            if (!zzm(this.zza.zzg(i10))) {
                return false;
            }
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            if (!zzm((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzci(boolean z10) {
        zzg();
        zzg();
    }
}
