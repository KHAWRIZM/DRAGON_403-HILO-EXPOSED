package td;

import io.reactivex.rxjava3.core.g0;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class q extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final Stream f١٨١٩٩a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class a implements sd.e {

        /* renamed from: a, reason: collision with root package name */
        final g0 f١٨٢٠٠a;

        /* renamed from: b, reason: collision with root package name */
        Iterator f١٨٢٠١b;

        /* renamed from: c, reason: collision with root package name */
        AutoCloseable f١٨٢٠٢c;

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f١٨٢٠٣d;

        /* renamed from: e, reason: collision with root package name */
        boolean f١٨٢٠٤e;

        /* renamed from: f, reason: collision with root package name */
        boolean f١٨٢٠٥f;

        a(g0 g0Var, Iterator it, AutoCloseable autoCloseable) {
            this.f١٨٢٠٠a = g0Var;
            this.f١٨٢٠١b = it;
            this.f١٨٢٠٢c = autoCloseable;
        }

        @Override // sd.f
        public int a(int i10) {
            if ((i10 & 1) != 0) {
                this.f١٨٢٠٥f = true;
                return 1;
            }
            return 0;
        }

        public void b() {
            if (this.f١٨٢٠٥f) {
                return;
            }
            Iterator it = this.f١٨٢٠١b;
            g0 g0Var = this.f١٨٢٠٠a;
            while (!this.f١٨٢٠٣d) {
                try {
                    Object next = it.next();
                    Objects.requireNonNull(next, "The Stream's Iterator.next returned a null value");
                    if (!this.f١٨٢٠٣d) {
                        g0Var.onNext(next);
                        if (!this.f١٨٢٠٣d) {
                            try {
                                if (!it.hasNext()) {
                                    g0Var.onComplete();
                                    this.f١٨٢٠٣d = true;
                                }
                            } catch (Throwable th) {
                                od.b.b(th);
                                g0Var.onError(th);
                                this.f١٨٢٠٣d = true;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    od.b.b(th2);
                    g0Var.onError(th2);
                    this.f١٨٢٠٣d = true;
                }
            }
            clear();
        }

        @Override // sd.j
        public void clear() {
            this.f١٨٢٠١b = null;
            AutoCloseable autoCloseable = this.f١٨٢٠٢c;
            this.f١٨٢٠٢c = null;
            if (autoCloseable != null) {
                q.d(autoCloseable);
            }
        }

        @Override // nd.c
        public void dispose() {
            this.f١٨٢٠٣d = true;
            b();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٨٢٠٣d;
        }

        @Override // sd.j
        public boolean isEmpty() {
            Iterator it = this.f١٨٢٠١b;
            if (it != null) {
                if (this.f١٨٢٠٤e && !it.hasNext()) {
                    clear();
                    return true;
                }
                return false;
            }
            return true;
        }

        @Override // sd.j
        public boolean offer(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // sd.j
        public Object poll() {
            Iterator it = this.f١٨٢٠١b;
            if (it == null) {
                return null;
            }
            if (!this.f١٨٢٠٤e) {
                this.f١٨٢٠٤e = true;
            } else if (!it.hasNext()) {
                clear();
                return null;
            }
            Object next = this.f١٨٢٠١b.next();
            Objects.requireNonNull(next, "The Stream's Iterator.next() returned a null value");
            return next;
        }
    }

    public q(Stream stream) {
        this.f١٨١٩٩a = stream;
    }

    static void d(AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        } catch (Throwable th) {
            od.b.b(th);
            ie.a.s(th);
        }
    }

    public static void e(g0 g0Var, Stream stream) {
        Iterator it;
        try {
            it = stream.iterator();
            if (!it.hasNext()) {
                qd.d.d(g0Var);
                d(stream);
            } else {
                a aVar = new a(g0Var, it, stream);
                g0Var.onSubscribe(aVar);
                aVar.b();
            }
        } catch (Throwable th) {
            od.b.b(th);
            qd.d.f(th, g0Var);
            d(stream);
        }
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(g0 g0Var) {
        e(g0Var, this.f١٨١٩٩a);
    }
}
