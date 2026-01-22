package com.alibaba.sdk.android.emas;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface Cache<T> {
    void add(T t10);

    void clear();

    T get();

    boolean remove(T t10);
}
