package com.taobao.accs.net;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.Config;
import anet.channel.SessionCenter;
import anet.channel.entity.ENV;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.StrategyTemplate;
import com.alibaba.sdk.android.error.ErrorCode;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.AccsException;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class b {
    public static final int ACCS_RECEIVE_TIMEOUT = 40000;
    public static final int INAPP = 1;
    public static final int SERVICE = 0;
    public String a;
    public String b;
    protected int c;
    protected Context d;
    protected com.taobao.accs.data.d e;
    public com.taobao.accs.client.c h;
    public AccsClientConfig i;
    protected String j;
    public String m;
    private Runnable o;
    private ScheduledFuture<?> p;
    protected int f = 0;
    private long n = 0;
    protected volatile boolean g = false;
    protected String k = null;
    protected LinkedHashMap<Integer, Message> l = new LinkedHashMap<Integer, Message>() { // from class: com.taobao.accs.net.BaseConnection$1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Integer, Message> entry) {
            if (size() > 10) {
                return true;
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, int i, String str) {
        this.b = "";
        this.c = i;
        this.d = context.getApplicationContext();
        AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
        if (configByTag == null) {
            ALog.e(d(), "BaseConnection config null!!", new Object[0]);
            try {
                configByTag = new AccsClientConfig.Builder().setAppKey(ACCSManager.getDefaultAppkey(context)).setTag(str).build();
            } catch (AccsException e) {
                ALog.e(d(), "BaseConnection build config", e, new Object[0]);
            }
        }
        this.m = configByTag.getTag();
        this.b = configByTag.getAppKey();
        this.i = configByTag;
        com.taobao.accs.data.d dVar = new com.taobao.accs.data.d(context, this);
        this.e = dVar;
        dVar.b = this.c;
        ALog.d(d(), "new connection", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(int i) {
        if (i == 1) {
            return "CONNECTED";
        }
        if (i == 2) {
            return "CONNECTING";
        }
        if (i != 4) {
            return "DISCONNECTED";
        }
        return "DISCONNECTING";
    }

    public abstract void a();

    protected abstract void a(Message message, boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(String str, boolean z, String str2);

    public abstract void a(boolean z, boolean z2);

    public abstract boolean a(String str);

    public abstract void b();

    public void b(Message message, boolean z) {
        Object obj;
        long j;
        if (message.a() != 2) {
            obj = "delay";
            j = this.e.d.a(message.H, message.V);
        } else {
            obj = "delay";
            j = 0;
        }
        if (j == -1) {
            ALog.e(d(), "sendMessage ready server limit high", Constants.KEY_DATA_ID, message.q);
            this.e.a(message, AccsErrorCode.SERVIER_HIGH_LIMIT);
            return;
        }
        if (j == -1000) {
            ALog.e(d(), "sendMessage ready server limit high for brush", Constants.KEY_DATA_ID, message.q);
            this.e.a(message, AccsErrorCode.SERVIER_HIGH_LIMIT_BRUSH);
            return;
        }
        if (j > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.n;
            if (currentTimeMillis > j2) {
                message.Q = j;
            } else {
                message.Q = (j2 + j) - System.currentTimeMillis();
            }
            this.n = System.currentTimeMillis() + message.Q;
            ALog.e(d(), "sendMessage ready delayed", Constants.KEY_DATA_ID, message.q, "type", Message.c.b(message.a()), obj, Long.valueOf(message.Q));
        } else if ("accs".equals(message.H)) {
            ALog.i(d(), "sendMessage ready", Constants.KEY_DATA_ID, message.q, "type", Message.c.b(message.a()), obj, Long.valueOf(message.Q));
        } else if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(d(), "sendMessage ready", Constants.KEY_DATA_ID, message.q, "type", Message.c.b(message.a()), obj, Long.valueOf(message.Q));
        }
        try {
            if (TextUtils.isEmpty(this.j)) {
                this.j = UtilityImpl.getDeviceId(this.d);
            }
            if (!message.g()) {
                a(message, z);
            } else {
                this.e.a(message, AccsErrorCode.REQ_TIME_OUT.copy().msg("重试或者延期时超时，不发送").detail(AccsErrorCode.getAllDetails(null)).build());
            }
        } catch (RejectedExecutionException unused) {
            int size = ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size();
            this.e.a(message, AccsErrorCode.MESSAGE_QUEUE_FULL.copy().detail(" " + size).build());
            ALog.e(d(), "sendMessage ready queue full", "size", Integer.valueOf(size));
        }
    }

    public abstract com.taobao.accs.ut.a.c c();

    /* JADX INFO: Access modifiers changed from: protected */
    public String c(String str) {
        String deviceId = UtilityImpl.getDeviceId(this.d);
        try {
            deviceId = URLEncoder.encode(deviceId);
        } catch (Throwable th) {
            ALog.e(d(), "buildAuthUrl", th, new Object[0]);
        }
        String a = UtilityImpl.a(i(), this.i.getAppSecret(), UtilityImpl.getDeviceId(this.d));
        StringBuilder sb2 = new StringBuilder(256);
        sb2.append(str);
        sb2.append("auth?1=");
        sb2.append(deviceId);
        sb2.append("&2=");
        sb2.append(a);
        sb2.append("&3=");
        sb2.append(i());
        if (this.k != null) {
            sb2.append("&4=");
            sb2.append(this.k);
        }
        sb2.append("&5=");
        sb2.append(this.c);
        sb2.append("&6=");
        sb2.append(UtilityImpl.e(this.d));
        sb2.append("&7=");
        sb2.append(UtilityImpl.b());
        sb2.append("&8=");
        sb2.append(this.c == 1 ? "1.1.2" : Integer.valueOf(Constants.SDK_VERSION_CODE));
        sb2.append("&9=");
        sb2.append(System.currentTimeMillis());
        sb2.append("&10=");
        sb2.append(1);
        sb2.append("&11=");
        sb2.append(Build.VERSION.SDK_INT);
        sb2.append("&12=");
        sb2.append(this.d.getPackageName());
        sb2.append("&13=");
        sb2.append(UtilityImpl.i(this.d));
        sb2.append("&14=");
        sb2.append(this.a);
        sb2.append("&15=");
        sb2.append(UtilityImpl.b(Build.MODEL));
        sb2.append("&16=");
        sb2.append(UtilityImpl.b(Build.BRAND));
        sb2.append("&17=");
        sb2.append(Constants.SDK_VERSION_CODE);
        sb2.append("&19=");
        sb2.append(!k() ? 1 : 0);
        sb2.append("&20=");
        sb2.append(this.i.getStoreId());
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String d();

    public void e() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        if (this.o == null) {
            this.o = new d(this);
        }
        g();
        this.p = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.o, 40000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        ScheduledFuture<?> scheduledFuture = this.p;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h() {
        return true;
    }

    public String i() {
        return this.b;
    }

    public com.taobao.accs.client.c j() {
        if (this.h == null) {
            ALog.d(d(), "new ClientManager", Constants.KEY_CONFIG_TAG, this.m);
            this.h = new com.taobao.accs.client.c(this.d, this.m, this.i.getInappHost(), this.b);
        }
        return this.h;
    }

    public boolean k() {
        if (2 == this.i.getSecurity()) {
            return true;
        }
        return false;
    }

    public abstract boolean l();

    public abstract int m();

    public abstract void n();

    public abstract void o();

    public void p() {
        com.taobao.accs.client.c cVar = this.h;
        if (cVar != null) {
            cVar.a();
        }
        this.g = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, boolean z, long j) {
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new c(this, str, j, z), j, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Message message, int i) {
        boolean z;
        int i2;
        try {
            i2 = message.R;
        } catch (Throwable th) {
            th = th;
            z = false;
        }
        if (i2 > 3) {
            return false;
        }
        z = true;
        message.R = i2 + 1;
        message.Q = i;
        ALog.e(d(), "reSend dataid:" + message.q + " retryTimes:" + message.R, new Object[0]);
        b(message, true);
        try {
            if (message.e() != null) {
                message.e().take_date = 0L;
                message.e().to_tnet_date = 0L;
                NetPerformanceMonitor e = message.e();
                int i3 = message.R;
                e.retry_times = i3;
                if (i3 == 1) {
                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "total", 0.0d);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            ALog.e(d(), "reSend error", th, new Object[0]);
            this.e.a(message, AccsErrorCode.SEND_LOCAL_EXCEPTION.copy().detail(AccsErrorCode.getExceptionInfo(th)).build());
            return z;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Context context) {
        try {
            ENV env = ENV.ONLINE;
            int i = AccsClientConfig.mEnv;
            if (i == 2) {
                env = ENV.TEST;
                SessionCenter.switchEnvironment(env);
            } else if (i == 1) {
                env = ENV.PREPARE;
                SessionCenter.switchEnvironment(env);
            }
            try {
                AwcnConfig.setSendConnectInfoByService(false);
            } catch (Throwable unused) {
            }
            SessionCenter.init(context, new Config.Builder().setAppkey(this.b).setAppSecret(this.i.getAppSecret()).setAuthCode(this.i.getAuthCode()).setEnv(env).setTag(this.i.getAppKey()).build());
            String str = "acs";
            if (this.i.getInappPubKey() == 10 || this.i.getInappPubKey() == 11) {
                str = AgooConstants.MESSAGE_BODY_OPEN;
            }
            StrategyTemplate.getInstance().registerConnProtocol(this.i.getInappHost(), ConnProtocol.valueOf("http2", "0rtt", str, false));
        } catch (Throwable th) {
            ALog.e(d(), "initAwcn", th, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i) {
        if (i < 0) {
            ALog.e(d(), "reSendAck", Constants.KEY_DATA_ID, Integer.valueOf(i));
            Message message = this.l.get(Integer.valueOf(i));
            if (message != null) {
                a(message, 5000);
                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, BaseMonitor.COUNT_ACK, 0.0d);
            }
        }
    }

    public String b(String str) {
        String inappHost = this.i.getInappHost();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("https://");
        sb2.append(TextUtils.isEmpty(str) ? "" : str);
        sb2.append(inappHost);
        String sb3 = sb2.toString();
        try {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("https://");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb4.append(str);
            sb4.append(inappHost);
            return sb4.toString();
        } catch (Throwable th) {
            ALog.e("InAppConnection", "getHost", th, new Object[0]);
            return sb3;
        }
    }

    public void b(Context context) {
        try {
            ThreadPoolExecutorFactory.schedule(new e(this, context), 10000L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            ALog.w(d(), "startChannelService", th, new Object[0]);
        }
    }

    public void a(Message message, ErrorCode errorCode) {
        this.e.a(message, errorCode);
    }
}
