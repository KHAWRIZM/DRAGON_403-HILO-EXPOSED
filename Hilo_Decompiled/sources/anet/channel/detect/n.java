package anet.channel.detect;

import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static d f٤٧٣٧a = new d();

    /* renamed from: b, reason: collision with root package name */
    private static ExceptionDetector f٤٧٣٨b = new ExceptionDetector();

    /* renamed from: c, reason: collision with root package name */
    private static k f٤٧٣٩c = new k();

    /* renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f٤٧٤٠d = new AtomicBoolean(false);

    public static void a() {
        try {
            if (f٤٧٤٠d.compareAndSet(false, true)) {
                ALog.i("awcn.NetworkDetector", "registerListener", null, new Object[0]);
                f٤٧٣٧a.b();
                f٤٧٣٨b.a();
                f٤٧٣٩c.a();
            }
        } catch (Exception e10) {
            ALog.e("awcn.NetworkDetector", "[registerListener]error", null, e10, new Object[0]);
        }
    }

    public static void a(RequestStatistic requestStatistic) {
        if (f٤٧٤٠d.get()) {
            f٤٧٣٨b.a(requestStatistic);
        }
    }
}
