package zd;

import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class h1 extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final kf.a f١٩٨٤٤a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.i, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٨٤٥a;

        /* renamed from: b, reason: collision with root package name */
        kf.c f١٩٨٤٦b;

        a(io.reactivex.rxjava3.core.g0 g0Var) {
            this.f١٩٨٤٥a = g0Var;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٨٤٦b.cancel();
            this.f١٩٨٤٦b = ee.c.CANCELLED;
        }

        @Override // nd.c
        public boolean isDisposed() {
            if (this.f١٩٨٤٦b == ee.c.CANCELLED) {
                return true;
            }
            return false;
        }

        public void onComplete() {
            this.f١٩٨٤٥a.onComplete();
        }

        public void onError(Throwable th) {
            this.f١٩٨٤٥a.onError(th);
        }

        public void onNext(Object obj) {
            this.f١٩٨٤٥a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.i
        public void onSubscribe(kf.c cVar) {
            if (ee.c.h(this.f١٩٨٤٦b, cVar)) {
                this.f١٩٨٤٦b = cVar;
                this.f١٩٨٤٥a.onSubscribe(this);
                cVar.request(LongCompanionObject.MAX_VALUE);
            }
        }
    }

    public h1(kf.a aVar) {
        this.f١٩٨٤٤a = aVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٨٤٤a.subscribe(new a(g0Var));
    }
}
