package wd;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class i extends wd.a {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicLong implements io.reactivex.rxjava3.core.i, kf.c {
        private static final long serialVersionUID = -3176480756392482682L;

        /* renamed from: a, reason: collision with root package name */
        final kf.b f١٨٧٨٦a;

        /* renamed from: b, reason: collision with root package name */
        kf.c f١٨٧٨٧b;

        /* renamed from: c, reason: collision with root package name */
        boolean f١٨٧٨٨c;

        a(kf.b bVar) {
            this.f١٨٧٨٦a = bVar;
        }

        public void cancel() {
            this.f١٨٧٨٧b.cancel();
        }

        public void onComplete() {
            if (this.f١٨٧٨٨c) {
                return;
            }
            this.f١٨٧٨٨c = true;
            this.f١٨٧٨٦a.onComplete();
        }

        public void onError(Throwable th) {
            if (this.f١٨٧٨٨c) {
                ie.a.s(th);
            } else {
                this.f١٨٧٨٨c = true;
                this.f١٨٧٨٦a.onError(th);
            }
        }

        public void onNext(Object obj) {
            if (this.f١٨٧٨٨c) {
                return;
            }
            if (get() != 0) {
                this.f١٨٧٨٦a.onNext(obj);
                fe.d.d(this, 1L);
            } else {
                onError(new od.c("could not emit value due to lack of requests"));
            }
        }

        @Override // io.reactivex.rxjava3.core.i
        public void onSubscribe(kf.c cVar) {
            if (ee.c.h(this.f١٨٧٨٧b, cVar)) {
                this.f١٨٧٨٧b = cVar;
                this.f١٨٧٨٦a.onSubscribe(this);
                cVar.request(LongCompanionObject.MAX_VALUE);
            }
        }

        public void request(long j10) {
            if (ee.c.g(j10)) {
                fe.d.a(this, j10);
            }
        }
    }

    public i(io.reactivex.rxjava3.core.h hVar) {
        super(hVar);
    }

    @Override // io.reactivex.rxjava3.core.h
    protected void p(kf.b bVar) {
        this.f١٨٧٣٨b.o(new a(bVar));
    }
}
