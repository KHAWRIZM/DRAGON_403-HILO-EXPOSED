package a7;

import a7.s;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class i extends s {

    /* renamed from: a, reason: collision with root package name */
    private final r f٣٢٠a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static final class b extends s.a {

        /* renamed from: a, reason: collision with root package name */
        private r f٣٢١a;

        @Override // a7.s.a
        public s a() {
            return new i(this.f٣٢١a);
        }

        @Override // a7.s.a
        public s.a b(r rVar) {
            this.f٣٢١a = rVar;
            return this;
        }
    }

    @Override // a7.s
    public r b() {
        return this.f٣٢٠a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        r rVar = this.f٣٢٠a;
        r b10 = ((s) obj).b();
        if (rVar == null) {
            if (b10 == null) {
                return true;
            }
            return false;
        }
        return rVar.equals(b10);
    }

    public int hashCode() {
        int hashCode;
        r rVar = this.f٣٢٠a;
        if (rVar == null) {
            hashCode = 0;
        } else {
            hashCode = rVar.hashCode();
        }
        return hashCode ^ 1000003;
    }

    public String toString() {
        return "ExternalPrivacyContext{prequest=" + this.f٣٢٠a + "}";
    }

    private i(r rVar) {
        this.f٣٢٠a = rVar;
    }
}
