package g0;

import android.net.Uri;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.SparseArray;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b {

    /* renamed from: y, reason: collision with root package name */
    public static final ThreadPoolExecutor f١٤٣٤٠y = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new l0.b("OkDownload file io"));

    /* renamed from: f, reason: collision with root package name */
    public final int f١٤٣٤٦f;

    /* renamed from: g, reason: collision with root package name */
    public final int f١٤٣٤٧g;

    /* renamed from: h, reason: collision with root package name */
    public final int f١٤٣٤٨h;

    /* renamed from: i, reason: collision with root package name */
    public final r0.g f١٤٣٤٩i;

    /* renamed from: j, reason: collision with root package name */
    public final n0.e f١٤٣٥٠j;

    /* renamed from: k, reason: collision with root package name */
    public final r0.d f١٤٣٥١k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f١٤٣٥٢l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f١٤٣٥٣m;

    /* renamed from: n, reason: collision with root package name */
    public volatile Future f١٤٣٥٤n;

    /* renamed from: o, reason: collision with root package name */
    public volatile Thread f١٤٣٥٥o;

    /* renamed from: q, reason: collision with root package name */
    public final h f١٤٣٥٧q;

    /* renamed from: r, reason: collision with root package name */
    public String f١٤٣٥٨r;

    /* renamed from: s, reason: collision with root package name */
    public IOException f١٤٣٥٩s;

    /* renamed from: t, reason: collision with root package name */
    public final ArrayList f١٤٣٦٠t;

    /* renamed from: u, reason: collision with root package name */
    public ArrayList f١٤٣٦١u;

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f١٤٣٤١a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray f١٤٣٤٢b = new SparseArray();

    /* renamed from: c, reason: collision with root package name */
    public final AtomicLong f١٤٣٤٣c = new AtomicLong();

    /* renamed from: d, reason: collision with root package name */
    public final AtomicLong f١٤٣٤٤d = new AtomicLong();

    /* renamed from: e, reason: collision with root package name */
    public boolean f١٤٣٤٥e = false;

    /* renamed from: p, reason: collision with root package name */
    public final SparseArray f١٤٣٥٦p = new SparseArray();

    /* renamed from: v, reason: collision with root package name */
    public final a f١٤٣٦٢v = new a();

    /* renamed from: w, reason: collision with root package name */
    public final a f١٤٣٦٣w = new a();

    /* renamed from: x, reason: collision with root package name */
    public volatile boolean f١٤٣٦٤x = true;

    public b(n0.e eVar, r0.g gVar, r0.d dVar) {
        this.f١٤٣٥٠j = eVar;
        this.f١٤٣٤٦f = eVar.f١٦١٢٠i;
        this.f١٤٣٤٧g = eVar.f١٦١٢١j;
        this.f١٤٣٤٨h = eVar.f١٦١٢٢k;
        this.f١٤٣٤٩i = gVar;
        this.f١٤٣٥١k = dVar;
        f fVar = n0.f.a().f١٦١٤١e;
        this.f١٤٣٥٢l = true;
        c cVar = n0.f.a().f١٦١٤٢f;
        f fVar2 = n0.f.a().f١٦١٤١e;
        this.f١٤٣٥٣m = true;
        this.f١٤٣٦٠t = new ArrayList();
        this.f١٤٣٥٧q = new h(this);
        File h10 = eVar.h();
        if (h10 != null) {
            this.f١٤٣٥٨r = h10.getAbsolutePath();
        }
    }

    public final void a() {
        int size;
        long j10;
        synchronized (this.f١٤٣٤٢b) {
            size = this.f١٤٣٤٢b.size();
        }
        SparseArray sparseArray = new SparseArray(size);
        int i10 = 0;
        while (true) {
            j10 = 0;
            if (i10 >= size) {
                break;
            }
            try {
                int keyAt = this.f١٤٣٤١a.keyAt(i10);
                long j11 = ((AtomicLong) this.f١٤٣٤٢b.get(keyAt)).get();
                if (j11 > 0) {
                    sparseArray.put(keyAt, Long.valueOf(j11));
                    e eVar = (e) ((d) this.f١٤٣٤١a.get(keyAt));
                    eVar.f١٤٣٦٨c.flush();
                    eVar.f١٤٣٦٧b.getFileDescriptor().sync();
                }
                i10++;
            } catch (IOException e10) {
                e10.toString();
                return;
            }
        }
        int size2 = sparseArray.size();
        for (int i11 = 0; i11 < size2; i11++) {
            int keyAt2 = sparseArray.keyAt(i11);
            long longValue = ((Long) sparseArray.valueAt(i11)).longValue();
            this.f١٤٣٥١k.g(this.f١٤٣٤٩i, keyAt2, longValue);
            j10 += longValue;
            ((AtomicLong) this.f١٤٣٤٢b.get(keyAt2)).addAndGet(-longValue);
            int i12 = this.f١٤٣٥٠j.f١٦١١٣b;
            ((r0.e) this.f١٤٣٤٩i.f١٧٢٨٨g.get(keyAt2)).f١٧٢٧٩c.get();
        }
        this.f١٤٣٤٣c.addAndGet(-j10);
        this.f١٤٣٤٤d.set(SystemClock.uptimeMillis());
    }

    public final synchronized void b(int i10) {
        d dVar = (d) this.f١٤٣٤١a.get(i10);
        if (dVar != null) {
            e eVar = (e) dVar;
            eVar.f١٤٣٦٨c.close();
            eVar.f١٤٣٦٩d.close();
            eVar.f١٤٣٦٧b.close();
            this.f١٤٣٤١a.remove(i10);
            int i11 = this.f١٤٣٥٠j.f١٦١١٣b;
        }
    }

    public final void c(int i10, boolean z10) {
        if (this.f١٤٣٥٤n != null && !this.f١٤٣٥٤n.isDone()) {
            if (!z10) {
                this.f١٤٣٥٦p.put(i10, Thread.currentThread());
            }
            if (this.f١٤٣٥٥o != null) {
                LockSupport.unpark(this.f١٤٣٥٥o);
            } else {
                while (this.f١٤٣٥٥o == null) {
                    LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(25L));
                }
                LockSupport.unpark(this.f١٤٣٥٥o);
            }
            if (z10) {
                LockSupport.unpark(this.f١٤٣٥٥o);
                try {
                    this.f١٤٣٥٤n.get();
                    return;
                } catch (InterruptedException | ExecutionException unused) {
                    return;
                }
            }
            LockSupport.park();
        }
    }

    public final void d(a aVar) {
        aVar.f١٤٣٣٩c.clear();
        if (new HashSet((List) this.f١٤٣٦٠t.clone()).size() != this.f١٤٣٦١u.size()) {
            int i10 = this.f١٤٣٥٠j.f١٦١١٣b;
            this.f١٤٣٦١u.size();
            aVar.f١٤٣٣٧a = false;
        } else {
            int i11 = this.f١٤٣٥٠j.f١٦١١٣b;
            this.f١٤٣٦١u.size();
            aVar.f١٤٣٣٧a = true;
        }
        SparseArray clone = this.f١٤٣٤١a.clone();
        int size = clone.size();
        for (int i12 = 0; i12 < size; i12++) {
            int keyAt = clone.keyAt(i12);
            if (this.f١٤٣٦٠t.contains(Integer.valueOf(keyAt)) && !aVar.f١٤٣٣٨b.contains(Integer.valueOf(keyAt))) {
                aVar.f١٤٣٣٨b.add(Integer.valueOf(keyAt));
                aVar.f١٤٣٣٩c.add(Integer.valueOf(keyAt));
            }
        }
    }

    public final synchronized d e(int i10) {
        Uri uri;
        try {
            d dVar = (d) this.f١٤٣٤١a.get(i10);
            if (dVar == null) {
                boolean equals = this.f١٤٣٥٠j.f١٦١١٥d.getScheme().equals("file");
                if (equals) {
                    File h10 = this.f١٤٣٥٠j.h();
                    if (h10 != null) {
                        File file = this.f١٤٣٥٠j.f١٦١٣٢u;
                        if (!file.exists() && !file.mkdirs()) {
                            throw new IOException("Create parent folder failed!");
                        }
                        if (h10.createNewFile()) {
                            h10.getName();
                        }
                        uri = Uri.fromFile(h10);
                    } else {
                        throw new FileNotFoundException("Filename is not ready!");
                    }
                } else {
                    uri = this.f١٤٣٥٠j.f١٦١١٥d;
                }
                f fVar = n0.f.a().f١٦١٤١e;
                e eVar = new e(n0.f.a().f١٦١٤٤h, uri, this.f١٤٣٤٦f);
                if (this.f١٤٣٥٢l) {
                    r0.e eVar2 = (r0.e) this.f١٤٣٤٩i.f١٧٢٨٨g.get(i10);
                    long j10 = eVar2.f١٧٢٧٩c.get() + eVar2.f١٧٢٧٧a;
                    if (j10 > 0) {
                        eVar.f١٤٣٦٦a.position(j10);
                        int i11 = this.f١٤٣٥٠j.f١٦١١٣b;
                    }
                }
                if (this.f١٤٣٦٤x) {
                    this.f١٤٣٥١k.f(this.f١٤٣٥٠j.f١٦١١٣b);
                }
                if (!this.f١٤٣٤٩i.f١٧٢٩٠i && this.f١٤٣٦٤x && this.f١٤٣٥٣m) {
                    long c10 = this.f١٤٣٤٩i.c();
                    if (equals) {
                        File h11 = this.f١٤٣٥٠j.h();
                        long length = c10 - h11.length();
                        if (length > 0) {
                            long b10 = l0.d.b(new StatFs(h11.getAbsolutePath()));
                            if (b10 >= length) {
                                eVar.a(c10);
                            } else {
                                throw new z.f(length, b10);
                            }
                        }
                    } else {
                        eVar.a(c10);
                    }
                }
                synchronized (this.f١٤٣٤٢b) {
                    this.f١٤٣٤١a.put(i10, eVar);
                    this.f١٤٣٤٢b.put(i10, new AtomicLong());
                }
                this.f١٤٣٦٤x = false;
                return eVar;
            }
            return dVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void f() {
        int i10;
        int i11;
        int i12 = this.f١٤٣٥٠j.f١٦١١٣b;
        this.f١٤٣٥٥o = Thread.currentThread();
        long j10 = this.f١٤٣٤٨h;
        a();
        while (true) {
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(j10));
            d(this.f١٤٣٦٣w);
            a aVar = this.f١٤٣٦٣w;
            if (!aVar.f١٤٣٣٧a && aVar.f١٤٣٣٩c.size() <= 0) {
                if (this.f١٤٣٤٣c.get() < this.f١٤٣٤٧g) {
                    i11 = this.f١٤٣٤٨h;
                } else {
                    j10 = this.f١٤٣٤٨h - (SystemClock.uptimeMillis() - this.f١٤٣٤٤d.get());
                    if (j10 <= 0) {
                        a();
                        i11 = this.f١٤٣٤٨h;
                    }
                }
                j10 = i11;
            } else {
                a aVar2 = this.f١٤٣٦٣w;
                boolean z10 = aVar2.f١٤٣٣٧a;
                Objects.toString(aVar2.f١٤٣٣٩c);
                if (this.f١٤٣٤٣c.get() > 0) {
                    a();
                }
                ArrayList arrayList = this.f١٤٣٦٣w.f١٤٣٣٩c;
                int size = arrayList.size();
                int i13 = 0;
                while (i13 < size) {
                    Object obj = arrayList.get(i13);
                    i13++;
                    Integer num = (Integer) obj;
                    Thread thread = (Thread) this.f١٤٣٥٦p.get(num.intValue());
                    this.f١٤٣٥٦p.remove(num.intValue());
                    if (thread != null) {
                        LockSupport.unpark(thread);
                    }
                }
                if (this.f١٤٣٦٣w.f١٤٣٣٧a) {
                    break;
                }
            }
        }
        int size2 = this.f١٤٣٥٦p.size();
        for (i10 = 0; i10 < size2; i10++) {
            Thread thread2 = (Thread) this.f١٤٣٥٦p.valueAt(i10);
            if (thread2 != null) {
                LockSupport.unpark(thread2);
            }
        }
        this.f١٤٣٥٦p.clear();
        int i14 = this.f١٤٣٥٠j.f١٦١١٣b;
    }

    public final void g() {
        IOException iOException = this.f١٤٣٥٩s;
        if (iOException == null) {
            if (this.f١٤٣٥٤n == null) {
                synchronized (this.f١٤٣٥٧q) {
                    try {
                        if (this.f١٤٣٥٤n == null) {
                            this.f١٤٣٥٤n = f١٤٣٤٠y.submit(this.f١٤٣٥٧q);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            }
            return;
        }
        throw iOException;
    }

    public final void h(int i10) {
        this.f١٤٣٦٠t.add(Integer.valueOf(i10));
        try {
            IOException iOException = this.f١٤٣٥٩s;
            if (iOException == null) {
                if (this.f١٤٣٥٤n != null && !this.f١٤٣٥٤n.isDone()) {
                    AtomicLong atomicLong = (AtomicLong) this.f١٤٣٤٢b.get(i10);
                    if (atomicLong != null && atomicLong.get() > 0) {
                        d(this.f١٤٣٦٢v);
                        c(i10, this.f١٤٣٦٢v.f١٤٣٣٧a);
                    }
                } else if (this.f١٤٣٥٤n == null) {
                    int i11 = this.f١٤٣٥٠j.f١٦١١٣b;
                } else {
                    this.f١٤٣٥٤n.isDone();
                    int i12 = this.f١٤٣٥٠j.f١٦١١٣b;
                }
                b(i10);
                return;
            }
            throw iOException;
        } catch (Throwable th) {
            b(i10);
            throw th;
        }
    }
}
