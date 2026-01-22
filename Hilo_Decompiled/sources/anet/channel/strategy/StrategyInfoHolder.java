package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.StrategyStatObject;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import com.facebook.internal.AnalyticsEvents;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class StrategyInfoHolder implements NetworkStatusHelper.INetworkStatusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    Map<String, StrategyTable> f٤٩٥٨a = new LruStrategyMap();

    /* renamed from: b, reason: collision with root package name */
    volatile StrategyConfig f٤٩٥٩b = null;

    /* renamed from: c, reason: collision with root package name */
    final a f٤٩٦٠c = new a();

    /* renamed from: d, reason: collision with root package name */
    private final StrategyTable f٤٩٦١d = new StrategyTable(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);

    /* renamed from: e, reason: collision with root package name */
    private final Set<String> f٤٩٦٢e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    private volatile String f٤٩٦٣f = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class LruStrategyMap extends SerialLruCache<String, StrategyTable> {
        public LruStrategyMap() {
            super(3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // anet.channel.strategy.utils.SerialLruCache
        public boolean entryRemoved(Map.Entry<String, StrategyTable> entry) {
            anet.channel.strategy.utils.a.a(new f(this, entry));
            return true;
        }
    }

    private StrategyInfoHolder() {
        try {
            e();
            g();
        } catch (Throwable unused) {
        }
        f();
    }

    public static StrategyInfoHolder a() {
        return new StrategyInfoHolder();
    }

    private void e() {
        NetworkStatusHelper.addStatusChangeListener(this);
        this.f٤٩٦٣f = a(NetworkStatusHelper.getStatus());
    }

    private void f() {
        Iterator<Map.Entry<String, StrategyTable>> it = this.f٤٩٥٨a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a();
        }
        synchronized (this) {
            try {
                if (this.f٤٩٥٩b == null) {
                    StrategyConfig strategyConfig = new StrategyConfig();
                    strategyConfig.b();
                    strategyConfig.a(this);
                    this.f٤٩٥٩b = strategyConfig;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void g() {
        ALog.i("awcn.StrategyInfoHolder", "restore", null, new Object[0]);
        String str = this.f٤٩٦٣f;
        if (!AwcnConfig.isAsyncLoadStrategyEnable()) {
            if (!TextUtils.isEmpty(str)) {
                a(str, true);
            }
            this.f٤٩٥٩b = (StrategyConfig) m.a("StrategyConfig", null);
            if (this.f٤٩٥٩b != null) {
                this.f٤٩٥٩b.b();
                this.f٤٩٥٩b.a(this);
            }
        }
        anet.channel.strategy.utils.a.a(new d(this, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        NetworkStatusHelper.removeStatusChangeListener(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        synchronized (this) {
            try {
                for (StrategyTable strategyTable : this.f٤٩٥٨a.values()) {
                    if (strategyTable.f٤٩٧٢d) {
                        StrategyStatObject strategyStatObject = new StrategyStatObject(1);
                        String str = strategyTable.f٤٩٦٩a;
                        strategyStatObject.writeStrategyFileId = str;
                        m.a(strategyTable, str, strategyStatObject);
                        strategyTable.f٤٩٧٢d = false;
                    }
                }
                m.a(this.f٤٩٥٩b.a(), "StrategyConfig", null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StrategyTable d() {
        StrategyTable strategyTable = this.f٤٩٦١d;
        String str = this.f٤٩٦٣f;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f٤٩٥٨a) {
                strategyTable = this.f٤٩٥٨a.get(str);
                if (strategyTable == null) {
                    strategyTable = new StrategyTable(str);
                    this.f٤٩٥٨a.put(str, strategyTable);
                }
            }
        }
        return strategyTable;
    }

    @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
    public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f٤٩٦٣f = a(networkStatus);
        String str = this.f٤٩٦٣f;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f٤٩٥٨a) {
                try {
                    if (!this.f٤٩٥٨a.containsKey(str)) {
                        anet.channel.strategy.utils.a.a(new e(this, str));
                    }
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, boolean z10) {
        StrategyStatObject strategyStatObject;
        synchronized (this.f٤٩٦٢e) {
            if (this.f٤٩٦٢e.contains(str)) {
                return;
            }
            this.f٤٩٦٢e.add(str);
            if (z10) {
                strategyStatObject = new StrategyStatObject(0);
                strategyStatObject.readStrategyFileId = str;
            } else {
                strategyStatObject = null;
            }
            StrategyTable strategyTable = (StrategyTable) m.a(str, strategyStatObject);
            if (strategyTable != null) {
                strategyTable.a();
                synchronized (this.f٤٩٥٨a) {
                    this.f٤٩٥٨a.put(strategyTable.f٤٩٦٩a, strategyTable);
                }
            }
            synchronized (this.f٤٩٦٢e) {
                this.f٤٩٦٢e.remove(str);
            }
            if (z10) {
                strategyStatObject.isSucceed = strategyTable != null ? 1 : 0;
                AppMonitor.getInstance().commitStat(strategyStatObject);
            }
        }
    }

    private String a(NetworkStatusHelper.NetworkStatus networkStatus) {
        if (networkStatus.isWifi()) {
            String md5ToHex = StringUtils.md5ToHex(NetworkStatusHelper.getWifiBSSID());
            return "WIFI$" + (TextUtils.isEmpty(md5ToHex) ? "" : md5ToHex);
        }
        if (!networkStatus.isMobile()) {
            return "";
        }
        return networkStatus.getType() + "$" + NetworkStatusHelper.getApn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(l.d dVar) {
        int i10 = dVar.f٥٠٤٤g;
        if (i10 != 0) {
            AmdcRuntimeInfo.updateAmdcLimit(i10, dVar.f٥٠٤٥h);
        }
        d().update(dVar);
        this.f٤٩٥٩b.a(dVar);
    }
}
