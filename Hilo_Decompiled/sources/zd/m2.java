package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class m2 extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    private final int f٢٠٠٨٢a;

    /* renamed from: b, reason: collision with root package name */
    private final long f٢٠٠٨٣b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends ud.b {
        private static final long serialVersionUID = 396518478098735504L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٠٨٤a;

        /* renamed from: b, reason: collision with root package name */
        final long f٢٠٠٨٥b;

        /* renamed from: c, reason: collision with root package name */
        long f٢٠٠٨٦c;

        /* renamed from: d, reason: collision with root package name */
        boolean f٢٠٠٨٧d;

        a(io.reactivex.rxjava3.core.g0 g0Var, long j10, long j11) {
            this.f٢٠٠٨٤a = g0Var;
            this.f٢٠٠٨٦c = j10;
            this.f٢٠٠٨٥b = j11;
        }

        @Override // sd.f
        public int a(int i10) {
            if ((i10 & 1) != 0) {
                this.f٢٠٠٨٧d = true;
                return 1;
            }
            return 0;
        }

        @Override // sd.j
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer poll() {
            long j10 = this.f٢٠٠٨٦c;
            if (j10 != this.f٢٠٠٨٥b) {
                this.f٢٠٠٨٦c = 1 + j10;
                return Integer.valueOf((int) j10);
            }
            lazySet(1);
            return null;
        }

        @Override // sd.j
        public void clear() {
            this.f٢٠٠٨٦c = this.f٢٠٠٨٥b;
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
            if (this.f٢٠٠٨٦c == this.f٢٠٠٨٥b) {
                return true;
            }
            return false;
        }

        void run() {
            if (this.f٢٠٠٨٧d) {
                return;
            }
            io.reactivex.rxjava3.core.g0 g0Var = this.f٢٠٠٨٤a;
            long j10 = this.f٢٠٠٨٥b;
            for (long j11 = this.f٢٠٠٨٦c; j11 != j10 && get() == 0; j11++) {
                g0Var.onNext(Integer.valueOf((int) j11));
            }
            if (get() == 0) {
                lazySet(1);
                g0Var.onComplete();
            }
        }
    }

    public m2(int i10, int i11) {
        this.f٢٠٠٨٢a = i10;
        this.f٢٠٠٨٣b = i10 + i11;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        a aVar = new a(g0Var, this.f٢٠٠٨٢a, this.f٢٠٠٨٣b);
        g0Var.onSubscribe(aVar);
        aVar.run();
    }
}
