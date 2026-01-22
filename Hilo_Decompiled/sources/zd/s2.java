package zd;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class s2 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final long f٢٠٤٦٦b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements io.reactivex.rxjava3.core.g0 {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٤٦٧a;

        /* renamed from: b, reason: collision with root package name */
        final qd.f f٢٠٤٦٨b;

        /* renamed from: c, reason: collision with root package name */
        final io.reactivex.rxjava3.core.e0 f٢٠٤٦٩c;

        /* renamed from: d, reason: collision with root package name */
        long f٢٠٤٧٠d;

        a(io.reactivex.rxjava3.core.g0 g0Var, long j10, qd.f fVar, io.reactivex.rxjava3.core.e0 e0Var) {
            this.f٢٠٤٦٧a = g0Var;
            this.f٢٠٤٦٨b = fVar;
            this.f٢٠٤٦٩c = e0Var;
            this.f٢٠٤٧٠d = j10;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i10 = 1;
                while (!this.f٢٠٤٦٨b.isDisposed()) {
                    this.f٢٠٤٦٩c.subscribe(this);
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            long j10 = this.f٢٠٤٧٠d;
            if (j10 != LongCompanionObject.MAX_VALUE) {
                this.f٢٠٤٧٠d = j10 - 1;
            }
            if (j10 != 0) {
                a();
            } else {
                this.f٢٠٤٦٧a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٤٦٧a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٤٦٧a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            this.f٢٠٤٦٨b.a(cVar);
        }
    }

    public s2(io.reactivex.rxjava3.core.z zVar, long j10) {
        super(zVar);
        this.f٢٠٤٦٦b = j10;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        qd.f fVar = new qd.f();
        g0Var.onSubscribe(fVar);
        long j10 = this.f٢٠٤٦٦b;
        long j11 = LongCompanionObject.MAX_VALUE;
        if (j10 != LongCompanionObject.MAX_VALUE) {
            j11 = j10 - 1;
        }
        new a(g0Var, j11, fVar, this.f١٩٥٣٢a).a();
    }
}
