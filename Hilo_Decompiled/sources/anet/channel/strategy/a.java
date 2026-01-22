package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    final ConcurrentHashMap<String, List<IPConnStrategy>> f٤٩٧٦a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    final HashMap<String, Object> f٤٩٧٧b = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public List a(String str) {
        Object obj;
        if (!TextUtils.isEmpty(str) && anet.channel.strategy.utils.c.c(str) && !DispatchConstants.getAmdcServerDomain().equalsIgnoreCase(str)) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.LocalDnsStrategyTable", "try resolve ip with local dns", null, "host", str);
            }
            List list = Collections.EMPTY_LIST;
            if (!this.f٤٩٧٦a.containsKey(str)) {
                synchronized (this.f٤٩٧٧b) {
                    try {
                        if (!this.f٤٩٧٧b.containsKey(str)) {
                            obj = new Object();
                            this.f٤٩٧٧b.put(str, obj);
                            a(str, obj);
                        } else {
                            obj = this.f٤٩٧٧b.get(str);
                        }
                    } finally {
                    }
                }
                if (obj != null) {
                    try {
                        synchronized (obj) {
                            obj.wait(500L);
                        }
                    } catch (InterruptedException unused) {
                    }
                }
            }
            List<IPConnStrategy> list2 = this.f٤٩٧٦a.get(str);
            if (list2 != null && list2 != Collections.EMPTY_LIST) {
                list = new ArrayList(list2);
            }
            ALog.i("awcn.LocalDnsStrategyTable", "get local strategy", null, "strategyList", list2);
            return list;
        }
        return Collections.EMPTY_LIST;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, ConnProtocol connProtocol) {
        List<IPConnStrategy> list = this.f٤٩٧٦a.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<IPConnStrategy> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getProtocol().equals(connProtocol)) {
                return;
            }
        }
        list.add(IPConnStrategy.a(list.get(0).getIp(), !a(connProtocol) ? 80 : 443, connProtocol, 0, 0, 1, 45000));
        ALog.i("awcn.LocalDnsStrategyTable", "setProtocolForHost", null, "strategyList", list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, IConnStrategy iConnStrategy, ConnEvent connEvent) {
        List<IPConnStrategy> list;
        if (connEvent.isSuccess || TextUtils.isEmpty(str) || connEvent.isAccs || (list = this.f٤٩٧٦a.get(str)) == null || list == Collections.EMPTY_LIST) {
            return;
        }
        Iterator<IPConnStrategy> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == iConnStrategy) {
                it.remove();
            }
        }
        if (list.isEmpty()) {
            this.f٤٩٧٦a.put(str, Collections.EMPTY_LIST);
        }
    }

    private void a(String str, Object obj) {
        anet.channel.strategy.utils.a.a(new b(this, str, obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ConnProtocol connProtocol) {
        return connProtocol.protocol.equalsIgnoreCase(HttpConstant.HTTPS) || connProtocol.protocol.equalsIgnoreCase(ConnType.H2S) || !TextUtils.isEmpty(connProtocol.publicKey);
    }
}
