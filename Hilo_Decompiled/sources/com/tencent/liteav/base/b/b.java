package com.tencent.liteav.base.b;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class b {
    private static final long a = TimeUnit.SECONDS.toMillis(1);
    private final Map<String, a> b = new HashMap();

    public final synchronized a a(String str) {
        a aVar;
        aVar = this.b.get(str);
        if (aVar == null) {
            aVar = new a(a);
            this.b.put(str, aVar);
        }
        return aVar;
    }
}
