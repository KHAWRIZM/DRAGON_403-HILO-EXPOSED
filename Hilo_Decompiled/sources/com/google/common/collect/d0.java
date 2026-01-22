package com.google.common.collect;

import java.util.Comparator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class d0 implements Comparator {
    public static d0 a(Comparator comparator) {
        if (comparator instanceof d0) {
            return (d0) comparator;
        }
        return new m(comparator);
    }

    public d0 b(k8.c cVar) {
        return new g(cVar, this);
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);
}
