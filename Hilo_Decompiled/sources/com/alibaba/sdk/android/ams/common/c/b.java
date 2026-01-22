package com.alibaba.sdk.android.ams.common.c;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    static Map<Class<?>, a<?>> f٦٣٢٥a;

    static {
        HashMap hashMap = new HashMap();
        for (a aVar : d.a(a.class, c.class.getClassLoader())) {
            a aVar2 = (a) hashMap.get(aVar.a());
            if (hashMap.containsKey(aVar.a())) {
                throw new IllegalStateException("Ambiguous providers: " + aVar.getClass().getCanonicalName() + " versus " + aVar2.getClass().getCanonicalName());
            }
            hashMap.put(aVar.a(), aVar);
        }
        f٦٣٢٥a = hashMap;
    }
}
