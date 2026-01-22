package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class f extends i implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f١٠٨٤٥a = new ArrayList();

    private i o() {
        int size = this.f١٠٨٤٥a.size();
        if (size == 1) {
            return (i) this.f١٠٨٤٥a.get(0);
        }
        throw new IllegalStateException("Array must have size 1, but has size " + size);
    }

    public boolean equals(Object obj) {
        if (obj != this && (!(obj instanceof f) || !((f) obj).f١٠٨٤٥a.equals(this.f١٠٨٤٥a))) {
            return false;
        }
        return true;
    }

    @Override // com.google.gson.i
    public String h() {
        return o().h();
    }

    public int hashCode() {
        return this.f١٠٨٤٥a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f١٠٨٤٥a.iterator();
    }

    public void n(i iVar) {
        if (iVar == null) {
            iVar = k.f١٠٨٤٦a;
        }
        this.f١٠٨٤٥a.add(iVar);
    }
}
