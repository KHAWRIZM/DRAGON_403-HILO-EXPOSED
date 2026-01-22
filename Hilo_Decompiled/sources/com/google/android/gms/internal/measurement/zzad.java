package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzad implements Iterator {
    final /* synthetic */ zzae zza;
    private int zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(zzae zzaeVar) {
        Objects.requireNonNull(zzaeVar);
        this.zza = zzaeVar;
        this.zzb = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.zzb < this.zza.zzh()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        zzae zzaeVar = this.zza;
        if (this.zzb < zzaeVar.zzh()) {
            int i10 = this.zzb;
            this.zzb = i10 + 1;
            return zzaeVar.zzl(i10);
        }
        int i11 = this.zzb;
        StringBuilder sb = new StringBuilder(String.valueOf(i11).length() + 21);
        sb.append("Out of bounds index: ");
        sb.append(i11);
        throw new NoSuchElementException(sb.toString());
    }
}
