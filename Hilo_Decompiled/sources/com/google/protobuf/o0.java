package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class o0 extends d implements p0, RandomAccess {

    /* renamed from: c, reason: collision with root package name */
    private static final o0 f١١٨٥٣c;

    /* renamed from: d, reason: collision with root package name */
    public static final p0 f١١٨٥٤d;

    /* renamed from: b, reason: collision with root package name */
    private final List f١١٨٥٥b;

    static {
        o0 o0Var = new o0();
        f١١٨٥٣c = o0Var;
        o0Var.b();
        f١١٨٥٤d = o0Var;
    }

    public o0() {
        this(10);
    }

    private static String f(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof h) {
            return ((h) obj).C();
        }
        return j0.k((byte[]) obj);
    }

    @Override // com.google.protobuf.p0
    public Object S(int i10) {
        return this.f١١٨٥٥b.get(i10);
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.protobuf.d, com.google.protobuf.j0.i
    public /* bridge */ /* synthetic */ boolean c() {
        return super.c();
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        d();
        this.f١١٨٥٥b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void add(int i10, String str) {
        d();
        this.f١١٨٥٥b.add(i10, str);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.protobuf.p0
    public List getUnderlyingElements() {
        return Collections.unmodifiableList(this.f١١٨٥٥b);
    }

    @Override // com.google.protobuf.p0
    public p0 getUnmodifiableView() {
        if (c()) {
            return new o2(this);
        }
        return this;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public String get(int i10) {
        Object obj = this.f١١٨٥٥b.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٨٥٥b.set(i10, C);
            }
            return C;
        }
        byte[] bArr = (byte[]) obj;
        String k10 = j0.k(bArr);
        if (j0.i(bArr)) {
            this.f١١٨٥٥b.set(i10, k10);
        }
        return k10;
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.protobuf.j0.i, com.google.protobuf.j0.f
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public o0 a(int i10) {
        if (i10 >= size()) {
            ArrayList arrayList = new ArrayList(i10);
            arrayList.addAll(this.f١١٨٥٥b);
            return new o0(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.p0
    public void j(h hVar) {
        d();
        this.f١١٨٥٥b.add(hVar);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.List
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public String remove(int i10) {
        d();
        Object remove = this.f١١٨٥٥b.remove(i10);
        ((AbstractList) this).modCount++;
        return f(remove);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public String set(int i10, String str) {
        d();
        return f(this.f١١٨٥٥b.set(i10, str));
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f١١٨٥٥b.size();
    }

    public o0(int i10) {
        this(new ArrayList(i10));
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.List
    public boolean addAll(int i10, Collection collection) {
        d();
        if (collection instanceof p0) {
            collection = ((p0) collection).getUnderlyingElements();
        }
        boolean addAll = this.f١١٨٥٥b.addAll(i10, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public o0(p0 p0Var) {
        this.f١١٨٥٥b = new ArrayList(p0Var.size());
        addAll(p0Var);
    }

    private o0(ArrayList arrayList) {
        this.f١١٨٥٥b = arrayList;
    }
}
