package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class n extends o {
    private static final long serialVersionUID = 0;

    /* renamed from: e, reason: collision with root package name */
    transient int f١٠٤٧٢e;

    private n() {
        this(12, 2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f١٠٤٧٢e = 2;
        int b10 = i0.b(objectInputStream);
        r(e0.c(12));
        i0.a(this, objectInputStream, b10);
    }

    public static n u() {
        return new n();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        i0.c(this, objectOutputStream);
    }

    @Override // com.google.common.collect.f, com.google.common.collect.e, com.google.common.collect.z
    public /* bridge */ /* synthetic */ Map a() {
        return super.a();
    }

    @Override // com.google.common.collect.e
    public /* bridge */ /* synthetic */ Set d() {
        return super.d();
    }

    @Override // com.google.common.collect.f, com.google.common.collect.e
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.e
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ void l() {
        super.l();
    }

    @Override // com.google.common.collect.f, com.google.common.collect.c
    public /* bridge */ /* synthetic */ boolean p(Object obj, Object obj2) {
        return super.p(obj, obj2);
    }

    @Override // com.google.common.collect.f
    /* renamed from: t */
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return super.get(obj);
    }

    @Override // com.google.common.collect.e
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.c
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public Set m() {
        return e0.d(this.f١٠٤٧٢e);
    }

    private n(int i10, int i11) {
        super(e0.c(i10));
        this.f١٠٤٧٢e = 2;
        k8.h.d(i11 >= 0);
        this.f١٠٤٧٢e = i11;
    }
}
