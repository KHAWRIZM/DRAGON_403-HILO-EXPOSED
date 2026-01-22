package la;

import io.reactivex.rxjava3.core.g0;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import la.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class b extends d {

    /* renamed from: f, reason: collision with root package name */
    private static final Object[] f١٥٨٤٥f = new Object[0];

    /* renamed from: g, reason: collision with root package name */
    static final a[] f١٥٨٤٦g = new a[0];

    /* renamed from: a, reason: collision with root package name */
    final AtomicReference f١٥٨٤٧a;

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference f١٥٨٤٨b;

    /* renamed from: c, reason: collision with root package name */
    final Lock f١٥٨٤٩c;

    /* renamed from: d, reason: collision with root package name */
    final Lock f١٥٨٥٠d;

    /* renamed from: e, reason: collision with root package name */
    long f١٥٨٥١e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a implements nd.c, a.InterfaceC٠١٨٧a {

        /* renamed from: a, reason: collision with root package name */
        final g0 f١٥٨٥٢a;

        /* renamed from: b, reason: collision with root package name */
        final b f١٥٨٥٣b;

        /* renamed from: c, reason: collision with root package name */
        boolean f١٥٨٥٤c;

        /* renamed from: d, reason: collision with root package name */
        boolean f١٥٨٥٥d;

        /* renamed from: e, reason: collision with root package name */
        la.a f١٥٨٥٦e;

        /* renamed from: f, reason: collision with root package name */
        boolean f١٥٨٥٧f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f١٥٨٥٨g;

        /* renamed from: h, reason: collision with root package name */
        long f١٥٨٥٩h;

        a(g0 g0Var, b bVar) {
            this.f١٥٨٥٢a = g0Var;
            this.f١٥٨٥٣b = bVar;
        }

        void a() {
            boolean z10;
            if (this.f١٥٨٥٨g) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.f١٥٨٥٨g) {
                        return;
                    }
                    if (this.f١٥٨٥٤c) {
                        return;
                    }
                    b bVar = this.f١٥٨٥٣b;
                    Lock lock = bVar.f١٥٨٤٩c;
                    lock.lock();
                    this.f١٥٨٥٩h = bVar.f١٥٨٥١e;
                    Object obj = bVar.f١٥٨٤٧a.get();
                    lock.unlock();
                    if (obj != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f١٥٨٥٥d = z10;
                    this.f١٥٨٥٤c = true;
                    if (obj != null) {
                        test(obj);
                        b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void b() {
            la.a aVar;
            while (!this.f١٥٨٥٨g) {
                synchronized (this) {
                    try {
                        aVar = this.f١٥٨٥٦e;
                        if (aVar == null) {
                            this.f١٥٨٥٥d = false;
                            return;
                        }
                        this.f١٥٨٥٦e = null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                aVar.b(this);
            }
        }

        void c(Object obj, long j10) {
            if (this.f١٥٨٥٨g) {
                return;
            }
            if (!this.f١٥٨٥٧f) {
                synchronized (this) {
                    try {
                        if (this.f١٥٨٥٨g) {
                            return;
                        }
                        if (this.f١٥٨٥٩h == j10) {
                            return;
                        }
                        if (this.f١٥٨٥٥d) {
                            la.a aVar = this.f١٥٨٥٦e;
                            if (aVar == null) {
                                aVar = new la.a(4);
                                this.f١٥٨٥٦e = aVar;
                            }
                            aVar.a(obj);
                            return;
                        }
                        this.f١٥٨٥٤c = true;
                        this.f١٥٨٥٧f = true;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            test(obj);
        }

        @Override // nd.c
        public void dispose() {
            if (!this.f١٥٨٥٨g) {
                this.f١٥٨٥٨g = true;
                this.f١٥٨٥٣b.g(this);
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٥٨٥٨g;
        }

        @Override // la.a.InterfaceC٠١٨٧a, pd.q
        public boolean test(Object obj) {
            if (!this.f١٥٨٥٨g) {
                this.f١٥٨٥٢a.onNext(obj);
                return false;
            }
            return false;
        }
    }

    b() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f١٥٨٤٩c = reentrantReadWriteLock.readLock();
        this.f١٥٨٥٠d = reentrantReadWriteLock.writeLock();
        this.f١٥٨٤٨b = new AtomicReference(f١٥٨٤٦g);
        this.f١٥٨٤٧a = new AtomicReference();
    }

    public static b e() {
        return new b();
    }

    public static b f(Object obj) {
        return new b(obj);
    }

    @Override // pd.g
    public void accept(Object obj) {
        if (obj != null) {
            h(obj);
            for (a aVar : (a[]) this.f١٥٨٤٨b.get()) {
                aVar.c(obj, this.f١٥٨٥١e);
            }
            return;
        }
        throw new NullPointerException("value == null");
    }

    void d(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.f١٥٨٤٨b.get();
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!androidx.lifecycle.a.a(this.f١٥٨٤٨b, aVarArr, aVarArr2));
    }

    void g(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.f١٥٨٤٨b.get();
            int length = aVarArr.length;
            if (length == 0) {
                return;
            }
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
                aVarArr2 = f١٥٨٤٦g;
            } else {
                a[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i10);
                System.arraycopy(aVarArr, i10 + 1, aVarArr3, i10, (length - i10) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!androidx.lifecycle.a.a(this.f١٥٨٤٨b, aVarArr, aVarArr2));
    }

    void h(Object obj) {
        this.f١٥٨٥٠d.lock();
        this.f١٥٨٥١e++;
        this.f١٥٨٤٧a.lazySet(obj);
        this.f١٥٨٥٠d.unlock();
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(g0 g0Var) {
        a aVar = new a(g0Var, this);
        g0Var.onSubscribe(aVar);
        d(aVar);
        if (aVar.f١٥٨٥٨g) {
            g(aVar);
        } else {
            aVar.a();
        }
    }

    b(Object obj) {
        this();
        if (obj != null) {
            this.f١٥٨٤٧a.lazySet(obj);
            return;
        }
        throw new NullPointerException("defaultValue == null");
    }
}
