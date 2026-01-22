package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzar implements Iterator {
    final /* synthetic */ zzas zza;
    private int zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzar(zzas zzasVar) {
        Objects.requireNonNull(zzasVar);
        this.zza = zzasVar;
        this.zzb = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zza.zzb().length();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        zzas zzasVar = this.zza;
        String zzb = zzasVar.zzb();
        int i10 = this.zzb;
        if (i10 < zzb.length()) {
            this.zzb = i10 + 1;
            return new zzas(String.valueOf(zzasVar.zzb().charAt(i10)));
        }
        throw new NoSuchElementException();
    }
}
