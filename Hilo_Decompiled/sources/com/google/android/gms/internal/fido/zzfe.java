package com.google.android.gms.internal.fido;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzfe implements Iterator {
    final /* synthetic */ zzff zza;
    private int zzb = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfe(zzff zzffVar) {
        this.zza = zzffVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i10 = this.zzb;
        zzff zzffVar = this.zza;
        if (i10 < zzffVar.zza() - zzffVar.zzb()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object[] objArr;
        int i10 = this.zzb;
        zzff zzffVar = this.zza;
        if (i10 < zzffVar.zza() - zzffVar.zzb()) {
            zzff zzffVar2 = this.zza;
            objArr = zzffVar2.zzb.zzb;
            Object obj = objArr[zzffVar2.zzb() + i10];
            this.zzb = i10 + 1;
            return obj;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
