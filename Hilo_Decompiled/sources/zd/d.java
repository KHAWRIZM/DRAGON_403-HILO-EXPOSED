package zd;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class d implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٦٥٤a;

    /* renamed from: b, reason: collision with root package name */
    final Object f١٩٦٥٥b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends he.b {

        /* renamed from: b, reason: collision with root package name */
        volatile Object f١٩٦٥٦b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: zd.d$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public final class C٠٢٦٠a implements Iterator {

            /* renamed from: a, reason: collision with root package name */
            private Object f١٩٦٥٧a;

            C٠٢٦٠a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.f١٩٦٥٧a = a.this.f١٩٦٥٦b;
                return !fe.m.j(r0);
            }

            @Override // java.util.Iterator
            public Object next() {
                try {
                    if (this.f١٩٦٥٧a == null) {
                        this.f١٩٦٥٧a = a.this.f١٩٦٥٦b;
                    }
                    if (!fe.m.j(this.f١٩٦٥٧a)) {
                        if (!fe.m.k(this.f١٩٦٥٧a)) {
                            Object i10 = fe.m.i(this.f١٩٦٥٧a);
                            this.f١٩٦٥٧a = null;
                            return i10;
                        }
                        throw fe.j.g(fe.m.h(this.f١٩٦٥٧a));
                    }
                    throw new NoSuchElementException();
                } catch (Throwable th) {
                    this.f١٩٦٥٧a = null;
                    throw th;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        a(Object obj) {
            this.f١٩٦٥٦b = fe.m.l(obj);
        }

        public C٠٢٦٠a b() {
            return new C٠٢٦٠a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٦٥٦b = fe.m.e();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f١٩٦٥٦b = fe.m.g(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f١٩٦٥٦b = fe.m.l(obj);
        }
    }

    public d(io.reactivex.rxjava3.core.e0 e0Var, Object obj) {
        this.f١٩٦٥٤a = e0Var;
        this.f١٩٦٥٥b = obj;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        a aVar = new a(this.f١٩٦٥٥b);
        this.f١٩٦٥٤a.subscribe(aVar);
        return aVar.b();
    }
}
