package com.google.protobuf;

import com.google.protobuf.a;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class x1 implements a.b {

    /* renamed from: a, reason: collision with root package name */
    private a.b f١١٩٩٥a;

    /* renamed from: b, reason: collision with root package name */
    private List f١١٩٩٦b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f١١٩٩٧c;

    /* renamed from: d, reason: collision with root package name */
    private List f١١٩٩٨d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f١١٩٩٩e;

    /* renamed from: f, reason: collision with root package name */
    private b f١٢٠٠٠f;

    /* renamed from: g, reason: collision with root package name */
    private a f١٢٠٠١g;

    /* renamed from: h, reason: collision with root package name */
    private c f١٢٠٠٢h;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a extends AbstractList implements List, RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        x1 f١٢٠٠٣a;

        a(x1 x1Var) {
            this.f١٢٠٠٣a = x1Var;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a.AbstractC٠١٣٢a get(int i10) {
            return this.f١٢٠٠٣a.l(i10);
        }

        void e() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f١٢٠٠٣a.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b extends AbstractList implements List, RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        x1 f١٢٠٠٤a;

        b(x1 x1Var) {
            this.f١٢٠٠٤a = x1Var;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public com.google.protobuf.a get(int i10) {
            return this.f١٢٠٠٤a.o(i10);
        }

        void e() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f١٢٠٠٤a.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class c extends AbstractList implements List, RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        x1 f١٢٠٠٥a;

        c(x1 x1Var) {
            this.f١٢٠٠٥a = x1Var;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public g1 get(int i10) {
            return this.f١٢٠٠٥a.r(i10);
        }

        void e() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f١٢٠٠٥a.n();
        }
    }

    public x1(List list, boolean z10, a.b bVar, boolean z11) {
        this.f١١٩٩٦b = list;
        this.f١١٩٩٧c = z10;
        this.f١١٩٩٥a = bVar;
        this.f١١٩٩٩e = z11;
    }

    private void j() {
        if (this.f١١٩٩٨d == null) {
            this.f١١٩٩٨d = new ArrayList(this.f١١٩٩٦b.size());
            for (int i10 = 0; i10 < this.f١١٩٩٦b.size(); i10++) {
                this.f١١٩٩٨d.add(null);
            }
        }
    }

    private void k() {
        if (!this.f١١٩٩٧c) {
            this.f١١٩٩٦b = new ArrayList(this.f١١٩٩٦b);
            this.f١١٩٩٧c = true;
        }
    }

    private com.google.protobuf.a p(int i10, boolean z10) {
        List list = this.f١١٩٩٨d;
        if (list == null) {
            return (com.google.protobuf.a) this.f١١٩٩٦b.get(i10);
        }
        b2 b2Var = (b2) list.get(i10);
        if (b2Var == null) {
            return (com.google.protobuf.a) this.f١١٩٩٦b.get(i10);
        }
        if (z10) {
            return b2Var.b();
        }
        return b2Var.e();
    }

    private void t() {
        b bVar = this.f١٢٠٠٠f;
        if (bVar != null) {
            bVar.e();
        }
        a aVar = this.f١٢٠٠١g;
        if (aVar != null) {
            aVar.e();
        }
        c cVar = this.f١٢٠٠٢h;
        if (cVar != null) {
            cVar.e();
        }
    }

    private void v() {
        a.b bVar;
        if (this.f١١٩٩٩e && (bVar = this.f١١٩٩٥a) != null) {
            bVar.a();
            this.f١١٩٩٩e = false;
        }
    }

    @Override // com.google.protobuf.a.b
    public void a() {
        v();
    }

    public x1 b(Iterable iterable) {
        int i10;
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            j0.a((com.google.protobuf.a) it.next());
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.isEmpty()) {
                return this;
            }
            i10 = collection.size();
        } else {
            i10 = -1;
        }
        k();
        if (i10 >= 0) {
            List list = this.f١١٩٩٦b;
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + i10);
            }
        }
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            f((com.google.protobuf.a) it2.next());
        }
        v();
        t();
        return this;
    }

    public a.AbstractC٠١٣٢a c(int i10, com.google.protobuf.a aVar) {
        k();
        j();
        b2 b2Var = new b2(aVar, this, this.f١١٩٩٩e);
        this.f١١٩٩٦b.add(i10, null);
        this.f١١٩٩٨d.add(i10, b2Var);
        v();
        t();
        return b2Var.d();
    }

    public a.AbstractC٠١٣٢a d(com.google.protobuf.a aVar) {
        k();
        j();
        b2 b2Var = new b2(aVar, this, this.f١١٩٩٩e);
        this.f١١٩٩٦b.add(null);
        this.f١١٩٩٨d.add(b2Var);
        v();
        t();
        return b2Var.d();
    }

    public x1 e(int i10, com.google.protobuf.a aVar) {
        j0.a(aVar);
        k();
        this.f١١٩٩٦b.add(i10, aVar);
        List list = this.f١١٩٩٨d;
        if (list != null) {
            list.add(i10, null);
        }
        v();
        t();
        return this;
    }

    public x1 f(com.google.protobuf.a aVar) {
        j0.a(aVar);
        k();
        this.f١١٩٩٦b.add(aVar);
        List list = this.f١١٩٩٨d;
        if (list != null) {
            list.add(null);
        }
        v();
        t();
        return this;
    }

    public List g() {
        this.f١١٩٩٩e = true;
        boolean z10 = this.f١١٩٩٧c;
        if (!z10 && this.f١١٩٩٨d == null) {
            return this.f١١٩٩٦b;
        }
        if (!z10) {
            for (int i10 = 0; i10 < this.f١١٩٩٦b.size(); i10++) {
                b1 b1Var = (b1) this.f١١٩٩٦b.get(i10);
                b2 b2Var = (b2) this.f١١٩٩٨d.get(i10);
                if (b2Var == null || b2Var.b() == b1Var) {
                }
            }
            return this.f١١٩٩٦b;
        }
        k();
        for (int i11 = 0; i11 < this.f١١٩٩٦b.size(); i11++) {
            this.f١١٩٩٦b.set(i11, p(i11, true));
        }
        List unmodifiableList = Collections.unmodifiableList(this.f١١٩٩٦b);
        this.f١١٩٩٦b = unmodifiableList;
        this.f١١٩٩٧c = false;
        return unmodifiableList;
    }

    public void h() {
        this.f١١٩٩٦b = Collections.emptyList();
        this.f١١٩٩٧c = false;
        List<b2> list = this.f١١٩٩٨d;
        if (list != null) {
            for (b2 b2Var : list) {
                if (b2Var != null) {
                    b2Var.c();
                }
            }
            this.f١١٩٩٨d = null;
        }
        v();
        t();
    }

    public void i() {
        this.f١١٩٩٥a = null;
    }

    public a.AbstractC٠١٣٢a l(int i10) {
        j();
        b2 b2Var = (b2) this.f١١٩٩٨d.get(i10);
        if (b2Var == null) {
            b2 b2Var2 = new b2((com.google.protobuf.a) this.f١١٩٩٦b.get(i10), this, this.f١١٩٩٩e);
            this.f١١٩٩٨d.set(i10, b2Var2);
            b2Var = b2Var2;
        }
        return b2Var.d();
    }

    public List m() {
        if (this.f١٢٠٠١g == null) {
            this.f١٢٠٠١g = new a(this);
        }
        return this.f١٢٠٠١g;
    }

    public int n() {
        return this.f١١٩٩٦b.size();
    }

    public com.google.protobuf.a o(int i10) {
        return p(i10, false);
    }

    public List q() {
        if (this.f١٢٠٠٠f == null) {
            this.f١٢٠٠٠f = new b(this);
        }
        return this.f١٢٠٠٠f;
    }

    public g1 r(int i10) {
        List list = this.f١١٩٩٨d;
        if (list == null) {
            return (g1) this.f١١٩٩٦b.get(i10);
        }
        b2 b2Var = (b2) list.get(i10);
        if (b2Var == null) {
            return (g1) this.f١١٩٩٦b.get(i10);
        }
        return b2Var.f();
    }

    public List s() {
        if (this.f١٢٠٠٢h == null) {
            this.f١٢٠٠٢h = new c(this);
        }
        return this.f١٢٠٠٢h;
    }

    public boolean u() {
        return this.f١١٩٩٦b.isEmpty();
    }

    public void w(int i10) {
        b2 b2Var;
        k();
        this.f١١٩٩٦b.remove(i10);
        List list = this.f١١٩٩٨d;
        if (list != null && (b2Var = (b2) list.remove(i10)) != null) {
            b2Var.c();
        }
        v();
        t();
    }

    public x1 x(int i10, com.google.protobuf.a aVar) {
        b2 b2Var;
        j0.a(aVar);
        k();
        this.f١١٩٩٦b.set(i10, aVar);
        List list = this.f١١٩٩٨d;
        if (list != null && (b2Var = (b2) list.set(i10, null)) != null) {
            b2Var.c();
        }
        v();
        t();
        return this;
    }
}
