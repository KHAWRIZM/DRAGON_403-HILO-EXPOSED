package zd;

import java.util.ArrayDeque;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class s3 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final int f٢٠٤٧١b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends ArrayDeque implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = 7240042530241604978L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٤٧٢a;

        /* renamed from: b, reason: collision with root package name */
        final int f٢٠٤٧٣b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f٢٠٤٧٤c;

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f٢٠٤٧٥d;

        a(io.reactivex.rxjava3.core.g0 g0Var, int i10) {
            this.f٢٠٤٧٢a = g0Var;
            this.f٢٠٤٧٣b = i10;
        }

        @Override // nd.c
        public void dispose() {
            if (!this.f٢٠٤٧٥d) {
                this.f٢٠٤٧٥d = true;
                this.f٢٠٤٧٤c.dispose();
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٤٧٥d;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            io.reactivex.rxjava3.core.g0 g0Var = this.f٢٠٤٧٢a;
            while (!this.f٢٠٤٧٥d) {
                Object poll = poll();
                if (poll == null) {
                    g0Var.onComplete();
                    return;
                }
                g0Var.onNext(poll);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٤٧٢a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f٢٠٤٧٣b == size()) {
                poll();
            }
            offer(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٤٧٤c, cVar)) {
                this.f٢٠٤٧٤c = cVar;
                this.f٢٠٤٧٢a.onSubscribe(this);
            }
        }
    }

    public s3(io.reactivex.rxjava3.core.e0 e0Var, int i10) {
        super(e0Var);
        this.f٢٠٤٧١b = i10;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f٢٠٤٧١b));
    }
}
