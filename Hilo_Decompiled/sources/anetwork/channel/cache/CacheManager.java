package anetwork.channel.cache;

import anet.channel.util.ALog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CacheManager {

    /* renamed from: a, reason: collision with root package name */
    private static List<a> f٥١٣٠a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static final ReentrantReadWriteLock f٥١٣١b;

    /* renamed from: c, reason: collision with root package name */
    private static final ReentrantReadWriteLock.ReadLock f٥١٣٢c;

    /* renamed from: d, reason: collision with root package name */
    private static final ReentrantReadWriteLock.WriteLock f٥١٣٣d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class a implements Comparable<a> {

        /* renamed from: a, reason: collision with root package name */
        final Cache f٥١٣٤a;

        /* renamed from: b, reason: collision with root package name */
        final CachePrediction f٥١٣٥b;

        /* renamed from: c, reason: collision with root package name */
        final int f٥١٣٦c;

        a(Cache cache, CachePrediction cachePrediction, int i10) {
            this.f٥١٣٤a = cache;
            this.f٥١٣٥b = cachePrediction;
            this.f٥١٣٦c = i10;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return this.f٥١٣٦c - aVar.f٥١٣٦c;
        }
    }

    static {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        f٥١٣١b = reentrantReadWriteLock;
        f٥١٣٢c = reentrantReadWriteLock.readLock();
        f٥١٣٣d = reentrantReadWriteLock.writeLock();
    }

    public static void addCache(Cache cache, CachePrediction cachePrediction, int i10) {
        try {
            if (cache != null) {
                if (cachePrediction != null) {
                    ReentrantReadWriteLock.WriteLock writeLock = f٥١٣٣d;
                    writeLock.lock();
                    f٥١٣٠a.add(new a(cache, cachePrediction, i10));
                    Collections.sort(f٥١٣٠a);
                    writeLock.unlock();
                    return;
                }
                throw new IllegalArgumentException("prediction is null");
            }
            throw new IllegalArgumentException("cache is null");
        } catch (Throwable th) {
            f٥١٣٣d.unlock();
            throw th;
        }
    }

    public static void clearAllCache() {
        ALog.w("anet.CacheManager", "clearAllCache", null, new Object[0]);
        Iterator<a> it = f٥١٣٠a.iterator();
        while (it.hasNext()) {
            try {
                it.next().f٥١٣٤a.clear();
            } catch (Exception unused) {
            }
        }
    }

    public static Cache getCache(String str, Map<String, String> map) {
        try {
            f٥١٣٢c.lock();
            for (a aVar : f٥١٣٠a) {
                if (aVar.f٥١٣٥b.handleCache(str, map)) {
                    return aVar.f٥١٣٤a;
                }
            }
            f٥١٣٢c.unlock();
            return null;
        } finally {
            f٥١٣٢c.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
    
        r0.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void removeCache(Cache cache) {
        try {
            f٥١٣٣d.lock();
            ListIterator<a> listIterator = f٥١٣٠a.listIterator();
            while (true) {
                if (!listIterator.hasNext()) {
                    break;
                } else if (listIterator.next().f٥١٣٤a == cache) {
                    break;
                }
            }
        } finally {
            f٥١٣٣d.unlock();
        }
    }
}
