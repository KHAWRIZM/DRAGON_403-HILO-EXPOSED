package zd;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class d4 extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.h0 f١٩٦٩٣a;

    /* renamed from: b, reason: collision with root package name */
    final long f١٩٦٩٤b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f١٩٦٩٥c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicReference implements nd.c, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٦٩٦a;

        a(io.reactivex.rxjava3.core.g0 g0Var) {
            this.f١٩٦٩٦a = g0Var;
        }

        public void a(nd.c cVar) {
            qd.c.h(this, cVar);
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this);
        }

        @Override // nd.c
        public boolean isDisposed() {
            if (get() == qd.c.DISPOSED) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!isDisposed()) {
                this.f١٩٦٩٦a.onNext(0L);
                lazySet(qd.d.INSTANCE);
                this.f١٩٦٩٦a.onComplete();
            }
        }
    }

    public d4(long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var) {
        this.f١٩٦٩٤b = j10;
        this.f١٩٦٩٥c = timeUnit;
        this.f١٩٦٩٣a = h0Var;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        a aVar = new a(g0Var);
        g0Var.onSubscribe(aVar);
        aVar.a(this.f١٩٦٩٣a.scheduleDirect(aVar, this.f١٩٦٩٤b, this.f١٩٦٩٥c));
    }
}
