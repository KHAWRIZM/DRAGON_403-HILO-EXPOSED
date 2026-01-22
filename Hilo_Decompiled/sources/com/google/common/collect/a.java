package com.google.common.collect;

import java.util.NoSuchElementException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
abstract class a extends n0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f١٠٣٧٣a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٠٣٧٤b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(int i10, int i11) {
        k8.h.k(i11, i10);
        this.f١٠٣٧٣a = i10;
        this.f١٠٣٧٤b = i11;
    }

    protected abstract Object a(int i10);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        if (this.f١٠٣٧٤b < this.f١٠٣٧٣a) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.f١٠٣٧٤b > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (hasNext()) {
            int i10 = this.f١٠٣٧٤b;
            this.f١٠٣٧٤b = i10 + 1;
            return a(i10);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f١٠٣٧٤b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (hasPrevious()) {
            int i10 = this.f١٠٣٧٤b - 1;
            this.f١٠٣٧٤b = i10;
            return a(i10);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f١٠٣٧٤b - 1;
    }
}
