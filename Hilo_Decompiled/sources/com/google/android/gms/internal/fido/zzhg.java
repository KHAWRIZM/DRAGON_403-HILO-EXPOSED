package com.google.android.gms.internal.fido;

import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzhg extends zzhp {
    private final zzcc zza;
    private final int zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhg(zzcc zzccVar) throws zzhf {
        zzccVar.getClass();
        this.zza = zzccVar;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            zzcc zzccVar2 = this.zza;
            if (i10 >= zzccVar2.size()) {
                break;
            }
            int zzb = ((zzhp) zzccVar2.get(i10)).zzb();
            if (i11 < zzb) {
                i11 = zzb;
            }
            i10++;
        }
        int i12 = i11 + 1;
        this.zzb = i12;
        if (i12 <= 8) {
        } else {
            throw new zzhf("Exceeded cutoff limit for max depth of cbor value");
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzhp zzhpVar = (zzhp) obj;
        if (zzhp.zzd(ByteCompanionObject.MIN_VALUE) != zzhpVar.zza()) {
            return zzhp.zzd(ByteCompanionObject.MIN_VALUE) - zzhpVar.zza();
        }
        zzhg zzhgVar = (zzhg) zzhpVar;
        zzcc zzccVar = this.zza;
        int size = zzccVar.size();
        zzcc zzccVar2 = zzhgVar.zza;
        if (size != zzccVar2.size()) {
            return zzccVar.size() - zzccVar2.size();
        }
        int i10 = 0;
        while (true) {
            zzcc zzccVar3 = this.zza;
            if (i10 >= zzccVar3.size()) {
                return 0;
            }
            int compareTo = ((zzhp) zzccVar3.get(i10)).compareTo((zzhp) zzhgVar.zza.get(i10));
            if (compareTo != 0) {
                return compareTo;
            }
            i10++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzhg.class != obj.getClass()) {
            return false;
        }
        return this.zza.equals(((zzhg) obj).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzhp.zzd(ByteCompanionObject.MIN_VALUE)), this.zza});
    }

    public final String toString() {
        if (this.zza.isEmpty()) {
            return "[]";
        }
        ArrayList arrayList = new ArrayList();
        zzcc zzccVar = this.zza;
        int size = zzccVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(((zzhp) zzccVar.get(i10)).toString().replace("\n", "\n  "));
        }
        zzbd zza = zzbd.zza(",\n  ");
        StringBuilder sb = new StringBuilder("[\n  ");
        zza.zzc(sb, arrayList.iterator());
        sb.append("\n]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.fido.zzhp
    public final int zza() {
        return zzhp.zzd(ByteCompanionObject.MIN_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.fido.zzhp
    public final int zzb() {
        return this.zzb;
    }
}
