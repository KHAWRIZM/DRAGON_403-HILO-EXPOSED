package de;

import fe.k;
import io.reactivex.rxjava3.core.i;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class f extends AtomicInteger implements i, kf.c {
    private static final long serialVersionUID = -4945028590049415624L;

    /* renamed from: a, reason: collision with root package name */
    final kf.b f١٣٧١١a;

    /* renamed from: b, reason: collision with root package name */
    final fe.c f١٣٧١٢b = new fe.c();

    /* renamed from: c, reason: collision with root package name */
    final AtomicLong f١٣٧١٣c = new AtomicLong();

    /* renamed from: d, reason: collision with root package name */
    final AtomicReference f١٣٧١٤d = new AtomicReference();

    /* renamed from: e, reason: collision with root package name */
    final AtomicBoolean f١٣٧١٥e = new AtomicBoolean();

    /* renamed from: f, reason: collision with root package name */
    volatile boolean f١٣٧١٦f;

    public f(kf.b bVar) {
        this.f١٣٧١١a = bVar;
    }

    public void cancel() {
        if (!this.f١٣٧١٦f) {
            ee.c.a(this.f١٣٧١٤d);
        }
    }

    public void onComplete() {
        this.f١٣٧١٦f = true;
        k.b(this.f١٣٧١١a, this, this.f١٣٧١٢b);
    }

    public void onError(Throwable th) {
        this.f١٣٧١٦f = true;
        k.d(this.f١٣٧١١a, th, this, this.f١٣٧١٢b);
    }

    public void onNext(Object obj) {
        k.f(this.f١٣٧١١a, obj, this, this.f١٣٧١٢b);
    }

    @Override // io.reactivex.rxjava3.core.i
    public void onSubscribe(kf.c cVar) {
        if (this.f١٣٧١٥e.compareAndSet(false, true)) {
            this.f١٣٧١١a.onSubscribe(this);
            ee.c.d(this.f١٣٧١٤d, this.f١٣٧١٣c, cVar);
        } else {
            cVar.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    public void request(long j10) {
        if (j10 <= 0) {
            cancel();
            onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j10));
            return;
        }
        ee.c.c(this.f١٣٧١٤d, this.f١٣٧١٣c, j10);
    }
}
