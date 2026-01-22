package com.taobao.accs.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.IChannelInit;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import com.taobao.accs.data.g;
import com.taobao.accs.messenger.MessengerService;
import com.taobao.accs.net.w;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.f;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.android.agoo.message.MessageService;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ServiceImpl extends d {
    private Service b;
    private Context c;
    private long d;
    private String e;

    public ServiceImpl(Service service) {
        super(service);
        this.e = UtilityImpl.NET_TYPE_UNKNOWN;
        this.b = service;
        this.c = service.getApplicationContext();
    }

    private void b(Intent intent) {
        Message message;
        Message.ReqType reqType;
        URL url;
        Message a;
        int intExtra = intent.getIntExtra("command", -1);
        ALog.i("ServiceImpl", "handleCommand", "command", Integer.valueOf(intExtra));
        String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
        String stringExtra2 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
        String stringExtra3 = intent.getStringExtra(Constants.KEY_USER_ID);
        String stringExtra4 = intent.getStringExtra(Constants.KEY_APP_KEY);
        String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
        String stringExtra6 = intent.getStringExtra(Constants.KEY_TTID);
        intent.getStringExtra(Constants.KEY_SID);
        intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
        if (intExtra == 201) {
            a(Message.a(true, 0), true);
            d();
        }
        if (intExtra <= 0 || TextUtils.isEmpty(stringExtra)) {
            return;
        }
        com.taobao.accs.net.b a2 = d.a(this.c, stringExtra5, true);
        if (a2 != null) {
            a2.a();
            if (intExtra != 1) {
                message = null;
                if (intExtra == 2) {
                    ALog.e("ServiceImpl", "onHostStartCommand COMMAND_UNBIND_APP", new Object[0]);
                    if (a2.j().e(stringExtra)) {
                        Message a3 = Message.a(a2, stringExtra);
                        ALog.i("ServiceImpl", stringExtra + " isAppUnbinded", new Object[0]);
                        a2.a(a3, AccsErrorCode.SUCCESS);
                        return;
                    }
                } else if (intExtra == 5) {
                    message = Message.a(stringExtra, stringExtra2);
                } else if (intExtra == 6) {
                    message = Message.b(stringExtra, stringExtra2);
                } else if (intExtra == 3) {
                    message = Message.c(stringExtra, stringExtra3);
                } else if (intExtra == 4) {
                    message = Message.a(stringExtra);
                } else if (intExtra == 100) {
                    byte[] byteArrayExtra = intent.getByteArrayExtra("data");
                    String stringExtra7 = intent.getStringExtra(Constants.KEY_DATA_ID);
                    String stringExtra8 = intent.getStringExtra(Constants.KEY_TARGET);
                    String stringExtra9 = intent.getStringExtra(Constants.KEY_BUSINESSID);
                    String stringExtra10 = intent.getStringExtra(Constants.KEY_EXT_TAG);
                    try {
                        reqType = (Message.ReqType) intent.getSerializableExtra(Constants.KEY_SEND_TYPE);
                    } catch (Exception unused) {
                        reqType = null;
                    }
                    if (byteArrayExtra != null) {
                        try {
                            url = new URL("https://" + ((w) a2).r());
                        } catch (Exception unused2) {
                            url = null;
                        }
                        ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(stringExtra3, stringExtra2, byteArrayExtra, stringExtra7, stringExtra8, url, stringExtra9);
                        accsRequest.setTag(stringExtra10);
                        if (reqType == null) {
                            a = Message.a(a2, this.c, stringExtra, accsRequest, false);
                        } else if (reqType == Message.ReqType.REQ) {
                            a = Message.a(a2, this.c, stringExtra, Constants.TARGET_SERVICE_PRE, accsRequest, false);
                        }
                        message = a;
                    }
                } else if (intExtra == 106) {
                    intent.setAction(Constants.ACTION_RECEIVE);
                    intent.putExtra("command", -1);
                    g.a(this.c, intent);
                    return;
                }
            } else {
                if (!stringExtra.equals(this.c.getPackageName())) {
                    ALog.e("ServiceImpl", "handleCommand bindapp pkg error", new Object[0]);
                    return;
                }
                message = Message.a(this.c, stringExtra5, stringExtra4, intent.getStringExtra("app_sercet"), stringExtra, stringExtra6, intent.getStringExtra(Constants.KEY_APP_VERSION));
                a2.a = stringExtra6;
                UtilityImpl.e(this.c, stringExtra4);
                if (a2.j().d(stringExtra) && !intent.getBooleanExtra(Constants.KEY_FOUCE_BIND, false)) {
                    ALog.i("ServiceImpl", stringExtra + " isAppBinded", new Object[0]);
                    a2.a(message, AccsErrorCode.SUCCESS);
                    return;
                }
            }
            if (message != null) {
                ALog.d("ServiceImpl", "try send message", new Object[0]);
                if (message.e() != null) {
                    message.e().onSend();
                }
                a2.b(message, true);
                return;
            }
            ALog.e("ServiceImpl", "message is null", new Object[0]);
            a2.a(Message.a(stringExtra, intExtra), AccsErrorCode.PARAMETER_ERROR);
            return;
        }
        ALog.e("ServiceImpl", "no connection", Constants.KEY_CONFIG_TAG, stringExtra5, "command", Integer.valueOf(intExtra));
    }

    private void c() {
        ConcurrentHashMap<String, com.taobao.accs.net.b> concurrentHashMap = d.a;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            Iterator<Map.Entry<String, com.taobao.accs.net.b>> it = d.a.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().b();
            }
        }
    }

    private void d() {
        ConcurrentHashMap<String, com.taobao.accs.net.b> concurrentHashMap = d.a;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            Iterator<Map.Entry<String, com.taobao.accs.net.b>> it = d.a.entrySet().iterator();
            while (it.hasNext()) {
                com.taobao.accs.ut.a.c c = it.next().getValue().c();
                if (c != null) {
                    c.h = this.d;
                    c.a();
                }
            }
        }
    }

    private void e() {
        ConcurrentHashMap<String, com.taobao.accs.net.b> concurrentHashMap = d.a;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            Iterator<Map.Entry<String, com.taobao.accs.net.b>> it = d.a.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().e();
            }
        }
    }

    @Override // com.taobao.accs.internal.d
    public int a(Intent intent) {
        String action;
        Bundle extras;
        int i = 1;
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i("ServiceImpl", "onHostStartCommand", MessengerService.INTENT, intent);
        }
        try {
            if (ALog.isPrintLog(ALog.Level.D) && intent != null && (extras = intent.getExtras()) != null) {
                for (String str : extras.keySet()) {
                    ALog.d("ServiceImpl", "onHostStartCommand", "key", str, " value", extras.get(str));
                }
            }
            int c = f.c();
            if (c > 3) {
                try {
                    ALog.e("ServiceImpl", "onHostStartCommand load SO fail 4 times, don't auto restart", new Object[0]);
                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_SOFAIL, UtilityImpl.a(c), 0.0d);
                    i = 2;
                } catch (Throwable th) {
                    th = th;
                    i = 2;
                    try {
                        ALog.e("ServiceImpl", "onHostStartCommand", th, new Object[0]);
                        return i;
                    } finally {
                        AdapterGlobalClientInfo.mStartServiceTimes.incrementAndGet();
                    }
                }
            }
            action = intent == null ? null : intent.getAction();
        } catch (Throwable th2) {
            th = th2;
        }
        if (TextUtils.isEmpty(action)) {
            b();
            a(false, false);
            return i;
        }
        a(intent, action);
        return i;
    }

    @Override // com.taobao.accs.internal.d, com.taobao.accs.base.IBaseService
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.taobao.accs.internal.d, com.taobao.accs.base.IBaseService
    public void onCreate() {
        super.onCreate();
        a();
    }

    @Override // com.taobao.accs.internal.d, com.taobao.accs.base.IBaseService
    public void onDestroy() {
        super.onDestroy();
        ALog.e("ServiceImpl", "Service onDestroy", new Object[0]);
        UtilityImpl.a(this.c, Constants.SP_KEY_SERVICE_END, System.currentTimeMillis());
        this.b = null;
        this.c = null;
        e();
        Process.killProcess(Process.myPid());
    }

    @Override // com.taobao.accs.internal.d, com.taobao.accs.base.IBaseService
    public boolean onUnbind(Intent intent) {
        return false;
    }

    private void a(Context context) {
        List<String> m = UtilityImpl.m(context);
        ArrayList arrayList = new ArrayList();
        if (m != null && m.size() > 0) {
            for (int i = 0; i < m.size(); i++) {
                try {
                    Class<?> cls = Class.forName(m.get(i));
                    if (IChannelInit.class.isAssignableFrom(cls)) {
                        try {
                            ((IChannelInit) cls.getDeclaredConstructor(null).newInstance(null)).init(context);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        arrayList.add(m.get(i));
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        if (arrayList.size() > 0) {
            UtilityImpl.a(context, arrayList);
        }
    }

    private void a() {
        ALog.d("ServiceImpl", "init start", new Object[0]);
        a(this.c);
        GlobalClientInfo.getInstance(this.c);
        AdapterGlobalClientInfo.mStartServiceTimes.incrementAndGet();
        this.d = System.currentTimeMillis();
        this.e = UtilityImpl.f(this.c);
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i("ServiceImpl", "init", Constants.KEY_SDK_VERSION, Integer.valueOf(Constants.SDK_VERSION_CODE), "procStart", Integer.valueOf(AdapterGlobalClientInfo.mStartServiceTimes.intValue()));
        }
        UTMini.getInstance().commitEvent(66001, "START", UtilityImpl.f(), "PROXY");
        long h = UtilityImpl.h(this.c);
        ALog.d("ServiceImpl", "getServiceAliveTime", "aliveTime", Long.valueOf(h));
        if (h > 20000) {
            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_SERVICE_ALIVE, "", h / 1000);
        }
        UtilityImpl.a(this.c, Constants.SP_KEY_SERVICE_START, System.currentTimeMillis());
        UTMini.getInstance().commitEvent(66001, "NOTIFY", UtilityImpl.k(this.c));
    }

    private void a(Intent intent, String str) {
        ALog.d("ServiceImpl", "handleAction", "action", str);
        try {
            b();
            if (TextUtils.equals(str, "android.intent.action.PACKAGE_REMOVED")) {
                return;
            }
            if (TextUtils.equals(str, "android.net.conn.CONNECTIVITY_CHANGE")) {
                String f = UtilityImpl.f(this.c);
                boolean g = UtilityImpl.g(this.c);
                ALog.i("ServiceImpl", "network change:" + this.e + " to " + f, new Object[0]);
                if (g) {
                    this.e = f;
                    c();
                    a(true, false);
                    UTMini.getInstance().commitEvent(66001, "CONNECTIVITY_CHANGE", f, UtilityImpl.f(), MessageService.MSG_DB_READY_REPORT);
                }
                if (f.equals(UtilityImpl.NET_TYPE_UNKNOWN)) {
                    c();
                    this.e = f;
                    return;
                }
                return;
            }
            if (TextUtils.equals(str, "android.intent.action.BOOT_COMPLETED")) {
                a(true, false);
                return;
            }
            if (TextUtils.equals(str, "android.intent.action.USER_PRESENT")) {
                ALog.d("ServiceImpl", "action android.intent.action.USER_PRESENT", new Object[0]);
                a(true, false);
            } else if (str.equals(Constants.ACTION_COMMAND)) {
                b(intent);
            }
        } catch (Throwable th) {
            ALog.e("ServiceImpl", "handleAction", th, new Object[0]);
        }
    }

    private synchronized void b() {
        ConcurrentHashMap<String, com.taobao.accs.net.b> concurrentHashMap = d.a;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            for (Map.Entry<String, com.taobao.accs.net.b> entry : d.a.entrySet()) {
                com.taobao.accs.net.b value = entry.getValue();
                if (value == null) {
                    ALog.e("ServiceImpl", "tryConnect connection null", Constants.SP_KEY_APPKEY, value.i());
                    return;
                }
                ALog.i("ServiceImpl", "tryConnect", Constants.SP_KEY_APPKEY, value.i(), Constants.KEY_CONFIG_TAG, entry.getKey());
                if (value.k() && TextUtils.isEmpty(value.i.getAppSecret())) {
                    ALog.e("ServiceImpl", "tryConnect secret is null", new Object[0]);
                } else {
                    value.a();
                }
            }
            return;
        }
        ALog.w("ServiceImpl", "tryConnect no connections", new Object[0]);
    }

    private void a(Message message, boolean z) {
        ConcurrentHashMap<String, com.taobao.accs.net.b> concurrentHashMap = d.a;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        Iterator<Map.Entry<String, com.taobao.accs.net.b>> it = d.a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().b(message, z);
        }
    }

    private void a(boolean z, boolean z2) {
        ConcurrentHashMap<String, com.taobao.accs.net.b> concurrentHashMap = d.a;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        Iterator<Map.Entry<String, com.taobao.accs.net.b>> it = d.a.entrySet().iterator();
        while (it.hasNext()) {
            com.taobao.accs.net.b value = it.next().getValue();
            value.a(z, z2);
            ALog.i("ServiceImpl", "ping connection", Constants.SP_KEY_APPKEY, value.i());
        }
    }
}
