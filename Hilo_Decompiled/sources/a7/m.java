package a7;

import a7.w;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class m extends w {

    /* renamed from: a, reason: collision with root package name */
    private final w.c f٣٥٥a;

    /* renamed from: b, reason: collision with root package name */
    private final w.b f٣٥٦b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static final class b extends w.a {

        /* renamed from: a, reason: collision with root package name */
        private w.c f٣٥٧a;

        /* renamed from: b, reason: collision with root package name */
        private w.b f٣٥٨b;

        @Override // a7.w.a
        public w a() {
            return new m(this.f٣٥٧a, this.f٣٥٨b);
        }

        @Override // a7.w.a
        public w.a b(w.b bVar) {
            this.f٣٥٨b = bVar;
            return this;
        }

        @Override // a7.w.a
        public w.a c(w.c cVar) {
            this.f٣٥٧a = cVar;
            return this;
        }
    }

    @Override // a7.w
    public w.b b() {
        return this.f٣٥٦b;
    }

    @Override // a7.w
    public w.c c() {
        return this.f٣٥٥a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        w.c cVar = this.f٣٥٥a;
        if (cVar != null ? cVar.equals(wVar.c()) : wVar.c() == null) {
            w.b bVar = this.f٣٥٦b;
            if (bVar == null) {
                if (wVar.b() == null) {
                    return true;
                }
            } else if (bVar.equals(wVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        w.c cVar = this.f٣٥٥a;
        int i10 = 0;
        if (cVar == null) {
            hashCode = 0;
        } else {
            hashCode = cVar.hashCode();
        }
        int i11 = (hashCode ^ 1000003) * 1000003;
        w.b bVar = this.f٣٥٦b;
        if (bVar != null) {
            i10 = bVar.hashCode();
        }
        return i11 ^ i10;
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f٣٥٥a + ", mobileSubtype=" + this.f٣٥٦b + "}";
    }

    private m(w.c cVar, w.b bVar) {
        this.f٣٥٥a = cVar;
        this.f٣٥٦b = bVar;
    }
}
