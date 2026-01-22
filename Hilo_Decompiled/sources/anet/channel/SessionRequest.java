package anet.channel;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventType;
import anet.channel.session.TnetSpdySession;
import anet.channel.statist.AlarmObject;
import anet.channel.statist.SessionConnStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SessionRequest {

    /* renamed from: a, reason: collision with root package name */
    SessionCenter f٤٦٤٩a;

    /* renamed from: b, reason: collision with root package name */
    e f٤٦٥٠b;

    /* renamed from: c, reason: collision with root package name */
    SessionInfo f٤٦٥١c;

    /* renamed from: e, reason: collision with root package name */
    volatile Session f٤٦٥٣e;

    /* renamed from: i, reason: collision with root package name */
    private String f٤٦٥٧i;

    /* renamed from: j, reason: collision with root package name */
    private String f٤٦٥٨j;

    /* renamed from: k, reason: collision with root package name */
    private volatile Future f٤٦٥٩k;

    /* renamed from: d, reason: collision with root package name */
    volatile boolean f٤٦٥٢d = false;

    /* renamed from: f, reason: collision with root package name */
    volatile boolean f٤٦٥٤f = false;

    /* renamed from: g, reason: collision with root package name */
    HashMap<SessionGetCallback, c> f٤٦٥٥g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    SessionConnStat f٤٦٥٦h = null;

    /* renamed from: l, reason: collision with root package name */
    private Object f٤٦٦٠l = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface IConnCb {
        void onDisConnect(Session session, long j10, int i10);

        void onFailed(Session session, long j10, int i10, int i11);

        void onSuccess(Session session, long j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a implements IConnCb {

        /* renamed from: a, reason: collision with root package name */
        boolean f٤٦٦١a = false;

        /* renamed from: c, reason: collision with root package name */
        private Context f٤٦٦٣c;

        /* renamed from: d, reason: collision with root package name */
        private List<anet.channel.entity.a> f٤٦٦٤d;

        /* renamed from: e, reason: collision with root package name */
        private anet.channel.entity.a f٤٦٦٥e;

        a(Context context, List<anet.channel.entity.a> list, anet.channel.entity.a aVar) {
            this.f٤٦٦٣c = context;
            this.f٤٦٦٤d = list;
            this.f٤٦٦٥e = aVar;
        }

        @Override // anet.channel.SessionRequest.IConnCb
        public void onDisConnect(Session session, long j10, int i10) {
            int i11;
            SessionInfo sessionInfo;
            boolean isAppBackground = GlobalAppRuntimeInfo.isAppBackground();
            ALog.d("awcn.SessionRequest", "Connect Disconnect", this.f٤٦٦٥e.h(), "session", session, "host", SessionRequest.this.a(), "appIsBg", Boolean.valueOf(isAppBackground), "isHandleFinish", Boolean.valueOf(this.f٤٦٦١a));
            SessionRequest sessionRequest = SessionRequest.this;
            sessionRequest.f٤٦٥٠b.b(sessionRequest, session);
            if (this.f٤٦٦١a) {
                return;
            }
            this.f٤٦٦١a = true;
            if (!session.f٤٦٣٠t) {
                return;
            }
            if (isAppBackground && ((sessionInfo = SessionRequest.this.f٤٦٥١c) == null || !sessionInfo.isAccs || AwcnConfig.isAccsSessionCreateForbiddenInBg())) {
                ALog.e("awcn.SessionRequest", "[onDisConnect]app background, don't Recreate", this.f٤٦٦٥e.h(), "session", session);
                return;
            }
            if (!NetworkStatusHelper.isConnected()) {
                ALog.e("awcn.SessionRequest", "[onDisConnect]no network, don't Recreate", this.f٤٦٦٥e.h(), "session", session);
                return;
            }
            try {
                ALog.d("awcn.SessionRequest", "session disconnected, try to recreate session", this.f٤٦٦٥e.h(), new Object[0]);
                SessionInfo sessionInfo2 = SessionRequest.this.f٤٦٥١c;
                if (sessionInfo2 != null && sessionInfo2.isAccs) {
                    i11 = AwcnConfig.getAccsReconnectionDelayPeriod();
                } else {
                    i11 = 10000;
                }
                ThreadPoolExecutorFactory.submitScheduledTask(new i(this, session), (long) (Math.random() * i11), TimeUnit.MILLISECONDS);
            } catch (Exception unused) {
            }
        }

        @Override // anet.channel.SessionRequest.IConnCb
        public void onFailed(Session session, long j10, int i10, int i11) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.SessionRequest", "Connect failed", this.f٤٦٦٥e.h(), "session", session, "host", SessionRequest.this.a(), "isHandleFinish", Boolean.valueOf(this.f٤٦٦١a));
            }
            if (SessionRequest.this.f٤٦٥٤f) {
                SessionRequest.this.f٤٦٥٤f = false;
                return;
            }
            if (this.f٤٦٦١a) {
                return;
            }
            this.f٤٦٦١a = true;
            SessionRequest sessionRequest = SessionRequest.this;
            sessionRequest.f٤٦٥٠b.b(sessionRequest, session);
            if (session.f٤٦٣١u && NetworkStatusHelper.isConnected() && !this.f٤٦٦٤d.isEmpty()) {
                if (ALog.isPrintLog(1)) {
                    ALog.d("awcn.SessionRequest", "use next connInfo to create session", this.f٤٦٦٥e.h(), "host", SessionRequest.this.a());
                }
                anet.channel.entity.a aVar = this.f٤٦٦٥e;
                if (aVar.f٤٧٦٤b == aVar.f٤٧٦٥c && (i11 == -2003 || i11 == -2410)) {
                    ListIterator<anet.channel.entity.a> listIterator = this.f٤٦٦٤d.listIterator();
                    while (listIterator.hasNext()) {
                        if (session.getIp().equals(listIterator.next().f٤٧٦٣a.getIp())) {
                            listIterator.remove();
                        }
                    }
                }
                if (anet.channel.strategy.utils.c.b(session.getIp())) {
                    ListIterator<anet.channel.entity.a> listIterator2 = this.f٤٦٦٤d.listIterator();
                    while (listIterator2.hasNext()) {
                        if (anet.channel.strategy.utils.c.b(listIterator2.next().f٤٧٦٣a.getIp())) {
                            listIterator2.remove();
                        }
                    }
                }
                if (this.f٤٦٦٤d.isEmpty()) {
                    SessionRequest.this.c();
                    SessionRequest.this.a(session, i10, i11);
                    synchronized (SessionRequest.this.f٤٦٥٥g) {
                        try {
                            for (Map.Entry<SessionGetCallback, c> entry : SessionRequest.this.f٤٦٥٥g.entrySet()) {
                                c value = entry.getValue();
                                if (value.f٤٦٦٩b.compareAndSet(false, true)) {
                                    ThreadPoolExecutorFactory.removeScheduleTask(value);
                                    entry.getKey().onSessionGetFail();
                                }
                            }
                            SessionRequest.this.f٤٦٥٥g.clear();
                        } finally {
                        }
                    }
                    return;
                }
                anet.channel.entity.a remove = this.f٤٦٦٤d.remove(0);
                SessionRequest sessionRequest2 = SessionRequest.this;
                Context context = this.f٤٦٦٣c;
                sessionRequest2.a(context, remove, new a(context, this.f٤٦٦٤d, remove), remove.h());
                return;
            }
            SessionRequest.this.c();
            SessionRequest.this.a(session, i10, i11);
            synchronized (SessionRequest.this.f٤٦٥٥g) {
                try {
                    for (Map.Entry<SessionGetCallback, c> entry2 : SessionRequest.this.f٤٦٥٥g.entrySet()) {
                        c value2 = entry2.getValue();
                        if (value2.f٤٦٦٩b.compareAndSet(false, true)) {
                            ThreadPoolExecutorFactory.removeScheduleTask(value2);
                            entry2.getKey().onSessionGetFail();
                        }
                    }
                    SessionRequest.this.f٤٦٥٥g.clear();
                } finally {
                }
            }
        }

        @Override // anet.channel.SessionRequest.IConnCb
        public void onSuccess(Session session, long j10) {
            ALog.d("awcn.SessionRequest", "Connect Success", this.f٤٦٦٥e.h(), "session", session, "host", SessionRequest.this.a());
            try {
                if (SessionRequest.this.f٤٦٥٤f) {
                    SessionRequest.this.f٤٦٥٤f = false;
                    session.close(false);
                    return;
                }
                SessionRequest sessionRequest = SessionRequest.this;
                sessionRequest.f٤٦٥٠b.a(sessionRequest, session);
                SessionRequest.this.a(session);
                synchronized (SessionRequest.this.f٤٦٥٥g) {
                    try {
                        for (Map.Entry<SessionGetCallback, c> entry : SessionRequest.this.f٤٦٥٥g.entrySet()) {
                            c value = entry.getValue();
                            if (value.f٤٦٦٩b.compareAndSet(false, true)) {
                                ThreadPoolExecutorFactory.removeScheduleTask(value);
                                entry.getKey().onSessionGetSuccess(session);
                            }
                        }
                        SessionRequest.this.f٤٦٥٥g.clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception e10) {
                ALog.e("awcn.SessionRequest", "[onSuccess]:", this.f٤٦٦٥e.h(), e10, new Object[0]);
            } finally {
                SessionRequest.this.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        String f٤٦٦٦a;

        b(String str) {
            this.f٤٦٦٦a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SessionRequest.this.f٤٦٥٢d) {
                ALog.e("awcn.SessionRequest", "Connecting timeout!!! reset status!", this.f٤٦٦٦a, new Object[0]);
                SessionConnStat sessionConnStat = SessionRequest.this.f٤٦٥٦h;
                sessionConnStat.ret = 2;
                sessionConnStat.totalTime = System.currentTimeMillis() - SessionRequest.this.f٤٦٥٦h.start;
                if (SessionRequest.this.f٤٦٥٣e != null) {
                    SessionRequest.this.f٤٦٥٣e.f٤٦٣١u = false;
                    SessionRequest.this.f٤٦٥٣e.close();
                    SessionRequest sessionRequest = SessionRequest.this;
                    sessionRequest.f٤٦٥٦h.syncValueFromSession(sessionRequest.f٤٦٥٣e);
                }
                AppMonitor.getInstance().commitStat(SessionRequest.this.f٤٦٥٦h);
                SessionRequest.this.a(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        SessionGetCallback f٤٦٦٨a;

        /* renamed from: b, reason: collision with root package name */
        AtomicBoolean f٤٦٦٩b = new AtomicBoolean(false);

        protected c(SessionGetCallback sessionGetCallback) {
            this.f٤٦٦٨a = null;
            this.f٤٦٦٨a = sessionGetCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f٤٦٦٩b.compareAndSet(false, true)) {
                ALog.e("awcn.SessionRequest", "get session timeout", null, new Object[0]);
                synchronized (SessionRequest.this.f٤٦٥٥g) {
                    SessionRequest.this.f٤٦٥٥g.remove(this.f٤٦٦٨a);
                }
                this.f٤٦٦٨a.onSessionGetFail();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionRequest(String str, SessionCenter sessionCenter) {
        this.f٤٦٥٧i = str;
        String substring = str.substring(str.indexOf(HttpConstant.SCHEME_SPLIT) + 3);
        this.f٤٦٥٨j = substring;
        this.f٤٦٤٩a = sessionCenter;
        this.f٤٦٥١c = sessionCenter.f٤٦٤٤g.b(substring);
        this.f٤٦٥٠b = sessionCenter.f٤٦٤٢e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void b(Context context, int i10, String str, SessionGetCallback sessionGetCallback, long j10) {
        Session a10 = this.f٤٦٥٠b.a(this, i10);
        if (a10 != null) {
            ALog.d("awcn.SessionRequest", "Available Session exist!!!", str, new Object[0]);
            sessionGetCallback.onSessionGetSuccess(a10);
            return;
        }
        String a11 = TextUtils.isEmpty(str) ? anet.channel.util.i.a(null) : str;
        ALog.d("awcn.SessionRequest", "SessionRequest start", a11, "host", this.f٤٦٥٧i, "type", Integer.valueOf(i10));
        if (this.f٤٦٥٢d) {
            ALog.d("awcn.SessionRequest", "session connecting", a11, "host", a());
            if (b() == i10) {
                c cVar = new c(sessionGetCallback);
                synchronized (this.f٤٦٥٥g) {
                    this.f٤٦٥٥g.put(sessionGetCallback, cVar);
                }
                ThreadPoolExecutorFactory.submitScheduledTask(cVar, j10, TimeUnit.MILLISECONDS);
            } else {
                sessionGetCallback.onSessionGetFail();
            }
            return;
        }
        a(true);
        this.f٤٦٥٩k = ThreadPoolExecutorFactory.submitScheduledTask(new b(a11), 45L, TimeUnit.SECONDS);
        SessionConnStat sessionConnStat = new SessionConnStat();
        this.f٤٦٥٦h = sessionConnStat;
        sessionConnStat.start = System.currentTimeMillis();
        if (!NetworkStatusHelper.isConnected()) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.SessionRequest", "network is not available, can't create session", a11, "isConnected", Boolean.valueOf(NetworkStatusHelper.isConnected()));
            }
            c();
            throw new RuntimeException("no network");
        }
        List<IConnStrategy> a12 = a(i10, a11);
        if (!a12.isEmpty()) {
            List<anet.channel.entity.a> a13 = a(a12, a11);
            try {
                anet.channel.entity.a remove = a13.remove(0);
                a(context, remove, new a(context, a13, remove), remove.h());
                c cVar2 = new c(sessionGetCallback);
                synchronized (this.f٤٦٥٥g) {
                    this.f٤٦٥٥g.put(sessionGetCallback, cVar2);
                }
                ThreadPoolExecutorFactory.submitScheduledTask(cVar2, j10, TimeUnit.MILLISECONDS);
            } catch (Throwable unused) {
                c();
            }
            return;
        }
        ALog.i("awcn.SessionRequest", "no avalible strategy, can't create session", a11, "host", this.f٤٦٥٧i, "type", Integer.valueOf(i10));
        c();
        throw new NoAvailStrategyException("no avalible strategy");
    }

    void c() {
        a(false);
        synchronized (this.f٤٦٦٠l) {
            this.f٤٦٦٠l.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a() {
        return this.f٤٦٥٧i;
    }

    void a(boolean z10) {
        this.f٤٦٥٢d = z10;
        if (z10) {
            return;
        }
        if (this.f٤٦٥٩k != null) {
            this.f٤٦٥٩k.cancel(true);
            this.f٤٦٥٩k = null;
        }
        this.f٤٦٥٣e = null;
    }

    private void c(Session session, int i10, String str) {
        SessionInfo sessionInfo = this.f٤٦٥١c;
        if (sessionInfo == null || !sessionInfo.isAccs) {
            return;
        }
        ALog.e("awcn.SessionRequest", "sendConnectInfoToAccsByCallBack", null, new Object[0]);
        Intent intent = new Intent("com.taobao.ACCS_CONNECT_INFO");
        intent.putExtra("command", 103);
        intent.putExtra("host", session.getHost());
        intent.putExtra("is_center_host", true);
        boolean isAvailable = session.isAvailable();
        if (!isAvailable) {
            intent.putExtra("errorCode", i10);
            intent.putExtra("errorDetail", str);
        }
        intent.putExtra("connect_avail", isAvailable);
        intent.putExtra("type_inapp", true);
        this.f٤٦٤٩a.f٤٦٤٥h.notifyListener(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(Context context, int i10, String str, SessionGetCallback sessionGetCallback, long j10) {
        Session a10 = this.f٤٦٥٠b.a(this, i10);
        if (a10 != null) {
            ALog.d("awcn.SessionRequest", "Available Session exist!!!", str, new Object[0]);
            if (sessionGetCallback != null) {
                sessionGetCallback.onSessionGetSuccess(a10);
            }
            return;
        }
        String a11 = TextUtils.isEmpty(str) ? anet.channel.util.i.a(null) : str;
        ALog.d("awcn.SessionRequest", "SessionRequest start", a11, "host", this.f٤٦٥٧i, "type", Integer.valueOf(i10));
        if (this.f٤٦٥٢d) {
            ALog.d("awcn.SessionRequest", "session connecting", a11, "host", a());
            if (sessionGetCallback != null) {
                if (b() == i10) {
                    c cVar = new c(sessionGetCallback);
                    synchronized (this.f٤٦٥٥g) {
                        this.f٤٦٥٥g.put(sessionGetCallback, cVar);
                    }
                    ThreadPoolExecutorFactory.submitScheduledTask(cVar, j10, TimeUnit.MILLISECONDS);
                } else {
                    sessionGetCallback.onSessionGetFail();
                }
            }
            return;
        }
        a(true);
        this.f٤٦٥٩k = ThreadPoolExecutorFactory.submitScheduledTask(new b(a11), 45L, TimeUnit.SECONDS);
        SessionConnStat sessionConnStat = new SessionConnStat();
        this.f٤٦٥٦h = sessionConnStat;
        sessionConnStat.start = System.currentTimeMillis();
        if (!NetworkStatusHelper.isConnected()) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.SessionRequest", "network is not available, can't create session", a11, "isConnected", Boolean.valueOf(NetworkStatusHelper.isConnected()));
            }
            c();
            throw new RuntimeException("no network");
        }
        List<IConnStrategy> a12 = a(i10, a11);
        if (!a12.isEmpty()) {
            List<anet.channel.entity.a> a13 = a(a12, a11);
            try {
                anet.channel.entity.a remove = a13.remove(0);
                a(context, remove, new a(context, a13, remove), remove.h());
                if (sessionGetCallback != null) {
                    c cVar2 = new c(sessionGetCallback);
                    synchronized (this.f٤٦٥٥g) {
                        this.f٤٦٥٥g.put(sessionGetCallback, cVar2);
                    }
                    ThreadPoolExecutorFactory.submitScheduledTask(cVar2, j10, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable unused) {
                c();
            }
            return;
        }
        ALog.i("awcn.SessionRequest", "no avalible strategy, can't create session", a11, "host", this.f٤٦٥٧i, "type", Integer.valueOf(i10));
        c();
        throw new NoAvailStrategyException("no avalible strategy");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(boolean z10) {
        ALog.d("awcn.SessionRequest", "closeSessions", this.f٤٦٤٩a.f٤٦٤٠c, "host", this.f٤٦٥٧i, "autoCreate", Boolean.valueOf(z10));
        if (!z10 && this.f٤٦٥٣e != null) {
            this.f٤٦٥٣e.f٤٦٣١u = false;
            this.f٤٦٥٣e.close(false);
        }
        List<Session> a10 = this.f٤٦٥٠b.a(this);
        if (a10 != null) {
            for (Session session : a10) {
                if (session != null) {
                    session.close(z10);
                }
            }
        }
    }

    void a(Session session) {
        AlarmObject alarmObject = new AlarmObject();
        alarmObject.module = "networkPrefer";
        alarmObject.modulePoint = "policy";
        alarmObject.arg = this.f٤٦٥٧i;
        alarmObject.isSuccess = true;
        AppMonitor.getInstance().commitAlarm(alarmObject);
        this.f٤٦٥٦h.syncValueFromSession(session);
        SessionConnStat sessionConnStat = this.f٤٦٥٦h;
        sessionConnStat.ret = 1;
        sessionConnStat.totalTime = System.currentTimeMillis() - this.f٤٦٥٦h.start;
        AppMonitor.getInstance().commitStat(this.f٤٦٥٦h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b() {
        Session session = this.f٤٦٥٣e;
        if (session != null) {
            return session.f٤٦٢٠j.getType();
        }
        return -1;
    }

    private void b(Session session, int i10, String str) {
        SessionInfo sessionInfo;
        Context context = GlobalAppRuntimeInfo.getContext();
        if (context == null || (sessionInfo = this.f٤٦٥١c) == null || !sessionInfo.isAccs) {
            return;
        }
        ALog.e("awcn.SessionRequest", "sendConnectInfoToAccsByService", null, new Object[0]);
        try {
            Intent intent = new Intent("com.taobao.accs.intent.action.RECEIVE");
            intent.setPackage(context.getPackageName());
            intent.setClassName(context, "com.taobao.accs.data.MsgDistributeService");
            intent.putExtra("command", 103);
            intent.putExtra("host", session.getHost());
            intent.putExtra("is_center_host", true);
            boolean isAvailable = session.isAvailable();
            if (!isAvailable) {
                intent.putExtra("errorCode", i10);
                intent.putExtra("errorDetail", str);
            }
            intent.putExtra("connect_avail", isAvailable);
            intent.putExtra("type_inapp", true);
            if (Build.VERSION.SDK_INT >= 26) {
                context.bindService(intent, new h(this, intent, context), 1);
            } else {
                context.startService(intent);
            }
        } catch (Throwable th) {
            ALog.e("awcn.SessionRequest", "sendConnectInfoToAccsByService", null, th, new Object[0]);
        }
    }

    void a(Session session, int i10, int i11) {
        if (256 != i10 || i11 == -2613 || i11 == -2601) {
            return;
        }
        AlarmObject alarmObject = new AlarmObject();
        alarmObject.module = "networkPrefer";
        alarmObject.modulePoint = "policy";
        alarmObject.arg = this.f٤٦٥٧i;
        alarmObject.errorCode = String.valueOf(i11);
        alarmObject.isSuccess = false;
        AppMonitor.getInstance().commitAlarm(alarmObject);
        SessionConnStat sessionConnStat = this.f٤٦٥٦h;
        sessionConnStat.ret = 0;
        sessionConnStat.appendErrorTrace(i11);
        this.f٤٦٥٦h.errorCode = String.valueOf(i11);
        this.f٤٦٥٦h.totalTime = System.currentTimeMillis() - this.f٤٦٥٦h.start;
        this.f٤٦٥٦h.syncValueFromSession(session);
        AppMonitor.getInstance().commitStat(this.f٤٦٥٦h);
    }

    private List<IConnStrategy> a(int i10, String str) {
        HttpUrl parse;
        List<IConnStrategy> list = Collections.EMPTY_LIST;
        try {
            parse = HttpUrl.parse(a());
        } catch (Throwable th) {
            ALog.e("awcn.SessionRequest", "", str, th, new Object[0]);
        }
        if (parse == null) {
            return list;
        }
        list = StrategyCenter.getInstance().getConnStrategyListByHost(parse.host());
        if (!list.isEmpty()) {
            boolean equalsIgnoreCase = HttpConstant.HTTPS.equalsIgnoreCase(parse.scheme());
            boolean b10 = anet.channel.util.c.b();
            ListIterator<IConnStrategy> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                IConnStrategy next = listIterator.next();
                ConnType valueOf = ConnType.valueOf(next.getProtocol());
                if (valueOf != null) {
                    if (valueOf.isSSL() == equalsIgnoreCase && (i10 == anet.channel.entity.c.f٤٧٧٣c || valueOf.getType() == i10)) {
                        if (b10 && anet.channel.strategy.utils.c.b(next.getIp())) {
                            listIterator.remove();
                        }
                    }
                    listIterator.remove();
                }
            }
        }
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.SessionRequest", "[getAvailStrategy]", str, "strategies", list);
        }
        return list;
    }

    private List<anet.channel.entity.a> a(List<IConnStrategy> list, String str) {
        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            IConnStrategy iConnStrategy = list.get(i11);
            int retryTimes = iConnStrategy.getRetryTimes();
            for (int i12 = 0; i12 <= retryTimes; i12++) {
                i10++;
                anet.channel.entity.a aVar = new anet.channel.entity.a(a(), str + "_" + i10, iConnStrategy);
                aVar.f٤٧٦٤b = i12;
                aVar.f٤٧٦٥c = retryTimes;
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, anet.channel.entity.a aVar, IConnCb iConnCb, String str) {
        ConnType c10 = aVar.c();
        if (context != null && !c10.isHttpType()) {
            TnetSpdySession tnetSpdySession = new TnetSpdySession(context, aVar);
            tnetSpdySession.initConfig(this.f٤٦٤٩a.f٤٦٤١d);
            tnetSpdySession.initSessionInfo(this.f٤٦٥١c);
            tnetSpdySession.setTnetPublicKey(this.f٤٦٤٩a.f٤٦٤٤g.c(this.f٤٦٥٨j));
            this.f٤٦٥٣e = tnetSpdySession;
        } else {
            this.f٤٦٥٣e = new anet.channel.session.d(context, aVar);
        }
        ALog.i("awcn.SessionRequest", "create connection...", str, "Host", a(), "Type", aVar.c(), "IP", aVar.a(), "Port", Integer.valueOf(aVar.b()), "heartbeat", Integer.valueOf(aVar.g()), "session", this.f٤٦٥٣e);
        a(this.f٤٦٥٣e, iConnCb, System.currentTimeMillis());
        this.f٤٦٥٣e.connect();
        SessionConnStat sessionConnStat = this.f٤٦٥٦h;
        sessionConnStat.retryTimes++;
        sessionConnStat.startConnect = System.currentTimeMillis();
        SessionConnStat sessionConnStat2 = this.f٤٦٥٦h;
        if (sessionConnStat2.retryTimes == 0) {
            sessionConnStat2.putExtra("firstIp", aVar.a());
        }
    }

    private void a(Session session, IConnCb iConnCb, long j10) {
        if (iConnCb == null) {
            return;
        }
        session.registerEventcb(EventType.ALL, new f(this, iConnCb, j10));
        session.registerEventcb(1792, new g(this, session));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        ALog.d("awcn.SessionRequest", "reCreateSession", str, "host", this.f٤٦٥٧i);
        b(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(long j10) throws InterruptedException, TimeoutException {
        ALog.d("awcn.SessionRequest", "[await]", null, "timeoutMs", Long.valueOf(j10));
        if (j10 <= 0) {
            return;
        }
        synchronized (this.f٤٦٦٠l) {
            try {
                long currentTimeMillis = System.currentTimeMillis() + j10;
                while (this.f٤٦٥٢d) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (currentTimeMillis2 >= currentTimeMillis) {
                        break;
                    } else {
                        this.f٤٦٦٠l.wait(currentTimeMillis - currentTimeMillis2);
                    }
                }
                if (this.f٤٦٥٢d) {
                    throw new TimeoutException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Session session, int i10, String str) {
        if (AwcnConfig.isSendConnectInfoByService()) {
            b(session, i10, str);
        }
        c(session, i10, str);
    }
}
