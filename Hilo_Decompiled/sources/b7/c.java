package b7;

import b7.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class c extends o {

    /* renamed from: a, reason: collision with root package name */
    private final p f٥٤٩٠a;

    /* renamed from: b, reason: collision with root package name */
    private final String f٥٤٩١b;

    /* renamed from: c, reason: collision with root package name */
    private final z6.d f٥٤٩٢c;

    /* renamed from: d, reason: collision with root package name */
    private final z6.h f٥٤٩٣d;

    /* renamed from: e, reason: collision with root package name */
    private final z6.c f٥٤٩٤e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static final class b extends o.a {

        /* renamed from: a, reason: collision with root package name */
        private p f٥٤٩٥a;

        /* renamed from: b, reason: collision with root package name */
        private String f٥٤٩٦b;

        /* renamed from: c, reason: collision with root package name */
        private z6.d f٥٤٩٧c;

        /* renamed from: d, reason: collision with root package name */
        private z6.h f٥٤٩٨d;

        /* renamed from: e, reason: collision with root package name */
        private z6.c f٥٤٩٩e;

        @Override // b7.o.a
        public o a() {
            String str = "";
            if (this.f٥٤٩٥a == null) {
                str = " transportContext";
            }
            if (this.f٥٤٩٦b == null) {
                str = str + " transportName";
            }
            if (this.f٥٤٩٧c == null) {
                str = str + " event";
            }
            if (this.f٥٤٩٨d == null) {
                str = str + " transformer";
            }
            if (this.f٥٤٩٩e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new c(this.f٥٤٩٥a, this.f٥٤٩٦b, this.f٥٤٩٧c, this.f٥٤٩٨d, this.f٥٤٩٩e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // b7.o.a
        o.a b(z6.c cVar) {
            if (cVar != null) {
                this.f٥٤٩٩e = cVar;
                return this;
            }
            throw new NullPointerException("Null encoding");
        }

        @Override // b7.o.a
        o.a c(z6.d dVar) {
            if (dVar != null) {
                this.f٥٤٩٧c = dVar;
                return this;
            }
            throw new NullPointerException("Null event");
        }

        @Override // b7.o.a
        o.a d(z6.h hVar) {
            if (hVar != null) {
                this.f٥٤٩٨d = hVar;
                return this;
            }
            throw new NullPointerException("Null transformer");
        }

        @Override // b7.o.a
        public o.a e(p pVar) {
            if (pVar != null) {
                this.f٥٤٩٥a = pVar;
                return this;
            }
            throw new NullPointerException("Null transportContext");
        }

        @Override // b7.o.a
        public o.a f(String str) {
            if (str != null) {
                this.f٥٤٩٦b = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }
    }

    @Override // b7.o
    public z6.c b() {
        return this.f٥٤٩٤e;
    }

    @Override // b7.o
    z6.d c() {
        return this.f٥٤٩٢c;
    }

    @Override // b7.o
    z6.h e() {
        return this.f٥٤٩٣d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f٥٤٩٠a.equals(oVar.f()) && this.f٥٤٩١b.equals(oVar.g()) && this.f٥٤٩٢c.equals(oVar.c()) && this.f٥٤٩٣d.equals(oVar.e()) && this.f٥٤٩٤e.equals(oVar.b())) {
            return true;
        }
        return false;
    }

    @Override // b7.o
    public p f() {
        return this.f٥٤٩٠a;
    }

    @Override // b7.o
    public String g() {
        return this.f٥٤٩١b;
    }

    public int hashCode() {
        return ((((((((this.f٥٤٩٠a.hashCode() ^ 1000003) * 1000003) ^ this.f٥٤٩١b.hashCode()) * 1000003) ^ this.f٥٤٩٢c.hashCode()) * 1000003) ^ this.f٥٤٩٣d.hashCode()) * 1000003) ^ this.f٥٤٩٤e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f٥٤٩٠a + ", transportName=" + this.f٥٤٩١b + ", event=" + this.f٥٤٩٢c + ", transformer=" + this.f٥٤٩٣d + ", encoding=" + this.f٥٤٩٤e + "}";
    }

    private c(p pVar, String str, z6.d dVar, z6.h hVar, z6.c cVar) {
        this.f٥٤٩٠a = pVar;
        this.f٥٤٩١b = str;
        this.f٥٤٩٢c = dVar;
        this.f٥٤٩٣d = hVar;
        this.f٥٤٩٤e = cVar;
    }
}
