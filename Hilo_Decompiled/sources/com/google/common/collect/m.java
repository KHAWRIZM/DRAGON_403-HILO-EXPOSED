package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class m extends d0 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    final Comparator f١٠٤٧١a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Comparator comparator) {
        this.f١٠٤٧١a = (Comparator) k8.h.i(comparator);
    }

    @Override // com.google.common.collect.d0, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f١٠٤٧١a.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            return this.f١٠٤٧١a.equals(((m) obj).f١٠٤٧١a);
        }
        return false;
    }

    public int hashCode() {
        return this.f١٠٤٧١a.hashCode();
    }

    public String toString() {
        return this.f١٠٤٧١a.toString();
    }
}
