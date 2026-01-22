package zd;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class c implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٥٩٦a;

    public c(io.reactivex.rxjava3.core.e0 e0Var) {
        this.f١٩٥٩٦a = e0Var;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        a aVar = new a();
        io.reactivex.rxjava3.core.z.wrap(this.f١٩٥٩٦a).materialize().subscribe(aVar);
        return aVar;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends he.c implements Iterator {

        /* renamed from: b, reason: collision with root package name */
        io.reactivex.rxjava3.core.o f١٩٥٩٧b;

        /* renamed from: c, reason: collision with root package name */
        final Semaphore f١٩٥٩٨c = new Semaphore(0);

        /* renamed from: d, reason: collision with root package name */
        final AtomicReference f١٩٥٩٩d = new AtomicReference();

        a() {
        }

        @Override // io.reactivex.rxjava3.core.g0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onNext(io.reactivex.rxjava3.core.o oVar) {
            if (this.f١٩٥٩٩d.getAndSet(oVar) == null) {
                this.f١٩٥٩٨c.release();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            io.reactivex.rxjava3.core.o oVar = this.f١٩٥٩٧b;
            if (oVar != null && oVar.g()) {
                throw fe.j.g(this.f١٩٥٩٧b.d());
            }
            if (this.f١٩٥٩٧b == null) {
                try {
                    fe.e.b();
                    this.f١٩٥٩٨c.acquire();
                    io.reactivex.rxjava3.core.o oVar2 = (io.reactivex.rxjava3.core.o) this.f١٩٥٩٩d.getAndSet(null);
                    this.f١٩٥٩٧b = oVar2;
                    if (oVar2.g()) {
                        throw fe.j.g(oVar2.d());
                    }
                } catch (InterruptedException e10) {
                    dispose();
                    this.f١٩٥٩٧b = io.reactivex.rxjava3.core.o.b(e10);
                    throw fe.j.g(e10);
                }
            }
            return this.f١٩٥٩٧b.h();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (hasNext()) {
                Object e10 = this.f١٩٥٩٧b.e();
                this.f١٩٥٩٧b = null;
                return e10;
            }
            throw new NoSuchElementException();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            ie.a.s(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
        }
    }
}
