package com.alibaba.sdk.android.ams.common.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class c {
    public static <T> T a(Class<T> cls) {
        a<?> aVar = b.f٦٣٢٥a.get(cls);
        if (aVar != null) {
            return cls.cast(aVar.b());
        }
        throw new IllegalArgumentException("No factory was registered for " + cls.getCanonicalName());
    }
}
