package zd;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class x2 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.q f٢٠٧٤١b;

    /* renamed from: c, reason: collision with root package name */
    final long f٢٠٧٤٢c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements io.reactivex.rxjava3.core.g0 {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٧٤٣a;

        /* renamed from: b, reason: collision with root package name */
        final qd.f f٢٠٧٤٤b;

        /* renamed from: c, reason: collision with root package name */
        final io.reactivex.rxjava3.core.e0 f٢٠٧٤٥c;

        /* renamed from: d, reason: collision with root package name */
        final pd.q f٢٠٧٤٦d;

        /* renamed from: e, reason: collision with root package name */
        long f٢٠٧٤٧e;

        a(io.reactivex.rxjava3.core.g0 g0Var, long j10, pd.q qVar, qd.f fVar, io.reactivex.rxjava3.core.e0 e0Var) {
            this.f٢٠٧٤٣a = g0Var;
            this.f٢٠٧٤٤b = fVar;
            this.f٢٠٧٤٥c = e0Var;
            this.f٢٠٧٤٦d = qVar;
            this.f٢٠٧٤٧e = j10;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i10 = 1;
                while (!this.f٢٠٧٤٤b.isDisposed()) {
                    this.f٢٠٧٤٥c.subscribe(this);
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٧٤٣a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            long j10 = this.f٢٠٧٤٧e;
            if (j10 != LongCompanionObject.MAX_VALUE) {
                this.f٢٠٧٤٧e = j10 - 1;
            }
            if (j10 == 0) {
                this.f٢٠٧٤٣a.onError(th);
                return;
            }
            try {
                if (!this.f٢٠٧٤٦d.test(th)) {
                    this.f٢٠٧٤٣a.onError(th);
                } else {
                    a();
                }
            } catch (Throwable th2) {
                od.b.b(th2);
                this.f٢٠٧٤٣a.onError(new od.a(th, th2));
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٧٤٣a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            this.f٢٠٧٤٤b.a(cVar);
        }
    }

    public x2(io.reactivex.rxjava3.core.z zVar, long j10, pd.q qVar) {
        super(zVar);
        this.f٢٠٧٤١b = qVar;
        this.f٢٠٧٤٢c = j10;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        qd.f fVar = new qd.f();
        g0Var.onSubscribe(fVar);
        new a(g0Var, this.f٢٠٧٤٢c, this.f٢٠٧٤١b, fVar, this.f١٩٥٣٢a).a();
    }
}
