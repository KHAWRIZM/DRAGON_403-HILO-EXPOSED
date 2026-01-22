package b7;

import b7.p;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class d extends p {

    /* renamed from: a, reason: collision with root package name */
    private final String f٥٥٠٠a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f٥٥٠١b;

    /* renamed from: c, reason: collision with root package name */
    private final z6.f f٥٥٠٢c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static final class b extends p.a {

        /* renamed from: a, reason: collision with root package name */
        private String f٥٥٠٣a;

        /* renamed from: b, reason: collision with root package name */
        private byte[] f٥٥٠٤b;

        /* renamed from: c, reason: collision with root package name */
        private z6.f f٥٥٠٥c;

        @Override // b7.p.a
        public p a() {
            String str = "";
            if (this.f٥٥٠٣a == null) {
                str = " backendName";
            }
            if (this.f٥٥٠٥c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new d(this.f٥٥٠٣a, this.f٥٥٠٤b, this.f٥٥٠٥c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // b7.p.a
        public p.a b(String str) {
            if (str != null) {
                this.f٥٥٠٣a = str;
                return this;
            }
            throw new NullPointerException("Null backendName");
        }

        @Override // b7.p.a
        public p.a c(byte[] bArr) {
            this.f٥٥٠٤b = bArr;
            return this;
        }

        @Override // b7.p.a
        public p.a d(z6.f fVar) {
            if (fVar != null) {
                this.f٥٥٠٥c = fVar;
                return this;
            }
            throw new NullPointerException("Null priority");
        }
    }

    @Override // b7.p
    public String b() {
        return this.f٥٥٠٠a;
    }

    @Override // b7.p
    public byte[] c() {
        return this.f٥٥٠١b;
    }

    @Override // b7.p
    public z6.f d() {
        return this.f٥٥٠٢c;
    }

    public boolean equals(Object obj) {
        byte[] c10;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f٥٥٠٠a.equals(pVar.b())) {
            byte[] bArr = this.f٥٥٠١b;
            if (pVar instanceof d) {
                c10 = ((d) pVar).f٥٥٠١b;
            } else {
                c10 = pVar.c();
            }
            if (Arrays.equals(bArr, c10) && this.f٥٥٠٢c.equals(pVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f٥٥٠٠a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f٥٥٠١b)) * 1000003) ^ this.f٥٥٠٢c.hashCode();
    }

    private d(String str, byte[] bArr, z6.f fVar) {
        this.f٥٥٠٠a = str;
        this.f٥٥٠١b = bArr;
        this.f٥٥٠٢c = fVar;
    }
}
