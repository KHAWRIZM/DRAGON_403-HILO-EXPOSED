package com.google.common.collect;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class k0 extends u {

    /* renamed from: c, reason: collision with root package name */
    final transient Object f١٠٤٦٩c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k0(Object obj) {
        this.f١٠٤٦٩c = k8.h.i(obj);
    }

    @Override // com.google.common.collect.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f١٠٤٦٩c.equals(obj);
    }

    @Override // com.google.common.collect.q
    int d(Object[] objArr, int i10) {
        objArr[i10] = this.f١٠٤٦٩c;
        return i10 + 1;
    }

    @Override // com.google.common.collect.u, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f١٠٤٦٩c.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: i */
    public m0 iterator() {
        return v.d(this.f١٠٤٦٩c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String obj = this.f١٠٤٦٩c.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }
}
