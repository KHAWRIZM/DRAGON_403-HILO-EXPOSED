package com.google.common.collect;

import com.google.common.collect.j0;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class y {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends l0 {
        a(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.l0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Object a(Map.Entry entry) {
            return entry.getValue();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static abstract class b implements k8.c {

        /* renamed from: a, reason: collision with root package name */
        public static final b f١٠٥٠٣a = new a("KEY", 0);

        /* renamed from: b, reason: collision with root package name */
        public static final b f١٠٥٠٤b = new C٠١٢٧b("VALUE", 1);

        /* renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ b[] f١٠٥٠٥c = a();

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        enum a extends b {
            a(String str, int i10) {
                super(str, i10, null);
            }

            @Override // k8.c
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry entry) {
                return entry.getKey();
            }
        }

        /* renamed from: com.google.common.collect.y$b$b, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        enum C٠١٢٧b extends b {
            C٠١٢٧b(String str, int i10) {
                super(str, i10, null);
            }

            @Override // k8.c
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry entry) {
                return entry.getValue();
            }
        }

        private b(String str, int i10) {
        }

        private static /* synthetic */ b[] a() {
            return new b[]{f١٠٥٠٣a, f١٠٥٠٤b};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f١٠٥٠٥c.clone();
        }

        /* synthetic */ b(String str, int i10, x xVar) {
            this(str, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class c extends j0.b {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            d().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public abstract boolean contains(Object obj);

        abstract Map d();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return d().isEmpty();
        }

        @Override // com.google.common.collect.j0.b, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            try {
                return super.removeAll((Collection) k8.h.i(collection));
            } catch (UnsupportedOperationException unused) {
                return j0.f(this, collection.iterator());
            }
        }

        @Override // com.google.common.collect.j0.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            try {
                return super.retainAll((Collection) k8.h.i(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet d10 = j0.d(collection.size());
                for (Object obj : collection) {
                    if (contains(obj) && (obj instanceof Map.Entry)) {
                        d10.add(((Map.Entry) obj).getKey());
                    }
                }
                return d().keySet().retainAll(d10);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return d().size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class d extends j0.b {

        /* renamed from: a, reason: collision with root package name */
        final Map f١٠٥٠٦a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(Map map) {
            this.f١٠٥٠٦a = (Map) k8.h.i(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return d().containsKey(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Map d() {
            return this.f١٠٥٠٦a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return d().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return d().size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class e extends AbstractCollection {

        /* renamed from: a, reason: collision with root package name */
        final Map f١٠٥٠٧a;

        e(Map map) {
            this.f١٠٥٠٧a = (Map) k8.h.i(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            d().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return d().containsValue(obj);
        }

        final Map d() {
            return this.f١٠٥٠٧a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return d().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return y.i(d().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry entry : d().entrySet()) {
                    if (k8.f.a(obj, entry.getValue())) {
                        d().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            try {
                return super.removeAll((Collection) k8.h.i(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet c10 = j0.c();
                for (Map.Entry entry : d().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        c10.add(entry.getKey());
                    }
                }
                return d().keySet().removeAll(c10);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            try {
                return super.retainAll((Collection) k8.h.i(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet c10 = j0.c();
                for (Map.Entry entry : d().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        c10.add(entry.getKey());
                    }
                }
                return d().keySet().retainAll(c10);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return d().size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class f extends AbstractMap {

        /* renamed from: a, reason: collision with root package name */
        private transient Set f١٠٥٠٨a;

        /* renamed from: b, reason: collision with root package name */
        private transient Collection f١٠٥٠٩b;

        abstract Set c();

        Collection d() {
            return new e(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set entrySet() {
            Set set = this.f١٠٥٠٨a;
            if (set == null) {
                Set c10 = c();
                this.f١٠٥٠٨a = c10;
                return c10;
            }
            return set;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection values() {
            Collection collection = this.f١٠٥٠٩b;
            if (collection == null) {
                Collection d10 = d();
                this.f١٠٥٠٩b = d10;
                return d10;
            }
            return collection;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i10) {
        if (i10 < 3) {
            h.b(i10, "expectedSize");
            return i10 + 1;
        }
        if (i10 < 1073741824) {
            return (int) ((i10 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Map map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static Map.Entry c(Object obj, Object obj2) {
        return new r(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(Map map, Object obj) {
        k8.h.i(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object e(Map map, Object obj) {
        k8.h.i(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object f(Map map, Object obj) {
        k8.h.i(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(Map map) {
        StringBuilder a10 = i.a(map.size());
        a10.append('{');
        boolean z10 = true;
        for (Map.Entry entry : map.entrySet()) {
            if (!z10) {
                a10.append(", ");
            }
            a10.append(entry.getKey());
            a10.append('=');
            a10.append(entry.getValue());
            z10 = false;
        }
        a10.append('}');
        return a10.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k8.c h() {
        return b.f١٠٥٠٤b;
    }

    static Iterator i(Iterator it) {
        return new a(it);
    }
}
