package anet.channel.strategy;

import anet.channel.util.ALog;
import java.net.InetAddress;
import java.util.Collections;
import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f٤٩٧٨a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Object f٤٩٧٩b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ a f٤٩٨٠c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, Object obj) {
        this.f٤٩٨٠c = aVar;
        this.f٤٩٧٨a = str;
        this.f٤٩٧٩b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i10;
        try {
            try {
                String hostAddress = InetAddress.getByName(this.f٤٩٧٨a).getHostAddress();
                LinkedList linkedList = new LinkedList();
                ConnProtocol connProtocol = StrategyTemplate.getInstance().getConnProtocol(this.f٤٩٧٨a);
                if (connProtocol != null) {
                    if (!this.f٤٩٨٠c.a(connProtocol)) {
                        i10 = 80;
                    } else {
                        i10 = 443;
                    }
                    linkedList.add(IPConnStrategy.a(hostAddress, i10, connProtocol, 0, 0, 1, 45000));
                }
                linkedList.add(IPConnStrategy.a(hostAddress, 80, ConnProtocol.HTTP, 0, 0, 0, 0));
                linkedList.add(IPConnStrategy.a(hostAddress, 443, ConnProtocol.HTTPS, 0, 0, 0, 0));
                this.f٤٩٨٠c.f٤٩٧٦a.put(this.f٤٩٧٨a, linkedList);
                if (ALog.isPrintLog(1)) {
                    ALog.d("awcn.LocalDnsStrategyTable", "resolve ip by local dns", null, "host", this.f٤٩٧٨a, "ip", hostAddress, "list", linkedList);
                }
                synchronized (this.f٤٩٨٠c.f٤٩٧٧b) {
                    this.f٤٩٨٠c.f٤٩٧٧b.remove(this.f٤٩٧٨a);
                }
                synchronized (this.f٤٩٧٩b) {
                    this.f٤٩٧٩b.notifyAll();
                }
            } catch (Exception unused) {
                if (ALog.isPrintLog(1)) {
                    ALog.d("awcn.LocalDnsStrategyTable", "resolve ip by local dns failed", null, "host", this.f٤٩٧٨a);
                }
                this.f٤٩٨٠c.f٤٩٧٦a.put(this.f٤٩٧٨a, Collections.EMPTY_LIST);
                synchronized (this.f٤٩٨٠c.f٤٩٧٧b) {
                    this.f٤٩٨٠c.f٤٩٧٧b.remove(this.f٤٩٧٨a);
                    synchronized (this.f٤٩٧٩b) {
                        this.f٤٩٧٩b.notifyAll();
                    }
                }
            }
        } catch (Throwable th) {
            synchronized (this.f٤٩٨٠c.f٤٩٧٧b) {
                this.f٤٩٨٠c.f٤٩٧٧b.remove(this.f٤٩٧٨a);
                synchronized (this.f٤٩٧٩b) {
                    this.f٤٩٧٩b.notifyAll();
                    throw th;
                }
            }
        }
    }
}
