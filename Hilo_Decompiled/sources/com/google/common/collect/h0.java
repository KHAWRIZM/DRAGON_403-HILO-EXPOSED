package com.google.common.collect;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class h0 extends u {

    /* renamed from: h, reason: collision with root package name */
    private static final Object[] f١٠٤٢٥h;

    /* renamed from: i, reason: collision with root package name */
    static final h0 f١٠٤٢٦i;

    /* renamed from: c, reason: collision with root package name */
    final transient Object[] f١٠٤٢٧c;

    /* renamed from: d, reason: collision with root package name */
    private final transient int f١٠٤٢٨d;

    /* renamed from: e, reason: collision with root package name */
    final transient Object[] f١٠٤٢٩e;

    /* renamed from: f, reason: collision with root package name */
    private final transient int f١٠٤٣٠f;

    /* renamed from: g, reason: collision with root package name */
    private final transient int f١٠٤٣١g;

    static {
        Object[] objArr = new Object[0];
        f١٠٤٢٥h = objArr;
        f١٠٤٢٦i = new h0(objArr, 0, objArr, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(Object[] objArr, int i10, Object[] objArr2, int i11, int i12) {
        this.f١٠٤٢٧c = objArr;
        this.f١٠٤٢٨d = i10;
        this.f١٠٤٢٩e = objArr2;
        this.f١٠٤٣٠f = i11;
        this.f١٠٤٣١g = i12;
    }

    @Override // com.google.common.collect.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Object[] objArr = this.f١٠٤٢٩e;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int c10 = p.c(obj);
        while (true) {
            int i10 = c10 & this.f١٠٤٣٠f;
            Object obj2 = objArr[i10];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            c10 = i10 + 1;
        }
    }

    @Override // com.google.common.collect.q
    int d(Object[] objArr, int i10) {
        System.arraycopy(this.f١٠٤٢٧c, 0, objArr, i10, this.f١٠٤٣١g);
        return i10 + this.f١٠٤٣١g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.q
    public Object[] e() {
        return this.f١٠٤٢٧c;
    }

    @Override // com.google.common.collect.q
    int f() {
        return this.f١٠٤٣١g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.q
    public int h() {
        return 0;
    }

    @Override // com.google.common.collect.u, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f١٠٤٢٨d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: i */
    public m0 iterator() {
        return k().iterator();
    }

    @Override // com.google.common.collect.u
    s o() {
        return s.l(this.f١٠٤٢٧c, this.f١٠٤٣١g);
    }

    @Override // com.google.common.collect.u
    boolean p() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f١٠٤٣١g;
    }
}
