package com.google.firebase.components;

import androidx.annotation.VisibleForTesting;
import com.google.firebase.inject.Provider;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class Lazy<T> implements Provider<T> {
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance;
    private volatile Provider<T> provider;

    Lazy(T t10) {
        this.instance = UNINITIALIZED;
        this.instance = t10;
    }

    @Override // com.google.firebase.inject.Provider
    public T get() {
        T t10 = (T) this.instance;
        Object obj = UNINITIALIZED;
        if (t10 == obj) {
            synchronized (this) {
                try {
                    t10 = (T) this.instance;
                    if (t10 == obj) {
                        t10 = this.provider.get();
                        this.instance = t10;
                        this.provider = null;
                    }
                } finally {
                }
            }
        }
        return t10;
    }

    @VisibleForTesting
    boolean isInitialized() {
        if (this.instance != UNINITIALIZED) {
            return true;
        }
        return false;
    }

    public Lazy(Provider<T> provider) {
        this.instance = UNINITIALIZED;
        this.provider = provider;
    }
}
