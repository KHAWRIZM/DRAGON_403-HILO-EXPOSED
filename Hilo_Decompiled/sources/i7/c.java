package i7;

import i7.f;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class c extends f.b {

    /* renamed from: a, reason: collision with root package name */
    private final long f١٤٦١٦a;

    /* renamed from: b, reason: collision with root package name */
    private final long f١٤٦١٧b;

    /* renamed from: c, reason: collision with root package name */
    private final Set f١٤٦١٨c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static final class b extends f.b.a {

        /* renamed from: a, reason: collision with root package name */
        private Long f١٤٦١٩a;

        /* renamed from: b, reason: collision with root package name */
        private Long f١٤٦٢٠b;

        /* renamed from: c, reason: collision with root package name */
        private Set f١٤٦٢١c;

        @Override // i7.f.b.a
        public f.b a() {
            String str = "";
            if (this.f١٤٦١٩a == null) {
                str = " delta";
            }
            if (this.f١٤٦٢٠b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f١٤٦٢١c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new c(this.f١٤٦١٩a.longValue(), this.f١٤٦٢٠b.longValue(), this.f١٤٦٢١c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // i7.f.b.a
        public f.b.a b(long j10) {
            this.f١٤٦١٩a = Long.valueOf(j10);
            return this;
        }

        @Override // i7.f.b.a
        public f.b.a c(Set set) {
            if (set != null) {
                this.f١٤٦٢١c = set;
                return this;
            }
            throw new NullPointerException("Null flags");
        }

        @Override // i7.f.b.a
        public f.b.a d(long j10) {
            this.f١٤٦٢٠b = Long.valueOf(j10);
            return this;
        }
    }

    @Override // i7.f.b
    long b() {
        return this.f١٤٦١٦a;
    }

    @Override // i7.f.b
    Set c() {
        return this.f١٤٦١٨c;
    }

    @Override // i7.f.b
    long d() {
        return this.f١٤٦١٧b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f.b)) {
            return false;
        }
        f.b bVar = (f.b) obj;
        if (this.f١٤٦١٦a == bVar.b() && this.f١٤٦١٧b == bVar.d() && this.f١٤٦١٨c.equals(bVar.c())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f١٤٦١٦a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        long j11 = this.f١٤٦١٧b;
        return this.f١٤٦١٨c.hashCode() ^ ((i10 ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f١٤٦١٦a + ", maxAllowedDelay=" + this.f١٤٦١٧b + ", flags=" + this.f١٤٦١٨c + "}";
    }

    private c(long j10, long j11, Set set) {
        this.f١٤٦١٦a = j10;
        this.f١٤٦١٧b = j11;
        this.f١٤٦١٨c = set;
    }
}
