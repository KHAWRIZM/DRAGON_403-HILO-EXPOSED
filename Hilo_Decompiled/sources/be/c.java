package be;

import fe.p;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import sd.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class c implements i {

    /* renamed from: i, reason: collision with root package name */
    static final int f٥٦١٦i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: j, reason: collision with root package name */
    private static final Object f٥٦١٧j = new Object();

    /* renamed from: b, reason: collision with root package name */
    int f٥٦١٩b;

    /* renamed from: c, reason: collision with root package name */
    long f٥٦٢٠c;

    /* renamed from: d, reason: collision with root package name */
    final int f٥٦٢١d;

    /* renamed from: e, reason: collision with root package name */
    AtomicReferenceArray f٥٦٢٢e;

    /* renamed from: f, reason: collision with root package name */
    final int f٥٦٢٣f;

    /* renamed from: g, reason: collision with root package name */
    AtomicReferenceArray f٥٦٢٤g;

    /* renamed from: a, reason: collision with root package name */
    final AtomicLong f٥٦١٨a = new AtomicLong();

    /* renamed from: h, reason: collision with root package name */
    final AtomicLong f٥٦٢٥h = new AtomicLong();

    public c(int i10) {
        int a10 = p.a(Math.max(8, i10));
        int i11 = a10 - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(a10 + 1);
        this.f٥٦٢٢e = atomicReferenceArray;
        this.f٥٦٢١d = i11;
        b(a10);
        this.f٥٦٢٤g = atomicReferenceArray;
        this.f٥٦٢٣f = i11;
        this.f٥٦٢٠c = a10 - 2;
        t(0L);
    }

    private void b(int i10) {
        this.f٥٦١٩b = Math.min(i10 / 4, f٥٦١٦i);
    }

    private static int d(long j10, int i10) {
        return c(((int) j10) & i10);
    }

    private long e() {
        return this.f٥٦٢٥h.get();
    }

    private long f() {
        return this.f٥٦١٨a.get();
    }

    private long g() {
        return this.f٥٦٢٥h.get();
    }

    private static Object h(AtomicReferenceArray atomicReferenceArray, int i10) {
        return atomicReferenceArray.get(i10);
    }

    private AtomicReferenceArray i(AtomicReferenceArray atomicReferenceArray, int i10) {
        int c10 = c(i10);
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray) h(atomicReferenceArray, c10);
        r(atomicReferenceArray, c10, null);
        return atomicReferenceArray2;
    }

    private long j() {
        return this.f٥٦١٨a.get();
    }

    private Object k(AtomicReferenceArray atomicReferenceArray, long j10, int i10) {
        this.f٥٦٢٤g = atomicReferenceArray;
        return h(atomicReferenceArray, d(j10, i10));
    }

    private Object l(AtomicReferenceArray atomicReferenceArray, long j10, int i10) {
        this.f٥٦٢٤g = atomicReferenceArray;
        int d10 = d(j10, i10);
        Object h10 = h(atomicReferenceArray, d10);
        if (h10 != null) {
            r(atomicReferenceArray, d10, null);
            q(j10 + 1);
        }
        return h10;
    }

    private void o(AtomicReferenceArray atomicReferenceArray, long j10, int i10, Object obj, long j11) {
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.f٥٦٢٢e = atomicReferenceArray2;
        this.f٥٦٢٠c = (j11 + j10) - 1;
        r(atomicReferenceArray2, i10, obj);
        s(atomicReferenceArray, atomicReferenceArray2);
        r(atomicReferenceArray, i10, f٥٦١٧j);
        t(j10 + 1);
    }

    private void q(long j10) {
        this.f٥٦٢٥h.lazySet(j10);
    }

    private static void r(AtomicReferenceArray atomicReferenceArray, int i10, Object obj) {
        atomicReferenceArray.lazySet(i10, obj);
    }

    private void s(AtomicReferenceArray atomicReferenceArray, AtomicReferenceArray atomicReferenceArray2) {
        r(atomicReferenceArray, c(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void t(long j10) {
        this.f٥٦١٨a.lazySet(j10);
    }

    private boolean u(AtomicReferenceArray atomicReferenceArray, Object obj, long j10, int i10) {
        r(atomicReferenceArray, i10, obj);
        t(j10 + 1);
        return true;
    }

    @Override // sd.j
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // sd.j
    public boolean isEmpty() {
        if (j() == g()) {
            return true;
        }
        return false;
    }

    public boolean m(Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray = this.f٥٦٢٢e;
        long j10 = j();
        int i10 = this.f٥٦٢١d;
        long j11 = 2 + j10;
        if (h(atomicReferenceArray, d(j11, i10)) == null) {
            int d10 = d(j10, i10);
            r(atomicReferenceArray, d10 + 1, obj2);
            r(atomicReferenceArray, d10, obj);
            t(j11);
            return true;
        }
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.f٥٦٢٢e = atomicReferenceArray2;
        int d11 = d(j10, i10);
        r(atomicReferenceArray2, d11 + 1, obj2);
        r(atomicReferenceArray2, d11, obj);
        s(atomicReferenceArray, atomicReferenceArray2);
        r(atomicReferenceArray, d11, f٥٦١٧j);
        t(j11);
        return true;
    }

    public Object n() {
        AtomicReferenceArray atomicReferenceArray = this.f٥٦٢٤g;
        long e10 = e();
        int i10 = this.f٥٦٢٣f;
        Object h10 = h(atomicReferenceArray, d(e10, i10));
        if (h10 == f٥٦١٧j) {
            return k(i(atomicReferenceArray, i10 + 1), e10, i10);
        }
        return h10;
    }

    @Override // sd.j
    public boolean offer(Object obj) {
        if (obj != null) {
            AtomicReferenceArray atomicReferenceArray = this.f٥٦٢٢e;
            long f10 = f();
            int i10 = this.f٥٦٢١d;
            int d10 = d(f10, i10);
            if (f10 < this.f٥٦٢٠c) {
                return u(atomicReferenceArray, obj, f10, d10);
            }
            long j10 = this.f٥٦١٩b + f10;
            if (h(atomicReferenceArray, d(j10, i10)) == null) {
                this.f٥٦٢٠c = j10 - 1;
                return u(atomicReferenceArray, obj, f10, d10);
            }
            if (h(atomicReferenceArray, d(1 + f10, i10)) == null) {
                return u(atomicReferenceArray, obj, f10, d10);
            }
            o(atomicReferenceArray, f10, d10, obj, i10);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public int p() {
        long g10 = g();
        while (true) {
            long j10 = j();
            long g11 = g();
            if (g10 == g11) {
                return (int) (j10 - g11);
            }
            g10 = g11;
        }
    }

    @Override // sd.i, sd.j
    public Object poll() {
        boolean z10;
        AtomicReferenceArray atomicReferenceArray = this.f٥٦٢٤g;
        long e10 = e();
        int i10 = this.f٥٦٢٣f;
        int d10 = d(e10, i10);
        Object h10 = h(atomicReferenceArray, d10);
        if (h10 == f٥٦١٧j) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (h10 != null && !z10) {
            r(atomicReferenceArray, d10, null);
            q(e10 + 1);
            return h10;
        }
        if (!z10) {
            return null;
        }
        return l(i(atomicReferenceArray, i10 + 1), e10, i10);
    }

    private static int c(int i10) {
        return i10;
    }
}
