package anet.channel.strategy;

import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.PolicyVersionStat;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class StrategyCollection implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    String f٤٩٤٧a;

    /* renamed from: b, reason: collision with root package name */
    volatile long f٤٩٤٨b;

    /* renamed from: c, reason: collision with root package name */
    volatile String f٤٩٤٩c;

    /* renamed from: d, reason: collision with root package name */
    boolean f٤٩٥٠d;

    /* renamed from: e, reason: collision with root package name */
    int f٤٩٥١e;

    /* renamed from: f, reason: collision with root package name */
    private StrategyList f٤٩٥٢f;

    /* renamed from: g, reason: collision with root package name */
    private transient long f٤٩٥٣g;

    /* renamed from: h, reason: collision with root package name */
    private transient boolean f٤٩٥٤h;

    public StrategyCollection() {
        this.f٤٩٥٢f = null;
        this.f٤٩٤٨b = 0L;
        this.f٤٩٤٩c = null;
        this.f٤٩٥٠d = false;
        this.f٤٩٥١e = 0;
        this.f٤٩٥٣g = 0L;
        this.f٤٩٥٤h = true;
    }

    public synchronized void checkInit() {
        if (System.currentTimeMillis() - this.f٤٩٤٨b > 172800000) {
            this.f٤٩٥٢f = null;
            return;
        }
        StrategyList strategyList = this.f٤٩٥٢f;
        if (strategyList != null) {
            strategyList.checkInit();
        }
    }

    public boolean isExpired() {
        if (System.currentTimeMillis() > this.f٤٩٤٨b) {
            return true;
        }
        return false;
    }

    public synchronized void notifyConnEvent(IConnStrategy iConnStrategy, ConnEvent connEvent) {
        StrategyList strategyList = this.f٤٩٥٢f;
        if (strategyList != null) {
            strategyList.notifyConnEvent(iConnStrategy, connEvent);
            if (!connEvent.isSuccess && this.f٤٩٥٢f.shouldRefresh()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f٤٩٥٣g > 60000) {
                    StrategyCenter.getInstance().forceRefreshStrategy(this.f٤٩٤٧a);
                    this.f٤٩٥٣g = currentTimeMillis;
                }
            }
        }
    }

    public synchronized List<IConnStrategy> queryStrategyList() {
        if (this.f٤٩٥٢f == null) {
            return Collections.EMPTY_LIST;
        }
        if (this.f٤٩٥٤h) {
            this.f٤٩٥٤h = false;
            PolicyVersionStat policyVersionStat = new PolicyVersionStat(this.f٤٩٤٧a, this.f٤٩٥١e);
            policyVersionStat.reportType = 0;
            AppMonitor.getInstance().commitStat(policyVersionStat);
        }
        return this.f٤٩٥٢f.getStrategyList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("\nStrategyList = ");
        sb.append(this.f٤٩٤٨b);
        StrategyList strategyList = this.f٤٩٥٢f;
        if (strategyList != null) {
            sb.append(strategyList.toString());
        } else if (this.f٤٩٤٩c != null) {
            sb.append('[');
            sb.append(this.f٤٩٤٧a);
            sb.append("=>");
            sb.append(this.f٤٩٤٩c);
            sb.append(']');
        } else {
            sb.append("[]");
        }
        return sb.toString();
    }

    public synchronized void update(l.b bVar) {
        l.e[] eVarArr;
        l.a[] aVarArr;
        this.f٤٩٤٨b = System.currentTimeMillis() + (bVar.f٥٠٢٥b * 1000);
        if (!bVar.f٥٠٢٤a.equalsIgnoreCase(this.f٤٩٤٧a)) {
            ALog.e("StrategyCollection", "update error!", null, "host", this.f٤٩٤٧a, "dnsInfo.host", bVar.f٥٠٢٤a);
            return;
        }
        int i10 = this.f٤٩٥١e;
        int i11 = bVar.f٥٠٣٥l;
        if (i10 != i11) {
            this.f٤٩٥١e = i11;
            PolicyVersionStat policyVersionStat = new PolicyVersionStat(this.f٤٩٤٧a, i11);
            policyVersionStat.reportType = 1;
            AppMonitor.getInstance().commitStat(policyVersionStat);
        }
        this.f٤٩٤٩c = bVar.f٥٠٢٧d;
        String[] strArr = bVar.f٥٠٢٩f;
        if ((strArr != null && strArr.length != 0 && (aVarArr = bVar.f٥٠٣١h) != null && aVarArr.length != 0) || ((eVarArr = bVar.f٥٠٣٢i) != null && eVarArr.length != 0)) {
            if (this.f٤٩٥٢f == null) {
                this.f٤٩٥٢f = new StrategyList();
            }
            this.f٤٩٥٢f.update(bVar);
            return;
        }
        this.f٤٩٥٢f = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StrategyCollection(String str) {
        this.f٤٩٥٢f = null;
        this.f٤٩٤٨b = 0L;
        this.f٤٩٤٩c = null;
        this.f٤٩٥٠d = false;
        this.f٤٩٥١e = 0;
        this.f٤٩٥٣g = 0L;
        this.f٤٩٥٤h = true;
        this.f٤٩٤٧a = str;
        this.f٤٩٥٠d = DispatchConstants.isAmdcServerDomain(str);
    }
}
