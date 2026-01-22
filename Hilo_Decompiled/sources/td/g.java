package td;

import io.reactivex.rxjava3.core.g0;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class g extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.z f١٨١٧٣a;

    /* renamed from: b, reason: collision with root package name */
    final Collector f١٨١٧٤b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends ud.j implements g0 {
        private static final long serialVersionUID = -229544830565448758L;

        /* renamed from: c, reason: collision with root package name */
        final BiConsumer f١٨١٧٥c;

        /* renamed from: d, reason: collision with root package name */
        final Function f١٨١٧٦d;

        /* renamed from: e, reason: collision with root package name */
        nd.c f١٨١٧٧e;

        /* renamed from: f, reason: collision with root package name */
        boolean f١٨١٧٨f;

        /* renamed from: g, reason: collision with root package name */
        Object f١٨١٧٩g;

        a(g0 g0Var, Object obj, BiConsumer biConsumer, Function function) {
            super(g0Var);
            this.f١٨١٧٩g = obj;
            this.f١٨١٧٥c = biConsumer;
            this.f١٨١٧٦d = function;
        }

        @Override // ud.j, nd.c
        public void dispose() {
            super.dispose();
            this.f١٨١٧٧e.dispose();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            Object apply;
            if (this.f١٨١٧٨f) {
                return;
            }
            this.f١٨١٧٨f = true;
            this.f١٨١٧٧e = qd.c.DISPOSED;
            Object obj = this.f١٨١٧٩g;
            this.f١٨١٧٩g = null;
            try {
                apply = this.f١٨١٧٦d.apply(obj);
                Objects.requireNonNull(apply, "The finisher returned a null value");
                c(apply);
            } catch (Throwable th) {
                od.b.b(th);
                this.f١٨٢٩٩a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٨١٧٨f) {
                ie.a.s(th);
                return;
            }
            this.f١٨١٧٨f = true;
            this.f١٨١٧٧e = qd.c.DISPOSED;
            this.f١٨١٧٩g = null;
            this.f١٨٢٩٩a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (!this.f١٨١٧٨f) {
                try {
                    this.f١٨١٧٥c.accept(this.f١٨١٧٩g, obj);
                } catch (Throwable th) {
                    od.b.b(th);
                    this.f١٨١٧٧e.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٨١٧٧e, cVar)) {
                this.f١٨١٧٧e = cVar;
                this.f١٨٢٩٩a.onSubscribe(this);
            }
        }
    }

    public g(io.reactivex.rxjava3.core.z zVar, Collector collector) {
        this.f١٨١٧٣a = zVar;
        this.f١٨١٧٤b = collector;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(g0 g0Var) {
        Supplier supplier;
        Object obj;
        BiConsumer accumulator;
        Function finisher;
        try {
            supplier = this.f١٨١٧٤b.supplier();
            obj = supplier.get();
            accumulator = this.f١٨١٧٤b.accumulator();
            finisher = this.f١٨١٧٤b.finisher();
            this.f١٨١٧٣a.subscribe(new a(g0Var, obj, accumulator, finisher));
        } catch (Throwable th) {
            od.b.b(th);
            qd.d.f(th, g0Var);
        }
    }
}
