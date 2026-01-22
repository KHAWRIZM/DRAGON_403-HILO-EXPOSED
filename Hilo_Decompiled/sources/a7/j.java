package a7;

import a7.t;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class j extends t {

    /* renamed from: a, reason: collision with root package name */
    private final long f٣٢٢a;

    /* renamed from: b, reason: collision with root package name */
    private final Integer f٣٢٣b;

    /* renamed from: c, reason: collision with root package name */
    private final p f٣٢٤c;

    /* renamed from: d, reason: collision with root package name */
    private final long f٣٢٥d;

    /* renamed from: e, reason: collision with root package name */
    private final byte[] f٣٢٦e;

    /* renamed from: f, reason: collision with root package name */
    private final String f٣٢٧f;

    /* renamed from: g, reason: collision with root package name */
    private final long f٣٢٨g;

    /* renamed from: h, reason: collision with root package name */
    private final w f٣٢٩h;

    /* renamed from: i, reason: collision with root package name */
    private final q f٣٣٠i;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static final class b extends t.a {

        /* renamed from: a, reason: collision with root package name */
        private Long f٣٣١a;

        /* renamed from: b, reason: collision with root package name */
        private Integer f٣٣٢b;

        /* renamed from: c, reason: collision with root package name */
        private p f٣٣٣c;

        /* renamed from: d, reason: collision with root package name */
        private Long f٣٣٤d;

        /* renamed from: e, reason: collision with root package name */
        private byte[] f٣٣٥e;

        /* renamed from: f, reason: collision with root package name */
        private String f٣٣٦f;

        /* renamed from: g, reason: collision with root package name */
        private Long f٣٣٧g;

        /* renamed from: h, reason: collision with root package name */
        private w f٣٣٨h;

        /* renamed from: i, reason: collision with root package name */
        private q f٣٣٩i;

        @Override // a7.t.a
        public t a() {
            String str = "";
            if (this.f٣٣١a == null) {
                str = " eventTimeMs";
            }
            if (this.f٣٣٤d == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f٣٣٧g == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new j(this.f٣٣١a.longValue(), this.f٣٣٢b, this.f٣٣٣c, this.f٣٣٤d.longValue(), this.f٣٣٥e, this.f٣٣٦f, this.f٣٣٧g.longValue(), this.f٣٣٨h, this.f٣٣٩i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // a7.t.a
        public t.a b(p pVar) {
            this.f٣٣٣c = pVar;
            return this;
        }

        @Override // a7.t.a
        public t.a c(Integer num) {
            this.f٣٣٢b = num;
            return this;
        }

        @Override // a7.t.a
        public t.a d(long j10) {
            this.f٣٣١a = Long.valueOf(j10);
            return this;
        }

        @Override // a7.t.a
        public t.a e(long j10) {
            this.f٣٣٤d = Long.valueOf(j10);
            return this;
        }

        @Override // a7.t.a
        public t.a f(q qVar) {
            this.f٣٣٩i = qVar;
            return this;
        }

        @Override // a7.t.a
        public t.a g(w wVar) {
            this.f٣٣٨h = wVar;
            return this;
        }

        @Override // a7.t.a
        t.a h(byte[] bArr) {
            this.f٣٣٥e = bArr;
            return this;
        }

        @Override // a7.t.a
        t.a i(String str) {
            this.f٣٣٦f = str;
            return this;
        }

        @Override // a7.t.a
        public t.a j(long j10) {
            this.f٣٣٧g = Long.valueOf(j10);
            return this;
        }
    }

    @Override // a7.t
    public p b() {
        return this.f٣٢٤c;
    }

    @Override // a7.t
    public Integer c() {
        return this.f٣٢٣b;
    }

    @Override // a7.t
    public long d() {
        return this.f٣٢٢a;
    }

    @Override // a7.t
    public long e() {
        return this.f٣٢٥d;
    }

    public boolean equals(Object obj) {
        Integer num;
        p pVar;
        byte[] h10;
        String str;
        w wVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (this.f٣٢٢a == tVar.d() && ((num = this.f٣٢٣b) != null ? num.equals(tVar.c()) : tVar.c() == null) && ((pVar = this.f٣٢٤c) != null ? pVar.equals(tVar.b()) : tVar.b() == null) && this.f٣٢٥d == tVar.e()) {
            byte[] bArr = this.f٣٢٦e;
            if (tVar instanceof j) {
                h10 = ((j) tVar).f٣٢٦e;
            } else {
                h10 = tVar.h();
            }
            if (Arrays.equals(bArr, h10) && ((str = this.f٣٢٧f) != null ? str.equals(tVar.i()) : tVar.i() == null) && this.f٣٢٨g == tVar.j() && ((wVar = this.f٣٢٩h) != null ? wVar.equals(tVar.g()) : tVar.g() == null)) {
                q qVar = this.f٣٣٠i;
                if (qVar == null) {
                    if (tVar.f() == null) {
                        return true;
                    }
                } else if (qVar.equals(tVar.f())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // a7.t
    public q f() {
        return this.f٣٣٠i;
    }

    @Override // a7.t
    public w g() {
        return this.f٣٢٩h;
    }

    @Override // a7.t
    public byte[] h() {
        return this.f٣٢٦e;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        long j10 = this.f٣٢٢a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f٣٢٣b;
        int i11 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i12 = (i10 ^ hashCode) * 1000003;
        p pVar = this.f٣٢٤c;
        if (pVar == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = pVar.hashCode();
        }
        long j11 = this.f٣٢٥d;
        int hashCode5 = (((((i12 ^ hashCode2) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f٣٢٦e)) * 1000003;
        String str = this.f٣٢٧f;
        if (str == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str.hashCode();
        }
        long j12 = this.f٣٢٨g;
        int i13 = (((hashCode5 ^ hashCode3) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003;
        w wVar = this.f٣٢٩h;
        if (wVar == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = wVar.hashCode();
        }
        int i14 = (i13 ^ hashCode4) * 1000003;
        q qVar = this.f٣٣٠i;
        if (qVar != null) {
            i11 = qVar.hashCode();
        }
        return i14 ^ i11;
    }

    @Override // a7.t
    public String i() {
        return this.f٣٢٧f;
    }

    @Override // a7.t
    public long j() {
        return this.f٣٢٨g;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f٣٢٢a + ", eventCode=" + this.f٣٢٣b + ", complianceData=" + this.f٣٢٤c + ", eventUptimeMs=" + this.f٣٢٥d + ", sourceExtension=" + Arrays.toString(this.f٣٢٦e) + ", sourceExtensionJsonProto3=" + this.f٣٢٧f + ", timezoneOffsetSeconds=" + this.f٣٢٨g + ", networkConnectionInfo=" + this.f٣٢٩h + ", experimentIds=" + this.f٣٣٠i + "}";
    }

    private j(long j10, Integer num, p pVar, long j11, byte[] bArr, String str, long j12, w wVar, q qVar) {
        this.f٣٢٢a = j10;
        this.f٣٢٣b = num;
        this.f٣٢٤c = pVar;
        this.f٣٢٥d = j11;
        this.f٣٢٦e = bArr;
        this.f٣٢٧f = str;
        this.f٣٢٨g = j12;
        this.f٣٢٩h = wVar;
        this.f٣٣٠i = qVar;
    }
}
