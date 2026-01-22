package wd;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class h extends wd.a implements pd.g {

    /* renamed from: c, reason: collision with root package name */
    final pd.g f١٨٧٨١c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicLong implements io.reactivex.rxjava3.core.i, kf.c {
        private static final long serialVersionUID = -6246093802440953054L;

        /* renamed from: a, reason: collision with root package name */
        final kf.b f١٨٧٨٢a;

        /* renamed from: b, reason: collision with root package name */
        final pd.g f١٨٧٨٣b;

        /* renamed from: c, reason: collision with root package name */
        kf.c f١٨٧٨٤c;

        /* renamed from: d, reason: collision with root package name */
        boolean f١٨٧٨٥d;

        a(kf.b bVar, pd.g gVar) {
            this.f١٨٧٨٢a = bVar;
            this.f١٨٧٨٣b = gVar;
        }

        public void cancel() {
            this.f١٨٧٨٤c.cancel();
        }

        public void onComplete() {
            if (this.f١٨٧٨٥d) {
                return;
            }
            this.f١٨٧٨٥d = true;
            this.f١٨٧٨٢a.onComplete();
        }

        public void onError(Throwable th) {
            if (this.f١٨٧٨٥d) {
                ie.a.s(th);
            } else {
                this.f١٨٧٨٥d = true;
                this.f١٨٧٨٢a.onError(th);
            }
        }

        public void onNext(Object obj) {
            if (this.f١٨٧٨٥d) {
                return;
            }
            if (get() != 0) {
                this.f١٨٧٨٢a.onNext(obj);
                fe.d.d(this, 1L);
                return;
            }
            try {
                this.f١٨٧٨٣b.accept(obj);
            } catch (Throwable th) {
                od.b.b(th);
                cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.i
        public void onSubscribe(kf.c cVar) {
            if (ee.c.h(this.f١٨٧٨٤c, cVar)) {
                this.f١٨٧٨٤c = cVar;
                this.f١٨٧٨٢a.onSubscribe(this);
                cVar.request(LongCompanionObject.MAX_VALUE);
            }
        }

        public void request(long j10) {
            if (ee.c.g(j10)) {
                fe.d.a(this, j10);
            }
        }
    }

    public h(io.reactivex.rxjava3.core.h hVar) {
        super(hVar);
        this.f١٨٧٨١c = this;
    }

    @Override // io.reactivex.rxjava3.core.h
    protected void p(kf.b bVar) {
        this.f١٨٧٣٨b.o(new a(bVar, this.f١٨٧٨١c));
    }

    @Override // pd.g
    public void accept(Object obj) {
    }
}
