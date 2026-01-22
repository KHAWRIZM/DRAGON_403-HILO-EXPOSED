package anet.channel.strategy;

import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class StrategyList implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private List<IPConnStrategy> f٤٩٦٤a;

    /* renamed from: b, reason: collision with root package name */
    private Map<Integer, ConnHistoryItem> f٤٩٦٥b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f٤٩٦٦c;

    /* renamed from: d, reason: collision with root package name */
    private transient Comparator<IPConnStrategy> f٤٩٦٧d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface Predicate<T> {
        boolean apply(T t10);
    }

    public StrategyList() {
        this.f٤٩٦٤a = new ArrayList();
        this.f٤٩٦٥b = new SerialLruCache(40);
        this.f٤٩٦٦c = false;
        this.f٤٩٦٧d = null;
    }

    public void checkInit() {
        if (this.f٤٩٦٤a == null) {
            this.f٤٩٦٤a = new ArrayList();
        }
        if (this.f٤٩٦٥b == null) {
            this.f٤٩٦٥b = new SerialLruCache(40);
        }
        Iterator<Map.Entry<Integer, ConnHistoryItem>> it = this.f٤٩٦٥b.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().d()) {
                it.remove();
            }
        }
        for (IPConnStrategy iPConnStrategy : this.f٤٩٦٤a) {
            if (!this.f٤٩٦٥b.containsKey(Integer.valueOf(iPConnStrategy.getUniqueId()))) {
                this.f٤٩٦٥b.put(Integer.valueOf(iPConnStrategy.getUniqueId()), new ConnHistoryItem());
            }
        }
        Collections.sort(this.f٤٩٦٤a, a());
    }

    public List<IConnStrategy> getStrategyList() {
        if (this.f٤٩٦٤a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        LinkedList linkedList = null;
        for (IPConnStrategy iPConnStrategy : this.f٤٩٦٤a) {
            ConnHistoryItem connHistoryItem = this.f٤٩٦٥b.get(Integer.valueOf(iPConnStrategy.getUniqueId()));
            if (connHistoryItem != null && connHistoryItem.c()) {
                ALog.i("awcn.StrategyList", "strategy ban!", null, "strategy", iPConnStrategy);
            } else {
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                linkedList.add(iPConnStrategy);
            }
        }
        if (linkedList == null) {
            return Collections.EMPTY_LIST;
        }
        return linkedList;
    }

    public void notifyConnEvent(IConnStrategy iConnStrategy, ConnEvent connEvent) {
        if ((iConnStrategy instanceof IPConnStrategy) && this.f٤٩٦٤a.indexOf(iConnStrategy) != -1) {
            this.f٤٩٦٥b.get(Integer.valueOf(((IPConnStrategy) iConnStrategy).getUniqueId())).a(connEvent.isSuccess);
            Collections.sort(this.f٤٩٦٤a, this.f٤٩٦٧d);
        }
    }

    public boolean shouldRefresh() {
        boolean z10 = true;
        boolean z11 = true;
        for (IPConnStrategy iPConnStrategy : this.f٤٩٦٤a) {
            if (!this.f٤٩٦٥b.get(Integer.valueOf(iPConnStrategy.getUniqueId())).b()) {
                if (iPConnStrategy.f٤٩٤٤a == 0) {
                    z10 = false;
                }
                z11 = false;
            }
        }
        if ((this.f٤٩٦٦c && z10) || z11) {
            return true;
        }
        return false;
    }

    public String toString() {
        return new ArrayList(this.f٤٩٦٤a).toString();
    }

    public void update(l.b bVar) {
        int i10;
        Iterator<IPConnStrategy> it = this.f٤٩٦٤a.iterator();
        while (it.hasNext()) {
            it.next().f٤٩٤٦c = true;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < bVar.f٥٠٣١h.length; i12++) {
            int i13 = 0;
            while (true) {
                String[] strArr = bVar.f٥٠٢٩f;
                if (i13 >= strArr.length) {
                    break;
                }
                a(strArr[i13], 1, bVar.f٥٠٣١h[i12]);
                i13++;
            }
            if (bVar.f٥٠٣٠g != null) {
                this.f٤٩٦٦c = true;
                int i14 = 0;
                while (true) {
                    String[] strArr2 = bVar.f٥٠٣٠g;
                    if (i14 < strArr2.length) {
                        a(strArr2[i14], 0, bVar.f٥٠٣١h[i12]);
                        i14++;
                    }
                }
            } else {
                this.f٤٩٦٦c = false;
            }
        }
        if (bVar.f٥٠٣٢i != null) {
            while (true) {
                l.e[] eVarArr = bVar.f٥٠٣٢i;
                if (i11 >= eVarArr.length) {
                    break;
                }
                l.e eVar = eVarArr[i11];
                String str = eVar.f٥٠٤٦a;
                if (anet.channel.strategy.utils.c.c(str)) {
                    i10 = -1;
                } else {
                    i10 = 1;
                }
                a(str, i10, eVar.f٥٠٤٧b);
                i11++;
            }
        }
        ListIterator<IPConnStrategy> listIterator = this.f٤٩٦٤a.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().f٤٩٤٦c) {
                listIterator.remove();
            }
        }
        Collections.sort(this.f٤٩٦٤a, a());
    }

    private void a(String str, int i10, l.a aVar) {
        int a10 = a(this.f٤٩٦٤a, new j(this, aVar, str, ConnProtocol.valueOf(aVar)));
        if (a10 != -1) {
            IPConnStrategy iPConnStrategy = this.f٤٩٦٤a.get(a10);
            iPConnStrategy.cto = aVar.f٥٠١٨c;
            iPConnStrategy.rto = aVar.f٥٠١٩d;
            iPConnStrategy.heartbeat = aVar.f٥٠٢١f;
            iPConnStrategy.f٤٩٤٤a = i10;
            iPConnStrategy.f٤٩٤٥b = 0;
            iPConnStrategy.f٤٩٤٦c = false;
            return;
        }
        IPConnStrategy a11 = IPConnStrategy.a(str, aVar);
        if (a11 != null) {
            a11.f٤٩٤٤a = i10;
            a11.f٤٩٤٥b = 0;
            if (!this.f٤٩٦٥b.containsKey(Integer.valueOf(a11.getUniqueId()))) {
                this.f٤٩٦٥b.put(Integer.valueOf(a11.getUniqueId()), new ConnHistoryItem());
            }
            this.f٤٩٦٤a.add(a11);
        }
    }

    StrategyList(List<IPConnStrategy> list) {
        this.f٤٩٦٤a = new ArrayList();
        this.f٤٩٦٥b = new SerialLruCache(40);
        this.f٤٩٦٦c = false;
        this.f٤٩٦٧d = null;
        this.f٤٩٦٤a = list;
    }

    private Comparator a() {
        if (this.f٤٩٦٧d == null) {
            this.f٤٩٦٧d = new k(this);
        }
        return this.f٤٩٦٧d;
    }

    private static <T> int a(Collection<T> collection, Predicate<T> predicate) {
        if (collection == null) {
            return -1;
        }
        Iterator<T> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext() && !predicate.apply(it.next())) {
            i10++;
        }
        if (i10 == collection.size()) {
            return -1;
        }
        return i10;
    }
}
