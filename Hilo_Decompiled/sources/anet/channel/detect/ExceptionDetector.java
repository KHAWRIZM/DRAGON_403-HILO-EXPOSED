package anet.channel.detect;

import android.text.TextUtils;
import android.util.Pair;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;
import org.android.netutil.NetUtils;
import org.android.netutil.PingEntry;
import org.android.netutil.PingResponse;
import org.android.netutil.PingTask;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ExceptionDetector {

    /* renamed from: a, reason: collision with root package name */
    long f٤٧٠١a;

    /* renamed from: b, reason: collision with root package name */
    String f٤٧٠٢b;

    /* renamed from: c, reason: collision with root package name */
    String f٤٧٠٣c;

    /* renamed from: d, reason: collision with root package name */
    String f٤٧٠٤d;

    /* renamed from: e, reason: collision with root package name */
    LimitedQueue<Pair<String, Integer>> f٤٧٠٥e = new LimitedQueue<>(10);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class LimitedQueue<E> extends LinkedList<E> {

        /* renamed from: b, reason: collision with root package name */
        private int f٤٧٠٧b;

        public LimitedQueue(int i10) {
            this.f٤٧٠٧b = i10;
        }

        @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
        public boolean add(E e10) {
            boolean add = super.add(e10);
            while (add && size() > this.f٤٧٠٧b) {
                super.remove();
            }
            return add;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        String f٤٧٠٨a;

        /* renamed from: b, reason: collision with root package name */
        String f٤٧٠٩b;

        /* renamed from: c, reason: collision with root package name */
        String f٤٧١٠c;

        /* renamed from: d, reason: collision with root package name */
        Future<PingResponse> f٤٧١١d;

        /* renamed from: e, reason: collision with root package name */
        Future<PingResponse> f٤٧١٢e;

        /* renamed from: f, reason: collision with root package name */
        Future<PingResponse> f٤٧١٣f;

        private a() {
        }

        /* synthetic */ a(ExceptionDetector exceptionDetector, anet.channel.detect.a aVar) {
            this();
        }
    }

    public void a() {
        NetworkStatusHelper.addStatusChangeListener(new anet.channel.detect.a(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() throws JSONException {
        String preferNextHop;
        Future<PingResponse> future;
        ALog.e("anet.ExceptionDetector", "network detect start.", null, new Object[0]);
        SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        NetworkStatusHelper.NetworkStatus status = NetworkStatusHelper.getStatus();
        jSONObject2.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, status.getType());
        jSONObject2.put("subType", NetworkStatusHelper.getNetworkSubType());
        if (status != NetworkStatusHelper.NetworkStatus.NO) {
            if (status.isMobile()) {
                jSONObject2.put(DynamicLink.AndroidParameters.KEY_ANDROID_PACKAGE_NAME, NetworkStatusHelper.getApn());
                jSONObject2.put("carrier", NetworkStatusHelper.getCarrier());
            } else {
                jSONObject2.put(DispatchConstants.BSSID, NetworkStatusHelper.getWifiBSSID());
                jSONObject2.put("ssid", NetworkStatusHelper.getWifiSSID());
            }
            jSONObject2.put("proxy", NetworkStatusHelper.getProxyType());
        }
        jSONObject.put("NetworkInfo", jSONObject2);
        if (status.isWifi()) {
            preferNextHop = NetUtils.getDefaultGateway("114.114.114.114");
        } else {
            preferNextHop = NetUtils.getPreferNextHop("114.114.114.114", 2);
        }
        if (!TextUtils.isEmpty(preferNextHop)) {
            future = new PingTask(preferNextHop, 1000, 3, 0, 0).launch();
        } else {
            future = null;
        }
        a a10 = a("guide-acs.m.taobao.com", this.f٤٧٠٢b);
        a a11 = a("gw.alicdn.com", this.f٤٧٠٤d);
        a a12 = a("msgacs.m.taobao.com", this.f٤٧٠٣c);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("nextHop", preferNextHop);
        jSONObject3.put("ping", a(future));
        jSONObject.put("LocalDetect", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(a(a10));
        jSONArray.put(a(a11));
        jSONArray.put(a(a12));
        jSONObject.put("InternetDetect", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        Iterator<Pair<String, Integer>> it = this.f٤٧٠٥e.iterator();
        while (it.hasNext()) {
            Pair<String, Integer> next = it.next();
            jSONObject4.put((String) next.first, next.second);
        }
        jSONObject.put("BizDetect", jSONObject4);
        this.f٤٧٠٥e.clear();
        ALog.e("anet.ExceptionDetector", "network detect result: " + jSONObject.toString(), null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        boolean z10 = false;
        if (this.f٤٧٠٥e.size() != 10) {
            return false;
        }
        if (NetworkStatusHelper.getStatus() == NetworkStatusHelper.NetworkStatus.NO) {
            ALog.e("anet.ExceptionDetector", "no network", null, new Object[0]);
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.f٤٧٠١a) {
            return false;
        }
        Iterator<Pair<String, Integer>> it = this.f٤٧٠٥e.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next().second).intValue();
            if (intValue == -202 || intValue == -400 || intValue == -401 || intValue == -405 || intValue == -406) {
                i10++;
            }
        }
        if (i10 * 2 > 10) {
            z10 = true;
        }
        if (z10) {
            this.f٤٧٠١a = currentTimeMillis + 1800000;
        }
        return z10;
    }

    public void a(RequestStatistic requestStatistic) {
        if (!AwcnConfig.isNetworkDetectEnable()) {
            ALog.i("anet.ExceptionDetector", "network detect closed.", null, new Object[0]);
        } else {
            ThreadPoolExecutorFactory.submitDetectTask(new c(this, requestStatistic));
        }
    }

    private ArrayList<String> a(String str, int i10) {
        PingResponse pingResponse;
        ArrayList<String> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        int i11 = 0;
        while (i11 < i10) {
            i11++;
            try {
                pingResponse = (PingResponse) new PingTask(str, 0, 1, 0, i11).launch().get();
            } catch (Exception unused) {
                pingResponse = null;
            }
            StringBuilder sb = new StringBuilder();
            if (pingResponse != null) {
                String lastHopIPStr = pingResponse.getLastHopIPStr();
                double d10 = pingResponse.getResults()[0].rtt;
                int errcode = pingResponse.getErrcode();
                if (TextUtils.isEmpty(lastHopIPStr)) {
                    lastHopIPStr = "*";
                }
                sb.append("hop=");
                sb.append(lastHopIPStr);
                sb.append(",rtt=");
                sb.append(d10);
                sb.append(",errCode=");
                sb.append(errcode);
            }
            arrayList.add(sb.toString());
        }
        return arrayList;
    }

    private a a(String str, String str2) {
        a aVar = new a(this, null);
        aVar.f٤٧٠٨a = str;
        try {
            aVar.f٤٧٠٩b = InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException unused) {
        }
        if (!TextUtils.isEmpty(str2)) {
            aVar.f٤٧١٠c = str2;
        } else {
            List<IConnStrategy> connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(str);
            if (connStrategyListByHost != null && !connStrategyListByHost.isEmpty()) {
                aVar.f٤٧١٠c = connStrategyListByHost.get(0).getIp();
            }
        }
        String str3 = !TextUtils.isEmpty(aVar.f٤٧١٠c) ? aVar.f٤٧١٠c : aVar.f٤٧٠٩b;
        if (!TextUtils.isEmpty(str3)) {
            String str4 = str3;
            aVar.f٤٧١١d = new PingTask(str4, 1000, 3, 0, 0).launch();
            aVar.f٤٧١٢e = new PingTask(str4, 1000, 3, 1172, 0).launch();
            aVar.f٤٧١٣f = new PingTask(str4, 1000, 3, 1432, 0).launch();
        }
        return aVar;
    }

    private JSONObject a(a aVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (aVar != null && aVar.f٤٧١١d != null) {
            jSONObject.put("host", aVar.f٤٧٠٨a);
            jSONObject.put("currentIp", aVar.f٤٧١٠c);
            jSONObject.put("localIp", aVar.f٤٧٠٩b);
            jSONObject.put("ping", a(aVar.f٤٧١١d));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("1200", a(aVar.f٤٧١٢e));
            jSONObject2.put("1460", a(aVar.f٤٧١٣f));
            jSONObject.put("MTU", jSONObject2);
            if ("guide-acs.m.taobao.com".equals(aVar.f٤٧٠٨a)) {
                ArrayList<String> a10 = a(!TextUtils.isEmpty(aVar.f٤٧١٠c) ? aVar.f٤٧١٠c : aVar.f٤٧٠٩b, 5);
                JSONObject jSONObject3 = new JSONObject();
                int i10 = 0;
                while (i10 < a10.size()) {
                    int i11 = i10 + 1;
                    jSONObject3.put(String.valueOf(i11), a10.get(i10));
                    i10 = i11;
                }
                jSONObject.put("traceRoute", jSONObject3);
            }
        }
        return jSONObject;
    }

    private JSONObject a(Future<PingResponse> future) throws JSONException {
        PingResponse pingResponse;
        JSONObject jSONObject = new JSONObject();
        if (future == null) {
            return jSONObject;
        }
        try {
            pingResponse = future.get();
        } catch (Exception unused) {
            pingResponse = null;
        }
        if (pingResponse == null) {
            return jSONObject;
        }
        jSONObject.put("errCode", pingResponse.getErrcode());
        JSONArray jSONArray = new JSONArray();
        for (PingEntry pingEntry : pingResponse.getResults()) {
            jSONArray.put("seq=" + pingEntry.seq + ",hop=" + pingEntry.hop + ",rtt=" + pingEntry.rtt);
        }
        jSONObject.put("response", jSONArray);
        return jSONObject;
    }
}
