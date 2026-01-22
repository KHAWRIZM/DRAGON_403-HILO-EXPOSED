package com.taobao.accs.net;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.strategy.IConnStrategy;
import com.alibaba.sdk.android.error.ErrorCode;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.ut.monitor.SessionMonitor;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.Utils;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http2.Header;
import org.android.agoo.message.MessageService;
import org.android.spdy.RequestPriority;
import org.android.spdy.SessionCb;
import org.android.spdy.SessionInfo;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyByteArray;
import org.android.spdy.SpdyDataProvider;
import org.android.spdy.SpdyRequest;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.Spdycb;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class w extends b implements SessionCb, Spdycb {
    private Object A;
    private long B;
    private long C;
    private long D;
    private long E;
    private int F;
    private String G;
    private SessionMonitor H;
    private com.taobao.accs.ut.a.c I;
    private boolean J;
    private String K;
    private boolean L;
    private g M;
    private String N;
    protected ScheduledFuture<?> n;
    protected String o;
    protected int p;
    protected String q;
    protected int r;
    private int s;
    private LinkedList<Message> t;
    private a u;
    private boolean v;
    private String w;
    private String x;
    private SpdyAgent y;
    private SpdySession z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class a extends Thread {
        public int a;
        long b;
        private final String d;

        public a(String str) {
            super(str);
            this.d = getName();
            this.a = 0;
        }

        private void a(boolean z) {
            if (w.this.s != 1) {
                ALog.d(w.this.d(), "tryConnect", "force", Boolean.valueOf(z));
                if (z) {
                    this.a = 0;
                }
                ALog.i(this.d, "tryConnect", "force", Boolean.valueOf(z), "failTimes", Integer.valueOf(this.a));
                if (w.this.s != 1 && this.a >= 4) {
                    w.this.J = true;
                    ALog.e(this.d, "tryConnect fail", "maxTimes", 4);
                    return;
                }
                if (w.this.s != 1) {
                    if (w.this.c == 1 && this.a == 0) {
                        ALog.i(this.d, "tryConnect in app, no sleep", new Object[0]);
                    } else {
                        ALog.i(this.d, "tryConnect, need sleep", new Object[0]);
                        try {
                            Thread.sleep(5000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    w.this.K = "";
                    if (this.a == 3) {
                        w.this.M.b(w.this.r());
                    }
                    w.this.d((String) null);
                    w.this.H.setRetryTimes(this.a);
                    if (w.this.s != 1) {
                        this.a++;
                        ALog.e(this.d, "try connect fail, ready for reconnect", new Object[0]);
                        a(false);
                        return;
                    }
                    this.b = System.currentTimeMillis();
                    return;
                }
                return;
            }
            if (w.this.s == 1 && System.currentTimeMillis() - this.b > 5000) {
                this.a = 0;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Message message;
            boolean z;
            Integer num;
            int a;
            char c = 3;
            int i = 4;
            ALog.i(this.d, "NetworkThread run", new Object[0]);
            this.a = 0;
            Message message2 = null;
            while (w.this.v) {
                ALog.d(this.d, "ready to get message", new Object[0]);
                synchronized (w.this.t) {
                    if (w.this.t.size() == 0) {
                        try {
                            ALog.d(this.d, "no message, wait", new Object[0]);
                            w.this.t.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    ALog.d(this.d, "try get message", new Object[0]);
                    if (w.this.t.size() != 0) {
                        message2 = (Message) w.this.t.getFirst();
                        if (message2.e() != null) {
                            message2.e().onTakeFromQueue();
                        }
                    }
                    message = message2;
                }
                if (!w.this.v) {
                    break;
                }
                if (message != null) {
                    ALog.d(this.d, "sendMessage not null", new Object[0]);
                    try {
                        int a2 = message.a();
                        String str = this.d;
                        String b = Message.c.b(a2);
                        Integer valueOf = Integer.valueOf(w.this.s);
                        Object[] objArr = new Object[i];
                        objArr[0] = "type";
                        objArr[1] = b;
                        objArr[2] = "status";
                        objArr[c] = valueOf;
                        ALog.i(str, TUIConstants.TUIChat.METHOD_SEND_MESSAGE, objArr);
                        if (a2 == 2) {
                            if (w.this.c == 1) {
                                ALog.d(this.d, "sendMessage INAPP ping, skip", new Object[0]);
                                try {
                                    ALog.d(this.d, "send succ, remove it", new Object[0]);
                                    synchronized (w.this.t) {
                                        w.this.t.remove(message);
                                    }
                                } catch (Throwable th) {
                                    ALog.e(this.d, " run finally error", th, new Object[0]);
                                }
                            } else {
                                if (System.currentTimeMillis() - w.this.B < (f.a(w.this.d).b() - 1) * 1000 && !message.d) {
                                    a(false);
                                    z = true;
                                }
                                String str2 = this.d;
                                Boolean valueOf2 = Boolean.valueOf(message.d);
                                Long valueOf3 = Long.valueOf(System.currentTimeMillis() - w.this.B);
                                Object[] objArr2 = new Object[i];
                                objArr2[0] = "force";
                                objArr2[1] = valueOf2;
                                objArr2[2] = "last ping";
                                objArr2[c] = valueOf3;
                                ALog.d(str2, TUIConstants.TUIChat.METHOD_SEND_MESSAGE, objArr2);
                                a(true);
                                if (w.this.z != null && w.this.s == 1) {
                                    if (System.currentTimeMillis() - w.this.B >= (f.a(w.this.d).b() - 1) * 1000) {
                                        ALog.i(this.d, "sendMessage onSendPing", new Object[0]);
                                        w.this.e.a();
                                        w.this.z.submitPing();
                                        w.this.H.onSendPing();
                                        w.this.B = System.currentTimeMillis();
                                        w.this.C = System.nanoTime();
                                        w.this.f();
                                    }
                                    z = true;
                                }
                                z = false;
                            }
                        } else {
                            if (a2 == 1) {
                                a(true);
                                if (w.this.s == 1 && w.this.z != null) {
                                    w wVar = w.this;
                                    byte[] a3 = message.a(wVar.d, wVar.c);
                                    message.a(System.currentTimeMillis());
                                    if (a3.length > 16384 && message.t.intValue() != 102) {
                                        w.this.e.a(message, AccsErrorCode.MESSAGE_TOO_LARGE);
                                    } else {
                                        if (message.c) {
                                            a = -message.d().a();
                                        } else {
                                            a = message.d().a();
                                        }
                                        w.this.z.sendCustomControlFrame(a, 200, 0, a3.length, a3);
                                        String str3 = this.d;
                                        Integer valueOf4 = Integer.valueOf(a3.length);
                                        String b2 = message.b();
                                        String str4 = w.this.j;
                                        Object[] objArr3 = new Object[6];
                                        objArr3[0] = "length";
                                        objArr3[1] = valueOf4;
                                        objArr3[2] = Constants.KEY_DATA_ID;
                                        objArr3[c] = b2;
                                        objArr3[i] = "utdid";
                                        objArr3[5] = str4;
                                        ALog.i(str3, "send data", objArr3);
                                        w.this.e.a(message);
                                        if (message.c) {
                                            ALog.i(this.d, "sendCFrame end ack", Constants.KEY_DATA_ID, Integer.valueOf(a));
                                            w.this.l.put(Integer.valueOf(a), message);
                                        }
                                        if (message.e() != null) {
                                            message.e().onSendData();
                                        }
                                        w.this.a(message.b(), w.this.i.isQuickReconnect(), message.S);
                                        w.this.e.a(new TrafficsMonitor.a(message.H, GlobalAppRuntimeInfo.isAppBackground(), w.this.r(), a3.length));
                                    }
                                }
                                z = false;
                            } else {
                                a(false);
                                ALog.i(this.d, "skip msg", "type", Integer.valueOf(a2));
                            }
                            z = true;
                        }
                        try {
                            w.this.v();
                            if (!z) {
                                try {
                                    w.this.q();
                                    if (w.this.H != null) {
                                        w.this.H.setCloseReason("send fail");
                                    }
                                    synchronized (w.this.t) {
                                        try {
                                            for (int size = w.this.t.size() - 1; size >= 0; size--) {
                                                Message message3 = (Message) w.this.t.get(size);
                                                if (message3 != null) {
                                                    Integer num2 = message3.t;
                                                    if (num2 != null) {
                                                        if (num2.intValue() != 100 && message3.t.intValue() != 201) {
                                                        }
                                                        w.this.e.a(message3, AccsErrorCode.SPDY_CONNECTION_DISCONNECTED_WHEN_SEND_DATA);
                                                        w.this.t.remove(size);
                                                    }
                                                }
                                            }
                                            ALog.e(this.d, "network disconnected, wait", new Object[0]);
                                            w.this.t.wait();
                                        } finally {
                                        }
                                    }
                                } catch (Throwable th2) {
                                    ALog.e(this.d, " run finally error", th2, new Object[0]);
                                }
                            } else {
                                ALog.d(this.d, "send succ, remove it", new Object[0]);
                                synchronized (w.this.t) {
                                    w.this.t.remove(message);
                                }
                            }
                            ALog.e(this.d, " run finally error", th2, new Object[0]);
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, message.H, MessageService.MSG_DB_NOTIFY_REACHED, w.this.c + th.toString());
                                th.printStackTrace();
                                ALog.e(this.d, "service connection run", th, new Object[0]);
                                if (!z) {
                                    try {
                                        w.this.q();
                                        if (w.this.H != null) {
                                            w.this.H.setCloseReason("send fail");
                                        }
                                        synchronized (w.this.t) {
                                            try {
                                                for (int size2 = w.this.t.size() - 1; size2 >= 0; size2--) {
                                                    Message message4 = (Message) w.this.t.get(size2);
                                                    if (message4 != null) {
                                                        Integer num3 = message4.t;
                                                        if (num3 != null) {
                                                            if (num3.intValue() != 100 && message4.t.intValue() != 201) {
                                                            }
                                                            w.this.e.a(message4, AccsErrorCode.SPDY_CONNECTION_DISCONNECTED_WHEN_SEND_DATA);
                                                            w.this.t.remove(size2);
                                                        }
                                                    }
                                                }
                                                ALog.e(this.d, "network disconnected, wait", new Object[0]);
                                                w.this.t.wait();
                                            } finally {
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        ALog.e(this.d, " run finally error", th4, new Object[0]);
                                    }
                                    message2 = message;
                                    c = 3;
                                    i = 4;
                                } else {
                                    ALog.d(this.d, "send succ, remove it", new Object[0]);
                                    synchronized (w.this.t) {
                                        w.this.t.remove(message);
                                    }
                                    message2 = message;
                                    c = 3;
                                    i = 4;
                                }
                                ALog.e(this.d, " run finally error", th4, new Object[0]);
                                message2 = message;
                                c = 3;
                                i = 4;
                            } catch (Throwable th5) {
                                try {
                                    if (!z) {
                                        w.this.q();
                                        if (w.this.H != null) {
                                            w.this.H.setCloseReason("send fail");
                                        }
                                        synchronized (w.this.t) {
                                            try {
                                                for (int size3 = w.this.t.size() - 1; size3 >= 0; size3--) {
                                                    Message message5 = (Message) w.this.t.get(size3);
                                                    if (message5 != null && (num = message5.t) != null) {
                                                        if (num.intValue() != 100 && message5.t.intValue() != 201) {
                                                        }
                                                        w.this.e.a(message5, AccsErrorCode.SPDY_CONNECTION_DISCONNECTED_WHEN_SEND_DATA);
                                                        w.this.t.remove(size3);
                                                    }
                                                }
                                                ALog.e(this.d, "network disconnected, wait", new Object[0]);
                                                w.this.t.wait();
                                                throw th5;
                                            } finally {
                                            }
                                        }
                                    }
                                    ALog.d(this.d, "send succ, remove it", new Object[0]);
                                    synchronized (w.this.t) {
                                        w.this.t.remove(message);
                                        throw th5;
                                    }
                                } catch (Throwable th6) {
                                    ALog.e(this.d, " run finally error", th6, new Object[0]);
                                    throw th5;
                                }
                                ALog.e(this.d, " run finally error", th6, new Object[0]);
                                throw th5;
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        z = true;
                    }
                }
                message2 = message;
                c = 3;
                i = 4;
            }
            w.this.q();
        }
    }

    public w(Context context, int i, String str) {
        super(context, i, str);
        this.s = 3;
        this.t = new LinkedList<>();
        this.v = true;
        this.y = null;
        this.z = null;
        this.A = new Object();
        this.F = -1;
        this.G = null;
        this.J = false;
        this.K = "";
        this.L = false;
        this.M = new g(r());
        w();
    }

    private int t() {
        boolean k = k();
        if (AccsClientConfig.mEnv == 2) {
            return 0;
        }
        int channelPubKey = this.i.getChannelPubKey();
        if (channelPubKey > 0) {
            ALog.i(d(), "getPublicKeyType use custom pub key", "pubKey", Integer.valueOf(channelPubKey));
            return channelPubKey;
        }
        if (k) {
            return 4;
        }
        return 3;
    }

    private void u() {
        if (this.z == null) {
            c(3);
            return;
        }
        try {
            String encode = URLEncoder.encode(UtilityImpl.getDeviceId(this.d));
            String a2 = UtilityImpl.a(i(), this.i.getAppSecret(), UtilityImpl.getDeviceId(this.d));
            String c = c(this.w);
            ALog.i(d(), BaseMonitor.ALARM_POINT_AUTH, "url", c);
            this.x = c;
            if (!a(encode, i(), a2)) {
                ErrorCode build = AccsErrorCode.SPDY_AUTH_PARAM_ERROR.copy().detail("device " + encode + " key " + i() + " sign " + a2).build();
                ALog.e(d(), "auth param error!", Constants.KEY_HTTP_CODE, build);
                a(build);
                return;
            }
            new URL(c);
            SpdyRequest spdyRequest = new SpdyRequest(new URL(c), SpdyRequest.GET_METHOD, RequestPriority.DEFAULT_PRIORITY, 80000, b.ACCS_RECEIVE_TIMEOUT);
            spdyRequest.setDomain(r());
            this.z.submitRequest(spdyRequest, new SpdyDataProvider((byte[]) null), r(), this);
        } catch (Throwable th) {
            ALog.e(d(), "auth exception ", th, new Object[0]);
            a(AccsErrorCode.SPDY_AUTH_EXCEPTION.copy().detail(AccsErrorCode.getExceptionInfo(th)).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void v() {
        if (this.c == 1) {
            return;
        }
        this.B = System.currentTimeMillis();
        this.C = System.nanoTime();
        f.a(this.d).a();
    }

    private void w() {
        String str;
        try {
            SpdyAgent.enableDebug = true;
            this.y = SpdyAgent.getInstance(this.d, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
            if (SpdyAgent.checkLoadSucc()) {
                com.taobao.accs.utl.f.a();
                if (!k()) {
                    this.y.setAccsSslCallback(new aa(this));
                }
                if (!OrangeAdapter.isTnetLogOff(false)) {
                    if (this.c == 0) {
                        str = "service";
                    } else {
                        str = "inapp";
                    }
                    ALog.d(d(), "into--[setTnetLogPath]", new Object[0]);
                    String d = UtilityImpl.d(this.d, str);
                    ALog.d(d(), "config tnet log path:" + d, new Object[0]);
                    if (!TextUtils.isEmpty(d)) {
                        this.y.configLogFile(d, UtilityImpl.TNET_FILE_SIZE, 5);
                        return;
                    }
                    return;
                }
                return;
            }
            ALog.e(d(), "initClient", new Object[0]);
            com.taobao.accs.utl.f.b();
        } catch (Throwable th) {
            ALog.e(d(), "initClient", th, new Object[0]);
        }
    }

    @Override // org.android.spdy.SessionCb
    public void bioPingRecvCallback(SpdySession spdySession, int i) {
        ALog.w(d(), "bioPingRecvCallback uniId:" + i, new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public byte[] getSSLMeta(SpdySession spdySession) {
        return UtilityImpl.a(this.d, this.b, spdySession.getDomain());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.accs.net.b
    public boolean h() {
        return false;
    }

    @Override // com.taobao.accs.net.b
    public boolean l() {
        if (this.s == 1) {
            return true;
        }
        return false;
    }

    @Override // com.taobao.accs.net.b
    public int m() {
        return 0;
    }

    @Override // com.taobao.accs.net.b
    public void n() {
        q();
    }

    @Override // com.taobao.accs.net.b
    public void o() {
        a(true, false);
    }

    @Override // org.android.spdy.SessionCb
    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        return UtilityImpl.a(this.d, this.b, spdySession.getDomain(), bArr);
    }

    public void q() {
        ALog.e(d(), " force close!", new Object[0]);
        try {
            this.z.closeSession();
            this.H.setCloseType(1);
        } catch (Exception unused) {
        }
        c(3);
    }

    public String r() {
        String channelHost = this.i.getChannelHost();
        ALog.i(d(), "getChannelHost", Constants.KEY_HOST, channelHost);
        if (channelHost == null) {
            return "";
        }
        return channelHost;
    }

    public boolean s() {
        return this.v;
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i, int i2) {
        b(i);
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i, int i2, int i3, int i4, byte[] bArr) {
        String str;
        v();
        ALog.i(d(), "onFrame", "type", Integer.valueOf(i2), "len", Integer.valueOf(bArr.length));
        StringBuilder sb2 = new StringBuilder();
        if (ALog.isPrintLog(ALog.Level.D) && bArr.length < 512) {
            long currentTimeMillis = System.currentTimeMillis();
            for (byte b : bArr) {
                sb2.append(Integer.toHexString(b & 255));
                sb2.append(" ");
            }
            ALog.d(d(), ((Object) sb2) + " log time:" + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
        }
        if (i2 == 200) {
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                this.e.a(bArr);
                com.taobao.accs.ut.a.d g = this.e.g();
                if (g != null) {
                    g.c = String.valueOf(currentTimeMillis2);
                    if (this.c == 0) {
                        str = "service";
                    } else {
                        str = "inapp";
                    }
                    g.g = str;
                    g.a();
                }
            } catch (Throwable th) {
                ALog.e(d(), "onDataReceive ", th, new Object[0]);
                UTMini.getInstance().commitEvent(66001, "SERVICE_DATA_RECEIVE", UtilityImpl.a(th));
            }
            ALog.d(d(), "try handle msg", new Object[0]);
            g();
        } else {
            ALog.e(d(), "drop frame", "len", Integer.valueOf(bArr.length));
        }
        ALog.d(d(), "spdyCustomControlFrameRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j, SpdyByteArray spdyByteArray, Object obj) {
        ALog.d(d(), "spdyDataChunkRecvCB", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataRecvCallback(SpdySession spdySession, boolean z, long j, int i, Object obj) {
        ALog.d(d(), "spdyDataRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataSendCallback(SpdySession spdySession, boolean z, long j, int i, Object obj) {
        ALog.d(d(), "spdyDataSendCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyOnStreamResponse(SpdySession spdySession, long j, Map<String, List<String>> map, Object obj) {
        String str;
        this.B = System.currentTimeMillis();
        this.C = System.nanoTime();
        try {
            Map<String, String> a2 = UtilityImpl.a(map);
            ALog.d("SilenceConn_", "spdyOnStreamResponse", "header", map);
            int parseInt = Integer.parseInt(a2.get(Header.RESPONSE_STATUS_UTF8));
            if (parseInt == 200) {
                ALog.i(d(), "spdyOnStreamResponse", "httpStatusCode", Integer.valueOf(parseInt));
                c(1);
                String str2 = a2.get("x-at");
                if (!TextUtils.isEmpty(str2)) {
                    this.k = str2;
                }
                SessionMonitor sessionMonitor = this.H;
                long j2 = 0;
                if (sessionMonitor.connection_stop_date > 0) {
                    j2 = System.currentTimeMillis() - this.H.connection_stop_date;
                }
                sessionMonitor.auth_time = j2;
                if (this.c == 0) {
                    str = "service";
                } else {
                    str = "inapp";
                }
                UTMini.getInstance().commitEvent(66001, "CONNECTED 200 " + str, this.x, this.K, Integer.valueOf(Constants.SDK_VERSION_CODE), MessageService.MSG_DB_READY_REPORT);
                AppMonitorAdapter.commitAlarmSuccess("accs", BaseMonitor.ALARM_POINT_AUTH, "");
            } else {
                ALog.e(d(), "spdyOnStreamResponse", "httpStatusCode", Integer.valueOf(parseInt));
                a(AccsErrorCode.NETWORKSDK_SPDY_RES_ERROR.copy().detail("channel code " + parseInt).build());
            }
        } catch (Exception e) {
            ALog.e(d(), e.toString(), new Object[0]);
            q();
            this.H.setCloseReason("exception");
        }
        ALog.d(d(), "spdyOnStreamResponse", new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj) {
        ALog.d(d(), "spdyPingRecvCallback uniId:" + j, new Object[0]);
        if (j < 0) {
            return;
        }
        this.e.b();
        f.a(this.d).e();
        f.a(this.d).a();
        this.H.onPingCBReceive();
        if (this.H.ping_rec_times % 2 == 0) {
            UtilityImpl.a(this.d, Constants.SP_KEY_SERVICE_END, System.currentTimeMillis());
        }
    }

    @Override // org.android.spdy.Spdycb
    public void spdyRequestRecvCallback(SpdySession spdySession, long j, Object obj) {
        ALog.d(d(), "spdyRequestRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
        String str;
        ALog.e(d(), "spdySessionCloseCallback", Constants.KEY_ERROR_CODE, Integer.valueOf(i));
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e) {
                ALog.e(d(), "session cleanUp has exception: " + e, new Object[0]);
            }
        }
        c(3);
        this.H.onCloseConnect();
        if (this.H.getConCloseDate() > 0 && this.H.getConStopDate() > 0) {
            this.H.getConCloseDate();
            this.H.getConStopDate();
        }
        this.H.setCloseReason(this.H.getCloseReason() + "tnet error:" + i);
        if (superviseConnectInfo != null) {
            this.H.live_time = superviseConnectInfo.keepalive_period_second;
        }
        AppMonitor.getInstance().commitStat(this.H);
        for (Message message : this.e.e()) {
            if (message.e() != null) {
                message.e().setFailReason("session close");
                AppMonitor.getInstance().commitStat(message.e());
            }
        }
        if (this.c == 0) {
            str = "service";
        } else {
            str = "inapp";
        }
        ALog.d(d(), "spdySessionCloseCallback, conKeepTime:" + this.H.live_time + " connectType:" + str, new Object[0]);
        UTMini uTMini = UTMini.getInstance();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DISCONNECT CLOSE ");
        sb2.append(str);
        uTMini.commitEvent(66001, sb2.toString(), Integer.valueOf(i), Long.valueOf(this.H.live_time), Integer.valueOf(Constants.SDK_VERSION_CODE), this.x, this.K);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        String str;
        this.F = superviseConnectInfo.connectTime;
        int i = superviseConnectInfo.handshakeTime;
        ALog.i(d(), "spdySessionConnectCB", "sessionConnectInterval", Integer.valueOf(this.F), "sslTime", Integer.valueOf(i), "reuse", Integer.valueOf(superviseConnectInfo.sessionTicketReused));
        u();
        this.H.setRet(true);
        this.H.onConnectStop();
        SessionMonitor sessionMonitor = this.H;
        sessionMonitor.tcp_time = this.F;
        sessionMonitor.ssl_time = i;
        if (this.c == 0) {
            str = "service";
        } else {
            str = "inapp";
        }
        UTMini.getInstance().commitEvent(66001, "CONNECTED " + str + " " + superviseConnectInfo.sessionTicketReused, String.valueOf(this.F), String.valueOf(i), Integer.valueOf(Constants.SDK_VERSION_CODE), String.valueOf(superviseConnectInfo.sessionTicketReused), this.x, this.K);
        AppMonitorAdapter.commitAlarmSuccess("accs", BaseMonitor.ALARM_POINT_CONNECT, "");
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionFailedError(SpdySession spdySession, int i, Object obj) {
        int i2;
        String str;
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e) {
                ALog.e(d(), "session cleanUp has exception: " + e, new Object[0]);
            }
        }
        a aVar = this.u;
        if (aVar != null) {
            i2 = aVar.a;
        } else {
            i2 = 0;
        }
        ALog.e(d(), "spdySessionFailedError", "retryTimes", Integer.valueOf(i2), "errorId", Integer.valueOf(i));
        this.J = false;
        this.L = true;
        c(3);
        this.H.setFailReason(i);
        this.H.onConnectStop();
        if (this.c == 0) {
            str = "service";
        } else {
            str = "inapp";
        }
        UTMini.getInstance().commitEvent(66001, "DISCONNECT " + str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(Constants.SDK_VERSION_CODE), this.x, this.K);
        AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_CONNECT, "retrytimes:" + i2, i + "", "");
    }

    @Override // org.android.spdy.Spdycb
    public void spdyStreamCloseCallback(SpdySession spdySession, long j, int i, Object obj, SuperviseData superviseData) {
        ALog.d(d(), "spdyStreamCloseCallback", new Object[0]);
        if (i != 0) {
            ALog.e(d(), "spdyStreamCloseCallback", "statusCode", Integer.valueOf(i));
            a(AccsErrorCode.NETWORKSDK_SPDY_CLOSE_ERROR.copy().detail("channel code " + i).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        SessionInfo sessionInfo;
        int i = this.s;
        if (i == 2 || i == 1) {
            return;
        }
        if (this.M == null) {
            this.M = new g(r());
        }
        List<IConnStrategy> a2 = this.M.a(r());
        if (a2 != null && a2.size() > 0) {
            for (IConnStrategy iConnStrategy : a2) {
                if (iConnStrategy != null) {
                    ALog.i(d(), BaseMonitor.ALARM_POINT_CONNECT, "ip", iConnStrategy.getIp(), "port", Integer.valueOf(iConnStrategy.getPort()));
                }
            }
            if (this.L) {
                this.M.b();
                this.L = false;
            }
            IConnStrategy a3 = this.M.a();
            this.o = a3 == null ? r() : a3.getIp();
            this.p = a3 == null ? Constants.PORT : a3.getPort();
            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_DNS, "httpdns", 0.0d);
            ALog.i(d(), "connect from amdc succ", "ip", this.o, "port", Integer.valueOf(this.p), "originPos", Integer.valueOf(this.M.c()));
        } else {
            if (str != null) {
                this.o = str;
            } else {
                this.o = r();
            }
            this.p = System.currentTimeMillis() % 2 == 0 ? 80 : Constants.PORT;
            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_DNS, "localdns", 0.0d);
            ALog.i(d(), "connect get ip from amdc fail!!", new Object[0]);
        }
        if (Utils.isIPV6Address(this.o)) {
            this.w = "https://[" + this.o + "]:" + this.p + "/accs/";
        } else {
            this.w = "https://" + this.o + ":" + this.p + "/accs/";
        }
        ALog.i(d(), BaseMonitor.ALARM_POINT_CONNECT, "URL", this.w);
        this.N = String.valueOf(System.currentTimeMillis());
        if (this.H != null) {
            AppMonitor.getInstance().commitStat(this.H);
        }
        SessionMonitor sessionMonitor = new SessionMonitor();
        this.H = sessionMonitor;
        sessionMonitor.setConnectType(this.c == 0 ? "service" : "inapp");
        if (this.y != null) {
            try {
                this.D = System.currentTimeMillis();
                this.E = System.nanoTime();
                this.q = UtilityImpl.a(this.d);
                this.r = UtilityImpl.b(this.d);
                this.B = System.currentTimeMillis();
                this.H.onStartConnect();
                c(2);
                synchronized (this.A) {
                    try {
                        try {
                            if (!TextUtils.isEmpty(this.q) && this.r >= 0 && this.J) {
                                ALog.i(d(), BaseMonitor.ALARM_POINT_CONNECT, "proxy", this.q, "port", Integer.valueOf(this.r));
                                sessionInfo = new SessionInfo(this.o, this.p, r() + "_" + this.b, this.q, this.r, this.N, this, 4226);
                                this.K = this.q + ":" + this.r;
                            } else {
                                ALog.i(d(), "connect normal", new Object[0]);
                                sessionInfo = new SessionInfo(this.o, this.p, r() + "_" + this.b, null, 0, this.N, this, 4226);
                                this.K = "";
                            }
                            sessionInfo.setPubKeySeqNum(t());
                            sessionInfo.setConnectionTimeoutMs(b.ACCS_RECEIVE_TIMEOUT);
                            this.z = this.y.createSession(sessionInfo);
                            this.H.connection_stop_date = 0L;
                            this.A.wait();
                        } catch (Throwable th) {
                            throw th;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        this.J = false;
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.taobao.accs.net.b
    public com.taobao.accs.ut.a.c c() {
        if (this.I == null) {
            this.I = new com.taobao.accs.ut.a.c();
        }
        com.taobao.accs.ut.a.c cVar = this.I;
        cVar.b = this.c;
        cVar.d = this.t.size();
        this.I.i = UtilityImpl.g(this.d);
        com.taobao.accs.ut.a.c cVar2 = this.I;
        cVar2.f = this.K;
        cVar2.a = this.s;
        SessionMonitor sessionMonitor = this.H;
        cVar2.c = sessionMonitor != null && sessionMonitor.getRet();
        this.I.j = s();
        com.taobao.accs.ut.a.c cVar3 = this.I;
        com.taobao.accs.data.d dVar = this.e;
        cVar3.e = dVar != null ? dVar.d() : 0;
        com.taobao.accs.ut.a.c cVar4 = this.I;
        cVar4.g = this.x;
        return cVar4;
    }

    @Override // com.taobao.accs.net.b
    public void e() {
        super.e();
        this.v = false;
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new y(this));
        ALog.e(d(), "shut down", new Object[0]);
    }

    @Override // com.taobao.accs.net.b
    public void b() {
        this.J = false;
        this.f = 0;
    }

    @Override // com.taobao.accs.net.b
    public void a() {
        this.v = true;
        ALog.d(d(), "start", new Object[0]);
        a(this.d);
        if (this.u == null) {
            ALog.i(d(), "start thread", new Object[0]);
            a aVar = new a("NetworkThread_" + this.m);
            this.u = aVar;
            aVar.setPriority(2);
            this.u.start();
        }
        a(false, false);
    }

    @Override // com.taobao.accs.net.b
    public String b(String str) {
        return "https://" + this.i.getChannelHost();
    }

    private synchronized void c(int i) {
        ALog.i(d(), "notifyStatus start", "status", a(i));
        if (i == this.s) {
            ALog.d(d(), "ignore notifyStatus", new Object[0]);
            return;
        }
        this.s = i;
        if (i == 1) {
            f.a(this.d).f();
            v();
            ScheduledFuture<?> scheduledFuture = this.n;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            synchronized (this.A) {
                try {
                    this.A.notifyAll();
                } catch (Exception unused) {
                }
            }
            synchronized (this.t) {
                try {
                    this.t.notifyAll();
                } catch (Exception unused2) {
                }
            }
            ALog.i(d(), "notifyStatus end", "status", a(i));
        }
        if (i == 2) {
            ScheduledFuture<?> scheduledFuture2 = this.n;
            if (scheduledFuture2 != null) {
                scheduledFuture2.cancel(true);
            }
            ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new z(this, this.N), 120000L, TimeUnit.MILLISECONDS);
        } else if (i == 3) {
            ALog.w(d(), "notifyStatus", "status", a(i));
            v();
            f.a(this.d).d();
            synchronized (this.A) {
                try {
                    this.A.notifyAll();
                } catch (Exception unused3) {
                }
            }
            this.e.a(AccsErrorCode.SPDY_CON_DISCONNECTED.copy().detail(com.taobao.accs.utl.i.a().b()).build());
            a(false, true);
        }
        ALog.i(d(), "notifyStatus end", "status", a(i));
    }

    @Override // com.taobao.accs.net.b
    protected void a(Message message, boolean z) {
        if (this.v && message != null) {
            try {
                if (ThreadPoolExecutorFactory.getScheduledExecutor().getQueue().size() <= 1000) {
                    ScheduledFuture<?> schedule = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new x(this, message, z), message.Q, TimeUnit.MILLISECONDS);
                    if (message.a() == 1 && message.O != null) {
                        if (message.c()) {
                            a(message.O);
                        }
                        this.e.a.put(message.O, schedule);
                    }
                    if (message.e() != null) {
                        message.e().setDeviceId(UtilityImpl.getDeviceId(this.d));
                        message.e().setConnType(this.c);
                        message.e().onEnterQueueData();
                        return;
                    }
                    return;
                }
                throw new RejectedExecutionException("accs");
            } catch (RejectedExecutionException unused) {
                int size = ThreadPoolExecutorFactory.getScheduledExecutor().getQueue().size();
                this.e.a(message, AccsErrorCode.MESSAGE_QUEUE_FULL.copy().detail("channel " + size).build());
                ALog.e(d(), "send queue full count:" + size, new Object[0]);
                return;
            } catch (Throwable th) {
                ALog.e(d(), "send error", th, new Object[0]);
                this.e.a(message, AccsErrorCode.SEND_LOCAL_EXCEPTION.copy().detail(AccsErrorCode.getExceptionInfo(th)).build());
                return;
            }
        }
        ALog.e(d(), "not running or msg null! " + this.v, new Object[0]);
    }

    @Override // com.taobao.accs.net.b
    public void a(boolean z, boolean z2) {
        ALog.d(d(), "try ping, force:" + z, new Object[0]);
        if (this.c == 1) {
            ALog.d(d(), "INAPP, skip", new Object[0]);
        } else {
            b(Message.a(z, (int) (z2 ? Math.random() * 10.0d * 1000.0d : 0.0d)), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x003a. Please report as an issue. */
    public void a(Message message) {
        if (message.t == null || this.t.size() == 0) {
            return;
        }
        for (int size = this.t.size() - 1; size >= 0; size--) {
            Message message2 = this.t.get(size);
            if (message2 != null && message2.t != null && message2.f().equals(message.f())) {
                switch (message.t.intValue()) {
                    case 1:
                    case 2:
                        if (message2.t.intValue() == 1 || message2.t.intValue() == 2) {
                            this.t.remove(size);
                            break;
                        }
                        break;
                    case 3:
                    case 4:
                        if (message2.t.intValue() == 3 || message2.t.intValue() == 4) {
                            this.t.remove(size);
                            break;
                        }
                        break;
                    case 5:
                    case 6:
                        if (message2.t.intValue() == 5 || message2.t.intValue() == 6) {
                            this.t.remove(size);
                            break;
                        }
                        break;
                }
                ALog.d(d(), "clearRepeatControlCommand message:" + message2.t + "/" + message2.f(), new Object[0]);
            }
        }
        com.taobao.accs.data.d dVar = this.e;
        if (dVar != null) {
            dVar.b(message);
        }
    }

    private boolean a(String str, String str2, String str3) {
        int i = 1;
        if (Utils.getMode(this.d) == 2) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            return true;
        }
        c(3);
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                i = 2;
            } else if (TextUtils.isEmpty(str3)) {
                i = 3;
            }
        }
        this.H.setFailReason(i);
        this.H.onConnectStop();
        String str4 = this.c == 0 ? "service" : "inapp";
        a aVar = this.u;
        int i2 = aVar != null ? aVar.a : 0;
        UTMini.getInstance().commitEvent(66001, "DISCONNECT " + str4, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(Constants.SDK_VERSION_CODE), this.x, this.K);
        AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_CONNECT, "retrytimes:" + i2, i + "", "");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.accs.net.b
    public String d() {
        return "SilenceConn_" + this.m;
    }

    private void a(ErrorCode errorCode) {
        this.k = null;
        q();
        a aVar = this.u;
        int i = aVar != null ? aVar.a : 0;
        this.H.setCloseReason("code not 200 is" + errorCode.getCodeInt());
        this.L = true;
        String str = this.c == 0 ? "service" : "inapp";
        UTMini.getInstance().commitEvent(66001, "CONNECTED NO 200 " + str, errorCode, Integer.valueOf(i), Integer.valueOf(Constants.SDK_VERSION_CODE), this.x, this.K);
        AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_AUTH, "", errorCode + "", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.accs.net.b
    public void a(String str, boolean z, String str2) {
        try {
            c(4);
            q();
            this.H.setCloseReason(str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.taobao.accs.net.b
    public boolean a(String str) {
        boolean z;
        String str2;
        synchronized (this.t) {
            try {
                z = true;
                int size = this.t.size() - 1;
                while (true) {
                    if (size >= 0) {
                        Message message = this.t.get(size);
                        if (message != null && message.a() == 1 && (str2 = message.O) != null && str2.equals(str)) {
                            this.t.remove(size);
                            break;
                        }
                        size--;
                    } else {
                        z = false;
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.accs.net.b
    public void a(Context context) {
        if (this.g) {
            return;
        }
        super.a(context);
        GlobalAppRuntimeInfo.setBackground(false);
        this.g = true;
        ALog.i(d(), "init awcn success!", new Object[0]);
    }
}
