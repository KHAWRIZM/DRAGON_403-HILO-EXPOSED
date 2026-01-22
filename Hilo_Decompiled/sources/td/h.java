package td;

import io.reactivex.rxjava3.core.g0;
import io.reactivex.rxjava3.core.i0;
import io.reactivex.rxjava3.core.k0;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class h extends i0 implements sd.d {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.z f١٨١٨٠a;

    /* renamed from: b, reason: collision with root package name */
    final Collector f١٨١٨١b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final k0 f١٨١٨٢a;

        /* renamed from: b, reason: collision with root package name */
        final BiConsumer f١٨١٨٣b;

        /* renamed from: c, reason: collision with root package name */
        final Function f١٨١٨٤c;

        /* renamed from: d, reason: collision with root package name */
        nd.c f١٨١٨٥d;

        /* renamed from: e, reason: collision with root package name */
        boolean f١٨١٨٦e;

        /* renamed from: f, reason: collision with root package name */
        Object f١٨١٨٧f;

        a(k0 k0Var, Object obj, BiConsumer biConsumer, Function function) {
            this.f١٨١٨٢a = k0Var;
            this.f١٨١٨٧f = obj;
            this.f١٨١٨٣b = biConsumer;
            this.f١٨١٨٤c = function;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٨١٨٥d.dispose();
            this.f١٨١٨٥d = qd.c.DISPOSED;
        }

        @Override // nd.c
        public boolean isDisposed() {
            if (this.f١٨١٨٥d == qd.c.DISPOSED) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            Object apply;
            if (this.f١٨١٨٦e) {
                return;
            }
            this.f١٨١٨٦e = true;
            this.f١٨١٨٥d = qd.c.DISPOSED;
            Object obj = this.f١٨١٨٧f;
            this.f١٨١٨٧f = null;
            try {
                apply = this.f١٨١٨٤c.apply(obj);
                Objects.requireNonNull(apply, "The finisher returned a null value");
                this.f١٨١٨٢a.onSuccess(apply);
            } catch (Throwable th) {
                od.b.b(th);
                this.f١٨١٨٢a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٨١٨٦e) {
                ie.a.s(th);
                return;
            }
            this.f١٨١٨٦e = true;
            this.f١٨١٨٥d = qd.c.DISPOSED;
            this.f١٨١٨٧f = null;
            this.f١٨١٨٢a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (!this.f١٨١٨٦e) {
                try {
                    this.f١٨١٨٣b.accept(this.f١٨١٨٧f, obj);
                } catch (Throwable th) {
                    od.b.b(th);
                    this.f١٨١٨٥d.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٨١٨٥d, cVar)) {
                this.f١٨١٨٥d = cVar;
                this.f١٨١٨٢a.onSubscribe(this);
            }
        }
    }

    public h(io.reactivex.rxjava3.core.z zVar, Collector collector) {
        this.f١٨١٨٠a = zVar;
        this.f١٨١٨١b = collector;
    }

    @Override // sd.d
    public io.reactivex.rxjava3.core.z b() {
        return new g(this.f١٨١٨٠a, this.f١٨١٨١b);
    }

    @Override // io.reactivex.rxjava3.core.i0
    protected void o(k0 k0Var) {
        Supplier supplier;
        Object obj;
        BiConsumer accumulator;
        Function finisher;
        try {
            supplier = this.f١٨١٨١b.supplier();
            obj = supplier.get();
            accumulator = this.f١٨١٨١b.accumulator();
            finisher = this.f١٨١٨١b.finisher();
            this.f١٨١٨٠a.subscribe(new a(k0Var, obj, accumulator, finisher));
        } catch (Throwable th) {
            od.b.b(th);
            qd.d.g(th, k0Var);
        }
    }
}
