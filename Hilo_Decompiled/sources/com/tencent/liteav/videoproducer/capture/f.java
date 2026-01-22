package com.tencent.liteav.videoproducer.capture;

import java.util.Comparator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class f implements Comparator {
    private static final f a = new f();

    private f() {
    }

    public static Comparator a() {
        return a;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((com.tencent.liteav.videoproducer.a.a) obj).b - ((com.tencent.liteav.videoproducer.a.a) obj2).b;
    }
}
