package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class n2 extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    private final long f٢٠١٨٥a;

    /* renamed from: b, reason: collision with root package name */
    private final long f٢٠١٨٦b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends ud.b {
        private static final long serialVersionUID = 396518478098735504L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠١٨٧a;

        /* renamed from: b, reason: collision with root package name */
        final long f٢٠١٨٨b;

        /* renamed from: c, reason: collision with root package name */
        long f٢٠١٨٩c;

        /* renamed from: d, reason: collision with root package name */
        boolean f٢٠١٩٠d;

        a(io.reactivex.rxjava3.core.g0 g0Var, long j10, long j11) {
            this.f٢٠١٨٧a = g0Var;
            this.f٢٠١٨٩c = j10;
            this.f٢٠١٨٨b = j11;
        }

        @Override // sd.f
        public int a(int i10) {
            if ((i10 & 1) != 0) {
                this.f٢٠١٩٠d = true;
                return 1;
            }
            return 0;
        }

        @Override // sd.j
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long poll() {
            long j10 = this.f٢٠١٨٩c;
            if (j10 != this.f٢٠١٨٨b) {
                this.f٢٠١٨٩c = 1 + j10;
                return Long.valueOf(j10);
            }
            lazySet(1);
            return null;
        }

        @Override // sd.j
        public void clear() {
            this.f٢٠١٨٩c = this.f٢٠١٨٨b;
            lazySet(1);
        }

        @Override // nd.c
        public void dispose() {
            set(1);
        }

        @Override // nd.c
        public boolean isDisposed() {
            if (get() != 0) {
                return true;
            }
            return false;
        }

        @Override // sd.j
        public boolean isEmpty() {
            if (this.f٢٠١٨٩c == this.f٢٠١٨٨b) {
                return true;
            }
            return false;
        }

        void run() {
            if (this.f٢٠١٩٠d) {
                return;
            }
            io.reactivex.rxjava3.core.g0 g0Var = this.f٢٠١٨٧a;
            long j10 = this.f٢٠١٨٨b;
            for (long j11 = this.f٢٠١٨٩c; j11 != j10 && get() == 0; j11++) {
                g0Var.onNext(Long.valueOf(j11));
            }
            if (get() == 0) {
                lazySet(1);
                g0Var.onComplete();
            }
        }
    }

    public n2(long j10, long j11) {
        this.f٢٠١٨٥a = j10;
        this.f٢٠١٨٦b = j11;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        long j10 = this.f٢٠١٨٥a;
        a aVar = new a(g0Var, j10, j10 + this.f٢٠١٨٦b);
        g0Var.onSubscribe(aVar);
        aVar.run();
    }
}
