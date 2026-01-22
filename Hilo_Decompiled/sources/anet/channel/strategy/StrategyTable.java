package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.entity.ConnType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class StrategyTable implements Serializable {

    /* renamed from: e, reason: collision with root package name */
    protected static Comparator<StrategyCollection> f٤٩٦٨e = new o();

    /* renamed from: a, reason: collision with root package name */
    protected String f٤٩٦٩a;

    /* renamed from: b, reason: collision with root package name */
    protected volatile String f٤٩٧٠b;

    /* renamed from: c, reason: collision with root package name */
    Map<String, Long> f٤٩٧١c;

    /* renamed from: d, reason: collision with root package name */
    protected transient boolean f٤٩٧٢d = false;

    /* renamed from: f, reason: collision with root package name */
    private HostLruCache f٤٩٧٣f;

    /* renamed from: g, reason: collision with root package name */
    private volatile transient int f٤٩٧٤g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class HostLruCache extends SerialLruCache<String, StrategyCollection> {
        public HostLruCache(int i10) {
            super(i10);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // anet.channel.strategy.utils.SerialLruCache
        public boolean entryRemoved(Map.Entry<String, StrategyCollection> entry) {
            if (!entry.getValue().f٤٩٥٠d) {
                return true;
            }
            Iterator<Map.Entry<String, StrategyCollection>> it = entrySet().iterator();
            while (it.hasNext()) {
                if (!it.next().getValue().f٤٩٥٠d) {
                    it.remove();
                    return false;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StrategyTable(String str) {
        this.f٤٩٦٩a = str;
        a();
    }

    private void b() {
        if (HttpDispatcher.getInstance().isInitHostsChanged(this.f٤٩٦٩a)) {
            for (String str : HttpDispatcher.getInstance().getInitHosts()) {
                this.f٤٩٧٣f.put(str, new StrategyCollection(str));
            }
        }
    }

    private void c() {
        TreeSet treeSet;
        try {
            if (HttpDispatcher.getInstance().isInitHostsChanged(this.f٤٩٦٩a)) {
                synchronized (this.f٤٩٧٣f) {
                    try {
                        treeSet = null;
                        for (String str : HttpDispatcher.getInstance().getInitHosts()) {
                            if (!this.f٤٩٧٣f.containsKey(str)) {
                                this.f٤٩٧٣f.put(str, new StrategyCollection(str));
                                if (treeSet == null) {
                                    treeSet = new TreeSet();
                                }
                                treeSet.add(str);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (treeSet != null) {
                    a(treeSet);
                }
            }
        } catch (Exception e10) {
            ALog.e("awcn.StrategyTable", "checkInitHost failed", this.f٤٩٦٩a, e10, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        if (this.f٤٩٧٣f == null) {
            this.f٤٩٧٣f = new HostLruCache(256);
            b();
        }
        Iterator<StrategyCollection> it = this.f٤٩٧٣f.values().iterator();
        while (it.hasNext()) {
            it.next().checkInit();
        }
        ALog.i("awcn.StrategyTable", "strategy map", null, "size", Integer.valueOf(this.f٤٩٧٣f.size()));
        this.f٤٩٧٤g = GlobalAppRuntimeInfo.isTargetProcess() ? 0 : -1;
        if (this.f٤٩٧١c == null) {
            this.f٤٩٧١c = new ConcurrentHashMap();
        }
    }

    public String getCnameByHost(String str) {
        StrategyCollection strategyCollection;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f٤٩٧٣f) {
            strategyCollection = this.f٤٩٧٣f.get(str);
        }
        if (strategyCollection != null && strategyCollection.isExpired() && AmdcRuntimeInfo.getAmdcLimitLevel() == 0) {
            a(str);
        }
        if (strategyCollection == null) {
            return null;
        }
        return strategyCollection.f٤٩٤٩c;
    }

    public List<IConnStrategy> queryByHost(String str) {
        StrategyCollection strategyCollection;
        if (!TextUtils.isEmpty(str) && anet.channel.strategy.utils.c.c(str)) {
            c();
            synchronized (this.f٤٩٧٣f) {
                try {
                    strategyCollection = this.f٤٩٧٣f.get(str);
                    if (strategyCollection == null) {
                        strategyCollection = new StrategyCollection(str);
                        this.f٤٩٧٣f.put(str, strategyCollection);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (strategyCollection.f٤٩٤٨b == 0 || (strategyCollection.isExpired() && AmdcRuntimeInfo.getAmdcLimitLevel() == 0)) {
                a(str);
            }
            return strategyCollection.queryStrategyList();
        }
        return Collections.EMPTY_LIST;
    }

    public void update(l.d dVar) {
        l.b[] bVarArr;
        String str;
        ALog.i("awcn.StrategyTable", "update strategyTable with httpDns response", this.f٤٩٦٩a, new Object[0]);
        try {
            this.f٤٩٧٠b = dVar.f٥٠٣٨a;
            this.f٤٩٧٤g = dVar.f٥٠٤٣f;
            bVarArr = dVar.f٥٠٣٩b;
        } catch (Throwable th) {
            ALog.e("awcn.StrategyTable", "fail to update strategyTable", this.f٤٩٦٩a, th, new Object[0]);
        }
        if (bVarArr == null) {
            return;
        }
        synchronized (this.f٤٩٧٣f) {
            for (l.b bVar : bVarArr) {
                try {
                    if (bVar != null && (str = bVar.f٥٠٢٤a) != null) {
                        if (bVar.f٥٠٣٣j) {
                            this.f٤٩٧٣f.remove(str);
                        } else {
                            StrategyCollection strategyCollection = this.f٤٩٧٣f.get(str);
                            if (strategyCollection == null) {
                                strategyCollection = new StrategyCollection(bVar.f٥٠٢٤a);
                                this.f٤٩٧٣f.put(bVar.f٥٠٢٤a, strategyCollection);
                            }
                            strategyCollection.update(bVar);
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        this.f٤٩٧٢d = true;
        if (ALog.isPrintLog(1)) {
            StringBuilder sb = new StringBuilder("uniqueId : ");
            sb.append(this.f٤٩٦٩a);
            sb.append("\n-------------------------domains:------------------------------------");
            ALog.d("awcn.StrategyTable", sb.toString(), null, new Object[0]);
            synchronized (this.f٤٩٧٣f) {
                try {
                    for (Map.Entry<String, StrategyCollection> entry : this.f٤٩٧٣f.entrySet()) {
                        sb.setLength(0);
                        sb.append(entry.getKey());
                        sb.append(" = ");
                        sb.append(entry.getValue().toString());
                        ALog.d("awcn.StrategyTable", sb.toString(), null, new Object[0]);
                    }
                } finally {
                }
            }
        }
    }

    private void b(Set<String> set) {
        TreeSet treeSet = new TreeSet(f٤٩٦٨e);
        synchronized (this.f٤٩٧٣f) {
            treeSet.addAll(this.f٤٩٧٣f.values());
        }
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            StrategyCollection strategyCollection = (StrategyCollection) it.next();
            if (!strategyCollection.isExpired() || set.size() >= 40) {
                return;
            }
            strategyCollection.f٤٩٤٨b = 30000 + currentTimeMillis;
            set.add(strategyCollection.f٤٩٤٧a);
        }
    }

    private void a(String str) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(str);
        a(treeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, boolean z10) {
        StrategyCollection strategyCollection;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f٤٩٧٣f) {
            try {
                strategyCollection = this.f٤٩٧٣f.get(str);
                if (strategyCollection == null) {
                    strategyCollection = new StrategyCollection(str);
                    this.f٤٩٧٣f.put(str, strategyCollection);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z10 || strategyCollection.f٤٩٤٨b == 0 || (strategyCollection.isExpired() && AmdcRuntimeInfo.getAmdcLimitLevel() == 0)) {
            a(str);
        }
    }

    private void a(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        if ((GlobalAppRuntimeInfo.isAppBackground() && AppLifecycle.lastEnterBackgroundTime > 0) || !NetworkStatusHelper.isConnected()) {
            ALog.i("awcn.StrategyTable", "app in background or no network", this.f٤٩٦٩a, new Object[0]);
            return;
        }
        int amdcLimitLevel = AmdcRuntimeInfo.getAmdcLimitLevel();
        if (amdcLimitLevel == 3) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f٤٩٧٣f) {
            try {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    StrategyCollection strategyCollection = this.f٤٩٧٣f.get(it.next());
                    if (strategyCollection != null) {
                        strategyCollection.f٤٩٤٨b = 30000 + currentTimeMillis;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (amdcLimitLevel == 0) {
            b(set);
        }
        HttpDispatcher.getInstance().sendAmdcRequest(set, this.f٤٩٧٤g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, IConnStrategy iConnStrategy, ConnEvent connEvent) {
        StrategyCollection strategyCollection;
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.StrategyTable", "[notifyConnEvent]", null, "Host", str, "IConnStrategy", iConnStrategy, "ConnEvent", connEvent);
        }
        String str2 = iConnStrategy.getProtocol().protocol;
        if (ConnType.HTTP3.equals(str2) || ConnType.HTTP3_PLAIN.equals(str2)) {
            anet.channel.e.a.a(connEvent.isSuccess);
            ALog.e("awcn.StrategyTable", "enable http3", null, "uniqueId", this.f٤٩٦٩a, "enable", Boolean.valueOf(connEvent.isSuccess));
        }
        if (!connEvent.isSuccess && anet.channel.strategy.utils.c.b(iConnStrategy.getIp())) {
            this.f٤٩٧١c.put(str, Long.valueOf(System.currentTimeMillis()));
            ALog.e("awcn.StrategyTable", "disable ipv6", null, "uniqueId", this.f٤٩٦٩a, "host", str);
        }
        synchronized (this.f٤٩٧٣f) {
            strategyCollection = this.f٤٩٧٣f.get(str);
        }
        if (strategyCollection != null) {
            strategyCollection.notifyConnEvent(iConnStrategy, connEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str, long j10) {
        Long l10 = this.f٤٩٧١c.get(str);
        if (l10 == null) {
            return false;
        }
        if (l10.longValue() + j10 >= System.currentTimeMillis()) {
            return true;
        }
        this.f٤٩٧١c.remove(str);
        return false;
    }
}
