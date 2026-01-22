package com.google.protobuf;

import com.google.protobuf.j0;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class w0 extends LinkedHashMap {

    /* renamed from: b, reason: collision with root package name */
    private static final w0 f١١٩٩١b;

    /* renamed from: a, reason: collision with root package name */
    private boolean f١١٩٩٢a;

    static {
        w0 w0Var = new w0();
        f١١٩٩١b = w0Var;
        w0Var.m();
    }

    private w0() {
        this.f١١٩٩٢a = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(Map map) {
        int i10 = 0;
        for (Map.Entry entry : map.entrySet()) {
            i10 += d(entry.getValue()) ^ d(entry.getKey());
        }
        return i10;
    }

    private static int d(Object obj) {
        if (obj instanceof byte[]) {
            return j0.d((byte[]) obj);
        }
        if (!(obj instanceof j0.c)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    private static void e(Map map) {
        for (Object obj : map.keySet()) {
            j0.a(obj);
            j0.a(map.get(obj));
        }
    }

    private static Object f(Object obj) {
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            return Arrays.copyOf(bArr, bArr.length);
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map g(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), f(entry.getValue()));
        }
        return linkedHashMap;
    }

    public static w0 h() {
        return f١١٩٩١b;
    }

    private void i() {
        if (l()) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private static boolean j(Object obj, Object obj2) {
        if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
            return Arrays.equals((byte[]) obj, (byte[]) obj2);
        }
        return obj.equals(obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k(Map map, Map map2) {
        if (map == map2) {
            return true;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || !j(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        i();
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
        if ((obj instanceof Map) && k(this, (Map) obj)) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return c(this);
    }

    public boolean l() {
        return this.f١١٩٩٢a;
    }

    public void m() {
        this.f١١٩٩٢a = false;
    }

    public void n(w0 w0Var) {
        i();
        if (!w0Var.isEmpty()) {
            putAll(w0Var);
        }
    }

    public w0 o() {
        if (isEmpty()) {
            return new w0();
        }
        return new w0(this);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        i();
        j0.a(obj);
        j0.a(obj2);
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        i();
        e(map);
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        i();
        return super.remove(obj);
    }

    private w0(Map map) {
        super(map);
        this.f١١٩٩٢a = true;
    }
}
