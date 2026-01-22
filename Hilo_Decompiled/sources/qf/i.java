package qf;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public abstract class i {
    public static final wf.d a;
    public static final OkHttpClient b;
    public static final ThreadPoolExecutor c;
    public static final ExecutorService d;

    static {
        wf.d dVar = new wf.d();
        a = dVar;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        b = builder.connectTimeout(15L, timeUnit).readTimeout(30L, timeUnit).addInterceptor(dVar).writeTimeout(30L, timeUnit).eventListenerFactory(new wf.a()).dns(new z()).build();
        c = new ThreadPoolExecutor(1, 64, 30L, timeUnit, new SynchronousQueue(), new e());
        d = Executors.newSingleThreadExecutor();
    }

    public static void a(Request.Builder builder) {
        builder.addHeader("Authorization", "Bearer " + e.d.b.i);
    }
}
