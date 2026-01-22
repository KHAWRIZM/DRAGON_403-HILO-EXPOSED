package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzfj implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzfk zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfj(zzfk zzfkVar) {
        zzdk zzdkVar;
        this.zzb = zzfkVar;
        zzdkVar = zzfkVar.zza;
        this.zza = zzdkVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
