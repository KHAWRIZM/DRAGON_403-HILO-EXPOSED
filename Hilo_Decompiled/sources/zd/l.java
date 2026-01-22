package zd;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class l extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final int f١٩٩٨٥b;

    /* renamed from: c, reason: collision with root package name */
    final int f١٩٩٨٦c;

    /* renamed from: d, reason: collision with root package name */
    final pd.r f١٩٩٨٧d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٩٨٨a;

        /* renamed from: b, reason: collision with root package name */
        final int f١٩٩٨٩b;

        /* renamed from: c, reason: collision with root package name */
        final pd.r f١٩٩٩٠c;

        /* renamed from: d, reason: collision with root package name */
        Collection f١٩٩٩١d;

        /* renamed from: e, reason: collision with root package name */
        int f١٩٩٩٢e;

        /* renamed from: f, reason: collision with root package name */
        nd.c f١٩٩٩٣f;

        a(io.reactivex.rxjava3.core.g0 g0Var, int i10, pd.r rVar) {
            this.f١٩٩٨٨a = g0Var;
            this.f١٩٩٨٩b = i10;
            this.f١٩٩٩٠c = rVar;
        }

        boolean a() {
            try {
                Object obj = this.f١٩٩٩٠c.get();
                Objects.requireNonNull(obj, "Empty buffer supplied");
                this.f١٩٩٩١d = (Collection) obj;
                return true;
            } catch (Throwable th) {
                od.b.b(th);
                this.f١٩٩٩١d = null;
                nd.c cVar = this.f١٩٩٩٣f;
                if (cVar == null) {
                    qd.d.f(th, this.f١٩٩٨٨a);
                    return false;
                }
                cVar.dispose();
                this.f١٩٩٨٨a.onError(th);
                return false;
            }
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٩٩٣f.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٩٩٣f.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            Collection collection = this.f١٩٩٩١d;
            if (collection != null) {
                this.f١٩٩٩١d = null;
                if (!collection.isEmpty()) {
                    this.f١٩٩٨٨a.onNext(collection);
                }
                this.f١٩٩٨٨a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f١٩٩٩١d = null;
            this.f١٩٩٨٨a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            Collection collection = this.f١٩٩٩١d;
            if (collection != null) {
                collection.add(obj);
                int i10 = this.f١٩٩٩٢e + 1;
                this.f١٩٩٩٢e = i10;
                if (i10 >= this.f١٩٩٨٩b) {
                    this.f١٩٩٨٨a.onNext(collection);
                    this.f١٩٩٩٢e = 0;
                    a();
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٩٩٣f, cVar)) {
                this.f١٩٩٩٣f = cVar;
                this.f١٩٩٨٨a.onSubscribe(this);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends AtomicBoolean implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = -8223395059921494546L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٩٩٤a;

        /* renamed from: b, reason: collision with root package name */
        final int f١٩٩٩٥b;

        /* renamed from: c, reason: collision with root package name */
        final int f١٩٩٩٦c;

        /* renamed from: d, reason: collision with root package name */
        final pd.r f١٩٩٩٧d;

        /* renamed from: e, reason: collision with root package name */
        nd.c f١٩٩٩٨e;

        /* renamed from: f, reason: collision with root package name */
        final ArrayDeque f١٩٩٩٩f = new ArrayDeque();

        /* renamed from: g, reason: collision with root package name */
        long f٢٠٠٠٠g;

        b(io.reactivex.rxjava3.core.g0 g0Var, int i10, int i11, pd.r rVar) {
            this.f١٩٩٩٤a = g0Var;
            this.f١٩٩٩٥b = i10;
            this.f١٩٩٩٦c = i11;
            this.f١٩٩٩٧d = rVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٩٩٨e.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٩٩٨e.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            while (!this.f١٩٩٩٩f.isEmpty()) {
                this.f١٩٩٩٤a.onNext(this.f١٩٩٩٩f.poll());
            }
            this.f١٩٩٩٤a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f١٩٩٩٩f.clear();
            this.f١٩٩٩٤a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            long j10 = this.f٢٠٠٠٠g;
            this.f٢٠٠٠٠g = 1 + j10;
            if (j10 % this.f١٩٩٩٦c == 0) {
                try {
                    this.f١٩٩٩٩f.offer((Collection) fe.j.c(this.f١٩٩٩٧d.get(), "The bufferSupplier returned a null Collection."));
                } catch (Throwable th) {
                    od.b.b(th);
                    this.f١٩٩٩٩f.clear();
                    this.f١٩٩٩٨e.dispose();
                    this.f١٩٩٩٤a.onError(th);
                    return;
                }
            }
            Iterator it = this.f١٩٩٩٩f.iterator();
            while (it.hasNext()) {
                Collection collection = (Collection) it.next();
                collection.add(obj);
                if (this.f١٩٩٩٥b <= collection.size()) {
                    it.remove();
                    this.f١٩٩٩٤a.onNext(collection);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٩٩٨e, cVar)) {
                this.f١٩٩٩٨e = cVar;
                this.f١٩٩٩٤a.onSubscribe(this);
            }
        }
    }

    public l(io.reactivex.rxjava3.core.e0 e0Var, int i10, int i11, pd.r rVar) {
        super(e0Var);
        this.f١٩٩٨٥b = i10;
        this.f١٩٩٨٦c = i11;
        this.f١٩٩٨٧d = rVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        int i10 = this.f١٩٩٨٦c;
        int i11 = this.f١٩٩٨٥b;
        if (i10 == i11) {
            a aVar = new a(g0Var, i11, this.f١٩٩٨٧d);
            if (aVar.a()) {
                this.f١٩٥٣٢a.subscribe(aVar);
                return;
            }
            return;
        }
        this.f١٩٥٣٢a.subscribe(new b(g0Var, this.f١٩٩٨٥b, this.f١٩٩٨٦c, this.f١٩٩٨٧d));
    }
}
