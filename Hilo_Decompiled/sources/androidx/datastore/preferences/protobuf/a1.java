package androidx.datastore.preferences.protobuf;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a1 extends AbstractMap {

    /* renamed from: a, reason: collision with root package name */
    private List f٣٢٤٦a;

    /* renamed from: b, reason: collision with root package name */
    private Map f٣٢٤٧b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f٣٢٤٨c;

    /* renamed from: d, reason: collision with root package name */
    private volatile f f٣٢٤٩d;

    /* renamed from: e, reason: collision with root package name */
    private Map f٣٢٥٠e;

    /* renamed from: f, reason: collision with root package name */
    private volatile c f٣٢٥١f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a extends a1 {
        a() {
            super(null);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.t((Comparable) obj, obj2);
        }

        @Override // androidx.datastore.preferences.protobuf.a1
        public void r() {
            if (!q()) {
                if (m() <= 0) {
                    Iterator it = o().iterator();
                    if (it.hasNext()) {
                        androidx.appcompat.app.a0.a(((Map.Entry) it.next()).getKey());
                        throw null;
                    }
                } else {
                    androidx.appcompat.app.a0.a(l(0).getKey());
                    throw null;
                }
            }
            super.r();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private class c extends f {
        private c() {
            super(a1.this, null);
        }

        @Override // androidx.datastore.preferences.protobuf.a1.f, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new b(a1.this, null);
        }

        /* synthetic */ c(a1 a1Var, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class d implements Map.Entry, Comparable {

        /* renamed from: a, reason: collision with root package name */
        private final Comparable f٣٢٥٦a;

        /* renamed from: b, reason: collision with root package name */
        private Object f٣٢٥٧b;

        d(a1 a1Var, Map.Entry entry) {
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
        public int compareTo(d dVar) {
            return getKey().compareTo(dVar.getKey());
        }

        @Override // java.util.Map.Entry
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Comparable getKey() {
            return this.f٣٢٥٦a;
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
            if (c(this.f٣٢٥٦a, entry.getKey()) && c(this.f٣٢٥٧b, entry.getValue())) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f٣٢٥٧b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            Comparable comparable = this.f٣٢٥٦a;
            int i10 = 0;
            if (comparable == null) {
                hashCode = 0;
            } else {
                hashCode = comparable.hashCode();
            }
            Object obj = this.f٣٢٥٧b;
            if (obj != null) {
                i10 = obj.hashCode();
            }
            return hashCode ^ i10;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            a1.this.i();
            Object obj2 = this.f٣٢٥٧b;
            this.f٣٢٥٧b = obj;
            return obj2;
        }

        public String toString() {
            return this.f٣٢٥٦a + "=" + this.f٣٢٥٧b;
        }

        d(Comparable comparable, Object obj) {
            this.f٣٢٥٦a = comparable;
            this.f٣٢٥٧b = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class f extends AbstractSet {
        private f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a1.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = a1.this.get(entry.getKey());
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
                a1.this.t((Comparable) entry.getKey(), entry.getValue());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new e(a1.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                a1.this.remove(entry.getKey());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a1.this.size();
        }

        /* synthetic */ f(a1 a1Var, a aVar) {
            this();
        }
    }

    /* synthetic */ a1(a aVar) {
        this();
    }

    private int h(Comparable comparable) {
        int i10;
        int size = this.f٣٢٤٦a.size();
        int i11 = size - 1;
        if (i11 >= 0) {
            int compareTo = comparable.compareTo(((d) this.f٣٢٤٦a.get(i11)).getKey());
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
            int compareTo2 = comparable.compareTo(((d) this.f٣٢٤٦a.get(i13)).getKey());
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
    public void i() {
        if (!this.f٣٢٤٨c) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private void k() {
        i();
        if (this.f٣٢٤٦a.isEmpty() && !(this.f٣٢٤٦a instanceof ArrayList)) {
            this.f٣٢٤٦a = new ArrayList(16);
        }
    }

    private SortedMap p() {
        i();
        if (this.f٣٢٤٧b.isEmpty() && !(this.f٣٢٤٧b instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f٣٢٤٧b = treeMap;
            this.f٣٢٥٠e = treeMap.descendingMap();
        }
        return (SortedMap) this.f٣٢٤٧b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a1 s() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object u(int i10) {
        i();
        Object value = ((d) this.f٣٢٤٦a.remove(i10)).getValue();
        if (!this.f٣٢٤٧b.isEmpty()) {
            Iterator it = p().entrySet().iterator();
            this.f٣٢٤٦a.add(new d(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        i();
        if (!this.f٣٢٤٦a.isEmpty()) {
            this.f٣٢٤٦a.clear();
        }
        if (!this.f٣٢٤٧b.isEmpty()) {
            this.f٣٢٤٧b.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (h(comparable) < 0 && !this.f٣٢٤٧b.containsKey(comparable)) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.f٣٢٤٩d == null) {
            this.f٣٢٤٩d = new f(this, null);
        }
        return this.f٣٢٤٩d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a1)) {
            return super.equals(obj);
        }
        a1 a1Var = (a1) obj;
        int size = size();
        if (size != a1Var.size()) {
            return false;
        }
        int m10 = m();
        if (m10 != a1Var.m()) {
            return entrySet().equals(a1Var.entrySet());
        }
        for (int i10 = 0; i10 < m10; i10++) {
            if (!l(i10).equals(a1Var.l(i10))) {
                return false;
            }
        }
        if (m10 == size) {
            return true;
        }
        return this.f٣٢٤٧b.equals(a1Var.f٣٢٤٧b);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int h10 = h(comparable);
        if (h10 >= 0) {
            return ((d) this.f٣٢٤٦a.get(h10)).getValue();
        }
        return this.f٣٢٤٧b.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int m10 = m();
        int i10 = 0;
        for (int i11 = 0; i11 < m10; i11++) {
            i10 += ((d) this.f٣٢٤٦a.get(i11)).hashCode();
        }
        if (n() > 0) {
            return i10 + this.f٣٢٤٧b.hashCode();
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set j() {
        if (this.f٣٢٥١f == null) {
            this.f٣٢٥١f = new c(this, null);
        }
        return this.f٣٢٥١f;
    }

    public Map.Entry l(int i10) {
        return (Map.Entry) this.f٣٢٤٦a.get(i10);
    }

    public int m() {
        return this.f٣٢٤٦a.size();
    }

    public int n() {
        return this.f٣٢٤٧b.size();
    }

    public Iterable o() {
        if (this.f٣٢٤٧b.isEmpty()) {
            return Collections.emptySet();
        }
        return this.f٣٢٤٧b.entrySet();
    }

    public boolean q() {
        return this.f٣٢٤٨c;
    }

    public void r() {
        Map unmodifiableMap;
        Map unmodifiableMap2;
        if (!this.f٣٢٤٨c) {
            if (this.f٣٢٤٧b.isEmpty()) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(this.f٣٢٤٧b);
            }
            this.f٣٢٤٧b = unmodifiableMap;
            if (this.f٣٢٥٠e.isEmpty()) {
                unmodifiableMap2 = Collections.emptyMap();
            } else {
                unmodifiableMap2 = Collections.unmodifiableMap(this.f٣٢٥٠e);
            }
            this.f٣٢٥٠e = unmodifiableMap2;
            this.f٣٢٤٨c = true;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        i();
        Comparable comparable = (Comparable) obj;
        int h10 = h(comparable);
        if (h10 >= 0) {
            return u(h10);
        }
        if (this.f٣٢٤٧b.isEmpty()) {
            return null;
        }
        return this.f٣٢٤٧b.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f٣٢٤٦a.size() + this.f٣٢٤٧b.size();
    }

    public Object t(Comparable comparable, Object obj) {
        i();
        int h10 = h(comparable);
        if (h10 >= 0) {
            return ((d) this.f٣٢٤٦a.get(h10)).setValue(obj);
        }
        k();
        int i10 = -(h10 + 1);
        if (i10 >= 16) {
            return p().put(comparable, obj);
        }
        if (this.f٣٢٤٦a.size() == 16) {
            d dVar = (d) this.f٣٢٤٦a.remove(15);
            p().put(dVar.getKey(), dVar.getValue());
        }
        this.f٣٢٤٦a.add(i10, new d(comparable, obj));
        return null;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private class b implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        private int f٣٢٥٢a;

        /* renamed from: b, reason: collision with root package name */
        private Iterator f٣٢٥٣b;

        private b() {
            this.f٣٢٥٢a = a1.this.f٣٢٤٦a.size();
        }

        private Iterator a() {
            if (this.f٣٢٥٣b == null) {
                this.f٣٢٥٣b = a1.this.f٣٢٥٠e.entrySet().iterator();
            }
            return this.f٣٢٥٣b;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (!a().hasNext()) {
                List list = a1.this.f٣٢٤٦a;
                int i10 = this.f٣٢٥٢a - 1;
                this.f٣٢٥٢a = i10;
                return (Map.Entry) list.get(i10);
            }
            return (Map.Entry) a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i10 = this.f٣٢٥٢a;
            if ((i10 > 0 && i10 <= a1.this.f٣٢٤٦a.size()) || a().hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* synthetic */ b(a1 a1Var, a aVar) {
            this();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private class e implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        private int f٣٢٥٩a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f٣٢٦٠b;

        /* renamed from: c, reason: collision with root package name */
        private Iterator f٣٢٦١c;

        private e() {
            this.f٣٢٥٩a = -1;
        }

        private Iterator a() {
            if (this.f٣٢٦١c == null) {
                this.f٣٢٦١c = a1.this.f٣٢٤٧b.entrySet().iterator();
            }
            return this.f٣٢٦١c;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            this.f٣٢٦٠b = true;
            int i10 = this.f٣٢٥٩a + 1;
            this.f٣٢٥٩a = i10;
            if (i10 < a1.this.f٣٢٤٦a.size()) {
                return (Map.Entry) a1.this.f٣٢٤٦a.get(this.f٣٢٥٩a);
            }
            return (Map.Entry) a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f٣٢٥٩a + 1 < a1.this.f٣٢٤٦a.size()) {
                return true;
            }
            if (!a1.this.f٣٢٤٧b.isEmpty() && a().hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f٣٢٦٠b) {
                this.f٣٢٦٠b = false;
                a1.this.i();
                if (this.f٣٢٥٩a < a1.this.f٣٢٤٦a.size()) {
                    a1 a1Var = a1.this;
                    int i10 = this.f٣٢٥٩a;
                    this.f٣٢٥٩a = i10 - 1;
                    a1Var.u(i10);
                    return;
                }
                a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        /* synthetic */ e(a1 a1Var, a aVar) {
            this();
        }
    }

    private a1() {
        this.f٣٢٤٦a = Collections.emptyList();
        this.f٣٢٤٧b = Collections.emptyMap();
        this.f٣٢٥٠e = Collections.emptyMap();
    }
}
