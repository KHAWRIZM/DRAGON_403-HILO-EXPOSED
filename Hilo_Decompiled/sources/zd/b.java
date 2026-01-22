package zd;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class b implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٥٦٥a;

    /* renamed from: b, reason: collision with root package name */
    final int f١٩٥٦٦b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicReference implements io.reactivex.rxjava3.core.g0, Iterator, nd.c {
        private static final long serialVersionUID = 6695226475494099826L;

        /* renamed from: a, reason: collision with root package name */
        final be.c f١٩٥٦٧a;

        /* renamed from: b, reason: collision with root package name */
        final Lock f١٩٥٦٨b;

        /* renamed from: c, reason: collision with root package name */
        final Condition f١٩٥٦٩c;

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f١٩٥٧٠d;

        /* renamed from: e, reason: collision with root package name */
        volatile Throwable f١٩٥٧١e;

        a(int i10) {
            this.f١٩٥٦٧a = new be.c(i10);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.f١٩٥٦٨b = reentrantLock;
            this.f١٩٥٦٩c = reentrantLock.newCondition();
        }

        void a() {
            this.f١٩٥٦٨b.lock();
            try {
                this.f١٩٥٦٩c.signalAll();
            } finally {
                this.f١٩٥٦٨b.unlock();
            }
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this);
            a();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!isDisposed()) {
                boolean z10 = this.f١٩٥٧٠d;
                boolean isEmpty = this.f١٩٥٦٧a.isEmpty();
                if (z10) {
                    Throwable th = this.f١٩٥٧١e;
                    if (th == null) {
                        if (isEmpty) {
                            return false;
                        }
                    } else {
                        throw fe.j.g(th);
                    }
                }
                if (isEmpty) {
                    try {
                        fe.e.b();
                        this.f١٩٥٦٨b.lock();
                        while (!this.f١٩٥٧٠d && this.f١٩٥٦٧a.isEmpty() && !isDisposed()) {
                            try {
                                this.f١٩٥٦٩c.await();
                            } finally {
                            }
                        }
                        this.f١٩٥٦٨b.unlock();
                    } catch (InterruptedException e10) {
                        qd.c.a(this);
                        a();
                        throw fe.j.g(e10);
                    }
                } else {
                    return true;
                }
            }
            Throwable th2 = this.f١٩٥٧١e;
            if (th2 == null) {
                return false;
            }
            throw fe.j.g(th2);
        }

        @Override // nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) get());
        }

        @Override // java.util.Iterator
        public Object next() {
            if (hasNext()) {
                return this.f١٩٥٦٧a.poll();
            }
            throw new NoSuchElementException();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٥٧٠d = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f١٩٥٧١e = th;
            this.f١٩٥٧٠d = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f١٩٥٦٧a.offer(obj);
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this, cVar);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    public b(io.reactivex.rxjava3.core.e0 e0Var, int i10) {
        this.f١٩٥٦٥a = e0Var;
        this.f١٩٥٦٦b = i10;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        a aVar = new a(this.f١٩٥٦٦b);
        this.f١٩٥٦٥a.subscribe(aVar);
        return aVar;
    }
}
