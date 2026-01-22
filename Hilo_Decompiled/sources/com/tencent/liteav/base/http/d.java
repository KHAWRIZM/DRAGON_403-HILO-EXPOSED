package com.tencent.liteav.base.http;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class d implements Runnable {
    private final HttpClientAndroid a;
    private final long b;

    private d(HttpClientAndroid httpClientAndroid, long j) {
        this.a = httpClientAndroid;
        this.b = j;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid, long j) {
        return new d(httpClientAndroid, j);
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpClientAndroid.lambda$resumeRepeatDownload$3(this.a, this.b);
    }
}
