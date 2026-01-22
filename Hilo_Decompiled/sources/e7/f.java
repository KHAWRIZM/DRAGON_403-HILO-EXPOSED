package e7;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    private static final f f١٣٩٢٥c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    private final long f١٣٩٢٦a;

    /* renamed from: b, reason: collision with root package name */
    private final long f١٣٩٢٧b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private long f١٣٩٢٨a = 0;

        /* renamed from: b, reason: collision with root package name */
        private long f١٣٩٢٩b = 0;

        a() {
        }

        public f a() {
            return new f(this.f١٣٩٢٨a, this.f١٣٩٢٩b);
        }

        public a b(long j10) {
            this.f١٣٩٢٩b = j10;
            return this;
        }

        public a c(long j10) {
            this.f١٣٩٢٨a = j10;
            return this;
        }
    }

    f(long j10, long j11) {
        this.f١٣٩٢٦a = j10;
        this.f١٣٩٢٧b = j11;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f١٣٩٢٧b;
    }

    public long b() {
        return this.f١٣٩٢٦a;
    }
}
