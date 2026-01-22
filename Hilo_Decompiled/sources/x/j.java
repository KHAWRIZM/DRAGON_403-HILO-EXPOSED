package x;

import android.os.SystemClock;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import w.m;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class j extends l0.c implements Comparable {

    /* renamed from: j, reason: collision with root package name */
    public static final ThreadPoolExecutor f١٨٨٥٨j = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new l0.b("OkDownload Block"));

    /* renamed from: b, reason: collision with root package name */
    public final n0.e f١٨٨٥٩b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f١٨٨٦٠c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f١٨٨٦١d;

    /* renamed from: e, reason: collision with root package name */
    public volatile i f١٨٨٦٢e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f١٨٨٦٣f;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f١٨٨٦٤g;

    /* renamed from: h, reason: collision with root package name */
    public volatile Thread f١٨٨٦٥h;

    /* renamed from: i, reason: collision with root package name */
    public final r0.d f١٨٨٦٦i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(n0.e eVar, r0.d dVar) {
        super("download call: " + eVar.f١٦١١٣b);
        ArrayList arrayList = new ArrayList();
        this.f١٨٨٥٩b = eVar;
        this.f١٨٨٦٠c = true;
        this.f١٨٨٦١d = arrayList;
        this.f١٨٨٦٦i = dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x02c5 A[LOOP:0: B:2:0x0025->B:105:0x02c5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x004d A[EDGE_INSN: B:106:0x004d->B:107:0x004d BREAK  A[LOOP:0: B:2:0x0025->B:105:0x02c5], SYNTHETIC] */
    @Override // l0.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        Exception exc;
        int i10;
        int i11;
        boolean z10;
        int i12;
        ArrayList arrayList;
        g0.c cVar;
        ArrayList arrayList2;
        int i13;
        String str;
        this.f١٨٨٦٥h = Thread.currentThread();
        n0.f a10 = n0.f.a();
        g0.c cVar2 = a10.f١٦١٤٢f;
        r0.d dVar = this.f١٨٨٦٦i;
        int i14 = this.f١٨٨٥٩b.f١٦١١٣b;
        dVar.a();
        n0.f.a().f١٦١٣٨b.f١٨٦٦٣a.b(this.f١٨٨٥٩b);
        int i15 = 0;
        while (true) {
            if (this.f١٨٨٥٩b.f١٦١١٤c.length() <= 0) {
                this.f١٨٨٦٢e = new h(new IOException("unexpected url: " + this.f١٨٨٥٩b.f١٦١١٤c));
                break;
            }
            if (this.f١٨٨٦٣f) {
                break;
            }
            try {
                r0.g gVar = this.f١٨٨٦٦i.get(this.f١٨٨٥٩b.f١٦١١٣b);
                if (gVar == null) {
                    gVar = this.f١٨٨٦٦i.b(this.f١٨٨٥٩b);
                }
                this.f١٨٨٥٩b.f١٦١١٧f = gVar;
                if (this.f١٨٨٦٣f) {
                    break;
                }
                g0.c cVar3 = n0.f.a().f١٦١٤٢f;
                i iVar = new i(new g0.b(this.f١٨٨٥٩b, gVar, this.f١٨٨٦٦i));
                this.f١٨٨٦٢e = iVar;
                g gVar2 = new g(this.f١٨٨٥٩b, gVar);
                try {
                    gVar2.a();
                    n0.e eVar = this.f١٨٨٥٩b;
                    iVar.f١٨٨٤٩a = eVar.f١٦١٣٤w;
                    cVar2.f١٤٣٦٥a.b(eVar.h().getAbsolutePath());
                    e eVar2 = n0.f.a().f١٦١٤٣g;
                    n0.e eVar3 = this.f١٨٨٥٩b;
                    long j10 = gVar2.f١٨٨٤٦d;
                    if (eVar3.f١٦١٢٩r) {
                        r0.c cVar4 = n0.f.a().f١٦١٣٩c;
                        r0.g h10 = cVar4.f١٧٢٧٦b.h(eVar3, gVar);
                        if (h10 != null) {
                            cVar4.remove(h10.f١٧٢٨٢a);
                            long e10 = h10.e();
                            e eVar4 = n0.f.a().f١٦١٤٣g;
                            if (e10 > 10240 && (((str = h10.f١٧٢٨٤c) == null || str.equals(gVar.f١٧٢٨٤c)) && h10.c() == j10 && h10.d() != null && h10.d().exists())) {
                                gVar.f١٧٢٨٨g.clear();
                                gVar.f١٧٢٨٨g.addAll(h10.f١٧٢٨٨g);
                                gVar.toString();
                            }
                        }
                    }
                    try {
                        if (gVar2.f١٨٨٤٤b) {
                            d dVar2 = new d(this.f١٨٨٥٩b, gVar, gVar2.f١٨٨٤٦d);
                            dVar2.a();
                            if (dVar2.f١٨٨٢٥a) {
                                int i16 = this.f١٨٨٥٩b.f١٦١١٣b;
                                dVar2.toString();
                                File h11 = this.f١٨٨٥٩b.h();
                                if (h11 != null && h11.exists() && !h11.delete()) {
                                    throw new IOException("Delete file failed!");
                                }
                                if (!dVar2.f١٨٨٢٧c) {
                                    i13 = 1;
                                } else if (!dVar2.f١٨٨٢٦b) {
                                    i13 = 2;
                                } else if (!dVar2.f١٨٨٢٨d) {
                                    i13 = 3;
                                } else {
                                    throw new IllegalStateException("No cause find with dirty: " + dVar2.f١٨٨٢٥a);
                                }
                                d(gVar, gVar2, i13);
                            } else {
                                m mVar = a10.f١٦١٣٨b.f١٨٦٦٣a;
                                n0.e eVar5 = this.f١٨٨٥٩b;
                                mVar.getClass();
                                int i17 = eVar5.f١٦١١٣b;
                                n0.f.a().getClass();
                                if (eVar5.f١٦١٢٥n) {
                                    mVar.f١٨٦٦١a.post(new w.c(eVar5, gVar));
                                } else {
                                    eVar5.f١٦١٢٧p.f(eVar5, gVar);
                                }
                            }
                        } else {
                            int i18 = this.f١٨٨٥٩b.f١٦١١٣b;
                            gVar2.toString();
                            File h12 = this.f١٨٨٥٩b.h();
                            if (h12 != null && h12.exists() && !h12.delete()) {
                                throw new IOException("Delete file failed!");
                            }
                            int i19 = gVar2.f١٨٨٤٥c;
                            if (i19 != 0) {
                                d(gVar, gVar2, i19);
                            } else {
                                throw new IllegalStateException("No cause find with resumable: " + gVar2.f١٨٨٤٤b);
                            }
                        }
                        int size = gVar.f١٧٢٨٨g.size();
                        ArrayList arrayList3 = new ArrayList(gVar.f١٧٢٨٨g.size());
                        ArrayList arrayList4 = new ArrayList();
                        int i20 = 0;
                        while (i20 < size) {
                            r0.e eVar6 = (r0.e) gVar.f١٧٢٨٨g.get(i20);
                            if (eVar6.f١٧٢٧٩c.get() == eVar6.f١٧٢٧٨b) {
                                cVar = cVar2;
                                i12 = i20;
                                arrayList = arrayList4;
                                arrayList2 = arrayList3;
                            } else {
                                if (eVar6.f١٧٢٧٩c.get() < 0 || eVar6.f١٧٢٧٩c.get() > eVar6.f١٧٢٧٨b) {
                                    eVar6.toString();
                                    eVar6.f١٧٢٧٩c.set(0L);
                                }
                                i12 = i20;
                                arrayList = arrayList4;
                                cVar = cVar2;
                                arrayList2 = arrayList3;
                                b bVar = new b(i20, this.f١٨٨٥٩b, gVar, iVar, this.f١٨٨٦٦i);
                                arrayList2.add(bVar);
                                arrayList.add(Integer.valueOf(bVar.f١٨٨٠٨a));
                            }
                            i20 = i12 + 1;
                            arrayList3 = arrayList2;
                            arrayList4 = arrayList;
                            cVar2 = cVar;
                        }
                        g0.c cVar5 = cVar2;
                        ArrayList arrayList5 = arrayList4;
                        ArrayList arrayList6 = arrayList3;
                        if (!this.f١٨٨٦٣f) {
                            iVar.a().f١٤٣٦١u = arrayList5;
                            ArrayList arrayList7 = new ArrayList(arrayList6.size());
                            try {
                                int size2 = arrayList6.size();
                                int i21 = 0;
                                while (i21 < size2) {
                                    Object obj = arrayList6.get(i21);
                                    i21++;
                                    arrayList7.add(f١٨٨٥٨j.submit((b) obj));
                                }
                                this.f١٨٨٦١d.addAll(arrayList6);
                                int size3 = arrayList7.size();
                                int i22 = 0;
                                while (i22 < size3) {
                                    Object obj2 = arrayList7.get(i22);
                                    i22++;
                                    Future future = (Future) obj2;
                                    if (!future.isDone()) {
                                        try {
                                            future.get();
                                        } catch (CancellationException | ExecutionException unused) {
                                        }
                                    }
                                }
                                this.f١٨٨٦١d.removeAll(arrayList6);
                            } finally {
                                try {
                                    int size4 = arrayList7.size();
                                    int i23 = 0;
                                    while (i23 < size4) {
                                        Object obj3 = arrayList7.get(i23);
                                        i23++;
                                        ((Future) obj3).cancel(true);
                                    }
                                    throw th;
                                } finally {
                                    this.f١٨٨٦١d.removeAll(arrayList6);
                                }
                            }
                        }
                        if (this.f١٨٨٦٣f) {
                            break;
                        }
                        if (iVar.f١٨٨٥١c) {
                            int i24 = i15 + 1;
                            if (i15 < 1) {
                                this.f١٨٨٦٦i.remove(this.f١٨٨٥٩b.f١٦١١٣b);
                                i15 = i24;
                                z10 = true;
                                if (z10) {
                                    break;
                                } else {
                                    cVar2 = cVar5;
                                }
                            } else {
                                i15 = i24;
                            }
                        }
                        z10 = false;
                        if (z10) {
                        }
                    } catch (IOException e11) {
                        iVar.f١٨٨٥٤f = true;
                        iVar.f١٨٨٥٧i = e11;
                    }
                } catch (Exception e12) {
                    iVar.b(e12);
                }
            } catch (IOException e13) {
                this.f١٨٨٦٢e = new h(e13);
            }
        }
        this.f١٨٨٦٤g = true;
        this.f١٨٨٦١d.clear();
        i iVar2 = this.f١٨٨٦٢e;
        if (!this.f١٨٨٦٣f && iVar2 != null) {
            if (!iVar2.f١٨٨٥٣e && !iVar2.f١٨٨٥٤f && !iVar2.f١٨٨٥١c) {
                exc = null;
                if (iVar2.f١٨٨٥٥g) {
                    i11 = 4;
                } else if (iVar2.f١٨٨٥٦h) {
                    exc = iVar2.f١٨٨٥٧i;
                    i11 = 6;
                } else {
                    i10 = 3;
                    i11 = 1;
                }
                i10 = 3;
            } else {
                exc = iVar2.f١٨٨٥٧i;
                i10 = 3;
                i11 = 2;
            }
            if (i11 != i10) {
                synchronized (this) {
                    try {
                        if (!this.f١٨٨٦٣f) {
                            this.f١٨٨٦٤g = true;
                            this.f١٨٨٦٦i.e(this.f١٨٨٥٩b.f١٦١١٣b, i11);
                            if (i11 == 1) {
                                this.f١٨٨٦٦i.d(this.f١٨٨٥٩b.f١٦١١٣b);
                                g0.c cVar6 = n0.f.a().f١٦١٤٢f;
                                iVar2.a();
                            }
                            n0.f.a().f١٦١٣٨b.f١٨٦٦٣a.d(this.f١٨٨٥٩b, i11, exc);
                        }
                    } finally {
                    }
                }
                return;
            }
            throw new IllegalAccessError("can't recognize cancelled on here");
        }
    }

    @Override // l0.c
    public final void c() {
        ArrayList arrayList;
        w.a aVar = n0.f.a().f١٦١٣٧a;
        synchronized (aVar) {
            try {
                boolean z10 = this.f١٨٨٦٠c;
                if (aVar.f١٨٦٣٦e.contains(this)) {
                    arrayList = aVar.f١٨٦٣٦e;
                } else if (z10) {
                    arrayList = aVar.f١٨٦٣٤c;
                } else {
                    arrayList = aVar.f١٨٦٣٥d;
                }
                if (arrayList.remove(this)) {
                    if (z10 && this.f١٨٨٦٣f) {
                        aVar.f١٨٦٣٧f.decrementAndGet();
                    }
                    if (z10) {
                        aVar.h();
                    }
                } else {
                    throw new AssertionError("Call wasn't in-flight!");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int i10 = this.f١٨٨٥٩b.f١٦١١٣b;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return ((j) obj).f١٨٨٥٩b.f١٦١١٨g - this.f١٨٨٥٩b.f١٦١١٨g;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(r0.g gVar, g gVar2, int i10) {
        int i11;
        int i12;
        n0.e eVar = this.f١٨٨٥٩b;
        long j10 = gVar2.f١٨٨٤٦d;
        boolean z10 = gVar2.f١٨٨٤٣a;
        e eVar2 = n0.f.a().f١٦١٤٣g;
        g0.f fVar = n0.f.a().f١٦١٤١e;
        if (z10) {
            e eVar3 = n0.f.a().f١٦١٤٣g;
            Integer num = eVar.f١٦١٢٣l;
            if (num != null) {
                i11 = num.intValue();
            } else if (j10 >= 1048576) {
                if (j10 < 5242880) {
                    i11 = 2;
                } else if (j10 < 52428800) {
                    i11 = 3;
                } else if (j10 < 104857600) {
                    i11 = 4;
                } else {
                    i11 = 5;
                }
            }
            gVar.f١٧٢٨٨g.clear();
            long j11 = i11;
            long j12 = j10 / j11;
            long j13 = 0;
            i12 = 0;
            long j14 = 0;
            while (i12 < i11) {
                j13 += j14;
                if (i12 == 0) {
                    j14 = (j10 % j11) + j12;
                } else {
                    j14 = j12;
                }
                gVar.f١٧٢٨٨g.add(new r0.e(j13, j14, 0L));
                i12++;
                i11 = i11;
            }
            n0.f.a().f١٦١٣٨b.f١٨٦٦٣a.g(this.f١٨٨٥٩b, gVar, i10);
        }
        i11 = 1;
        gVar.f١٧٢٨٨g.clear();
        long j112 = i11;
        long j122 = j10 / j112;
        long j132 = 0;
        i12 = 0;
        long j142 = 0;
        while (i12 < i11) {
        }
        n0.f.a().f١٦١٣٨b.f١٨٦٦٣a.g(this.f١٨٨٥٩b, gVar, i10);
    }

    public final boolean e() {
        synchronized (this) {
            try {
                if (this.f١٨٨٦٣f) {
                    return false;
                }
                if (this.f١٨٨٦٤g) {
                    return false;
                }
                this.f١٨٨٦٣f = true;
                SystemClock.uptimeMillis();
                n0.f.a().f١٦١٣٧a.e(this);
                i iVar = this.f١٨٨٦٢e;
                if (iVar != null) {
                    iVar.f١٨٨٥٢d = true;
                }
                Object[] array = this.f١٨٨٦١d.toArray();
                if (array != null && array.length != 0) {
                    for (Object obj : array) {
                        if (obj instanceof b) {
                            b bVar = (b) obj;
                            if (!bVar.f١٨٨٢٢o.get() && bVar.f١٨٨١٩l != null) {
                                bVar.f١٨٨١٩l.interrupt();
                            }
                        }
                    }
                } else if (this.f١٨٨٦٥h != null) {
                    int i10 = this.f١٨٨٥٩b.f١٦١١٣b;
                    this.f١٨٨٦٥h.interrupt();
                }
                if (iVar != null) {
                    g0.b a10 = iVar.a();
                    a10.getClass();
                    g0.b.f١٤٣٤٠y.execute(new g0.i(a10));
                }
                int i11 = this.f١٨٨٥٩b.f١٦١١٣b;
                SystemClock.uptimeMillis();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
