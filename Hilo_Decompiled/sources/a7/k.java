package a7;

import a7.u;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class k extends u {

    /* renamed from: a, reason: collision with root package name */
    private final long f٣٤٠a;

    /* renamed from: b, reason: collision with root package name */
    private final long f٣٤١b;

    /* renamed from: c, reason: collision with root package name */
    private final o f٣٤٢c;

    /* renamed from: d, reason: collision with root package name */
    private final Integer f٣٤٣d;

    /* renamed from: e, reason: collision with root package name */
    private final String f٣٤٤e;

    /* renamed from: f, reason: collision with root package name */
    private final List f٣٤٥f;

    /* renamed from: g, reason: collision with root package name */
    private final x f٣٤٦g;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static final class b extends u.a {

        /* renamed from: a, reason: collision with root package name */
        private Long f٣٤٧a;

        /* renamed from: b, reason: collision with root package name */
        private Long f٣٤٨b;

        /* renamed from: c, reason: collision with root package name */
        private o f٣٤٩c;

        /* renamed from: d, reason: collision with root package name */
        private Integer f٣٥٠d;

        /* renamed from: e, reason: collision with root package name */
        private String f٣٥١e;

        /* renamed from: f, reason: collision with root package name */
        private List f٣٥٢f;

        /* renamed from: g, reason: collision with root package name */
        private x f٣٥٣g;

        @Override // a7.u.a
        public u a() {
            String str = "";
            if (this.f٣٤٧a == null) {
                str = " requestTimeMs";
            }
            if (this.f٣٤٨b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new k(this.f٣٤٧a.longValue(), this.f٣٤٨b.longValue(), this.f٣٤٩c, this.f٣٥٠d, this.f٣٥١e, this.f٣٥٢f, this.f٣٥٣g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // a7.u.a
        public u.a b(o oVar) {
            this.f٣٤٩c = oVar;
            return this;
        }

        @Override // a7.u.a
        public u.a c(List list) {
            this.f٣٥٢f = list;
            return this;
        }

        @Override // a7.u.a
        u.a d(Integer num) {
            this.f٣٥٠d = num;
            return this;
        }

        @Override // a7.u.a
        u.a e(String str) {
            this.f٣٥١e = str;
            return this;
        }

        @Override // a7.u.a
        public u.a f(x xVar) {
            this.f٣٥٣g = xVar;
            return this;
        }

        @Override // a7.u.a
        public u.a g(long j10) {
            this.f٣٤٧a = Long.valueOf(j10);
            return this;
        }

        @Override // a7.u.a
        public u.a h(long j10) {
            this.f٣٤٨b = Long.valueOf(j10);
            return this;
        }
    }

    @Override // a7.u
    public o b() {
        return this.f٣٤٢c;
    }

    @Override // a7.u
    public List c() {
        return this.f٣٤٥f;
    }

    @Override // a7.u
    public Integer d() {
        return this.f٣٤٣d;
    }

    @Override // a7.u
    public String e() {
        return this.f٣٤٤e;
    }

    public boolean equals(Object obj) {
        o oVar;
        Integer num;
        String str;
        List list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        if (this.f٣٤٠a == uVar.g() && this.f٣٤١b == uVar.h() && ((oVar = this.f٣٤٢c) != null ? oVar.equals(uVar.b()) : uVar.b() == null) && ((num = this.f٣٤٣d) != null ? num.equals(uVar.d()) : uVar.d() == null) && ((str = this.f٣٤٤e) != null ? str.equals(uVar.e()) : uVar.e() == null) && ((list = this.f٣٤٥f) != null ? list.equals(uVar.c()) : uVar.c() == null)) {
            x xVar = this.f٣٤٦g;
            if (xVar == null) {
                if (uVar.f() == null) {
                    return true;
                }
            } else if (xVar.equals(uVar.f())) {
                return true;
            }
        }
        return false;
    }

    @Override // a7.u
    public x f() {
        return this.f٣٤٦g;
    }

    @Override // a7.u
    public long g() {
        return this.f٣٤٠a;
    }

    @Override // a7.u
    public long h() {
        return this.f٣٤١b;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        long j10 = this.f٣٤٠a;
        long j11 = this.f٣٤١b;
        int i10 = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003;
        o oVar = this.f٣٤٢c;
        int i11 = 0;
        if (oVar == null) {
            hashCode = 0;
        } else {
            hashCode = oVar.hashCode();
        }
        int i12 = (i10 ^ hashCode) * 1000003;
        Integer num = this.f٣٤٣d;
        if (num == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num.hashCode();
        }
        int i13 = (i12 ^ hashCode2) * 1000003;
        String str = this.f٣٤٤e;
        if (str == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str.hashCode();
        }
        int i14 = (i13 ^ hashCode3) * 1000003;
        List list = this.f٣٤٥f;
        if (list == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = list.hashCode();
        }
        int i15 = (i14 ^ hashCode4) * 1000003;
        x xVar = this.f٣٤٦g;
        if (xVar != null) {
            i11 = xVar.hashCode();
        }
        return i15 ^ i11;
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f٣٤٠a + ", requestUptimeMs=" + this.f٣٤١b + ", clientInfo=" + this.f٣٤٢c + ", logSource=" + this.f٣٤٣d + ", logSourceName=" + this.f٣٤٤e + ", logEvents=" + this.f٣٤٥f + ", qosTier=" + this.f٣٤٦g + "}";
    }

    private k(long j10, long j11, o oVar, Integer num, String str, List list, x xVar) {
        this.f٣٤٠a = j10;
        this.f٣٤١b = j11;
        this.f٣٤٢c = oVar;
        this.f٣٤٣d = num;
        this.f٣٤٤e = str;
        this.f٣٤٥f = list;
        this.f٣٤٦g = xVar;
    }
}
