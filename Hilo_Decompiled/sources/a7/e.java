package a7;

import a7.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class e extends o {

    /* renamed from: a, reason: collision with root package name */
    private final o.b f٣٠٦a;

    /* renamed from: b, reason: collision with root package name */
    private final a7.a f٣٠٧b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static final class b extends o.a {

        /* renamed from: a, reason: collision with root package name */
        private o.b f٣٠٨a;

        /* renamed from: b, reason: collision with root package name */
        private a7.a f٣٠٩b;

        @Override // a7.o.a
        public o a() {
            return new e(this.f٣٠٨a, this.f٣٠٩b);
        }

        @Override // a7.o.a
        public o.a b(a7.a aVar) {
            this.f٣٠٩b = aVar;
            return this;
        }

        @Override // a7.o.a
        public o.a c(o.b bVar) {
            this.f٣٠٨a = bVar;
            return this;
        }
    }

    @Override // a7.o
    public a7.a b() {
        return this.f٣٠٧b;
    }

    @Override // a7.o
    public o.b c() {
        return this.f٣٠٦a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        o.b bVar = this.f٣٠٦a;
        if (bVar != null ? bVar.equals(oVar.c()) : oVar.c() == null) {
            a7.a aVar = this.f٣٠٧b;
            if (aVar == null) {
                if (oVar.b() == null) {
                    return true;
                }
            } else if (aVar.equals(oVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        o.b bVar = this.f٣٠٦a;
        int i10 = 0;
        if (bVar == null) {
            hashCode = 0;
        } else {
            hashCode = bVar.hashCode();
        }
        int i11 = (hashCode ^ 1000003) * 1000003;
        a7.a aVar = this.f٣٠٧b;
        if (aVar != null) {
            i10 = aVar.hashCode();
        }
        return i11 ^ i10;
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f٣٠٦a + ", androidClientInfo=" + this.f٣٠٧b + "}";
    }

    private e(o.b bVar, a7.a aVar) {
        this.f٣٠٦a = bVar;
        this.f٣٠٧b = aVar;
    }
}
