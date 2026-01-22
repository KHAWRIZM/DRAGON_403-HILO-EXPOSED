package com.tencent.liteav.videoproducer.capture;

import java.util.Comparator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class e implements Comparator {
    private static final e a = new e();

    private e() {
    }

    public static Comparator a() {
        return a;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        com.tencent.liteav.videoproducer.a.a aVar = (com.tencent.liteav.videoproducer.a.a) obj;
        com.tencent.liteav.videoproducer.a.a aVar2 = (com.tencent.liteav.videoproducer.a.a) obj2;
        int i = aVar.a;
        int i2 = aVar2.a;
        if (i < i2) {
            return -1;
        }
        if (i == i2) {
            return aVar.b - aVar2.b;
        }
        return 1;
    }
}
