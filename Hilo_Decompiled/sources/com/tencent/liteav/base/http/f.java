package com.tencent.liteav.base.http;

import com.tencent.liteav.base.http.HttpClientAndroid;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* synthetic */ class f implements Runnable {
    private final HttpClientAndroid a;
    private final HttpClientAndroid.f b;
    private final long c;

    private f(HttpClientAndroid httpClientAndroid, HttpClientAndroid.f fVar, long j) {
        this.a = httpClientAndroid;
        this.b = fVar;
        this.c = j;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid, HttpClientAndroid.f fVar, long j) {
        return new f(httpClientAndroid, fVar, j);
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpClientAndroid.lambda$doReadData$5(this.a, this.b, this.c);
    }
}
