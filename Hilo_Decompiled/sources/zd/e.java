package zd;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class e implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٦٩٧a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        private final b f١٩٦٩٨a;

        /* renamed from: b, reason: collision with root package name */
        private final io.reactivex.rxjava3.core.e0 f١٩٦٩٩b;

        /* renamed from: c, reason: collision with root package name */
        private Object f١٩٧٠٠c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f١٩٧٠١d = true;

        /* renamed from: e, reason: collision with root package name */
        private boolean f١٩٧٠٢e = true;

        /* renamed from: f, reason: collision with root package name */
        private Throwable f١٩٧٠٣f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f١٩٧٠٤g;

        a(io.reactivex.rxjava3.core.e0 e0Var, b bVar) {
            this.f١٩٦٩٩b = e0Var;
            this.f١٩٦٩٨a = bVar;
        }

        private boolean a() {
            if (!this.f١٩٧٠٤g) {
                this.f١٩٧٠٤g = true;
                this.f١٩٦٩٨a.c();
                new b2(this.f١٩٦٩٩b).subscribe(this.f١٩٦٩٨a);
            }
            try {
                io.reactivex.rxjava3.core.o d10 = this.f١٩٦٩٨a.d();
                if (d10.h()) {
                    this.f١٩٧٠٢e = false;
                    this.f١٩٧٠٠c = d10.e();
                    return true;
                }
                this.f١٩٧٠١d = false;
                if (d10.f()) {
                    return false;
                }
                Throwable d11 = d10.d();
                this.f١٩٧٠٣f = d11;
                throw fe.j.g(d11);
            } catch (InterruptedException e10) {
                this.f١٩٦٩٨a.dispose();
                this.f١٩٧٠٣f = e10;
                throw fe.j.g(e10);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th = this.f١٩٧٠٣f;
            if (th == null) {
                if (!this.f١٩٧٠١d) {
                    return false;
                }
                if (this.f١٩٧٠٢e && !a()) {
                    return false;
                }
                return true;
            }
            throw fe.j.g(th);
        }

        @Override // java.util.Iterator
        public Object next() {
            Throwable th = this.f١٩٧٠٣f;
            if (th == null) {
                if (hasNext()) {
                    this.f١٩٧٠٢e = true;
                    return this.f١٩٧٠٠c;
                }
                throw new NoSuchElementException("No more elements");
            }
            throw fe.j.g(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    public e(io.reactivex.rxjava3.core.e0 e0Var) {
        this.f١٩٦٩٧a = e0Var;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new a(this.f١٩٦٩٧a, new b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class b extends he.c {

        /* renamed from: b, reason: collision with root package name */
        private final BlockingQueue f١٩٧٠٥b = new ArrayBlockingQueue(1);

        /* renamed from: c, reason: collision with root package name */
        final AtomicInteger f١٩٧٠٦c = new AtomicInteger();

        b() {
        }

        @Override // io.reactivex.rxjava3.core.g0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onNext(io.reactivex.rxjava3.core.o oVar) {
            if (this.f١٩٧٠٦c.getAndSet(0) == 1 || !oVar.h()) {
                while (!this.f١٩٧٠٥b.offer(oVar)) {
                    io.reactivex.rxjava3.core.o oVar2 = (io.reactivex.rxjava3.core.o) this.f١٩٧٠٥b.poll();
                    if (oVar2 != null && !oVar2.h()) {
                        oVar = oVar2;
                    }
                }
            }
        }

        void c() {
            this.f١٩٧٠٦c.set(1);
        }

        public io.reactivex.rxjava3.core.o d() {
            c();
            fe.e.b();
            return (io.reactivex.rxjava3.core.o) this.f١٩٧٠٥b.take();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            ie.a.s(th);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
        }
    }
}
