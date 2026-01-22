package wd;

import io.reactivex.rxjava3.core.e0;
import io.reactivex.rxjava3.core.g0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class b extends io.reactivex.rxjava3.core.h {

    /* renamed from: b, reason: collision with root package name */
    private final e0 f١٨٧٣٩b;

    public b(e0 e0Var) {
        this.f١٨٧٣٩b = e0Var;
    }

    @Override // io.reactivex.rxjava3.core.h
    protected void p(kf.b bVar) {
        this.f١٨٧٣٩b.subscribe(new a(bVar));
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements g0, kf.c {

        /* renamed from: a, reason: collision with root package name */
        final kf.b f١٨٧٤٠a;

        /* renamed from: b, reason: collision with root package name */
        nd.c f١٨٧٤١b;

        a(kf.b bVar) {
            this.f١٨٧٤٠a = bVar;
        }

        public void cancel() {
            this.f١٨٧٤١b.dispose();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٨٧٤٠a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f١٨٧٤٠a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f١٨٧٤٠a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            this.f١٨٧٤١b = cVar;
            this.f١٨٧٤٠a.onSubscribe(this);
        }

        public void request(long j10) {
        }
    }
}
