package q4;

import f5.k;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Map f١٧١٢٥a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final b f١٧١٢٦b = new b();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final Lock f١٧١٢٧a = new ReentrantLock();

        /* renamed from: b, reason: collision with root package name */
        int f١٧١٢٨b;

        a() {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Queue f١٧١٢٩a = new ArrayDeque();

        b() {
        }

        a a() {
            a aVar;
            synchronized (this.f١٧١٢٩a) {
                aVar = (a) this.f١٧١٢٩a.poll();
            }
            if (aVar == null) {
                return new a();
            }
            return aVar;
        }

        void b(a aVar) {
            synchronized (this.f١٧١٢٩a) {
                try {
                    if (this.f١٧١٢٩a.size() < 10) {
                        this.f١٧١٢٩a.offer(aVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        a aVar;
        synchronized (this) {
            try {
                aVar = (a) this.f١٧١٢٥a.get(str);
                if (aVar == null) {
                    aVar = this.f١٧١٢٦b.a();
                    this.f١٧١٢٥a.put(str, aVar);
                }
                aVar.f١٧١٢٨b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        aVar.f١٧١٢٧a.lock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        a aVar;
        synchronized (this) {
            try {
                aVar = (a) k.d(this.f١٧١٢٥a.get(str));
                int i10 = aVar.f١٧١٢٨b;
                if (i10 >= 1) {
                    int i11 = i10 - 1;
                    aVar.f١٧١٢٨b = i11;
                    if (i11 == 0) {
                        a aVar2 = (a) this.f١٧١٢٥a.remove(str);
                        if (aVar2.equals(aVar)) {
                            this.f١٧١٢٦b.b(aVar2);
                        } else {
                            throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + aVar2 + ", safeKey: " + str);
                        }
                    }
                } else {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f١٧١٢٨b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        aVar.f١٧١٢٧a.unlock();
    }
}
