package be;

import fe.p;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import sd.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class b extends AtomicReferenceArray implements i {

    /* renamed from: f, reason: collision with root package name */
    private static final Integer f٥٦١٠f = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;

    /* renamed from: a, reason: collision with root package name */
    final int f٥٦١١a;

    /* renamed from: b, reason: collision with root package name */
    final AtomicLong f٥٦١٢b;

    /* renamed from: c, reason: collision with root package name */
    long f٥٦١٣c;

    /* renamed from: d, reason: collision with root package name */
    final AtomicLong f٥٦١٤d;

    /* renamed from: e, reason: collision with root package name */
    final int f٥٦١٥e;

    public b(int i10) {
        super(p.a(i10));
        this.f٥٦١١a = length() - 1;
        this.f٥٦١٢b = new AtomicLong();
        this.f٥٦١٤d = new AtomicLong();
        this.f٥٦١٥e = Math.min(i10 / 4, f٥٦١٠f.intValue());
    }

    int b(long j10) {
        return this.f٥٦١١a & ((int) j10);
    }

    int c(long j10, int i10) {
        return ((int) j10) & i10;
    }

    @Override // sd.j
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    Object d(int i10) {
        return get(i10);
    }

    void e(long j10) {
        this.f٥٦١٤d.lazySet(j10);
    }

    void f(int i10, Object obj) {
        lazySet(i10, obj);
    }

    void g(long j10) {
        this.f٥٦١٢b.lazySet(j10);
    }

    @Override // sd.j
    public boolean isEmpty() {
        if (this.f٥٦١٢b.get() == this.f٥٦١٤d.get()) {
            return true;
        }
        return false;
    }

    @Override // sd.j
    public boolean offer(Object obj) {
        if (obj != null) {
            int i10 = this.f٥٦١١a;
            long j10 = this.f٥٦١٢b.get();
            int c10 = c(j10, i10);
            if (j10 >= this.f٥٦١٣c) {
                long j11 = this.f٥٦١٥e + j10;
                if (d(c(j11, i10)) == null) {
                    this.f٥٦١٣c = j11;
                } else if (d(c10) != null) {
                    return false;
                }
            }
            f(c10, obj);
            g(j10 + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // sd.i, sd.j
    public Object poll() {
        long j10 = this.f٥٦١٤d.get();
        int b10 = b(j10);
        Object d10 = d(b10);
        if (d10 == null) {
            return null;
        }
        e(j10 + 1);
        f(b10, null);
        return d10;
    }
}
