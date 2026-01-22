package com.google.common.collect;

import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
abstract class l0 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    final Iterator f١٠٤٧٠a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l0(Iterator it) {
        this.f١٠٤٧٠a = (Iterator) k8.h.i(it);
    }

    abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f١٠٤٧٠a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return a(this.f١٠٤٧٠a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f١٠٤٧٠a.remove();
    }
}
