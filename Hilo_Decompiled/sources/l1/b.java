package l1;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import qf.z;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public OkHttpClient.Builder f١٥٦٨٦a;

    /* renamed from: b, reason: collision with root package name */
    public volatile OkHttpClient f١٥٦٨٧b;

    public final d a(String str) {
        if (this.f١٥٦٨٧b == null) {
            synchronized (b.class) {
                try {
                    if (this.f١٥٦٨٧b == null) {
                        b();
                        wf.d dVar = new wf.d();
                        dVar.c = 3;
                        dVar.b.a = "DownloadHttpLoggingInterceptor";
                        this.f١٥٦٨٦a.addInterceptor(dVar);
                        wf.a aVar = new wf.a();
                        aVar.a = "DownloadLoggingEventListener";
                        this.f١٥٦٨٦a.eventListenerFactory(aVar);
                        this.f١٥٦٨٧b = this.f١٥٦٨٦a.build();
                        this.f١٥٦٨٦a = null;
                    }
                } finally {
                }
            }
        }
        return new d(this.f١٥٦٨٧b, str);
    }

    public final void b() {
        if (this.f١٥٦٨٦a == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            this.f١٥٦٨٦a = builder;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            builder.connectTimeout(30L, timeUnit);
            this.f١٥٦٨٦a.readTimeout(30L, timeUnit);
            this.f١٥٦٨٦a.writeTimeout(30L, timeUnit);
            this.f١٥٦٨٦a.dns(new z("DownloadIpv4PreferredDns"));
        }
    }
}
