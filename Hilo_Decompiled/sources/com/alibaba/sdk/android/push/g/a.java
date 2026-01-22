package com.alibaba.sdk.android.push.g;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import anet.channel.AwcnConfig;
import anet.channel.request.Request;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.AppLifecycle;
import anetwork.channel.http.NetworkSdkSetting;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import com.alibaba.sdk.android.ams.common.util.StringUtil;
import com.alibaba.sdk.android.error.ErrorCode;
import com.alibaba.sdk.android.push.CommonCallback;
import com.alibaba.sdk.android.push.PushControlService;
import com.alibaba.sdk.android.push.common.util.AppInfoUtil;
import com.alibaba.sdk.android.tbrest.rest.RestUrlWrapper;
import com.facebook.internal.ServerProtocol;
import com.qiahao.base_common.network.BaseServer;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsException;
import com.taobao.accs.AccsState;
import com.taobao.accs.ConnectionListener;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.agoo.IRegister;
import com.taobao.agoo.TaobaoRegister;
import com.ut.device.UTDevice;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static final AmsLogger f٦٦٦٠e = AmsLogger.getLogger("MPS:AppRegister");

    /* renamed from: f, reason: collision with root package name */
    private static a f٦٦٦١f = null;

    /* renamed from: g, reason: collision with root package name */
    private static final IntentFilter f٦٦٦٢g = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");

    /* renamed from: h, reason: collision with root package name */
    private static final IntentFilter f٦٦٦٣h = new IntentFilter("android.intent.action.USER_PRESENT");

    /* renamed from: a, reason: collision with root package name */
    volatile HandlerThreadC٠٠٨٣a<d> f٦٦٦٤a;

    /* renamed from: i, reason: collision with root package name */
    private final b f٦٦٦٨i = new b();

    /* renamed from: b, reason: collision with root package name */
    volatile boolean f٦٦٦٥b = false;

    /* renamed from: c, reason: collision with root package name */
    volatile boolean f٦٦٦٦c = false;

    /* renamed from: d, reason: collision with root package name */
    volatile boolean f٦٦٦٧d = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.sdk.android.push.g.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class HandlerThreadC٠٠٨٣a<Token> extends HandlerThread {

        /* renamed from: a, reason: collision with root package name */
        Handler f٦٦٧٥a;

        /* renamed from: b, reason: collision with root package name */
        Handler f٦٦٧٦b;

        /* renamed from: c, reason: collision with root package name */
        c<Token> f٦٦٧٧c;

        /* renamed from: d, reason: collision with root package name */
        volatile int f٦٦٧٨d;

        /* renamed from: e, reason: collision with root package name */
        int f٦٦٧٩e;

        /* renamed from: g, reason: collision with root package name */
        private Token f٦٦٨١g;

        public HandlerThreadC٠٠٨٣a() {
            super("ConnectionWorker");
            this.f٦٦٧٨d = 0;
            this.f٦٦٧٩e = 0;
        }

        private e b(Context context) {
            String str;
            a.f٦٦٦٠e.d("initAccsChannel...");
            NetworkSdkSetting.init(context.getApplicationContext());
            com.alibaba.sdk.android.ams.common.b.b a10 = com.alibaba.sdk.android.ams.common.b.c.a();
            String a11 = a10.a();
            String d10 = a10.d();
            AmsLogger.getImportantLogger().i("register agoo appkey:" + a11);
            final com.alibaba.sdk.android.push.f.b bVar = new com.alibaba.sdk.android.push.f.b();
            final e[] eVarArr = {null};
            try {
                a.f٦٦٦٠e.d("init aliyun accs. context:" + context.getPackageName() + " -- appkey:" + a11);
                ACCSClient.getAccsClient("AliyunPush").cleanLocalBindInfo();
                AppLifecycle.onForeground();
                TaobaoRegister.register(context.getApplicationContext(), "AliyunPush", a11, d10, "aliyun", new IRegister() { // from class: com.alibaba.sdk.android.push.g.a.a.2
                    public void onFailure(String str2, String str3) {
                        AmsLogger.getImportantLogger().i("agoo errorcode:" + str2 + ";errorMsg:" + str3);
                        eVarArr[0] = new e(com.alibaba.sdk.android.push.common.a.d.a(str2, str3).detail("register").build());
                        bVar.a();
                    }

                    public void onSuccess(String str2) {
                        AmsLogger.getImportantLogger().i("agoo init success.");
                        HandlerThreadC٠٠٨٣a.this.f٦٦٧٩e = 2;
                        eVarArr[0] = new e(com.alibaba.sdk.android.push.common.a.d.f٦٥٨٩a);
                        bVar.a();
                    }
                });
            } catch (Throwable th) {
                a.f٦٦٦٠e.e("accs config failed", th);
                eVarArr[0] = new e(com.alibaba.sdk.android.push.common.a.d.f٦٥٩٩k.copy().msg(th.getMessage()).detail(Log.getStackTraceString(th)).build());
                bVar.a();
            }
            if (!com.alibaba.sdk.android.push.common.util.c.a(context.getApplicationContext())) {
                a.this.f٦٦٦٧d = true;
                a.f٦٦٦٠e.d("not main process");
                return new e(com.alibaba.sdk.android.push.common.a.d.f٦٦٠٢n);
            }
            a.f٦٦٦٠e.d("lock" + bVar.toString());
            bVar.a(150);
            if (eVarArr[0] == null) {
                try {
                    str = AccsState.getInstance().getStateByKey("re");
                } catch (Exception unused) {
                    str = "accs time out";
                }
                eVarArr[0] = new e(com.alibaba.sdk.android.push.common.a.d.f٦٦٠٣o.copy().msg(str).detail("connected:" + a.this.c()).build());
            }
            AmsLogger.getImportantLogger().d("register agoo result " + eVarArr[0].a());
            return eVarArr[0];
        }

        private String c() {
            com.alibaba.sdk.android.ams.common.b.b a10 = com.alibaba.sdk.android.ams.common.b.c.a();
            String i10 = com.alibaba.sdk.android.ams.common.a.a.i();
            Context b10 = com.alibaba.sdk.android.ams.common.a.a.b();
            HttpURLConnection httpURLConnection = null;
            try {
                try {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("appKey", a10.a());
                        hashMap.put(DispatchConstants.DEVICEID, UTDevice.getUtdid(b10));
                        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "3.8.6.1");
                        hashMap.put(RestUrlWrapper.FIELD_UTDID, UTDevice.getUtdid(b10));
                        hashMap.put("os", "2");
                        hashMap.put("package", com.alibaba.sdk.android.ams.common.a.a.k());
                        try {
                            HttpURLConnection a11 = com.alibaba.sdk.android.ams.common.util.a.a(i10, com.alibaba.sdk.android.ams.common.util.c.a(hashMap), Request.Method.POST);
                            if (a11 == null) {
                                a.f٦٦٦٠e.e("failed to loadConfigFromRemote!");
                                throw new com.alibaba.sdk.android.push.common.util.a.a(com.alibaba.sdk.android.push.common.a.d.f٦٦٠٤p.copy().msg("getDeviceId创建请求连接失败").build());
                            }
                            String a12 = i.a(com.alibaba.sdk.android.push.common.util.a.d.CONFIG.a(), a11);
                            a11.disconnect();
                            return a12;
                        } catch (IOException e10) {
                            throw new com.alibaba.sdk.android.push.b.f(com.alibaba.sdk.android.push.common.a.d.f٦٦٠٤p.copy().msg(e10.getMessage()).detail(Log.getStackTraceString(e10)).build());
                        }
                    } catch (com.alibaba.sdk.android.push.b.f e11) {
                        throw e11;
                    }
                } catch (Throwable th) {
                    a.f٦٦٦٠e.w("loadConfigFromRemote failed! error:", th);
                    throw new com.alibaba.sdk.android.push.b.f(com.alibaba.sdk.android.push.common.a.d.f٦٥٩٩k.copy().msg(th.getMessage()).detail(Log.getStackTraceString(th)).build());
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    httpURLConnection.disconnect();
                }
                throw th2;
            }
        }

        @Override // android.os.HandlerThread
        @SuppressLint({"HandlerLeak"})
        protected void onLooperPrepared() {
            this.f٦٦٧٦b = new Handler(Looper.getMainLooper());
            this.f٦٦٧٥a = new Handler() { // from class: com.alibaba.sdk.android.push.g.a.a.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    final e a10;
                    int i10 = message.what;
                    if (i10 == 1 || i10 == 2) {
                        final Object obj = message.obj;
                        a.f٦٦٦٠e.d("Looping handleMessage: " + message.what);
                        if (message.what == 1) {
                            removeMessages(2);
                        }
                        if (a.this.f٦٦٦٧d || (a10 = HandlerThreadC٠٠٨٣a.this.a((HandlerThreadC٠٠٨٣a) obj)) == null) {
                            return;
                        }
                        if (!HandlerThreadC٠٠٨٣a.this.a(a10) || HandlerThreadC٠٠٨٣a.this.f٦٦٧٨d <= 1) {
                            HandlerThreadC٠٠٨٣a.this.f٦٦٧٦b.post(new Runnable() { // from class: com.alibaba.sdk.android.push.g.a.a.1.1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // java.lang.Runnable
                                public void run() {
                                    HandlerThreadC٠٠٨٣a.this.f٦٦٧٧c.a(obj, a10);
                                }
                            });
                        }
                    }
                }
            };
            a.f٦٦٦٠e.d("Looping Prepared.");
            a.this.f٦٦٦٥b = true;
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Finally extract failed */
        public e a(Token token) {
            e eVar;
            Context b10 = com.alibaba.sdk.android.ams.common.a.a.b();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    if (!com.alibaba.sdk.android.push.common.util.c.a(b10.getApplicationContext())) {
                        this.f٦٦٧٩e = 2;
                        e eVar2 = new e(com.alibaba.sdk.android.push.common.a.d.f٦٥٨٩a);
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        try {
                            a.f٦٦٦٠e.i("connState=" + this.f٦٦٧٩e + ";estimatedTime=" + currentTimeMillis2 + ";response{msg: " + eVar2.a().getMsg() + ", code: " + eVar2.a().getCode() + "}", null, 1);
                        } catch (Exception e10) {
                            a.f٦٦٦٠e.e("ut log error", e10);
                        }
                        return eVar2;
                    }
                    if (this.f٦٦٧٩e == 0) {
                        a.f٦٦٦٠e.d("is debug：" + com.alibaba.sdk.android.push.common.a.b.d());
                        if (com.alibaba.sdk.android.push.common.a.b.d()) {
                            a.this.j();
                            a.this.i();
                        }
                        a(b10);
                    }
                    if (com.alibaba.sdk.android.ams.common.a.a.h() && !com.alibaba.sdk.android.ams.common.a.a.c() && !com.alibaba.sdk.android.push.notification.e.a(b10)) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        while (!com.alibaba.sdk.android.push.notification.e.a(b10) && SystemClock.elapsedRealtime() - elapsedRealtime < BaseServer.TIMEOUT_DEBUG) {
                            Thread.sleep(1000L);
                            a.f٦٦٦٠e.d("wait for app come to foreground");
                        }
                        try {
                            if (!com.alibaba.sdk.android.push.notification.e.a(b10)) {
                                AwcnConfig.setIpv6Enable(false);
                                a.f٦٦٦٠e.d("APP is background, disable ipv6 test");
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    int i10 = this.f٦٦٧٩e;
                    if (i10 == 1) {
                        a.f٦٦٦٠e.d("accs init.");
                        e b11 = b(b10);
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (b11 != null) {
                            try {
                                a.f٦٦٦٠e.i("connState=" + this.f٦٦٧٩e + ";estimatedTime=" + currentTimeMillis3 + ";response{msg: " + b11.a().getMsg() + ", code: " + b11.a().getCode() + "}", null, 1);
                            } catch (Exception e11) {
                                a.f٦٦٦٠e.e("ut log error", e11);
                            }
                        }
                        return b11;
                    }
                    if (i10 == 2) {
                        a.f٦٦٦٠e.d("accs connected.setBindStop.");
                        eVar = null;
                    } else {
                        a.f٦٦٦٠e.e("cant entry this block...");
                        eVar = new e(com.alibaba.sdk.android.push.common.a.d.f٦٦٠٠l);
                    }
                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                    if (eVar != null) {
                        try {
                            a.f٦٦٦٠e.i("connState=" + this.f٦٦٧٩e + ";estimatedTime=" + currentTimeMillis4 + ";response{msg: " + eVar.a().getMsg() + ", code: " + eVar.a().getCode() + "}", null, 1);
                        } catch (Exception e12) {
                            a.f٦٦٦٠e.e("ut log error", e12);
                        }
                    }
                    return eVar;
                } catch (Throwable th) {
                    System.currentTimeMillis();
                    throw th;
                }
            } catch (com.alibaba.sdk.android.push.b.f e13) {
                a.f٦٦٦٠e.d("Catch StopProcessException: " + e13.a() + " stack:" + Log.getStackTraceString(e13));
                e eVar3 = new e(e13.a());
                long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                try {
                    a.f٦٦٦٠e.i("connState=" + this.f٦٦٧٩e + ";estimatedTime=" + currentTimeMillis5 + ";response{msg: " + eVar3.a().getMsg() + ", code: " + eVar3.a().getCode() + "}", null, 1);
                } catch (Exception e14) {
                    a.f٦٦٦٠e.e("ut log error", e14);
                }
                return eVar3;
            } catch (Throwable th2) {
                a.f٦٦٦٠e.d("Catch RuntimeException: " + th2.getMessage());
                e eVar4 = new e(com.alibaba.sdk.android.push.common.a.d.f٦٥٩٩k.copy().msg(th2.getMessage()).detail(Log.getStackTraceString(th2)).build());
                long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                try {
                    a.f٦٦٦٠e.i("connState=" + this.f٦٦٧٩e + ";estimatedTime=" + currentTimeMillis6 + ";response{msg: " + eVar4.a().getMsg() + ", code: " + eVar4.a().getCode() + "}", null, 1);
                } catch (Exception e15) {
                    a.f٦٦٦٠e.e("ut log error", e15);
                }
                return eVar4;
            }
        }

        public void b() {
            this.f٦٦٧٥a.removeMessages(1);
            this.f٦٦٧٥a.removeMessages(2);
        }

        public synchronized void a() {
            try {
                this.f٦٦٧٨d = 0;
                if (a.this.f٦٦٦٧d) {
                    if (this.f٦٦٧٩e != 2) {
                    }
                }
                Handler handler = this.f٦٦٧٥a;
                if (handler != null) {
                    handler.sendMessage(handler.obtainMessage(1, this.f٦٦٨١g));
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        private void a(Context context) {
            a.f٦٦٦٠e.d("load utdid: " + UTDevice.getUtdid(context));
            com.alibaba.sdk.android.ams.common.b.b a10 = com.alibaba.sdk.android.ams.common.b.c.a();
            String c10 = a10.c();
            a.f٦٦٦٠e.d("vip init.");
            String b10 = a10.b();
            if (!StringUtil.isEmpty(b10) && !StringUtil.isBlank(c10) && c10.equals(UTDevice.getUtdid(context))) {
                AmsLogger.getImportantLogger().i("Got deviceId from preference: " + b10);
                this.f٦٦٧٩e = 1;
                return;
            }
            String c11 = c();
            AmsLogger.getImportantLogger().i("Got deviceId from remote server: " + c11);
            if (StringUtil.isEmpty(c11)) {
                throw new com.alibaba.sdk.android.push.b.f(com.alibaba.sdk.android.push.common.a.d.f٦٥٩٥g.copy().msg("获取设备ID失败").detail("getDeviceIdFromServer").build());
            }
            a10.a(c11);
            a10.b(UTDevice.getUtdid(context));
            this.f٦٦٧٩e = 1;
            AmsLogger.getImportantLogger().i("vip init success");
        }

        public void a(c<Token> cVar) {
            this.f٦٦٧٧c = cVar;
        }

        public synchronized boolean a(e eVar) {
            if (this.f٦٦٧٩e == 2 || this.f٦٦٧٨d >= 5) {
                return false;
            }
            a.f٦٦٦٠e.d("init retry:" + this.f٦٦٧٨d);
            this.f٦٦٧٨d = this.f٦٦٧٨d + 1;
            Handler handler = this.f٦٦٧٥a;
            if (handler != null) {
                handler.sendMessageDelayed(handler.obtainMessage(2, this.f٦٦٨١g), ((int) Math.pow(3.0d, this.f٦٦٧٨d)) * 5000);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    if (intent.getBooleanExtra("noConnectivity", false)) {
                        a.f٦٦٦٠e.e("Network has lost");
                        return;
                    } else if (a.this.f٦٦٦٧d || !a.this.f٦٦٦٥b) {
                        return;
                    }
                } else if (!"android.intent.action.USER_PRESENT".equals(intent.getAction()) || !com.alibaba.sdk.android.push.common.util.a.a(context) || a.this.f٦٦٦٧d || !a.this.f٦٦٦٥b) {
                    return;
                }
                a.this.f٦٦٦٤a.a();
            }
        }
    }

    private a() {
    }

    public static a a() {
        if (f٦٦٦١f == null) {
            synchronized (a.class) {
                try {
                    if (f٦٦٦١f == null) {
                        f٦٦٦١f = new a();
                    }
                } finally {
                }
            }
        }
        return f٦٦٦١f;
    }

    private void h() {
        Context b10 = com.alibaba.sdk.android.ams.common.a.a.b();
        if (com.alibaba.sdk.android.push.common.util.c.a(b10)) {
            try {
                b10.registerReceiver(this.f٦٦٦٨i, f٦٦٦٢g);
                b10.registerReceiver(this.f٦٦٦٨i, f٦٦٦٣h);
            } catch (Exception e10) {
                f٦٦٦٠e.e("Fail to register broad", e10);
            }
        }
        if (AdapterUtilityImpl.isChannelProcess(b10)) {
            com.alibaba.sdk.android.push.c.a.a(b10);
            com.alibaba.sdk.android.push.c.a.a().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        String e10 = com.alibaba.sdk.android.ams.common.b.c.a().e();
        if (StringUtil.isEmpty(e10) || e10.length() > 32) {
            throw new com.alibaba.sdk.android.push.b.f(com.alibaba.sdk.android.push.common.a.d.f٦٦٠٦r);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        for (com.alibaba.sdk.android.push.common.a.a aVar : com.alibaba.sdk.android.push.common.a.a.values()) {
            if (!AppInfoUtil.isComponentExists(com.alibaba.sdk.android.ams.common.a.a.b(), aVar.a(), aVar.b())) {
                if (aVar.c()) {
                    throw new com.alibaba.sdk.android.push.b.f(com.alibaba.sdk.android.push.common.a.d.f٦٦٠٧s.copy().msg(aVar.a() + "未配置").build());
                }
                f٦٦٦٠e.w("未配置" + aVar.a() + "; 建议配置,可有效提高推送到达率");
            }
        }
    }

    public void b() {
        b(false, 0L);
    }

    public boolean c() {
        try {
            return ACCSClient.getAccsClient("AliyunPush").isConnected();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void d() {
        try {
            ACCSClient.getAccsClient("AliyunPush").reconnect();
        } catch (AccsException e10) {
            e10.printStackTrace();
        }
    }

    public void e() {
        TaobaoRegister.reset();
        this.f٦٦٦٦c = false;
    }

    public void f() {
        try {
            ACCSClient.getAccsClient("AliyunPush").disconnect();
        } catch (AccsException e10) {
            e10.printStackTrace();
        }
    }

    public synchronized void a(final CommonCallback commonCallback) {
        if (this.f٦٦٦٦c) {
            AmsLogger.getImportantLogger().d("Already startReg, skip.");
            if (commonCallback != null) {
                ErrorCode errorCode = com.alibaba.sdk.android.push.common.a.d.f٦٦١١w;
                commonCallback.onFailed(errorCode.getCode(), errorCode.getMsg());
            }
            return;
        }
        this.f٦٦٦٦c = true;
        h();
        this.f٦٦٦٧d = false;
        if (this.f٦٦٦٤a != null) {
            try {
                this.f٦٦٦٤a.quitSafely();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        this.f٦٦٦٤a = new HandlerThreadC٠٠٨٣a<>();
        this.f٦٦٦٤a.a(new c<d>() { // from class: com.alibaba.sdk.android.push.g.a.2
            @Override // com.alibaba.sdk.android.push.g.c
            public void a(d dVar, e eVar) {
                if (eVar.a().getCode().equals(com.alibaba.sdk.android.push.common.a.d.f٦٥٨٩a.getCode())) {
                    synchronized (a.class) {
                        a.this.f٦٦٦٧d = true;
                        a.this.f٦٦٦٥b = false;
                        a.this.f٦٦٦٤a.b();
                        a.this.f٦٦٦٤a.quit();
                    }
                }
                com.alibaba.sdk.android.push.g.b.a(commonCallback, eVar);
            }
        });
        this.f٦٦٦٤a.start();
        f٦٦٦٠e.d("getLooper called.");
    }

    private void b(boolean z10, long j10) {
        Context b10 = com.alibaba.sdk.android.ams.common.a.a.b();
        final com.alibaba.sdk.android.ams.common.b.b a10 = com.alibaba.sdk.android.ams.common.b.c.a();
        String a11 = a10.a();
        AmsLogger.getImportantLogger().i("init agoo config appkey:" + a11);
        String d10 = a10.d();
        if (!TextUtils.isEmpty(com.alibaba.sdk.android.ams.common.a.a.g())) {
            DispatchConstants.setAmdcServerDomain(new String[]{com.alibaba.sdk.android.ams.common.a.a.g(), com.alibaba.sdk.android.ams.common.a.a.g(), com.alibaba.sdk.android.ams.common.a.a.g()});
        }
        if (com.alibaba.sdk.android.ams.common.a.a.h()) {
            try {
                AwcnConfig.setWifiInfoEnable(false);
            } catch (Throwable unused) {
            }
            try {
                AwcnConfig.setCarrierInfoEnable(false);
            } catch (Throwable unused2) {
            }
            try {
                AmdcRuntimeInfo.setForceHttps(true);
            } catch (Throwable unused3) {
            }
        }
        try {
            AwcnConfig.setAccsSessionCreateForbiddenInBg(false);
        } catch (Throwable unused4) {
        }
        try {
            TaobaoRegister.setEnv(b10, 0);
            AccsClientConfig build = new AccsClientConfig.Builder().setAppKey(a11).setAppSecret(d10).setTag("AliyunPush").setInappHost(com.alibaba.sdk.android.ams.common.a.a.e()).setChannelHost(com.alibaba.sdk.android.ams.common.a.a.f()).setAccsHeartbeatEnable(true).setConfigEnv(0).loopChannelStart(z10).loopChannelInterval(j10).build();
            TaobaoRegister.setAccsConfigTag(b10, "AliyunPush");
            ACCSClient.init(b10, build);
            TaobaoRegister.setReportPushArrive(new com.aliyun.ams.emas.push.d() { // from class: com.alibaba.sdk.android.push.g.a.1
                @Override // com.aliyun.ams.emas.push.d
                public void reportPushArrive(Context context, String str, int i10) {
                    com.alibaba.sdk.android.push.d.a a12 = com.alibaba.sdk.android.push.d.a.a(context);
                    if (a12 != null) {
                        a12.a(a10.b(), str, i10);
                    }
                }
            });
        } catch (AccsException e10) {
            e10.printStackTrace();
        }
    }

    public void a(final PushControlService.ConnectionChangeListener connectionChangeListener) {
        try {
            ACCSClient.getAccsClient("AliyunPush").addConnectionListener(new ConnectionListener() { // from class: com.alibaba.sdk.android.push.g.a.3
                public void onConnect() {
                    connectionChangeListener.onConnect();
                }

                public void onDisconnect(int i10, String str) {
                    ErrorCode build = com.alibaba.sdk.android.push.common.a.d.a(i10, str).build();
                    connectionChangeListener.onDisconnect(build.getCode(), build.getMsg());
                }
            });
        } catch (AccsException e10) {
            e10.printStackTrace();
        }
    }

    public void a(boolean z10, long j10) {
        b(z10, j10);
    }
}
