package com.alibaba.sdk.android.ams.common.c;

import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final AmsLogger f٦٣٢٦a = AmsLogger.getLogger("ServiceLoader");

    /* renamed from: b, reason: collision with root package name */
    private static final String f٦٣٢٧b = com.alibaba.sdk.android.push.e.a.c.class.getName();

    public static <T> List<T> a(Class<T> cls, ClassLoader classLoader) {
        String name = cls.getName();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(cls.cast(classLoader.loadClass(f٦٣٢٧b).newInstance()));
            return arrayList;
        } catch (Exception e10) {
            throw new IllegalStateException("Fail to load ams-spi-services for " + name, e10);
        }
    }
}
