package com.google.gson;

import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class l extends i {

    /* renamed from: a, reason: collision with root package name */
    private final q8.h f١٠٨٤٧a = new q8.h(false);

    public boolean equals(Object obj) {
        if (obj != this && (!(obj instanceof l) || !((l) obj).f١٠٨٤٧a.equals(this.f١٠٨٤٧a))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f١٠٨٤٧a.hashCode();
    }

    public void n(String str, i iVar) {
        q8.h hVar = this.f١٠٨٤٧a;
        if (iVar == null) {
            iVar = k.f١٠٨٤٦a;
        }
        hVar.put(str, iVar);
    }

    public Set o() {
        return this.f١٠٨٤٧a.entrySet();
    }

    public i p(String str) {
        return (i) this.f١٠٨٤٧a.get(str);
    }

    public o q(String str) {
        return (o) this.f١٠٨٤٧a.get(str);
    }
}
