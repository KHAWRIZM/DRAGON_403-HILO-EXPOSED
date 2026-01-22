package la;

import io.reactivex.rxjava3.core.g0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class c extends d {

    /* renamed from: b, reason: collision with root package name */
    static final a[] f١٥٨٦٠b = new a[0];

    /* renamed from: a, reason: collision with root package name */
    final AtomicReference f١٥٨٦١a = new AtomicReference(f١٥٨٦٠b);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a extends AtomicBoolean implements nd.c {
        private static final long serialVersionUID = 3562861878281475070L;

        /* renamed from: a, reason: collision with root package name */
        final g0 f١٥٨٦٢a;

        /* renamed from: b, reason: collision with root package name */
        final c f١٥٨٦٣b;

        a(g0 g0Var, c cVar) {
            this.f١٥٨٦٢a = g0Var;
            this.f١٥٨٦٣b = cVar;
        }

        public void a(Object obj) {
            if (!get()) {
                this.f١٥٨٦٢a.onNext(obj);
            }
        }

        @Override // nd.c
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f١٥٨٦٣b.f(this);
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return get();
        }
    }

    c() {
    }

    public static c e() {
        return new c();
    }

    @Override // pd.g
    public void accept(Object obj) {
        if (obj != null) {
            for (a aVar : (a[]) this.f١٥٨٦١a.get()) {
                aVar.a(obj);
            }
            return;
        }
        throw new NullPointerException("value == null");
    }

    void d(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.f١٥٨٦١a.get();
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!androidx.lifecycle.a.a(this.f١٥٨٦١a, aVarArr, aVarArr2));
    }

    void f(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.f١٥٨٦١a.get();
            if (aVarArr == f١٥٨٦٠b) {
                return;
            }
            int length = aVarArr.length;
            int i10 = 0;
            while (true) {
                if (i10 < length) {
                    if (aVarArr[i10] == aVar) {
                        break;
                    } else {
                        i10++;
                    }
                } else {
                    i10 = -1;
                    break;
                }
            }
            if (i10 < 0) {
                return;
            }
            if (length == 1) {
                aVarArr2 = f١٥٨٦٠b;
            } else {
                a[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i10);
                System.arraycopy(aVarArr, i10 + 1, aVarArr3, i10, (length - i10) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!androidx.lifecycle.a.a(this.f١٥٨٦١a, aVarArr, aVarArr2));
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(g0 g0Var) {
        a aVar = new a(g0Var, this);
        g0Var.onSubscribe(aVar);
        d(aVar);
        if (aVar.isDisposed()) {
            f(aVar);
        }
    }
}
