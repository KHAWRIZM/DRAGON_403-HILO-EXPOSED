package anet.channel.strategy.dispatch;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.util.ALog;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class HttpDispatcher {

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArraySet<IDispatchEventListener> f٤٩٨٦a;

    /* renamed from: b, reason: collision with root package name */
    private anet.channel.strategy.dispatch.a f٤٩٨٧b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f٤٩٨٨c;

    /* renamed from: d, reason: collision with root package name */
    private Set<String> f٤٩٨٩d;

    /* renamed from: e, reason: collision with root package name */
    private Set<String> f٤٩٩٠e;

    /* renamed from: f, reason: collision with root package name */
    private AtomicBoolean f٤٩٩١f;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface IDispatchEventListener {
        void onEvent(DispatchEvent dispatchEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static HttpDispatcher f٤٩٩٢a = new HttpDispatcher();

        private a() {
        }
    }

    public static HttpDispatcher getInstance() {
        return a.f٤٩٩٢a;
    }

    public static void setInitHosts(List<String> list) {
        if (list != null) {
            DispatchConstants.initHostArray = (String[]) list.toArray(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(DispatchEvent dispatchEvent) {
        Iterator<IDispatchEventListener> it = this.f٤٩٨٦a.iterator();
        while (it.hasNext()) {
            try {
                it.next().onEvent(dispatchEvent);
            } catch (Exception unused) {
            }
        }
    }

    public synchronized void addHosts(List<String> list) {
        if (list != null) {
            this.f٤٩٩٠e.addAll(list);
            this.f٤٩٨٩d.clear();
        }
    }

    public void addListener(IDispatchEventListener iDispatchEventListener) {
        this.f٤٩٨٦a.add(iDispatchEventListener);
    }

    public synchronized Set<String> getInitHosts() {
        a();
        return new HashSet(this.f٤٩٩٠e);
    }

    public boolean isInitHostsChanged(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean contains = this.f٤٩٨٩d.contains(str);
        if (!contains) {
            this.f٤٩٨٩d.add(str);
        }
        return !contains;
    }

    public void removeListener(IDispatchEventListener iDispatchEventListener) {
        this.f٤٩٨٦a.remove(iDispatchEventListener);
    }

    public void sendAmdcRequest(Set<String> set, int i10) {
        if (this.f٤٩٨٨c && set != null && !set.isEmpty()) {
            if (ALog.isPrintLog(2)) {
                ALog.i("awcn.HttpDispatcher", "sendAmdcRequest", null, DispatchConstants.HOSTS, set.toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put(DispatchConstants.HOSTS, set);
            hashMap.put(DispatchConstants.CONFIG_VERSION, String.valueOf(i10));
            this.f٤٩٨٧b.a(hashMap);
            return;
        }
        ALog.e("awcn.HttpDispatcher", "invalid parameter", null, new Object[0]);
    }

    public void setEnable(boolean z10) {
        this.f٤٩٨٨c = z10;
    }

    public void switchENV() {
        this.f٤٩٨٩d.clear();
        this.f٤٩٩٠e.clear();
        this.f٤٩٩١f.set(false);
    }

    private HttpDispatcher() {
        this.f٤٩٨٦a = new CopyOnWriteArraySet<>();
        this.f٤٩٨٧b = new anet.channel.strategy.dispatch.a();
        this.f٤٩٨٨c = true;
        this.f٤٩٨٩d = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f٤٩٩٠e = new TreeSet();
        this.f٤٩٩١f = new AtomicBoolean();
        a();
    }

    private void a() {
        if (this.f٤٩٩١f.get() || GlobalAppRuntimeInfo.getContext() == null || !this.f٤٩٩١f.compareAndSet(false, true)) {
            return;
        }
        this.f٤٩٩٠e.add(DispatchConstants.getAmdcServerDomain());
        if (GlobalAppRuntimeInfo.isTargetProcess()) {
            this.f٤٩٩٠e.addAll(Arrays.asList(DispatchConstants.initHostArray));
        }
    }
}
