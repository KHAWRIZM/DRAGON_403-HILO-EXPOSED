package ud;

import io.reactivex.rxjava3.core.g0;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class n extends CountDownLatch implements g0, Future, nd.c {

    /* renamed from: a, reason: collision with root package name */
    Object f١٨٣٠٩a;

    /* renamed from: b, reason: collision with root package name */
    Throwable f١٨٣١٠b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference f١٨٣١١c;

    public n() {
        super(1);
        this.f١٨٣١١c = new AtomicReference();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        nd.c cVar;
        qd.c cVar2;
        do {
            cVar = (nd.c) this.f١٨٣١١c.get();
            if (cVar == this || cVar == (cVar2 = qd.c.DISPOSED)) {
                return false;
            }
        } while (!androidx.lifecycle.a.a(this.f١٨٣١١c, cVar, cVar2));
        if (cVar != null) {
            cVar.dispose();
        }
        countDown();
        return true;
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        if (getCount() != 0) {
            fe.e.b();
            await();
        }
        if (!isCancelled()) {
            Throwable th = this.f١٨٣١٠b;
            if (th == null) {
                return this.f١٨٣٠٩a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return qd.c.c((nd.c) this.f١٨٣١١c.get());
    }

    @Override // nd.c
    public boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        if (getCount() == 0) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
    public void onComplete() {
        if (this.f١٨٣٠٩a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        nd.c cVar = (nd.c) this.f١٨٣١١c.get();
        if (cVar != this && cVar != qd.c.DISPOSED && androidx.lifecycle.a.a(this.f١٨٣١١c, cVar, this)) {
            countDown();
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onError(Throwable th) {
        nd.c cVar;
        if (this.f١٨٣١٠b == null && (cVar = (nd.c) this.f١٨٣١١c.get()) != this && cVar != qd.c.DISPOSED && androidx.lifecycle.a.a(this.f١٨٣١١c, cVar, this)) {
            this.f١٨٣١٠b = th;
            countDown();
        } else {
            ie.a.s(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.g0
    public void onNext(Object obj) {
        if (this.f١٨٣٠٩a != null) {
            ((nd.c) this.f١٨٣١١c.get()).dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
        } else {
            this.f١٨٣٠٩a = obj;
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onSubscribe(nd.c cVar) {
        qd.c.g(this.f١٨٣١١c, cVar);
    }

    @Override // java.util.concurrent.Future
    public Object get(long j10, TimeUnit timeUnit) {
        if (getCount() != 0) {
            fe.e.b();
            if (!await(j10, timeUnit)) {
                throw new TimeoutException(fe.j.f(j10, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th = this.f١٨٣١٠b;
            if (th == null) {
                return this.f١٨٣٠٩a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    @Override // nd.c
    public void dispose() {
    }
}
