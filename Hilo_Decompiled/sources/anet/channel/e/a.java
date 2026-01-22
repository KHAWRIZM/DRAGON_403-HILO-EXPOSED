package anet.channel.e;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.IStrategyFilter;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static b f٤٧٤٥a;

    /* renamed from: b, reason: collision with root package name */
    private static String f٤٧٤٦b;

    /* renamed from: f, reason: collision with root package name */
    private static SharedPreferences f٤٧٥٠f;

    /* renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f٤٧٤٧c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f٤٧٤٨d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    private static long f٤٧٤٩e = 21600000;

    /* renamed from: g, reason: collision with root package name */
    private static IStrategyFilter f٤٧٥١g = new anet.channel.e.b();

    /* renamed from: h, reason: collision with root package name */
    private static AtomicInteger f٤٧٥٢h = new AtomicInteger(1);

    /* renamed from: i, reason: collision with root package name */
    private static IStrategyListener f٤٧٥٣i = new c();

    /* renamed from: j, reason: collision with root package name */
    private static NetworkStatusHelper.INetworkStatusChangeListener f٤٧٥٤j = new d();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: anet.channel.e.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class C٠٠٦١a {

        /* renamed from: a, reason: collision with root package name */
        long f٤٧٥٥a;

        /* renamed from: b, reason: collision with root package name */
        boolean f٤٧٥٦b;

        private C٠٠٦١a() {
        }

        /* synthetic */ C٠٠٦١a(anet.channel.e.b bVar) {
            this();
        }
    }

    public static boolean b() {
        b bVar = f٤٧٤٥a;
        if (bVar != null) {
            return bVar.b(NetworkStatusHelper.getUniqueId(NetworkStatusHelper.getStatus()));
        }
        return false;
    }

    public static void a(NetworkStatusHelper.NetworkStatus networkStatus) {
        if (!AwcnConfig.isHttp3Enable()) {
            ALog.i("awcn.Http3ConnDetector", "startDetect", null, "http3 global config close.");
            return;
        }
        if (f٤٧٤٨d.get()) {
            ALog.e("awcn.Http3ConnDetector", "tnet exception.", null, new Object[0]);
            return;
        }
        if (NetworkStatusHelper.isConnected()) {
            if (TextUtils.isEmpty(f٤٧٤٦b)) {
                ALog.e("awcn.Http3ConnDetector", "startDetect", null, "host is null");
                return;
            }
            List<IConnStrategy> connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(f٤٧٤٦b, f٤٧٥١g);
            if (connStrategyListByHost.isEmpty()) {
                ALog.e("awcn.Http3ConnDetector", "startDetect", null, "http3 strategy is null.");
                return;
            }
            if (f٤٧٤٧c.compareAndSet(false, true)) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION).InitializeSecurityStuff();
                    ALog.e("awcn.Http3ConnDetector", "tnet init http3.", null, "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable th) {
                    ALog.e("awcn.Http3ConnDetector", "tnet init http3 error.", null, th, new Object[0]);
                    f٤٧٤٨d.set(true);
                    return;
                }
            }
            if (f٤٧٤٥a == null) {
                f٤٧٤٥a = new b();
            }
            if (f٤٧٤٥a.a(NetworkStatusHelper.getUniqueId(networkStatus))) {
                ThreadPoolExecutorFactory.submitDetectTask(new e(connStrategyListByHost, networkStatus));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IConnStrategy b(IConnStrategy iConnStrategy) {
        return new g(iConnStrategy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private Map<String, C٠٠٦١a> f٤٧٥٧a = new ConcurrentHashMap();

        b() {
            a();
        }

        private void a() {
            anet.channel.e.b bVar = null;
            String string = a.f٤٧٥٠f.getString("networksdk_http3_history_records", null);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i10);
                    C٠٠٦١a r42 = new C٠٠٦١a(bVar);
                    String string2 = jSONObject.getString("networkUniqueId");
                    r42.f٤٧٥٥a = jSONObject.getLong("time");
                    r42.f٤٧٥٦b = jSONObject.getBoolean("enable");
                    if (a(r42.f٤٧٥٥a)) {
                        synchronized (this.f٤٧٥٧a) {
                            this.f٤٧٥٧a.put(string2, r42);
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }

        boolean b(String str) {
            synchronized (this.f٤٧٥٧a) {
                try {
                    C٠٠٦١a r32 = this.f٤٧٥٧a.get(str);
                    if (r32 != null) {
                        return r32.f٤٧٥٦b;
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        boolean a(String str) {
            synchronized (this.f٤٧٥٧a) {
                try {
                    if (this.f٤٧٥٧a.get(str) == null) {
                        return true;
                    }
                    return !a(r5.f٤٧٥٥a);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private boolean a(long j10) {
            return System.currentTimeMillis() - j10 < a.f٤٧٤٩e;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(String str, boolean z10) {
            C٠٠٦١a r02 = new C٠٠٦١a(null);
            r02.f٤٧٥٦b = z10;
            r02.f٤٧٥٥a = System.currentTimeMillis();
            JSONArray jSONArray = new JSONArray();
            synchronized (this.f٤٧٥٧a) {
                this.f٤٧٥٧a.put(str, r02);
                for (Map.Entry<String, C٠٠٦١a> entry : this.f٤٧٥٧a.entrySet()) {
                    String key = entry.getKey();
                    C٠٠٦١a value = entry.getValue();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("networkUniqueId", key);
                        jSONObject.put("time", value.f٤٧٥٥a);
                        jSONObject.put("enable", value.f٤٧٥٦b);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e10) {
                        e10.printStackTrace();
                    }
                }
            }
            a.f٤٧٥٠f.edit().putString("networksdk_http3_history_records", jSONArray.toString()).apply();
        }
    }

    public static void a() {
        try {
            ALog.e("awcn.Http3ConnDetector", "registerListener", null, "http3Enable", Boolean.valueOf(AwcnConfig.isHttp3Enable()));
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(GlobalAppRuntimeInfo.getContext());
            f٤٧٥٠f = defaultSharedPreferences;
            f٤٧٤٦b = defaultSharedPreferences.getString("http3_detector_host", "");
            a(NetworkStatusHelper.getStatus());
            NetworkStatusHelper.addStatusChangeListener(f٤٧٥٤j);
            StrategyCenter.getInstance().registerListener(f٤٧٥٣i);
        } catch (Exception e10) {
            ALog.e("awcn.Http3ConnDetector", "[registerListener]error", null, e10, new Object[0]);
        }
    }

    public static void a(long j10) {
        if (j10 < 0) {
            return;
        }
        f٤٧٤٩e = j10;
    }

    public static void a(boolean z10) {
        b bVar = f٤٧٤٥a;
        if (bVar != null) {
            bVar.a(NetworkStatusHelper.getUniqueId(NetworkStatusHelper.getStatus()), z10);
        }
    }
}
