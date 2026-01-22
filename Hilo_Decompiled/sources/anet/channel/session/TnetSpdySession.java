package anet.channel.session;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.Config;
import anet.channel.DataFrameCb;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.IAuth;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.bytes.a;
import anet.channel.entity.ConnType;
import anet.channel.heartbeat.HeartbeatManager;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.security.ISecurity;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.statist.SessionMonitor;
import anet.channel.statist.SessionStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpHelper;
import anet.channel.util.Utils;
import anetwork.channel.util.RequestConstant;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.UByte;
import org.android.spdy.RequestPriority;
import org.android.spdy.SessionCb;
import org.android.spdy.SessionInfo;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyByteArray;
import org.android.spdy.SpdyDataProvider;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdyRequest;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class TnetSpdySession extends Session implements SessionCb {
    protected long A;

    /* renamed from: B, reason: collision with root package name */
    protected int f٤٨٩١B;
    protected DataFrameCb C;
    protected IHeartbeat D;
    protected IAuth E;
    protected String F;
    protected ISecurity G;
    private int H;
    private boolean I;

    /* renamed from: w, reason: collision with root package name */
    protected SpdyAgent f٤٨٩٢w;

    /* renamed from: x, reason: collision with root package name */
    protected SpdySession f٤٨٩٣x;

    /* renamed from: y, reason: collision with root package name */
    protected volatile boolean f٤٨٩٤y;

    /* renamed from: z, reason: collision with root package name */
    protected long f٤٨٩٥z;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private class a extends anet.channel.session.a {

        /* renamed from: b, reason: collision with root package name */
        private Request f٤٨٩٧b;

        /* renamed from: c, reason: collision with root package name */
        private RequestCb f٤٨٩٨c;

        /* renamed from: d, reason: collision with root package name */
        private int f٤٨٩٩d = 0;

        /* renamed from: e, reason: collision with root package name */
        private long f٤٩٠٠e = 0;

        public a(Request request, RequestCb requestCb) {
            this.f٤٨٩٧b = request;
            this.f٤٨٩٨c = requestCb;
        }

        private void a(SuperviseData superviseData, int i10, String str) {
            try {
                this.f٤٨٩٧b.f٤٨٤٤a.rspEnd = System.currentTimeMillis();
                if (this.f٤٨٩٧b.f٤٨٤٤a.isDone.get()) {
                    return;
                }
                if (i10 > 0) {
                    this.f٤٨٩٧b.f٤٨٤٤a.ret = 1;
                }
                this.f٤٨٩٧b.f٤٨٤٤a.statusCode = i10;
                this.f٤٨٩٧b.f٤٨٤٤a.msg = str;
                if (superviseData != null) {
                    this.f٤٨٩٧b.f٤٨٤٤a.rspEnd = superviseData.responseEnd;
                    this.f٤٨٩٧b.f٤٨٤٤a.sendBeforeTime = superviseData.sendStart - superviseData.requestStart;
                    RequestStatistic requestStatistic = this.f٤٨٩٧b.f٤٨٤٤a;
                    requestStatistic.sendDataTime = superviseData.sendEnd - requestStatistic.sendStart;
                    this.f٤٨٩٧b.f٤٨٤٤a.firstDataTime = superviseData.responseStart - superviseData.sendEnd;
                    this.f٤٨٩٧b.f٤٨٤٤a.recDataTime = superviseData.responseEnd - superviseData.responseStart;
                    this.f٤٨٩٧b.f٤٨٤٤a.sendDataSize = superviseData.bodySize + superviseData.compressSize;
                    this.f٤٨٩٧b.f٤٨٤٤a.recDataSize = this.f٤٩٠٠e + superviseData.recvUncompressSize;
                    this.f٤٨٩٧b.f٤٨٤٤a.reqHeadInflateSize = superviseData.uncompressSize;
                    this.f٤٨٩٧b.f٤٨٤٤a.reqHeadDeflateSize = superviseData.compressSize;
                    this.f٤٨٩٧b.f٤٨٤٤a.reqBodyInflateSize = superviseData.bodySize;
                    this.f٤٨٩٧b.f٤٨٤٤a.reqBodyDeflateSize = superviseData.bodySize;
                    this.f٤٨٩٧b.f٤٨٤٤a.rspHeadDeflateSize = superviseData.recvCompressSize;
                    this.f٤٨٩٧b.f٤٨٤٤a.rspHeadInflateSize = superviseData.recvUncompressSize;
                    this.f٤٨٩٧b.f٤٨٤٤a.rspBodyDeflateSize = superviseData.recvBodySize;
                    this.f٤٨٩٧b.f٤٨٤٤a.rspBodyInflateSize = this.f٤٩٠٠e;
                    if (this.f٤٨٩٧b.f٤٨٤٤a.contentLength == 0) {
                        this.f٤٨٩٧b.f٤٨٤٤a.contentLength = superviseData.originContentLength;
                    }
                    SessionStatistic sessionStatistic = TnetSpdySession.this.f٤٦٢٧q;
                    sessionStatistic.recvSizeCount += superviseData.recvBodySize + superviseData.recvCompressSize;
                    sessionStatistic.sendSizeCount += superviseData.bodySize + superviseData.compressSize;
                }
            } catch (Exception unused) {
            }
        }

        @Override // anet.channel.session.a
        public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z10, long j10, SpdyByteArray spdyByteArray, Object obj) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.TnetSpdySession", "spdyDataChunkRecvCB", this.f٤٨٩٧b.getSeq(), "len", Integer.valueOf(spdyByteArray.getDataLength()), "fin", Boolean.valueOf(z10));
            }
            this.f٤٩٠٠e += spdyByteArray.getDataLength();
            this.f٤٨٩٧b.f٤٨٤٤a.recDataSize += spdyByteArray.getDataLength();
            IHeartbeat iHeartbeat = TnetSpdySession.this.D;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
            if (this.f٤٨٩٨c != null) {
                ByteArray a10 = a.C٠٠٦٠a.f٤٦٩٣a.a(spdyByteArray.getByteArray(), spdyByteArray.getDataLength());
                spdyByteArray.recycle();
                this.f٤٨٩٨c.onDataReceive(a10, z10);
            }
            TnetSpdySession.this.handleCallbacks(32, null);
        }

        @Override // anet.channel.session.a
        public void spdyOnStreamResponse(SpdySession spdySession, long j10, Map<String, List<String>> map, Object obj) {
            this.f٤٨٩٧b.f٤٨٤٤a.firstDataTime = System.currentTimeMillis() - this.f٤٨٩٧b.f٤٨٤٤a.sendStart;
            this.f٤٨٩٩d = HttpHelper.parseStatusCode(map);
            TnetSpdySession.this.H = 0;
            ALog.i("awcn.TnetSpdySession", "", this.f٤٨٩٧b.getSeq(), "statusCode", Integer.valueOf(this.f٤٨٩٩d));
            ALog.i("awcn.TnetSpdySession", "", this.f٤٨٩٧b.getSeq(), "response headers", map);
            RequestCb requestCb = this.f٤٨٩٨c;
            if (requestCb != null) {
                requestCb.onResponseCode(this.f٤٨٩٩d, HttpHelper.cloneMap(map));
            }
            TnetSpdySession.this.handleCallbacks(16, null);
            this.f٤٨٩٧b.f٤٨٤٤a.contentEncoding = HttpHelper.getSingleHeaderFieldByKey(map, "Content-Encoding");
            this.f٤٨٩٧b.f٤٨٤٤a.contentType = HttpHelper.getSingleHeaderFieldByKey(map, "Content-Type");
            this.f٤٨٩٧b.f٤٨٤٤a.contentLength = HttpHelper.parseContentLength(map);
            this.f٤٨٩٧b.f٤٨٤٤a.serverRT = HttpHelper.parseServerRT(map);
            TnetSpdySession.this.handleResponseCode(this.f٤٨٩٧b, this.f٤٨٩٩d);
            TnetSpdySession.this.handleResponseHeaders(this.f٤٨٩٧b, map);
            IHeartbeat iHeartbeat = TnetSpdySession.this.D;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
        }

        @Override // anet.channel.session.a
        public void spdyStreamCloseCallback(SpdySession spdySession, long j10, int i10, Object obj, SuperviseData superviseData) {
            String str;
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.TnetSpdySession", "spdyStreamCloseCallback", this.f٤٨٩٧b.getSeq(), "streamId", Long.valueOf(j10), "errorCode", Integer.valueOf(i10));
            }
            if (i10 != 0) {
                this.f٤٨٩٩d = ErrorConstant.ERROR_TNET_REQUEST_FAIL;
                str = ErrorConstant.formatMsg(ErrorConstant.ERROR_TNET_REQUEST_FAIL, String.valueOf(i10));
                if (i10 != -2005) {
                    AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_TNET_EXCEPTION, str, this.f٤٨٩٧b.f٤٨٤٤a, null));
                }
                ALog.e("awcn.TnetSpdySession", "spdyStreamCloseCallback error", this.f٤٨٩٧b.getSeq(), "session", TnetSpdySession.this.f٤٦٢٦p, "status code", Integer.valueOf(i10), "URL", this.f٤٨٩٧b.getHttpUrl().simpleUrlString());
            } else {
                str = HttpConstant.SUCCESS;
            }
            this.f٤٨٩٧b.f٤٨٤٤a.tnetErrorCode = i10;
            a(superviseData, this.f٤٨٩٩d, str);
            RequestCb requestCb = this.f٤٨٩٨c;
            if (requestCb != null) {
                requestCb.onFinish(this.f٤٨٩٩d, str, this.f٤٨٩٧b.f٤٨٤٤a);
            }
            if (i10 == -2004) {
                if (!TnetSpdySession.this.f٤٨٩٤y) {
                    TnetSpdySession.this.ping(true);
                }
                if (TnetSpdySession.e(TnetSpdySession.this) >= 2) {
                    ConnEvent connEvent = new ConnEvent();
                    connEvent.isSuccess = false;
                    connEvent.isAccs = TnetSpdySession.this.I;
                    StrategyCenter.getInstance().notifyConnEvent(TnetSpdySession.this.f٤٦١٤d, TnetSpdySession.this.f٤٦٢١k, connEvent);
                    TnetSpdySession.this.close(true);
                }
            }
        }
    }

    public TnetSpdySession(Context context, anet.channel.entity.a aVar) {
        super(context, aVar);
        this.f٤٨٩٤y = false;
        this.A = 0L;
        this.H = 0;
        this.f٤٨٩١B = -1;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.I = false;
    }

    static /* synthetic */ int e(TnetSpdySession tnetSpdySession) {
        int i10 = tnetSpdySession.H + 1;
        tnetSpdySession.H = i10;
        return i10;
    }

    public void bioPingRecvCallback(SpdySession spdySession, int i10) {
    }

    @Override // anet.channel.Session
    public void close() {
        ALog.e("awcn.TnetSpdySession", "force close!", this.f٤٦٢٦p, "session", this);
        notifyStatus(7, null);
        try {
            IHeartbeat iHeartbeat = this.D;
            if (iHeartbeat != null) {
                iHeartbeat.stop();
                this.D = null;
            }
            SpdySession spdySession = this.f٤٨٩٣x;
            if (spdySession != null) {
                spdySession.closeSession();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0132 A[Catch: all -> 0x001a, TryCatch #0 {all -> 0x001a, blocks: (B:6:0x0012, B:8:0x0016, B:9:0x001e, B:11:0x0024, B:14:0x002c, B:17:0x0034, B:19:0x00d8, B:21:0x00e0, B:24:0x00e9, B:26:0x00ed, B:27:0x0113, B:29:0x011b, B:31:0x0121, B:32:0x0124, B:34:0x0132, B:37:0x0147, B:39:0x00f1, B:41:0x00f7, B:42:0x00fd, B:44:0x0107, B:46:0x010b, B:47:0x0110, B:48:0x010e), top: B:5:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0147 A[Catch: all -> 0x001a, TRY_LEAVE, TryCatch #0 {all -> 0x001a, blocks: (B:6:0x0012, B:8:0x0016, B:9:0x001e, B:11:0x0024, B:14:0x002c, B:17:0x0034, B:19:0x00d8, B:21:0x00e0, B:24:0x00e9, B:26:0x00ed, B:27:0x0113, B:29:0x011b, B:31:0x0121, B:32:0x0124, B:34:0x0132, B:37:0x0147, B:39:0x00f1, B:41:0x00f7, B:42:0x00fd, B:44:0x0107, B:46:0x010b, B:47:0x0110, B:48:0x010e), top: B:5:0x0012 }] */
    @Override // anet.channel.Session
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void connect() {
        String str;
        SpdySession createSession;
        int xquicCongControl;
        boolean z10;
        int i10 = this.f٤٦٢٤n;
        if (i10 != 1 && i10 != 0 && i10 != 4) {
            try {
                if (this.f٤٨٩٢w == null) {
                    c();
                }
                if (anet.channel.util.c.a() && anet.channel.strategy.utils.c.a(this.f٤٦١٥e)) {
                    try {
                        this.f٤٦١٦f = anet.channel.util.c.a(this.f٤٦١٥e);
                    } catch (Exception unused) {
                    }
                }
                String valueOf = String.valueOf(System.currentTimeMillis());
                ALog.e("awcn.TnetSpdySession", "connect", this.f٤٦٢٦p, "host", this.f٤٦١٣c, "ip", this.f٤٦١٦f, "port", Integer.valueOf(this.f٤٦١٧g), "sessionId", valueOf, "SpdyProtocol,", this.f٤٦٢٠j, "proxyIp,", this.f٤٦١٨h, "proxyPort,", Integer.valueOf(this.f٤٦١٩i));
                SessionInfo sessionInfo = new SessionInfo(this.f٤٦١٦f, this.f٤٦١٧g, this.f٤٦١٣c + "_" + this.F, this.f٤٦١٨h, this.f٤٦١٩i, valueOf, this, this.f٤٦٢٠j.getTnetConType());
                sessionInfo.setConnectionTimeoutMs((int) (((float) this.f٤٦٢٨r) * Utils.getNetworkTimeFactor()));
                if (!this.f٤٦٢٠j.isPublicKeyAuto() && !this.f٤٦٢٠j.isH2S() && !this.f٤٦٢٠j.isHTTP3()) {
                    int i11 = this.f٤٨٩١B;
                    if (i11 >= 0) {
                        sessionInfo.setPubKeySeqNum(i11);
                    } else {
                        ConnType connType = this.f٤٦٢٠j;
                        ISecurity iSecurity = this.G;
                        if (iSecurity != null) {
                            z10 = iSecurity.isSecOff();
                        } else {
                            z10 = true;
                        }
                        int tnetPublicKey = connType.getTnetPublicKey(z10);
                        this.f٤٨٩١B = tnetPublicKey;
                        sessionInfo.setPubKeySeqNum(tnetPublicKey);
                    }
                    if (this.f٤٦٢٠j.isHTTP3() && (xquicCongControl = AwcnConfig.getXquicCongControl()) >= 0) {
                        sessionInfo.setXquicCongControl(xquicCongControl);
                    }
                    createSession = this.f٤٨٩٢w.createSession(sessionInfo);
                    this.f٤٨٩٣x = createSession;
                    if (createSession.getRefCount() <= 1) {
                        ALog.e("awcn.TnetSpdySession", "get session ref count > 1!!!", this.f٤٦٢٦p, new Object[0]);
                        notifyStatus(0, new anet.channel.entity.b(1));
                        b();
                        return;
                    }
                    notifyStatus(1, null);
                    this.f٤٨٩٥z = System.currentTimeMillis();
                    this.f٤٦٢٧q.isProxy = !TextUtils.isEmpty(this.f٤٦١٨h) ? 1 : 0;
                    SessionStatistic sessionStatistic = this.f٤٦٢٧q;
                    sessionStatistic.isTunnel = RequestConstant.FALSE;
                    sessionStatistic.isBackground = GlobalAppRuntimeInfo.isAppBackground();
                    this.A = 0L;
                    return;
                }
                if (this.f٤٦٢٣m) {
                    str = this.f٤٦١٥e;
                } else {
                    str = this.f٤٦١٤d;
                }
                sessionInfo.setCertHost(str);
                if (this.f٤٦٢٠j.isHTTP3()) {
                    sessionInfo.setXquicCongControl(xquicCongControl);
                }
                createSession = this.f٤٨٩٢w.createSession(sessionInfo);
                this.f٤٨٩٣x = createSession;
                if (createSession.getRefCount() <= 1) {
                }
            } catch (Throwable th) {
                notifyStatus(2, null);
                ALog.e("awcn.TnetSpdySession", "connect exception ", this.f٤٦٢٦p, th, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // anet.channel.Session
    public Runnable getRecvTimeOutRunnable() {
        return new h(this);
    }

    public byte[] getSSLMeta(SpdySession spdySession) {
        String domain = spdySession.getDomain();
        if (TextUtils.isEmpty(domain)) {
            ALog.i("awcn.TnetSpdySession", "get sslticket host is null", null, new Object[0]);
            return null;
        }
        try {
            ISecurity iSecurity = this.G;
            if (iSecurity == null) {
                return null;
            }
            return iSecurity.getBytes(this.f٤٦١١a, "accs_ssl_key2_" + domain);
        } catch (Throwable th) {
            ALog.e("awcn.TnetSpdySession", "getSSLMeta", null, th, new Object[0]);
            return null;
        }
    }

    public void initConfig(Config config) {
        if (config != null) {
            this.F = config.getAppkey();
            this.G = config.getSecurity();
        }
    }

    public void initSessionInfo(anet.channel.SessionInfo sessionInfo) {
        if (sessionInfo != null) {
            this.C = sessionInfo.dataFrameCb;
            this.E = sessionInfo.auth;
            if (sessionInfo.isKeepAlive) {
                this.f٤٦٢٧q.isKL = 1L;
                this.f٤٦٣٠t = true;
                IHeartbeat iHeartbeat = sessionInfo.heartbeat;
                this.D = iHeartbeat;
                boolean z10 = sessionInfo.isAccs;
                this.I = z10;
                if (iHeartbeat == null) {
                    if (z10 && !AwcnConfig.isAccsSessionCreateForbiddenInBg()) {
                        this.D = HeartbeatManager.getDefaultBackgroundAccsHeartbeat();
                    } else {
                        this.D = HeartbeatManager.getDefaultHeartbeat();
                    }
                }
            }
        }
        if (AwcnConfig.isIdleSessionCloseEnable() && this.D == null) {
            this.D = new anet.channel.heartbeat.c();
        }
    }

    @Override // anet.channel.Session
    public boolean isAvailable() {
        if (this.f٤٦٢٤n == 4) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // anet.channel.Session
    public void onDisconnect() {
        this.f٤٨٩٤y = false;
    }

    @Override // anet.channel.Session
    public void ping(boolean z10) {
        ping(z10, this.f٤٦٢٩s);
    }

    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        String domain = spdySession.getDomain();
        if (TextUtils.isEmpty(domain)) {
            return -1;
        }
        try {
            ISecurity iSecurity = this.G;
            if (iSecurity == null) {
                return -1;
            }
            if (!iSecurity.saveBytes(this.f٤٦١١a, "accs_ssl_key2_" + domain, bArr)) {
                return -1;
            }
            return 0;
        } catch (Throwable th) {
            ALog.e("awcn.TnetSpdySession", "putSSLMeta", null, th, new Object[0]);
            return -1;
        }
    }

    @Override // anet.channel.Session
    public Cancelable request(Request request, RequestCb requestCb) {
        RequestStatistic requestStatistic;
        int i10;
        String str;
        SpdyRequest spdyRequest;
        String host;
        anet.channel.request.c cVar = anet.channel.request.c.NULL;
        if (request != null) {
            requestStatistic = request.f٤٨٤٤a;
        } else {
            requestStatistic = new RequestStatistic(this.f٤٦١٤d, null);
        }
        requestStatistic.setConnType(this.f٤٦٢٠j);
        if (requestStatistic.start == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            requestStatistic.reqStart = currentTimeMillis;
            requestStatistic.start = currentTimeMillis;
        }
        requestStatistic.setIPAndPort(this.f٤٦١٦f, this.f٤٦١٧g);
        requestStatistic.ipRefer = this.f٤٦٢١k.getIpSource();
        requestStatistic.ipType = this.f٤٦٢١k.getIpType();
        requestStatistic.unit = this.f٤٦٢٢l;
        if (request != null && requestCb != null) {
            try {
                if (this.f٤٨٩٣x != null && ((i10 = this.f٤٦٢٤n) == 0 || i10 == 4)) {
                    if (this.f٤٦٢٣m) {
                        request.setDnsOptimize(this.f٤٦١٥e, this.f٤٦١٧g);
                    }
                    request.setUrlScheme(this.f٤٦٢٠j.isSSL());
                    URL url = request.getUrl();
                    if (ALog.isPrintLog(2)) {
                        ALog.i("awcn.TnetSpdySession", "", request.getSeq(), "request URL", url.toString());
                        ALog.i("awcn.TnetSpdySession", "", request.getSeq(), "request Method", request.getMethod());
                        ALog.i("awcn.TnetSpdySession", "", request.getSeq(), "request headers", request.getHeaders());
                    }
                    if (TextUtils.isEmpty(this.f٤٦١٨h) || this.f٤٦١٩i <= 0) {
                        str = "";
                        spdyRequest = new SpdyRequest(url, request.getMethod(), RequestPriority.DEFAULT_PRIORITY, -1, request.getConnectTimeout());
                    } else {
                        str = "";
                        spdyRequest = new SpdyRequest(url, url.getHost(), url.getPort(), this.f٤٦١٨h, this.f٤٦١٩i, request.getMethod(), RequestPriority.DEFAULT_PRIORITY, -1, request.getConnectTimeout(), 0);
                    }
                    spdyRequest.setRequestRdTimeoutMs(request.getReadTimeout());
                    Map<String, String> headers = request.getHeaders();
                    if (!headers.containsKey("Host")) {
                        spdyRequest.addHeaders(headers);
                        if (this.f٤٦٢٣m) {
                            host = this.f٤٦١٥e;
                        } else {
                            host = request.getHost();
                        }
                        spdyRequest.addHeader(":host", host);
                    } else {
                        HashMap hashMap = new HashMap(request.getHeaders());
                        String str2 = (String) hashMap.remove("Host");
                        if (this.f٤٦٢٣m) {
                            str2 = this.f٤٦١٥e;
                        }
                        hashMap.put(":host", str2);
                        spdyRequest.addHeaders(hashMap);
                    }
                    SpdyDataProvider spdyDataProvider = new SpdyDataProvider(request.getBodyBytes());
                    request.f٤٨٤٤a.sendStart = System.currentTimeMillis();
                    RequestStatistic requestStatistic2 = request.f٤٨٤٤a;
                    requestStatistic2.processTime = requestStatistic2.sendStart - request.f٤٨٤٤a.start;
                    int submitRequest = this.f٤٨٩٣x.submitRequest(spdyRequest, spdyDataProvider, this, new a(request, requestCb));
                    if (ALog.isPrintLog(1)) {
                        ALog.d("awcn.TnetSpdySession", str, request.getSeq(), "streamId", Integer.valueOf(submitRequest));
                    }
                    anet.channel.request.c cVar2 = new anet.channel.request.c(this.f٤٨٩٣x, submitRequest, request.getSeq());
                    try {
                        SessionStatistic sessionStatistic = this.f٤٦٢٧q;
                        sessionStatistic.requestCount++;
                        sessionStatistic.stdRCount++;
                        this.f٤٨٩٥z = System.currentTimeMillis();
                        IHeartbeat iHeartbeat = this.D;
                        if (iHeartbeat != null) {
                            iHeartbeat.reSchedule();
                        }
                        return cVar2;
                    } catch (SpdyErrorException e10) {
                        e = e10;
                        cVar = cVar2;
                        if (e.SpdyErrorGetCode() == -1104 || e.SpdyErrorGetCode() == -1103) {
                            ALog.e("awcn.TnetSpdySession", "Send request on closed session!!!", this.f٤٦٢٦p, new Object[0]);
                            notifyStatus(6, new anet.channel.entity.b(2));
                        }
                        requestCb.onFinish(ErrorConstant.ERROR_TNET_EXCEPTION, ErrorConstant.formatMsg(ErrorConstant.ERROR_TNET_EXCEPTION, String.valueOf(e.SpdyErrorGetCode())), requestStatistic);
                        return cVar;
                    } catch (Exception unused) {
                        cVar = cVar2;
                        requestCb.onFinish(-101, ErrorConstant.getErrMsg(-101), requestStatistic);
                        return cVar;
                    }
                }
                requestCb.onFinish(ErrorConstant.ERROR_SESSION_INVALID, ErrorConstant.getErrMsg(ErrorConstant.ERROR_SESSION_INVALID), request.f٤٨٤٤a);
                return cVar;
            } catch (Exception unused2) {
            } catch (SpdyErrorException e11) {
                e = e11;
            }
        } else {
            if (requestCb != null) {
                requestCb.onFinish(-102, ErrorConstant.getErrMsg(-102), requestStatistic);
            }
            return cVar;
        }
    }

    @Override // anet.channel.Session
    public void sendCustomFrame(int i10, byte[] bArr, int i11) {
        SpdySession spdySession;
        int length;
        try {
            if (this.C == null) {
                return;
            }
            ALog.e("awcn.TnetSpdySession", "sendCustomFrame", this.f٤٦٢٦p, "dataId", Integer.valueOf(i10), "type", Integer.valueOf(i11));
            if (this.f٤٦٢٤n == 4 && (spdySession = this.f٤٨٩٣x) != null) {
                if (bArr != null && bArr.length > 16384) {
                    a(i10, ErrorConstant.ERROR_DATA_TOO_LARGE, false, null);
                    return;
                }
                if (bArr == null) {
                    length = 0;
                } else {
                    length = bArr.length;
                }
                spdySession.sendCustomControlFrame(i10, i11, 0, length, bArr);
                SessionStatistic sessionStatistic = this.f٤٦٢٧q;
                sessionStatistic.requestCount++;
                sessionStatistic.cfRCount++;
                this.f٤٨٩٥z = System.currentTimeMillis();
                IHeartbeat iHeartbeat = this.D;
                if (iHeartbeat != null) {
                    iHeartbeat.reSchedule();
                    return;
                }
                return;
            }
            ALog.e("awcn.TnetSpdySession", "sendCustomFrame", this.f٤٦٢٦p, "sendCustomFrame con invalid mStatus:" + this.f٤٦٢٤n);
            a(i10, ErrorConstant.ERROR_SESSION_INVALID, true, "session invalid");
        } catch (SpdyErrorException e10) {
            ALog.e("awcn.TnetSpdySession", "sendCustomFrame error", this.f٤٦٢٦p, e10, new Object[0]);
            a(i10, ErrorConstant.ERROR_TNET_EXCEPTION, true, "SpdyErrorException: " + e10.toString());
        } catch (Exception e11) {
            ALog.e("awcn.TnetSpdySession", "sendCustomFrame error", this.f٤٦٢٦p, e11, new Object[0]);
            a(i10, -101, true, e11.toString());
        }
    }

    public void setTnetPublicKey(int i10) {
        this.f٤٨٩١B = i10;
    }

    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i10, int i11) {
        ALog.e("awcn.TnetSpdySession", "spdyCustomControlFrameFailCallback", this.f٤٦٢٦p, "dataId", Integer.valueOf(i10));
        a(i10, i11, true, "tnet error");
    }

    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i10, int i11, int i12, int i13, byte[] bArr) {
        ALog.e("awcn.TnetSpdySession", "[spdyCustomControlFrameRecvCallback]", this.f٤٦٢٦p, "len", Integer.valueOf(i13), "frameCb", this.C);
        if (ALog.isPrintLog(1) && i13 < 512) {
            String str = "";
            for (byte b10 : bArr) {
                str = str + Integer.toHexString(b10 & UByte.MAX_VALUE) + " ";
            }
            ALog.e("awcn.TnetSpdySession", null, this.f٤٦٢٦p, "str", str);
        }
        DataFrameCb dataFrameCb = this.C;
        if (dataFrameCb != null) {
            dataFrameCb.onDataReceive(this, bArr, i10, i11);
        } else {
            ALog.e("awcn.TnetSpdySession", "AccsFrameCb is null", this.f٤٦٢٦p, new Object[0]);
            AppMonitor.getInstance().commitStat(new ExceptionStatistic(-105, null, "rt"));
        }
        this.f٤٦٢٧q.inceptCount++;
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.reSchedule();
        }
    }

    public void spdyPingRecvCallback(SpdySession spdySession, long j10, Object obj) {
        if (ALog.isPrintLog(2)) {
            ALog.i("awcn.TnetSpdySession", "ping receive", this.f٤٦٢٦p, "Host", this.f٤٦١٣c, "id", Long.valueOf(j10));
        }
        if (j10 < 0) {
            return;
        }
        this.f٤٨٩٤y = false;
        this.H = 0;
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.reSchedule();
        }
        handleCallbacks(128, null);
    }

    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i10) {
        ALog.e("awcn.TnetSpdySession", "spdySessionCloseCallback", this.f٤٦٢٦p, " errorCode:", Integer.valueOf(i10));
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.stop();
            this.D = null;
        }
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e10) {
                ALog.e("awcn.TnetSpdySession", "session clean up failed!", null, e10, new Object[0]);
            }
        }
        if (i10 == -3516) {
            ConnEvent connEvent = new ConnEvent();
            connEvent.isSuccess = false;
            StrategyCenter.getInstance().notifyConnEvent(this.f٤٦١٤d, this.f٤٦٢١k, connEvent);
        }
        notifyStatus(6, new anet.channel.entity.b(2));
        if (superviseConnectInfo != null) {
            SessionStatistic sessionStatistic = this.f٤٦٢٧q;
            sessionStatistic.requestCount = superviseConnectInfo.reused_counter;
            sessionStatistic.liveTime = superviseConnectInfo.keepalive_period_second;
            try {
                if (this.f٤٦٢٠j.isHTTP3()) {
                    if (spdySession != null) {
                        ALog.e("awcn.TnetSpdySession", "[HTTP3 spdySessionCloseCallback]", this.f٤٦٢٦p, "connectInfo", spdySession.getConnectInfoOnDisConnected());
                    }
                    this.f٤٦٢٧q.xqc0RttStatus = superviseConnectInfo.xqc0RttStatus;
                    this.f٤٦٢٧q.retransmissionRate = superviseConnectInfo.retransmissionRate;
                    this.f٤٦٢٧q.lossRate = superviseConnectInfo.lossRate;
                    this.f٤٦٢٧q.tlpCount = superviseConnectInfo.tlpCount;
                    this.f٤٦٢٧q.rtoCount = superviseConnectInfo.rtoCount;
                    this.f٤٦٢٧q.srtt = superviseConnectInfo.srtt;
                }
            } catch (Exception unused) {
            }
        }
        SessionStatistic sessionStatistic2 = this.f٤٦٢٧q;
        if (sessionStatistic2.errorCode == 0) {
            sessionStatistic2.errorCode = i10;
        }
        sessionStatistic2.lastPingInterval = (int) (System.currentTimeMillis() - this.f٤٨٩٥z);
        AppMonitor.getInstance().commitStat(this.f٤٦٢٧q);
        if (anet.channel.strategy.utils.c.b(this.f٤٦٢٧q.ip)) {
            AppMonitor.getInstance().commitStat(new SessionMonitor(this.f٤٦٢٧q));
        }
        AppMonitor.getInstance().commitAlarm(this.f٤٦٢٧q.getAlarmObject());
    }

    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        SessionStatistic sessionStatistic = this.f٤٦٢٧q;
        sessionStatistic.connectionTime = superviseConnectInfo.connectTime;
        sessionStatistic.sslTime = superviseConnectInfo.handshakeTime;
        sessionStatistic.sslCalTime = superviseConnectInfo.doHandshakeTime;
        sessionStatistic.netType = NetworkStatusHelper.getNetworkSubType();
        this.A = System.currentTimeMillis();
        notifyStatus(0, new anet.channel.entity.b(1));
        b();
        ALog.e("awcn.TnetSpdySession", "spdySessionConnectCB connect", this.f٤٦٢٦p, "connectTime", Integer.valueOf(superviseConnectInfo.connectTime), "sslTime", Integer.valueOf(superviseConnectInfo.handshakeTime));
        if (this.f٤٦٢٠j.isHTTP3()) {
            this.f٤٦٢٧q.scid = superviseConnectInfo.scid;
            this.f٤٦٢٧q.dcid = superviseConnectInfo.dcid;
            this.f٤٦٢٧q.congControlKind = superviseConnectInfo.congControlKind;
            ALog.e("awcn.TnetSpdySession", "[HTTP3 spdySessionConnectCB]", this.f٤٦٢٦p, "connectInfo", spdySession.getConnectInfoOnConnected());
        }
    }

    public void spdySessionFailedError(SpdySession spdySession, int i10, Object obj) {
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e10) {
                ALog.e("awcn.TnetSpdySession", "[spdySessionFailedError]session clean up failed!", null, e10, new Object[0]);
            }
        }
        notifyStatus(2, new anet.channel.entity.b(256, i10, "tnet connect fail"));
        ALog.e("awcn.TnetSpdySession", null, this.f٤٦٢٦p, " errorId:", Integer.valueOf(i10));
        SessionStatistic sessionStatistic = this.f٤٦٢٧q;
        sessionStatistic.errorCode = i10;
        sessionStatistic.ret = 0;
        sessionStatistic.netType = NetworkStatusHelper.getNetworkSubType();
        AppMonitor.getInstance().commitStat(this.f٤٦٢٧q);
        if (anet.channel.strategy.utils.c.b(this.f٤٦٢٧q.ip)) {
            AppMonitor.getInstance().commitStat(new SessionMonitor(this.f٤٦٢٧q));
        }
        AppMonitor.getInstance().commitAlarm(this.f٤٦٢٧q.getAlarmObject());
    }

    @Override // anet.channel.Session
    public void ping(boolean z10, int i10) {
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.TnetSpdySession", "ping", this.f٤٦٢٦p, "host", this.f٤٦١٣c, "thread", Thread.currentThread().getName());
        }
        if (z10) {
            try {
                if (this.f٤٨٩٣x != null) {
                    int i11 = this.f٤٦٢٤n;
                    if (i11 == 0 || i11 == 4) {
                        handleCallbacks(64, null);
                        if (this.f٤٨٩٤y) {
                            return;
                        }
                        this.f٤٨٩٤y = true;
                        this.f٤٦٢٧q.ppkgCount++;
                        this.f٤٨٩٣x.submitPing();
                        if (ALog.isPrintLog(1)) {
                            ALog.d("awcn.TnetSpdySession", this.f٤٦١٣c + " submit ping ms:" + (System.currentTimeMillis() - this.f٤٨٩٥z) + " force:" + z10, this.f٤٦٢٦p, new Object[0]);
                        }
                        setPingTimeout(i10);
                        this.f٤٨٩٥z = System.currentTimeMillis();
                        IHeartbeat iHeartbeat = this.D;
                        if (iHeartbeat != null) {
                            iHeartbeat.reSchedule();
                            return;
                        }
                        return;
                    }
                    return;
                }
                SessionStatistic sessionStatistic = this.f٤٦٢٧q;
                if (sessionStatistic != null) {
                    sessionStatistic.closeReason = "session null";
                }
                ALog.e("awcn.TnetSpdySession", this.f٤٦١٣c + " session null", this.f٤٦٢٦p, new Object[0]);
                close();
            } catch (SpdyErrorException e10) {
                if (e10.SpdyErrorGetCode() == -1104 || e10.SpdyErrorGetCode() == -1103) {
                    ALog.e("awcn.TnetSpdySession", "Send request on closed session!!!", this.f٤٦٢٦p, new Object[0]);
                    notifyStatus(6, new anet.channel.entity.b(2));
                }
                ALog.e("awcn.TnetSpdySession", "ping", this.f٤٦٢٦p, e10, new Object[0]);
            } catch (Exception e11) {
                ALog.e("awcn.TnetSpdySession", "ping", this.f٤٦٢٦p, e11, new Object[0]);
            }
        }
    }

    private void c() {
        SpdyAgent.enableDebug = false;
        this.f٤٨٩٢w = SpdyAgent.getInstance(this.f٤٦١١a, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        ISecurity iSecurity = this.G;
        if (iSecurity != null && !iSecurity.isSecOff()) {
            this.f٤٨٩٢w.setAccsSslCallback(new j(this));
        }
        if (AwcnConfig.isTnetHeaderCacheEnable()) {
            return;
        }
        try {
            this.f٤٨٩٢w.getClass().getDeclaredMethod("disableHeaderCache", null).invoke(this.f٤٨٩٢w, null);
            ALog.i("awcn.TnetSpdySession", "tnet disableHeaderCache", null, new Object[0]);
        } catch (Exception e10) {
            ALog.e("awcn.TnetSpdySession", "tnet disableHeaderCache", null, e10, new Object[0]);
        }
    }

    protected void b() {
        IAuth iAuth = this.E;
        if (iAuth != null) {
            iAuth.auth(this, new i(this));
            return;
        }
        notifyStatus(4, null);
        this.f٤٦٢٧q.ret = 1;
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.start(this);
        }
    }

    private void a(int i10, int i11, boolean z10, String str) {
        DataFrameCb dataFrameCb = this.C;
        if (dataFrameCb != null) {
            dataFrameCb.onException(i10, i11, z10, str);
        }
    }
}
