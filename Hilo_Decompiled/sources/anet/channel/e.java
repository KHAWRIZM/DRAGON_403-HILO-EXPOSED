package anet.channel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final Map<SessionRequest, List<Session>> f٤٧٤١a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final ReentrantReadWriteLock f٤٧٤٢b;

    /* renamed from: c, reason: collision with root package name */
    private final ReentrantReadWriteLock.ReadLock f٤٧٤٣c;

    /* renamed from: d, reason: collision with root package name */
    private final ReentrantReadWriteLock.WriteLock f٤٧٤٤d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f٤٧٤٢b = reentrantReadWriteLock;
        this.f٤٧٤٣c = reentrantReadWriteLock.readLock();
        this.f٤٧٤٤d = reentrantReadWriteLock.writeLock();
    }

    public void a(SessionRequest sessionRequest, Session session) {
        if (sessionRequest == null || sessionRequest.a() == null || session == null) {
            return;
        }
        this.f٤٧٤٤d.lock();
        try {
            List<Session> list = this.f٤٧٤١a.get(sessionRequest);
            if (list == null) {
                list = new ArrayList<>();
                this.f٤٧٤١a.put(sessionRequest, list);
            }
            if (list.indexOf(session) != -1) {
                this.f٤٧٤٤d.unlock();
                return;
            }
            list.add(session);
            Collections.sort(list);
            this.f٤٧٤٤d.unlock();
        } catch (Throwable th) {
            this.f٤٧٤٤d.unlock();
            throw th;
        }
    }

    public void b(SessionRequest sessionRequest, Session session) {
        this.f٤٧٤٤d.lock();
        try {
            List<Session> list = this.f٤٧٤١a.get(sessionRequest);
            if (list == null) {
                return;
            }
            list.remove(session);
            if (list.size() == 0) {
                this.f٤٧٤١a.remove(sessionRequest);
            }
        } finally {
            this.f٤٧٤٤d.unlock();
        }
    }

    public boolean c(SessionRequest sessionRequest, Session session) {
        this.f٤٧٤٣c.lock();
        try {
            List<Session> list = this.f٤٧٤١a.get(sessionRequest);
            boolean z10 = false;
            if (list != null) {
                if (list.indexOf(session) != -1) {
                    z10 = true;
                }
            }
            return z10;
        } finally {
            this.f٤٧٤٣c.unlock();
        }
    }

    public List<Session> a(SessionRequest sessionRequest) {
        this.f٤٧٤٣c.lock();
        try {
            List<Session> list = this.f٤٧٤١a.get(sessionRequest);
            if (list != null) {
                return new ArrayList(list);
            }
            return Collections.EMPTY_LIST;
        } finally {
            this.f٤٧٤٣c.unlock();
        }
    }

    public Session a(SessionRequest sessionRequest, int i10) {
        this.f٤٧٤٣c.lock();
        try {
            List<Session> list = this.f٤٧٤١a.get(sessionRequest);
            Session session = null;
            if (list != null && !list.isEmpty()) {
                for (Session session2 : list) {
                    if (session2 != null && session2.isAvailable() && (i10 == anet.channel.entity.c.f٤٧٧٣c || session2.f٤٦٢٠j.getType() == i10)) {
                        session = session2;
                        break;
                    }
                }
                return session;
            }
            return null;
        } finally {
            this.f٤٧٤٣c.unlock();
        }
    }

    public List<SessionRequest> a() {
        List<SessionRequest> list = Collections.EMPTY_LIST;
        this.f٤٧٤٣c.lock();
        try {
            return this.f٤٧٤١a.isEmpty() ? list : new ArrayList(this.f٤٧٤١a.keySet());
        } finally {
            this.f٤٧٤٣c.unlock();
        }
    }
}
