package b7;

import b7.i;
import java.util.Arrays;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class b extends i {

    /* renamed from: a, reason: collision with root package name */
    private final String f٥٤٧٠a;

    /* renamed from: b, reason: collision with root package name */
    private final Integer f٥٤٧١b;

    /* renamed from: c, reason: collision with root package name */
    private final h f٥٤٧٢c;

    /* renamed from: d, reason: collision with root package name */
    private final long f٥٤٧٣d;

    /* renamed from: e, reason: collision with root package name */
    private final long f٥٤٧٤e;

    /* renamed from: f, reason: collision with root package name */
    private final Map f٥٤٧٥f;

    /* renamed from: g, reason: collision with root package name */
    private final Integer f٥٤٧٦g;

    /* renamed from: h, reason: collision with root package name */
    private final String f٥٤٧٧h;

    /* renamed from: i, reason: collision with root package name */
    private final byte[] f٥٤٧٨i;

    /* renamed from: j, reason: collision with root package name */
    private final byte[] f٥٤٧٩j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b7.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class C٠٠٦٩b extends i.a {

        /* renamed from: a, reason: collision with root package name */
        private String f٥٤٨٠a;

        /* renamed from: b, reason: collision with root package name */
        private Integer f٥٤٨١b;

        /* renamed from: c, reason: collision with root package name */
        private h f٥٤٨٢c;

        /* renamed from: d, reason: collision with root package name */
        private Long f٥٤٨٣d;

        /* renamed from: e, reason: collision with root package name */
        private Long f٥٤٨٤e;

        /* renamed from: f, reason: collision with root package name */
        private Map f٥٤٨٥f;

        /* renamed from: g, reason: collision with root package name */
        private Integer f٥٤٨٦g;

        /* renamed from: h, reason: collision with root package name */
        private String f٥٤٨٧h;

        /* renamed from: i, reason: collision with root package name */
        private byte[] f٥٤٨٨i;

        /* renamed from: j, reason: collision with root package name */
        private byte[] f٥٤٨٩j;

        @Override // b7.i.a
        public i d() {
            String str = "";
            if (this.f٥٤٨٠a == null) {
                str = " transportName";
            }
            if (this.f٥٤٨٢c == null) {
                str = str + " encodedPayload";
            }
            if (this.f٥٤٨٣d == null) {
                str = str + " eventMillis";
            }
            if (this.f٥٤٨٤e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f٥٤٨٥f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new b(this.f٥٤٨٠a, this.f٥٤٨١b, this.f٥٤٨٢c, this.f٥٤٨٣d.longValue(), this.f٥٤٨٤e.longValue(), this.f٥٤٨٥f, this.f٥٤٨٦g, this.f٥٤٨٧h, this.f٥٤٨٨i, this.f٥٤٨٩j);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // b7.i.a
        protected Map e() {
            Map map = this.f٥٤٨٥f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // b7.i.a
        public i.a f(Map map) {
            if (map != null) {
                this.f٥٤٨٥f = map;
                return this;
            }
            throw new NullPointerException("Null autoMetadata");
        }

        @Override // b7.i.a
        public i.a g(Integer num) {
            this.f٥٤٨١b = num;
            return this;
        }

        @Override // b7.i.a
        public i.a h(h hVar) {
            if (hVar != null) {
                this.f٥٤٨٢c = hVar;
                return this;
            }
            throw new NullPointerException("Null encodedPayload");
        }

        @Override // b7.i.a
        public i.a i(long j10) {
            this.f٥٤٨٣d = Long.valueOf(j10);
            return this;
        }

        @Override // b7.i.a
        public i.a j(byte[] bArr) {
            this.f٥٤٨٨i = bArr;
            return this;
        }

        @Override // b7.i.a
        public i.a k(byte[] bArr) {
            this.f٥٤٨٩j = bArr;
            return this;
        }

        @Override // b7.i.a
        public i.a l(Integer num) {
            this.f٥٤٨٦g = num;
            return this;
        }

        @Override // b7.i.a
        public i.a m(String str) {
            this.f٥٤٨٧h = str;
            return this;
        }

        @Override // b7.i.a
        public i.a n(String str) {
            if (str != null) {
                this.f٥٤٨٠a = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        @Override // b7.i.a
        public i.a o(long j10) {
            this.f٥٤٨٤e = Long.valueOf(j10);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b7.i
    public Map c() {
        return this.f٥٤٧٥f;
    }

    @Override // b7.i
    public Integer d() {
        return this.f٥٤٧١b;
    }

    @Override // b7.i
    public h e() {
        return this.f٥٤٧٢c;
    }

    public boolean equals(Object obj) {
        Integer num;
        Integer num2;
        String str;
        byte[] g10;
        byte[] h10;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f٥٤٧٠a.equals(iVar.n()) && ((num = this.f٥٤٧١b) != null ? num.equals(iVar.d()) : iVar.d() == null) && this.f٥٤٧٢c.equals(iVar.e()) && this.f٥٤٧٣d == iVar.f() && this.f٥٤٧٤e == iVar.o() && this.f٥٤٧٥f.equals(iVar.c()) && ((num2 = this.f٥٤٧٦g) != null ? num2.equals(iVar.l()) : iVar.l() == null) && ((str = this.f٥٤٧٧h) != null ? str.equals(iVar.m()) : iVar.m() == null)) {
            byte[] bArr = this.f٥٤٧٨i;
            boolean z10 = iVar instanceof b;
            if (z10) {
                g10 = ((b) iVar).f٥٤٧٨i;
            } else {
                g10 = iVar.g();
            }
            if (Arrays.equals(bArr, g10)) {
                byte[] bArr2 = this.f٥٤٧٩j;
                if (z10) {
                    h10 = ((b) iVar).f٥٤٧٩j;
                } else {
                    h10 = iVar.h();
                }
                if (Arrays.equals(bArr2, h10)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // b7.i
    public long f() {
        return this.f٥٤٧٣d;
    }

    @Override // b7.i
    public byte[] g() {
        return this.f٥٤٧٨i;
    }

    @Override // b7.i
    public byte[] h() {
        return this.f٥٤٧٩j;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = (this.f٥٤٧٠a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f٥٤٧١b;
        int i10 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int hashCode4 = (((hashCode3 ^ hashCode) * 1000003) ^ this.f٥٤٧٢c.hashCode()) * 1000003;
        long j10 = this.f٥٤٧٣d;
        int i11 = (hashCode4 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f٥٤٧٤e;
        int hashCode5 = (((i11 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.f٥٤٧٥f.hashCode()) * 1000003;
        Integer num2 = this.f٥٤٧٦g;
        if (num2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num2.hashCode();
        }
        int i12 = (hashCode5 ^ hashCode2) * 1000003;
        String str = this.f٥٤٧٧h;
        if (str != null) {
            i10 = str.hashCode();
        }
        return ((((i12 ^ i10) * 1000003) ^ Arrays.hashCode(this.f٥٤٧٨i)) * 1000003) ^ Arrays.hashCode(this.f٥٤٧٩j);
    }

    @Override // b7.i
    public Integer l() {
        return this.f٥٤٧٦g;
    }

    @Override // b7.i
    public String m() {
        return this.f٥٤٧٧h;
    }

    @Override // b7.i
    public String n() {
        return this.f٥٤٧٠a;
    }

    @Override // b7.i
    public long o() {
        return this.f٥٤٧٤e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f٥٤٧٠a + ", code=" + this.f٥٤٧١b + ", encodedPayload=" + this.f٥٤٧٢c + ", eventMillis=" + this.f٥٤٧٣d + ", uptimeMillis=" + this.f٥٤٧٤e + ", autoMetadata=" + this.f٥٤٧٥f + ", productId=" + this.f٥٤٧٦g + ", pseudonymousId=" + this.f٥٤٧٧h + ", experimentIdsClear=" + Arrays.toString(this.f٥٤٧٨i) + ", experimentIdsEncrypted=" + Arrays.toString(this.f٥٤٧٩j) + "}";
    }

    private b(String str, Integer num, h hVar, long j10, long j11, Map map, Integer num2, String str2, byte[] bArr, byte[] bArr2) {
        this.f٥٤٧٠a = str;
        this.f٥٤٧١b = num;
        this.f٥٤٧٢c = hVar;
        this.f٥٤٧٣d = j10;
        this.f٥٤٧٤e = j11;
        this.f٥٤٧٥f = map;
        this.f٥٤٧٦g = num2;
        this.f٥٤٧٧h = str2;
        this.f٥٤٧٨i = bArr;
        this.f٥٤٧٩j = bArr2;
    }
}
