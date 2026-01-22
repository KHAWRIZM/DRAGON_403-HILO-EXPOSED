package com.google.protobuf;

import com.google.protobuf.b0;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class c2 extends AbstractMap {

    /* renamed from: a, reason: collision with root package name */
    private final int f١٠٩٤٠a;

    /* renamed from: b, reason: collision with root package name */
    private List f١٠٩٤١b;

    /* renamed from: c, reason: collision with root package name */
    private Map f١٠٩٤٢c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f١٠٩٤٣d;

    /* renamed from: e, reason: collision with root package name */
    private volatile e f١٠٩٤٤e;

    /* renamed from: f, reason: collision with root package name */
    private Map f١٠٩٤٥f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends c2 {
        a(int i10) {
            super(i10, null);
        }

        @Override // com.google.protobuf.c2
        public void p() {
            if (!o()) {
                for (int i10 = 0; i10 < k(); i10++) {
                    Map.Entry j10 = j(i10);
                    if (((b0.c) j10.getKey()).isRepeated()) {
                        j10.setValue(Collections.unmodifiableList((List) j10.getValue()));
                    }
                }
                for (Map.Entry entry : m()) {
                    if (((b0.c) entry.getKey()).isRepeated()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.p();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.r((Comparable) obj, obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final Iterator f١٠٩٤٦a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final Iterable f١٠٩٤٧b = new C٠١٣٤b();

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a implements Iterator {
            a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* renamed from: com.google.protobuf.c2$b$b, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class C٠١٣٤b implements Iterable {
            C٠١٣٤b() {
            }

            @Override // java.lang.Iterable
            public Iterator iterator() {
                return b.f١٠٩٤٦a;
            }
        }

        static Iterable b() {
            return f١٠٩٤٧b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class c implements Map.Entry, Comparable {

        /* renamed from: a, reason: collision with root package name */
        private final Comparable f١٠٩٤٨a;

        /* renamed from: b, reason: collision with root package name */
        private Object f١٠٩٤٩b;

        c(c2 c2Var, Map.Entry entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        private boolean c(Object obj, Object obj2) {
            if (obj == null) {
                if (obj2 == null) {
                    return true;
                }
                return false;
            }
            return obj.equals(obj2);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return getKey().compareTo(cVar.getKey());
        }

        @Override // java.util.Map.Entry
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Comparable getKey() {
            return this.f١٠٩٤٨a;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (c(this.f١٠٩٤٨a, entry.getKey()) && c(this.f١٠٩٤٩b, entry.getValue())) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f١٠٩٤٩b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            Comparable comparable = this.f١٠٩٤٨a;
            int i10 = 0;
            if (comparable == null) {
                hashCode = 0;
            } else {
                hashCode = comparable.hashCode();
            }
            Object obj = this.f١٠٩٤٩b;
            if (obj != null) {
                i10 = obj.hashCode();
            }
            return hashCode ^ i10;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            c2.this.h();
            Object obj2 = this.f١٠٩٤٩b;
            this.f١٠٩٤٩b = obj;
            return obj2;
        }

        public String toString() {
            return this.f١٠٩٤٨a + "=" + this.f١٠٩٤٩b;
        }

        c(Comparable comparable, Object obj) {
            this.f١٠٩٤٨a = comparable;
            this.f١٠٩٤٩b = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class e extends AbstractSet {
        private e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            c2.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = c2.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value && (obj2 == null || !obj2.equals(value))) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            if (!contains(entry)) {
                c2.this.r((Comparable) entry.getKey(), entry.getValue());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new d(c2.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                c2.this.remove(entry.getKey());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return c2.this.size();
        }

        /* synthetic */ e(c2 c2Var, a aVar) {
            this();
        }
    }

    /* synthetic */ c2(int i10, a aVar) {
        this(i10);
    }

    private int g(Comparable comparable) {
        int i10;
        int size = this.f١٠٩٤١b.size();
        int i11 = size - 1;
        if (i11 >= 0) {
            int compareTo = comparable.compareTo(((c) this.f١٠٩٤١b.get(i11)).getKey());
            if (compareTo > 0) {
                i10 = size + 1;
                return -i10;
            }
            if (compareTo == 0) {
                return i11;
            }
        }
        int i12 = 0;
        while (i12 <= i11) {
            int i13 = (i12 + i11) / 2;
            int compareTo2 = comparable.compareTo(((c) this.f١٠٩٤١b.get(i13)).getKey());
            if (compareTo2 < 0) {
                i11 = i13 - 1;
            } else if (compareTo2 > 0) {
                i12 = i13 + 1;
            } else {
                return i13;
            }
        }
        i10 = i12 + 1;
        return -i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (!this.f١٠٩٤٣d) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private void i() {
        h();
        if (this.f١٠٩٤١b.isEmpty() && !(this.f١٠٩٤١b instanceof ArrayList)) {
            this.f١٠٩٤١b = new ArrayList(this.f١٠٩٤٠a);
        }
    }

    private SortedMap n() {
        h();
        if (this.f١٠٩٤٢c.isEmpty() && !(this.f١٠٩٤٢c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f١٠٩٤٢c = treeMap;
            this.f١٠٩٤٥f = treeMap.descendingMap();
        }
        return (SortedMap) this.f١٠٩٤٢c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c2 q(int i10) {
        return new a(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object s(int i10) {
        h();
        Object value = ((c) this.f١٠٩٤١b.remove(i10)).getValue();
        if (!this.f١٠٩٤٢c.isEmpty()) {
            Iterator it = n().entrySet().iterator();
            this.f١٠٩٤١b.add(new c(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        h();
        if (!this.f١٠٩٤١b.isEmpty()) {
            this.f١٠٩٤١b.clear();
        }
        if (!this.f١٠٩٤٢c.isEmpty()) {
            this.f١٠٩٤٢c.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (g(comparable) < 0 && !this.f١٠٩٤٢c.containsKey(comparable)) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.f١٠٩٤٤e == null) {
            this.f١٠٩٤٤e = new e(this, null);
        }
        return this.f١٠٩٤٤e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c2)) {
            return super.equals(obj);
        }
        c2 c2Var = (c2) obj;
        int size = size();
        if (size != c2Var.size()) {
            return false;
        }
        int k10 = k();
        if (k10 != c2Var.k()) {
            return entrySet().equals(c2Var.entrySet());
        }
        for (int i10 = 0; i10 < k10; i10++) {
            if (!j(i10).equals(c2Var.j(i10))) {
                return false;
            }
        }
        if (k10 == size) {
            return true;
        }
        return this.f١٠٩٤٢c.equals(c2Var.f١٠٩٤٢c);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int g10 = g(comparable);
        if (g10 >= 0) {
            return ((c) this.f١٠٩٤١b.get(g10)).getValue();
        }
        return this.f١٠٩٤٢c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int k10 = k();
        int i10 = 0;
        for (int i11 = 0; i11 < k10; i11++) {
            i10 += ((c) this.f١٠٩٤١b.get(i11)).hashCode();
        }
        if (l() > 0) {
            return i10 + this.f١٠٩٤٢c.hashCode();
        }
        return i10;
    }

    public Map.Entry j(int i10) {
        return (Map.Entry) this.f١٠٩٤١b.get(i10);
    }

    public int k() {
        return this.f١٠٩٤١b.size();
    }

    public int l() {
        return this.f١٠٩٤٢c.size();
    }

    public Iterable m() {
        if (this.f١٠٩٤٢c.isEmpty()) {
            return b.b();
        }
        return this.f١٠٩٤٢c.entrySet();
    }

    public boolean o() {
        return this.f١٠٩٤٣d;
    }

    public void p() {
        Map unmodifiableMap;
        Map unmodifiableMap2;
        if (!this.f١٠٩٤٣d) {
            if (this.f١٠٩٤٢c.isEmpty()) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(this.f١٠٩٤٢c);
            }
            this.f١٠٩٤٢c = unmodifiableMap;
            if (this.f١٠٩٤٥f.isEmpty()) {
                unmodifiableMap2 = Collections.emptyMap();
            } else {
                unmodifiableMap2 = Collections.unmodifiableMap(this.f١٠٩٤٥f);
            }
            this.f١٠٩٤٥f = unmodifiableMap2;
            this.f١٠٩٤٣d = true;
        }
    }

    public Object r(Comparable comparable, Object obj) {
        h();
        int g10 = g(comparable);
        if (g10 >= 0) {
            return ((c) this.f١٠٩٤١b.get(g10)).setValue(obj);
        }
        i();
        int i10 = -(g10 + 1);
        if (i10 >= this.f١٠٩٤٠a) {
            return n().put(comparable, obj);
        }
        int size = this.f١٠٩٤١b.size();
        int i11 = this.f١٠٩٤٠a;
        if (size == i11) {
            c cVar = (c) this.f١٠٩٤١b.remove(i11 - 1);
            n().put(cVar.getKey(), cVar.getValue());
        }
        this.f١٠٩٤١b.add(i10, new c(comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        h();
        Comparable comparable = (Comparable) obj;
        int g10 = g(comparable);
        if (g10 >= 0) {
            return s(g10);
        }
        if (this.f١٠٩٤٢c.isEmpty()) {
            return null;
        }
        return this.f١٠٩٤٢c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f١٠٩٤١b.size() + this.f١٠٩٤٢c.size();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private class d implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        private int f١٠٩٥١a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f١٠٩٥٢b;

        /* renamed from: c, reason: collision with root package name */
        private Iterator f١٠٩٥٣c;

        private d() {
            this.f١٠٩٥١a = -1;
        }

        private Iterator a() {
            if (this.f١٠٩٥٣c == null) {
                this.f١٠٩٥٣c = c2.this.f١٠٩٤٢c.entrySet().iterator();
            }
            return this.f١٠٩٥٣c;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            this.f١٠٩٥٢b = true;
            int i10 = this.f١٠٩٥١a + 1;
            this.f١٠٩٥١a = i10;
            if (i10 < c2.this.f١٠٩٤١b.size()) {
                return (Map.Entry) c2.this.f١٠٩٤١b.get(this.f١٠٩٥١a);
            }
            return (Map.Entry) a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f١٠٩٥١a + 1 < c2.this.f١٠٩٤١b.size()) {
                return true;
            }
            if (!c2.this.f١٠٩٤٢c.isEmpty() && a().hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f١٠٩٥٢b) {
                this.f١٠٩٥٢b = false;
                c2.this.h();
                if (this.f١٠٩٥١a < c2.this.f١٠٩٤١b.size()) {
                    c2 c2Var = c2.this;
                    int i10 = this.f١٠٩٥١a;
                    this.f١٠٩٥١a = i10 - 1;
                    c2Var.s(i10);
                    return;
                }
                a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        /* synthetic */ d(c2 c2Var, a aVar) {
            this();
        }
    }

    private c2(int i10) {
        this.f١٠٩٤٠a = i10;
        this.f١٠٩٤١b = Collections.emptyList();
        this.f١٠٩٤٢c = Collections.emptyMap();
        this.f١٠٩٤٥f = Collections.emptyMap();
    }
}
