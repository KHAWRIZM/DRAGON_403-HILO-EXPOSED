package zd;

import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class c1 extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final Object[] f١٩٦١٢a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends ud.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٦١٣a;

        /* renamed from: b, reason: collision with root package name */
        final Object[] f١٩٦١٤b;

        /* renamed from: c, reason: collision with root package name */
        int f١٩٦١٥c;

        /* renamed from: d, reason: collision with root package name */
        boolean f١٩٦١٦d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f١٩٦١٧e;

        a(io.reactivex.rxjava3.core.g0 g0Var, Object[] objArr) {
            this.f١٩٦١٣a = g0Var;
            this.f١٩٦١٤b = objArr;
        }

        @Override // sd.f
        public int a(int i10) {
            if ((i10 & 1) != 0) {
                this.f١٩٦١٦d = true;
                return 1;
            }
            return 0;
        }

        void b() {
            Object[] objArr = this.f١٩٦١٤b;
            int length = objArr.length;
            for (int i10 = 0; i10 < length && !isDisposed(); i10++) {
                Object obj = objArr[i10];
                if (obj == null) {
                    this.f١٩٦١٣a.onError(new NullPointerException("The element at index " + i10 + " is null"));
                    return;
                }
                this.f١٩٦١٣a.onNext(obj);
            }
            if (!isDisposed()) {
                this.f١٩٦١٣a.onComplete();
            }
        }

        @Override // sd.j
        public void clear() {
            this.f١٩٦١٥c = this.f١٩٦١٤b.length;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٦١٧e = true;
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٦١٧e;
        }

        @Override // sd.j
        public boolean isEmpty() {
            if (this.f١٩٦١٥c == this.f١٩٦١٤b.length) {
                return true;
            }
            return false;
        }

        @Override // sd.j
        public Object poll() {
            int i10 = this.f١٩٦١٥c;
            Object[] objArr = this.f١٩٦١٤b;
            if (i10 != objArr.length) {
                this.f١٩٦١٥c = i10 + 1;
                Object obj = objArr[i10];
                Objects.requireNonNull(obj, "The array element is null");
                return obj;
            }
            return null;
        }
    }

    public c1(Object[] objArr) {
        this.f١٩٦١٢a = objArr;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        a aVar = new a(g0Var, this.f١٩٦١٢a);
        g0Var.onSubscribe(aVar);
        if (aVar.f١٩٦١٦d) {
            return;
        }
        aVar.b();
    }
}
