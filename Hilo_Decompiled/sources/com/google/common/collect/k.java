package com.google.common.collect;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class k extends AbstractSet implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private transient Object f١٠٤٦٠a;

    /* renamed from: b, reason: collision with root package name */
    private transient int[] f١٠٤٦١b;

    /* renamed from: c, reason: collision with root package name */
    transient Object[] f١٠٤٦٢c;

    /* renamed from: d, reason: collision with root package name */
    private transient int f١٠٤٦٣d;

    /* renamed from: e, reason: collision with root package name */
    private transient int f١٠٤٦٤e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        int f١٠٤٦٥a;

        /* renamed from: b, reason: collision with root package name */
        int f١٠٤٦٦b;

        /* renamed from: c, reason: collision with root package name */
        int f١٠٤٦٧c = -1;

        a() {
            this.f١٠٤٦٥a = k.this.f١٠٤٦٣d;
            this.f١٠٤٦٦b = k.this.p();
        }

        private void a() {
            if (k.this.f١٠٤٦٣d == this.f١٠٤٦٥a) {
            } else {
                throw new ConcurrentModificationException();
            }
        }

        void b() {
            this.f١٠٤٦٥a += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f١٠٤٦٦b >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (hasNext()) {
                int i10 = this.f١٠٤٦٦b;
                this.f١٠٤٦٧c = i10;
                Object n10 = k.this.n(i10);
                this.f١٠٤٦٦b = k.this.q(this.f١٠٤٦٦b);
                return n10;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean z10;
            a();
            if (this.f١٠٤٦٧c >= 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            h.c(z10);
            b();
            k kVar = k.this;
            kVar.remove(kVar.n(this.f١٠٤٦٧c));
            this.f١٠٤٦٦b = k.this.f(this.f١٠٤٦٦b, this.f١٠٤٦٧c);
            this.f١٠٤٦٧c = -1;
        }
    }

    k(int i10) {
        t(i10);
    }

    private void B(int i10) {
        int min;
        int length = y().length;
        if (i10 > length && (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            A(min);
        }
    }

    private int C(int i10, int i11, int i12, int i13) {
        Object a10 = l.a(i11);
        int i14 = i11 - 1;
        if (i13 != 0) {
            l.i(a10, i12 & i14, i13 + 1);
        }
        Object z10 = z();
        int[] y10 = y();
        for (int i15 = 0; i15 <= i10; i15++) {
            int h10 = l.h(z10, i15);
            while (h10 != 0) {
                int i16 = h10 - 1;
                int i17 = y10[i16];
                int b10 = l.b(i17, i10) | i15;
                int i18 = b10 & i14;
                int h11 = l.h(a10, i18);
                l.i(a10, i18, h10);
                y10[i16] = l.d(b10, h11, i14);
                h10 = l.c(i17, i10);
            }
        }
        this.f١٠٤٦٠a = a10;
        G(i14);
        return i14;
    }

    private void D(int i10, Object obj) {
        x()[i10] = obj;
    }

    private void F(int i10, int i11) {
        y()[i10] = i11;
    }

    private void G(int i10) {
        this.f١٠٤٦٣d = l.d(this.f١٠٤٦٣d, 32 - Integer.numberOfLeadingZeros(i10), 31);
    }

    private Set k(int i10) {
        return new LinkedHashSet(i10, 1.0f);
    }

    public static k l(int i10) {
        return new k(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object n(int i10) {
        return x()[i10];
    }

    private int o(int i10) {
        return y()[i10];
    }

    private int r() {
        return (1 << (this.f١٠٤٦٣d & 31)) - 1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            t(readInt);
            for (int i10 = 0; i10 < readInt; i10++) {
                add(objectInputStream.readObject());
            }
            return;
        }
        StringBuilder sb = new StringBuilder(25);
        sb.append("Invalid size: ");
        sb.append(readInt);
        throw new InvalidObjectException(sb.toString());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    private Object[] x() {
        Object[] objArr = this.f١٠٤٦٢c;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    private int[] y() {
        int[] iArr = this.f١٠٤٦١b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    private Object z() {
        Object obj = this.f١٠٤٦٠a;
        Objects.requireNonNull(obj);
        return obj;
    }

    void A(int i10) {
        this.f١٠٤٦١b = Arrays.copyOf(y(), i10);
        this.f١٠٤٦٢c = Arrays.copyOf(x(), i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        if (w()) {
            h();
        }
        Set m10 = m();
        if (m10 != null) {
            return m10.add(obj);
        }
        int[] y10 = y();
        Object[] x10 = x();
        int i10 = this.f١٠٤٦٤e;
        int i11 = i10 + 1;
        int c10 = p.c(obj);
        int r10 = r();
        int i12 = c10 & r10;
        int h10 = l.h(z(), i12);
        if (h10 == 0) {
            if (i11 > r10) {
                r10 = C(r10, l.e(r10), c10, i10);
            } else {
                l.i(z(), i12, i11);
            }
        } else {
            int b10 = l.b(c10, r10);
            int i13 = 0;
            while (true) {
                int i14 = h10 - 1;
                int i15 = y10[i14];
                if (l.b(i15, r10) == b10 && k8.f.a(obj, x10[i14])) {
                    return false;
                }
                int c11 = l.c(i15, r10);
                i13++;
                if (c11 == 0) {
                    if (i13 >= 9) {
                        return i().add(obj);
                    }
                    if (i11 > r10) {
                        r10 = C(r10, l.e(r10), c10, i10);
                    } else {
                        y10[i14] = l.d(i15, i11, r10);
                    }
                } else {
                    h10 = c11;
                }
            }
        }
        B(i11);
        u(i10, obj, c10, r10);
        this.f١٠٤٦٤e = i11;
        s();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (w()) {
            return;
        }
        s();
        Set m10 = m();
        if (m10 != null) {
            this.f١٠٤٦٣d = l8.a.a(size(), 3, 1073741823);
            m10.clear();
            this.f١٠٤٦٠a = null;
            this.f١٠٤٦٤e = 0;
            return;
        }
        Arrays.fill(x(), 0, this.f١٠٤٦٤e, (Object) null);
        l.g(z());
        Arrays.fill(y(), 0, this.f١٠٤٦٤e, 0);
        this.f١٠٤٦٤e = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (w()) {
            return false;
        }
        Set m10 = m();
        if (m10 != null) {
            return m10.contains(obj);
        }
        int c10 = p.c(obj);
        int r10 = r();
        int h10 = l.h(z(), c10 & r10);
        if (h10 == 0) {
            return false;
        }
        int b10 = l.b(c10, r10);
        do {
            int i10 = h10 - 1;
            int o10 = o(i10);
            if (l.b(o10, r10) == b10 && k8.f.a(obj, n(i10))) {
                return true;
            }
            h10 = l.c(o10, r10);
        } while (h10 != 0);
        return false;
    }

    int f(int i10, int i11) {
        return i10 - 1;
    }

    int h() {
        k8.h.o(w(), "Arrays already allocated");
        int i10 = this.f١٠٤٦٣d;
        int j10 = l.j(i10);
        this.f١٠٤٦٠a = l.a(j10);
        G(j10 - 1);
        this.f١٠٤٦١b = new int[i10];
        this.f١٠٤٦٢c = new Object[i10];
        return i10;
    }

    Set i() {
        Set k10 = k(r() + 1);
        int p10 = p();
        while (p10 >= 0) {
            k10.add(n(p10));
            p10 = q(p10);
        }
        this.f١٠٤٦٠a = k10;
        this.f١٠٤٦١b = null;
        this.f١٠٤٦٢c = null;
        s();
        return k10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        Set m10 = m();
        if (m10 != null) {
            return m10.iterator();
        }
        return new a();
    }

    Set m() {
        Object obj = this.f١٠٤٦٠a;
        if (obj instanceof Set) {
            return (Set) obj;
        }
        return null;
    }

    int p() {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    int q(int i10) {
        int i11 = i10 + 1;
        if (i11 >= this.f١٠٤٦٤e) {
            return -1;
        }
        return i11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (w()) {
            return false;
        }
        Set m10 = m();
        if (m10 != null) {
            return m10.remove(obj);
        }
        int r10 = r();
        int f10 = l.f(obj, null, r10, z(), y(), x(), null);
        if (f10 == -1) {
            return false;
        }
        v(f10, r10);
        this.f١٠٤٦٤e--;
        s();
        return true;
    }

    void s() {
        this.f١٠٤٦٣d += 32;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        Set m10 = m();
        if (m10 != null) {
            return m10.size();
        }
        return this.f١٠٤٦٤e;
    }

    void t(int i10) {
        boolean z10;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        k8.h.e(z10, "Expected size must be >= 0");
        this.f١٠٤٦٣d = l8.a.a(i10, 1, 1073741823);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        if (w()) {
            return new Object[0];
        }
        Set m10 = m();
        return m10 != null ? m10.toArray() : Arrays.copyOf(x(), this.f١٠٤٦٤e);
    }

    void u(int i10, Object obj, int i11, int i12) {
        F(i10, l.d(i11, 0, i12));
        D(i10, obj);
    }

    void v(int i10, int i11) {
        Object z10 = z();
        int[] y10 = y();
        Object[] x10 = x();
        int size = size();
        int i12 = size - 1;
        if (i10 < i12) {
            Object obj = x10[i12];
            x10[i10] = obj;
            x10[i12] = null;
            y10[i10] = y10[i12];
            y10[i12] = 0;
            int c10 = p.c(obj) & i11;
            int h10 = l.h(z10, c10);
            if (h10 == size) {
                l.i(z10, c10, i10 + 1);
                return;
            }
            while (true) {
                int i13 = h10 - 1;
                int i14 = y10[i13];
                int c11 = l.c(i14, i11);
                if (c11 == size) {
                    y10[i13] = l.d(i14, i10 + 1, i11);
                    return;
                }
                h10 = c11;
            }
        } else {
            x10[i10] = null;
            y10[i10] = 0;
        }
    }

    boolean w() {
        if (this.f١٠٤٦٠a == null) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        if (w()) {
            if (objArr.length > 0) {
                objArr[0] = null;
            }
            return objArr;
        }
        Set m10 = m();
        if (m10 != null) {
            return m10.toArray(objArr);
        }
        return c0.e(x(), 0, this.f١٠٤٦٤e, objArr);
    }
}
