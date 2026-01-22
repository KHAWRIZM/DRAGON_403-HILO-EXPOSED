package com.bumptech.glide;

import f5.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class k implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private d5.c f٧٤١٥a = d5.a.b();

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final k clone() {
        try {
            return (k) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final d5.c b() {
        return this.f٧٤١٥a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            return l.e(this.f٧٤١٥a, ((k) obj).f٧٤١٥a);
        }
        return false;
    }

    public int hashCode() {
        d5.c cVar = this.f٧٤١٥a;
        if (cVar != null) {
            return cVar.hashCode();
        }
        return 0;
    }
}
