package com.google.android.gms.internal.fido;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzff extends AbstractSet {
    final int zza = -1;
    final /* synthetic */ zzfg zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzff(zzfg zzfgVar, int i10) {
        this.zzb = zzfgVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Object[] objArr;
        Comparator comparator;
        int i10 = this.zza;
        objArr = this.zzb.zzb;
        int zzb = zzb();
        int zza = zza();
        if (i10 == -1) {
            comparator = zzfg.zza;
        } else {
            comparator = zzfi.zza;
        }
        if (Arrays.binarySearch(objArr, zzb, zza, obj, comparator) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzfe(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return zza() - zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zza() {
        int[] iArr;
        int i10 = this.zza;
        iArr = this.zzb.zzc;
        return iArr[i10 + 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzb() {
        int[] iArr;
        if (this.zza == -1) {
            return 0;
        }
        iArr = this.zzb.zzc;
        return iArr[0];
    }
}
