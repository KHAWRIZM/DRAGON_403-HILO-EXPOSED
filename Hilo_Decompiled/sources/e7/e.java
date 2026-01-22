package e7;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    private static final e f١٣٩٢٠c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    private final long f١٣٩٢١a;

    /* renamed from: b, reason: collision with root package name */
    private final long f١٣٩٢٢b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private long f١٣٩٢٣a = 0;

        /* renamed from: b, reason: collision with root package name */
        private long f١٣٩٢٤b = 0;

        a() {
        }

        public e a() {
            return new e(this.f١٣٩٢٣a, this.f١٣٩٢٤b);
        }

        public a b(long j10) {
            this.f١٣٩٢٣a = j10;
            return this;
        }

        public a c(long j10) {
            this.f١٣٩٢٤b = j10;
            return this;
        }
    }

    e(long j10, long j11) {
        this.f١٣٩٢١a = j10;
        this.f١٣٩٢٢b = j11;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f١٣٩٢١a;
    }

    public long b() {
        return this.f١٣٩٢٢b;
    }
}
