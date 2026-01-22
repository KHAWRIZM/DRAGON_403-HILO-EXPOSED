package com.google.common.collect;

import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
abstract class e implements z {

    /* renamed from: a, reason: collision with root package name */
    private transient Set f١٠٤٠٤a;

    /* renamed from: b, reason: collision with root package name */
    private transient Map f١٠٤٠٥b;

    @Override // com.google.common.collect.z
    public Map a() {
        Map map = this.f١٠٤٠٥b;
        if (map == null) {
            Map b10 = b();
            this.f١٠٤٠٥b = b10;
            return b10;
        }
        return map;
    }

    abstract Map b();

    abstract Set c();

    public Set d() {
        Set set = this.f١٠٤٠٤a;
        if (set == null) {
            Set c10 = c();
            this.f١٠٤٠٤a = c10;
            return c10;
        }
        return set;
    }

    public boolean equals(Object obj) {
        return a0.a(this, obj);
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString();
    }
}
