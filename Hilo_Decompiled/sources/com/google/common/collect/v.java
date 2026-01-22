package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class v {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends m0 {

        /* renamed from: a, reason: collision with root package name */
        boolean f١٠٥٠١a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f١٠٥٠٢b;

        a(Object obj) {
            this.f١٠٥٠٢b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f١٠٥٠١a;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.f١٠٥٠١a) {
                this.f١٠٥٠١a = true;
                return this.f١٠٥٠٢b;
            }
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Iterator it) {
        k8.h.i(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static boolean b(Iterator it, Iterator it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !k8.f.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static boolean c(Iterator it, Collection collection) {
        k8.h.i(collection);
        boolean z10 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    public static m0 d(Object obj) {
        return new a(obj);
    }
}
