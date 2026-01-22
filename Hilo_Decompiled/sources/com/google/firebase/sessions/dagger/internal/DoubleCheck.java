package com.google.firebase.sessions.dagger.internal;

import com.google.firebase.sessions.dagger.Lazy;
import ne.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class DoubleCheck<T> implements a, Lazy<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile a provider;

    private DoubleCheck(a aVar) {
        this.provider = aVar;
    }

    public static <P extends a, T> Lazy<T> lazy(P p10) {
        if (p10 instanceof Lazy) {
            return (Lazy) p10;
        }
        return new DoubleCheck((a) Preconditions.checkNotNull(p10));
    }

    public static <P extends a, T> a provider(P p10) {
        Preconditions.checkNotNull(p10);
        if (p10 instanceof DoubleCheck) {
            return p10;
        }
        return new DoubleCheck(p10);
    }

    private static Object reentrantCheck(Object obj, Object obj2) {
        if (obj != UNINITIALIZED && obj != obj2) {
            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
        }
        return obj2;
    }

    @Override // ne.a
    public T get() {
        Object obj = (T) this.instance;
        Object obj2 = UNINITIALIZED;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.instance;
                    if (obj == obj2) {
                        obj = (T) this.provider.get();
                        this.instance = reentrantCheck(this.instance, obj);
                        this.provider = null;
                    }
                } finally {
                }
            }
        }
        return (T) obj;
    }
}
