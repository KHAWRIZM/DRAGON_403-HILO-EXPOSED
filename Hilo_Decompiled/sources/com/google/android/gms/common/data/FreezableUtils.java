package com.google.android.gms.common.data;

import java.util.ArrayList;
import java.util.Iterator;
import zd.v2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        v2.o oVar = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            oVar.add(arrayList.get(i10).freeze());
        }
        return oVar;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        v2.o oVar = (ArrayList<T>) new ArrayList();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            oVar.add(it.next().freeze());
        }
        return oVar;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        v2.o oVar = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e10 : eArr) {
            oVar.add(e10.freeze());
        }
        return oVar;
    }
}
