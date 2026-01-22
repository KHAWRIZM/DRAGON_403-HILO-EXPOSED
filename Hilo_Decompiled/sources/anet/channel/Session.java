package anet.channel;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventCb;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.SessionStatistic;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpHelper;
import anet.channel.util.StringUtils;
import com.facebook.internal.AnalyticsEvents;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class Session implements Comparable<Session> {

    /* renamed from: v, reason: collision with root package name */
    static ExecutorService f٤٦١٠v = Executors.newSingleThreadExecutor();

    /* renamed from: a, reason: collision with root package name */
    public Context f٤٦١١a;

    /* renamed from: c, reason: collision with root package name */
    public String f٤٦١٣c;

    /* renamed from: d, reason: collision with root package name */
    public String f٤٦١٤d;

    /* renamed from: e, reason: collision with root package name */
    public String f٤٦١٥e;

    /* renamed from: f, reason: collision with root package name */
    public String f٤٦١٦f;

    /* renamed from: g, reason: collision with root package name */
    public int f٤٦١٧g;

    /* renamed from: h, reason: collision with root package name */
    public String f٤٦١٨h;

    /* renamed from: i, reason: collision with root package name */
    public int f٤٦١٩i;

    /* renamed from: j, reason: collision with root package name */
    public ConnType f٤٦٢٠j;

    /* renamed from: k, reason: collision with root package name */
    public IConnStrategy f٤٦٢١k;

    /* renamed from: m, reason: collision with root package name */
    public boolean f٤٦٢٣m;

    /* renamed from: o, reason: collision with root package name */
    protected Runnable f٤٦٢٥o;

    /* renamed from: p, reason: collision with root package name */
    public final String f٤٦٢٦p;

    /* renamed from: q, reason: collision with root package name */
    public final SessionStatistic f٤٦٢٧q;

    /* renamed from: r, reason: collision with root package name */
    public int f٤٦٢٨r;

    /* renamed from: s, reason: collision with root package name */
    public int f٤٦٢٩s;

    /* renamed from: x, reason: collision with root package name */
    private Future<?> f٤٦٣٣x;

    /* renamed from: b, reason: collision with root package name */
    Map<EventCb, Integer> f٤٦١٢b = new LinkedHashMap();

    /* renamed from: w, reason: collision with root package name */
    private boolean f٤٦٣٢w = false;

    /* renamed from: l, reason: collision with root package name */
    public String f٤٦٢٢l = null;

    /* renamed from: n, reason: collision with root package name */
    public int f٤٦٢٤n = 6;

    /* renamed from: t, reason: collision with root package name */
    public boolean f٤٦٣٠t = false;

    /* renamed from: u, reason: collision with root package name */
    protected boolean f٤٦٣١u = true;

    /* renamed from: y, reason: collision with root package name */
    private List<Long> f٤٦٣٤y = null;

    /* renamed from: z, reason: collision with root package name */
    private long f٤٦٣٥z = 0;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {
        public static final int AUTHING = 3;
        public static final int AUTH_FAIL = 5;
        public static final int AUTH_SUCC = 4;
        public static final int CONNECTED = 0;
        public static final int CONNECTING = 1;
        public static final int CONNETFAIL = 2;
        public static final int DISCONNECTED = 6;
        public static final int DISCONNECTING = 7;

        /* renamed from: a, reason: collision with root package name */
        static final String[] f٤٦٣٦a = {"CONNECTED", "CONNECTING", "CONNETFAIL", "AUTHING", "AUTH_SUCC", "AUTH_FAIL", "DISCONNECTED", "DISCONNECTING"};

        static String a(int i10) {
            return f٤٦٣٦a[i10];
        }
    }

    public Session(Context context, anet.channel.entity.a aVar) {
        boolean z10 = false;
        this.f٤٦٢٣m = false;
        this.f٤٦١١a = context;
        String a10 = aVar.a();
        this.f٤٦١٥e = a10;
        this.f٤٦١٦f = a10;
        this.f٤٦١٧g = aVar.b();
        this.f٤٦٢٠j = aVar.c();
        String f10 = aVar.f();
        this.f٤٦١٣c = f10;
        this.f٤٦١٤d = f10.substring(f10.indexOf(HttpConstant.SCHEME_SPLIT) + 3);
        this.f٤٦٢٩s = aVar.e();
        this.f٤٦٢٨r = aVar.d();
        IConnStrategy iConnStrategy = aVar.f٤٧٦٣a;
        this.f٤٦٢١k = iConnStrategy;
        if (iConnStrategy != null && iConnStrategy.getIpType() == -1) {
            z10 = true;
        }
        this.f٤٦٢٣m = z10;
        this.f٤٦٢٦p = aVar.h();
        SessionStatistic sessionStatistic = new SessionStatistic(aVar);
        this.f٤٦٢٧q = sessionStatistic;
        sessionStatistic.host = this.f٤٦١٤d;
    }

    public static void configTnetALog(Context context, String str, int i10, int i11) {
        SpdyAgent spdyAgent = SpdyAgent.getInstance(context, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        if (spdyAgent != null && SpdyAgent.checkLoadSucc()) {
            spdyAgent.configLogFile(str, i10, i11);
        } else {
            ALog.e("agent null or configTnetALog load so fail!!!", null, "loadso", Boolean.valueOf(SpdyAgent.checkLoadSucc()));
        }
    }

    protected void a() {
        Future<?> future;
        if (this.f٤٦٢٥o != null && (future = this.f٤٦٣٣x) != null) {
            future.cancel(true);
        }
    }

    public void checkAvailable() {
        ping(true);
    }

    public abstract void close();

    public void close(boolean z10) {
        this.f٤٦٣٠t = z10;
        close();
    }

    public void connect() {
    }

    public IConnStrategy getConnStrategy() {
        return this.f٤٦٢١k;
    }

    public ConnType getConnType() {
        return this.f٤٦٢٠j;
    }

    public String getHost() {
        return this.f٤٦١٣c;
    }

    public String getIp() {
        return this.f٤٦١٥e;
    }

    public int getPort() {
        return this.f٤٦١٧g;
    }

    public String getRealHost() {
        return this.f٤٦١٤d;
    }

    public abstract Runnable getRecvTimeOutRunnable();

    public String getUnit() {
        return this.f٤٦٢٢l;
    }

    public void handleCallbacks(int i10, anet.channel.entity.b bVar) {
        f٤٦١٠v.submit(new b(this, i10, bVar));
    }

    public void handleResponseCode(Request request, int i10) {
        if (request.getHeaders().containsKey(HttpConstant.X_PV) && i10 >= 500 && i10 < 600) {
            synchronized (this) {
                try {
                    if (this.f٤٦٣٤y == null) {
                        this.f٤٦٣٤y = new LinkedList();
                    }
                    if (this.f٤٦٣٤y.size() < 5) {
                        this.f٤٦٣٤y.add(Long.valueOf(System.currentTimeMillis()));
                    } else {
                        long longValue = this.f٤٦٣٤y.remove(0).longValue();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - longValue <= 60000) {
                            StrategyCenter.getInstance().forceRefreshStrategy(request.getHost());
                            this.f٤٦٣٤y.clear();
                        } else {
                            this.f٤٦٣٤y.add(Long.valueOf(currentTimeMillis));
                        }
                    }
                } finally {
                }
            }
        }
    }

    public void handleResponseHeaders(Request request, Map<String, List<String>> map) {
        try {
            if (map.containsKey(HttpConstant.X_SWITCH_UNIT)) {
                String singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(map, HttpConstant.X_SWITCH_UNIT);
                if (TextUtils.isEmpty(singleHeaderFieldByKey)) {
                    singleHeaderFieldByKey = null;
                }
                if (!StringUtils.isStringEqual(this.f٤٦٢٢l, singleHeaderFieldByKey)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.f٤٦٣٥z > 60000) {
                        StrategyCenter.getInstance().forceRefreshStrategy(request.getHost());
                        this.f٤٦٣٥z = currentTimeMillis;
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public abstract boolean isAvailable();

    public synchronized void notifyStatus(int i10, anet.channel.entity.b bVar) {
        ALog.e("awcn.Session", "notifyStatus", this.f٤٦٢٦p, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, a.a(i10));
        if (i10 == this.f٤٦٢٤n) {
            ALog.i("awcn.Session", "ignore notifyStatus", this.f٤٦٢٦p, new Object[0]);
            return;
        }
        this.f٤٦٢٤n = i10;
        if (i10 != 0) {
            if (i10 != 2) {
                if (i10 != 4) {
                    if (i10 != 5) {
                        if (i10 == 6) {
                            onDisconnect();
                            if (!this.f٤٦٣٢w) {
                                handleCallbacks(2, bVar);
                            }
                        }
                    } else {
                        handleCallbacks(1024, bVar);
                    }
                } else {
                    this.f٤٦٢٢l = StrategyCenter.getInstance().getUnitByHost(this.f٤٦١٤d);
                    handleCallbacks(512, bVar);
                }
            } else {
                handleCallbacks(256, bVar);
            }
        } else {
            handleCallbacks(1, bVar);
        }
    }

    public void onDisconnect() {
    }

    public void ping(boolean z10) {
    }

    public void registerEventcb(int i10, EventCb eventCb) {
        Map<EventCb, Integer> map = this.f٤٦١٢b;
        if (map != null) {
            map.put(eventCb, Integer.valueOf(i10));
        }
    }

    public abstract Cancelable request(Request request, RequestCb requestCb);

    public void sendCustomFrame(int i10, byte[] bArr, int i11) {
    }

    public void setPingTimeout(int i10) {
        if (this.f٤٦٢٥o == null) {
            this.f٤٦٢٥o = getRecvTimeOutRunnable();
        }
        a();
        Runnable runnable = this.f٤٦٢٥o;
        if (runnable != null) {
            this.f٤٦٣٣x = ThreadPoolExecutorFactory.submitScheduledTask(runnable, i10, TimeUnit.MILLISECONDS);
        }
    }

    public String toString() {
        return "Session@[" + this.f٤٦٢٦p + '|' + this.f٤٦٢٠j + ']';
    }

    @Override // java.lang.Comparable
    public int compareTo(Session session) {
        return ConnType.compare(this.f٤٦٢٠j, session.f٤٦٢٠j);
    }

    public void ping(boolean z10, int i10) {
    }
}
