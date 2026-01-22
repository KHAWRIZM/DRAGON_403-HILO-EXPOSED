package le;

import fe.j;
import io.reactivex.rxjava3.core.g0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class a extends c {

    /* renamed from: c, reason: collision with root package name */
    static final C٠١٨٨a[] f١٥٨٧٧c = new C٠١٨٨a[0];

    /* renamed from: d, reason: collision with root package name */
    static final C٠١٨٨a[] f١٥٨٧٨d = new C٠١٨٨a[0];

    /* renamed from: a, reason: collision with root package name */
    final AtomicReference f١٥٨٧٩a = new AtomicReference(f١٥٨٧٨d);

    /* renamed from: b, reason: collision with root package name */
    Throwable f١٥٨٨٠b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: le.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class C٠١٨٨a extends AtomicBoolean implements nd.c {
        private static final long serialVersionUID = 3562861878281475070L;

        /* renamed from: a, reason: collision with root package name */
        final g0 f١٥٨٨١a;

        /* renamed from: b, reason: collision with root package name */
        final a f١٥٨٨٢b;

        C٠١٨٨a(g0 g0Var, a aVar) {
            this.f١٥٨٨١a = g0Var;
            this.f١٥٨٨٢b = aVar;
        }

        public void a() {
            if (!get()) {
                this.f١٥٨٨١a.onComplete();
            }
        }

        public void b(Throwable th) {
            if (get()) {
                ie.a.s(th);
            } else {
                this.f١٥٨٨١a.onError(th);
            }
        }

        public void c(Object obj) {
            if (!get()) {
                this.f١٥٨٨١a.onNext(obj);
            }
        }

        @Override // nd.c
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f١٥٨٨٢b.g(this);
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return get();
        }
    }

    a() {
    }

    public static a f() {
        return new a();
    }

    boolean e(C٠١٨٨a r52) {
        C٠١٨٨a[] r02;
        C٠١٨٨a[] r32;
        do {
            r02 = (C٠١٨٨a[]) this.f١٥٨٧٩a.get();
            if (r02 == f١٥٨٧٧c) {
                return false;
            }
            int length = r02.length;
            r32 = new C٠١٨٨a[length + 1];
            System.arraycopy(r02, 0, r32, 0, length);
            r32[length] = r52;
        } while (!androidx.lifecycle.a.a(this.f١٥٨٧٩a, r02, r32));
        return true;
    }

    void g(C٠١٨٨a r72) {
        C٠١٨٨a[] r02;
        C٠١٨٨a[] r12;
        do {
            r02 = (C٠١٨٨a[]) this.f١٥٨٧٩a.get();
            if (r02 != f١٥٨٧٧c && r02 != f١٥٨٧٨d) {
                int length = r02.length;
                int i10 = 0;
                while (true) {
                    if (i10 < length) {
                        if (r02[i10] == r72) {
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
                    r12 = f١٥٨٧٨d;
                } else {
                    C٠١٨٨a[] r52 = new C٠١٨٨a[length - 1];
                    System.arraycopy(r02, 0, r52, 0, i10);
                    System.arraycopy(r02, i10 + 1, r52, i10, (length - i10) - 1);
                    r12 = r52;
                }
            } else {
                return;
            }
        } while (!androidx.lifecycle.a.a(this.f١٥٨٧٩a, r02, r12));
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
    public void onComplete() {
        Object obj = this.f١٥٨٧٩a.get();
        Object obj2 = f١٥٨٧٧c;
        if (obj == obj2) {
            return;
        }
        for (C٠١٨٨a r02 : (C٠١٨٨a[]) this.f١٥٨٧٩a.getAndSet(obj2)) {
            r02.a();
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onError(Throwable th) {
        j.c(th, "onError called with a null Throwable.");
        Object obj = this.f١٥٨٧٩a.get();
        Object obj2 = f١٥٨٧٧c;
        if (obj == obj2) {
            ie.a.s(th);
            return;
        }
        this.f١٥٨٨٠b = th;
        for (C٠١٨٨a r02 : (C٠١٨٨a[]) this.f١٥٨٧٩a.getAndSet(obj2)) {
            r02.b(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.g0
    public void onNext(Object obj) {
        j.c(obj, "onNext called with a null value.");
        for (C٠١٨٨a r02 : (C٠١٨٨a[]) this.f١٥٨٧٩a.get()) {
            r02.c(obj);
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onSubscribe(nd.c cVar) {
        if (this.f١٥٨٧٩a.get() == f١٥٨٧٧c) {
            cVar.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(g0 g0Var) {
        C٠١٨٨a r02 = new C٠١٨٨a(g0Var, this);
        g0Var.onSubscribe(r02);
        if (e(r02)) {
            if (r02.isDisposed()) {
                g(r02);
            }
        } else {
            Throwable th = this.f١٥٨٨٠b;
            if (th != null) {
                g0Var.onError(th);
            } else {
                g0Var.onComplete();
            }
        }
    }
}
