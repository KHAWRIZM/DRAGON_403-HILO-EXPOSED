package com.tencent.liteav.base.http;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class c implements Runnable {
    private final HttpClientAndroid a;
    private final Long b;

    private c(HttpClientAndroid httpClientAndroid, Long l) {
        this.a = httpClientAndroid;
        this.b = l;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid, Long l) {
        return new c(httpClientAndroid, l);
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpClientAndroid.lambda$resumeRepeatDownload$2(this.a, this.b);
    }
}
