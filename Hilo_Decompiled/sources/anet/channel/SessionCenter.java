package anet.channel;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import anet.channel.Config;
import anet.channel.detect.n;
import anet.channel.entity.ConnType;
import anet.channel.entity.ENV;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import anet.channel.util.StringUtils;
import anet.channel.util.Utils;
import anetwork.channel.util.RequestConstant;
import java.net.ConnectException;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SessionCenter {
    public static final String TAG = "awcn.SessionCenter";

    /* renamed from: a, reason: collision with root package name */
    static Map<Config, SessionCenter> f٤٦٣٧a = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    private static boolean f٤٦٣٨j = false;

    /* renamed from: b, reason: collision with root package name */
    Context f٤٦٣٩b;

    /* renamed from: c, reason: collision with root package name */
    String f٤٦٤٠c;

    /* renamed from: d, reason: collision with root package name */
    Config f٤٦٤١d;

    /* renamed from: e, reason: collision with root package name */
    final e f٤٦٤٢e = new e();

    /* renamed from: f, reason: collision with root package name */
    final LruCache<String, SessionRequest> f٤٦٤٣f = new LruCache<>(32);

    /* renamed from: g, reason: collision with root package name */
    final c f٤٦٤٤g = new c();

    /* renamed from: h, reason: collision with root package name */
    final AccsSessionManager f٤٦٤٥h;

    /* renamed from: i, reason: collision with root package name */
    final a f٤٦٤٦i;

    private SessionCenter(Config config) {
        a aVar = new a(this, null);
        this.f٤٦٤٦i = aVar;
        this.f٤٦٣٩b = GlobalAppRuntimeInfo.getContext();
        this.f٤٦٤١d = config;
        this.f٤٦٤٠c = config.getAppkey();
        aVar.a();
        this.f٤٦٤٥h = new AccsSessionManager(this);
        if (!config.getAppkey().equals("[default]")) {
            AmdcRuntimeInfo.setSign(new d(this, config.getAppkey(), config.getSecurity()));
        }
    }

    public static void checkAndStartAccsSession() {
        Iterator<SessionCenter> it = f٤٦٣٧a.values().iterator();
        while (it.hasNext()) {
            it.next().f٤٦٤٥h.checkAndStartSession();
        }
    }

    public static synchronized SessionCenter getInstance(String str) {
        SessionCenter sessionCenter;
        synchronized (SessionCenter.class) {
            Config configByTag = Config.getConfigByTag(str);
            if (configByTag != null) {
                sessionCenter = getInstance(configByTag);
            } else {
                throw new RuntimeException("tag not exist!");
            }
        }
        return sessionCenter;
    }

    public static synchronized void init(Context context) {
        synchronized (SessionCenter.class) {
            try {
                if (context != null) {
                    GlobalAppRuntimeInfo.setContext(context.getApplicationContext());
                    if (!f٤٦٣٨j) {
                        Map<Config, SessionCenter> map = f٤٦٣٧a;
                        Config config = Config.DEFAULT_CONFIG;
                        map.put(config, new SessionCenter(config));
                        AppLifecycle.initialize();
                        NetworkStatusHelper.startListener(context);
                        if (!AwcnConfig.isTbNextLaunch()) {
                            StrategyCenter.getInstance().initialize(GlobalAppRuntimeInfo.getContext());
                        }
                        if (GlobalAppRuntimeInfo.isTargetProcess()) {
                            n.a();
                            anet.channel.e.a.a();
                        }
                        f٤٦٣٨j = true;
                    }
                } else {
                    ALog.e(TAG, "context is null!", null, new Object[0]);
                    throw new NullPointerException("init failed. context is null");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized void switchEnvironment(ENV env) {
        int i10;
        synchronized (SessionCenter.class) {
            try {
                if (GlobalAppRuntimeInfo.getEnv() != env) {
                    ALog.i(TAG, "switch env", null, "old", GlobalAppRuntimeInfo.getEnv(), "new", env);
                    GlobalAppRuntimeInfo.setEnv(env);
                    StrategyCenter.getInstance().switchEnv();
                    SpdyAgent spdyAgent = SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
                    if (env == ENV.TEST) {
                        i10 = 0;
                    } else {
                        i10 = 1;
                    }
                    spdyAgent.switchAccsServer(i10);
                }
                Iterator<Map.Entry<Config, SessionCenter>> it = f٤٦٣٧a.entrySet().iterator();
                while (it.hasNext()) {
                    SessionCenter value = it.next().getValue();
                    if (value.f٤٦٤١d.getEnv() != env) {
                        ALog.i(TAG, "remove instance", value.f٤٦٤٠c, RequestConstant.ENVIRONMENT, value.f٤٦٤١d.getEnv());
                        value.f٤٦٤٥h.forceCloseSession(false);
                        value.f٤٦٤٦i.b();
                        it.remove();
                    }
                }
            } finally {
            }
        }
    }

    public void asyncGet(HttpUrl httpUrl, int i10, long j10, SessionGetCallback sessionGetCallback) {
        if (sessionGetCallback != null) {
            if (j10 > 0) {
                try {
                    b(httpUrl, i10, j10, sessionGetCallback);
                    return;
                } catch (Exception unused) {
                    sessionGetCallback.onSessionGetFail();
                    return;
                }
            }
            throw new InvalidParameterException("timeout must > 0");
        }
        throw new NullPointerException("cb is null");
    }

    protected void b(HttpUrl httpUrl, int i10, long j10, SessionGetCallback sessionGetCallback) throws Exception {
        SessionInfo b10;
        if (!f٤٦٣٨j) {
            ALog.e(TAG, "getInternal not inited!", this.f٤٦٤٠c, new Object[0]);
            throw new IllegalStateException("getInternal not inited");
        }
        if (httpUrl == null) {
            throw new InvalidParameterException("httpUrl is null");
        }
        if (sessionGetCallback != null) {
            ALog.d(TAG, "getInternal", this.f٤٦٤٠c, "u", httpUrl.urlString(), "sessionType", i10 == anet.channel.entity.c.f٤٧٧١a ? "LongLink" : "ShortLink", "timeout", Long.valueOf(j10));
            SessionRequest a10 = a(httpUrl);
            Session a11 = this.f٤٦٤٢e.a(a10, i10);
            if (a11 != null) {
                ALog.d(TAG, "get internal hit cache session", this.f٤٦٤٠c, "session", a11);
                sessionGetCallback.onSessionGetSuccess(a11);
                return;
            }
            if (this.f٤٦٤١d == Config.DEFAULT_CONFIG && i10 != anet.channel.entity.c.f٤٧٧٢b) {
                sessionGetCallback.onSessionGetFail();
                return;
            }
            if (GlobalAppRuntimeInfo.isAppBackground() && i10 == anet.channel.entity.c.f٤٧٧١a && AwcnConfig.isAccsSessionCreateForbiddenInBg() && (b10 = this.f٤٦٤٤g.b(httpUrl.host())) != null && b10.isAccs) {
                ALog.w(TAG, "app background, forbid to create accs session", this.f٤٦٤٠c, new Object[0]);
                throw new ConnectException("accs session connecting forbidden in background");
            }
            a10.b(this.f٤٦٣٩b, i10, anet.channel.util.i.a(this.f٤٦٤٠c), sessionGetCallback, j10);
            return;
        }
        throw new InvalidParameterException("sessionGetCallback is null");
    }

    @Deprecated
    public void enterBackground() {
        AppLifecycle.onBackground();
    }

    @Deprecated
    public void enterForeground() {
        AppLifecycle.onForeground();
    }

    public void forceRecreateAccsSession() {
        this.f٤٦٤٥h.forceCloseSession(true);
    }

    public Session get(String str, long j10) {
        return get(HttpUrl.parse(str), anet.channel.entity.c.f٤٧٧٣c, j10);
    }

    public Session getThrowsException(String str, long j10) throws Exception {
        return a(HttpUrl.parse(str), anet.channel.entity.c.f٤٧٧٣c, j10, null);
    }

    public void registerAccsSessionListener(ISessionListener iSessionListener) {
        this.f٤٦٤٥h.registerListener(iSessionListener);
    }

    public void registerPublicKey(String str, int i10) {
        this.f٤٦٤٤g.a(str, i10);
    }

    public void registerSessionInfo(SessionInfo sessionInfo) {
        this.f٤٦٤٤g.a(sessionInfo);
        if (sessionInfo.isKeepAlive) {
            this.f٤٦٤٥h.checkAndStartSession();
        }
    }

    @Deprecated
    public synchronized void switchEnv(ENV env) {
        switchEnvironment(env);
    }

    public void unregisterAccsSessionListener(ISessionListener iSessionListener) {
        this.f٤٦٤٥h.unregisterListener(iSessionListener);
    }

    public void unregisterSessionInfo(String str) {
        SessionInfo a10 = this.f٤٦٤٤g.a(str);
        if (a10 != null && a10.isKeepAlive) {
            this.f٤٦٤٥h.checkAndStartSession();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a implements NetworkStatusHelper.INetworkStatusChangeListener, IStrategyListener, AppLifecycle.AppLifecycleListener {

        /* renamed from: a, reason: collision with root package name */
        boolean f٤٦٤٧a;

        private a() {
            this.f٤٦٤٧a = false;
        }

        void a() {
            AppLifecycle.registerLifecycleListener(this);
            NetworkStatusHelper.addStatusChangeListener(this);
            StrategyCenter.getInstance().registerListener(this);
        }

        void b() {
            StrategyCenter.getInstance().unregisterListener(this);
            AppLifecycle.unregisterLifecycleListener(this);
            NetworkStatusHelper.removeStatusChangeListener(this);
        }

        @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
        public void background() {
            ALog.i(SessionCenter.TAG, "[background]", SessionCenter.this.f٤٦٤٠c, new Object[0]);
            if (!SessionCenter.f٤٦٣٨j) {
                ALog.e(SessionCenter.TAG, "background not inited!", SessionCenter.this.f٤٦٤٠c, new Object[0]);
                return;
            }
            try {
                StrategyCenter.getInstance().saveData();
                if (AwcnConfig.isAccsSessionCreateForbiddenInBg() && "OPPO".equalsIgnoreCase(Build.BRAND)) {
                    ALog.i(SessionCenter.TAG, "close session for OPPO", SessionCenter.this.f٤٦٤٠c, new Object[0]);
                    SessionCenter.this.f٤٦٤٥h.forceCloseSession(false);
                }
            } catch (Exception unused) {
            }
        }

        @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
        public void forground() {
            ALog.i(SessionCenter.TAG, "[forground]", SessionCenter.this.f٤٦٤٠c, new Object[0]);
            if (SessionCenter.this.f٤٦٣٩b == null || this.f٤٦٤٧a) {
                return;
            }
            this.f٤٦٤٧a = true;
            try {
                if (!SessionCenter.f٤٦٣٨j) {
                    ALog.e(SessionCenter.TAG, "forground not inited!", SessionCenter.this.f٤٦٤٠c, new Object[0]);
                    return;
                }
                try {
                    if (AppLifecycle.lastEnterBackgroundTime != 0 && System.currentTimeMillis() - AppLifecycle.lastEnterBackgroundTime > 60000) {
                        SessionCenter.this.f٤٦٤٥h.forceCloseSession(true);
                    } else {
                        SessionCenter.this.f٤٦٤٥h.checkAndStartSession();
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    this.f٤٦٤٧a = false;
                    throw th;
                }
                this.f٤٦٤٧a = false;
            } catch (Exception unused2) {
            }
        }

        @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
        public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
            ALog.e(SessionCenter.TAG, "onNetworkStatusChanged.", SessionCenter.this.f٤٦٤٠c, "networkStatus", networkStatus);
            List<SessionRequest> a10 = SessionCenter.this.f٤٦٤٢e.a();
            if (!a10.isEmpty()) {
                for (SessionRequest sessionRequest : a10) {
                    ALog.d(SessionCenter.TAG, "network change, try recreate session", SessionCenter.this.f٤٦٤٠c, new Object[0]);
                    sessionRequest.a((String) null);
                }
            }
            SessionCenter.this.f٤٦٤٥h.checkAndStartSession();
        }

        @Override // anet.channel.strategy.IStrategyListener
        public void onStrategyUpdated(l.d dVar) {
            SessionCenter.this.a(dVar);
            SessionCenter.this.f٤٦٤٥h.checkAndStartSession();
        }

        /* synthetic */ a(SessionCenter sessionCenter, d dVar) {
            this();
        }
    }

    @Deprecated
    public Session get(String str, ConnType.TypeLevel typeLevel, long j10) {
        return get(HttpUrl.parse(str), typeLevel == ConnType.TypeLevel.SPDY ? anet.channel.entity.c.f٤٧٧١a : anet.channel.entity.c.f٤٧٧٢b, j10);
    }

    @Deprecated
    public Session getThrowsException(String str, ConnType.TypeLevel typeLevel, long j10) throws Exception {
        return a(HttpUrl.parse(str), typeLevel == ConnType.TypeLevel.SPDY ? anet.channel.entity.c.f٤٧٧١a : anet.channel.entity.c.f٤٧٧٢b, j10, null);
    }

    private SessionRequest a(HttpUrl httpUrl) {
        String cNameByHost = StrategyCenter.getInstance().getCNameByHost(httpUrl.host());
        if (cNameByHost == null) {
            cNameByHost = httpUrl.host();
        }
        String scheme = httpUrl.scheme();
        if (!httpUrl.isSchemeLocked()) {
            scheme = StrategyCenter.getInstance().getSchemeByHost(cNameByHost, scheme);
        }
        return a(StringUtils.concatString(scheme, HttpConstant.SCHEME_SPLIT, cNameByHost));
    }

    @Deprecated
    public Session get(HttpUrl httpUrl, ConnType.TypeLevel typeLevel, long j10) {
        return get(httpUrl, typeLevel == ConnType.TypeLevel.SPDY ? anet.channel.entity.c.f٤٧٧١a : anet.channel.entity.c.f٤٧٧٢b, j10);
    }

    public Session getThrowsException(HttpUrl httpUrl, int i10, long j10) throws Exception {
        return a(httpUrl, i10, j10, null);
    }

    public Session get(HttpUrl httpUrl, int i10, long j10) {
        try {
            return a(httpUrl, i10, j10, null);
        } catch (NoAvailStrategyException e10) {
            ALog.i(TAG, "[Get]" + e10.getMessage(), this.f٤٦٤٠c, null, "url", httpUrl.urlString());
            return null;
        } catch (ConnectException e11) {
            ALog.e(TAG, "[Get]connect exception", this.f٤٦٤٠c, "errMsg", e11.getMessage(), "url", httpUrl.urlString());
            return null;
        } catch (InvalidParameterException e12) {
            ALog.e(TAG, "[Get]param url is invalid", this.f٤٦٤٠c, e12, "url", httpUrl);
            return null;
        } catch (TimeoutException e13) {
            ALog.e(TAG, "[Get]timeout exception", this.f٤٦٤٠c, e13, "url", httpUrl.urlString());
            return null;
        } catch (Exception e14) {
            ALog.e(TAG, "[Get]" + e14.getMessage(), this.f٤٦٤٠c, null, "url", httpUrl.urlString());
            return null;
        }
    }

    @Deprecated
    public Session getThrowsException(HttpUrl httpUrl, ConnType.TypeLevel typeLevel, long j10) throws Exception {
        return a(httpUrl, typeLevel == ConnType.TypeLevel.SPDY ? anet.channel.entity.c.f٤٧٧١a : anet.channel.entity.c.f٤٧٧٢b, j10, null);
    }

    public static synchronized SessionCenter getInstance(Config config) {
        SessionCenter sessionCenter;
        Context appContext;
        synchronized (SessionCenter.class) {
            try {
                if (config != null) {
                    if (!f٤٦٣٨j && (appContext = Utils.getAppContext()) != null) {
                        init(appContext);
                    }
                    sessionCenter = f٤٦٣٧a.get(config);
                    if (sessionCenter == null) {
                        sessionCenter = new SessionCenter(config);
                        f٤٦٣٧a.put(config, sessionCenter);
                    }
                } else {
                    throw new NullPointerException("config is null!");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sessionCenter;
    }

    protected Session a(HttpUrl httpUrl, int i10, long j10, SessionGetCallback sessionGetCallback) throws Exception {
        SessionInfo b10;
        if (!f٤٦٣٨j) {
            ALog.e(TAG, "getInternal not inited!", this.f٤٦٤٠c, new Object[0]);
            throw new IllegalStateException("getInternal not inited");
        }
        if (httpUrl != null) {
            ALog.d(TAG, "getInternal", this.f٤٦٤٠c, "u", httpUrl.urlString(), "sessionType", i10 == anet.channel.entity.c.f٤٧٧١a ? "LongLink" : "ShortLink", "timeout", Long.valueOf(j10));
            SessionRequest a10 = a(httpUrl);
            Session a11 = this.f٤٦٤٢e.a(a10, i10);
            if (a11 != null) {
                ALog.d(TAG, "get internal hit cache session", this.f٤٦٤٠c, "session", a11);
            } else {
                if (this.f٤٦٤١d == Config.DEFAULT_CONFIG && i10 != anet.channel.entity.c.f٤٧٧٢b) {
                    if (sessionGetCallback == null) {
                        return null;
                    }
                    sessionGetCallback.onSessionGetFail();
                    return null;
                }
                if (GlobalAppRuntimeInfo.isAppBackground() && i10 == anet.channel.entity.c.f٤٧٧١a && AwcnConfig.isAccsSessionCreateForbiddenInBg() && (b10 = this.f٤٦٤٤g.b(httpUrl.host())) != null && b10.isAccs) {
                    ALog.w(TAG, "app background, forbid to create accs session", this.f٤٦٤٠c, new Object[0]);
                    throw new ConnectException("accs session connecting forbidden in background");
                }
                a10.a(this.f٤٦٣٩b, i10, anet.channel.util.i.a(this.f٤٦٤٠c), sessionGetCallback, j10);
                if (sessionGetCallback == null && j10 > 0 && (i10 == anet.channel.entity.c.f٤٧٧٣c || a10.b() == i10)) {
                    a10.a(j10);
                    a11 = this.f٤٦٤٢e.a(a10, i10);
                    if (a11 == null) {
                        throw new ConnectException("session connecting failed or timeout");
                    }
                }
            }
            return a11;
        }
        throw new InvalidParameterException("httpUrl is null");
    }

    @Deprecated
    public static synchronized SessionCenter getInstance() {
        Context appContext;
        synchronized (SessionCenter.class) {
            try {
                if (!f٤٦٣٨j && (appContext = Utils.getAppContext()) != null) {
                    init(appContext);
                }
                SessionCenter sessionCenter = null;
                for (Map.Entry<Config, SessionCenter> entry : f٤٦٣٧a.entrySet()) {
                    SessionCenter value = entry.getValue();
                    if (entry.getKey() != Config.DEFAULT_CONFIG) {
                        return value;
                    }
                    sessionCenter = value;
                }
                return sessionCenter;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    public static synchronized void init(Context context, String str) {
        synchronized (SessionCenter.class) {
            init(context, str, GlobalAppRuntimeInfo.getEnv());
        }
    }

    public static synchronized void init(Context context, String str, ENV env) {
        synchronized (SessionCenter.class) {
            try {
                if (context != null) {
                    Config config = Config.getConfig(str, env);
                    if (config == null) {
                        config = new Config.Builder().setAppkey(str).setEnv(env).build();
                    }
                    init(context, config);
                } else {
                    ALog.e(TAG, "context is null!", null, new Object[0]);
                    throw new NullPointerException("init failed. context is null");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void b(l.b bVar) {
        int i10;
        ALog.i(TAG, "find effectNow", this.f٤٦٤٠c, "host", bVar.f٥٠٢٤a);
        l.a[] aVarArr = bVar.f٥٠٣١h;
        String[] strArr = bVar.f٥٠٢٩f;
        for (Session session : this.f٤٦٤٢e.a(a(StringUtils.buildKey(bVar.f٥٠٢٦c, bVar.f٥٠٢٤a)))) {
            if (!session.getConnType().isHttpType()) {
                int i11 = 0;
                while (true) {
                    if (i11 < strArr.length) {
                        if (session.getIp().equals(strArr[i11])) {
                            while (true) {
                                if (i10 < aVarArr.length) {
                                    i10 = (session.getPort() == aVarArr[i10].f٥٠١٦a && session.getConnType().equals(ConnType.valueOf(ConnProtocol.valueOf(aVarArr[i10])))) ? 0 : i10 + 1;
                                } else {
                                    if (ALog.isPrintLog(2)) {
                                        ALog.i(TAG, "aisle not match", session.f٤٦٢٦p, "port", Integer.valueOf(session.getPort()), "connType", session.getConnType(), "aisle", Arrays.toString(aVarArr));
                                    }
                                    session.close(true);
                                }
                            }
                        } else {
                            i11++;
                        }
                    } else {
                        if (ALog.isPrintLog(2)) {
                            ALog.i(TAG, "ip not match", session.f٤٦٢٦p, "session ip", session.getIp(), "ips", Arrays.toString(strArr));
                        }
                        session.close(true);
                    }
                }
            }
        }
    }

    public static synchronized void init(Context context, Config config) {
        synchronized (SessionCenter.class) {
            if (context == null) {
                ALog.e(TAG, "context is null!", null, new Object[0]);
                throw new NullPointerException("init failed. context is null");
            }
            if (config != null) {
                init(context);
                if (!f٤٦٣٧a.containsKey(config)) {
                    f٤٦٣٧a.put(config, new SessionCenter(config));
                }
            } else {
                ALog.e(TAG, "paramter config is null!", null, new Object[0]);
                throw new NullPointerException("init failed. config is null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l.d dVar) {
        try {
            for (l.b bVar : dVar.f٥٠٣٩b) {
                if (bVar.f٥٠٣٤k) {
                    b(bVar);
                }
                if (bVar.f٥٠٢٨e != null) {
                    a(bVar);
                }
            }
        } catch (Exception e10) {
            ALog.e(TAG, "checkStrategy failed", this.f٤٦٤٠c, e10, new Object[0]);
        }
    }

    private void a(l.b bVar) {
        for (Session session : this.f٤٦٤٢e.a(a(StringUtils.buildKey(bVar.f٥٠٢٦c, bVar.f٥٠٢٤a)))) {
            if (!StringUtils.isStringEqual(session.f٤٦٢٢l, bVar.f٥٠٢٨e)) {
                ALog.i(TAG, "unit change", session.f٤٦٢٦p, "session unit", session.f٤٦٢٢l, "unit", bVar.f٥٠٢٨e);
                session.close(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SessionRequest a(String str) {
        SessionRequest sessionRequest;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f٤٦٤٣f) {
            try {
                sessionRequest = this.f٤٦٤٣f.get(str);
                if (sessionRequest == null) {
                    sessionRequest = new SessionRequest(str, this);
                    this.f٤٦٤٣f.put(str, sessionRequest);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sessionRequest;
    }
}
