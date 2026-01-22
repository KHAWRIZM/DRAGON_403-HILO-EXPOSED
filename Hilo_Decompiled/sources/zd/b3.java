package zd;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class b3 {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class a extends AtomicInteger implements sd.e, Runnable {
        private static final long serialVersionUID = 3880992722410194083L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٥٧٧a;

        /* renamed from: b, reason: collision with root package name */
        final Object f١٩٥٧٨b;

        public a(io.reactivex.rxjava3.core.g0 g0Var, Object obj) {
            this.f١٩٥٧٧a = g0Var;
            this.f١٩٥٧٨b = obj;
        }

        @Override // sd.f
        public int a(int i10) {
            if ((i10 & 1) != 0) {
                lazySet(1);
                return 1;
            }
            return 0;
        }

        @Override // sd.j
        public void clear() {
            lazySet(3);
        }

        @Override // nd.c
        public void dispose() {
            set(3);
        }

        @Override // nd.c
        public boolean isDisposed() {
            if (get() == 3) {
                return true;
            }
            return false;
        }

        @Override // sd.j
        public boolean isEmpty() {
            if (get() != 1) {
                return true;
            }
            return false;
        }

        @Override // sd.j
        public boolean offer(Object obj) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // sd.j
        public Object poll() {
            if (get() == 1) {
                lazySet(3);
                return this.f١٩٥٧٨b;
            }
            return null;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.f١٩٥٧٧a.onNext(this.f١٩٥٧٨b);
                if (get() == 2) {
                    lazySet(3);
                    this.f١٩٥٧٧a.onComplete();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class b extends io.reactivex.rxjava3.core.z {

        /* renamed from: a, reason: collision with root package name */
        final Object f١٩٥٧٩a;

        /* renamed from: b, reason: collision with root package name */
        final pd.o f١٩٥٨٠b;

        b(Object obj, pd.o oVar) {
            this.f١٩٥٧٩a = obj;
            this.f١٩٥٨٠b = oVar;
        }

        @Override // io.reactivex.rxjava3.core.z
        public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
            try {
                Object apply = this.f١٩٥٨٠b.apply(this.f١٩٥٧٩a);
                Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                io.reactivex.rxjava3.core.e0 e0Var = (io.reactivex.rxjava3.core.e0) apply;
                if (e0Var instanceof pd.r) {
                    try {
                        Object obj = ((pd.r) e0Var).get();
                        if (obj == null) {
                            qd.d.d(g0Var);
                            return;
                        }
                        a aVar = new a(g0Var, obj);
                        g0Var.onSubscribe(aVar);
                        aVar.run();
                        return;
                    } catch (Throwable th) {
                        od.b.b(th);
                        qd.d.f(th, g0Var);
                        return;
                    }
                }
                e0Var.subscribe(g0Var);
            } catch (Throwable th2) {
                od.b.b(th2);
                qd.d.f(th2, g0Var);
            }
        }
    }

    public static io.reactivex.rxjava3.core.z a(Object obj, pd.o oVar) {
        return ie.a.o(new b(obj, oVar));
    }

    public static boolean b(io.reactivex.rxjava3.core.e0 e0Var, io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar) {
        if (e0Var instanceof pd.r) {
            try {
                Object obj = ((pd.r) e0Var).get();
                if (obj == null) {
                    qd.d.d(g0Var);
                    return true;
                }
                try {
                    Object apply = oVar.apply(obj);
                    Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                    io.reactivex.rxjava3.core.e0 e0Var2 = (io.reactivex.rxjava3.core.e0) apply;
                    if (e0Var2 instanceof pd.r) {
                        try {
                            Object obj2 = ((pd.r) e0Var2).get();
                            if (obj2 == null) {
                                qd.d.d(g0Var);
                                return true;
                            }
                            a aVar = new a(g0Var, obj2);
                            g0Var.onSubscribe(aVar);
                            aVar.run();
                        } catch (Throwable th) {
                            od.b.b(th);
                            qd.d.f(th, g0Var);
                            return true;
                        }
                    } else {
                        e0Var2.subscribe(g0Var);
                    }
                    return true;
                } catch (Throwable th2) {
                    od.b.b(th2);
                    qd.d.f(th2, g0Var);
                    return true;
                }
            } catch (Throwable th3) {
                od.b.b(th3);
                qd.d.f(th3, g0Var);
                return true;
            }
        }
        return false;
    }
}
