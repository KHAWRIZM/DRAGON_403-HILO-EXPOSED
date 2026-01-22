package j7;

import j7.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class a extends e {

    /* renamed from: b, reason: collision with root package name */
    private final long f١٥٢٥٩b;

    /* renamed from: c, reason: collision with root package name */
    private final int f١٥٢٦٠c;

    /* renamed from: d, reason: collision with root package name */
    private final int f١٥٢٦١d;

    /* renamed from: e, reason: collision with root package name */
    private final long f١٥٢٦٢e;

    /* renamed from: f, reason: collision with root package name */
    private final int f١٥٢٦٣f;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static final class b extends e.a {

        /* renamed from: a, reason: collision with root package name */
        private Long f١٥٢٦٤a;

        /* renamed from: b, reason: collision with root package name */
        private Integer f١٥٢٦٥b;

        /* renamed from: c, reason: collision with root package name */
        private Integer f١٥٢٦٦c;

        /* renamed from: d, reason: collision with root package name */
        private Long f١٥٢٦٧d;

        /* renamed from: e, reason: collision with root package name */
        private Integer f١٥٢٦٨e;

        @Override // j7.e.a
        e a() {
            String str = "";
            if (this.f١٥٢٦٤a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f١٥٢٦٥b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f١٥٢٦٦c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f١٥٢٦٧d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f١٥٢٦٨e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new a(this.f١٥٢٦٤a.longValue(), this.f١٥٢٦٥b.intValue(), this.f١٥٢٦٦c.intValue(), this.f١٥٢٦٧d.longValue(), this.f١٥٢٦٨e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // j7.e.a
        e.a b(int i10) {
            this.f١٥٢٦٦c = Integer.valueOf(i10);
            return this;
        }

        @Override // j7.e.a
        e.a c(long j10) {
            this.f١٥٢٦٧d = Long.valueOf(j10);
            return this;
        }

        @Override // j7.e.a
        e.a d(int i10) {
            this.f١٥٢٦٥b = Integer.valueOf(i10);
            return this;
        }

        @Override // j7.e.a
        e.a e(int i10) {
            this.f١٥٢٦٨e = Integer.valueOf(i10);
            return this;
        }

        @Override // j7.e.a
        e.a f(long j10) {
            this.f١٥٢٦٤a = Long.valueOf(j10);
            return this;
        }
    }

    @Override // j7.e
    int b() {
        return this.f١٥٢٦١d;
    }

    @Override // j7.e
    long c() {
        return this.f١٥٢٦٢e;
    }

    @Override // j7.e
    int d() {
        return this.f١٥٢٦٠c;
    }

    @Override // j7.e
    int e() {
        return this.f١٥٢٦٣f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f١٥٢٥٩b == eVar.f() && this.f١٥٢٦٠c == eVar.d() && this.f١٥٢٦١d == eVar.b() && this.f١٥٢٦٢e == eVar.c() && this.f١٥٢٦٣f == eVar.e()) {
            return true;
        }
        return false;
    }

    @Override // j7.e
    long f() {
        return this.f١٥٢٥٩b;
    }

    public int hashCode() {
        long j10 = this.f١٥٢٥٩b;
        int i10 = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f١٥٢٦٠c) * 1000003) ^ this.f١٥٢٦١d) * 1000003;
        long j11 = this.f١٥٢٦٢e;
        return this.f١٥٢٦٣f ^ ((i10 ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f١٥٢٥٩b + ", loadBatchSize=" + this.f١٥٢٦٠c + ", criticalSectionEnterTimeoutMs=" + this.f١٥٢٦١d + ", eventCleanUpAge=" + this.f١٥٢٦٢e + ", maxBlobByteSizePerRow=" + this.f١٥٢٦٣f + "}";
    }

    private a(long j10, int i10, int i11, long j11, int i12) {
        this.f١٥٢٥٩b = j10;
        this.f١٥٢٦٠c = i10;
        this.f١٥٢٦١d = i11;
        this.f١٥٢٦٢e = j11;
        this.f١٥٢٦٣f = i12;
    }
}
