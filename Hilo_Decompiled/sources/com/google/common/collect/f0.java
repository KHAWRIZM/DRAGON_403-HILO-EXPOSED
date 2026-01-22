package com.google.common.collect;

import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class f0 extends s {

    /* renamed from: e, reason: collision with root package name */
    static final s f١٠٤٠٦e = new f0(new Object[0], 0);

    /* renamed from: c, reason: collision with root package name */
    final transient Object[] f١٠٤٠٧c;

    /* renamed from: d, reason: collision with root package name */
    private final transient int f١٠٤٠٨d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0(Object[] objArr, int i10) {
        this.f١٠٤٠٧c = objArr;
        this.f١٠٤٠٨d = i10;
    }

    @Override // com.google.common.collect.s, com.google.common.collect.q
    int d(Object[] objArr, int i10) {
        System.arraycopy(this.f١٠٤٠٧c, 0, objArr, i10, this.f١٠٤٠٨d);
        return i10 + this.f١٠٤٠٨d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.q
    public Object[] e() {
        return this.f١٠٤٠٧c;
    }

    @Override // com.google.common.collect.q
    int f() {
        return this.f١٠٤٠٨d;
    }

    @Override // java.util.List
    public Object get(int i10) {
        k8.h.g(i10, this.f١٠٤٠٨d);
        Object obj = this.f١٠٤٠٧c[i10];
        Objects.requireNonNull(obj);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.q
    public int h() {
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f١٠٤٠٨d;
    }
}
