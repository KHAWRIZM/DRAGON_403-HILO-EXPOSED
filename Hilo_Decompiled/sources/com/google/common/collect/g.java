package com.google.common.collect;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class g extends d0 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    final k8.c f١٠٤٠٩a;

    /* renamed from: b, reason: collision with root package name */
    final d0 f١٠٤١٠b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(k8.c cVar, d0 d0Var) {
        this.f١٠٤٠٩a = (k8.c) k8.h.i(cVar);
        this.f١٠٤١٠b = (d0) k8.h.i(d0Var);
    }

    @Override // com.google.common.collect.d0, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f١٠٤١٠b.compare(this.f١٠٤٠٩a.apply(obj), this.f١٠٤٠٩a.apply(obj2));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f١٠٤٠٩a.equals(gVar.f١٠٤٠٩a) && this.f١٠٤١٠b.equals(gVar.f١٠٤١٠b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return k8.f.b(this.f١٠٤٠٩a, this.f١٠٤١٠b);
    }

    public String toString() {
        String valueOf = String.valueOf(this.f١٠٤١٠b);
        String valueOf2 = String.valueOf(this.f١٠٤٠٩a);
        StringBuilder sb = new StringBuilder(valueOf.length() + 13 + valueOf2.length());
        sb.append(valueOf);
        sb.append(".onResultOf(");
        sb.append(valueOf2);
        sb.append(")");
        return sb.toString();
    }
}
