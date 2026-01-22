package ae;

import io.reactivex.rxjava3.core.i0;
import io.reactivex.rxjava3.core.k0;
import io.reactivex.rxjava3.core.m0;
import java.util.Objects;
import pd.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class g extends i0 {

    /* renamed from: a, reason: collision with root package name */
    final m0 f٤٧٥a;

    /* renamed from: b, reason: collision with root package name */
    final o f٤٧٦b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements k0 {

        /* renamed from: a, reason: collision with root package name */
        final k0 f٤٧٧a;

        /* renamed from: b, reason: collision with root package name */
        final o f٤٧٨b;

        a(k0 k0Var, o oVar) {
            this.f٤٧٧a = k0Var;
            this.f٤٧٨b = oVar;
        }

        @Override // io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٤٧٧a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            this.f٤٧٧a.onSubscribe(cVar);
        }

        @Override // io.reactivex.rxjava3.core.k0
        public void onSuccess(Object obj) {
            try {
                Object apply = this.f٤٧٨b.apply(obj);
                Objects.requireNonNull(apply, "The mapper function returned a null value.");
                this.f٤٧٧a.onSuccess(apply);
            } catch (Throwable th) {
                od.b.b(th);
                onError(th);
            }
        }
    }

    public g(m0 m0Var, o oVar) {
        this.f٤٧٥a = m0Var;
        this.f٤٧٦b = oVar;
    }

    @Override // io.reactivex.rxjava3.core.i0
    protected void o(k0 k0Var) {
        this.f٤٧٥a.a(new a(k0Var, this.f٤٧٦b));
    }
}
