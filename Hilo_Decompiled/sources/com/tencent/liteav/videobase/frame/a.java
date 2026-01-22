package com.tencent.liteav.videobase.frame;

import android.os.SystemClock;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.i;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class a<T extends i> {
    private static final long a = TimeUnit.SECONDS.toMillis(1);
    private final Map<InterfaceC٠٠١٦a, Deque<T>> c = new HashMap();
    private volatile boolean d = false;
    private final com.tencent.liteav.base.b.a e = new com.tencent.liteav.base.b.a(a);
    private final g<T> f = new g(this) { // from class: com.tencent.liteav.videobase.frame.b
        private final a a;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            this.a = this;
        }

        @Override // com.tencent.liteav.videobase.frame.g
        public final void a(i iVar) {
            a.a(this.a, iVar);
        }
    };
    private final String b = null;

    /* renamed from: com.tencent.liteav.videobase.frame.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface InterfaceC٠٠١٦a {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(a aVar, i iVar) {
        if (iVar == 0) {
            return;
        }
        synchronized (aVar.c) {
            try {
                if (aVar.d) {
                    aVar.a((a) iVar);
                    return;
                }
                Deque<T> b = aVar.b(aVar.b((a) iVar));
                iVar.updateLastUsedTimestamp(SystemClock.elapsedRealtime());
                b.addFirst(iVar);
                aVar.c();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c() {
        T peekLast;
        if (!this.e.a()) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ArrayList arrayList = new ArrayList();
        synchronized (this.c) {
            try {
                for (Deque<T> deque : this.c.values()) {
                    while (!deque.isEmpty() && ((peekLast = deque.peekLast()) == null || elapsedRealtime - peekLast.getLastUsedTimestamp() >= a)) {
                        deque.pollLast();
                        arrayList.add(peekLast);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a((a<T>) it.next());
        }
    }

    protected abstract T a(g<T> gVar, InterfaceC٠٠١٦a r2);

    protected abstract void a(T t);

    protected abstract InterfaceC٠٠١٦a b(T t);

    public void b() {
        this.d = true;
        a();
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (!this.d) {
            LiteavLog.e("FramePool", "%s must call destroy() before finalize()!\n%s", getClass().getName(), this.b);
        }
    }

    private Deque<T> b(InterfaceC٠٠١٦a r3) {
        Deque<T> deque = this.c.get(r3);
        if (deque != null) {
            return deque;
        }
        LinkedList linkedList = new LinkedList();
        this.c.put(r3, linkedList);
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final T a(InterfaceC٠٠١٦a r5) {
        T removeFirst;
        synchronized (this.c) {
            try {
                Deque<T> b = b(r5);
                removeFirst = !b.isEmpty() ? b.removeFirst() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        c();
        if (removeFirst == null) {
            removeFirst = a(this.f, r5);
        }
        if (removeFirst.retain() != 1) {
            LiteavLog.e("FramePool", "invalid reference count for %s", removeFirst);
        }
        return removeFirst;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.c) {
            try {
                Iterator<Deque<T>> it = this.c.values().iterator();
                while (it.hasNext()) {
                    arrayList.addAll(it.next());
                }
                this.c.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            a((a<T>) it2.next());
        }
    }
}
