package com.google.android.gms.internal.fido;

import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzhh extends zzhp {
    private final boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhh(boolean z10) {
        this.zza = z10;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        int i10;
        zzhp zzhpVar = (zzhp) obj;
        if (zzhp.zzd((byte) -32) != zzhpVar.zza()) {
            return zzhp.zzd((byte) -32) - zzhpVar.zza();
        }
        zzhh zzhhVar = (zzhh) zzhpVar;
        int i11 = 21;
        if (true != this.zza) {
            i10 = 20;
        } else {
            i10 = 21;
        }
        if (true != zzhhVar.zza) {
            i11 = 20;
        }
        return i10 - i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzhh.class == obj.getClass() && this.zza == ((zzhh) obj).zza) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzhp.zzd((byte) -32)), Boolean.valueOf(this.zza)});
    }

    public final String toString() {
        return Boolean.toString(this.zza);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.fido.zzhp
    public final int zza() {
        return zzhp.zzd((byte) -32);
    }
}
