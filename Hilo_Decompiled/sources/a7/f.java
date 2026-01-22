package a7;

import a7.p;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class f extends p {

    /* renamed from: a, reason: collision with root package name */
    private final s f٣١٠a;

    /* renamed from: b, reason: collision with root package name */
    private final p.b f٣١١b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static final class b extends p.a {

        /* renamed from: a, reason: collision with root package name */
        private s f٣١٢a;

        /* renamed from: b, reason: collision with root package name */
        private p.b f٣١٣b;

        @Override // a7.p.a
        public p a() {
            return new f(this.f٣١٢a, this.f٣١٣b);
        }

        @Override // a7.p.a
        public p.a b(s sVar) {
            this.f٣١٢a = sVar;
            return this;
        }

        @Override // a7.p.a
        public p.a c(p.b bVar) {
            this.f٣١٣b = bVar;
            return this;
        }
    }

    @Override // a7.p
    public s b() {
        return this.f٣١٠a;
    }

    @Override // a7.p
    public p.b c() {
        return this.f٣١١b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        s sVar = this.f٣١٠a;
        if (sVar != null ? sVar.equals(pVar.b()) : pVar.b() == null) {
            p.b bVar = this.f٣١١b;
            if (bVar == null) {
                if (pVar.c() == null) {
                    return true;
                }
            } else if (bVar.equals(pVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        s sVar = this.f٣١٠a;
        int i10 = 0;
        if (sVar == null) {
            hashCode = 0;
        } else {
            hashCode = sVar.hashCode();
        }
        int i11 = (hashCode ^ 1000003) * 1000003;
        p.b bVar = this.f٣١١b;
        if (bVar != null) {
            i10 = bVar.hashCode();
        }
        return i11 ^ i10;
    }

    public String toString() {
        return "ComplianceData{privacyContext=" + this.f٣١٠a + ", productIdOrigin=" + this.f٣١١b + "}";
    }

    private f(s sVar, p.b bVar) {
        this.f٣١٠a = sVar;
        this.f٣١١b = bVar;
    }
}
