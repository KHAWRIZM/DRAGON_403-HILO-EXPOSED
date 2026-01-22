package androidx.datastore.preferences.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d0 extends LinkedHashMap {

    /* renamed from: b, reason: collision with root package name */
    private static final d0 f٣٢٨١b;

    /* renamed from: a, reason: collision with root package name */
    private boolean f٣٢٨٢a;

    static {
        d0 d0Var = new d0();
        f٣٢٨١b = d0Var;
        d0Var.k();
    }

    private d0() {
        this.f٣٢٨٢a = true;
    }

    static int c(Map map) {
        int i10 = 0;
        for (Map.Entry entry : map.entrySet()) {
            i10 += d(entry.getValue()) ^ d(entry.getKey());
        }
        return i10;
    }

    private static int d(Object obj) {
        if (obj instanceof byte[]) {
            return u.d((byte[]) obj);
        }
        return obj.hashCode();
    }

    private static void e(Map map) {
        for (Object obj : map.keySet()) {
            u.a(obj);
            u.a(map.get(obj));
        }
    }

    public static d0 f() {
        return f٣٢٨١b;
    }

    private void g() {
        if (j()) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private static boolean h(Object obj, Object obj2) {
        if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
            return Arrays.equals((byte[]) obj, (byte[]) obj2);
        }
        return obj.equals(obj2);
    }

    static boolean i(Map map, Map map2) {
        if (map == map2) {
            return true;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || !h(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        g();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        return super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if ((obj instanceof Map) && i(this, (Map) obj)) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return c(this);
    }

    public boolean j() {
        return this.f٣٢٨٢a;
    }

    public void k() {
        this.f٣٢٨٢a = false;
    }

    public void l(d0 d0Var) {
        g();
        if (!d0Var.isEmpty()) {
            putAll(d0Var);
        }
    }

    public d0 m() {
        if (isEmpty()) {
            return new d0();
        }
        return new d0(this);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        g();
        u.a(obj);
        u.a(obj2);
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        g();
        e(map);
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        g();
        return super.remove(obj);
    }

    private d0(Map map) {
        super(map);
        this.f٣٢٨٢a = true;
    }
}
