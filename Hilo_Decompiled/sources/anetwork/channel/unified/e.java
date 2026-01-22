package anetwork.channel.unified;

import android.text.TextUtils;
import anet.channel.Config;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.NoAvailStrategyException;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.entity.ENV;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import anet.channel.util.StringUtils;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.cache.Cache;
import anetwork.channel.config.NetworkConfigCenter;
import anetwork.channel.cookie.CookieManager;
import anetwork.channel.http.NetworkSdkSetting;
import anetwork.channel.interceptor.Callback;
import anetwork.channel.util.RequestConstant;
import com.amazonaws.services.s3.Headers;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class e implements IUnifiedTask {
    public static final int MAX_RSP_BUFFER_LENGTH = 131072;
    public static final String TAG = "anet.NetworkTask";

    /* renamed from: a, reason: collision with root package name */
    j f٥٢٤٨a;

    /* renamed from: b, reason: collision with root package name */
    Cache f٥٢٤٩b;

    /* renamed from: c, reason: collision with root package name */
    Cache.Entry f٥٢٥٠c;

    /* renamed from: e, reason: collision with root package name */
    String f٥٢٥٢e;

    /* renamed from: h, reason: collision with root package name */
    volatile AtomicBoolean f٥٢٥٥h;

    /* renamed from: d, reason: collision with root package name */
    ByteArrayOutputStream f٥٢٥١d = null;

    /* renamed from: f, reason: collision with root package name */
    volatile Cancelable f٥٢٥٣f = null;

    /* renamed from: g, reason: collision with root package name */
    volatile boolean f٥٢٥٤g = false;

    /* renamed from: i, reason: collision with root package name */
    int f٥٢٥٦i = 0;

    /* renamed from: j, reason: collision with root package name */
    int f٥٢٥٧j = 0;

    /* renamed from: k, reason: collision with root package name */
    boolean f٥٢٥٨k = false;

    /* renamed from: l, reason: collision with root package name */
    boolean f٥٢٥٩l = false;

    /* renamed from: m, reason: collision with root package name */
    a f٥٢٦٠m = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(j jVar, Cache cache, Cache.Entry entry) {
        this.f٥٢٤٩b = null;
        this.f٥٢٥٠c = null;
        this.f٥٢٥٢e = "other";
        this.f٥٢٥٥h = null;
        this.f٥٢٤٨a = jVar;
        this.f٥٢٥٥h = jVar.f٥٢٨٤d;
        this.f٥٢٤٩b = cache;
        this.f٥٢٥٠c = entry;
        this.f٥٢٥٢e = jVar.f٥٢٨١a.h().get(HttpConstant.F_REFER);
    }

    private Session b() {
        Session session;
        SessionCenter a10 = a();
        HttpUrl f10 = this.f٥٢٤٨a.f٥٢٨١a.f();
        boolean containsNonDefaultPort = f10.containsNonDefaultPort();
        anetwork.channel.entity.g gVar = this.f٥٢٤٨a.f٥٢٨١a;
        RequestStatistic requestStatistic = gVar.f٥٢٢٥b;
        if (gVar.f٥٢٢٩f == 1 && NetworkConfigCenter.isSpdyEnabled() && this.f٥٢٤٨a.f٥٢٨١a.f٥٢٢٤a == 0 && !containsNonDefaultPort) {
            HttpUrl a11 = a(f10);
            try {
                session = a10.getThrowsException(a11, anet.channel.entity.c.f٤٧٧١a, 0L);
            } catch (NoAvailStrategyException unused) {
                return a(null, a10, f10, containsNonDefaultPort);
            } catch (Exception unused2) {
                session = null;
            }
            if (session == null) {
                ThreadPoolExecutorFactory.submitPriorityTask(new g(this, a10, a11, requestStatistic, f10, containsNonDefaultPort), ThreadPoolExecutorFactory.Priority.NORMAL);
                return null;
            }
            ALog.i(TAG, "tryGetSession", this.f٥٢٤٨a.f٥٢٨٣c, "Session", session);
            requestStatistic.spdyRequestSend = true;
            return session;
        }
        return a(null, a10, f10, containsNonDefaultPort);
    }

    private void c() {
        SessionCenter a10 = a();
        HttpUrl f10 = this.f٥٢٤٨a.f٥٢٨١a.f();
        boolean containsNonDefaultPort = f10.containsNonDefaultPort();
        anetwork.channel.entity.g gVar = this.f٥٢٤٨a.f٥٢٨١a;
        RequestStatistic requestStatistic = gVar.f٥٢٢٥b;
        Request a11 = gVar.a();
        if (this.f٥٢٤٨a.f٥٢٨١a.f٥٢٢٩f == 1 && NetworkConfigCenter.isSpdyEnabled() && this.f٥٢٤٨a.f٥٢٨١a.f٥٢٢٤a == 0 && !containsNonDefaultPort) {
            a10.asyncGet(a(f10), anet.channel.entity.c.f٤٧٧١a, 3000L, new h(this, requestStatistic, System.currentTimeMillis(), a11, a10, f10, containsNonDefaultPort));
            return;
        }
        a(a(null, a10, f10, containsNonDefaultPort), a11);
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.f٥٢٥٤g = true;
        if (this.f٥٢٥٣f != null) {
            this.f٥٢٥٣f.cancel();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f٥٢٥٤g) {
            return;
        }
        RequestStatistic requestStatistic = this.f٥٢٤٨a.f٥٢٨١a.f٥٢٢٥b;
        requestStatistic.f_refer = this.f٥٢٥٢e;
        if (!NetworkStatusHelper.isConnected()) {
            if (NetworkConfigCenter.isRequestDelayRetryForNoNetwork() && requestStatistic.statusCode != -200) {
                requestStatistic.statusCode = ErrorConstant.ERROR_NO_NETWORK;
                ThreadPoolExecutorFactory.submitScheduledTask(new f(this), 1000L, TimeUnit.MILLISECONDS);
                return;
            }
            if (ALog.isPrintLog(2)) {
                ALog.i(TAG, "network unavailable", this.f٥٢٤٨a.f٥٢٨٣c, "NetworkStatus", NetworkStatusHelper.getStatus());
            }
            this.f٥٢٥٥h.set(true);
            this.f٥٢٤٨a.a();
            requestStatistic.isDone.set(true);
            requestStatistic.statusCode = ErrorConstant.ERROR_NO_NETWORK;
            requestStatistic.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_NO_NETWORK);
            requestStatistic.rspEnd = System.currentTimeMillis();
            this.f٥٢٤٨a.f٥٢٨٢b.onFinish(new DefaultFinishEvent(ErrorConstant.ERROR_NO_NETWORK, (String) null, this.f٥٢٤٨a.f٥٢٨١a.a()));
            return;
        }
        if (NetworkConfigCenter.isBgRequestForbidden() && GlobalAppRuntimeInfo.isAppBackground() && AppLifecycle.lastEnterBackgroundTime > 0 && !AppLifecycle.isGoingForeground && System.currentTimeMillis() - AppLifecycle.lastEnterBackgroundTime > NetworkConfigCenter.getBgForbidRequestThreshold() && !NetworkConfigCenter.isUrlInWhiteList(this.f٥٢٤٨a.f٥٢٨١a.f()) && !NetworkConfigCenter.isBizInWhiteList(this.f٥٢٤٨a.f٥٢٨١a.a().getBizId()) && !this.f٥٢٤٨a.f٥٢٨١a.a().isAllowRequestInBg()) {
            this.f٥٢٥٥h.set(true);
            this.f٥٢٤٨a.a();
            if (ALog.isPrintLog(2)) {
                j jVar = this.f٥٢٤٨a;
                ALog.i(TAG, "request forbidden in background", jVar.f٥٢٨٣c, "url", jVar.f٥٢٨١a.f());
            }
            requestStatistic.isDone.set(true);
            requestStatistic.statusCode = ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG;
            requestStatistic.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG);
            requestStatistic.rspEnd = System.currentTimeMillis();
            this.f٥٢٤٨a.f٥٢٨٢b.onFinish(new DefaultFinishEvent(ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG, (String) null, this.f٥٢٤٨a.f٥٢٨١a.a()));
            ExceptionStatistic exceptionStatistic = new ExceptionStatistic(ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG, null, "rt");
            exceptionStatistic.host = this.f٥٢٤٨a.f٥٢٨١a.f().host();
            exceptionStatistic.url = this.f٥٢٤٨a.f٥٢٨١a.g();
            AppMonitor.getInstance().commitStat(exceptionStatistic);
            return;
        }
        if (ALog.isPrintLog(2)) {
            j jVar2 = this.f٥٢٤٨a;
            ALog.i(TAG, "exec request", jVar2.f٥٢٨٣c, "retryTimes", Integer.valueOf(jVar2.f٥٢٨١a.f٥٢٢٤a));
        }
        if (NetworkConfigCenter.isGetSessionAsyncEnable()) {
            c();
            return;
        }
        try {
            Session b10 = b();
            if (b10 == null) {
                return;
            }
            a(b10, this.f٥٢٤٨a.f٥٢٨١a.a());
        } catch (Exception e10) {
            ALog.e(TAG, "send request failed.", this.f٥٢٤٨a.f٥٢٨٣c, e10, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f٥٢٦١a;

        /* renamed from: b, reason: collision with root package name */
        Map<String, List<String>> f٥٢٦٢b;

        /* renamed from: c, reason: collision with root package name */
        List<ByteArray> f٥٢٦٣c = new ArrayList();

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i10, Map<String, List<String>> map) {
            this.f٥٢٦١a = i10;
            this.f٥٢٦٢b = map;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            Iterator<ByteArray> it = this.f٥٢٦٣c.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a(Callback callback, int i10) {
            callback.onResponseCode(this.f٥٢٦١a, this.f٥٢٦٢b);
            Iterator<ByteArray> it = this.f٥٢٦٣c.iterator();
            int i11 = 1;
            while (it.hasNext()) {
                callback.onDataReceiveSize(i11, i10, it.next());
                i11++;
            }
            return i11;
        }
    }

    private HttpUrl a(HttpUrl httpUrl) {
        HttpUrl parse;
        String str = this.f٥٢٤٨a.f٥٢٨١a.h().get(HttpConstant.X_HOST_CNAME);
        return (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(httpUrl.urlString().replaceFirst(httpUrl.host(), str))) == null) ? httpUrl : parse;
    }

    private SessionCenter a() {
        String a10 = this.f٥٢٤٨a.f٥٢٨١a.a(RequestConstant.APPKEY);
        if (TextUtils.isEmpty(a10)) {
            return SessionCenter.getInstance();
        }
        ENV env = ENV.ONLINE;
        String a11 = this.f٥٢٤٨a.f٥٢٨١a.a(RequestConstant.ENVIRONMENT);
        if (RequestConstant.ENV_PRE.equalsIgnoreCase(a11)) {
            env = ENV.PREPARE;
        } else if ("test".equalsIgnoreCase(a11)) {
            env = ENV.TEST;
        }
        if (env != NetworkSdkSetting.CURRENT_ENV) {
            NetworkSdkSetting.CURRENT_ENV = env;
            SessionCenter.switchEnvironment(env);
        }
        Config config = Config.getConfig(a10, env);
        if (config == null) {
            config = new Config.Builder().setAppkey(a10).setEnv(env).setAuthCode(this.f٥٢٤٨a.f٥٢٨١a.a(RequestConstant.AUTH_CODE)).build();
        }
        return SessionCenter.getInstance(config);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Session a(Session session, SessionCenter sessionCenter, HttpUrl httpUrl, boolean z10) {
        anetwork.channel.entity.g gVar = this.f٥٢٤٨a.f٥٢٨١a;
        RequestStatistic requestStatistic = gVar.f٥٢٢٥b;
        if (session == null && gVar.e() && !z10 && !NetworkStatusHelper.isProxy()) {
            session = sessionCenter.get(httpUrl, anet.channel.entity.c.f٤٧٧٢b, 0L);
        }
        if (session == null) {
            ALog.i(TAG, "create HttpSession with local DNS", this.f٥٢٤٨a.f٥٢٨٣c, new Object[0]);
            session = new anet.channel.session.d(GlobalAppRuntimeInfo.getContext(), new anet.channel.entity.a(StringUtils.concatString(httpUrl.scheme(), HttpConstant.SCHEME_SPLIT, httpUrl.host()), this.f٥٢٤٨a.f٥٢٨٣c, null));
        }
        if (requestStatistic.spdyRequestSend) {
            requestStatistic.degraded = 1;
        }
        ALog.i(TAG, "tryGetHttpSession", this.f٥٢٤٨a.f٥٢٨٣c, "Session", session);
        return session;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Request a(Request request) {
        Request.Builder builder;
        if (this.f٥٢٤٨a.f٥٢٨١a.i()) {
            String cookie = CookieManager.getCookie(this.f٥٢٤٨a.f٥٢٨١a.g());
            if (!TextUtils.isEmpty(cookie)) {
                builder = request.newBuilder();
                String str = request.getHeaders().get(HttpConstant.COOKIE);
                if (!TextUtils.isEmpty(str)) {
                    cookie = StringUtils.concatString(str, "; ", cookie);
                }
                builder.addHeader(HttpConstant.COOKIE, cookie);
                if (this.f٥٢٥٠c != null) {
                    if (builder == null) {
                        builder = request.newBuilder();
                    }
                    String str2 = this.f٥٢٥٠c.etag;
                    if (str2 != null) {
                        builder.addHeader(Headers.GET_OBJECT_IF_NONE_MATCH, str2);
                    }
                    long j10 = this.f٥٢٥٠c.lastModified;
                    if (j10 > 0) {
                        builder.addHeader(Headers.GET_OBJECT_IF_MODIFIED_SINCE, anetwork.channel.cache.a.a(j10));
                    }
                }
                if (this.f٥٢٤٨a.f٥٢٨١a.f٥٢٢٤a == 0 && "weex".equalsIgnoreCase(this.f٥٢٥٢e)) {
                    if (builder == null) {
                        builder = request.newBuilder();
                    }
                    builder.setReadTimeout(3000);
                }
                return builder != null ? request : builder.build();
            }
        }
        builder = null;
        if (this.f٥٢٥٠c != null) {
        }
        if (this.f٥٢٤٨a.f٥٢٨١a.f٥٢٢٤a == 0) {
            if (builder == null) {
            }
            builder.setReadTimeout(3000);
        }
        if (builder != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Session session, Request request) {
        if (session == null || this.f٥٢٥٤g) {
            return;
        }
        Request a10 = a(request);
        RequestStatistic requestStatistic = this.f٥٢٤٨a.f٥٢٨١a.f٥٢٢٥b;
        requestStatistic.reqStart = System.currentTimeMillis();
        this.f٥٢٥٣f = session.request(a10, new i(this, a10, requestStatistic));
    }
}
