package anet.channel.monitor;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    static int f٤٨٠٩a = 0;

    /* renamed from: b, reason: collision with root package name */
    static long f٤٨١٠b = 0;

    /* renamed from: c, reason: collision with root package name */
    static long f٤٨١١c = 0;

    /* renamed from: d, reason: collision with root package name */
    static long f٤٨١٢d = 0;

    /* renamed from: e, reason: collision with root package name */
    static long f٤٨١٣e = 0;

    /* renamed from: f, reason: collision with root package name */
    static long f٤٨١٤f = 0;

    /* renamed from: g, reason: collision with root package name */
    static double f٤٨١٥g = 0.0d;

    /* renamed from: h, reason: collision with root package name */
    static double f٤٨١٦h = 0.0d;

    /* renamed from: i, reason: collision with root package name */
    static double f٤٨١٧i = 0.0d;

    /* renamed from: j, reason: collision with root package name */
    static double f٤٨١٨j = 40.0d;

    /* renamed from: k, reason: collision with root package name */
    private static volatile boolean f٤٨١٩k;

    /* renamed from: l, reason: collision with root package name */
    private int f٤٨٢٠l;

    /* renamed from: m, reason: collision with root package name */
    private int f٤٨٢١m;

    /* renamed from: n, reason: collision with root package name */
    private e f٤٨٢٢n;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        static b f٤٨٢٣a = new b(null);

        a() {
        }
    }

    /* synthetic */ b(c cVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int b(b bVar) {
        int i10 = bVar.f٤٨٢١m;
        bVar.f٤٨٢١m = i10 + 1;
        return i10;
    }

    public synchronized void d() {
        try {
            ALog.i("awcn.BandWidthSampler", "[startNetworkMeter]", null, "NetworkStatus", NetworkStatusHelper.getStatus());
        } catch (Exception e10) {
            ALog.w("awcn.BandWidthSampler", "startNetworkMeter fail.", null, e10, new Object[0]);
        }
        if (NetworkStatusHelper.getStatus() == NetworkStatusHelper.NetworkStatus.G2) {
            f٤٨١٩k = false;
        } else {
            f٤٨١٩k = true;
        }
    }

    public void e() {
        f٤٨١٩k = false;
    }

    private b() {
        this.f٤٨٢٠l = 5;
        this.f٤٨٢١m = 0;
        this.f٤٨٢٢n = new e();
        NetworkStatusHelper.addStatusChangeListener(new c(this));
    }

    public double c() {
        return f٤٨١٧i;
    }

    public static b a() {
        return a.f٤٨٢٣a;
    }

    public int b() {
        if (NetworkStatusHelper.getStatus() == NetworkStatusHelper.NetworkStatus.G2) {
            return 1;
        }
        return this.f٤٨٢٠l;
    }

    public void a(long j10, long j11, long j12) {
        if (f٤٨١٩k) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.BandWidthSampler", "onDataReceived", null, "mRequestStartTime", Long.valueOf(j10), "mRequestFinishedTime", Long.valueOf(j11), "mRequestDataSize", Long.valueOf(j12));
            }
            if (j12 <= 3000 || j10 >= j11) {
                return;
            }
            ThreadPoolExecutorFactory.submitScheduledTask(new d(this, j12, j11, j10));
        }
    }
}
