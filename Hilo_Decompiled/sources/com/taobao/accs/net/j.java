package com.taobao.accs.net;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import anet.channel.DataFrameCb;
import anet.channel.IAuth;
import anet.channel.ISessionListener;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.SessionInfo;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.request.Request;
import anet.channel.session.TnetSpdySession;
import com.alibaba.sdk.android.error.ErrorCode;
import com.alibaba.sdk.android.logger.ILog;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.AccsException;
import com.taobao.accs.AccsState;
import com.taobao.accs.ConnectionListener;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.AccsLogger;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UtilityImpl;
import com.therouter.inject.DebugOnlyKt;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class j extends b implements DataFrameCb, ISessionListener {
    private boolean n;
    private long o;
    private ScheduledFuture p;
    private ScheduledFuture q;
    private boolean r;
    private ErrorCode s;
    private final ILog t;
    private final Runnable u;
    private final Runnable v;
    private final Runnable w;
    private final Set<String> x;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class a implements IAuth {
        private final String a;
        private int b;
        private String c;
        private final b d;
        private final ILog e;

        public a(b bVar, String str) {
            this.c = bVar.d();
            this.a = bVar.c("https://" + str + "/accs/");
            this.b = bVar.c;
            this.d = bVar;
            this.e = AccsLogger.getLogger(bVar.d());
        }

        public void auth(Session session, IAuth.AuthCallback authCallback) {
            this.e.i(new Object[]{BaseMonitor.ALARM_POINT_AUTH, "URL", this.a});
            session.request(new Request.Builder().setUrl(this.a).build(), new s(this, authCallback));
        }
    }

    public j(Context context, int i, String str) {
        super(context, i, str);
        this.n = true;
        this.o = 3600000L;
        this.r = false;
        this.s = null;
        this.u = new k(this);
        this.v = new l(this);
        q qVar = new q(this);
        this.w = qVar;
        this.x = Collections.synchronizedSet(new HashSet());
        ILog logger = AccsLogger.getLogger(d());
        this.t = logger;
        if (!OrangeAdapter.isTnetLogOff(true)) {
            String d = UtilityImpl.d(this.d, "inapp");
            logger.d("config tnet log path:" + d);
            if (!TextUtils.isEmpty(d)) {
                Session.configTnetALog(context, d, UtilityImpl.TNET_FILE_SIZE, 5);
            }
        }
        AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
        if (configByTag != null && configByTag.isChannelLoopStart()) {
            logger.d("channel loop start");
            ThreadPoolExecutorFactory.getScheduledExecutor().scheduleWithFixedDelay(qVar, 120000L, configByTag.getLoopInterval(), TimeUnit.MILLISECONDS);
        } else {
            logger.d("channel delay start");
            ThreadPoolExecutorFactory.getScheduledExecutor().schedule(qVar, 120000L, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.i.isAccsHeartbeatEnable()) {
            ScheduledThreadPoolExecutor scheduledExecutor = ThreadPoolExecutorFactory.getScheduledExecutor();
            Runnable runnable = this.v;
            long j = this.o;
            this.p = scheduledExecutor.scheduleAtFixedRate(runnable, j, j, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        s();
        this.t.i("startReconnectTask");
        this.q = ThreadPoolExecutorFactory.getScheduledExecutor().scheduleWithFixedDelay(this.u, 120L, 120L, TimeUnit.SECONDS);
    }

    private void s() {
        ScheduledFuture scheduledFuture = this.q;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.q = null;
        }
    }

    @Override // com.taobao.accs.net.b
    public void a(boolean z, boolean z2) {
    }

    @Override // com.taobao.accs.net.b
    public com.taobao.accs.ut.a.c c() {
        return null;
    }

    @Override // com.taobao.accs.net.b
    public void e() {
        this.t.e("shut down");
        this.n = false;
    }

    @Override // com.taobao.accs.net.b
    public boolean l() {
        return this.r;
    }

    @Override // com.taobao.accs.net.b
    public int m() {
        ErrorCode errorCode = this.s;
        if (errorCode != null) {
            return errorCode.getCodeInt();
        }
        return 0;
    }

    @Override // com.taobao.accs.net.b
    public void n() {
        SessionCenter sessionCenter = SessionCenter.getInstance(this.i.getAppKey());
        if (sessionCenter == null) {
            return;
        }
        String inappHost = this.i.getInappHost();
        sessionCenter.unregisterSessionInfo(inappHost);
        if (this.x.contains(inappHost)) {
            this.x.remove(inappHost);
        }
    }

    @Override // com.taobao.accs.net.b
    public void o() {
        this.t.i("reconnect begin");
        this.g = false;
        a(this.d);
        ThreadPoolExecutorFactory.getSendScheduledExecutor().execute(new r(this));
    }

    public void onConnectionChanged(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
        String stringExtra = intent.getStringExtra(Constants.KEY_HOST);
        ErrorCode errorCode = Constants.getErrorCode(intent);
        if (!TextUtils.isEmpty(stringExtra)) {
            if (!booleanExtra) {
                if (errorCode.getCodeInt() == AccsErrorCode.SUCCESS.getCodeInt()) {
                    if (UtilityImpl.g(this.d)) {
                        errorCode = AccsErrorCode.INAPP_CON_DISCONNECTED.copy().detail(AccsErrorCode.getAllDetails("lost connect")).build();
                    } else {
                        errorCode = AccsErrorCode.NO_NETWORK.copy().detail(AccsErrorCode.getAllDetails("lost connect")).build();
                    }
                }
                this.t.e(new Object[]{"InAppConnection Not Available ", BaseMonitor.COUNT_ERROR, errorCode});
                r();
            } else {
                this.t.i(new Object[]{"InAppConnection Available. last status", Boolean.valueOf(this.r)});
                s();
                if (!this.r) {
                    b(this.d);
                }
            }
            this.r = booleanExtra;
            this.s = errorCode;
            if (errorCode != null && errorCode.getCodeInt() != AccsErrorCode.SUCCESS.getCodeInt()) {
                AccsState.getInstance().b(AccsState.CONNECTION_CHANGE, "h" + stringExtra + DebugOnlyKt.PACKAGE + booleanExtra + "c" + errorCode.getCodeInt());
                AccsState.getInstance().b(AccsState.RECENT_ERRORS, Integer.valueOf(errorCode.getCodeInt()));
            } else {
                AccsState.getInstance().b(AccsState.CONNECTION_CHANGE, "h" + stringExtra + DebugOnlyKt.PACKAGE + booleanExtra);
            }
            a(booleanExtra, errorCode);
        }
    }

    public void onDataReceive(TnetSpdySession tnetSpdySession, byte[] bArr, int i, int i2) {
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new o(this, i2, i, bArr, tnetSpdySession));
    }

    public void onException(int i, int i2, boolean z, String str) {
        this.t.e(new Object[]{"onException", Constants.KEY_DATA_ID, Integer.valueOf(i), "errorId", Integer.valueOf(i2), "needRetry", Boolean.valueOf(z), "detail", str});
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new p(this, i2, str, i, z));
    }

    @Override // com.taobao.accs.net.b
    public void b() {
        this.f = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.accs.net.b
    public String d() {
        return "InAppConn_" + this.m;
    }

    @Override // com.taobao.accs.net.b
    public synchronized void a() {
        this.t.d("start");
        this.n = true;
        a(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.accs.net.b
    public void a(Message message, boolean z) {
        if (this.n && message != null) {
            try {
                if (ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size() <= 1000) {
                    long j = message.Q;
                    if (j <= 0) {
                        j = 1;
                    }
                    ScheduledFuture<?> schedule = ThreadPoolExecutorFactory.getSendScheduledExecutor().schedule(new m(this, message), j, TimeUnit.MILLISECONDS);
                    if (message.a() == 1 && message.O != null) {
                        if (message.c() && a(message.O)) {
                            this.e.b(message);
                        }
                        this.e.a.put(message.O, schedule);
                    }
                    NetPerformanceMonitor e = message.e();
                    if (e != null) {
                        e.setDeviceId(UtilityImpl.getDeviceId(this.d));
                        e.setConnType(this.c);
                        e.onEnterQueueData();
                        return;
                    }
                    return;
                }
                throw new RejectedExecutionException("accs");
            } catch (RejectedExecutionException unused) {
                int size = ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size();
                ErrorCode build = AccsErrorCode.MESSAGE_QUEUE_FULL.copy().detail("inapp " + size).build();
                this.e.a(message, build);
                this.t.e(new Object[]{"send queue full", "err", build});
                return;
            } catch (Throwable th) {
                this.t.e("send error", th);
                this.e.a(message, AccsErrorCode.SEND_LOCAL_EXCEPTION.copy().detail(AccsErrorCode.getExceptionInfo(th)).build());
                return;
            }
        }
        this.t.w("not running or msg null! " + this.n);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.accs.net.b
    public void a(String str, boolean z, long j) {
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new n(this, str, j, z), j, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.accs.net.b
    public void a(String str, boolean z, String str2) {
        Session session;
        try {
            Message b = this.e.b(str);
            if (b != null && b.f != null && (session = SessionCenter.getInstance(this.i.getAppKey()).get(b.f.toString(), 0L)) != null) {
                if (z) {
                    session.close(true);
                } else {
                    session.ping(true);
                }
            }
        } catch (Exception e) {
            this.t.e("onTimeOut", e);
        }
    }

    @Override // com.taobao.accs.net.b
    public boolean a(String str) {
        if (str == null) {
            return false;
        }
        ScheduledFuture<?> scheduledFuture = this.e.a.get(str);
        boolean cancel = scheduledFuture != null ? scheduledFuture.cancel(false) : false;
        if (cancel) {
            this.t.i(new Object[]{"cancel", "customDataId", str});
        }
        return cancel;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.t.e("onReceiveAccsHeartbeatResp response data is null");
            return;
        }
        this.t.i(new Object[]{"onReceiveAccsHeartbeatResp", "data", jSONObject});
        try {
            int i = jSONObject.getInt("timeInterval");
            if (i == -1) {
                ScheduledFuture scheduledFuture = this.p;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                }
            } else {
                long j = i * 1000;
                if (this.o != j) {
                    if (i == 0) {
                        j = 3600000;
                    }
                    this.o = j;
                    ScheduledThreadPoolExecutor scheduledExecutor = ThreadPoolExecutorFactory.getScheduledExecutor();
                    Runnable runnable = this.v;
                    long j2 = this.o;
                    this.p = scheduledExecutor.scheduleAtFixedRate(runnable, j2, j2, TimeUnit.MILLISECONDS);
                }
            }
        } catch (JSONException e) {
            this.t.e("onReceiveAccsHeartbeatResp", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.accs.net.b
    public void a(Context context) {
        boolean z;
        try {
            if (this.g) {
                return;
            }
            super.a(context);
            String inappHost = this.i.getInappHost();
            if (h() && this.i.isKeepalive()) {
                z = true;
            } else {
                this.t.d("initAwcn close keep alive");
                z = false;
            }
            a(SessionCenter.getInstance(this.i.getAppKey()), inappHost, z);
            this.g = true;
            this.t.i("initAwcn success!");
        } catch (Throwable th) {
            this.t.e("initAwcn", th);
        }
    }

    public void a(SessionCenter sessionCenter, String str, boolean z) {
        if (this.x.contains(str)) {
            return;
        }
        SessionInfo create = SessionInfo.create(str, z, true, new a(this, str), (IHeartbeat) null, this);
        sessionCenter.registerAccsSessionListener(this);
        sessionCenter.registerPublicKey(str, this.i.getInappPubKey());
        sessionCenter.registerSessionInfo(create);
        this.x.add(str);
        this.t.i(new Object[]{"registerSessionInfo", Constants.KEY_HOST, str});
    }

    public void a(AccsClientConfig accsClientConfig) {
        boolean z = true;
        if (accsClientConfig == null) {
            this.t.i("updateConfig null");
            return;
        }
        if (accsClientConfig.equals(this.i)) {
            this.t.i("updateConfig not any changed");
            return;
        }
        try {
            this.t.i(new Object[]{"updateConfig", "old", this.i, "new", accsClientConfig});
            String inappHost = this.i.getInappHost();
            String inappHost2 = accsClientConfig.getInappHost();
            SessionCenter sessionCenter = SessionCenter.getInstance(this.i.getAppKey());
            if (sessionCenter == null) {
                this.t.d("old session not exist, no need update");
                return;
            }
            sessionCenter.unregisterSessionInfo(inappHost);
            if (this.x.contains(inappHost)) {
                this.x.remove(inappHost);
            }
            String appKey = this.i.getAppKey();
            this.i = accsClientConfig;
            this.b = accsClientConfig.getAppKey();
            this.m = this.i.getTag();
            if (!appKey.equals(this.b)) {
                sessionCenter = SessionCenter.getInstance(this.b);
            }
            if (!h() || !this.i.isKeepalive()) {
                this.t.i("updateConfig close keepalive");
                z = false;
            }
            a(sessionCenter, inappHost2, z);
            this.t.i("updateConfig done");
        } catch (Throwable th) {
            this.t.e("updateConfig", th);
        }
    }

    private void a(boolean z, ErrorCode errorCode) {
        try {
            for (ConnectionListener connectionListener : ACCSClient.getAccsClient(this.m).getConnectionListeners()) {
                if (z) {
                    connectionListener.onConnect();
                } else {
                    connectionListener.onDisconnect(errorCode.getCodeInt(), errorCode.getMsg());
                }
            }
        } catch (AccsException e) {
            e.printStackTrace();
        }
    }
}
