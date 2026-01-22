package com.tencent.liteav.base.http;

import com.tencent.liteav.base.http.HttpClientAndroid;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* synthetic */ class a implements Runnable {
    private final HttpClientAndroid a;
    private final HttpClientAndroid.e b;

    private a(HttpClientAndroid httpClientAndroid, HttpClientAndroid.e eVar) {
        this.a = httpClientAndroid;
        this.b = eVar;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid, HttpClientAndroid.e eVar) {
        return new a(httpClientAndroid, eVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.doRequest(this.b);
    }
}
