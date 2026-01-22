package je;

import fe.j;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class b extends je.a {

    /* renamed from: d, reason: collision with root package name */
    static final a[] f١٥٣٨٢d = new a[0];

    /* renamed from: e, reason: collision with root package name */
    static final a[] f١٥٣٨٣e = new a[0];

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference f١٥٣٨٤b = new AtomicReference(f١٥٣٨٣e);

    /* renamed from: c, reason: collision with root package name */
    Throwable f١٥٣٨٥c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class a extends AtomicLong implements kf.c {
        private static final long serialVersionUID = 3562861878281475070L;

        /* renamed from: a, reason: collision with root package name */
        final kf.b f١٥٣٨٦a;

        /* renamed from: b, reason: collision with root package name */
        final b f١٥٣٨٧b;

        a(kf.b bVar, b bVar2) {
            this.f١٥٣٨٦a = bVar;
            this.f١٥٣٨٧b = bVar2;
        }

        public boolean a() {
            if (get() == Long.MIN_VALUE) {
                return true;
            }
            return false;
        }

        public void b() {
            if (get() != Long.MIN_VALUE) {
                this.f١٥٣٨٦a.onComplete();
            }
        }

        public void c(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.f١٥٣٨٦a.onError(th);
            } else {
                ie.a.s(th);
            }
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f١٥٣٨٧b.v(this);
            }
        }

        public void d(Object obj) {
            long j10 = get();
            if (j10 == Long.MIN_VALUE) {
                return;
            }
            if (j10 != 0) {
                this.f١٥٣٨٦a.onNext(obj);
                fe.d.e(this, 1L);
            } else {
                cancel();
                this.f١٥٣٨٦a.onError(new od.c("Could not emit value due to lack of requests"));
            }
        }

        public void request(long j10) {
            if (ee.c.g(j10)) {
                fe.d.b(this, j10);
            }
        }
    }

    b() {
    }

    public static b u() {
        return new b();
    }

    public void onComplete() {
        Object obj = this.f١٥٣٨٤b.get();
        Object obj2 = f١٥٣٨٢d;
        if (obj == obj2) {
            return;
        }
        for (a aVar : (a[]) this.f١٥٣٨٤b.getAndSet(obj2)) {
            aVar.b();
        }
    }

    public void onError(Throwable th) {
        j.c(th, "onError called with a null Throwable.");
        Object obj = this.f١٥٣٨٤b.get();
        Object obj2 = f١٥٣٨٢d;
        if (obj == obj2) {
            ie.a.s(th);
            return;
        }
        this.f١٥٣٨٥c = th;
        for (a aVar : (a[]) this.f١٥٣٨٤b.getAndSet(obj2)) {
            aVar.c(th);
        }
    }

    public void onNext(Object obj) {
        j.c(obj, "onNext called with a null value.");
        for (a aVar : (a[]) this.f١٥٣٨٤b.get()) {
            aVar.d(obj);
        }
    }

    @Override // io.reactivex.rxjava3.core.i
    public void onSubscribe(kf.c cVar) {
        if (this.f١٥٣٨٤b.get() == f١٥٣٨٢d) {
            cVar.cancel();
        } else {
            cVar.request(LongCompanionObject.MAX_VALUE);
        }
    }

    @Override // io.reactivex.rxjava3.core.h
    protected void p(kf.b bVar) {
        a aVar = new a(bVar, this);
        bVar.onSubscribe(aVar);
        if (t(aVar)) {
            if (aVar.a()) {
                v(aVar);
            }
        } else {
            Throwable th = this.f١٥٣٨٥c;
            if (th != null) {
                bVar.onError(th);
            } else {
                bVar.onComplete();
            }
        }
    }

    boolean t(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.f١٥٣٨٤b.get();
            if (aVarArr == f١٥٣٨٢d) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!androidx.lifecycle.a.a(this.f١٥٣٨٤b, aVarArr, aVarArr2));
        return true;
    }

    void v(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.f١٥٣٨٤b.get();
            if (aVarArr != f١٥٣٨٢d && aVarArr != f١٥٣٨٣e) {
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
                    aVarArr2 = f١٥٣٨٣e;
                } else {
                    a[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i10);
                    System.arraycopy(aVarArr, i10 + 1, aVarArr3, i10, (length - i10) - 1);
                    aVarArr2 = aVarArr3;
                }
            } else {
                return;
            }
        } while (!androidx.lifecycle.a.a(this.f١٥٣٨٤b, aVarArr, aVarArr2));
    }
}
