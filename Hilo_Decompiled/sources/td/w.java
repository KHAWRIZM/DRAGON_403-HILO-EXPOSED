package td;

import io.reactivex.rxjava3.core.g0;
import java.util.Objects;
import java.util.Optional;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class w extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.z f١٨٢٠٨a;

    /* renamed from: b, reason: collision with root package name */
    final pd.o f١٨٢٠٩b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends ud.a {

        /* renamed from: f, reason: collision with root package name */
        final pd.o f١٨٢١٠f;

        a(g0 g0Var, pd.o oVar) {
            super(g0Var);
            this.f١٨٢١٠f = oVar;
        }

        @Override // sd.f
        public int a(int i10) {
            return e(i10);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            boolean isPresent;
            Object obj2;
            if (this.f١٨٢٨٥d) {
                return;
            }
            if (this.f١٨٢٨٦e != 0) {
                this.f١٨٢٨٢a.onNext(null);
                return;
            }
            try {
                Object apply = this.f١٨٢١٠f.apply(obj);
                Objects.requireNonNull(apply, "The mapper returned a null Optional");
                Optional a10 = t.a(apply);
                isPresent = a10.isPresent();
                if (isPresent) {
                    g0 g0Var = this.f١٨٢٨٢a;
                    obj2 = a10.get();
                    g0Var.onNext(obj2);
                }
            } catch (Throwable th) {
                d(th);
            }
        }

        @Override // sd.j
        public Object poll() {
            Optional a10;
            boolean isPresent;
            Object obj;
            do {
                Object poll = this.f١٨٢٨٤c.poll();
                if (poll == null) {
                    return null;
                }
                Object apply = this.f١٨٢١٠f.apply(poll);
                Objects.requireNonNull(apply, "The mapper returned a null Optional");
                a10 = t.a(apply);
                isPresent = a10.isPresent();
            } while (!isPresent);
            obj = a10.get();
            return obj;
        }
    }

    public w(io.reactivex.rxjava3.core.z zVar, pd.o oVar) {
        this.f١٨٢٠٨a = zVar;
        this.f١٨٢٠٩b = oVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(g0 g0Var) {
        this.f١٨٢٠٨a.subscribe(new a(g0Var, this.f١٨٢٠٩b));
    }
}
