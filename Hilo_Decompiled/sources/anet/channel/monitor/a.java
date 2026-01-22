package anet.channel.monitor;

import anet.channel.util.ALog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f٤٨٠٦a;

    /* renamed from: b, reason: collision with root package name */
    private Map<INetworkQualityChangeListener, f> f٤٨٠٧b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private f f٤٨٠٨c = new f();

    private a() {
    }

    public static a a() {
        if (f٤٨٠٦a == null) {
            synchronized (a.class) {
                try {
                    if (f٤٨٠٦a == null) {
                        f٤٨٠٦a = new a();
                    }
                } finally {
                }
            }
        }
        return f٤٨٠٦a;
    }

    public void a(INetworkQualityChangeListener iNetworkQualityChangeListener, f fVar) {
        if (iNetworkQualityChangeListener == null) {
            ALog.e("BandWidthListenerHelp", "listener is null", null, new Object[0]);
            return;
        }
        if (fVar == null) {
            this.f٤٨٠٨c.f٤٨٤١b = System.currentTimeMillis();
            this.f٤٨٠٧b.put(iNetworkQualityChangeListener, this.f٤٨٠٨c);
        } else {
            fVar.f٤٨٤١b = System.currentTimeMillis();
            this.f٤٨٠٧b.put(iNetworkQualityChangeListener, fVar);
        }
    }

    public void a(INetworkQualityChangeListener iNetworkQualityChangeListener) {
        this.f٤٨٠٧b.remove(iNetworkQualityChangeListener);
    }

    public void a(double d10) {
        boolean a10;
        for (Map.Entry<INetworkQualityChangeListener, f> entry : this.f٤٨٠٧b.entrySet()) {
            INetworkQualityChangeListener key = entry.getKey();
            f value = entry.getValue();
            if (key != null && value != null && !value.b() && value.f٤٨٤٠a != (a10 = value.a(d10))) {
                value.f٤٨٤٠a = a10;
                key.onNetworkQualityChanged(a10 ? NetworkSpeed.Slow : NetworkSpeed.Fast);
            }
        }
    }
}
